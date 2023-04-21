package exts.koreahana.emp.web;

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
import exts.koreahana.emp.service.KoreahanaEmpPrcService;
import exts.koreahana.emp.service.KoreahanaEmpQlfService;
import exts.koreahana.emp.validator.KoreahanaEmpPrcValidator;
import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEmpPrcController.java
 * @Description : 취업연계직업훈련지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmpPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/empPrc";}
	
	@Resource(name = "koreahanaEmpPrcService")
	private KoreahanaEmpPrcService koreahanaEmpPrcService;

	@Resource(name = "koreahanaEmpQlfService")
	private KoreahanaEmpQlfService koreahanaEmpQlfService;

	@Resource(name = "koreahanaEmpPrcValidator")
	private KoreahanaEmpPrcValidator koreahanaEmpPrcValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/empPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKepMode())))searchVO.setKepMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EMP_PRC, request, searchVO.getKepMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/empPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/empPrc/" + searchVO.getKepMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/exts/koreahana/empPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.EMP, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEmpPrcVO> resultList = koreahanaEmpPrcService.selectKoreahanaEmpPrcList(searchVO);
			if(resultList != null) {
				model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
				for(KoreahanaEmpPrcVO result : resultList) {
					result.setBizSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bizSeCdList"), result.getBizSeCd()));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setLastAcbgSchlGrdtnCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("empmSttsCdList"), result.getLastAcbgSchlGrdtnCd()));
					result.setHgvlcYn( ("Y".equals(result.getHgvlcYn()) ? "있음" : "없음") );
					result.setBusDrvngCrtfctYn( ("Y".equals(result.getBusDrvngCrtfctYn()) ? "있음" : "없음") );
					result.setEmpmSttsYn( ("Y".equals(result.getEmpmSttsYn()) ? "재직중" : "구직중") );
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setEduBgngYmd(JnitTag.convertDateSplitString(result.getEduBgngYmd(), "-"));
					result.setEduEndYmd(JnitTag.convertDateSplitString(result.getEduEndYmd(), "-"));
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "empPrc", "취업연계직업훈련지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmpPrcService.selectKoreahanaEmpPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmpPrcService.selectKoreahanaEmpPrcList(searchVO));
			
			KoreahanaEmpPrcVO sttVO = new KoreahanaEmpPrcVO();
			sttVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
			sttVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
			model.addAttribute("sttList", koreahanaEmpPrcService.selectKoreahanaEmpPrcStatistic(sttVO));
		}
		
		
		return "exts/koreahana/emp/empPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/empPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpPrcVO result = koreahanaEmpPrcService.selectKoreahanaEmpPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpPrcService.isViewable(result))throwBizException("com.error.noauth.view");

		//취업연계직업훈련자격사항
		KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
		empQlfSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("empQlfList", koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO));

		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, result.getPbancrcCtgryFrstCd()));		//사업구분
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("sprtSttsCdList", getCodeListByGrpCd(EnumGrpCd.SPRT_STTS_CD));						//지원상태코드
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmpPrcService.isModifiable(result));
		return "exts/koreahana/emp/empPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/empPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmpPrcService.deleteKoreahanaEmpPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/empPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpPrcVO result = koreahanaEmpPrcService.selectKoreahanaEmpPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmpPrcService.isModifiable(result));

		//취업연계직업훈련자격사항
		KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
		empQlfSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("empQlfList", koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO));

		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, result.getPbancrcCtgryFrstCd()));		//사업구분
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("sprtSttsCdList", getCodeListByGrpCd(EnumGrpCd.SPRT_STTS_CD));						//지원상태코드
		return "exts/koreahana/emp/empPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/empPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmpPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaEmpPrcService.writeKoreahanaEmpPrc(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/empPrc/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaEmpPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_EMP_STT, request, searchVO.getKepMode());				//분기공통처리

		List<Integer> yearList = getYearList();
		model.addAttribute("yearList", yearList);
		
		if("".equals(NullUtil.nullString(searchVO.getSprtYr())))searchVO.setSprtYr(String.valueOf(yearList.get(0)));
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		model.addAttribute("resultList", koreahanaEmpPrcService.selectKoreahanaEmpPrcStatistic(searchVO));
		
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, KoreahanaEnumCtgryFrstCd.EMP.getCode()));
		return "exts/koreahana/emp/empPrcStatistic";
	}


}
