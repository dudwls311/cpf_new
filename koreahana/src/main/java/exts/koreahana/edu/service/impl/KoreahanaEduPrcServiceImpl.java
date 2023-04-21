package exts.koreahana.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.edu.service.KoreahanaEduPrcService;
import exts.koreahana.edu.vo.KoreahanaEduPrcVO;

/**
 * @Class Name : KoreahanaEduPrcServiceImpl.java
 * @Description : 교육지원금지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEduPrcService")
public class KoreahanaEduPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEduPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEduPrcDao")
	private KoreahanaEduPrcDao koreahanaEduPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEduKoreahanaEduPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEduPrcVO> selectKoreahanaEduPrcList(KoreahanaEduPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaEduPrcVO> list = (List<KoreahanaEduPrcVO>)koreahanaEduPrcDao.selectKoreahanaEduPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaEduPrcVO result:list){
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
	public Integer selectKoreahanaEduPrcTot(KoreahanaEduPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaEduPrcDao.selectKoreahanaEduPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEduPrcVO selectKoreahanaEduPrc(KoreahanaEduPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		KoreahanaEduPrcVO result = koreahanaEduPrcDao.selectKoreahanaEduPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEduPrc(KoreahanaEduPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		if(!isStreAuth())throwBizException("com.error.noauth.write");

		//기존데이터(지원정보에 따른 데이터이므로 무조건 존재해야함.) 
		KoreahanaEduPrcVO result = selectKoreahanaEduPrc(searchVO); 
		String id = NullUtil.nullString(result.getEduSprtPrcnMngSn());
		if("".equals(id)){			
			koreahanaEduPrcDao.insertKoreahanaEduPrc(searchVO);
			id = searchVO.getEduSprtPrcnMngSn();				//SEQUENCE USE
		}else{			
			koreahanaEduPrcDao.updateKoreahanaEduPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEduPrc(KoreahanaEduPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEduPrcVO result = selectKoreahanaEduPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaEduPrcDao.deleteKoreahanaEduPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEduPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEduPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEduPrcVO searchVO){
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
	private void validate(KoreahanaEduPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
