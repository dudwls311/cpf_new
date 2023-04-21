package exts.onepass.service;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.onepass.vo.OnepassRequestHandlerVO;
import exts.onepass.vo.OnepassResponseVO;
import exts.onepass.vo.OnepassUserResponseVO;




/**  
 * @Class Name : OnepassService.java
 * @Description : 디지털원패스 서비스 Service
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
public interface OnepassService{
	public static final String SESSION_ONEPASS = "onepassInfo";//세션에 저장될 원패스 사용자 정보 attribute name.
	public static final String SESSION_LOGIN_ONEPASS = "onepassLoginInfo";//세션에 저장될 원패스 로그인정보(userkey, usersession) attribute name.

	/**
	 * OnepassRequestHandler 용 값들 가져오기
	 * @param OnepassRequestHandlerVO
	 */
	OnepassRequestHandlerVO getRequestHandlerValues();

	/**
	 * 응답데이터 변환 후 session에 저장
	 * @param request
	 * @return
	 */
	void responseHandlerCheck(HttpServletRequest request) throws EgovBizException;
	
	/**
	 * 원패스 로그인 세션 생성하기
	 * @param authVO
	 */
	void makeLoginSession(OnepassResponseVO onepassVO);
	
	/**
	 * 원패스 로그인 세션 제거하기
	 */
	void removeLoginSession();
	
	/**
	 * 원패스 로그인 세션 가져오기
	 * @return RealauthVO
	 */
	OnepassResponseVO getLoginSession();
	

	/**
	 * 원패스 세션 생성하기
	 * @param authVO
	 */
	void makeSession(OnepassUserResponseVO onepassVO);
	
	/**
	 * 원패스 세션 제거하기
	 */
	void removeSession();
	
	/**
	 * 원패스 세션 가져오기
	 * @return RealauthVO
	 */
	OnepassUserResponseVO getSession();
	
	/**
	 * 사용자 정보 가져오기
	 * @param onepassVO
	 * @return
	 */
	OnepassUserResponseVO getUserInfo(OnepassResponseVO onepassVO);
	
	/**
	 * 연동 해제 처리
	 * @param onepassVO
	 * @return
	 */
	void out() throws Exception;

}