<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_gray">가산금지원(장애, 장기치료, 제3국 출생 자녀 양육) 신청</p>



<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
<table class="table_style table_t_left thd_v_m">
  <colgroup>
    <col width="15%" />
    <col width="35%" />
    <col width="15%" />
    <col width="35%" />
  </colgroup>
  <tbody>
    <tr>
      <th>거래일자</th>
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
      <th>거래일자</th>
      <th>생년월일</th>
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
      <th>신청일</th>
      <td>yyyy-mm-dd hh:mm:ss</td>
    </tr>
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



<h4 class="tit">제출 서류<a href="#" class="btn_st btn_c_gr FloatRight">제출 서류 일괄다운로드</a></h4>
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
  </tbody>
</table>




<div class="box_w_agree">
  <p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.
</p>
  
  <p class="date">2022년 07월 28일</p>
  <div class="agree_sign">
    <div class="name">신청인 <b>홍길동</b> <p>인<img src="/support/img/main/icon_woman.png" alt="" class="sign_img"/></p></div>
  </div>
  
  <p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
</div>



<div class="sup_sel_result">
  <div class="sup_sel_tit">선정결과</div>
  <div class="sup_sel_radio">
    <input type="radio" name="chk_info" value="신청완료" id="asdasd0001" class="st_radio"/>
    <label for="asdasd0001">신청완료</label>
    <input type="radio" name="chk_info" value="선정" id="asdasd0002" class="st_radio"/>
    <label for="asdasd0002">선정</label>
    <input type="radio" name="chk_info" value="미선정" id="asdasd0003" class="st_radio"/>
    <label for="asdasd0003">미선정</label>
    <input type="radio" name="chk_info" value="서류미비" id="asdasd0004" class="st_radio"/>
    <label for="asdasd0004">서류미비</label>
      
    <label for="isWord3" class="comment">서류미비 사유</label>
    <textarea class="st_textarea" placeholder="서류미비 사유를 입력해주세요." ></textarea> 
  </div>
  <a href="#" class="btn_st btn_c_gr sup_sel_save">저장</a>
</div>



<div class="btn_g_btm">
  <a class="btn_st btn_c_gr btn_s_big" href="#">신청서 수정</a>
  <a class="btn_st btn_c_wt btn_s_big" href="#">신청서 인쇄</a>
  <a class="btn_st btn_s_big" href="#">목록</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>