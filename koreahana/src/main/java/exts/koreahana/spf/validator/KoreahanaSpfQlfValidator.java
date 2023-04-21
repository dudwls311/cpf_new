package exts.koreahana.spf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;

/**
 * @Class Name : KoreahanaSpfQlfValidator.java
 * @Description : 정착지원자격시험정보 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSpfQlfValidator")
public class KoreahanaSpfQlfValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String spfstQlfcTestInfoSn = "spfstQlfcTestInfoSn";		//정착지원자격시험정보일련번호
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	private static final String testPlc = "testPlc";		//시험장소
	private static final String testYmd = "testYmd";		//시험연월일
	private static final String testHrInfo = "testHrInfo";		//시험시간정보
	private static final String sccdPrsntnYmd = "sccdPrsntnYmd";		//합격자발표연월일
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spf";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSpfQlfVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSpfQlfVO command = (KoreahanaSpfQlfVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,spfstQlfcTestInfoSn, REQUIRED_FIELD, makeMessage(spfstQlfcTestInfoSn, REQUIRED_FIELD));	//정착지원자격시험정보일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));		//모집공고일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,testPlc, REQUIRED_FIELD, makeMessage(testPlc, REQUIRED_FIELD));		//시험장소
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,testYmd, REQUIRED_FIELD, makeMessage(testYmd, REQUIRED_FIELD));		//시험연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,testHrInfo, REQUIRED_FIELD, makeMessage(testHrInfo, REQUIRED_FIELD));		//시험시간정보
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sccdPrsntnYmd, REQUIRED_FIELD, makeMessage(sccdPrsntnYmd, REQUIRED_FIELD));		//합격자발표연월일
		
	}

}
