package exts.koreahana.smb.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;

import exts.koreahana.smb.vo.KoreahanaSmbTypVO;

/**
 * @Class Name : KoreahanaSmbTypDAO.java
 * @Description : 제출서류유형 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.09.14
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSmbTypDao")
public class KoreahanaSmbTypDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.smb.KoreahanaSmbTyp.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmbTypVO> selectKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSmbTypTot(KoreahanaSmbTypVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbTypVO selectKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) {
		return (KoreahanaSmbTypVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO) {
		update(namespace + "deleteList", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
