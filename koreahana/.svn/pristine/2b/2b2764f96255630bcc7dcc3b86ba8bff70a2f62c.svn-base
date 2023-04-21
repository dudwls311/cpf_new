package exts.koreahana.lnb.validator;

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
import exts.koreahana.lnb.vo.KoreahanaLnbVO;

/**
 * @Class Name : KoreahanaLnbExcelValidator.java
 * @Description : 학습지지원 Excel 업로드 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaLnbExcelValidator")
public class KoreahanaLnbExcelValidator extends ExtsAbstractValidator implements Validator {

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String sprtSttsCd = "sprtSttsCd";		//선정결과
	private static final String rsn = "rsn";		//서류미비사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spr";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaLnbVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {
		List<ComCodeVO> sprtSttsCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SPRT_STTS_CD);

		final KoreahanaLnbVO command = (KoreahanaLnbVO) obj;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호

		if(!"".equals(NullUtil.nullString(command.getSprtSttsCd())) && "".equals(comCodeService.getCd(sprtSttsCdList, command.getSprtSttsCd())))errors.rejectValue(sprtSttsCd, INVALID_CODE_NAME_FIELD, makeMessage(sprtSttsCd,INVALID_CODE_NAME_FIELD));
		
	}

}
