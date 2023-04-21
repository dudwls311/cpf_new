package exts.koreahana.spf.web;

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
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.spf.service.KoreahanaSpfService;
import exts.koreahana.spf.validator.KoreahanaSpfExcelValidator;
import exts.koreahana.spf.validator.KoreahanaSpfValidator;
import exts.koreahana.spf.vo.KoreahanaSpfExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
import jnit.crypto.JnitCryptoService;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaSpfController.java
 * @Description : 정착지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSpfController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/spf";}
	
	@Resource(name = "koreahanaSpfService")
	private KoreahanaSpfService koreahanaSpfService;

	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	@Resource(name = "koreahanaSpfValidator")
	private KoreahanaSpfValidator koreahanaSpfValidator;
	
	@Resource(name = "koreahanaSpfExcelValidator")
	private KoreahanaSpfExcelValidator koreahanaSpfExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/spf/index.do")
	public String index(
			@ModelAttribute	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_SPF_SPR, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/spf/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/spf/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/spf/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		prevList(KoreahanaEnumCtgryFrstCd.SPF, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaSpfExcelVO> resultList = koreahanaSpfService.selectKoreahanaSpfListExcel(searchVO);
			
			if(resultList != null) {
				String lastAcbgCd = "";		//최종학력코드
				String ocptInstTypeCd = "";	//종사기관유형코드
				
				model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
				model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
				
				for(KoreahanaSpfExcelVO result : resultList) {
					if(!"".equals(NullUtil.nullString(result.getOcptInstTypeCd()))) {
						ocptInstTypeCd = JnitTag.getCdNm((List<ComCodeVO>)model.get("ocptInstTypeCdList"), result.getOcptInstTypeCd());
					}else {
						ocptInstTypeCd = result.getOcptInstTypeEtc();
					}
					
					if(!"".equals(NullUtil.nullString(result.getLastAcbgCd()))) {
						lastAcbgCd = JnitTag.getCdNm((List<ComCodeVO>)model.get("aplcntLastAcbgCdList"), result.getLastAcbgCd());
					}else {
						lastAcbgCd = result.getLastAcbgEtc();
					}
					
					result.setBizSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bizSeCdList"), result.getBizSeCd()));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setLastAcbgCd(lastAcbgCd);
					result.setOcptInstTypeCd(ocptInstTypeCd);
					result.setEduFnshYmd(JnitTag.convertDateSplitString(result.getEduFnshYmd(), "-"));
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "spf", "정착지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSpfService.selectKoreahanaSpfTot(searchVO);

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
			model.addAttribute("resultList",koreahanaSpfService.selectKoreahanaSpfList(searchVO));
		}
		
		
		return "exts/koreahana/spf/spfList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/spf/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfVO result = koreahanaSpfService.selectKoreahanaSpf(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			model.addAttribute("photoFile", comAtchFileService.selectComAtchFile(photoFileVO));
		}
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaSpfService.isModifiable(result));
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
		return "exts/koreahana/spf/spfView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/spf/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaSpfVO result = koreahanaSpfService.selectKoreahanaSpf(searchVO);
			//읽기 권한 체크
			if(!koreahanaSpfService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaSpfService.isModifiable(result));
			
			//사진
			if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
				ComAtchFileVO photoFileVO = new ComAtchFileVO();
				photoFileVO.setAtchFileSn(result.getPhotoFileSn());
				model.addAttribute("photoFile", comAtchFileService.selectComAtchFile(photoFileVO));
			}
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		}		
		
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
		return "exts/koreahana/spf/spfWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/spf/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			koreahanaSpfValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaSpfService.writeKoreahanaSpf(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/spf/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpfService.deleteKoreahanaSpf(searchVO);
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
	@RequestMapping(value="/exts/koreahana/spf/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/spf/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/spf/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfVO result = koreahanaSpfService.selectKoreahanaSpf(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/spf/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfVO result = koreahanaSpfService.selectKoreahanaSpf(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/spf/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/spf/sgnView.do")
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
	@RequestMapping(value="/exts/koreahana/spf/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/spf/spfExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/spf/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
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
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ntkrdfUnqNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hanawonFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ordpNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String eml = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String lastAcbgCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ocptInstTypeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ptexp = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String aplyMtv = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String eduFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String exslno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaSpfExcelVO exVO = new KoreahanaSpfExcelVO();
			exVO.setBizSeCd(bizSeCd);
			exVO.setSprtSn(sprtSn);
			exVO.setRegDtStr(regDtStr);
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setBrdtYmd(brdtYmd);
			exVO.setMbphno(mbphno);
			exVO.setZip(zip);
			exVO.setNtkrdfUnqNo(ntkrdfUnqNo);
			exVO.setEntcnyYmd(entcnyYmd);
			exVO.setPrtdcsYmd(prtdcsYmd);
			exVO.setHanawonFnshYmd(hanawonFnshYmd);
			exVO.setHanawonTh(hanawonTh);
			exVO.setOrdpNm(ordpNm);
			exVO.setEml(eml);
			exVO.setLastAcbgCd(lastAcbgCd);
			exVO.setOcptInstTypeCd(ocptInstTypeCd);
			exVO.setPtexp(ptexp);
			exVO.setAplyMtv(aplyMtv);
			exVO.setEduFnshYmd(eduFnshYmd);
			exVO.setSprtSttsCd(sprtSttsCd);
			exVO.setRsn(rsn);
			exVO.setExslno(exslno);
			
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaSpfExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/spf/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
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
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String zip = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ntkrdfUnqNo = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtdcsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hanawonFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String hanawonTh = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ordpNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String eml = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String lastAcbgCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ocptInstTypeCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ptexp = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String aplyMtv = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String eduFnshYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String exslno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaSpfExcelVO exVO = new KoreahanaSpfExcelVO();
				exVO.setBizSeCd(bizSeCd);
				exVO.setSprtSn(sprtSn);
				exVO.setRegDtStr(regDtStr);
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setBrdtYmd(brdtYmd);
				exVO.setMbphno(mbphno);
				exVO.setZip(zip);
				exVO.setNtkrdfUnqNo(ntkrdfUnqNo);
				exVO.setEntcnyYmd(entcnyYmd);
				exVO.setPrtdcsYmd(prtdcsYmd);
				exVO.setHanawonFnshYmd(hanawonFnshYmd);
				exVO.setHanawonTh(hanawonTh);
				exVO.setOrdpNm(ordpNm);
				exVO.setEml(eml);
				exVO.setLastAcbgCd(lastAcbgCd);
				exVO.setOcptInstTypeCd(ocptInstTypeCd);
				exVO.setPtexp(ptexp);
				exVO.setAplyMtv(aplyMtv);
				exVO.setEduFnshYmd(eduFnshYmd);
				exVO.setSprtSttsCd(sprtSttsCd);
				exVO.setRsn(rsn);
				exVO.setExslno(exslno);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaSpfExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaSpfService.excelUpload(dataList);
			
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
		
		return getResponseJsonView(model, isSuccess, msg, dataList);
	}
}
