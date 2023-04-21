package exts.koreahana.sgn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.sgn.vo.KoreahanaSgnVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaSgnService.java
 * @Description : 서명 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSgnService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSgnVO> selectKoreahanaSgnList(KoreahanaSgnVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSgnTot(KoreahanaSgnVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSgnVO selectKoreahanaSgn(KoreahanaSgnVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSgn(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSgn(KoreahanaSgnVO searchVO) throws EgovBizException;
	
	/**
	 * 즐겨찾기 서명 설정
	 * @param searchVO
	 */
	void updateKoreahanaSgnFavoChg(KoreahanaSgnVO searchVO) throws EgovBizException;

	/**
	 * 즐겨찾기 서명 초기화
	 * @param searchVO
	 */
	void updateKoreahanaSgnFavoReset(KoreahanaSgnVO searchVO) throws EgovBizException;
	
	/**
	 * 서명파일 일련번호 또는 유무 가져오기
	 * @param request
	 * @param sgnAtchFileSn
	 * @param fileAccessNm
	 * @return
	 */
	String getSgnFile(HttpServletRequest request, String sgnAtchFileSn, String fileAccessNm) throws EgovBizException;
	
	/**
	 * 서명파일(업로드) 저장
	 * @param request
	 * @param fileAccessNm
	 * @param pbancrcSn
	 * @return
	 * @throws Exception
	 */
	String writeSgnFile(HttpServletRequest request, String fileAccessNm, String pbancrcSn) throws Exception;

	/**
	 * 서명파일(직접그리기) 유효성 검사
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	void saveSignFileValidate(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception;
	
	/**
	 * 서명파일(직접그리기) 저장
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	void saveSignFile(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception;
		
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSgnVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSgnVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSgnVO searchVO);
}
