package exts.koreahana.com.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import exts.com.enums.EnumMenuCd;
import exts.com.service.ComService;


/**
 * @Class Name : KoreahanaUserComController.java
 * @Description : 사용자공통 처리용 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.13
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaUserComController extends KoreahanaUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/com";}


	@Resource(name = "comService")
	private ComService comService;

	/**
	 * 주소찾기 함수
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/user/exts/com/addressFind.do")
	public String addressFind(HttpServletRequest request) throws Exception{
		request.setAttribute("isTrustedNetowrk", comService.isTrustedNetworkIp(request));
		return "exts/koreahana/com/addressFind/find";
	}

	/**
	 * 주소찾기 팝업(juso.go.kr)
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/user/exts/com/jusoPopup.do")
	public String jusoPopup(HttpServletRequest request) throws Exception{
		request.setAttribute("key", Globals.JUSO_KEY);
		return "exts/koreahana/com/addressFind/jusoPopup";
	}
	
}
