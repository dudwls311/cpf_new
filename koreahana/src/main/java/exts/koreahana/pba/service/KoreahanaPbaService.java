package exts.koreahana.pba.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaPbaService.java
 * @Description : 모집공고 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaPbaService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaPbaVO> selectKoreahanaPbaList(KoreahanaPbaVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaPbaTot(KoreahanaPbaVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaPbaVO selectKoreahanaPba(KoreahanaPbaVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	void writeKoreahanaPba(KoreahanaSpfQlfVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaPba(KoreahanaPbaVO searchVO) throws EgovBizException;
	
	/**
	 * 조회수 증가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void updateInqCntPlus(KoreahanaPbaVO searchVO) throws EgovBizException;
	
	/**
	 * 모집공고 접수가능 상태
	 * @param searchVO
	 * @param sprVO
	 * @return
	 */
	boolean isAllowSprtStts(KoreahanaPbaVO searchVO, KoreahanaSprVO sprVO);

	/**
	 * XSS 적용된 문자열 가져오기
	 * @param request
	 * @param content
	 * @return
	 * @throws PolicyException
	 * @throws ScanException
	 */
	String getXssClearString(String content) throws PolicyException, ScanException;
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaPbaVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaPbaVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaPbaVO searchVO);
}
