package exts.koreahana.pba.service;

import java.util.List;

import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaPbaFileService.java
 * @Description : 모집공고첨부파일매핑 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.25
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaPbaFileService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaPbaFileVO> selectKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaPbaFileTot(KoreahanaPbaFileVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaPbaFileVO selectKoreahanaPbaFile(KoreahanaPbaFileVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaPbaFileVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaPbaFileVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaPbaFileVO searchVO);
}
