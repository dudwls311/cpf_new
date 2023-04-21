package exts.koreahana.emp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;

/**
 * @Class Name : KoreahanaEmpQlfValidator.java
 * @Description : 취업연계직업훈련자격사항 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmpQlfValidator")
public class KoreahanaEmpQlfValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String empmQlfcMttrSn = "empmQlfcMttrSn";		//취업연계직업훈련자격사항일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String crtfctNm = "crtfctNm";		//자격증명
	private static final String acqsYmd = "acqsYmd";		//취득연월일
	private static final String acqsPlc = "acqsPlc";		//취득처
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emp";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmpQlfVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmpQlfVO command = (KoreahanaEmpQlfVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,empmQlfcMttrSn, REQUIRED_FIELD, makeMessage(empmQlfcMttrSn, REQUIRED_FIELD));	//취업연계직업훈련자격사항일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctNm, REQUIRED_FIELD, makeMessage(crtfctNm, REQUIRED_FIELD));		//자격증명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,acqsYmd, REQUIRED_FIELD, makeMessage(acqsYmd, REQUIRED_FIELD));		//취득연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,acqsPlc, REQUIRED_FIELD, makeMessage(acqsPlc, REQUIRED_FIELD));		//취득처
		
	}

}
