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
import exts.koreahana.fth.service.KoreahanaFthMtrService;
import exts.koreahana.fth.vo.KoreahanaFthMtrVO;

/**
 * @Class Name : KoreahanaFthMtrServiceImpl.java
 * @Description : 미래행복통장만기해지 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaFthMtrService")
public class KoreahanaFthMtrServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaFthMtrService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaFthMtrDao")
	private KoreahanaFthMtrDao koreahanaFthMtrDao;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaFthKoreahanaFthMtrIdGnrService")		//IDGEN USE
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
	public List<KoreahanaFthMtrVO> selectKoreahanaFthMtrList(KoreahanaFthMtrVO searchVO) {
		List<KoreahanaFthMtrVO> list = (List<KoreahanaFthMtrVO>)koreahanaFthMtrDao.selectKoreahanaFthMtrList(searchVO);
//		if(list != null){
//			for(KoreahanaFthMtrVO result:list){
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
	public Integer selectKoreahanaFthMtrTot(KoreahanaFthMtrVO searchVO) {
		return koreahanaFthMtrDao.selectKoreahanaFthMtrTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaFthMtrVO selectKoreahanaFthMtr(KoreahanaFthMtrVO searchVO) {
		KoreahanaFthMtrVO result = koreahanaFthMtrDao.selectKoreahanaFthMtr(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaFthMtr(KoreahanaFthMtrVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getFthpbbMtryCncltnSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getFthpbbMtryCncltnSn());	//SEQUENCE USE

		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setFthpbbMtryCncltnSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaFthMtrDao.insertKoreahanaFthMtr(searchVO);
			id = searchVO.getFthpbbMtryCncltnSn();				//SEQUENCE USE
		}else{
			KoreahanaFthMtrVO result = selectKoreahanaFthMtr(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getFthpbbMtryCncltnSn();
			
			koreahanaFthMtrDao.updateKoreahanaFthMtr(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaFthMtr(KoreahanaFthMtrVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaFthMtrVO result = selectKoreahanaFthMtr(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaFthMtrDao.deleteKoreahanaFthMtr(searchVO);
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
		List<ComCodeVO> usdusgCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.USDUSG_CD);
		List<ComCodeVO> ctpvCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.CTPV_CD);
		List<ComCodeVO> sggCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SGG_CD);
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaFthMtrVO data = (KoreahanaFthMtrVO)excelVO.getVo();

				try {
					data.setUsdusgCd(comCodeService.getCd(usdusgCdList, data.getUsdusgCd()));
					data.setCtpvCd(comCodeService.getCd(ctpvCdList, data.getCtpvCd()));
					data.setSggCd(comCodeService.getCd(sggCdList, data.getSggCd()));
					data.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaFthMtrDao.insertKoreahanaFthMtr(data);
					
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
	public List<EgovMap> selectKoreahanaFthMtrStatisticJoinYm(KoreahanaFthMtrVO searchVO){
		return koreahanaFthMtrDao.selectKoreahanaFthMtrStatisticJoinYm(searchVO);
	}

	/**
	 * 통계 - 만기해지사유별현황
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaFthMtrStatisticUsdusgCd(KoreahanaFthMtrVO searchVO){
		return koreahanaFthMtrDao.selectKoreahanaFthMtrStatisticUsdusgCd(searchVO);
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaFthMtrVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaFthMtrVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaFthMtrVO searchVO){
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
	private void validate(KoreahanaFthMtrVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
