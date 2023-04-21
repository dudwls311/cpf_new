package exts.koreahana.sgn.vo;

import exts.com.vo.ComAtchFileVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaSgnVO.java
 * @Description : 서명 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSgnVO extends ComAtchFileVO {

	private String sgntSn;		//서명일련번호
//	private String atchFileSn;		//첨부파일일련번호
	private String sgntNm;		//서명이름
	private String sgntFavoYn;	//서명즐겨찾기여부

	private String ksMode;		//화면 모드
}
