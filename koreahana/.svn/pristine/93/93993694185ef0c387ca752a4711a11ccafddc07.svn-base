package exts.koreahana.smb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSmbService.java
 * @Description : 제출서류 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface KoreahanaSmbService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmbVO> selectKoreahanaSmbList(KoreahanaSmbVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectKoreahanaSmbTot(KoreahanaSmbVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	KoreahanaSmbVO selectKoreahanaSmb(KoreahanaSmbVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeKoreahanaSmb(KoreahanaSmbVO searchVO) throws Exception;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmb(KoreahanaSmbVO searchVO) throws EgovBizException;
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbList(KoreahanaSmbVO searchVO) throws EgovBizException;
	
	/**
	 * 제출서류양식일련번호 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteKoreahanaSmbDocForm(KoreahanaSmbVO searchVO) throws EgovBizException;

	/**
	 * 파라미터로 KoreahanaSmbVO 가져오기
	 * @param request
	 * @return
	 */
	void getParamToSmbVO(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException;
	
	/**
	 * 파라미터로 넘어온 제출서류 validation
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	void getParamToSmbValidate(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException;

	/**
	 * 파라미터로 넘어온 제출서류 삭제
	 * @param pbaVO
	 * @param request
	 * @throws Exception
	 */
	void getParamToDeleteSmbMpn(String upSn, HttpServletRequest request) throws Exception;
	
	/**
	 * 파라미터로 넘어온 제출서류 저장
	 * @param sprVO
	 * @param request
	 * @param isTmpSave
	 * @return
	 * @throws Exception
	 */
	List<KoreahanaSmbMpnVO> getParamToSaveSmbMpn(KoreahanaSprVO sprVO, HttpServletRequest request, boolean isTmpSave) throws Exception;
	
	/**
	 * 
	 * @param searchVO
	 * @param model
	 * @throws Exception
	 */
	void getSmbListAll(KoreahanaPbaVO searchVO, ModelMap model) throws Exception;
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(KoreahanaSmbVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(KoreahanaSmbVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(KoreahanaSmbVO searchVO);
}
