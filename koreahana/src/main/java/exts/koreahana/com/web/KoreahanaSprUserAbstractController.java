/**
 * @version 3.2.0.1
 */
package exts.koreahana.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.exception.ValidatorException;
import exts.com.service.ComAtchFileUserService;
import exts.com.service.ComMbrService;
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ComMbrVO;
import exts.koreahana.adt.vo.KoreahanaAdtVO;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.edu.vo.KoreahanaEduVO;
import exts.koreahana.emp.vo.KoreahanaEmpVO;
import exts.koreahana.lnb.service.KoreahanaLnbPrcService;
import exts.koreahana.lnb.vo.KoreahanaLnbPrcVO;
import exts.koreahana.lnb.vo.KoreahanaLnbVO;
import exts.koreahana.pba.service.KoreahanaPbaFileService;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaFileVO;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.sho.vo.KoreahanaShoVO;
import exts.koreahana.smb.service.KoreahanaSmbMpnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.spf.vo.KoreahanaSpfVO;
import exts.koreahana.spr.service.KoreahanaSprUserService;
import exts.koreahana.spr.validator.KoreahanaSprValidator;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import exts.koreahana.vdo.vo.KoreahanaVdoVO;
import jnit.com.tag.JnitTag;
import jnit.crypto.JnitCryptoService;

/**
 *  Koreahana 지원신청관련 User Abstract 컨트롤러 클래스
 * @author 
 * @since 2022.09.13
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2022.09.13            최초 생성
 *
 * </pre>
 */

public abstract class KoreahanaSprUserAbstractController extends KoreahanaUserAbstractController {

	@Resource(name = "koreahanaPbaService")
	private KoreahanaPbaService koreahanaPbaService;
	
	@Resource(name = "koreahanaPbaFileService")
	private KoreahanaPbaFileService koreahanaPbaFileService;
	
	@Resource(name = "koreahanaSprUserService")
	protected KoreahanaSprUserService koreahanaSprUserService;
	
	@Resource(name = "koreahanaSmbTypService")
	private KoreahanaSmbTypService koreahanaSmbTypService;

	@Resource(name = "comAtchFileUserService")
	protected ComAtchFileUserService comAtchFileUserService;

	@Resource(name = "koreahanaSmbMpnService")
	protected KoreahanaSmbMpnService koreahanaSmbMpnService;
	
