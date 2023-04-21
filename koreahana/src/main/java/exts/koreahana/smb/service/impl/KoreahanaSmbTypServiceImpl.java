package exts.koreahana.smb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;

/**
 * @Class Name : KoreahanaSmbTypServiceImpl.java
 * @Description : 제출서류유형 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.14
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSmbTypService")
public class KoreahanaSmbTypServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSmbTypService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSmbTypDao")
	private KoreahanaSmbTypDao koreahanaSmbTypDao;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSmbKoreahanaSmbTypIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSmbTypVO> selectKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaSmbTypVO> list = (List<KoreahanaSmbTypVO>)koreahanaSmbTypDao.selectKoreahanaSmbTypList(searchVO);
//		if(list != null){
//			for(KoreahanaSmbTypVO result:list){
//				
//			}
//		}
		return list;
	}
	
	/**
	 * 리스트 All
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmbTypVO> selectKoreahanaSmbTypListAll(KoreahanaSmbTypVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaSmbTypVO> list = (List<KoreahanaSmbTypVO>)koreahanaSmbTypDao.selectKoreahanaSmbTypList(searchVO);
		if(list != null){
			List<String> smbsnDocTypeSnList = new ArrayList<String>();
			for(KoreahanaSmbTypVO result:list){
				if(!"".equals(NullUtil.nullString(result.getSmbsnDocTypeSn()))) smbsnDocTypeSnList.add(result.getSmbsnDocTypeSn());
			}
			
			//제출서류
			if(smbsnDocTypeSnList != null && smbsnDocTypeSnList.size() > 0) {
				KoreahanaSmbVO smbSearchVO = new KoreahanaSmbVO();
				smbSearchVO.setSmbsnDocTypeSnList(smbsnDocTypeSnList);
				List<KoreahanaSmbVO> smbList = koreahanaSmbService.selectKoreahanaSmbList(smbSearchVO);
				searchVO.setSmbList(smbList);
				
				List<String> smbsnDocFormSnList = null;
				if(smbList != null && smbList.size() > 0) {
					smbsnDocFormSnList = new ArrayList<String>();
					for(KoreahanaSmbVO smbVO : smbList) {
						if(!"".equals(NullUtil.nullString(smbVO.getSmbsnDocFormSn()))) smbsnDocFormSnList.add(smbVO.getSmbsnDocFormSn());
					}
					
					if(smbsnDocFormSnList != null && smbsnDocFormSnList.size() > 0) {
						ComAtchFileVO atchFileVO = new ComAtchFileVO();
						atchFileVO.setAtchFileSnList(smbsnDocFormSnList);
						searchVO.setSmbDocFormList(comAtchFileService.selectComAtchFileList(atchFileVO));
					}
				}
			}
		}
		return list;
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaSmbTypTot(KoreahanaSmbTypVO searchVO) {
		return koreahanaSmbTypDao.selectKoreahanaSmbTypTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbTypVO selectKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) {
		KoreahanaSmbTypVO result = koreahanaSmbTypDao.selectKoreahanaSmbTyp(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public String writeKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getSmbsnDocTypeSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getSmbsnDocTypeSn());	//SEQUENCE USE
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setSmbsnDocTypeSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaSmbTypDao.insertKoreahanaSmbTyp(searchVO);
			id = searchVO.getSmbsnDocTypeSn();				//SEQUENCE USE
		}else{
			KoreahanaSmbTypVO result = selectKoreahanaSmbTyp(searchVO);
//			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getSmbsnDocTypeSn();
			
			koreahanaSmbTypDao.updateKoreahanaSmbTyp(searchVO);
		}
		return id;
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbTyp(KoreahanaSmbTypVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaSmbTypVO result = selectKoreahanaSmbTyp(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbTypDao.deleteKoreahanaSmbTyp(searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbTypList(KoreahanaSmbTypVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		//KoreahanaSmbTypVO result = selectKoreahanaSmbTyp(searchVO);
		//if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbTypDao.deleteKoreahanaSmbTypList(searchVO);
	}

	/**
	 * 파라미터로 KoreahanaSmbTypVO 가져오기
	 * @param searchVO
	 * @param request
	 * @throws EgovBizException
	 */
	public void getParamToSmbTypVO(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException{
		List<KoreahanaSmbTypVO> smbTypList = null;
		KoreahanaSmbTypVO smbTypVO = null;
		String[] smbsnDocTypeVls = request.getParameterValues("smbsnDocTypeVl");
		if(smbsnDocTypeVls != null) {
			smbTypList = new ArrayList<KoreahanaSmbTypVO>();
			for(String smbsnDocTypeVl : smbsnDocTypeVls) {
				smbTypVO = new KoreahanaSmbTypVO();
				smbTypVO.setSmbsnDocTypeVl(smbsnDocTypeVl);
				smbTypList.add(smbTypVO);
			}
			searchVO.setSmbTypList(smbTypList);
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSmbTypVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSmbTypVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSmbTypVO searchVO){
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
	private void validate(KoreahanaSmbTypVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
