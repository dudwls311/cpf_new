package exts.koreahana.drm.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;

public interface KoreahanaDrmService {

	/**
	 * fasoo drm enc
	 * @param storePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	File enc(String storePath, String fileName) throws EgovBizException;
	
	/**
	 * fasoo drm dec
	 * @param storePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	File dec(String storePath, String fileName) throws EgovBizException;
	
	/**
	 * DRM 파일을 해제하여 multipartfile로 반환
	 * @param originFile
	 * @return
	 * @throws Exception
	 */
	MultipartFile getDrmDecFile(MultipartFile originFile) throws EgovBizException, IOException;
}
