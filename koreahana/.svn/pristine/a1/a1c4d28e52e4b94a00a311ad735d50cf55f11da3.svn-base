package exts.koreahana.emv.web;

import java.util.ArrayList;
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
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComMbrVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.emv.service.KoreahanaEmvPrcService;
import exts.koreahana.emv.service.KoreahanaEmvPrcTkcService;
import exts.koreahana.emv.service.KoreahanaEmvUseService;
import exts.koreahana.emv.validator.KoreahanaEmvPrcValidator;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;
import exts.koreahana.emv.vo.KoreahanaEmvPrcVO;
import exts.koreahana.emv.vo.KoreahanaEmvUseVO;
import exts.koreahana.mbr.service.KoreahanaMbrUserService;
import jnit.cms.org.JnitcmsorgDefaultVO;
import jnit.cms.org.JnitcmsorgService;
import jnit.cms.org.JnitcmsorgVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaEmvPrcController.java
 * @Description : 취업바우처카드지원현황관리 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmvPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/emvPrc";}
	
	@Resource(name = "koreahanaEmvPrcService")
	private KoreahanaEmvPrcService koreahanaEmvPrcService;
	
	@Resource(name = "jnitcmsorgService")
	private JnitcmsorgService jnitcmsorgService;

	@Resource(name = "koreahanaEmvPrcValidator")
	private KoreahanaEmvPrcValidator koreahanaEmvPrcValidator;
	
	@Resource(name = "koreahanaMbrUserService")
	private KoreahanaMbrUserService koreahanaMbrUserService;
	
	@Resource(name = "koreahanaEmvUseService")
	private KoreahanaEmvUseService koreahanaEmvUseService;
	
	@Resource(name = "koreahanaEmvPrcTkcService")
	private KoreahanaEmvPrcTkcService koreahanaEmvPrcTkcService;
	

	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/emvPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmvPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKepMode())))searchVO.setKepMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_EMV_PRC, request, searchVO.getKepMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/emvPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/emvPrc/" + searchVO.getKepMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/emvPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmvPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevPrcList(KoreahanaEnumCtgryFrstCd.EMV, searchVO, request, model);

		if(isCenterStaff()) {
			searchVO.setHanactCd(getLoginVO().getOrgId());		//재단직원이 아니면 해당센터만 조회가능
		}else{
			JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
			cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
			model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		}

		model.addAttribute("aplcntQlfcCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_QLFC_CD));
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){

			searchVO.setRecordCountPerPage(0);
			List<KoreahanaEmvPrcVO> resultList = koreahanaEmvPrcService.selectKoreahanaEmvPrcListExcel(searchVO);
			List<JnitcmsorgVO> hanactList = (List<JnitcmsorgVO>)model.get("hanactList");
			if(resultList != null) {
				model.addAttribute("sbjctCdList", getCodeListByGrpCd(EnumGrpCd.SBJCT_CD));
				model.addAttribute("ednstCdList", getCodeListByGrpCd(EnumGrpCd.EDNST_CD));
				for(KoreahanaEmvPrcVO result : resultList) {
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setDscsnYmd(JnitTag.convertDateSplitString(result.getDscsnYmd(), "-"));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setAplcntQlfcCd(JnitTag.getCdNm((List<ComCodeVO>) model.get("aplcntQlfcCdList"), result.getAplcntQlfcCd()));
					result.setBalance( (NullUtil.nullLong(result.getAplyAmt()) - NullUtil.nullLong(result.getUseAmt())) );
					result.setUsePercent(JnitTag.percent(NullUtil.nullString(result.getAplyAmt()), NullUtil.nullString(result.getUseAmt()), ""));
					result.setPntyYn( NullUtil.nullString(result.getPntyYn()).equals("Y") ? "O" : NullUtil.nullString(result.getPntyYn()).equals("N") ? "X" : "");
					result.setExistCdUseYn( NullUtil.nullString(result.getExistCdUseYn()).equals("Y") ? "O" : NullUtil.nullString(result.getExistCdUseYn()).equals("N") ? "X" : "");
					
					for(JnitcmsorgVO orgVO : hanactList) {
						if(orgVO.getOrgId().equals(result.getHanactCd())) {
							result.setHanactNm(orgVO.getOrgNm());
							break;
						}
					}
					result.setSbjctConcat(result.getSbjctConcat());
					if(result.getEmvPrcTkcList() != null && result.getEmvPrcTkcList().size() > 0) {
						for(KoreahanaEmvPrcTkcVO emvPrcTkcVO : result.getEmvPrcTkcList()) {
							emvPrcTkcVO.setSbjctCd(JnitTag.getCdNm((List<ComCodeVO>) model.get("sbjctCdList"), emvPrcTkcVO.getSbjctCd()));
							emvPrcTkcVO.setEdnstCd(JnitTag.getCdNm((List<ComCodeVO>) model.get("ednstCdList"), emvPrcTkcVO.getEdnstCd()));
						}
					}
				}
			}
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "emvPrc", "취업바우처카드지원현황관리");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaEmvPrcService.selectKoreahanaEmvPrcTot(searchVO);

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
			model.addAttribute("resultList",koreahanaEmvPrcService.selectKoreahanaEmvPrcList(searchVO));
		}
		
		
		return "exts/koreahana/emv/emvPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/emvPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmvPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmvPrcVO result = koreahanaEmvPrcService.selectKoreahanaEmvPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmvPrcService.isModifiable(result));

		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		model.addAttribute("sbjctCdList", getCodeListByGrpCd(EnumGrpCd.SBJCT_CD));
		model.addAttribute("ednstCdList", getCodeListByGrpCd(EnumGrpCd.EDNST_CD));
		model.addAttribute("aplcntQlfcCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_QLFC_CD));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		
		//수강정보
		KoreahanaEmvPrcTkcVO emvPrcTkcSearchVO = new KoreahanaEmvPrcTkcVO();
		emvPrcTkcSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("emvPrcTkcList" , koreahanaEmvPrcTkcService.selectKoreahanaEmvPrcTkcList(emvPrcTkcSearchVO));
		
		//카드 사용 정보
		List<String> cardNoList = new ArrayList<String>();
		if(!NullUtil.nullString(result.getFrstCardNo()).equals(""))cardNoList.add(result.getFrstCardNo());
		if(!NullUtil.nullString(result.getScndryCardNo()).equals(""))cardNoList.add(result.getScndryCardNo());
		if(!NullUtil.nullString(result.getThirdCardNo()).equals(""))cardNoList.add(result.getThirdCardNo());
		if(cardNoList.size() > 0) {
			KoreahanaEmvUseVO useVO = new KoreahanaEmvUseVO();
			useVO.setCardNoList(cardNoList);
			useVO.setRecordCountPerPage(0);
			model.addAttribute("cardUseList", koreahanaEmvUseService.selectKoreahanaEmvUseList(useVO));
		}
		
		return "exts/koreahana/emv/emvPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/emvPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmvPrcService.deleteKoreahanaEmvPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/emvPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmvPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmvPrcVO result = koreahanaEmvPrcService.selectKoreahanaEmvPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmvPrcService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmvPrcService.isModifiable(result));

		//수강정보
		KoreahanaEmvPrcTkcVO emvPrcTkcSearchVO = new KoreahanaEmvPrcTkcVO();
		emvPrcTkcSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("emvPrcTkcList" , koreahanaEmvPrcTkcService.selectKoreahanaEmvPrcTkcList(emvPrcTkcSearchVO));
		
		JnitcmsorgDefaultVO cmsOrgSearchVO = new JnitcmsorgDefaultVO();
		cmsOrgSearchVO.setNotOrgRankOdr(0);		//교육지원부,생활안전부,자립지원부,정보보호팀 제외
		model.addAttribute("hanactList", jnitcmsorgService.selectHanactList(cmsOrgSearchVO));
		model.addAttribute("sbjctCdList", getCodeListByGrpCd(EnumGrpCd.SBJCT_CD));
		model.addAttribute("ednstCdList", getCodeListByGrpCd(EnumGrpCd.EDNST_CD));
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("aplcntQlfcCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_QLFC_CD));
		return "exts/koreahana/emv/emvPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/emvPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmvPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			
			//수강정보 파라미터 설정
			String[] emvPrcTkcPrefixArr = request.getParameterValues("emvPrcTkcPrefix");
			if(emvPrcTkcPrefixArr != null) {
				List<KoreahanaEmvPrcTkcVO> emvPrcTkcList = new ArrayList<KoreahanaEmvPrcTkcVO>();
				KoreahanaEmvPrcTkcVO emvPrcTkcVO = null;
				for(String prefix : emvPrcTkcPrefixArr) {
					emvPrcTkcVO = new KoreahanaEmvPrcTkcVO();
					emvPrcTkcVO.setSbjctCd(request.getParameter("sbjctCd"+prefix));		//과목코드
					emvPrcTkcVO.setSbjctNm(request.getParameter("sbjctNm"+prefix));		//과목명
					emvPrcTkcVO.setEdnstCd(request.getParameter("ednstCd"+prefix));		//교육기관코드
					emvPrcTkcVO.setEdnstNm(request.getParameter("ednstNm"+prefix));		//교육기관명
					emvPrcTkcVO.setTkclsPeriod(request.getParameter("tkclsPeriod"+prefix));	//수강기간
					
					//입력된 값이 하나라도 있으면 값 설정
					if(!"".equals(NullUtil.nullString(emvPrcTkcVO.getSbjctCd()))
						|| !"".equals(NullUtil.nullString(emvPrcTkcVO.getSbjctNm()))
						|| !"".equals(NullUtil.nullString(emvPrcTkcVO.getEdnstCd()))
						|| !"".equals(NullUtil.nullString(emvPrcTkcVO.getEdnstNm()))
						|| !"".equals(NullUtil.nullString(emvPrcTkcVO.getTkclsPeriod()))) {
							
							emvPrcTkcList.add(emvPrcTkcVO);
						}
				}
				searchVO.setEmvPrcTkcList(emvPrcTkcList);
			}
			
			koreahanaEmvPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaEmvPrcService.writeKoreahanaEmvPrc(searchVO);
			
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
	 * 카드정보 보기
	 */
	@RequestMapping(value="/exts/koreahana/emvPrc/viewCardInfo.do")
	public String viewCardInfo(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		boolean isSuccess = false;
		String msg = "";

		EgovMap ret = new EgovMap();
		try{
			String cardListType = NullUtil.nullString(request.getParameter("cardListType"));		//카드번호를 보여줄 유형(reqInfo:신청정보, cardUseList:카드사용정보);
			
			ComMbrVO loginAdtVO = comService.getLoginAdtVO();
			if(loginAdtVO == null || loginAdtVO.getMbrId() == null)throwBizException("com.error.login.nodata");
			String passwd = koreahanaMbrUserService.selectComMbrEncodePw(request.getParameter("cardPasswd"));
			if(!loginAdtVO.getPasswd().equals(passwd))throwBizException("com.error.login.notmatchpw");
			
			KoreahanaEmvPrcVO searchVO = new KoreahanaEmvPrcVO();
			searchVO.setSprtSn(request.getParameter("sprtSn"));
			KoreahanaEmvPrcVO result = koreahanaEmvPrcService.selectKoreahanaEmvPrc(searchVO);
			//읽기 권한 체크
			if(!koreahanaEmvPrcService.isViewable(result))throwBizException("com.error.noauth.view");
	
			if("reqInfo".equals(cardListType)) {
				//신청정보 카드번호
				ret.put("frstCardNo", result.getFrstCardNo());
				ret.put("scndryCardNo", result.getScndryCardNo());
				ret.put("thirdCardNo", result.getThirdCardNo());
				
			}else if("cardUseList".equals(cardListType)) {
				//카드사용정보 카드번호
				List<String> cardNoList = new ArrayList<String>();
				if(!NullUtil.nullString(result.getFrstCardNo()).equals(""))cardNoList.add(result.getFrstCardNo());
				if(!NullUtil.nullString(result.getScndryCardNo()).equals(""))cardNoList.add(result.getScndryCardNo());
				if(!NullUtil.nullString(result.getThirdCardNo()).equals(""))cardNoList.add(result.getThirdCardNo());
				if(cardNoList.size() > 0) {
					KoreahanaEmvUseVO useVO = new KoreahanaEmvUseVO();
					useVO.setCardNoList(cardNoList);
					useVO.setRecordCountPerPage(0);
					List<KoreahanaEmvUseVO> emvUseList = koreahanaEmvUseService.selectKoreahanaEmvUseList(useVO);
					List<String> cardList = new ArrayList<String>();
					for(KoreahanaEmvUseVO emvUseVO : emvUseList) {
						cardList.add(emvUseVO.getCardNo());
					}
					ret.put("cardList", cardList);
				}
			}
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg, ret);
	}

}
