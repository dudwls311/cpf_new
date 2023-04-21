package exts.koreahana.fth.vo;

import lombok.Getter;
import lombok.Setter;
import exts.com.vo.ExtsAbstractVO;
/**
 * @Class Name : KoreahanaFthMtrVO.java
 * @Description : 미래행복통장만기해지 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaFthMtrVO extends ExtsAbstractVO {

	private String fthpbbMtryCncltnSn;		//미래행복통장만기해지일련번호
	private String flnm;		//성명
	private String rrno;		//주민등록번호
	private String mbphno;		//휴대폰번호
	private String ctpvCd;		//시도코드
	private String sggCd;		//시군구코드
	private String rcptYmd;		//접수연월일
	private String cncltnYmd;		//해지연월일
	private String jrdcHanactNm;		//관할하나센터
	private String bbJoinYmd;		//통장가입연월일
	private String usdusgCd;		//사용처코드
	private String idtprsSavingAmt;		//본인적립금
	private String fndtSavingAmt;		//재단적립금
	private String mtryMmCnt;		//만기개월수
	private String fncEduTkclsYmd;		//금융교육수강연월일
	private String idtprsSavingAmtActno;		//본인적립금계좌번호
	private String stmchkActno;		//정부지원금계좌번호
	private String rmrk;		//비고
	private String sprtSttsCd;		//지원상태
	private String rsn;		//사유
	

	private String kfmMode;		//화면 모드

	//검색용
	private String rcptYear;	//접수연도
}
