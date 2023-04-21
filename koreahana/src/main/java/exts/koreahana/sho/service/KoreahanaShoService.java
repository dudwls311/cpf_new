package exts.koreahana.sho.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.sho.vo.KoreahanaShoVO;

/**
 * @Class Name : KoreahanaShoService.java
 * @Description : 장학금지원 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaShoService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaShoVO> selectKoreahanaShoList(KoreahanaShoVO searchVO);

	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaShoVO> selectKoreahanaShoListExcel(KoreahanaShoVO searchVO);
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaShoTot(KoreahanaShoVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaShoVO selectKoreahanaSho(KoreahanaShoVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSho(KoreahanaShoVO searchVO, HttpServletRequest request) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSho(KoreahanaShoVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaShoVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaShoVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaShoVO searchVO);
	

	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


}
