<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="tab_st01 MAB30">
  <li class="on"><a href="#">신청서 접수현황</a></li>
  <li><a href="#">지원금 지급정보</a></li>
</ul>
<div class="gonggo_s_wrap on">
  <div class="box_w_gray">
    <label for="ggst">공고선택</label>
    <p class="gong_select"><span class="s_date"><b>접수마감</b>(2022-01-01 ~ 2022-12-31)</span> <span class="gong_tit">모집공고 제목이 보여집니다. 모집공고 제목이 보여집니다. 모집공고 제목고 제목</span></p>
    <button type="button" class="btn_st btn_c_gr02" id="ggst"><span class="comment">공고선택</span></button>
  </div>
  <div class="box_w_wht box_w_pop">
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
</div>


<table class="table_style td_v_m">
  <colgroup>
    <col width="70px" />
    <col width="" />
    <col width="200px" />
    <col width="80px" />
  </colgroup>
  <thead>
    <tr>
      <th>선택</th>
      <th>제목</th>
      <th>모집기간</th>
      <th>상태</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><button type="button" class="btn_st">선택</button></td>
      <td class="AlignLeft" colspan="3"><b>전체 (전체 공고문을 선택합니다.)</b></td>
    </tr>
    <tr class="tr_bg_bl">
      <td><b class="txt_c_bl">선택됨</b></td>
      <td class="AlignLeft">2022년 긴급생계비지원 모집(25차)</td>
      <td>yyyy-mm-dd ~ yyyy-mm-dd</td>
      <td>접수전</td>
    </tr>
    <tr>
      <td><button type="button" class="btn_st">선택</button></td>
      <td class="AlignLeft">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다… 
      </td>
      <td>상시모집</td>
      <td>모집중</td>
    </tr>
    <tr>
      <td><button type="button" class="btn_st">선택</button></td>
      <td class="AlignLeft">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다… </td>
      <td>yyyy-mm-dd ~ yyyy-mm-dd</td>
      <td>모집완료</td>
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </div>
</div>
<div class="box_w_gray MAB10">

  <div class="search_wrap">
    <div class="search_left">
      <label for="s2">신청연도</label>
      <select name="s2" id="s2"  class="st_select">
        <option value="">2022</option> 
        <option value="0">2021</option>
        <option value="0">2020</option>
      </select> 

      <label for="s22" class="MAL20">상태</label>
      <select name="s22" id="s22" class="st_select">
        <option value="">전체</option> 
        <option value="0">신청완료</option>
        <option value="0">선정</option>
        <option value="0">미선정</option>
        <option value="0">서류미비</option>
      </select>

      <label for="s32" class="MAL20">하나센터</label>
      <select name="s32" id="s32" class="st_select">
        <option value="">전체</option> 
        <option value="0">강원남부</option>
        <option value="0">강원북부</option>
        <option value="0">경기남부</option>
        <option value="0">경북</option>
      </select>

    </div>

    <div class="search_right">

      <label for="iWWWW" class="comment">검색어 입력</label>
      <input type="text" name="iWWWW" id="iWWWW" class="st_input" value="" placeholder="지원대상 이름으로 검색"/>


      <button type="button" class="btn-input-search">조회</button>

    </div>
  </div>
</div>
<!-- // search box -->

<div class="box_w_blue board_l_stat_i">
  <b>신청완료</b><span>1</span>
  <span class="bar"></span>
  <b>선정</b><span>23</span>
  <span class="bar"></span>
  <b>미선정</b><span>92</span>
  <span class="bar"></span>
  <b>서류미비</b><span>1</span>

</div>


<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class=" FloatRight">
    <a class="btn_st btn_c_gr" href="#">엑셀다운로드</a>
  </div>
</div>



<div class="box_w_wht MAB5">
  <label for="s2" class="comment">신청서 상태변경</label>
  <select name="s2" id="s2" class="st_select">
    <option value="">신청서 상태변경</option> 
    <option value="0">신청완료</option>
    <option value="0">선정</option>
    <option value="0">미선정</option>
    <option value="0">서류미비</option>
  </select>
</div>

<table class="table_style">
  <colgroup>
    <col width="50px" />
    <col width="" />
  </colgroup>
  <thead>
    <tr>
      <th><input type="checkbox" id="aaa1111" name="xxx" value="" class="st_check" /><label for="aaa1111"><span class="comment">전체선택</span></label></th>
      <th>지원대상</th>
      <th>생년월일</th>
      <th>신청일</th>
      <th>하나센터(상담사)</th>
      <th>상태</th>
      <th>신청서</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><input type="checkbox" id="aaa1112" name="xxx" value="" class="st_check" /><label for="aaa1112"><span class="comment">선택</span></label></td>
      <td>홍길동</td>
      <td>yyyy-mm-dd</td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td>강원남부(이영미)</td>
      <td class="td_bg"><b class="txt_c_bk">신청완료</b></td>
      <td><a href="#" class="btn_st">신청서확인</a></td>
    </tr>
    <tr>
      <td><input type="checkbox" id="aaa1113" name="xxx" value="" class="st_check" /><label for="aaa1113"><span class="comment">선택</span></label></td>
      <td>홍길동</td>
      <td>yyyy-mm-dd</td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td>강원남부(이영미)</td>
      <td class="td_bg"><b class="txt_c_bl">선정</b></td>
      <td><a href="#" class="btn_st">신청서확인</a></td>
    </tr>
    <tr>
      <td><input type="checkbox" id="aaa1115" name="xxx" value="" class="st_check" /><label for="aaa1115"><span class="comment">선택</span></label></td>
      <td>홍길동</td>
      <td>yyyy-mm-dd</td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td>강원남부(이영미)</td>
      <td class="td_bg"><b class="txt_c_bk">미선정</b></td>
      <td><a href="#" class="btn_st">신청서확인</a></td>
    </tr>
    <tr>
      <td><input type="checkbox" id="aaa1114" name="xxx" value="" class="st_check" /><label for="aaa1114"><span class="comment">선택</span></label></td>
      <td>홍길동</td>
      <td>yyyy-mm-dd</td>
      <td>yyyy-mm-dd hh:mm:ss</td>
      <td>강원남부(이영미)</td>
      <td class="td_bg"><b class="txt_c_re">서류미비</b> <a href="#" class="btn_st btn_c_re btn_s_sml">사유등록</a></td>
      <td><a href="#" class="btn_st">신청서확인</a></td>
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
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>