package exts.realauth.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Kisinfo.Check.IPIN2Client;
import egovframework.com.cmm.service.Globals;
//import Kisinfo.Check.IPIN2Client;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.UrlUtil;
import exts.com.web.ExtsAbstractController;
import exts.realauth.service.RealAuthService;
import exts.realauth.vo.RealauthVO;
/**  
 * @Class Name : RealauthController.java
 * @Description : 
 * 실명인증 Controller
 * 
 * @Modification Information  
 * @
 * @  수정일		수정자		수정내용
 * @ ---------	---------	-------------------------------
 * @ 2018.10.12	김문기		최초생성
 * 
 * @author 
 * @since 2018.10.12
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by Meddogi All right reserved.
 */
@Controller
public class RealauthController extends ExtsAbstractController{

	protected String getPkg(){return "exts/realauth";}
	
	protected final Log log = LogFactory.getLog(getClass());

	public static final String REAL_AUTH_URL = "/user/exts/realauth/auth.do";//실명인증 페이지
////////////////////////resource 선언 영역 ///////////////////////////////////////////////////////////////////

	@Resource(name="realAuthService")
	private RealAuthService realAuthService;
	
////////////////////////resource 선언 영역 끝 ///////////////////////////////////////////////////////////////////	

////////////////////////실행 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

	/**
	 * 실명인증 화면
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/auth.do")
	public String auth(
			HttpServletRequest request,
			HttpSession session,
			ModelMap model) throws Exception{
		String type = Globals.REALAUTH_TYPE;
		
		String ui = "/exts/realauth/" + type + "/auth";
		
		return ui;
	}


	/**
	 * 실명인증 팝업 redircet 화면(새창 오류때문에)
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/authPopup.do")
	public String authPopup(
			@RequestParam(required=true)String authType,
			HttpServletRequest request,
			HttpSession session,
			ModelMap model) throws Exception{
		String type = Globals.REALAUTH_TYPE;
		
		String ui = "/exts/realauth/" + type + "/authPopup";
		
		if("nice".equals(authType)){
			//nice용
			NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
		    
		    String sSiteCode = Globals.NICE_SITECODE;			// NICE로부터 부여받은 사이트 코드
		    String sSitePassword = Globals.NICE_SITEPASSWORD;		// NICE로부터 부여받은 사이트 패스워드
		    
		    String sRequestNumber = "REQ0000000001";        	// 요청 번호, 이는 성공/실패후에 같은 값으로 되돌려주게 되므로 
		                                                    	// 업체에서 적절하게 변경하여 쓰거나, 아래와 같이 생성한다.
		    sRequestNumber = niceCheck.getRequestNO(sSiteCode);
		  	session.setAttribute("REQ_SEQ" , sRequestNumber);	// 해킹등의 방지를 위하여 세션을 쓴다면, 세션에 요청번호를 넣는다.
		  	
		   	String sAuthType = NullUtil.nullString(request.getParameter("sAuthType"));      	// 없으면 기본 선택화면, M: 핸드폰, C: 신용카드, X: 공인인증서
		   	
		   	String popgubun 	= "N";		//Y : 취소버튼 있음 / N : 취소버튼 없음
			String customize 	= "";		//없으면 기본 웹페이지 / Mobile : 모바일페이지
			
			String sGender = ""; 			//없으면 기본 선택 값, 0 : 여자, 1 : 남자 
			
		    // CheckPlus(본인인증) 처리 후, 결과 데이타를 리턴 받기위해 다음예제와 같이 http부터 입력합니다.
			//리턴url은 인증 전 인증페이지를 호출하기 전 url과 동일해야 합니다. ex) 인증 전 url : http://www.~ 리턴 url : http://www.~
			
			/* 호스팅 서버에서는 무조건 80포트로 호출되서 강제로 셋팅함(2018.12.11)
			 * -- 원본
		    String sReturnUrl = Globals.SSL_DOMAIN + "/user/exts/realauth/authSuccess.do";      // 성공시 이동될 URL
		    String sErrorUrl = Globals.SSL_DOMAIN + "/user/exts/realauth/authFail.do";          // 실패시 이동될 URL
			-- */
			String sReturnUrl = getDomain(request) + "/user/exts/realauth/authSuccess.do";      // 성공시 이동될 URL
		    String sErrorUrl = getDomain(request) + "/user/exts/realauth/authFail.do";          // 실패시 이동될 URL
			
