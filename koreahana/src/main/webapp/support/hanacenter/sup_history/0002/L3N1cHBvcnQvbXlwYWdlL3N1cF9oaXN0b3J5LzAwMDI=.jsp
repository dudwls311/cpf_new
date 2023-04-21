<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_gray">가산금지원(장애, 장기치료, 제3국 출생 자녀 양육) 신청</p>



<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
<table class="table_style table_t_left thd_v_m">
  <colgroup>
    <col width="15%" />
    <col width="35%" />
    <col width="15%" />
    <col width="35%" />
  </colgroup>
  <tbody>
    <tr>
      <th>성명 / 성별</th>
      <td>홍길동 / 남</td>
      <th>생년월일</th>
      <td>1989-06-06</td>
    </tr>
    <tr>
      <th>북한이탈주민 정보</th>
      <td>북한이탈주민 번호 : 12345678<br />
        입국일 : 2020-02-14<br />
        보호결정일 : 2020-05-10<br />
        하나원 수료일 : 2021-01-20<br />
        하나원기수 : 20
      </td>
      <th>휴대폰 번호</th>
      <td>010-1234-5678</td>
    </tr>
    <tr>
      <th>주소</th>
      <td colspan="3">(041680) 서울 마포구 새창로 7 SNU장학빌딩 4-5-14층</td>
    </tr>
  </tbody>
</table>




<h4 class="tit">가족 관계</h4>
<table class="table_style">
  <colgroup>
    <col width="50%" />
    <col width="50%" />
  </colgroup>
  <thead>
    <tr>
      <th>신청자와의 관계</th>
      <th>가족 성명</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>자녀</td>
      <td>홍민영</td>
    </tr>
  </tbody>
</table>





<h4 class="tit">가산금 선택 및 지급 사유 입력</h4>
<table class="table_style table_t_left">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>가산금  종류</th>
      <td>장애가산금</td>
    </tr>
    <tr>
      <th>지급사유</th>
      <td>장애가 있는 자녀를 위해 제3국 출생 자녀 양육을 위해 지원금이 필요합니다</td>
    </tr>
  </tbody>
</table>



<h4 class="tit">제출 서류</h4>
<table class="table_style table_t_left">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>신분증사본</th>
      <td><p><a class="txt_ico_f" href="#none">홍길동_신분증사본.pdf</a></p></td>
    </tr>
    <tr>
      <th>본인명의 통장사본</th>
      <td><p><a class="txt_ico_f" href="#none">홍길동_우리은행_통장사본.pdf</a></p></td>
    </tr>
    <tr>
      <th>장애 증빙서류</th>
      <td><p><a class="txt_ico_f" href="#none">장애인증명서.pdf</a></p>
        <p><a class="txt_ico_f" href="#none">장애인_복지카드.jpg</a></p>
      </td>
    </tr>
    <tr>
      <th>제3국 출생 자녀 양육 증빙서류</th>
      <td><p><a class="txt_ico_f" href="#none">가족관계증명서.pdf</a></p></td>
    </tr>
  </tbody>
</table>




<div class="box_w_agree">
  <p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.
</p>
  
  <p class="date">2022년 07월 28일</p>
  <div class="agree_sign">
    <div class="name">신청인 <b>홍길동</b> <p>인<img src="/support/img/content/s_sign01.png" alt="" class="sign_img"/></p></div>
  </div>
  
  <p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
</div>





<div class="btn_g_btm">
  <a class="btn_st btn_s_big" href="/support/mypage/sup_history/0001/">뒤로가기</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>