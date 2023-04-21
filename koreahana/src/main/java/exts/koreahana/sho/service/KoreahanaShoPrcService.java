package exts.koreahana.sho.service;

import java.util.List;

import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.sho.vo.KoreahanaShoPrcVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : KoreahanaShoPrcService.java
 * @Description : 장학금지원현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaShoPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaShoPrcVO> selectKoreahanaShoPrcList(KoreahanaShoPrcVO searchVO);

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaShoPrcVO> selectKoreahanaShoPrcListExcel(KoreahanaShoPrcVO searchVO);
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaShoPrcTot(KoreahanaShoPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaShoPrcVO selectKoreahanaShoPrc(KoreahanaShoPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaShoPrc(KoreahanaShoPrcVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaShoPrc(KoreahanaShoPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaShoPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaShoPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaShoPrcVO searchVO);
	

	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaShoPrcListStatistic(EgovMap searchVO);
	
	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;
}
