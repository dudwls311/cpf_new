package exts.koreahana.sho.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.sho.vo.KoreahanaShoVO;

/**
 * @Class Name : KoreahanaShoDAO.java
 * @Description : 장학금지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaShoDao")
public class KoreahanaShoDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.sho.KoreahanaSho.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaShoVO> selectKoreahanaShoList(KoreahanaShoVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaShoVO> selectKoreahanaShoListExcel(KoreahanaShoVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaShoTot(KoreahanaShoVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaShoVO selectKoreahanaSho(KoreahanaShoVO searchVO) {
		return (KoreahanaShoVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSho(KoreahanaShoVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSho(KoreahanaShoVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSho(KoreahanaShoVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
