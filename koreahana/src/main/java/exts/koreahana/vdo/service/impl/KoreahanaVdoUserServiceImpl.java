package exts.koreahana.vdo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.spr.service.KoreahanaSprUserService;
import exts.koreahana.vdo.service.KoreahanaVdoUserService;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

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
@Service("koreahanaVdoUserService")
public class KoreahanaVdoUserServiceImpl extends KoreahanaVdoServiceImpl implements KoreahanaVdoUserService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSprUserService")
	private KoreahanaSprUserService koreahanaSprUserService;
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

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
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaVdo(KoreahanaVdoVO searchVO) throws EgovBizException {
		//권한 체크는 deleteKoreahanaSpr 에서 처리
		koreahanaSprUserService.deleteKoreahanaSpr(searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
