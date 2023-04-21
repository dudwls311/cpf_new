package exts.koreahana.spf.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import exts.com.service.impl.ExtsAbstractDao;
import exts.koreahana.spf.vo.KoreahanaSpfExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;

/**
 * @Class Name : KoreahanaSpfPrcDAO.java
 * @Description : 정착지원현황관리 dao
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Repository("koreahanaSpfPrcDao")
public class KoreahanaSpfPrcDao extends ExtsAbstractDao {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	private final String namespace = "exts.mapper.koreahana.spf.KoreahanaSpfPrc.";
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpfPrcVO> selectKoreahanaSpfPrcList(KoreahanaSpfPrcVO searchVO) {
		return selectList(namespace + "selectList", searchVO);
	}
	
	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSpfPrcExcelVO> selectKoreahanaSpfPrcListExcel(KoreahanaSpfPrcVO searchVO) {
		return selectList(namespace + "selectListExcel", searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public int selectKoreahanaSpfPrcTot(KoreahanaSpfPrcVO searchVO) {
		return (Integer) select(namespace + "selectTot", searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfPrcVO selectKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) {
		return (KoreahanaSpfPrcVO) select(namespace + "select", searchVO);
	}

	/**
	 * 추가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void insertKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) {
		update(namespace + "insert", searchVO);
	}

	/**
	 * 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) {
		update(namespace + "update", searchVO);
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) {
		update(namespace + "delete", searchVO);
	}
	

	/**
	 * 응시번호 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaSpfPrc(KoreahanaSpfExcelVO searchVO) {
		update(namespace + "updateExslno", searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역 /////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝 //////////////////////////////////////////
}
