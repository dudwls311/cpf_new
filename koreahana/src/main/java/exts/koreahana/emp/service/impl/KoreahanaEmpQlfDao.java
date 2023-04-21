package exts.koreahana.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;

/**
 * @Class Name : KoreahanaEmpQlfDAO.java
 * @Description : 취업연계직업훈련자격사항 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaEmpQlfDao")
public class KoreahanaEmpQlfDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.emp.KoreahanaEmpQlf.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmpQlfVO> selectKoreahanaEmpQlfList(KoreahanaEmpQlfVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaEmpQlfTot(KoreahanaEmpQlfVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmpQlfVO selectKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) {
		return (KoreahanaEmpQlfVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
