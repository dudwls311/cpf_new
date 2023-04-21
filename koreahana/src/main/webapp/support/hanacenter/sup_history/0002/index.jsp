<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_gray MAB5">긴급생계비지원 신청</p>
<p class="AlignRight p_info"><span class="imp_st">* 표시는 필수입력</span></p>



<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
<table class="table_style table_t_left">
  <colgroup>
    <col width="15%" />
    <col width="35%" />
    <col width="15%" />
    <col width="35%" />
  </colgroup>
  <tbody>
    <tr>
      <th>성명/성별</th>
      <td>이성민 / 남</td>
      <th>생년월일</label></th>
    <td>1989-06-06</td>
    </tr>
  <tr>
    <th>주소 (실거주지)<span class="imp_st">*</span></th>
    <td colspan="3">(041680) 서울 마포구 새창로 7 SNU장학빌딩 4-5-14층</td>
  </tr>
  <tr>
    <th>북한이탈주민정보 </th>
    <td colspan="3">입국년도 : 2020년   |   하나원 2020년 수료 (20기)</td>
  </tr>
  <tr><th>하나센터 상담정보 </th>
    <td colspan="3">상담일 : 2022년 8월 6일   |   상담사 : 홍길동</td>
  </tr>
  <tr>
    <th>휴대폰 번호</th>
    <td>010-1234-5678</td>
    <th>이메일</th>
    <td>email@email.com</td>
  </tr>
  <tr>
    <th>계좌번호</th>
    <td colspan="3">기업은행 2001-0000-0000 이성민</td>
  </tr>
  </tbody>
</table>




<h4 class="tit">제출서류</h4>
<table class="table_style table_t_left">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>공문</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>긴급생계비 지원 신청서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>북한이탈주민 확인서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>통장사본</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>기초생활수급 증명서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>



    <tr>
      <th>차상위계층 증명서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>건강보험자격확인서 (건강보험증 사본)</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>
    <tr>
      <th>건강보험료 납부 확인서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>주민등록등본</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>
    <tr>
      <th>가족관계증명서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>
    <tr>
      <th>한부모가족증명서</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>


    <tr>
      <th>공과금 등 체납 증빙서류</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>

    <tr>
      <th>위기상황에 대한 증빙서류</th>
      <td><p><a class="txt_ico_f" href="#none">defult_file.pdf</a></p></td>
    </tr>



  </tbody>
</table>





<div class="btn_g_btm AlignCenter">
  <a class="btn_st btn_s_big btn_c_wt" href="/support/hn_sub/imsi/">임시저장</a>
  <a class="btn_st btn_s_big btn_c_gr" href="#none">신청하기</a>
  <a class="btn_st btn_s_big" href="/support/hn_sub/living/list/">취소</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>
