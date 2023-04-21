package exts.ciel.sms.service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.ciel.sms.vo.CielSmsResultVO;
import exts.ciel.sms.vo.CielSmsVO;

/**
 * @Class Name : CielSmsService.java
 * @Description : 문자전송시스템 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface CielSmsService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	boolean sendSms(CielSmsVO searchVO) throws EgovBizException;
	
	/**
	 * sms전송 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	CielSmsResultVO selectKoreahanaSms(CielSmsResultVO searchVO);
}
