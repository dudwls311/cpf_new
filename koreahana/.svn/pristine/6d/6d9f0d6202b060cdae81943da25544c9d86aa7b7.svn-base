package exts.koreahana.mdl.service.impl;

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
import exts.koreahana.mdl.service.KoreahanaMdlService;
import exts.koreahana.mdl.vo.KoreahanaMdlVO;

/**
 * @Class Name : KoreahanaMdlServiceImpl.java
 * @Description : 의료비지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.21
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaMdlService")
public class KoreahanaMdlServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaMdlService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaMdlDao")
	private KoreahanaMdlDao koreahanaMdlDao;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaMdlKoreahanaMdlIdGnrService")		//IDGEN USE
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
	public List<KoreahanaMdlVO> selectKoreahanaMdlList(KoreahanaMdlVO searchVO) {
		List<KoreahanaMdlVO> list = (List<KoreahanaMdlVO>)koreahanaMdlDao.selectKoreahanaMdlList(searchVO);
//		if(list != null){
//			for(KoreahanaMdlVO result:list){
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
	public Integer selectKoreahanaMdlTot(KoreahanaMdlVO searchVO) {
		return koreahanaMdlDao.selectKoreahanaMdlTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaMdlVO selectKoreahanaMdl(KoreahanaMdlVO searchVO) {
		KoreahanaMdlVO result = koreahanaMdlDao.selectKoreahanaMdl(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaMdl(KoreahanaMdlVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getMdlcrSprtSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getMdlcrSprtSn());	//SEQUENCE USE
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setMdlcrSprtSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
			koreahanaMdlDao.insertKoreahanaMdl(searchVO);
			id = searchVO.getMdlcrSprtSn();				//SEQUENCE USE
		}else{
			KoreahanaMdlVO result = selectKoreahanaMdl(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getMdlcrSprtSn();
			
			searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
			koreahanaMdlDao.updateKoreahanaMdl(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaMdl(KoreahanaMdlVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaMdlVO result = selectKoreahanaMdl(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaMdlDao.deleteKoreahanaMdl(searchVO);
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
		List<ComCodeVO> dssSeCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.DSS_SE_CD);
		List<ComCodeVO> sprtSeCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SPRT_SE_CD);
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaMdlVO data = (KoreahanaMdlVO)excelVO.getVo();

				try {
					data.setGenderCd(comCodeService.getCd(genderCdList, data.getGenderCd()));
					data.setDssSeCd(comCodeService.getCd(dssSeCdList, data.getDssSeCd()));
					data.setSprtSeCd(comCodeService.getCd(sprtSeCdList, data.getSprtSeCd()));
					data.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaMdlDao.insertKoreahanaMdl(data);
					
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
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaMdlStatistic(KoreahanaMdlVO searchVO) {
		List<EgovMap> list = (List<EgovMap>)koreahanaMdlDao.selectKoreahanaMdlStatistic(searchVO);
//		if(list != null){
//			for(KoreahanaMdlVO result:list){
//				
//			}
//		}
		return list;
	}
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaMdlVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaMdlVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaMdlVO searchVO){
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
	private void validate(KoreahanaMdlVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
