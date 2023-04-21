package exts.koreahana.smb.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.cmmn.exception.FdlException;
//import egovframework.rte.fdl.idgnr.EgovIdGnrService;		//IDGEN USE
import exts.com.service.ComAtchFileService;
import exts.com.service.ComAtchFileUserService;
import exts.com.service.impl.ExtsAbstractServiceImpl;
import exts.com.util.ComFileUploadUtil;
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.doc.service.KoreahanaDocService;
import exts.koreahana.doc.vo.KoreahanaDocVO;
import exts.koreahana.pba.vo.KoreahanaPbaSmbMpnParamVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.service.KoreahanaSmbMpnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.vo.KoreahanaSprVO;

/**
 * @Class Name : KoreahanaSmbServiceImpl.java
 * @Description : 제출서류 ServiceImpl
 * @Modification Information
 * 
 * @author
 * @since 2022.08.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaSmbService")
public class KoreahanaSmbServiceImpl extends ExtsAbstractServiceImpl implements KoreahanaSmbService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////
	@Resource(name = "koreahanaSmbDao")
	private KoreahanaSmbDao koreahanaSmbDao;
	
	@Resource(name = "koreahanaSmbTypService")
	private KoreahanaSmbTypService koreahanaSmbTypService;
	
	@Resource(name = "koreahanaDocService")
	private KoreahanaDocService koreahanaDocService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;

	@Resource(name = "comAtchFileUserService")
	private ComAtchFileUserService comAtchFileUserService;
	
	@Resource(name = "koreahanaSmbMpnService")
	private KoreahanaSmbMpnService koreahanaSmbMpnService;
	
	
	/** ID Generation */
    //@Resource(name="extsKoreahanaSmbKoreahanaSmbIdGnrService")		//IDGEN USE
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
	public List<KoreahanaSmbVO> selectKoreahanaSmbList(KoreahanaSmbVO searchVO) {
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaSmbVO> list = (List<KoreahanaSmbVO>)koreahanaSmbDao.selectKoreahanaSmbList(searchVO);
//		if(list != null){
//			for(KoreahanaSmbVO result:list){
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
	public Integer selectKoreahanaSmbTot(KoreahanaSmbVO searchVO) {
		return koreahanaSmbDao.selectKoreahanaSmbTot(searchVO);
	}

	/**
	 * Pk데이터
	 * 
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public KoreahanaSmbVO selectKoreahanaSmb(KoreahanaSmbVO searchVO) {
		KoreahanaSmbVO result = koreahanaSmbDao.selectKoreahanaSmb(searchVO);
		return result;
	}

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws FdlException 
	 * @throws Exception
	 */
	public void writeKoreahanaSmb(KoreahanaSmbVO searchVO) throws Exception {
		String mbrId = getLoginID();
		searchVO.setRgtrId(mbrId);
		searchVO.setMdfrId(mbrId);

		validate(searchVO);
		//String id = NullUtil.nullString(searchVO.getSmbsnDocSn());  //IDGEN USE
		String id = NullUtil.nullString(searchVO.getSmbsnDocSn());	//SEQUENCE USE
		
		if("".equals(id)){
			//id = egovIdGnrService.getNextStringId();	//IDGEN USE
			//searchVO.setSmbsnDocSn(id);				//IDGEN USE
			if(!isStreAuth())throwBizException("com.error.noauth.write");
			
			koreahanaSmbDao.insertKoreahanaSmb(searchVO);
			//id = searchVO.getSmbsnDocSn();				//SEQUENCE USE
		}else{
			//KoreahanaSmbVO result = selectKoreahanaSmb(searchVO);
			//if(!isModifiable(result))throwBizException("com.error.noauth.modify");
			//id = result.getSmbsnDocSn();
			
			koreahanaSmbDao.updateKoreahanaSmb(searchVO);
		}

	}

	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmb(KoreahanaSmbVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
//		KoreahanaSmbVO result = selectKoreahanaSmb(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbDao.deleteKoreahanaSmb(searchVO);
	}
	
	/**
	 * 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbList(KoreahanaSmbVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		//권한 체크
//		KoreahanaSmbVO result = selectKoreahanaSmb(searchVO);
//		if(!isDeletable(result))throwBizException("com.error.noauth.delete");
				
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbDao.deleteKoreahanaSmbList(searchVO);
	}
	
	/**
	 * 제출서류양식일련번호 삭제
	 * 
	 * @param searchVO
	 * @throws Exception
	 */
	public void deleteKoreahanaSmbDocForm(KoreahanaSmbVO searchVO) throws EgovBizException {
		String userId = getLoginID();
		searchVO.setRgtrId(userId);
		searchVO.setMdfrId(userId);
		koreahanaSmbDao.deleteKoreahanaSmbDocForm(searchVO);
	}
	
	/**
	 * 파라미터로 KoreahanaSmbVO 가져오기
	 * @param request
	 * @return
	 * @throws EgovBizException 
	 */
	public void getParamToSmbVO(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException{
		List<KoreahanaSmbVO> smbList = new ArrayList<KoreahanaSmbVO>();
		KoreahanaSmbVO smbVO = null;
		String[] docIds = request.getParameterValues("docId");
		if(docIds != null) {
			String smbsnDocSn = "";
			String smbsnDocNm = "";
			String smbsnRsn = "";
			String smbsnDocMtlYn = "";
			String smbsnDocRqrYn = "";
			String docBoxYn = "";
			String smbsnDocTypeVl = "";
			String fsn = "";
			
			int smbsnSortSn = 0;
			for(String docId : docIds) {
				smbsnSortSn++;
				smbVO = new KoreahanaSmbVO();
				smbsnDocSn = NullUtil.nullString(request.getParameter(docId+"_smbsnDocSn"));
				smbsnDocNm = NullUtil.nullString(request.getParameter(docId+"_smbsnDocNm"));
				smbsnRsn = NullUtil.nullString(request.getParameter(docId+"_smbsnRsn"));
				smbsnDocMtlYn = NullUtil.nullString(request.getParameter(docId+"_smbsnDocMtlYn"));
				smbsnDocRqrYn = NullUtil.nullString(request.getParameter(docId+"_smbsnDocRqrYn"));
				docBoxYn = NullUtil.nullString(request.getParameter(docId+"_docBoxYn"));
				smbsnDocTypeVl = NullUtil.nullString(request.getParameter(docId+"_smbsnDocTypeVl"));
				fsn = NullUtil.nullString(request.getParameter(docId+"_fsn"));
				
				smbVO.setSmbsnDocSn(smbsnDocSn);
				smbVO.setSmbsnSortSn(smbsnSortSn+"");
				smbVO.setSmbsnDocNm(smbsnDocNm);
				smbVO.setSmbsnRsn(smbsnRsn);
				smbVO.setSmbsnDocMtlYn( ("".equals(smbsnDocMtlYn) ? "N" : smbsnDocMtlYn) );
				smbVO.setSmbsnDocRqrYn( ("".equals(smbsnDocRqrYn) ? "N" : smbsnDocRqrYn) );
				smbVO.setDocBoxYn( ("".equals(docBoxYn) ? "N" : docBoxYn) );
				smbVO.setSmbDocId(docId);
				smbVO.setSmbsnDocFormSn(fsn);
				smbVO.setSmbsnDocTypeVl(smbsnDocTypeVl);
				smbList.add(smbVO);
			}
		}
		searchVO.setSmbList(smbList);
	}

	/**
	 * 파라미터로 넘어온 제출서류 validation
	 * @param searchVO
	 * @param request
	 * @throws Exception
	 */
	public void getParamToSmbValidate(KoreahanaPbaVO searchVO, HttpServletRequest request) throws EgovBizException {
		
		//제출서류유형
		List<KoreahanaSmbTypVO> smbTypList = searchVO.getSmbTypList();
				
		//제출서류
		if(smbTypList != null) {
			List<String> smbsnDocTypSnList = new ArrayList<String>();
			for(KoreahanaSmbTypVO smbTypVO : smbTypList) {
				smbsnDocTypSnList.add(smbTypVO.getSmbsnDocTypeSn());
			}
			KoreahanaSmbVO smbSearchVO = new KoreahanaSmbVO();
			smbSearchVO.setSmbsnDocTypeSnList(smbsnDocTypSnList);
			List<KoreahanaSmbVO> smbList = selectKoreahanaSmbList(smbSearchVO);
			
			if(smbList != null) {		//제출서류 목록
				for(KoreahanaSmbVO smbVO : smbList) {
					String prefix = smbVO.getSmbsnDocSn()+"_id";
					String[] prefixArr = request.getParameterValues(prefix);
					String paramFile = "";		//첨부파일 파라미터
					String paramFsn = "";		//첨부파일 일련번호 파라미터
					String fsn = "";			//첨부파일 일련번호 값
					
					if(prefixArr != null) {
						for(String prefixParam : prefixArr) {		//첨부파일 파라미터
							paramFile = prefixParam+"file";
							paramFsn = prefixParam+"fsn";
							fsn = NullUtil.nullString(request.getParameter(paramFsn));
							if(!"".equals(fsn)) break;
						}
					}
					
					//첨부파일 
					if("".equals(fsn)) {
						if("Y".equals(smbVO.getSmbsnDocRqrYn()) && !ComFileUploadUtil.uploadFormFilesValidate(request, paramFile)) {
							throwBizException("exts.item.koreahana.smb.fileRequired", new String[] {smbVO.getSmbsnDocNm()});
						}
					}
				}
			}
		}
	}
	


	/**
	 * 파라미터로 넘어온 제출서류 삭제
	 * @param upSn
	 * @param request
	 * @throws Exception
	 */
	public void getParamToDeleteSmbMpn(String upSn, HttpServletRequest request) throws Exception {
		String[] deleteFileSnArr = request.getParameterValues("deleteFileSn");
		if( deleteFileSnArr != null && !"".equals(upSn) ) {
			List<String> deleteFileSnList = Arrays.asList(deleteFileSnArr);
			
			//문서함에 등록된 첨부파일은 제거하지 않기 위해 조회
			KoreahanaDocVO docSearchVO = new KoreahanaDocVO();
			docSearchVO.setRecordCountPerPage(0);
			docSearchVO.setRgtrId(getLoginID());
			List<String> docAtchFileList = new ArrayList<String>();
			List<KoreahanaDocVO> docList = koreahanaDocService.selectKoreahanaDocList(docSearchVO);
			for(KoreahanaDocVO docVO : docList) {
				docAtchFileList.add(docVO.getAtchFileSn());
			}
			
			//첨부파일 제거
			KoreahanaSmbMpnVO adtSmbMpnSearchVO = new KoreahanaSmbMpnVO();
			adtSmbMpnSearchVO.setSprtSn(upSn);
			adtSmbMpnSearchVO.setSmbDocMpngSnList(deleteFileSnList);
			List<KoreahanaSmbMpnVO> smbMpnList = koreahanaSmbMpnService.selectKoreahanaSmbMpnList(adtSmbMpnSearchVO);
			List<String> atchFileSnList = new ArrayList<String>();
			List<String> smbDocMpngSnList = new ArrayList<String>();
			
			//제거할 첨부파일 일련번호, 첨부파일 매핑 일련번호 셋팅
			for(KoreahanaSmbMpnVO smbMpnVO : smbMpnList) {
				smbDocMpngSnList.add(smbMpnVO.getSmbDocMpngSn());
				if(!docAtchFileList.contains(smbMpnVO.getAtchFileSn())) atchFileSnList.add(smbMpnVO.getAtchFileSn());	//문서함의 fileSn과 삭제할 fileSn이 일치하면 첨부파일에서 제거하지 않음
			}
			
			//첨부파일 매핑 제거
			if(!"".equals(upSn) && smbDocMpngSnList != null && smbDocMpngSnList.size() > 0) {
				KoreahanaSmbMpnVO smbMpnDeleteVO = new KoreahanaSmbMpnVO();
				smbMpnDeleteVO.setSprtSn(upSn);
				smbMpnDeleteVO.setSmbDocMpngSnList(smbDocMpngSnList);
				koreahanaSmbMpnService.deleteKoreahanaSmbMpnList(smbMpnDeleteVO);
			}
			
			//첨부파일 제거
			/* 문서함 파일의 경우 문서함에서 파일을 지우고 제출서류에서도 파일을 제거하면 해당 atchFileSn으로 등록된 문서함 파일 모두 제거됨
			if(atchFileSnList != null && atchFileSnList.size() > 0) {
				ComAtchFileVO atchFileDeleteVO = new ComAtchFileVO();
				atchFileDeleteVO.setAtchFileSnList(atchFileSnList);
				comAtchFileService.deleteComAtchFileList(atchFileDeleteVO);
			}
			*/
		}
	}
	
	/**
	 * 파라미터로 넘어온 제출서류 저장
	 * @param pbaVO
	 * @param upSn
	 * @param request
	 * @param isTmpSave
	 * @return
	 * @throws Exception
	 */
	public List<KoreahanaSmbMpnVO> getParamToSaveSmbMpn(KoreahanaSprVO sprVO, HttpServletRequest request, boolean isTmpSave) throws Exception {
		
		List<String> smbsnDocTypeSnList = null;
		List<String> docAtchFileList = null;
		List<KoreahanaPbaSmbMpnParamVO> pbaSmbMpnParamList = null;
		
		/* 기존에 데이터에서 가져오므로 조회 제거
		//제출서류에 등록된 파라미터값을 VO에 설정
		KoreahanaSmbTypVO smbTypeSearchVO = new KoreahanaSmbTypVO();
		smbTypeSearchVO.setPbancrcSn(sprVO.getPbancrcSn());
		List<KoreahanaSmbTypVO> smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypeSearchVO);
		*/
		List<KoreahanaSmbTypVO> smbTypList = sprVO.getSmbTypList();
		
		if(smbTypList != null && smbTypList.size() > 0) {
			smbsnDocTypeSnList = new ArrayList<String>();
			for(KoreahanaSmbTypVO smbTypVO : smbTypList) {
				smbsnDocTypeSnList.add(smbTypVO.getSmbsnDocTypeSn());
			}
		}
		
		KoreahanaSmbVO smbSearchVO = new KoreahanaSmbVO();
		smbSearchVO.setSmbsnDocTypeSnList(smbsnDocTypeSnList);
		List<KoreahanaSmbVO> smbList = selectKoreahanaSmbList(smbSearchVO);
		if(smbList != null && smbList.size() > 0) {
			
			boolean isDocSelect = false;
			List<String> fsnList = new ArrayList<String>();
			pbaSmbMpnParamList = new ArrayList<KoreahanaPbaSmbMpnParamVO>();
			for(KoreahanaSmbVO smbVO : smbList) {
				String prefix = smbVO.getSmbsnDocSn()+"_id";
				String[] prefixArr = request.getParameterValues(prefix);
				
				if(prefixArr != null) {
					KoreahanaPbaSmbMpnParamVO pbaSmbMpnParamVO = null;
					for(String prefixParam : prefixArr) {
						pbaSmbMpnParamVO = new KoreahanaPbaSmbMpnParamVO();
						String paramFsn = prefixParam+"fsn";
						String paramFile = prefixParam+"file";
						String paramMpngSn = prefixParam+"mpngSn";
						
						String fsn = NullUtil.nullString(request.getParameter(paramFsn));			//첨부파일 일련번호
						String mpngSn = NullUtil.nullString(request.getParameter(paramMpngSn));		//가산금 첨부파일 매핑 일련번호
						if(!"".equals(fsn) && "".equals(mpngSn)) isDocSelect = true;				//첨부파일일련번호는 있고 첨부파일 매핑 일련번호가 없으면 문서함 파일로 보고 문서함을 조회
						
						pbaSmbMpnParamVO.setFid(paramFile);
						pbaSmbMpnParamVO.setFsn(fsn);
						pbaSmbMpnParamVO.setMpngSn(mpngSn);
						pbaSmbMpnParamVO.setSmbsnDocSn(smbVO.getSmbsnDocSn());		//제출서류 일련번호
						
						pbaSmbMpnParamList.add(pbaSmbMpnParamVO);
						fsnList.add(fsn);
					}
				}
			}
			
			//문서함에 등록된 첨부파일 일련번호 가져오기
			if(isDocSelect &&fsnList != null && fsnList.size() > 0) {
				docAtchFileList = new ArrayList<String>();
				KoreahanaDocVO docSearchVO = new KoreahanaDocVO();
				docSearchVO.setRgtrId(getLoginID());
				docSearchVO.setAtchFileSnList(fsnList);
				docSearchVO.setRecordCountPerPage(0);
				List<KoreahanaDocVO> docList = koreahanaDocService.selectKoreahanaDocList(docSearchVO);
				for(KoreahanaDocVO docVO : docList) {
					docAtchFileList.add(docVO.getAtchFileSn());
				}
			}
			
		}
		
		//제출서류에 등록한 첨부파일 저장
		List<KoreahanaSmbMpnVO> tmpSmbMpnList = new ArrayList<KoreahanaSmbMpnVO>();		//가산금 임시저장 제출서류 첨부파일 목록
		if(smbList != null) {		//제출서류 목록
			
			for(KoreahanaSmbVO smbVO : smbList) {
				
				if(pbaSmbMpnParamList != null) {
					for(KoreahanaPbaSmbMpnParamVO paramVO : pbaSmbMpnParamList) {
						if(!smbVO.getSmbsnDocSn().equals(paramVO.getSmbsnDocSn())) continue;
						String paramFile = paramVO.getFid();
						String fsn = paramVO.getFsn();
						String mpngSn = paramVO.getMpngSn();
						
						if("".equals(fsn)) {
							//문서함의 파일이 아닐경우
							List<String> atchFileSnList = comAtchFileService.writeComAtchUploadFile(request, paramFile, KoreahanaSprService.SPR_FILE, sprVO.getPbancrcSn());
							if(atchFileSnList != null && atchFileSnList.size() > 0) {
								KoreahanaSmbMpnVO smbMpnVO = null;
								for(String atchFileSn : atchFileSnList) {		//첨부파일 일련번호 목록
									smbMpnVO = new KoreahanaSmbMpnVO();
									smbMpnVO.setSprtSn(sprVO.getSprtSn());
									smbMpnVO.setAtchFileSn(atchFileSn);
									smbMpnVO.setSmbsnDocSn(smbVO.getSmbsnDocSn());
									if(isTmpSave) {
										tmpSmbMpnList.add(smbMpnVO);
									}else {
										koreahanaSmbMpnService.writeKoreahanaSmbMpn(smbMpnVO);
									}
								}
//								if("Y".equals(tmpSaveYn)) searchVO.setTmpAdtSmbMpnList(tmpAdtSmbMpnList);
							}
						}else {
							//문서함의 파일일 경우 (최초 등록되는 문서함의 파일인경우 mpngSn 값이 없음)
							if("".equals(mpngSn)) {
								
								//문서함 권한체크 (문서함에 첨부파일일련번호가 없거나 일치하지 않는지 확인)
								/*
								if(!isTmpSave && (docAtchFileList == null || docAtchFileList.size() < 1 || !docAtchFileList.contains(fsn)) ) {
									throwBizException("exts.item.koreahana.pba.notExistDocBoxFile");
								}
								*/
								
								KoreahanaSmbMpnVO smbMpnVO = new KoreahanaSmbMpnVO();
								smbMpnVO.setSprtSn(sprVO.getSprtSn());
								smbMpnVO.setAtchFileSn(fsn);
								smbMpnVO.setSmbsnDocSn(smbVO.getSmbsnDocSn());
								
								if(isTmpSave) {
									tmpSmbMpnList.add(smbMpnVO);
								}else {
									koreahanaSmbMpnService.writeKoreahanaSmbMpn(smbMpnVO);
								}
							}
						}
					}
				}
			}
		}
		
		return tmpSmbMpnList;
	}
	
	/**
	 * 
	 * @param searchVO
	 * @param model
	 * @throws Exception
	 */
	public void getSmbListAll(KoreahanaPbaVO searchVO, ModelMap model) throws Exception {
		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
		smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
		List<KoreahanaSmbTypVO> smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypSearchVO);
		List<String> smbsnDocTypeSnList = null;
		if(smbTypList != null) {
			smbsnDocTypeSnList = new ArrayList<String>();
			for(KoreahanaSmbTypVO smbTypeVO : smbTypList) {
				smbsnDocTypeSnList.add(smbTypeVO.getSmbsnDocTypeSn());
			}
			
			//제출서류
			KoreahanaSmbVO smbSearchVO = new KoreahanaSmbVO();
			smbSearchVO.setSmbsnDocTypeSnList(smbsnDocTypeSnList);
			List<KoreahanaSmbVO> smbList = selectKoreahanaSmbList(smbSearchVO);
			model.addAttribute("smbListJson", JsonUtil.convertObjectToJson(smbList));
			
			List<String> smbsnDocFormSnList = null;
			if(smbList != null) {
				smbsnDocFormSnList = new ArrayList<String>();
				for(KoreahanaSmbVO smbVO : smbList) {
					smbsnDocFormSnList.add(smbVO.getSmbsnDocFormSn());
				}
				
				ComAtchFileVO atchFileVO = new ComAtchFileVO();
				atchFileVO.setAtchFileSnList(smbsnDocFormSnList);
				model.addAttribute("smbDocFormListJson", JsonUtil.convertObjectToJson(comAtchFileUserService.selectComAtchFileList(atchFileVO)));
			}
		}
	}
	
	/**
	 * 해당 데이터를 볼 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isViewable(KoreahanaSmbVO searchVO){
		return super.isViewable(searchVO);
	}

	/**
	 * 해당 데이터를 수정할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isModifiable(KoreahanaSmbVO searchVO){
		return super.isModifiable(searchVO);
	}

	/**
	 * 해당 데이터를 삭제할 수 있는 권한이 있는지 체크
	 * @param searchVO
	 * @return
	 */
	public boolean isDeletable(KoreahanaSmbVO searchVO){
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
	private void validate(KoreahanaSmbVO searchVO){
		
	}
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
