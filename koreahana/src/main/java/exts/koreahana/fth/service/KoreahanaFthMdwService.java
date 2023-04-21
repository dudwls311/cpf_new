package exts.koreahana.fth.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.fth.vo.KoreahanaFthMdwVO;

/**
 * @Class Name : KoreahanaFthMdwService.java
 * @Description : 미래행복통장중도해지 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaFthMdwService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaFthMdwVO> selectKoreahanaFthMdwList(KoreahanaFthMdwVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaFthMdwTot(KoreahanaFthMdwVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaFthMdwVO selectKoreahanaFthMdw(KoreahanaFthMdwVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaFthMdw(KoreahanaFthMdwVO searchVO) throws EgovBizException;


	/**
	 * 일괄 추가/수정
	 * 
	 * @param searchList
	 * @throws Exception
	 */
	void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException;


	/**
	 * 통계 - 연도별월별 해지현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthMdwStatisticJoinYm(KoreahanaFthMdwVO searchVO);

	/**
	 * 통계 - 중도해지사유별현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<EgovMap> selectKoreahanaFthMdwStatisticCncltnRsnCd(KoreahanaFthMdwVO searchVO);

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaFthMdwVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaFthMdwVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaFthMdwVO searchVO);
}
