package exts.koreahana.spf.vo;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaSpfPrcVO.java
 * @Description : 정착지원현황관리 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSpfPrcVO extends KoreahanaSpfVO {

	private String spfstPrcnMngSn;		//정착지원현황관리일련번호
//	private String sprtSn;		//지원일련번호
	private String spfstQlfcTestInfoSn;		//정착지원자격시험정보일련번호
	private String exslno;		//응시번호
	private String testRsltCd;		//시험결과코드
	private String passYmd;		//합격연월일
	

	private String kspMode;		//화면 모드
}
