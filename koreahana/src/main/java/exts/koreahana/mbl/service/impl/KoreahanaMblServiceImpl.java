package exts.koreahana.mbl.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.EgovFormBasedFileVo;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ComAtchFileDao;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.util.ComFileUploadUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.mbl.service.KoreahanaMblService;
import exts.koreahana.mbl.vo.KoreahanaMblVO;

/**
 * @Class Name : KoreahanaMblServiceImpl.java
 * @Description : 모바일업로드 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaMblService")
public class KoreahanaMblServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaMblService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaMblDao")
	private KoreahanaMblDao koreahanaMblDao;

	@Resource(name = "comAtchFileDao")
	private ComAtchFileDao comAtchFileDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaMblKoreahanaMblIdGnrService")		//IDGEN USE
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
	public List<KoreahanaMblVO> selectKoreahanaMblList(KoreahanaMblVO searchVO) {
		List<KoreahanaMblVO> list = (List<KoreahanaMblVO>)koreahanaMblDao.selectKoreahanaMblList(searchVO);
//		if(list != null){
//			for(KoreahanaMblVO result:list){
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
	public Integer selectKoreahanaMblTot(KoreahanaMblVO searchVO) {
		return koreahanaMblDao.selectKoreahanaMblTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaMblVO selectKoreahanaMbl(KoreahanaMblVO searchVO) {
		KoreahanaMblVO result = koreahanaMblDao.selectKoreahanaMbl(searchVO);

		if(result != null) {
			//유효기간 체크
			Date today = new Date();
			result.setValid(today.before(result.getVldDt()));	
		}
		
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaMbl(KoreahanaMblVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getMblUldSn());  //IDGEN USE
//		String id = NullUtil.nullString(searchVO.getMblUldSn());	//SEQUENCE USE
		
//		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setMblUldSn(id);				//IDGEN USE
			if(!isLogin())throwBizException("com.error.noauth.write");
			
			koreahanaMblDao.insertKoreahanaMbl(searchVO);
		/*
			id = searchVO.getMblUldSn();				//SEQUENCE USE
		}else{
			KoreahanaMblVO result = selectKoreahanaMbl(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getMblUldSn();
			
			koreahanaMblDao.updateKoreahanaMbl(searchVO);
		}
		*/

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaMbl(KoreahanaMblVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaMblVO result = selectKoreahanaMbl(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaMblDao.deleteKoreahanaMbl(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaMblVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaMblVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaMblVO searchVO){
		if(searchVO == null)return false;
//		if(isAdmin())return true;
		
		return getLoginID().equals(searchVO.getRgtrId());
	}

	/**
	 * 업로드 처리
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void uploadKoreahanaMbl(KoreahanaMblVO searchVO, HttpServletRequest request) throws Exception {
		//모바일 업로드는 로그인정보가 없으므로 공통업로드기능 사용 X
		String fileName = "upfile";
		String uppath = "MBL";
		for(EgovFormBasedFileVo fvo : ComFileUploadUtil.uploadFormFiles(request, fileName, uppath, "", null)) {
			ComAtchFileVO atchFileVO = new ComAtchFileVO();
			atchFileVO.setOrgnlAtchFileNm(fvo.getFileName());
			atchFileVO.setAtchFileNm(fvo.getPhysicalName());
			atchFileVO.setAtchFileSz(fvo.getSize());
			atchFileVO.setAtchFileExtnNm(fvo.getExtnName());
			atchFileVO.setAtchFilePathNm(fvo.getServerSubPath());
			atchFileVO.setMdfrId(searchVO.getMdfrId());
			atchFileVO.setRgtrId(searchVO.getRgtrId());
			comAtchFileDao.insertComAtchFile(atchFileVO);
			
			searchVO.setAtchFileSn(atchFileVO.getAtchFileSn());
		}
		
		if(searchVO.getAtchFileSn() == null)throwBizException("exts.error.koreahana.mbl.not.vldExtn");
		
		koreahanaMblDao.updateKoreahanaMbl(searchVO);
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaMblVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
