package exts.koreahana.emv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emv.vo.KoreahanaEmvPrcVO;

/**
 * @Class Name : KoreahanaEmvPrcValidator.java
 * @Description : 취업바우처카드지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmvPrcValidator")
public class KoreahanaEmvPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String emvucdSprtPrcnMngSn = "emvucdSprtPrcnMngSn";		//취업바우처카드지원현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String schlNm = "schlNm";		//학교명
	private static final String mjrNm = "mjrNm";		//전공명
	private static final String schlyr = "schlyr";		//학년
	private static final String ogdp = "ogdp";		//소속
	private static final String aplcntQlfcCd = "aplcntQlfcCd";		//신청자격코드
	private static final String existCdUseYn = "existCdUseYn";		//기존카드사용여부
	private static final String frstCardNo = "frstCardNo";		//최초카드번호
	private static final String scndryCardNo = "scndryCardNo";		//두번째카드번호
	private static final String thirdCardNo = "thirdCardNo";		//세번째카드번호
	private static final String bfrhdAprvYmd = "bfrhdAprvYmd";		//사전승인연월일
	private static final String aplyAmt = "aplyAmt";		//신청금액
	private static final String pntyYn = "pntyYn";		//패널티여부
	private static final String rmrk = "rmrk";		//비고
	private static final String hanactMemo = "hanactMemo";		//하나센터메모
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emv";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmvPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmvPrcVO command = (KoreahanaEmvPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,emvucdSprtPrcnMngSn, REQUIRED_FIELD, makeMessage(emvucdSprtPrcnMngSn, REQUIRED_FIELD));	//취업바우처카드지원현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlNm, REQUIRED_FIELD, makeMessage(schlNm, REQUIRED_FIELD));		//학교명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mjrNm, REQUIRED_FIELD, makeMessage(mjrNm, REQUIRED_FIELD));		//전공명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlyr, REQUIRED_FIELD, makeMessage(schlyr, REQUIRED_FIELD));		//학년
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ogdp, REQUIRED_FIELD, makeMessage(ogdp, REQUIRED_FIELD));		//소속
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplcntQlfcCd, REQUIRED_FIELD, makeMessage(aplcntQlfcCd, REQUIRED_FIELD));		//신청자격코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,existCdUseYn, REQUIRED_FIELD, makeMessage(existCdUseYn, REQUIRED_FIELD));		//기존카드사용여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstCardNo, REQUIRED_FIELD, makeMessage(frstCardNo, REQUIRED_FIELD));		//최초카드번호
		if(!"".equals(NullUtil.nullString(command.getFrstCardNo())) && !PatternUtil.isCard(command.getFrstCardNo()))errors.rejectValue(frstCardNo, INVALID_CARDNO_FIELD, makeMessage(frstCardNo, INVALID_CARDNO_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,scndryCardNo, REQUIRED_FIELD, makeMessage(scndryCardNo, REQUIRED_FIELD));		//두번째카드번호
		if(!"".equals(NullUtil.nullString(command.getScndryCardNo())) && !PatternUtil.isCard(command.getScndryCardNo()))errors.rejectValue(scndryCardNo, INVALID_CARDNO_FIELD, makeMessage(scndryCardNo, INVALID_CARDNO_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,thirdCardNo, REQUIRED_FIELD, makeMessage(thirdCardNo, REQUIRED_FIELD));		//세번째카드번호
		if(!"".equals(NullUtil.nullString(command.getThirdCardNo())) && !PatternUtil.isCard(command.getThirdCardNo()))errors.rejectValue(thirdCardNo, INVALID_CARDNO_FIELD, makeMessage(thirdCardNo, INVALID_CARDNO_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bfrhdAprvYmd, REQUIRED_FIELD, makeMessage(bfrhdAprvYmd, REQUIRED_FIELD));		//사전승인연월일
		if(!"".equals(NullUtil.nullString(command.getBfrhdAprvYmd())))ValidationDateUtil.rejectIfDatePattern(errors, bfrhdAprvYmd, command.getBfrhdAprvYmd(), makeMessage(bfrhdAprvYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplyAmt, REQUIRED_FIELD, makeMessage(aplyAmt, REQUIRED_FIELD));		//신청금액
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pntyYn, REQUIRED_FIELD, makeMessage(pntyYn, REQUIRED_FIELD));		//패널티여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanactMemo, REQUIRED_FIELD, makeMessage(hanactMemo, REQUIRED_FIELD));		//하나센터메모
		
	}

}
