package exts.ciel.sms.service.impl;

import org.springframework.stereotype.Repository;

import exts.ciel.sms.vo.CielSmsResultVO;
import exts.ciel.sms.vo.CielSmsVO;
import exts.com.service.impl.ExtsSmsAbstractDao;

/**
 * @Class Name : CielSmsDao.java
 * @Description : 문자전송시스템 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("cielSmsDao")
public class CielSmsDao extends ExtsSmsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.ciel.sms.CielSms.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

	/**
	 * SMS 전송 후 결과값 받아오기
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public CielSmsVO sendSms(CielSmsVO searchVO) {
		return (CielSmsVO)select(namespace + "sendSms", searchVO);
	}
	
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public CielSmsResultVO selectKoreahanaSms(CielSmsResultVO searchVO) {
		return (CielSmsResultVO) select(namespace + "select", searchVO);
	}
	
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