		    // 입력될 plain 데이타를 만든다.
		    String sPlainData = "7:REQ_SEQ" + sRequestNumber.getBytes().length + ":" + sRequestNumber +
		                        "8:SITECODE" + sSiteCode.getBytes().length + ":" + sSiteCode +
		                        "9:AUTH_TYPE" + sAuthType.getBytes().length + ":" + sAuthType +
		                        "7:RTN_URL" + sReturnUrl.getBytes().length + ":" + sReturnUrl +
		                        "7:ERR_URL" + sErrorUrl.getBytes().length + ":" + sErrorUrl +
		                        "11:POPUP_GUBUN" + popgubun.getBytes().length + ":" + popgubun +
		                        "9:CUSTOMIZE" + customize.getBytes().length + ":" + customize + 
								"6:GENDER" + sGender.getBytes().length + ":" + sGender;
		    
		    String sMessage = "";
		    String sEncData = "";
		    
		    int iReturn = niceCheck.fnEncode(sSiteCode, sSitePassword, sPlainData);
		    if( iReturn == 0 )
		    {
		        sEncData = niceCheck.getCipherData();
		    }
		    else if( iReturn == -1)
		    {
		        sMessage = "암호화 시스템 에러입니다.";
		    }    
		    else if( iReturn == -2)
		    {
		        sMessage = "암호화 처리오류입니다.";
		    }    
		    else if( iReturn == -3)
		    {
		        sMessage = "암호화 데이터 오류입니다.";
		    }    
		    else if( iReturn == -9)
		    {
		        sMessage = "입력 데이터 오류입니다.";
		    }    
		    else
		    {
		        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
		    }
			
		    if(!"".equals(sMessage)){
		    	log.error(sMessage);
		    	throwBizException("com.error.realauth.encodeerror", new String[]{String.valueOf(iReturn)});
		    }
		    
