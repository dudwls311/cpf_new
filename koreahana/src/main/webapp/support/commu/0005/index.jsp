<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div class="box_w_suc box_s_add">
  <h3 class="suc_tit">문의 등록이 완료되었습니다.</h3>
  <p class="AlignCenter ">입력하신 이메일로 답변 드리도록 하겠습니다. <br />
운영 상황에 따라 답변에 2~3일 이상 소요 될 수 있습니다.<br />
1:1문의 정보는 마이페이지 &gt; <span class="txt_st_unb">1:1문의 이력</span> 메뉴에서 확인 할 수 있습니다.</p>

</div>
<div class="box_w_suc PADDING20 AlignLeft" style="background:#fff;">
  <ul class="ul_st02">
        <li><b>고객센터</b> 평일 9:00~18:00 (점심시간 : 12:00~13:00)</li>
        <li><b>전화번호</b> 02-0000-0000</li>
        <li><b>이메일</b> email@emai.com</li>
      </ul>
</div>
<div class="btn_g_btm">
  <a class="btn_st btn_c_bk btn_s_big btn_s_long" href="/support/mypage/qna_history/">1:1문의 이력</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
