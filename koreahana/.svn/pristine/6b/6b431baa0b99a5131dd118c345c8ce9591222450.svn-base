package exts.koreahana.fth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.fth.service.KoreahanaFthNewService;
import exts.koreahana.fth.vo.KoreahanaFthNewVO;

/**
 * @Class Name : KoreahanaFthServiceImpl.java
 * @Description : 미래행복통장신규신청 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaFthNewService")
public class KoreahanaFthNewServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaFthNewService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaFthNewDao")
	private KoreahanaFthNewDao koreahanaFthNewDao;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaFthKoreahanaFthIdGnrService")		//IDGEN USE
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
	public List<KoreahanaFthNewVO> selectKoreahanaFthNewList(KoreahanaFthNewVO searchVO) {
		List<KoreahanaFthNewVO> list = (List<KoreahanaFthNewVO>)koreahanaFthNewDao.selectKoreahanaFthNewList(searchVO);
//		if(list != null){
//			for(KoreahanaFthVO result:list){
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
	public Integer selectKoreahanaFthNewTot(KoreahanaFthNewVO searchVO) {
		return koreahanaFthNewDao.selectKoreahanaFthNewTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaFthNewVO selectKoreahanaFthNew(KoreahanaFthNewVO searchVO) {
		KoreahanaFthNewVO result = koreahanaFthNewDao.selectKoreahanaFthNew(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaFthNew(KoreahanaFthNewVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getFthpbbNewAplySn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getFthpbbNewAplySn());	//SEQUENCE USE

		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setFthpbbNewAplySn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaFthNewDao.insertKoreahanaFthNew(searchVO);
			id = searchVO.getFthpbbNewAplySn();				//SEQUENCE USE
		}else{
			KoreahanaFthNewVO result = selectKoreahanaFthNew(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getFthpbbNewAplySn();
			
			koreahanaFthNewDao.updateKoreahanaFthNew(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaFthNew(KoreahanaFthNewVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaFthNewVO result = selectKoreahanaFthNew(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaFthNewDao.deleteKoreahanaFthNew(searchVO);
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
		List<ComCodeVO> genderCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.GENDER_CD);
		List<ComCodeVO> ageCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.AGE_CD);
		List<ComCodeVO> ecnmatCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.ECNMAT_CD);
		List<ComCodeVO> crCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CR_CD);
		List<ComCodeVO> prtprdExtsnCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.PRTPRD_EXTSN_CD);
		List<ComCodeVO> ctpvCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CTPV_CD);
		List<ComCodeVO> sggCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SGG_CD);
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaFthNewVO data = (KoreahanaFthNewVO)excelVO.getVo();

				try {
					data.setGenderCd(comCodeService.getCd(genderCdList, data.getGenderCd()));
					data.setAgeCd(comCodeService.getCd(ageCdList, data.getAgeCd()));
					data.setEcnmatCd(comCodeService.getCd(ecnmatCdList, data.getEcnmatCd()));
					data.setCrCd(comCodeService.getCd(crCdList, data.getCrCd()));
					data.setPrtprdExtsnCd(comCodeService.getCd(prtprdExtsnCdList, data.getPrtprdExtsnCd()));
					data.setCtpvCd(comCodeService.getCd(ctpvCdList, data.getCtpvCd()));
					data.setSggCd(comCodeService.getCd(sggCdList, data.getSggCd()));
					data.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaFthNewDao.insertKoreahanaFthNew(data);
					
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
	 * 통계 - 연도별월별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticJoinYm(KoreahanaFthNewVO searchVO){
		return koreahanaFthNewDao.selectKoreahanaFthNewStatisticJoinYm(searchVO);
	}

	/**
	 * 통계 - 적립금액별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticSprtAmt(KoreahanaFthNewVO searchVO){
		return koreahanaFthNewDao.selectKoreahanaFthNewStatisticSprtAmt(searchVO);
	}

	/**
	 * 통계 - 성별,연령별 가입현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthNewStatisticGenderAge(KoreahanaFthNewVO searchVO){
		return koreahanaFthNewDao.selectKoreahanaFthNewStatisticGenderAge(searchVO);
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaFthNewVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaFthNewVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaFthNewVO searchVO){
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
	private void validate(KoreahanaFthNewVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