		    model.addAttribute("sEncData",sEncData);
		}else if("niceipin".equals(authType)){
			/********************************************************************************************************************************************
			NICE평가정보 Copyright(c) KOREA INFOMATION SERVICE INC. ALL RIGHTS RESERVED
			
			서비스명 : 가상주민번호서비스 (IPIN) 서비스
			페이지명 : 가상주민번호서비스 (IPIN) 호출 페이지
			*********************************************************************************************************************************************/

			String sSiteCode				= Globals.NICE_IPIN_SITECODE;			// IPIN 서비스 사이트 코드		(NICE평가정보에서 발급한 사이트코드)
			String sSitePw					= Globals.NICE_IPIN_SITEPASSWORD;			// IPIN 서비스 사이트 패스워드	(NICE평가정보에서 발급한 사이트패스워드)
			
			
			/*
			┌ sReturnURL 변수에 대한 설명  ─────────────────────────────────────────────────────
				NICE평가정보 팝업에서 인증받은 사용자 정보를 암호화하여 귀사로 리턴합니다.
				따라서 암호화된 결과 데이타를 리턴받으실 URL 정의해 주세요.
				
				* URL 은 http 부터 입력해 주셔야하며, 외부에서도 접속이 유효한 정보여야 합니다.
				* 당사에서 배포해드린 샘플페이지 중, ipin_process.jsp 페이지가 사용자 정보를 리턴받는 예제 페이지입니다.
				
				아래는 URL 예제이며, 귀사의 서비스 도메인과 서버에 업로드 된 샘플페이지 위치에 따라 경로를 설정하시기 바랍니다.
				예 - http://www.test.co.kr/ipin_process.jsp, https://www.test.co.kr/ipin_process.jsp, https://test.co.kr/ipin_process.jsp
			└────────────────────────────────────────────────────────────────────
			*/
			/* 호스팅 서버에서는 무조건 80포트로 호출되서 강제로 셋팅함(2018.12.11)
			 * -- 원본
//			String sReturnURL = Globals.SSL_DOMAIN + "/user/exts/realauth/authIpinSuccess.do";      // 성공시 이동될 URL
		     * -- 원본끝
			 */
		    String sReturnURL = UrlUtil.currentContextUrl(request) + "/user/exts/realauth/authIpinSuccess.do";      // 성공시 이동될 URL
			
		    log.debug(sSiteCode);
		    log.debug(sSitePw);
			log.debug(sReturnURL);
			/*
			┌ sCPRequest 변수에 대한 설명  ─────────────────────────────────────────────────────
				[CP 요청번호]로 귀사에서 데이타를 임의로 정의하거나, 당사에서 배포된 모듈로 데이타를 생성할 수 있습니다.
				
				CP 요청번호는 인증 완료 후, 암호화된 결과 데이타에 함께 제공되며
				데이타 위변조 방지 및 특정 사용자가 요청한 것임을 확인하기 위한 목적으로 이용하실 수 있습니다.
				
				따라서 귀사의 프로세스에 응용하여 이용할 수 있는 데이타이기에, 필수값은 아닙니다.
			└────────────────────────────────────────────────────────────────────
			*/
			String sCPRequest				= "";
			
			// 객체 생성
			IPIN2Client pClient = new IPIN2Client();
			
			// 앞서 설명드린 바와같이, CP 요청번호는 배포된 모듈을 통해 아래와 같이 생성할 수 있습니다.
			sCPRequest = pClient.getRequestNO(sSiteCode);
			
			// CP 요청번호를 세션에 저장합니다.
			// 현재 예제로 저장한 세션은 ipin_result.jsp 페이지에서 데이타 위변조 방지를 위해 확인하기 위함입니다.
			// 필수사항은 아니며, 보안을 위한 권고사항입니다.
			session.setAttribute("CPREQUEST" , sCPRequest);
			
			// Method 결과값(iRtn)에 따라, 프로세스 진행여부를 파악합니다.
			int iRtn = pClient.fnRequest(sSiteCode, sSitePw, sCPRequest, sReturnURL);
			
			String sRtnMsg					= "";			// 처리결과 메세지
			String sEncData					= "";			// 암호화 된 데이타
			
			// Method 결과값에 따른 처리사항
			if (iRtn == 0)
			{
				// fnRequest 함수 처리시 업체정보를 암호화한 데이터를 추출합니다.
				// 추출된 암호화된 데이타는 당사 팝업 요청시, 함께 보내주셔야 합니다.
				sEncData = pClient.getCipherData();		//암호화 된 데이타
			}
			else if (iRtn == -1 || iRtn == -2)
			{
				sRtnMsg =	"배포해 드린 서비스 모듈 중, 귀사 서버환경에 맞는 모듈을 이용해 주시기 바랍니다.<BR>" +
							"귀사 서버환경에 맞는 모듈이 없다면 ..<BR><B>iRtn 값, 서버 환경정보를 정확히 확인하여 메일로 요청해 주시기 바랍니다.</B>";
			}
			else if (iRtn == -9)
			{
				sRtnMsg = "입력값 오류 : fnRequest 함수 처리시, 필요한 4개의 파라미터값의 정보를 정확하게 입력해 주시기 바랍니다.";
			}
			else
			{
				sRtnMsg = "iRtn 값 확인 후, NICE평가정보 개발 담당자에게 문의해 주세요.";
			}
		    if(!"".equals(sRtnMsg)){
		    	log.error(sRtnMsg);
		    	throwBizException("com.error.realauth.encodeerror", new String[]{String.valueOf(iRtn)});
		    }
		    
		    model.addAttribute("sEncData",sEncData);
		}
		return ui;
	}

	

	/**
	 * NICE실명인증 성공
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/authSuccess.do")
	public String authSuccess(
			HttpServletRequest request,
			HttpSession session,
			ModelMap model) throws Exception{
		String type = Globals.REALAUTH_TYPE;
		String ui = "/exts/realauth/" + type + "/authSuccess";
		
		if("nice".equals(type)){
			NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();

		    String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");

		    String sSiteCode = Globals.NICE_SITECODE;			// NICE로부터 부여받은 사이트 코드
		    String sSitePassword = Globals.NICE_SITEPASSWORD;		// NICE로부터 부여받은 사이트 패스워드

		    String sCipherTime = "";			// 복호화한 시간
		    String sRequestNumber = "";			// 요청 번호
		    String sResponseNumber = "";		// 인증 고유번호
		    String sAuthType = "";				// 인증 수단
		    String sName = "";					// 성명
		    String sDupInfo = "";				// 중복가입 확인값 (DI_64 byte)
		    String sConnInfo = "";				// 연계정보 확인값 (CI_88 byte)
		    String sBirthDate = "";				// 생년월일(YYYYMMDD)
		    String sGender = "";				// 성별
		    String sNationalInfo = "";			// 내/외국인정보 (개발가이드 참조)
			String sMobileNo = "";				// 휴대폰번호
			String sMobileCo = "";				// 통신사
		    String sMessage = "";
		    String sPlainData = "";
		    
		    int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);

		    if( iReturn == 0 )
		    {
		        sPlainData = niceCheck.getPlainData();
		        sCipherTime = niceCheck.getCipherDateTime();
		        
		        // 데이타를 추출합니다.
		        java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
		        
		        sRequestNumber  = (String)mapresult.get("REQ_SEQ");
		        sResponseNumber = (String)mapresult.get("RES_SEQ");
		        sAuthType		= (String)mapresult.get("AUTH_TYPE");
		        sName			= (String)mapresult.get("NAME");
				//sName			= (String)mapresult.get("UTF8_NAME"); //charset utf8 사용시 주석 해제 후 사용
		        sBirthDate		= (String)mapresult.get("BIRTHDATE");
		        sGender			= (String)mapresult.get("GENDER");
		        sNationalInfo  	= (String)mapresult.get("NATIONALINFO");
		        sDupInfo		= (String)mapresult.get("DI");
		        sConnInfo		= (String)mapresult.get("CI");
		        sMobileNo		= (String)mapresult.get("MOBILE_NO");
		        sMobileCo		= (String)mapresult.get("MOBILE_CO");
		        /*
		        log.debug(":" + sAuthType);
		        log.debug(":" + sName);
		        log.debug(":" + sBirthDate);
		        log.debug(":" + sGender);
		        log.debug(":" + sNationalInfo);
		        log.debug(":" + sDupInfo);
		        log.debug("ci:" + sConnInfo);
		        log.debug(":" + sMobileNo);
		        log.debug(":" + sMobileCo);
		        */
		        String session_sRequestNumber = (String)session.getAttribute("REQ_SEQ");
		        if(!sRequestNumber.equals(session_sRequestNumber))
		        {
		            sMessage = "세션값이 다릅니다. 올바른 경로로 접근하시기 바랍니다.";
		            sResponseNumber = "";
		            sAuthType = "";
		        }
		    }
		    else if( iReturn == -1)
		    {
		        sMessage = "복호화 시스템 에러입니다.";
		    }    
		    else if( iReturn == -4)
		    {
		        sMessage = "복호화 처리오류입니다.";
		    }    
		    else if( iReturn == -5)
		    {
		        sMessage = "복호화 해쉬 오류입니다.";
		    }    
		    else if( iReturn == -6)
		    {
		        sMessage = "복호화 데이터 오류입니다.";
		    }    
		    else if( iReturn == -9)
		    {
		        sMessage = "입력 데이터 오류입니다.";
		    }    
		    else if( iReturn == -12)
		    {
		        sMessage = "사이트 패스워드 오류입니다.";
		    }    
		    else
		    {
		        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
		    }

		    if(!"".equals(sMessage)){
		    	log.error(sMessage);
		    	throwBizException("com.error.realauth.encodeerror", new String[]{String.valueOf(iReturn)});
		    }
		    
			RealauthVO authVO = new RealauthVO();
			authVO.setDupinfo(sDupInfo);
			authVO.setRealname(sName);
			authVO.setSex(sGender);
			authVO.setType(sAuthType);
			authVO.setMobile(sMobileNo);
			authVO.setMobileCo(sMobileCo);
			authVO.setCi(sConnInfo);
			authVO.setNationalInfo(sNationalInfo);
			authVO.setBirth(sBirthDate);
