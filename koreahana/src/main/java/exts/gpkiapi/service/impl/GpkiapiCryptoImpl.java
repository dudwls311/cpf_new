package exts.gpkiapi.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import egovframework.com.cmm.service.Globals;
import exts.gpkiapi.service.GpkiapiCrypto;
import exts.gpkiapi.util.GpkiUtil;
import exts.gpkiapi.vo.GpkiapiRequestVO;
import exts.koreahana.mbr.vo.KoreahanaMbrDpkdfrVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("gpkiapiCrypto")
public class GpkiapiCryptoImpl implements GpkiapiCrypto {

	private final Log log = LogFactory.getLog(getClass());
	
	/**
	 * gpkiapi 값 가져오기
	 * @param gpkiapiRequestVO
	 * @return
	 */
	public KoreahanaMbrDpkdfrVO getGpkiapiResult(GpkiapiRequestVO gpkiapiRequestVO) {
		
		JSONObject rootJson = new JSONObject();
		JSONArray dataJsonArr = new JSONArray();
		JSONObject dataJsonObj = new JSONObject();
		dataJsonObj.put("name", gpkiapiRequestVO.getName());
		dataJsonObj.put("id", gpkiapiRequestVO.getId());
		dataJsonArr.add(dataJsonObj);
		rootJson.put("data", dataJsonArr);
		
		String data = rootJson.toString();
		KoreahanaMbrDpkdfrVO dpkdfrVO = null;
		
		try {
			GpkiUtil gpki = new GpkiUtil();
			gpki.setCertFilePath(Globals.GPKIAPI_CERT_FILE_PATH);
			gpki.setEnvCertFilePathName(Globals.GPKIAPI_ENV_CERT_FILE_PATH_NAME);
			gpki.setEnvPrivateKeyFilePathName(Globals.GPKIAPI_ENV_PRIVATE_KEY_FILE_PATH_NAME);
			gpki.setEnvPrivateKeyPasswd(Globals.GPKIAPI_ENV_PRIVATE_KEY_PASSWD);
			gpki.setGpkiLicPath(Globals.GPKIAPI_LIC_PATH);
			gpki.setIsLDAP( ("true".equals(Globals.GPKIAPI_IS_LDAP) ? true : false) );
			gpki.setLdapAddress(Globals.GPKIAPI_LDAP_ADDRESS);
			gpki.setMyServerId(Globals.GPKIAPI_MY_SERVER_ID);
			gpki.setSigCertFilePathName(Globals.GPKIAPI_SIG_CERT_FILE_PATH_NAME);
			gpki.setSigPrivateKeyFilePathName(Globals.GPKIAPI_SIG_PRIVATE_KEY_FILE_PATH_NAME);
			gpki.setSigPrivateKeyPasswd(Globals.GPKIAPI_SIG_PRIVATE_KEY_PASSWD);
			gpki.setTargetServerId(Globals.GPKIAPI_TARGET_SERVER_ID);
			gpki.setTargetServerIdList(Globals.GPKIAPI_TARGET_SERVER_ID+",");
			gpki.setTestGPKI( ("true".equals(Globals.GPKIAPI_TEST_GPKI) ? true : false) );
			gpki.init();
			
			byte[] encrypted = gpki.encrypt(data.getBytes("UTF-8"), gpki.getTargetServerId());
            byte[] signed = gpki.sign(encrypted);
            String encoded = gpki.encode(signed);
            
			Map<String,String> requestHeader = new LinkedHashMap<String, String>();
			requestHeader.put("API_KEY",Globals.GPKIAPI_KEY);
			requestHeader.put("mock_yn",Globals.GPKIAPI_MOCK_YN);
			requestHeader.put("gpki_yn",Globals.GPKIAPI_GPKI_YN);
			requestHeader.put("cert_server_id",Globals.GPKIAPI_MY_SERVER_ID);
			requestHeader.put("Accept", "application/json");
			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("tx_id", getTx_Id());
			
			try {
				requestHeader.put("Host",InetAddress.getLocalHost().toString());
				requestHeader.put("User-Agent","java-net-httpclient");
			} catch (UnknownHostException e) {
				log.error(e.getMessage());
			}
			
			String body = encoded;
			String targetUrl = Globals.GPKIAPI_DOMAIN+Globals.GPKIAPI_URI;
			String method = "POST";
			String charset = "UTF-8";
			Response response = sendRequest(targetUrl,method ,requestHeader ,body ,charset);
			
			int responseCode = response.getResponseCode();
			String responseBody = response.getBody();
			
			Map<String, Object> responseHeader = response.getHeaderMap();
			
			byte[] decoded = gpki.decode(responseBody);// Base64 decode
	        byte[] validated = gpki.validate(decoded);//
	        String decrypted = new String(gpki.decrypt(validated), "UTF-8");
			
			if(responseCode == HttpURLConnection.HTTP_OK) { //응답 성공
				JSONObject r = JSONObject.fromObject(decrypted);
				JSONArray resultArrJson = r.getJSONArray("data");
				if(resultArrJson != null && resultArrJson.size() > 0) {
					JSONObject responseData = (JSONObject) resultArrJson.get(0);
					
					String DPKDFRYN = (String) responseData.get("DPKDFRYN");
					if(DPKDFRYN != null && "Y".equals(DPKDFRYN)) {
						
						String GNDR = (String) responseData.get("GNDR");
						String BRTHDY = (String) responseData.get("BRTHDY");
						String PRTCNNO = (String) responseData.get("PRTCNNO");
						String ENTRCDATE = (String) responseData.get("ENTRCDATE");
						String PRTCNDECSNDATE = (String) responseData.get("PRTCNDECSNDATE");
						String HANASORDNO = (String) responseData.get("HANASORDNO");
						String HANASCOMPTDATE = (String) responseData.get("HANASCOMPTDATE");
						
						if(GNDR == null) GNDR = "NONE";
						if(BRTHDY == null) BRTHDY = "NONE";
						if(PRTCNNO == null) PRTCNNO = "NONE";
						if(ENTRCDATE == null) ENTRCDATE = "NONE";
						if(PRTCNDECSNDATE == null) PRTCNDECSNDATE = "NONE";
						if(HANASORDNO == null) HANASORDNO = "NONE";
						if(HANASCOMPTDATE == null) HANASCOMPTDATE = "NONE";
						
						dpkdfrVO = new KoreahanaMbrDpkdfrVO();
						dpkdfrVO.setDpkdfrnm(DPKDFRYN);
						dpkdfrVO.setGndr(GNDR);
						dpkdfrVO.setBrthdy(BRTHDY);
						dpkdfrVO.setPrtcnno(PRTCNNO);
						dpkdfrVO.setEntrcdate(ENTRCDATE);
						dpkdfrVO.setPrtcndecsndate(PRTCNDECSNDATE);
						dpkdfrVO.setHanasordno(HANASORDNO);
						dpkdfrVO.setHanascomptdate(HANASCOMPTDATE);
					}
				}else {
					log.debug("restData Is Null : " + Globals.GPKIAPI_DOMAIN+Globals.GPKIAPI_URI);
				}
			}else {
				log.error("GPKIAPI ERROR");
			}
		}catch(RestClientException e) {
			log.error(e.getMessage());
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return dpkdfrVO;
	}
	
   /**
	 * tx_id 생성
	 * @return tx_id
	 */
	private String getTx_Id() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.KOREA);
		String cur = sdf.format(new Date());
		String transactionUniqueId = cur + keyGen(8);
		return transactionUniqueId;
	}

	private Random r = new Random(System.currentTimeMillis());
	private String keyGen(int length) {
		char[] key = new char[length];
		int tmp = 0;
		for (int i = 0; i < length; i++) {
			tmp = r.nextInt(3);
			if (tmp == 0)
				key[i] = (char) (r.nextInt(26) + 65);
			else if (tmp == 1)
				key[i] = (char) (r.nextInt(10) + 48);
			else if (tmp == 2)
				key[i] = (char) (r.nextInt(26) + 97);
			else {
				key[i] = (char) r.nextInt(256);
			}
		}
		return String.valueOf(key);
	}
	
	private class Response {
		int responseCode;
		String body;
		Map<String, Object> headerMap = new LinkedHashMap<String, Object>();
		
		public int getResponseCode() {
			return responseCode;
		}
		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public Map<String, Object> getHeaderMap() {
			return headerMap;
		}
		public void setHeaderMap(Map<String, Object> headerMap) {
			this.headerMap = headerMap;
		}
		
	}
	
	// HTTP 호출
		private Response sendRequest(String targetUrl , String method , Map<String,String> requestHeader , String body , String charset) {
			Response res = new Response();
			HttpURLConnection con = null;
			try {
				URL url = new URL(targetUrl);
				con = (HttpURLConnection) url.openConnection();
			} 
			catch (MalformedURLException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				con.setRequestMethod(method);
				for(Map.Entry<String,String> entry : requestHeader.entrySet()) {
					con.setRequestProperty(entry.getKey(),entry.getValue());
					
				}
				con.setDefaultUseCaches(false);
				con.setAllowUserInteraction(false);
				con.setReadTimeout(30000);
				con.setDoInput(true);
				con.setDoOutput(true);
				
				con.connect();
				
				OutputStream os = null;
				OutputStreamWriter osw = null;
				StringBuffer responseBodyBuffer = new StringBuffer("");
				Map<String, Object> headerMap = res.getHeaderMap();
				
				try {
					os = con.getOutputStream();
					osw = new OutputStreamWriter(os,Charset.forName(charset));
					osw.write(body);
					osw.flush();
					
					int code = con.getResponseCode();
					res.setResponseCode(code);
					
					InputStream is = null;
					InputStreamReader isr = null;
					if(code == HttpURLConnection.HTTP_OK) {
						is = con.getInputStream();
					}
					else {
						is = con.getErrorStream();
					}
					
					Map<String, List<String>> headerFields = con.getHeaderFields();
					
					for(Map.Entry<String,List<String>> headerEntry : headerFields.entrySet()) {
						String key = headerEntry.getKey();
						List<String> values = headerEntry.getValue();
						if(values.size()<=1) {
							headerMap.put(key,values.get(0));
						}
						else {
							headerMap.put(key, values);
						}
					}
					
					try {
						isr = new InputStreamReader(is,Charset.forName(charset));
						int len = -1;
						char[] ch = new char[32];
						while((len=isr.read(ch,0,ch.length))!=-1) {
							responseBodyBuffer.append(new String(ch,0,len));
						}
						//log.debug("==========="+responseBodyBuffer.toString());
						res.setBody(responseBodyBuffer.toString());
					}
					catch(IOException e) {
						e.printStackTrace();
					}
					finally {
						isr.close();
						is.close();
						os.close();
						osw.close();
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
			} 
			catch (ProtocolException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				if(con!=null) con.disconnect();
			}
			
			return res;
		}
}
