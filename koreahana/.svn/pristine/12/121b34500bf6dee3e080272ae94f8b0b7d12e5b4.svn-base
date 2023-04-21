package exts.koreahana.smb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.smb.vo.KoreahanaSmbVO;

/**
 * @Class Name : KoreahanaSmbValidator.java
 * @Description : 제출서류 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSmbValidator")
public class KoreahanaSmbValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String smbsnDocSn = "smbsnDocSn";		//제출서류일련번호
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	private static final String smbsnDocNm = "smbsnDocNm";		//제출서류명
	private static final String smbsnDocMtlYn = "smbsnDocMtlYn";		//제출서류멀티여부
	private static final String smbsnDocFormSn = "smbsnDocFormSn";		//제출서류양식일련번호
	private static final String smbsnDocRqrYn = "smbsnDocRqrYn";		//제출서류필수여부
	private static final String docBoxYn = "docBoxYn";		//서류함여부
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.smb";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSmbVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSmbVO command = (KoreahanaSmbVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocSn, REQUIRED_FIELD, makeMessage(smbsnDocSn, REQUIRED_FIELD));	//제출서류일련번호
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));		//모집공고일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocNm, REQUIRED_FIELD, makeMessage(smbsnDocNm, REQUIRED_FIELD));		//제출서류명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocMtlYn, REQUIRED_FIELD, makeMessage(smbsnDocMtlYn, REQUIRED_FIELD));		//제출서류멀티여부
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocFormSn, REQUIRED_FIELD, makeMessage(smbsnDocFormSn, REQUIRED_FIELD));		//제출서류양식일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocRqrYn, REQUIRED_FIELD, makeMessage(smbsnDocRqrYn, REQUIRED_FIELD));		//제출서류필수여부
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,docBoxYn, REQUIRED_FIELD, makeMessage(docBoxYn, REQUIRED_FIELD));		//서류함여부
		
	}

}