//			authVO.setAgeCode(sAgeCode);
			realAuthService.makeSession(authVO);
		}
		return ui;
	}

	/**
	 * 실명인증 실패
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/authFail.do")
	public String authFail(
			HttpServletRequest request,
			HttpSession session,
			ModelMap model) throws Exception{
		String type = Globals.REALAUTH_TYPE;
		String ui = "/exts/realauth/" + type + "/authFail";
		
		if("nice".equals(type)){
			NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();

		    String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");

		    String sSiteCode = Globals.NICE_SITECODE;			// NICE로부터 부여받은 사이트 코드
		    String sSitePassword = Globals.NICE_SITEPASSWORD;		// NICE로부터 부여받은 사이트 패스워드

		    String sCipherTime = "";			// 복호화한 시간
		    String sRequestNumber = "";			// 요청 번호
		    String sErrorCode = "";				// 인증 결과코드
		    String sAuthType = "";				// 인증 수단
		    String sMessage = "";
		    String sPlainData = "";
		    
		    int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);

		    if( iReturn == 0 )
		    {
		        sPlainData = niceCheck.getPlainData();
		        sCipherTime = niceCheck.getCipherDateTime();
		        
		        // 데이타를 추출합니다.
		        java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
		        
		        sRequestNumber 	= (String)mapresult.get("REQ_SEQ");
		        sErrorCode 		= (String)mapresult.get("ERR_CODE");
		        sAuthType 		= (String)mapresult.get("AUTH_TYPE");
		    }
		    else if( iReturn == -1)
		    {
		        sMessage = "복호화 시스템 에러입니다.";
		    }    
		    else if( iReturn == -4)
		    {
		        sMessage = "복호화 처리오류입니다.";
		    }    
		    else if( iReturn == -5)
		    {
		        sMessage = "복호화 해쉬 오류입니다.";
		    }    
		    else if( iReturn == -6)
		    {
		        sMessage = "복호화 데이터 오류입니다.";
		    }    
		    else if( iReturn == -9)
		    {
		        sMessage = "입력 데이터 오류입니다.";
		    }    
		    else if( iReturn == -12)
		    {
		        sMessage = "사이트 패스워드 오류입니다.";
		    }    
		    else
		    {
		        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
		    }
		    if(!"".equals(sMessage)){
		    	log.error(sMessage);
		    	throwBizException("com.error.realauth.encodeerror", new String[]{String.valueOf(iReturn)});
		    }
		    model.addAttribute("authType",sAuthType);
		    model.addAttribute("errorCode",sErrorCode);
		}
		return ui;
	}
	

	/**
	 * NICE IPIN인증 성공
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/authIpinSuccess.do")
	public String authIpinSuccess(
			HttpServletRequest request,
			HttpSession session,
			ModelMap model) throws Exception{
		String type = Globals.REALAUTH_TYPE;
		String ui = "/exts/realauth/" + type + "/authSuccess";
		
		if("nice".equals(type)){
			/********************************************************************************************************************************************
			NICE평가정보 Copyright(c) KOREA INFOMATION SERVICE INC. ALL RIGHTS RESERVED
			
			서비스명 : 가상주민번호서비스 (IPIN) 서비스
			페이지명 : 가상주민번호서비스 (IPIN) 결과 페이지
			*********************************************************************************************************************************************/

			String sSiteCode				= Globals.NICE_IPIN_SITECODE;			// IPIN 서비스 사이트 코드		(NICE평가정보에서 발급한 사이트코드)
			String sSitePw					= Globals.NICE_IPIN_SITEPASSWORD;			// IPIN 서비스 사이트 패스워드	(NICE평가정보에서 발급한 사이트패스워드)
			
				
			// 사용자 정보 및 CP 요청번호를 암호화한 데이타입니다.
		    String sResponseData = requestReplace(request.getParameter("enc_data"), "encodeData");
		    
		    // CP 요청번호 : ipin_main.jsp 에서 세션 처리한 데이타
		    String sCPRequest = (String)session.getAttribute("CPREQUEST");
	
		    
		    // 객체 생성
			IPIN2Client pClient = new IPIN2Client();
			
			
			/*
			┌ 복호화 함수 설명  ──────────────────────────────────────────────────────────
				Method 결과값(iRtn)에 따라, 프로세스 진행여부를 파악합니다.
				
				fnResponse 함수는 결과 데이타를 복호화 하는 함수이며,
				'sCPRequest'값을 추가로 보내시면 CP요청번호 일치여부도 확인하는 함수입니다. (세션에 넣은 sCPRequest 데이타로 검증)
				
				따라서 귀사에서 원하는 함수로 이용하시기 바랍니다.
			└────────────────────────────────────────────────────────────────────
			*/
			int iRtn = pClient.fnResponse(sSiteCode, sSitePw, sResponseData);
			//int iRtn = pClient.fnResponse(sSiteCode, sSitePw, sResponseData, sCPRequest);

			String sRtnMsg					= "";							// 처리결과 메세지
			String sVNumber					= pClient.getVNumber();			// 가상주민번호 (13byte, 영숫자 조합)
			String sName					= pClient.getName();			// 성명 (EUC-KR)
			String sAgeCode					= pClient.getAgeCode();			// 연령대코드 (0~7: 가이드 참조)
			String sGenderCode				= pClient.getGenderCode();		// 성별 (0:여성, 1: 남성)
			String sBirthDate				= pClient.getBirthDate();		// 생년월일 (YYYYMMDD)
			String sNationalInfo			= pClient.getNationalInfo();	// 내/외국인코드 (0:내국인, 1:외국인)
			String sCPRequestNum			= pClient.getCPRequestNO();		// CP 요청번호
			String sDupInfo					= pClient.getDupInfo();			// 중복가입확인값 (64byte, 개인식별값, DI:Duplicate Info) 
			String sCoInfo1				    = pClient.getCoInfo1();			// 연계정보 확인값 (88byte, 개인식별값, CI:Connecting Information)
			String sCIUpdate			    = pClient.getCIUpdate();		// CI 갱신정보 (1~: 가이드 참조)
			String sAuthInfo			    = pClient.getAuthInfo();		// 본인확인수단 (0~4: 가이드 참조)
					
			// Method 결과값에 따른 처리사항
			if (iRtn == 1)
			{
				//정상처리
				sRtnMsg = "";
				
			}
		    else if (iRtn == -1 || iRtn == -4)
		    {
		        sRtnMsg = "복호화 시스템 오류 :<br> 귀사 서버 환경에 맞는 모듈을 이용해주십시오.<br>오류가 지속되는 경우 iRtn 값, 서버 환경정보, 사이트코드를 기재해 문의주시기 바랍니다.";
		    }
		    else if (iRtn == -6)
		    {
		        sRtnMsg =	"복호화 처리 오류: 당사에서 이용하는 charset인 EUC-KR이 정상적으로 받아지는 확인해주십시오. <br>오류가 지속되는 경우, 개발 가이드의 <b>\"결과 데이터 확인 방법\"</b>을 참고해주시기 바랍니다.";
		    }
		    else if (iRtn == -9)
		    {
		        sRtnMsg = "입력 정보 오류: 복호화 함수에 입력된 파라미터 값을 확인해주십시오.<br>오류가 지속되는 경우, 함수 실행 직전 각 파라미터 값을 로그로 출력해 발송해주시기 바랍니다.";
		    }
		    else if (iRtn == -12)
		    {
		        sRtnMsg = "CP 패스워드 불일치: IPIN 서비스 사이트패스워드를 확인해주시기 바랍니다.";
		    }
		    else if (iRtn == -13)
		    {
		        sRtnMsg = "CP 요청번호 불일치: 세션에 저장된 CP요청번호(sCPRequest) 값을 확인해주시기 바랍니다.";
		    }
		    else
		    {
		        sRtnMsg = "기타오류: iRtn 값 확인 후 NICE평가정보 전산 담당자에게 문의해주시기 바랍니다.";
			}

		    if(!"".equals(sRtnMsg)){
		    	log.error(sRtnMsg);
		    	throwBizException("com.error.realauth.encodeerror", new String[]{String.valueOf(iRtn)});
		    }
		    
			RealauthVO authVO = new RealauthVO();
			authVO.setType(sAuthInfo);
			authVO.setDupinfo(sDupInfo);
			authVO.setRealname(sName);
			authVO.setSex(sGenderCode);
			authVO.setBirth(sBirthDate);
