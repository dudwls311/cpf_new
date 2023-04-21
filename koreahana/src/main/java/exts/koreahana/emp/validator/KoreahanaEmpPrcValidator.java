package exts.koreahana.emp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;

/**
 * @Class Name : KoreahanaEmpPrcValidator.java
 * @Description : 취업연계직업훈련지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmpPrcValidator")
public class KoreahanaEmpPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String empcnnVoctrnPcrnMngSn = "empcnnVoctrnPcrnMngSn";		//취업연계직업훈련현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String eduBgngYmd = "eduBgngYmd";		//교육시작연월일
	private static final String eduEndYmd = "eduEndYmd";		//교육종료연월일
	private static final String eduFnshCmptnYn = "eduFnshCmptnYn";		//교육수료완료여부
	private static final String mdwGvupYn = "mdwGvupYn";		//중도포기여부
	private static final String crtfctAcqsYn = "crtfctAcqsYn";		//자격증취득여부
	private static final String crtfctInfo = "crtfctInfo";		//자격증정보
	private static final String empmYn = "empmYn";		//취업여부
	private static final String empmCoNm = "empmCoNm";		//취업회사명
	private static final String rmrk = "rmrk";		//비고
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emp";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmpPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmpPrcVO command = (KoreahanaEmpPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,empcnnVoctrnPcrnMngSn, REQUIRED_FIELD, makeMessage(empcnnVoctrnPcrnMngSn, REQUIRED_FIELD));	//취업연계직업훈련현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduBgngYmd, REQUIRED_FIELD, makeMessage(eduBgngYmd, REQUIRED_FIELD));		//교육시작연월일
		if(!"".equals(NullUtil.nullString(command.getEduBgngYmd())))ValidationDateUtil.rejectIfDatePattern(errors, eduBgngYmd, command.getEduBgngYmd(), makeMessage(eduBgngYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduEndYmd, REQUIRED_FIELD, makeMessage(eduEndYmd, REQUIRED_FIELD));		//교육종료연월일
		if(!"".equals(NullUtil.nullString(command.getEduEndYmd())))ValidationDateUtil.rejectIfDatePattern(errors, eduEndYmd, command.getEduEndYmd(), makeMessage(eduEndYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduFnshCmptnYn, REQUIRED_FIELD, makeMessage(eduFnshCmptnYn, REQUIRED_FIELD));		//교육수료완료여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mdwGvupYn, REQUIRED_FIELD, makeMessage(mdwGvupYn, REQUIRED_FIELD));		//중도포기여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctAcqsYn, REQUIRED_FIELD, makeMessage(crtfctAcqsYn, REQUIRED_FIELD));		//자격증취득여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctInfo, REQUIRED_FIELD, makeMessage(crtfctInfo, REQUIRED_FIELD));		//자격증정보
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,empmYn, REQUIRED_FIELD, makeMessage(empmYn, REQUIRED_FIELD));		//취업여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,empmCoNm, REQUIRED_FIELD, makeMessage(empmCoNm, REQUIRED_FIELD));		//취업회사명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
		
	}

}
