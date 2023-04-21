package exts.koreahana.fth.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.fth.vo.KoreahanaFthMtrVO;

/**
 * @Class Name : KoreahanaFthMtrService.java
 * @Description : 미래행복통장만기해지 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaFthMtrService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaFthMtrVO> selectKoreahanaFthMtrList(KoreahanaFthMtrVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaFthMtrTot(KoreahanaFthMtrVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaFthMtrVO selectKoreahanaFthMtr(KoreahanaFthMtrVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaFthMtr(KoreahanaFthMtrVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaFthMtr(KoreahanaFthMtrVO searchVO) throws EgovBizException;


	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


	/**
	 * 통계 - 연도별월별 해지현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthMtrStatisticJoinYm(KoreahanaFthMtrVO searchVO);

	/**
	 * 통계 - 만기해지사유별현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthMtrStatisticUsdusgCd(KoreahanaFthMtrVO searchVO);


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaFthMtrVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaFthMtrVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaFthMtrVO searchVO);
}
