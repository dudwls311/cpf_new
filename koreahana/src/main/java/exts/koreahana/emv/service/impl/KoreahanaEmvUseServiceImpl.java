package exts.koreahana.emv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComExcelValidationResultVO;
import exts.koreahana.emv.service.KoreahanaEmvUseService;
import exts.koreahana.emv.vo.KoreahanaEmvUseVO;

/**
 * @Class Name : KoreahanaEmvUseServiceImpl.java
 * @Description : 취업바우처카드사용정보 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmvUseService")
public class KoreahanaEmvUseServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmvUseService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmvUseDao")
	private KoreahanaEmvUseDao koreahanaEmvUseDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmvKoreahanaEmvUseIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmvUseVO> selectKoreahanaEmvUseList(KoreahanaEmvUseVO searchVO) {
		List<KoreahanaEmvUseVO> list = (List<KoreahanaEmvUseVO>)koreahanaEmvUseDao.selectKoreahanaEmvUseList(searchVO);
//		if(list != null){
//			for(KoreahanaEmvUseVO result:list){
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
	public Integer selectKoreahanaEmvUseTot(KoreahanaEmvUseVO searchVO) {
		return koreahanaEmvUseDao.selectKoreahanaEmvUseTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmvUseVO selectKoreahanaEmvUse(KoreahanaEmvUseVO searchVO) {
		KoreahanaEmvUseVO result = koreahanaEmvUseDao.selectKoreahanaEmvUse(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmvUse(KoreahanaEmvUseVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		String id = NullUtil.nullString(searchVO.getEmvucdUseInfoSn());
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setEmvucdUseInfoSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaEmvUseDao.insertKoreahanaEmvUse(searchVO);
			id = searchVO.getEmvucdUseInfoSn();				//SEQUENCE USE
		}else{
			KoreahanaEmvUseVO result = selectKoreahanaEmvUse(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getEmvucdUseInfoSn();
			
			koreahanaEmvUseDao.updateKoreahanaEmvUse(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmvUse(KoreahanaEmvUseVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaEmvUseVO result = selectKoreahanaEmvUse(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaEmvUseDao.deleteKoreahanaEmvUse(searchVO);
	}

	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmvUseVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmvUseVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmvUseVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}

	/**
	 * 일괄 추가 / 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws Exception
	 */
	public void excelUpload(List<ComExcelValidationResultVO> searchList) throws EgovBizException {

		if(!isStreAuth())throwBizException("com.error.noauth.write");
		String mbrId = getLoginID();
		
		if(searchList != null) {
			for(ComExcelValidationResultVO excelVO:searchList) {
				if(!excelVO.isSuccess())continue;
				
				KoreahanaEmvUseVO data = (KoreahanaEmvUseVO)excelVO.getVo();

				try {
					data.setRgtrId(mbrId);
					data.setMdfrId(mbrId);
					koreahanaEmvUseDao.insertKoreahanaEmvUse(data);
					
				}catch(DataAccessException e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("flnm", "com.error.none", getMessage("com.error.none"));
				}catch(Exception e) {
					log.error(e.getMessage());
					excelVO.setSuccess(false);
					excelVO.addError("flnm", "com.error.none", getMessage("com.error.none"));
				}
				
			}
		}
		
	}
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	/**
	 * DB에 입력하기 위한 데이터 처리.
	 * @param searchVO
	 * @throws EgovBizException
	 */
	private void validate(KoreahanaEmvUseVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
