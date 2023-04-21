package exts.koreahana.vdo.web;

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
import exts.koreahana.com.enums.KoreahanaEnumBrplcCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumEduSprtTrprRelCd;
import exts.koreahana.com.enums.KoreahanaEnumGenderCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.enums.KoreahanaEnumVdoType;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.sho.vo.KoreahanaShoVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import exts.koreahana.vdo.service.KoreahanaVdoUserService;
import exts.koreahana.vdo.validator.KoreahanaVdoValidator;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;


/**
 * @Class Name : KoreahanaVdoController.java
 * @Description : 화상영어교육지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaVdoUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/vdo";}
	
	@Resource(name = "koreahanaVdoUserService")
	private KoreahanaVdoUserService koreahanaVdoUserService;
	
	@Resource(name = "koreahanaVdoValidator")
	private KoreahanaVdoValidator koreahanaVdoValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/index.do")
	public String index(
			@ModelAttribute	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKvMode())))searchVO.setKvMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_VDO, request, searchVO.getKvMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/vdo/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/vdo/" + searchVO.getKvMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.VDO.getCode());
		searchVO.setRlsYn("Y");
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.VDO.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoUserService.selectKoreahanaVdo(searchVO);
		//읽기 권한 체크
		if(!koreahanaVdoUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//국민기초생활수급확인서
		ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
		rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
		model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(rcoblSgntFileVO));
		
		//북한이탈주민 인증서
		ComAtchFileVO ntkrdfAcrtfctFileVO = new ComAtchFileVO();
		ntkrdfAcrtfctFileVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
		model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(ntkrdfAcrtfctFileVO));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		//등록된 보호자 서명
		ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
		atchFileSearchPrtcrVO.setAtchFileSn(result.getPrtcrSgntFileSn());
		model.addAttribute("prtcrSgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchPrtcrVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaVdoUserService.isModifiable(result));
		
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		
		return "exts/koreahana/vdo/vdoUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.VDO.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.VDO, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaVdoVO result = koreahanaVdoUserService.selectKoreahanaVdo(searchVO);
			//읽기 권한 체크
			if(!koreahanaVdoUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//국민기초생활수급확인서
			ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
			rcoblSgntFileVO.setAtchFileSn(result.getRcoblSgntFileSn());
			model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(rcoblSgntFileVO));
			
			//북한이탈주민 인증서
			ComAtchFileVO ntkrdfAcrtfctFileVO = new ComAtchFileVO();
			ntkrdfAcrtfctFileVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
			model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(ntkrdfAcrtfctFileVO));
			
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
		}else {
			KoreahanaVdoVO result = (KoreahanaVdoVO) model.get("result");
			String aplcntType = (result != null ? result.getAplcntType() : searchVO.getAplcntType());
			
			if("".equals(NullUtil.nullString(aplcntType))) {
				//최초 등록시 신청자 회원유형 선택
				model.addAttribute("isNtkrdf", isNtkrdf());
				model.addAttribute("isNormal", isNormal());
				model.addAttribute("isAdmin", isAdmin());
				model.addAttribute("isMbrLevelStaff", isMbrLevelStaff());
				
				return "exts/koreahana/vdo/vdoUserSelect";
			}else {
				boolean isPass = false;
				for(KoreahanaEnumVdoType vdoType : KoreahanaEnumVdoType.values()) {
					if(vdoType.getCode().equals(aplcntType)) {
						isPass = true;
						break;
					}
				}
				if(!isPass) return getResponseBackView(model, comService.getMessage("exts.item.koreahana.vdo.errorAplcnt"));
			}
		}
		
		model.addAttribute("brplcCdList", getCodeListByGrpCd(EnumGrpCd.BRPLC_CD));
		model.addAttribute("existBnfCdList", getCodeListByGrpCd(EnumGrpCd.EXIST_BNF_CD));
		model.addAttribute("eduSprtTrprRelCdList", getCodeListByGrpCd(EnumGrpCd.EDU_SPRT_TRPR_REL_CD));
		model.addAttribute("frontOfPhone", getFrontOfPhone());
		
		return "exts/koreahana/vdo/vdoUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.VDO.getCode());
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			if(KoreahanaEnumVdoType.NTK_IDT.getCode().equals(searchVO.getAplcntType())) {
				//북한이탈주민(본인)
				searchVO.setBrplcCd(KoreahanaEnumBrplcCd.NOR.getCode());		//출생지 북한값 고정
				koreahanaVdoUserService.setSprtPrtcrInfoBySession(searchVO);							//보호자 정보 설정
			}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(searchVO.getAplcntType())) {
				//본인(북한이탈주민 자녀) 부모값으로 성별 구분
				if(KoreahanaEnumEduSprtTrprRelCd.FAT.getCode().equals(searchVO.getEduSprtTrprRelCd())) {
					searchVO.setPrtcrGenderCd(KoreahanaEnumGenderCd.MALE.getCode());
				}else if(KoreahanaEnumEduSprtTrprRelCd.MOT.getCode().equals(searchVO.getEduSprtTrprRelCd())) {
					searchVO.setPrtcrGenderCd(KoreahanaEnumGenderCd.FEMALE.getCode());
				}
			}else if(KoreahanaEnumVdoType.NOR_IDT.getCode().equals(searchVO.getAplcntType())) {
				koreahanaVdoUserService.setSprtPrtcrInfoBySession(searchVO);							//보호자 정보 설정
			}
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) {
				//기초생활수급자인증서
				if(ComFileUploadUtil.uploadFormFilesValidate(request, "rcoblSgntFileSnFile")) searchVO.setRcoblSgntFileSn("FILE_EXIST");
				//북한이탈주민 인증서
				if(ComFileUploadUtil.uploadFormFilesValidate(request, "ntkrdfAcrtfctFileSnFile")) searchVO.setNtkrdfAcrtfctFileSn("FILE_EXIST");
			}
			
			koreahanaVdoValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			//기초생활수급자인증서
			List<String> rcoblSgntFileSnFileList = comAtchFileUserService.writeComAtchUploadFile(request, "rcoblSgntFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : rcoblSgntFileSnFileList) {
				searchVO.setRcoblSgntFileSn(atchFileSn);
			}
			
			//북한이탈주민 인증서
			List<String> ntkrdfAcrtfctFileList = comAtchFileUserService.writeComAtchUploadFile(request, "ntkrdfAcrtfctFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : ntkrdfAcrtfctFileList) {
				searchVO.setNtkrdfAcrtfctFileSn(atchFileSn);
			}
			koreahanaVdoUserService.writeKoreahanaVdo(searchVO, request);
			
			isSuccess = true;
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			msg = e.getMessage();
			if("tempSave".equals(e.getMessageKey())) {//임시저장일 경우 정상 저장처리
				isSuccess = true;
				msg = "";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	
	/**
	 * 삭제
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaVdoUserService.deleteKoreahanaVdo(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/vdo/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/vdo/complete";
	}
	
	/**
	 * 기초생활수급자인증서파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/rcoblSgntFileDownload.do")
	public void rcoblSgntFileDownload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoUserService.selectKoreahanaVdo(searchVO);
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) {
			//임시저장 데이터 가져오기
			KoreahanaSprVO sprVO = koreahanaSprUserService.selectKoreahanaSpr(result);
			result = (KoreahanaVdoVO) JsonUtil.convertJsonToObject(sprVO.getTmprStrgData(), KoreahanaVdoVO.class);
		}
		//읽기 권한 체크
		if(!koreahanaVdoUserService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getRcoblSgntFileSn(), request, response);
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/vdo/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaVdoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaVdoVO result = koreahanaVdoUserService.selectKoreahanaVdo(searchVO);
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) {
			//임시저장 데이터 가져오기
			KoreahanaSprVO sprVO = koreahanaSprUserService.selectKoreahanaSpr(result);
			result = (KoreahanaVdoVO) JsonUtil.convertJsonToObject(sprVO.getTmprStrgData(), KoreahanaVdoVO.class);
		}
		//읽기 권한 체크
		if(!koreahanaVdoUserService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getNtkrdfAcrtfctFileSn(), request, response);
	}
}
