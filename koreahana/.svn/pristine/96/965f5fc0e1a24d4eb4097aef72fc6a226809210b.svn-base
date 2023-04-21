package exts.koreahana.mdl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.mdl.vo.KoreahanaMdlVO;

/**
 * @Class Name : KoreahanaMdlDAO.java
 * @Description : 의료비지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.21
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaMdlDao")
public class KoreahanaMdlDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.mdl.KoreahanaMdl.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaMdlVO> selectKoreahanaMdlList(KoreahanaMdlVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaMdlTot(KoreahanaMdlVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaMdlVO selectKoreahanaMdl(KoreahanaMdlVO searchVO) {
		return (KoreahanaMdlVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaMdl(KoreahanaMdlVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaMdl(KoreahanaMdlVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaMdl(KoreahanaMdlVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMdlStatistic(KoreahanaMdlVO searchVO) {
		return selectList(namespace + "selectStatistic", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
