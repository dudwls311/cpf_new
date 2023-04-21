package exts.gpkiapi.service;

import exts.gpkiapi.vo.GpkiapiRequestVO;
import exts.koreahana.mbr.vo.KoreahanaMbrDpkdfrVO;

public interface GpkiapiCrypto {

	/**
	 * gpkiapi 값 가져오기
	 * @param gpkiapiRequestVO
	 * @return
	 */
	KoreahanaMbrDpkdfrVO getGpkiapiResult(GpkiapiRequestVO gpkiapiRequestVO);
	
}
