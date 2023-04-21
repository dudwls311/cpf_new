package exts.koreahana.mbr.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import exts.com.service.impl.ComMbrServiceImpl;
import exts.com.vo.ComMbrVO;
import exts.gpkiapi.service.GpkiapiCrypto;
import exts.gpkiapi.vo.GpkiapiRequestVO;
import exts.koreahana.mbr.service.KoreahanaMbrUserService;
import exts.koreahana.mbr.vo.KoreahanaMbrDpkdfrVO;
import exts.onepass.service.OnepassService;
import exts.onepass.vo.OnepassResponseVO;
import exts.onepass.vo.OnepassUserResponseVO;
import jnit.cms.mbr.JnitcmsmbrVO;
import jnit.cms.mbr.MbrUtil;
import jnit.com.tag.JnitTag;
import jnit.com.util.SpringHelperUtil;

/**
 * @Class Name : ComMbrServiceImpl.java
 * @Description : 관리 회원 ServiceImpl(추가관리자페이지용)
 * @Modification Information
 * 
 * @author
 * @since 2020. 07.20
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Service("koreahanaMbrUserService")
public class KoreahanaMbrUserServiceImpl extends ComMbrServiceImpl implements KoreahanaMbrUserService {
	// ////////////////////// Resource 선언 영역 ///////////////////////////////////////////////////////////////////

	@Resource(name="onepassService")
	private OnepassService onepassService;
	
	@Resource(name="gpkiapiCrypto")
	GpkiapiCrypto gpkiapiCrypto;
    
	// ////////////////////// Resource 선언 영역 끝 /////////////////////////////////////////////////////////////////

	// //////////////////////서비스 메소드 선언 영역 ///////////////////////////////////////////////////////////////////

	/**
	 * 추가 / 수정
	 * 
	 * @param searchVO
	 * @param detailList
	 * @throws Exception
	 */
	public void writeComMbr(ComMbrVO searchVO) throws Exception {
		
		String id = getLoginID();
		if("".equals(id)){
			ComMbrVO result = selectComMbr(searchVO);
			if(result != null && result.getMbrId() != null)throwBizException("com.error.realauth.existmbr");
			
			if(!idCheck(searchVO.getMbrLogin()))throwBizException("");
			
			searchVO.setPasswd(comMbrDao.selectComMbrEncodePw(searchVO.getPasswd()));
//			comMbrDao.insertComMbr(searchVO);
			JnitcmsmbrVO mbrVO = new JnitcmsmbrVO();
			BeanUtils.copyProperties(searchVO, mbrVO);
			id = jnitcmsmbrService.insertJnitcmsmbr(mbrVO);
			
			MbrUtil.insertMbrlog(SpringHelperUtil.getRequest(), mbrVO, mbrVO,"가입", null, null);
		}else{
			ComMbrVO result = selectComMbr(searchVO);
			if(result == null || result.getMbrId() == null || !result.getMbrId().equals(searchVO.getMbrId()))throwBizException("com.error.noauth.modify");
			
			//비밀번호 변경일 때만 처리.
			if(NullUtil.nullString(searchVO.getPasswd()).equals(""))searchVO.setPasswd(result.getPasswd());
			else searchVO.setPasswd(comMbrDao.selectComMbrEncodePw(searchVO.getPasswd()));
			
			//비밀번호 틀린횟수 초기화
			searchVO.setPwMiscnt(1);
			
			id = searchVO.getMbrId();
//			comMbrDao.updateComMbr(searchVO);
			JnitcmsmbrVO mbrVO = new JnitcmsmbrVO();
			BeanUtils.copyProperties(searchVO, mbrVO);
			mbrVO.setUpdateCondition("0");
			jnitcmsmbrService.updateJnitcmsmbr(mbrVO);
			
			MbrUtil.insertMbrlog(SpringHelperUtil.getRequest(), mbrVO, mbrVO,"수정", null, null);
			//세션 갱신
			SessionUtil.setAttribute(SESSION_ADT_VO, searchVO);
		}
		//추가정보
		searchVO.setMbrId(id);
		comMbrDao.mergeKoreahanaMbrAdt(searchVO);
		
		
	}
	
	/**
	 * 비밀번호 재설정
	 * @param searchVO
	 * @return
	 */
	public void updatePwByCi(String ci, ComMbrVO searchVO)throws Exception{

		ComMbrVO mbrVO = new ComMbrVO();
		mbrVO.setDp(ci);		
		mbrVO = selectComMbr(mbrVO);
		if(mbrVO == null || mbrVO.getMbrId() == null)throwBizException("com.error.realauth.nomatchmbr");
		
		JnitcmsmbrVO cmsmbrVO = new JnitcmsmbrVO();
		BeanUtils.copyProperties(mbrVO, cmsmbrVO);
		cmsmbrVO.setUpdateCondition("0");
		cmsmbrVO.setPwMiscnt(1);
		cmsmbrVO.setPasswd(comMbrDao.selectComMbrEncodePw(searchVO.getPasswd()));
		jnitcmsmbrService.updateJnitcmsmbr(cmsmbrVO);
	}

	
	/**
	 * 비밀번호 암호화
	 * @param passwd
	 * @return
	 */
	public String selectComMbrEncodePw(String passwd)throws Exception{
		return comMbrDao.selectComMbrEncodePw(passwd);
	}
	

	/**
	 * 북한이탈주민 인증
	 * 
	 * @param searchVO
	 */
	public KoreahanaMbrDpkdfrVO certification(String rrno, String name) throws Exception {
		KoreahanaMbrDpkdfrVO result = new KoreahanaMbrDpkdfrVO();
		GpkiapiRequestVO requestVO = new GpkiapiRequestVO();
		requestVO.setId(rrno);
		requestVO.setName(name);
		KoreahanaMbrDpkdfrVO dpkdfrVO = gpkiapiCrypto.getGpkiapiResult(requestVO);
		
		if(dpkdfrVO != null) {
			result.setDpkdfryn("Y");
			result.setRrno(rrno);
			result.setDpkdfrnm(dpkdfrVO.getDpkdfrnm());
			result.setGndr(dpkdfrVO.getGndr());
			result.setBrthdy(JnitTag.convertDateSplitString(dpkdfrVO.getBrthdy(),"-"));
			result.setPrtcnno(dpkdfrVO.getPrtcnno());
			result.setEntrcdate(JnitTag.convertDateSplitString(dpkdfrVO.getEntrcdate(),"-"));
			result.setPrtcndecsndate(JnitTag.convertDateSplitString(dpkdfrVO.getPrtcndecsndate(),"-"));
			result.setHanasordno(dpkdfrVO.getHanasordno());
			result.setHanascomptdate(JnitTag.convertDateSplitString(dpkdfrVO.getHanascomptdate(),"-"));
			SessionUtil.setAttribute(SESSION_DPKDFR_CERT, result);
		}else {
			result.setDpkdfryn("N");
			SessionUtil.removeAttribute(SESSION_DPKDFR_CERT);
		}
		
		return result;
	}

	/**
	 * 회원탈퇴
	 * @param searchVO
	 * @return
	 */
	public void out(ComMbrVO searchVO)throws Exception{
		ComMbrVO mbrVO = new ComMbrVO();
		mbrVO = selectComMbr(searchVO);
		if(mbrVO == null || mbrVO.getMbrId() == null)throwBizException("com.login.nomatch");
		
		//디지털원패스 연동 해지시에는 비밀번호 체크 안함.
		if(searchVO.getSn() == null) {
			String encodePw = comMbrDao.selectComMbrEncodePw(searchVO.getPasswd());
			if(!mbrVO.getPasswd().equals(encodePw)) throwBizException("com.error.login.notmatchpw");
		}else {
			onepassService.out();
		}
		
		if(isMbrLevelStaff())throwBizException("com.error.login.cannot.outmbr");
		
		//cms 회원탈퇴
		JnitcmsmbrVO loginVO = getLoginVO();
		mbrVO.setEx01(mbrVO.getMbrLogin());
    	mbrVO.setEx02(mbrVO.getMbrNm());
    	mbrVO.setEx03(mbrVO.getTypeId());
		mbrVO.setMbrLogin(mbrVO.getMbrId());//MbrLogin으로 할 경우 한 사용자가 여러번 탈퇴할경우 제약조건 위배됨.
    	mbrVO.setOrgId(null);
    	mbrVO.setPosId(null);
    	mbrVO.setPasswd("#"+mbrVO.getMbrId());
    	//mbrVO.setMbrNm("#"+mbrVO.getMbrNm());
    	mbrVO.setMbrNm(mbrVO.getMbrId());
    	mbrVO.setTypeId("30016");//탈퇴회원
    	mbrVO.setTel("");
    	mbrVO.setMobile("");
    	mbrVO.setEmail("");
    	mbrVO.setHomepage("");
    	mbrVO.setPostcode("");
    	mbrVO.setAddress("");
    	mbrVO.setEmailRecv((byte)0);
    	mbrVO.setSmsRecv((byte)0);
    	mbrVO.setSn("");
    	mbrVO.setDp("");
    	
		jnitcmsmbrService.leaveJnitcmsmbr(mbrVO);
    		
    	MbrUtil.insertMbrlog(SpringHelperUtil.getRequest(), mbrVO, loginVO,"탈퇴", null, null);    	
		logout();
	}


	/**
	 * 원패스정보로 로그인 시키기
	 * @param onepassResponse
	 * @return 로그인 처리 여부
	 */
	public boolean loginByOnepass(OnepassResponseVO onepassResponse)throws Exception{
		
		//userKey로 회원가입 여부 체크
		ComMbrVO mbrVO = new ComMbrVO();
		mbrVO.setSn(onepassResponse.getUserKey());
		mbrVO = selectComMbr(mbrVO);
		if(mbrVO != null && mbrVO.getMbrId() != null){
			login(mbrVO);
			return true;
		}
		
		//userKey에 해당하는 회원이 없을 때 원패스 사용자 정보 조회
		OnepassUserResponseVO userInfo = onepassService.getUserInfo(onepassResponse);
		if(userInfo == null || NullUtil.nullString(userInfo.getCi()).equals(""))throwBizException("onepass no ci");//값이 있어야 정상.
		
		mbrVO = new ComMbrVO();
		mbrVO.setDp(userInfo.getCi());
		mbrVO = selectComMbr(mbrVO);
		if(mbrVO != null && mbrVO.getMbrId() != null){
			//userKey값 업데이트 후 로그인
			mbrVO.setSn(userInfo.getUserKey());
			comMbrDao.updateComMbrUpdateUserKey(mbrVO);			
			login(mbrVO);
			return true;
		}
		
		//ci값도 없을 때 회원가입을 위한 세션 생성.
		onepassService.makeSession(userInfo);
		return false;
	}
	
	
	// //////////////////////서비스 메소드 선언 영역 끝 ///////////////////////////////////////////////////////////////////

	// /////////////////////private,protected 메소드 선언 영역
	// ///////////////////////////////////////////////////////////////////
	// /////////////////////private,protected 메소드 선언 영역 끝
	// ///////////////////////////////////////////////////////////////////
}
