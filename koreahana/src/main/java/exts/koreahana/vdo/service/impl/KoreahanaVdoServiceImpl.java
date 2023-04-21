package exts.koreahana.vdo.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComAtchFileService;
import exts.com.service.ComCodeService;
import exts.com.service.ComMbrService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComExcelValidationResultVO;
import exts.com.vo.ComMbrVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.sgn.service.KoreahanaSgnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.vdo.service.KoreahanaVdoService;
import exts.koreahana.vdo.vo.KoreahanaVdoExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE
import jnit.com.tag.JnitTag;

/**
 * @Class Name : KoreahanaVdoServiceImpl.java
 * @Description : 화상영어교육지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaVdoService")
public class KoreahanaVdoServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaVdoService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaVdoDao")
	private KoreahanaVdoDao koreahanaVdoDao;
	
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
	public List<KoreahanaVdoVO> selectKoreahanaVdoList(KoreahanaVdoVO searchVO) {
		List<KoreahanaVdoVO> list = (List<KoreahanaVdoVO>)koreahanaVdoDao.selectKoreahanaVdoList(searchVO);
//		if(list != null){
//			for(KoreahanaVdoVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaVdoExcelVO> selectKoreahanaVdoListExcel(KoreahanaVdoVO searchVO) {
		List<KoreahanaVdoExcelVO> list = (List<KoreahanaVdoExcelVO>)koreahanaVdoDao.selectKoreahanaVdoListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaVdoVO result:list){
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
	public Integer selectKoreahanaVdoTot(KoreahanaVdoVO searchVO) {
		return koreahanaVdoDao.selectKoreahanaVdoTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaVdoVO selectKoreahanaVdo(KoreahanaVdoVO searchVO) {
		KoreahanaVdoVO result = koreahanaVdoDao.selectKoreahanaVdo(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaVdo(KoreahanaVdoVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);
		
		//권한체크
		if("".equals(searchVO.getSprtSn())){
			if(!isStreAuth())throwBizException("com.error.noauth.write");
		}else{
			KoreahanaVdoVO result = selectKoreahanaVdo(searchVO);
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
			//가산금 정보처리
			koreahanaVdoDao.deleteKoreahanaVdo(searchVO);
			koreahanaVdoDao.insertKoreahanaVdo(searchVO);
		}
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaVdo(KoreahanaVdoVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaVdoVO result = selectKoreahanaVdo(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		//koreahanaVdoDao.deleteKoreahanaVdo(searchVO);
		koreahanaSprService.deleteKoreahanaSpr(searchVO);
	}

	/**
	 * 보호자 정보 설정
	 * @param searchVO
	 * @throws EgovBizException
	 */
	public void setSprtPrtcrInfoBySession(KoreahanaVdoVO searchVO) throws EgovBizException {
		//최초 신청시 회원추가정보에서 셋팅
		ComMbrVO comMbrVO = (ComMbrVO)SessionUtil.getAttribute(ComMbrService.SESSION_ADT_VO);
		if(comMbrVO == null) throwBizException("exts.item.koreahana.spr.notExistMbrAdtifm");
		searchVO.setPrtcrFlnm(getLoginVO().getMbrNm());											//성명
		searchVO.setPrtcrGenderCd(comMbrVO.getGenderCd());										//성별
		searchVO.setPrtcrBrdtYmd(JnitTag.convertDateSplitString(comMbrVO.getBrdtYmd(), "-"));	//생년월일
		searchVO.setPrtcrMbphno(comMbrVO.getMbphno());											//휴대폰번호
		searchVO.setPrtcrZip(comMbrVO.getZip());						//우편번호
		searchVO.setPrtcrAddr(comMbrVO.getAddr());						//주소
		searchVO.setPrtcrDaddr(comMbrVO.getDaddr());		
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaVdoVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaVdoVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaVdoVO searchVO){
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
				
				KoreahanaVdoVO data = (KoreahanaVdoVO)excelVO.getVo();

				try {
					if(!NullUtil.nullString(data.getSprtSttsCd()).equals("")) {
						String sprtSttsCd = comCodeService.getCd(sprtSttsCdList, data.getSprtSttsCd());
						if("".equals(sprtSttsCd))throwBizException("com.error.invalid.codeNm", new String[] {getMessage("exts.item.koreahana.spr.sprtSttsCd")});
						data.setSprtSttsCd(sprtSttsCd);
					}
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					data.setPbancrcCtgryFrstCd(KoreahanaEnumCtgryFrstCd.VDO.getCode());//카테고리확인을 위해 넘겨줌
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
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaVdoVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
