package exts.koreahana.mbl.web;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.service.ComAtchFileService;
import exts.com.vo.ComAtchFileVO;
import exts.com.web.ExtsAbstractController;
import exts.koreahana.mbl.service.KoreahanaMblService;
import exts.koreahana.mbl.vo.KoreahanaMblVO;
import jnit.crypto.JnitCryptoService;
import jnit.qr.mini.QRGenerator;


/**
 * @Class Name : KoreahanaMblController.java
 * @Description : 모바일업로드 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022. 08.22
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaMblController extends ExtsAbstractController{
	
	protected String getPkg(){return "exts/koreahana/mbl";}

    /** 암호화서비스 */
    @Resource(name = "jnitCryptoService")
    JnitCryptoService jnitCryptoService;
	
	@Resource(name = "koreahanaMblService")
	private KoreahanaMblService koreahanaMblService;
	
	@Resource(name = "comAtchFileService")
	private ComAtchFileService comAtchFileService;
	
	/**
	 * qr코드 생성
	 */
	@RequestMapping(value="/exts/koreahana/mbl/showQrPopupAjax.do")
	public String showQrPopupAjax(
			KoreahanaMblVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		DateTime dt = new DateTime();		
		searchVO.setVldDt(dt.plusMinutes(5).toDate());//유효기간설정
		
		//생성
		koreahanaMblService.writeKoreahanaMbl(searchVO);
		
		model.addAttribute("result",searchVO);
		model.addAttribute("c",jnitCryptoService.encrypt(searchVO.getMblUldSn()));
		
		return "/exts/koreahana/mbl/showQrPopupAjax";
	}

	/**
	 * 데이터 확인
	 */
	@RequestMapping(value="/exts/koreahana/mbl/getDataAjax.do")
	public String getDataAjax(
			KoreahanaMblVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		
		KoreahanaMblVO result = koreahanaMblService.selectKoreahanaMbl(searchVO);
		String mbrId  = getLoginId();
		if(result != null && (!isAdmin() && !result.getRgtrId().equals(mbrId)))result = null;
		
		if(result != null && result.getAtchFileSn() != null) {
			ComAtchFileVO atchFileVO = new ComAtchFileVO();
			atchFileVO.setAtchFileSn(result.getAtchFileSn());
			result.setAtchFile(comAtchFileService.selectComAtchFile(atchFileVO));
		}
		
		return getResponseJsonView(model, result);
	}



    @RequestMapping("/exts/koreahana/mbl/qr.do")
    public void qr(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam(required=true)String qrContent,
    		ModelMap model) throws Exception {

        QRGenerator qrg = new QRGenerator("");//qr이미지 따로 저장안함
        HashMap<Integer, Object> param = new HashMap<Integer, Object>();
		param.put(QRGenerator.ENCODE_DOTS_SIZE, 10);
		param.put(QRGenerator.ENCODE_DOTS, new Boolean(true));
		param.put(QRGenerator.ENCODE_STRING, qrContent );
		param.put(QRGenerator.ENCODE_COLOR, Integer.parseInt("000000", 16));
		param.put(QRGenerator.ENCODE_BGCOLOR, Integer.parseInt("ffffff", 16));
		param.put(QRGenerator.ENCODE_BG_SIZE, 0);
		param.put(QRGenerator.ENCODE_DPP, 10);
		param.put(QRGenerator.ENCODE_CIRCLE, true);

		int width = NullUtil.nullInt(request.getParameter("w"));
		int height = NullUtil.nullInt(request.getParameter("h"));
		if(width == 0) width = 70;
		if(height == 0) height = 70;
		
		int borderThickness = NullUtil.nullInt(request.getParameter("b"));
        BufferedImage bi;
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		BufferedImage qrBi = qrg.make(param);
		Image qrImage = qrBi.getScaledInstance(width-(borderThickness*2), height-(borderThickness*2), Image.SCALE_SMOOTH);

		bi.createGraphics().drawImage(qrImage, borderThickness, borderThickness, null);
		
		response.setContentType("image/png");
		response.setHeader("Content-Disposition:", "attachment; filename=qr.png;");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		BufferedOutputStream outs = null;

		try {
			
		    outs = new BufferedOutputStream(response.getOutputStream());
			ImageIO.write(bi, "png", outs);
		} catch (IOException e){
			log.error(e.getMessage());
		}catch(Exception e){
			log.error(e.getMessage());
		}finally {
			if(bi!=null)bi.flush();
			if(qrImage!=null)qrImage.flush();
			if(qrBi!=null)qrBi.flush();
			if(outs!=null)outs.close();
		}
    }
    
	/**
	 * 업로드폼
	 */
	@RequestMapping(value="/exts/koreahana/mbl/mobileUpload.do")
	public String mobileUpload(
			KoreahanaMblVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{

		String c = request.getParameter("c");
		searchVO.setMblUldSn(jnitCryptoService.decryptNoneEncodingParameter(c));
		model.addAttribute("result",koreahanaMblService.selectKoreahanaMbl(searchVO));
		
		return "/exts/koreahana/mbl/mobileUpload";
	}


	/**
	 * 업로드처리
	 */
	@RequestMapping(value="/exts/koreahana/mbl/uploadAction.do")
	public String uploadAction(
			KoreahanaMblVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{


		boolean isSuccess = false;
		String msg = "";
		try{
			String c = request.getParameter("c");
			searchVO.setMblUldSn(jnitCryptoService.decryptNoneEncodingParameter(c));
			KoreahanaMblVO result = koreahanaMblService.selectKoreahanaMbl(searchVO);
			if(result == null || result.getMblUldSn() == null)throwBizException("exts.error.koreahana.mbl.none");
			if(!result.isValid())throwBizException("exts.error.koreahana.mbl.not.vldDt");
			/* vldExtn값은 input access형태로 출력하고 확장자체크안함.
			//확장자체크
			if(!NullUtil.nullString(result.getVldExtn()).equals("")) {
				String upfile = NullUtil.nullString(request.getParameter("upfile"));
				boolean isValidExt = false;
				for(String ext:searchVO.getVldExtn().split(",")) {
					if(upfile.indexOf("." + ext) >= 0) {
						isValidExt = true;
						break;
					}
				}
				if(!isValidExt)throwBizException("exts.error.koreahana.mbl.not.vldExtn");
			}
			*/
			koreahanaMblService.uploadKoreahanaMbl(result, request);
			
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		model.addAttribute("isSuccess",isSuccess);
		model.addAttribute("msg",msg);
		return "/exts/koreahana/mbl/mobileUploadAction";
	}

	/**
	 * 취소처리
	 */
	@RequestMapping(value="/exts/koreahana/mbl/cancelAjax.do")
	public String cancelAjax(
			KoreahanaMblVO searchVO,
			HttpServletRequest request,
			ModelMap model) throws Exception{
		

		boolean isSuccess = false;
		String msg = "";
		try{
			koreahanaMblService.deleteKoreahanaMbl(searchVO);
			
			isSuccess = true;
		}catch(EgovBizException e){
			msg = e.getMessage();
		}catch(Exception e){
			log.error(e.getMessage());
			msg = "알 수 없는 에러";
		}

		return getResponseJsonView(model, isSuccess, msg);
	}

}

