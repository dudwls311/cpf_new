package exts.koreahana.fth.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.fth.vo.KoreahanaFthNewVO;

/**
 * @Class Name : KoreahanaFthValidator.java
 * @Description : 미래행복통장신규신청 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaFthNewValidator")
public class KoreahanaFthNewValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String fthpbbNewAplySn = "fthpbbNewAplySn";		//미래행복통장신규신청일련번호
	private static final String flnm = "flnm";		//성명
	private static final String genderCd = "genderCd";		//성별코드
	private static final String rrno = "rrno";		//주민등록번호
	private static final String ageCd = "ageCd";		//연령대코드
	private static final String mbphno = "mbphno";		//휴대폰번호
	private static final String ctpvCd = "ctpvCd";		//시도코드
	private static final String sggCd = "sggCd";		//시군구코드
	private static final String ecnmatCd = "ecnmatCd";		//경제활동코드
	private static final String crCd = "crCd";		//직업군코드
	private static final String coNm = "coNm";		//회사명
	private static final String emplisJoinYmd = "emplisJoinYmd";		//고용보험가입연월일
	private static final String salaryAmt = "salaryAmt";		//월급여액
	private static final String entcnyYmd = "entcnyYmd";		//입국연월일
	private static final String entiscYmd = "entiscYmd";		//사회진출연월일
	private static final String trinsExpryYmd = "trinsExpryYmd";		//보험기간만료연월일
	private static final String rcptYmd = "rcptYmd";		//접수연월일
	private static final String jrdcHanactNm = "jrdcHanactNm";		//관할하나센터
	private static final String dcsnSprtAmt = "dcsnSprtAmt";		//결정지원액코드
	private static final String bbJoinYmd = "bbJoinYmd";		//통장가입연월일
	private static final String savingDdlnYmd = "savingDdlnYmd";		//적립마감연월일
	private static final String prtprdExtsnCd = "prtprdExtsnCd";		//보호기간연장코드
	private static final String idtprsSavingAmtActno = "idtprsSavingAmtActno";		//본인적립금계좌번호
	private static final String stmchkActno = "stmchkActno";		//정부지원금계좌번호
	private static final String rmrk = "rmrk";		//비고
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.fthNew";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaFthNewVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {


		final KoreahanaFthNewVO command = (KoreahanaFthNewVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,fthpbbNewAplySn, REQUIRED_FIELD, makeMessage(fthpbbNewAplySn, REQUIRED_FIELD));	//미래행복통장신규신청일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rrno, REQUIRED_FIELD, makeMessage(rrno, REQUIRED_FIELD));		//주민등록번호
		if(command.getRrno() != null && !PatternUtil.isRrno(command.getRrno()))errors.rejectValue(rrno, INVALID_RRNO_FIELD, makeMessage(rrno, INVALID_RRNO_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ageCd, REQUIRED_FIELD, makeMessage(ageCd, REQUIRED_FIELD));		//연령대코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,genderCd, REQUIRED_FIELD, makeMessage(genderCd, REQUIRED_FIELD));		//성별코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
		if(command.getMbphno() != null && !PatternUtil.isPhone(command.getMbphno()))errors.rejectValue(mbphno, INVALID_PHONE_FIELD, makeMessage(mbphno, INVALID_PHONE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ctpvCd, REQUIRED_FIELD, makeMessage(ctpvCd, REQUIRED_FIELD));		//시도코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sggCd, REQUIRED_FIELD, makeMessage(sggCd, REQUIRED_FIELD));		//시군구코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ecnmatCd, REQUIRED_FIELD, makeMessage(ecnmatCd, REQUIRED_FIELD));		//경제활동코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,crCd, REQUIRED_FIELD, makeMessage(crCd, REQUIRED_FIELD));		//직업군코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,coNm, REQUIRED_FIELD, makeMessage(coNm, REQUIRED_FIELD));		//회사명
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,emplisJoinYmd, REQUIRED_FIELD, makeMessage(emplisJoinYmd, REQUIRED_FIELD));		//고용보험가입연월일
		if(!"".equals(NullUtil.nullString(command.getEmplisJoinYmd())))ValidationDateUtil.rejectIfDatePattern(errors, emplisJoinYmd, command.getEmplisJoinYmd(), makeMessage(emplisJoinYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,salaryAmt, REQUIRED_FIELD, makeMessage(salaryAmt, REQUIRED_FIELD));		//월급여액
		if(!"".equals(NullUtil.nullString(command.getSalaryAmt())) && !PatternUtil.isNumber(command.getSalaryAmt()))errors.rejectValue(salaryAmt, INVALID_NUMBER_FIELD, makeMessage(salaryAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,entcnyYmd, REQUIRED_FIELD, makeMessage(entcnyYmd, REQUIRED_FIELD));		//입국연월일
		ValidationDateUtil.rejectIfDatePattern(errors, entcnyYmd, command.getEntcnyYmd(), makeMessage(entcnyYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,entiscYmd, REQUIRED_FIELD, makeMessage(entiscYmd, REQUIRED_FIELD));		//사회진출연월일
		ValidationDateUtil.rejectIfDatePattern(errors, entiscYmd, command.getEntiscYmd(), makeMessage(entiscYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,trinsExpryYmd, REQUIRED_FIELD, makeMessage(trinsExpryYmd, REQUIRED_FIELD));		//보험기간만료연월일
		ValidationDateUtil.rejectIfDatePattern(errors, trinsExpryYmd, command.getTrinsExpryYmd(), makeMessage(trinsExpryYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcptYmd, REQUIRED_FIELD, makeMessage(rcptYmd, REQUIRED_FIELD));		//접수연월일
		ValidationDateUtil.rejectIfDatePattern(errors, rcptYmd, command.getRcptYmd(), makeMessage(rcptYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,jrdcHanactNm, REQUIRED_FIELD, makeMessage(jrdcHanactNm, REQUIRED_FIELD));		//관할하나센터
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dcsnSprtAmt, REQUIRED_FIELD, makeMessage(dcsnSprtAmt, REQUIRED_FIELD));		//결정지원액
		if(command.getDcsnSprtAmt() != null && !PatternUtil.isNumber(command.getDcsnSprtAmt()))errors.rejectValue(dcsnSprtAmt, INVALID_NUMBER_FIELD, makeMessage(dcsnSprtAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bbJoinYmd, REQUIRED_FIELD, makeMessage(bbJoinYmd, REQUIRED_FIELD));		//통장가입연월일
		ValidationDateUtil.rejectIfDatePattern(errors, bbJoinYmd, command.getBbJoinYmd(), makeMessage(bbJoinYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,savingDdlnYmd, REQUIRED_FIELD, makeMessage(savingDdlnYmd, REQUIRED_FIELD));		//적립마감연월일
		ValidationDateUtil.rejectIfDatePattern(errors, savingDdlnYmd, command.getSavingDdlnYmd(), makeMessage(savingDdlnYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtprdExtsnCd, REQUIRED_FIELD, makeMessage(prtprdExtsnCd, REQUIRED_FIELD));		//보호기간연장코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,idtprsSavingAmtActno, REQUIRED_FIELD, makeMessage(idtprsSavingAmtActno, REQUIRED_FIELD));		//본인적립금계좌번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,stmchkActno, REQUIRED_FIELD, makeMessage(stmchkActno, REQUIRED_FIELD));		//정부지원금계좌번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
