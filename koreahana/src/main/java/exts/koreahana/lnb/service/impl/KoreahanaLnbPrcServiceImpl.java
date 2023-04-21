package exts.koreahana.lnb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.koreahana.com.enums.KoreahanaEnumBrplcCd;
import exts.koreahana.com.enums.KoreahanaEnumLnbType;
import exts.koreahana.lnb.service.KoreahanaLnbPrcService;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;

/**
 * @Class Name : KoreahanaLnbPrcServiceImpl.java
 * @Description : 학습지지원기본정보 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaLnbPrcService")
public class KoreahanaLnbPrcServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaLnbPrcService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaLnbPrcDao")
	private KoreahanaLnbPrcDao koreahanaLnbPrcDao;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaLnbKoreahanaLnbPrcIdGnrService")		//IDGEN USE
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
	public List<KoreahanaLnbPrcVO> selectKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaLnbPrcVO> list = (List<KoreahanaLnbPrcVO>)koreahanaLnbPrcDao.selectKoreahanaLnbPrcList(searchVO);
//		if(list != null){
//			for(KoreahanaLnbPrcVO result:list){
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
	public Integer selectKoreahanaLnbPrcTot(KoreahanaLnbPrcVO searchVO) {
		return koreahanaLnbPrcDao.selectKoreahanaLnbPrcTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaLnbPrcVO selectKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) {
		KoreahanaLnbPrcVO result = koreahanaLnbPrcDao.selectKoreahanaLnbPrc(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		String id = NullUtil.nullString(searchVO.getLnbkSprtBscInfoSn());
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setLnbkSprtBscInfoSn(id);				//IDGEN USE
			//if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaLnbPrcDao.insertKoreahanaLnbPrc(searchVO);
			id = searchVO.getLnbkSprtBscInfoSn();				//SEQUENCE USE
		}else{
			//KoreahanaLnbPrcVO result = selectKoreahanaLnbPrc(searchVO);
			//if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			//id = result.getLnbkSprtBscInfoSn();
			
			koreahanaLnbPrcDao.updateKoreahanaLnbPrc(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaLnbPrc(KoreahanaLnbPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaLnbPrcVO result = selectKoreahanaLnbPrc(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaLnbPrcDao.deleteKoreahanaLnbPrc(searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaLnbPrcList(KoreahanaLnbPrcVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
//		KoreahanaLnbPrcVO result = selectKoreahanaLnbPrc(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaLnbPrcDao.deleteKoreahanaLnbPrcList(searchVO);
	}

	/**
	 * KoreahanaLnbPrcVO 파라미터 셋팅
	 * @param searchVO
	 * @param request
	 */
	public void setParamToLnbPrcVO(KoreahanaLnbVO searchVO, HttpServletRequest request){
		List<KoreahanaLnbPrcVO> resultList = null;
		
		String[] prefixArr = request.getParameterValues("prefix");
		if(prefixArr != null) {
			resultList = new ArrayList<KoreahanaLnbPrcVO>();
			KoreahanaLnbPrcVO lnbPrcVO = null;
			String lnbkSprtBscInfoSn = "";
			String rnkg = "";
			String lnbPrcFlnm = "";
			String lnbPrcBrdtYmd = "";
			String lnbPrcBrplcCd = "";
			String lnbPrcHanawonTh = "";
			String lnbPrcEntcnyYr = "";
			String ntkrdfAcrtfctFileId = "";
			String lnbPrcExistBnfCd = "";
			String ntkrdfAcrtfctFileSn = "";
			
			String ntkrdfOprtSe = "";
			String ntkrdfOprtFlnm = "";
			String ntkrdfOprtHanawonTh = "";
			String ntkrdfOprtEnctnyYr = "";
			
			for(String prefix : prefixArr) {
				lnbkSprtBscInfoSn = NullUtil.nullString(request.getParameter("lnbkSprtBscInfoSn"+prefix));
				rnkg = NullUtil.nullString(request.getParameter("rnkg"+prefix));
				lnbPrcFlnm = NullUtil.nullString(request.getParameter("lnbPrcFlnm"+prefix));
				lnbPrcBrdtYmd = NullUtil.nullString(request.getParameter("lnbPrcBrdtYmd"+prefix));
				lnbPrcBrplcCd = NullUtil.nullString(request.getParameter("lnbPrcBrplcCd"+prefix));
				lnbPrcHanawonTh = NullUtil.nullString(request.getParameter("lnbPrcHanawonTh"+prefix));
				lnbPrcEntcnyYr = NullUtil.nullString(request.getParameter("lnbPrcEntcnyYr"+prefix));
				lnbPrcExistBnfCd = NullUtil.nullString(request.getParameter("lnbPrcExistBnfCd"+prefix));
				ntkrdfAcrtfctFileSn = NullUtil.nullString(request.getParameter("ntkrdfAcrtfctFileSn"+prefix));
				ntkrdfAcrtfctFileId = "ntkrdfAcrtfctFileSn"+prefix+"File";
				
				ntkrdfOprtSe = NullUtil.nullString(request.getParameter("ntkrdfOprtSe"+prefix));
				ntkrdfOprtFlnm = NullUtil.nullString(request.getParameter("ntkrdfOprtFlnm"+prefix));
				ntkrdfOprtHanawonTh = NullUtil.nullString(request.getParameter("ntkrdfOprtHanawonTh"+prefix));
				ntkrdfOprtEnctnyYr = NullUtil.nullString(request.getParameter("ntkrdfOprtEnctnyYr"+prefix));
				
				lnbPrcVO = new KoreahanaLnbPrcVO();
				lnbPrcVO.setLnbkSprtBscInfoSn(lnbkSprtBscInfoSn);
				lnbPrcVO.setRnkg(rnkg);
				lnbPrcVO.setFlnm(lnbPrcFlnm);
				lnbPrcVO.setBrdtYmd(lnbPrcBrdtYmd);
				lnbPrcVO.setBrplcCd(lnbPrcBrplcCd);
				lnbPrcVO.setHanawonTh(lnbPrcHanawonTh);
				lnbPrcVO.setEntcnyYr(lnbPrcEntcnyYr);
				lnbPrcVO.setNtkrdfAcrtfctFileId(ntkrdfAcrtfctFileId);
				lnbPrcVO.setNtkrdfAcrtfctFileSn(ntkrdfAcrtfctFileSn);
				lnbPrcVO.setExistBnfCd(lnbPrcExistBnfCd);
				
				lnbPrcVO.setNtkrdfOprtSe(ntkrdfOprtSe);
				lnbPrcVO.setNtkrdfOprtFlnm(ntkrdfOprtFlnm);
				lnbPrcVO.setNtkrdfOprtHanawonTh(ntkrdfOprtHanawonTh);
				lnbPrcVO.setNtkrdfOprtEnctnyYr(ntkrdfOprtEnctnyYr);
				resultList.add(lnbPrcVO);
			}
		}
		searchVO.setLnbPrcList(resultList);
	}
	
	/**
	 * 학습지지원기본정보 유효성 검사
	 * @param searchVO
	 * @throws EgovBizException
	 */
	public void validateLnbPrcVO(KoreahanaLnbPrcVO searchVO) throws EgovBizException {
		if(KoreahanaEnumLnbType.NTK.getCode().equals(searchVO.getAplcntType())) {
			//북한이탈주민
			if("".equals(NullUtil.nullString(searchVO.getFlnm()))) throwBizException("exts.item.koreahana.lnb.noFlnm");
			if("".equals(NullUtil.nullString(searchVO.getBrdtYmd()))) throwBizException("exts.item.koreahana.lnb.noBrdtYmd");
			if("".equals(NullUtil.nullString(searchVO.getBrplcCd()))) throwBizException("exts.item.koreahana.lnb.noBrplcCd");
			if(KoreahanaEnumBrplcCd.NOR.getCode().equals(searchVO.getBrplcCd())) {
				if("".equals(NullUtil.nullString(searchVO.getHanawonTh()))) throwBizException("exts.item.koreahana.lnb.noHanawonTh");
				if("".equals(NullUtil.nullString(searchVO.getEntcnyYr()))) throwBizException("exts.item.koreahana.lnb.noEntcnyYr");
				if("".equals(NullUtil.nullString(searchVO.getNtkrdfAcrtfctFileSn()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfAcrtfctFileSn");
			}
			if("".equals(NullUtil.nullString(searchVO.getExistBnfCd()))) throwBizException("exts.item.koreahana.lnb.noExistBnfCd");
		}else {
			//일반사용자
			if("".equals(NullUtil.nullString(searchVO.getFlnm()))) throwBizException("exts.item.koreahana.lnb.noFlnm");
			if("".equals(NullUtil.nullString(searchVO.getBrdtYmd()))) throwBizException("exts.item.koreahana.lnb.noBrdtYmd");
			if("".equals(NullUtil.nullString(searchVO.getBrplcCd()))) throwBizException("exts.item.koreahana.lnb.noBrplcCd");
			if(KoreahanaEnumBrplcCd.NOR.getCode().equals(searchVO.getBrplcCd())) {
				if("".equals(NullUtil.nullString(searchVO.getHanawonTh()))) throwBizException("exts.item.koreahana.lnb.noHanawonTh");
				if("".equals(NullUtil.nullString(searchVO.getEntcnyYr()))) throwBizException("exts.item.koreahana.lnb.noEntcnyYr");
			}else {
				if("".equals(NullUtil.nullString(searchVO.getNtkrdfOprtSe()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfOprtSe");
				if("".equals(NullUtil.nullString(searchVO.getNtkrdfOprtFlnm()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfOprtFlnm");
				if("".equals(NullUtil.nullString(searchVO.getNtkrdfOprtHanawonTh()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfOprtHanawonTh");
				if("".equals(NullUtil.nullString(searchVO.getNtkrdfOprtEnctnyYr()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfOprtEnctnyYr");
			}
			if("".equals(NullUtil.nullString(searchVO.getNtkrdfAcrtfctFileSn()))) throwBizException("exts.item.koreahana.lnb.noNtkrdfAcrtfctFileSn");
			if("".equals(NullUtil.nullString(searchVO.getExistBnfCd()))) throwBizException("exts.item.koreahana.lnb.noExistBnfCd");
			
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaLnbPrcVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaLnbPrcVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaLnbPrcVO searchVO){
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
		return isDelAuth();
	}

	/**
	 * 지원현황 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateKoreahanaLnbPrcSupport(KoreahanaLnbPrcVO searchVO) throws Exception{
		String userId = getLoginID();
		if(searchVO.getLnbPrcList() != null) {
			for(KoreahanaLnbPrcVO vo:searchVO.getLnbPrcList()) {
				KoreahanaLnbPrcVO result = selectKoreahanaLnbPrc(vo);
				if(!isModifiable(result))throwBizException("com.error.noauth.modify");
				
				//변경할 정보만 셋팅
				result.setRnkg(vo.getRnkg());
				result.setSprtTrgtYn(vo.getSprtTrgtYn());
				result.setVdoengDpcnTrgtYn(vo.getVdoengDpcnTrgtYn());
				result.setSprtTrgtYn(vo.getSprtTrgtYn());
				result.setMdwGbkhmYmd(vo.getMdwGbkhmYmd());
				result.setGbkhmRsn(vo.getGbkhmRsn());
				result.setMdfrId(userId);
				koreahanaLnbPrcDao.updateKoreahanaLnbPrc(result);
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
	private void validate(KoreahanaLnbPrcVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
