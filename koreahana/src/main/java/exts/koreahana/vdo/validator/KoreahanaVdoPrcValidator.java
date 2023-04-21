package exts.koreahana.vdo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcVO;

/**
 * @Class Name : KoreahanaVdoPrcValidator.java
 * @Description : 화상영어교육현황관리 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaVdoPrcValidator")
public class KoreahanaVdoPrcValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String vdoengEduPrcnMngSn = "vdoengEduPrcnMngSn";		//화상영어교육현황관리일련번호
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String lnbkDpcnTrgtYn = "lnbkDpcnTrgtYn";		//학습지중복대상여부
	private static final String mdwGbkhmYmd = "mdwGbkhmYmd";		//중도퇴가연월일
	private static final String gbkhmRsn = "gbkhmRsn";		//퇴가사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.vdo";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaVdoPrcVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaVdoPrcVO command = (KoreahanaVdoPrcVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,vdoengEduPrcnMngSn, REQUIRED_FIELD, makeMessage(vdoengEduPrcnMngSn, REQUIRED_FIELD));	//화상영어교육현황관리일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));		//지원일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,lnbkDpcnTrgtYn, REQUIRED_FIELD, makeMessage(lnbkDpcnTrgtYn, REQUIRED_FIELD));		//학습지중복대상여부
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mdwGbkhmYmd, REQUIRED_FIELD, makeMessage(mdwGbkhmYmd, REQUIRED_FIELD));		//중도퇴가연월일
		if(!"".equals(NullUtil.nullString(command.getMdwGbkhmYmd())))ValidationDateUtil.rejectIfDatePattern(errors, mdwGbkhmYmd, command.getMdwGbkhmYmd(), makeMessage(mdwGbkhmYmd, INVALID_DATE_FIELD));
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,gbkhmRsn, REQUIRED_FIELD, makeMessage(gbkhmRsn, REQUIRED_FIELD));		//퇴가사유
		
	}

}
