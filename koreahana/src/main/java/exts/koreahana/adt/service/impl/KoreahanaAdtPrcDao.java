package exts.koreahana.adt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.adt.vo.KoreahanaAdtPrcVO;

/**
 * @Class Name : KoreahanaAdtPrcDAO.java
 * @Description : 가산금지원현황관리 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaAdtPrcDao")
public class KoreahanaAdtPrcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.adt.KoreahanaAdtPrc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcList(KoreahanaAdtPrcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaAdtPrcTot(KoreahanaAdtPrcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtPrcVO selectKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) {
		return (KoreahanaAdtPrcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계 - 월별 
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticMonth(EgovMap searchVO) {
		return selectList(namespace + "selectStatisticMonth", searchVO);
	}
	/**
	 * 통계 - 연도별 
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYear(EgovMap searchVO) {
		return selectList(namespace + "selectStatisticYear", searchVO);
	}
	/**
	 * 통계 - 연도별 (장애정도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearDegr(EgovMap searchVO) {
		return selectList(namespace + "selectStatisticYearDegr", searchVO);
	}
	/**
	 * 통계 - 연도별 (입원기간)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearPeriod(EgovMap searchVO) {
		return selectList(namespace + "selectStatisticYearPeriod", searchVO);
	}
	/**
	 * 통계 - 연도별 (자녀연령)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearAge(EgovMap searchVO) {
		return selectList(namespace + "selectStatisticYearAge", searchVO);
	}
	
	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcListExcel(KoreahanaAdtPrcVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
