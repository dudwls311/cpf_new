package exts.koreahana.spr.vo;

import java.util.List;

import exts.koreahana.pba.vo.KoreahanaPbaVO;
import exts.koreahana.smb.vo.KoreahanaSmbMpnVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaSprVO.java
 * @Description : 지원 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.10.07
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSprVO extends KoreahanaPbaVO {

	private String sprtSn;		//지원일련번호
//	private String pbancrcSn;		//모집공고일련번호
	private String flnm;		//성명
	private String genderCd;		//성별코드
	private String brdtYmd;		//생년월일
	private String mbphno;		//휴대폰번호
	private String zip;		//우편번호
	private String addr;		//주소
	private String daddr;		//상세주소
	private String tmprStrgData;	//임시저장데이터
	private String sprtSttsCd;		//지원상태코드
	private String rsn;		//사유
	
	private String ksMode;		//화면 모드

	private String atchFileSn;		//첨부파일 다운로드시 사용될 변수 또는 서명파일 임시저장에서 사용
	private String tmpSaveYn;	//임시저장여부
	private List<KoreahanaSmbMpnVO> smbMpnList = null;		//제출서류 목록
	private List<String> pbancrcSnList = null;		//지원일련번호 목록(신청건수 조회시 사용)
	

	//검색용
	private String sprtYr;	//지원연도(신청연도)
	private List<String> notInsprtSttsCdList = null;		//지원상태코드 목록
	private String hanactCd;		//하나센터코드
	private String searchJoinType;	//신청서접수 현황에서 모집공고별 접수현황(갯수)를 상담사별로 가져올때 사용
	
	//장학금 전용변수
	private String sholSlctnTypeValue;		//장학금에서 선발유형값을 전달받아 제출서류 필수값 체크시 사용
	
	//엑셀저장용
	private String regDtStr;	
	private String ntkrdfUnqNo;		//북한이탈주민고유번호
	private String hanawonTh;		//하나원기수
	private String entcnyYmd;		//입국연월일
	private String prtdcsYmd;		//보호결정연월일
	private String hanawonFnshYmd;	//하나원수료연월일
}
