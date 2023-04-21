package exts.koreahana.emv.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;

/**
 * @Class Name : KoreahanaEmvPrcTkcDAO.java
 * @Description : 취업바우처카드지원현황관리수강정보 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.28
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaEmvPrcTkcDao")
public class KoreahanaEmvPrcTkcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.emv.KoreahanaEmvPrcTkc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmvPrcTkcVO> selectKoreahanaEmvPrcTkcList(KoreahanaEmvPrcTkcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaEmvPrcTkcTot(KoreahanaEmvPrcTkcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvPrcTkcVO selectKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) {
		return (KoreahanaEmvPrcTkcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
