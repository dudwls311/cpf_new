package exts.koreahana.emv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emv.vo.KoreahanaEmvVO;

/**
 * @Class Name : KoreahanaEmvValidator.java
 * @Description : 취업바우처카드 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmvValidator")
public class KoreahanaEmvValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";					//지원일련번호
	private static final String hanactCd = "hanactCd";				//하나센터코드
	private static final String hnwTh = "hnwTh";					//하나원기수
	private static final String hanawonFnshYr = "hanawonFnshYr";	//하나원수료연도
	private static final String dscsnYmd = "dscsnYmd";				//상담연월일
	private static final String cnslFlnm = "cnslFlnm";				//상담사성명
	private static final String eml = "eml";						//이메일

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emv";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmvVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmvVO command = (KoreahanaEmvVO) obj;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanawonFnshYr, REQUIRED_FIELD, makeMessage(hanawonFnshYr, REQUIRED_FIELD));		//하나원수료연도
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hnwTh, REQUIRED_FIELD, makeMessage(hnwTh, REQUIRED_FIELD));		//하나원기수
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dscsnYmd, REQUIRED_SELECT_FIELD, makeMessage(dscsnYmd, REQUIRED_SELECT_FIELD));		//상담연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cnslFlnm, REQUIRED_FIELD, makeMessage(cnslFlnm, REQUIRED_FIELD));		//상담사 성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanactCd, REQUIRED_SELECT_FIELD, makeMessage(hanactCd, REQUIRED_SELECT_FIELD));		//하나센터코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,eml, REQUIRED_FIELD, makeMessage(eml, REQUIRED_FIELD));		//이메일
		
	}

}
