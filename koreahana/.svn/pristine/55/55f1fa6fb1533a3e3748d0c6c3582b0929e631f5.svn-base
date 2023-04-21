package exts.koreahana.doc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.doc.vo.KoreahanaDocVO;
import egovframework.com.utl.fcc.service.NullUtil;

/**
 * @Class Name : KoreahanaDocValidator.java
 * @Description : 문서함 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaDocValidator")
public class KoreahanaDocValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String docBoxSn = "docBoxSn";		//문서함일련번호
	private static final String atchFileSn = "atchFileSn";		//첨부파일일련번호
	private static final String docBoxNm = "docBoxNm";		//문서함이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.doc";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaDocVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaDocVO command = (KoreahanaDocVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,docBoxSn, REQUIRED_FIELD, makeMessage(docBoxSn, REQUIRED_FIELD));	//문서함일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,docBoxNm, REQUIRED_FIELD, makeMessage(docBoxNm, REQUIRED_FIELD));		//문서함이름
		if("".equals(NullUtil.nullString(command.getDocBoxSn()))) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,atchFileSn, REQUIRED_SELECT_FIELD, makeMessage(atchFileSn, REQUIRED_SELECT_FIELD));		//첨부파일일련번호
		}
		
	}

}
