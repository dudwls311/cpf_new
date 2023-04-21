package exts.koreahana.spb.service;

import java.util.List;

import exts.koreahana.spb.vo.KoreahanaSpbVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : KoreahanaSpbService.java
 * @Description : 지원사업설정 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.10.19
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSpbService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSpbVO> selectKoreahanaSpbList(KoreahanaSpbVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSpbTot(KoreahanaSpbVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSpbVO selectKoreahanaSpb(KoreahanaSpbVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSpb(KoreahanaSpbVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSpb(KoreahanaSpbVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSpbVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSpbVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSpbVO searchVO);

	/**
	 * 조건에 해당하는 frstCd 데이터 검색
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<String> selectKoreahanaSpbSearch(EgovMap searchVO);
}
