package exts.koreahana.mbl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.mbl.vo.KoreahanaMblVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaMblService.java
 * @Description : 모바일업로드 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaMblService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaMblVO> selectKoreahanaMblList(KoreahanaMblVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaMblTot(KoreahanaMblVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaMblVO selectKoreahanaMbl(KoreahanaMblVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaMbl(KoreahanaMblVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaMbl(KoreahanaMblVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaMblVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaMblVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaMblVO searchVO);


	/**
	 * 업로드 처리
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void uploadKoreahanaMbl(KoreahanaMblVO searchVO, HttpServletRequest request) throws Exception;
}
