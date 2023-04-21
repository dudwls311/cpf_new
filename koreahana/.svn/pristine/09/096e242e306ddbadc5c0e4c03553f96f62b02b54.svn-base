package exts.koreahana.adt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.koreahana.adt.service.KoreahanaAdtUserService;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.spr.service.KoreahanaSprUserService;

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
@Service("koreahanaAdtUserService")
public class KoreahanaAdtUserServiceImpl extends KoreahanaAdtServiceImpl implements KoreahanaAdtUserService {
	
	@Resource(name = "koreahanaSprUserService")
	private KoreahanaSprUserService koreahanaSprUserService;
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isViewable(KoreahanaAdtVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isModifiable(KoreahanaAdtVO searchVO){
		//서류미비 || 임시저장일때 수정가능
		boolean isSprtPass = ( KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd()) || KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd()) );
		return (isSprtPass && NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID()));
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	@Override
	public boolean isDeletable(KoreahanaAdtVO searchVO){
		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	@Override
	public void deleteKoreahanaAdt(KoreahanaAdtVO searchVO) throws EgovBizException {
		//권한 체크는 deleteKoreahanaSpr 에서 처리
		koreahanaSprUserService.deleteKoreahanaSpr(searchVO);
	}
}
