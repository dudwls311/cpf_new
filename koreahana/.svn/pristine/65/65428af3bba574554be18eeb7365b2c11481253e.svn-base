package exts.ciel.sms.vo;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : CielSmsVO.java
 * @Description : 문자전송시스템 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class CielSmsVO {

	private String userId;			//varchar(20) 시스템계정
	private String subCode;			//varchar(20) 시스템하위코드
	private String sendTitle;		//varchar(50) 제목
	private String sendNumber;		//varchar(20) 발신번호(숫자+하이픈가능/하이픈제외 최대12자) * 하이픈제외12자 초과시 오류발생
	private String sendMessage;		//varchar(2000) 내용
	private String targetNumber;	//varchar(20) 대상번호(숫자+하이픈가능/하이픈제외 최대12자) * 하이픈제외12자 초과시 오류발생
	private String currentdate;		//ex)2022-01-01 12:34:56
	private int returnStat;			//int output 상태(0:성공/-1:계정없음/9:발신,수신번호자릿수(12자)초과)
	private int returnClidx;		//발신고유번호(결과조회시사용)
}
