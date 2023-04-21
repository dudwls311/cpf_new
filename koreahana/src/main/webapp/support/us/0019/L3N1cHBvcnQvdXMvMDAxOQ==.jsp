<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="tab_st01 MAB30">
  <li><a href="#">서명관리</a></li>
  <li class="on"><a href="#">문서관리</a></li>
</ul>

<h4 class="tit">문서관리</h4>
<p class="p_info">지원서 신청시 첨부하는 다양한 서류를 저장하여 신청서 작성시 이용할 수 있습니다.</p>

<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class=" FloatRight"><a class="btn_st btn_c_bk" href="#">모집공고 등록</a></div>
</div>




<table class="table_style thd_v_m">
  <colgroup>
    <col width="5%" />
    <col width="*" />
    <col width="35%" />
    <col width="11%" />
    <col width="11%" />
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>문서명</th>
      <th>파일명</th>
      <th>등록일</th>
      <th>수정/삭제</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>7</td>
      <td class="AlignLeft">신분증 사본(홍길동)</td>
      <td class="AlignLeft"><a class="txt_ico_f" href="#none">홍길동_신분증사본_앞뒤.jpg</a></td>
      <td>yyyy-mm-dd</td>
      <td><a href="#" class="btn_st btn_c_or">수정</a> <a href="#" class="btn_st btn_c_gy">삭제</a></td>
    </tr>
    <tr>
      <td>6</td>
      <td class="AlignLeft">통장사본(우리은행)</td>
      <td class="AlignLeft"><a class="txt_ico_f" href="#none">통장사본.pdf</a></td>
      <td>yyyy-mm-dd</td>
      <td><a href="#" class="btn_st btn_c_or">수정</a> <a href="#" class="btn_st btn_c_gy">삭제</a></td>
    </tr>
    <tr>
      <td>5</td>
      <td class="AlignLeft">복지카드(홍길동)</td>
      <td class="AlignLeft"><a class="txt_ico_f" href="#none">복지카드.jpg</a></td>
      <td>yyyy-mm-dd</td>
      <td><a href="#" class="btn_st btn_c_or">수정</a> <a href="#" class="btn_st btn_c_gy">삭제</a></td>
    </tr>
    <tr>
      <td>4</td>
      <td class="AlignLeft">신분증 사본(홍길동)</td>
      <td class="AlignLeft"><a class="txt_ico_f" href="#none">홍길동_신분증사본_앞뒤.jpg</a></td>
      <td>yyyy-mm-dd</td>
      <td><a href="#" class="btn_st btn_c_or">수정</a> <a href="#" class="btn_st btn_c_gy">삭제</a></td>
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
<div class="popup_wrap">
  <div class="popup_bg"></div>
  <div class="popup_box" style="width: 540px;"> <!-- 1040으로 하면 안쪽이 1000으로 잡힘 -->
    <div class="popup_tit">
      <div class="p_title">문서 등록</div>
    </div>
    <div class="popup_con pop_b_none">
     
      
      <ul class="ul_st02">
        <li class="MAB10"><b>문서 명</b> <input type="text" name="B09" id="B09" value="" class="st_input input_long" /></li>
        <li class="MAB20"><b>파일등록</b> <p class="file_uplode">
          <a class="btn_st" href="#">파일열기</a>
          <span class="file_name">파일링크 이름
            <a class="file_del" href="#"><span class="comment">파일제거</span></a>
          </span>
        </p>
        </li>
      </ul>
      

      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big" href="#">문서 등록</a>
        <a class="btn_st btn_s_big" href="#">취소</a>
      </div>

      <!-- 팝업내용종료 -->
    </div>
    <!-- 하단버튼있던자리 -->
  </div>
</div>
<!-- //popup --><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>