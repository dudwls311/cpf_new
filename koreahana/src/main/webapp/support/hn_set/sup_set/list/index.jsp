<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><table class="table_style">
  <colgroup>
    <col width="14%" />
    <col width="7%"/>
    <col width="20%"/>
    <col width="*"/>
    <col width="10%"/>
    <col width="10%"/>
    <col width="7%"/>
  </colgroup>
  <thead>
    <tr>
      <th>지원사업명</th>
      <th>지원구분<br />(부서)</th>
      <th>지원신청 자격</th>
      <th>연령</th>
      <th>업종</th>
      <th>기타 조건</th>
      <th>수정</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="td_bg02"><b>의료비지원</b></td>
      <td>생활안정</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>긴급생계비지원</b></td>
      <td>생활안정</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>


    <tr>
      <td class="td_bg02"><b>가산금지원</b></td>
      <td>생활안정</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>


    <tr>
      <td class="td_bg02"><b>장학금지원</b></td>
      <td>교육지원</td>
      <td>북한이탈주민, 제3국출생 자녀</td>
      <td>대학생, 대학원생, 검정고시생, 중학생, 고등학생</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>


    <tr>
      <td class="td_bg02"><b>교육지원금지원</b></td>
      <td>교육지원</td>
      <td>북한이탈주민</td>
      <td>대학생</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>


    <tr>
      <td class="td_bg02"><b>화상영어지원</b></td>
      <td>교육지원</td>
      <td>북한이탈주민, 제3국출생 자녀</td>
      <td>초등학생, 중학생, 고등학생, 대학생</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>학습지지원</b></td>
      <td>교육지원</td>
      <td>북한이탈주민, 제3국출생 자녀</td>
      <td>미취학아동, 초등학생</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>정착지원전문관리사</b></td>
      <td>교육지원</td>
      <td>북한이탈주민, 제3국출생 자녀</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>취업바우처카드</b></td>
      <td>자립지원</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>미래행복통장</b></td>
      <td>자립지원</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>재직중</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>취업연계직업훈련</b></td>
      <td>자립지원</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>업종무관</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>경영개선자금지원</b></td>
      <td>자립지원</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>운수업</td>
      <td>사업자(기창업자)</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>

    <tr>
      <td class="td_bg02"><b>영농정착지원</b></td>
      <td>자립지원</td>
      <td>북한이탈주민</td>
      <td>연령 제한 없음</td>
      <td>농업, 어업, 임업</td>
      <td>&nbsp;</td>
      <td><a class="btn_st" href="/support/hn_set/sup_set/edit/">수정</a></td>
    </tr>


  </tbody>
</table><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>
