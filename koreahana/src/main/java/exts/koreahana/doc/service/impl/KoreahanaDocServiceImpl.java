package exts.koreahana.doc.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.doc.service.KoreahanaDocService;
import exts.koreahana.doc.vo.KoreahanaDocVO;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.cmmn.exception.FdlException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

/**
 * @Class Name : KoreahanaDocServiceImpl.java
 * @Description : 문서함 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaDocService")
public class KoreahanaDocServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaDocService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	public final static String DOC_BOX_FILE = "docFile";		//문서함 첨부파일
	
	@Resource(name = "koreahanaDocDao")
	private KoreahanaDocDao koreahanaDocDao;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaDocKoreahanaDocIdGnrService")		//IDGEN USE
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
	public List<KoreahanaDocVO> selectKoreahanaDocList(KoreahanaDocVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		List<KoreahanaDocVO> list = (List<KoreahanaDocVO>)koreahanaDocDao.selectKoreahanaDocList(searchVO);
//		if(list != null){
//			for(KoreahanaDocVO result:list){
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
	public Integer selectKoreahanaDocTot(KoreahanaDocVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		return koreahanaDocDao.selectKoreahanaDocTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaDocVO selectKoreahanaDoc(KoreahanaDocVO searchVO) {
		searchVO.setRgtrId(getLoginID());
		KoreahanaDocVO result = koreahanaDocDao.selectKoreahanaDoc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param request
	 * @throws FdlException 
	 * @throws Exception
	 */
	public void writeKoreahanaDoc(KoreahanaDocVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getDocBoxSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getDocBoxSn());	//SEQUENCE USE
		
		List<String> atchFileSnList = comAtchFileService.writeComAtchUploadFile(request, DOC_BOX_FILE, DOC_BOX_FILE);
		for(String atchFileSn : atchFileSnList) {
			searchVO.setAtchFileSn(atchFileSn);
		}
		
		if("".equals(id)){
			//첨부파일 필수 체크
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setDocBoxSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaDocDao.insertKoreahanaDoc(searchVO);
			id = searchVO.getDocBoxSn();				//SEQUENCE USE
			
		}else{
			KoreahanaDocVO result = selectKoreahanaDoc(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getDocBoxSn();
			
			//수정될 첨부파일이 들어오면 기존 첨부파일 삭제처리
			if(!"".equals(NullUtil.nullString(searchVO.getAtchFileSn()))) {
				ComAtchFileVO atchFileDeleteVO = new ComAtchFileVO();
				atchFileDeleteVO.setAtchFileSn(result.getAtchFileSn());
				comAtchFileService.deleteComAtchFile(atchFileDeleteVO);
			}
			
			koreahanaDocDao.updateKoreahanaDoc(searchVO);
		}
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaDoc(KoreahanaDocVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaDocVO result = selectKoreahanaDoc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaDocDao.deleteKoreahanaDoc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaDocVO searchVO) throws EgovBizException{
		KoreahanaDocVO docSearchVO = new KoreahanaDocVO();
		docSearchVO.setRecordCountPerPage(0);
		
		List<KoreahanaDocVO> docList = selectKoreahanaDocList(docSearchVO);
		if(docList != null) {
			for(KoreahanaDocVO docVO : docList) {
				if(docVO.getDocBoxNm().equals(searchVO.getDocBoxNm())) {
					throwBizException("exts.item.koreahana.doc.duplicationDocBoxNm");
				}
			}
		}
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
