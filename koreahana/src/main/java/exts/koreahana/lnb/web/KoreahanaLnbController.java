package exts.koreahana.lnb.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.util.ComFileUploadUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumExistBnfCd;
import exts.koreahana.com.enums.KoreahanaEnumLnbType;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.lnb.service.KoreahanaLnbPrcService;
import exts.koreahana.lnb.service.KoreahanaLnbService;
import exts.koreahana.lnb.validator.KoreahanaLnbExcelValidator;
import exts.koreahana.lnb.validator.KoreahanaLnbValidator;
import exts.koreahana.lnb.vo.KoreahanaLnbExcelVO;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaLnbController.java
 * @Description : 학습지지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaLnbController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/lnb";}
	
	@Resource(name = "koreahanaLnbService")
	private KoreahanaLnbService koreahanaLnbService;
	
	@Resource(name = "koreahanaLnbPrcService")
	private KoreahanaLnbPrcService koreahanaLnbPrcService;
	
	@Resource(name = "koreahanaLnbValidator")
	private KoreahanaLnbValidator koreahanaLnbValidator;
	
	@Resource(name = "koreahanaLnbExcelValidator")
	private KoreahanaLnbExcelValidator koreahanaLnbExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/lnb/index.do")
	public String index(
			@ModelAttribute	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKlMode())))searchVO.setKlMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_LNB_SPR, request, searchVO.getKlMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/lnb/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/lnb/" + searchVO.getKlMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/lnb/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		prevList(KoreahanaEnumCtgryFrstCd.LNB, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
			model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaLnbVO> resultList = koreahanaLnbService.selectKoreahanaLnbList(searchVO);
			if(resultList != null) {
				String eduSprtTrprRelCd = "";
				
				KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
				BeanUtils.copyProperties(searchVO, lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcInList = null;		//sprtSn이 동일한 VO를 담을 변수
				
				for(KoreahanaLnbVO result : resultList) {
					lnbPrcInList = new ArrayList<KoreahanaLnbPrcVO>();
					
					//교육지원대상자관계코드 값이 없으면 상세값 설정
					eduSprtTrprRelCd = JnitTag.getCdNm((List<ComCodeVO>) model.get("eduSprtTrprRelCdList"), result.getEduSprtTrprRelCd());
					if("".equals(eduSprtTrprRelCd)) eduSprtTrprRelCd = result.getEduSprtTrprRelDtl();
					
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setEduSprtTrprRelCd(eduSprtTrprRelCd);
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setRcoblYn( ("Y".equals(result.getRcoblYn()) ? "O" : "X") );		//기초생활수급자여부
					
					//sprtSn값이 동일한 VO를 list에 추가
					for(KoreahanaLnbPrcVO lpVO : lnbPrcList) {
						if(lpVO != null && lpVO.getSprtSn().equals(result.getSprtSn())) lnbPrcInList.add(lpVO);
					}

					for(KoreahanaLnbPrcVO lnbPrcVO:lnbPrcInList) {
						
						lnbPrcVO.setBrplcCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("brplcCdList"), lnbPrcVO.getBrplcCd()));
						if("".equals(NullUtil.nullString(lnbPrcVO.getHanawonTh()))) lnbPrcVO.setHanawonTh(lnbPrcVO.getNtkrdfOprtHanawonTh());
						//신규/전년도수혜/전전연도 수혜
						if(KoreahanaEnumExistBnfCd.NOT.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("O");
							lnbPrcVO.setBf1ExistBnfYn("X");
							lnbPrcVO.setBf2ExistBnfYn("X");
						}else if(KoreahanaEnumExistBnfCd.BF1.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("X");
							lnbPrcVO.setBf1ExistBnfYn("O");
							lnbPrcVO.setBf2ExistBnfYn("X");
						}else if(KoreahanaEnumExistBnfCd.BF2.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("X");
							lnbPrcVO.setBf1ExistBnfYn("X");
							lnbPrcVO.setBf2ExistBnfYn("O");
						}
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getSprtTrgtYn()))) lnbPrcVO.setSprtTrgtYn( ("Y".equals(lnbPrcVO.getSprtTrgtYn()) ? "대상" : "비대상") );				//지원대상여부
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getVdoengDpcnTrgtYn()))) lnbPrcVO.setVdoengDpcnTrgtYn( ("Y".equals(lnbPrcVO.getVdoengDpcnTrgtYn()) ? "여" : "부") );	//화상영어중복대상여부
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getMdwGbkhmYmd()))) lnbPrcVO.setMdwGbkhmYmd(JnitTag.convertDateSplitString(lnbPrcVO.getMdwGbkhmYmd(), "-"));			//중도퇴가연월일

						if("1".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc1(lnbPrcVO);
						}else if("2".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc2(lnbPrcVO);
						}else if("3".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc3(lnbPrcVO);
						}else if("4".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc4(lnbPrcVO);
						}
					}	
					
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "lnb", "학습지지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaLnbService.selectKoreahanaLnbTot(searchVO);

	    	PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
			paginationInfo.setPageSize(searchVO.getPageSize());
	    	paginationInfo.setTotalRecordCount(totalRecordCount);
			
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			
			//전체가져올때
			if(searchVO.getPageUnit() == -1)searchVO.setRecordCountPerPage(0);
			
			model.addAttribute("paginationInfo",paginationInfo);
			model.addAttribute("resultCnt",totalRecordCount);
			
			List<KoreahanaLnbVO> resultList = koreahanaLnbService.selectKoreahanaLnbList(searchVO);
			model.addAttribute("resultList", resultList);
			
			if(resultList != null) {

				KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
				BeanUtils.copyProperties(searchVO, lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcInList = null;		//sprtSn이 동일한 VO를 담을 변수
				
				for(KoreahanaLnbVO result : resultList) {
					lnbPrcInList = new ArrayList<KoreahanaLnbPrcVO>();
					//sprtSn값이 동일한 VO를 list에 추가
					for(KoreahanaLnbPrcVO lpVO : lnbPrcList) {
						if(lpVO != null && lpVO.getSprtSn().equals(result.getSprtSn())) lnbPrcInList.add(lpVO);
					}
					
					for(KoreahanaLnbPrcVO lnbPrc:lnbPrcInList) {
						if("1".equals(lnbPrc.getRnkg())) {
							result.setLnbPrc1(lnbPrc);
						}else if("2".equals(lnbPrc.getRnkg())) {
							result.setLnbPrc2(lnbPrc);
						}
					}
				}
			}
		}
		
		
		return "exts/koreahana/lnb/lnbList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/lnb/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//국민기초생활수급확인서
		ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
		rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
		model.addAttribute("rcoblSgntFile", comAtchFileService.selectComAtchFile(rcoblSgntFileVO));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		//등록된 보호자 서명
		ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
		atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
		model.addAttribute("prtcrSgnResult", comAtchFileService.selectComAtchFile(atchFileSearchPrtcrVO));
		
		//학습지 지원대상자 기본 정보
		KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
		lnbPrcSearchVO.setSprtSn(result.getSprtSn());
		List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
		if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
			List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
			for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
				ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
			}
			ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
			ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
			model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
		}
		model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaLnbService.isModifiable(result));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		
		return "exts/koreahana/lnb/lnbView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/lnb/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
			//읽기 권한 체크
			if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaLnbService.isModifiable(result));
			
			//국민기초생활수급확인서
			ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
			rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
			model.addAttribute("rcoblSgntFile", comAtchFileService.selectComAtchFile(rcoblSgntFileVO));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
			
			//등록된 보호자 서명
			ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
			atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
			model.addAttribute("prtcrSgnResult", comAtchFileService.selectComAtchFile(atchFileSearchPrtcrVO));
			
			//학습지 지원대상자 기본 정보
			KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
			lnbPrcSearchVO.setSprtSn(result.getSprtSn());
			List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
			if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
				List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
				for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
					ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
				}
				if(ntkrdfAcrtfctFileSnList.size() > 0) {
					ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
					ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
					model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
				}
			}
			model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);
		}else {
			if("".equals(NullUtil.nullString(searchVO.getAplcntType()))) {
				return "exts/koreahana/lnb/lnbSelect";
			}
			
			boolean isPass = false;
			for(KoreahanaEnumLnbType vdoType : KoreahanaEnumLnbType.values()) {
				if(vdoType.getCode().equals(searchVO.getAplcntType())) {
					isPass = true;
					break;
				}
			}
			if(!isPass) return getResponseBackView(model, comService.getMessage("exts.item.koreahana.vdo.errorAplcnt"));
		}
		
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		
		return "exts/koreahana/lnb/lnbWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/lnb/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			koreahanaLnbPrcService.setParamToLnbPrcVO(searchVO, request);
			
			//기초생활수급자인증서
			if(ComFileUploadUtil.uploadFormFilesValidate(request, "rcoblSgntFileSnFile")) searchVO.setRcoblSgntFileSn("FILE_EXIST");
			
			koreahanaLnbValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			//학습지 지원대상자 기본정보
			if(searchVO.getLnbPrcList() != null) {
				for(KoreahanaLnbPrcVO prcVO : searchVO.getLnbPrcList()) {
					prcVO.setAplcntType(searchVO.getAplcntType());		//유형에 따른 validation
					//북한이탈주민 인증서
					if(ComFileUploadUtil.uploadFormFilesValidate(request, prcVO.getNtkrdfAcrtfctFileId())) prcVO.setNtkrdfAcrtfctFileSn("FILE_EXIST");
					koreahanaLnbPrcService.validateLnbPrcVO(prcVO);
				}
			}
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			//기초생활수급자인증서
			List<String> rcoblSgntFileSnFileList = comAtchFileService.writeComAtchUploadFile(request, "rcoblSgntFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : rcoblSgntFileSnFileList) {
				searchVO.setRcoblSgntFileSn(atchFileSn);
			}
			
			koreahanaLnbService.writeKoreahanaLnb(searchVO, request);
			
			isSuccess = true;
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}

	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/lnb/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaLnbService.deleteKoreahanaLnb(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	
	/**
	 * 선정결과 변경
	 */
	@RequestMapping(value="/exts/koreahana/lnb/writeSprtSttsActionJson.do")
	public String writeSprtSttsActionJson(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return updateKoreahanaSprStts(searchVO, request, model);
	}
	
	
	/**
	 * 선정사유 변경 팝업창
	 */
	@RequestMapping(value="/exts/koreahana/lnb/writeRsnJson.do")
	public String writeRsnJson(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		return writeRsnPageJson(searchVO, request, model);
	}

	/**
	 * 제출서류 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/lnb/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 기초생활수급자인증서파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/lnb/rcoblSgntFileDownload.do")
	public void rcoblSgntFileDownload(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getRcoblSgntFileSn(), request, response);
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/lnb/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		
		boolean isPass = false;
		List<KoreahanaLnbPrcVO> lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(searchVO);
		if(lnbPrcList != null && lnbPrcList.size() > 0) {
			for(KoreahanaLnbPrcVO lnbPrcVO : lnbPrcList) {
				if(NullUtil.nullString(lnbPrcVO.getNtkrdfAcrtfctFileSn()).equals(searchVO.getNtkrdfAcrtfctFileSn())) {
					isPass = true;
					break;
				}
			}
		}
		if(isPass) {
			sprtFileDonwload(searchVO.getNtkrdfAcrtfctFileSn(), request, response);
		}else {
			throwBizException("com.error.noauth.view");
		}
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/lnb/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/lnb/imgView.do")
	public void imgView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		imageView(request, response, enc);
	}
	
	/**
	 * 서명 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/lnb/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		signView(request, response, enc);
	}
	
	/**
	 * 엑셀 업로드 폼
	 */
	@RequestMapping(value="/exts/koreahana/lnb/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/lnb/lnbExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/lnb/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		String maxRow = NullUtil.nullString(request.getParameter("maxRow"));
		String maxCell = NullUtil.nullString(request.getParameter("maxCell"));
		String data = NullUtil.nullString(request.getParameter("data"));
		ComExcelVO excelVO = comService.setExcelData(maxRow, maxCell, data);
//		if(excelVO.getMaxRow() == 0 || excelVO.getMaxCell() == 0 || excelVO.getData() == null) throwBizException("com.error.excel.notFoundData");
		List<ComExcelValidationResultVO> dataList = new ArrayList<ComExcelValidationResultVO>();
		for(int i=0; i<excelVO.getMaxRow(); i++) {
			if(i < 3)continue;//4번째 줄부터처리
			int j = 0;
			JSONObject job = (JSONObject) excelVO.getData().get(i);
			String no = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String eduSprtTrprRelCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hshldrFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rcoblYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc1_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc2_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc3_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lnbPrc4_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaLnbExcelVO exVO = new KoreahanaLnbExcelVO();
			KoreahanaLnbPrcVO lnbPrc1 = new KoreahanaLnbPrcVO();
			KoreahanaLnbPrcVO lnbPrc2 = new KoreahanaLnbPrcVO();
			KoreahanaLnbPrcVO lnbPrc3 = new KoreahanaLnbPrcVO();
			KoreahanaLnbPrcVO lnbPrc4 = new KoreahanaLnbPrcVO(); 
			exVO.setSprtSn(sprtSn);
			exVO.setRegDtStr(regDtStr);
			exVO.setSprtSttsCd(sprtSttsCd);
			exVO.setRsn(rsn);
			exVO.setRegDtStr(regDtStr);
			exVO.setFlnm(flnm);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setEduSprtTrprRelCd(eduSprtTrprRelCd);
			exVO.setMbphno(mbphno);
			exVO.setHanawonTh(hanawonTh);
			exVO.setZip(zip);
			exVO.setHshldrFlnm(hshldrFlnm);
			exVO.setRcoblYn(rcoblYn);
			lnbPrc1.setRnkg(lnbPrc1_rnkg);
			lnbPrc1.setFlnm(lnbPrc1_flnm);
			lnbPrc1.setBrdtYmd(lnbPrc1_brdtYmd);
			lnbPrc1.setBrplcCd(lnbPrc1_brplcCd);
			lnbPrc1.setHanawonTh(lnbPrc1_hanawonTh);
			lnbPrc1.setNoExistBnfYn(lnbPrc1_noExistBnfYn);
			lnbPrc1.setBf1ExistBnfYn(lnbPrc1_bf1ExistBnfYn);
			lnbPrc1.setBf2ExistBnfYn(lnbPrc1_bf2ExistBnfYn);
			lnbPrc2.setRnkg(lnbPrc2_rnkg);
			lnbPrc2.setFlnm(lnbPrc2_flnm);
			lnbPrc2.setBrdtYmd(lnbPrc2_brdtYmd);
			lnbPrc2.setBrplcCd(lnbPrc2_brplcCd);
			lnbPrc2.setHanawonTh(lnbPrc2_hanawonTh);
			lnbPrc2.setNoExistBnfYn(lnbPrc2_noExistBnfYn);
			lnbPrc2.setBf1ExistBnfYn(lnbPrc2_bf1ExistBnfYn);
			lnbPrc2.setBf2ExistBnfYn(lnbPrc2_bf2ExistBnfYn);
			lnbPrc3.setRnkg(lnbPrc3_rnkg);
			lnbPrc3.setFlnm(lnbPrc3_flnm);
			lnbPrc3.setBrdtYmd(lnbPrc3_brdtYmd);
			lnbPrc3.setBrplcCd(lnbPrc3_brplcCd);
			lnbPrc3.setHanawonTh(lnbPrc3_hanawonTh);
			lnbPrc3.setNoExistBnfYn(lnbPrc3_noExistBnfYn);
			lnbPrc3.setBf1ExistBnfYn(lnbPrc3_bf1ExistBnfYn);
			lnbPrc3.setBf2ExistBnfYn(lnbPrc3_bf2ExistBnfYn);
			lnbPrc4.setRnkg(lnbPrc4_rnkg);
			lnbPrc4.setFlnm(lnbPrc4_flnm);
			lnbPrc4.setBrdtYmd(lnbPrc4_brdtYmd);
			lnbPrc4.setBrplcCd(lnbPrc4_brplcCd);
			lnbPrc4.setHanawonTh(lnbPrc4_hanawonTh);
			lnbPrc4.setNoExistBnfYn(lnbPrc4_noExistBnfYn);
			lnbPrc4.setBf1ExistBnfYn(lnbPrc4_bf1ExistBnfYn);
			lnbPrc4.setBf2ExistBnfYn(lnbPrc4_bf2ExistBnfYn);
			exVO.setLnbPrc1(lnbPrc1);
			exVO.setLnbPrc2(lnbPrc2);
			exVO.setLnbPrc3(lnbPrc3);
			exVO.setLnbPrc4(lnbPrc4);

			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaLnbExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/lnb/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		List<ComExcelValidationResultVO> dataList = new ArrayList<ComExcelValidationResultVO>();
		try{
			throwDirect(request);
			String maxRow = NullUtil.nullString(request.getParameter("maxRow"));
			String maxCell = NullUtil.nullString(request.getParameter("maxCell"));
			String data = NullUtil.nullString(request.getParameter("data"));
			ComExcelVO excelVO = comService.setExcelData(maxRow, maxCell, data);
			if(excelVO.getMaxRow() == 0 || excelVO.getMaxCell() == 0 || excelVO.getData() == null) throwBizException("com.error.excel.notFoundData");

			for(int i=0; i<excelVO.getMaxRow(); i++) {
				if(i < 3)continue;//4번째 줄부터처리
				int j = 0;
				JSONObject job = (JSONObject) excelVO.getData().get(i);
				String no = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String eduSprtTrprRelCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hshldrFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rcoblYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc1_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc2_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc3_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_rnkg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lnbPrc4_bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaLnbExcelVO exVO = new KoreahanaLnbExcelVO();
//				KoreahanaLnbPrcVO lnbPrc1 = new KoreahanaLnbPrcVO();
//				KoreahanaLnbPrcVO lnbPrc2 = new KoreahanaLnbPrcVO();
//				KoreahanaLnbPrcVO lnbPrc3 = new KoreahanaLnbPrcVO();
//				KoreahanaLnbPrcVO lnbPrc4 = new KoreahanaLnbPrcVO(); 
				exVO.setSprtSn(sprtSn);
				exVO.setRegDtStr(regDtStr);
				exVO.setSprtSttsCd(sprtSttsCd);
				exVO.setRsn(rsn);
				exVO.setRegDtStr(regDtStr);
				exVO.setFlnm(flnm);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setEduSprtTrprRelCd(eduSprtTrprRelCd);
				exVO.setMbphno(mbphno);
				exVO.setHanawonTh(hanawonTh);
				exVO.setZip(zip);
				exVO.setHshldrFlnm(hshldrFlnm);
				exVO.setRcoblYn(rcoblYn);
//				lnbPrc1.setRnkg(lnbPrc1_rnkg);
//				lnbPrc1.setFlnm(lnbPrc1_flnm);
//				lnbPrc1.setBrdtYmd(lnbPrc1_brdtYmd);
//				lnbPrc1.setBrplcCd(lnbPrc1_brplcCd);
//				lnbPrc1.setHanawonTh(lnbPrc1_hanawonTh);
//				lnbPrc1.setNoExistBnfYn(lnbPrc1_noExistBnfYn);
//				lnbPrc1.setBf1ExistBnfYn(lnbPrc1_bf1ExistBnfYn);
//				lnbPrc1.setBf2ExistBnfYn(lnbPrc1_bf2ExistBnfYn);
//				lnbPrc2.setRnkg(lnbPrc2_rnkg);
//				lnbPrc2.setFlnm(lnbPrc2_flnm);
//				lnbPrc2.setBrdtYmd(lnbPrc2_brdtYmd);
//				lnbPrc2.setBrplcCd(lnbPrc2_brplcCd);
//				lnbPrc2.setHanawonTh(lnbPrc2_hanawonTh);
//				lnbPrc2.setNoExistBnfYn(lnbPrc2_noExistBnfYn);
//				lnbPrc2.setBf1ExistBnfYn(lnbPrc2_bf1ExistBnfYn);
//				lnbPrc2.setBf2ExistBnfYn(lnbPrc2_bf2ExistBnfYn);
//				lnbPrc3.setRnkg(lnbPrc3_rnkg);
//				lnbPrc3.setFlnm(lnbPrc3_flnm);
//				lnbPrc3.setBrdtYmd(lnbPrc3_brdtYmd);
//				lnbPrc3.setBrplcCd(lnbPrc3_brplcCd);
//				lnbPrc3.setHanawonTh(lnbPrc3_hanawonTh);
//				lnbPrc3.setNoExistBnfYn(lnbPrc3_noExistBnfYn);
//				lnbPrc3.setBf1ExistBnfYn(lnbPrc3_bf1ExistBnfYn);
//				lnbPrc3.setBf2ExistBnfYn(lnbPrc3_bf2ExistBnfYn);
//				lnbPrc4.setRnkg(lnbPrc4_rnkg);
//				lnbPrc4.setFlnm(lnbPrc4_flnm);
//				lnbPrc4.setBrdtYmd(lnbPrc4_brdtYmd);
//				lnbPrc4.setBrplcCd(lnbPrc4_brplcCd);
//				lnbPrc4.setHanawonTh(lnbPrc4_hanawonTh);
//				lnbPrc4.setNoExistBnfYn(lnbPrc4_noExistBnfYn);
//				lnbPrc4.setBf1ExistBnfYn(lnbPrc4_bf1ExistBnfYn);
//				lnbPrc4.setBf2ExistBnfYn(lnbPrc4_bf2ExistBnfYn);
//				exVO.setLnbPrc1(lnbPrc1);
//				exVO.setLnbPrc2(lnbPrc2);
//				exVO.setLnbPrc3(lnbPrc3);
//				exVO.setLnbPrc4(lnbPrc4);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaLnbExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaLnbService.excelUpload(dataList);
			
			//log
			int successCnt = 0;
			for(ComExcelValidationResultVO result:dataList) {
				if(result.isSuccess())successCnt++;
			}
			insertComMbrLog(request, EnumMenuCd.SPR_VDO, "엑셀업로드(성공:" + successCnt + "건)");
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		log.debug(dataList);
		return getResponseJsonView(model, isSuccess, msg, dataList);
	}
}
