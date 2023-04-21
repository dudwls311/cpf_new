package exts.koreahana.spf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.spf.service.KoreahanaSpfPrcService;
import exts.koreahana.spf.vo.KoreahanaSpfPrcExcelVO;
import exts.koreahana.spf.vo.KoreahanaSpfPrcVO;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

/**
 * @Class Name : KoreahanaSpfPrcServiceImpl.java
 * @Description : 정착지원현황관리 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSpfPrcService")
public class KoreahanaSpfPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSpfPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSpfPrcDao")
	private KoreahanaSpfPrcDao koreahanaSpfPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSpfKoreahanaSpfPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSpfPrcVO> selectKoreahanaSpfPrcList(KoreahanaSpfPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		List<KoreahanaSpfPrcVO> list = (List<KoreahanaSpfPrcVO>)koreahanaSpfPrcDao.selectKoreahanaSpfPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaSpfPrcVO result:list){
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
	public List<KoreahanaSpfPrcExcelVO> selectKoreahanaSpfPrcListExcel(KoreahanaSpfPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaSpfPrcDao.selectKoreahanaSpfPrcListExcel(searchVO);
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaSpfPrcTot(KoreahanaSpfPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		return koreahanaSpfPrcDao.selectKoreahanaSpfPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSpfPrcVO selectKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) {
		searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.SEL.getCode());//선정
		KoreahanaSpfPrcVO result = koreahanaSpfPrcDao.selectKoreahanaSpfPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		if(!isStreAuth())throwBizException("com.error.noauth.write");
		
		//기존데이터(지원정보에 따른 데이터이므로 무조건 존재해야함.) 
		KoreahanaSpfPrcVO result = selectKoreahanaSpfPrc(searchVO);
		String id = NullUtil.nullString(result.getSpfstPrcnMngSn());
		
		if("".equals(id)){
			koreahanaSpfPrcDao.insertKoreahanaSpfPrc(searchVO);
			id = searchVO.getSpfstPrcnMngSn();				//SEQUENCE USE
		}else{
			koreahanaSpfPrcDao.updateKoreahanaSpfPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpfPrc(KoreahanaSpfPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaSpfPrcVO result = selectKoreahanaSpfPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSpfPrcDao.deleteKoreahanaSpfPrc(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSpfPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSpfPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSpfPrcVO searchVO){
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
	private void validate(KoreahanaSpfPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
