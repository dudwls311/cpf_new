package exts.koreahana.spf.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.spf.service.KoreahanaSpfPrcService;
import exts.koreahana.spf.service.KoreahanaSpfQlfService;
import exts.koreahana.spf.validator.KoreahanaSpfPrcValidator;
import exts.koreahana.spf.vo.KoreahanaSpfPrcExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;
import jnit.com.tag.JnitTag;
import jnit.crypto.JnitCryptoService;


/**
 * @Class Name : KoreahanaSpfPrcController.java
 * @Description : 정착지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSpfPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/spfPrc";}
	
	@Resource(name = "koreahanaSpfPrcService")
	private KoreahanaSpfPrcService koreahanaSpfPrcService;

	@Resource(name = "koreahanaSpfPrcValidator")
	private KoreahanaSpfPrcValidator koreahanaSpfPrcValidator;
	
	@Resource(name = "koreahanaSpfQlfService")
	private KoreahanaSpfQlfService koreahanaSpfQlfService;

	@Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKspMode())))searchVO.setKspMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_SPF_PRC, request, searchVO.getKspMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/spfPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/spfPrc/" + searchVO.getKspMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/spfPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.SPF, searchVO, request, model);

		model.addAttribute("testRsltCdList", getCodeListByGrpCd(EnumGrpCd.TEST_RSLT_CD));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaSpfPrcExcelVO> resultList = koreahanaSpfPrcService.selectKoreahanaSpfPrcListExcel(searchVO);
			
			if(resultList != null) {
				String lastAcbgCd = "";		//최종학력코드
				String ocptInstTypeCd = "";	//종사기관유형코드
				
				model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
				model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
				
				for(KoreahanaSpfPrcExcelVO result : resultList) {
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
					result.setTestYmd(JnitTag.convertDateSplitString(result.getTestYmd(), "-"));
					result.setSccdPrsntnYmd(JnitTag.convertDateSplitString(result.getSccdPrsntnYmd(), "-"));
					result.setPassYmd(JnitTag.convertDateSplitString(result.getPassYmd(), "-"));
					result.setTestRsltCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("testRsltCdList"), result.getTestRsltCd()));
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "spfPrc", "정착지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaSpfPrcService.selectKoreahanaSpfPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaSpfPrcService.selectKoreahanaSpfPrcList(searchVO));
		}
		
		
		return "exts/koreahana/spf/spfPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfPrcVO result = koreahanaSpfPrcService.selectKoreahanaSpfPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaSpfPrcService.isModifiable(result));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("testRsltCdList", getCodeListByGrpCd(EnumGrpCd.TEST_RSLT_CD));
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));

		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			model.addAttribute("photoFile", comAtchFileService.selectComAtchFile(photoFileVO));
		}
		
		//시험정보가져오기
		KoreahanaSpfQlfVO qlfVO = new KoreahanaSpfQlfVO();
		qlfVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("qlfResult", koreahanaSpfQlfService.selectKoreahanaSpfQlf(qlfVO));
		
		return "exts/koreahana/spf/spfPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpfPrcService.deleteKoreahanaSpfPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/spfPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfPrcVO result = koreahanaSpfPrcService.selectKoreahanaSpfPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaSpfPrcService.isModifiable(result));
		
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("testRsltCdList", getCodeListByGrpCd(EnumGrpCd.TEST_RSLT_CD));
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));

		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			photoFileVO = comAtchFileService.selectComAtchFile(photoFileVO);
			if(photoFileVO != null) model.addAttribute("photoFileEnc", jnitCryptoService.encrypt(result.getSprtSn()+"||"+photoFileVO.getAtchFileSn()));
		}
		
		//시험정보가져오기
		KoreahanaSpfQlfVO qlfVO = new KoreahanaSpfQlfVO();
		qlfVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("qlfResult", koreahanaSpfQlfService.selectKoreahanaSpfQlf(qlfVO));
		
		return "exts/koreahana/spf/spfPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpfPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaSpfPrcService.writeKoreahanaSpfPrc(searchVO);
			
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
	 * 수험표출력
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/print.do")
	public String print(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfPrcVO result = koreahanaSpfPrcService.selectKoreahanaSpfPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("testRsltCdList", getCodeListByGrpCd(EnumGrpCd.TEST_RSLT_CD));
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
		

		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			model.addAttribute("photoFile", comAtchFileService.selectComAtchFile(photoFileVO));
		}
		
		//시험정보가져오기
		KoreahanaSpfQlfVO qlfVO = new KoreahanaSpfQlfVO();
		qlfVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("qlfResult", koreahanaSpfQlfService.selectKoreahanaSpfQlf(qlfVO));
		
		return "exts/koreahana/spf/spfPrcPrint";
	}

	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/spfPrc/imgView.do")
	public void imgView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		imageView(request, response, enc);
	}
	
}
