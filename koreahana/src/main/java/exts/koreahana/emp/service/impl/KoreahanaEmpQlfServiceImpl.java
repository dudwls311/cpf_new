package exts.koreahana.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.emp.service.KoreahanaEmpQlfService;
import exts.koreahana.emp.vo.KoreahanaEmpQlfVO;

/**
 * @Class Name : KoreahanaEmpQlfServiceImpl.java
 * @Description : 취업연계직업훈련자격사항 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaEmpQlfService")
public class KoreahanaEmpQlfServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaEmpQlfService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaEmpQlfDao")
	private KoreahanaEmpQlfDao koreahanaEmpQlfDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaEmpKoreahanaEmpQlfIdGnrService")		//IDGEN USE
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
	public List<KoreahanaEmpQlfVO> selectKoreahanaEmpQlfList(KoreahanaEmpQlfVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaEmpQlfVO> list = (List<KoreahanaEmpQlfVO>)koreahanaEmpQlfDao.selectKoreahanaEmpQlfList(searchVO);
//		if(list != null){
//			for(KoreahanaEmpQlfVO result:list){
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
	public Integer selectKoreahanaEmpQlfTot(KoreahanaEmpQlfVO searchVO) {
		return koreahanaEmpQlfDao.selectKoreahanaEmpQlfTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaEmpQlfVO selectKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) {
		KoreahanaEmpQlfVO result = koreahanaEmpQlfDao.selectKoreahanaEmpQlf(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) throws Exception {
//		String mbrId = getLoginID();
//		searchVO.setRgtrId(mbrId);
//		searchVO.setMdfrId(mbrId);

//		validate(searchVO);
//		String id = NullUtil.nullString(searchVO.getEmpmQlfcMttrSn());
		
//		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setEmpmQlfcMttrSn(id);				//IDGEN USE
//			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaEmpQlfDao.insertKoreahanaEmpQlf(searchVO);
//			id = searchVO.getEmpmQlfcMttrSn();				//SEQUENCE USE
//		}else{
//			KoreahanaEmpQlfVO result = selectKoreahanaEmpQlf(searchVO);
//			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
//			id = result.getEmpmQlfcMttrSn();
//			
//			koreahanaEmpQlfDao.updateKoreahanaEmpQlf(searchVO);
//		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaEmpQlf(KoreahanaEmpQlfVO searchVO) throws EgovBizException {
//		String userId = getLoginID();
		//권한 체크
//		KoreahanaEmpQlfVO result = selectKoreahanaEmpQlf(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
//				
//		searchVO.setRgtrId(userId);
//		searchVO.setMdfrId(userId);
		koreahanaEmpQlfDao.deleteKoreahanaEmpQlf(searchVO);
	}

	/**
	 * 파라미터를 List<KoreahanaEmpQlfVO> 반환
	 * @param request
	 * @return
	 */
	public List<KoreahanaEmpQlfVO> getParamToEmpQlfVO(HttpServletRequest request){
		List<KoreahanaEmpQlfVO> empQlfList = null;
		String[] empQlfPrefixArr = request.getParameterValues("empQlfPrefix");
		if(empQlfPrefixArr != null) {
			empQlfList = new ArrayList<KoreahanaEmpQlfVO>();
			KoreahanaEmpQlfVO empQlfVO = null;
			String crtfctNm = "";
			String acqsYmd = "";
			String acqsPlc = "";
			for(String prefix : empQlfPrefixArr) {
				crtfctNm = request.getParameter("crtfctNm"+prefix);
				acqsYmd = request.getParameter("acqsYmd"+prefix);
				acqsPlc = request.getParameter("acqsPlc"+prefix);
				
				empQlfVO = new KoreahanaEmpQlfVO();
				empQlfVO.setCrtfctNm(crtfctNm);
				empQlfVO.setAcqsYmd(acqsYmd);
				empQlfVO.setAcqsPlc(acqsPlc);
				empQlfList.add(empQlfVO);
			}
		}
		return empQlfList;
	}
	
	/**
	 * 파라미터를 List<KoreahanaEmpQlfVO> 반환
	 * @param request
	 * @return
	 */
	public void empQlfValidate(List<KoreahanaEmpQlfVO> empQlfList) throws EgovBizException{
		if(empQlfList == null || empQlfList.size() < 1) throwBizException("exts.item.koreahana.emp.noEmpQlf");
		
		for(KoreahanaEmpQlfVO empQlfVO : empQlfList) {
			if("".equals(NullUtil.nullString(empQlfVO.getCrtfctNm()))) throwBizException("exts.item.koreahana.emp.noCrtfctNm");
			if("".equals(NullUtil.nullString(empQlfVO.getAcqsYmd()))) throwBizException("exts.item.koreahana.emp.noAcqsYmd");
			if("".equals(NullUtil.nullString(empQlfVO.getAcqsPlc()))) throwBizException("exts.item.koreahana.emp.noAcqsPlc");
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaEmpQlfVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaEmpQlfVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaEmpQlfVO searchVO){
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
	private void validate(KoreahanaEmpQlfVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
