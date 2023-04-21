package exts.koreahana.smb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.smb.service.KoreahanaSmbMpnService;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;

/**
 * @Class Name : KoreahanaSmbMpnServiceImpl.java
 * @Description : 가산금지원제출서류매핑 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSmbMpnService")
public class KoreahanaSmbMpnServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSmbMpnService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSmbMpnDao")
	private KoreahanaSmbMpnDao koreahanaSmbMpnDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaAdtKoreahanaSmbMpnIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSmbMpnVO> selectKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaSmbMpnVO> list = (List<KoreahanaSmbMpnVO>)koreahanaSmbMpnDao.selectKoreahanaSmbMpnList(searchVO);
//		if(list != null){
//			for(KoreahanaSmbMpnVO result:list){
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
	public Integer selectKoreahanaSmbMpnTot(KoreahanaSmbMpnVO searchVO) {
		return koreahanaSmbMpnDao.selectKoreahanaSmbMpnTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbMpnVO selectKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) {
		KoreahanaSmbMpnVO result = koreahanaSmbMpnDao.selectKoreahanaSmbMpn(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getSmbDocMpngSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getSmbDocMpngSn());	//SEQUENCE USE
		
//		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setSmbDocMpngSn(id);				//IDGEN USE
			koreahanaSmbMpnDao.insertKoreahanaSmbMpn(searchVO);
			id = searchVO.getSmbDocMpngSn();				//SEQUENCE USE
//		}else{
//			KoreahanaSmbMpnVO result = selectKoreahanaSmbMpn(searchVO);
//			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
//			id = result.getSmbDocMpngSn();
//			
//			koreahanaSmbMpnDao.updateKoreahanaSmbMpn(searchVO);
//		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbMpn(KoreahanaSmbMpnVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaSmbMpnVO result = selectKoreahanaSmbMpn(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbMpnDao.deleteKoreahanaSmbMpn(searchVO);
	}
	
	/**
	 * 삭제(다중)
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbMpnList(KoreahanaSmbMpnVO searchVO) throws EgovBizException {
		koreahanaSmbMpnDao.deleteKoreahanaSmbMpnList(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSmbMpnVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSmbMpnVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSmbMpnVO searchVO){
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
	private void validate(KoreahanaSmbMpnVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
