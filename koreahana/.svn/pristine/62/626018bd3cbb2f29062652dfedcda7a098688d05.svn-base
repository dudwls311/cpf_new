<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><script>
  $(document).ready(function(){
  // 팝업닫기
  $('.SAMPLE_POP_03_CLOSE').click(function() {
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  });
</script>
<!-- popup -->
<div class="popup_wrap SAMPLE_POP_03_HERE">
  <div class="popup_bg SAMPLE_POP_03_CLOSE"></div>
  <div class="popup_box" style="width: 540px;"> <!-- 1040으로 하면 안쪽이 1000으로 잡힘 -->
    <div class="popup_con pop_tb_none">
      <div class="box_w_gray AlignCenter"> 
        <img src="/support/img/content/notice.png" alt="" style="width:60px; "/><br />
        <span style="font-size: 16px;line-height: 30px;">
          <b class="txt_c_bl">학습지 지원 사업</b>은 <b class="txt_c_re">화상영어 지원 사업</b>과 <br />
          <span style="background: #777777;color: #fff;padding: 2px 3px;">중복 수혜 불가능</span> 하오니 유의하여 신청해 주세요.</span>
        <p class="p_info">(화상영어 또는 학습지 중 하나의 사업만 신청 가능)</p>

      </div>

      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_wh btn_s_big" href="SAMPLE_POP_03_CLOSE">확인</a>
      </div>

      <!-- 팝업내용종료 -->
    </div>
    <!-- 하단버튼있던자리 -->
  </div>
</div>
<!-- //popup --><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>