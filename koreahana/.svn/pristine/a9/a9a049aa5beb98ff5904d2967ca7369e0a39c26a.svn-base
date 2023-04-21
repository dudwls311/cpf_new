<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><script>
  $(document).ready(function(){
  // 팝업
  $('.SAMPLE_POP_BTN').click(function() {
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  // 팝업닫기
  $('.SAMPLE_POP_CLOSE').click(function() {
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  //테이블 삭제버튼
  $('.SAMPLE_TR_DEL_BTN').click(function() {
  $(this).parent().parent('tr').remove();
  });


  });
</script>



<ul class="tab_st01 MAB30">
  <li><a href="/support/hn_set/business/hana/">재단</a></li>
  <li class="on"><a href="/support/hn_set/business/center/">하나센터</a></li>
</ul>



<div class="box_w_gray">
  <div class="ig_wrap">
    <div class="ig_s">
      <label for="s4">소속센터</label>
      <select name="s4" id="s4"  class="st_select MAR20">
        <option>전체</option> 
        <option>서울남부</option> 
        <option>서울동부</option> 
        <option>서울북부</option> 
        <option>서울서부</option> 
        <option>경기남부</option> 
        <option>경기동부</option> 
        <option>경기북부</option> 
        <option>경기서부</option> 
        <option>경기서북부</option> 
        <option>경기중부</option> 
        <option>광주</option> 
        <option>대구</option> 
        <option>대전</option> 
        <option>부산</option> 
        <option>울산</option> 
        <option>인천</option> 
        <option>강원남부</option> 
        <option>강원북부</option> 
        <option>경남</option> 
        <option>경북</option> 
        <option>전남</option> 
        <option>전북</option> 
        <option>충남</option> 
        <option>충북</option> 
        <option>제주</option> 
      </select> 

      <label for="s5">지원사업</label>
      <select name="s5" id="s5"  class="st_select MAR20">
        <option>전체</option> 
        <option>긴급생계비지원</option> 
        <option>취업바우처카드</option> 
      </select> 

    </div>

    <div class="ig_l">
      <label for="iWWWW" class="comment">검색어 입력</label>
      <input type="text" name="iWWWW" id="iWWWW" class="st_input input_long" value="" placeholder="사용자 이름, ID로 검색" />

    </div>

    <div class="ig_s">
      <button type="button" class="btn-input-search">검색</button>
    </div>

  </div>
</div>
<!-- // search box -->



<div class="con_b_tp">

  <div class=" FloatRight">

    <label for="s6" class="comment">지원사업 선택</label>
    <select name="s6" id="s6"  class="st_select MAR20">
      <option>전체</option> 
      <option>긴급생계비지원</option> 
      <option>취업바우처카드</option> 
    </select> 

    <a class="btn_st btn_c_bk SAMPLE_POP_BTN" href="#none">사업담당자 추가</a></div>
</div>



<table class="table_style thd_v_m">
  <colgroup>
    <col width="10%" />
    <col width="20%"/>
    <col width="20%"/>
    <col width="20%"/>
    <col width="20%"/>
    <col width="10%"/>
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>지원사업명</th>
      <th>소속센터</th>
      <th>이름</th>
      <th>아이디</th>
      <th>권한삭제</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>5</td>
      <td class="td_bg">긴급생계비지원</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td><a href="#none" class="btn_st SAMPLE_TR_DEL_BTN">삭제</a></td>
    </tr>
    <tr>
      <td>4</td>
      <td class="td_bg">긴급생계비지원</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td><a href="#none" class="btn_st SAMPLE_TR_DEL_BTN">삭제</a></td>
    </tr>
    <tr>
      <td>3</td>
      <td class="td_bg">취업바우처카드</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td><a href="#none" class="btn_st SAMPLE_TR_DEL_BTN">삭제</a></td>
    </tr>
    <tr>
      <td>2</td>
      <td class="td_bg">취업바우처카드</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td><a href="#none" class="btn_st SAMPLE_TR_DEL_BTN">삭제</a></td>
    </tr>
    <tr>
      <td>1</td>
      <td class="td_bg">긴급생계비지원</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td><a href="#none" class="btn_st SAMPLE_TR_DEL_BTN">삭제</a></td>
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
      <div class="p_title">사업담당자 선택</div>
    </div>
    <div class="popup_con pop_b_none">


      <div class="box_w_gray ig_wrap MAB10">
        <div class="ig_l">
          <label for="iWWWW" class="comment">검색어 입력</label>
          <input type="text" name="iWWWW" id="iWWWW" class="st_input input_long" value="" placeholder="사용자 이름, ID로 검색" />
        </div>
        <div class="ig_s">
          <button type="button" class="btn-input-search">검색</button>
        </div>
      </div>





      <div class="con_b_tp">
        <p class="b_total FloatLeft">총<span>102</span>건</p>
      </div>


      <table class="table_style thd_v_m">
        <colgroup>
          <col width="10%" />
          <col width="25%" />
          <col width="25%" />
          <col width="25%" />
          <col width="15%" />
        </colgroup>
        <thead>
          <tr>
            <th>No.</th>
            <th>소속센터</th>
            <th>이름</th>
            <th>아이디</th>
            <th>선택</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>10</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
          <tr>
            <td>9</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
          <tr>
            <td>8</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
          <tr>
            <td>7</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
          <tr>
            <td>6</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
          <tr>
            <td>5</td>
            <td>강원남부</td>
            <td>홍길동</td>
            <td>id1234</td>
            <td><a href="#" class="btn_st btn_c_gr SAMPLE_POP_CLOSE">선택</a></td>
          </tr>
        </tbody>
      </table>


      <div class="con_b_bt AlignCenter on">
        <div class="paging" style="display: block;">
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


      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_s_big SAMPLE_POP_CLOSE" href="#none">닫기</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>