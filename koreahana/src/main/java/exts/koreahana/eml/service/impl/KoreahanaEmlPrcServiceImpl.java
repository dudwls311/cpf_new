package exts.koreahana.eml.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.eml.service.KoreahanaEmlPrcService;
import exts.koreahana.eml.vo.KoreahanaEmlPrcVO;

/**
 * @Class Name : KoreahanaEmlPrcServiceImpl.java
 * @Description : 긴급생계비지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmlPrcService")
public class KoreahanaEmlPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmlPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmlPrcDao")
	private KoreahanaEmlPrcDao koreahanaEmlPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmlKoreahanaEmlPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmlPrcVO> selectKoreahanaEmlPrcList(KoreahanaEmlPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		List<KoreahanaEmlPrcVO> list = (List<KoreahanaEmlPrcVO>)koreahanaEmlPrcDao.selectKoreahanaEmlPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaEmlPrcVO result:list){
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
	public Integer selectKoreahanaEmlPrcTot(KoreahanaEmlPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		return koreahanaEmlPrcDao.selectKoreahanaEmlPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmlPrcVO selectKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		KoreahanaEmlPrcVO result = koreahanaEmlPrcDao.selectKoreahanaEmlPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		validate(searchVO);
		
		KoreahanaEmlPrcVO result = selectKoreahanaEmlPrc(searchVO);
		String id = NullUtil.nullString(result.getEmlvexSprtPrcnMngSn());
		
		if("".equals(id)){
			koreahanaEmlPrcDao.insertKoreahanaEmlPrc(searchVO);
			id = searchVO.getEmlvexSprtPrcnMngSn();				//SEQUENCE USE
		}else{
			koreahanaEmlPrcDao.updateKoreahanaEmlPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmlPrc(KoreahanaEmlPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEmlPrcVO result = selectKoreahanaEmlPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaEmlPrcDao.deleteKoreahanaEmlPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmlPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmlPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmlPrcVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}

	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaEmlPrcStatistic(KoreahanaEmlPrcVO searchVO) {
		return koreahanaEmlPrcDao.selectKoreahanaEmlPrcStatistic(searchVO);
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaEmlPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
