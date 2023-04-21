package exts.koreahana.sgn.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.sgn.vo.KoreahanaSgnVO;

/**
 * @Class Name : KoreahanaSgnDAO.java
 * @Description : 서명 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSgnDao")
public class KoreahanaSgnDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.sgn.KoreahanaSgn.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSgnVO> selectKoreahanaSgnList(KoreahanaSgnVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSgnTot(KoreahanaSgnVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSgnVO selectKoreahanaSgn(KoreahanaSgnVO searchVO) {
		return (KoreahanaSgnVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSgn(KoreahanaSgnVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSgn(KoreahanaSgnVO searchVO) {
		update(namespace + "update", searchVO);
	}
	
	/**
	 * 즐겨찾기 서명 설정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSgnFavoChg(KoreahanaSgnVO searchVO) {
		update(namespace + "updateFavoChg", searchVO);
	}
	
	/**
	 * 즐겨찾기 서명 초기화
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSgnFavoReset(KoreahanaSgnVO searchVO) {
		update(namespace + "updateFavoReset", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSgn(KoreahanaSgnVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
