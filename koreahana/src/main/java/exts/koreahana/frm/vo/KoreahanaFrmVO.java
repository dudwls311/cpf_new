package exts.koreahana.frm.vo;

import java.util.List;

import exts.com.vo.ExtsAbstractVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaFrmVO.java
 * @Description : 영농정착지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaFrmVO extends ExtsAbstractVO {

	private String frmSpfstSn;		//영농정착지원일련번호
	private String flnm;		//성명
	private String genderCd;		//성별코드
	private String brdtYmd;		//생년월일
	private String mbphno;		//휴대폰번호
	private String prtdcsYmd;		//보호결정연월일
	private String entcnyYmd;		//입국연월일
	private String addr;		//주소
	private String frscpkEdu;		//영성패교육
	private String newYn;		//신규여부
	private String sprtYr;		//지원연도
	private String sprtCycl;		//지원차수
	private String sprtDcsnAmt;		//지원결정액
	private String sprtAmt;		//실집행액
	private String prchsBzenty;		//구매업체
	private String prchsItem;		//구매품목
	private String rmrk;		//비고
	private String sprtSttsCd;		//지원상태코드
	private String rsn;		//사유
	

	private String kfMode;		//화면 모드
	
	private List<String> frmSpfstSnList = null;		//선택삭제할 지원일련번호 목록
}
