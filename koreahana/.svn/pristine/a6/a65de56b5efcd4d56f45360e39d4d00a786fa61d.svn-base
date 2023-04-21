package exts.com.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exts.com.vo.ComSmplVO;
import net.lingala.zip4j.exception.ZipException;

/**
 * @Class Name : ComSmplService.java
 * @Description : 샘플 Service
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
public interface ComSampleSourceService {
    
	/**
	 * 샘플 소스 생성 후 ZIP파일 경로 반환
	 */
	String makeTmpFile(String path, String dbmsType, String inPkg, String inFileName, String inDescription, String tableName, String[] dbColumnArr, String[] dbColumnTypeArr, String[] dbColumnSizeArr, String[] dbColumnIsNotNullArr, String[] dbCommentArr) throws IOException, ZipException;


	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isViewable(ComSmplVO searchVO);


	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isModifiable(ComSmplVO searchVO);


	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	boolean isDeletable(ComSmplVO searchVO);
}
