package exts.koreahana.com.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.EgovFormBasedFileVo;
import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.com.service.ComMbrService;
import exts.com.util.ComFileUploadUtil;
import exts.com.util.FileMngUtil;
import exts.com.vo.ComCodeVO;
import exts.com.vo.ComLoginMenuVO;
import exts.koreahana.emp.vo.KoreahanaEmpPrcVO;
import exts.koreahana.pba.service.KoreahanaPbaService;
import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.spb.service.KoreahanaSpbService;
import jnit.crypto.JnitCryptoService;


/**
 * @Class Name : KoreahanaComController.java
 * @Description : 관리자공통 처리용 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.13
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaComController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/com";}

	@Resource(name = "koreahanaSpbService")
	private KoreahanaSpbService koreahanaSpbService;

	@Resource(name = "koreahanaPbaService")
	private KoreahanaPbaService koreahanaPbaService;

    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	/**
	 * 관리자메인
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/exts/koreahana/com/main.do")
	public String main(
			HttpServletRequest request,
			ModelMap model) throws Exception{
		setIndexProcess(EnumMenuCd.MAIN, request, "");				//분기공통처리

		KoreahanaPbaVO pbaVO = new KoreahanaEmpPrcVO();
		pbaVO.setRlsYn("Y");
		pbaVO.setPageUnit(12);
		pbaVO.setPageSize(10);
		pbaVO.setPageIndex(NullUtil.nullInt(request.getParameter("pageIndex")));
		
		//모집중인 공고만 조회하도록 설정
		List<String> pbancrcSttsCdList = new ArrayList<String>();
		pbancrcSttsCdList.add("12002");		//상시
		pbancrcSttsCdList.add("12005");		//신청하기
		pbaVO.setPbancrcSttsCdList(pbancrcSttsCdList);
		
		if(pbaVO.getPageIndex() == 0)pbaVO.setPageIndex(1);
	
		//총갯수
		int totalRecordCount = koreahanaPbaService.selectKoreahanaPbaTot(pbaVO);

    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pbaVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(pbaVO.getPageUnit());
		paginationInfo.setPageSize(pbaVO.getPageSize());
    	paginationInfo.setTotalRecordCount(totalRecordCount);
		
    	pbaVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
    	pbaVO.setLastIndex(paginationInfo.getLastRecordIndex());
    	pbaVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		
		model.addAttribute("pbaList",koreahanaPbaService.selectKoreahanaPbaList(pbaVO));
		model.addAttribute("paginationInfo",paginationInfo);

		model.addAttribute("pbancrcSttsCdList", getCodeListByGrpCd(EnumGrpCd.PBANCRC_STTS_CD));			//공고상태
		model.addAttribute("bizSeCdList", getCodeListByGrpCd(EnumGrpCd.BIZ_SE_CD));						//사업구분
		
		List<ComLoginMenuVO> lmenuList = (List<ComLoginMenuVO>)SessionUtil.getAttribute(ComMbrService.SESSION_LMENU_LIST);
		if(lmenuList != null) {
			for(ComLoginMenuVO lmenu:lmenuList){
				if(EnumMenuCd.PBA.getMenuSn().equals(lmenu.getMenuSn())) {		//정작지원사업 공고 관리 권한
					model.addAttribute("pbaMenuAuth", lmenu.isRedngAuth());
				}
				if(EnumMenuCd.SPR.getMenuSn().equals(lmenu.getMenuSn())) {		//정작지원사업 지원대상 관리 권한
					model.addAttribute("sprMenuAuth", lmenu.isRedngAuth());
				}
				if(EnumMenuCd.SPH.getMenuSn().equals(lmenu.getMenuSn())) {		//지원이력조회 권한
					model.addAttribute("sphMenuAuth", lmenu.isRedngAuth());
				}
			}
		}
		
		return "exts/koreahana/com/main";
	}
	 

	/**
	 * 사용자 메인 지원사업 검색 결과
	 */
	@RequestMapping(value="/user/exts/koreahana/com/spbSearchActionJson.do")
	public String spbSearchActionJson(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		List<String> resultList = null;
		
		EgovMap egovMap = new EgovMap();
		List<ComCodeVO> spbCdList = getCodeListByGrpCd(EnumGrpCd.SPB_CD);
		
		
		String[] cd1Vals = request.getParameterValues("cd1Vals");//1차카테고리
		String[] stngCds = request.getParameterValues("stngCds");//조건들
		//1차 카테고리 비교
		if(cd1Vals != null && stngCds != null) {
			List<String> ctgryFrstCds = new ArrayList<String>();
			for(int i = 0; i < cd1Vals.length; i++) {
				for(ComCodeVO code:spbCdList) {
					if(cd1Vals[i].equals(code.getIndivCdVlFrst())) {
						ctgryFrstCds.add(code.getIndivCd());
					}
				}
			}
			egovMap.put("ctgryFrstCds", ctgryFrstCds);
			egovMap.put("stngCds", stngCds);
			resultList = koreahanaSpbService.selectKoreahanaSpbSearch(egovMap);
		}
		
		
		return getResponseJsonView(model, resultList);
	}
	 



	/**
	 * 에디터 이미지 업로드
	 */
	@RequestMapping(value="/exts/koreahana/com/imageUploadPopup.do")
	public String imageUploadPopup(
			HttpServletRequest request,
			ModelMap model) throws Exception{

				
		return "exts/koreahana/com/imageUploadPopup";
	}
	

	/**
	 * 에디터 이미지 업로드 처리
	 */
	@RequestMapping(value="/exts/koreahana/com/imageUploadPopupAction.do")
	public String imageUploadPopupAction(
			HttpServletRequest request,
			ModelMap model) throws Exception{


		boolean isSuccess = false;
		String msg = "";
		try {
			if(!isMbrLevelStaff())throwBizException("com.error.noauth");
	
			List<EgovFormBasedFileVo> fileList = ComFileUploadUtil.uploadFormFiles(request, "imgFile", "editorImage", null, new String[] {"png","jpeg","jpg","bmp","gif"});
			if(fileList != null) {
				for(EgovFormBasedFileVo fvo : fileList) {
					msg = jnitCryptoService.encrypt(fvo.getServerSubPath() + "||" + fvo.getPhysicalName());
				}
			}
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
	 * 에디터 이미지 보이기
	 */
	@RequestMapping(value="/user/exts/koreahana/com/imageView.do")
	public void imageView(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) String enc,
			ModelMap model) throws Exception{
		
		String dec = jnitCryptoService.decryptNoneEncodingParameter(enc);
		String[] encArr = dec.split("\\|\\|");
		if(encArr != null && encArr.length == 2) {
			FileMngUtil.showFile(request, response, encArr[0], encArr[1], Globals.UPLOAD_PATH);
		}
	}

}
