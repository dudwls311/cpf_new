package exts.koreahana.lnb.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
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
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprAbstractController;
import exts.koreahana.lnb.service.KoreahanaLnbPrcService;
import exts.koreahana.lnb.service.KoreahanaLnbService;
import exts.koreahana.lnb.validator.KoreahanaLnbPrcValidator;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import jnit.com.tag.JnitTag;


/**
 * @Class Name : KoreahanaLnbPrcController.java
 * @Description : 학습지지원기본정보 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaLnbPrcController extends KoreahanaSprAbstractController{
	
	protected String getPkg(){return "exts/koreahana/lnbPrc";}

	@Resource(name = "koreahanaLnbService")
	private KoreahanaLnbService koreahanaLnbService;
	
	@Resource(name = "koreahanaLnbPrcService")
	private KoreahanaLnbPrcService koreahanaLnbPrcService;

	@Resource(name = "koreahanaLnbPrcValidator")
	private KoreahanaLnbPrcValidator koreahanaLnbPrcValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/lnbPrc/index.do")
	public String index(
			@ModelAttribute	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKlpMode())))searchVO.setKlpMode("list");		//기본 list로 포워딩		
		setIndexProcess(EnumMenuCd.SPR_LNB_PRC, request, searchVO.getKlpMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/lnbPrc/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/lnbPrc/" + searchVO.getKlpMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/lnbPrc/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		prevList(KoreahanaEnumCtgryFrstCd.LNB, searchVO, request, model);
		
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정(service는 기본신청에서 함께 쓰므로 controller에서 처리)
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){

			model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
			model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
			model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
			
			searchVO.setRecordCountPerPage(0);
			List<KoreahanaLnbVO> resultList = koreahanaLnbService.selectKoreahanaLnbList(searchVO);
			if(resultList != null) {
				String eduSprtTrprRelCd = "";
				
				KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
				BeanUtils.copyProperties(searchVO, lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcInList = null;		//sprtSn이 동일한 VO를 담을 변수
				
				for(KoreahanaLnbVO result : resultList) {
					lnbPrcInList = new ArrayList<KoreahanaLnbPrcVO>();
					
					//교육지원대상자관계코드 값이 없으면 상세값 설정
					eduSprtTrprRelCd = JnitTag.getCdNm((List<ComCodeVO>) model.get("eduSprtTrprRelCdList"), result.getEduSprtTrprRelCd());
					if("".equals(eduSprtTrprRelCd)) eduSprtTrprRelCd = result.getEduSprtTrprRelDtl();
					
					result.setRegDtStr(new DateTime(result.getRegDt()).toString("yyyy-MM-dd"));
					result.setEduSprtTrprRelCd(eduSprtTrprRelCd);
					result.setGenderCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("genderCdList"), result.getGenderCd()));
					result.setBrdtYmd(JnitTag.convertDateSplitString(result.getBrdtYmd(), "-"));
					result.setSprtSttsCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("sprtSttsCdList"), result.getSprtSttsCd()));
					result.setRcoblYn( ("Y".equals(result.getRcoblYn()) ? "O" : "X") );		//기초생활수급자여부
					
					//sprtSn값이 동일한 VO를 list에 추가
					for(KoreahanaLnbPrcVO lpVO : lnbPrcList) {
						if(lpVO != null && lpVO.getSprtSn().equals(result.getSprtSn())) lnbPrcInList.add(lpVO);
					}

					for(KoreahanaLnbPrcVO lnbPrcVO:lnbPrcInList) {
						
						lnbPrcVO.setBrplcCd(JnitTag.getCdNm((List<ComCodeVO>)model.get("brplcCdList"), lnbPrcVO.getBrplcCd()));
						if("".equals(NullUtil.nullString(lnbPrcVO.getHanawonTh()))) lnbPrcVO.setHanawonTh(lnbPrcVO.getNtkrdfOprtHanawonTh());
						//신규/전년도수혜/전전연도 수혜
						if(KoreahanaEnumExistBnfCd.NOT.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("O");
							lnbPrcVO.setBf1ExistBnfYn("X");
							lnbPrcVO.setBf2ExistBnfYn("X");
						}else if(KoreahanaEnumExistBnfCd.BF1.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("X");
							lnbPrcVO.setBf1ExistBnfYn("O");
							lnbPrcVO.setBf2ExistBnfYn("X");
						}else if(KoreahanaEnumExistBnfCd.BF2.getCode().equals(lnbPrcVO.getExistBnfCd())) {
							lnbPrcVO.setNoExistBnfYn("X");
							lnbPrcVO.setBf1ExistBnfYn("X");
							lnbPrcVO.setBf2ExistBnfYn("O");
						}
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getSprtTrgtYn()))) lnbPrcVO.setSprtTrgtYn( ("Y".equals(lnbPrcVO.getSprtTrgtYn()) ? "대상" : "비대상") );				//지원대상여부
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getVdoengDpcnTrgtYn()))) lnbPrcVO.setVdoengDpcnTrgtYn( ("Y".equals(lnbPrcVO.getVdoengDpcnTrgtYn()) ? "여" : "부") );	//화상영어중복대상여부
						if(!"".equals(NullUtil.nullString(lnbPrcVO.getMdwGbkhmYmd()))) lnbPrcVO.setMdwGbkhmYmd(JnitTag.convertDateSplitString(lnbPrcVO.getMdwGbkhmYmd(), "-"));			//중도퇴가연월일

						if("1".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc1(lnbPrcVO);
						}else if("2".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc2(lnbPrcVO);
						}else if("3".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc3(lnbPrcVO);
						}else if("4".equals(lnbPrcVO.getRnkg())) {
							result.setLnbPrc4(lnbPrcVO);
						}
					}	
					
				}
			}
			
			model.addAttribute("resultList",resultList);
			return getResponseExcelView(model, "lnbPrc", "학습지지원_지원정보");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaLnbService.selectKoreahanaLnbTot(searchVO);

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
			
			List<KoreahanaLnbVO> resultList = koreahanaLnbService.selectKoreahanaLnbList(searchVO);
			model.addAttribute("resultList", resultList);
			
			if(resultList != null) {

				KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
				BeanUtils.copyProperties(searchVO, lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
				List<KoreahanaLnbPrcVO> lnbPrcInList = null;		//sprtSn이 동일한 VO를 담을 변수
				
				for(KoreahanaLnbVO result : resultList) {
					lnbPrcInList = new ArrayList<KoreahanaLnbPrcVO>();
					//sprtSn값이 동일한 VO를 list에 추가
					for(KoreahanaLnbPrcVO lpVO : lnbPrcList) {
						if(lpVO != null && lpVO.getSprtSn().equals(result.getSprtSn())) lnbPrcInList.add(lpVO);
					}
					
					for(KoreahanaLnbPrcVO lnbPrc:lnbPrcInList) {
						if("1".equals(lnbPrc.getRnkg())) {
							result.setLnbPrc1(lnbPrc);
						}else if("2".equals(lnbPrc.getRnkg())) {
							result.setLnbPrc2(lnbPrc);
						}
					}
				}
			}
		}
		
		
		return "exts/koreahana/lnb/lnbPrcList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/lnbPrc/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaLnbService.isModifiable(result));
		

		//학습지 지원대상자 기본 정보
		KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
		lnbPrcSearchVO.setSprtSn(result.getSprtSn());
		List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
//		if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
//			List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
//			for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
//				ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
//			}
//			ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
//			ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
//			model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
//		}
		model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);

		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		return "exts/koreahana/lnb/lnbPrcView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/lnbPrc/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaLnbPrcService.deleteKoreahanaLnbPrc(searchVO);
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
	@RequestMapping(value="/exts/koreahana/lnbPrc/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		KoreahanaLnbVO result = koreahanaLnbService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbService.isViewable(result))throwBizException("com.error.noauth.view");
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaLnbService.isModifiable(result));

		//학습지 지원대상자 기본 정보
		KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
		lnbPrcSearchVO.setSprtSn(result.getSprtSn());
		List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
//		if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
//			List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
//			for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
//				ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
//			}
//			ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
//			ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
//			model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
//		}
		model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);
		
		model.addAttribute("result",result);
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		
		return "exts/koreahana/lnb/lnbPrcWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/lnbPrc/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			List<KoreahanaLnbPrcVO> lnbPrcList = new ArrayList<KoreahanaLnbPrcVO>();
			//지원대상자 정보 pk값에 따른 정보 셋팅
			String[] prcSns = request.getParameterValues("prcSns");
			if(prcSns != null) {
				for(String prcSn:prcSns) {
					KoreahanaLnbPrcVO lnbPrcVO = new KoreahanaLnbPrcVO();
					lnbPrcVO.setLnbkSprtBscInfoSn(prcSn);
					lnbPrcVO.setRnkg(request.getParameter("rnkg" + prcSn));
					lnbPrcVO.setSprtTrgtYn(request.getParameter("sprtTrgtYn" + prcSn));
					lnbPrcVO.setVdoengDpcnTrgtYn(request.getParameter("vdoengDpcnTrgtYn" + prcSn));
					lnbPrcVO.setMdwGbkhmYmd(request.getParameter("mdwGbkhmYmd" + prcSn));
					lnbPrcVO.setGbkhmRsn(request.getParameter("gbkhmRsn" + prcSn));
					lnbPrcList.add(lnbPrcVO);
				}
			}
			searchVO.setLnbPrcList(lnbPrcList);
			
			koreahanaLnbPrcValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaLnbPrcService.updateKoreahanaLnbPrcSupport(searchVO);
			
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
