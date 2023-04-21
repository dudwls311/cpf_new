package exts.koreahana.emv.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.emv.vo.KoreahanaEmvPrcVO;

/**
 * @Class Name : KoreahanaEmvPrcDAO.java
 * @Description : 취업바우처카드지원현황관리 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaEmvPrcDao")
public class KoreahanaEmvPrcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.emv.KoreahanaEmvPrc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmvPrcVO> selectKoreahanaEmvPrcList(KoreahanaEmvPrcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}
	
	/**
	 * 리스트 엘셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmvPrcVO> selectKoreahanaEmvPrcListExcel(KoreahanaEmvPrcVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaEmvPrcTot(KoreahanaEmvPrcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvPrcVO selectKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) {
		return (KoreahanaEmvPrcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
