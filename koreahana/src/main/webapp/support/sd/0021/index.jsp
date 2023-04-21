<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div class="box_w_gray MAB10">

<label for="aaa11">지원사업</label>
<select name="aaa11" id="aaa11" class="st_select">
  <option value="">전체</option> 
  <option value="0">0</option>
  <option value="0">1</option>
</select> 
<label for="aaa12" class="MAL20">이름</label>
<input type="text" name="aaa12" id="aaa12" class="st_input" value="" />
<label for="aaa13" class="MAL20">생년월일</label>
<input type="text" name="aaa13" id="aaa13" class="st_input i_w95" value="" />
<label for="aaa14" class="MAL20">북한이탈주민번호</label>
<input type="text" name="aaa14" id="aaa14" class="st_input" value="" />


<div class="br">
</div>

<label for="aaa15">입국일</label>
<input type="text" name="aaa15" id="aaa15" class="st_input i_w95" value="" />
<label for="aaa16" class="MAL20">보호결정일</label>
<input type="text" name="aaa16" id="aaa16" class="st_input i_w95" value="" />
<label for="aaa17" class="MAL20">하나원기수</label>
<input type="text" name="aaa17" id="aaa17" class="st_input" value="" />
<label for="aaa18" class="MAL20">하나원 수료일</label>
<input type="text" name="aaa18" id="aaa18" class="st_input i_w95" value="" />

<button type="button" class="btn-input-search">검색</button>

</div>
<!-- // search box -->

<div class="box_w_blue board_l_stat_i">
<p class="txt_c_bl">✓ 최종 선정된 지원대상자의 사업별 지원 이력정보가 조회됩니다.</p>
<p class="txt_c_bl">✓ 이름, 생년월일, 입국일, 북한이탈주민번호, 보호결정일, 하나원기수, 하나원수요일 정보 중 하나 이상 입력 후 검색해주세요.</p>
</div>


<div class="con_b_tp">
<p class="b_total FloatLeft">총<span>102</span>건</p>
<div class=" FloatRight">
  <a class="btn_st btn_c_gr" href="#">엑셀다운로드</a>
</div>
</div>


<table class="table_style">
  <colgroup>
    <col width="30px" />
    <col width="80px" />
    <col width="100px" />
    <col width="100px" />
    <col width="50px" />
    
    <col width="100px" />
    <col width="50px" />
    <col width="*" />
    <col width="100px" />
    <col width="100px" />
    <col width="90px" />
  </colgroup>
<thead>
  <tr>
    <th>No.</th>
    <th>이름</th>
    <th>생년월일</th>
    <th>입국일</th>
    <th>하나원<br/>기수</th>
    
    <th>하나원 수료일</th>
    <th>북한이탈<br/>주민번호</th>
    <th>지원사업명</th>
    <th>신청일</th>
    <th>지원 또는<br/>지급(결정)일</th>
    <th>상세</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>5</td>
    <td>홍길동</td>
    <td>yyyy-mm-dd</td>
    <td>yyyy-mm-dd</td>
    <td>20</td>
    <td>yyyy-mm-dd</td>
    <td>000000</td>
    <td>가산금지원</td>
    <td>yyyy-mm-dd</td>
    <td>yyyy-mm-dd</td>
    <td><a href="#" class="btn_st">상세보기</a></td>
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
