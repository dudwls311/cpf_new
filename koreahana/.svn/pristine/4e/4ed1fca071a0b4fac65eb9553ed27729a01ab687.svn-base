package exts.koreahana.emp.service;

import java.util.List;

import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : KoreahanaEmpPrcService.java
 * @Description : 취업연계직업훈련지원현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmpPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmpPrcVO> selectKoreahanaEmpPrcList(KoreahanaEmpPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmpPrcTot(KoreahanaEmpPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmpPrcVO selectKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmpPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmpPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmpPrcVO searchVO);
	

	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaEmpPrcStatistic(KoreahanaEmpPrcVO searchVO);
}
