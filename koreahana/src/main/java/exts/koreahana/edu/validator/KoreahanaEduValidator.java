package exts.koreahana.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.edu.vo.KoreahanaEduVO;

/**
 * @Class Name : KoreahanaEduValidator.java
 * @Description : 교육지원금 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEduValidator")
public class KoreahanaEduValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String shclNm = "shclNm";		//학교명
	private static final String schlZip = "schlZip";		//학교우편번호
	private static final String schlAddr = "schlAddr";		//학교주소
	private static final String schlDaddr = "schlDaddr";		//학교상세주소
	private static final String rprsvFlnm = "rprsvFlnm";		//대표자성명
	private static final String schlacCnt = "schlacCnt";		//취학자수
	private static final String asstBizTotAmt = "asstBizTotAmt";		//보조사업비총액
	private static final String asstBizAsstAmt = "asstBizAsstAmt";		//보조사업비보조액
	private static final String asstBizBrdmAmt = "asstBizBrdmAmt";		//보조사업비부담액
	private static final String bacntBankCd = "bacntBankCd";		//계좌은행코드
	private static final String actno = "actno";		//계좌번호
	private static final String dpstr = "dpstr";		//예금주
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.edu";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEduVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaEduVO command = (KoreahanaEduVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,shclNm, REQUIRED_FIELD, makeMessage(shclNm, REQUIRED_FIELD));		//학교명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlZip, REQUIRED_FIELD, makeMessage(schlZip, REQUIRED_FIELD));		//학교우편번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlAddr, REQUIRED_FIELD, makeMessage(schlAddr, REQUIRED_FIELD));		//학교주소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlDaddr, REQUIRED_FIELD, makeMessage(schlDaddr, REQUIRED_FIELD));		//학교상세주소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rprsvFlnm, REQUIRED_FIELD, makeMessage(rprsvFlnm, REQUIRED_FIELD));		//대표자성명
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors,schlacCnt, REQUIRED_FIELD, makeMessage(schlacCnt, REQUIRED_FIELD));		//취학자수
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,asstBizTotAmt, REQUIRED_FIELD, makeMessage(asstBizTotAmt, REQUIRED_FIELD));		//보조사업비총액
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,asstBizAsstAmt, REQUIRED_FIELD, makeMessage(asstBizAsstAmt, REQUIRED_FIELD));		//보조사업비보조액
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,asstBizBrdmAmt, REQUIRED_FIELD, makeMessage(asstBizBrdmAmt, REQUIRED_FIELD));		//보조사업비부담액
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,bacntBankCd, REQUIRED_FIELD, makeMessage(bacntBankCd, REQUIRED_FIELD));		//계좌은행코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,actno, REQUIRED_FIELD, makeMessage(actno, REQUIRED_FIELD));		//계좌번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,dpstr, REQUIRED_FIELD, makeMessage(dpstr, REQUIRED_FIELD));		//예금주
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_FIELD, makeMessage(sgntFileSn, REQUIRED_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
		}
		
	}

}
