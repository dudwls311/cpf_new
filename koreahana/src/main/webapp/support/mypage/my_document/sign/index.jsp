<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><c:import url="/user/exts/koreahana/sgn/index.do" />

<%--
<script>
  $(document).ready(function(){
  

  
  //사인 제거
       $('.SAMPLE_DEL_BTN').click(function() {
        var result = confirm('서명을 삭제 하시겠습니까?');

        if(result) {
           //yes
    	 $(this).parent().parent().parent('li').remove();
        } else {
            //no
        }
    });
// 팝업 01
    $('.SAMPLE_POP_D_BTN').click(function() {
      $('.SAMPLE_POP_D_HERE').toggleClass('SAMPLE_POP_OFF');
      $('.SAMPLE_POP_D_HERE').toggleClass('SAMPLE_POP_ON');
    });

// 팝업 02
    $('.SAMPLE_POP_E_BTN').click(function() {
        $('.SAMPLE_POP_E_HERE').toggleClass('SAMPLE_POP_OFF');
        $('.SAMPLE_POP_E_HERE').toggleClass('SAMPLE_POP_ON');
    });
  
// 팝업 02 - 초기화
    $('.SAMPLE_SIGN_BTN').click(function() {
        $('.SAMPLE_SIGN_HERE').toggleClass('SAMPLE_POP_OFF');
        $('.SAMPLE_SIGN_HERE').toggleClass('SAMPLE_POP_ON');
    });
  
  




  });
</script>


<ul class="tab_st01 MAB30">
  <li class="on"><a href="/support/mypage/my_document/sign/">서명관리</a></li>
  <li><a href="/support/mypage/my_document/docu/">문서관리</a></li>
</ul>

<h4 class="tit">서명관리<a class="btn_st btn_c_gr FloatRight SAMPLE_POP_D_BTN" href="#none">서명등록</a></h4>
<div class="board_list">

  <div class="list_type_3 sign_c_list">
    <ul>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign01.png" alt="" /></p>
          <p class="name AlignCenter">
            <button type="button" class="btn_star on"><i></i><span class="comment">기본서명</span></button>
            홍길동
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight SAMPLE_DEL_BTN">삭제</button>
          </p>
        </a>
      </li>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign02.gif" alt="" /></p>
          <p class="name AlignCenter">
            홍민영
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight SAMPLE_DEL_BTN">삭제</button>
          </p>
        </a>
      </li>
      <li>
        <a class="sign_c_btn">
          <p class="sign"><img src="/support/img/content/s_sign03.gif" alt="" /></p>
          <p class="name">
            이하나
            <button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight SAMPLE_DEL_BTN">삭제</button>
          </p>
        </a>
      </li>
    </ul>
  </div>

</div>

--%><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>
