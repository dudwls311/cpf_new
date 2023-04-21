package exts.koreahana.spf.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.spf.vo.KoreahanaSpfExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;
import exts.koreahana.spf.vo.KoreahanaSpfVO;

/**
 * @Class Name : KoreahanaSpfDAO.java
 * @Description : 정착지원 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSpfDao")
public class KoreahanaSpfDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.spf.KoreahanaSpf.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpfVO> selectKoreahanaSpfList(KoreahanaSpfVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpfExcelVO> selectKoreahanaSpfListExcel(KoreahanaSpfVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSpfTot(KoreahanaSpfVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfVO selectKoreahanaSpf(KoreahanaSpfVO searchVO) {
		return (KoreahanaSpfVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSpf(KoreahanaSpfVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSpf(KoreahanaSpfVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpf(KoreahanaSpfVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	
	/**
	 * 수험표인쇄
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfPrcVO selectKoreahanaSpfPrint(KoreahanaSpfVO searchVO) {
		return (KoreahanaSpfPrcVO) select(namespace + "selectPrint", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
