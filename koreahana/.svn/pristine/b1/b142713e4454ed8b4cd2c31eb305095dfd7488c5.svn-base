package exts.koreahana.sgn.service.impl;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.koreahana.sgn.service.KoreahanaSgnUserService;
import exts.koreahana.sgn.vo.KoreahanaSgnVO;

/**
 * @Class Name : KoreahanaSgnServiceImpl.java
 * @Description : 서명 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSgnUserService")
public class KoreahanaSgnUserServiceImpl extends KoreahanaSgnServiceImpl implements KoreahanaSgnUserService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isViewable(KoreahanaSgnVO searchVO){
		return (searchVO != null && NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID()));
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isModifiable(KoreahanaSgnVO searchVO){
		return (searchVO != null && NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID()));
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isDeletable(KoreahanaSgnVO searchVO){
		return (searchVO != null && NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID()));
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
