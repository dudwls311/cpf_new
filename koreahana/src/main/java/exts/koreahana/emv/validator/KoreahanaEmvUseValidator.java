package exts.koreahana.emv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.emv.vo.KoreahanaEmvUseVO;

/**
 * @Class Name : KoreahanaEmvUseValidator.java
 * @Description : 취업바우처카드사용정보 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaEmvUseValidator")
public class KoreahanaEmvUseValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String emvucdUseInfoSn = "emvucdUseInfoSn";		//취업바우처카드사용정보일련번호
	private static final String cardNo = "cardNo";		//카드번호
	private static final String issuistFlnm = "issuistFlnm";		//발급자
	private static final String aprvYmd = "aprvYmd";		//승인연월일
	private static final String aprvNo = "aprvNo";		//승인번호
	private static final String frcsNm = "frcsNm";		//가맹점명
	private static final String aprvAmt = "aprvAmt";		//승인금액
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.emv";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaEmvUseVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {
		final KoreahanaEmvUseVO command = (KoreahanaEmvUseVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,emvucdUseInfoSn, REQUIRED_FIELD, makeMessage(emvucdUseInfoSn, REQUIRED_FIELD));	//취업바우처카드사용정보일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,cardNo, REQUIRED_FIELD, makeMessage(cardNo, REQUIRED_FIELD));		//카드번호
		if(!NullUtil.nullString(command.getCardNo()).equals("") && !PatternUtil.isCard(command.getCardNo()))errors.rejectValue(cardNo, INVALID_CARDNO_FIELD, makeMessage(cardNo, INVALID_CARDNO_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,issuistFlnm, REQUIRED_FIELD, makeMessage(issuistFlnm, REQUIRED_FIELD));		//발급자
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aprvYmd, REQUIRED_FIELD, makeMessage(aprvYmd, REQUIRED_FIELD));		//승인연월일
		if(command.getAprvYmd() != null)ValidationDateUtil.rejectIfDatePattern(errors, aprvYmd, command.getAprvYmd(), makeMessage(aprvYmd, INVALID_DATE_FIELD));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aprvNo, REQUIRED_FIELD, makeMessage(aprvNo, REQUIRED_FIELD));		//승인번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,frcsNm, REQUIRED_FIELD, makeMessage(frcsNm, REQUIRED_FIELD));		//가맹점명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,aprvAmt, REQUIRED_FIELD, makeMessage(aprvAmt, REQUIRED_FIELD));		//승인금액
		if(command.getAprvAmt() != null && !PatternUtil.isNumber(command.getAprvAmt()))errors.rejectValue(aprvAmt, INVALID_NUMBER_FIELD, makeMessage(aprvAmt, INVALID_NUMBER_FIELD));
		
	}

}
