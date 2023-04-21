package exts.koreahana.pba.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.pba.vo.KoreahanaPbaVO;

/**
 * @Class Name : KoreahanaPbaDAO.java
 * @Description : 모집공고 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaPbaDao")
public class KoreahanaPbaDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.pba.KoreahanaPba.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaPbaVO> selectKoreahanaPbaList(KoreahanaPbaVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaPbaTot(KoreahanaPbaVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaPbaVO selectKoreahanaPba(KoreahanaPbaVO searchVO) {
		return (KoreahanaPbaVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaPba(KoreahanaPbaVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaPba(KoreahanaPbaVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPba(KoreahanaPbaVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 조회수 증가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateInqCntPlus(KoreahanaPbaVO searchVO) {
		update(namespace + "updateInqCntPlus", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
