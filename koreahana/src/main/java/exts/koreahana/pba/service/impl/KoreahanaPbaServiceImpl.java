package exts.koreahana.pba.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import exts.com.service.ComAtchFileService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.adt.service.KoreahanaAdtService;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumBizSeCd;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.doc.service.KoreahanaDocService;
import exts.koreahana.pba.service.KoreahanaPbaFileService;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import exts.koreahana.spf.service.KoreahanaSpfQlfService;
import exts.koreahana.spf.vo.KoreahanaSpfQlfVO;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaPbaServiceImpl.java
 * @Description : 모집공고 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaPbaService")
public class KoreahanaPbaServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaPbaService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	public final static String PBA_FILE = "pbaFile";		//모집공고 첨부파일
	
	@Resource(name = "koreahanaPbaDao")
	private KoreahanaPbaDao koreahanaPbaDao;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaPbaFileService")
	private KoreahanaPbaFileService koreahanaPbaFileService;
	
	@Resource(name = "koreahanaSmbService")
	private KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "koreahanaDocService")
	private KoreahanaDocService koreahanaDocService;
	
	@Resource(name = "koreahanaSmbTypService")
	private KoreahanaSmbTypService koreahanaSmbTypService;
	
	@Resource(name = "koreahanaAdtService")
	private KoreahanaAdtService koreahanaAdtService;
	
	@Resource(name = "koreahanaSpfQlfService")
	private KoreahanaSpfQlfService koreahanaSpfQlfService;
	
	@Resource(name = "koreahanaSprService")
	private KoreahanaSprService koreahanaSprService;
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaPbaKoreahanaPbaIdGnrService")		//IDGEN USE
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
	public List<KoreahanaPbaVO> selectKoreahanaPbaList(KoreahanaPbaVO searchVO) {
		List<KoreahanaPbaVO> list = (List<KoreahanaPbaVO>)koreahanaPbaDao.selectKoreahanaPbaList(searchVO);
		if(list != null){
			for(KoreahanaPbaVO result:list){
				if("Y".equals(searchVO.getReqSearchYn())) {
					if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
						//가산금 신청건수 조회
						KoreahanaAdtVO adtSearchVO = new KoreahanaAdtVO();
						adtSearchVO.setPbancrcSn(result.getPbancrcSn());
						searchVO.setReqCnt(koreahanaAdtService.selectKoreahanaAdtTot(adtSearchVO));
					}
				}
			}
		}
		return list;
	}

	/**
	 * 총갯수
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer selectKoreahanaPbaTot(KoreahanaPbaVO searchVO) {
		return koreahanaPbaDao.selectKoreahanaPbaTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaPbaVO selectKoreahanaPba(KoreahanaPbaVO searchVO) {
		KoreahanaPbaVO result = koreahanaPbaDao.selectKoreahanaPba(searchVO);
		return result;
	}
	
	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param request
	 * @throws FdlException 
	 * @throws Exception
	 */
	public void writeKoreahanaPba(KoreahanaSpfQlfVO searchVO, HttpServletRequest request) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);
		
		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getPbancrcSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getPbancrcSn());	//SEQUENCE USE
		
		if(!"Y".equals(searchVO.getTopSearchYn())) searchVO.setTopSearchYn("N");		//상위표시여부 값이 Y가 아니면 N으로 판단
		
		searchVO.setPbancrcCn(getXssClearString(searchVO.getPbancrcCn()));		//XSS 적용(내용)
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setPbancrcSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			searchVO.setInqCnt(0);		//글 등록시 조회수 0 기본값
			koreahanaPbaDao.insertKoreahanaPba(searchVO);
			id = searchVO.getPbancrcSn();				//SEQUENCE USE
		}else{
			String rlsYn = searchVO.getRlsYn();
			searchVO.setRlsYn(null);		//모집공고 수정시 공개여부를 변경하게 되면 게시글 조회가 되지 않아서 권한조회전 값 제거 후 재설정
			KoreahanaPbaVO result = selectKoreahanaPba(searchVO);
			if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			id = result.getPbancrcSn();
			
			searchVO.setRlsYn(rlsYn);		//모집공고 값 재설정
			
			koreahanaPbaDao.updateKoreahanaPba(searchVO);
			
			//모집공고 첨부파일 삭제
			String[] deleteFileSnArr = request.getParameterValues("deleteFileSn");
			if(deleteFileSnArr != null) {
				List<String> deleteFileSnList = Arrays.asList(deleteFileSnArr);
				KoreahanaPbaFileVO pbaFileSearchVO = new KoreahanaPbaFileVO();
				pbaFileSearchVO.setPbancrcSn(id);
				pbaFileSearchVO.setPbancrcAtchFileMpngSnList(deleteFileSnList);
				List<KoreahanaPbaFileVO> pbaFileList = koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileSearchVO);
				
				List<String> pbancrcAtchFileMpngSnList = new ArrayList<String>();
				if(pbaFileList.size() == deleteFileSnArr.length) {
					List<String> atchFileSnList = new ArrayList<String>();
					for(KoreahanaPbaFileVO adtSmbMpnVO : pbaFileList) {
						atchFileSnList.add(adtSmbMpnVO.getAtchFileSn());
						pbancrcAtchFileMpngSnList.add(adtSmbMpnVO.getPbancrcAtchFileMpngSn());
					}
					ComAtchFileVO atchFileDeleteVO = new ComAtchFileVO();
					atchFileDeleteVO.setAtchFileSnList(atchFileSnList);
					comAtchFileService.deleteComAtchFileList(atchFileDeleteVO);
					
					//모집공고 매핑첨부파일 삭제
					KoreahanaPbaFileVO pbaFileDeleteVO = new KoreahanaPbaFileVO();
					pbaFileDeleteVO.setPbancrcAtchFileMpngSnList(pbancrcAtchFileMpngSnList);
					koreahanaPbaFileService.deleteKoreahanaPbaFile(pbaFileDeleteVO);
				}else {
					throwBizException("com.msg.notEqulDeleteFileCount");
				}
			}
			
			//제출서류 첨부파일 삭제
			String[] deleteSmbsnDocFormSnArr = request.getParameterValues("deleteSmbsnDocFormSn");
			if(deleteSmbsnDocFormSnArr != null) {
				List<String> deleteSmbFileSnList = Arrays.asList(deleteSmbsnDocFormSnArr);
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSnList(deleteSmbFileSnList);
				List<ComAtchFileVO> atchFileList = comAtchFileService.selectComAtchFileList(atchFileSearchVO);
				
				if(atchFileList.size() == deleteSmbsnDocFormSnArr.length) {
					ComAtchFileVO atchFileDeleteVO = new ComAtchFileVO();
					atchFileDeleteVO.setAtchFileSnList(deleteSmbFileSnList);
					comAtchFileService.deleteComAtchFileList(atchFileDeleteVO);
					
					//삭제된 제출서류 첨부파일의 일련번호는 VO에서 제거 (해당 VO에 값으로 이후 로직에서 update 되기때문에 미리 값 제거)
					for(KoreahanaSmbVO smbVO : searchVO.getSmbList()) {
						if(deleteSmbFileSnList.contains(smbVO.getSmbsnDocFormSn())){
							smbVO.setSmbsnDocFormSn(null);
						}
					}
					
				}else {
					throwBizException("com.msg.notEqulDeleteFileCount");
				}
			}
			
			//제출서류유형 삭제
			String[] deleteSmbsnDocTypeSnArr = request.getParameterValues("deleteSmbsnDocTypeSn");
			if(deleteSmbsnDocTypeSnArr != null) {
				List<String> deleteSmbsnDocTypeSnList = Arrays.asList(deleteSmbsnDocTypeSnArr);
				
				KoreahanaSmbTypVO smbTypeDeleteVO = new KoreahanaSmbTypVO();
				smbTypeDeleteVO.setPbancrcSn(id);
				smbTypeDeleteVO.setSmbsnDocTypeSnList(deleteSmbsnDocTypeSnList);
				koreahanaSmbTypService.deleteKoreahanaSmbTypList(smbTypeDeleteVO);	//제출서류유형 제거
			}
			
			//제출서류 삭제
			String[] deleteSmbSnArr = request.getParameterValues("deleteSmbsnDocSn");
			if(deleteSmbSnArr != null) {
				List<String> deleteSmbSnList = Arrays.asList(deleteSmbSnArr);
				KoreahanaSmbVO smbDeleteVO = new KoreahanaSmbVO();
				smbDeleteVO.setSmbsnDocList(deleteSmbSnList);
				koreahanaSmbService.deleteKoreahanaSmbList(smbDeleteVO);
			}
		}
		
		//모집공고 첨부파일 추가
		List<String> atchFileSnList = comAtchFileService.writeComAtchUploadFile(request, PBA_FILE, PBA_FILE, id);
		for(String atchFileSn : atchFileSnList) {
			KoreahanaPbaFileVO pbaFileVO = new KoreahanaPbaFileVO();
			pbaFileVO.setAtchFileSn(atchFileSn);
			pbaFileVO.setPbancrcSn(id);
			koreahanaPbaFileService.writeKoreahanaPbaFile(pbaFileVO);
		}
		
		//제출서류유형 추가 and 제출서류 추가(+제출서류 첨부파일)
		List<String> smbsnDocSns = new ArrayList<String>();
		if(searchVO.getSmbTypList() != null) {
			for(KoreahanaSmbTypVO smbTypVO : searchVO.getSmbTypList()) {
				
				KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
				smbTypSearchVO.setPbancrcSn(id);
				List<KoreahanaSmbTypVO> smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypSearchVO);
				List<String> smbsnDocTypeVlList = new ArrayList<String>();
				if(smbTypList != null && smbTypList.size() > 0) {
					for(KoreahanaSmbTypVO smbTypVO2 : smbTypList) {
						if(smbTypVO2.getSmbsnDocTypeVl().equals(smbTypVO.getSmbsnDocTypeVl())) {
							//기존에 동일한 값이 있을때 일련번호 설정
							smbTypVO.setSmbsnDocTypeSn(smbTypVO2.getSmbsnDocTypeSn());
						}
						smbsnDocTypeVlList.add(smbTypVO2.getSmbsnDocTypeVl());
					}
				}
				
				String smbsnDocTypeSn = "";
				if(smbsnDocTypeVlList.contains(smbTypVO.getSmbsnDocTypeVl())) {
					//제출유형이 이미 등록되어 있을때
					smbsnDocTypeSn = smbTypVO.getSmbsnDocTypeSn();
				}else {
					//제출유형이 등록되어 있지 않을때
					smbTypVO.setPbancrcSn(id);
					smbsnDocTypeSn = koreahanaSmbTypService.writeKoreahanaSmbTyp(smbTypVO);		//제출서류유형 추가
				}
				
				//제출서류(파라미터로 받아온 제출서류 추가/수정)
				for(KoreahanaSmbVO smbVO : searchVO.getSmbList()) {
					if(!smbVO.getSmbsnDocTypeVl().equals(smbTypVO.getSmbsnDocTypeVl())) continue;
					
					List<String> atchFileSmbSnList = comAtchFileService.writeComAtchUploadFile(request, smbVO.getSmbDocId()+"_file", PBA_FILE, id);
					for(String atchFileSn : atchFileSmbSnList) {
						smbVO.setSmbsnDocFormSn(atchFileSn);
					}
					smbVO.setSmbsnDocTypeSn(smbsnDocTypeSn);
					koreahanaSmbService.writeKoreahanaSmb(smbVO);		//제출서류 추가
					smbsnDocSns.add(smbVO.getSmbsnDocSn());
				}
			}
		}
		
		//자격시험 정보
		if(KoreahanaEnumCtgryFrstCd.SPF.getCode().equals(searchVO.getPbancrcCtgryFrstCd()) && KoreahanaEnumBizSeCd.QLF.getCode().equals(searchVO.getBizSeCd())) {
			koreahanaSpfQlfService.mergeKoreahanaSpfQlf(searchVO);
		}
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaPba(KoreahanaPbaVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
		KoreahanaPbaVO result = selectKoreahanaPba(searchVO);
		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
		
		//지원신청된 내역이 있는지 확인
		KoreahanaAdtVO sprtCntSearchVO = new KoreahanaAdtVO();
		List<String> pbancrcSnList = new ArrayList<String>();
		pbancrcSnList.add(searchVO.getPbancrcSn());
		sprtCntSearchVO.setPbancrcSnList(pbancrcSnList);
		List<Map<String, String>> sprtCntList = koreahanaSprService.selectListSprtCnt(sprtCntSearchVO);
		if(sprtCntList != null && sprtCntList.size() > 0) {
			for(Map<String, String> sprCnt : sprtCntList) {
				//oracle Count는 BigDecimal로 Return되서 String으로 변환후 Integer parse
				String sprtCnt = String.valueOf(sprCnt.get("sprtCnt"));
				if(Integer.parseInt(sprtCnt) > 0) throwBizException("exts.item.koreahana.pba.receptPbancrcNotDelete");;
			}
		}
		
		/*
		//모집공고첨부파일 매핑
		List<String> deleteAtchFileSnList = new ArrayList<String>();
		KoreahanaPbaFileVO pbaFileDeleteVO = new KoreahanaPbaFileVO();
		pbaFileDeleteVO.setRecordCountPerPage(0);
		pbaFileDeleteVO.setPbancrcSn(result.getPbancrcSn());
		for(KoreahanaPbaFileVO pbaFileVO : koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileDeleteVO)) {
			deleteAtchFileSnList.add(pbaFileVO.getAtchFileSn());
		}
		
		//제출서류
		KoreahanaSmbVO smbDeleteVO = new KoreahanaSmbVO();
		smbDeleteVO.setRecordCountPerPage(0);
		smbDeleteVO.setPbancrcSn(result.getPbancrcSn());
		for(KoreahanaSmbVO smbVO : koreahanaSmbService.selectKoreahanaSmbList(smbDeleteVO)) {
			if(!"".equals(NullUtil.nullString(smbVO.getSmbsnDocFormSn()))) {
				deleteAtchFileSnList.add(smbVO.getSmbsnDocFormSn());
			}
		}
		
		//첨부파일 삭제
		if(deleteAtchFileSnList.size() > 0) {
			ComAtchFileVO atchFileDeleteVO = new ComAtchFileVO();
			atchFileDeleteVO.setAtchFileSnList(deleteAtchFileSnList);
			comAtchFileService.deleteComAtchFileList(atchFileDeleteVO);
		}
		*/
		
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaPbaDao.deleteKoreahanaPba(searchVO);
	}
	
	/**
	 * 조회수 증가
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void updateInqCntPlus(KoreahanaPbaVO searchVO) throws EgovBizException {
		koreahanaPbaDao.updateInqCntPlus(searchVO);
	}
	
	/**
	 * 접수가능 상태 체크
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public boolean isAllowSprtStts(KoreahanaPbaVO searchVO, KoreahanaSprVO sprVO) {
		if(searchVO == null) return false;
		if(!"Y".equals(searchVO.getRlsYn())) return false;
		
		//상시상태 || 신청상태 && 최초등록시
		if(KoreahanaEnumPbancrcSttsCd.ALW.getCode().equals(searchVO.getPbancrcSttsCd()) 
				|| KoreahanaEnumPbancrcSttsCd.REQ.getCode().equals(searchVO.getPbancrcSttsCd())
				&& sprVO == null) {
			
			return true;
		}
		
		//서류미비일때
		if(sprVO != null && KoreahanaEnumSprtSttsCd.UND.getCode().equals(sprVO.getSprtSttsCd())) return true;
		
		//임시저장일때
		if(sprVO != null && KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd())
			&& KoreahanaEnumPbancrcSttsCd.ALW.getCode().equals(searchVO.getPbancrcSttsCd())
			|| KoreahanaEnumPbancrcSttsCd.REQ.getCode().equals(searchVO.getPbancrcSttsCd())) return true;
		
		return false;
	}

	/**
	 * XSS 적용된 문자열 가져오기
	 * @param request
	 * @param content
	 * @return
	 * @throws PolicyException
	 * @throws ScanException
	 */
	public String getXssClearString(String content) throws PolicyException, ScanException {
		if("".equals(NullUtil.nullString(content))) return content;
		
		//XSS 적용
		String antisamyTinymce = Globals.CONTEXT_PATH + File.separator + "WEB-INF/classes/antisamy-anythinggoes-1.4.4.xml";
		Policy policy = Policy.getInstance(antisamyTinymce);
		AntiSamy as = new AntiSamy();
		CleanResults cr = as.scan(content, policy, AntiSamy.SAX);
		
		return cr.getCleanHTML();
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaPbaVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaPbaVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaPbaVO searchVO){
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
	private void validate(KoreahanaPbaVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
