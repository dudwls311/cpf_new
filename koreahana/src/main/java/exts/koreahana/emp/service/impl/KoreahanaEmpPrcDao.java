package exts.koreahana.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;

/**
 * @Class Name : KoreahanaEmpPrcDAO.java
 * @Description : 취업연계직업훈련지원현황관리 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaEmpPrcDao")
public class KoreahanaEmpPrcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.emp.KoreahanaEmpPrc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmpPrcVO> selectKoreahanaEmpPrcList(KoreahanaEmpPrcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaEmpPrcTot(KoreahanaEmpPrcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmpPrcVO selectKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) {
		return (KoreahanaEmpPrcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaEmpPrcStatistic(KoreahanaEmpPrcVO searchVO) {
		return selectList(namespace + "selectStatistic", searchVO);
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
