package exts.koreahana.spf.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;

/**
 * @Class Name : KoreahanaSpfQlfDAO.java
 * @Description : 정착지원자격시험정보 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSpfQlfDao")
public class KoreahanaSpfQlfDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.spf.KoreahanaSpfQlf.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpfQlfVO> selectKoreahanaSpfQlfList(KoreahanaSpfQlfVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSpfQlfTot(KoreahanaSpfQlfVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfQlfVO selectKoreahanaSpfQlf(KoreahanaSpfQlfVO searchVO) {
		return (KoreahanaSpfQlfVO) select(namespace + "select", searchVO);
	}

	/**
	 * merge
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void mergeKoreahanaSpfQlf(KoreahanaSpfQlfVO searchVO) {
		update(namespace + "merge", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
