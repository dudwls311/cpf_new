package exts.koreahana.fth.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import exts.com.enums.EnumGrpCd;
import exts.com.enums.EnumMenuCd;
import exts.koreahana.com.web.KoreahanaAbstractController;
import exts.koreahana.fth.service.KoreahanaFthMdwService;
import exts.koreahana.fth.service.KoreahanaFthMtrService;
import exts.koreahana.fth.service.KoreahanaFthNewService;
import exts.koreahana.fth.vo.KoreahanaFthMdwVO;
import exts.koreahana.fth.vo.KoreahanaFthMtrVO;
import exts.koreahana.fth.vo.KoreahanaFthNewVO;


/**
 * @Class Name : KoreahanaFthStatisticController.java
 * @Description : 미래행복통장통계 Controller
 * @Modification Information
 * 
 * @author
 * @since 2022.09.26
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Controller
public class KoreahanaFthStatisticController extends KoreahanaAbstractController{
	
	protected String getPkg(){return "exts/koreahana/fthStt";}
	
	@Resource(name = "koreahanaFthNewService")
	private KoreahanaFthNewService koreahanaFthNewService;
	
	@Resource(name = "koreahanaFthMtrService")
	private KoreahanaFthMtrService koreahanaFthMtrService;
	
	@Resource(name = "koreahanaFthMdwService")
	private KoreahanaFthMdwService koreahanaFthMdwService;

	/**
	 * 통계
	 */
	@RequestMapping(value="/exts/koreahana/fthStt/index.do")
	public String index(
			HttpServletRequest request,
			ModelMap model) throws Exception{

		setIndexProcess(EnumMenuCd.SPR_FTH_STT, request, "statistic");				//분기공통처리


		model.addAttribute("genderCdList",getCodeListByGrpCd(EnumGrpCd.GENDER_CD));
		model.addAttribute("ageCdList",getCodeListByGrpCd(EnumGrpCd.AGE_CD));
		model.addAttribute("usdusgCdList",getCodeListByGrpCd(EnumGrpCd.USDUSG_CD));
		model.addAttribute("cncltnRsnCdList",getCodeListByGrpCd(EnumGrpCd.CNCLTN_RSN_CD));
		
		model.addAttribute("fthNewJoinYmList",koreahanaFthNewService.selectKoreahanaFthNewStatisticJoinYm(new KoreahanaFthNewVO()));
		model.addAttribute("fthNewSprtAmtList",koreahanaFthNewService.selectKoreahanaFthNewStatisticSprtAmt(new KoreahanaFthNewVO()));
		model.addAttribute("fthNewGenderAgeList",koreahanaFthNewService.selectKoreahanaFthNewStatisticGenderAge(new KoreahanaFthNewVO()));
		
		model.addAttribute("fthMtrJoinYmList",koreahanaFthMtrService.selectKoreahanaFthMtrStatisticJoinYm(new KoreahanaFthMtrVO()));
		model.addAttribute("fthMtrUsdusgCdList",koreahanaFthMtrService.selectKoreahanaFthMtrStatisticUsdusgCd(new KoreahanaFthMtrVO()));

		model.addAttribute("fthMdwJoinYmList",koreahanaFthMdwService.selectKoreahanaFthMdwStatisticJoinYm(new KoreahanaFthMdwVO()));
		model.addAttribute("fthMdwCncltnRsnCdList",koreahanaFthMdwService.selectKoreahanaFthMdwStatisticCncltnRsnCd(new KoreahanaFthMdwVO()));
		
		return "exts/koreahana/fth/fthStatistic";
	}


}
