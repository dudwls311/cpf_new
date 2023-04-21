package exts.koreahana.spb.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.koreahana.spb.service.KoreahanaSpbService;
import exts.koreahana.spb.validator.KoreahanaSpbValidator;
import exts.koreahana.spb.vo.KoreahanaSpbVO;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : KoreahanaSpbController.java
 * @Description : 지원사업설정 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.19
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSpbController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/spb";}
	
	@Resource(name = "koreahanaSpbService")
	private KoreahanaSpbService koreahanaSpbService;

	@Resource(name = "koreahanaSpbValidator")
	private KoreahanaSpbValidator koreahanaSpbValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/spb/index.do")
	public String index(
			@ModelAttribute	KoreahanaSpbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.CFG_SPB, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/spb/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/spb/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/exts/koreahana/spb/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSpbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaSpbService.selectKoreahanaSpbList(searchVO));
			return getResponseExcelView(model, "spb", "지원사업설정");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSpbService.selectKoreahanaSpbTot(searchVO);

	    	PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
			paginationInfo.setPageSize(searchVO.getPageSize());
	    	paginationInfo.setTotalRecordCount(totalRecordCount);
			
			searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
			searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			
			//전체가져올때
			//if(searchVO.getPageUnit() == -1)searchVO.setRecordCountPerPage(0);
			searchVO.setRecordCountPerPage(0);
			
			model.addAttribute("paginationInfo",paginationInfo);
			model.addAttribute("resultCnt",totalRecordCount);
			model.addAttribute("resultList",koreahanaSpbService.selectKoreahanaSpbList(searchVO));
		}
		

		model.addAttribute("spbCdList",getCodeListByGrpCd(EnumGrpCd.SPB_CD));
		model.addAttribute("spbStngCdList",getCodeListByGrpCd(EnumGrpCd.SPB_STNG_CD));
		model.addAttribute("spbDtlCdList",getCodeListByGrpCd(EnumGrpCd.SPB_DTL_CD));
		
		return "exts/koreahana/spb/spbList";
	}

	/**
	 * 보기
	@RequestMapping(value="/exts/koreahana/spb/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSpbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpbVO result = koreahanaSpbService.selectKoreahanaSpb(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpbService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaSpbService.isModifiable(result));
		return "exts/koreahana/spb/spbView";
	}
	 */


	/**
	 * 삭제
	@RequestMapping(value="/exts/koreahana/spb/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpbService.deleteKoreahanaSpb(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	 */


	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/spb/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSpbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		model.addAttribute("resultList",koreahanaSpbService.selectKoreahanaSpbList(searchVO));

		model.addAttribute("spbCdList",getCodeListByGrpCd(EnumGrpCd.SPB_CD));
		model.addAttribute("spbStngCdList",getCodeListByGrpCd(EnumGrpCd.SPB_STNG_CD));
		model.addAttribute("spbDtlCdList",getCodeListByGrpCd(EnumGrpCd.SPB_DTL_CD));
		
		return "exts/koreahana/spb/spbWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/spb/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpbVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpbValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaSpbService.writeKoreahanaSpb(searchVO);
			
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
}
