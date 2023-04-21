<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><h5 class="tit">의료비지원사업</h5>

<table class="table_style table_t_left">
<colgroup>
  <col width="20%"/>
</colgroup>
<tbody>
  <tr>
    <th>지원구분</th>
    <td>생활안정</td>
    <tr>
    </tr>
    <th>지원신청 자격</th>
    <td>
      <input type="checkbox" id="chk00001" name="xxx"  class="st_check"  />
      <label for="chk00001">북한이탈주민</label>

      <input type="checkbox" id="chk00002" name="xxx"  class="st_check"  />
      <label for="chk00002">제3국 출생 자녀</label>

      <input type="checkbox" id="chk00003" name="xxx"  class="st_check"  />
      <label for="chk00003">대국민</label>

    </td>
  </tr>
  <tr>
    <th>연령</th>
    <td>
      <input type="checkbox" id="chk00011" name="xxx"  class="st_check"  />
      <label for="chk00011">미취학아동</label>
      <input type="checkbox" id="chk00012" name="xxx"  class="st_check"  />
      <label for="chk00012">초등학생</label>
      <input type="checkbox" id="chk00013" name="xxx"  class="st_check"  />
      <label for="chk00013">중학생</label>
      <input type="checkbox" id="chk00014" name="xxx"  class="st_check"  />
      <label for="chk00014">고등학생</label>
      <input type="checkbox" id="chk00015" name="xxx"  class="st_check"  />
      <label for="chk00015">검정고시생</label>
      <input type="checkbox" id="chk00016" name="xxx"  class="st_check"  />
      <label for="chk00016">대학생</label>
      <input type="checkbox" id="chk00017" name="xxx"  class="st_check"  />
      <label for="chk00017">대학원생</label>
      <input type="checkbox" id="chk00018" name="xxx"  class="st_check"  />
      <label for="chk00018">연령제한 없음</label>


    </td>
  </tr>


  
  <tr>
    <th>업종</th>
    <td>
      <input type="checkbox" id="chk00021" name="xxx"  class="st_check"  />
      <label for="chk00021">운수업</label>
      <input type="checkbox" id="chk00022" name="xxx"  class="st_check"  />
      <label for="chk00022">농업</label>
      <input type="checkbox" id="chk00023" name="xxx"  class="st_check"  />
      <label for="chk00023">어업</label>
      <input type="checkbox" id="chk00024" name="xxx"  class="st_check"  />
      <label for="chk00024">임업</label>
      <input type="checkbox" id="chk00025" name="xxx"  class="st_check"  />
      <label for="chk00025">업종무관</label>


    </td>
  </tr>


  
  <tr>
    <th>기타  조건</th>
    <td>
      <input type="checkbox" id="chk00031" name="xxx"  class="st_check"  />
      <label for="chk00031">재직중</label>
      <input type="checkbox" id="chk00032" name="xxx"  class="st_check"  />
      <label for="chk00032">사업자(기창업자)
      </label>


    </td>
  </tr>


</tbody>
</table>


<div class="btn_g_btm">
  <a class="btn_st btn_c_gr btn_s_big" href="/support/hn_set/sup_set/list/">저장</a> 
  <a class="btn_st btn_s_big" href="/support/hn_set/sup_set/list/">취소</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>
