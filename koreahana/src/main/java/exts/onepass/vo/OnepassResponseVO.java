package exts.onepass.vo;

import lombok.Getter;
import lombok.Setter;
/**
 * @Class Name : OnepassRequestVO.java
 * @Description : 디지털 원패스 라이브러리제공 OnepassResponse 대체 vo
 * @Modification Information
 * 
 * @author
 * @since 2022.09.05
 * @version 1.0
 * @see Copyright (C) by  All right reserved.
 */
@Getter
@Setter
public class OnepassResponseVO {
    private String response;
    private String userKey;
    private String intfToken;
    private String crtLevelCode;
    private String crtCode;
    private String type;
    private String status;
    private String resultCode;
    private String invalidCode;
    private String detailErrorMessage;
    private String findUser;
}
