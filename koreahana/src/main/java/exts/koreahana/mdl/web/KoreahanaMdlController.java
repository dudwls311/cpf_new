package exts.koreahana.mdl.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.mdl.service.KoreahanaMdlService;
import exts.koreahana.mdl.validator.KoreahanaMdlExcelValidator;
import exts.koreahana.mdl.validator.KoreahanaMdlValidator;
import exts.koreahana.mdl.vo.KoreahanaMdlVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : KoreahanaMdlController.java
 * @Description : 의료비지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.21
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaMdlController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/mdl";}
	
	@Resource(name = "koreahanaMdlService")
	private KoreahanaMdlService koreahanaMdlService;

	@Resource(name = "koreahanaMdlValidator")
	private KoreahanaMdlValidator koreahanaMdlValidator;

	@Resource(name = "koreahanaMdlExcelValidator")
	private KoreahanaMdlExcelValidator koreahanaMdlExcelValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/mdl/index.do")
	public String index(
			@ModelAttribute	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKmMode())))searchVO.setKmMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_MDL_PAY , request, searchVO.getKmMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/mdl/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/mdl/" + searchVO.getKmMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/mdl/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("dssSeCdList",getCodeListByGrpCd(EnumGrpCd.DSS_SE_CD));
		model.addAttribute("sprtSeCdList",getCodeListByGrpCd(EnumGrpCd.SPRT_SE_CD));
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYear()).equals(""))searchVO.setSprtYear(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaMdlVO> resultList = koreahanaMdlService.selectKoreahanaMdlList(searchVO);
			if(resultList != null) {
				for(KoreahanaMdlVO result:resultList) {
					result.setEntcnyYm(JnitTag.convertDateSplitString(result.getEntcnyYm(), "-"));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setSprtYmd(JnitTag.convertDateSplitString(result.getSprtYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setDssSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("dssSeCdList"), result.getDssSeCd()));
					result.setSprtSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSeCdList"), result.getSprtSeCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "mdl", "의료비지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaMdlService.selectKoreahanaMdlTot(searchVO);

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
			model.addAttribute("resultList",koreahanaMdlService.selectKoreahanaMdlList(searchVO));
		}
		
		model.addAttribute("yearList", yearList);
		return "exts/koreahana/mdl/mdlList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/mdl/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaMdlVO result = koreahanaMdlService.selectKoreahanaMdl(searchVO);
		//읽기 권한 체크
		if(!koreahanaMdlService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원이력
		KoreahanaMdlVO hisVO = new KoreahanaMdlVO();
		hisVO.setFlnm(result.getFlnm());
		hisVO.setGenderCd(result.getGenderCd());
		hisVO.setBrdtYmd(result.getBrdtYmd());
		hisVO.setEntcnyYm(result.getEntcnyYm());
		model.addAttribute("hisList",koreahanaMdlService.selectKoreahanaMdlList(hisVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaMdlService.isModifiable(result));


		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("dssSeCdList",getCodeListByGrpCd(EnumGrpCd.DSS_SE_CD));
		model.addAttribute("sprtSeCdList",getCodeListByGrpCd(EnumGrpCd.SPRT_SE_CD));
		
		return "exts/koreahana/mdl/mdlView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/mdl/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaMdlService.deleteKoreahanaMdl(searchVO);
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
	@RequestMapping(value="/exts/koreahana/mdl/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getMdlcrSprtSn()))) {
			KoreahanaMdlVO result = koreahanaMdlService.selectKoreahanaMdl(searchVO);
			//읽기 권한 체크
			if(!koreahanaMdlService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaMdlService.isModifiable(result));

			//지원이력
			KoreahanaMdlVO hisVO = new KoreahanaMdlVO();
			hisVO.setFlnm(result.getFlnm());
			hisVO.setGenderCd(result.getGenderCd());
			hisVO.setBrdtYmd(result.getBrdtYmd());
			hisVO.setEntcnyYm(result.getEntcnyYm());
			model.addAttribute("hisList",koreahanaMdlService.selectKoreahanaMdlList(hisVO));
		}		

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("dssSeCdList",getCodeListByGrpCd(EnumGrpCd.DSS_SE_CD));
		model.addAttribute("sprtSeCdList",getCodeListByGrpCd(EnumGrpCd.SPRT_SE_CD));
		
		return "exts/koreahana/mdl/mdlWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/mdl/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaMdlValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaMdlService.writeKoreahanaMdl(searchVO);
			
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
	 * 엑셀 업로드 폼
	 */
	@RequestMapping(value="/exts/koreahana/mdl/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/mdl/mdlExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/mdl/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		String maxRow = NullUtil.nullString(request.getParameter("maxRow"));
		String maxCell = NullUtil.nullString(request.getParameter("maxCell"));
		String data = NullUtil.nullString(request.getParameter("data"));
		ComExcelVO excelVO = comService.setExcelData(maxRow, maxCell, data);
//		if(excelVO.getMaxRow() == 0 || excelVO.getMaxCell() == 0 || excelVO.getData() == null) throwBizException("com.error.excel.notFoundData");
		List<ComExcelValidationResultVO> dataList = new ArrayList<ComExcelValidationResultVO>();
		for(int i=0; i<excelVO.getMaxRow(); i++) {
			if(i < 4)continue;//5번째 줄부터처리
			int j = 0;
			JSONObject job = (JSONObject) excelVO.getData().get(i);
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entcnyYm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String telno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String dssSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String curePeriod = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String dssNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hsptlNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaMdlVO exVO = new KoreahanaMdlVO();
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setEntcnyYm(entcnyYm);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setAddr(addr);
			exVO.setTelno(telno);
			exVO.setDssSeCd(dssSeCd);
			exVO.setHsptlNm(hsptlNm);
			exVO.setCurePeriod(curePeriod);
			exVO.setDssNm(dssNm);
			exVO.setSprtAmt(sprtAmt);
			exVO.setSprtYmd(sprtYmd);
			exVO.setSprtSeCd(sprtSeCd);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaMdlExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/mdl/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		List<ComExcelValidationResultVO> dataList = new ArrayList<ComExcelValidationResultVO>();
		try{
			throwDirect(request);
			String maxRow = NullUtil.nullString(request.getParameter("maxRow"));
			String maxCell = NullUtil.nullString(request.getParameter("maxCell"));
			String data = NullUtil.nullString(request.getParameter("data"));
			ComExcelVO excelVO = comService.setExcelData(maxRow, maxCell, data);
			if(excelVO.getMaxRow() == 0 || excelVO.getMaxCell() == 0 || excelVO.getData() == null) throwBizException("com.error.excel.notFoundData");

			for(int i=0; i<excelVO.getMaxRow(); i++) {
				if(i < 4)continue;//5번째 줄부터처리
				int j = 0;
				JSONObject job = (JSONObject) excelVO.getData().get(i);
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entcnyYm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String telno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String dssSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String curePeriod = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hsptlNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String dssNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaMdlVO exVO = new KoreahanaMdlVO();
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setEntcnyYm(entcnyYm);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setAddr(addr);
				exVO.setTelno(telno);
				exVO.setDssSeCd(dssSeCd);
				exVO.setCurePeriod(curePeriod);
				exVO.setHsptlNm(hsptlNm);
				exVO.setDssNm(dssNm);
				exVO.setSprtAmt(sprtAmt);
				exVO.setSprtYmd(sprtYmd);
				exVO.setSprtSeCd(sprtSeCd);
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaMdlExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaMdlService.excelUpload(dataList);
			
			//log
			int successCnt = 0;
			for(ComExcelValidationResultVO result:dataList) {
				if(result.isSuccess())successCnt++;
			}
			insertComMbrLog(request, EnumMenuCd.SPR_MDL, "엑셀업로드(성공:" + successCnt + "건)");
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg, dataList);
	}
	


	/**
	 * 통계 분기문
	 */
	@RequestMapping(value="/exts/koreahana/mdl/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaMdlVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_MDL_STT, request, "statistic");				//분기공통처리
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYear()).equals(""))searchVO.setSprtYear(String.valueOf(yearList.get(0)));

		model.addAttribute("resultList",koreahanaMdlService.selectKoreahanaMdlStatistic(searchVO));
	
		model.addAttribute("yearList", yearList);
		model.addAttribute("dssSeCdList",getCodeListByGrpCd(EnumGrpCd.DSS_SE_CD));
		model.addAttribute("sprtSeCdList",getCodeListByGrpCd(EnumGrpCd.SPRT_SE_CD));
	return "exts/koreahana/mdl/mdlStatistic";
	}
}
