package exts.koreahana.adt.web;

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
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.koreahana.adt.service.KoreahanaAdtFamService;
import exts.koreahana.adt.service.KoreahanaAdtPrcService;
import exts.koreahana.adt.validator.KoreahanaAdtPrcValidator;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtPrcRndVO;
import exts.koreahana.adt.vo.KoreahanaAdtPrcVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaAdtPrcController.java
 * @Description : 가산금지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaAdtPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/adt";}
	
	@Resource(name = "koreahanaAdtPrcService")
	private KoreahanaAdtPrcService koreahanaAdtPrcService;

	@Resource(name = "koreahanaAdtPrcValidator")
	private KoreahanaAdtPrcValidator koreahanaAdtPrcValidator;
	
	@Resource(name = "koreahanaAdtFamService")
	private KoreahanaAdtFamService koreahanaAdtFamService;

	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/adtPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaAdtPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKapMode())))searchVO.setKapMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_ADT_PRC, request, searchVO.getKapMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/adtPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/adtPrc/" + searchVO.getKapMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/adtPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaAdtPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.ADT, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaAdtPrcVO> resultList = koreahanaAdtPrcService.selectKoreahanaAdtPrcListExcel(searchVO);
			if(resultList != null) {
				for(KoreahanaAdtPrcVO result:resultList) {
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm(getCodeListByGrpCd(EnumGrpCd.GENDER_CD), result.getGenderCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					
					result.setGiveDcsnYmd(JnitTag.convertDateSplitString(result.getGiveDcsnYmd(), "-"));
					result.setGiveBgngYm(JnitTag.convertDateSplitString(result.getGiveBgngYm(), "-"));
					result.setGiveEndYm(JnitTag.convertDateSplitString(result.getGiveEndYm(), "-"));					
					result.setBacntBankCd(JnitTag.getCdNm(getCodeListByGrpCd(EnumGrpCd.BANK_CD), result.getBacntBankCd()));
					result.setGiveTrmnYmd(JnitTag.convertDateSplitString(result.getGiveTrmnYmd(), "-"));				
					result.setFrstChdrBrdtYmd(JnitTag.convertDateSplitString(result.getFrstChdrBrdtYmd(), "-"));			
					result.setScndryChdrBrdtYmd(JnitTag.convertDateSplitString(result.getScndryChdrBrdtYmd(), "-"));				
					result.setBizSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bizSeCdList"), result.getBizSeCd()));
					
					
					//회차정보처리
					StringBuffer sb = new StringBuffer();
					int rndAmtTotal = 0;//총지급액
					if(result.getRndList() != null) {
						for(KoreahanaAdtPrcRndVO rnd:result.getRndList()) {
							rndAmtTotal += NullUtil.nullInt(rnd.getGiveAmt());
							if(sb.length() > 0)sb.append(",");
							sb.append(rnd.getRnd())
								.append("회")
								.append(JnitTag.convertDateSplitString(rnd.getGiveYm(), "-"))
								.append(rndAmtTotal);
						}
					}
					result.setRndAmtTotal(rndAmtTotal+"");
					result.setRndConcatExcel(sb.toString());
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "adtPrc", "가산금지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaAdtPrcService.selectKoreahanaAdtPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaAdtPrcService.selectKoreahanaAdtPrcList(searchVO));
		}
		
		return "exts/koreahana/adt/adtPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/adtPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaAdtPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		KoreahanaAdtPrcVO result = koreahanaAdtPrcService.selectKoreahanaAdtPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaAdtPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//가족관계
		KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
		famSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("famList", koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaAdtPrcService.isModifiable(result));
		
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, KoreahanaEnumCtgryFrstCd.ADT.getCode()));						//모집공고 - 사업코드
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/adt/adtPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/adtPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaAdtPrcService.deleteKoreahanaAdtPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/adtPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaAdtPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaAdtPrcVO result = koreahanaAdtPrcService.selectKoreahanaAdtPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaAdtPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaAdtPrcService.isModifiable(result));
		
		//가족관계
		KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
		famSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("famList", koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, KoreahanaEnumCtgryFrstCd.ADT.getCode()));						//모집공고 - 사업코드
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/adt/adtPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/adtPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaAdtPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaAdtPrcService.writeKoreahanaAdtPrc(searchVO);
			
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
	 * 통계 분기문
	 */
	@RequestMapping(value="/exts/koreahana/adtPrc/statistic.do")
	public String statistic(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		setIndexProcess(EnumMenuCd.SPR_ADT_STT, request, "statistic");				//분기공통처리
		
		List<Integer> yearList = getYearList();
		String searchYear = NullUtil.nullString(request.getParameter("searchYear"));
		model.addAttribute("yearList", yearList);
		
		if("".equals(searchYear))searchYear = String.valueOf(yearList.get(0));
		EgovMap searchVO = new EgovMap();
		searchVO.put("searchYear", searchYear);
		model.addAttribute("searchVO", searchVO);
		
		model.addAttribute("stmonthList",koreahanaAdtPrcService.selectStatisticMonth(searchVO));
		model.addAttribute("styearList",koreahanaAdtPrcService.selectStatisticYear(searchVO));
		model.addAttribute("styearDegrList",koreahanaAdtPrcService.selectStatisticYearDegr(searchVO));
		model.addAttribute("styearPeriodList",koreahanaAdtPrcService.selectStatisticYearPeriod(searchVO));
		model.addAttribute("styearAgeList",koreahanaAdtPrcService.selectStatisticYearAge(searchVO));

		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, KoreahanaEnumCtgryFrstCd.ADT.getCode()));	
		
		return "exts/koreahana/adt/adtPrcStatistic";
	}


}
