package exts.koreahana.smb.vo;

import java.util.List;

import exts.com.vo.ComAtchFileVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaSmbVO.java
 * @Description : 제출서류 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSmbVO extends KoreahanaSmbTypVO {

	private String smbsnDocSn;		//제출서류일련번호
	private String smbsnSortSn;		//제출서류정렬일련번호     
	private String smbsnDocNm;		//제출서류명
	private String smbsnRsn;		//제출서류설명
	private String smbsnDocMtlYn;		//제출서류멀티여부
	private String smbsnDocFormSn;		//제출서류양식일련번호
	private String smbsnDocRqrYn;		//제출서류필수여부
	private String docBoxYn;		//서류함여부

	private String smbDocId;		//파라미터로 넘어온 Id
	private List<String> smbsnDocList = null;		//제출서류일련번호배열
	private ComAtchFileVO fileVO;
	
	private String ksMode;
}
