package exts.koreahana.spf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;

/**
 * @Class Name : KoreahanaSpfPrcValidator.java
 * @Description : 정착지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSpfPrcValidator")
public class KoreahanaSpfPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String spfstPrcnMngSn = "spfstPrcnMngSn";		//정착지원현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String spfstQlfcTestInfoSn = "spfstQlfcTestInfoSn";		//정착지원자격시험정보일련번호
	private static final String exslno = "exslno";		//응시번호
	private static final String testRsltCd = "testRsltCd";		//시험결과코드
	private static final String passYmd = "passYmd";		//합격연월일
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spf";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSpfPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSpfPrcVO command = (KoreahanaSpfPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,spfstPrcnMngSn, REQUIRED_FIELD, makeMessage(spfstPrcnMngSn, REQUIRED_FIELD));	//정착지원현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,spfstQlfcTestInfoSn, REQUIRED_FIELD, makeMessage(spfstQlfcTestInfoSn, REQUIRED_FIELD));		//정착지원자격시험정보일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,exslno, REQUIRED_FIELD, makeMessage(exslno, REQUIRED_FIELD));		//응시번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,testRsltCd, REQUIRED_FIELD, makeMessage(testRsltCd, REQUIRED_FIELD));		//시험결과코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,passYmd, REQUIRED_FIELD, makeMessage(passYmd, REQUIRED_FIELD));		//합격연월일
		if(!"".equals(NullUtil.nullString(command.getPassYmd())))ValidationDateUtil.rejectIfDatePattern(errors, passYmd, command.getPassYmd(), makeMessage(passYmd, INVALID_DATE_FIELD));
		
	}

}
