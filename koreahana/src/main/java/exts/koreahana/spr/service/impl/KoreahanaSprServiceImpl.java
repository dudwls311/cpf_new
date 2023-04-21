package exts.koreahana.spr.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.ciel.sms.service.CielSmsService;
import exts.ciel.sms.vo.CielSmsVO;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComCodeService;
import exts.com.service.ComMbrService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.util.ComFileUploadUtil;
import exts.com.util.FileMngUtil;
import exts.com.util.JsonUtil;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComMbrVO;
import exts.koreahana.adt.service.KoreahanaAdtUserService;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.service.KoreahanaSmbMpnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.vo.KoreahanaSprHistoryVO;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.util.FileListUtil;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * @Class Name : KoreahanaSprServiceImpl.java
 * @Description : 지원 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSprService")
public class KoreahanaSprServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSprService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSprDao")
	private KoreahanaSprDao koreahanaSprDao;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;

	@Resource(name = "koreahanaSmbMpnService")
	private KoreahanaSmbMpnService koreahanaSmbMpnService;
	
	@Resource(name = "cielSmsService")
	private CielSmsService cielSmsService;

	@Resource(name = "comCodeService")
	private ComCodeService comCodeService;
	
	@Resource(name = "comMbrService")
	private ComMbrService comMbrService;
	
	@Resource(name = "koreahanaPbaService")
	private KoreahanaPbaService koreahanaPbaService;
	
	@Resource(name = "koreahanaAdtUserService")
	private KoreahanaAdtUserService koreahanaAdtUserService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSprKoreahanaSprIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSprVO> selectKoreahanaSprList(KoreahanaSprVO searchVO) {
		List<KoreahanaSprVO> list = (List<KoreahanaSprVO>)koreahanaSprDao.selectKoreahanaSprList(searchVO);
//		if(list != null){
//			for(KoreahanaSprVO result:list){
//				
//			}
//		}
		return list;
	}

	/**
	 * 리스트 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSprHistoryVO> selectKoreahanaSprListHistory(KoreahanaSprHistoryVO searchVO) {
		List<KoreahanaSprHistoryVO> list = (List<KoreahanaSprHistoryVO>)koreahanaSprDao.selectKoreahanaSprListHistory(searchVO);
//		if(list != null){
//			for(KoreahanaSprVO result:list){
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
	public Integer selectKoreahanaSprTot(KoreahanaSprVO searchVO) {
		return koreahanaSprDao.selectKoreahanaSprTot(searchVO);
	}
	
	/**
	 * 총갯수 히스토리
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaSprTotHistory(KoreahanaSprHistoryVO searchVO) {
		return koreahanaSprDao.selectKoreahanaSprTotHistory(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSprVO selectKoreahanaSpr(KoreahanaSprVO searchVO) {
		KoreahanaSprVO result = koreahanaSprDao.selectKoreahanaSpr(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void writeKoreahanaSpr(KoreahanaSprVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		String id = NullUtil.nullString(searchVO.getSprtSn());
		
		//임시저장 데이터 설정
		if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) searchVO.setTmprStrgData(JsonUtil.convertObjectToJson(searchVO));
		
		//권한 체크는 각 지원하위 사업에서 처리함.
		if("".equals(id)){

			//중복접수 체크(등록자 ID로 중복 구분) 임시저장 상태에서 신청하기를 눌러서 데이터 저장 후 다시 뒤로가기로 와서 신청하기 눌렀을때 상황 방지
//			if(!isAdmin()) {
//				searchVO.setRgtrId(getLoginID());
//				int duplicateCheckCnt = selectKoreahanaSprTot(searchVO);
//				if(duplicateCheckCnt > 0) throwBizException("exts.item.koreahana.pba.duplicateSprtSn");
//			}
			
			//prevWriteAction에서 임시저장 상태값을 설정하고 그게 아닌경우 신청완료값 설정
			if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(searchVO.getSprtSttsCd())) {
				searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.COM.getCode());		//신규 등록시 신청완료 코드값 설정
			}
			
			koreahanaSprDao.insertKoreahanaSpr(searchVO);
		}else{
			koreahanaSprDao.updateKoreahanaSpr(searchVO);
			/* 지원상태값이 서류미비일때 또는 임시저장 상태가 아닐때 신청완료로 변경
			 * 일반사용자 + 북한이탈주민 + 센터직원의 경우에만 서류미비에서 신청완료 상태를 바꿔주는 로직 사용 */
			if(isNtkrdf() || isNormal() || isCenterStaff()) {
				if(KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd())) {
					searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.COM.getCode());
					koreahanaSprDao.updateSttsRsnSpr(searchVO);
				}
			}
		}

		//긴급생계비 + 취업바우처카드일 경우 신청완료 SMS 전송안함
		if(KoreahanaEnumCtgryFrstCd.EML.getCode().equals(searchVO.getPbancrcCtgryFrstCd())
			|| KoreahanaEnumCtgryFrstCd.EMV.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
			return;
		}
		
		//가산금일 경우 신청완료 SMS 전송안함
		if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
			return;
		}
		
		//신청완료의 경우에만 모집공고를 등록한 사람의 전화번호로 전송
		if(KoreahanaEnumSprtSttsCd.COM.getCode().equals(searchVO.getSprtSttsCd())) {
			
			KoreahanaPbaVO pbaVO = new KoreahanaPbaVO();
			pbaVO.setPbancrcSn(searchVO.getPbancrcSn());
			pbaVO = koreahanaPbaService.selectKoreahanaPba(pbaVO);
			
			ComMbrVO comMbrVO = new ComMbrVO();
			comMbrVO.setMbrId(pbaVO.getRgtrId());
			comMbrVO = comMbrService.selectComMbr(comMbrVO);
			String telno = comMbrVO.getTelno();
			
			String pbancrcTitle = pbacrcNm(searchVO);																//카테고리+사업명
			String sprtSttsNm = comCodeService.getCdNmInGrp(EnumGrpCd.SPRT_STTS_CD, searchVO.getSprtSttsCd());		//선정결과명
			
			CielSmsVO smsVO = new CielSmsVO();
			smsVO.setTargetNumber(searchVO.getMbphno());
			smsVO.setSendNumber(telno);
			smsVO.setSendTitle(getMessage("exts.item.koreahana.pba.smsSendTitle"));
			smsVO.setSendMessage(getMessage("exts.item.koreahana.pba.smsSendMsg", new String[] {searchVO.getFlnm(), pbancrcTitle, sprtSttsNm }));
			cielSmsService.sendSms(smsVO);
		} 
	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSpr(KoreahanaSprVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크는 각 지원하위 사업에서 처리함.
		KoreahanaSprVO result = selectKoreahanaSpr(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSprDao.deleteKoreahanaSpr(searchVO);
	}

	/**
	 * 선정결과 변경
	 * @param searchVO
	 */
	public List<String> updateKoreahanaSprStts(KoreahanaSprVO searchVO, String[] sprtSnArr) throws EgovBizException {
//		String[] sprtSnArr = request.getParameterValues("sprtSnArr");
		if(sprtSnArr == null) throwBizException("exts.item.koreahana.adt.sprtSnRequired");
		
		List<String> errorMsg = new ArrayList<String>();
		
		for(String sprtSn : sprtSnArr) {
			String msg = "";
			try {
				KoreahanaSprVO sprVO = new KoreahanaSprVO();
				sprVO.setSprtSn(sprtSn);
				
				KoreahanaSprVO result = selectKoreahanaSpr(sprVO);
				if(!isModifiable(result))throwBizException("com.error.noauth.modify");
				
				//카테고리값이 넘어왔을 때 같은 카테고리인지 체크
				if(!NullUtil.nullString(searchVO.getPbancrcCtgryFrstCd()).equals("") && !searchVO.getPbancrcCtgryFrstCd().equals(result.getPbancrcCtgryFrstCd()))throwBizException("com.error.noauth.modify");
				
				//사유만 변경시 기존 지원상태값 설정
				if("".equals(NullUtil.nullString(searchVO.getSprtSttsCd()))) {
					sprVO.setSprtSttsCd(result.getSprtSttsCd());
				}else {
					sprVO.setSprtSttsCd(searchVO.getSprtSttsCd());
				}
				
				//서류미비가 아닐땐 사유 제거
				if(!KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd())) {
					sprVO.setRsn(null);
				}else {
					sprVO.setRsn(searchVO.getRsn());
				}
				
				koreahanaSprDao.updateSttsRsnSpr(sprVO);
				
				String telno = "";
				if(getLoginAdtVO() != null && !"".equals(NullUtil.nullString(getLoginAdtVO().getTelno()))) {
					telno = getLoginAdtVO().getTelno();
				}
				
				//긴급생계비 + 취업바우처카드 상담사전용 메뉴는 SMS 전송차단(차후에 상담사 연락처 설정이 되면 신청자가 아닌 상담사에게로 연락되도록 수정필요)
				if(KoreahanaEnumCtgryFrstCd.EML.getCode().equals(result.getPbancrcCtgryFrstCd()) || KoreahanaEnumCtgryFrstCd.EMV.getCode().equals(result.getPbancrcCtgryFrstCd())) {
					return errorMsg;
				}
				//가산금일경우 return  
				if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(result.getPbancrcCtgryFrstCd())){
					return errorMsg;
				}
				
				//선정결과에 따른 SMS 전송 
				 if(KoreahanaEnumSprtSttsCd.UND.getCode().equals(searchVO.getSprtSttsCd())		//서류미비
					 || KoreahanaEnumSprtSttsCd.SEL.getCode().equals(searchVO.getSprtSttsCd())		//선정
					 || KoreahanaEnumSprtSttsCd.UNS.getCode().equals(searchVO.getSprtSttsCd())		//미선정
					 && !"".equals(telno)) {
				 	
					 //사업구분명
					 String pbancrcTitle = pbacrcNm(result);																	//카테고리+사업명
					 String sprtSttsNm = comCodeService.getCdNmInGrp(EnumGrpCd.SPRT_STTS_CD, searchVO.getSprtSttsCd());		//선정결과명
					 
					 CielSmsVO smsVO = new CielSmsVO();
					 smsVO.setTargetNumber(result.getMbphno());
					 smsVO.setSendNumber(telno);
					 smsVO.setSendTitle(getMessage("exts.item.koreahana.pba.smsSendTitle"));
					 smsVO.setSendMessage(getMessage("exts.item.koreahana.pba.smsSendMsg", new String[] {result.getFlnm(), pbancrcTitle, sprtSttsNm }));
					 if(!cielSmsService.sendSms(smsVO)) msg = getMessage("exts.item.koreahana.pba.smsSendError");
				}

			}catch(DataAccessException e) {
				log.error(e.getMessage());
				msg = "DB ERROR";
			}catch(EgovBizException e) {
				log.error(e.getMessage());
				msg = e.getMessage();
			}catch(Exception e) {
				log.error(e.getMessage());
				msg = "UNKNWON ERROR";
			}
			errorMsg.add(msg);
		}
		return errorMsg;
	}
	
	/**
	 * 리스트(신청연도)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectKoreahanaSprListGroupByRegDtYr(KoreahanaSprVO searchVO) {
		return koreahanaSprDao.selectKoreahanaSprListGroupByRegDtYr(searchVO);
	}
	
	/**
	 * 리스트(지원상태)
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectKoreahanaSprListGroupBySprtSttsCd(KoreahanaSprVO searchVO) {
		return koreahanaSprDao.selectKoreahanaSprListGroupBySprtSttsCd(searchVO);
	}
	
	/**
	 * 파라미터로 넘어온 제출서류 처리
	 * @param searchVO
	 * @param request
	 * @param isTmpSave
	 * @throws Exception
	 */
	public void getParamToSmbMpnProc(KoreahanaSprVO searchVO, HttpServletRequest request, boolean isTmpSave) throws Exception {		
		koreahanaSmbService.getParamToDeleteSmbMpn(searchVO.getSprtSn(), request);
		List<KoreahanaSmbMpnVO> smbMpnList = koreahanaSmbService.getParamToSaveSmbMpn(searchVO, request, isTmpSave);
		searchVO.setSmbMpnList(smbMpnList);
	}
	
	/**
	 * 모집공고별 신청건수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> selectListSprtCnt(KoreahanaSprVO searchVO) {
		return koreahanaSprDao.selectListSprtCnt(searchVO);
	}
	
	/**
	 * 지원신청에 관련된 첨부파일 압축다운로드
	 * @param searchVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void zipFileDownload(KoreahanaSprVO searchVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//호출하기 전 권한 체크
//		KoreahanaSprVO result = new KoreahanaSprVO();
//		result.setSprtSn(searchVO.getSprtSn());
//		result = selectKoreahanaSpr(searchVO);
//		if(!isViewable(result)) throwBizException("com.error.noauth");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String zipFileName = new StringBuffer().append(dayTime.format(cal.getTime())+(int)(Math.random()*100)).append(".zip").toString();
		
		//압축파일 저장
		String zipStoreCours = Globals.FILE_DEC_PATH;
		String zipStoreName = zipFileName;
		
		ZipFile zipFile = new ZipFile(new StringBuffer().append(zipStoreCours).append(File.separator).append(zipStoreName).toString());
		
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
		smbMpnSearchVO.setRecordCountPerPage(0);
		smbMpnSearchVO.setSprtSn(searchVO.getSprtSn());
		List<KoreahanaSmbMpnVO> smbMpnList = koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO);
		List<File> deleteFileList = null;
		if(smbMpnList != null && smbMpnList.size() > 0) {
			deleteFileList = new ArrayList<File>();
			StringBuffer filePath = new StringBuffer();
			File file = null;
			int cnt = 1;
			for(KoreahanaSmbMpnVO smbMpnVO : smbMpnList) {
				filePath.setLength(0);
				file = ComFileUploadUtil.getDecFile(filePath.append(Globals.UPLOAD_PATH).append(File.separator).append(smbMpnVO.getAtchFilePathNm()).toString(), smbMpnVO.getAtchFileNm(), smbMpnVO.getOrgnlAtchFileNm(), "["+cnt+"]_");
				if(file.exists()) {
					//TODO:압축 파일에 넣기 전 DRM 메소드 추가
					zipFile.addFile(file, parameters);
					deleteFileList.add(file);
				}else {
					log.error("file not found : " + file.getPath());
				}
				cnt++;
			}
			
			//복호화된 파일 파일제거
			FileListUtil.deleteFiles(deleteFileList);
			FileMngUtil.downFileNoneEnc(request, response, zipStoreCours, zipStoreName, zipStoreName, true);
		}else {
			throwBizException("exts.item.koreahana.spr.noSmbFileList");
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSprVO searchVO){
		if(!isRedngAuth())return false;
		
		if(searchVO == null)return false;
		if(isAdmin())return true;
		
//		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
		return true;
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSprVO searchVO){
		if(!isStreAuth())return false;
		
		if(searchVO == null)return false;
		if(isAdmin())return true;

//		return NullUtil.nullString(searchVO.getRgtrId()).equals(getLoginID());
		return true;
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSprVO searchVO){
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
	private void validate(KoreahanaSprVO searchVO){
		
	}
	
	private String pbacrcNm(KoreahanaSprVO searchVO) {
		//사업구분명
		String pbancrcTitle = "";
		List<ComCodeVO> bizSeCdList = comCodeService.getCodeByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd());
		if(bizSeCdList != null && bizSeCdList.size() > 0) {
			for(ComCodeVO code : bizSeCdList) {
				if(code.getIndivCd().equals(searchVO.getBizSeCd())) {
					pbancrcTitle = code.getIndivCdNm()+" ";
				}
			}
		}
		
		//1차 카테고리
		for(KoreahanaEnumCtgryFrstCd ctgrtFrstCd : KoreahanaEnumCtgryFrstCd.values()) {
			if(ctgrtFrstCd.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
				pbancrcTitle += ctgrtFrstCd.getName();
			}
		}
		return pbancrcTitle;
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
