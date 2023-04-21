package exts.koreahana.mgm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.mgm.service.KoreahanaMgmService;
import exts.koreahana.mgm.vo.KoreahanaMgmVO;

/**
 * @Class Name : KoreahanaMgmServiceImpl.java
 * @Description : 경영개선자금지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaMgmService")
public class KoreahanaMgmServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaMgmService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaMgmDao")
	private KoreahanaMgmDao koreahanaMgmDao;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaMgmKoreahanaMgmIdGnrService")		//IDGEN USE
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
	public List<KoreahanaMgmVO> selectKoreahanaMgmList(KoreahanaMgmVO searchVO) {
		List<KoreahanaMgmVO> list = (List<KoreahanaMgmVO>)koreahanaMgmDao.selectKoreahanaMgmList(searchVO);
//		if(list != null){
//			for(KoreahanaMgmVO result:list){
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
	public Integer selectKoreahanaMgmTot(KoreahanaMgmVO searchVO) {
		return koreahanaMgmDao.selectKoreahanaMgmTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaMgmVO selectKoreahanaMgm(KoreahanaMgmVO searchVO) {
		KoreahanaMgmVO result = koreahanaMgmDao.selectKoreahanaMgm(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaMgm(KoreahanaMgmVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getMgmipvAmtSprtSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getMgmipvAmtSprtSn());	//SEQUENCE USE

		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setMgmipvAmtSprtSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaMgmDao.insertKoreahanaMgm(searchVO);
			id = searchVO.getMgmipvAmtSprtSn();				//SEQUENCE USE
		}else{
			KoreahanaMgmVO result = selectKoreahanaMgm(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getMgmipvAmtSprtSn();
			
			koreahanaMgmDao.updateKoreahanaMgm(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaMgm(KoreahanaMgmVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaMgmVO result = selectKoreahanaMgm(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaMgmDao.deleteKoreahanaMgm(searchVO);
	}

	/**
	 * 일괄 추가 / 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws Exception
	 */
	public void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException {

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		String mbrId = getLoginID();
		//코드리스트
		List<ComCodeVO> bzstatCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.BZSTAT_CD);
		List<ComCodeVO> carmdlCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CARMDL_CD);
		List<ComCodeVO> rcmtFldCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.RCMT_FLD_CD);
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaMgmVO data = (KoreahanaMgmVO)excelVO.getVo();

				try {
					data.setBzstatCd(comCodeService.getCd(bzstatCdList, data.getBzstatCd()));
					data.setCarmdlCd(comCodeService.getCd(carmdlCdList, data.getCarmdlCd()));
					data.setRcmtFldCd(comCodeService.getCd(rcmtFldCdList, data.getRcmtFldCd()));
					data.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaMgmDao.insertKoreahanaMgm(data);
					
				}catch(DataAccessException e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("flnm", "com.error.none", getMessage("com.error.none"));
				}catch(Exception e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("flnm", "com.error.none", getMessage("com.error.none"));
				}
				
			}
		}
		
	}
	
	/**
	 * 통계 - 모집분야별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMgmStatisticRcmtFldCd(KoreahanaMgmVO searchVO) {
		return koreahanaMgmDao.selectKoreahanaMgmStatisticRcmtFldCd(searchVO);
	}

	/**
	 * 통계 - 연도별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMgmStatisticSprtYr(KoreahanaMgmVO searchVO) {
		return koreahanaMgmDao.selectKoreahanaMgmStatisticSprtYr(searchVO);
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaMgmVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaMgmVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaMgmVO searchVO){
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
	private void validate(KoreahanaMgmVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
