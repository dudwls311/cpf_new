<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><c:set var="Jnit_sitePath" value="support" /><%@ page import="jnit.cms.mbr.MbrUtil" %><% Boolean siauth = MbrUtil.siauth(); Boolean gpinauth = MbrUtil.gpinauth(); Boolean pkiauth = MbrUtil.pkiauth(); %><% String retType = request.getParameter("retType"); %><%@ include file='/support/_tpls/B/TPL_000018_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><%
   /**
   *@version 3.2.0.1
   **/
   %>
  <div class="member_content">

    <c:set var="siauth" value="<%=siauth %>" />
    <c:set var="gpinauth" value="<%=gpinauth %>" />
    <c:set var="pkiauth" value="<%=pkiauth %>" />

    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.min.js "></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/total_login/common/js/auth_login.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/total_login/common/js/search_idpw.js"></script>
    <form id="pwFindForm">
      <input type="hidden" id="localYn" name="localYn" value="${localYn }" />
      <input type="hidden" id="site" name="site" value="${Jnit_sitePath }" />
      <div class="box_w_suc MAT50">
        <h3 class="suc_tit">비밀번호 찾기</h3>
        <p style="text-align:center;margin-top:30px;font-size:14px;">비밀번호를 찾기 원하시면 하단에 <strong>I-PIN인증</strong>버튼을 누르시면 됩니다.</p>
        <div class="findForm">
          <input type="hidden" name="returnUrl" id="returnUrl" value="kr" />
          <div class="MAB20">
            <label for="mbrLogin" class="AlignLeft" ><strong>아이디</strong></label>
            <input name="mbrLogin" id="mbrLogin" type="text" class="st_input input_long" title="로그인아이디" />
          </div>
          <p class="btn_g_btm AlignCenter">
            <c:if test="${siauth == true}" >
              <a href="javascript:authSiPwfind();" class="btn_st btn_c_bl btn_s_long btn_s_big btn_s_long">실명인증</a>
            </c:if>
            <c:if test="${gpinauth == true}" >
              <a href="javascript:authGpinPwfind();"class="btn_st btn_c_bk btn_s_long btn_s_big btn_s_long">I-PIN인증</a>
            </c:if>
          </p>
          <div id="snAuthDiv" style="display:none;">
            <div class="newPwInput MAT10">
              <div class="MAB20">
                <label for="passwd">새비밀번호</label>
                <input name="passwd" id="passwd" type="password" />
              </div>
              <div class="MAB20">
                <label for="passwdConfirm"><strong>새비밀번호 확인</strong></label><input name="passwdConfirm" id="passwdConfirm" type="password" />
              </div>

              <div class="btn_g_btm">
                <a class="btn_st btn_c_bk btn_s_long btn_s_big btn_s_long " href="javascript:checkPwChange();">확인</a>
              </div>


            </div>
          </div>
        </div>
      </div>
    </form>
  </div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000018_E.jsp' %>