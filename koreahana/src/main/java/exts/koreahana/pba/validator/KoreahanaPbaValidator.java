package exts.koreahana.pba.validator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import exts.com.util.ValidationDateUtil;
import exts.com.validator.ExtsAbstractValidator;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaPbaValidator.java
 * @Description : 모집공고 Validator
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@SuppressWarnings("unused")
@Component("koreahanaPbaValidator")
public class KoreahanaPbaValidator extends ExtsAbstractValidator implements Validator {
	//validate체크할  field들
	private static final String pbancrcSn = "pbancrcSn";		//모집공고일련번호
	private static final String pbancrcCtgryFrstCd = "pbancrcCtgryFrstCd";		//모집공고 1차 카테고리
	private static final String bizSeCd = "bizSeCd";			//사업구분
	private static final String rlsYn = "rlsYn";			//공개여부
	private static final String pbancrcNm = "pbancrcNm";		//모집공고명
	private static final String pbancrcCn = "pbancrcCn";		//내용
	private static final String inqCnt = "inqCnt";		//조회수
	private static final String pbancrcBgngDt = "pbancrcBgngDt";		//모집공고 시작일
	private static final String pbancrcEndDt = "pbancrcEndDt";		//모집공고 종료일
	
	private static final String testPlc = "testPlc";				//시험장소
	private static final String testYmd = "testYmd";				//시험연월일
	private static final String testHrInfo = "testHrInfo";			//시험시간정보
	private static final String sccdPrsntnYmd = "sccdPrsntnYmd";	//합격자발표연월일
	

	private static final String FIELDNAME_PRFIX = "exts.item.koreahana.pba";
	@Override
	protected String getTablePrefix() {return FIELDNAME_PRFIX;}
	
	@Override
	public boolean supports(final Class<?> clazz) {

		return KoreahanaPbaVO.class.equals(clazz);
	}

	@Override
	public void validate(final Object obj, final Errors errors) {

		final KoreahanaPbaVO command = (KoreahanaPbaVO) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcSn, REQUIRED_FIELD, makeMessage(pbancrcSn, REQUIRED_FIELD));	//모집공고일련번호
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcCtgryFrstCd, REQUIRED_SELECT_FIELD, makeMessage(pbancrcCtgryFrstCd, REQUIRED_SELECT_FIELD));		//모집공고일차적카테고리
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,bizSeCd, REQUIRED_SELECT_FIELD, makeMessage(bizSeCd, REQUIRED_SELECT_FIELD));		//모집공고이차적카테고리
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,rlsYn, REQUIRED_SELECT_FIELD, makeMessage(rlsYn, REQUIRED_SELECT_FIELD));		//공개여부
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcNm, REQUIRED_FIELD, makeMessage(pbancrcNm, REQUIRED_FIELD));		//모집공고명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcCn, REQUIRED_FIELD, makeMessage(pbancrcCn, REQUIRED_FIELD));		//모집공고내용
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,inqCnt, REQUIRED_FIELD, makeMessage(inqCnt, REQUIRED_FIELD));		//조회수
		
		if(command.getPbancrcBgngDt() != null || command.getPbancrcEndDt() != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
			if(command.getPbancrcBgngDt() == null) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcBgngDt, REQUIRED_FIELD, makeMessage(pbancrcBgngDt, REQUIRED_FIELD));		//모집공고시작일시
			}else if(command.getPbancrcEndDt() == null) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,pbancrcEndDt, REQUIRED_FIELD, makeMessage(pbancrcEndDt, REQUIRED_FIELD));		//모집공고종료일시
			}else if(command.getPbancrcBgngDt() != null && command.getPbancrcEndDt() != null) {
				ValidationDateUtil.rejectIfDateGreaterThan(new DateTime(command.getPbancrcBgngDt()), new DateTime(command.getPbancrcEndDt()), errors, pbancrcBgngDt, makeMessage(new String[]{pbancrcBgngDt, pbancrcEndDt}, INVALID_DATEPERIOD_FIELD));
			}
		}
		
		//제출서류유형
		if(command.getSmbTypList() != null) {
			for(KoreahanaSmbTypVO smbTypVO : command.getSmbTypList()) {
				if("".equals(NullUtil.nullString(smbTypVO.getSmbsnDocTypeVl()))) errors.reject("exts.item.koreahana.smb.smbsnDocTypeVl", getMessage("exts.item.koreahana.smb.smbsnDocTypeVl"));
			}
		}
		
		//정착지원 전문관리사 + 자격시험
		if(KoreahanaEnumCtgryFrstCd.SPF.getCode().equals(command.getPbancrcCtgryFrstCd()) && KoreahanaEnumBizSeCd.QLF.getCode().equals(command.getBizSeCd())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,testPlc, REQUIRED_FIELD, makeMessage(testPlc, REQUIRED_FIELD));							//시험장소
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,testYmd, REQUIRED_SELECT_FIELD, makeMessage(testYmd, REQUIRED_SELECT_FIELD));				//시험연월일
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,testHrInfo, REQUIRED_FIELD, makeMessage(testHrInfo, REQUIRED_FIELD));						//시험시간정보
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,sccdPrsntnYmd, REQUIRED_SELECT_FIELD, makeMessage(sccdPrsntnYmd, REQUIRED_SELECT_FIELD));	//합격자발표연월일
		}
		
		//제출서류
		if(command.getSmbList() != null) {
			for(KoreahanaSmbVO smbVO : command.getSmbList()) {
//				if("".equals(NullUtil.nullString(smbVO.getSmbsnDocSn()))) errors.reject("exts.item.koreahana.smb.smbsnDocSn", getMessage("exts.item.koreahana.smb.smbsnDocSn"));
//				if("".equals(NullUtil.nullString(smbVO.getPbancrcSn()))) errors.reject("exts.item.koreahana.smb.pbancrcSn", getMessage("exts.item.koreahana.smb.pbancrcSn"));
				if("".equals(NullUtil.nullString(smbVO.getSmbsnDocNm()))) errors.reject("exts.item.koreahana.smb.smbsnDocNm", getMessage("exts.item.koreahana.smb.smbsnDocNm"));
				if("".equals(NullUtil.nullString(smbVO.getSmbsnDocMtlYn()))) errors.reject("exts.item.koreahana.smb.smbsnDocMtlYn", getMessage("exts.item.koreahana.smb.smbsnDocMtlYn"));
//				if("".equals(NullUtil.nullString(smbVO.getSmbsnDocFormSn()))) errors.reject("exts.item.koreahana.smb.smbsnDocFormSn", getMessage("exts.item.koreahana.smb.smbsnDocFormSn"));
				if("".equals(NullUtil.nullString(smbVO.getSmbsnDocRqrYn()))) errors.reject("exts.item.koreahana.smb.smbsnDocRqrYn", getMessage("exts.item.koreahana.smb.smbsnDocRqrYn"));
				if("".equals(NullUtil.nullString(smbVO.getDocBoxYn()))) errors.reject("exts.item.koreahana.smb.docBoxYn", getMessage("exts.item.koreahana.smb.docBoxYn"));
			}
		}
	}
}
