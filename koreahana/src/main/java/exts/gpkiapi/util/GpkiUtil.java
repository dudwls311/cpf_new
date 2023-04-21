package exts.gpkiapi.util;

/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gpki.gpkiapi_jni;
import com.gpki.gpkiapi.GpkiApi;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.cms.EnvelopedData;
import com.gpki.gpkiapi.cms.SignedData;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.exception.GpkiApiException;
import com.gpki.gpkiapi.storage.Disk;


public class GpkiUtil {
	
	private final Log logger = LogFactory.getLog(GpkiUtil.class);
	public GpkiUtil() {
		targetServerCertMap = new HashMap();
		gpkiLicPath = ".";
		testGPKI = false;
		//ldapAddress = "ldap.gcc.go.kr:389";
		ldapAddress = "10.1.7.118:389";
		prop = new Properties();
	}

	public void init(String passwd) throws GpkiApiException {
		envPrivateKeyPasswd = passwd;
		sigPrivateKeyPasswd = passwd;
		init();
	}

	public void init() throws GpkiApiException {
		GpkiApi.init(gpkiLicPath);
		gpkiapi_jni gpki = getGPKI();
		LoadCert(gpki);
		X509Certificate _myEnvCert = Disk.readCert(getEnvCertFilePathName());
		myEnvCert = _myEnvCert.getCert();
		PrivateKey _myEnvKey = Disk.readPriKey(getEnvPrivateKeyFilePathName(),
				getEnvPrivateKeyPasswd());
		myEnvKey = _myEnvKey.getKey();
		X509Certificate _mySigCert = Disk.readCert(getSigCertFilePathName());
		mySigCert = _mySigCert.getCert();
		PrivateKey _mySigKey = Disk.readPriKey(getSigPrivateKeyFilePathName(),
				getSigPrivateKeyPasswd());
		mySigKey = _mySigKey.getKey();

		load(gpki, getMyServerId());

		if (testGPKI) {
			testGpki(gpki);
		}
		finish(gpki);
	}

	private static String[] split(String str, String param) {
		String tempStr = str;
		int index = 0;

		while (tempStr.indexOf(param) >= 0) {
			String token = tempStr.substring(0, tempStr.indexOf(param));
			tempStr = tempStr.substring(tempStr.indexOf(param) + 1,
					tempStr.length());
			index++;
		}

		String[] returnStr = new String[index];
		index = 0;
		while (str.indexOf(param) >= 0) {
			String token = str.substring(0, str.indexOf(param));
			returnStr[index++] = token;
			str = str.substring(str.indexOf(param) + 1, str.length());
		}

		return returnStr;
	}
	
	private void LoadCert(gpkiapi_jni gpki) throws GpkiApiException {
		if (targetServerIdList != null) {
			String certIdList[] = split(targetServerIdList, ",");
			for (int i = 0; i < certIdList.length; i++) {
				String certId = certIdList[i].trim();
				if (!certId.equals(""))
					load(gpki, certId);
			}

		}
		if (!prop.isEmpty()) {
			Set keys = prop.keySet();
			Iterator itr = keys.iterator();
			do {
				if (!itr.hasNext())
					break;
				String key = (String) itr.next();
				if (key.endsWith("targetServerIdList")) {
					String certList = prop.getProperty(key);
					String certId[] = split(certList, ",");
					int i = 0;
					while (i < certId.length) {
						String cert = certId[i].trim();
						if (!cert.equals(""))
							load(gpki, cert);
						i++;
					}
				}
			} while (true);
		}
	}

	private void load(gpkiapi_jni gpki, String certId) throws GpkiApiException {
		X509Certificate cert = (X509Certificate) targetServerCertMap
				.get(certId);
		if (cert != null)
			return;
		if (isLDAP) {
			String ldapUrl = "ldap://" + ldapAddress + "/cn=";
			String ldapUri;
			if (certId.charAt(3) > '9')
				ldapUri = ",ou=Group of Server,o=Public of Korea,c=KR";
			else
				ldapUri = ",ou=Group of Server,o=Government of Korea,c=KR";
			int ret = gpki.LDAP_GetAnyDataByURL("userCertificate;binary",
					ldapUrl + certId + ldapUri);
			checkResult(ret, gpki);
			cert = new X509Certificate(gpki.baReturnArray);
		} else if (certFilePath != null)
			cert = Disk.readCert(certFilePath + File.separator + certId
					+ ".cer");
		else
			logger.error("not certFilePath");
		targetServerCertMap.put(certId, cert);
	}

	private gpkiapi_jni getGPKI() {
		gpkiapi_jni gpki = new gpkiapi_jni();
		if (gpki.API_Init(gpkiLicPath) != 0)
			logger.error(gpki.sDetailErrorString);
		return gpki;
	}

