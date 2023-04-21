package exts.koreahana.lnb.vo;

import java.util.List;

import exts.koreahana.spr.vo.KoreahanaSprVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaLnbVO.java
 * @Description : 학습지지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaLnbVO extends KoreahanaSprVO {

//	private String sprtSn;		//지원일련번호
	private String aplcntType;		//신청자유형
	private String eduSprtTrprRelCd;		//교육지원대상자관계코드
	private String eduSprtTrprRelDtl;		//교육지원대상자관계상세
	private String hshldrFlnm;		//세대주명
	private String rcoblYn;		//기초생활수급자여부
	private String rcoblSgntFileSn;		//기초생활수급자인증서파일일련번호
	private String sgntFileSn;		//서명파일일련번호
	private String sgntrFlnm;		//서명자이름
	private String prtcrSgntFileSn;		//보호자서명파일일련번호
	private String prtcrSgntrFlnm;		//보호자서명이름
	
	List<KoreahanaLnbPrcVO> lnbPrcList = null;

	private String klMode;		//화면 모드
	
	//엑셀 추가데이터 (교육지원대상자정보 4개 고정값)
	private KoreahanaLnbPrcVO lnbPrc1;
	private KoreahanaLnbPrcVO lnbPrc2;
	private KoreahanaLnbPrcVO lnbPrc3;
	private KoreahanaLnbPrcVO lnbPrc4;
}
