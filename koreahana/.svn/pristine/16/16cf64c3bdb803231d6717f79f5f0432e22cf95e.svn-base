package exts.koreahana.mgm.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.mgm.vo.KoreahanaMgmVO;

/**
 * @Class Name : KoreahanaMgmService.java
 * @Description : 경영개선자금지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaMgmService {
	
	public static final String RCMT_FLD_CD_VEHICLE = "25002";//운수업코드
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaMgmVO> selectKoreahanaMgmList(KoreahanaMgmVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaMgmTot(KoreahanaMgmVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaMgmVO selectKoreahanaMgm(KoreahanaMgmVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaMgm(KoreahanaMgmVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaMgm(KoreahanaMgmVO searchVO) throws EgovBizException;


	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


	/**
	 * 통계 - 모집분야별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaMgmStatisticRcmtFldCd(KoreahanaMgmVO searchVO);


	/**
	 * 통계 - 연도별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaMgmStatisticSprtYr(KoreahanaMgmVO searchVO);


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaMgmVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaMgmVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaMgmVO searchVO);
}
