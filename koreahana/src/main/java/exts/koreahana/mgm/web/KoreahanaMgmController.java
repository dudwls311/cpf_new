package exts.koreahana.mgm.web;

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

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.koreahana.mgm.service.KoreahanaMgmService;
import exts.koreahana.mgm.validator.KoreahanaMgmExcelValidator;
import exts.koreahana.mgm.validator.KoreahanaMgmValidator;
import exts.koreahana.mgm.vo.KoreahanaMgmVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaMgmController.java
 * @Description : 경영개선자금지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaMgmController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/mgm";}
	
	@Resource(name = "koreahanaMgmService")
	private KoreahanaMgmService koreahanaMgmService;

	@Resource(name = "koreahanaMgmValidator")
	private KoreahanaMgmValidator koreahanaMgmValidator;

	@Resource(name = "koreahanaMgmExcelValidator")
	private KoreahanaMgmExcelValidator koreahanaMgmExcelValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/mgm/index.do")
	public String index(
			@ModelAttribute	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKmMode())))searchVO.setKmMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_MGM_SPR, request, searchVO.getKmMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/mgm/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/mgm/" + searchVO.getKmMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/mgm/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		model.addAttribute("bzstatCdList",getCodeListByGrpCd(EnumGrpCd.BZSTAT_CD));
		model.addAttribute("carmdlCdList",getCodeListByGrpCd(EnumGrpCd.CARMDL_CD));
		model.addAttribute("rcmtFldCdList",getCodeListByGrpCd(EnumGrpCd.RCMT_FLD_CD));
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYr()).equals(""))searchVO.setSprtYr(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){

			searchVO.setRecordCountPerPage(0);
			List<KoreahanaMgmVO> resultList = koreahanaMgmService.selectKoreahanaMgmList(searchVO);
			if(resultList != null) {
				for(KoreahanaMgmVO result:resultList) {
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setBrno(JnitTag.convertBiznumberSplitString(result.getBrno(), "-"));
					result.setBizStartYmd(JnitTag.convertDateSplitString(result.getBizStartYmd(), "-"));
					result.setBzstatCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bzstatCdList"), result.getBzstatCd()));
					result.setCarmdlCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("carmdlCdList"), result.getCarmdlCd()));
					result.setRcmtFldCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("rcmtFldCdList"), result.getRcmtFldCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "mgm", "경영개선자금지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaMgmService.selectKoreahanaMgmTot(searchVO);

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
			model.addAttribute("resultList",koreahanaMgmService.selectKoreahanaMgmList(searchVO));
		}

		model.addAttribute("yearList", yearList);
		
		return "exts/koreahana/mgm/mgmList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/mgm/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaMgmVO result = koreahanaMgmService.selectKoreahanaMgm(searchVO);
		//읽기 권한 체크
		if(!koreahanaMgmService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaMgmService.isModifiable(result));

		model.addAttribute("bzstatCdList",getCodeListByGrpCd(EnumGrpCd.BZSTAT_CD));
		model.addAttribute("carmdlCdList",getCodeListByGrpCd(EnumGrpCd.CARMDL_CD));
		model.addAttribute("rcmtFldCdList",getCodeListByGrpCd(EnumGrpCd.RCMT_FLD_CD));
		

		//지원이력
		KoreahanaMgmVO hisVO = new KoreahanaMgmVO();
		hisVO.setFlnm(result.getFlnm());
		hisVO.setBrdtYmd(result.getBrdtYmd());
