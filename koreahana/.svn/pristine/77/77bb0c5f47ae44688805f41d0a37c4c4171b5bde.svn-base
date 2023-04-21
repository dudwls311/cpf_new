package exts.koreahana.fth.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.fth.vo.KoreahanaFthNewVO;

/**
 * @Class Name : KoreahanaFthService.java
 * @Description : 미래행복통장신규신청 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaFthNewService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaFthNewVO> selectKoreahanaFthNewList(KoreahanaFthNewVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaFthNewTot(KoreahanaFthNewVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaFthNewVO selectKoreahanaFthNew(KoreahanaFthNewVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaFthNew(KoreahanaFthNewVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaFthNew(KoreahanaFthNewVO searchVO) throws EgovBizException;


	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


	/**
	 * 통계 - 연도별월별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthNewStatisticJoinYm(KoreahanaFthNewVO searchVO);

	/**
	 * 통계 - 적립금액별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthNewStatisticSprtAmt(KoreahanaFthNewVO searchVO);

	/**
	 * 통계 - 성별,연령별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthNewStatisticGenderAge(KoreahanaFthNewVO searchVO);
	

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaFthNewVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaFthNewVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaFthNewVO searchVO);
}
