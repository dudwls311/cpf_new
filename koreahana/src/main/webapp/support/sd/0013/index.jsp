<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="tab_st01 MAB30">
  <li class="on"><a href="#">신청서 접수현황</a></li>
  <li><a href="#">지원금 지급정보</a></li>
</ul>

<div class="box_w_gray MAB5">
  <label for="s2">지원연도</label>
  <select name="s2" id="s2" class="st_select">
    <option value="">2022</option> 
    <option value="0">2021</option>
    <option value="0">2020</option>
  </select>
</div>

<div class="con_b_tp">
  <h4 class="tit">전체 지원현황 <p class="p_info FloatRight">(단위 : 천원)</p></h4>
</div>



<table class="table_style th_v_m">
  <colgroup>
    <col width="50px" />
    <col width="" />
  </colgroup>
  <thead>
    <tr>
      <th colspan="2">구분</th>
      <th>1월</th>
      <th>2월</th>
      <th>3월</th>
      <th>4월</th>
      <th>5월</th>
      <th>6월</th>
      <th>7월</th>
      <th>8월</th>
      <th>9월</th>
      <th>10월</th>
      <th>11월</th>
      <th>12월</th>
      <th>총계</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="2">장기<br/>
이식</th>
      <th>금액</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg"><b>0</b></td>
    </tr>
    <tr>
      <th>인원</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg"><b>0</b></td>
    </tr>

  </tbody>
  <tfoot>
    
    <tr>
      <th rowspan="2">총계</th>
      <th>금액</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg"><b>0</b></td>
    </tr>
    <tr>
      <th>인원</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg"><b>0</b></td>
    </tr>
  </tfoot>
</table><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
