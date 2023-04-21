package exts.koreahana.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.adt.service.KoreahanaAdtPrcService;
import exts.koreahana.adt.vo.KoreahanaAdtPrcRndVO;
import exts.koreahana.adt.vo.KoreahanaAdtPrcVO;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;

/**
 * @Class Name : KoreahanaAdtPrcServiceImpl.java
 * @Description : 가산금지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaAdtPrcService")
public class KoreahanaAdtPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaAdtPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaAdtPrcDao")
	private KoreahanaAdtPrcDao koreahanaAdtPrcDao;
	
	@Resource(name = "koreahanaAdtPrcRndDao")
	private KoreahanaAdtPrcRndDao koreahanaAdtPrcRndDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaAdtKoreahanaAdtPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcList(KoreahanaAdtPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaAdtPrcVO> list = (List<KoreahanaAdtPrcVO>)koreahanaAdtPrcDao.selectKoreahanaAdtPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaAdtPrcVO result:list){
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
	public Integer selectKoreahanaAdtPrcTot(KoreahanaAdtPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaAdtPrcDao.selectKoreahanaAdtPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtPrcVO selectKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		KoreahanaAdtPrcVO result = koreahanaAdtPrcDao.selectKoreahanaAdtPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		
		//기존데이터(지원정보에 따른 데이터이므로 무조건 존재해야함.) 
		KoreahanaAdtPrcVO result = selectKoreahanaAdtPrc(searchVO);
		String id = NullUtil.nullString(result.getAdtnAmtSprtPrcnMngSn());
		
		if("".equals(id)){			
			koreahanaAdtPrcDao.insertKoreahanaAdtPrc(searchVO);
			id = searchVO.getAdtnAmtSprtPrcnMngSn();				//SEQUENCE USE
		}else{			
			koreahanaAdtPrcDao.updateKoreahanaAdtPrc(searchVO);
		}
		
		//횟차별 데이터 변경
		koreahanaAdtPrcRndDao.deleteKoreahanaAdtPrcRndByPrcnSn(searchVO.getSprtSn());
		if(searchVO.getRndList() != null) {
			for(KoreahanaAdtPrcRndVO rndVO:searchVO.getRndList()) {
				rndVO.setSprtSn(searchVO.getSprtSn());
				koreahanaAdtPrcRndDao.insertKoreahanaAdtPrcRnd(rndVO);
			}
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdtPrc(KoreahanaAdtPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaAdtPrcVO result = selectKoreahanaAdtPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaAdtPrcDao.deleteKoreahanaAdtPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaAdtPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaAdtPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaAdtPrcVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}


    
	/**
	 * 통계 - 월별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticMonth(EgovMap searchVO){
		return koreahanaAdtPrcDao.selectStatisticMonth(searchVO);
	}

	/**
	 * 통계 - 연도별 
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYear(EgovMap searchVO){
		return koreahanaAdtPrcDao.selectStatisticYear(searchVO);
	}

	/**
	 * 통계 - 연도별(장애정도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearDegr(EgovMap searchVO){
		return koreahanaAdtPrcDao.selectStatisticYearDegr(searchVO);
	}

	/**
	 * 통계 - 연도별(입원기간)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearPeriod(EgovMap searchVO){
		return koreahanaAdtPrcDao.selectStatisticYearPeriod(searchVO);
	}

	/**
	 * 통계 - 연도별(자녀연령)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectStatisticYearAge(EgovMap searchVO){
		return koreahanaAdtPrcDao.selectStatisticYearAge(searchVO);
	}
	
	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaAdtPrcVO> selectKoreahanaAdtPrcListExcel(KoreahanaAdtPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaAdtPrcVO> list = (List<KoreahanaAdtPrcVO>)koreahanaAdtPrcDao.selectKoreahanaAdtPrcListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaAdtPrcVO result:list){
//				
//			}
//		}
		return list;
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaAdtPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
