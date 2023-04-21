package exts.koreahana.doc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.doc.vo.KoreahanaDocVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaDocService.java
 * @Description : 문서함 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaDocService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaDocVO> selectKoreahanaDocList(KoreahanaDocVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaDocTot(KoreahanaDocVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaDocVO selectKoreahanaDoc(KoreahanaDocVO searchVO);

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	void writeKoreahanaDoc(KoreahanaDocVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaDoc(KoreahanaDocVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaDocVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaDocVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaDocVO searchVO);
}
