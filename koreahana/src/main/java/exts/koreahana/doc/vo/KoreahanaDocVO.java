package exts.koreahana.doc.vo;

import exts.com.vo.ComAtchFileVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaDocVO.java
 * @Description : 문서함 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaDocVO extends ComAtchFileVO {

	private String docBoxSn;		//문서함일련번호
//	private String atchFileSn;		//첨부파일일련번호
	private String docBoxNm;		//문서함이름
	
	private String kdMode;		//화면 모드
}
