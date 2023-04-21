package exts.koreahana.mgm.validator;

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
import exts.koreahana.mgm.service.KoreahanaMgmService;
import exts.koreahana.mgm.vo.KoreahanaMgmVO;

/**
 * @Class Name : KoreahanaMgmExcelValidator.java
 * @Description : 경영개선자금지원 Excel Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaMgmExcelValidator")
public class KoreahanaMgmExcelValidator extends ExtsAbstractValidator implements Validator {

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String mgmipvAmtSprtSn = "mgmipvAmtSprtSn";		//경영개선자금지원일련번호
	private static final String flnm = "flnm";		//성명
	private static final String brdtYmd = "brdtYmd";		//생년월일
	private static final String rrnoBknb = "rrnoBknb";		//주민등록번호뒷번호
	private static final String hnwCycl = "hnwCycl";		//하나원기수
	private static final String mbphno = "mbphno";		//휴대폰번호
	private static final String conm = "conm";		//상호명
	private static final String bzstatCd = "bzstatCd";		//업태코드
	private static final String bzstatOsd = "bzstatOsd";		//업태그외
	private static final String tpbizNm = "tpbizNm";		//업종명
	private static final String brno = "brno";		//사업자등록번호
	private static final String bizStartYmd = "bizStartYmd";		//사업개시연월일
	private static final String addr = "addr";		//주소
	private static final String carmdlCd = "carmdlCd";		//차종코드
	private static final String mlg = "mlg";		//주행거리
	private static final String vhclMdyr = "vhclMdyr";		//차량연식
	private static final String rcmtFldCd = "rcmtFldCd";		//모집분야코드
	private static final String sprtYr = "sprtYr";		//지원연도
	private static final String dcsnAmt = "dcsnAmt";		//결정금액
	private static final String prchsDsctn = "prchsDsctn";		//구매내역
	private static final String prchsAmt = "prchsAmt";		//구매금액
	private static final String giveAmt = "giveAmt";		//지급금액
	private static final String giveCycl = "giveCycl";		//지급차수
	private static final String rmrk = "rmrk";		//비고
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.mgm";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaMgmVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		List<ComCodeVO> bzstatCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.BZSTAT_CD);
		List<ComCodeVO> carmdlCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CARMDL_CD);
		List<ComCodeVO> rcmtFldCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.RCMT_FLD_CD);

		final KoreahanaMgmVO command = (KoreahanaMgmVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,mgmipvAmtSprtSn, REQUIRED_FIELD, makeMessage(mgmipvAmtSprtSn, REQUIRED_FIELD));	//경영개선자금지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
		ValidationDateUtil.rejectIfDatePattern(errors, brdtYmd, command.getBrdtYmd(), makeMessage(brdtYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rrnoBknb, REQUIRED_FIELD, makeMessage(rrnoBknb, REQUIRED_FIELD));		//주민등록번호뒷번호
		if(command.getRrnoBknb() != null && (command.getRrnoBknb().length() !=7 || !PatternUtil.isNumber(command.getRrnoBknb())))errors.rejectValue(rrnoBknb, INVALID_NUMBER_FIELD, getMessage("exts.error.koreahana.mgm.wrong.rrnoBknb"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,hnwCycl, REQUIRED_FIELD, makeMessage(hnwCycl, REQUIRED_FIELD));		//하나원기수
		if(command.getHnwCycl() != null && !PatternUtil.isNumber(command.getHnwCycl()))errors.rejectValue(hnwCycl, INVALID_NUMBER_FIELD, makeMessage(hnwCycl, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
		if(command.getMbphno() != null && !PatternUtil.isPhone(command.getMbphno()) )errors.rejectValue(mbphno, INVALID_PHONE_FIELD, makeMessage(mbphno, INVALID_PHONE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,conm, REQUIRED_FIELD, makeMessage(conm, REQUIRED_FIELD));		//상호명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bzstatCd, REQUIRED_FIELD, makeMessage(bzstatCd, REQUIRED_FIELD));		//업태코드
		if("".equals(comCodeService.getCd(bzstatCdList, command.getBzstatCd())))errors.rejectValue(bzstatCd, INVALID_CODE_NAME_FIELD, makeMessage(bzstatCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bzstatOsd, REQUIRED_FIELD, makeMessage(bzstatOsd, REQUIRED_FIELD));		//업태그외
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,tpbizNm, REQUIRED_FIELD, makeMessage(tpbizNm, REQUIRED_FIELD));		//업종명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brno, REQUIRED_FIELD, makeMessage(brno, REQUIRED_FIELD));		//사업자등록번호
		if(command.getBrno() != null && !PatternUtil.isBizno(command.getBrno()))errors.rejectValue(brno, INVALID_BIZNO_FIELD, makeMessage(brno, INVALID_BIZNO_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bizStartYmd, REQUIRED_FIELD, makeMessage(bizStartYmd, REQUIRED_FIELD));		//사업개시연월일
		ValidationDateUtil.rejectIfDatePattern(errors, bizStartYmd, command.getBizStartYmd(), makeMessage(bizStartYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,addr, REQUIRED_FIELD, makeMessage(addr, REQUIRED_FIELD));		//주소
		if(KoreahanaMgmService.RCMT_FLD_CD_VEHICLE.equals(command.getRcmtFldCd())) {//운수업일때
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,carmdlCd, REQUIRED_FIELD, makeMessage(carmdlCd, REQUIRED_FIELD));		//차종코드
			if("".equals(comCodeService.getCd(carmdlCdList, command.getCarmdlCd())))errors.rejectValue(carmdlCd, INVALID_CODE_NAME_FIELD, makeMessage(carmdlCd,INVALID_CODE_NAME_FIELD));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,mlg, REQUIRED_FIELD, makeMessage(mlg, REQUIRED_FIELD));		//주행거리
			if(command.getMlg() != null && !PatternUtil.isNumber(command.getMlg()))errors.rejectValue(mlg, INVALID_NUMBER_FIELD, makeMessage(mlg, INVALID_NUMBER_FIELD));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,vhclMdyr, REQUIRED_FIELD, makeMessage(vhclMdyr, REQUIRED_FIELD));		//차량연식
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcmtFldCd, REQUIRED_FIELD, makeMessage(rcmtFldCd, REQUIRED_FIELD));		//모집분야코드
		if("".equals(comCodeService.getCd(rcmtFldCdList, command.getRcmtFldCd())))errors.rejectValue(rcmtFldCd, INVALID_CODE_NAME_FIELD, makeMessage(rcmtFldCd,INVALID_CODE_NAME_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtYr, REQUIRED_FIELD, makeMessage(sprtYr, REQUIRED_FIELD));		//지원연도
		if(command.getSprtYr() != null && (command.getSprtYr().length() != 4 || !PatternUtil.isNumber(command.getSprtYr())))errors.rejectValue(sprtYr, INVALID_NUMBER_FIELD, makeMessage(sprtYr, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,dcsnAmt, REQUIRED_FIELD, makeMessage(dcsnAmt, REQUIRED_FIELD));		//결정금액
		if(command.getDcsnAmt() != null && !PatternUtil.isNumber(command.getDcsnAmt()))errors.rejectValue(dcsnAmt, INVALID_NUMBER_FIELD, makeMessage(dcsnAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prchsDsctn, REQUIRED_FIELD, makeMessage(prchsDsctn, REQUIRED_FIELD));		//구매내역
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,prchsAmt, REQUIRED_FIELD, makeMessage(prchsAmt, REQUIRED_FIELD));		//구매금액
		if(command.getPrchsAmt() != null && !PatternUtil.isNumber(command.getPrchsAmt()))errors.rejectValue(prchsAmt, INVALID_NUMBER_FIELD, makeMessage(prchsAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveAmt, REQUIRED_FIELD, makeMessage(giveAmt, REQUIRED_FIELD));		//지급금액
		if(command.getGiveAmt() != null && !PatternUtil.isNumber(command.getGiveAmt()))errors.rejectValue(giveAmt, INVALID_NUMBER_FIELD, makeMessage(giveAmt, INVALID_NUMBER_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,giveCycl, REQUIRED_FIELD, makeMessage(giveCycl, REQUIRED_FIELD));		//지급차수
		if(command.getGiveCycl() != null && !PatternUtil.isNumber(command.getGiveCycl()))errors.rejectValue(giveCycl, INVALID_NUMBER_FIELD, makeMessage(giveCycl, INVALID_NUMBER_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rmrk, REQUIRED_FIELD, makeMessage(rmrk, REQUIRED_FIELD));		//비고
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
