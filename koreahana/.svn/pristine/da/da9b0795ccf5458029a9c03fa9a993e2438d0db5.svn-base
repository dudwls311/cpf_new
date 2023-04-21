package exts.koreahana.frm.validator;

import java.util.List;

import javax.annotation.Resource;

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
import exts.koreahana.frm.vo.KoreahanaFrmVO;

/**
 * @Class Name : KoreahanaFrmValidator.java
 * @Description : 영농정착지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaFrmExcelValidator")
public class KoreahanaFrmExcelValidator extends ExtsAbstractValidator implements Validator {
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String frmSpfstSn = "frmSpfstSn";		//영농정착지원일련번호
	private static final String flnm = "flnm";		//성명
	private static final String genderCd = "genderCd";		//성별코드
	private static final String brdtYmd = "brdtYmd";		//생년월일
	private static final String mbphno = "mbphno";		//휴대폰번호
	private static final String prtdcsYmd = "prtdcsYmd";		//보호결정연월일
	private static final String entcnyYmd = "entcnyYmd";		//입국연월일
	private static final String addr = "addr";		//주소
	private static final String frscpkEdu = "frscpkEdu";		//영성패교육
	private static final String newYn = "newYn";		//신규여부
	private static final String sprtYr = "sprtYr";		//지원연도
	private static final String sprtCycl = "sprtCycl";		//지원차수
	private static final String sprtDcsnAmt = "sprtDcsnAmt";		//지원결정액
	private static final String sprtAmt = "sprtAmt";		//지원금액
	private static final String prchsBzenty = "prchsBzenty";		//구매업체
	private static final String prchsItem = "prchsItem";		//구매품목
	private static final String rmrk = "rmrk";		//비고
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.frm";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaFrmVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		List<ComCodeVO> genderCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.GENDER_CD);
		
		final KoreahanaFrmVO command = (KoreahanaFrmVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,frmSpfstSn, REQUIRED_FIELD, makeMessage(frmSpfstSn, REQUIRED_FIELD));	//영농정착지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,genderCd, REQUIRED_FIELD, makeMessage(genderCd, REQUIRED_FIELD));		//성별코드
		if("".equals(comCodeService.getCd(genderCdList, command.getGenderCd())))errors.rejectValue(genderCd, INVALID_CODE_NAME_FIELD, makeMessage(genderCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
		ValidationDateUtil.rejectIfDatePattern(errors, brdtYmd, command.getBrdtYmd(), makeMessage(brdtYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
		if(command.getMbphno() != null && !PatternUtil.isPhone(command.getMbphno()) )errors.rejectValue(mbphno, INVALID_TEL_FIELD, makeMessage(mbphno, INVALID_TEL_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtdcsYmd, REQUIRED_FIELD, makeMessage(prtdcsYmd, REQUIRED_FIELD));		//보호결정연월일
		if(command.getPrtdcsYmd() != null)ValidationDateUtil.rejectIfDatePattern(errors, prtdcsYmd, command.getPrtdcsYmd(), makeMessage(prtdcsYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,entcnyYmd, REQUIRED_FIELD, makeMessage(entcnyYmd, REQUIRED_FIELD));		//입국연월일
		ValidationDateUtil.rejectIfDatePattern(errors, entcnyYmd, command.getEntcnyYmd(), makeMessage(entcnyYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,addr, REQUIRED_FIELD, makeMessage(addr, REQUIRED_FIELD));		//주소
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frscpkEdu, REQUIRED_FIELD, makeMessage(frscpkEdu, REQUIRED_FIELD));		//영성패교육
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,newYn, REQUIRED_FIELD, makeMessage(newYn, REQUIRED_FIELD));		//신규여부
		if(!"신규".equals(command.getNewYn()) && !"기존".equals(command.getNewYn()))errors.rejectValue(newYn, "exts.error.koreahana.frm.notmatch.newYn");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtYr, REQUIRED_FIELD, makeMessage(sprtYr, REQUIRED_FIELD));		//지원연도
		if(command.getSprtYr() != null && (command.getSprtYr().length() != 4 || !PatternUtil.isNumber(command.getSprtYr())))errors.rejectValue(sprtYr, INVALID_NUMBER_FIELD, makeMessage(sprtYr, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtCycl, REQUIRED_FIELD, makeMessage(sprtCycl, REQUIRED_FIELD));		//지원차수
		if(command.getSprtCycl() != null && !PatternUtil.isNumber(command.getSprtCycl()))errors.rejectValue(sprtCycl, INVALID_NUMBER_FIELD, makeMessage(sprtCycl, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtDcsnAmt, REQUIRED_FIELD, makeMessage(sprtDcsnAmt, REQUIRED_FIELD));		//지원결정액
		if(command.getSprtDcsnAmt() != null && !PatternUtil.isNumber(command.getSprtDcsnAmt()))errors.rejectValue(sprtDcsnAmt, INVALID_NUMBER_FIELD, makeMessage(sprtDcsnAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtAmt, REQUIRED_FIELD, makeMessage(sprtAmt, REQUIRED_FIELD));		//지원금액
		if(command.getSprtAmt() != null && !PatternUtil.isNumber(command.getSprtAmt()))errors.rejectValue(sprtAmt, INVALID_NUMBER_FIELD, makeMessage(sprtAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prchsBzenty, REQUIRED_FIELD, makeMessage(prchsBzenty, REQUIRED_FIELD));		//구매업체
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prchsItem, REQUIRED_FIELD, makeMessage(prchsItem, REQUIRED_FIELD));		//구매품목
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
