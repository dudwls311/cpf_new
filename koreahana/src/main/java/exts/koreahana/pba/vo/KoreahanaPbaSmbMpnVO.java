package exts.koreahana.pba.vo;

import java.util.List;

import exts.com.vo.ExtsAbstractVO;
import exts.koreahana.smb.vo.KoreahanaSmbVO;
import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : KoreahanaPbaVO.java
 * @Description : 제출서류 관련 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.08.24
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaPbaSmbMpnVO extends ExtsAbstractVO {

	private List<KoreahanaPbaSmbMpnParamVO> pbaSmbMpnParamList = null;
	private List<String> deleteFileSnList = null;		//삭제할 첨부파일일련번호 목록
	private List<String> docAtchFileList = null;		//문서첨부파일일련번호 목록
	private List<KoreahanaSmbVO> smbList = null;
}
