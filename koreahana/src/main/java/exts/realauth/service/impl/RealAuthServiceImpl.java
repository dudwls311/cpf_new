package exts.realauth.service.impl;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.SessionUtil;
import exts.realauth.service.RealAuthService;
import exts.realauth.vo.RealauthVO;

/**  
 * @Class Name : RealAuthServiceImpl.java
 * @Description : 실명인증서비스 ServiceImpl
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
@Service("realAuthService")
public class RealAuthServiceImpl implements RealAuthService {

//////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////	
//////////////////////// Resource 선언 영역  끝 /////////////////////////////////////////////////////////////////
	
////////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////	

	/**
	 * 실명인증용 세션 생성하기
	 * @param authVO
	 */
	public void makeSession(RealauthVO authVO)throws Exception{
		SessionUtil.setAttribute(SESSION_REALAUTH, authVO);
	}

	/**
	 * 실명인증용 세션 제거하기
	 */
	public void removeSession()throws Exception{
		SessionUtil.removeAttribute(SESSION_REALAUTH);		
	}

	/**
	 * 실명인증용 세션 가져오기
	 * @return RealauthVO
	 */
	public RealauthVO getSession()throws Exception{
		return (RealauthVO)SessionUtil.getAttribute(SESSION_REALAUTH);		
	}
////////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////	

///////////////////////private,protected 메소드 선언 영역  ///////////////////////////////////////////////////////////////////
///////////////////////private,protected 메소드 선언 영역 끝  ///////////////////////////////////////////////////////////////////	
}
