package exts.onepass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.util.JsonUtil;
import exts.onepass.service.OnepassService;
import exts.onepass.vo.OnepassRequestHandlerVO;
import exts.onepass.vo.OnepassResponseVO;
import exts.onepass.vo.OnepassUserResponseVO;

/**  
 * @Class Name : OnepassServiceImpl.java
 * @Description : 디지털원패스 서비스 ServiceImpl
 * @Modification Information  
 * @
 * @  수정일		수정자		수정내용
 * @ ---------	---------	-------------------------------
 * @ 2022.10.12	김문기		최초생성
 * @ 2022.12.01	김문기		내부망에서 인터넷망 디지털원패스 서버간 연계가 안된다고 하여 인터넷망 와스(relay 서버)와 통신하는 걸로 변경
 * 
 * @author 
 * @since 2022.10.12
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by Meddogi All right reserved.
 */
@Service("onepassService")
public class OnepassServiceImpl extends ExtsAbstractServiceImpl implements OnepassService {

	protected final Log log = LogFactory.getLog(getClass());
//////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////	
//////////////////////// Resource 선언 영역  끝 /////////////////////////////////////////////////////////////////
	
////////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////	

	/**
	 * OnepassRequestHandler 용 값들 가져오기
	 * @param OnepassRequestHandlerVO
	 */
	public OnepassRequestHandlerVO getRequestHandlerValues() {
		/*
		OnepassRequestHandlerVO ret = new OnepassRequestHandlerVO();
		ret.setLoginDest(OnepassRequestHandler.LOGIN_DEST);
		ret.setLoginInputName(OnepassRequestHandler.LOGIN_INPUT_NAME);
		ret.setLoginInputValue(OnepassRequestHandler.login());
		*/
		//relay 서버연계로 변경.
		String url = Globals.RELAY_SERVER + Globals.RELAY_URL_ONEPASS_GET_REQUEST_HANDLER_VALUES;
		RestTemplate rest = new RestTemplate();
		log.debug(url);
		OnepassRequestHandlerVO ret = rest.postForObject(url, null, OnepassRequestHandlerVO.class);
		return ret;
	}

	/**
	 * 응답데이터 변환
	 * @param request
	 * @return
	 */
	public void responseHandlerCheck(HttpServletRequest request) throws EgovBizException {		
/*		
		OnepassResponse onepassResponse = OnepassResponseHandler.check(request);
		if (onepassResponse.getStatus() == STATUS.SUCCESS  && onepassResponse.getResultCode() == RESULT_CODE.SUCCESS) {
			if (onepassResponse.getType() == TYPE.LOGIN) {
//		    	OnepassResponseHandler.onepassLogin(response, onepassResponse.getUserKey(), onepassResponse.getIntfToken());
				//원패스 로그인 세션 담기
				makeLoginSession(onepassResponse);
		  	} else if(onepassResponse.getType() == TYPE.LOGOUT) {
//		    	OnepassResponseHandler.onepassLogout(request, response);
		  		//로그아웃 처리 없음.
		  	}
		}else {
			log.error("onepass/acs:"+ onepassResponse.getStatus() + "," + onepassResponse.getInvalidCode());
			throwBizException("com.error.onepass.notvalid");
		}
*/		
		//relay 서버연계로 변경
		String url = Globals.RELAY_SERVER + Globals.RELAY_URL_ONEPASS_RESPONSE_HANDLER_CHECK;
		RestTemplate rest = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, Object> maps = new LinkedMultiValueMap<String, Object>();
		maps.add("response", request.getParameter("response"));//디컴파일 결과 response라는 파라미터의 값으로 파싱함.(request.getParamter로 사용하므로 그대로 셋팅)
		HttpEntity<MultiValueMap<String, String>> params = new HttpEntity(maps, headers);

    	List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
    	list.add(new FormHttpMessageConverter());
    	list.add(new MappingJackson2HttpMessageConverter());		//json-type
    	rest.setMessageConverters(list);
    	
		OnepassResponseVO onepassResponse = rest.postForObject(url, params, OnepassResponseVO.class);
		if ("SUCCESS".equals(onepassResponse.getStatus())  && "SUCCESS".equals(onepassResponse.getResultCode())) {
			if ("LOGIN".equals(onepassResponse.getType())) {
//		    	OnepassResponseHandler.onepassLogin(response, onepassResponse.getUserKey(), onepassResponse.getIntfToken());
				//원패스 로그인 세션 담기
				makeLoginSession(onepassResponse);
		  	} else if("LOGOUT".equals(onepassResponse.getType())) {
//		    	OnepassResponseHandler.onepassLogout(request, response);
		  		//로그아웃 처리 없음.
		  	}
		}else {
			log.error("onepass/acs:"+ onepassResponse.getStatus() + "," + onepassResponse.getInvalidCode());
			throwBizException("com.error.onepass.notvalid");
		}
	}
	
