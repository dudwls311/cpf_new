package exts.koreahana.spr.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComAtchFileUserService;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.spr.service.KoreahanaSprUserService;
import exts.koreahana.spr.validator.KoreahanaSprValidator;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.crypto.JnitCryptoService;


/**
 * @Class Name : KoreahanaSprController.java
 * @Description : 지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSprUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/spr";}
	
	@Resource(name = "koreahanaSprUserService")
	private KoreahanaSprUserService koreahanaSprUserService;

	@Resource(name = "comAtchFileUserService")
	private ComAtchFileUserService comAtchFileUserService;
	
	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	@Resource(name = "koreahanaSprValidator")
	private KoreahanaSprValidator koreahanaSprValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/index.do")
	public String index(
			@ModelAttribute	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_MYPAGE, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/spr/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/spr/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 지원이력 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setRgtrId(getLoginId());
		
		List<String> pbancrcCtgryFrstCdList = new ArrayList<String>();
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.ADT.getCode());		//가산금
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.SHO.getCode());		//장학금
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.EDU.getCode());		//교육지원금
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.VDO.getCode());		//화상영어
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.LNB.getCode());		//학습지
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.SPF.getCode());		//정착지원 전문관리사
		pbancrcCtgryFrstCdList.add(KoreahanaEnumCtgryFrstCd.EMP.getCode());		//취업연계 직업훈련
		searchVO.setPbancrcCtgryFrstCdList(pbancrcCtgryFrstCdList);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaSprUserService.selectKoreahanaSprList(searchVO));
			return getResponseExcelView(model, "spr", "지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSprUserService.selectKoreahanaSprTot(searchVO);

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
			model.addAttribute("resultList",koreahanaSprUserService.selectKoreahanaSprList(searchVO));
			
			model.addAttribute("sprtSttsCdList", getCodeListByGrpCd(EnumGrpCd.SPRT_STTS_CD));						//지원상태코드
		}
		
		
		return "exts/koreahana/spr/sprUserList";
	}
	
	/**
	 * 사유 확인
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/showRsnAjax.do")
	public String showRsnAjax(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("result", koreahanaSprUserService.selectKoreahanaSpr(searchVO));
		return "exts/koreahana/spr/sprRsnViewAjax";
	}
	
	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/spr/sprUserWrite";
	}
	
	/**
	 * 상세
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/spr/sprUserView";
	}
	
	/**
	 * 제출서류 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/imgView.do")
	public void imgView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		String dec = jnitCryptoService.decryptNoneEncodingParameter(enc);
		String[] decArr = dec.split("\\|\\|");
		
		String atchFileSn = "";
		String sprtSn = "";
		if(decArr.length > 0) atchFileSn = NullUtil.nullString(decArr[0]);
		if(decArr.length > 1) sprtSn = NullUtil.nullString(decArr[1]);
		
		if(!"".equals(sprtSn)) {
			//사진 최초 등록시 sprtSn값이 없는 관계로 sprtSn 값이 넘어올때만 체크
			KoreahanaSprVO searchVO = new KoreahanaSprVO();
			searchVO.setSprtSn(sprtSn);
			KoreahanaSprVO result = koreahanaSprUserService.selectKoreahanaSpr(searchVO);
			//읽기 권한 체크
			if(!koreahanaSprUserService.isViewable(result))throwBizException("com.error.noauth.view");
		}
		
		imageView(request, response, atchFileSn);
	}
	
	/**
	 * 처리완료 페이지
	 */
	@RequestMapping(value="/user/exts/koreahana/spr/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/spr/complete";
	}
}
