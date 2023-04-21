package exts.koreahana.eml.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.eml.service.KoreahanaEmlPrcService;
import exts.koreahana.eml.validator.KoreahanaEmlPrcValidator;
import exts.koreahana.eml.vo.KoreahanaEmlPrcVO;
import jnit.cms.org.JnitcmsorgDefaultVO;
import jnit.cms.org.JnitcmsorgService;
import jnit.cms.org.JnitcmsorgVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEmlPrcController.java
 * @Description : 긴급생계비지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmlPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/emlPrc";}
	
	@Resource(name = "koreahanaEmlPrcService")
	private KoreahanaEmlPrcService koreahanaEmlPrcService;
	
	@Resource(name = "jnitcmsorgService")
	private JnitcmsorgService jnitcmsorgService;

	@Resource(name = "koreahanaEmlPrcValidator")
	private KoreahanaEmlPrcValidator koreahanaEmlPrcValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/emlPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKepMode())))searchVO.setKepMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EML_PRC, request, searchVO.getKepMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/emlPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/emlPrc/" + searchVO.getKepMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/emlPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.EML, searchVO, request, model);
		
		if(isCenterStaff()) {
			searchVO.setHanactCd(getLoginVO().getOrgId());		//재단직원이 아니면 해당센터만 조회가능
		}else {
			JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
			cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
			model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));	
		}
		
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		model.addAttribute("earnCdList", getCodeListByGrpCd(EnumGrpCd.EARN_CD));
		model.addAttribute("mbohhCntCdList", getCodeListByGrpCd(EnumGrpCd.MBOHH_CNT_CD));
		model.addAttribute("dwngShapeCdList", getCodeListByGrpCd(EnumGrpCd.DWNG_SHAPE_CD));
		model.addAttribute("utblNpmntCdList", getCodeListByGrpCd(EnumGrpCd.UTBL_NPMNT_CD));
		model.addAttribute("crssCdList", getCodeListByGrpCd(EnumGrpCd.CRSS_CD));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEmlPrcVO> resultList = koreahanaEmlPrcService.selectKoreahanaEmlPrcList(searchVO);
			if(resultList != null) {
				model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
				model.addAttribute("excvMthdCdList", getCodeListByGrpCd(EnumGrpCd.EXCV_MTHD_CD));
				for(KoreahanaEmlPrcVO result : resultList) {
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setBacntBankCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bankCdList"), result.getBacntBankCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));

					result.setEmrgSprtSpdmYn( ("Y".equals(result.getEmrgSprtSpdmYn()) ? "유" : "N".equals(result.getEmrgSprtSpdmYn()) ? "무" : "") );
					result.setEarnCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("earnCdList"), result.getEarnCd()));
					result.setMbohhCntCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("mbohhCntCdList"), result.getMbohhCntCd()));
					result.setDwngShapeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("dwngShapeCdList"), result.getDwngShapeCd()));
					result.setUtblNpmntCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("utblNpmntCdList"), result.getUtblNpmntCd()));
					result.setCrssCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("crssCdList"), result.getCrssCd()));
					result.setGiveYmd(JnitTag.convertDateSplitString(result.getGiveYmd(), "-"));
					result.setFrstCnslYmdStr(JnitTag.convertDateSplitString(result.getFrstCnslYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					
					String excvMthdCd = JnitTag.getCdNm((List<ComCodeVO>)model.get("excvMthdCdList"), result.getExcvMthdCd());
					if(!"".equals(NullUtil.nullString(result.getExcvMthdEtc()))) excvMthdCd += "("+result.getExcvMthdEtc()+")";
					result.setExcvMthdCd(excvMthdCd);
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "emlPrc", "긴급생계비지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmlPrcService.selectKoreahanaEmlPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmlPrcService.selectKoreahanaEmlPrcList(searchVO));
		}
		
		
		return "exts/koreahana/eml/emlPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/emlPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmlPrcVO result = koreahanaEmlPrcService.selectKoreahanaEmlPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmlPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmlPrcService.isModifiable(result));

		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		model.addAttribute("earnCdList", getCodeListByGrpCd(EnumGrpCd.EARN_CD));
		model.addAttribute("mbohhCntCdList", getCodeListByGrpCd(EnumGrpCd.MBOHH_CNT_CD));
		model.addAttribute("dwngShapeCdList", getCodeListByGrpCd(EnumGrpCd.DWNG_SHAPE_CD));
		model.addAttribute("utblNpmntCdList", getCodeListByGrpCd(EnumGrpCd.UTBL_NPMNT_CD));
		model.addAttribute("crssCdList", getCodeListByGrpCd(EnumGrpCd.CRSS_CD));
		model.addAttribute("excvMthdCdList", getCodeListByGrpCd(EnumGrpCd.EXCV_MTHD_CD));
		return "exts/koreahana/eml/emlPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/emlPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmlPrcService.deleteKoreahanaEmlPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/emlPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmlPrcVO result = koreahanaEmlPrcService.selectKoreahanaEmlPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmlPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmlPrcService.isModifiable(result));

		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		model.addAttribute("earnCdList", getCodeListByGrpCd(EnumGrpCd.EARN_CD));
		model.addAttribute("mbohhCntCdList", getCodeListByGrpCd(EnumGrpCd.MBOHH_CNT_CD));
		model.addAttribute("dwngShapeCdList", getCodeListByGrpCd(EnumGrpCd.DWNG_SHAPE_CD));
		model.addAttribute("utblNpmntCdList", getCodeListByGrpCd(EnumGrpCd.UTBL_NPMNT_CD));
		model.addAttribute("crssCdList", getCodeListByGrpCd(EnumGrpCd.CRSS_CD));
		model.addAttribute("excvMthdCdList", getCodeListByGrpCd(EnumGrpCd.EXCV_MTHD_CD));
		return "exts/koreahana/eml/emlPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/emlPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmlPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaEmlPrcService.writeKoreahanaEmlPrc(searchVO);
			
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
	 * 통계
	 */
	@RequestMapping(value="/exts/koreahana/emlPrc/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaEmlPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_EML_STT, request, searchVO.getKepMode());				//분기공통처리

		List<Integer> yearList = getYearList();
		model.addAttribute("yearList", yearList);
		
		if("".equals(NullUtil.nullString(searchVO.getSprtYr())))searchVO.setSprtYr(String.valueOf(yearList.get(0)));
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EML.getCode());
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		model.addAttribute("resultList", koreahanaEmlPrcService.selectKoreahanaEmlPrcStatistic(searchVO));
		
		return "exts/koreahana/eml/emlPrcStatistic";
	}


}
