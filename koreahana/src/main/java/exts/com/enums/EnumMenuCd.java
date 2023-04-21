package exts.com.enums;

public enum EnumMenuCd {
	
	MAIN ("MAIN"),				//메인
	
	PBA("1000000"),				//사업공고(신청서) 관리
	PBA_EME("1010000"),			//사업공고(신청서) 관리 > 긴급생계비
	PBA_ADT("1020000"),			//사업공고(신청서) 관리 > 가산금
	PBA_SHO("1030000"),			//사업공고(신청서) 관리 > 장학금
	PBA_EDU("1040000"),			//사업공고(신청서) 관리 > 교육지원금
	PBA_VDO("1050000"),			//사업공고(신청서) 관리 > 화상영어
	PBA_LNB("1060000"),			//사업공고(신청서) 관리 > 학습지
	PBA_SPF("1070000"),			//사업공고(신청서) 관리 > 정착지원 전문관리사
	PBA_EMV("1080000"),			//사업공고(신청서) 관리 > 취업바우처카드
	PBA_EMP("1090000"),			//사업공고(신청서) 관리 > 취업연계 직업훈련
	
	SPR("2000000"),				//지원대상 관리
	SPR_MDL("2010000"),			//지원대상 관리 > 의료비
	SPR_MDL_PAY("2010100"),		//지원대상 관리 > 의료비 > 지원금 지급정보
	SPR_MDL_STT("2010200"),		//지원대상 관리 > 의료비 > 통계
	
	SPR_EML("2020000"),			//지원대상 관리 > 긴급생계비
	SPR_EML_SPR("2020100"),		//지원대상 관리 > 긴급생계비 > 신청서 접수현황
	SPR_EML_PRC("2020200"),		//지원대상 관리 > 긴급생계비 > 지원금 지급정보
	SPR_EML_STT("2020300"),		//지원대상 관리 > 긴급생계비 > 통계
	
	SPR_ADT("2030000"),			//지원대상 관리 > 가산금
	SPR_ADT_SPR("2030100"),		//지원대상 관리 > 가산금 > 신청서 지원현황
	SPR_ADT_PRC("2030200"),		//지원대상 관리 > 가산금 > 지급정보
	SPR_ADT_STT("2030300"),		//지원대상 관리 > 가산금 > 통계
	
	SPR_SHO("2040000"),			//지원대상 관리 > 장학금
	SPR_SHO_SPR("2040100"),		//지원대상 관리 > 장학금 > 신청서 접수현황
	SPR_SHO_PRC("2040200"),		//지원대상 관리 > 장학금 > 장학금 지급정보
	SPR_SHO_STT("2040300"),		//지원대상 관리 > 장학금 > 통계
	
	SPR_EDU("2050000"),			//지원대상 관리 > 교육지원금
	SPR_EDU_SPR("2050100"),		//지원대상 관리 > 교육지원금 > 신청서 접수현황
	SPR_EDU_PRC("2050200"),		//지원대상 관리 > 교육지원금 > 지원금 지급정보
	
	SPR_VDO("2060000"),			//지원대상 관리 > 화상영어
	SPR_VDO_SPR("2060100"),		//지원대상 관리 > 화상영어 > 신청서 접수현황
	SPR_VDO_PRC("2060200"),		//지원대상 관리 > 화상영어 > 화상영어 지원정보
	
	SPR_LNB("2070000"),			//지원대상 관리 > 학습지
	SPR_LNB_SPR("2070100"),		//지원대상 관리 > 학습지 > 신청서 접수현황
	SPR_LNB_PRC("2070200"),		//지원대상 관리 > 학습지 > 학습지 지원정보
	
	SPR_SPF("2080000"),			//지원대상 관리 > 정착지원 전문관리사
	SPR_SPF_SPR("2080100"),		//지원대상 관리 > 정착지원 전문관리사 > 신청서 접수현황
	SPR_SPF_PRC("2080200"),		//지원대상 관리 > 정착지원 전문관리사 > 교육 지원정보
	
	SPR_EMV("2090000"),			//지원대상 관리 > 취업바우처카드
	SPR_EMV_SPR("2090100"),		//지원대상 관리 > 취업바우처카드 > 신청서 접수현황
	SPR_EMV_PRC("2090200"),		//지원대상 관리 > 취업바우처카드 > 지원금 지급정보
	SPR_EMV_USE("2090300"),		//지원대상 관리 > 취업바우처카드 > 카드사용 정보
	
	SPR_FTH("2100000"),			//지원대상 관리 > 미래행복통장
	SPR_FTH_NEW("2100100"),		//지원대상 관리 > 미래행복통장 > 신규신청
	SPR_FTH_MTR("2100200"),		//지원대상 관리 > 미래행복통장 > 만기해지
	SPR_FTH_MDW("2100300"),		//지원대상 관리 > 미래행복통장 > 중도해지
	SPR_FTH_STT("2100400"),		//지원대상 관리 > 미래행복통장 > 통계
	
	SPR_EMP("2110000"),			//지원대상 관리 > 취업연계 직업훈련
	SPR_EMP_SPR("2110100"),		//지원대상 관리 > 취업연계 직업훈련 > 신청서 접수현황
	SPR_EMP_PRC("2110200"),		//지원대상 관리 > 취업연계 직업훈련 > 교육 지원정보
	SPR_EMP_STT("2110300"),		//지원대상 관리 > 취업연계 직업훈련 > 통계
	
	SPR_MGM("2120000"),			//지원대상 관리 > 경영개선자금
	SPR_MGM_SPR("2120100"),		//지원대상 관리 > 경영개선자금 > 지원금 지급정보
	SPR_MGM_STT("2120200"),		//지원대상 관리 > 경영개선자금 > 통계
	
	SPR_FRM("2130000"),			//지원대상 관리 > 영농정착
	SPR_FRM_SPR("2130100"),		//지원대상 관리 > 영농정착 > 지원금 지급정보
	SPR_FRM_STT("2130200"),		//지원대상 관리 > 영농정착 > 통계
	
	SPH("3000000"),				//지원이력 조회
	SPH_SEL("3010000"),			//지원이력 조회 > 지원이력조회
	
	CFG("4000000"),			//설정
	CFG_SPB("4010000"),		//설정 > 지원사업설정
	CFG_MBR("4020000"),		//설정 > 사용자관리
	
	COM_AUTH_GRP("----"),				//그룹 관리 - cms기능으로 대체
	COM_GROUP_MENU_AUTH	("4030000"),	//그룹별 메뉴권한 관리
	COM_GROUP_MENU_HST("------"),		//권한관리 변경이력
	COM_USER_MENU_HST("------"),		//권한관리 변경이력 > 사용자별
	COM_USER_MENU_AUTH("4040000"),		//개인별 메뉴권한 관리
	
	COM_CODE ("SAMPLESOURCE"),			//공통코드
	SAMPLE_SOURCE ("SAMPLE_SOURCE"),	//샘플소스
	SAMPLE ("SAMPLE"),					//샘플페이지
	
	NONE(""), 							//메뉴의 종류가 아닐경우.
	POPUP("") 							//레이어 팝업일 경우
	;
	
	private String menuSn;//DB의 menuSn값
	private EnumMenuCd(String menuSn){
		this.menuSn = menuSn;
	}
	public String getMenuSn(){
		return this.menuSn;
	}
}
