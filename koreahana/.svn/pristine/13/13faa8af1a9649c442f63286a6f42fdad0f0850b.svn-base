package exts.koreahana.sgn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.sgn.vo.KoreahanaSgnVO;

/**
 * @Class Name : KoreahanaSgnValidator.java
 * @Description : 서명 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSgnValidator")
public class KoreahanaSgnValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sgntSn = "sgntSn";		//서명일련번호
	private static final String atchFileSn = "atchFileSn";		//첨부파일일련번호
	private static final String sgntNm = "sgntNm";		//서명이름
	private static final String sgntFavoYn = "sgntFavoYn";		//서명메인여부
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.sgn";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSgnVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSgnVO command = (KoreahanaSgnVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntSn, REQUIRED_FIELD, makeMessage(sgntSn, REQUIRED_FIELD));	//서명일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,atchFileSn, REQUIRED_SELECT_FIELD, getMessage("exts.item.koreahana.sgn.atchFileSnRequired"));		//첨부파일일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntNm, REQUIRED_FIELD, makeMessage(sgntNm, REQUIRED_FIELD));		//서명이름
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFavoYn, REQUIRED_SELECT_FIELD, makeMessage(sgntFavoYn, REQUIRED_SELECT_FIELD));		//서명메인여부
	}

}
