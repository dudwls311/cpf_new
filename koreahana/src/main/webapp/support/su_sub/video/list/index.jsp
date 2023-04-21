<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><c:import url="/user/exts/koreahana/vdo/index.do" />

<%--
<div class="page_tip">만9세 ~ 만24세 탈북 청소년 및 북한이탈주민 자녀를 대상으로 원어민 교사와의 1:1 수준별 화상영어 수업을 지원하고 있습니다.

  <a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&menuPos=31">자세히 알기</a>
</div>

<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class="FloatRight">
    <input type="text" name="isWord2" id="isWord2" class="st_input MAL10 PAR25" value="" placeholder="제목 또는 내용으로 검색
                                                                                                      " />
    <button type="button" class="ico_search"><span class="comment">검색</span></button>
  </div>
</div>



<table class="table_style thd_v_m">
  <colgroup>
    <col width="5%" />
    <col width="10%" />
    <col width="*" />
    <col width="20%" />
    <col width="10%" />
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>구분</th>
      <th>제목</th>
      <th>모집기간</th>
      <th>상태</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>10</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="/support/su_sub/video/view/" class="btn_a">2022년 탈북청소년 및 북한이탈주민 자녀 화상영어 교육 지원 신청 안내 </a></td>
      <td>상시모집</td>
      <td class="td_bg"><a class="btn_st btn_c_gr" href="/support/su_sub/video/write/">신청하기</a></td>
    </tr>

    <tr>
      <td>9</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span class="txt_c_bk"><b>접수전</b></span></td>
    </tr>

    <tr>
      <td>8</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span class="txt_c_bk"><b>접수전</b></span></td>
    </tr>

    <tr>
      <td>7</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span class="txt_c_bk"><b>접수전</b></span></td>
    </tr>

    <tr>
      <td>6</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span class="txt_c_bk"><b>접수전</b></span></td>
    </tr>

    <tr>
      <td>5</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>상시모집</td>
      <td class="td_bg"><span class="txt_c_bk"><b>접수전</b></span></td>
    </tr>

    <tr>
      <td>4</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span><b>모집완료</b></span></td>
    </tr>

    <tr>
      <td>3</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>상시모집</td>
      <td class="td_bg"><span><b>모집완료</b></span></td>
    </tr>

    <tr>
      <td>2</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span><b>모집완료</b></span></td>
    </tr>

    <tr>
      <td>1</td>
      <td>장애</td>
      <td class="AlignLeft"><a href="#" class="btn_a">모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다. 모집공고 제목이 보여집니다. 2줄이상인 경우 생략되어 보여집니다</a></td>
      <td>yyyy-mm-dd  ~ yyyy-mm-dd</td>
      <td class="td_bg"><span><b>모집완료</b></span></td>
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
--%><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
