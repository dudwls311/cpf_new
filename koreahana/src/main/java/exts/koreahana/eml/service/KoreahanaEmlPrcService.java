package exts.koreahana.eml.service;

import java.util.List;

import exts.koreahana.eml.vo.KoreahanaEmlPrcVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : KoreahanaEmlPrcService.java
 * @Description : 긴급생계비지원현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmlPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmlPrcVO> selectKoreahanaEmlPrcList(KoreahanaEmlPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmlPrcTot(KoreahanaEmlPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmlPrcVO selectKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmlPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmlPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmlPrcVO searchVO);

	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaEmlPrcStatistic(KoreahanaEmlPrcVO searchVO);
}
