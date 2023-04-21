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
import exts.koreahana.fth.service.KoreahanaFthMdwService;
import exts.koreahana.fth.validator.KoreahanaFthMdwExcelValidator;
import exts.koreahana.fth.validator.KoreahanaFthMdwValidator;
import exts.koreahana.fth.vo.KoreahanaFthMdwVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaFthMdwController.java
 * @Description : 미래행복통장중도해지 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaFthMdwController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/fthMdw";}
	
	@Resource(name = "koreahanaFthMdwService")
	private KoreahanaFthMdwService koreahanaFthMdwService;

	@Resource(name = "koreahanaFthMdwValidator")
	private KoreahanaFthMdwValidator koreahanaFthMdwValidator;

	@Resource(name = "koreahanaFthMdwExcelValidator")
	private KoreahanaFthMdwExcelValidator koreahanaFthMdwExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/index.do")
	public String index(
			@ModelAttribute	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKfmMode())))searchVO.setKfmMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_FTH_MDW, request, searchVO.getKfmMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/fthMdw/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/fthMdw/" + searchVO.getKfmMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/fthMdw/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("cncltnRsnCdList",getCodeListByGrpCd(EnumGrpCd.CNCLTN_RSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getRcptYear()).equals(""))searchVO.setRcptYear(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaFthMdwVO> resultList = koreahanaFthMdwService.selectKoreahanaFthMdwList(searchVO);
			if(resultList != null) {
				for(KoreahanaFthMdwVO result:resultList) {
					if(result.getRrno() != null && result.getRrno().length() == 13)result.setRrno(result.getRrno().substring(0,6) + "-" + result.getRrno().substring(6,13));
					result.setRcptYmd(JnitTag.convertDateSplitString(result.getRcptYmd(), "-"));
					result.setCncltnYmd(JnitTag.convertDateSplitString(result.getCncltnYmd(), "-"));
					result.setBbJoinYmd(JnitTag.convertDateSplitString(result.getBbJoinYmd(), "-"));
					result.setCncltnRsnCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("cncltnRsnCdList"), result.getCncltnRsnCd()));
					result.setCtpvCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("ctpvCdList"), result.getCtpvCd()));
					result.setSggCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sggCdList"), result.getSggCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "fthMdw", "미래행복통장중도해지");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaFthMdwService.selectKoreahanaFthMdwTot(searchVO);

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
			model.addAttribute("resultList",koreahanaFthMdwService.selectKoreahanaFthMdwList(searchVO));
		}

		model.addAttribute("yearList", yearList);
		
		return "exts/koreahana/fth/fthMdwList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaFthMdwVO result = koreahanaFthMdwService.selectKoreahanaFthMdw(searchVO);
		//읽기 권한 체크
		if(!koreahanaFthMdwService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaFthMdwService.isModifiable(result));

		model.addAttribute("cncltnRsnCdList",getCodeListByGrpCd(EnumGrpCd.CNCLTN_RSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthMdwView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthMdwService.deleteKoreahanaFthMdw(searchVO);
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
	@RequestMapping(value="/exts/koreahana/fthMdw/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getFthpbbMdwCncltnSn()))) {
			KoreahanaFthMdwVO result = koreahanaFthMdwService.selectKoreahanaFthMdw(searchVO);
			//읽기 권한 체크
			if(!koreahanaFthMdwService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaFthMdwService.isModifiable(result));
		}		
		
		model.addAttribute("frontOfPhone",getFrontOfPhone());
//		model.addAttribute("frontOfTel",getFrontOfTel());

		model.addAttribute("cncltnRsnCdList",getCodeListByGrpCd(EnumGrpCd.CNCLTN_RSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthMdwWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthMdwValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaFthMdwService.writeKoreahanaFthMdw(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/fthMdw/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/fth/fthMdwExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
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
			String hanactPic = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String joinPeriodMmCnt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String cncltnRsnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String idtprsSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String fndtSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaFthMdwVO exVO = new KoreahanaFthMdwVO();
			exVO.setRcptYmd(rcptYmd);
			exVO.setCncltnYmd(cncltnYmd);
			exVO.setFlnm(flnm);
			exVO.setRrno(rrno);
			exVO.setMbphno(mbphno);
			exVO.setCtpvCd(ctpvCd);
			exVO.setSggCd(sggCd);
			exVO.setJrdcHanactNm(jrdcHanactNm);
			exVO.setHanactPic(hanactPic);
			exVO.setBbJoinYmd(bbJoinYmd);
			exVO.setJoinPeriodMmCnt(joinPeriodMmCnt);
			exVO.setCncltnRsnCd(cncltnRsnCd);
			exVO.setIdtprsSavingAmt(idtprsSavingAmt);
			exVO.setFndtSavingAmt(fndtSavingAmt);
			exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
			exVO.setStmchkActno(stmchkActno);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaFthMdwExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/fthMdw/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthMdwVO searchVO,
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
				String hanactPic = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String joinPeriodMmCnt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String cncltnRsnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String idtprsSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String fndtSavingAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaFthMdwVO exVO = new KoreahanaFthMdwVO();
				exVO.setRcptYmd(rcptYmd);
				exVO.setCncltnYmd(cncltnYmd);
				exVO.setFlnm(flnm);
				exVO.setRrno(rrno);
				exVO.setMbphno(mbphno);
				exVO.setCtpvCd(ctpvCd);
				exVO.setSggCd(sggCd);
				exVO.setJrdcHanactNm(jrdcHanactNm);
				exVO.setHanactPic(hanactPic);
				exVO.setBbJoinYmd(bbJoinYmd);
				exVO.setJoinPeriodMmCnt(joinPeriodMmCnt);
				exVO.setCncltnRsnCd(cncltnRsnCd);
				exVO.setIdtprsSavingAmt(idtprsSavingAmt);
				exVO.setFndtSavingAmt(fndtSavingAmt);
				exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
				exVO.setStmchkActno(stmchkActno);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaFthMdwExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaFthMdwService.excelUpload(dataList);
			
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
