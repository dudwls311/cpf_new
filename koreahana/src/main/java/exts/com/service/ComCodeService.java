package exts.com.service;

import java.util.List;

import exts.com.enums.EnumGrpCd;
import exts.com.vo.ComCodeVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.cmmn.exception.FdlException;

/**
 * @Class Name : ComCodeService.java
 * @Description : 개별코드 Service
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface ComCodeService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComCodeVO> selectComCodeList(ComCodeVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectComCodeTot(ComCodeVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	ComCodeVO selectComCode(ComCodeVO searchVO);

	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void writeComCode(ComCodeVO searchVO) throws EgovBizException, FdlException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteComCode(ComCodeVO searchVO) throws EgovBizException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(ComCodeVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(ComCodeVO searchVO);

	/**
	 * 전체코드 리스트 가져오기
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<ComCodeVO> getAllCode();
	
	/**
	 * 그룹코드로 개별코드 리스트 가져오기
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComCodeVO> getCodeByGrpCd(EnumGrpCd grpCd);

	/**
	 * 그룹코드 및 상위코드로 개별코드 리스트 가져오기
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComCodeVO> getCodeByGrpCd(EnumGrpCd grpCd, String uprCd);

	/**
	 * 상위코드로 개별코드 리스트 가져오기
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComCodeVO> getCodeByUprCd(String uprCd);


	/**
	 * 해당 코드가 그룹에 해당하는지 체크
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	boolean isCdInGrp(EnumGrpCd grpCd, String cd);



	/**
	 * 코드값으로 이름 가져오기
	 * 
	 * @param grpCd
	 * @param cd
	 * @return
	 * @throws Exception
	 */
	String getCdNmInGrp(EnumGrpCd grpCd, String cd);

	/**
	 * 이름으로 코드값 가져오기
	 * 
	 * @param grpCd
	 * @param jccNm
	 * @return
	 * @throws Exception
	 */
	String getCdInGrp(EnumGrpCd grpCd, String jccNm);

	/**
	 * 코드명으로 코드값 가져오기
	 * @param list
	 * @param cdNm
	 * @return
	 */
	String getCd(List<ComCodeVO> list, String cdNm);

}
