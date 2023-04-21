package exts.koreahana.com.enums;

/**
 * 성별코드
 * @author KMK
 *
 */
public enum KoreahanaEnumGenderCd {
	
	MALE("1001"),	
	FEMALE("1002"),
	;
	
	private String code;
	private KoreahanaEnumGenderCd(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
