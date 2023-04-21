package exts.koreahana.smb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;

/**
 * @Class Name : KoreahanaSmbTypValidator.java
 * @Description : 제출서류유형 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.09.14
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSmbTypValidator")
public class KoreahanaSmbTypValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String smbsnDocTypeSn = "smbsnDocTypeSn";		//제출서류유형일련번호
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	private static final String smbsnDocTypeVl = "smbsnDocTypeVl";		//제출서류유형값
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.smb";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSmbTypVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSmbTypVO command = (KoreahanaSmbTypVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocTypeSn, REQUIRED_FIELD, makeMessage(smbsnDocTypeSn, REQUIRED_FIELD));	//제출서류유형일련번호
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));		//모집공고일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,smbsnDocTypeVl, REQUIRED_FIELD, makeMessage(smbsnDocTypeVl, REQUIRED_FIELD));		//제출서류유형값
		
	}

}
