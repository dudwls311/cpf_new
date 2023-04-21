package exts.koreahana.edu.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.edu.service.KoreahanaEduPrcService;
import exts.koreahana.edu.validator.KoreahanaEduPrcValidator;
import exts.koreahana.edu.vo.KoreahanaEduPrcVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEduPrcController.java
 * @Description : 교육지원금지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEduPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/eduPrc";}
	
	@Resource(name = "koreahanaEduPrcService")
	private KoreahanaEduPrcService koreahanaEduPrcService;

	@Resource(name = "koreahanaEduPrcValidator")
	private KoreahanaEduPrcValidator koreahanaEduPrcValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/eduPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaEduPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKepMode())))searchVO.setKepMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EDU_PRC, request, searchVO.getKepMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/eduPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/eduPrc/" + searchVO.getKepMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/eduPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEduPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		prevPrcList(KoreahanaEnumCtgryFrstCd.EDU, searchVO, request, model);
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);

			List<KoreahanaEduPrcVO> resultList = koreahanaEduPrcService.selectKoreahanaEduPrcList(searchVO);
			if(resultList != null) {
				for(KoreahanaEduPrcVO result:resultList) {
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd HH:mm:ss"));
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBacntBankCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("bankCdList"), result.getBacntBankCd()));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setGiveYmd(JnitTag.convertDateSplitString(result.getGiveYmd(), "-"));
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "eduPrc", "교육지원금지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEduPrcService.selectKoreahanaEduPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEduPrcService.selectKoreahanaEduPrcList(searchVO));
		}

		
		return "exts/koreahana/edu/eduPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/eduPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEduPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEduPrcVO result = koreahanaEduPrcService.selectKoreahanaEduPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEduPrcService.isModifiable(result));
		
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));						//성별코드
		return "exts/koreahana/edu/eduPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/eduPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEduPrcService.deleteKoreahanaEduPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/eduPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEduPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEduPrcVO result = koreahanaEduPrcService.selectKoreahanaEduPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEduPrcService.isModifiable(result));
		
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));						//성별코드
		return "exts/koreahana/edu/eduPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/eduPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEduPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaEduPrcService.writeKoreahanaEduPrc(searchVO);
			
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
}
