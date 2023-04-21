package exts.koreahana.pba.vo;

import exts.com.vo.ExtsAbstractVO;
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
public class KoreahanaPbaSmbMpnParamVO extends ExtsAbstractVO {

	private String fid;
	private String fsn;
	private String mpngSn;
	private String smbsnDocSn;
}
