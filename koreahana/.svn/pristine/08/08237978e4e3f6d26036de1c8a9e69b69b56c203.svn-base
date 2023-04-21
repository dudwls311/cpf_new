package exts.koreahana.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.sms.service.KoreahanaSmsLogService;
import exts.koreahana.sms.vo.KoreahanaSmsLogVO;

/**
 * @Class Name : KoreahanaSmsLogServiceImpl.java
 * @Description : SMS전송로그 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.12.06
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSmsLogService")
public class KoreahanaSmsLogServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSmsLogService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSmsLogDao")
	private KoreahanaSmsLogDao koreahanaSmsLogDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSmsKoreahanaSmsLogIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSmsLogVO> selectKoreahanaSmsLogList(KoreahanaSmsLogVO searchVO) {
		List<KoreahanaSmsLogVO> list = (List<KoreahanaSmsLogVO>)koreahanaSmsLogDao.selectKoreahanaSmsLogList(searchVO);
//		if(list != null){
//			for(KoreahanaSmsLogVO result:list){
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
	public Integer selectKoreahanaSmsLogTot(KoreahanaSmsLogVO searchVO) {
		return koreahanaSmsLogDao.selectKoreahanaSmsLogTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmsLogVO selectKoreahanaSmsLog(KoreahanaSmsLogVO searchVO) {
		KoreahanaSmsLogVO result = koreahanaSmsLogDao.selectKoreahanaSmsLog(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSmsLog(KoreahanaSmsLogVO searchVO) throws EgovBizException {
		String mbrId = getLoginID();
		mbrId = mbrId.equals("") ? "OTHER" : mbrId;
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
//		if(!isStreAuth())throwBizException("com.error.noauth.write");
		koreahanaSmsLogDao.insertKoreahanaSmsLog(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSmsLogVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSmsLogVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSmsLogVO searchVO){
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
	private void validate(KoreahanaSmsLogVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
