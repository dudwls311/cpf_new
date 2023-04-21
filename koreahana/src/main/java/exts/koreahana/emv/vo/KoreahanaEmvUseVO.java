package exts.koreahana.emv.vo;

import java.util.List;

import exts.com.vo.ExtsAbstractVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaEmvPrcUseVO.java
 * @Description : 취업바우처카드사용정보 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaEmvUseVO extends ExtsAbstractVO {

	private String emvucdUseInfoSn;		//취업바우처카드사용정보일련번호
	private String cardNo;		//카드번호
	private String issuistFlnm;		//발급자
	private String aprvYmd;		//승인연월일
	private String aprvNo;		//승인번호
	private String frcsNm;		//가맹점명
	private String aprvAmt;		//승인금액
	

	private String keuMode;		//화면 모드

	//검색용
	private String aprvYear;		//승인연도
	private List<String> cardNoList;	//카드번호리스트
}
