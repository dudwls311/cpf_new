package exts.koreahana.fth.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.fth.vo.KoreahanaFthMdwVO;

/**
 * @Class Name : KoreahanaFthMdwDAO.java
 * @Description : 미래행복통장중도해지 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaFthMdwDao")
public class KoreahanaFthMdwDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.fth.KoreahanaFthMdw.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaFthMdwVO> selectKoreahanaFthMdwList(KoreahanaFthMdwVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaFthMdwTot(KoreahanaFthMdwVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaFthMdwVO selectKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) {
		return (KoreahanaFthMdwVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계 - 연도별월별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthMdwStatisticJoinYm(KoreahanaFthMdwVO searchVO) {
		return selectList(namespace + "selectStatisticJoinYm", searchVO);
	}
	
	/**
	 * 통계 - 중도해지사유별현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthMdwStatisticCncltnRsnCd(KoreahanaFthMdwVO searchVO) {
		return selectList(namespace + "selectStatisticCncltnRsnCd", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
