package exts.koreahana.emv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.emv.service.KoreahanaEmvPrcService;
import exts.koreahana.emv.service.KoreahanaEmvPrcTkcService;
import exts.koreahana.emv.vo.KoreahanaEmvPrcTkcVO;
import exts.koreahana.emv.vo.KoreahanaEmvPrcVO;

/**
 * @Class Name : KoreahanaEmvPrcServiceImpl.java
 * @Description : 취업바우처카드지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmvPrcService")
public class KoreahanaEmvPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmvPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmvPrcDao")
	private KoreahanaEmvPrcDao koreahanaEmvPrcDao;
	
	@Resource(name = "koreahanaEmvPrcTkcService")
	private KoreahanaEmvPrcTkcService koreahanaEmvPrcTkcService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmvKoreahanaEmvPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmvPrcVO> selectKoreahanaEmvPrcList(KoreahanaEmvPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		List<KoreahanaEmvPrcVO> list = (List<KoreahanaEmvPrcVO>)koreahanaEmvPrcDao.selectKoreahanaEmvPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaEmvPrcVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 리스트 Excel
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaEmvPrcVO> selectKoreahanaEmvPrcListExcel(KoreahanaEmvPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		List<KoreahanaEmvPrcVO> list = (List<KoreahanaEmvPrcVO>)koreahanaEmvPrcDao.selectKoreahanaEmvPrcListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaEmvPrcVO result:list){
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
	public Integer selectKoreahanaEmvPrcTot(KoreahanaEmvPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		return koreahanaEmvPrcDao.selectKoreahanaEmvPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvPrcVO selectKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());
		KoreahanaEmvPrcVO result = koreahanaEmvPrcDao.selectKoreahanaEmvPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		validate(searchVO);
		KoreahanaEmvPrcVO result = selectKoreahanaEmvPrc(searchVO);
		String id = NullUtil.nullString(result.getEmvucdSprtPrcnMngSn());
		
		if("".equals(id)){
			
			koreahanaEmvPrcDao.insertKoreahanaEmvPrc(searchVO);
			id = searchVO.getEmvucdSprtPrcnMngSn();				//SEQUENCE USE
		}else{
			koreahanaEmvPrcDao.updateKoreahanaEmvPrc(searchVO);
		}

		//수강정보 삭제 후 저장
		KoreahanaEmvPrcTkcVO emvPrcTkcDeleteVO = new KoreahanaEmvPrcTkcVO();
		emvPrcTkcDeleteVO.setSprtSn(searchVO.getSprtSn());
		koreahanaEmvPrcTkcService.deleteKoreahanaEmvPrcTkc(emvPrcTkcDeleteVO);
		
		if(searchVO.getEmvPrcTkcList() != null && searchVO.getEmvPrcTkcList().size() > 0) {
			for(KoreahanaEmvPrcTkcVO emvPrcTkcVO : searchVO.getEmvPrcTkcList()) {
				emvPrcTkcVO.setSprtSn(searchVO.getSprtSn());
				koreahanaEmvPrcTkcService.writeKoreahanaEmvPrcTkc(emvPrcTkcVO);
			}
		}
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmvPrc(KoreahanaEmvPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEmvPrcVO result = selectKoreahanaEmvPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaEmvPrcDao.deleteKoreahanaEmvPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmvPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmvPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmvPrcVO searchVO){
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
	private void validate(KoreahanaEmvPrcVO searchVO){
		
	}
	
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
