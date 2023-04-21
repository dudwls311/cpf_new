package exts.koreahana.adt.web;

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
import exts.koreahana.adt.service.KoreahanaAdtFamService;
import exts.koreahana.adt.service.KoreahanaAdtUserService;
import exts.koreahana.adt.validator.KoreahanaAdtValidator;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.com.web.KoreahanaSprUserAbstractController;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;


/**
 * @Class Name : KoreahanaAdtController.java
 * @Description : 가산금지원 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaAdtUserController extends KoreahanaSprUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/adt";}
	
	@Resource(name = "koreahanaAdtUserService")
	private KoreahanaAdtUserService koreahanaAdtUserService;
	
	@Resource(name = "koreahanaAdtFamService")
	private KoreahanaAdtFamService koreahanaAdtFamService;
	
	@Resource(name = "koreahanaAdtValidator")
	private KoreahanaAdtValidator koreahanaAdtValidator;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/index.do")
	public String index(
			@ModelAttribute	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKaMode())))searchVO.setKaMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.USER_PBA_ADT, request, searchVO.getKaMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/adt/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/adt/" + searchVO.getKaMode() + ".do");
		
		return sb.toString();
	}
	
	/**
	 * 리스트
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/list.do")
	public String list(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.ADT.getCode());
		searchVO.setRlsYn("Y");
		
		
		return comList(searchVO,request,model);
	}
	
	/**
	 * 공고 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/pbaView.do")
	public String pbaView(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.ADT.getCode());
		searchVO.setRlsYn("Y");
		
		return comPbaView(searchVO,request,model);
	}
	
	/**
	 * 상세보기
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/view.do")
	public String view(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.ADT.getCode());
		searchVO.setRlsYn("Y");
		
		KoreahanaAdtVO result = koreahanaAdtUserService.selectKoreahanaAdt(searchVO);
		//읽기 권한 체크
		if(!koreahanaAdtUserService.isViewable(result))throwBizException("com.error.noauth.view");

		//지원신청정보 관련 공통처리
		prevView(result, request, model);
		
		
		//가족관계
		KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
		famSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("famList", koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO));
		
		//등록된 서명
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
		model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaAdtUserService.isModifiable(result));
		
		return "exts/koreahana/adt/adtUserView";
	}

	/**
	 * 추가/수정
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/write.do")
	public String write(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.ADT.getCode());
		
		//지원신청관련 선처리
		try {
			prevWrite(searchVO, request, model);
		}catch(EgovBizException e) {
			return getResponseBackView(model, e.getMessage());
		}
		
		KoreahanaSprVO sprVO = (KoreahanaSprVO) model.get(ATTR_SPR_VO);
		setModelTmpData(KoreahanaEnumCtgryFrstCd.ADT, sprVO, model);
		
		//지원값이 있고 임시저장이 아닐때
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) ) {
			searchVO.setSprtSn(sprVO.getSprtSn());
			KoreahanaAdtVO result = koreahanaAdtUserService.selectKoreahanaAdt(searchVO);
			//읽기 권한 체크
			if(!koreahanaAdtUserService.isViewable(result))throwBizException("com.error.noauth.view");
			model.addAttribute("result",result);
			
			//가산금 제출서류(등록한 첨부파일)
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
			
			//가족관계
			KoreahanaAdtFamVO famSearchVO = new KoreahanaAdtFamVO();
			famSearchVO.setSprtSn(result.getSprtSn());
			model.addAttribute("famListJson", JsonUtil.convertObjectToJson(koreahanaAdtFamService.selectKoreahanaAdtFamList(famSearchVO)));
			
			//등록된 서명
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(result.getSgntFileSn());
			model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
		}
		model.addAttribute("aplcntRelCdList", getCodeListByGrpCd(EnumGrpCd.APLCNT_REL_CD));
		
		return "exts/koreahana/adt/adtUserWrite";
	}


	/**
	 * 추가 / 수정 처리
	 */
	@RequestMapping(value="/user/exts/koreahana/adt/writeActionJson.do")
	public String writeActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.ADT.getCode());
			
			koreahanaAdtFamService.getParamToAdtFamVO(searchVO, request);		//가산금지원가족관계
			
			//지원신청관련 선처리
			prevWriteAction(searchVO, errors, request, model);

			koreahanaAdtValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) koreahanaSmbService.getParamToSmbValidate(searchVO, request);		//파라미터로 넘어온 제출서류 validation
			
			koreahanaAdtUserService.writeKoreahanaAdt(searchVO, request);
			
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
	@RequestMapping(value="/user/exts/koreahana/adt/deleteActionJson.do")
	public String deleteActionJson(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaAdtUserService.deleteKoreahanaAdt(searchVO);
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
	@RequestMapping(value="/user/exts/koreahana/adt/complete.do")
	public String complete(
			@ModelAttribute("searchVO")	KoreahanaAdtVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		return "exts/koreahana/adt/complete";
	}
}
