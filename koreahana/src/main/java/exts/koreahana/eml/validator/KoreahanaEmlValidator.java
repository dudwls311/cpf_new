package exts.koreahana.eml.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.util.PatternUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.eml.vo.KoreahanaEmlVO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Class Name : KoreahanaEmlValidator.java
 * @Description : 긴급생계비지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmlValidator")
public class KoreahanaEmlValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String hanawonFnshYr = "hanawonFnshYr";		//하나원수료연도
	private static final String entcnyYmd = "entcnyYmd";		//입국연월일
	private static final String hnwTh = "hnwTh";		//하나원기수
	private static final String dscsnYmd = "dscsnYmd";		//상담연월일
	private static final String hanactCd = "hanactCd";		//하나센터코드
	private static final String cnslFlnm = "cnslFlnm";		//상담사명
	private static final String eml = "eml";		//이메일
	private static final String bacntBankCd = "bacntBankCd";		//계좌은행
	private static final String actno = "actno";		//계좌번호
	private static final String dpstr = "dpstr";		//예금주
	private static final String excvMthdCd = "excvMthdCd";	//발굴방법
	private static final String excvMthdEtc = "excvMthdEtc";	//발굴방법기타사유
	private static final String frstCnslYmd = "frstCnslYmd";	//최초상담일
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.eml";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmlVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmlVO command = (KoreahanaEmlVO) obj;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanawonFnshYr, REQUIRED_FIELD, makeMessage(hanawonFnshYr, REQUIRED_FIELD));		//하나원수료연도
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,entcnyYmd, REQUIRED_FIELD, makeMessage(entcnyYmd, REQUIRED_FIELD));		//입국연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hnwTh, REQUIRED_FIELD, makeMessage(hnwTh, REQUIRED_FIELD));		//하나원기수
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dscsnYmd, REQUIRED_SELECT_FIELD, makeMessage(dscsnYmd, REQUIRED_SELECT_FIELD));		//상담연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanactCd, REQUIRED_SELECT_FIELD, makeMessage(hanactCd, REQUIRED_SELECT_FIELD));		//하나센터코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cnslFlnm, REQUIRED_FIELD, makeMessage(cnslFlnm, REQUIRED_FIELD));		//상담사명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,eml, REQUIRED_FIELD, makeMessage(eml, REQUIRED_FIELD));		//이메일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bacntBankCd, REQUIRED_SELECT_FIELD, makeMessage(bacntBankCd, REQUIRED_SELECT_FIELD));		//계좌은행
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,actno, REQUIRED_FIELD, makeMessage(actno, REQUIRED_FIELD));		//계좌번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dpstr, REQUIRED_FIELD, makeMessage(dpstr, REQUIRED_FIELD));		//예금주
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,excvMthdCd, REQUIRED_SELECT_FIELD, makeMessage(excvMthdCd, REQUIRED_SELECT_FIELD));		//발굴방법기타
		
		//발굴방법(기타)일때 기타(입력값) 필수
		if("42006".equals(command.getExcvMthdCd())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,excvMthdEtc, REQUIRED_SELECT_FIELD, makeMessage(excvMthdEtc, REQUIRED_SELECT_FIELD));		//발굴방법기타
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstCnslYmd, REQUIRED_FIELD, makeMessage(frstCnslYmd, REQUIRED_FIELD));		//최초상담일
		
		
		if(!PatternUtil.isDateHyphen(command.getFrstCnslYmd())) {
			errors.reject("exts.item.koreahana.eml.nDate", getMessage("exts.item.koreahana.eml.nDate"));
		}
		//김영진 
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,frstCnslYmd, INVALID_DATE_FIELD,makeMessage(frstCnslYmd,INVALID_DATE_FIELD)); //최초상담일
		
	}

}
