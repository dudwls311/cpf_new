/**
 * @version 3.2.0.1
 */
package exts.koreahana.com.web;

import javax.servlet.http.HttpServletRequest;

import egovframework.com.utl.fcc.service.NullUtil;
import egovframework.com.utl.fcc.service.SessionUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import exts.com.enums.EnumModeType;
import exts.com.exception.MenuAuthRequiredException;
import exts.com.exception.MenuAuthRequiredJsonException;
import exts.com.exception.SessionRequiredException;
import exts.com.exception.SessionRequiredJsonException;
import exts.com.web.ExtsAbstractController;
import exts.koreahana.com.enums.KoreahanaEnumMenuUserCd;

/**
 *  Koreahana User Abstract 컨트롤러 클래스
 * @author 
 * @since 2022.09.13
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2022.09.13            최초 생성
 *
 * </pre>
 */

public abstract class KoreahanaUserAbstractController extends ExtsAbstractController {

	/**
	 * 분기에서 공통으로 처리할 내용
	 * @param menuCode
	 * @param request
	 * @param mode
	 */
	protected void setIndexProcess(KoreahanaEnumMenuUserCd menuUserCd, HttpServletRequest request, String mode)
			throws SessionRequiredException, SessionRequiredJsonException, MenuAuthRequiredJsonException,MenuAuthRequiredException{
		
		//메소드 직접접근 방지
		request.setAttribute(getPkg(), getPkg());

		
		//로그인 체크
		String loginId = getLoginId();
		request.setAttribute("loginId", loginId);
		
		boolean isStreAuth = true;
		boolean isRedngAuth = true;
		boolean isDelAuth = true;
		
		try {
			//메뉴전체 권한 체크
			if(
				(
				KoreahanaEnumMenuUserCd.USER_SGN == menuUserCd
				|| KoreahanaEnumMenuUserCd.USER_DOC == menuUserCd
				|| KoreahanaEnumMenuUserCd.USER_MYPAGE == menuUserCd
				) && "".equals(loginId)
			) throwBizException("user");
			
			EnumModeType modeType = null;
			try{
				modeType = EnumModeType.valueOf(mode);
			}catch(IllegalArgumentException e) {
				log.debug("NONE MODE TYPE : " + mode);
			}
			
			
			//각 메소드에 따른 권한 체크
			if(modeType != null){
				boolean isAuth = true;
				
				if(
					(
						EnumModeType.write == modeType || EnumModeType.writeActionJson == modeType || EnumModeType.deleteActionJson == modeType
					))isAuth = false;
				
				if(!isAuth && "".equals(loginId))throwBizException("user");
			}
		}catch(EgovBizException e) {
			if(NullUtil.nullString(mode).indexOf("Json") >= 0){
				throw new SessionRequiredJsonException("user");
			}else{
				SessionUtil.setAttribute("urlAfterLogin", request.getRequestURL().toString());
				throw new SessionRequiredException("user");
			}
		}
		
		request.setAttribute(REQUEST_IS_STRE_AUTH,isStreAuth);
		request.setAttribute(REQUEST_IS_REDNG_AUTH,isRedngAuth);
		request.setAttribute(REQUEST_IS_DEL_AUTH,isDelAuth);
	}
	
	/**
	 * 분기에서 공통으로 처리할 내용
	 * @param menuCode
	 * @param request
	 * @param mode
	 */
	protected void setIndexProcess(KoreahanaEnumMenuUserCd menuUserCd, HttpServletRequest request, String orMode, String mode )
			throws SessionRequiredException, SessionRequiredJsonException, MenuAuthRequiredJsonException,MenuAuthRequiredException{
		setIndexProcess(menuUserCd, request, mode);
	}
}
