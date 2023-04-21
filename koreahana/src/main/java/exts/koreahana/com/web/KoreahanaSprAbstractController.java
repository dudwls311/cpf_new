/**
 * @version 3.2.0.1
 */
package exts.koreahana.com.web;

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

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumGrpCd;
import exts.com.service.ComAtchFileService;
import exts.com.util.FileMngUtil;
import exts.com.util.JsonUtil;
import exts.com.vo.ComAtchFileVO;
import exts.com.web.ExtsAbstractController;
import exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd;
import exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.sgn.service.KoreahanaSgnService;
import exts.koreahana.smb.service.KoreahanaSmbMpnService;
import exts.koreahana.smb.service.KoreahanaSmbService;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.spr.service.KoreahanaSprService;
import exts.koreahana.spr.validator.KoreahanaSprValidator;
import exts.koreahana.spr.vo.KoreahanaSprVO;
import jnit.crypto.JnitCryptoService;

/**
 *  Koreahana 지원신청 Abstract 컨트롤러 클래스
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

public abstract class KoreahanaSprAbstractController extends ExtsAbstractController {

	public static final String ATTR_PBA_VO = "pbaVO";//model에 setAttribute한 선택된 공고정보 VO
	public static final String ATTR_SPR_VO = "sprVO";//model에 setAttribute한 선택된 신청정보 VO

	@Resource(name = "koreahanaPbaService")
	protected KoreahanaPbaService koreahanaPbaService;
	
	@Resource(name = "koreahanaSprService")
	protected KoreahanaSprService koreahanaSprService;

	@Resource(name = "koreahanaSmbMpnService")
	protected KoreahanaSmbMpnService koreahanaSmbMpnService;

	@Resource(name = "koreahanaSmbTypService")
	protected KoreahanaSmbTypService koreahanaSmbTypService;

	@Resource(name = "comAtchFileService")
	protected ComAtchFileService comAtchFileService;
	
	@Resource(name = "koreahanaSprValidator")
	protected KoreahanaSprValidator koreahanaSprValidator;
	
	@Resource(name = "koreahanaSmbService")
	protected KoreahanaSmbService koreahanaSmbService;
	
	@Resource(name = "koreahanaSgnService")
	protected KoreahanaSgnService koreahanaSgnService;

	/** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    protected JnitCryptoService jnitCryptoService;
	
	/**
	 * 목록페이지에서 필요한 내용 공통처리
	 */
	public void prevList(
			KoreahanaEnumCtgryFrstCd ctgryFrstCd,
			KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//상담사 권한일 경우 공개만 나오게
		if(isCenterStaff()) searchVO.setRlsYn("Y");
		prevPrcList(ctgryFrstCd, searchVO, request, model);
		
		//목록에서 보이지 않을 상태값 설정
		if(!searchVO.getPbancrcCtgryFrstCd().equals(KoreahanaEnumCtgryFrstCd.ADT.getCode())) {
		List<String> notInsprtSttsCdList = new ArrayList<String>();
		log.debug("searchVO"+searchVO);
		log.debug("request"+request);
		notInsprtSttsCdList.add(KoreahanaEnumSprtSttsCd.TMP.getCode());
		searchVO.setNotInsprtSttsCdList(notInsprtSttsCdList);
		}
		
		model.addAttribute("sprtSttsList", koreahanaSprService.selectKoreahanaSprListGroupBySprtSttsCd(searchVO));				//지원상태 수
		
	}

	/**
	 * 지원현황 목록페이지에서 필요한 내용 공통처리
	 */
	public void prevPrcList(
			KoreahanaEnumCtgryFrstCd ctgryFrstCd,
			KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		//카테고리 셋팅
		searchVO.setPbancrcCtgryFrstCd(ctgryFrstCd.getCode());
		
		//공고리스트
		KoreahanaPbaVO pbaVO = new KoreahanaPbaVO();
		pbaVO.setPbancrcCtgryFrstCd(ctgryFrstCd.getCode());
		//상담사 권한일 경우 공개만 나오게
		if(isCenterStaff()) pbaVO.setRlsYn("Y");
		pbaVO.setRecordCountPerPage(0);
		List<KoreahanaPbaVO> pbaList = koreahanaPbaService.selectKoreahanaPbaList(pbaVO);
		model.addAttribute("pbaList", pbaList);
		if(NullUtil.nullString(searchVO.getPbancrcSn()).equals(""))searchVO.setPbancrcSn((pbaList != null && pbaList.size() > 0)?pbaList.get(0).getPbancrcSn():"0");
		
		
		
		model.addAttribute("regDtYrList", koreahanaSprService.selectKoreahanaSprListGroupByRegDtYr(searchVO));					//신청연도 전체

		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));				//공고상태
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, searchVO.getPbancrcCtgryFrstCd()));		//모집공고 - 사업구분
		model.addAttribute("sprtSttsCdList", getCodeListByGrpCd(EnumGrpCd.SPRT_STTS_CD));						//지원상태코드
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));						//성별코드
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
	 * 추가/수정에서 필요한 내용 공통처리
	 */
	public void prevWrite(
			KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		//접수 상태 확인
		KoreahanaPbaVO pbaVO = koreahanaPbaService.selectKoreahanaPba(searchVO);
		model.addAttribute(ATTR_PBA_VO, pbaVO);
		model.addAttribute("isAllowSprtStts", koreahanaPbaService.isAllowSprtStts(pbaVO, null));
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD, pbaVO.getPbancrcCtgryFrstCd()));		//사업구분
		model.addAttribute("genderCdList", getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("frontOfPhone", getFrontOfPhone());
		model.addAttribute("today", new Date());
		
		//제출서류+제출서류서식
		KoreahanaSmbTypVO smbTypSearchVO = new KoreahanaSmbTypVO();
		smbTypSearchVO.setPbancrcSn(searchVO.getPbancrcSn());
		List<KoreahanaSmbTypVO> smbTypeList = koreahanaSmbTypService.selectKoreahanaSmbTypListAll(smbTypSearchVO);
		model.addAttribute("smbTypList", smbTypeList);
		model.addAttribute("smbListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbList()));
		model.addAttribute("smbDocFormListJson", JsonUtil.convertObjectToJson(smbTypSearchVO.getSmbDocFormList()));
	
		if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
			KoreahanaSmbMpnVO smbMpnSearchVO = new KoreahanaSmbMpnVO();
			smbMpnSearchVO.setSprtSn(searchVO.getSprtSn());
			List<KoreahanaSmbMpnVO> smbMpnList = koreahanaSmbMpnService.selectKoreahanaSmbMpnList(smbMpnSearchVO);
			
			//제출서류에 등록한 첨부파일
			if(smbMpnList != null && smbMpnList.size() > 0) {
				List<String> atchFileSnList = new ArrayList<String>();
				for(KoreahanaSmbMpnVO tmpAdtSmbMpnVO : smbMpnList) {
					atchFileSnList.add(tmpAdtSmbMpnVO.getAtchFileSn());
				}
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSnList(atchFileSnList);
				List<ComAtchFileVO> atchFileList = comAtchFileService.selectComAtchFileList(atchFileSearchVO);
				for(KoreahanaSmbMpnVO tmpAdtSmbMpnVO : smbMpnList) {
					for(ComAtchFileVO atchFileVO : atchFileList) {
						if(tmpAdtSmbMpnVO.getAtchFileSn().equals(atchFileVO.getAtchFileSn())) {
							String smbsnDocSn = tmpAdtSmbMpnVO.getSmbsnDocSn();
							BeanUtils.copyProperties(atchFileVO, tmpAdtSmbMpnVO);
							tmpAdtSmbMpnVO.setSmbsnDocSn(smbsnDocSn);
						}
					}
				}
				model.addAttribute("smbMpnListJson", JsonUtil.convertObjectToJson(smbMpnList));
			}
		}
	}
	

	/**
	 * 각 지원신청 처리시 선처리
	 */
	public void prevWriteAction(
			KoreahanaSprVO searchVO,
			BindingResult errors,
			HttpServletRequest request,
			ModelMap model) throws Exception{

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
		
		koreahanaSprValidator.validate(searchVO, errors);
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
		
		ComAtchFileVO result = comAtchFileService.selectComAtchFileSpr(searchVO);
		if(result != null && comAtchFileService.isViewable(result)) {
			comAtchFileService.myFileDrmDownload(result, request, response);
		}else {
			throwBizException("exts.item.koreahana.spr.notAccessFile");
		}
	}
	
	/**
	 * 이미지 View
	 * @param searchVO
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	protected void imageView(
			HttpServletRequest request, 
			HttpServletResponse response, 
			String enc) throws Exception{
		
		String dec = jnitCryptoService.decryptNoneEncodingParameter(enc);
		String[] decArr = dec.split("\\|\\|");
		if(decArr != null && decArr.length == 2) {
			//지원신청에 등록된 이미지일때
			String atchFileSn = decArr[0];
			String sprtSn = decArr[1];
			
			KoreahanaSprVO searchVO = new KoreahanaSprVO();
			searchVO.setSprtSn(sprtSn);
			KoreahanaSprVO result = koreahanaSprService.selectKoreahanaSpr(searchVO);
			if(result != null && koreahanaSprService.isViewable(result)) {
				comAtchFileService.imageView(request, response, atchFileSn);
			}else {
				throwBizException("exts.item.koreahana.spr.notAccessImgFile");
			}
		}else if(decArr != null && decArr.length == 1) {
			String atchFileSn = decArr[0];
			//지원신청이 등록되기 전 이미지일때
			comAtchFileService.imageView(request, response, atchFileSn);
		}else {
			throwBizException("exts.item.koreahana.spr.notAccessImgFile");
		}
	}
	
	/**
	 * 서명 View
	 * @param request
	 * @param response
	 * @param enc
	 * @throws Exception
	 */
	protected void signView(
			HttpServletRequest request,
			HttpServletResponse response,
			String enc) throws Exception{
		throwDirect(request);
		
		String dec = jnitCryptoService.decryptNoneEncodingParameter(enc);
		String[] encArr = dec.split("\\|\\|");
		if(encArr != null && encArr.length == 2) {
			String atchFileSn = encArr[0];
			String sprtSn = encArr[1];
			
			KoreahanaSprVO sprVO = new KoreahanaSprVO();
			sprVO.setSprtSn(sprtSn);
			sprVO = koreahanaSprService.selectKoreahanaSpr(sprVO);
			if(!koreahanaSprService.isViewable(sprVO)) throwBizException("com.error.noauth.view");
			
			ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
			atchFileSearchVO.setAtchFileSn(atchFileSn);
			ComAtchFileVO atchFileVO = comAtchFileService.selectComAtchFile(atchFileSearchVO);
			if(atchFileVO != null) {
				FileMngUtil.showFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), Globals.UPLOAD_PATH);
			}else {
				throwBizException("com.error.nodata");
			}
		}else {
			//관리자가 지원신청 최초 글 등록시
			if(dec != null) {
				String atchFileSn = dec;
				ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
				atchFileSearchVO.setAtchFileSn(atchFileSn);
				ComAtchFileVO atchFileVO = comAtchFileService.selectComAtchFile(atchFileSearchVO);
				if(atchFileVO != null && comAtchFileService.isViewable(atchFileVO) ) {
					FileMngUtil.showFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), Globals.UPLOAD_PATH);
				}else {
					throwBizException("com.error.nodata");
				}
			}
		}
	}
	
	/**
	 * 선정결과 변경
	 * @param searchVO
	 * @param request
	 * @throws EgovBizException
	 */
	protected String updateKoreahanaSprStts(KoreahanaSprVO searchVO, HttpServletRequest request, ModelMap model) throws EgovBizException {
		
		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaSprService.updateKoreahanaSprStts(searchVO, request.getParameterValues("sprtSnArr"));
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}
		
		return getResponseJsonView(model, isSuccess, msg);
	}
	
	/**
	 * 선정사유 변경 팝업창
	 */
	protected String writeRsnPageJson(
			KoreahanaSprVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		throwDirect(request);

		model.addAttribute("result", koreahanaSprService.selectKoreahanaSpr(searchVO));
		return "exts/koreahana/spr/sprRsnAjax";
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
		ComAtchFileVO atchFile = comAtchFileService.selectComAtchFile(atchFileSearchVO);
		comAtchFileService.myFileDownload(atchFile, request, response);
	}
	
	/**
	 * 센터직원 지원 권한체크 
	 * @param searchVO
	 * @throws EgovBizException
	 */
	protected void centerStaffAllowSprtSttsChk(KoreahanaSprVO searchVO) throws EgovBizException {
		if(!isCenterStaff()) return;
		
		if(!"".equals(NullUtil.nullString(searchVO.getPbancrcSn()))) {
			KoreahanaPbaVO pbaVO = new KoreahanaPbaVO();
			pbaVO.setPbancrcSn(searchVO.getPbancrcSn());
			pbaVO = koreahanaPbaService.selectKoreahanaPba(pbaVO);
			
			KoreahanaSprVO sprVO = null;
			if(!"".equals(NullUtil.nullString(searchVO.getSprtSn()))) {
				sprVO = new KoreahanaSprVO();
				sprVO.setSprtSn(searchVO.getSprtSn());
				sprVO = koreahanaSprService.selectKoreahanaSpr(sprVO);
			}
			if(!koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO)) throwBizException("exts.item.koreahana.pba.notAccessStts");
		}else {
			throwBizException("exts.item.koreahana.pba.notAccessStts");
		}
	}
	
	/**
	 * 센터직원 지원 권한체크
	 * @param sprVO
	 * @throws EgovBizException
	 */
	protected void centerStaffAllowSprtSttsChk(KoreahanaPbaVO pbaVO, KoreahanaSprVO sprVO) throws EgovBizException {
		if(!isCenterStaff()) return;
		
		if(pbaVO != null) {
			if(!koreahanaPbaService.isAllowSprtStts(pbaVO, sprVO)) throwBizException("exts.item.koreahana.pba.notAccessStts");
		}else {
			throwBizException("exts.item.koreahana.pba.notAccessStts");
		}
	}
}
