package exts.koreahana.smb.vo;

import java.util.List;

import exts.com.vo.ComAtchFileVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaAdtSmbMpnVO.java
 * @Description : 원제출서류매핑 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSmbMpnVO extends ComAtchFileVO {

	private String smbDocMpngSn;		//제출서류매핑일련번호
	private String sprtSn;				//상위일련번호
	private String smbsnDocSn;		//제출서류일련번호
//	private String atchFileSn;		//첨부파일일련번호
	
	private String pbancrcSn;		//모집공고일련번호
	
	private List<String> docSnList;
	private List<String> smbDocMpngSnList;
}
