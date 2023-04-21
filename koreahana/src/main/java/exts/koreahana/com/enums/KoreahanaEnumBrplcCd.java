package exts.koreahana.com.enums;

/**
 * 출생지코드
 * @author KMK
 *
 */
public enum KoreahanaEnumBrplcCd {
	
	NOR("3001"),		//북한
	SOU("3002"),		//남한
	THR("3003"),		//제3국
	;
	
	private String code;
	private KoreahanaEnumBrplcCd(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
