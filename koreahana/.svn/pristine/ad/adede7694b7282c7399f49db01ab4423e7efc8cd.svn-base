package exts.koreahana.pba.vo;

import java.util.Date;
import java.util.List;

import exts.com.vo.ExtsAbstractVO;
import exts.koreahana.smb.vo.KoreahanaSmbTypVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaPbaVO.java
 * @Description : 모집공고 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaPbaVO extends ExtsAbstractVO {

	private String pbancrcSn;		//모집공고일련번호
	private String pbancrcCtgryFrstCd;		//모집공고최초범주
	private String bizSeCd;			//사업구분
	private String rlsYn;			//공개여부
	private String pbancrcNm;		//모집공고명
	private String pbancrcCn;		//모집공고내용
	private long inqCnt;		//조회수
	private Date pbancrcBgngDt;		//모집공고시작일시
	private Date pbancrcEndDt;		//모집공고종료일시
	private String pbancrcBgngStr;		//모집공고시작일시문자열(파라미터 전달용)
	private String pbancrcEndStr;		//모집공고종료일시문자열(파라미터 전달용)
	
	private String pbancrcSttsCd;		//모집상태값(시작일 종료일 비교하여 나온 상태값)
	private List<KoreahanaSmbTypVO> smbTypList = null;		//제출서류유형
	private List<KoreahanaSmbVO> smbList = null;			//제출서류

	private List<String> pbancrcSttsCdList = null;		//모집상태목록
	private List<String> pbancrcCtgryFrstCdList = null;	//모집공고최초범주목록
	
	private String collectAgreeYn;		//개인정보수집동의여부
	private String thirdPartyAgreeYn;	//개인정보제3자동의여부
	
	private int reqCnt;					//신청건수
	private String reqSearchYn;			//신청건수조회여부
	
	private String regDtYr;			//신청연도
	private long sprtSttsCnt;		//지원상태별 수
	
	private String topSearchYn;			//상위표시여부
	
	private String kpMode;		//화면 모드
}
