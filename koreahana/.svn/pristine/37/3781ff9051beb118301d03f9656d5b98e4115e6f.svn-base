<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div class="container">

  <script type="text/javascript" src="/resources/js/exts/com/mbr/mbrList.js"></script>

  <form id="writePageForm" action="?">
    <input type="hidden" name="searchCondition" value="0">
      <input type="hidden" name="searchKeyword" value="">
        <input type="hidden" name="pageIndex" value="1">
          <input type="hidden" id="commMode" name="commMode" value="">
            <input type="hidden" id="mbrId" name="mbrId" value="">
              </form>
            <form id="listPageForm" action="?">
              <input type="hidden" name="searchCondition" value="0">
                <input type="hidden" name="searchKeyword" value="">
                  <input type="hidden" id="pageIndex" name="pageIndex" value="1">
                    </form>
                  <form action="?">

                    <div class="box_w_gray">
                      <div class="search_wrap">
                        <div class="search_left">
                          <label for="searchCondition">검색종류</label>
                          <select id="searchCondition" name="searchCondition" class="st_select">
                            <option value="0">전체</option>
                            <option value="1">제목</option>
                            <option value="2">내용</option>
                          </select>
                        </div>
                        <div class="search_right">
                          <label for="searchKeyword" class="comment">검색어 입력</label>
                          <input type="text" id="searchKeyword" name="searchKeyword" value="" class="st_input" placeholder="검색어를 입력하세요">
                            <button type="submit" class="btn-input-search">조회</button>
                            </div>
                        </div>
                      </div>
                      </form>
                    <div class="con_b_tp">
                      <p class="b_total FloatLeft">총<span>5</span>건</p>




                    </div>

                    <!-- 필요시 exceltemplate 추가 후 주석 제거 -->
                    <!-- <div class="btn_right_hd">
     <button class="btn_bdgreen_25" type="button" onclick="ComFns.excelDownload()">엑셀저장</button>
    </div> -->

                    <table class="table_style thd_v_m">
                      <thead>
                        <tr>
                          <th scope="col">등록일</th>
                          <th scope="col">권한구분</th>
                          <th scope="col">소속</th>
                          <th scope="col">이름</th>
                          <th scope="col">아이디</th>
                        </tr>
                      </thead>
                      <tbody>



                        <tr>
                          <td>2022-10-12</td>
                          <td></td>
                          <td></td>
                          <td><a href="/support/hn_set/user/edit/" >탈북민1</a></td>
                          <td>nuser1</td>
                        </tr>



                        <tr>
                          <td>2022-10-12</td>
                          <td></td>
                          <td></td>
                          <td><a href="/support/hn_set/user/edit/" >일반사용자1</a></td>
                          <td>user1</td>
                        </tr>



                        <tr>
                          <td>2022-09-16</td>
                          <td></td>
                          <td></td>
                          <td><a href="/support/hn_set/user/edit/" >센터직원1</a></td>
                          <td>center1</td>
                        </tr>



                        <tr>
                          <td>2022-09-16</td>
                          <td></td>
                          <td></td>
                          <td><a href="/support/hn_set/user/edit/" >재단직원1</a></td>
                          <td>found1</td>
                        </tr>



                        <tr>
                          <td>2022-08-11</td>
                          <td></td>
                          <td></td>
                          <td><a href="/support/hn_set/user/edit/" >관리자</a></td>
                          <td>cmsad</td>
                        </tr>

                      </tbody>
                    </table>

                    <div class="con_b_bt AlignCenter on">
                      <div class="paging">
                        <li><a href="#none">1</a></li>

                      </div>
                    </div>





                    <div class="popup_wrap" id="modalDiv" style="display:none">
                      <div class="popup_bg" onclick="ComFns.popup.hide()"></div>
                      <div class="popup_box">
                        <div class="popup_tit">
                          <div class="p_title" id="modalDiv_title"></div>
                        </div>
                        <div class="popup_con" id="modalDiv_content">
                        </div>
                        <div class="pop_b_btn AlignCenter">
                          <a class="btn_st btn_c_gr btn_s_big" href="#" id="modalDiv_confirmBtn">확인</a>
                          <a class="btn_st btn_s_big" href="#" onclick="ComFns.popup.hide();return false;">취소</a>
                        </div>
                      </div>
                    </div>
                    </div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>
