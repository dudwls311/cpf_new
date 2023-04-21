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
import exts.koreahana.fth.service.KoreahanaFthNewService;
import exts.koreahana.fth.validator.KoreahanaFthNewExcelValidator;
import exts.koreahana.fth.validator.KoreahanaFthNewValidator;
import exts.koreahana.fth.vo.KoreahanaFthNewVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaFthController.java
 * @Description : 미래행복통장신규신청 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaFthNewController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/fthNew";}
	
	@Resource(name = "koreahanaFthNewService")
	private KoreahanaFthNewService koreahanaFthNewService;

	@Resource(name = "koreahanaFthNewValidator")
	private KoreahanaFthNewValidator koreahanaFthNewValidator;

	@Resource(name = "koreahanaFthNewExcelValidator")
	private KoreahanaFthNewExcelValidator koreahanaFthNewExcelValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/index.do")
	public String index(
			@ModelAttribute	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKfnMode())))searchVO.setKfnMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_FTH_NEW, request, searchVO.getKfnMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/fthNew/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/fthNew/" + searchVO.getKfnMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/fthNew/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("ageCdList",getCodeListByGrpCd(EnumGrpCd.AGE_CD));
		model.addAttribute("ecnmatCdList",getCodeListByGrpCd(EnumGrpCd.ECNMAT_CD));
		model.addAttribute("crCdList",getCodeListByGrpCd(EnumGrpCd.CR_CD));
		model.addAttribute("prtprdExtsnCdList",getCodeListByGrpCd(EnumGrpCd.PRTPRD_EXTSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		List<Integer> yearList = getYearList();
		if(NullUtil.nullString(searchVO.getRcptYear()).equals(""))searchVO.setRcptYear(String.valueOf(yearList.get(0)));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaFthNewVO> resultList = koreahanaFthNewService.selectKoreahanaFthNewList(searchVO);
			if(resultList != null) {
				for(KoreahanaFthNewVO result:resultList) {
					if(result.getRrno() != null && result.getRrno().length() == 13)result.setRrno(result.getRrno().substring(0,6) + "-" + result.getRrno().substring(6,13));
					result.setRcptYmd(JnitTag.convertDateSplitString(result.getRcptYmd(), "-"));
					result.setEmplisJoinYmd(JnitTag.convertDateSplitString(result.getEmplisJoinYmd(), "-"));
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setEntiscYmd(JnitTag.convertDateSplitString(result.getEntiscYmd(), "-"));
					result.setTrinsExpryYmd(JnitTag.convertDateSplitString(result.getTrinsExpryYmd(), "-"));
					result.setBbJoinYmd(JnitTag.convertDateSplitString(result.getBbJoinYmd(), "-"));
					result.setSavingDdlnYmd(JnitTag.convertDateSplitString(result.getSavingDdlnYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setAgeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("ageCdList"), result.getAgeCd()));
					result.setEcnmatCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("ecnmatCdList"), result.getEcnmatCd()));
					result.setCrCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("crCdList"), result.getCrCd()));
					result.setPrtprdExtsnCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("prtprdExtsnCdList"), result.getPrtprdExtsnCd()));
					result.setCtpvCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("ctpvCdList"), result.getCtpvCd()));
					result.setSggCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sggCdList"), result.getSggCd()));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "fthNew", "미래행복통장신규신청");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaFthNewService.selectKoreahanaFthNewTot(searchVO);

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
			model.addAttribute("resultList",koreahanaFthNewService.selectKoreahanaFthNewList(searchVO));
		}

		model.addAttribute("yearList", yearList);
		
		return "exts/koreahana/fth/fthNewList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaFthNewVO result = koreahanaFthNewService.selectKoreahanaFthNew(searchVO);
		//읽기 권한 체크
		if(!koreahanaFthNewService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaFthNewService.isModifiable(result));

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("ageCdList",getCodeListByGrpCd(EnumGrpCd.AGE_CD));
		model.addAttribute("ecnmatCdList",getCodeListByGrpCd(EnumGrpCd.ECNMAT_CD));
		model.addAttribute("crCdList",getCodeListByGrpCd(EnumGrpCd.CR_CD));
		model.addAttribute("prtprdExtsnCdList",getCodeListByGrpCd(EnumGrpCd.PRTPRD_EXTSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthNewView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthNewService.deleteKoreahanaFthNew(searchVO);
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
	@RequestMapping(value="/exts/koreahana/fthNew/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		if(!"".equals(NullUtil.nullString(searchVO.getFthpbbNewAplySn()))) {
			KoreahanaFthNewVO result = koreahanaFthNewService.selectKoreahanaFthNew(searchVO);
			//읽기 권한 체크
			if(!koreahanaFthNewService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaFthNewService.isModifiable(result));
		}		
		
		model.addAttribute("frontOfPhone",getFrontOfPhone());
//		model.addAttribute("frontOfTel",getFrontOfTel());

		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("ageCdList",getCodeListByGrpCd(EnumGrpCd.AGE_CD));
		model.addAttribute("ecnmatCdList",getCodeListByGrpCd(EnumGrpCd.ECNMAT_CD));
		model.addAttribute("crCdList",getCodeListByGrpCd(EnumGrpCd.CR_CD));
		model.addAttribute("prtprdExtsnCdList",getCodeListByGrpCd(EnumGrpCd.PRTPRD_EXTSN_CD));
		model.addAttribute("ctpvCdList",getCodeListByGrpCd(EnumGrpCd.CTPV_CD));
		model.addAttribute("sggCdList",getCodeListByGrpCd(EnumGrpCd.SGG_CD));
		
		return "exts/koreahana/fth/fthNewWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaFthNewValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaFthNewService.writeKoreahanaFthNew(searchVO);
			
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
	@RequestMapping(value="/exts/koreahana/fthNew/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/fth/fthNewExcelUpload";
	}

	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
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
			String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rrno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ageCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ctpvCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sggCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String ecnmatCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String crCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String coNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String emplisJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String salaryAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String dcsnSprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String jrdcHanactNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String entiscYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String trinsExpryYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String savingDdlnYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String prtprdExtsnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaFthNewVO exVO = new KoreahanaFthNewVO();
			exVO.setFlnm(flnm);
			exVO.setGenderCd(genderCd);
			exVO.setRrno(rrno);
			exVO.setAgeCd(ageCd);
			exVO.setMbphno(mbphno);
			exVO.setCtpvCd(ctpvCd);
			exVO.setSggCd(sggCd);
			exVO.setEcnmatCd(ecnmatCd);
			exVO.setCrCd(crCd);
			exVO.setCoNm(coNm);
			exVO.setEmplisJoinYmd(emplisJoinYmd);
			exVO.setSalaryAmt(salaryAmt);
			exVO.setEntcnyYmd(entcnyYmd);
			exVO.setEntiscYmd(entiscYmd);
			exVO.setTrinsExpryYmd(trinsExpryYmd);
			exVO.setRcptYmd(rcptYmd);
			exVO.setJrdcHanactNm(jrdcHanactNm);
			exVO.setDcsnSprtAmt(dcsnSprtAmt);
			exVO.setBbJoinYmd(bbJoinYmd);
			exVO.setSavingDdlnYmd(savingDdlnYmd);
			exVO.setPrtprdExtsnCd(prtprdExtsnCd);
			exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
			exVO.setStmchkActno(stmchkActno);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaFthNewExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/fthNew/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaFthNewVO searchVO,
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
				String flnm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rrno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ageCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String genderCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String mbphno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ctpvCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sggCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String ecnmatCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String crCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String coNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String emplisJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String salaryAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String dcsnSprtAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String jrdcHanactNm = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entcnyYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String entiscYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String trinsExpryYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String bbJoinYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String savingDdlnYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String prtprdExtsnCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String idtprsSavingAmtActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String stmchkActno = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaFthNewVO exVO = new KoreahanaFthNewVO();
				exVO.setFlnm(flnm);
				exVO.setGenderCd(genderCd);
				exVO.setRrno(rrno);
				exVO.setAgeCd(ageCd);
				exVO.setMbphno(mbphno);
				exVO.setCtpvCd(ctpvCd);
				exVO.setSggCd(sggCd);
				exVO.setEcnmatCd(ecnmatCd);
				exVO.setCrCd(crCd);
				exVO.setCoNm(coNm);
				exVO.setEmplisJoinYmd(emplisJoinYmd);
				exVO.setSalaryAmt(salaryAmt);
				exVO.setEntcnyYmd(entcnyYmd);
				exVO.setEntiscYmd(entiscYmd);
				exVO.setTrinsExpryYmd(trinsExpryYmd);
				exVO.setRcptYmd(rcptYmd);
				exVO.setJrdcHanactNm(jrdcHanactNm);
				exVO.setDcsnSprtAmt(dcsnSprtAmt);
				exVO.setBbJoinYmd(bbJoinYmd);
				exVO.setSavingDdlnYmd(savingDdlnYmd);
				exVO.setPrtprdExtsnCd(prtprdExtsnCd);
				exVO.setIdtprsSavingAmtActno(idtprsSavingAmtActno);
				exVO.setStmchkActno(stmchkActno);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaFthNewExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaFthNewService.excelUpload(dataList);
			
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
