package exts.koreahana.pba.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.exception.ValidatorException;
import exts.com.service.ComAtchFileService;
import exts.com.util.FileMngUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.web.ExtsAbstractController;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.pba.service.KoreahanaPbaFileService;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.validator.KoreahanaPbaValidator;
import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import exts.koreahana.spf.service.KoreahanaSpfQlfService;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;
import exts.koreahana.spr.service.KoreahanaSprService;


/**
 * @Class Name : KoreahanaPbaController.java
 * @Description : 모집공고 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaPbaController extends ExtsAbstractController{
	
	protected String getPkg(){return "exts/koreahana/pba";}
	private String pbaMainUri = "forward:/exts/koreahana/pba/index.do";

	@Resource(name = "koreahanaPbaService")
	private KoreahanaPbaService koreahanaPbaService;

	@Resource(name = "koreahanaPbaFileService")
	private KoreahanaPbaFileService koreahanaPbaFileService;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "koreahanaSmbTypService")
	private KoreahanaSmbTypService koreahanaSmbTypService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	
	@Resource(name = "koreahanaSpfQlfService")
	private KoreahanaSpfQlfService koreahanaSpfQlfService;
	
	@Resource(name = "koreahanaPbaValidator")
	private KoreahanaPbaValidator koreahanaPbaValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/index.do")
	public String index(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKpMode())))searchVO.setKpMode("list");		//기본 list로 포워딩
				
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/exts/koreahana/pba/" + searchVO.getKpMode() + ".do");
		
		return sb.toString();
	}

	/**
	 * 사업공고(신청서)관리 > 긴급생계비 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/emeIndex.do")
	public String emeIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.EML);
		
		setIndexProcess(EnumMenuCd.PBA_EME, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/emeIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 가산금 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/adtIndex.do")
	public String adtIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.ADT);
		
		setIndexProcess(EnumMenuCd.PBA_ADT, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/adtIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 장학금 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/shoIndex.do")
	public String schIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.SHO);
		
		setIndexProcess(EnumMenuCd.PBA_SHO, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/shoIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 교육지원금 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/eduIndex.do")
	public String eduIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.EDU);
		
		setIndexProcess(EnumMenuCd.PBA_EDU, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/eduIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 화상영어 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/vdoIndex.do")
	public String vdoIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.VDO);
		
		setIndexProcess(EnumMenuCd.PBA_VDO, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/vdoIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 학습지 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/lnbIndex.do")
	public String lnbIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.LNB);
		
		setIndexProcess(EnumMenuCd.PBA_LNB, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/lnbIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 정착지원 전문관리사 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/spfIndex.do")
	public String spfIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.SPF);
		
		setIndexProcess(EnumMenuCd.PBA_SPF, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/spfIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 취업바우처카드 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/emvIndex.do")
	public String emvIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.EMV);
		
		setIndexProcess(EnumMenuCd.PBA_EMV, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/emvIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 사업공고(신청서)관리 > 취업연계 직업훈련 분기문
	 */
	@RequestMapping(value="/exts/koreahana/pba/empIndex.do")
	public String empIndex(
			@ModelAttribute	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setPbaCtgryCd(request, KoreahanaEnumCtgryFrstCd.EMP);
		
		setIndexProcess(EnumMenuCd.PBA_EMP, request, searchVO.getKpMode());
		request.setAttribute(REQUEST_ACTION_URL, "/exts/koreahana/pba/empIndex.do");
		return pbaMainUri;
	}
	
	/**
	 * 리스트
	 */
	@RequestMapping(value="/exts/koreahana/pba/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		getPbaCtgryCd(request, searchVO);

		//상담사 권한일 경우 공개만 나오게
		if(isCenterStaff()) searchVO.setRlsYn("Y");
		
		if("Y".equals(request.getParameter(REQUEST_EXCEL_YN))){
			
			searchVO.setRecordCountPerPage(0);
			model.addAttribute("resultList",koreahanaPbaService.selectKoreahanaPbaList(searchVO));
			return getResponseExcelView(model, "pba", "모집공고");
		}else {

			//기본값으로 스프링빈에 설정된 값 로드
			if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
			if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
		
			//총갯수
			int totalRecordCount = koreahanaPbaService.selectKoreahanaPbaTot(searchVO);

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
			
			//신청건수
			List<KoreahanaPbaVO> resultList = koreahanaPbaService.selectKoreahanaPbaList(searchVO);
			if(resultList != null && resultList.size() > 0) {
				List<String> pbancrcSnList = new ArrayList<String>();
				for(KoreahanaPbaVO adtVO : resultList) {
					pbancrcSnList.add(adtVO.getPbancrcSn());
				}
				List<String> notInsprtSttsCdList = new ArrayList<String>(); 
				notInsprtSttsCdList.add(KoreahanaEnumSprtSttsCd.TMP.getCode());
				
				KoreahanaAdtVO sprtCntSearchVO = new KoreahanaAdtVO();
				sprtCntSearchVO.setPbancrcSnList(pbancrcSnList);
				sprtCntSearchVO.setNotInsprtSttsCdList(notInsprtSttsCdList);
				model.addAttribute("sprtCntList", koreahanaSprService.selectListSprtCnt(sprtCntSearchVO));
			}
			
			model.addAttribute("paginationInfo",paginationInfo);
			model.addAttribute("resultCnt",totalRecordCount);
			model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));			//공고상태
			model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));						//사업구분
			
			model.addAttribute("resultList", resultList);
		}
		
		
		return "exts/koreahana/pba/pbaList";
	}

	/**
	 * 보기
	 */
	@RequestMapping(value="/exts/koreahana/pba/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		getPbaCtgryCd(request, searchVO);
		
		koreahanaPbaService.updateInqCntPlus(searchVO);				//조회수 증가
		KoreahanaPbaVO result = koreahanaPbaService.selectKoreahanaPba(searchVO);
		//읽기 권한 체크
//		if(!koreahanaPbaService.isViewable(result))throwBizException("com.error.noauth.view");
		
		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));		//공고상태
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, result.getPbancrcCtgryFrstCd()));						//사업구분
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaPbaService.isModifiable(result));
		
		if(KoreahanaEnumCtgryFrstCd.SPF.getCode().equals(result.getPbancrcCtgryFrstCd()) && KoreahanaEnumBizSeCd.QLF.getCode().equals(result.getBizSeCd())) {
			KoreahanaSpfQlfVO spfQlfSearchVO = new KoreahanaSpfQlfVO();
			spfQlfSearchVO.setPbancrcSn(result.getPbancrcSn());
			model.addAttribute("spfQlfVO", koreahanaSpfQlfService.selectKoreahanaSpfQlf(spfQlfSearchVO));
		}
		
		//첨부파일
		KoreahanaPbaFileVO pbaFileVO = new KoreahanaPbaFileVO();
		pbaFileVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("pbaFileList", koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileVO));
		
		return "exts/koreahana/pba/pbaView";
	}


	/**
	 * 삭제
	 */
	@RequestMapping(value="/exts/koreahana/pba/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		getPbaCtgryCd(request, searchVO);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaPbaService.deleteKoreahanaPba(searchVO);
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
	@RequestMapping(value="/exts/koreahana/pba/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		getPbaCtgryCd(request, searchVO);
		
		if(!"".equals(NullUtil.nullString(searchVO.getPbancrcSn()))) {
			KoreahanaPbaVO result = koreahanaPbaService.selectKoreahanaPba(searchVO);
			//읽기 권한 체크
			if(!koreahanaPbaService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			model.addAttribute("isModifiable",koreahanaPbaService.isModifiable(result));
			
			//첨부파일
			KoreahanaPbaFileVO pbaFileVO = new KoreahanaPbaFileVO();
			pbaFileVO.setPbancrcSn(result.getPbancrcSn());
			model.addAttribute("pbaFileList", koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileVO));
			
			if(KoreahanaEnumCtgryFrstCd.SPF.getCode().equals(result.getPbancrcCtgryFrstCd()) && KoreahanaEnumBizSeCd.QLF.getCode().equals(result.getBizSeCd())) {
				KoreahanaSpfQlfVO spfQlfSearchVO = new KoreahanaSpfQlfVO();
				spfQlfSearchVO.setPbancrcSn(result.getPbancrcSn());
				model.addAttribute("spfQlfVO", koreahanaSpfQlfService.selectKoreahanaSpfQlf(spfQlfSearchVO));
			}
		}		
		
		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));		//공고상태
		model.addAttribute("ctgryFrstCdList", getCodeListByGrpCd(EnumGrpCd.CTGRY_FRST_CD));			//지원코드
		
		if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
			|| KoreahanaEnumCtgryFrstCd.SPF.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
			|| KoreahanaEnumCtgryFrstCd.EMP.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
			
			model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));		//사업구분
			
		}
		
		
		return "exts/koreahana/pba/pbaWrite";
	}

	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/exts/koreahana/pba/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfQlfVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd((String)request.getAttribute("pbancrcCtgryFrstCd"));
			
			if(KoreahanaEnumCtgryFrstCd.SHO.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
					|| KoreahanaEnumCtgryFrstCd.EDU.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
					|| KoreahanaEnumCtgryFrstCd.VDO.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
					|| KoreahanaEnumCtgryFrstCd.LNB.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
					|| KoreahanaEnumCtgryFrstCd.EML.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
					|| KoreahanaEnumCtgryFrstCd.EMV.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
				
				searchVO.setBizSeCd(searchVO.getPbancrcCtgryFrstCd());
			}
			
			//상시여부에 따른 값 설정
			String pbancrcAlways = NullUtil.nullString(request.getParameter("pbancrcAlways"));		//상시모집 여부(Y:상시모집)
			if("Y".equals(pbancrcAlways)) {
				searchVO.setPbancrcBgngDt(new DateTime("1980-01-01").toDate());
				searchVO.setPbancrcEndDt(new DateTime("9999-01-01").toDate());
			}else {
				if(!"".equals(NullUtil.nullString(searchVO.getPbancrcBgngStr()))) searchVO.setPbancrcBgngDt(new DateTime(searchVO.getPbancrcBgngStr()).toDate());
				if(!"".equals(NullUtil.nullString(searchVO.getPbancrcEndStr()))) searchVO.setPbancrcEndDt(new DateTime(searchVO.getPbancrcEndStr()).toDate());
			}
			
			koreahanaSmbTypService.getParamToSmbTypVO(searchVO, request);	//제출서류유형
			koreahanaSmbService.getParamToSmbVO(searchVO, request);			//제출서류
			koreahanaPbaValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			koreahanaPbaService.writeKoreahanaPba(searchVO, request);
			
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
	 * 모집공고 첨부파일 다운로드
	 */
	@RequestMapping(value="/exts/koreahana/pba/fileDownload.do")
	public void fileDownload(
			@ModelAttribute("searchVO")	KoreahanaPbaFileVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		//해당 파일정보를 가져와서 셋팅.
		KoreahanaPbaFileVO pbaFileVO = koreahanaPbaFileService.selectKoreahanaPbaFile(searchVO);
		if(pbaFileVO != null) {
			FileMngUtil.downFile(request, response, pbaFileVO.getAtchFilePathNm(), pbaFileVO.getAtchFileNm(), pbaFileVO.getOrgnlAtchFileNm(), Globals.UPLOAD_PATH);
		}
	}
	
	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/exts/koreahana/pba/smbTypListAjax.do")
	public String smbTypListAjax(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		getPbaCtgryCd(request, searchVO);
		
		if(!"".equals(NullUtil.nullString(searchVO.getPbancrcSn()))) {
			//제출서류유형
			KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
			smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
			List<KoreahanaSmbTypVO> smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypSearchVO);
			model.addAttribute("smbTypList", smbTypList);
			
			//제출서류
			if(smbTypList != null) {
				List<String> smbsnDocTypSnList = new ArrayList<String>();
				for(KoreahanaSmbTypVO smbTypVO : smbTypList) {
					smbsnDocTypSnList.add(smbTypVO.getSmbsnDocTypeSn());
				}
				KoreahanaSmbVO smbSearchVO = new KoreahanaSmbVO();
				smbSearchVO.setSmbsnDocTypeSnList(smbsnDocTypSnList);
				List<KoreahanaSmbVO> smbList = koreahanaSmbService.selectKoreahanaSmbList(smbSearchVO);
				model.addAttribute("smbList", smbList);
				
				if(smbList != null) {
					List<String> atchFileSnList = new ArrayList<String>();
					for(KoreahanaSmbVO smbVO : smbList) {
						atchFileSnList.add(smbVO.getSmbsnDocFormSn());
					}
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSnList(atchFileSnList);
					model.addAttribute("smbFileList", comAtchFileService.selectComAtchFileList(atchFileSearchVO));
				}
			}
		}
		
		if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
			model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));		//사업구분
		}
		
		return "exts/koreahana/pba/pbaSmbTypeAjax";
	}
	
	/**
	 * 모집공고 범주값 request에 설정
	 * @return 아이디
	 */
	private void setPbaCtgryCd(HttpServletRequest request, KoreahanaEnumCtgryFrstCd frstCd){
		request.setAttribute("pbancrcCtgryFrstCd", frstCd.getCode());
	}
	
	/**
	 * 모집공고 범주값 request에서 가져오기
	 * @return 아이디
	 */
	private void getPbaCtgryCd(HttpServletRequest request, KoreahanaPbaVO searchVO){
		searchVO.setPbancrcCtgryFrstCd((String)request.getAttribute("pbancrcCtgryFrstCd"));
	}
}
