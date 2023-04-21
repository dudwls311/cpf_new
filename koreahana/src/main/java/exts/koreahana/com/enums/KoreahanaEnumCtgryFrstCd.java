package exts.koreahana.com.enums;

/**
 * 일차적범주코드
 * @author KMK
 *
 */
public enum KoreahanaEnumCtgryFrstCd {
	//값이 NONE인 경우 코드값은 없지만 Enum을 통해 사용해야 할 경우가 있어서 변수 선언
	MDL("20001", "의료비"),	//의료비
	EML("10001", "긴급생계비"),	//긴급생계비 (상담사 전용)
	ADT("10002", "가산금지원"),	//가산금
	SHO("10003", "장학금"),	//장학금
	EDU("10004", "교육지원금"),	//교육지원금
	VDO("10005", "화상영어"),	//화상영어
	LNB("10006", "학습지"),	//학습지
	SPF("10007", "정착지원 전문관리사"),	//정착지원 전문관리사
	EMV("10008", "취업바우처카드"),	//취업바우처카드 (상담사 전용)
	FTH("20002", "미래행복통장"),	//미래행복통장
	FTH_NEW("20003", "미래행복통장(신규)"),	//미래행복통장_신규
	FTH_MTR("20004", "미래행복통장(만기해제)"),	//미래행복통장_만기해지
	FTH_MDW("20005", "미래행복통장(중도해지)"),	//미래행복통장_중도해지
	EMP("10009", "취업연계 직업훈련"),	//취업연계직업훈련
	MGM("20006", "경영개선자금"),	//경영개선자금
	FRM("20007", "영농정착"),	//영농정착
	;
	
	private String code;
	private String name;
	private KoreahanaEnumCtgryFrstCd(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
}
