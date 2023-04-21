package exts.koreahana.spf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.spf.service.KoreahanaSpfQlfService;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;

/**
 * @Class Name : KoreahanaSpfQlfServiceImpl.java
 * @Description : 정착지원자격시험정보 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSpfQlfService")
public class KoreahanaSpfQlfServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSpfQlfService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSpfQlfDao")
	private KoreahanaSpfQlfDao koreahanaSpfQlfDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSpfKoreahanaSpfQlfIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSpfQlfVO> selectKoreahanaSpfQlfList(KoreahanaSpfQlfVO searchVO) {
		List<KoreahanaSpfQlfVO> list = (List<KoreahanaSpfQlfVO>)koreahanaSpfQlfDao.selectKoreahanaSpfQlfList(searchVO);
//		if(list != null){
//			for(KoreahanaSpfQlfVO result:list){
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
	public Integer selectKoreahanaSpfQlfTot(KoreahanaSpfQlfVO searchVO) {
		return koreahanaSpfQlfDao.selectKoreahanaSpfQlfTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfQlfVO selectKoreahanaSpfQlf(KoreahanaSpfQlfVO searchVO) {
		KoreahanaSpfQlfVO result = koreahanaSpfQlfDao.selectKoreahanaSpfQlf(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void mergeKoreahanaSpfQlf(KoreahanaSpfQlfVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		koreahanaSpfQlfDao.mergeKoreahanaSpfQlf(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSpfQlfVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSpfQlfVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSpfQlfVO searchVO){
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
	private void validate(KoreahanaSpfQlfVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
