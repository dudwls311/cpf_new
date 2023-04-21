package exts.koreahana.spb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.spb.vo.KoreahanaSpbVO;

/**
 * @Class Name : KoreahanaSpbValidator.java
 * @Description : 지원사업설정 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.19
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSpbValidator")
public class KoreahanaSpbValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtBizStngSn = "sprtBizStngSn";		//지원사업설정일련번호
	private static final String ctgryFrstCd = "ctgryFrstCd";		//최초범주코드
	private static final String stngCd = "stngCd";		//설정코드
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spb";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSpbVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSpbVO command = (KoreahanaSpbVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtBizStngSn, REQUIRED_FIELD, makeMessage(sprtBizStngSn, REQUIRED_FIELD));	//지원사업설정일련번호지원사업설정일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ctgryFrstCd, REQUIRED_FIELD, makeMessage(ctgryFrstCd, REQUIRED_FIELD));		//최초범주코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,stngCd, REQUIRED_FIELD, makeMessage(stngCd, REQUIRED_FIELD));		//설정코드
		
	}

}
