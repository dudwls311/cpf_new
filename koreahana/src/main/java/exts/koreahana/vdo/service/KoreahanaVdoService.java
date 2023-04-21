package exts.koreahana.vdo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.vdo.vo.KoreahanaVdoExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaVdoService.java
 * @Description : 화상영어교육지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaVdoService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaVdoVO> selectKoreahanaVdoList(KoreahanaVdoVO searchVO);
	
	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaVdoExcelVO> selectKoreahanaVdoListExcel(KoreahanaVdoVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaVdoTot(KoreahanaVdoVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaVdoVO selectKoreahanaVdo(KoreahanaVdoVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaVdo(KoreahanaVdoVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaVdo(KoreahanaVdoVO searchVO) throws EgovBizException;

	/**
	 * 보호자 정보 설정
	 * @param searchVO
	 * @throws EgovBizException
	 */
	void setSprtPrtcrInfoBySession(KoreahanaVdoVO searchVO) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaVdoVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaVdoVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaVdoVO searchVO);

	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;
}
