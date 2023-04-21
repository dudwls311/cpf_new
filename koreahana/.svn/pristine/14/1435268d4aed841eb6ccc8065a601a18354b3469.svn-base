package exts.koreahana.spr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.spr.vo.KoreahanaSprHistoryVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSprDAO.java
 * @Description : 지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSprDao")
public class KoreahanaSprDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.spr.KoreahanaSpr.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSprVO> selectKoreahanaSprList(KoreahanaSprVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}
	
	/**
	 * 리스트 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSprHistoryVO> selectKoreahanaSprListHistory(KoreahanaSprHistoryVO searchVO) {
		return selectList(namespace + "selectListHistory", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSprTot(KoreahanaSprVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}
	
	/**
	 * 총갯수 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSprTotHistory(KoreahanaSprHistoryVO searchVO) {
		return (Integer) select(namespace + "selectTotHistory", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSprVO selectKoreahanaSpr(KoreahanaSprVO searchVO) {
		return (KoreahanaSprVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSpr(KoreahanaSprVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSpr(KoreahanaSprVO searchVO) {
		update(namespace + "update", searchVO);
	}
	
	/**
	 * 지원상태+지원사유 변경
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateSttsRsnSpr(KoreahanaSprVO searchVO) {
		update(namespace + "updateSttsRsn", searchVO);
	}

	/**
	 * 리스트(신청연도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectKoreahanaSprListGroupByRegDtYr(KoreahanaSprVO searchVO) {
		return selectList(namespace + "selectListGroupByRegDtYr", searchVO);
	}
	
	/**
	 * 리스트(지원상태)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectKoreahanaSprListGroupBySprtSttsCd(KoreahanaSprVO searchVO) {
		return selectList(namespace + "selectListGroupBySprtSttsCd", searchVO);
	}
	
	/**
	 * 모집공고별 신청건수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectListSprtCnt(KoreahanaSprVO searchVO) {
		return selectList(namespace + "selectListSprtCnt", searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpr(KoreahanaSprVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
