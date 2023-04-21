package exts.koreahana.fth.validator;

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
import exts.koreahana.fth.vo.KoreahanaFthMdwVO;

/**
 * @Class Name : KoreahanaFthMdwExcelValidator.java
 * @Description : 미래행복통장중도해지 Excel Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaFthMdwExcelValidator")
public class KoreahanaFthMdwExcelValidator extends ExtsAbstractValidator implements Validator {

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String fthpbbMdwCncltnSn = "fthpbbMdwCncltnSn";		//미래행복통장중도해지일련번호
	private static final String flnm = "flnm";		//성명
	private static final String rrno = "rrno";		//주민등록번호
	private static final String mbphno = "mbphno";		//휴대폰번호
	private static final String ctpvCd = "ctpvCd";		//시도코드
	private static final String sggCd = "sggCd";		//시군구코드
	private static final String rcptYmd = "rcptYmd";		//접수연월일
	private static final String cncltnYmd = "cncltnYmd";		//해지연월일
	private static final String jrdcHanactNm = "jrdcHanactNm";		//관할하나센터
	private static final String hanactPic = "hanactPic";		//하나센터담당자
	private static final String bbJoinYmd = "bbJoinYmd";		//통장가입연월일
	private static final String joinPeriodMmCnt = "joinPeriodMmCnt";		//가입기간개월수
	private static final String cncltnRsnCd = "cncltnRsnCd";		//해지사유코드
	private static final String idtprsSavingAmt = "idtprsSavingAmt";		//본인적립금
	private static final String fndtSavingAmt = "fndtSavingAmt";		//재단적립금
	private static final String idtprsSavingAmtActno = "idtprsSavingAmtActno";		//본인적립금계좌번호
	private static final String stmchkActno = "stmchkActno";		//정부지원금계좌번호
	private static final String rmrk = "rmrk";		//비고
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.fthMdw";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaFthMdwVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {
		List<ComCodeVO> cncltnRsnCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CNCLTN_RSN_CD);
		List<ComCodeVO> ctpvCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CTPV_CD);
		List<ComCodeVO> sggCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SGG_CD);

		final KoreahanaFthMdwVO command = (KoreahanaFthMdwVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,fthpbbMdwCncltnSn, REQUIRED_FIELD, makeMessage(fthpbbMdwCncltnSn, REQUIRED_FIELD));	//미래행복통장중도해지일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcptYmd, REQUIRED_FIELD, makeMessage(rcptYmd, REQUIRED_FIELD));		//접수연월일
		ValidationDateUtil.rejectIfDatePattern(errors, rcptYmd, command.getRcptYmd(), makeMessage(rcptYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cncltnYmd, REQUIRED_FIELD, makeMessage(cncltnYmd, REQUIRED_FIELD));		//해지연월일
		ValidationDateUtil.rejectIfDatePattern(errors, cncltnYmd, command.getCncltnYmd(), makeMessage(cncltnYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rrno, REQUIRED_FIELD, makeMessage(rrno, REQUIRED_FIELD));		//주민등록번호
		if(command.getRrno() != null && !PatternUtil.isRrno(command.getRrno()))errors.rejectValue(rrno, INVALID_RRNO_FIELD, makeMessage(rrno, INVALID_RRNO_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
		if(command.getMbphno() != null && !PatternUtil.isPhone(command.getMbphno()))errors.rejectValue(mbphno, INVALID_PHONE_FIELD, makeMessage(mbphno, INVALID_PHONE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,ctpvCd, REQUIRED_FIELD, makeMessage(ctpvCd, REQUIRED_FIELD));		//시도코드
		if("".equals(comCodeService.getCd(ctpvCdList, command.getCtpvCd())))errors.rejectValue(ctpvCd, INVALID_CODE_NAME_FIELD, makeMessage(ctpvCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sggCd, REQUIRED_FIELD, makeMessage(sggCd, REQUIRED_FIELD));		//시군구코드
		if("".equals(comCodeService.getCd(sggCdList, command.getSggCd())))errors.rejectValue(sggCd, INVALID_CODE_NAME_FIELD, makeMessage(sggCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,jrdcHanactNm, REQUIRED_FIELD, makeMessage(jrdcHanactNm, REQUIRED_FIELD));		//관할하나센터
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hanactPic, REQUIRED_FIELD, makeMessage(hanactPic, REQUIRED_FIELD));		//하나센터담당자
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bbJoinYmd, REQUIRED_FIELD, makeMessage(bbJoinYmd, REQUIRED_FIELD));		//통장가입연월일
		ValidationDateUtil.rejectIfDatePattern(errors, bbJoinYmd, command.getBbJoinYmd(), makeMessage(bbJoinYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,joinPeriodMmCnt, REQUIRED_FIELD, makeMessage(joinPeriodMmCnt, REQUIRED_FIELD));		//가입기간개월수
		if(command.getJoinPeriodMmCnt() != null && !PatternUtil.isNumber(command.getJoinPeriodMmCnt()))errors.rejectValue(joinPeriodMmCnt, INVALID_NUMBER_FIELD, makeMessage(joinPeriodMmCnt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cncltnRsnCd, REQUIRED_FIELD, makeMessage(cncltnRsnCd, REQUIRED_FIELD));		//해지사유코드
		if("".equals(comCodeService.getCd(cncltnRsnCdList, command.getCncltnRsnCd())))errors.rejectValue(cncltnRsnCd, INVALID_CODE_NAME_FIELD, makeMessage(cncltnRsnCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,idtprsSavingAmt, REQUIRED_FIELD, makeMessage(idtprsSavingAmt, REQUIRED_FIELD));		//본인적립금
		if(command.getIdtprsSavingAmt() != null && !PatternUtil.isNumber(command.getIdtprsSavingAmt()))errors.rejectValue(idtprsSavingAmt, INVALID_NUMBER_FIELD, makeMessage(idtprsSavingAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,fndtSavingAmt, REQUIRED_FIELD, makeMessage(fndtSavingAmt, REQUIRED_FIELD));		//재단적립금
		if(command.getFndtSavingAmt() != null && !PatternUtil.isNumber(command.getFndtSavingAmt()))errors.rejectValue(fndtSavingAmt, INVALID_NUMBER_FIELD, makeMessage(fndtSavingAmt, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,idtprsSavingAmtActno, REQUIRED_FIELD, makeMessage(idtprsSavingAmtActno, REQUIRED_FIELD));		//본인적립금계좌번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,stmchkActno, REQUIRED_FIELD, makeMessage(stmchkActno, REQUIRED_FIELD));		//정부지원금계좌번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
