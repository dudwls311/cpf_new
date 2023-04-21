package exts.koreahana.frm.service.impl;

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
import exts.koreahana.frm.service.KoreahanaFrmService;
import exts.koreahana.frm.vo.KoreahanaFrmVO;

/**
 * @Class Name : KoreahanaFrmServiceImpl.java
 * @Description : 영농정착지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaFrmService")
public class KoreahanaFrmServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaFrmService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaFrmDao")
	private KoreahanaFrmDao koreahanaFrmDao;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaFrmKoreahanaFrmIdGnrService")		//IDGEN USE
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
	public List<KoreahanaFrmVO> selectKoreahanaFrmList(KoreahanaFrmVO searchVO) {
		List<KoreahanaFrmVO> list = (List<KoreahanaFrmVO>)koreahanaFrmDao.selectKoreahanaFrmList(searchVO);
//		if(list != null){
//			for(KoreahanaFrmVO result:list){
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
	public Integer selectKoreahanaFrmTot(KoreahanaFrmVO searchVO) {
		return koreahanaFrmDao.selectKoreahanaFrmTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaFrmVO selectKoreahanaFrm(KoreahanaFrmVO searchVO) {
		KoreahanaFrmVO result = koreahanaFrmDao.selectKoreahanaFrm(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaFrm(KoreahanaFrmVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getFrmSpfstSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getFrmSpfstSn());	//SEQUENCE USE

		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setFrmSpfstSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaFrmDao.insertKoreahanaFrm(searchVO);
			id = searchVO.getFrmSpfstSn();				//SEQUENCE USE
		}else{
			KoreahanaFrmVO result = selectKoreahanaFrm(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getFrmSpfstSn();
			
			koreahanaFrmDao.updateKoreahanaFrm(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaFrm(KoreahanaFrmVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaFrmVO result = selectKoreahanaFrm(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaFrmDao.deleteKoreahanaFrm(searchVO);
	}
	
	/**
	 * 삭제(선택삭제)
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteAllKoreahanaFrm(KoreahanaFrmVO searchVO) throws EgovBizException {
		if(searchVO.getFrmSpfstSnList() != null && searchVO.getFrmSpfstSnList().size() > 0) {
			for(String frmSpfstSn : searchVO.getFrmSpfstSnList()) {
				KoreahanaFrmVO deleteFrmVO = new KoreahanaFrmVO();
				String userId = getLoginID();
				//권한 체크
				deleteFrmVO.setFrmSpfstSn(frmSpfstSn);
				KoreahanaFrmVO result = selectKoreahanaFrm(deleteFrmVO);
				if(!isDeletable(result))throwBizException("com.error.noauth.delete");
						
				deleteFrmVO.setRgtrId(userId);
				deleteFrmVO.setMdfrId(userId);
				koreahanaFrmDao.deleteKoreahanaFrm(deleteFrmVO);
			}
		}
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
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaFrmVO data = (KoreahanaFrmVO)excelVO.getVo();

				try {
					data.setGenderCd(comCodeService.getCd(genderCdList, data.getGenderCd()));
					data.setNewYn("신규".equals(data.getNewYn())?"Y":"N");
					data.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaFrmDao.insertKoreahanaFrm(data);
					
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
	public List<EgovMap> selectKoreahanaFrmStatistic(KoreahanaFrmVO searchVO) {
		return koreahanaFrmDao.selectKoreahanaFrmStatistic(searchVO);
	}
	/**
	 * 통계 - 연도별
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFrmStatisticSprtYr(KoreahanaFrmVO searchVO) {
		return koreahanaFrmDao.selectKoreahanaFrmStatisticSprtYr(searchVO);
	}
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaFrmVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaFrmVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaFrmVO searchVO){
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
	private void validate(KoreahanaFrmVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
