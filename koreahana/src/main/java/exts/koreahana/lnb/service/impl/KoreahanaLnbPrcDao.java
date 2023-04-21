package exts.koreahana.lnb.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;

/**
 * @Class Name : KoreahanaLnbPrcDAO.java
 * @Description : 학습지지원기본정보 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaLnbPrcDao")
public class KoreahanaLnbPrcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.lnb.KoreahanaLnbPrc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaLnbPrcVO> selectKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaLnbPrcTot(KoreahanaLnbPrcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaLnbPrcVO selectKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) {
		return (KoreahanaLnbPrcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO) {
		update(namespace + "deleteList", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
