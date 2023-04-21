package exts.koreahana.lnb.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumGrpCd;
import exts.com.exception.ValidatorException;
import exts.com.util.ComFileUploadUtil;
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumLnbType;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.lnb.service.KoreahanaLnbPrcService;
import exts.koreahana.lnb.service.KoreahanaLnbUserService;
import exts.koreahana.lnb.validator.KoreahanaLnbValidator;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;


/**
 * @Class Name : KoreahanaLnbController.java
 * @Description : 학습지지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaLnbUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/lnb";}
	
	@Resource(name = "koreahanaLnbUserService")
	private KoreahanaLnbUserService koreahanaLnbUserService;

	@Resource(name = "koreahanaLnbPrcService")
	private KoreahanaLnbPrcService koreahanaLnbPrcService;
	
	@Resource(name = "koreahanaLnbValidator")
	private KoreahanaLnbValidator koreahanaLnbValidator;
	
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/index.do")
	public String index(
			@ModelAttribute	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKlMode())))searchVO.setKlMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_LNB, request, searchVO.getKlMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/lnb/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/lnb/" + searchVO.getKlMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.LNB.getCode());
		searchVO.setRlsYn("Y");
		
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.LNB.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.LNB.getCode());
		searchVO.setRlsYn("Y");
		
		KoreahanaLnbVO result = koreahanaLnbUserService.selectKoreahanaLnb(searchVO);
		//읽기 권한 체크
		if(!koreahanaLnbUserService.isViewable(result))throwBizException("com.error.noauth.view");

		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//국민기초생활수급확인서
		ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
		rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
		model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(rcoblSgntFileVO));
		
		//가산금 제출서류(등록한 첨부파일)
		KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
		smbMpnSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		//등록된 보호자 서명
		ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
		atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
		model.addAttribute("prtcrSgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchPrtcrVO));
		
		//학습지 지원대상자 기본 정보
		KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
		lnbPrcSearchVO.setSprtSn(result.getSprtSn());
		List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
		if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
			List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
			for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
				ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
			}
			ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
			ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
			model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileUserService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
		}
		model.addAttribute("lnbSprtInfoList", koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO));
		
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaLnbUserService.isModifiable(result));
		
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		
		return "exts/koreahana/lnb/lnbUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.LNB.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.LNB, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaLnbVO result = koreahanaLnbUserService.selectKoreahanaLnb(searchVO);
			//읽기 권한 체크
			if(!koreahanaLnbUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//국민기초생활수급확인서
			ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
			rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
			model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(rcoblSgntFileVO));
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
			
			//등록된 보호자 서명
			ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
			atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
			model.addAttribute("prtcrSgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchPrtcrVO));
			
			//학습지 지원대상자 기본 정보
			KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
			lnbPrcSearchVO.setSprtSn(result.getSprtSn());
			List<KoreahanaLnbPrcVO> lnbSprtInfoList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(lnbPrcSearchVO);
			if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
				List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
				for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
					ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
				}
				if(ntkrdfAcrtfctFileSnList.size() > 0) {
					ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
					ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
					model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileUserService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
				}
			}
			model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);
			
		}else {
			if(isNtkrdf()) {
				searchVO.setAplcntType(KoreahanaEnumLnbType.NTK.getCode());
			}else if(isNormal()) {
				searchVO.setAplcntType(KoreahanaEnumLnbType.NOR.getCode());
			}
		}
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		return "exts/koreahana/lnb/lnbUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.LNB.getCode());
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			koreahanaLnbPrcService.setParamToLnbPrcVO(searchVO, request);
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) {
				//기초생활수급자인증서
				if(ComFileUploadUtil.uploadFormFilesValidate(request, "rcoblSgntFileSnFile")) searchVO.setRcoblSgntFileSn("FILE_EXIST");
			}
			
			koreahanaLnbValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) {
				//학습지 지원대상자 기본정보
				if(searchVO.getLnbPrcList() != null) {
					for(KoreahanaLnbPrcVO prcVO : searchVO.getLnbPrcList()) {
						prcVO.setAplcntType(searchVO.getAplcntType());		//유형에 따른 validation
						//북한이탈주민 인증서
						if(ComFileUploadUtil.uploadFormFilesValidate(request, prcVO.getNtkrdfAcrtfctFileId())) prcVO.setNtkrdfAcrtfctFileSn("FILE_EXIST");
						koreahanaLnbPrcService.validateLnbPrcVO(prcVO);
					}
				}
			}
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			//기초생활수급자인증서
			List<String> rcoblSgntFileSnFileList = comAtchFileUserService.writeComAtchUploadFile(request, "rcoblSgntFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : rcoblSgntFileSnFileList) {
				searchVO.setRcoblSgntFileSn(atchFileSn);
			}
			
			koreahanaLnbUserService.writeKoreahanaLnb(searchVO, request);
			
			isSuccess = true;
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			e.printStackTrace();
			msg = e.getMessage();
			if("tempSave".equals(e.getMessageKey())) {//임시저장일 경우 정상 저장처리
				isSuccess = true;
				msg = "";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	
	/**
	 * 삭제
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaLnbUserService.deleteKoreahanaLnb(searchVO);
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
	 * 처리완료 페이지
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/lnb/complete";
	}
	
	/**
	 * 기초생활수급자인증서파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/rcoblSgntFileDownload.do")
	public void rcoblSgntFileDownload(
			@ModelAttribute("searchVO")	KoreahanaLnbVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbUserService.selectKoreahanaLnb(searchVO);
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) {
			//임시저장 데이터 가져오기
			KoreahanaSprVO sprVO = koreahanaSprUserService.selectKoreahanaSpr(result);
			result = (KoreahanaLnbVO) JsonUtil.convertJsonToObject(sprVO.getTmprStrgData(), KoreahanaLnbVO.class);
		}
		//읽기 권한 체크
		if(!koreahanaLnbUserService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getRcoblSgntFileSn(), request, response);
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/lnb/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaLnbPrcVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaLnbVO result = koreahanaLnbUserService.selectKoreahanaLnb(searchVO);
		List<KoreahanaLnbPrcVO> lnbPrcList = null;
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) {
			//임시저장 데이터 가져오기
			KoreahanaSprVO sprVO = koreahanaSprUserService.selectKoreahanaSpr(result);
			result = (KoreahanaLnbVO) JsonUtil.convertJsonToObject(sprVO.getTmprStrgData(), KoreahanaLnbVO.class);
			lnbPrcList = result.getLnbPrcList();
		}else {
			lnbPrcList = koreahanaLnbPrcService.selectKoreahanaLnbPrcList(searchVO);
		}
		//읽기 권한 체크
		if(!koreahanaLnbUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		boolean isPass = false;
		if(lnbPrcList != null && lnbPrcList.size() > 0) {
			for(KoreahanaLnbPrcVO lnbPrcVO : lnbPrcList) {
				if(NullUtil.nullString(lnbPrcVO.getNtkrdfAcrtfctFileSn()).equals(searchVO.getNtkrdfAcrtfctFileSn())) {
					isPass = true;
					break;
				}
			}
		}
		if(isPass) {
			sprtFileDonwload(searchVO.getNtkrdfAcrtfctFileSn(), request, response);
		}else {
			throwBizException("com.error.noauth.view");
		}
	}
}