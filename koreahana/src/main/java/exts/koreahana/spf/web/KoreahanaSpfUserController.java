package exts.koreahana.spf.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spf.service.KoreahanaSpfPrcService;
import exts.koreahana.spf.service.KoreahanaSpfQlfService;
import exts.koreahana.spf.service.KoreahanaSpfUserService;
import exts.koreahana.spf.validator.KoreahanaSpfValidator;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;
import exts.koreahana.spf.vo.KoreahanaSpfVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.com.tag.JnitTag;
import jnit.crypto.JnitCryptoService;


/**
 * @Class Name : KoreahanaSpfController.java
 * @Description : 정착지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSpfUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/spf";}
	
	@Resource(name = "koreahanaSpfUserService")
	private KoreahanaSpfUserService koreahanaSpfUserService;

	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	@Resource(name = "koreahanaSpfValidator")
	private KoreahanaSpfValidator koreahanaSpfValidator;
	
	@Resource(name = "koreahanaSpfPrcService")
	private KoreahanaSpfPrcService koreahanaSpfPrcService;
	
	@Resource(name = "koreahanaSpfQlfService")
	private KoreahanaSpfQlfService koreahanaSpfQlfService;


	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/index.do")
	public String index(
			@ModelAttribute	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_SPF, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/spf/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/spf/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SPF.getCode());
		searchVO.setRlsYn("Y");
		
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SPF.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaSpfVO result = koreahanaSpfUserService.selectKoreahanaSpf(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			model.addAttribute("photoFile", comAtchFileUserService.selectComAtchFile(photoFileVO));
		}
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaSpfUserService.isModifiable(result));
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
		return "exts/koreahana/spf/spfUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SPF.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.SPF, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaSpfVO result = koreahanaSpfUserService.selectKoreahanaSpf(searchVO);
			//읽기 권한 체크
			if(!koreahanaSpfUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//사진
			if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
				ComAtchFileVO photoFileVO = new ComAtchFileVO();
				photoFileVO.setAtchFileSn(result.getPhotoFileSn());
				model.addAttribute("photoFile", comAtchFileUserService.selectComAtchFile(photoFileVO));
			}
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		}	
		model.addAttribute("aplcntLastAcbgCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_LAST_ACBG_CD));
		model.addAttribute("ocptInstTypeCdList", getCodeListByGrpCd(EnumGrpCd.OCPT_INST_TYPE_CD));
		
		
		return "exts/koreahana/spf/spfUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SPF.getCode());
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			koreahanaSpfValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaSpfUserService.writeKoreahanaSpf(searchVO, request);
			
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
	@RequestMapping(value="/user/exts/koreahana/spf/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSpfUserService.deleteKoreahanaSpf(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/spf/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/spf/complete";
	}
	
	/**
	 * 추가 / 수정(파일첨부)
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/writeFileActionJson.do")
	public String writeFileActionJson(
			@ModelAttribute("searchVO")	KoreahanaSpfVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		boolean isSuccess = false;
		String msg = "";
		ComAtchFileVO atchFileVO = null;
		
		try{
			
			//사진파일(첨부)
			String fsn = "";
			List<String> atchFileSmbSnList = comAtchFileUserService.writeComAtchUploadFile(request, "photoFile", "photo", null, new String[] {"jpg", "jpeg", "png", "gif", "bmp"});
			for(String atchFileSn : atchFileSmbSnList) {
				fsn = atchFileSn;
			}
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(fsn);
			atchFileVO = comAtchFileUserService.selectComAtchFile(atchFileSearchVO);
			msg = JnitTag.sprtFileViewEncode(atchFileVO.getAtchFileSn(), "");
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg, atchFileVO);
	}
	
	

	/**
	 * 수험표 출력
	 */
	@RequestMapping(value="/user/exts/koreahana/spf/print.do")
	public String print(
			@ModelAttribute("searchVO")	KoreahanaSpfPrcVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		KoreahanaSpfPrcVO result = koreahanaSpfPrcService.selectKoreahanaSpfPrc(searchVO);
		//읽기 권한 체크
		if(!koreahanaSpfUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//사진
		if(!"".equals(NullUtil.nullString(result.getPhotoFileSn()))) {
			ComAtchFileVO photoFileVO = new ComAtchFileVO();
			photoFileVO.setAtchFileSn(result.getPhotoFileSn());
			model.addAttribute("photoFile", comAtchFileUserService.selectComAtchFile(photoFileVO));
		}
		
		model.addAttribute("result",result);
		

		//시험정보가져오기
		KoreahanaSpfQlfVO qlfVO = new KoreahanaSpfQlfVO();
		qlfVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("qlfResult", koreahanaSpfQlfService.selectKoreahanaSpfQlf(qlfVO));
		
		return "exts/koreahana/spf/spfUserPrint";
	}

}
