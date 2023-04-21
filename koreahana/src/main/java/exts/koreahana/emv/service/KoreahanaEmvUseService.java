package exts.koreahana.emv.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.emv.vo.KoreahanaEmvUseVO;

/**
 * @Class Name : KoreahanaEmvUseService.java
 * @Description : 취업바우처카드사용정보 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmvUseService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmvUseVO> selectKoreahanaEmvUseList(KoreahanaEmvUseVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmvUseTot(KoreahanaEmvUseVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmvUseVO selectKoreahanaEmvUse(KoreahanaEmvUseVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmvUse(KoreahanaEmvUseVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmvUse(KoreahanaEmvUseVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmvUseVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmvUseVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmvUseVO searchVO);


	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;
}
