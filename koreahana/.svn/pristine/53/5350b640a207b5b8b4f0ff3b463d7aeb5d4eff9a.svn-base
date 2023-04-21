package exts.koreahana.mbr.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumMbrTypeCd;
import exts.com.exception.ValidatorException;
import exts.com.validator.ComLoginProcessValidator;
import exts.com.validator.ComMbrPwChangeValidator;
import exts.com.vo.ComMbrVO;
import exts.koreahana.com.enums.KoreahanaEnumGenderCd;
import exts.koreahana.com.web.KoreahanaUserAbstractController;
import exts.koreahana.mbr.service.KoreahanaMbrUserService;
import exts.koreahana.mbr.validator.KoreahanaMbrValidator;
import exts.koreahana.mbr.vo.KoreahanaMbrDpkdfrVO;
import exts.onepass.service.OnepassService;
import exts.onepass.vo.OnepassResponseVO;
import exts.onepass.vo.OnepassUserResponseVO;
import exts.realauth.service.RealAuthService;
import exts.realauth.vo.RealauthVO;
import jnit.cms.mbr.JnitcmsmbrVO;
import jnit.util.StringUtil;


/**
 * @Class Name : KoreahanaMbrUserController.java
 * @Description : 사용자용 회원 처리용 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.13
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaMbrUserController extends KoreahanaUserAbstractController{

	
	@Resource(name = "koreahanaMbrUserService")
	private KoreahanaMbrUserService koreahanaMbrUserService;

	@Resource(name = "comLoginProcessValidator")
	private ComLoginProcessValidator comLoginProcessValidator;

	@Resource(name = "comMbrPwChangeValidator")
	private ComMbrPwChangeValidator comMbrPwChangeValidator;

	@Resource(name = "koreahanaMbrValidator")
	private KoreahanaMbrValidator koreahanaMbrValidator;


	@Resource(name="realAuthService")
	private RealAuthService realAuthService;

	@Resource(name="onepassService")
	private OnepassService onepassService;
	
	protected String getPkg(){return "user/exts/koreahana/mbr";}

	/**
	 * 로그인 페이지
	 * @param searchVO
	 * @param skinLogin
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/login.do")
	public String login(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		model.addAttribute("smsAuthNumberReqYn", Globals.SMS_AUTH_USE_YN);
		model.addAttribute("smsAuthInvalidTime", Globals.SMS_AUTH_INVALID_SECOND);
		return "exts/koreahana/mbr/mbrUserLogin";
	}
	
	/**
	 * 로그인 처리 페이지
	 * @param searchVO
	 * @param skinLoginAction
	 * @param returnUrl
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/loginAction.do")
	public String loginAction(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		boolean isSuccess = false;
		String msg = "";
		try{

			comLoginProcessValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			msg = koreahanaMbrUserService.login(searchVO);
			if(NullUtil.nullString(msg).indexOf("wrong") >= 0) {
				String pwMiscnt = msg.replaceAll("wrong:", "");
				throwBizException("com.error.login.wrongpw", new String[] {String.valueOf(pwMiscnt),Globals.LOGIN_PW_MISS_MAX_COUNT});
			}
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
	 * 로그아웃 처리 페이지
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/logout.do")
	public String logout(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		koreahanaMbrUserService.logout();
		
		return "redirect:/";
	}
	
	/**
	 * 회원가입 - 회원타입선택
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/sign.do")
	public String sign(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserSign";
	}

	/**
	 * 회원가입 - 본인확인
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/signup.do")
	public String signup(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserSignup";
	}

	/**
	 * 회원가입 - 가입폼
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/signupAdd.do")
	public String signupAdd(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserSignupAdd";
	}

	/**
	 * 중복가입체크
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/duplicationActionJson.do")
	public String duplicationActionJson(
			
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			RealauthVO realAuth = realAuthService.getSession();
			if(realAuth == null)throwBizException("com.error.realauth.nosession");
			
			if("Y".equals(request.getParameter("o"))) {//원패스로 중복가입 체크일 때 원패스의 ci값과 비교.
				OnepassUserResponseVO userInfo = onepassService.getSession();
				if(userInfo == null || userInfo.getCi() == null)throwBizException("com.error.onepass.nosession");
				if(!realAuth.getCi().equals(userInfo.getCi())) {
					realAuthService.removeSession();
					throwBizException("com.error.onepass.notmatchci");
				}
			}
			
			ComMbrVO searchVO = new ComMbrVO();
			searchVO.setDp(realAuth.getCi());
			ComMbrVO result = koreahanaMbrUserService.selectComMbr(searchVO);
			if(result != null && result.getMbrId() != null) {
				realAuthService.removeSession();
				throwBizException("com.error.realauth.existmbr");
			}
			
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}

	
	/**
	 * 회원가입처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/joinActionJson.do")
	public String joinActionJson(
			ComMbrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setTypeId("n".equals(request.getParameter("t"))?EnumMbrTypeCd.NTK.getCode():EnumMbrTypeCd.NOR.getCode());
			
			RealauthVO realAuth = realAuthService.getSession();
			if(realAuth == null)throwBizException("com.error.realauth.nosession");
			

			if("Y".equals(request.getParameter("o"))) {//원패스로 가입일 때 아이디 패스워드 강제 생성.
				OnepassUserResponseVO userInfo = onepassService.getSession();
				if(userInfo == null || userInfo.getCi() == null)throwBizException("com.error.onepass.nosession");
				if(!realAuth.getCi().equals(userInfo.getCi())) {
					realAuthService.removeSession();
					throwBizException("com.error.onepass.notmatchci");
				}
				 
				searchVO.setMbrLogin("op"+DateTime.now().getMillis());
				searchVO.setPasswd(StringUtil.lpad(userInfo.getUserKey(), 10, 'a').substring(0,10) + "1!");
				searchVO.setSn(userInfo.getUserKey());
			}
			
			//북한이탈주민인증정보 셋팅
			KoreahanaMbrDpkdfrVO dpkdfrVO = (KoreahanaMbrDpkdfrVO)SessionUtil.getAttribute(KoreahanaMbrUserService.SESSION_DPKDFR_CERT);
			if(dpkdfrVO != null && "Y".equals(dpkdfrVO.getDpkdfryn())) {
				searchVO.setRrno(dpkdfrVO.getRrno());
				searchVO.setEntcnyYmd(dpkdfrVO.getEntrcdate());
				searchVO.setHanawonFnshYmd(dpkdfrVO.getHanascomptdate());
				searchVO.setHanawonTh(dpkdfrVO.getHanasordno());
				searchVO.setPrtdcsYmd(dpkdfrVO.getPrtcndecsndate());
				searchVO.setNtkrdfUnqNo(dpkdfrVO.getPrtcnno());
			}
			
			//실명인증정보 셋팅
			searchVO.setMbrNm(realAuth.getRealname());
			searchVO.setGenderCd("0".equals(realAuth.getSex())?KoreahanaEnumGenderCd.FEMALE.getCode():KoreahanaEnumGenderCd.MALE.getCode());
			searchVO.setDp(realAuth.getCi());
			searchVO.setBrdtYmd(realAuth.getBirth());

			log.debug(searchVO);
			koreahanaMbrValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaMbrUserService.writeComMbr(searchVO);
			realAuthService.removeSession();
			onepassService.removeSession();
			SessionUtil.removeAttribute(KoreahanaMbrUserService.SESSION_DPKDFR_CERT);
			isSuccess = true;
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}

	/**
	 * 회원가입 - 성공
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/signupSuccess.do")
	public String signupSuccess(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserSignupSuccess";
	}


	/**
	 * 비밀번호 확인
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/chkPasswdActionJson.do")
	public String chkPasswdActionJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			ComMbrVO loginAdtVO = comService.getLoginAdtVO();
			if(loginAdtVO == null || loginAdtVO.getMbrId() == null)throwBizException("com.error.login.nodata");
			String passwd = koreahanaMbrUserService.selectComMbrEncodePw(request.getParameter("passwd"));
			if(loginAdtVO.getPasswd().equals(passwd)) {
				isSuccess = true;
				//세션에 저장처리
				request.getSession().setAttribute("chkPasswdActionJson", true);
			}
			
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}

	/**
	 * 비밀번호 확인(디지털 원패스 회원의 경우)
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/chkDigitalOnepassJson.do")
	public String chkDigitalOnepassJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			ComMbrVO loginAdtVO = comService.getLoginAdtVO();
			if(loginAdtVO == null || loginAdtVO.getMbrId() == null)throwBizException("com.error.login.nodata");
			if(!"".equals(NullUtil.nullString(loginAdtVO.getSn()))) {
				isSuccess = true;
				//세션에 저장처리
				request.getSession().setAttribute("chkPasswdActionJson", true);
			}
			
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}
	
	/**
	 * 마이페이지 - 회원정보 수정(비밀번호 확인)
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/modify.do")
	public String modify(
			ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		request.getSession().removeAttribute("chkPasswdActionJson");
		
		return "exts/koreahana/mbr/mbrUserModify";
	}
	

	/**
	 * 마이페이지 - 회원정보 수정 보기
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/modifyView.do")
	public String modifyView(
			ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		//세션체크
		if(!(Boolean)request.getSession().getAttribute("chkPasswdActionJson"))throwBizException("com.error.noauth.modify");
		

		return "exts/koreahana/mbr/mbrUserModifyView";
	}
	
	/**
	 * 마이페이지 - 회원정보 수정처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/modifyActionJson.do")
	public String modifyActionJson(
			ComMbrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			//세션체크
			if(!(Boolean)request.getSession().getAttribute("chkPasswdActionJson"))throwBizException("com.error.noauth.modify");
			
			ComMbrVO loginAdtVO = comService.getLoginAdtVO();
			if(loginAdtVO == null || loginAdtVO.getMbrId() == null)throwBizException("com.error.login.nodata");
			
			//validation체크 제외를 위해 기존 값 셋팅
			BeanUtils.copyProperties(loginAdtVO, searchVO);
			
			searchVO.setZip(request.getParameter("zip"));
			searchVO.setAddr(request.getParameter("addr"));
			searchVO.setDaddr(request.getParameter("daddr"));
			searchVO.setMbphno(request.getParameter("mbphno"));
			searchVO.setPasswd(null);
			
			koreahanaMbrValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
						
			koreahanaMbrUserService.writeComMbr(searchVO);
			
			
			isSuccess = true;
			request.getSession().removeAttribute("chkPasswdActionJson");
		}catch(ValidatorException e){
			return getResponseValidatorErrorJsonView(model, errors);
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}

	/**
	 * 마이페이지 - 비밀번호 변경
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/mypagePassword.do")
	public String mypagePassword(
			ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		return "exts/koreahana/mbr/mbrUserMypagePassword";
	}
	
	/**
	 * 마이페이지 - 비밀번호 변경처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/mypagePasswordActionJson.do")
	public String mypagePasswordActionJson(
			ComMbrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setMbrId(getLoginId());
			
			comMbrPwChangeValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");

			koreahanaMbrUserService.changePw(searchVO, request.getParameter("orPasswd"));
			
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
	 * 회원탈퇴 
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/out.do")
	public String out(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserOut";
	}
	
	/**
	 * 탈퇴처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/outActionJson.do")
	public String outActionJson(
			ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			searchVO.setMbrId(getLoginId());
			koreahanaMbrUserService.out(searchVO);
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
	
		return getResponseJsonView(model, isSuccess, msg);
	}

	
	
	
	/**
	 * 아이디 찾기 페이지
	 * @param searchVO
	 * @param skinLogin
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/findId.do")
	public String findId(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserFindId";
	}
	
	/**
	 * 비밀번호 찾기 페이지
	 * @param searchVO
	 * @param skinLogin
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/findPassword.do")
	public String findPassword(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		return "exts/koreahana/mbr/mbrUserFindPassword";
	}
	 
	/**
	 * 아이디 찾기 완료 페이지
	 * @param searchVO
	 * @param skinLoginAction
	 * @param returnUrl
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/findIdAction.do")
	public String findIdAction(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		RealauthVO realAuth = realAuthService.getSession();
		if(realAuth == null)throwBizException("com.error.realauth.nosession");
		
		ComMbrVO mbrVO = new ComMbrVO();
		mbrVO.setDp(realAuth.getCi());		
		model.addAttribute("result",koreahanaMbrUserService.selectComMbr(mbrVO));

		realAuthService.removeSession();
		
		return "exts/koreahana/mbr/mbrUserFindIdAction";
	}

	/**
	 * 비밀번호 찾기 완료 페이지
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/findPasswdAction.do")
	public String findPasswdAction(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		RealauthVO realAuth = realAuthService.getSession();
		if(realAuth == null)throwBizException("com.error.realauth.nosession");
		
		ComMbrVO mbrVO = new ComMbrVO();
		mbrVO.setDp(realAuth.getCi());		
		mbrVO = koreahanaMbrUserService.selectComMbr(mbrVO);
		//일치하는 정보가 없을 경우 실명인증 세션 삭제
		if(mbrVO == null || mbrVO.getMbrId() == null)realAuthService.removeSession();
		
		model.addAttribute("result",mbrVO);

		return "exts/koreahana/mbr/mbrUserFindPasswdAction";
	}
	
	/**
	 * 비밀번호 찾기 후 새 비밀번호 변경 처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/changePasswordActionJson.do")
	public String changePasswordActionJson(
			ComMbrVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			comMbrPwChangeValidator.validate(searchVO, errors);
			if(errors.hasErrors())throw new ValidatorException("");
			
			RealauthVO realAuth = realAuthService.getSession();
			if(realAuth == null)throwBizException("com.error.realauth.nosession");


			koreahanaMbrUserService.updatePwByCi(realAuth.getCi(), searchVO);
			
			realAuthService.removeSession();
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
	 * 차단 해제 처리
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/blockRemoveActionJson.do")
	public String blockRemoveActionJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try{
			String mbrLogin = NullUtil.nullString(request.getParameter("mbrLogin"));
			RealauthVO realAuth = realAuthService.getSession();
			if(realAuth == null)throwBizException("com.error.realauth.nosession");

			ComMbrVO mbrVO = new ComMbrVO();
			mbrVO.setDp(realAuth.getCi());		
			mbrVO = koreahanaMbrUserService.selectComMbr(mbrVO);			
			if(mbrVO == null || mbrVO.getMbrId() == null) {
				throwBizException("com.error.realauth.nomatchmbr");
				realAuthService.removeSession();
			}
			if(!mbrLogin.equals(mbrVO.getMbrLogin())) {
				throwBizException("com.error.login.blockremove.notmatch");
				realAuthService.removeSession();
			}

			koreahanaMbrUserService.initWrongPwCnt(mbrVO);
			
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}


	/**
	 * 아이디 중복 체크
	 * 응답 : JSON {isSuccess:true(중복아님)|false(중복)}
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/duplicateIdActionJson.do")
	public String duplicateIdActionJson(
			@ModelAttribute("searchVO")ComMbrVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		boolean isPossible = koreahanaMbrUserService.idCheck(searchVO.getMbrLogin());
		
		return getResponseJsonView(model,isPossible,"");
	}


	/**
	 * 북한이탈주민 인증
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/certificationActionJson.do")
	public String certificationActionJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		KoreahanaMbrDpkdfrVO result = null;
		try{
			String rrno = NullUtil.nullString(request.getParameter("rrno"));
			RealauthVO realAuth = realAuthService.getSession();
			if(realAuth == null)throwBizException("com.error.realauth.nosession");
			
			//5회 이상일시 1분간 차단
			Integer certCount = (Integer)SessionUtil.getAttribute("certCount");
			certCount = (certCount == null)?1:certCount+1;
			SessionUtil.setAttribute("certCount", certCount);
			if(certCount > 5) {
				DateTime certTime = (DateTime)SessionUtil.getAttribute("certTime");
				DateTime now = new DateTime();
				if(certTime == null)certTime = now;		
				if(certTime.plusMinutes(1).isAfter(now.getMillis())) {
				}
				SessionUtil.setAttribute("certTime", now);
			}
			
			result = koreahanaMbrUserService.certification(rrno, realAuth.getRealname());
			if(result != null && "Y".equals(result.getDpkdfryn())) {
				SessionUtil.removeAttribute("certCount");
				SessionUtil.removeAttribute("certTime");
			}
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg, result);
	}


	/**
	 * 원패스 로그인 처리 페이지(원패스 로그인 완료시 포워딩 처리)
	 * @param searchVO
	 * @param skinLoginAction
	 * @param returnUrl
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/onepassLoginAction.do")
	public String onepassLoginAction(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		OnepassResponseVO onepassResponse = onepassService.getLoginSession();
		
		model.addAttribute("onepassLogin", koreahanaMbrUserService.loginByOnepass(onepassResponse));
		return "exts/koreahana/mbr/mbrUserOnepassLoginAction";
	}
	

	/**
	 * 원패스 연동해제 처리
	 * @param searchVO
	 * @param skinLoginAction
	 * @param returnUrl
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/koreahana/mbr/onepassOutActionJson.do")
	public String onepassOutActionJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		boolean isSuccess = false;
		String msg = "";
		try {
			
			JnitcmsmbrVO loginVO = getLoginVO();
			ComMbrVO searchVO = new ComMbrVO();
			searchVO.setMbrId(getLoginId());
			searchVO.setSn(loginVO.getSn());
			koreahanaMbrUserService.out(searchVO);
			
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
	
		return getResponseJsonView(model, isSuccess, msg);
	}
////////////////////////실행 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	

///////////////////////private,protected 메소드 선언 영역  ///////////////////////////////////////////////////////////////////
	
///////////////////////private,protected 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	

}
