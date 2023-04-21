package exts.koreahana.sgn.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.EgovFileUploadUtil;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.util.ComFileUploadUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.pba.service.impl.KoreahanaPbaServiceImpl;
import exts.koreahana.sgn.service.KoreahanaSgnService;
import exts.koreahana.sgn.vo.KoreahanaSgnVO;

/**
 * @Class Name : KoreahanaSgnServiceImpl.java
 * @Description : 서명 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSgnService")
public class KoreahanaSgnServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSgnService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSgnDao")
	private KoreahanaSgnDao koreahanaSgnDao;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	private final static String SIGN_FILE_EXIST = "SIGN_FILE_EXIST";
	
	public static final String SGN_FILE_NM = "sgnFile";
	/** ID Generation */
    //@Resource(name="extsKoreahanaSgnKoreahanaSgnIdGnrService")		//IDGEN USE
    //private EgovIdGnrService egovIdGnrService;	//IDGEN USE
    
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSgnVO> selectKoreahanaSgnList(KoreahanaSgnVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		List<KoreahanaSgnVO> list = (List<KoreahanaSgnVO>)koreahanaSgnDao.selectKoreahanaSgnList(searchVO);
//		if(list != null){
//			for(KoreahanaSgnVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaSgnTot(KoreahanaSgnVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		return koreahanaSgnDao.selectKoreahanaSgnTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSgnVO selectKoreahanaSgn(KoreahanaSgnVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		KoreahanaSgnVO result = koreahanaSgnDao.selectKoreahanaSgn(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSgn(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getSgntSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getSgntSn());	//SEQUENCE USE
		
		if(SIGN_FILE_EXIST.equals(searchVO.getAtchFileSn())) {
			saveSignFile(searchVO, request);
		}
		
		//기본서명 선택시 기존에 선택되어 있던 기본서명 해제
		if("Y".equals(searchVO.getSgntFavoYn())) updateKoreahanaSgnFavoReset(searchVO);
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setSgntSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaSgnDao.insertKoreahanaSgn(searchVO);
			id = searchVO.getSgntSn();				//SEQUENCE USE
		}else{
			KoreahanaSgnVO result = selectKoreahanaSgn(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getSgntSn();
			koreahanaSgnDao.updateKoreahanaSgn(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSgn(KoreahanaSgnVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaSgnVO result = selectKoreahanaSgn(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSgnDao.deleteKoreahanaSgn(searchVO);
	}

	/**
	 * 즐겨찾기 서명 설정
	 * @param searchVO
	 */
	public void updateKoreahanaSgnFavoChg(KoreahanaSgnVO searchVO) throws EgovBizException {
		if("".equals(NullUtil.nullString(searchVO.getSgntSn()))) throwBizException("exts.item.koreahana.sgn.sgntSnRequired");
		updateKoreahanaSgnFavoReset(searchVO);
		koreahanaSgnDao.updateKoreahanaSgnFavoChg(searchVO);
	}
	
	/**
	 * 즐겨찾기 서명 초기화
	 * @param searchVO
	 */
	public void updateKoreahanaSgnFavoReset(KoreahanaSgnVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		searchVO.setRgtrId(userId);
		if(!"".equals(NullUtil.nullString(searchVO.getRgtrId()))) {
			koreahanaSgnDao.updateKoreahanaSgnFavoReset(searchVO);
		}else {
			throwBizException("com.error.login.nodata");
		}
	}
	
	/**
	 * 서명파일이 존재하는지 확인
	 * @param request
	 * @param sgnAtchFileSn
	 * @param fileAccessNm
	 * @return
	 */
	public String getSgnFile(HttpServletRequest request, String sgnAtchFileSn, String fileAccessNm) {
		if("".equals(NullUtil.nullString(sgnAtchFileSn))) {
			//첨부파일에 포함되어 있다면 로직에서 서명파일 일련번호 넣을 예정이고 여기서는 유효성 검증을 위해 임시값 설정
			if(ComFileUploadUtil.uploadFormFilesValidate(request, fileAccessNm)) sgnAtchFileSn = "SGN_FILE_IN";
		}
		return sgnAtchFileSn;
	}
	
	/**
	 * 서명파일(업로드) 저장
	 * @param request
	 * @param fileAccessNm
	 * @param pbancrcSn
	 * @return
	 * @throws Exception
	 */
	public String writeSgnFile(HttpServletRequest request, String fileAccessNm, String pbancrcSn) throws Exception {
		String fsn = "";
		List<String> atchFileSnList = comAtchFileService.writeComAtchUploadFile(request, fileAccessNm, KoreahanaPbaServiceImpl.PBA_FILE, pbancrcSn, new String[] {"png"});
		for(String atchFileSn : atchFileSnList) {
			fsn = atchFileSn;
		}
		return fsn;
	}
	
	/**
	 * 서명파일(직접그리기) 유효성 검사
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	public void saveSignFileValidate(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception{
		String[] signs = NullUtil.nullString(request.getParameter("signDataUrl")).split(",");
		if(signs.length == 2) searchVO.setAtchFileSn(SIGN_FILE_EXIST);
	}
	
	/**
	 * 서명파일(직접그리기) 저장
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	public void saveSignFile(KoreahanaSgnVO searchVO, HttpServletRequest request) throws Exception{
		String[] signs = request.getParameter("signDataUrl").split(",");
		if(signs == null) throwBizException("exts.item.koreahana.sgn.notExistFile");
		
		String ext = "png";
		String subPath = ComFileUploadUtil.BASE_FOLDER+File.separator+"sign"+File.separator+EgovFileUploadUtil.getTodayString();
		//String fileNm = EgovFileUploadUtil.getPhysicalFileName()+"."+ext;
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileNm = "SGN_"+dayTime.format(new Date())+(int)(Math.random()*100)+"."+ext;
		
		StringBuffer uploadPathSb = new StringBuffer();
		uploadPathSb.append(Globals.UPLOAD_PATH)
					.append(File.separator)
					.append(subPath)
					.append(File.separator)
					.append(fileNm);
		
		FileUtils.writeByteArrayToFile(new File(uploadPathSb.toString()), Base64.decodeBase64(signs[1]));
		Path uploadFilePath = Paths.get(uploadPathSb.toString());
		File file = new File(uploadPathSb.toString());
		long fileSize = 0;
		if(file.exists()) {
			fileSize = Files.size(uploadFilePath);
		}else {
			throwBizException("exts.item.koreahana.sgn.uploadFail");
		}
		ComFileUploadUtil.fileEnc(file.getPath());
		
		ComAtchFileVO atchFileWriteVO = new ComAtchFileVO();
		atchFileWriteVO.setOrgnlAtchFileNm(fileNm);
		atchFileWriteVO.setAtchFileNm(fileNm);
		atchFileWriteVO.setAtchFileSz(fileSize);
		atchFileWriteVO.setAtchFileExtnNm(ext);
		atchFileWriteVO.setAtchFilePathNm(subPath);
		String atchFileSn = comAtchFileService.writeComAtchFile(atchFileWriteVO);
		searchVO.setAtchFileSn(atchFileSn);
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSgnVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSgnVO searchVO){
		if(searchVO == null)return false;

		return isStreAuth();
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSgnVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaSgnVO searchVO) throws EgovBizException{
		KoreahanaSgnVO sgnSearchVO = new KoreahanaSgnVO();
		sgnSearchVO.setRecordCountPerPage(0);
		
		List<KoreahanaSgnVO> sgnList = selectKoreahanaSgnList(sgnSearchVO);
		if(sgnList != null) {
			for(KoreahanaSgnVO sgnVO : sgnList) {
				if(sgnVO.getSgntNm().equals(searchVO.getSgntNm())) {
					throwBizException("exts.item.koreahana.sgn.sgntNmDuplication");
				}
			}
		}
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
