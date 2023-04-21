package exts.koreahana.mgm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.mgm.vo.KoreahanaMgmVO;

/**
 * @Class Name : KoreahanaMgmDAO.java
 * @Description : 경영개선자금지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaMgmDao")
public class KoreahanaMgmDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.mgm.KoreahanaMgm.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaMgmVO> selectKoreahanaMgmList(KoreahanaMgmVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaMgmTot(KoreahanaMgmVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaMgmVO selectKoreahanaMgm(KoreahanaMgmVO searchVO) {
		return (KoreahanaMgmVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaMgm(KoreahanaMgmVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaMgm(KoreahanaMgmVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaMgm(KoreahanaMgmVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계 - 모집분야별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMgmStatisticRcmtFldCd(KoreahanaMgmVO searchVO) {
		return selectList(namespace + "selectStatisticRcmtFldCd", searchVO);
	}

	/**
	 * 통계 - 연도별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMgmStatisticSprtYr(KoreahanaMgmVO searchVO) {
		return selectList(namespace + "selectStatisticSprtYr", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
