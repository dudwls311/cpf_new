package exts.koreahana.sms.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.ciel.sms.service.CielSmsService;
import exts.ciel.sms.vo.CielSmsResultVO;
import exts.com.enums.EnumMenuCd;
import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.koreahana.sms.service.KoreahanaSmsLogService;
import exts.koreahana.sms.vo.KoreahanaSmsLogVO;


/**
 * @Class Name : KoreahanaSmsLogController.java
 * @Description : SMS전송로그 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.12.06
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSmsLogController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/smsLog";}
	
	@Resource(name = "koreahanaSmsLogService")
	private KoreahanaSmsLogService koreahanaSmsLogService;

	@Resource(name = "cielSmsService")
	private CielSmsService cielSmsService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/smsLog/index.do")
	public String index(
			@ModelAttribute	KoreahanaSmsLogVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKslMode())))searchVO.setKslMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.CFG, request, searchVO.getKslMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/smsLog/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/smsLog/" + searchVO.getKslMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/exts/koreahana/smsLog/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSmsLogVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//기본값으로 스프링빈에 설정된 값 로드
		if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
		if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
	
		//총갯수
		int totalRecordCount = koreahanaSmsLogService.selectKoreahanaSmsLogTot(searchVO);

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
		model.addAttribute("resultList",koreahanaSmsLogService.selectKoreahanaSmsLogList(searchVO));
		
		
		return "exts/koreahana/sms/smsLogList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/smsLog/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSmsLogVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSmsLogVO result = koreahanaSmsLogService.selectKoreahanaSmsLog(searchVO);
		//읽기 권한 체크
		if(!koreahanaSmsLogService.isViewable(result))throwBizException("com.error.noauth.view");
		
		CielSmsResultVO smsSearchVO = new CielSmsResultVO();
		smsSearchVO.setClidx(result.getClidx());
		model.addAttribute("result",cielSmsService.selectKoreahanaSms(smsSearchVO));
		return "exts/koreahana/sms/smsLogView";
	}
}
