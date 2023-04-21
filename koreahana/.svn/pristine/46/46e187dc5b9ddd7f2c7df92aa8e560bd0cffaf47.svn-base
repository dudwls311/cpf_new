package exts.koreahana.smb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : KoreahanaSmbTypService.java
 * @Description : 제출서류유형 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.09.14
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSmbTypService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmbTypVO> selectKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO);

	/**
	 * 리스트 All
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmbTypVO> selectKoreahanaSmbTypListAll(KoreahanaSmbTypVO searchVO);
	
	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSmbTypTot(KoreahanaSmbTypVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSmbTypVO selectKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	String writeKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO) throws EgovBizException;
	
	/**
	 * 파라미터로 KoreahanaSmbTypVO 가져오기
	 * @param searchVO
	 * @param request
	 * @throws EgovBizException
	 */
	void getParamToSmbTypVO(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException;

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSmbTypVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSmbTypVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSmbTypVO searchVO);
}
