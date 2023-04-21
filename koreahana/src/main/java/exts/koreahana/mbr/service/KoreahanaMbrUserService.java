package exts.koreahana.mbr.service;

import exts.com.service.ComMbrService;
import exts.com.vo.ComMbrVO;
import exts.koreahana.mbr.vo.KoreahanaMbrDpkdfrVO;
import exts.onepass.vo.OnepassResponseVO;

public interface KoreahanaMbrUserService extends ComMbrService{

	public static String SESSION_DPKDFR_CERT = "dpkdfrVO";//북한이탈주민인증 세션정보
	
	/**
	 * 비밀번호 재설정
	 * @param ci
	 * @param searchVO
	 * @return
	 */
	void updatePwByCi(String ci, ComMbrVO searchVO)throws Exception;


	/**
	 * 비밀번호 암호화
	 * @param passwd
	 * @return
	 */
	String selectComMbrEncodePw(String passwd)throws Exception;
	
	/**
	 * 북한이탈주민 인증
	 * 
	 * @param searchVO
	 */
	KoreahanaMbrDpkdfrVO certification(String rrno, String name) throws Exception ;
	

	/**
	 * 회원탈퇴
	 * @param searchVO
	 * @return
	 */
	void out(ComMbrVO searchVO)throws Exception;


	/**
	 * 원패스정보로 로그인 시키기
	 * @param onepassResponse
	 * @return 로그인 처리 여부
	 */
	boolean loginByOnepass(OnepassResponseVO onepassResponse)throws Exception;
}
