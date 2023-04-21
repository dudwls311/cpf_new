package exts.koreahana.emv.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;

/**
 * @Class Name : KoreahanaEmvPrcTkcService.java
 * @Description : 취업바우처카드지원현황관리수강정보 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.28
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmvPrcTkcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmvPrcTkcVO> selectKoreahanaEmvPrcTkcList(KoreahanaEmvPrcTkcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmvPrcTkcTot(KoreahanaEmvPrcTkcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmvPrcTkcVO selectKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmvPrcTkcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmvPrcTkcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmvPrcTkcVO searchVO);
}
