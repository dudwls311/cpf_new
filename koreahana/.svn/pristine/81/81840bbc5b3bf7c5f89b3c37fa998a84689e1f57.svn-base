package exts.koreahana.lnb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.lnb.service.KoreahanaLnbUserService;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import exts.koreahana.spr.service.KoreahanaSprUserService;

/**
 * @Class Name : KoreahanaLnbServiceImpl.java
 * @Description : 학습지지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaLnbUserService")
public class KoreahanaLnbUserServiceImpl extends KoreahanaLnbServiceImpl implements KoreahanaLnbUserService {
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
	public boolean isViewable(KoreahanaLnbVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaLnbVO searchVO){
		//서류미비 || 임시저장일때 수정가능
		boolean isSprtPass = ( KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd()) || KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd()) );
		return (isSprtPass && NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID()));
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaLnbVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaLnb(KoreahanaLnbVO searchVO) throws EgovBizException {
		//권한 체크는 deleteKoreahanaSpr 에서 처리
		koreahanaSprUserService.deleteKoreahanaSpr(searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
