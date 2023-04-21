<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="tab_st01 MAB30">
  <li class="on"><a href="#">서명관리</a></li>
  <li><a href="#">문서관리</a></li>
</ul>

<h4 class="tit">서명관리<a class="btn_st btn_c_gr FloatRight" href="#">서명등록</a></h4>
<div class="board_list">

  <div class="list_type_3 sign_c_list">
    <ul>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign01.png" alt="" /></p>
          <p class="name AlignCenter">
            <button type="button" class="btn_star on"><i></i><span class="comment">기본서명</span></button>
            홍길동
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight">삭제</button>
          </p>
        </a>
      </li>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign02.gif" alt="" /></p>
          <p class="name AlignCenter">
            홍민영
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight">삭제</button>
          </p>
        </a>
      </li>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign03.gif" alt="" /></p>
          <p class="name">
            이하나
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight">삭제</button>
          </p>
        </a>
      </li>
    </ul>
  </div>

</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>