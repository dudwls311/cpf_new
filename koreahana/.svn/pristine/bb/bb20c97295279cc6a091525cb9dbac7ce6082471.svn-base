package exts.koreahana.spr.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.spr.vo.KoreahanaSprHistoryVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSprService.java
 * @Description : 지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSprService {
	public final static String SPR_FILE = "sprFile";		//지원신청 제출서류 저장경로
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSprVO> selectKoreahanaSprList(KoreahanaSprVO searchVO);

	/**
	 * 리스트 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSprHistoryVO> selectKoreahanaSprListHistory(KoreahanaSprHistoryVO searchVO);
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSprTot(KoreahanaSprVO searchVO);

	/**
	 * 총갯수 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSprTotHistory(KoreahanaSprHistoryVO searchVO);
	
	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSprVO selectKoreahanaSpr(KoreahanaSprVO searchVO);
	
	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSpr(KoreahanaSprVO searchVO) throws Exception;

	/**
	 * 선정결과 변경
	 * @param searchVO
	 */
	List<String> updateKoreahanaSprStts(KoreahanaSprVO searchVO, String[] sprtSnArr) throws EgovBizException;
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSpr(KoreahanaSprVO searchVO) throws EgovBizException;

	/**
	 * 리스트(신청연도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<Map<String, String>> selectKoreahanaSprListGroupByRegDtYr(KoreahanaSprVO searchVO);
	
	/**
	 * 리스트(지원상태)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<Map<String, String>> selectKoreahanaSprListGroupBySprtSttsCd(KoreahanaSprVO searchVO);


	/**
	 * 파라미터로 넘어온 제출서류 처리
	 * @param searchVO
	 * @param request
	 * @param isTmpSave
	 * @throws Exception
	 */
	void getParamToSmbMpnProc(KoreahanaSprVO searchVO, HttpServletRequest request, boolean isTmpSave) throws Exception ;
	
	/**
	 * 모집공고별 신청건수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<Map<String, String>> selectListSprtCnt(KoreahanaSprVO searchVO);
	

	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 * @param searchVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void zipFileDownload(KoreahanaSprVO searchVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSprVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSprVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSprVO searchVO);
}
