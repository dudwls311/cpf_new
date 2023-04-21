package exts.koreahana.lnb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumLnbType;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;

/**
 * @Class Name : KoreahanaLnbValidator.java
 * @Description : 학습지지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaLnbValidator")
public class KoreahanaLnbValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String eduSprtTrprRelCd = "eduSprtTrprRelCd";		//교육지원대상자관계코드
	private static final String eduSprtTrprRelDtl = "eduSprtTrprRelDtl";		//교육지원대상자관계상세
	private static final String hshldrFlnm = "hshldrFlnm";		//세대주명
	private static final String rcoblYn = "rcoblYn";		//기초생활수급자여부
	private static final String rcoblSgntFileSn = "rcoblSgntFileSn";		//기초생활수급자인증서파일일련번호
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	private static final String prtcrSgntFileSn = "prtcrSgntFileSn";		//보호자서명파일일련번호
	private static final String prtcrSgntrFlnm = "prtcrSgntrFlnm";		//보호자서명이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.lnb";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaLnbVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaLnbVO command = (KoreahanaLnbVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
		
			if(KoreahanaEnumLnbType.NTK.getCode().equals(command.getAplcntType())) {
				//탈북민
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelCd, REQUIRED_SELECT_FIELD, makeMessage(eduSprtTrprRelCd, REQUIRED_SELECT_FIELD));//교육지원대상자관계코드
			}else if(KoreahanaEnumLnbType.NOR.getCode().equals(command.getAplcntType())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelDtl, REQUIRED_FIELD, makeMessage(eduSprtTrprRelDtl, REQUIRED_FIELD));			//교육지원대상자관계상세
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,hshldrFlnm, REQUIRED_FIELD, makeMessage(hshldrFlnm, REQUIRED_FIELD));								//세대주명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_SELECT_FIELD, makeMessage(rcoblYn, REQUIRED_SELECT_FIELD));						//기초생활수급자여부
			if("Y".equals(command.getRcoblYn())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_SELECT_FIELD));	//기초생활수급자인증서파일일련번호
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));				//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));								//서명자이름
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(prtcrSgntFileSn, REQUIRED_SELECT_FIELD));		//보호자서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntrFlnm, REQUIRED_FIELD, makeMessage(prtcrSgntrFlnm, REQUIRED_FIELD));						//보호자서명이름
			
			if(command.getLnbPrcList()  == null || command.getLnbPrcList().size() < 1) {
				errors.reject("exts.item.koreahana.lnb.notExistLnbSprtInfo", getMessage("exts.item.koreahana.lnb.notExistLnbSprtInfo"));
			}
			/*
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelCd, REQUIRED_FIELD, makeMessage(eduSprtTrprRelCd, REQUIRED_FIELD));		//교육지원대상자관계코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelDtl, REQUIRED_FIELD, makeMessage(eduSprtTrprRelDtl, REQUIRED_FIELD));		//교육지원대상자관계상세
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,hshldrFlnm, REQUIRED_FIELD, makeMessage(hshldrFlnm, REQUIRED_FIELD));		//세대주명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_FIELD, makeMessage(rcoblYn, REQUIRED_FIELD));		//기초생활수급자여부
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_FIELD));		//기초생활수급자인증서파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_FIELD, makeMessage(sgntFileSn, REQUIRED_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntFileSn, REQUIRED_FIELD, makeMessage(prtcrSgntFileSn, REQUIRED_FIELD));		//보호자서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntrFlnm, REQUIRED_FIELD, makeMessage(prtcrSgntrFlnm, REQUIRED_FIELD));		//보호자서명이름
			*/
		}
		
	}

}
