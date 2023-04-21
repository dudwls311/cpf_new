package exts.koreahana.emv.web;

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
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.koreahana.emv.service.KoreahanaEmvUseService;
import exts.koreahana.emv.validator.KoreahanaEmvUseValidator;
import exts.koreahana.emv.vo.KoreahanaEmvUseVO;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaEmvUseController.java
 * @Description : 취업바우처카드사용정보 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmvUseController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/emvUse";}
	
	@Resource(name = "koreahanaEmvUseService")
	private KoreahanaEmvUseService koreahanaEmvUseService;

	@Resource(name = "koreahanaEmvUseValidator")
	private KoreahanaEmvUseValidator koreahanaEmvUseValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeuMode())))searchVO.setKeuMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EMV_USE, request, searchVO.getKeuMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/emvUse/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/emvUse/" + searchVO.getKeuMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		model.addAttribute("yearList", getYearList());
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaEmvUseService.selectKoreahanaEmvUseList(searchVO));
			return getResponseExcelView(model, "emvUse", "취업바우처카드사용정보");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmvUseService.selectKoreahanaEmvUseTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmvUseService.selectKoreahanaEmvUseList(searchVO));
		}
		
		
		return "exts/koreahana/emv/emvUseList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmvUseVO result = koreahanaEmvUseService.selectKoreahanaEmvUse(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvUseService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmvUseService.isModifiable(result));
		return "exts/koreahana/emv/emvUseView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmvUseService.deleteKoreahanaEmvUse(searchVO);
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
	@RequestMapping(value="/exts/koreahana/emvUse/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getEmvucdUseInfoSn()))) {
			KoreahanaEmvUseVO result = koreahanaEmvUseService.selectKoreahanaEmvUse(searchVO);
			//읽기 권한 체크
			if(!koreahanaEmvUseService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaEmvUseService.isModifiable(result));
		}		
		
		return "exts/koreahana/emv/emvUseWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmvUseValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaEmvUseService.writeKoreahanaEmvUse(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/emvUse/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/emv/emvUseExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
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
			String cardNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String issuistFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String aprvYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String aprvNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String frcsNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String aprvAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaEmvUseVO exVO = new KoreahanaEmvUseVO();
			exVO.setCardNo(cardNo);
			exVO.setIssuistFlnm(issuistFlnm);
			exVO.setAprvYmd(aprvYmd);
			exVO.setAprvNo(aprvNo);
			exVO.setFrcsNm(frcsNm);
			exVO.setAprvAmt(aprvAmt);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaEmvUseValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/emvUse/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvUseVO searchVO,
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
				String cardNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String issuistFlnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String aprvYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String aprvNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String frcsNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String aprvAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaEmvUseVO exVO = new KoreahanaEmvUseVO();
				exVO.setCardNo(cardNo);
				exVO.setIssuistFlnm(issuistFlnm);
				exVO.setAprvYmd(aprvYmd);
				exVO.setAprvNo(aprvNo);
				exVO.setFrcsNm(frcsNm);
				exVO.setAprvAmt(aprvAmt);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaEmvUseValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaEmvUseService.excelUpload(dataList);
			
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
	

}
