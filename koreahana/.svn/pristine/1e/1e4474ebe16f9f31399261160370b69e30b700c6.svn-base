package exts.koreahana.vdo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.vdo.service.KoreahanaVdoPrcService;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcExcelVO;
import exts.koreahana.vdo.vo.KoreahanaVdoPrcVO;

/**
 * @Class Name : KoreahanaVdoPrcServiceImpl.java
 * @Description : 화상영어교육현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaVdoPrcService")
public class KoreahanaVdoPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaVdoPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaVdoPrcDao")
	private KoreahanaVdoPrcDao koreahanaVdoPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaVdoKoreahanaVdoPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaVdoPrcVO> selectKoreahanaVdoPrcList(KoreahanaVdoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaVdoPrcVO> list = (List<KoreahanaVdoPrcVO>)koreahanaVdoPrcDao.selectKoreahanaVdoPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaVdoPrcVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 리스트(엑셀)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaVdoPrcExcelVO> selectKoreahanaVdoPrcListExcel(KoreahanaVdoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaVdoPrcExcelVO> list = (List<KoreahanaVdoPrcExcelVO>)koreahanaVdoPrcDao.selectKoreahanaVdoPrcListExcel(searchVO);
//		if(list != null){
//			for(KoreahanaVdoPrcVO result:list){
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
	public Integer selectKoreahanaVdoPrcTot(KoreahanaVdoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaVdoPrcDao.selectKoreahanaVdoPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaVdoPrcVO selectKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		KoreahanaVdoPrcVO result = koreahanaVdoPrcDao.selectKoreahanaVdoPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		if(!isStreAuth())throwBizException("com.error.noauth.write");
		
		//기존데이터(지원정보에 따른 데이터이므로 무조건 존재해야함.) 
		KoreahanaVdoPrcVO result = selectKoreahanaVdoPrc(searchVO);
		String id = NullUtil.nullString(result.getVdoengEduPrcnMngSn());
		
		if("".equals(id)){
			koreahanaVdoPrcDao.insertKoreahanaVdoPrc(searchVO);
			id = searchVO.getVdoengEduPrcnMngSn();				//SEQUENCE USE
		}else{
			koreahanaVdoPrcDao.updateKoreahanaVdoPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaVdoPrc(KoreahanaVdoPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaVdoPrcVO result = selectKoreahanaVdoPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaVdoPrcDao.deleteKoreahanaVdoPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaVdoPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaVdoPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaVdoPrcVO searchVO){
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
	private void validate(KoreahanaVdoPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
