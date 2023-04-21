package exts.koreahana.com.enums;

/**
 * 사용자메뉴코드
 * @author KMK
 *
 */
public enum KoreahanaEnumMenuUserCd {
	
	MAIN ("MAIN"),					//메인
	
	USER_DOC("21000000"),			//문서함
	USER_SGN("22000000"),			//서명
	USER_PBA_ADT("23000000"),		//가산금지원 신청
	USER_PBA_SHO("24000000"),		//장학금지원 신청
	USER_PBA_EDU("25000000"),		//교육지원금 신청
	USER_PBA_VDO("26000000"),		//화상영어 신청
	USER_PBA_LNB("27000000"),		//학습지 신청
	USER_PBA_SPF("28000000"),		//정착지원 전문관리사 신청
	USER_PBA_EMP("29000000"),		//취업연계 직업훈련 신청
	USER_MYPAGE("00000000"),		//마이페이지
	NONE(""), 						//메뉴의 종류가 아닐경우.
	POPUP("") 						//레이어 팝업일 경우
	;
	
	private String menuSno;//DB의 menuSno값
	private KoreahanaEnumMenuUserCd(String menuSno){
		this.menuSno = menuSno;
	}
	public String getMenuSno(){
		return this.menuSno;
	}
}