	@Resource(name = "koreahanaSmbService")
	protected KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "koreahanaSprValidator")
	private KoreahanaSprValidator koreahanaSprValidator;
	
	@Resource(name = "koreahanaLnbPrcService")
	private KoreahanaLnbPrcService koreahanaLnbPrcService;
	
	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    protected JnitCryptoService jnitCryptoService;

	public static final String ATTR_PBA_VO = "pbaVO";//model에 setAttribute한 선택된 공고정보 VO
	public static final String ATTR_SPR_VO = "sprVO";//model에 setAttribute한 선택된 신청정보 VO
	
	/**
	 * 공고목록
	 * @param searchVO
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	protected String comList(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		//기본값으로 스프링빈에 설정된 값 로드
		if(searchVO.getPageUnit() == 0)searchVO.setPageUnit(getDefaultPageUnit());
		if(searchVO.getPageSize() == 0)searchVO.setPageSize(getDefaultPageSize());
	
		//총갯수
		int totalRecordCount = koreahanaPbaService.selectKoreahanaPbaTot(searchVO);

    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
    	paginationInfo.setTotalRecordCount(totalRecordCount);
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//전체가져올때
		if(searchVO.getPageUnit() == -1)searchVO.setRecordCountPerPage(0);
		
		model.addAttribute("paginationInfo",paginationInfo);
		model.addAttribute("resultCnt",totalRecordCount);
		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));			//공고상태
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));						//사업구분
		
		searchVO.setReqSearchYn("Y");
		model.addAttribute("resultList",koreahanaPbaService.selectKoreahanaPbaList(searchVO));
		
		return "exts/koreahana/pba/pbaUserList";
	}
	
	/**
	 * 공고상세보기
	 */
	protected String comPbaView(
			@ModelAttribute("searchVO")	KoreahanaPbaVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		koreahanaPbaService.updateInqCntPlus(searchVO);				//조회수 증가
		KoreahanaPbaVO result = koreahanaPbaService.selectKoreahanaPba(searchVO);
		
		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));
		model.addAttribute("ctgryFrstCdList", getCodeListByGrpCd(EnumGrpCd.CTGRY_FRST_CD));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));						//사업구분
		
		model.addAttribute("result",result);
		model.addAttribute("isModifiable",koreahanaPbaService.isModifiable(result));
		
		//첨부파일
		KoreahanaPbaFileVO pbaFileVO = new KoreahanaPbaFileVO();
		pbaFileVO.setPbancrcSn(result.getPbancrcSn());
		model.addAttribute("pbaFileList", koreahanaPbaFileService.selectKoreahanaPbaFileList(pbaFileVO));
		
		return "exts/koreahana/pba/pbaUserView";
	}
	
	/**
	 * 보기페이지에서 필요한 내용 공통처리
	 */
	public void prevView(
			KoreahanaSprVO result,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setSmbMpnList(result);
		
		//제출서류+제출서류서식
		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
		smbTypSearchVO.setPbancrcSn(result.getPbancrcSn());
		koreahanaSmbTypService.selectKoreahanaSmbTypListAll(smbTypSearchVO);
		model.addAttribute("smbList", smbTypSearchVO.getSmbList());
		model.addAttribute("smbDocFormList", smbTypSearchVO.getSmbDocFormList());
		
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, result.getPbancrcCtgryFrstCd()));		//사업구분
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("sprtSttsCdList", getCodeListByGrpCd(EnumGrpCd.SPRT_STTS_CD));						//지원상태코드
		
	}

	/**
	 * 각 지원신청시 선처리
	 */
	public void prevWrite(
			KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		log.debug("qqqqqqqqqqqqqqqq");
		//접수 상태 확인
		KoreahanaPbaVO pbaVO = koreahanaPbaService.selectKoreahanaPba(searchVO);
		if(!isSprtWriteable(pbaVO)) throwBizException("exts.item.koreahana.spr.notAccessMbr");
		log.debug("bbbbbbbbbbbbbb");
		model.addAttribute(ATTR_PBA_VO, pbaVO);
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, pbaVO.getPbancrcCtgryFrstCd()));		//사업구분
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("today", new Date());
		
		
		//중복접수 체크
		KoreahanaSprVO sprVO = new KoreahanaSprVO();
		searchVO.setRgtrId(getLoginId());
		searchVO.setRecordCountPerPage(0);
		List<KoreahanaSprVO> sprtList = koreahanaSprUserService.selectKoreahanaSprList(searchVO);
		if(sprtList != null && sprtList.size() > 0) {
			sprVO = sprtList.get(0);
		}
		
		if(!koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO)) throwBizException("exts.item.koreahana.pba.notAccessStts");
		
		if(sprVO != null && !"".equals(NullUtil.nullString(sprVO.getSprtSn())) && !KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) && !KoreahanaEnumSprtSttsCd.UND.getCode().equals(sprVO.getSprtSttsCd())) {
			throwBizException("exts.item.koreahana.pba.duplication");
		}
		
		setSprtInfoBySession(sprVO);		//회원정보 셋팅.
		model.addAttribute(ATTR_SPR_VO, sprVO);

		//제출서류+제출서류서식
		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
		smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
		List<KoreahanaSmbTypVO> smbTypeList = koreahanaSmbTypService.selectKoreahanaSmbTypListAll(smbTypSearchVO);
		model.addAttribute("smbTypList", smbTypeList);
		model.addAttribute("smbListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbList()));
		model.addAttribute("smbDocFormListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbDocFormList()));
		model.addAttribute("isAllowSprtStts", koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO));
	}


	/**
	 * 각 지원 수정시 선처리(마이페이지에서)
	 */
