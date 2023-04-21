package exts.koreahana.pba.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.pba.vo.KoreahanaPbaFileVO;

/**
 * @Class Name : KoreahanaPbaFileDAO.java
 * @Description : 모집공고첨부파일매핑 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.25
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaPbaFileDao")
public class KoreahanaPbaFileDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.pba.KoreahanaPbaFile.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaPbaFileVO> selectKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaPbaFileTot(KoreahanaPbaFileVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaPbaFileVO selectKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) {
		return (KoreahanaPbaFileVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO) {
		update(namespace + "deleteList", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
