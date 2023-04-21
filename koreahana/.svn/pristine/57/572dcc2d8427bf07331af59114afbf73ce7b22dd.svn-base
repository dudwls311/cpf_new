package exts.koreahana.vdo.web;

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
import exts.koreahana.com.enums.KoreahanaEnumExistBnfCd;
import exts.koreahana.com.enums.KoreahanaEnumVdoType;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.vdo.service.KoreahanaVdoPrcService;
import exts.koreahana.vdo.validator.KoreahanaVdoPrcValidator;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaVdoPrcController.java
 * @Description : 화상영어교육현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaVdoPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/vdoPrc";}
	
	@Resource(name = "koreahanaVdoPrcService")
	private KoreahanaVdoPrcService koreahanaVdoPrcService;

	@Resource(name = "koreahanaVdoPrcValidator")
	private KoreahanaVdoPrcValidator koreahanaVdoPrcValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/vdoPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaVdoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKvpMode())))searchVO.setKvpMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_VDO_PRC, request, searchVO.getKvpMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/vdoPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/vdoPrc/" + searchVO.getKvpMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/vdoPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaVdoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.VDO, searchVO, request, model);
		
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaVdoPrcExcelVO> resultList = koreahanaVdoPrcService.selectKoreahanaVdoPrcListExcel(searchVO);
			if(resultList != null) {
				String eduSprtTrprRelCd = "";
				for(KoreahanaVdoPrcExcelVO result : resultList) {
					//교육지원대상자관계코드 값이 없으면 상세값 설정
					eduSprtTrprRelCd = JnitTag.getCdNm((List<ComCodeVO>) model.get("eduSprtTrprRelCdList"), result.getEduSprtTrprRelCd());
					if("".equals(eduSprtTrprRelCd)) eduSprtTrprRelCd = result.getEduSprtTrprRelDtl();
					
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setEduSprtTrprRelCd(eduSprtTrprRelCd);
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setBrplcCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("brplcCdList"), result.getBrplcCd()));
					
					if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(result.getAplcntType())) {
						//일반사용자 > 본인(북한이탈주민 자녀) : 보호자 하나원기수로 취급
						result.setPrtcrHanawonTh(result.getNtkrdfHanawonTh());
						result.setNtkrdfHanawonTh("");
					}else if(KoreahanaEnumVdoType.NOR_PRT.getCode().equals(result.getAplcntType())) {
						//일반사용자 > 보호자 : 북한이탈주민 구분이 본인 또는 부모 여부에 따라 하나원기수 표시 위치가 다름(보호자측 본인측)
						if(!"본인".equals(result.getNtkrdfSe())) {
							result.setPrtcrHanawonTh(result.getNtkrdfHanawonTh());
							result.setNtkrdfHanawonTh("");
						}
					}
					
					//신규/전년도수혜/전전연도 수혜
					if(KoreahanaEnumExistBnfCd.NOT.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("O");
						result.setBf1ExistBnfYn("X");
						result.setBf2ExistBnfYn("X");
					}else if(KoreahanaEnumExistBnfCd.BF1.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("X");
						result.setBf1ExistBnfYn("O");
						result.setBf2ExistBnfYn("X");
					}else if(KoreahanaEnumExistBnfCd.BF2.getCode().equals(result.getExistBnfCd())) {
						result.setNoExistBnfYn("X");
						result.setBf1ExistBnfYn("X");
						result.setBf2ExistBnfYn("O");
					}
					
					
					//기초생활수급자
					result.setRcoblYn( (result.getRcoblYn().equals("Y") ? "O" : "X" ) );
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "vdoPrc", "화상영어교육현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaVdoPrcService.selectKoreahanaVdoPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaVdoPrcService.selectKoreahanaVdoPrcList(searchVO));
		}
		
		
		return "exts/koreahana/vdo/vdoPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/vdoPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaVdoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoPrcVO result = koreahanaVdoPrcService.selectKoreahanaVdoPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaVdoPrcService.isModifiable(result));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		
		return "exts/koreahana/vdo/vdoPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/vdoPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaVdoPrcService.deleteKoreahanaVdoPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/vdoPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaVdoPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoPrcVO result = koreahanaVdoPrcService.selectKoreahanaVdoPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaVdoPrcService.isModifiable(result));

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		
		return "exts/koreahana/vdo/vdoPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/vdoPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaVdoPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaVdoPrcService.writeKoreahanaVdoPrc(searchVO);
			
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