//	public void prevModify(
//			KoreahanaSprVO searchVO,
//			HttpServletRequest request,
//			ModelMap model) throws Exception{
//
//		KoreahanaPbaVO pbaVO = koreahanaPbaService.selectKoreahanaPba(searchVO);
//		model.addAttribute(ATTR_PBA_VO, pbaVO);
//		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));						//사업구분
//		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
//		model.addAttribute("today", new Date());
//
//		KoreahanaSprVO sprVO = new KoreahanaSprVO();
//		searchVO.setRgtrId(getLoginId());
//		searchVO.setRecordCountPerPage(0);
//		List<KoreahanaSprVO> sprtList = koreahanaSprUserService.selectKoreahanaSprList(searchVO);
//		if(sprtList != null && sprtList.size() > 0) {
//			sprVO = sprtList.get(0);
//			if(!koreahanaSprUserService.isModifiable(sprVO))throwBizException("com.error.noauth.modify");
//		}else {
//			throwBizException("com.error.nodata");
//		}
//
//		if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd()) && !KoreahanaEnumSprtSttsCd.UND.getCode().equals(sprVO.getSprtSttsCd())) {
//			throwBizException("exts.item.koreahana.pba.duplication");
//		}
//		
//		model.addAttribute(ATTR_SPR_VO, sprVO);
//		
//
//		//제출서류+제출서류서식
//		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
//		smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
//		koreahanaSmbTypService.selectKoreahanaSmbTypListAll(smbTypSearchVO);
//		model.addAttribute("smbListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbList()));
//		model.addAttribute("smbDocFormListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbDocFormList()));
//		
//		model.addAttribute("isAllowSprtStts", koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO));
//	}


	/**
	 * 각 지원신청 처리시 선처리
	 */
	public void prevWriteAction(
			KoreahanaSprVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		//접수 상태 확인
		KoreahanaPbaVO pbaVO = koreahanaPbaService.selectKoreahanaPba(searchVO);
		searchVO.setBizSeCd(pbaVO.getBizSeCd());
		KoreahanaSprVO sprVO = null;
		if(NullUtil.nullString(searchVO.getSprtSn()).equals("")) {
			if(!isSprtWriteable(pbaVO)) throwBizException("exts.item.koreahana.spr.notAccessMbr");
			//신청시에는 공고상태체크(최초 추가시)
			if(!koreahanaPbaService.isAllowSprtStts(pbaVO, null)) throwBizException("exts.item.koreahana.pba.notAccessStts");
			//화상영어는 화면에서 입력됨, 나머지는 세션에서 가져와서 셋팅
			if(!KoreahanaEnumCtgryFrstCd.VDO.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
				setSprtInfoBySession(searchVO);
			}
			
			//등록 완료 후 뒤로가기를 통해서 다시 등록할때 중복 접수를 막기위함
			KoreahanaSprVO dupSearchVO = new KoreahanaSprVO();
			dupSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
			dupSearchVO.setRgtrId(getLoginId());
			int dupCnt = koreahanaSprUserService.selectKoreahanaSprTot(dupSearchVO);		//해당 모집공고에 중복으로 등록한 사람인지 체크 
			if(dupCnt > 0) throwBizException("exts.item.koreahana.pba.duplication");
		}else {
			//신청시에는 공고상태체크(수정시)
			sprVO = koreahanaSprUserService.selectKoreahanaSpr(searchVO);
			if(!koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO)) throwBizException("exts.item.koreahana.pba.notAccessStts");
		}
		//제출서류유형
		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
		smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
		
		List<KoreahanaSmbTypVO> smbTypList = null;
		if(KoreahanaEnumCtgryFrstCd.SHO.getCode().equals(searchVO.getPbancrcCtgryFrstCd())) {
			//장학금의 경우 장학금 유형에 맞는것만 조회 후 비교
			List<String> smbsnDocTypeVlList = new ArrayList<String>();
			smbsnDocTypeVlList.add(searchVO.getSholSlctnTypeValue());
			smbTypSearchVO.setSmbsnDocTypeVlList(smbsnDocTypeVlList);
			smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypSearchVO);
			searchVO.setSmbTypList(smbTypList);
		}else {
			smbTypList = koreahanaSmbTypService.selectKoreahanaSmbTypList(smbTypSearchVO);
			searchVO.setSmbTypList(smbTypList);
		}
		
		
		//임시저장일 때는 임시저장테이블에 저장하고 bizexception 처리를 하여  controller에서 예외처리 
		if("Y".equals(searchVO.getTmpSaveYn())) {
			//제출서류 처리
//			koreahanaSprUserService.getParamToSmbMpnProc(searchVO, request, true);	//파라미터로 넘어온 제출서류 처리(임시저장)
			searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.TMP.getCode());
		}else {
			//임시저장 상태에서 신청시 상태값을 서류미비 상태로 설정해서 지원값을 수정할때 서류미비시 제출완료 상태로 변경하는 로직 활용
			if(sprVO != null) {
				if(KoreahanaEnumSprtSttsCd.TMP.getCode().equals(sprVO.getSprtSttsCd())) {
					searchVO.setSprtSttsCd(KoreahanaEnumSprtSttsCd.UND.getCode());
				}else {
					searchVO.setSprtSttsCd(sprVO.getSprtSttsCd());
				}
			}
		}
		
		koreahanaSprValidator.validate(searchVO, errors);
		if(errors.hasErrors())throw new ValidatorException("");
	}



	/**
	 * 제출서류 파일 다운로드
	 * @param searchVO
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	protected void fileDownload(
			@ModelAttribute("searchVO")	KoreahanaSprVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		
		ComAtchFileVO result = comAtchFileUserService.selectComAtchFileSpr(searchVO);
		
		if(result != null && comAtchFileUserService.isViewable(result)) {
			comAtchFileUserService.myFileDownload(result, request, response);
		}else {
			throwBizException("exts.item.koreahana.spr.notAccessFile");
		}
	}
	
	/**
	 * 지원별 별도로 등록된 첨부파일 다운로드(국민기초생활수급확인서, 북한이탈주민확인서)
	 * @param atchFileSn
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void sprtFileDonwload(String atchFileSn, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(atchFileSn);
		ComAtchFileVO atchFile = comAtchFileUserService.selectComAtchFile(atchFileSearchVO);
		comAtchFileUserService.myFileDownload(atchFile, request, response);
	}
	
	/**
	 * 이미지 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	protected void imageView(
			HttpServletRequest request, 
			HttpServletResponse response, 
			String atchFileSn) throws Exception{
		
		comAtchFileUserService.imageView(request, response, atchFileSn);
	}
	
	/**
	 * 세션정보로 지원자정보 셋팅
	 * @param searchVO
	 */
	protected void setSprtInfoBySession(KoreahanaSprVO searchVO) throws EgovBizException {
		
		//최초 신청시 회원추가정보에서 셋팅
		ComMbrVO comMbrVO = (ComMbrVO)SessionUtil.getAttribute(ComMbrService.SESSION_ADT_VO);
		if(comMbrVO == null) throwBizException("exts.item.koreahana.spr.notExistMbrAdtifm");
		searchVO.setFlnm(getLoginVO().getMbrNm());											//성명
		searchVO.setGenderCd(comMbrVO.getGenderCd());										//성별
		searchVO.setBrdtYmd(JnitTag.convertDateSplitString(comMbrVO.getBrdtYmd(), "-"));	//생년월일
		searchVO.setMbphno(comMbrVO.getMbphno());											//휴대폰번호
		searchVO.setZip(comMbrVO.getZip());						//우편번호
		searchVO.setAddr(comMbrVO.getAddr());						//주소
		searchVO.setDaddr(comMbrVO.getDaddr());		
		
	}
	
	/**
	 * 임시저장 데이터를 조회하고 model에 값을 설정
	 * @param result
	 * @param model
	 * @throws IOException
	 */
	protected void setModelTmpData(KoreahanaEnumCtgryFrstCd enumCtgryFrstCd, KoreahanaSprVO result, ModelMap model) throws IOException {
		if(result == null) return;
		if(!KoreahanaEnumSprtSttsCd.TMP.getCode().equals(result.getSprtSttsCd())) return;
		
		KoreahanaSprVO sprTmpVO = null;
		if(KoreahanaEnumCtgryFrstCd.ADT == enumCtgryFrstCd) {	//가산금
			KoreahanaAdtVO adtVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaAdtVO.class);
			sprTmpVO = (KoreahanaAdtVO) adtVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			
			if(sprTmpVO != null) {
				//가족관계
				model.addAttribute("famListJson", JsonUtil.convertObjectToJson(adtVO.getAdtFamList()));
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(adtVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(adtVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
			}
		}else if(KoreahanaEnumCtgryFrstCd.SHO == enumCtgryFrstCd) {
			KoreahanaShoVO shoVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaShoVO.class);
			sprTmpVO = (KoreahanaShoVO) shoVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				//북한이탈주민 인증서파일
				if(!"".equals(NullUtil.nullString(shoVO.getNtkrdfAcrtfctFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(shoVO.getNtkrdfAcrtfctFileSn());
					model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(shoVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(shoVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
			}
		}else if(KoreahanaEnumCtgryFrstCd.EDU == enumCtgryFrstCd) {
			KoreahanaEduVO eduVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaEduVO.class);
			sprTmpVO = (KoreahanaEduVO) eduVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(eduVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(eduVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
			}
		}else if(KoreahanaEnumCtgryFrstCd.VDO == enumCtgryFrstCd) {
			KoreahanaVdoVO vdoVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaVdoVO.class);
			sprTmpVO = (KoreahanaVdoVO) vdoVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				//국민기초생활수급확인서
				if(!"".equals(NullUtil.nullString(vdoVO.getRcoblSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(vdoVO.getRcoblSgntFileSn());
					model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
				
				//북한이탈주민 인증서
				if(!"".equals(NullUtil.nullString(vdoVO.getNtkrdfAcrtfctFileSn()))) {
					ComAtchFileVO ntkrdfAcrtfctFileVO = new ComAtchFileVO();
					ntkrdfAcrtfctFileVO.setAtchFileSn(vdoVO.getNtkrdfAcrtfctFileSn());
					model.addAttribute("ntkrdfAcrtfctFile", comAtchFileUserService.selectComAtchFile(ntkrdfAcrtfctFileVO));
				}
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(vdoVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(vdoVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
				
				//등록된 보호자 서명
				if(!"".equals(NullUtil.nullString(vdoVO.getPrtcrSgntFileSn()))) {
					ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
					atchFileSearchPrtcrVO.setAtchFileSn(vdoVO.getPrtcrSgntFileSn());
					model.addAttribute("prtcrSgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchPrtcrVO));
				}
			}
		}else if(KoreahanaEnumCtgryFrstCd.LNB == enumCtgryFrstCd) {
			KoreahanaLnbVO lnbVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaLnbVO.class);
			sprTmpVO = (KoreahanaLnbVO) lnbVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				
				//국민기초생활수급확인서
				if(!"".equals(NullUtil.nullString(lnbVO.getRcoblSgntFileSn()))) {
					ComAtchFileVO rcoblSgntFileVO = new ComAtchFileVO();
					rcoblSgntFileVO.setAtchFileSn(lnbVO.getRcoblSgntFileSn());
					model.addAttribute("rcoblSgntFile", comAtchFileUserService.selectComAtchFile(rcoblSgntFileVO));
				}
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(lnbVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(lnbVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
				
				//등록된 보호자 서명
				if(!"".equals(NullUtil.nullString(lnbVO.getPrtcrSgntFileSn()))) {
					ComAtchFileVO atchFileSearchPrtcrVO = new ComAtchFileVO();
					atchFileSearchPrtcrVO.setAtchFileSn(lnbVO.getPrtcrSgntFileSn());
					model.addAttribute("prtcrSgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchPrtcrVO));
				}
				
				//학습지지원기본정보
				List<KoreahanaLnbPrcVO> lnbSprtInfoList = lnbVO.getLnbPrcList();
				if(lnbSprtInfoList != null && lnbSprtInfoList.size() > 0) {
					List<String> ntkrdfAcrtfctFileSnList = new ArrayList<String>();
					for(KoreahanaLnbPrcVO lnbPrcVO : lnbSprtInfoList) {
						ntkrdfAcrtfctFileSnList.add(lnbPrcVO.getNtkrdfAcrtfctFileSn());
					}
					
					if(ntkrdfAcrtfctFileSnList.size() > 0) {
						ComAtchFileVO ntkrdfAcrtfctFileSearchVO = new ComAtchFileVO();
						ntkrdfAcrtfctFileSearchVO.setAtchFileSnList(ntkrdfAcrtfctFileSnList);
						model.addAttribute("ntkrdfAcrtfctFileList", comAtchFileUserService.selectComAtchFileList(ntkrdfAcrtfctFileSearchVO));
					}
				}
				KoreahanaLnbPrcVO lnbPrcSearchVO = new KoreahanaLnbPrcVO();
				lnbPrcSearchVO.setSprtSn(result.getSprtSn());
				model.addAttribute("lnbSprtInfoList", lnbSprtInfoList);
				
			}
		}else if(KoreahanaEnumCtgryFrstCd.SPF == enumCtgryFrstCd) {
			KoreahanaSpfVO spfVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaSpfVO.class);
			sprTmpVO = (KoreahanaSpfVO) spfVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				
				//사진
				if(!"".equals(NullUtil.nullString(spfVO.getPhotoFileSn()))) {
					ComAtchFileVO photoFileVO = new ComAtchFileVO();
					photoFileVO.setAtchFileSn(spfVO.getPhotoFileSn());
					model.addAttribute("photoFile", comAtchFileUserService.selectComAtchFile(photoFileVO));
				}
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(spfVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(spfVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
			}
		}else if(KoreahanaEnumCtgryFrstCd.EMP == enumCtgryFrstCd) {
			KoreahanaEmpVO empVO = JsonUtil.convertJsonToObject(result.getTmprStrgData(), KoreahanaEmpVO.class);
			sprTmpVO = (KoreahanaEmpVO) empVO;
			sprTmpVO.setSprtSn(result.getSprtSn());
			
			if(sprTmpVO != null) {
				
				//취업연계직업훈련자격사항
				model.addAttribute("empQlfListJson", JsonUtil.convertObjectToJson(empVO.getEmpQlfList()));
				
				//서명파일 임시저장데이터로 첨부파일 테이블 조회
				if(!"".equals(NullUtil.nullString(empVO.getSgntFileSn()))) {
					ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
					atchFileSearchVO.setAtchFileSn(empVO.getSgntFileSn());
					model.addAttribute("sgnResult", comAtchFileUserService.selectComAtchFile(atchFileSearchVO));
				}
			}
		}
		
		//제출서류에 등록한 첨부파일
		/*
		if(sprTmpVO != null) {
			sprTmpVO.setSprtSttsCd(result.getSprtSttsCd());
			
			List<String> atchFileSnList = new ArrayList<String>();
			if(sprTmpVO.getSmbMpnList() != null) {
				for(KoreahanaSmbMpnVO tmpAdtSmbMpnVO : sprTmpVO.getSmbMpnList()) {
					atchFileSnList.add(tmpAdtSmbMpnVO.getAtchFileSn());
				}
			}
			
			if(atchFileSnList != null && atchFileSnList.size() > 0) {
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSnList(atchFileSnList);
				List<ComAtchFileVO> atchFileList = comAtchFileUserService.selectComAtchFileList(atchFileSearchVO);
				for(KoreahanaSmbMpnVO tmpAdtSmbMpnVO : sprTmpVO.getSmbMpnList()) {
					for(ComAtchFileVO atchFileVO : atchFileList) {
						if(tmpAdtSmbMpnVO.getAtchFileSn().equals(atchFileVO.getAtchFileSn())) {
							String smbsnDocSn = tmpAdtSmbMpnVO.getSmbsnDocSn();
							BeanUtils.copyProperties(atchFileVO, tmpAdtSmbMpnVO);
							tmpAdtSmbMpnVO.setSmbsnDocSn(smbsnDocSn);
						}
					}
				}
				model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(sprTmpVO.getSmbMpnList()));
			}
		}
		*/
		
		//제출서류(등록한 첨부파일)
		KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
		smbMpnSearchVO.setSprtSn(result.getSprtSn());
		model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO)));
		
		sprTmpVO.setNtkrdfUnqNo(result.getNtkrdfUnqNo());		//임시저장시 보여줘야할 북한이탈주민정보 셋팅
		sprTmpVO.setEntcnyYmd(result.getEntcnyYmd());
		sprTmpVO.setPrtdcsYmd(result.getPrtdcsYmd());
		sprTmpVO.setHanawonFnshYmd(result.getHanawonFnshYmd());
		sprTmpVO.setHanawonTh(result.getHanawonTh());
		model.addAttribute("result", sprTmpVO);
			
	}
	
	/**
	 * result에 제출서류 첨부파일 매핑 셋팅
	 * @param result
	 */
	protected void setSmbMpnList(KoreahanaSprVO result) {

		//제출서류(등록한 첨부파일)
		KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
		smbMpnSearchVO.setSprtSn(result.getSprtSn());
		result.setSmbMpnList(koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO));
		
	}
	
	/**
	 * 지원신청에서 사용하는 추가/수정 권한
	 * @param result
	 */
	protected boolean isSprtWriteable(KoreahanaPbaVO pbaVO) {
		
		//가산금 + 취업연계직업휸련 탈북민만 지원가능
		if(KoreahanaEnumCtgryFrstCd.ADT.getCode().equals(pbaVO.getPbancrcCtgryFrstCd())
				|| KoreahanaEnumCtgryFrstCd.EDU.getCode().equals(pbaVO.getPbancrcCtgryFrstCd())
				|| KoreahanaEnumCtgryFrstCd.EMP.getCode().equals(pbaVO.getPbancrcCtgryFrstCd())) {
			
			return isNtkrdf();
		}
		
		return true;
	}
}
