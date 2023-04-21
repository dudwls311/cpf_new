package exts.koreahana.smb.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.smb.vo.KoreahanaSmbVO;

/**
 * @Class Name : KoreahanaSmbDAO.java
 * @Description : 제출서류 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSmbDao")
public class KoreahanaSmbDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.smb.KoreahanaSmb.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmbVO> selectKoreahanaSmbList(KoreahanaSmbVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSmbTot(KoreahanaSmbVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbVO selectKoreahanaSmb(KoreahanaSmbVO searchVO) {
		return (KoreahanaSmbVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSmb(KoreahanaSmbVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSmb(KoreahanaSmbVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmb(KoreahanaSmbVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbList(KoreahanaSmbVO searchVO) {
		update(namespace + "deleteList", searchVO);
	}
	
	/**
	 * 제출서류양식일련번호 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbDocForm(KoreahanaSmbVO searchVO) {
		update(namespace + "deleteDocForm", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
