package exts.koreahana.drm.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasoo.fcwpkg.packager.WorkPackager;

import egovframework.com.cmm.service.Globals;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.drm.service.KoreahanaDrmService;
import exts.koreahana.drm.util.FileToMultipartFileConverter;

@Service("koreahanaDrmService")
public class KoreahanaDrmServiceImpl implements KoreahanaDrmService {

	private Log log = LogFactory.getLog(getClass());
	
	/**
	 * fasoo drm enc
	 * @param storePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public File enc(String storePath, String fileName) throws EgovBizException {
		String oUserID = "online";
		String oUserName = "온라인신청";
		String WriterID = "online";
		String WriterNm = "온라인신청";
		String WdeptID = "001";
		String WdeptNm = "팀_1";
		String OwnerID = "online";
		String OwnerNm = "온라인신청";
		String OdeptID = "001";
		String OdeptNm = "팀_1";
		return enc(storePath, fileName, oUserID, oUserName, WriterID, WriterNm, WdeptID, WdeptNm, OwnerID, OwnerNm, OdeptID, OdeptNm);
	}
	
	/**
	 * fasoo drm dec
	 * @param storePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public File dec(String storePath, String fileName) throws EgovBizException {
		File retDecFile = null;
		boolean bret = false;
		int retVal = 0;
		
		//DRM Config Information
		String strFsdinitPath = Globals.FASOO_FSDINIT_PATH;							//키 파일이 포함된 디렉토리 위치(해당 디렉토리 위치에 맞게 수정)
		String strCPID = Globals.FASOO_CPID;							//남북 하나재단 고유 코드
		String strEncFilePath = new StringBuffer().append(storePath).append(File.separator).append(fileName).toString();			//복호화 대상 파일(경로 포함)
		String strDecFilePath = new StringBuffer().append(storePath).append(File.separator).append("FASOO_DEC_").append(fileName).toString();			//복호화 후 생성할 파일(경로 포함)

		WorkPackager objWorkPackager = new WorkPackager();				//Fasoo 암/복호화 오브젝트 호출
		//objWorkPackager.setCharset("eucKR");
		
		objWorkPackager.setOverWriteFlag(false);						//복호화 된문서가 암호화된 문서를 덮어쓰지 않음
		retVal = objWorkPackager.GetFileType(strEncFilePath);			//복호화 대상 문서 FileType 확인
		
		//대상 문서가 Fasoo FSN로 암호화 되었을 때만 복호화 실행
		if (retVal == 103) {
		
				// 암호화 된 파일 복호화
				bret = objWorkPackager.DoExtract(
										strFsdinitPath,					//fsdinit 폴더 FullPath 설정
										strCPID,						//고객사 Key(default) 
										strEncFilePath,					//복호화 대상 문서 FullPath + FileName
										strDecFilePath					//복호화 된 문서 FullPath + FileName
										);
				
				if(objWorkPackager.getLastErrorNum() == 0) {
					retDecFile = new File(strDecFilePath);
				} else {
					log.error("파일형태는 " + FileTypeStr(retVal) + "["+retVal+"]"+" 입니다.");	// 복호화 대상 문서의 파일 타입 출력
					log.error("복호화 결과값 : " + bret);
					log.error("복호화 문서 : " + objWorkPackager.getContainerFilePathName());
					log.error("오류코드 : " + objWorkPackager.getLastErrorNum());
					log.error("오류값 : " + objWorkPackager.getLastErrorStr());
				}
		} else {
			retDecFile = new File(strEncFilePath);
			log.error("FSN 파일이 아닌경우 복호화 불가능 합니다.["+ retVal + "]");
			log.debug("파일형태는 " + FileTypeStr(retVal) + "["+retVal+"]"+" 입니다.");	// 복호화 대상 문서의 파일 타입 출력
			log.debug("복호화 결과값 : " + bret);
			log.debug("복호화 문서 : " + objWorkPackager.getContainerFilePathName());
			log.debug("오류코드 : " + objWorkPackager.getLastErrorNum());
			log.debug("오류값 : " + objWorkPackager.getLastErrorStr());
		}
		return retDecFile;
	}
	
	/**
	 * DRM 파일을 해제하여 multipartfile로 반환
	 * @param originFile
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	public MultipartFile getDrmDecFile(MultipartFile originFile) throws EgovBizException, IOException {
		File file = new File(originFile.getOriginalFilename());
		return FileToMultipartFileConverter.convert(dec(file.getPath(), file.getName()));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * fasoo 응답코드
	 * @param i
	 * @return
	 */
	private String FileTypeStr(int i) {
		String ret = null;
		switch(i) {
	    	case 20 : ret = "파일을 찾을 수 없습니다."; break;
	    	case 21 : ret = "파일 사이즈가 0 입니다.";  break;
	    	case 22 : ret = "파일을 읽을 수 없습니다."; break;
	    	case 29 : ret = "암호화 파일이 아닙니다.";  break;
	    	case 26 : ret = "FSD 파일입니다.";       	break;
	    	case 105: ret = "Wrapsody 파일입니다.";  	break;
	    	case 106: ret = "NX 파일입니다.";			break;	    	
	    	case 101: ret = "MarkAny 파일입니다.";   	break;
	    	case 104: ret = "INCAPS 파일입니다.";    	break;
	    	case 103: ret = "FSN 파일입니다.";       	break;
		}
		return ret;		
	}
	
