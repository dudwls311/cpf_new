package exts.koreahana.eml.vo;

import exts.koreahana.spr.vo.KoreahanaSprVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaEmlVO.java
 * @Description : 긴급생계비지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaEmlVO extends KoreahanaSprVO {

	private String sprtSn;		//지원일련번호
	private String entcnyYmd;		//입국연월일
	private String hanawonFnshYr;		//하나원수료연도
	private String hnwTh;		//하나원기수
	private String dscsnYmd;		//상담연월일
	private String hanactCd;		//하나센터코드
	private String cnslFlnm;		//상담사명
	private String eml;		//이메일
	private String bacntBankCd;		//계좌은행
	private String actno;		//계좌번호
	private String dpstr;		//예금주
	private String actnoRmrk;		//계좌번호기타
	private String excvMthdCd;	//발굴방법코드
	private String excvMthdEtc;	//발굴방법기타사유
	private String frstCnslYmd;	//최초상담일
	
	private String keMode;		//화면 모드
	
	//리스트에서 보여주기용
	private String hanactNm;	//하나센터 명
	
	//엑셀 데이터
	private String frstCnslYmdStr;	//최초상담일 문자열
}
