package exts.koreahana.adt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.adt.vo.KoreahanaAdtPrcRndVO;
import exts.koreahana.adt.vo.KoreahanaAdtPrcVO;

/**
 * @Class Name : KoreahanaAdtPrcValidator.java
 * @Description : 가산금지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaAdtPrcValidator")
public class KoreahanaAdtPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String dsbltyDegr = "dsbltyDegr";		//장애정도
	private static final String dsbltySe = "dsbltySe";		//장애구분
	private static final String dsbltyRmrk = "dsbltyRmrk";		//장애비고
	private static final String dssNm = "dssNm";		//질병명
	private static final String hsptzPeriod = "hsptzPeriod";		//입원기간
	private static final String hsptzInfo = "hsptzInfo";		//입원정보
	private static final String lperiodCureRmrk = "lperiodCureRmrk";		//장기치료비고
	private static final String frstChdrFlnm = "frstChdrFlnm";		//첫번째자녀이름
	private static final String frstChdrBrdtYmd = "frstChdrBrdtYmd";		//첫번째자녀생년월일
	private static final String frstChdrBrthNtnNm = "frstChdrBrthNtnNm";		//첫번째자녀출생국가명
	private static final String scndryChdrFlnm = "scndryChdrFlnm";		//두번째자녀이름
	private static final String scndryChdrBrdtYmd = "scndryChdrBrdtYmd";		//두번째자녀생년월일
	private static final String scndryChdrBrthNtnNm = "scndryChdrBrthNtnNm";		//두번째자녀출생국가명
	private static final String chdrNtreRmrk = "chdrNtreRmrk";		//자녀양육비고
	private static final String giveDcsnYmd = "giveDcsnYmd";		//지급결정연월일
	private static final String frstDcsnAmt = "frstDcsnAmt";		//최초결정액
	private static final String giveBgngYm = "giveBgngYm";		//지급시작연월
	private static final String giveEndYm = "giveEndYm";		//지급종료연월
	private static final String totGiveNmtm = "totGiveNmtm";		//총지급횟수
	private static final String bacntBankCd = "bacntBankCd";		//계좌은행코드
	private static final String actno = "actno";		//계좌번호
	private static final String dpstr = "dpstr";		//예금주
	private static final String giveTrmnYmd = "giveTrmnYmd";		//지급종결연월일
	private static final String trmnRsn = "trmnRsn";		//종결사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.adt";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaAdtPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaAdtPrcVO command = (KoreahanaAdtPrcVO) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dsbltyDegr, REQUIRED_FIELD, makeMessage(dsbltyDegr, REQUIRED_FIELD));		//장애정도
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dsbltySe, REQUIRED_FIELD, makeMessage(dsbltySe, REQUIRED_FIELD));		//장애구분
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dsbltyRmrk, REQUIRED_FIELD, makeMessage(dsbltyRmrk, REQUIRED_FIELD));		//장애비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dssNm, REQUIRED_FIELD, makeMessage(dssNm, REQUIRED_FIELD));		//질병명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hsptzPeriod, REQUIRED_FIELD, makeMessage(hsptzPeriod, REQUIRED_FIELD));		//입원기간
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hsptzInfo, REQUIRED_FIELD, makeMessage(hsptzInfo, REQUIRED_FIELD));		//입원정보
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,lperiodCureRmrk, REQUIRED_FIELD, makeMessage(lperiodCureRmrk, REQUIRED_FIELD));		//장기치료비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstChdrFlnm, REQUIRED_FIELD, makeMessage(frstChdrFlnm, REQUIRED_FIELD));		//첫번째자녀이름
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstChdrBrdtYmd, REQUIRED_FIELD, makeMessage(frstChdrBrdtYmd, REQUIRED_FIELD));		//첫번째자녀생년월일
		if(!"".equals(NullUtil.nullString(command.getFrstChdrBrdtYmd())))ValidationDateUtil.rejectIfDatePattern(errors, frstChdrBrdtYmd, command.getFrstChdrBrdtYmd(), makeMessage(frstChdrBrdtYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstChdrBrthNtnNm, REQUIRED_FIELD, makeMessage(frstChdrBrthNtnNm, REQUIRED_FIELD));		//첫번째자녀출생국가명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,scndryChdrFlnm, REQUIRED_FIELD, makeMessage(scndryChdrFlnm, REQUIRED_FIELD));		//두번째자녀이름
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,scndryChdrBrdtYmd, REQUIRED_FIELD, makeMessage(scndryChdrBrdtYmd, REQUIRED_FIELD));		//두번째자녀생년월일
		if(!"".equals(NullUtil.nullString(command.getScndryChdrBrdtYmd())))ValidationDateUtil.rejectIfDatePattern(errors, scndryChdrBrdtYmd, command.getScndryChdrBrdtYmd(), makeMessage(scndryChdrBrdtYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,scndryChdrBrthNtnNm, REQUIRED_FIELD, makeMessage(scndryChdrBrthNtnNm, REQUIRED_FIELD));		//두번째자녀출생국가명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,chdrNtreRmrk, REQUIRED_FIELD, makeMessage(chdrNtreRmrk, REQUIRED_FIELD));		//자녀양육비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveDcsnYmd, REQUIRED_FIELD, makeMessage(giveDcsnYmd, REQUIRED_FIELD));		//지급결정연월일
		if(!"".equals(NullUtil.nullString(command.getGiveDcsnYmd())))ValidationDateUtil.rejectIfDatePattern(errors, giveDcsnYmd, command.getGiveDcsnYmd(), makeMessage(giveDcsnYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstDcsnAmt, REQUIRED_FIELD, makeMessage(frstDcsnAmt, REQUIRED_FIELD));		//최초결정액
		if(!"".equals(NullUtil.nullString(command.getFrstDcsnAmt())) && !PatternUtil.isNumber(command.getFrstDcsnAmt()))errors.rejectValue(frstDcsnAmt, INVALID_NUMBER_FIELD, makeMessage(frstDcsnAmt, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveBgngYm, REQUIRED_FIELD, makeMessage(giveBgngYm, REQUIRED_FIELD));		//지급시작연월
		if(!"".equals(NullUtil.nullString(command.getGiveBgngYm())))ValidationDateUtil.rejectIfDatePattern(errors, giveBgngYm, command.getGiveBgngYm()+"-01", makeMessage(giveBgngYm, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveEndYm, REQUIRED_FIELD, makeMessage(giveEndYm, REQUIRED_FIELD));		//지급종료연월
		if(!"".equals(NullUtil.nullString(command.getGiveEndYm())))ValidationDateUtil.rejectIfDatePattern(errors, giveEndYm, command.getGiveEndYm()+"-01", makeMessage(giveEndYm, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,totGiveNmtm, REQUIRED_FIELD, makeMessage(totGiveNmtm, REQUIRED_FIELD));		//총지급횟수
		if(!"".equals(NullUtil.nullString(command.getTotGiveNmtm())) && !PatternUtil.isNumber(command.getTotGiveNmtm()))errors.rejectValue(totGiveNmtm, INVALID_NUMBER_FIELD, makeMessage(totGiveNmtm, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bacntBankCd, REQUIRED_FIELD, makeMessage(bacntBankCd, REQUIRED_FIELD));		//계좌은행코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,actno, REQUIRED_FIELD, makeMessage(actno, REQUIRED_FIELD));		//계좌번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dpstr, REQUIRED_FIELD, makeMessage(dpstr, REQUIRED_FIELD));		//예금주
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveTrmnYmd, REQUIRED_FIELD, makeMessage(giveTrmnYmd, REQUIRED_FIELD));		//지급종결연월일
		if(!"".equals(NullUtil.nullString(command.getGiveTrmnYmd())))ValidationDateUtil.rejectIfDatePattern(errors, giveTrmnYmd, command.getGiveTrmnYmd(), makeMessage(giveTrmnYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,trmnRsn, REQUIRED_FIELD, makeMessage(trmnRsn, REQUIRED_FIELD));		//종결사유
		
		
	}

}
