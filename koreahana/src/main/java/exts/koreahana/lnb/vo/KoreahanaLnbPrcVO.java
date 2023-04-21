package exts.koreahana.lnb.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaLnbPrcVO.java
 * @Description : 학습지지원기본정보 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.18
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaLnbPrcVO extends KoreahanaLnbVO {

	private String lnbkSprtBscInfoSn;		//학습지지원기본정보일련번호
//	private String sprtSn;		//지원일련번호
	private String rnkg;		//순위
	private String flnm;		//성명
	private String brdtYmd;		//생년월일
	private String brplcCd;		//출생지코드
	private String hanawonTh;		//하나원기수
	private String entcnyYr;		//입국연도
	private String ntkrdfOprtSe;		//북한이탈주민부모여부
	private String ntkrdfOprtFlnm;		//북한이탈주민부모성명
	private String ntkrdfOprtHanawonTh;		//북한이탈주민부모하나원기수
	private String ntkrdfOprtEnctnyYr;		//북한이타주민부모입국년도
	private String ntkrdfAcrtfctFileSn;		//북한이탈주민인증서파일일련번호
	private String existBnfCd;		//기존수혜여부코드
	private String sprtTrgtYn;		//지원대상여부
	private String vdoengDpcnTrgtYn;		//화상영어중복대상여부
	private String mdwGbkhmYmd;		//중도퇴가연월일
	private String gbkhmRsn;		//퇴가사유
	
	private String ntkrdfAcrtfctFileId;		//북한이탈주민인증서파일_ID(파라미터로 넘어오는 명칭)
	private List<String> lnbkSprtBscInfoSnList = null;
	
	private String klpMode;		//화면 모드
	
	//엑셀 추가데이터
	private String noExistBnfYn;		//신규
	private String bf1ExistBnfYn;		//전년도 수혜여부
	private String bf2ExistBnfYn;		//전전연도 수혜여부
}
