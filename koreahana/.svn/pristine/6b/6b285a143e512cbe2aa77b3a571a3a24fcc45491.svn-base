package exts.koreahana.frm.web;

import java.util.ArrayList;
import java.util.Arrays;
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
import exts.koreahana.frm.service.KoreahanaFrmService;
import exts.koreahana.frm.validator.KoreahanaFrmExcelValidator;
import exts.koreahana.frm.validator.KoreahanaFrmValidator;
import exts.koreahana.frm.vo.KoreahanaFrmVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaFrmController.java
 * @Description : 영농정착지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaFrmController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/frm";}
	
	@Resource(name = "koreahanaFrmService")
	private KoreahanaFrmService koreahanaFrmService;

	@Resource(name = "koreahanaFrmValidator")
	private KoreahanaFrmValidator koreahanaFrmValidator;

	@Resource(name = "koreahanaFrmExcelValidator")
	private KoreahanaFrmExcelValidator koreahanaFrmExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/frm/index.do")
	public String index(
			@ModelAttribute	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKfMode())))searchVO.setKfMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_FRM_SPR, request, searchVO.getKfMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/frm/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/frm/" + searchVO.getKfMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/frm/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));

		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYr()).equals(""))searchVO.setSprtYr(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){

			searchVO.setRecordCountPerPage(0);
			List<KoreahanaFrmVO> resultList = koreahanaFrmService.selectKoreahanaFrmList(searchVO);
			if(resultList != null) {
				for(KoreahanaFrmVO result:resultList) {
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "frm", "영농정착지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaFrmService.selectKoreahanaFrmTot(searchVO);

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
			model.addAttribute("resultList",koreahanaFrmService.selectKoreahanaFrmList(searchVO));
		}
		
		model.addAttribute("yearList", yearList);
		
		return "exts/koreahana/frm/frmList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/frm/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaFrmVO result = koreahanaFrmService.selectKoreahanaFrm(searchVO);
		//읽기 권한 체크
		if(!koreahanaFrmService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaFrmService.isModifiable(result));
		
		//지원이력
		KoreahanaFrmVO hisVO = new KoreahanaFrmVO();
		hisVO.setFlnm(result.getFlnm());
		hisVO.setGenderCd(result.getGenderCd());
		hisVO.setBrdtYmd(result.getBrdtYmd());
		hisVO.setPrtdcsYmd(result.getPrtdcsYmd());
		hisVO.setEntcnyYmd(result.getEntcnyYmd());
		hisVO.setRecordCountPerPage(0);
		model.addAttribute("hisList",koreahanaFrmService.selectKoreahanaFrmList(hisVO));
		return "exts/koreahana/frm/frmView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/frm/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFrmService.deleteKoreahanaFrm(searchVO);
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
	 * 삭제 (선택삭제)
	 */
	@RequestMapping(value="/exts/koreahana/frm/deleteAllActionJson.do")
	public String deleteAllActionJson(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception {
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			String frmSpfstSnArr = request.getParameter("frmSpfstSnArr");
			searchVO.setFrmSpfstSnList(Arrays.asList(frmSpfstSnArr.split(",")));
			koreahanaFrmService.deleteAllKoreahanaFrm(searchVO);
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
	@RequestMapping(value="/exts/koreahana/frm/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getFrmSpfstSn()))) {
			KoreahanaFrmVO result = koreahanaFrmService.selectKoreahanaFrm(searchVO);
			//읽기 권한 체크
			if(!koreahanaFrmService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaFrmService.isModifiable(result));
		}		

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("frontOfPhone", getFrontOfPhone());
		model.addAttribute("yearList", getYearList());
		
		return "exts/koreahana/frm/frmWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/frm/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFrmValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaFrmService.writeKoreahanaFrm(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/frm/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/frm/frmExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/frm/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
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
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String frscpkEdu = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String newYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtYr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtDcsnAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prchsBzenty = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prchsItem = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaFrmVO exVO = new KoreahanaFrmVO();
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setEntcnyYmd(entcnyYmd);
			exVO.setPrtdcsYmd(prtdcsYmd);
			exVO.setMbphno(mbphno);
			exVO.setAddr(addr);
			exVO.setFrscpkEdu(frscpkEdu);
			exVO.setNewYn(newYn);
			exVO.setSprtYr(sprtYr);
			exVO.setSprtCycl(sprtCycl);
			exVO.setSprtDcsnAmt(sprtDcsnAmt);
			exVO.setSprtAmt(sprtAmt);
			exVO.setPrchsBzenty(prchsBzenty);
			exVO.setPrchsItem(prchsItem);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaFrmExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/frm/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
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
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String addr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String frscpkEdu = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String newYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtYr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtCycl = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtDcsnAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prchsBzenty = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prchsItem = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaFrmVO exVO = new KoreahanaFrmVO();
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setEntcnyYmd(entcnyYmd);
				exVO.setPrtdcsYmd(prtdcsYmd);
				exVO.setMbphno(mbphno);
				exVO.setAddr(addr);
				exVO.setFrscpkEdu(frscpkEdu);
				exVO.setNewYn(newYn);
				exVO.setSprtYr(sprtYr);
				exVO.setSprtCycl(sprtCycl);
				exVO.setSprtDcsnAmt(sprtDcsnAmt);
				exVO.setSprtAmt(sprtAmt);
				exVO.setPrchsBzenty(prchsBzenty);
				exVO.setPrchsItem(prchsItem);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaFrmExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaFrmService.excelUpload(dataList);
			
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
	@RequestMapping(value="/exts/koreahana/frm/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaFrmVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_FRM_STT, request, "statistic");				//분기공통처리
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getSprtYr()).equals(""))searchVO.setSprtYr(String.valueOf(yearList.get(0)));

		model.addAttribute("resultList",koreahanaFrmService.selectKoreahanaFrmStatistic(searchVO));

		model.addAttribute("resultSprtYrList",koreahanaFrmService.selectKoreahanaFrmStatisticSprtYr(searchVO));

		model.addAttribute("yearList", yearList);
	return "exts/koreahana/frm/frmStatistic";
	}
}
