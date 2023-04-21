package exts.koreahana.emv.vo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.vo.ComCodeVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaEmvPrcVO.java
 * @Description : 취업바우처카드지원현황관리 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaEmvPrcVO extends KoreahanaEmvVO {

	private String emvucdSprtPrcnMngSn;		//취업바우처카드지원현황관리일련번호
//	private String sprtSn;		//지원일련번호
	private String schlNm;		//학교명
	private String mjrNm;		//전공명
	private String schlyr;		//학년
	private String ogdp;		//소속
	private String aplcntQlfcCd;		//신청자격코드
	private String existCdUseYn;		//기존카드사용여부
	private String frstCardNo;		//최초카드번호
	private String scndryCardNo;		//두번째카드번호
	private String thirdCardNo;		//세번째카드번호
	private String bfrhdAprvYmd;		//사전승인연월일
	private String aplyAmt;		//신청금액
	private String pntyYn;		//패널티여부
	private String rmrk;		//비고
	private String hanactMemo;		//하나센터메모
	
	private List<KoreahanaEmvPrcTkcVO> emvPrcTkcList = null;

	private String kepMode;		//화면 모드
	
	//추가데이터
	private String useAmt;	//사용금액
	
	
	//엑셀데이터
	private String sbjctConcat;	//수강정보
	private long balance;		//잔액
	private String usePercent;	//사용율
	
	//수강정보 리스트로 변환
	public void setSbjctConcat(String sbjctConcat) {
		this.sbjctConcat = sbjctConcat;
		if(sbjctConcat == null)return;
		List<KoreahanaEmvPrcTkcVO> emvPrcTkcList = new ArrayList<KoreahanaEmvPrcTkcVO>();
		for(String splitSbjctConcat:sbjctConcat.split(",")) {
			String[] splitSbjct = splitSbjctConcat.split("\\^");
			KoreahanaEmvPrcTkcVO emvPrcTkcVO = new KoreahanaEmvPrcTkcVO();
			if(splitSbjct.length > 0)emvPrcTkcVO.setSbjctCd(splitSbjct[0]);
			if(splitSbjct.length > 1)emvPrcTkcVO.setSbjctNm(splitSbjct[1]);
			if(splitSbjct.length > 2)emvPrcTkcVO.setEdnstCd(splitSbjct[2]);
			if(splitSbjct.length > 3)emvPrcTkcVO.setEdnstNm(splitSbjct[3]);
			if(splitSbjct.length > 4)emvPrcTkcVO.setTkclsPeriod(splitSbjct[4]);
			emvPrcTkcList.add(emvPrcTkcVO);
		}
		this.emvPrcTkcList = emvPrcTkcList;
	}
}
