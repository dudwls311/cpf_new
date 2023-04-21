package exts.koreahana.spr.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumMenuCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.validator.KoreahanaSprValidator;
import exts.koreahana.spr.vo.KoreahanaSprHistoryVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
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
public class KoreahanaSprController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/spr";}
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;

	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	@Resource(name = "koreahanaSprValidator")
	private KoreahanaSprValidator koreahanaSprValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/spr/index.do")
	public String index(
			@ModelAttribute	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPH_SEL, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/spr/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/spr/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}

	/**
	 * 지원이력 리스트
	 */
	@RequestMapping(value="/exts/koreahana/spr/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSprHistoryVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//이름, 생년월일, 입국일, 북한이탈주민번호, 보호결정일, 하나원기수, 하나원수료일 정보 중 하나 이상 입력 후 검색
		if("".equals(NullUtil.nullString(searchVO.getFlnm()))
			&& "".equals(NullUtil.nullString(searchVO.getBrdtYmd()))
			&& "".equals(NullUtil.nullString(searchVO.getNtkrdfUnqNo()))
			&& "".equals(NullUtil.nullString(searchVO.getEntcnyYmd()))
			&& "".equals(NullUtil.nullString(searchVO.getPrtdcsYmd()))
			&& "".equals(NullUtil.nullString(searchVO.getHanawonTh()))
			&& "".equals(NullUtil.nullString(searchVO.getHanawonFnshYmd())) ) {
			
			searchVO.setPbancrcCtgryFrstCd("NONE");
		}
		
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			
			List<KoreahanaSprHistoryVO> resultList = koreahanaSprService.selectKoreahanaSprListHistory(searchVO);
			if(resultList != null) {
				for(KoreahanaSprHistoryVO result : resultList) {
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setGiveYmd(JnitTag.convertDateSplitString(result.getGiveYmd(), "-"));
					
					for(KoreahanaEnumCtgryFrstCd frstCd : KoreahanaEnumCtgryFrstCd.values()) {
						if(frstCd.getCode().equals(result.getPbancrcCtgryFrstCd())) result.setSprtName(frstCd.getName());
					}
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "sprHistory", "지원이력");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSprService.selectKoreahanaSprTotHistory(searchVO);

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
			model.addAttribute("resultList",koreahanaSprService.selectKoreahanaSprListHistory(searchVO));
		}
		
		return "exts/koreahana/spr/sprList";
	}
}
