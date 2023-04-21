package exts.com.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.service.ComAtchFileUserService;
import exts.com.util.FileMngUtil;
import exts.com.vo.ComAtchFileVO;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE
import jnit.crypto.JnitCryptoService;

/**
 * @Class Name : ComAtchFileServiceImpl.java
 * @Description : 첨부파일 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.16
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("comAtchFileUserService")
public class ComAtchFileUserServiceImpl extends ComAtchFileServiceImpl implements ComAtchFileUserService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

    /**
	 * 제출서류 첨부파일 다운로드
	 * @param psrtSn
	 * @param atchFileSn
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void myFileDownload (ComAtchFileVO fileVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileMngUtil.downFile(request, response, fileVO.getAtchFilePathNm(), fileVO.getAtchFileNm(), fileVO.getOrgnlAtchFileNm(), Globals.UPLOAD_PATH);
	}
	
	/**
	 * 이미지 뷰
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	public void imageView (HttpServletRequest request, HttpServletResponse response, String atchFileSn) throws Exception {
		if(!"".equals(NullUtil.nullString(atchFileSn))) {
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(atchFileSn);
			ComAtchFileVO atchFileVO = selectComAtchFile(atchFileSearchVO);
			if(atchFileVO != null) {
				FileMngUtil.showFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), Globals.UPLOAD_PATH);
			}
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(ComAtchFileVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(ComAtchFileVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(ComAtchFileVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
