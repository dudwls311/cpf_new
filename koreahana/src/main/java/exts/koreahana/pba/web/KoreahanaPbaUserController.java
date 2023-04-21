package exts.koreahana.pba.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.util.FileMngUtil;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.web.KoreahanaUserAbstractController;
import exts.koreahana.pba.service.KoreahanaPbaFileService;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;


/**
 * @Class Name : KoreahanaPbaController.java
 * @Description : 모집공고 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaPbaUserController extends KoreahanaUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/pba";}
	private String pbaMainUri = "forward:/user/exts/koreahana/pba/index.do";

	@Resource(name = "koreahanaPbaService")
	private KoreahanaPbaService koreahanaPbaService;

	@Resource(name = "koreahanaPbaFileService")
	private KoreahanaPbaFileService koreahanaPbaFileService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/index.do")
	public String index(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKpMode())))searchVO.setKpMode("list");		//기본 list로 포워딩
				
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/pba/" + searchVO.getKpMode() + ".do");
		
		return sb.toString();
	}

	/**
	 * 사업공고(신청서)관리 > 가산금 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/adtIndex.do")
	public String adtIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.ADT.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_ADT, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/adtIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 장학금 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/shoIndex.do")
	public String schIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.SHO.getCode());
		setIndexProcess(EnumMenuCd.PBA_SHO, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/shoIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 교육지원금 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/eduIndex.do")
	public String eduIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.EDU.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_EDU, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/eduIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 화상영어 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/vdoIndex.do")
	public String vdoIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.VDO.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_VDO, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/vdoIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 학습지 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/lnbIndex.do")
	public String lnbIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.LNB.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_LNB, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/lnbIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 정착지원 전문관리사 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/spfIndex.do")
	public String spfIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.SPF.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_SPF, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/spfIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 취업연계 직업훈련 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/empIndex.do")
	public String empIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		request.setAttribute("pbancrcCtgryFrstCd", KoreahanaEnumCtgryFrstCd.EMP.getCode());
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_EMP, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pbaUser/empIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd((String)request.getAttribute("pbancrcCtgryFrstCd"));;
		searchVO.setRlsYn("Y");
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaPbaService.selectKoreahanaPbaList(searchVO));
			return getResponseExcelView(model, "pbaUser", "모집공고");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaPbaService.selectKoreahanaPbaTot(searchVO);

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
			model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));			//공고상태
			model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));						//사업구분
			
			searchVO.setReqSearchYn("Y");
			model.addAttribute("resultList",koreahanaPbaService.selectKoreahanaPbaList(searchVO));
		}
		
		
		return "exts/koreahana/pba/pbaUserList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setRlsYn("Y");
		koreahanaPbaService.updateInqCntPlus(searchVO);				//조회수 증가
		KoreahanaPbaVO result = koreahanaPbaService.selectKoreahanaPba(searchVO);
		//읽기 권한 체크
//		if(!koreahanaPbaService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));
		model.addAttribute("ctgryFrstCdList", getCodeListByGrpCd(EnumGrpCd.CTGRY_FRST_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, result.getPbancrcCtgryFrstCd()));						//사업구분
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaPbaService.isModifiable(result));
		
		//첨부파일
		KoreahanaPbaFileVO pbaFileVO = new KoreahanaPbaFileVO();
		pbaFileVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("pbaFileList", koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileVO));
		
		return "exts/koreahana/pba/pbaUserView";
	}
	
	/**
	 * 모집공고 첨부파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/pba/fileDownload.do")
	public void fileDownload(
			@ModelAttribute("searchVO")	KoreahanaPbaFileVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//해당 파일정보를 가져와서 셋팅.
		KoreahanaPbaFileVO pbaFileVO = koreahanaPbaFileService.selectKoreahanaPbaFile(searchVO);
		if(pbaFileVO != null) {
			FileMngUtil.downFile(request, response, pbaFileVO.getAtchFilePathNm(), pbaFileVO.getAtchFileNm(), pbaFileVO.getOrgnlAtchFileNm(), Globals.UPLOAD_PATH);
		}
	}
}
