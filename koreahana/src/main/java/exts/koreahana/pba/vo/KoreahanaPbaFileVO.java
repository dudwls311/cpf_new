package exts.koreahana.pba.vo;

import java.util.List;

import exts.com.vo.ComAtchFileVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaPbaFileVO.java
 * @Description : 모집공고첨부파일매핑 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.25
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaPbaFileVO extends ComAtchFileVO {

	private String pbancrcAtchFileMpngSn;		//모집공고첨부파일매핑일련번호
//	private String atchFileSn;		//첨부파일일련번호
	private String pbancrcSn;		//모집공고일련번호
	
	private List<String> pbancrcAtchFileMpngSnList = null;
}
