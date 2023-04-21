package exts.koreahana.sho.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.sho.vo.KoreahanaShoPrcVO;

/**
 * @Class Name : KoreahanaShoPrcValidator.java
 * @Description : 장학금지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaShoPrcValidator")
public class KoreahanaShoPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sholSprtPrcnMngSn = "sholSprtPrcnMngSn";		//장학금지원현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String slctnMthdCd = "slctnMthdCd";		//선발방법코드
	private static final String slctnMmtCd = "slctnMmtCd";		//선발시기코드
	private static final String fncrscCd = "fncrscCd";		//지재원코드
	private static final String giveYmd = "giveYmd";		//급연월일
	private static final String sholGiveAmt = "sholGiveAmt";		//장학금지급금액
	private static final String rmrk = "rmrk";		//비고
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.sho";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaShoPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaShoPrcVO command = (KoreahanaShoPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sholSprtPrcnMngSn, REQUIRED_FIELD, makeMessage(sholSprtPrcnMngSn, REQUIRED_FIELD));	//장학금지원현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,slctnMthdCd, REQUIRED_FIELD, makeMessage(slctnMthdCd, REQUIRED_FIELD));		//선발방법코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,slctnMmtCd, REQUIRED_FIELD, makeMessage(slctnMmtCd, REQUIRED_FIELD));		//선발시기코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,fncrscCd, REQUIRED_FIELD, makeMessage(fncrscCd, REQUIRED_FIELD));		//지재원코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveYmd, REQUIRED_FIELD, makeMessage(giveYmd, REQUIRED_FIELD));		//급연월일
		if(!"".equals(NullUtil.nullString(command.getGiveYmd())))ValidationDateUtil.rejectIfDatePattern(errors, giveYmd, command.getGiveYmd(), makeMessage(giveYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sholGiveAmt, REQUIRED_FIELD, makeMessage(sholGiveAmt, REQUIRED_FIELD));		//장학금지급금액
		if(!"".equals(NullUtil.nullString(command.getSholGiveAmt())) && !PatternUtil.isNumber(command.getSholGiveAmt()))errors.rejectValue(sholGiveAmt, INVALID_NUMBER_FIELD, makeMessage(sholGiveAmt, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
		
	}

}
