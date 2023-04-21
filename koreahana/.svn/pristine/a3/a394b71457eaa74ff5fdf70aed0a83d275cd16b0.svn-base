package exts.koreahana.sgn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.exception.ValidatorException;
import exts.com.service.ComAtchFileUserService;
import exts.com.util.FileMngUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.web.KoreahanaUserAbstractController;
import exts.koreahana.sgn.service.KoreahanaSgnUserService;
import exts.koreahana.sgn.validator.KoreahanaSgnValidator;
import exts.koreahana.sgn.vo.KoreahanaSgnVO;
import exts.koreahana.spr.service.KoreahanaSprUserService;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
import jnit.crypto.JnitCryptoService;


/**
 * @Class Name : KoreahanaSgnController.java
 * @Description : 서명 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSgnUserController extends KoreahanaUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/sgn";}
	
	@Resource(name = "koreahanaSgnUserService")
	private KoreahanaSgnUserService koreahanaSgnUserService;

	@Resource(name = "comAtchFileUserService")
	private ComAtchFileUserService comAtchFileUserService;
	
	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
    
    @Resource(name = "koreahanaSprUserService")
	private KoreahanaSprUserService koreahanaSprUserService;
    
	@Resource(name = "koreahanaSgnValidator")
	private KoreahanaSgnValidator koreahanaSgnValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/index.do")
	public String index(
			@ModelAttribute	KoreahanaSgnVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_SGN, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/sgn/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/sgn/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaSgnUserService.selectKoreahanaSgnList(searchVO));
			return getResponseExcelView(model, "sgn", "서명");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSgnUserService.selectKoreahanaSgnTot(searchVO);

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
			model.addAttribute("resultList",koreahanaSgnUserService.selectKoreahanaSgnList(searchVO));
		}
		
		
		return "exts/koreahana/sgn/sgnUserList";
	}
	
	/**
	 * 리스트Ajax
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/listAjax.do")
	public String listAjax(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		KoreahanaSgnVO sgnSearchVO = new KoreahanaSgnVO();
		List<KoreahanaSgnVO> sgnList = koreahanaSgnUserService.selectKoreahanaSgnList(sgnSearchVO);
		model.addAttribute("sgnList", sgnList);
		model.addAttribute("sgnId", NullUtil.nullString(request.getParameter("sgnId")));
		return "exts/koreahana/sgn/sgnUserListAjax";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSgnUserService.deleteKoreahanaSgn(searchVO);
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
	 * 추가/수정(그리기)
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSgntSn()))) {
			KoreahanaSgnVO result = koreahanaSgnUserService.selectKoreahanaSgn(searchVO);
			//읽기 권한 체크
			if(!koreahanaSgnUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaSgnUserService.isModifiable(result));
		}		
		
		return "exts/koreahana/sgn/sgnUserWrite";
	}

	/**
	 * 추가/수정(파일첨부)
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/writeFile.do")
	public String writeFile(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSgntSn()))) {
			KoreahanaSgnVO result = koreahanaSgnUserService.selectKoreahanaSgn(searchVO);
			//읽기 권한 체크
			if(!koreahanaSgnUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaSgnUserService.isModifiable(result));
		}		
		
		return "exts/koreahana/sgn/sgnUserWriteFile";
	}

	/**
	 * 추가 / 수정 처리(그리기)
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//즐겨찾기여부 설정
			if("".equals(NullUtil.nullString(searchVO.getSgntFavoYn()))) searchVO.setSgntFavoYn("N");
			
			//서명 (atchFileSn 값이 없으면 서명 그려서 오는걸로 판단)
			if("".equals(NullUtil.nullString(searchVO.getAtchFileSn()))) {
				koreahanaSgnUserService.saveSignFileValidate(searchVO, request);
			}
			
			koreahanaSgnValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			koreahanaSgnUserService.writeKoreahanaSgn(searchVO, request);
			
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
	 * 추가 / 수정(파일첨부)
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/writeFileActionJson.do")
	public String writeFileActionJson(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		ComAtchFileVO atchFileVO = null;
		
		try{
			
			//서명파일(첨부)
			String fsn = "";
			List<String> atchFileSmbSnList = comAtchFileUserService.writeComAtchUploadFile(request, "sgnFile", "sign", null, new String[] {"png"});
			for(String atchFileSn : atchFileSmbSnList) {
				fsn = atchFileSn;
			}
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(fsn);
			atchFileVO = comAtchFileUserService.selectComAtchFile(atchFileSearchVO);
			msg = jnitCryptoService.encrypt(atchFileVO.getAtchFileSn());
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg, atchFileVO);
	}
	
	/**
	 * 서명파일 즐겨찾기여부 변경
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/favoChgActionJson.do")
	public String favoChgActionJson(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSgnUserService.updateKoreahanaSgnFavoChg(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	
	@RequestMapping(value="/user/exts/koreahana/sgn/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		
		throwDirect(request);
		
		String dec = jnitCryptoService.decryptNoneEncodingParameter(enc);
		String[] encArr = dec.split("\\|\\|");
		if(encArr != null && encArr.length == 2) {
			//지원신청에서 서명 볼때
			String atchFileSn = encArr[0];
			String sprtSn = encArr[1];
			
			KoreahanaSprVO sprVO = new KoreahanaSprVO();
			sprVO.setSprtSn(sprtSn);
			sprVO = koreahanaSprUserService.selectKoreahanaSpr(sprVO);
			
			//관리자가 서명선택시 권한으로 보이지 않는걸 해결하기 위해 별도권한 추가
			if(!koreahanaSprUserService.isViewable(sprVO) && ( !isAdmin() && !isFoundStaff() )) throwBizException("com.error.noauth.view");
			
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(atchFileSn);
			ComAtchFileVO atchFileVO = comAtchFileUserService.selectComAtchFile(atchFileSearchVO);
			if(atchFileVO != null) {
				FileMngUtil.showFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), Globals.UPLOAD_PATH);
			}else {
				throwBizException("com.error.nodata");
			}
		}else {
			//마이페이지 > 서명관리에서 서명 볼때
			if(dec != null) {
				String atchFileSn = dec;
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSn(atchFileSn);
				ComAtchFileVO atchFileVO = comAtchFileUserService.selectComAtchFile(atchFileSearchVO);
				if(atchFileVO != null && comAtchFileUserService.isViewable(atchFileVO) ) {
					FileMngUtil.showFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), Globals.UPLOAD_PATH);
				}else {
					throwBizException("com.error.nodata");
				}
			}
		}
	}
	
	/**
	 * 즐겨찾기 서명 가져오기
	 */
	@RequestMapping(value="/user/exts/koreahana/sgn/getFavoSgnJson.do")
	public String getFavoSgnJson(
			@ModelAttribute("searchVO")	KoreahanaSgnVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		Map<String, String> sgnMap = null;
		try{
			searchVO.setSgntFavoYn("Y");		//즐겨찾기
			List<KoreahanaSgnVO> sgnList = koreahanaSgnUserService.selectKoreahanaSgnList(searchVO);
			if(sgnList != null && sgnList.size() > 0) {
				sgnMap = new HashMap<String, String>();
				KoreahanaSgnVO sgnResult = sgnList.get(0);
				sgnMap.put("encParam", JnitTag.sprtFileViewEncode(sgnResult.getAtchFileSn(), ""));
				sgnMap.put("fsn", sgnResult.getAtchFileSn());
			}
			isSuccess = true;
		}catch(NullPointerException e){
			msg = "알 수 없는 에러";
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg, sgnMap);
	}
}
