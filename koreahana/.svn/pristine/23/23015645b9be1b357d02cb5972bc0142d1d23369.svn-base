package exts.koreahana.vdo.service;

import java.util.List;

import exts.koreahana.vdo.vo.KoreahanaVdoPrcExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaVdoPrcService.java
 * @Description : 화상영어교육현황관리 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaVdoPrcService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaVdoPrcVO> selectKoreahanaVdoPrcList(KoreahanaVdoPrcVO searchVO);
    
	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaVdoPrcExcelVO> selectKoreahanaVdoPrcListExcel(KoreahanaVdoPrcVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaVdoPrcTot(KoreahanaVdoPrcVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaVdoPrcVO selectKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaVdoPrcVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaVdoPrcVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaVdoPrcVO searchVO);
}
