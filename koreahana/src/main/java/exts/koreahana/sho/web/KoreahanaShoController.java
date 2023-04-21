package exts.koreahana.sho.web;

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
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.sho.service.KoreahanaShoService;
import exts.koreahana.sho.validator.KoreahanaShoExcelValidator;
import exts.koreahana.sho.validator.KoreahanaShoValidator;
import exts.koreahana.sho.vo.KoreahanaShoVO;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaShoController.java
 * @Description : 장학금지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaShoController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/sho";}
	
	@Resource(name = "koreahanaShoService")
	private KoreahanaShoService koreahanaShoService;
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	
	@Resource(name = "koreahanaShoValidator")
	private KoreahanaShoValidator koreahanaShoValidator;
	
	@Resource(name = "koreahanaShoExcelValidator")
	private KoreahanaShoExcelValidator koreahanaShoExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/sho/index.do")
	public String index(
			@ModelAttribute	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_SHO_SPR, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/sho/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/sho/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/sho/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		prevList(KoreahanaEnumCtgryFrstCd.SHO, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaShoVO> resultList = koreahanaShoService.selectKoreahanaShoListExcel(searchVO);
			if(resultList != null) {
				for(KoreahanaShoVO result:resultList) {
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd HH:mm:ss"));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setSearchNtkYn( "".equals(NullUtil.nullString(result.getNtkrdfUnqNo())) ? "제3국출생" : "북한이탈주민" );
					
					//장학금유형
					if("ntkrdf1".equals(result.getSholSlctnType()) || "thirdcnty1".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("대학원생");
					}else if("ntkrdf2_1".equals(result.getSholSlctnType()) || "thirdcnty2_1".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("대학생(연속지원)");
					}else if("ntkrdf2_2".equals(result.getSholSlctnType()) || "thirdcnty2_2".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("대학생(1회지원)");
					}else if("ntkrdf2_3".equals(result.getSholSlctnType()) || "thirdcnty2_3".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("대학생(전문대)");
					}else if("ntkrdf2_4".equals(result.getSholSlctnType()) || "thirdcnty2_4".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("대학생(사이버/방송/통신대)");
					}else if("ntkrdf3".equals(result.getSholSlctnType()) || "thirdcnty3".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("계절학기 수강생");
					}else if("ntkrdf4_1".equals(result.getSholSlctnType()) || "thirdcnty4_1".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("중학생");
					}else if("ntkrdf4_2".equals(result.getSholSlctnType()) || "thirdcnty4_2".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("고등학생");
					}else if("ntkrdf5".equals(result.getSholSlctnType()) || "thirdcnty5".equals(result.getSholSlctnType())) {
						result.setSearchSholSlctnType("검정고시 합격생");
					}
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "sho", "장학금지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaShoService.selectKoreahanaShoTot(searchVO);

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
			model.addAttribute("resultList",koreahanaShoService.selectKoreahanaShoList(searchVO));
		}
		
		
		return "exts/koreahana/sho/shoList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/sho/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoVO result = koreahanaShoService.selectKoreahanaSho(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//북한이탈주민 인증서파일
		if(!"".equals(NullUtil.nullString(result.getNtkrdfAcrtfctFileSn()))) {
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
			model.addAttribute("ntkrdfAcrtfctFile", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		}
				
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaShoService.isModifiable(result));
		return "exts/koreahana/sho/shoView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/sho/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
				
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaShoVO result = koreahanaShoService.selectKoreahanaSho(searchVO);
			//읽기 권한 체크
			if(!koreahanaShoService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//북한이탈주민 인증서파일
			if(!"".equals(NullUtil.nullString(result.getNtkrdfAcrtfctFileSn()))) {
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
				model.addAttribute("ntkrdfAcrtfctFile", comAtchFileService.selectComAtchFile(atchFileSearchVO));
			}
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		}	
		
		return "exts/koreahana/sho/shoWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/sho/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
			
			//북한이탈주민 인증서
			List<String> atchFileSmbSnList = comAtchFileService.writeComAtchUploadFile(request, "ntkrdfAcrtfctFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : atchFileSmbSnList) {
				searchVO.setNtkrdfAcrtfctFileSn(atchFileSn);
			}
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			koreahanaShoValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaShoService.writeKoreahanaSho(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/sho/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaShoService.deleteKoreahanaSho(searchVO);
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
	@RequestMapping(value="/exts/koreahana/sho/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/sho/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/sho/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoVO result = koreahanaShoService.selectKoreahanaSho(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoService.isViewable(result))throwBizException("com.error.noauth.view");
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/sho/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoVO result = koreahanaShoService.selectKoreahanaSho(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getNtkrdfAcrtfctFileSn(), request, response);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/sho/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoVO result = koreahanaShoService.selectKoreahanaSho(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/sho/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/sho/sgnView.do")
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
	@RequestMapping(value="/exts/koreahana/sho/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/sho/shoExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/sho/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
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
			String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String searchNtkYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String searchSholSlctnType = NullUtil.nullString((String)job.get(String.valueOf(j++)));
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
			String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaShoVO exVO = new KoreahanaShoVO();
			exVO.setSprtSn(sprtSn);
			exVO.setRegDtStr(regDtStr);
			exVO.setSearchNtkYn(searchNtkYn);
			exVO.setSearchSholSlctnType(searchSholSlctnType);
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
			exVO.setSprtSttsCd(sprtSttsCd);
			exVO.setRsn(rsn);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaShoExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/sho/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
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
				String sprtSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String regDtStr = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String searchNtkYn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String searchSholSlctnType = NullUtil.nullString((String)job.get(String.valueOf(j++)));
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
				String sprtSttsCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rsn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaShoVO exVO = new KoreahanaShoVO();
				exVO.setSprtSn(sprtSn);
				exVO.setRegDtStr(regDtStr);
				exVO.setSearchNtkYn(searchNtkYn);
				exVO.setSearchSholSlctnType(searchSholSlctnType);
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
				exVO.setSprtSttsCd(sprtSttsCd);
				exVO.setRsn(rsn);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaShoExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaShoService.excelUpload(dataList);
			
			//log
			int successCnt = 0;
			for(ComExcelValidationResultVO result:dataList) {
				if(result.isSuccess())successCnt++;
			}
			insertComMbrLog(request, EnumMenuCd.SPR_SHO, "엑셀업로드(성공:" + successCnt + "건)");
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
