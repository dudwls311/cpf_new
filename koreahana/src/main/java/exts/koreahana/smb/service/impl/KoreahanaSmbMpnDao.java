package exts.koreahana.smb.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;

/**
 * @Class Name : KoreahanaSmbMpnDAO.java
 * @Description : 가산금지원제출서류매핑 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSmbMpnDao")
public class KoreahanaSmbMpnDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.smb.KoreahanaSmbMpn.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmbMpnVO> selectKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSmbMpnTot(KoreahanaSmbMpnVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbMpnVO selectKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) {
		return (KoreahanaSmbMpnVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 삭제(다중)
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO) {
		update(namespace + "deleteList", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
