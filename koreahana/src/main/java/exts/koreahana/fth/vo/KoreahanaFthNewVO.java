package exts.koreahana.fth.vo;

import lombok.Getter;
import lombok.Setter;
import exts.com.vo.ExtsAbstractVO;
/**
 * @Class Name : KoreahanaFthVO.java
 * @Description : 미래행복통장신규신청 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaFthNewVO extends ExtsAbstractVO {

	private String fthpbbNewAplySn;		//미래행복통장신규신청일련번호
	private String flnm;		//성명
	private String genderCd;		//성별코드
	private String rrno;		//주민등록번호
	private String ageCd;		//연령대코드
	private String mbphno;		//휴대폰번호
	private String ctpvCd;		//시도코드
	private String sggCd;		//시군구코드
	private String ecnmatCd;		//경제활동코드
	private String crCd;		//직업군코드
	private String coNm;		//회사명
	private String emplisJoinYmd;		//고용보험가입연월일
	private String salaryAmt;		//월급여액
	private String entcnyYmd;		//입국연월일
	private String entiscYmd;		//사회진출연월일
	private String trinsExpryYmd;		//보험기간만료연월일
	private String rcptYmd;		//접수연월일
	private String jrdcHanactNm;		//관할하나센터
	private String dcsnSprtAmt;		//결정지원액
	private String bbJoinYmd;		//통장가입연월일
	private String savingDdlnYmd;		//적립마감연월일
	private String prtprdExtsnCd;		//보호기간연장코드
	private String idtprsSavingAmtActno;		//본인적립금계좌번호
	private String stmchkActno;		//정부지원금계좌번호
	private String rmrk;		//비고
	private String sprtSttsCd;		//지원상태코드
	private String rsn;		//사유
	

	private String kfnMode;		//화면 모드

	//검색용
	private String rcptYear;	//접수연도
}
