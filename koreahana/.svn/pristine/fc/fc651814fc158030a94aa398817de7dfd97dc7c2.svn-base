import com.fasoo.fcwpkg.packager.*;
import java.util.*;

class unpackagingSample {
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

		boolean bret = false;
		boolean nret = false;
		boolean iret = false; 
		int retVal = 0;
		
		//DRM Config Information
		String strFsdinitPath = "./fsdinit";							//키 파일이 포함된 디렉토리 위치(해당 디렉토리 위치에 맞게 수정)
		String strCPID = "0100000000001615";							//남북 하나재단 고유 코드
		String strEncFilePath = "./content/encfile/test.txt";			//복호화 대상 파일(경로 포함)
		String strFileName = "test.txt";								//복호화 대상 파일 명
		String strDecFilePath = "./content/decfile/test.txt";			//복호화 후 생성할 파일(경로 포함)
		
		WorkPackager objWorkPackager = new WorkPackager();				//Fasoo 암/복호화 오브젝트 호출
		//objWorkPackager.setCharset("eucKR");
		
		objWorkPackager.setOverWriteFlag(false);						//복호화 된문서가 암호화된 문서를 덮어쓰지 않음
		retVal = objWorkPackager.GetFileType(strEncFilePath);			//복호화 대상 문서 FileType 확인

		System.out.println("파일형태는 " + FileTypeStr(retVal) + "["+retVal+"]"+" 입니다.");	// 복호화 대상 문서의 파일 타입 출력

		//대상 문서가 Fasoo FSN로 암호화 되었을 때만 복호화 실행
		if (retVal == 103) {
		
				// 암호화 된 파일 복호화
				bret = objWorkPackager.DoExtract(
										strFsdinitPath,					//fsdinit 폴더 FullPath 설정
										strCPID,						//고객사 Key(default) 
										strEncFilePath,					//복호화 대상 문서 FullPath + FileName
										strDecFilePath					//복호화 된 문서 FullPath + FileName
										);
				
				System.out.println("복호화 결과값 : " + iret);
				System.out.println("복호화 문서 : " + objWorkPackager.getContainerFilePathName());
				System.out.println("오류코드 : " + objWorkPackager.getLastErrorNum());
				System.out.println("오류값 : " + objWorkPackager.getLastErrorStr());
		
		}
		else {
			System.out.println("FSN 파일이 아닌경우 복호화 불가능 합니다.["+ retVal + "]");
		}
    }
}