	private void finish(gpkiapi_jni gpki) {
		if (gpki.API_Finish() != 0)
			logger.error(gpki.sDetailErrorString);
	}

	public byte[] encrypt(byte plain[], String certId, boolean certload)
			throws GpkiApiException {
		X509Certificate targetEnvCert;
		gpkiapi_jni gpki;
		targetEnvCert = (X509Certificate) targetServerCertMap.get(certId);
		gpki = getGPKI();
		if (targetEnvCert == null) {
			if (!certload)
				throw new GpkiApiException(
						"Certificate not found : targetServerId=" + certId);
			load(gpki, certId);
			targetEnvCert = (X509Certificate) targetServerCertMap.get(certId);
		}
		byte abyte0[];
		try {
			int result = gpki.CMS_MakeEnvelopedData(targetEnvCert.getCert(),
					plain, gpkiapi_jni.SYM_ALG_NEAT_CBC);
			checkResult(result, "Fail to encrypt message", gpki);
			abyte0 = gpki.baReturnArray;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return abyte0;
	}

	public byte[] encrypt(byte plain[], String certId) throws GpkiApiException {
		return encrypt(plain, certId, false);
	}

	public byte[] decrypt(byte encrypted[]) throws GpkiApiException {
		gpkiapi_jni gpki = getGPKI();
		byte abyte0[];
		try {
			int result = gpki.CMS_ProcessEnvelopedData(myEnvCert, myEnvKey,
					encrypted);
			checkResult(result, "Fail to decrpyt message", gpki);
			abyte0 = gpki.baReturnArray;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return abyte0;
	}

	public byte[] sign(byte plain[]) throws GpkiApiException {
		gpkiapi_jni gpki = getGPKI();
		byte abyte0[];
		try {
			int result = gpki.CMS_MakeSignedData(mySigCert, mySigKey, plain,
					null);
			checkResult(result, "Fail to sign message", gpki);
			abyte0 = gpki.baReturnArray;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return abyte0;
	}

	public byte[] validate(byte signed[]) throws GpkiApiException {
		gpkiapi_jni gpki = getGPKI();
		byte abyte0[];
		try {
			int result = gpki.CMS_ProcessSignedData(signed);
			checkResult(result, "Fail to validate signed message", gpki);
			abyte0 = gpki.baData;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return abyte0;
	}

	public String encode(byte plain[]) throws GpkiApiException {
		gpkiapi_jni gpki = getGPKI();
		String s;
		try {
			int result = gpki.BASE64_Encode(plain);
			checkResult(result, "Fail to encode message", gpki);
			s = gpki.sReturnString;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return s;
	}

	public byte[] decode(String base64) throws GpkiApiException {
		gpkiapi_jni gpki = getGPKI();
		byte abyte0[];
		try {
			int result = gpki.BASE64_Decode(base64);
			checkResult(result, "Fail to decode base64 message", gpki);
			abyte0 = gpki.baReturnArray;
		} catch (GpkiApiException ex) {
			throw ex;
		}
		finish(gpki);
		return abyte0;
	}

	private void checkResult(int result, String message)
			throws GpkiApiException {
		checkResult(result, message, null);
	}

	private void checkResult(int result, gpkiapi_jni gpki)
			throws GpkiApiException {
		checkResult(result, null, gpki);
	}

	private void checkResult(int result, String message, gpkiapi_jni gpki)
			throws GpkiApiException {
		if (0 != result) {
			if (null != gpki)
				throw new GpkiApiException(message + " : gpkiErrorMessage="
						+ gpki.sDetailErrorString);
			else
				throw new GpkiApiException(message + " : gpkiErrorCode="
						+ result);
		} else {
			return;
		}
	}

	public void testGpki(gpkiapi_jni gpki) throws GpkiApiException {

		// gpki test eng
		String original_Eng = "abc";
		try {
			byte[] encrypted = encrypt(original_Eng.getBytes(), getMyServerId());
			String decrypted = new String(decrypt(encrypted));

			if (!original_Eng.equals(decrypted)) {
				throw new GpkiApiException(
						"GpkiUtil not initialized properly(english)");
			}
		} catch (GpkiApiException e) {
			throw e;
		}

		// gpki test kor
		String original = "가나다";
		try {
			byte[] encrypted = encrypt(original.getBytes(), getMyServerId());
			String decrypted = new String(decrypt(encrypted));
			if (!original.equals(decrypted)) {
				throw new GpkiApiException(
						"GpkiUtil not initialized properly(korean)");
			}
		} catch (GpkiApiException e) {
			throw e;
		}
	}

	public String getMyServerId() {
		return myServerId;
	}

	public void setMyServerId(String myServerId) {
		this.myServerId = myServerId.trim();
	}

	public String getEnvCertFilePathName() {
		return envCertFilePathName;
	}

	public void setEnvCertFilePathName(String envCertFilePathName) {
		this.envCertFilePathName = envCertFilePathName.trim();
	}

	public String getEnvPrivateKeyFilePathName() {
		return envPrivateKeyFilePathName;
	}

	public void setEnvPrivateKeyFilePathName(String envPrivateKeyFilePathName) {
		this.envPrivateKeyFilePathName = envPrivateKeyFilePathName.trim();
	}

	public String getEnvPrivateKeyPasswd() {
		return envPrivateKeyPasswd;
	}

	public void setEnvPrivateKeyPasswd(String envPrivateKeyPasswd) {
		this.envPrivateKeyPasswd = envPrivateKeyPasswd.trim();
	}

	public String getSigPrivateKeyPasswd() {
		return sigPrivateKeyPasswd;
	}

	public void setSigPrivateKeyPasswd(String sigPrivateKeyPasswd) {
		this.sigPrivateKeyPasswd = sigPrivateKeyPasswd.trim();
	}

	public String getSigCertFilePathName() {
		return sigCertFilePathName;
	}

	public void setSigCertFilePathName(String sigCertFilePathName) {
		this.sigCertFilePathName = sigCertFilePathName.trim();
	}

	public String getSigPrivateKeyFilePathName() {
		return sigPrivateKeyFilePathName;
	}

	public void setSigPrivateKeyFilePathName(String sigPrivateKeyFilePathName) {
		this.sigPrivateKeyFilePathName = sigPrivateKeyFilePathName.trim();
	}

	public boolean getIsLDAP() {
		return isLDAP;
	}

	public void setIsLDAP(boolean isLDAP) {
		this.isLDAP = isLDAP;
	}

	public String getCertFilePath() {
		return certFilePath;
	}

	public void setCertFilePath(String certFilePath) {
		this.certFilePath = certFilePath.trim();
	}

	public String getTargetServerIdList() {
		return targetServerIdList;
	}

	public void setTargetServerIdList(String targetServerIdList) {
		this.targetServerIdList = targetServerIdList;
	}

	public String getGpkiLicPath() {
		return gpkiLicPath;
	}

	public void setGpkiLicPath(String gpkiLicPath) {
		this.gpkiLicPath = gpkiLicPath;
	}

	public boolean getTestGPKI() {
		return testGPKI;
	}

	public void setTestGPKI(boolean testGPKI) {
		this.testGPKI = testGPKI;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getLdapAddress() {
		return ldapAddress;
	}

	public void setLdapAddress(String ldapAddress) {
		this.ldapAddress = ldapAddress;
	}

	public void encryptFile(String sourceFilePath, String targetFilePath,
			String targetServerId) throws GpkiApiException {
		X509Certificate targetEnvCert = (X509Certificate) targetServerCertMap
				.get(targetServerId);
		if (targetEnvCert == null) {
			throw new GpkiApiException(
					"Certificate not found : targetServerId=" + targetServerId);
		} else {
			EnvelopedData data = new EnvelopedData("NEAT");
			data.addRecipient(targetEnvCert);
			data.generate_File(sourceFilePath, targetFilePath);
			return;
		}
	}

	public void signFile(String sourceFilePath, String targetFilePath)
			throws GpkiApiException {
		SignedData sdata = new SignedData();
		sdata.setMessage_File(sourceFilePath);
		sdata.generate_File(new X509Certificate(mySigCert), new PrivateKey(
				mySigKey), targetFilePath);
	}

	public void decryptFile(String sourceFilePath, String targetFilePath)
			throws GpkiApiException {
		EnvelopedData data = new EnvelopedData("NEAT");
		data.process_File(sourceFilePath, new X509Certificate(myEnvCert),
				new PrivateKey(myEnvKey), targetFilePath);
	}

	public void validateFile(String sourceFilePath, String targetFilePath)
			throws GpkiApiException {
		SignedData sdata = new SignedData();
		sdata.verify_File(sourceFilePath, targetFilePath);
	}

	public String getTargetServerId() {
		return targetServerId;
	}

	public void setTargetServerId(String targetServerId) {
		this.targetServerId = targetServerId;
	}

	byte myEnvCert[];
	byte myEnvKey[];
	byte mySigCert[];
	byte mySigKey[];
	private Map targetServerCertMap;
	private String myServerId;
	private String targetServerId;
	private String targetServerIdList;
	private String envCertFilePathName;
	private String envPrivateKeyFilePathName;
	private String envPrivateKeyPasswd;
	private String sigCertFilePathName;
	private String sigPrivateKeyFilePathName;
	private String sigPrivateKeyPasswd;
	private String certFilePath;
	private String gpkiLicPath;
	private boolean isLDAP;
	private boolean testGPKI;
	private String ldapAddress;
	private final String TARGET_CERT_LIST = "targetServerIdList";
	private Properties prop;
}
