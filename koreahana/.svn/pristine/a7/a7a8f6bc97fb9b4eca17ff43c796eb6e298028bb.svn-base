package exts.koreahana.sho.web;

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
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import exts.koreahana.sho.service.KoreahanaShoService;
import exts.koreahana.sho.validator.KoreahanaShoValidator;
import exts.koreahana.sho.vo.KoreahanaShoVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;


/**
 * @Class Name : KoreahanaShoController.java
 * @Description : 장학금지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaShoUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/sho";}
	
	@Resource(name = "koreahanaShoUserService")
	private KoreahanaShoService koreahanaShoUserService;

	@Resource(name = "koreahanaShoValidator")
	private KoreahanaShoValidator koreahanaShoValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/index.do")
	public String index(
			@ModelAttribute	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_SHO, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/sho/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/sho/" + searchVO.getKsMode() + ".do");
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
		searchVO.setRlsYn("Y");
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
		searchVO.setRlsYn("Y");
		
		KoreahanaShoVO result = koreahanaShoUserService.selectKoreahanaSho(searchVO);
		//읽기 권한 체크
		if(!koreahanaShoUserService.isViewable(result))throwBizException("com.error.noauth.view");

		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//북한이탈주민 인증서파일
		if(!"".equals(NullUtil.nullString(result.getNtkrdfAcrtfctFileSn()))) {
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
			model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		}
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaShoUserService.isModifiable(result));
		
		return "exts/koreahana/sho/shoUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.SHO, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaShoVO result = koreahanaShoUserService.selectKoreahanaSho(searchVO);
			//읽기 권한 체크
			if(!koreahanaShoUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//북한이탈주민 인증서파일
			if(!"".equals(NullUtil.nullString(result.getNtkrdfAcrtfctFileSn()))) {
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSn(result.getNtkrdfAcrtfctFileSn());
				model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
			}
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		}
		
		model.addAttribute("isNtkrdf", isNtkrdf());		//탈북민 여부
		model.addAttribute("isNormal", isNormal());		//일반사용자 여부
		
		return "exts/koreahana/sho/shoUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());
			
			//북한이탈주민 인증서
			List<String> atchFileSmbSnList = comAtchFileUserService.writeComAtchUploadFile(request, "ntkrdfAcrtfctFileSnFile", searchVO.getPbancrcSn(), null);
			for(String atchFileSn : atchFileSmbSnList) {
				searchVO.setNtkrdfAcrtfctFileSn(atchFileSn);
			}
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);
			
			searchVO.setNormal(isNormal());
			koreahanaShoValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaShoUserService.writeKoreahanaSho(searchVO, request);
			
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
	@RequestMapping(value="/user/exts/koreahana/sho/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaShoUserService.deleteKoreahanaSho(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/sho/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/sho/complete";
	}
	
	/**
	 * 북한이탈주민인증서파일 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/sho/ntkrdfAcrtfctFileDownload.do")
	public void ntkrdfAcrtfctFileDownload(
			@ModelAttribute("searchVO")	KoreahanaShoVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaShoVO result = koreahanaShoUserService.selectKoreahanaSho(searchVO);
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) {
			//임시저장 데이터 가져오기
			KoreahanaSprVO sprVO = koreahanaSprUserService.selectKoreahanaSpr(result);
			result = (KoreahanaShoVO) JsonUtil.convertJsonToObject(sprVO.getTmprStrgData(), KoreahanaShoVO.class);
		}
		//읽기 권한 체크
		if(!koreahanaShoUserService.isViewable(result))throwBizException("com.error.noauth.view");
		sprtFileDonwload(result.getNtkrdfAcrtfctFileSn(), request, response);
	}
}
