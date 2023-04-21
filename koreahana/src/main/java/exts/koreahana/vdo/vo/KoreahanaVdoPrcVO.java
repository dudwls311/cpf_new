package exts.koreahana.vdo.vo;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaVdoPrcVO.java
 * @Description : 화상영어교육현황관리 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaVdoPrcVO extends KoreahanaVdoVO {

	private String vdoengEduPrcnMngSn;		//화상영어교육현황관리일련번호
//	private String sprtSn;		//지원일련번호
	private String lnbkDpcnTrgtYn;		//학습지중복대상여부
	private String mdwGbkhmYmd;		//중도퇴가연월일
	private String gbkhmRsn;		//퇴가사유
	

	private String kvpMode;		//화면 모드
}
