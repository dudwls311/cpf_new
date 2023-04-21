package exts.koreahana.spr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.util.PatternUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSprValidator.java
 * @Description : 지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaSprValidator")
public class KoreahanaSprValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	private static final String flnm = "flnm";		//성명
	private static final String genderCd = "genderCd";		//성별코드
	private static final String brdtYmd = "brdtYmd";		//생년월일
	private static final String mbphno = "mbphno";		//휴대폰번호
	private static final String zip = "zip";		//우편번호
	private static final String addr = "addr";		//주소
	private static final String daddr = "daddr";		//상세주소
	private static final String sprtSttsCd = "sprtSttsCd";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.spr";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaSprVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaSprVO command = (KoreahanaSprVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));	//지원일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));		//모집공고일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,genderCd, REQUIRED_FIELD, makeMessage(genderCd, REQUIRED_FIELD));		//성별코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
		if(!PatternUtil.isPhone(command.getMbphno())) {
			errors.reject("exts.item.koreahana.adt.mbphnoNotValidate", getMessage("exts.item.koreahana.adt.mbphnoNotValidate"));
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,zip, REQUIRED_FIELD, makeMessage(zip, REQUIRED_FIELD));		//우편번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,addr, REQUIRED_FIELD, makeMessage(addr, REQUIRED_FIELD));		//주소
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,daddr, REQUIRED_FIELD, makeMessage(daddr, REQUIRED_FIELD));		//상세주소
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSttsCd, REQUIRED_FIELD, makeMessage(sprtSttsCd, REQUIRED_FIELD));		//지원상태코드
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,rsn, REQUIRED_FIELD, makeMessage(rsn, REQUIRED_FIELD));		//사유
		
	}

}
