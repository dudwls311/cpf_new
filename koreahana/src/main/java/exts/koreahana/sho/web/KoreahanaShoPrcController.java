package exts.koreahana.sho.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.sho.service.KoreahanaShoPrcService;
import exts.koreahana.sho.validator.KoreahanaShoExcelValidator;
import exts.koreahana.sho.validator.KoreahanaShoPrcExcelValidator;
import exts.koreahana.sho.validator.KoreahanaShoPrcValidator;
import exts.koreahana.sho.vo.KoreahanaShoPrcVO;
import jnit.com.tag.JnitTag;
import net.sf.json.JSONObject;


/**
 * @Class Name : KoreahanaShoPrcController.java
 * @Description : 장학금지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaShoPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/shoPrc";}
	
	@Resource(name = "koreahanaShoPrcService")
	private KoreahanaShoPrcService koreahanaShoPrcService;

	@Resource(name = "koreahanaShoPrcValidator")
	private KoreahanaShoPrcValidator koreahanaShoPrcValidator;
	
	@Resource(name = "koreahanaShoPrcExcelValidator")
	private KoreahanaShoPrcExcelValidator koreahanaShoPrcExcelValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKspMode())))searchVO.setKspMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_SHO_PRC, request, searchVO.getKspMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/shoPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/shoPrc/" + searchVO.getKspMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/shoPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.SHO, searchVO, request, model);

		model.addAttribute("slctnMthdCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MTHD_CD));
		model.addAttribute("slctnMmtCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MMT_CD));
		model.addAttribute("fncrscCdList", getCodeListByGrpCd(EnumGrpCd.FNCRSC_CD));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaShoPrcVO> resultList = koreahanaShoPrcService.selectKoreahanaShoPrcList(searchVO);
			if(resultList != null) {
				for(KoreahanaShoPrcVO result:resultList) {
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd HH:mm:ss"));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setSearchNtkYn( "".equals(NullUtil.nullString(result.getNtkrdfUnqNo())) ? "제3국출생" : "북한이탈주민" );
					result.setSlctnMthdCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("slctnMthdCdList"), result.getSlctnMthdCd()));
					result.setSlctnMmtCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("slctnMmtCdList"), result.getSlctnMmtCd()));
					result.setFncrscCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("fncrscCdList"), result.getFncrscCd()));
					result.setGiveYmd(JnitTag.convertDateSplitString(result.getGiveYmd(), "-"));

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
			return getResponseExcelView(model, "shoPrc", "장학금지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaShoPrcService.selectKoreahanaShoPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaShoPrcService.selectKoreahanaShoPrcList(searchVO));
		}
		
		return "exts/koreahana/sho/shoPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoPrcVO result = koreahanaShoPrcService.selectKoreahanaShoPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaShoPrcService.isModifiable(result));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("slctnMthdCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MTHD_CD));
		model.addAttribute("slctnMmtCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MMT_CD));
		model.addAttribute("fncrscCdList", getCodeListByGrpCd(EnumGrpCd.FNCRSC_CD));
		return "exts/koreahana/sho/shoPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaShoPrcService.deleteKoreahanaShoPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/shoPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoPrcVO result = koreahanaShoPrcService.selectKoreahanaShoPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaShoPrcService.isModifiable(result));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("slctnMthdCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MTHD_CD));
		model.addAttribute("slctnMmtCdList", getCodeListByGrpCd(EnumGrpCd.SLCTN_MMT_CD));
		model.addAttribute("fncrscCdList", getCodeListByGrpCd(EnumGrpCd.FNCRSC_CD));
		
		return "exts/koreahana/sho/shoPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaShoPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaShoPrcService.writeKoreahanaShoPrc(searchVO);
			
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
	 * 통계분기문
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/statistic.do")
	public String statistic(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_SHO_STT, request, "statistic");				//분기공통처리
		
		prevPrcList(KoreahanaEnumCtgryFrstCd.SHO, searchVO, request, model);
		
		EgovMap egovMap = new EgovMap();
		egovMap.put("pbancrcSn", searchVO.getPbancrcSn());
		egovMap.put("sprtSttsCd", KoreahanaEnumSprtSttsCd.TMP.getCode());//임시제외
		model.addAttribute("resultList",koreahanaShoPrcService.selectKoreahanaShoPrcListStatistic(egovMap));
		return "exts/koreahana/sho/shoPrcStatistic";
	}
	
	
	/**
	 * 엑셀 업로드 폼
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/excelUpload.do")
	public String excelUpload(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		return "exts/koreahana/sho/shoPrcExcelUpload";
	}
	
	/**
	 * 엑셀 정합성 검사
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/excelValidationActionJson.do")
	public String excelValidationActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
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
			String sholSprtPrcnMngSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
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
			
			//지급정보
			String slctnMthdCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String slctnMmtCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String fncrscCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String giveYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String sholGiveAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
			
			KoreahanaShoPrcVO exVO = new KoreahanaShoPrcVO();
			exVO.setSprtSn(sprtSn);
			exVO.setSholSprtPrcnMngSn(sholSprtPrcnMngSn);
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
			exVO.setSlctnMthdCd(slctnMthdCd);
			exVO.setSlctnMmtCd(slctnMmtCd);
			exVO.setFncrscCd(fncrscCd);
			exVO.setGiveYmd(giveYmd);
			exVO.setSholGiveAmt(sholGiveAmt);
			exVO.setRmrk(rmrk);
			
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
			koreahanaShoPrcExcelValidator.validate(exVO, errors);
			
			ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
			dataList.add(result);
		}
		
		return getResponseJsonView(model, dataList);
	}
	

	/**
	 * 엑셀 일괄 업로드
	 */
	@RequestMapping(value="/exts/koreahana/shoPrc/excelUploadActionJson.do")
	public String excelUploadActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoPrcVO searchVO,
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
				String sholSprtPrcnMngSn = NullUtil.nullString((String)job.get(String.valueOf(j++)));
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
				
				//지급정보
				String slctnMthdCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String slctnMmtCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String fncrscCd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String giveYmd = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String sholGiveAmt = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				String rmrk = NullUtil.nullString((String)job.get(String.valueOf(j++)));
				
				KoreahanaShoPrcVO exVO = new KoreahanaShoPrcVO();
				exVO.setSprtSn(sprtSn);
				exVO.setSholSprtPrcnMngSn(sholSprtPrcnMngSn);
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
				exVO.setSlctnMthdCd(slctnMthdCd);
				exVO.setSlctnMmtCd(slctnMmtCd);
				exVO.setFncrscCd(fncrscCd);
				exVO.setGiveYmd(giveYmd);
				exVO.setSholGiveAmt(sholGiveAmt);
				exVO.setRmrk(rmrk);
				
				BeanPropertyBindingResult errors = new BeanPropertyBindingResult(exVO, "exVO");
				koreahanaShoPrcExcelValidator.validate(exVO, errors);
				
				ComExcelValidationResultVO result = new ComExcelValidationResultVO(i, exVO, errors);
				dataList.add(result);
			}
			koreahanaShoPrcService.excelUpload(dataList);
			
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
