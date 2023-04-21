package exts.koreahana.vdo.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
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
import exts.koreahana.com.enums.KoreahanaEnumBrplcCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumEduSprtTrprRelCd;
import exts.koreahana.com.enums.KoreahanaEnumExistBnfCd;
import exts.koreahana.com.enums.KoreahanaEnumGenderCd;
import exts.koreahana.com.enums.KoreahanaEnumVdoType;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import exts.koreahana.vdo.service.KoreahanaVdoService;
import exts.koreahana.vdo.validator.KoreahanaVdoExcelValidator;
import exts.koreahana.vdo.validator.KoreahanaVdoValidator;
import exts.koreahana.vdo.vo.KoreahanaVdoExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaVdoController.java
 * @Description : 화상영어교육지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaVdoController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/vdo";}
	
	@Resource(name = "koreahanaVdoService")
	private KoreahanaVdoService koreahanaVdoService;
	
	@Resource(name = "koreahanaVdoValidator")
	private KoreahanaVdoValidator koreahanaVdoValidator;
	
	@Resource(name = "koreahanaVdoExcelValidator")
	private KoreahanaVdoExcelValidator koreahanaVdoExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/vdo/index.do")
	public String index(
			@ModelAttribute	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKvMode())))searchVO.setKvMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_VDO_SPR, request, searchVO.getKvMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/vdo/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/vdo/" + searchVO.getKvMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/vdo/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevList(KoreahanaEnumCtgryFrstCd.VDO, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
			model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
			model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaVdoExcelVO> resultList = koreahanaVdoService.selectKoreahanaVdoListExcel(searchVO);
			if(resultList != null) {
				String eduSprtTrprRelCd = "";
				for(KoreahanaVdoExcelVO result : resultList) {
					//교육지원대상자관계코드 값이 없으면 상세값 설정
					eduSprtTrprRelCd = JnitTag.getCdNm((List<ComCodeVO>) model.get("eduSprtTrprRelCdList"), result.getEduSprtTrprRelCd());
					if("".equals(eduSprtTrprRelCd)) eduSprtTrprRelCd = result.getEduSprtTrprRelDtl();
					
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setEduSprtTrprRelCd(eduSprtTrprRelCd);
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setBrplcCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("brplcCdList"), result.getBrplcCd()));
					
					if(KoreahanaEnumVdoType.NTK_IDT.getCode().equals(result.getAplcntType())) {
						//북한이탈주민(본인)
					}else if(KoreahanaEnumVdoType.NTK_PRT.getCode().equals(result.getAplcntType())) {
						//북한이탈주민(보호자)
						result.setPrtcrHanawonTh(result.getHanawonTh());	//보호자 기본정보에 계정에 설정된 하나원기수 설정
						result.setHanawonTh("");							//
					}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(result.getAplcntType())) {
						//일반사용자(본인)
					}else if(KoreahanaEnumVdoType.NOR_PRT.getCode().equals(result.getAplcntType())) {
						//일반사용자(보호자)
						if("본인".equals(result.getNtkrdfSe())) {
							result.setHanawonTh(result.getNtkrdfHanawonTh());		//북한이탈주민 구분에서 본인으로 선택한 경우 하나원기수는 본인의 값으로 설정
						}else if("부".equals(result.getNtkrdfSe()) || "모".equals(result.getNtkrdfSe())) {
							result.setPrtcrHanawonTh(result.getNtkrdfHanawonTh());	//보호자 기본정보에 계정에 설정된 하나원기수 설정
						}
					}
					
					//신규/전년도수혜/전전연도 수혜
					if(KoreahanaEnumExistBnfCd.NOT.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("O");
						result.setBf1ExistBnfYn("X");
						result.setBf2ExistBnfYn("X");
					}else if(KoreahanaEnumExistBnfCd.BF1.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("X");
						result.setBf1ExistBnfYn("O");
						result.setBf2ExistBnfYn("X");
					}else if(KoreahanaEnumExistBnfCd.BF2.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("X");
						result.setBf1ExistBnfYn("X");
						result.setBf2ExistBnfYn("O");
					}
					
					//기초생활수급자
					result.setRcoblYn( (result.getRcoblYn().equals("Y") ? "O" : "X" ) );
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "vdo", "화상영어교육지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaVdoService.selectKoreahanaVdoTot(searchVO);

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
			model.addAttribute("resultList",koreahanaVdoService.selectKoreahanaVdoList(searchVO));
		}
		
		
		return "exts/koreahana/vdo/vdoList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/vdo/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//국민기초생활수급확인서
		ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
		rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
		model.addAttribute("rcoblSgntFile", comAtchFileService.selectComAtchFile(rcoblSgntFileVO));
		
		//북한이탈주민 인증서
		ComAtchFileVO ntkrdfAcrtfctFileVO = new ComAtchFileVO();
		ntkrdfAcrtfctFileVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
		model.addAttribute("ntkrdfAcrtfctFile", comAtchFileService.selectComAtchFile(ntkrdfAcrtfctFileVO));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		//등록된 보호자 서명
		ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
		atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
		model.addAttribute("prtcrSgnResult", comAtchFileService.selectComAtchFile(atchFileSearchPrtcrVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaVdoService.isModifiable(result));
		
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		
		return "exts/koreahana/vdo/vdoView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/vdo/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		String aplcntType = "";
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
			
			aplcntType = NullUtil.nullString(result.getAplcntType());
			
			//읽기 권한 체크
			if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaVdoService.isModifiable(result));
			
			//국민기초생활수급확인서
			ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
			rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
			model.addAttribute("rcoblSgntFile", comAtchFileService.selectComAtchFile(rcoblSgntFileVO));
			
			//북한이탈주민 인증서
			ComAtchFileVO ntkrdfAcrtfctFileVO = new ComAtchFileVO();
			ntkrdfAcrtfctFileVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
			model.addAttribute("ntkrdfAcrtfctFile", comAtchFileService.selectComAtchFile(ntkrdfAcrtfctFileVO));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
			
			//등록된 보호자 서명
			ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
			atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
			model.addAttribute("prtcrSgnResult", comAtchFileService.selectComAtchFile(atchFileSearchPrtcrVO));
		}
		
		aplcntType = ("".equals(aplcntType) ? searchVO.getAplcntType() : aplcntType);
		if("".equals(NullUtil.nullString(aplcntType))) {
			//최초 등록시 신청자 회원유형 선택
			model.addAttribute("isNtkrdf", isNtkrdf());
			model.addAttribute("isNormal", isNormal());
			model.addAttribute("isAdmin", isAdmin());
			model.addAttribute("isMbrLevelStaff", isMbrLevelStaff());
			
			return "exts/koreahana/vdo/vdoSelect";
		}else {
			boolean isPass = false;
			for(KoreahanaEnumVdoType vdoType : KoreahanaEnumVdoType.values()) {
				if(vdoType.getCode().equals(aplcntType)) {
					isPass = true;
					break;
				}
			}
			if(!isPass) return getResponseBackView(model, comService.getMessage("exts.item.koreahana.vdo.errorAplcnt"));
		}
		
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("frontOfPhone", getFrontOfPhone());
		
		return "exts/koreahana/vdo/vdoWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/vdo/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			if(KoreahanaEnumVdoType.NTK_IDT.getCode().equals(searchVO.getAplcntType())) {
				//북한이탈주민(본인)
				searchVO.setBrplcCd(KoreahanaEnumBrplcCd.NOR.getCode());		//출생지 북한값 고정
				koreahanaVdoService.setSprtPrtcrInfoBySession(searchVO);		//보호자 정보 설정
			}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(searchVO.getAplcntType())) {
				//본인(북한이탈주민 자녀) 부모값으로 성별 구분
				if(KoreahanaEnumEduSprtTrprRelCd.FAT.getCode().equals(searchVO.getEduSprtTrprRelCd())) {
					searchVO.setPrtcrGenderCd(KoreahanaEnumGenderCd.MALE.getCode());
				}else if(KoreahanaEnumEduSprtTrprRelCd.MOT.getCode().equals(searchVO.getEduSprtTrprRelCd())) {
					searchVO.setPrtcrGenderCd(KoreahanaEnumGenderCd.FEMALE.getCode());
				}
			}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(searchVO.getAplcntType())) {
				koreahanaVdoService.setSprtPrtcrInfoBySession(searchVO);		//보호자 정보 설정
			}
			
			//기초생활수급자인증서
			if(ComFileUploadUtil.uploadFormFilesValidate(request, "rcoblSgntFileSnFile")) searchVO.setRcoblSgntFileSn("FILE_EXIST");
			//북한이탈주민 인증서
			if(ComFileUploadUtil.uploadFormFilesValidate(request, "ntkrdfAcrtfctFileSnFile")) searchVO.setNtkrdfAcrtfctFileSn("FILE_EXIST");
			
			koreahanaVdoValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			//기초생활수급자인증서
			List<String> rcoblSgntFileSnFileList = comAtchFileService.writeComAtchUploadFile(request, "rcoblSgntFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : rcoblSgntFileSnFileList) {
				searchVO.setRcoblSgntFileSn(atchFileSn);
			}
			
			//북한이탈주민 인증서
			List<String> ntkrdfAcrtfctFileList = comAtchFileService.writeComAtchUploadFile(request, "ntkrdfAcrtfctFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : ntkrdfAcrtfctFileList) {
				searchVO.setNtkrdfAcrtfctFileSn(atchFileSn);
			}
			
			koreahanaVdoService.writeKoreahanaVdo(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/vdo/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaVdoService.deleteKoreahanaVdo(searchVO);
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
	@RequestMapping(value="/exts/koreahana/vdo/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/vdo/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/vdo/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 기초생활수급자인증서파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/vdo/rcoblSgntFileDownload.do")
	public void rcoblSgntFileDownload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getRcoblSgntFileSn(), request, response);
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/vdo/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getNtkrdfAcrtfctFileSn(), request, response);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/vdo/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/vdo/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/vdo/sgnView.do")
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
	@RequestMapping(value="/exts/koreahana/vdo/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/vdo/vdoExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/vdo/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
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
			String prtcrFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String eduSprtTrprRelCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtcrMbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtcrHanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ntkrdfHanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rcoblYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String aplcntOgdp = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaVdoExcelVO exVO = new KoreahanaVdoExcelVO();
			exVO.setSprtSn(sprtSn);
			exVO.setRegDtStr(regDtStr);
			exVO.setPrtcrFlnm(prtcrFlnm);
			exVO.setEduSprtTrprRelCd(eduSprtTrprRelCd);
			exVO.setPrtcrMbphno(prtcrMbphno);
			exVO.setPrtcrHanawonTh(prtcrHanawonTh);
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setBrplcCd(brplcCd);
			exVO.setMbphno(mbphno);
			exVO.setZip(zip);
			exVO.setNtkrdfHanawonTh(ntkrdfHanawonTh);
			exVO.setNoExistBnfYn(noExistBnfYn);
			exVO.setBf1ExistBnfYn(bf1ExistBnfYn);
			exVO.setBf2ExistBnfYn(bf2ExistBnfYn);
			exVO.setRcoblYn(rcoblYn);
			exVO.setAplcntOgdp(aplcntOgdp);
			exVO.setSprtSttsCd(sprtSttsCd);
			exVO.setRsn(rsn);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaVdoExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/vdo/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
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
				String prtcrFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String eduSprtTrprRelCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtcrMbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtcrHanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brplcCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ntkrdfHanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String noExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bf1ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bf2ExistBnfYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rcoblYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String aplcntOgdp = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaVdoExcelVO exVO = new KoreahanaVdoExcelVO();
				exVO.setSprtSn(sprtSn);
				exVO.setRegDtStr(regDtStr);
				exVO.setPrtcrFlnm(prtcrFlnm);
				exVO.setEduSprtTrprRelCd(eduSprtTrprRelCd);
				exVO.setPrtcrMbphno(prtcrMbphno);
				exVO.setPrtcrHanawonTh(prtcrHanawonTh);
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setBrplcCd(brplcCd);
				exVO.setMbphno(mbphno);
				exVO.setZip(zip);
				exVO.setNtkrdfHanawonTh(ntkrdfHanawonTh);
				exVO.setNoExistBnfYn(noExistBnfYn);
				exVO.setBf1ExistBnfYn(bf1ExistBnfYn);
				exVO.setBf2ExistBnfYn(bf2ExistBnfYn);
				exVO.setRcoblYn(rcoblYn);
				exVO.setAplcntOgdp(aplcntOgdp);
				exVO.setSprtSttsCd(sprtSttsCd);
				exVO.setRsn(rsn);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaVdoExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaVdoService.excelUpload(dataList);
			
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
		
		return getResponseJsonView(model, isSuccess, msg, dataList);
	}
}
