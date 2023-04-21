package exts.koreahana.adt.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaAdtPrcVO.java
 * @Description : 가산금지원현황관리 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaAdtPrcVO extends KoreahanaAdtVO {

	private String adtnAmtSprtPrcnMngSn;		//가산금지원현황관리일련번호
//	private String adtnAmtSprtSn;		//가산금지원일련번호
	private String dsbltyDegr;		//장애정도
	private String dsbltySe;		//장애구분
	private String dsbltyRmrk;		//장애비고
	private String dssNm;		//질병명
	private String hsptzPeriod;		//입원기간
	private String hsptzInfo;		//입원정보
	private String lperiodCureRmrk;		//장기치료비고
	private String frstChdrFlnm;		//첫번째자녀이름
	private String frstChdrBrdtYmd;		//첫번째자녀생년월일
	private String frstChdrBrthNtnNm;		//첫번째자녀출생국가명
	private String scndryChdrFlnm;		//두번째자녀이름
	private String scndryChdrBrdtYmd;		//두번째자녀생년월일
	private String scndryChdrBrthNtnNm;		//두번째자녀출생국가명
	private String chdrNtreRmrk;		//자녀양육비고
	private String giveDcsnYmd;		//지급결정연월일
	private String frstDcsnAmt;		//최초결정액
	private String giveBgngYm;		//지급시작연월
	private String giveEndYm;		//지급종료연월
	private String totGiveNmtm;		//총지급횟수
	private String bacntBankCd;		//계좌은행코드
	private String actno;		//계좌번호
	private String dpstr;		//예금주
	private String giveTrmnYmd;		//지급종결연월일
	private String trmnRsn;		//종결사유
	

	private String kapMode;		//화면 모드
	
	//추가데이터
	@Setter(value = AccessLevel.NONE)
	private String rndConcat;	//회차별지급액 및 회차를 콤마로 연결
	private List<KoreahanaAdtPrcRndVO> rndList;	//회차별지급리스트
	
	//회차별지급액 및 회차를 회차별지급리스트로 변환	
	public void setRndConcat(String rndConcat) {
		this.rndConcat = rndConcat;
		if(rndConcat == null)return;
		List<KoreahanaAdtPrcRndVO> rndList = new ArrayList<KoreahanaAdtPrcRndVO>();
		for(String splitRndConcat:rndConcat.split(",")) {
			String[] splitRnd = splitRndConcat.split("\\^");
			KoreahanaAdtPrcRndVO rndVO = new KoreahanaAdtPrcRndVO();
			if(splitRnd.length > 0)rndVO.setRnd(splitRnd[0]);
			if(splitRnd.length > 1)rndVO.setGiveYm(splitRnd[1]);
			if(splitRnd.length > 2)rndVO.setGiveAmt(splitRnd[2]);
			rndList.add(rndVO);
		}
		this.rndList = rndList;
	}

	private String rndAmtTotal;	//엑셀저장용 총지급액
	private String adtFamConcat;	//엑셀저장용 가족관계
	private String rndConcatExcel;	//엑셀저장용 회차별 지급액
}
