package exts.koreahana.sho.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.sho.vo.KoreahanaShoVO;

/**
 * @Class Name : KoreahanaShoValidator.java
 * @Description : 장학금지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaShoValidator")
public class KoreahanaShoValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String ntkrdfOptrCd = "ntkrdfOptrCd";		//북한이탈주민부모코드
	private static final String ntkrdfHanawonTh = "ntkrdfHanawonTh";		//북한이탈주민부모하나원기수
	private static final String ntkrdfOptrEntryYr = "ntkrdfOptrEntryYr";		//북한이탈주민부모입국년도
	private static final String ntkrdfAcrtfctFileSn = "ntkrdfAcrtfctFileSn";		//북한이탈주민인증서파일일련번호
	private static final String sholSlctnType = "sholSlctnType";		//장학금선발유형
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.sho";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaShoVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaShoVO command = (KoreahanaShoVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {	
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
			
			if(command.isNormal()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOptrCd, REQUIRED_SELECT_FIELD, makeMessage(ntkrdfOptrCd, REQUIRED_SELECT_FIELD));		//북한이탈주민부모코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfHanawonTh, REQUIRED_FIELD, makeMessage(ntkrdfHanawonTh, REQUIRED_FIELD));		//북한이탈주민부모하나원기수
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOptrEntryYr, REQUIRED_FIELD, makeMessage(ntkrdfOptrEntryYr, REQUIRED_FIELD));		//북한이탈주민부모입국년도
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD, makeMessage(ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD));		//북한이탈주민인증서파일일련번호
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sholSlctnType, REQUIRED_SELECT_FIELD, makeMessage(sholSlctnType, REQUIRED_SELECT_FIELD));		//장학금선발유형
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
		}
		
	}

}
