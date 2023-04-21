package exts.koreahana.emp.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.emp.service.KoreahanaEmpQlfService;
import exts.koreahana.emp.service.KoreahanaEmpService;
import exts.koreahana.emp.validator.KoreahanaEmpExcelValidator;
import exts.koreahana.emp.validator.KoreahanaEmpValidator;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;
import exts.koreahana.emp.vo.KoreahanaEmpVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaEmpController.java
 * @Description : 취업연계직업훈련 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmpController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/emp";}
	
	@Resource(name = "koreahanaEmpService")
	private KoreahanaEmpService koreahanaEmpService;

	@Resource(name = "koreahanaEmpQlfService")
	private KoreahanaEmpQlfService koreahanaEmpQlfService;
	
	@Resource(name = "koreahanaEmpValidator")
	private KoreahanaEmpValidator koreahanaEmpValidator;
	
	@Resource(name = "koreahanaEmpExcelValidator")
	private KoreahanaEmpExcelValidator koreahanaEmpExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/emp/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeMode())))searchVO.setKeMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EMP_SPR, request, searchVO.getKeMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/emp/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/emp/" + searchVO.getKeMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/emp/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		prevList(KoreahanaEnumCtgryFrstCd.EMP, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEmpVO> resultList = koreahanaEmpService.selectKoreahanaEmpListExcel(searchVO);
			if(resultList != null) {
				model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
				for(KoreahanaEmpVO result : resultList) {
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
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "emp", "취업연계직업훈련");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmpService.selectKoreahanaEmpTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmpService.selectKoreahanaEmpList(searchVO));
		}
		
		
		return "exts/koreahana/emp/empList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/emp/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpVO result = koreahanaEmpService.selectKoreahanaEmp(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		//취업연계직업훈련자격사항
		KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
		empQlfSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("empQlfList", koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmpService.isModifiable(result));
		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		return "exts/koreahana/emp/empView";
	}


	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/emp/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaEmpVO result = koreahanaEmpService.selectKoreahanaEmp(searchVO);
			//읽기 권한 체크
			if(!koreahanaEmpService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaEmpService.isModifiable(result));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
			
			//취업연계직업훈련자격사항
			KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
			empQlfSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("empQlfListJson", JsonUtil.convertObjectToJson(koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO)));
		}
		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		
		return "exts/koreahana/emp/empWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/emp/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			koreahanaEmpValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			//취업연계직업훈련자격사항
			searchVO.setEmpQlfList(koreahanaEmpQlfService.getParamToEmpQlfVO(request));
			koreahanaEmpQlfService.empQlfValidate(searchVO.getEmpQlfList());
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaEmpService.writeKoreahanaEmp(searchVO, request);
			
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
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/emp/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmpService.deleteKoreahanaEmp(searchVO);
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
	 * 선정결과 변경
	 */
	@RequestMapping(value="/exts/koreahana/emp/writeSprtSttsActionJson.do")
	public String writeSprtSttsActionJson(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return updateKoreahanaSprStts(searchVO, request, model);
	}
	
	
	/**
	 * 선정사유 변경 팝업창
	 */
	@RequestMapping(value="/exts/koreahana/emp/writeRsnJson.do")
	public String writeRsnJson(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		return writeRsnPageJson(searchVO, request, model);
	}

	/**
	 * 제출서류 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/emp/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpVO result = koreahanaEmpService.selectKoreahanaEmp(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/emp/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpVO result = koreahanaEmpService.selectKoreahanaEmp(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/emp/imgView.do")
	public void imgView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		imageView(request, response, enc);
	}
	
	/**
	 * 서명 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/emp/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		signView(request, response, enc);
	}
	
	/**
	 * 엑셀 업로드 폼
	 */
	@RequestMapping(value="/exts/koreahana/emp/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/emp/empExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/emp/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		String maxRow = NullUtil.nullString(request.getParameter("maxRow"));
		String maxCell = NullUtil.nullString(request.getParameter("maxCell"));
		String data = NullUtil.nullString(request.getParameter("data"));
		ComExcelVO excelVO = comService.setExcelData(maxRow, maxCell, data);
//		if(excelVO.getMaxRow() == 0 || excelVO.getMaxCell() == 0 || excelVO.getData() == null) throwBizException("com.error.excel.notFoundData");
		List<ComExcelValidationResultVO> dataList = new ArrayList<ComExcelValidationResultVO>();
		for(int i=0; i<excelVO.getMaxRow(); i++) {
			if(i < 3)continue;//4번째 줄부터처리
			int j = 0;
			JSONObject job = (JSONObject) excelVO.getData().get(i);
			String no = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bizSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ntkrdfUnqNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hanawonFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lastAcbgSchlNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lastAcbgSchlGrdtnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lastAcbgMjrNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String empmSttsYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String empmWrcNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsnaplc = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hgvlcYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String busDrvngCrtfctYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hopeTrpttBzenty = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));

			KoreahanaEmpVO exVO = new KoreahanaEmpVO();
			exVO.setBizSeCd(bizSeCd);
			exVO.setSprtSn(sprtSn);
			exVO.setRegDtStr(regDtStr);
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setNtkrdfUnqNo(ntkrdfUnqNo);
			exVO.setEntcnyYmd(entcnyYmd);
			exVO.setPrtdcsYmd(prtdcsYmd);
			exVO.setHanawonFnshYmd(hanawonFnshYmd);
			exVO.setHanawonTh(hanawonTh);
			exVO.setMbphno(mbphno);
			exVO.setZip(zip);
			exVO.setLastAcbgSchlNm(lastAcbgSchlNm);
			exVO.setLastAcbgSchlGrdtnCd(lastAcbgSchlGrdtnCd);
			exVO.setLastAcbgMjrNm(lastAcbgMjrNm);
			exVO.setEmpmSttsYn(empmSttsYn);
			exVO.setEmpmWrcNm(empmWrcNm);
			exVO.setRsnaplc(rsnaplc);
			exVO.setHgvlcYn(hgvlcYn);
			exVO.setBusDrvngCrtfctYn(busDrvngCrtfctYn);
			exVO.setHopeTrpttBzenty(hopeTrpttBzenty);
			exVO.setSprtSttsCd(sprtSttsCd);
			exVO.setRsn(rsn);

			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaEmpExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/emp/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
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
				if(i < 3)continue;//4번째 줄부터처리
				int j = 0;
				JSONObject job = (JSONObject) excelVO.getData().get(i);
				String no = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bizSeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String brdtYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ntkrdfUnqNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hanawonFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lastAcbgSchlNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lastAcbgSchlGrdtnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lastAcbgMjrNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String empmSttsYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String empmWrcNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsnaplc = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hgvlcYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String busDrvngCrtfctYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hopeTrpttBzenty = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));

				KoreahanaEmpVO exVO = new KoreahanaEmpVO();
				exVO.setBizSeCd(bizSeCd);
				exVO.setSprtSn(sprtSn);
				exVO.setRegDtStr(regDtStr);
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setNtkrdfUnqNo(ntkrdfUnqNo);
				exVO.setEntcnyYmd(entcnyYmd);
				exVO.setPrtdcsYmd(prtdcsYmd);
				exVO.setHanawonFnshYmd(hanawonFnshYmd);
				exVO.setHanawonTh(hanawonTh);
				exVO.setMbphno(mbphno);
				exVO.setZip(zip);
				exVO.setLastAcbgSchlNm(lastAcbgSchlNm);
				exVO.setLastAcbgSchlGrdtnCd(lastAcbgSchlGrdtnCd);
				exVO.setLastAcbgMjrNm(lastAcbgMjrNm);
				exVO.setEmpmSttsYn(empmSttsYn);
				exVO.setEmpmWrcNm(empmWrcNm);
				exVO.setRsnaplc(rsnaplc);
				exVO.setHgvlcYn(hgvlcYn);
				exVO.setBusDrvngCrtfctYn(busDrvngCrtfctYn);
				exVO.setHopeTrpttBzenty(hopeTrpttBzenty);
				exVO.setSprtSttsCd(sprtSttsCd);
				exVO.setRsn(rsn);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaEmpExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaEmpService.excelUpload(dataList);
			
			//log
			int successCnt = 0;
			for(ComExcelValidationResultVO result:dataList) {
				if(result.isSuccess())successCnt++;
			}
			insertComMbrLog(request, EnumMenuCd.SPR_VDO, "엑셀업로드(성공:" + successCnt + "건)");
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		log.debug(dataList);
		return getResponseJsonView(model, isSuccess, msg, dataList);
	}
}
