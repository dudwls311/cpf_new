package exts.koreahana.eml.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.eml.vo.KoreahanaEmlPrcVO;

/**
 * @Class Name : KoreahanaEmlPrcValidator.java
 * @Description : 긴급생계비지원현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmlPrcValidator")
public class KoreahanaEmlPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String emlvexSprtPrcnMngSn = "emlvexSprtPrcnMngSn";		//긴급생계비지원현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String sprtNmtm = "sprtNmtm";		//지원횟수
	private static final String sprtAmt = "sprtAmt";		//지원금액
	private static final String emrgSprtSpdmYn = "emrgSprtSpdmYn";		//긴급지원수급여부
	private static final String emrgSprtSpdmRsn = "emrgSprtSpdmRsn";		//긴급지원수급사유(유)
	private static final String emrgSprtSpdmNRsn = "emrgSprtSpdmNRsn";		//긴급지원수급사유(무)
	private static final String cycl = "cycl";		//차수
	private static final String aplyAmt = "aplyAmt";		//신청금액
	private static final String aplyMainCn = "aplyMainCn";		//신청주요내용
	private static final String mainCrssRsn = "mainCrssRsn";		//주요위기사유
	private static final String dsbltyYn = "dsbltyYn";		//장애여부
	private static final String earnCd = "earnCd";		//소득코드
	private static final String mbohhCntCd = "mbohhCntCd";		//가구원수코드
	private static final String dwngShapeCd = "dwngShapeCd";		//주거형태코드
	private static final String utblNpmntCd = "utblNpmntCd";		//공과금체납코드
	private static final String crssCd = "crssCd";		//위기코드
	private static final String totScr = "totScr";		//총점수
	private static final String giveYmd = "giveYmd";		//지급연월일
	private static final String giveAmt = "giveAmt";		//지급금액
	private static final String rmrk = "rmrk";		//비고
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.eml";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmlPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEmlPrcVO command = (KoreahanaEmlPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,emlvexSprtPrcnMngSn, REQUIRED_FIELD, makeMessage(emlvexSprtPrcnMngSn, REQUIRED_FIELD));	//긴급생계비지원현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtNmtm, REQUIRED_FIELD, makeMessage(sprtNmtm, REQUIRED_FIELD));		//지원횟수
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtAmt, REQUIRED_FIELD, makeMessage(sprtAmt, REQUIRED_FIELD));		//지원금액
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,emrgSprtSpdmYn, REQUIRED_FIELD, makeMessage(emrgSprtSpdmYn, REQUIRED_FIELD));		//긴급지원수급여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,emrgSprtSpdmRsn, REQUIRED_FIELD, makeMessage(emrgSprtSpdmRsn, REQUIRED_FIELD));		//긴급지원수급사유(유)
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,emrgSprtSpdmNRsn, REQUIRED_FIELD, makeMessage(emrgSprtSpdmNRsn, REQUIRED_FIELD));		//긴급지원수급사유(무)
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cycl, REQUIRED_FIELD, makeMessage(cycl, REQUIRED_FIELD));		//차수
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplyAmt, REQUIRED_FIELD, makeMessage(aplyAmt, REQUIRED_FIELD));		//신청금액
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplyMainCn, REQUIRED_FIELD, makeMessage(aplyMainCn, REQUIRED_FIELD));		//신청주요내용
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mainCrssRsn, REQUIRED_FIELD, makeMessage(mainCrssRsn, REQUIRED_FIELD));		//주요위기사유
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dsbltyYn, REQUIRED_FIELD, makeMessage(dsbltyYn, REQUIRED_FIELD));		//장애여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,earnCd, REQUIRED_FIELD, makeMessage(earnCd, REQUIRED_FIELD));		//소득코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbohhCntCd, REQUIRED_FIELD, makeMessage(mbohhCntCd, REQUIRED_FIELD));		//가구원수코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dwngShapeCd, REQUIRED_FIELD, makeMessage(dwngShapeCd, REQUIRED_FIELD));		//주거형태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,utblNpmntCd, REQUIRED_FIELD, makeMessage(utblNpmntCd, REQUIRED_FIELD));		//공과금체납코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crssCd, REQUIRED_FIELD, makeMessage(crssCd, REQUIRED_FIELD));		//위기코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,totScr, REQUIRED_FIELD, makeMessage(totScr, REQUIRED_FIELD));		//총점수
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveYmd, REQUIRED_FIELD, makeMessage(giveYmd, REQUIRED_FIELD));		//지급연월일
		if(!"".equals(NullUtil.nullString(command.getGiveYmd())))ValidationDateUtil.rejectIfDatePattern(errors, giveYmd, command.getGiveYmd(), makeMessage(giveYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveAmt, REQUIRED_FIELD, makeMessage(giveAmt, REQUIRED_FIELD));		//지급금액
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
		
	}

}
