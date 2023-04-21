package exts.koreahana.mdl.validator;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.com.vo.ComCodeVO;
import exts.koreahana.mdl.vo.KoreahanaMdlVO;

/**
 * @Class Name : KoreahanaMdlValidator.java
 * @Description : 의료비지원 엑셀 업로드 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.21
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaMdlExcelValidator")
public class KoreahanaMdlExcelValidator extends ExtsAbstractValidator implements Validator {
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String mdlcrSprtSn = "mdlcrSprtSn";		//의료비지원일련번호
	private static final String flnm = "flnm";		//성명
	private static final String genderCd = "genderCd";		//성별코드
	private static final String entcnyYm = "entcnyYm";		//입국연월
	private static final String brdtYmd = "brdtYmd";		//생년월일
	private static final String addr = "addr";		//주소
	private static final String telno = "telno";		//전화번호
	private static final String dssSeCd = "dssSeCd";		//질환구분코드
	private static final String curePeriod = "curePeriod";		//치료기간
	private static final String hsptlNm = "hsptlNm";		//병원명
	private static final String sprtAmt = "sprtAmt";		//지원금
	private static final String sprtYmd = "sprtYmd";		//지원일자
	private static final String sprtSeCd = "sprtSeCd";		//지원방식코드
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	private static final String dssNm = "dssNm";		//질병명
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.mdl";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaMdlVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		//코드리스트
		List<ComCodeVO> genderCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.GENDER_CD);
		List<ComCodeVO> dssSeCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.DSS_SE_CD);
		List<ComCodeVO> sprtSeCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SPRT_SE_CD);
		
		final KoreahanaMdlVO command = (KoreahanaMdlVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,mdlcrSprtSn, REQUIRED_FIELD, makeMessage(mdlcrSprtSn, REQUIRED_FIELD));	//의료비지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,genderCd, REQUIRED_FIELD, makeMessage(genderCd, REQUIRED_FIELD));		//성별코드
		if("".equals(comCodeService.getCd(genderCdList, command.getGenderCd())))errors.rejectValue(genderCd, INVALID_CODE_NAME_FIELD, makeMessage(genderCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,entcnyYm, REQUIRED_FIELD, makeMessage(entcnyYm, REQUIRED_FIELD));		//입국연월
		ValidationDateUtil.rejectIfDatePattern(errors, entcnyYm, command.getEntcnyYm()+"-01", makeMessage(entcnyYm, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
		ValidationDateUtil.rejectIfDatePattern(errors, brdtYmd, command.getBrdtYmd(), makeMessage(brdtYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,addr, REQUIRED_FIELD, makeMessage(addr, REQUIRED_FIELD));		//주소
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,telno, REQUIRED_FIELD, makeMessage(telno, REQUIRED_FIELD));		//전화번호
		if(command.getTelno() != null && !PatternUtil.isPhone(command.getTelno()) && !PatternUtil.isTel(command.getTelno()))errors.rejectValue(telno, INVALID_TEL_FIELD, makeMessage(telno, INVALID_TEL_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dssSeCd, REQUIRED_FIELD, makeMessage(dssSeCd, REQUIRED_FIELD));		//질환구분코드
		if("".equals(comCodeService.getCd(dssSeCdList, command.getDssSeCd())))errors.rejectValue(dssSeCd, INVALID_CODE_NAME_FIELD, makeMessage(dssSeCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,curePeriod, REQUIRED_FIELD, makeMessage(curePeriod, REQUIRED_FIELD));		//치료기간
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hsptlNm, REQUIRED_FIELD, makeMessage(hsptlNm, REQUIRED_FIELD));		//병원명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dssNm, REQUIRED_FIELD, makeMessage(dssNm, REQUIRED_FIELD));		//질병명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtAmt, REQUIRED_FIELD, makeMessage(sprtAmt, REQUIRED_FIELD));		//지원금
		if(command.getSprtAmt() != null && !PatternUtil.isNumber(command.getSprtAmt()))errors.rejectValue(sprtAmt, INVALID_NUMBER_FIELD, makeMessage(sprtAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtYmd, REQUIRED_FIELD, makeMessage(sprtYmd, REQUIRED_FIELD));		//지원일자
		ValidationDateUtil.rejectIfDatePattern(errors, sprtYmd, command.getSprtYmd(), makeMessage(sprtYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSeCd, REQUIRED_FIELD, makeMessage(sprtSeCd, REQUIRED_FIELD));		//지원방식코드
		if("".equals(comCodeService.getCd(sprtSeCdList, command.getSprtSeCd())))errors.rejectValue(sprtSeCd, INVALID_CODE_NAME_FIELD, makeMessage(sprtSeCd,INVALID_CODE_NAME_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
