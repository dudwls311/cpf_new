package exts.koreahana.emv.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.emv.service.KoreahanaEmvService;
import exts.koreahana.emv.vo.KoreahanaEmvVO;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.spr.service.KoreahanaSprService;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

/**
 * @Class Name : KoreahanaEmvServiceImpl.java
 * @Description : 취업바우처카드 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmvService")
public class KoreahanaEmvServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmvService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmvDao")
	private KoreahanaEmvDao koreahanaEmvDao;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 리스트
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmvVO> selectKoreahanaEmvList(KoreahanaEmvVO searchVO) {
		List<KoreahanaEmvVO> list = (List<KoreahanaEmvVO>)koreahanaEmvDao.selectKoreahanaEmvList(searchVO);
//		if(list != null){
//			for(KoreahanaEmvVO result:list){
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
	public Integer selectKoreahanaEmvTot(KoreahanaEmvVO searchVO) {
		return koreahanaEmvDao.selectKoreahanaEmvTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvVO selectKoreahanaEmv(KoreahanaEmvVO searchVO) {
		KoreahanaEmvVO result = koreahanaEmvDao.selectKoreahanaEmv(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmv(KoreahanaEmvVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);
		
		//권한체크
		if("".equals(searchVO.getSprtSn())){
			
			if(!isStreAuth())throwBizException("com.error.noauth.write");
		}else{
			KoreahanaEmvVO result = selectKoreahanaEmv(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			searchVO.setSprtSttsCd(result.getSprtSttsCd());		//서류미비일 경우 저장 후 신청완료로 변경해주기 위해 값 설정
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
			koreahanaEmvDao.deleteKoreahanaEmv(searchVO);
			koreahanaEmvDao.insertKoreahanaEmv(searchVO);
		}
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmv(KoreahanaEmvVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEmvVO result = selectKoreahanaEmv(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		//koreahanaEmvDao.deleteKoreahanaEmv(searchVO);
		koreahanaSprService.deleteKoreahanaSpr(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmvVO searchVO){
		if(searchVO == null)return false;
		if(!isRedngAuth())return false;
		if(!isCenterStaff()) return true;
		if(NullUtil.nullString(searchVO.getHanactCd()).equals(getLoginVO().getOrgId())) return true;
		return false;
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmvVO searchVO){
		if(searchVO == null)return false;
		if(!isStreAuth())return false;
		if(!isCenterStaff()) return true;
		if(!KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd())) return false;
		if(NullUtil.nullString(searchVO.getHanactCd()).equals(getLoginVO().getOrgId())) return true;
		return false;
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmvVO searchVO){
		if(searchVO == null)return false;
		if(!isCenterStaff()) return true;
		if(!KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd())) return false;
		if(NullUtil.nullString(searchVO.getHanactCd()).equals(getLoginVO().getOrgId())) return true;
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
	private void validate(KoreahanaEmvVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
