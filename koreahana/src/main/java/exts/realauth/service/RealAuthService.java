package exts.realauth.service;

import exts.realauth.vo.RealauthVO;




/**  
 * @Class Name : RealAuthService.java
 * @Description : 실명인증 서비스 Service
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
public interface RealAuthService{
	public static final String SESSION_REALAUTH = "authInfo";//세션에 저장될 attribute name.
	
	/**
	 * 실명인증용 세션 생성하기
	 * @param authVO
	 */
	void makeSession(RealauthVO authVO)throws Exception;
	
	/**
	 * 실명인증용 세션 제거하기
	 */
	void removeSession()throws Exception;
	
	/**
	 * 실명인증용 세션 가져오기
	 * @return RealauthVO
	 */
	RealauthVO getSession()throws Exception;

}