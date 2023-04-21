package exts.koreahana.smb.service;

import java.util.List;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;

/**
 * @Class Name : KoreahanaAdtSmbMpnService.java
 * @Description : 가산금지원제출서류매핑 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSmbMpnService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmbMpnVO> selectKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSmbMpnTot(KoreahanaSmbMpnVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSmbMpnVO selectKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSmbMpnVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSmbMpnVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSmbMpnVO searchVO);
}
