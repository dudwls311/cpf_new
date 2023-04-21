package exts.koreahana.adt.service;

import java.util.List;

import exts.koreahana.adt.vo.KoreahanaAdtPrcVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : KoreahanaAdtPrcService.java
 * @Description : 가산금지원현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaAdtPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcList(KoreahanaAdtPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaAdtPrcTot(KoreahanaAdtPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaAdtPrcVO selectKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaAdtPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaAdtPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaAdtPrcVO searchVO);
	

    
	/**
	 * 통계 - 월별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectStatisticMonth(EgovMap searchVO);

	/**
	 * 통계 - 연도별 
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectStatisticYear(EgovMap searchVO);

	/**
	 * 통계 - 연도별(장애정도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectStatisticYearDegr(EgovMap searchVO);

	/**
	 * 통계 - 연도별(입원기간)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectStatisticYearPeriod(EgovMap searchVO);

	/**
	 * 통계 - 연도별(자녀연령)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectStatisticYearAge(EgovMap searchVO);

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcListExcel(KoreahanaAdtPrcVO searchVO);
}
