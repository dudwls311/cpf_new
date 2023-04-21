package exts.koreahana.spb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.spb.service.KoreahanaSpbService;
import exts.koreahana.spb.vo.KoreahanaSpbVO;

/**
 * @Class Name : KoreahanaSpbServiceImpl.java
 * @Description : 지원사업설정 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.19
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSpbService")
public class KoreahanaSpbServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSpbService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSpbDao")
	private KoreahanaSpbDao koreahanaSpbDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSpbKoreahanaSpbIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSpbVO> selectKoreahanaSpbList(KoreahanaSpbVO searchVO) {
		List<KoreahanaSpbVO> list = (List<KoreahanaSpbVO>)koreahanaSpbDao.selectKoreahanaSpbList(searchVO);
//		if(list != null){
//			for(KoreahanaSpbVO result:list){
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
	public Integer selectKoreahanaSpbTot(KoreahanaSpbVO searchVO) {
		return koreahanaSpbDao.selectKoreahanaSpbTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpbVO selectKoreahanaSpb(KoreahanaSpbVO searchVO) {
		KoreahanaSpbVO result = koreahanaSpbDao.selectKoreahanaSpb(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSpb(KoreahanaSpbVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);
		koreahanaSpbDao.deleteKoreahanaSpb(searchVO);
		
		if(!isStreAuth())throwBizException("com.error.noauth.write");
		if(searchVO.getStngCds() != null) {
			for(String stngCd:searchVO.getStngCds()){
				KoreahanaSpbVO inVO = new KoreahanaSpbVO();
				inVO.setRgtrId(mbrId);
				inVO.setMdfrId(mbrId);
				inVO.setCtgryFrstCd(searchVO.getCtgryFrstCd());
				inVO.setStngCd(stngCd);
				koreahanaSpbDao.insertKoreahanaSpb(inVO);
			}
		}
			
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpb(KoreahanaSpbVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaSpbVO result = selectKoreahanaSpb(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSpbDao.deleteKoreahanaSpb(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSpbVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSpbVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSpbVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}

	/**
	 * 조건에 해당하는 frstCd 데이터 검색
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<String> selectKoreahanaSpbSearch(EgovMap searchVO) {
		return koreahanaSpbDao.selectKoreahanaSpbSearch(searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaSpbVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
