package exts.koreahana.emv.web;

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
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.service.ComMbrService;
import exts.com.vo.ComCodeVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.emv.service.KoreahanaEmvService;
import exts.koreahana.emv.validator.KoreahanaEmvValidator;
import exts.koreahana.emv.vo.KoreahanaEmvVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.cms.mbr.JnitcmsmbrVO;
import jnit.cms.org.JnitcmsorgDefaultVO;
import jnit.cms.org.JnitcmsorgService;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEmvController.java
 * @Description : 취업바우처카드 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmvController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/emv";}
	
	@Resource(name = "koreahanaEmvService")
	private KoreahanaEmvService koreahanaEmvService;

	@Resource(name = "jnitcmsorgService")
	private JnitcmsorgService jnitcmsorgService;
	
	@Resource(name = "koreahanaEmvValidator")
	private KoreahanaEmvValidator koreahanaEmvValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/emv/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeMode())))searchVO.setKeMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EMV_SPR, request, searchVO.getKeMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/emv/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/emv/" + searchVO.getKeMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/emv/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setSearchJoinType("emv");
		if(isCenterStaff()) {
			searchVO.setHanactCd(getLoginVO().getOrgId());		//재단직원이 아니면 해당센터만 조회가능
		}else{
			JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
			cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
			model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		}
		
		prevList(KoreahanaEnumCtgryFrstCd.EMV, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEmvVO> resultList = koreahanaEmvService.selectKoreahanaEmvList(searchVO);
			if(resultList != null) {
				for(KoreahanaEmvVO result : resultList) {
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setDscsnYmd(JnitTag.convertDateSplitString(result.getDscsnYmd(), "-"));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "emv", "취업바우처카드");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmvService.selectKoreahanaEmvTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmvService.selectKoreahanaEmvList(searchVO));
		}
		
		
		return "exts/koreahana/emv/emvList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/emv/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmvVO result = koreahanaEmvService.selectKoreahanaEmv(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmvService.isModifiable(result));
		return "exts/koreahana/emv/emvView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/emv/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaEmvVO result = koreahanaEmvService.selectKoreahanaEmv(searchVO);
			//읽기 권한 체크
			if(!koreahanaEmvService.isViewable(result))throwBizException("com.error.noauth.view");
			try {
				centerStaffAllowSprtSttsChk((KoreahanaPbaVO)model.get(KoreahanaSprAbstractController.ATTR_PBA_VO), result);
			}catch(EgovBizException e) {
				return getResponseBackView(model, e.getMessage());
			}
			
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaEmvService.isModifiable(result));
		}else {
			try {
				centerStaffAllowSprtSttsChk((KoreahanaPbaVO)model.get(KoreahanaSprAbstractController.ATTR_PBA_VO), null);
			}catch(EgovBizException e) {
				return getResponseBackView(model, e.getMessage());
			}
		}
		
		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		
		return "exts/koreahana/emv/emvWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/emv/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMV.getCode());
			centerStaffAllowSprtSttsChk(searchVO);
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			if(isCenterStaff()) {
				JnitcmsmbrVO loginVO = (JnitcmsmbrVO) SessionUtil.getAttribute(ComMbrService.SESSION_VO);
				searchVO.setHanactCd(loginVO.getOrgId());		//센터코드 설정
			}
			
			koreahanaEmvValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaEmvService.writeKoreahanaEmv(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/emv/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmvService.deleteKoreahanaEmv(searchVO);
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
	@RequestMapping(value="/exts/koreahana/emv/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/emv/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/emv/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		KoreahanaEmvVO result = koreahanaEmvService.selectKoreahanaEmv(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/emv/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaEmvVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmvVO result = koreahanaEmvService.selectKoreahanaEmv(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/emv/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/emv/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		signView(request, response, enc);
	}
}
