package exts.koreahana.smb.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import exts.com.vo.ComAtchFileVO;
import exts.com.vo.ExtsAbstractVO;
/**
 * @Class Name : KoreahanaSmbTypVO.java
 * @Description : 제출서류유형 VO
 * @Modification Information
 * 
 * @author
 * @since 2022.09.14
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class KoreahanaSmbTypVO extends ExtsAbstractVO {

	private String smbsnDocTypeSn;		//제출서류유형일련번호
	private String pbancrcSn;		//모집공고일련번호
	private String smbsnDocTypeVl;		//제출서류유형값
	
	private List<String> smbsnDocTypeSnList = null;
	private List<String> smbsnDocTypeVlList = null;
	
	List<KoreahanaSmbVO> smbList = null;
	List<ComAtchFileVO> smbDocFormList = null;
}
