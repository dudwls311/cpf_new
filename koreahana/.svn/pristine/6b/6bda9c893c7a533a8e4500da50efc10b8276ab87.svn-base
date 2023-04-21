package exts.koreahana.pba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.pba.service.KoreahanaPbaFileService;
import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.cmmn.exception.FdlException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

/**
 * @Class Name : KoreahanaPbaFileServiceImpl.java
 * @Description : 모집공고첨부파일매핑 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.25
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaPbaFileService")
public class KoreahanaPbaFileServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaPbaFileService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaPbaFileDao")
	private KoreahanaPbaFileDao koreahanaPbaFileDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaPbaKoreahanaPbaFileIdGnrService")		//IDGEN USE
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
	public List<KoreahanaPbaFileVO> selectKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaPbaFileVO> list = (List<KoreahanaPbaFileVO>)koreahanaPbaFileDao.selectKoreahanaPbaFileList(searchVO);
//		if(list != null){
//			for(KoreahanaPbaFileVO result:list){
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
	public Integer selectKoreahanaPbaFileTot(KoreahanaPbaFileVO searchVO) {
		return koreahanaPbaFileDao.selectKoreahanaPbaFileTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaPbaFileVO selectKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) {
		KoreahanaPbaFileVO result = koreahanaPbaFileDao.selectKoreahanaPbaFile(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws FdlException 
	 * @throws Exception
	 */
	public void writeKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getPbancrcAtchFileMpngSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getPbancrcAtchFileMpngSn());	//SEQUENCE USE
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setPbancrcAtchFileMpngSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			koreahanaPbaFileDao.insertKoreahanaPbaFile(searchVO);
			id = searchVO.getPbancrcAtchFileMpngSn();				//SEQUENCE USE
		}else{
			KoreahanaPbaFileVO result = selectKoreahanaPbaFile(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getPbancrcAtchFileMpngSn();
			
			koreahanaPbaFileDao.updateKoreahanaPbaFile(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPbaFile(KoreahanaPbaFileVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
//		KoreahanaPbaFileVO result = selectKoreahanaPbaFile(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaPbaFileDao.deleteKoreahanaPbaFile(searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPbaFileList(KoreahanaPbaFileVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
//		KoreahanaPbaFileVO result = selectKoreahanaPbaFile(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");

		if(searchVO != null && searchVO.getPbancrcAtchFileMpngSnList() != null && searchVO.getPbancrcAtchFileMpngSnList().size() > 0) {
			searchVO.setRgtrId(userId);
			searchVO.setMdfrId(userId);
			koreahanaPbaFileDao.deleteKoreahanaPbaFileList(searchVO);
		}
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaPbaFileVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaPbaFileVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaPbaFileVO searchVO){
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
	private void validate(KoreahanaPbaFileVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
