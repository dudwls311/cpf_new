package exts.koreahana.edu.web;

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
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.edu.service.KoreahanaEduUserService;
import exts.koreahana.edu.validator.KoreahanaEduValidator;
import exts.koreahana.edu.vo.KoreahanaEduVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;


/**
 * @Class Name : KoreahanaEduController.java
 * @Description : 교육지원금 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEduUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/edu";}
	
	@Resource(name = "koreahanaEduUserService")
	private KoreahanaEduUserService koreahanaEduUserService;

	@Resource(name = "koreahanaEduValidator")
	private KoreahanaEduValidator koreahanaEduValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/index.do")
	public String index(
			@ModelAttribute	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeMode())))searchVO.setKeMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_EDU, request, searchVO.getKeMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/edu/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/edu/" + searchVO.getKeMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EDU.getCode());
		searchVO.setRlsYn("Y");
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EDU.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EDU.getCode());
		searchVO.setRlsYn("Y");
		
		KoreahanaEduVO result = koreahanaEduUserService.selectKoreahanaEdu(searchVO);
		//읽기 권한 체크
		if(!koreahanaEduUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEduUserService.isModifiable(result));
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/edu/eduUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EDU.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.EDU, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaEduVO result = koreahanaEduUserService.selectKoreahanaEdu(searchVO);
			//읽기 권한 체크
			if(!koreahanaEduUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		}
		model.addAttribute("bankCdList", getCodeListByGrpCd(EnumGrpCd.BANK_CD));
		
		return "exts/koreahana/edu/eduUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/edu/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EDU.getCode());
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			koreahanaEduValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaEduUserService.writeKoreahanaEdu(searchVO, request);
			
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
	@RequestMapping(value="/user/exts/koreahana/edu/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEduVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEduUserService.deleteKoreahanaEdu(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/edu/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/edu/complete";
	}
}
