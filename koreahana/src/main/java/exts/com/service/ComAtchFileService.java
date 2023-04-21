package exts.com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exts.com.vo.ComAtchFileVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;

/**
 * @Class Name : ComAtchFileService.java
 * @Description : 첨부파일 Service
 * @Modification Information
 * 
 * @author
 * @since 2022.08.16
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface ComAtchFileService {
    
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<ComAtchFileVO> selectComAtchFileList(ComAtchFileVO searchVO);

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	Integer selectComAtchFileTot(ComAtchFileVO searchVO);

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	ComAtchFileVO selectComAtchFile(ComAtchFileVO searchVO);

	/**
	 * Pk데이터 File
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	ComAtchFileVO selectComAtchFileSpr(KoreahanaSprVO searchVO);
	
	/**
	 * 추가/수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	String writeComAtchFile(ComAtchFileVO searchVO) throws Exception;

	/**
	 * 첨부파일 업로드 후 일련번호 List 반환
	 * @param request
	 * @param fileAccessNm
	 * @return
	 * @throws Exception
	 */
	List<String> writeComAtchUploadFile(HttpServletRequest request, String fileAccessNm) throws Exception;
	
	/**
	 * 첨부파일 업로드 후 일련번호 List 반환
	 * @param request
	 * @param fileAccessNm
	 * @param uploadSubPath1
	 * @return
	 * @throws Exception
	 */
	List<String> writeComAtchUploadFile(HttpServletRequest request, String fileAccessNm, String uploadSubPath1) throws Exception;
	
	/**
	 * 첨부파일 업로드 후 일련번호 List 반환
	 * @param request
	 * @param fileAccessNm
	 * @return
	 * @throws Exception
	 */
	List<String> writeComAtchUploadFile(HttpServletRequest request, String fileAccessNm, String uploadSubPath1, String uploadSubPath) throws Exception;
	
	/**
	 * 첨부파일 업로드 후 일련번호 List 반환
	 * @param request
	 * @param fileAccessNm
	 * @param uploadSubPath1
	 * @param uploadSubPath2
	 * @return
	 * @throws Exception
	 */
	List<String> writeComAtchUploadFile(HttpServletRequest request, String fileAccessNm, String uploadSubPath1, String uploadSubPath2, String[] accessExt) throws Exception;
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteComAtchFile(ComAtchFileVO searchVO) throws EgovBizException;

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	void deleteComAtchFileList(ComAtchFileVO searchVO) throws EgovBizException;

	/**
	 * 제출서류 첨부파일 다운로드
	 * @param sprtSn
	 * @param atchFileSn
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void myFileDownload (ComAtchFileVO fileVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * 제출서류 첨부파일 다운로드 (DRM)
	 * @param sprtSn
	 * @param atchFileSn
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void myFileDrmDownload (ComAtchFileVO fileVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * 이미지 뷰
	 * @param request
	 * @param response
	 * @param atchFileSn
	 * @throws Exception
	 */
	void imageView (HttpServletRequest request, HttpServletResponse response, String atchFileSn) throws Exception;
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(ComAtchFileVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(ComAtchFileVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(ComAtchFileVO searchVO);
}
