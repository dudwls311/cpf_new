package exts.koreahana.smb.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.fcc.service.NullUtil;
import exts.com.service.ComAtchFileService;
import exts.com.util.FileMngUtil;
import exts.com.vo.ComAtchFileVO;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;
import exts.koreahana.com.web.KoreahanaUserAbstractController;
import exts.koreahana.smb.service.KoreahanaSmbTypService;
import exts.koreahana.smb.vo.KoreahanaSmbVO;


/**
 * @Class Name : KoreahanasmbController.java
 * @Description : 제출서류 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.08.30
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaSmbUserController extends KoreahanaUserAbstractController{
	
	protected String getPkg(){return "user/exts/koreahana/smb";}
	
	@Resource(name = "messageSource")
	protected MessageSource messageSource;
	
	@Resource(name = "koreahanaSmbTypService")
	private KoreahanaSmbTypService koreahanaSmbTypService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	/**
	 * 분기문
	 */
	@RequestMapping(value="/user/exts/koreahana/smb/index.do")
	public String index(
			@ModelAttribute	KoreahanaSmbVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		//공통 처리부		
		if("".equals(NullUtil.nullString(searchVO.getKsMode())))searchVO.setKsMode("list");		//기본 list로 포워딩		
		setIndexProcess(KoreahanaEnumMenuUserCd.NONE, request, searchVO.getKsMode());				//분기공통처리
		request.setAttribute(REQUEST_ACTION_URL, "/user/exts/koreahana/smbUser/index.do");
		
		StringBuilder sb = new StringBuilder("forward:");
		sb.append("/user/exts/koreahana/smb/" + searchVO.getKsMode() + ".do");
		
		return sb.toString();
	}

	/**
	 * 제출서류양식 다운로드
	 */
	@RequestMapping(value="/user/exts/koreahana/smb/fileDownload.do")
	public void fileDownload(
			@ModelAttribute("searchVO")	KoreahanaSmbVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		throwDirect(request);
		
		ComAtchFileVO atchFileSearchVO = new ComAtchFileVO();
		atchFileSearchVO.setAtchFileSn(searchVO.getSmbsnDocFormSn());
		
		ComAtchFileVO atchFileVO = comAtchFileService.selectComAtchFile(atchFileSearchVO);
		if(atchFileVO != null) {
			FileMngUtil.downFile(request, response, atchFileVO.getAtchFilePathNm(), atchFileVO.getAtchFileNm(), atchFileVO.getOrgnlAtchFileNm(), Globals.UPLOAD_PATH);
		}
	}
}
