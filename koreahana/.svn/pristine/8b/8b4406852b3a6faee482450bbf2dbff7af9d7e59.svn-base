package exts.koreahana.adt.vo;

import java.util.ArrayList;
import java.util.List;

import exts.koreahana.spr.vo.KoreahanaSprVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaAdtVO.java
 * @Description : 가산금지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaAdtVO extends KoreahanaSprVO {

	private String adtnAmtGiveRsn;		//가산금지급내용
	private String sgntFileSn;		//가산금서명파일일련번호
	private String sgntrFlnm;		//서명자성명

	private String kaMode;		//화면 모드
	
	private List<KoreahanaAdtFamVO> adtFamList = null;
	
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
	
	private String adtFamConcat;	//엑셀저장용 가족관계
	private String rndConcatExcel;	//엑셀저장용 회차별 지급액
}
