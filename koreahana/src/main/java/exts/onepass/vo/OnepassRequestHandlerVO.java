package exts.onepass.vo;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : OnepassRequestHandlerVO.java
 * @Description : 디지털 원패스 라이브러리제공 OnepassRequestHandler 대체 vo
 * @Modification Information
 * 
 * @author
 * @since 2022.09.05
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class OnepassRequestHandlerVO {
	private String loginDest;
	private String loginInputName;
	private String loginInputValue;
}
