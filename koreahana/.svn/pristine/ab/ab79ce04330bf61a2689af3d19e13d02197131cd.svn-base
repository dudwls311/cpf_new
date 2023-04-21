package exts.koreahana.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.edu.vo.KoreahanaEduPrcVO;

/**
 * @Class Name : KoreahanaEduPrcValidator.java
 * @Description : 교육지원금지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEduPrcValidator")
public class KoreahanaEduPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String eduSprtPrcnMngSn = "eduSprtPrcnMngSn";		//교육지원금지원현황관리교육지원금지원현황관리
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String giveYmd = "giveYmd";		//지급연월일
	private static final String asstAmtGiveAmt = "asstAmtGiveAmt";		//보조금지급금액
	private static final String rmrk = "rmrk";		//비고
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.edu";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEduPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEduPrcVO command = (KoreahanaEduPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtPrcnMngSn, REQUIRED_FIELD, makeMessage(eduSprtPrcnMngSn, REQUIRED_FIELD));	//교육지원금지원현황관리교육지원금지원현황관리
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveYmd, REQUIRED_FIELD, makeMessage(giveYmd, REQUIRED_FIELD));		//지급연월일
		if(!"".equals(NullUtil.nullString(command.getGiveYmd())))ValidationDateUtil.rejectIfDatePattern(errors, giveYmd, command.getGiveYmd(), makeMessage(giveYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,asstAmtGiveAmt, REQUIRED_FIELD, makeMessage(asstAmtGiveAmt, REQUIRED_FIELD));		//보조금지급금액
		if(!"".equals(NullUtil.nullString(command.getAsstAmtGiveAmt())) && !PatternUtil.isNumber(command.getAsstAmtGiveAmt()))errors.rejectValue(asstAmtGiveAmt, INVALID_NUMBER_FIELD, makeMessage(asstAmtGiveAmt, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
		
	}

}
