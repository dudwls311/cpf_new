package exts.koreahana.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE
import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.adt.service.KoreahanaAdtFamService;
import exts.koreahana.adt.service.KoreahanaAdtService;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.sgn.service.KoreahanaSgnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.spr.service.KoreahanaSprService;

/**
 * @Class Name : KoreahanaAdtServiceImpl.java
 * @Description : 가산금지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaAdtService")
public class KoreahanaAdtServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaAdtService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaAdtDao")
	private KoreahanaAdtDao koreahanaAdtDao;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "koreahanaAdtFamService")
	private KoreahanaAdtFamService koreahanaAdtFamService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSgnService")
	private KoreahanaSgnService koreahanaSgnService;

	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaAdtKoreahanaAdtIdGnrService")		//IDGEN USE
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
	public List<KoreahanaAdtVO> selectKoreahanaAdtList(KoreahanaAdtVO searchVO) {
		List<KoreahanaAdtVO> list = (List<KoreahanaAdtVO>)koreahanaAdtDao.selectKoreahanaAdtList(searchVO);
//		if(list != null){
//			for(KoreahanaAdtVO result:list){
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
	public List<KoreahanaAdtVO> selectKoreahanaAdtListExcel(KoreahanaAdtVO searchVO) {
		return koreahanaAdtDao.selectKoreahanaAdtListExcel(searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaAdtTot(KoreahanaAdtVO searchVO) {
		return koreahanaAdtDao.selectKoreahanaAdtTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtVO selectKoreahanaAdt(KoreahanaAdtVO searchVO) {
		KoreahanaAdtVO result = koreahanaAdtDao.selectKoreahanaAdt(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaAdt(KoreahanaAdtVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);
		
		//권한체크
		if("".equals(searchVO.getSprtSn())){
			if(!isStreAuth())throwBizException("com.error.noauth.write");
		}else{
			KoreahanaAdtVO result = selectKoreahanaAdt(searchVO);
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
			koreahanaAdtDao.deleteKoreahanaAdt(searchVO);
			koreahanaAdtDao.insertKoreahanaAdt(searchVO);
			
			KoreahanaAdtFamVO adtFamDeleteVO = new KoreahanaAdtFamVO();
			adtFamDeleteVO.setSprtSn(searchVO.getSprtSn());
			koreahanaAdtFamService.deleteKoreahanaAdtFam(adtFamDeleteVO);
			//가산금지원신청자관계 추가
			if(searchVO.getAdtFamList() != null) {
				for(KoreahanaAdtFamVO adtFamVO : searchVO.getAdtFamList()) {
					adtFamVO.setSprtSn(searchVO.getSprtSn());
					koreahanaAdtFamService.writeKoreahanaAdtFam(adtFamVO);
				}
			}
		}
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdt(KoreahanaAdtVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaAdtVO result = selectKoreahanaAdt(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		//koreahanaAdtDao.deleteKoreahanaAdt(searchVO);
		koreahanaSprService.deleteKoreahanaSpr(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaAdtVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaAdtVO searchVO){
		if(searchVO == null)return false;

		return isStreAuth();
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaAdtVO searchVO){
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
	private void validate(KoreahanaAdtVO searchVO) throws EgovBizException{
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
