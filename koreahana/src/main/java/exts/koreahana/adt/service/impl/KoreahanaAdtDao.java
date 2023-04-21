package exts.koreahana.adt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.adt.vo.KoreahanaAdtVO;

/**
 * @Class Name : KoreahanaAdtDAO.java
 * @Description : 가산금지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaAdtDao")
public class KoreahanaAdtDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.adt.KoreahanaAdt.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtVO> selectKoreahanaAdtList(KoreahanaAdtVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}
	
	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtVO> selectKoreahanaAdtListExcel(KoreahanaAdtVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaAdtTot(KoreahanaAdtVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtVO selectKoreahanaAdt(KoreahanaAdtVO searchVO) {
		return (KoreahanaAdtVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaAdt(KoreahanaAdtVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaAdt(KoreahanaAdtVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdt(KoreahanaAdtVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
