package exts.koreahana.emv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.emv.service.KoreahanaEmvPrcTkcService;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;

/**
 * @Class Name : KoreahanaEmvPrcTkcServiceImpl.java
 * @Description : 취업바우처카드지원현황관리수강정보 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.28
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmvPrcTkcService")
public class KoreahanaEmvPrcTkcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmvPrcTkcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmvPrcTkcDao")
	private KoreahanaEmvPrcTkcDao koreahanaEmvPrcTkcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmvKoreahanaEmvPrcTkcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmvPrcTkcVO> selectKoreahanaEmvPrcTkcList(KoreahanaEmvPrcTkcVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaEmvPrcTkcVO> list = (List<KoreahanaEmvPrcTkcVO>)koreahanaEmvPrcTkcDao.selectKoreahanaEmvPrcTkcList(searchVO);
//		if(list != null){
//			for(KoreahanaEmvPrcTkcVO result:list){
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
	public Integer selectKoreahanaEmvPrcTkcTot(KoreahanaEmvPrcTkcVO searchVO) {
		return koreahanaEmvPrcTkcDao.selectKoreahanaEmvPrcTkcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvPrcTkcVO selectKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) {
		KoreahanaEmvPrcTkcVO result = koreahanaEmvPrcTkcDao.selectKoreahanaEmvPrcTkc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		String id = NullUtil.nullString(searchVO.getEmvucdSprtPrcnMngTkclsSn());
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setEmvucdSprtPrcnMngTkclsSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaEmvPrcTkcDao.insertKoreahanaEmvPrcTkc(searchVO);
			id = searchVO.getEmvucdSprtPrcnMngTkclsSn();				//SEQUENCE USE
		}else{
			KoreahanaEmvPrcTkcVO result = selectKoreahanaEmvPrcTkc(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getEmvucdSprtPrcnMngTkclsSn();
			
			koreahanaEmvPrcTkcDao.updateKoreahanaEmvPrcTkc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmvPrcTkc(KoreahanaEmvPrcTkcVO searchVO) throws EgovBizException {
//		String userId = getLoginID();
		//권한 체크
//		KoreahanaEmvPrcTkcVO result = selectKoreahanaEmvPrcTkc(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
//				
//		searchVO.setRgtrId(userId);
//		searchVO.setMdfrId(userId);
		koreahanaEmvPrcTkcDao.deleteKoreahanaEmvPrcTkc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmvPrcTkcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmvPrcTkcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmvPrcTkcVO searchVO){
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
	private void validate(KoreahanaEmvPrcTkcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
