package exts.koreahana.frm.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.frm.vo.KoreahanaFrmVO;

/**
 * @Class Name : KoreahanaFrmService.java
 * @Description : 영농정착지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaFrmService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaFrmVO> selectKoreahanaFrmList(KoreahanaFrmVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaFrmTot(KoreahanaFrmVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaFrmVO selectKoreahanaFrm(KoreahanaFrmVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaFrm(KoreahanaFrmVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaFrm(KoreahanaFrmVO searchVO) throws EgovBizException;

	/**
	 * 삭제(선택삭제)
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteAllKoreahanaFrm(KoreahanaFrmVO searchVO) throws EgovBizException;
	
	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFrmStatistic(KoreahanaFrmVO searchVO);

	/**
	 * 통계 - 연도별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFrmStatisticSprtYr(KoreahanaFrmVO searchVO); 

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaFrmVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaFrmVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaFrmVO searchVO);
}
