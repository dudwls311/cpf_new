package exts.koreahana.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.emp.service.KoreahanaEmpPrcService;
import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;

/**
 * @Class Name : KoreahanaEmpPrcServiceImpl.java
 * @Description : 취업연계직업훈련지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmpPrcService")
public class KoreahanaEmpPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmpPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmpPrcDao")
	private KoreahanaEmpPrcDao koreahanaEmpPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmpKoreahanaEmpPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmpPrcVO> selectKoreahanaEmpPrcList(KoreahanaEmpPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		List<KoreahanaEmpPrcVO> list = (List<KoreahanaEmpPrcVO>)koreahanaEmpPrcDao.selectKoreahanaEmpPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaEmpPrcVO result:list){
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
	public Integer selectKoreahanaEmpPrcTot(KoreahanaEmpPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		return koreahanaEmpPrcDao.selectKoreahanaEmpPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmpPrcVO selectKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		KoreahanaEmpPrcVO result = koreahanaEmpPrcDao.selectKoreahanaEmpPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		if(!isStreAuth())throwBizException("com.error.noauth.write");

		KoreahanaEmpPrcVO result = selectKoreahanaEmpPrc(searchVO);
		validate(searchVO);
		String id = NullUtil.nullString(result.getEmpcnnVoctrnPcrnMngSn());
		
		if("".equals(id)){
			koreahanaEmpPrcDao.insertKoreahanaEmpPrc(searchVO);
			id = searchVO.getEmpcnnVoctrnPcrnMngSn();				//SEQUENCE USE
		}else{
			koreahanaEmpPrcDao.updateKoreahanaEmpPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmpPrc(KoreahanaEmpPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEmpPrcVO result = selectKoreahanaEmpPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaEmpPrcDao.deleteKoreahanaEmpPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmpPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmpPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmpPrcVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}
	
	/**
	 * 통계
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<EgovMap> selectKoreahanaEmpPrcStatistic(KoreahanaEmpPrcVO searchVO) {
		return koreahanaEmpPrcDao.selectKoreahanaEmpPrcStatistic(searchVO);
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaEmpPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
