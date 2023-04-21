package exts.koreahana.emv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;

/**
 * @Class Name : KoreahanaEmvPrcTkcValidator.java
 * @Description : 취업바우처카드지원현황관리수강정보 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.28
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmvPrcTkcValidator")
public class KoreahanaEmvPrcTkcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String emvucdSprtPrcnMngTkclsSn = "emvucdSprtPrcnMngTkclsSn";		//취업바우처카드지원현황관리수강정보일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String sbjctCd = "sbjctCd";		//과목코드
	private static final String sbjctNm = "sbjctNm";		//과목명
	private static final String ednstCd = "ednstCd";		//교육기관코드
	private static final String ednstNm = "ednstNm";		//교육기관명
	private static final String tkclsPeriod = "tkclsPeriod";		//수강기간
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emv";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmvPrcTkcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmvPrcTkcVO command = (KoreahanaEmvPrcTkcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,emvucdSprtPrcnMngTkclsSn, REQUIRED_FIELD, makeMessage(emvucdSprtPrcnMngTkclsSn, REQUIRED_FIELD));	//취업바우처카드지원현황관리수강정보일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sbjctCd, REQUIRED_FIELD, makeMessage(sbjctCd, REQUIRED_FIELD));		//과목코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sbjctNm, REQUIRED_FIELD, makeMessage(sbjctNm, REQUIRED_FIELD));		//과목명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ednstCd, REQUIRED_FIELD, makeMessage(ednstCd, REQUIRED_FIELD));		//교육기관코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ednstNm, REQUIRED_FIELD, makeMessage(ednstNm, REQUIRED_FIELD));		//교육기관명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,tkclsPeriod, REQUIRED_FIELD, makeMessage(tkclsPeriod, REQUIRED_FIELD));		//수강기간
		
	}

}
