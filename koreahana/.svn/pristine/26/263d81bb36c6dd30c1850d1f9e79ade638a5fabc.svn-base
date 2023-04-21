package exts.koreahana.adt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.util.PatternUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import egovframework.com.utl.fcc.service.NullUtil;

/**
 * @Class Name : KoreahanaAdtValidator.java
 * @Description : 가산금지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaAdtValidator")
public class KoreahanaAdtValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	
	private static final String flnm = "flnm";			//성명
	private static final String genderCd = "genderCd";		//성별코드
	private static final String brdtYmd = "brdtYmd";			//생년월일
	private static final String mbphno = "mbphno";			//휴대폰번호
	private static final String addr = "addr";			//주소
	
	private static final String adtnAmtGiveRsn = "adtnAmtGiveRsn";		//가산금지급내용
	private static final String sgntFileSn = "sgntFileSn";		//가산금서명파일일련번호
	private static final String sprtSttsCode = "sprtSttsCode";		//지원상태코드
	private static final String rsn = "rsn";		//사유
	
	
	private static final String collectAgreeYn = "collectAgreeYn";		//사유
	private static final String thirdPartyAgreeYn = "thirdPartyAgreeYn";		//사유
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.adt";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaAdtVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaAdtVO command = (KoreahanaAdtVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));		//모집공고일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,flnm, REQUIRED_FIELD, makeMessage(flnm, REQUIRED_FIELD));		//성명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,genderCd, REQUIRED_FIELD, makeMessage(genderCd, REQUIRED_FIELD));		//성별코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,brdtYmd, REQUIRED_FIELD, makeMessage(brdtYmd, REQUIRED_FIELD));		//생년월일
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,mbphno, REQUIRED_FIELD, makeMessage(mbphno, REQUIRED_FIELD));		//휴대폰번호
			if(!PatternUtil.isPhone(command.getMbphno())) errors.rejectValue(mbphno, "exts.item.koreahana.adt.mbphnoNotValidate", getMessage("exts.item.koreahana.adt.mbphnoNotValidate"));
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,addr, REQUIRED_FIELD, makeMessage(addr, REQUIRED_FIELD));		//주소
			
			if(KoreahanaEnumBizSeCd.THR.getCode().equals(command.getBizSeCd())) {	//제3국출생양육
				if(command.getAdtFamList() == null || command.getAdtFamList().size() < 1) {
					errors.reject("exts.item.koreahana.adt.required", getMessage("exts.item.koreahana.adt.required"));
				}else{
					for(KoreahanaAdtFamVO famVO : command.getAdtFamList()) {
						if(!"".equals(NullUtil.nullString(famVO.getAplcntRelCd())) || !"".equals(NullUtil.nullString(famVO.getFamFlnm()))) {
							if("".equals(NullUtil.nullString(famVO.getAplcntRelCd()))) {
								errors.reject("exts.item.koreahana.adt.aplcntRelCd", getMessage("exts.item.koreahana.adt.aplcntRelCd"));
							}else if("".equals(NullUtil.nullString(famVO.getFamFlnm()))) {
								errors.reject("exts.item.koreahana.adt.famFlnm", getMessage("exts.item.koreahana.adt.famFlnm"));
							}
						}
					}
				}
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,adtnAmtGiveRsn, REQUIRED_FIELD, makeMessage(adtnAmtGiveRsn, REQUIRED_FIELD));		//가산금지급내용
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));		//가산금서명파일일련번호
		}
		
	}

}
