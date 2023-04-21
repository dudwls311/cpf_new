package exts.koreahana.lnb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaLnbPrcService.java
 * @Description : 학습지지원기본정보 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaLnbPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaLnbPrcVO> selectKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaLnbPrcTot(KoreahanaLnbPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaLnbPrcVO selectKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) throws EgovBizException;

	/**
	 * 삭제 목록
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO) throws EgovBizException;
	
	/**
	 * KoreahanaLnbPrcVO 파라미터 셋팅
	 * @param searchVO
	 * @param request
	 */
	void setParamToLnbPrcVO(KoreahanaLnbVO searchVO, HttpServletRequest request);
	
	/**
	 * 학습지지원기본정보 유효성 검사
	 * @param searchVO
	 * @throws EgovBizException
	 */
	void validateLnbPrcVO(KoreahanaLnbPrcVO searchVO) throws EgovBizException;
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaLnbPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaLnbPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaLnbPrcVO searchVO);
	

	/**
	 * 지원현황 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void updateKoreahanaLnbPrcSupport(KoreahanaLnbPrcVO searchVO) throws Exception;
}
