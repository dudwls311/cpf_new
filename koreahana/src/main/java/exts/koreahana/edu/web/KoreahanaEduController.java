package exts.koreahana.edu.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.edu.service.KoreahanaEduService;
import exts.koreahana.edu.validator.KoreahanaEduValidator;
import exts.koreahana.edu.vo.KoreahanaEduExcelVO;
import exts.koreahana.edu.vo.KoreahanaEduVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEduController.java
 * @Description : 교육지원금 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEduController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/edu";}
	
	@Resource(name = "koreahanaEduService")
	private KoreahanaEduService koreahanaEduService;
	
	@Resource(name = "koreahanaEduValidator")
	private KoreahanaEduValidator koreahanaEduValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/edu/index.do")
	public String index(
			@ModelAttribute	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeMode())))searchVO.setKeMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EDU_SPR, request, searchVO.getKeMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/edu/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/edu/" + searchVO.getKeMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/edu/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevList(KoreahanaEnumCtgryFrstCd.EDU, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEduExcelVO> resultList = koreahanaEduService.selectKoreahanaEduListExcel(searchVO);
			if(resultList != null) {
				List<ComCodeVO> bankCdList = getCodeListByGrpCd(EnumGrpCd.BANK_CD);
				for(KoreahanaEduExcelVO result:resultList) {
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd HH:mm:ss"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBacntBankCd(JnitTag.getCdNm(bankCdList, result.getBacntBankCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "edu", "교육지원금");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEduService.selectKoreahanaEduTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEduService.selectKoreahanaEduList(searchVO));
		}
		
		
		return "exts/koreahana/edu/eduList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/edu/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEduVO result = koreahanaEduService.selectKoreahanaEdu(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);

		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
				
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEduService.isModifiable(result));
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/edu/eduView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/edu/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaEduVO result = koreahanaEduService.selectKoreahanaEdu(searchVO);
			//읽기 권한 체크
			if(!koreahanaEduService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaEduService.isModifiable(result));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		}		
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/edu/eduWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/edu/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			koreahanaEduValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaEduService.writeKoreahanaEdu(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/edu/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEduService.deleteKoreahanaEdu(searchVO);
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
	@RequestMapping(value="/exts/koreahana/edu/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/edu/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/edu/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEduVO result = koreahanaEduService.selectKoreahanaEdu(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/edu/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEduVO result = koreahanaEduService.selectKoreahanaEdu(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/edu/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/edu/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		signView(request, response, enc);
	}
}
