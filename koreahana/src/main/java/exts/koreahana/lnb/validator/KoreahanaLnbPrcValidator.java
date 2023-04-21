package exts.koreahana.lnb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumBrplcCd;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;

/**
 * @Class Name : KoreahanaLnbPrcValidator.java
 * @Description : 학습지지원기본정보 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaLnbPrcValidator")
public class KoreahanaLnbPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String lnbkSprtBscInfoSn = "lnbkSprtBscInfoSn";		//학습지지원기본정보일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String rnkg = "rnkg";		//순위
	private static final String flnm = "flnm";		//성명
	private static final String brdtYmd = "brdtYmd";		//생년월일
	private static final String brplcCd = "brplcCd";		//출생지코드
	private static final String hanawonTh = "hanawonTh";		//하나원기수
	private static final String entcnyYr = "entcnyYr";		//입국연도
	private static final String ntkrdfOprtSe = "ntkrdfOprtSe";		//북한이탈주민부모여부
	private static final String ntkrdfOprtFlnm = "ntkrdfOprtFlnm";		//북한이탈주민부모성명
	private static final String ntkrdfOprtHanawonTh = "ntkrdfOprtHanawonTh";		//북한이탈주민부모하나원기수
	private static final String ntkrdfOprtEnctnyYr = "ntkrdfOprtEnctnyYr";		//북한이타주민부모입국년도
	private static final String ntkrdfAcrtfctFileSn = "ntkrdfAcrtfctFileSn";		//북한이탈주민인증서파일일련번호
	private static final String existBnfCd = "existBnfCd";		//기존수혜여부코드
	private static final String sprtTrgtYn = "sprtTrgtYn";		//지원대상여부
	private static final String vdoengDpcnTrgtYn = "vdoengDpcnTrgtYn";		//화상영어중복대상여부
	private static final String mdwGbkhmYmd = "mdwGbkhmYmd";		//중도퇴가연월일
	private static final String gbkhmRsn = "gbkhmRsn";		//퇴가사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.lnb";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaLnbPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaLnbPrcVO command = (KoreahanaLnbPrcVO) obj;
		
		if(command.getLnbPrcList() != null) {
			for(KoreahanaLnbPrcVO vo:command.getLnbPrcList()) {
				if("".equals(NullUtil.nullString(vo.getLnbkSprtBscInfoSn())))errors.rejectValue(lnbkSprtBscInfoSn, REQUIRED_FIELD, makeMessage(lnbkSprtBscInfoSn, REQUIRED_FIELD));
				if("".equals(NullUtil.nullString(vo.getRnkg())) || !PatternUtil.isNumber(vo.getRnkg()))errors.rejectValue(rnkg, INVALID_NUMBER_FIELD, makeMessage(rnkg, INVALID_NUMBER_FIELD));
				if(!"".equals(NullUtil.nullString(vo.getMdwGbkhmYmd())))ValidationDateUtil.rejectIfDatePattern(errors, mdwGbkhmYmd, vo.getMdwGbkhmYmd(), makeMessage(mdwGbkhmYmd, INVALID_DATE_FIELD));
			}
		}
		/*
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,lnbkSprtBscInfoSn, REQUIRED_FIELD, makeMessage(lnbkSprtBscInfoSn, REQUIRED_FIELD));	//학습지지원기본정보일련번호
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors,rnkg, REQUIRED_FIELD, makeMessage(rnkg, REQUIRED_FIELD));		//순위
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brplcCd, REQUIRED_FIELD, makeMessage(brplcCd, REQUIRED_FIELD));		//출생지코드
		if(KoreahanaEnumBrplcCd.NOR.getCode().equals(command.getBrplcCd())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanawonTh, REQUIRED_FIELD, makeMessage(hanawonTh, REQUIRED_FIELD));		//하나원기수
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,entcnyYr, REQUIRED_FIELD, makeMessage(entcnyYr, REQUIRED_FIELD));		//입국연도
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfAcrtfctFileSn, REQUIRED_FIELD, makeMessage(ntkrdfAcrtfctFileSn, REQUIRED_FIELD));		//북한이탈주민인증서파일일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,existBnfCd, REQUIRED_FIELD, makeMessage(existBnfCd, REQUIRED_FIELD));		//기존수혜여부코드
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOprtSe, REQUIRED_FIELD, makeMessage(ntkrdfOprtSe, REQUIRED_FIELD));		//북한이탈주민부모여부
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOprtFlnm, REQUIRED_FIELD, makeMessage(ntkrdfOprtFlnm, REQUIRED_FIELD));		//북한이탈주민부모성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOprtHanawonTh, REQUIRED_FIELD, makeMessage(ntkrdfOprtHanawonTh, REQUIRED_FIELD));		//북한이탈주민부모하나원기수
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfOprtEnctnyYr, REQUIRED_FIELD, makeMessage(ntkrdfOprtEnctnyYr, REQUIRED_FIELD));		//북한이타주민부모입국년도
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtTrgtYn, REQUIRED_FIELD, makeMessage(sprtTrgtYn, REQUIRED_FIELD));		//지원대상여부
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,vdoengDpcnTrgtYn, REQUIRED_FIELD, makeMessage(vdoengDpcnTrgtYn, REQUIRED_FIELD));		//화상영어중복대상여부
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mdwGbkhmYmd, REQUIRED_FIELD, makeMessage(mdwGbkhmYmd, REQUIRED_FIELD));		//중도퇴가연월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,gbkhmRsn, REQUIRED_FIELD, makeMessage(gbkhmRsn, REQUIRED_FIELD));		//퇴가사유
		*/
		
	}

}
