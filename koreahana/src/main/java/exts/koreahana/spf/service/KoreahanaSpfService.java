package exts.koreahana.spf.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.spf.vo.KoreahanaSpfExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;
import exts.koreahana.spf.vo.KoreahanaSpfVO;

/**
 * @Class Name : KoreahanaSpfService.java
 * @Description : 정착지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSpfService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSpfVO> selectKoreahanaSpfList(KoreahanaSpfVO searchVO);

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSpfExcelVO> selectKoreahanaSpfListExcel(KoreahanaSpfVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSpfTot(KoreahanaSpfVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSpfVO selectKoreahanaSpf(KoreahanaSpfVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSpf(KoreahanaSpfVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSpf(KoreahanaSpfVO searchVO) throws EgovBizException;

	/**
	 * 수험표인쇄
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSpfPrcVO selectKoreahanaSpfPrint(KoreahanaSpfVO searchVO);

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSpfVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSpfVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSpfVO searchVO);

	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;
}
