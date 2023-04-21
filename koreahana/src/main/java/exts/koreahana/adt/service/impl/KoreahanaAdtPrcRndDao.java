package exts.koreahana.adt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.adt.vo.KoreahanaAdtPrcRndVO;

/**
 * @Class Name : KoreahanaAdtPrcRndDAO.java
 * @Description : 가산금지원현황관리회차 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.04
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaAdtPrcRndDao")
public class KoreahanaAdtPrcRndDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.adt.KoreahanaAdtPrcRnd.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtPrcRndVO> selectKoreahanaAdtPrcRndList(KoreahanaAdtPrcRndVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaAdtPrcRndTot(KoreahanaAdtPrcRndVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtPrcRndVO selectKoreahanaAdtPrcRnd(KoreahanaAdtPrcRndVO searchVO) {
		return (KoreahanaAdtPrcRndVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaAdtPrcRnd(KoreahanaAdtPrcRndVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaAdtPrcRnd(KoreahanaAdtPrcRndVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdtPrcRnd(KoreahanaAdtPrcRndVO searchVO) {
		update(namespace + "delete", searchVO);
	}

	/**
	 * 지원현황SN으로 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdtPrcRndByPrcnSn(String sn) {
		update(namespace + "deleteByPrcnSn", sn);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
