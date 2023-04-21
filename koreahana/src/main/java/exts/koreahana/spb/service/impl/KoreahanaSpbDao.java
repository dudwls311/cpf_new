package exts.koreahana.spb.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.spb.vo.KoreahanaSpbVO;

/**
 * @Class Name : KoreahanaSpbDAO.java
 * @Description : 지원사업설정 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.19
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSpbDao")
public class KoreahanaSpbDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.spb.KoreahanaSpb.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpbVO> selectKoreahanaSpbList(KoreahanaSpbVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSpbTot(KoreahanaSpbVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpbVO selectKoreahanaSpb(KoreahanaSpbVO searchVO) {
		return (KoreahanaSpbVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSpb(KoreahanaSpbVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSpb(KoreahanaSpbVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpb(KoreahanaSpbVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	/**
	 * 조건에 해당하는 frstCd 데이터 검색
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<String> selectKoreahanaSpbSearch(EgovMap searchVO) {
		return selectList(namespace + "selectSearch", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