//		hisVO.setHnwCycl(result.getHnwCycl());
		hisVO.setRecordCountPerPage(0);
		model.addAttribute("hisList",koreahanaMgmService.selectKoreahanaMgmList(hisVO));
		
		model.addAttribute("RCMT_FLD_CD_VEHICLE",KoreahanaMgmService.RCMT_FLD_CD_VEHICLE);
		return "exts/koreahana/mgm/mgmView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/mgm/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaMgmService.deleteKoreahanaMgm(searchVO);
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
	@RequestMapping(value="/exts/koreahana/mgm/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getMgmipvAmtSprtSn()))) {
			KoreahanaMgmVO result = koreahanaMgmService.selectKoreahanaMgm(searchVO);
			//읽기 권한 체크
			if(!koreahanaMgmService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaMgmService.isModifiable(result));
			

			//지원이력
			KoreahanaMgmVO hisVO = new KoreahanaMgmVO();
			hisVO.setFlnm(result.getFlnm());
			hisVO.setBrdtYmd(result.getBrdtYmd());
			hisVO.setHnwCycl(result.getHnwCycl());
			model.addAttribute("hisList",koreahanaMgmService.selectKoreahanaMgmList(hisVO));
		}		

		model.addAttribute("bzstatCdList",getCodeListByGrpCd(EnumGrpCd.BZSTAT_CD));
		model.addAttribute("carmdlCdList",getCodeListByGrpCd(EnumGrpCd.CARMDL_CD));
		model.addAttribute("rcmtFldCdList",getCodeListByGrpCd(EnumGrpCd.RCMT_FLD_CD));

		model.addAttribute("frontOfPhone", getFrontOfPhone());
		model.addAttribute("yearList", getYearList());

		model.addAttribute("RCMT_FLD_CD_VEHICLE",KoreahanaMgmService.RCMT_FLD_CD_VEHICLE);
		return "exts/koreahana/mgm/mgmWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/mgm/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaMgmValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaMgmService.writeKoreahanaMgm(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/mgm/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/mgm/mgmExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/mgm/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
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
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rrnoBknb = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hnwCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String conm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bzstatCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bzstatOsd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String tpbizNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bizStartYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String carmdlCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mlg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String vhclMdyr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rcmtFldCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtYr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String dcsnAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prchsDsctn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prchsAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String giveAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String giveCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaMgmVO exVO = new KoreahanaMgmVO();
			exVO.setFlnm(flnm);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setRrnoBknb(rrnoBknb);
			exVO.setHnwCycl(hnwCycl);
			exVO.setMbphno(mbphno);
			exVO.setConm(conm);
			exVO.setBzstatCd(bzstatCd);
			exVO.setBzstatOsd(bzstatOsd);
			exVO.setTpbizNm(tpbizNm);
			exVO.setBrno(brno);
			exVO.setBizStartYmd(bizStartYmd);
			exVO.setAddr(addr);
			exVO.setCarmdlCd(carmdlCd);
			exVO.setMlg(mlg);
			exVO.setVhclMdyr(vhclMdyr);
			exVO.setRcmtFldCd(rcmtFldCd);
			exVO.setSprtYr(sprtYr);
			exVO.setDcsnAmt(dcsnAmt);
			exVO.setPrchsDsctn(prchsDsctn);
			exVO.setPrchsAmt(prchsAmt);
			exVO.setGiveAmt(giveAmt);
			exVO.setGiveCycl(giveCycl);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaMgmExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/mgm/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
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
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rrnoBknb = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hnwCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String conm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bzstatCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bzstatOsd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String tpbizNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bizStartYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String carmdlCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mlg = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String vhclMdyr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rcmtFldCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtYr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String dcsnAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prchsDsctn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prchsAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String giveAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String giveCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaMgmVO exVO = new KoreahanaMgmVO();
				exVO.setFlnm(flnm);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setRrnoBknb(rrnoBknb);
				exVO.setHnwCycl(hnwCycl);
				exVO.setMbphno(mbphno);
				exVO.setConm(conm);
				exVO.setBzstatCd(bzstatCd);
				exVO.setBzstatOsd(bzstatOsd);
				exVO.setTpbizNm(tpbizNm);
				exVO.setBrno(brno);
				exVO.setBizStartYmd(bizStartYmd);
				exVO.setAddr(addr);
				exVO.setCarmdlCd(carmdlCd);
				exVO.setMlg(mlg);
				exVO.setVhclMdyr(vhclMdyr);
				exVO.setRcmtFldCd(rcmtFldCd);
				exVO.setSprtYr(sprtYr);
				exVO.setDcsnAmt(dcsnAmt);
				exVO.setPrchsDsctn(prchsDsctn);
				exVO.setPrchsAmt(prchsAmt);
				exVO.setGiveAmt(giveAmt);
				exVO.setGiveCycl(giveCycl);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaMgmExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaMgmService.excelUpload(dataList);
			
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
	@RequestMapping(value="/exts/koreahana/mgm/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaMgmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_MGM_STT, request, "statistic");				//분기공통처리
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYr()).equals(""))searchVO.setSprtYr(String.valueOf(yearList.get(0)));

		model.addAttribute("resultRcmtFldCdList",koreahanaMgmService.selectKoreahanaMgmStatisticRcmtFldCd(searchVO));
		model.addAttribute("resultSprtYrList",koreahanaMgmService.selectKoreahanaMgmStatisticSprtYr(searchVO));
	
		model.addAttribute("yearList", yearList);
		model.addAttribute("rcmtFldCdList",getCodeListByGrpCd(EnumGrpCd.RCMT_FLD_CD));
	return "exts/koreahana/mgm/mgmStatistic";
	}
	 
}
