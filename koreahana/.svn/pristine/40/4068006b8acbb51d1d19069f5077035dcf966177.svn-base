package exts.koreahana.fth.web;

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
import exts.koreahana.fth.service.KoreahanaFthMtrService;
import exts.koreahana.fth.validator.KoreahanaFthMtrExcelValidator;
import exts.koreahana.fth.validator.KoreahanaFthMtrValidator;
import exts.koreahana.fth.vo.KoreahanaFthMtrVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaFthMtrController.java
 * @Description : 미래행복통장만기해지 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaFthMtrController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/fthMtr";}
	
	@Resource(name = "koreahanaFthMtrService")
	private KoreahanaFthMtrService koreahanaFthMtrService;

	@Resource(name = "koreahanaFthMtrValidator")
	private KoreahanaFthMtrValidator koreahanaFthMtrValidator;

	@Resource(name = "koreahanaFthMtrExcelValidator")
	private KoreahanaFthMtrExcelValidator koreahanaFthMtrExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/index.do")
	public String index(
			@ModelAttribute	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKfmMode())))searchVO.setKfmMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_FTH_MTR, request, searchVO.getKfmMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/fthMtr/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/fthMtr/" + searchVO.getKfmMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/fthMtr/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("usdusgCdList",getCodeListByGrpCd(EnumGrpCd.USDUSG_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getRcptYear()).equals(""))searchVO.setRcptYear(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaFthMtrVO> resultList = koreahanaFthMtrService.selectKoreahanaFthMtrList(searchVO);
			if(resultList != null) {
				for(KoreahanaFthMtrVO result:resultList) {
					if(result.getRrno() != null && result.getRrno().length() == 13)result.setRrno(result.getRrno().substring(0,6) + "-" + result.getRrno().substring(6,13));
					result.setRcptYmd(JnitTag.convertDateSplitString(result.getRcptYmd(), "-"));
					result.setCncltnYmd(JnitTag.convertDateSplitString(result.getCncltnYmd(), "-"));
					result.setBbJoinYmd(JnitTag.convertDateSplitString(result.getBbJoinYmd(), "-"));
					result.setFncEduTkclsYmd(JnitTag.convertDateSplitString(result.getFncEduTkclsYmd(), "-"));
					result.setUsdusgCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("usdusgCdList"), result.getUsdusgCd()));
					result.setCtpvCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("ctpvCdList"), result.getCtpvCd()));
					result.setSggCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sggCdList"), result.getSggCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "fthMtr", "미래행복통장만기해지");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaFthMtrService.selectKoreahanaFthMtrTot(searchVO);

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
			model.addAttribute("resultList",koreahanaFthMtrService.selectKoreahanaFthMtrList(searchVO));
		}

		model.addAttribute("yearList", yearList);
		
		return "exts/koreahana/fth/fthMtrList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaFthMtrVO result = koreahanaFthMtrService.selectKoreahanaFthMtr(searchVO);
		//읽기 권한 체크
		if(!koreahanaFthMtrService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaFthMtrService.isModifiable(result));

		model.addAttribute("usdusgCdList",getCodeListByGrpCd(EnumGrpCd.USDUSG_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthMtrView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthMtrService.deleteKoreahanaFthMtr(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		model.addAttribute("usdusgCdList",getCodeListByGrpCd(EnumGrpCd.USDUSG_CD));
		
		return getResponseJsonView(model, isSuccess, msg);
	}


	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getFthpbbMtryCncltnSn()))) {
			KoreahanaFthMtrVO result = koreahanaFthMtrService.selectKoreahanaFthMtr(searchVO);
			//읽기 권한 체크
			if(!koreahanaFthMtrService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaFthMtrService.isModifiable(result));
		}		
		
		model.addAttribute("frontOfPhone",getFrontOfPhone());
//		model.addAttribute("frontOfTel",getFrontOfTel());

		model.addAttribute("usdusgCdList",getCodeListByGrpCd(EnumGrpCd.USDUSG_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthMtrWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthMtrValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaFthMtrService.writeKoreahanaFthMtr(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/fthMtr/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/fth/fthMtrExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
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
			String rcptYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String cncltnYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rrno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ctpvCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sggCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String jrdcHanactNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String usdusgCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String idtprsSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String fndtSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mtryMmCnt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String fncEduTkclsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaFthMtrVO exVO = new KoreahanaFthMtrVO();
			exVO.setRcptYmd(rcptYmd);
			exVO.setCncltnYmd(cncltnYmd);
			exVO.setFlnm(flnm);
			exVO.setRrno(rrno);
			exVO.setMbphno(mbphno);
			exVO.setCtpvCd(ctpvCd);
			exVO.setSggCd(sggCd);
			exVO.setJrdcHanactNm(jrdcHanactNm);
			exVO.setBbJoinYmd(bbJoinYmd);
			exVO.setUsdusgCd(usdusgCd);
			exVO.setIdtprsSavingAmt(idtprsSavingAmt);
			exVO.setFndtSavingAmt(fndtSavingAmt);
			exVO.setMtryMmCnt(mtryMmCnt);
			exVO.setFncEduTkclsYmd(fncEduTkclsYmd);
			exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
			exVO.setStmchkActno(stmchkActno);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaFthMtrExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/fthMtr/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMtrVO searchVO,
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
				String rcptYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String cncltnYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rrno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ctpvCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sggCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String jrdcHanactNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String usdusgCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String idtprsSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String fndtSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mtryMmCnt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String fncEduTkclsYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaFthMtrVO exVO = new KoreahanaFthMtrVO();
				exVO.setRcptYmd(rcptYmd);
				exVO.setCncltnYmd(cncltnYmd);
				exVO.setFlnm(flnm);
				exVO.setRrno(rrno);
				exVO.setMbphno(mbphno);
				exVO.setCtpvCd(ctpvCd);
				exVO.setSggCd(sggCd);
				exVO.setJrdcHanactNm(jrdcHanactNm);
				exVO.setBbJoinYmd(bbJoinYmd);
				exVO.setUsdusgCd(usdusgCd);
				exVO.setIdtprsSavingAmt(idtprsSavingAmt);
				exVO.setFndtSavingAmt(fndtSavingAmt);
				exVO.setMtryMmCnt(mtryMmCnt);
				exVO.setFncEduTkclsYmd(fncEduTkclsYmd);
				exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
				exVO.setStmchkActno(stmchkActno);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaFthMtrExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaFthMtrService.excelUpload(dataList);
			
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
