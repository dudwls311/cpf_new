package exts.koreahana.spf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import exts.koreahana.spf.vo.KoreahanaSpfVO;

/**
 * @Class Name : KoreahanaSpfValidator.java
 * @Description : 정착지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSpfValidator")
public class KoreahanaSpfValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String photoFileSn = "photoFileSn";		//사진파일일련번호
	private static final String ordpNm = "ordpNm";		//소속
	private static final String crtfctRcvZip = "crtfctRcvZip";		//자격증수령우편번호
	private static final String crtfctRcvAddr = "crtfctRcvAddr";		//자격증수령주소
	private static final String crtfctRcvDaddr = "crtfctRcvDaddr";		//자격증수령상세주소
	private static final String eml = "eml";		//이메일주소
	private static final String lastAcbgCd = "lastAcbgCd";		//최종학력코드
	private static final String lastAcbgEtc = "lastAcbgEtc";		//최종학력기타
	private static final String ocptInstTypeCd = "ocptInstTypeCd";		//종사기관유형코드
	private static final String ocptInstTypeEtc = "ocptInstTypeEtc";		//종사기관유형기타
	private static final String ptexp = "ptexp";		//실무경력
	private static final String aplyMtv = "aplyMtv";		//신청동기
	private static final String eduFnshYmd = "eduFnshYmd";		//고급교육수료연월일
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spf";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSpfVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSpfVO command = (KoreahanaSpfVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
		
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));					//지원일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,photoFileSn, REQUIRED_SELECT_FIELD, makeMessage(photoFileSn, REQUIRED_SELECT_FIELD));			//사진파일일련번호
			
			if(KoreahanaEnumBizSeCd.QLF.getCode().equals(command.getBizSeCd())) {		//자격시험의 경우
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctRcvZip, REQUIRED_FIELD, makeMessage(crtfctRcvZip, REQUIRED_FIELD));		//자격증수령우편번호
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctRcvAddr, REQUIRED_FIELD, makeMessage(crtfctRcvAddr, REQUIRED_FIELD));	//자격증수령주소
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,crtfctRcvDaddr, REQUIRED_FIELD, makeMessage(crtfctRcvDaddr, REQUIRED_FIELD));	//자격증수령상세주소
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ordpNm, REQUIRED_FIELD, makeMessage(ordpNm, REQUIRED_FIELD));					//소속
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,eml, REQUIRED_FIELD, makeMessage(eml, REQUIRED_FIELD));						//이메일주소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,lastAcbgCd, REQUIRED_SELECT_FIELD, makeMessage(lastAcbgCd, REQUIRED_SELECT_FIELD));			//최종학력코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ocptInstTypeCd, REQUIRED_SELECT_FIELD, makeMessage(ocptInstTypeCd, REQUIRED_SELECT_FIELD));	//종사기관유형코드
			if(!KoreahanaEnumBizSeCd.QLF.getCode().equals(command.getBizSeCd())) {		//자격시험이 아닌 경우
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplyMtv, REQUIRED_FIELD, makeMessage(aplyMtv, REQUIRED_FIELD));				//신청동기
				if(command.getAplyMtv().length() < 300) errors.reject("exts.item.koreahana.spr.str300LengthRequired", getMessage("exts.item.koreahana.spr.str300LengthRequired"));
			}
			
			if(KoreahanaEnumBizSeCd.INT.getCode().equals(command.getBizSeCd())
				|| KoreahanaEnumBizSeCd.HIG.getCode().equals(command.getBizSeCd())
				|| KoreahanaEnumBizSeCd.PRA.getCode().equals(command.getBizSeCd())
				|| KoreahanaEnumBizSeCd.QLF.getCode().equals(command.getBizSeCd())) {
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduFnshYmd, REQUIRED_FIELD, makeMessage(eduFnshYmd, REQUIRED_FIELD));			//수료연월일
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
		}
	}

	public static void main(String[] args) {
		String a = "안녕하세요. ㅎㅎ";
		System.out.println(a.length());
	}
}
