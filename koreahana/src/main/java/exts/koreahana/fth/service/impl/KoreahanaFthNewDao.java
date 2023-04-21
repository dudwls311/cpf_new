package exts.koreahana.fth.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.fth.vo.KoreahanaFthNewVO;

/**
 * @Class Name : KoreahanaFthDAO.java
 * @Description : 미래행복통장신규신청 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaFthNewDao")
public class KoreahanaFthNewDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.fth.KoreahanaFthNew.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaFthNewVO> selectKoreahanaFthNewList(KoreahanaFthNewVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaFthNewTot(KoreahanaFthNewVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaFthNewVO selectKoreahanaFthNew(KoreahanaFthNewVO searchVO) {
		return (KoreahanaFthNewVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaFthNew(KoreahanaFthNewVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaFthNew(KoreahanaFthNewVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaFthNew(KoreahanaFthNewVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 통계 - 연도별월별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticJoinYm(KoreahanaFthNewVO searchVO) {
		return selectList(namespace + "selectStatisticJoinYm", searchVO);
	}
	
	/**
	 * 통계 - 적립금액별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticSprtAmt(KoreahanaFthNewVO searchVO) {
		return selectList(namespace + "selectStatisticSprtAmt", searchVO);
	}
	
	/**
	 * 통계 - 성별,연령별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticGenderAge(KoreahanaFthNewVO searchVO) {
		return selectList(namespace + "selectStatisticGenderAge", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
