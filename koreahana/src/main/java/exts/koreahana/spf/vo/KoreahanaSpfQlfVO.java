package exts.koreahana.spf.vo;

import exts.koreahana.pba.vo.KoreahanaPbaVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaSpfQlfVO.java
 * @Description : 정착지원자격시험정보 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSpfQlfVO extends KoreahanaPbaVO {

//	private String pbancrcSn;		//모집공고일련번호
	private String testPlc;		//시험장소
	private String testYmd;		//시험연월일
	private String testHrInfo;		//시험시간정보
	private String sccdPrsntnYmd;		//합격자발표연월일
	

//	private String ksqMode;		//화면 모드
}
