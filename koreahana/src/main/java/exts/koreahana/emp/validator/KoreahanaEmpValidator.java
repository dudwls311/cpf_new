package exts.koreahana.emp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import exts.koreahana.emp.vo.KoreahanaEmpVO;

/**
 * @Class Name : KoreahanaEmpValidator.java
 * @Description : 취업연계직업훈련 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmpValidator")
public class KoreahanaEmpValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String lastAcbgSchlNm = "lastAcbgSchlNm";		//최종학력학교명
	private static final String lastAcbgSchlGrdtnCd = "lastAcbgSchlGrdtnCd";		//최종학력졸업여부
	private static final String lastAcbgMjrNm = "lastAcbgMjrNm";		//최종학력전공명
	private static final String empmSttsYn = "empmSttsYn";		//취업상태여부
	private static final String empmWrcNm = "empmWrcNm";		//취업직장명
	private static final String hgvlcYn = "hgvlcYn";		//대형면허여부
	private static final String busDrvngCrtfctYn = "busDrvngCrtfctYn";		//버스운전자격증여부
	private static final String hopeTrpttBzenty = "hopeTrpttBzenty";		//희망운수업체
	private static final String rsnaplc = "rsnaplc";		//지원동기
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emp";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmpVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmpVO command = (KoreahanaEmpVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,lastAcbgSchlNm, REQUIRED_FIELD, makeMessage(lastAcbgSchlNm, REQUIRED_FIELD));		//최종학력학교명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,lastAcbgSchlGrdtnCd, REQUIRED_SELECT_FIELD, makeMessage(lastAcbgSchlGrdtnCd, REQUIRED_SELECT_FIELD));		//최종학력졸업여부
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,lastAcbgMjrNm, REQUIRED_FIELD, makeMessage(lastAcbgMjrNm, REQUIRED_FIELD));		//최종학력전공명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,empmSttsYn, REQUIRED_SELECT_FIELD, makeMessage(empmSttsYn, REQUIRED_SELECT_FIELD));		//취업상태여부
			if("Y".equals(NullUtil.nullString(command.getEmpmSttsYn()))) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,empmWrcNm, REQUIRED_FIELD, makeMessage(empmWrcNm, REQUIRED_FIELD));		//취업직장명
			}
			if(KoreahanaEnumBizSeCd.BUS.getCode().equals(command.getBizSeCd())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,hgvlcYn, REQUIRED_SELECT_FIELD, makeMessage(hgvlcYn, REQUIRED_SELECT_FIELD));		//대형면허여부
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,busDrvngCrtfctYn, REQUIRED_SELECT_FIELD, makeMessage(busDrvngCrtfctYn, REQUIRED_SELECT_FIELD));		//버스운전자격증여부
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,hopeTrpttBzenty, REQUIRED_FIELD, makeMessage(hopeTrpttBzenty, REQUIRED_FIELD));		//희망운수업체
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsnaplc, REQUIRED_FIELD, makeMessage(rsnaplc, REQUIRED_FIELD));		//지원동기
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
		}
		
	}

}
