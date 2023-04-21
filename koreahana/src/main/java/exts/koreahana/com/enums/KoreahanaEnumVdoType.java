package exts.koreahana.com.enums;

/**
 * 일차적범주코드
 * @author KMK
 *
 */
public enum KoreahanaEnumVdoType {
	
	NTK_IDT("NTK_IDT"),	//북한이탈주민(본인)
	NTK_PRT("NTK_PRT"),	//북한이탈주민(보호자)
	NOR_IDT("NOR_IDT"),	//본인(북한이탈주민 자녀)
	NOR_PRT("NOR_PRT"),	//보호자
	;
	
	private String code;
	private KoreahanaEnumVdoType(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
