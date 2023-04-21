package exts.koreahana.adt.web;

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
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComCodeVO;
import exts.koreahana.adt.service.KoreahanaAdtFamService;
import exts.koreahana.adt.service.KoreahanaAdtService;
import exts.koreahana.adt.validator.KoreahanaAdtValidator;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtPrcRndVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaAdtController.java
 * @Description : 가산금지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaAdtController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/adt";}
	
	@Resource(name = "koreahanaAdtService")
	private KoreahanaAdtService koreahanaAdtService;
	
	@Resource(name = "koreahanaAdtFamService")
	private KoreahanaAdtFamService koreahanaAdtFamService;
	
	@Resource(name = "koreahanaAdtValidator")
	private KoreahanaAdtValidator koreahanaAdtValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/adt/index.do")
	public String index(
			@ModelAttribute	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKaMode())))searchVO.setKaMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_ADT_SPR, request, searchVO.getKaMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/adt/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/adt/" + searchVO.getKaMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/adt/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevList(KoreahanaEnumCtgryFrstCd.ADT, searchVO, request, model);
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaAdtVO> resultList = koreahanaAdtService.selectKoreahanaAdtListExcel(searchVO);
			if(resultList != null) {
				for(KoreahanaAdtVO result:resultList) {
					result.setEntcnyYmd(JnitTag.convertDateSplitString(result.getEntcnyYmd(), "-"));
					result.setPrtdcsYmd(JnitTag.convertDateSplitString(result.getPrtdcsYmd(), "-"));
					result.setHanawonFnshYmd(JnitTag.convertDateSplitString(result.getHanawonFnshYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setBizSeCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bizSeCdList"), result.getBizSeCd()));
					
					//회차정보처리
					StringBuffer sb = new StringBuffer();
					int rndAmtTotal = 0;//총지급액
					if(result.getRndList() != null) {
						for(KoreahanaAdtPrcRndVO rnd:result.getRndList()) {
							rndAmtTotal += NullUtil.nullInt(rnd.getGiveAmt());
							if(sb.length() > 0)sb.append(",");
							sb.append(rnd.getRnd())
								.append("회")
								.append(JnitTag.convertDateSplitString(rnd.getGiveYm(), "-"))
								.append(rndAmtTotal);
						}
					}
					result.setRndConcatExcel(sb.toString());
				}
			}
			
			model.addAttribute("resultList", resultList);
			return getResponseExcelView(model, "adt", "가산금지원");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaAdtService.selectKoreahanaAdtTot(searchVO);

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
			model.addAttribute("resultList", koreahanaAdtService.selectKoreahanaAdtList(searchVO));
		}

		return "exts/koreahana/adt/adtList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/adt/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaAdtVO result = koreahanaAdtService.selectKoreahanaAdt(searchVO);
		//읽기 권한 체크
		if(!koreahanaAdtService.isViewable(result))throwBizException("com.error.noauth.view");
		

		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		
		//가족관계
		KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
		famSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("famList", koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaAdtService.isModifiable(result));
		return "exts/koreahana/adt/adtView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/adt/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//지원신청정보 관련 공통처리
		prevWrite(searchVO, request, model);
		
		
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaAdtVO result = koreahanaAdtService.selectKoreahanaAdt(searchVO);
			//읽기 권한 체크
			if(!koreahanaAdtService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가족관계
			KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
			famSearchVO.setSprtSn(searchVO.getSprtSn());
			model.addAttribute("famListJson", JsonUtil.convertObjectToJson(koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO)));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileService.selectComAtchFile(atchFileSearchVO));
		}
		
		//koreahanaSmbService.getSmbListAll(searchVO, model);				//제출서류유형
		
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		return "exts/koreahana/adt/adtWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/adt/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//지원신청정보 관련 공통처리
			prevWriteAction(searchVO, errors, request, model);
			
			
			koreahanaAdtFamService.getParamToAdtFamVO(searchVO, request);		//가산금지원가족관계
			koreahanaAdtValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaAdtService.writeKoreahanaAdt(searchVO, request);
			
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
	@RequestMapping(value="/exts/koreahana/adt/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaAdtService.deleteKoreahanaAdt(searchVO);
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
	@RequestMapping(value="/exts/koreahana/adt/writeSprtSttsActionJson.do")
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
	@RequestMapping(value="/exts/koreahana/adt/writeRsnJson.do")
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
	@RequestMapping(value="/exts/koreahana/adt/myFileDownload.do")
	public void myFileDownload(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		fileDownload(searchVO, request, response, model);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 */
	@RequestMapping(value="/exts/koreahana/adt/sprtFileAllDonwload.do")
	public void sprtTotalFileDonwload(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaAdtVO result = koreahanaAdtService.selectKoreahanaAdt(searchVO);
		//읽기 권한 체크
		if(!koreahanaAdtService.isViewable(result))throwBizException("com.error.noauth.view");
		koreahanaSprService.zipFileDownload(searchVO, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	@RequestMapping(value="/exts/koreahana/adt/imgView.do")
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
	@RequestMapping(value="/exts/koreahana/adt/sgnView.do")
	public void sgnView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc) throws Exception{
		throwDirect(request);
		
		signView(request, response, enc);
	}
}
