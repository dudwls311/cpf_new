package exts.ciel.sms.vo;

import java.sql.Date;
import java.util.List;

import exts.com.vo.ExtsAbstractVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : CielSmsVO.java
 * @Description : 문자결과조회 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.31
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class CielSmsResultVO extends ExtsAbstractVO {

	private String clidx;		//발신고유번호
	private String cltno;		//발신대상번호(미사용)
	private String gb;			//발신구분(M:일반문자/K:알림톡)
	private String msggb;		//전송구분(S:SMS/L:LMS)
	private String sendnum;		//발신번호
	private String recvnum;		//수신번호
	private Date schddt;		//발신요청일시
	private String result;		//결과코드(903:성공/905:실패)
	private String status;		//상태코드(333:완료/334:취소/335:오류)
	private String errcode;		//오류코드(0:성공/이외실패)
	private String sdt;			//처리시작일시
	private String edt;			//처리종료일시
	private String userid;		//시스템계정
	private String subcode;		//시스템하위코드
	
	private List<String> clidxList = null;
}
