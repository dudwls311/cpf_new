package exts.koreahana.emp.web;

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
import exts.koreahana.emp.service.KoreahanaEmpQlfService;
import exts.koreahana.emp.service.KoreahanaEmpUserService;
import exts.koreahana.emp.validator.KoreahanaEmpValidator;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;
import exts.koreahana.emp.vo.KoreahanaEmpVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;


/**
 * @Class Name : KoreahanaEmpController.java
 * @Description : 취업연계직업훈련 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaEmpUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/emp";}
	
	@Resource(name = "koreahanaEmpUserService")
	private KoreahanaEmpUserService koreahanaEmpUserService;

	@Resource(name = "koreahanaEmpQlfService")
	private KoreahanaEmpQlfService koreahanaEmpQlfService;
	
	@Resource(name = "koreahanaEmpValidator")
	private KoreahanaEmpValidator koreahanaEmpValidator;
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/index.do")
	public String index(
			@ModelAttribute	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKeMode())))searchVO.setKeMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_EMP, request, searchVO.getKeMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/emp/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/emp/" + searchVO.getKeMode() + ".do");
		
		return sb.toString();
	}


	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
		searchVO.setRlsYn("Y");
		
		
		return comList(searchVO,request,model);
	}

	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 보기
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		KoreahanaEmpVO result = koreahanaEmpUserService.selectKoreahanaEmp(searchVO);
		//읽기 권한 체크
		if(!koreahanaEmpUserService.isViewable(result))throwBizException("com.error.noauth.view");
		
		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		//취업연계직업훈련자격사항
		KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
		empQlfSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("empQlfList", koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO));
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaEmpUserService.isModifiable(result));
		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		return "exts/koreahana/emp/empUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.EMP, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaEmpVO result = koreahanaEmpUserService.selectKoreahanaEmp(searchVO);
			//읽기 권한 체크
			if(!koreahanaEmpUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
			
			//취업연계직업훈련자격사항
			KoreahanaEmpQlfVO empQlfSearchVO = new KoreahanaEmpQlfVO();
			empQlfSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("empQlfListJson", JsonUtil.convertObjectToJson(koreahanaEmpQlfService.selectKoreahanaEmpQlfList(empQlfSearchVO)));
		}
		model.addAttribute("empmSttsCdList", getCodeListByGrpCd(EnumGrpCd.EMPM_STTS_CD));
		
		return "exts/koreahana/emp/empUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/emp/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.EMP.getCode());
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			koreahanaEmpValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			//취업연계직업훈련자격사항
			searchVO.setEmpQlfList(koreahanaEmpQlfService.getParamToEmpQlfVO(request));
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) {
				koreahanaEmpQlfService.empQlfValidate(searchVO.getEmpQlfList());
				koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			}

			koreahanaEmpUserService.writeKoreahanaEmp(searchVO, request);
			
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
	@RequestMapping(value="/user/exts/koreahana/emp/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaEmpUserService.deleteKoreahanaEmp(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/emp/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaEmpVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/emp/complete";
	}
}
