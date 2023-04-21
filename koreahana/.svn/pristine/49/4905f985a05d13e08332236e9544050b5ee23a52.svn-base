package exts.koreahana.emp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;

/**
 * @Class Name : KoreahanaEmpQlfService.java
 * @Description : 취업연계직업훈련자격사항 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaEmpQlfService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaEmpQlfVO> selectKoreahanaEmpQlfList(KoreahanaEmpQlfVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaEmpQlfTot(KoreahanaEmpQlfVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaEmpQlfVO selectKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) throws EgovBizException;

	/**
	 * 파라미터를 List<KoreahanaEmpQlfVO> 반환
	 * @param request
	 * @return
	 */
	List<KoreahanaEmpQlfVO> getParamToEmpQlfVO(HttpServletRequest request);
	
	/**
	 * 파라미터를 List<KoreahanaEmpQlfVO> 반환
	 * @param request
	 * @return
	 */
	void empQlfValidate(List<KoreahanaEmpQlfVO> empQlfVO) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaEmpQlfVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaEmpQlfVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaEmpQlfVO searchVO);
}