//			authVO.setMobile(sMobileNo);
//			authVO.setMobileCo(sMobileCo);
			authVO.setCi(sCoInfo1);
			authVO.setNationalInfo(sNationalInfo);
			authVO.setAgeCode(sAgeCode);
			realAuthService.makeSession(authVO);
		}
		return ui;
	}
	
	/**
	 * 실명인증 강제 생성(개발용)
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user/exts/realauth/dev.do")
	public String dev(
			HttpServletRequest request,
			HttpSession session,
			RealauthVO authVO,
			ModelMap model) throws Exception{
		String ui = "/exts/realauth/dev";
		if("Y".equals(request.getParameter("remove"))){
			realAuthService.removeSession();
		}else {
			if(authVO.getDupinfo() != null) {
				realAuthService.makeSession(authVO);
				
				model.addAttribute("realAuthVO", realAuthService.getSession());
			}
		}
		return ui;
	}


////////////////////////실행 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	

///////////////////////private,protected 메소드 선언 영역  ///////////////////////////////////////////////////////////////////

	/**
	 * nice용 결과값 변환
	 * @param paramValue
	 * @param gubun
	 * @return
	 */
	private String requestReplace(String paramValue, String gubun) {

        String result = "";
        
        if (paramValue != null) {
        	
        	paramValue = paramValue.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

        	paramValue = paramValue.replaceAll("\\*", "");
        	paramValue = paramValue.replaceAll("\\?", "");
        	paramValue = paramValue.replaceAll("\\[", "");
        	paramValue = paramValue.replaceAll("\\{", "");
        	paramValue = paramValue.replaceAll("\\(", "");
        	paramValue = paramValue.replaceAll("\\)", "");
        	paramValue = paramValue.replaceAll("\\^", "");
        	paramValue = paramValue.replaceAll("\\$", "");
        	paramValue = paramValue.replaceAll("'", "");
        	paramValue = paramValue.replaceAll("@", "");
        	paramValue = paramValue.replaceAll("%", "");
        	paramValue = paramValue.replaceAll(";", "");
        	paramValue = paramValue.replaceAll(":", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll("#", "");
        	paramValue = paramValue.replaceAll("--", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll(",", "");
        	
        	if(gubun != "encodeData"){
        		paramValue = paramValue.replaceAll("\\+", "");
        		paramValue = paramValue.replaceAll("/", "");
            paramValue = paramValue.replaceAll("=", "");
        	}
        	
        	result = paramValue;
            
        }
        return result;
  }
	
	private String getDomain(HttpServletRequest request) {
		return UrlUtil.currentContextUrl(request);
	}
///////////////////////private,protected 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	
}