	/**
	 * 원패스 로그인 세션 생성하기
	 * @param authVO
	 */
	public void makeLoginSession(OnepassResponseVO onepassVO){
		SessionUtil.setAttribute(SESSION_LOGIN_ONEPASS, onepassVO);
	}

	/**
	 * 원패스 로그인 세션 제거하기
	 */
	public void removeLoginSession(){
		SessionUtil.removeAttribute(SESSION_LOGIN_ONEPASS);		
	}

	/**
	 * 원패스 로그인 세션 가져오기
	 * @return RealauthVO
	 */
	public OnepassResponseVO getLoginSession(){
		return (OnepassResponseVO)SessionUtil.getAttribute(SESSION_LOGIN_ONEPASS);		
	}
	
	/**
	 * 원패스 세션 생성하기
	 * @param authVO
	 */
	public void makeSession(OnepassUserResponseVO onepassVO){
		SessionUtil.setAttribute(SESSION_ONEPASS, onepassVO);
	}

	/**
	 * 원패스 세션 제거하기
	 */
	public void removeSession(){
		SessionUtil.removeAttribute(SESSION_ONEPASS);		
	}

	/**
	 * 원패스 세션 가져오기
	 * @return RealauthVO
	 */
	public OnepassUserResponseVO getSession(){
		return (OnepassUserResponseVO)SessionUtil.getAttribute(SESSION_ONEPASS);		
	}

	/**
	 * 사용자 정보 가져오기
	 * @param onepassVO
	 * @return
	 */
	public OnepassUserResponseVO getUserInfo(OnepassResponseVO onepassVO) {
		/*
		ApiSendHandler apiSendHandler = new ApiSendHandler();
		
		String userKey = onepassVO.getUserKey();
		String intfToken = onepassVO.getIntfToken();
		OnepassUserResponse onepassUser = apiSendHandler.findUser(userKey, intfToken);
		 */
		//relay 서버연계로 변경
		String url = Globals.RELAY_SERVER + Globals.RELAY_URL_ONEPASS_FIND_USER;
		RestTemplate rest = new RestTemplate();
		OnepassUserResponseVO onepassUser = rest.postForObject(url, onepassVO, OnepassUserResponseVO.class);
		return onepassUser;
	}

	/**
	 * 연동 해제 처리
	 * @param onepassVO
	 * @return
	 */
	public void out() throws Exception{
		/*
		OnepassResponse onepassResponse = getLoginSession();
		if(onepassResponse == null)throw new EgovBizException("com.error.onepass.nosession");
		
		ApiSendHandler apiSendHandler = new ApiSendHandler();
		OnepassUserResponse onepassUser = apiSendHandler.InterLockRelease(onepassResponse.getUserKey(), onepassResponse.getIntfToken());
		if(onepassUser == null)throw new EgovBizException("com.error.onepass.out.apierror");

		if(onepassUser.getProcess_result() != PROCESS_RESULT.SUCESS) {
			log.error("onepass out error : onepassKey=" + onepassResponse.getUserKey() + ",onepassUser:" + JsonUtil.convertObjectToJson(onepassUser));
			throw new EgovBizException("com.error.onepass.out.fail");
		}
		*/
		//relay 서버연계로 변경
		OnepassResponseVO onepassResponse = getLoginSession();
		if(onepassResponse == null)throw new EgovBizException("com.error.onepass.nosession");

		String url = Globals.RELAY_SERVER + Globals.RELAY_URL_ONEPASS_INTER_LOCK_RELEASE;
		RestTemplate rest = new RestTemplate();
		OnepassUserResponseVO onepassUser = rest.postForObject(url, onepassResponse, OnepassUserResponseVO.class);
		if(onepassUser == null)throw new EgovBizException("com.error.onepass.out.apierror");

		if("SUCCESS".equals(onepassUser.getProcess_result())) {
			log.error("onepass out error : onepassKey=" + onepassResponse.getUserKey() + ",onepassUser:" + JsonUtil.convertObjectToJson(onepassUser));
			throw new EgovBizException("com.error.onepass.out.fail");
		}
	}
////////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////	

///////////////////////private,protected 메소드 선언 영역  ///////////////////////////////////////////////////////////////////
///////////////////////private,protected 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	
}
