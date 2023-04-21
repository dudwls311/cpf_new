package exts.koreahana.doc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.exception.ValidatorException;
import exts.com.service.ComAtchFileUserService;
import exts.com.util.ComFileUploadUtil;
import exts.com.util.FileMngUtil;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.web.KoreahanaUserAbstractController;
import exts.koreahana.doc.service.KoreahanaDocService;
import exts.koreahana.doc.service.impl.KoreahanaDocServiceImpl;
import exts.koreahana.doc.validator.KoreahanaDocValidator;
import exts.koreahana.doc.vo.KoreahanaDocVO;


/**
 * @Class Name : KoreahanaDocController.java
 * @Description : 문서함 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaDocUserController extends KoreahanaUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/doc";}
	
	@Resource(name = "koreahanaDocUserService")
	private KoreahanaDocService koreahanaDocUserService;

	@Resource(name = "comAtchFileUserService")
	private ComAtchFileUserService comAtchFileUserService;
	
	@Resource(name = "koreahanaDocValidator")
	private KoreahanaDocValidator koreahanaDocValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/index.do")
	public String index(
			@ModelAttribute	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKdMode())))searchVO.setKdMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_DOC, request, searchVO.getKdMode());			//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/doc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/doc/" + searchVO.getKdMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaDocUserService.selectKoreahanaDocList(searchVO));
			return getResponseExcelView(model, "doc", "문서함");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaDocUserService.selectKoreahanaDocTot(searchVO);

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
			model.addAttribute("resultList",koreahanaDocUserService.selectKoreahanaDocList(searchVO));
		}
		
		
		return "exts/koreahana/doc/docUserList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaDocVO result = koreahanaDocUserService.selectKoreahanaDoc(searchVO);
		//읽기 권한 체크
		if(!koreahanaDocUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaDocUserService.isModifiable(result));
		return "exts/koreahana/doc/docUserView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaDocUserService.deleteKoreahanaDoc(searchVO);
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
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getDocBoxSn()))) {
			KoreahanaDocVO result = koreahanaDocUserService.selectKoreahanaDoc(searchVO);
			//읽기 권한 체크
			if(!koreahanaDocUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaDocUserService.isModifiable(result));
		}		
		
		return "exts/koreahana/doc/docUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			if(ComFileUploadUtil.uploadFormFilesValidate(request, KoreahanaDocServiceImpl.DOC_BOX_FILE)) searchVO.setAtchFileSn("fileExist");
			koreahanaDocValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaDocUserService.writeKoreahanaDoc(searchVO, request);
			
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
	 * 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/fileDownload.do")
	public void fileDownload(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		//해당 파일정보를 가져와서 셋팅.
		
		KoreahanaDocVO docVO = koreahanaDocUserService.selectKoreahanaDoc(searchVO);
		if(docVO != null) {
			FileMngUtil.downFile(request, response, docVO.getAtchFilePathNm(), docVO.getAtchFileNm(), docVO.getOrgnlAtchFileNm(), Globals.UPLOAD_PATH);
		}
	}
	
	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/doc/listAjax.do")
	public String listAjax(
			@ModelAttribute("searchVO")	KoreahanaDocVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//회원별 문서함 관리
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaDocUserService.selectKoreahanaDocList(searchVO));
			return getResponseExcelView(model, "doc", "문서함");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaDocUserService.selectKoreahanaDocTot(searchVO);

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
			model.addAttribute("resultList",koreahanaDocUserService.selectKoreahanaDocList(searchVO));
			model.addAttribute("smbsnDocPrefix", NullUtil.nullString(request.getParameter("smbsnDocPrefix")));
			model.addAttribute("smbsnDocMtlYn", NullUtil.nullString(request.getParameter("smbsnDocMtlYn")));
			model.addAttribute("smbDocMpngSn", NullUtil.nullString(request.getParameter("smbDocMpngSn")));
			model.addAttribute("docBoxSelectType", NullUtil.nullString(request.getParameter("docBoxSelectType")));
		}
		
		
		return "exts/koreahana/doc/docUserListAjax";
	}
}
