package exts.koreahana.sho.validator;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.validator.ExtsAbstractValidator;
import exts.com.vo.ComCodeVO;
import exts.koreahana.sho.vo.KoreahanaShoPrcVO;
import exts.koreahana.sho.vo.KoreahanaShoVO;

/**
 * @Class Name : KoreahanaShoExcelValidator.java
 * @Description : 장학금지원 일괄업로드 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Component("koreahanaShoPrcExcelValidator")
public class KoreahanaShoPrcExcelValidator extends ExtsAbstractValidator implements Validator {

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";				//지원일련번호
	private static final String sholSprtPrcnMngSn = "sholSprtPrcnMngSn";				//장학금지원현황관리일련번호
	private static final String slctnMthdCd = "slctnMthdCd";		//선발방법
	private static final String slctnMmtCd = "slctnMmtCd";		//선발시기
	private static final String fncrscCd = "fncrscCd";		//재원
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.sho";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaShoVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		List<ComCodeVO> slctnMthdCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SLCTN_MTHD_CD);	//선발방법
		List<ComCodeVO> slctnMmtCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SLCTN_MMT_CD);		//선발시기
		List<ComCodeVO> fncrscCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.FNCRSC_CD);			//재원
		
		
		final KoreahanaShoPrcVO command = (KoreahanaShoPrcVO) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));								//지원현황관리일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sholSprtPrcnMngSn, REQUIRED_FIELD, makeMessage(sholSprtPrcnMngSn, REQUIRED_FIELD));		//장학금지원현황관리일련번호
		
		if(!"".equals(NullUtil.nullString(command.getSlctnMthdCd())) && "".equals(comCodeService.getCd(slctnMthdCdList, command.getSlctnMthdCd())))errors.rejectValue(slctnMthdCd, INVALID_CODE_NAME_FIELD, makeMessage(slctnMthdCd,INVALID_CODE_NAME_FIELD));
		if(!"".equals(NullUtil.nullString(command.getSlctnMmtCd())) && "".equals(comCodeService.getCd(slctnMmtCdList, command.getSlctnMmtCd())))errors.rejectValue(slctnMmtCd, INVALID_CODE_NAME_FIELD, makeMessage(slctnMmtCd,INVALID_CODE_NAME_FIELD));
		if(!"".equals(NullUtil.nullString(command.getFncrscCd())) && "".equals(comCodeService.getCd(fncrscCdList, command.getFncrscCd())))errors.rejectValue(fncrscCd, INVALID_CODE_NAME_FIELD, makeMessage(fncrscCd,INVALID_CODE_NAME_FIELD));
	}

}
