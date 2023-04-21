package exts.koreahana.sho.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComAtchFileService;
import exts.com.service.ComCodeService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.sgn.service.KoreahanaSgnService;
import exts.koreahana.sho.service.KoreahanaShoService;
import exts.koreahana.sho.vo.KoreahanaShoVO;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.spr.service.KoreahanaSprService;

/**
 * @Class Name : KoreahanaShoServiceImpl.java
 * @Description : 장학금지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.17
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaShoService")
public class KoreahanaShoServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaShoService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaShoDao")
	private KoreahanaShoDao koreahanaShoDao;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSgnService")
	private KoreahanaSgnService koreahanaSgnService;

	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaShoVO> selectKoreahanaShoList(KoreahanaShoVO searchVO) {
		List<KoreahanaShoVO> list = (List<KoreahanaShoVO>)koreahanaShoDao.selectKoreahanaShoList(searchVO);
//		if(list != null){
//			for(KoreahanaShoVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 리스트 엑셀
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaShoVO> selectKoreahanaShoListExcel(KoreahanaShoVO searchVO) {
		List<KoreahanaShoVO> list = (List<KoreahanaShoVO>)koreahanaShoDao.selectKoreahanaShoListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaShoVO result:list){
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
	public Integer selectKoreahanaShoTot(KoreahanaShoVO searchVO) {
		return koreahanaShoDao.selectKoreahanaShoTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaShoVO selectKoreahanaSho(KoreahanaShoVO searchVO) {
		KoreahanaShoVO result = koreahanaShoDao.selectKoreahanaSho(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSho(KoreahanaShoVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		//권한체크
		if("".equals(searchVO.getSprtSn())){
			if(!isStreAuth())throwBizException("com.error.noauth.write");
		}else{
			KoreahanaShoVO result = selectKoreahanaSho(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
		}
		
		
		///// 지원신청 공통처리 ///////////
		
		//지원신청 정보 처리
		koreahanaSprService.writeKoreahanaSpr(searchVO);
		
		//임시저장이 아닐때만 제출서류매핑첨부파일 저장
//		if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())){
			//제출서류 처리
			//임시저장을 했을때 기존에는 SPRT_SN 값이 없었지만 TB_SPRT 테이블에 임시저장 데이터를 저장하면서 SPRT_SN은 임시저장을 해도 생기면서 이와같이 처리
			koreahanaSprService.getParamToSmbMpnProc(searchVO, request, false);			//파라미터로 넘어온 제출서류 처리
//		}
		
		///// 지원신청 공통처리  종료 ///////////	
		
		//임시저장이 아닐때만 지원하위 저장
		if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())){
			//장학금 정보처리
			koreahanaShoDao.deleteKoreahanaSho(searchVO);
			koreahanaShoDao.insertKoreahanaSho(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSho(KoreahanaShoVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaShoVO result = selectKoreahanaSho(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
		
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		//koreahanaShoDao.deleteKoreahanaSho(searchVO);
		koreahanaSprService.deleteKoreahanaSpr(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaShoVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaShoVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaShoVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
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
		List<ComCodeVO> sprtSttsCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.SPRT_STTS_CD);
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaShoVO data = (KoreahanaShoVO)excelVO.getVo();

				try {
					if(!NullUtil.nullString(data.getSprtSttsCd()).equals("")) {
						String sprtSttsCd = comCodeService.getCd(sprtSttsCdList, data.getSprtSttsCd());
						if("".equals(sprtSttsCd))throwBizException("com.error.invalid.codeNm", new String[] {getMessage("exts.item.koreahana.spr.sprtSttsCd")});
						data.setSprtSttsCd(sprtSttsCd);
					}
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					data.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.SHO.getCode());//카테고리확인을 위해 넘겨줌
					List<String> errorMsg = koreahanaSprService.updateKoreahanaSprStts(data, new String[] {data.getSprtSn()});
					if(errorMsg != null && !"".equals(errorMsg.get(0))) {
						excelVO.setSuccess(false);
						excelVO.addError("sprtSn", "com.error.none", errorMsg.get(0));
					}
				}catch(EgovBizException e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("sprtSn", e.getMessageKey(), e.getMessage());
				}
				
			}
		}
		
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