	/**
	 * fasoo drm enc
	 * @param storePath
	 * @param fileName
	 * @param oUserID
	 * @param oUserName
	 * @param WriterID
	 * @param WriterNm
	 * @param WdeptID
	 * @param WdeptNm
	 * @param OwnerID
	 * @param OwnerNm
	 * @param OdeptID
	 * @param OdeptNm
	 * @return
	 * @throws Exception
	 */
	private File enc(String storePath, String fileName, String oUserID, String oUserName, String WriterID, String WriterNm, String WdeptID, String WdeptNm, String OwnerID, String OwnerNm, String OdeptID, String OdeptNm) throws EgovBizException {
		File retEncFile = null;
		boolean iret = false;
		int retVal = 0;
		
		//DRM Config Information
		String strFsdinitPath = Globals.FASOO_FSDINIT_PATH;																				//키 파일이 포함된 디렉토리 위치(해당 디렉토리 위치에 맞게 수정)
		String strCPID = Globals.FASOO_CPID;																							//남북 하나재단 고유 코드
		String strOrgFilePath = new StringBuffer().append(storePath).append(File.separator).append(fileName).toString();				//암호화 대상 파일(경로 포함)
		String strFileName = fileName;																									//암호화 대상 파일 명
		String strEncFilePath = new StringBuffer().append(storePath).append(File.separator).append("FASOO_ENC_").append(fileName).toString();	//암호화 후 생성할 파일(경로 포함)
  
		WorkPackager objWorkPackager = new WorkPackager();					//Fasoo 암/복호화 오브젝트 호출
		//objWorkPackager.setCharset("eucKR");

		objWorkPackager.setOverWriteFlag(false);							//암호화 된문서가 문서를 덮어쓰지 않음
		retVal = objWorkPackager.GetFileType(strOrgFilePath);				//암호화 대상 문서 FileType 확인

		//일반 파일(29번)의 경우 암호화 진행
		if (retVal == 29) {

			//파일 확장자 체크( IsSupportFile() ) 로직
			iret = objWorkPackager.IsSupportFile(strFsdinitPath,
							strCPID,
							strOrgFilePath);
			
			//지원 확장자의 경우 암호화 진행
			if (iret == true) {
				//파일 암호화
				iret = objWorkPackager.DoPackagingFsn2( 
						strFsdinitPath,							//fsdinit 폴더 FullPath 설정
						strCPID,								//고객사 Key(default) 
						strOrgFilePath,							//암호화 대상 문서 FullPath + FileName
						strEncFilePath,							//암호화 된 문서 FullPath + FileName
						strFileName,							//파일 명
						oUserID,								//작성자 ID
						oUserName,								//작성자 명
						WriterID, WriterNm, WdeptID, WdeptNm,	//시스템 ID
						OwnerID, OwnerNm, OdeptID,OdeptNm,		//ACL ID (권한 확인을 위한 ID로 SystemID와 동일 적용)
						Globals.FASOO_CLIENT_CODE				//고객사 문서 코드 (문서 코드 확인 방법은 가이드 문서에 기술)
				);
				
				if(objWorkPackager.getLastErrorNum() == 0) {
					retEncFile = new File(strEncFilePath);
				} else {
					log.error("지원 확장자 체크  : "+ iret );
					log.error("파일형태는 " + FileTypeStr(retVal) + "["+retVal+"]"+" 입니다.");		// 암호화 대상 문서의 파일 타입 출력
					log.error("암호화 결과값 : " + iret);
					log.error("암호화 문서 : " + objWorkPackager.getContainerFilePathName());
					log.error("오류코드 : " + objWorkPackager.getLastErrorNum());
					log.error("오류값 : " + objWorkPackager.getLastErrorStr());
				}
			} else {
				retEncFile = new File(strOrgFilePath);
				log.error("지원 확장자가 아닌경우 암호화 불가능 합니다.["+ retVal +"]");
			}
		} else {
			retEncFile = new File(strOrgFilePath);
			log.error("일반 파일이 아닌경우 암호화 불가능 합니다.["+ retVal + "]");
		}
		return retEncFile;
	}
}
