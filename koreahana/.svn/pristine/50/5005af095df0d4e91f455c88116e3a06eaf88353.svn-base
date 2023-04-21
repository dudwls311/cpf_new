package exts.koreahana.doc.service.impl;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import exts.koreahana.doc.service.KoreahanaDocService;
import exts.koreahana.doc.vo.KoreahanaDocVO;

/**
 * @Class Name : KoreahanaDocServiceImpl.java
 * @Description : 문서함 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaDocUserService")
public class KoreahanaDocUserServiceImpl extends KoreahanaDocServiceImpl implements KoreahanaDocService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isViewable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isModifiable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isDeletable(KoreahanaDocVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
