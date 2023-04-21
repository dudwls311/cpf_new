<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><script>
  $(document).ready(function(){
      // 서류미비팝업
      $('.SAMPLE_POP_BTN').click(function() {
      $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_ON');
      $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_OFF');
      });

      // 팝업닫기
      $('.SAMPLE_POP_CLOSE').click(function() {
      $('.popup_wrap').toggleClass('SAMPLE_POP_ON');
      $('.popup_wrap').toggleClass('SAMPLE_POP_OFF');
      });
  
  
  });
  
  
  
  function openPop(){
    var popup = window.open('/support/mypage/sup_history/0004/', '수험표 인쇄 미리보기', 'width=830px,height=920px,scrollbars=yes');
}
</script>

<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
</div>


<table class="table_style thd_v_m">
  <colgroup>
    <col width="5%" />
    <col width="*" />
    <col width="17%" />
    <col width="15%" />
    <col width="8%" />
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>제목</th>
      <th>마지막 저장시간</th>
      <th>상태</th>
      <th>수정/조회</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>7</td>
      <td class="AlignLeft"><a href="/support/mypage/sup_history/0002/" class="btn_a">가산금지원 신청 (장애, 장기치료, 제3국 출생 자녀 양육)</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bk"><b>임시저장</b></span></td>
      <td><a href="/support/mypage/sup_history/0003" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    <tr>
      <td>6</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2022년 버스운전기사 양성과정 참가자 모집 공고</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bl"><b>선정</b></span> <a href="#none" target="_blank" onclick="openPop()" class="btn_st btn_c_bl">수험표 인쇄</a></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    <tr>
      <td>5</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2022년 버스운전기사 양성과정 참가자 모집 공고</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bk"><b>모집완료(신청불가)</b></span></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    
    <tr>
      <td>4</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2022년 버스운전기사 양성과정 참가자 모집 공고</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bk"><b>신청완료</b></span></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    <tr>
      <td>3</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2022년 버스운전기사 양성과정 참가자 모집 공고</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bl"><b>선정대기</b></span></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    <tr>
      <td>2</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2022년 버스운전기사 양성과정 참가자 모집 공고</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_bl"><b>선정</b></span></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
    <tr>
      <td>1</td>
      <td class="AlignLeft"><a href="#" class="btn_a">가산금지원 신청 (장애, 장기치료, 제3국 출생 자녀 양육)</a></td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td class="td_bg"><span class="txt_c_re"><b>서류미비</b></span> <a href="#none" class="btn_st btn_c_re SAMPLE_POP_BTN">서류확인</a></td>
      <td><a href="#" class="btn_st btn_c_wh">수정</a></td>
    </tr>
  </tbody>
</table>




<div class="con_b_bt AlignCenter">
  <div class="paging">
    <ul>
      <li class="first_page_btn"><a href="#none"><span>첫 페이지</span></a></li>
      <li class="prev_page_btn"><a href="#none"><span>이전 페이지</span></a></li>
      <li class="on"><a href="#none">1</a></li>                        
      <li><a href="#none">2</a></li>                        
      <li><a href="#none">3</a></li>                        
      <li><a href="#none">4</a></li>                        
      <li><a href="#none">5</a></li>                        
      <li><a href="#none">6</a></li>                        
      <li><a href="#none">7</a></li>                        
      <li><a href="#none">8</a></li>                        
      <li><a href="#none">9</a></li>                        
      <li><a href="#none">10</a></li>
      <li class="next_page_btn"><a href="#none"><span>다음 페이지</span></a></li>
      <li class="last_page_btn"><a href="#none"><span>마지막 페이지</span></a></li>
    </ul>
  </div>
</div>




<!-- popup -->
<div class="popup_wrap SAMPLE_POP_HERE SAMPLE_POP_OFF" >
  <div class="popup_bg SAMPLE_POP_CLOSE"></div>

  <!-- 팝업내용 -->
  <div class="popup_box SAMPLE_TOGGLE_HERE SAMPLE_POP_ON" style="width: 540px;">
    <div class="popup_tit">
      <div class="p_title">서류미비 사유</div>
    </div>
    <div class="popup_con pop_b_none">



      <div class="box_w_gray">
        주민등록표등본을 2022년 3월 1일 이후 발급된 서류로 재등록 해주세요.<br />
        (모집공고일 기준 3개월 이내 발급된 서류)

      </div>


      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big" href="/support/mypage/sup_history/0003/">신청서 수정</a>
        <a class="btn_st btn_s_big SAMPLE_POP_CLOSE" href="#none">닫기</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->

</div>
<!-- //popup --><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>