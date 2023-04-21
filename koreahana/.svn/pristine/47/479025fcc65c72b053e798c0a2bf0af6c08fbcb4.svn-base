package exts.koreahana.sms.service;

import java.util.List;

import exts.koreahana.sms.vo.KoreahanaSmsLogVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaSmsLogService.java
 * @Description : SMS전송로그 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.12.06
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSmsLogService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmsLogVO> selectKoreahanaSmsLogList(KoreahanaSmsLogVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSmsLogTot(KoreahanaSmsLogVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSmsLogVO selectKoreahanaSmsLog(KoreahanaSmsLogVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSmsLog(KoreahanaSmsLogVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSmsLogVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSmsLogVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSmsLogVO searchVO);
}
