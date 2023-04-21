<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><ul class="step_box">
  <li id="step1Li" class="on check">
    <div class="num">1</div> <span class="txt">업로드 파일선택</span>
  </li>
  <li id="step2Li" class="on check">
    <div class="num">2</div> <span class="txt">파일가져오기</span>
  </li>
  <li id="step3Li" class="on">
    <div class="num">3</div> <span class="txt">정합성 검사</span>
  </li>
  <li id="step4Li">
    <div class="num">4</div> <span class="txt">업로드 완료</span>
  </li>
</ul>

<h4 class="tit">지원금 지급정보 일괄등록</h4>
<div class="box_w_wht">

  <label for="iWWWW">파일 업로드</label>
  <span class="file_uplode" style="display: inline-block;width: 83%;">
    <a class="btn_st" href="#">파일찾기</a>
    <span class="file_name">파일링크 이름
      <a class="file_del" href="#"><span class="comment">파일제거</span></a>
    </span>
  </span>
  <a href="#" class="btn_st btn_c_gr" id="checkBtn">정합성 검사</a> 
  
</div>


<div class="box_w_blue" >
  <table class="txt_wl_1">
    <colgroup>
      <col style="width:33.3%;" />
      <col style="width:33.3%;" />
      <col />
    </colgroup>
    <tbody>
      <tr>
        <td>
          <input type="checkbox" class="st_check" id="chk1Yn" /><label for="chk1Yn">[공통] 지급액이 기준금액을 초과한 경우</label>
        </td>
        <td>
          <input type="checkbox" class="st_check" id="chk2Yn" /><label for="chk2Yn">[공통] 대상자가 사망, 이민, 거주불명자인 경우</label>
        </td>
        <td>
          <input type="checkbox" class="st_check" id="chk3Yn" /><label for="chk3Yn">[취업] 지급월에 고용보험 가입이력이 없는 경우</label>
        </td>
      </tr>
      <tr>
        <td>
          <input type="checkbox" class="st_check" id="chk4Yn" /><label for="chk4Yn">[취업] 고용보험 가입기간에 해당되지 않는 경우</label>
        </td>
        <td>
          <input type="checkbox" class="st_check" id="chk5Yn" /><label for="chk5Yn">[직업훈련] 총 훈련시간이 기준시간을 넘지 않는 경우</label>
        </td>
        <td>
          <input type="checkbox" class="st_check" id="chk6Yn" /><label for="chk6Yn">[직업훈련] 직업훈련 항목(코드)가 존재하지 않는 경우</label>
        </td>
      </tr>

    </tbody>
  </table>
</div>

<div class="MAB10">
  <span class="txt_c_re" id="msgSpan"><b>오류 : 6건</b></span>
  <span class="FloatRight">
    <a href="#" class="btn_st btn_c_bk" id="initBtn" style="">초기화</a>
    <a href="#" class="btn_st btn_c_gr" >업로드샘플파일 다운로드</a>
  </span>
</div>


<div class="fixed_table" >
  <table class="table_style">
    <thead>
      <tr>
        <th scope="col">연번</th>
        <th scope="col">보호번호</th>
        <th scope="col">입국연도</th>
        <th scope="col">하나원기수</th>
        <th scope="col">성명</th>
        <th scope="col">연락처</th>
        <th scope="col">거주지역</th>
        <th scope="col">센터접수일자</th>
        <th scope="col">하나원접수일자</th>
        <th scope="col">지급구분</th>
        <th scope="col">지급일자</th>
        <th scope="col">직업훈련</th>
        <th scope="col">자격취득</th>
        <th scope="col">우선선정</th>
        <th scope="col">취업</th>
        <th scope="col">지방여부</th>
        <th scope="col">취업연차</th>
        <th scope="col">대상여부</th>
        <th scope="col">자격증이름</th>
        <th scope="col">취득일</th>
        <th scope="col">훈련기관</th>
        <th scope="col">사업자번호</th>
        <th scope="col">훈련직종</th>
        <th scope="col">훈련기간</th>
        <th scope="col">훈련시간</th>
        <th scope="col">우선선정</th>
        <th scope="col">은행명</th>
        <th scope="col">계좌번호</th>
        <th scope="col">비고</th>
        <th scope="col">특이사항</th>
      </tr>
    </thead>
    <tbody id="excelUploadTbody"><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>123123	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>23123	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr><tr>	<td>	</td>	<td class="error"><span class="tooltip">보호번호의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">탈북민명의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td class="error"><span class="tooltip">지급일자의 값을 입력해 주십시요. </span>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td>	<td>	</td></tr></tbody>
  </table>
</div>




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




<div class="btn_b_g AlignCenter">
    <a href="#" class="btn_st btn_c_gr btn_s_big" id="uploadBtn" style="">데이터 업로드</a>
    <a href="#" class="btn_st btn_s_big" id="uploadBtn" style="">취소</a>
</div>




<h4 class="tit">지원금 지급정보 일괄등록 결과</h4>
  <table class="table_style table_t_left">
    <tbody>
      <tr>
        <th>성공</th>
        <td><em class="txt_c_bl">90 건</em></td>
      </tr>
      <tr>
        <th>실패</th>
        <td><em class="txt_c_re">2 건</em>
    		<a href="#" class="btn_st btn_c_gy MAL20">업로드 실패사유</a></td>
      </tr>
    </tbody>
</table>

<div class="btn_b_g AlignCenter">
    <a href="#" class="btn_st btn_c_gr btn_s_big" id="uploadBtn" style="">파일 추가업로드</a>
    <a href="#" class="btn_st btn_s_big" id="uploadBtn" style="">목록으로</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>