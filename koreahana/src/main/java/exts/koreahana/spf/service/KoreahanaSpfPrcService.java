package exts.koreahana.spf.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.spf.vo.KoreahanaSpfPrcExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;

/**
 * @Class Name : KoreahanaSpfPrcService.java
 * @Description : 정착지원현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSpfPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSpfPrcVO> selectKoreahanaSpfPrcList(KoreahanaSpfPrcVO searchVO);

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSpfPrcExcelVO> selectKoreahanaSpfPrcListExcel(KoreahanaSpfPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSpfPrcTot(KoreahanaSpfPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSpfPrcVO selectKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSpfPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSpfPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSpfPrcVO searchVO);
	
}
