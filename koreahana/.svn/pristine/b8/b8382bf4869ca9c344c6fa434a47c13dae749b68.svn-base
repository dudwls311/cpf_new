package exts.koreahana.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.sms.vo.KoreahanaSmsLogVO;

/**
 * @Class Name : KoreahanaSmsLogDAO.java
 * @Description : SMS전송로그 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.12.06
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSmsLogDao")
public class KoreahanaSmsLogDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.sms.KoreahanaSmsLog.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmsLogVO> selectKoreahanaSmsLogList(KoreahanaSmsLogVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSmsLogTot(KoreahanaSmsLogVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmsLogVO selectKoreahanaSmsLog(KoreahanaSmsLogVO searchVO) {
		return (KoreahanaSmsLogVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSmsLog(KoreahanaSmsLogVO searchVO) {
		update(namespace + "insert", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
