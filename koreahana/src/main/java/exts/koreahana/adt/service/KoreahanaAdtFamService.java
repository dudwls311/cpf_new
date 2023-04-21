package exts.koreahana.adt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaAdtFamService.java
 * @Description : 가산금지원가족관계 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.05
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaAdtFamService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaAdtFamVO> selectKoreahanaAdtFamList(KoreahanaAdtFamVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaAdtFamTot(KoreahanaAdtFamVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaAdtFamVO selectKoreahanaAdtFam(KoreahanaAdtFamVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaAdtFam(KoreahanaAdtFamVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaAdtFam(KoreahanaAdtFamVO searchVO) throws EgovBizException;

	/**
	 * 파라미터로 KoreahanaAdtFamVO 가져오기
	 * @param request
	 * @return
	 */
	void getParamToAdtFamVO(KoreahanaAdtVO searchVO, HttpServletRequest request);

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaAdtFamVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaAdtFamVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaAdtFamVO searchVO);
}
