package exts.koreahana.adt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.adt.vo.KoreahanaAdtVO;

/**
 * @Class Name : KoreahanaAdtService.java
 * @Description : 가산금지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaAdtService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaAdtVO> selectKoreahanaAdtList(KoreahanaAdtVO searchVO);

	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaAdtVO> selectKoreahanaAdtListExcel(KoreahanaAdtVO searchVO);
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaAdtTot(KoreahanaAdtVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaAdtVO selectKoreahanaAdt(KoreahanaAdtVO searchVO);
	
	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaAdt(KoreahanaAdtVO searchVO, HttpServletRequest request) throws Exception;
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaAdt(KoreahanaAdtVO searchVO) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaAdtVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaAdtVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaAdtVO searchVO);
}
