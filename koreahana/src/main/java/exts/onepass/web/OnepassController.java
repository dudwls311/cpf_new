package exts.onepass.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import exts.com.web.ExtsAbstractController;
import exts.onepass.service.OnepassService;
/**  
 * @Class Name : OnepassController.java
 * @Description : 
 * 디지털 원패스 Controller
 * 
 * @Modification Information  
 * @
 * @  수정일		수정자		수정내용
 * @ ---------	---------	-------------------------------
 * @ 2022.10.12	김문기		최초생성
 * 
 * @author 
 * @since 2022.10.12
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by Meddogi All right reserved.
 */
@Controller
public class OnepassController extends ExtsAbstractController{

	protected String getPkg(){return "exts/onepass";}
	
	protected final Log log = LogFactory.getLog(getClass());

////////////////////////resource 선언 영역 ///////////////////////////////////////////////////////////////////

	@Resource(name="onepassService")
	private OnepassService onepassService;
	
////////////////////////resource 선언 영역 끝 ///////////////////////////////////////////////////////////////////	

////////////////////////실행 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 디지털원패스 로그인폼 처리(로그인버튼출력)
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/onepass/login.do")
	public String login(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		String ui = "/exts/onepass/login";
		model.addAttribute("onepassRequestHandlerVO", onepassService.getRequestHandlerValues());
		return ui;
	}

	
	/**
	 * 디지털원패시 인증 완료시 호출될 페이지
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/onepass/acs.do")
	public String acs(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			ModelMap model) throws Exception{
		
		onepassService.responseHandlerCheck(request);
		
		return "forward:" + Globals.ONEPASS_LOGIN_FORWARD;
	}


///////////////////////private,protected 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	
}