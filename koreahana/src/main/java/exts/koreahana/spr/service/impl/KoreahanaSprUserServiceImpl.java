package exts.koreahana.spr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.spr.service.KoreahanaSprUserService;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSprServiceImpl.java
 * @Description : 지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSprUserService")
public class KoreahanaSprUserServiceImpl extends KoreahanaSprServiceImpl implements KoreahanaSprUserService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	
	@Resource(name = "koreahanaSprDao")
	private KoreahanaSprDao koreahanaSprDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSprKoreahanaSprIdGnrService")		//IDGEN USE
    //private EgovIdGnrService egovIdGnrService;	//IDGEN USE
    
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSprVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSprVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSprVO searchVO){
		if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) return false;		//사용자는 임시저장시에만 삭제 가능
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpr(KoreahanaSprVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크는 각 지원하위 사업에서 처리함.
		KoreahanaSprVO result = selectKoreahanaSpr(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSprDao.deleteKoreahanaSpr(searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
