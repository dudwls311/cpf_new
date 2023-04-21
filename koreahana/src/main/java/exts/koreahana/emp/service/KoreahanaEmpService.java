package exts.koreahana.emp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.emp.vo.KoreahanaEmpVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaEmpService.java
 * @Description : 취업연계직업훈련 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmpService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmpVO> selectKoreahanaEmpList(KoreahanaEmpVO searchVO);

	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmpVO> selectKoreahanaEmpListExcel(KoreahanaEmpVO searchVO);
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmpTot(KoreahanaEmpVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmpVO selectKoreahanaEmp(KoreahanaEmpVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmp(KoreahanaEmpVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmp(KoreahanaEmpVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmpVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmpVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmpVO searchVO);

	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;
}
