package exts.koreahana.vdo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.util.PatternUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumBrplcCd;
import exts.koreahana.com.enums.KoreahanaEnumVdoType;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;

/**
 * @Class Name : KoreahanaVdoValidator.java
 * @Description : 화상영어교육지원 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaVdoValidator")
public class KoreahanaVdoValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String sprtSn = "sprtSn";		//지원일련번호
	private static final String aplcntType = "aplcntType";		//신청자유형
	private static final String brplcCd = "brplcCd";		//출생지코드
	private static final String existBnfCd = "existBnfCd";		//기존수혜여부코드
	private static final String rcoblYn = "rcoblYn";		//기초생활수급자여부
	private static final String rcoblSgntFileSn = "rcoblSgntFileSn";		//기초생활수급자인증서파일일련번호
	private static final String aplcntOgdp = "aplcntOgdp";		//소속
	private static final String ntkrdfSe = "ntkrdfSe";		//북한이탈주민구분
	private static final String ntkrdfFlnm = "ntkrdfFlnm";		//북한이탈주민성명
	private static final String ntkrdfHanawonTh = "ntkrdfHanawonTh";		//북한이탈주민하나원기수
	private static final String ntkrdfEntcnyYr = "ntkrdfEntcnyYr";		//북한이탈주민입국년도
	private static final String ntkrdfAcrtfctFileSn = "ntkrdfAcrtfctFileSn";		//북한이탈주민인증서파일일련번호
	private static final String eduSprtTrprRelCd = "eduSprtTrprRelCd";		//교육지원대상자관계코드
	private static final String eduSprtTrprRelDtl = "eduSprtTrprRelDtl";		//교육지원대상자관계상세
	private static final String prtcrFlnm = "prtcrFlnm";		//보호자성명
	private static final String prtcrGenderCd = "prtcrGenderCd";		//보호자성별코드
	private static final String prtcrBrdtYmd = "prtcrBrdtYmd";		//보호자생년월일
	private static final String prtcrMbphno = "prtcrMbphno";		//보호자휴대폰번호
	private static final String prtcrZip = "prtcrZip";		//보호자우편번호
	private static final String prtcrAddr = "prtcrAddr";		//보호자주소
	private static final String prtcrDaddr = "prtcrDaddr";		//보호자상세주소
	private static final String sgntFileSn = "sgntFileSn";		//서명파일일련번호
	private static final String sgntrFlnm = "sgntrFlnm";		//서명자이름
	private static final String prtcrSgntFileSn = "prtcrSgntFileSn";		//보호자서명파일일련번호
	private static final String prtcrSgntrFlnm = "prtcrSgntrFlnm";		//보호자서명이름
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.vdo";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaVdoVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaVdoVO command = (KoreahanaVdoVO) obj;
		
		if(!"Y".equals(command.getCollectAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.collectAgreeYn", getMessage("exts.item.koreahana.pba.collectAgreeYn"));
		}
		if(!"Y".equals(command.getThirdPartyAgreeYn())) {
			errors.reject("exts.item.koreahana.pba.thirdPartyAgreeYn", getMessage("exts.item.koreahana.pba.thirdPartyAgreeYn"));
		}
		
		if(!"Y".equals(command.getTmpSaveYn())) {
			
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sprtSn, REQUIRED_FIELD, makeMessage(sprtSn, REQUIRED_FIELD));												//지원일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplcntType, REQUIRED_SELECT_FIELD, makeMessage(aplcntType, REQUIRED_SELECT_FIELD));						//신청자유형
			
			if(KoreahanaEnumVdoType.NTK_IDT.getCode().equals(command.getAplcntType())) {
				//북한이탈주민(본인)
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,brplcCd, REQUIRED_SELECT_FIELD, makeMessage(brplcCd, REQUIRED_SELECT_FIELD));							//출생지코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,existBnfCd, REQUIRED_SELECT_FIELD, makeMessage(existBnfCd, REQUIRED_SELECT_FIELD));					//기존수혜여부코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_SELECT_FIELD, makeMessage(rcoblYn, REQUIRED_SELECT_FIELD));							//기초생활수급자여부
				if("Y".equals(NullUtil.nullString(command.getRcoblYn()))) {
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_SELECT_FIELD));		//기초생활수급자인증서파일일련번호
				}
			}else if(KoreahanaEnumVdoType.NTK_PRT.getCode().equals(command.getAplcntType())) {
				//북한이탈주민(보호자)
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,brplcCd, REQUIRED_SELECT_FIELD, makeMessage(brplcCd, REQUIRED_SELECT_FIELD));							//출생지코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,existBnfCd, REQUIRED_SELECT_FIELD, makeMessage(existBnfCd, REQUIRED_SELECT_FIELD));					//기존수혜여부코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_SELECT_FIELD, makeMessage(rcoblYn, REQUIRED_SELECT_FIELD));							//기초생활수급자여부
				if("Y".equals(NullUtil.nullString(command.getRcoblYn()))) {
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_SELECT_FIELD));		//기초생활수급자인증서파일일련번호
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelCd, REQUIRED_SELECT_FIELD, makeMessage(eduSprtTrprRelCd, REQUIRED_SELECT_FIELD));		//교육지원대상자관계코드
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(prtcrSgntFileSn, REQUIRED_SELECT_FIELD));			//보호자서명파일일련번호
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntrFlnm, REQUIRED_FIELD, makeMessage(prtcrSgntrFlnm, REQUIRED_FIELD));							//보호자서명이름
			}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(command.getAplcntType())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,brplcCd, REQUIRED_SELECT_FIELD, makeMessage(brplcCd, REQUIRED_SELECT_FIELD));							//출생지코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,existBnfCd, REQUIRED_SELECT_FIELD, makeMessage(existBnfCd, REQUIRED_SELECT_FIELD));					//기존수혜여부코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_SELECT_FIELD, makeMessage(rcoblYn, REQUIRED_SELECT_FIELD));							//기초생활수급자여부
				if("Y".equals(NullUtil.nullString(command.getRcoblYn()))) {
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_SELECT_FIELD));		//기초생활수급자인증서파일일련번호
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelCd, REQUIRED_SELECT_FIELD, makeMessage(eduSprtTrprRelCd, REQUIRED_SELECT_FIELD));		//교육지원대상자관계코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrFlnm, REQUIRED_FIELD, makeMessage(prtcrFlnm, REQUIRED_FIELD));									//보호자성명
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrGenderCd, REQUIRED_SELECT_FIELD, makeMessage(prtcrGenderCd, REQUIRED_SELECT_FIELD));				//보호자성별코드
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrMbphno, REQUIRED_FIELD, makeMessage(prtcrMbphno, REQUIRED_FIELD));								//보호자휴대폰번호
				if(!PatternUtil.isPhone(command.getPrtcrMbphno())) {
					errors.reject("exts.item.koreahana.adt.mbphnoNotValidate", getMessage("exts.item.koreahana.adt.mbphnoNotValidate"));
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfHanawonTh, REQUIRED_FIELD, makeMessage(ntkrdfHanawonTh, REQUIRED_FIELD));						//북한이탈주민하나원기수
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfEntcnyYr, REQUIRED_FIELD, makeMessage(ntkrdfEntcnyYr, REQUIRED_FIELD));							//북한이탈주민입국년도
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD, makeMessage(ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD));		//북한이탈주민인증서파일일련번호
			}else if(KoreahanaEnumVdoType.NOR_PRT.getCode().equals(command.getAplcntType())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,brplcCd, REQUIRED_SELECT_FIELD, makeMessage(brplcCd, REQUIRED_SELECT_FIELD));							//출생지코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,existBnfCd, REQUIRED_SELECT_FIELD, makeMessage(existBnfCd, REQUIRED_SELECT_FIELD));					//기존수혜여부코드
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblYn, REQUIRED_SELECT_FIELD, makeMessage(rcoblYn, REQUIRED_SELECT_FIELD));							//기초생활수급자여부
				if("Y".equals(NullUtil.nullString(command.getRcoblYn()))) {
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,rcoblSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(rcoblSgntFileSn, REQUIRED_SELECT_FIELD));		//기초생활수급자인증서파일일련번호
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfSe, REQUIRED_FIELD, makeMessage(ntkrdfSe, REQUIRED_FIELD));										//북한이탈주민구분
				if(!KoreahanaEnumBrplcCd.NOR.getCode().equals(command.getBrplcCd())) {
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfFlnm, REQUIRED_FIELD, makeMessage(ntkrdfFlnm, REQUIRED_FIELD));								//북한이탈주민성명
				}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfHanawonTh, REQUIRED_FIELD, makeMessage(ntkrdfHanawonTh, REQUIRED_FIELD));						//북한이탈주민하나원기수
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfEntcnyYr, REQUIRED_FIELD, makeMessage(ntkrdfEntcnyYr, REQUIRED_FIELD));							//북한이탈주민입국년도
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD, makeMessage(ntkrdfAcrtfctFileSn, REQUIRED_SELECT_FIELD));		//북한이탈주민인증서파일일련번호
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelDtl, REQUIRED_FIELD, makeMessage(eduSprtTrprRelDtl, REQUIRED_FIELD));					//교육지원대상자관계상세
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(prtcrSgntFileSn, REQUIRED_SELECT_FIELD));			//보호자서명파일일련번호
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntrFlnm, REQUIRED_FIELD, makeMessage(prtcrSgntrFlnm, REQUIRED_FIELD));							//보호자서명이름
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_SELECT_FIELD, makeMessage(sgntFileSn, REQUIRED_SELECT_FIELD));					//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));									//서명자이름
			
			/*
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,aplcntOgdp, REQUIRED_FIELD, makeMessage(aplcntOgdp, REQUIRED_FIELD));		//소속
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfSe, REQUIRED_FIELD, makeMessage(ntkrdfSe, REQUIRED_FIELD));		//북한이탈주민구분
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfFlnm, REQUIRED_FIELD, makeMessage(ntkrdfFlnm, REQUIRED_FIELD));		//북한이탈주민성명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfHanawonTh, REQUIRED_FIELD, makeMessage(ntkrdfHanawonTh, REQUIRED_FIELD));		//북한이탈주민하나원기수
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfEntcnyYr, REQUIRED_FIELD, makeMessage(ntkrdfEntcnyYr, REQUIRED_FIELD));		//북한이탈주민입국년도
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,ntkrdfAcrtfctFileSn, REQUIRED_FIELD, makeMessage(ntkrdfAcrtfctFileSn, REQUIRED_FIELD));		//북한이탈주민인증서파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelCd, REQUIRED_FIELD, makeMessage(eduSprtTrprRelCd, REQUIRED_FIELD));		//교육지원대상자관계코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,eduSprtTrprRelDtl, REQUIRED_FIELD, makeMessage(eduSprtTrprRelDtl, REQUIRED_FIELD));		//교육지원대상자관계상세
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrFlnm, REQUIRED_FIELD, makeMessage(prtcrFlnm, REQUIRED_FIELD));		//보호자성명
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrGenderCd, REQUIRED_FIELD, makeMessage(prtcrGenderCd, REQUIRED_FIELD));		//보호자성별코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrBrdtYmd, REQUIRED_FIELD, makeMessage(prtcrBrdtYmd, REQUIRED_FIELD));		//보호자생년월일
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrMbphno, REQUIRED_FIELD, makeMessage(prtcrMbphno, REQUIRED_FIELD));		//보호자휴대폰번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrZip, REQUIRED_FIELD, makeMessage(prtcrZip, REQUIRED_FIELD));		//보호자우편번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrAddr, REQUIRED_FIELD, makeMessage(prtcrAddr, REQUIRED_FIELD));		//보호자주소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrDaddr, REQUIRED_FIELD, makeMessage(prtcrDaddr, REQUIRED_FIELD));		//보호자상세주소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntFileSn, REQUIRED_FIELD, makeMessage(sgntFileSn, REQUIRED_FIELD));		//서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sgntrFlnm, REQUIRED_FIELD, makeMessage(sgntrFlnm, REQUIRED_FIELD));		//서명자이름
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntFileSn, REQUIRED_FIELD, makeMessage(prtcrSgntFileSn, REQUIRED_FIELD));		//보호자서명파일일련번호
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,prtcrSgntrFlnm, REQUIRED_FIELD, makeMessage(prtcrSgntrFlnm, REQUIRED_FIELD));		//보호자서명이름
			*/
		}
		
	}

}
