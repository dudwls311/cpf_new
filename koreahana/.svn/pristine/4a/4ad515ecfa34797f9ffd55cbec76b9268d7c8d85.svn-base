package exts.koreahana.adt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.adt.service.KoreahanaAdtFamService;
import exts.koreahana.adt.vo.KoreahanaAdtFamVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE

/**
 * @Class Name : KoreahanaAdtFamServiceImpl.java
 * @Description : 가산금지원가족관계 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.09.05
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaAdtFamService")
public class KoreahanaAdtFamServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaAdtFamService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaAdtFamDao")
	private KoreahanaAdtFamDao koreahanaAdtFamDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaAdtKoreahanaAdtFamIdGnrService")		//IDGEN USE
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
	public List<KoreahanaAdtFamVO> selectKoreahanaAdtFamList(KoreahanaAdtFamVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaAdtFamVO> list = (List<KoreahanaAdtFamVO>)koreahanaAdtFamDao.selectKoreahanaAdtFamList(searchVO);
//		if(list != null){
//			for(KoreahanaAdtFamVO result:list){
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
	public Integer selectKoreahanaAdtFamTot(KoreahanaAdtFamVO searchVO) {
		return koreahanaAdtFamDao.selectKoreahanaAdtFamTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaAdtFamVO selectKoreahanaAdtFam(KoreahanaAdtFamVO searchVO) {
		KoreahanaAdtFamVO result = koreahanaAdtFamDao.selectKoreahanaAdtFam(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaAdtFam(KoreahanaAdtFamVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getFamRelSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getFamRelSn());	//SEQUENCE USE
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setFamRelSn(id);				//IDGEN USE
			koreahanaAdtFamDao.insertKoreahanaAdtFam(searchVO);
			id = searchVO.getFamRelSn();				//SEQUENCE USE
		}else{
			KoreahanaAdtFamVO result = selectKoreahanaAdtFam(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getFamRelSn();
			
			koreahanaAdtFamDao.updateKoreahanaAdtFam(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaAdtFam(KoreahanaAdtFamVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		//KoreahanaAdtFamVO result = selectKoreahanaAdtFam(searchVO);
		//if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaAdtFamDao.deleteKoreahanaAdtFam(searchVO);
	}

	/**
	 * 파라미터로 KoreahanaAdtFamVO 가져오기
	 * @param request
	 * @return
	 */
	public void getParamToAdtFamVO(KoreahanaAdtVO searchVO, HttpServletRequest request) {
		//가산금지원가족관계
		List<KoreahanaAdtFamVO> adtFamList = new ArrayList<KoreahanaAdtFamVO>();
		KoreahanaAdtFamVO adtFamVO = null;
		String[] adtnAmtFamIdArr = request.getParameterValues("adtnAmtFamId");
		if(adtnAmtFamIdArr != null) {
			for(String adtnAmtFamId : adtnAmtFamIdArr) {
				String aplcntRelCdParam = adtnAmtFamId+"aplcntRelCd";
				String famFlnmParam = adtnAmtFamId+"famFlnm";
				
				String aplcntRelCd = NullUtil.nullString(request.getParameter(aplcntRelCdParam));
				String famFlnm = NullUtil.nullString(request.getParameter(famFlnmParam));
				
				if(!"".equals(aplcntRelCd) || !"".equals(famFlnm)) {
					adtFamVO = new KoreahanaAdtFamVO();
					adtFamVO.setAplcntRelCd(aplcntRelCd);
					adtFamVO.setFamFlnm(famFlnm);
					adtFamList.add(adtFamVO);
				}
			}
		}
		searchVO.setAdtFamList(adtFamList);
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaAdtFamVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaAdtFamVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaAdtFamVO searchVO){
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
	private void validate(KoreahanaAdtFamVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
