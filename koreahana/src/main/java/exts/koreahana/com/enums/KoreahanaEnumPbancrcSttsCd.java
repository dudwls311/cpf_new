package exts.koreahana.com.enums;

/**
 * 모집공고상태코드
 * @author KMK
 *
 */
public enum KoreahanaEnumPbancrcSttsCd {
	
	UNS("12001"),	//미정(접수전)
	ALW("12002"),	//상시
	BEF("12003"),	//모집전
	COM("12004"),	//모집완료
	REQ("12005")	//신청하기
	;
	
	private String code;
	private KoreahanaEnumPbancrcSttsCd(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
