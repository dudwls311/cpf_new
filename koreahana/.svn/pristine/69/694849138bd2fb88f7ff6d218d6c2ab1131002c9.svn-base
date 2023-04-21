package exts.com.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.vo.ComIndvlzMenuAuthChngVO;

/**
 * @Class Name : ComIndvlzMenuAuthChngService.java
 * @Description : 그룹메뉴권한변경이력 Service
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface ComIndvlzMenuAuthChngService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComIndvlzMenuAuthChngVO> selectComIndvlzMenuAuthChngList(ComIndvlzMenuAuthChngVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectComIndvlzMenuAuthChngTot(ComIndvlzMenuAuthChngVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	ComIndvlzMenuAuthChngVO selectComIndvlzMenuAuthChng(ComIndvlzMenuAuthChngVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeComIndvlzMenuAuthChng(ComIndvlzMenuAuthChngVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteComIndvlzMenuAuthChng(ComIndvlzMenuAuthChngVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(ComIndvlzMenuAuthChngVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(ComIndvlzMenuAuthChngVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(ComIndvlzMenuAuthChngVO searchVO);
}
