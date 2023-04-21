import com.fasoo.fcwpkg.packager.*;
import java.util.*;

class packagingSample {
	public  static String FileTypeStr(int i) 
	{
		String ret = null;
		switch(i)
		{
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

    public static void main(String[] args) {

		boolean iret = false; 
		int retVal = 0;
		
		//DRM Config Information
		String strFsdinitPath = "./fsdinit";								//키 파일이 포함된 디렉토리 위치(해당 디렉토리 위치에 맞게 수정)
		String strCPID = "0100000000001615";								//남북 하나재단 고유 코드
		String strOrgFilePath = "./content/orgfile/test.txt";				//암호화 대상 파일(경로 포함)
		String strFileName = "test.txt";									//암호화 대상 파일 명
		String strEncFilePath = "./content/encfile/test.txt";				//암호화 후 생성할 파일(경로 포함)
  
		WorkPackager objWorkPackager = new WorkPackager();					//Fasoo 암/복호화 오브젝트 호출
		//objWorkPackager.setCharset("eucKR");

		objWorkPackager.setOverWriteFlag(false);							//암호화 된문서가 문서를 덮어쓰지 않음
		retVal = objWorkPackager.GetFileType(strOrgFilePath);				//암호화 대상 문서 FileType 확인

		System.out.println("파일형태는 " + FileTypeStr(retVal) + "["+retVal+"]"+" 입니다.");		// 암호화 대상 문서의 파일 타입 출력

		//일반 파일(29번)의 경우 암호화 진행
		if (retVal == 29) {

			//파일 확장자 체크( IsSupportFile() ) 로직
			iret = objWorkPackager.IsSupportFile(strFsdinitPath,
							strCPID,
							strOrgFilePath);
			System.out.println("지원 확장자 체크  : "+ iret );
			
			//지원 확장자의 경우 암호화 진행
			if (iret == true) {
			//파일 암호화
				iret = objWorkPackager.DoPackagingFsn2( 
												  strFsdinitPath,					//fsdinit 폴더 FullPath 설정
												  strCPID,							//고객사 Key(default) 
												  strOrgFilePath,					//암호화 대상 문서 FullPath + FileName
												  strEncFilePath,					//암호화 된 문서 FullPath + FileName
												  strFileName,						//파일 명
												  "admin",							//작성자 ID
												  "관리자",							//작성자 명
												  "test", "아무개", "001","팀_1",				//시스템 ID
												  "test", "아무개", "001","팀_1",				//ACL ID (권한 확인을 위한 ID로 SystemID와 동일 적용)
												  "2d48ea8502304e30886932ec4894b8f7"		//고객사 문서 코드 (문서 코드 확인 방법은 가이드 문서에 기술)
												  );
				
				System.out.println("암호화 결과값 : " + iret);
				System.out.println("암호화 문서 : " + objWorkPackager.getContainerFilePathName());
				System.out.println("오류코드 : " + objWorkPackager.getLastErrorNum());
				System.out.println("오류값 : " + objWorkPackager.getLastErrorStr());
			}
			else {
				System.out.println("지원 확장자가 아닌경우 암호화 불가능 합니다.["+ retVal +"]");
			}
		}
		else {
			System.out.println("일반 파일이 아닌경우 암호화 불가능 합니다.["+ retVal + "]");
		}
    }
}
