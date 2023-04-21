package exts.koreahana.emp.vo;

import java.util.List;

import exts.koreahana.spr.vo.KoreahanaSprVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaEmpVO.java
 * @Description : 취업연계직업훈련 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaEmpVO extends KoreahanaSprVO {

	private String sprtSn;		//지원일련번호
	private String lastAcbgSchlNm;		//최종학력학교명
	private String lastAcbgSchlGrdtnCd;		//최종학력졸업코드
	private String lastAcbgMjrNm;		//최종학력전공명
	private String empmSttsYn;		//취업상태여부
	private String empmWrcNm;		//취업직장명
	private String hgvlcYn;		//대형면허여부
	private String busDrvngCrtfctYn;		//버스운전자격증여부
	private String hopeTrpttBzenty;		//희망운수업체
	private String rsnaplc;		//지원동기
	private String sgntFileSn;		//서명파일일련번호
	private String sgntrFlnm;		//서명자이름
	
	private List<KoreahanaEmpQlfVO> empQlfList = null;

	private String keMode;		//화면 모드
}
