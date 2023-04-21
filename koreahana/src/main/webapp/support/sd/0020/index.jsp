<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="tab_st01 MAB30">
  <li><a href="#">신규신청</a></li>
  <li><a href="#">만기해지</a></li>
  <li><a href="#">중도해지</a></li>
  <li class="on"><a href="#">통계</a></li>
</ul>

<h4 class="tit">연도별·월별 가입 현황</h4>
<table class="table_style ">
  <thead>
    <tr>
      <th>구분</th>
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
      <th>월평균</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2015</th>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>10</td>
      <td class="td_bg02">10</td>
      <td class="td_bg02">10</td>
    </tr>
    <tr>
      <th>2022</th>
      <td>27</td>
      <td>44</td>
      <td>37</td>
      <td>39</td>
      <td>29</td>
      <td>28</td>
      <td>29</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg02">233</td>
      <td class="td_bg02">33</td>
    </tr>
  </tbody>
  <tfoot>

    <tr>
      <td colspan="13"><b>총계</b></td>
      <td><b>2,738</b></td>
      <td><b>30</b></td>
    </tr>
  </tfoot>
</table>







<h4 class="tit">적립금액별 가입현황</h4>
<table class="table_style ">
  <thead>
    <tr>
      <th>구분</th>
      <th>10만원</th>
      <th>15만원</th>
      <th>20만원</th>
      <th>25만원</th>
      <th>30만원</th>
      <th>35만원</th>
      <th>40만원</th>
      <th>45만원</th>
      <th>50만원</th>
      <th>총계</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>가입자</th>
      <td>1</td>
      <td>2</td>
      <td>7</td>
      <td>12</td>
      <td>36</td>
      <td>49</td>
      <td>83</td>
      <td>127</td>
      <td>2,421</td>
      <td class="td_bg02">2,738</td>
    </tr>
    <tr>
      <th>비율(%)</th>
      <td>0.04</td>
      <td>0.07</td>
      <td>0.26</td>
      <td>0.44</td>
      <td>1.32</td>
      <td>1.79</td>
      <td>3.04</td>
      <td>4.65</td>
      <td>88.43</td>
      <td class="td_bg02">100</td>
    </tr>
  </tbody>
</table>








<h4 class="tit">성별·연령별 가입현황(가입당시 만 나이 기준)</h4>
<table class="table_style th_v_m">
  <thead>
    <tr>
      <th>연도</th>
      <th>성별</th>
      <th>총계</th>
      <th>10대</th>
      <th>20대</th>
      <th>30대</th>
      <th>40대</th>
      <th>50대</th>
      <th>60대 이상</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="2">15년</th>
      <th>남</th>
      <td>2</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>2</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <th>여</th>
      <td>8</td>
      <td>1</td>
      <td>-</td>
      <td>5</td>
      <td>1</td>
      <td>1</td>
      <td>-</td>
    </tr>
    <tr>
      <th rowspan="2">22년</th>
      <th>남</th>
      <td>52</td>
      <td>2</td>
      <td>12</td>
      <td>15</td>
      <td>8</td>
      <td>10</td>
      <td>5</td>
    </tr>
    <tr>
      <th>여</th>
      <td>181</td>
      <td>-</td>
      <td>38</td>
      <td>74</td>
      <td>41</td>
      <td>27</td>
      <td>1</td>
    </tr>
  </tbody>
</table>






<h4 class="tit">연도별·월별 중도해지 현황</h4>
<table class="table_style ">
  <thead>
    <tr>
      <th>구분</th>
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
      <th>2015</th>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>1</td>
      <td>1</td>
      <td>1</td>
      <td>1</td>
      <td>-</td>
      <td>1</td>
      <td>1</td>
      <td>-</td>
      <td class="td_bg02">6</td>
    </tr>
    <tr>
      <th>2022</th>
      <td>7</td>
      <td>2</td>
      <td>9</td>
      <td>4</td>
      <td>4</td>
      <td>7</td>
      <td>5</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg02">38</td>
    </tr>
  </tbody>
  <tfoot>

    <tr>
      <td colspan="13"><b>총계</b></td>
      <td><b>453</b></td>
    </tr>
  </tfoot>
</table>




<h4 class="tit">중도해지사유</h4>
<table class="table_style th_v_m">
  <thead>
    <tr>
      <th>사유</th>
      <th>실직</th>
      <th>생활비마련</th>
      <th>창업</th>
      <th>본인 및 <br/>가족 의료비</th>
      <th>임신 및 출산</th>
      <th>근로능력상실</th>
      <th>만기부적합</th>
      <th>학업</th>
      <th>약정위반</th>
      <th>기타<br/>(개인사유)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>인원수</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
    </tr>
  </tbody>
</table>





<h4 class="tit">연도별·월별 만기해지 현황</h4>
<table class="table_style ">
  <thead>
    <tr>
      <th>구분</th>
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
      <th>2018</th>
      <td>1</td>
      <td>-</td>
      <td>-</td>
      <td>1</td>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>-</td>
      <td>-</td>
      <td>3</td>
      <td>5</td>
      <td>1</td>
      <td class="td_bg02">17</td>
    </tr>
    <tr>
      <th>2022</th>
      <td>31</td>
      <td>22</td>
      <td>37</td>
      <td>51</td>
      <td>36</td>
      <td>33</td>
      <td>27</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td class="td_bg02">237</td>
    </tr>
  </tbody>
  <tfoot>

    <tr>
      <td colspan="13"><b>총계</b></td>
      <td><b>453</b></td>
    </tr>
  </tfoot>
</table>



<h4 class="tit">만기해지사유</h4>
<table class="table_style th_v_m">
  <thead>
    <tr>
      <th>사유</th>
      <th>ISA가입</th>
      <th>주택구입 <br />
        및 임대</th>
      <th>창업</th>
      <th>차량구매</th>
      <th>교육비</th>
      <th>결혼자금</th>
      <th>가전제품 구매</th>
      <th>만기부적합</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>인원수</th>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
    </tr>
  </tbody>
</table><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
