package exts.koreahana.com.enums;

/**
 * 지원상태코드
 * @author KMK
 *
 */
public enum KoreahanaEnumSprtSttsCd {
	
	COM("16001"),		//신청완료
	SEL("16002"),		//선정
	UNS("16003"),		//미선정
	WAI("16004"),		//선정대기
	UND("16005"),		//서류미비
	TMP("16006"),		//임시저장
	;
	
	private String code;
	private KoreahanaEnumSprtSttsCd(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
