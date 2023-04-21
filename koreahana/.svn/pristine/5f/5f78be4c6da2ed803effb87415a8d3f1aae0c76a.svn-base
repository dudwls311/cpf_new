package exts.koreahana.sho.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.sho.service.KoreahanaShoPrcService;
import exts.koreahana.sho.vo.KoreahanaShoPrcVO;
import exts.koreahana.spr.service.KoreahanaSprService;

/**
 * @Class Name : KoreahanaShoPrcServiceImpl.java
 * @Description : 장학금지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaShoPrcService")
public class KoreahanaShoPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaShoPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaShoPrcDao")
	private KoreahanaShoPrcDao koreahanaShoPrcDao;
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	
	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaShoKoreahanaShoPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaShoPrcVO> selectKoreahanaShoPrcList(KoreahanaShoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaShoPrcVO> list = (List<KoreahanaShoPrcVO>)koreahanaShoPrcDao.selectKoreahanaShoPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaShoPrcVO result:list){
//				
//			}
//		}
		return list;
	}
	
	/**
	 * 엑셀 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaShoPrcVO> selectKoreahanaShoPrcListExcel(KoreahanaShoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaShoPrcVO> list = (List<KoreahanaShoPrcVO>)koreahanaShoPrcDao.selectKoreahanaShoPrcListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaShoPrcVO result:list){
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
	public Integer selectKoreahanaShoPrcTot(KoreahanaShoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaShoPrcDao.selectKoreahanaShoPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaShoPrcVO selectKoreahanaShoPrc(KoreahanaShoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		KoreahanaShoPrcVO result = koreahanaShoPrcDao.selectKoreahanaShoPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaShoPrc(KoreahanaShoPrcVO searchVO) throws EgovBizException {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		if(!isStreAuth())throwBizException("com.error.noauth.write");
		

		//기존데이터(지원정보에 따른 데이터이므로 무조건 존재해야함.) 
		KoreahanaShoPrcVO result = selectKoreahanaShoPrc(searchVO);
		String id = NullUtil.nullString(result.getSholSprtPrcnMngSn());
		
		if("".equals(id)){			
			koreahanaShoPrcDao.insertKoreahanaShoPrc(searchVO);
			id = searchVO.getSholSprtPrcnMngSn();				//SEQUENCE USE
		}else{
			koreahanaShoPrcDao.updateKoreahanaShoPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaShoPrc(KoreahanaShoPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaShoPrcVO result = selectKoreahanaShoPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaShoPrcDao.deleteKoreahanaShoPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaShoPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaShoPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaShoPrcVO searchVO){
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
	public List<EgovMap> selectKoreahanaShoPrcListStatistic(EgovMap searchVO){
		List<EgovMap> list = koreahanaShoPrcDao.selectKoreahanaShoPrcListStatistic(searchVO);
//		if(list != null){
//			for(KoreahanaShoPrcVO result:list){
//				
//			}
//		}
		return list;
	}
	
	/**
	 * 승인결과 일괄 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws Exception
	 */
	public void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException {

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		String mbrId = getLoginID();
		//코드리스트
		List<ComCodeVO> slctnMthdCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SLCTN_MTHD_CD);	//선발방법
		List<ComCodeVO> slctnMmtCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SLCTN_MMT_CD);		//선발시기
		List<ComCodeVO> fncrscCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.FNCRSC_CD);			//재원
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaShoPrcVO data = (KoreahanaShoPrcVO)excelVO.getVo();

				try {
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					data.setSlctnMthdCd(getCd(slctnMthdCdList, data.getSlctnMthdCd()));
					data.setSlctnMmtCd(getCd(slctnMmtCdList, data.getSlctnMmtCd()));
					data.setFncrscCd(getCd(fncrscCdList, data.getFncrscCd()));
					
					writeKoreahanaShoPrc(data);
					
				}catch(EgovBizException e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("sholSprtPrcnMngSn", e.getMessageKey(), e.getMessage());
				}
				
			}
		}
		
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaShoPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
