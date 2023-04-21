package exts.koreahana.vdo.vo;

import exts.koreahana.spr.vo.KoreahanaSprVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaVdoVO.java
 * @Description : 화상영어교육지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaVdoVO extends KoreahanaSprVO {

//	private String sprtSn;		//지원일련번호
	private String aplcntType;		//신청자유형
	private String brplcCd;		//출생지코드
	private String existBnfCd;		//기존수혜여부코드
	private String rcoblYn;		//기초생활수급자여부
	private String rcoblSgntFileSn;		//기초생활수급자인증서파일일련번호
	private String aplcntOgdp;		//소속
	private String ntkrdfSe;		//북한이탈주민구분
	private String ntkrdfFlnm;		//북한이탈주민성명
	private String ntkrdfHanawonTh;		//북한이탈주민하나원기수
	private String ntkrdfEntcnyYr;		//북한이탈주민입국년도
	private String ntkrdfAcrtfctFileSn;		//북한이탈주민인증서파일일련번호
	private String eduSprtTrprRelCd;		//교육지원대상자관계코드
	private String eduSprtTrprRelDtl;		//교육지원대상자관계상세
	private String prtcrFlnm;		//보호자성명
	private String prtcrGenderCd;		//보호자성별코드
	private String prtcrBrdtYmd;		//보호자생년월일
	private String prtcrMbphno;		//보호자휴대폰번호
	private String prtcrZip;		//보호자우편번호
	private String prtcrAddr;		//보호자주소
	private String prtcrDaddr;		//보호자상세주소
	private String sgntFileSn;		//서명파일일련번호
	private String sgntrFlnm;		//서명자이름
	private String prtcrSgntFileSn;		//보호자서명파일일련번호
	private String prtcrSgntrFlnm;		//보호자서명이름
	

	private String kvMode;		//화면 모드
}
