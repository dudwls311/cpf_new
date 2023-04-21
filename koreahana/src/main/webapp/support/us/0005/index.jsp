<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_gray MAB10">교육지원금 신청</p>
<p class="AlignRight p_info"><span class="imp_st">* 표시는 필수입력</span></p>


<h4 class="tit">신청자 기본 정보</h4>
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
      <th>휴대폰 번호</th>
      <td colspan="3">010-1234-5678</td>
    </tr>
    <tr>
      <th>주소</th>
      <td colspan="3">(041680) 서울 마포구새창로  7 SNU장학빌딩 4-5-14층</td>
    </tr>

  </tbody>
</table>






<h4 class="tit">교육지원금 신청 내용</h4>
<table class="table_style table_t_left thd_v_m">
  <colgroup>
    <col width="15%" />
    <col width="35%" />
    <col width="15%" />
    <col width="35%" />
  </colgroup>
  <tbody>
    <tr>
      <th>학교명 <b class="imp_st">*</b></th>
      <td colspan="3">

        <div class="ig_wrap ">
          <div class="ig_l">
            <input type="text" name="B09" id="B09" value="" class="st_input input_long" />
          </div>
          <div class="ig_s">
            <span class="txt_c_bl MAL20">캠퍼스명 기입 필수</span>
          </div>
        </div>

      </td>
    </tr>
    <tr>
      <th>소재지 <b class="imp_st">*</b></th>
      <td colspan="3">
        <a class="btn_st" href="#">주소찾기</a>
      </td>
    </tr>
    <tr>
      <th>대표자 성명 <b class="imp_st">*</b></th>
      <td><input type="text" name="B09" id="B09" value="" class="st_input input_long" /></td>
      <th>취학자</th>
      <td><input type="text" name="B09" id="B09" value="" class="st_input " /> 명</td>
    </tr>
    <tr>
      <th>보조사업비 소요경비 <b class="imp_st">*</b></th>
      <td colspan="3">소요경비 총액 : <input type="text" name="B09" id="B09" value="" class="st_input i_w95" /> 원 | 지급받으려는 보조액 : <input type="text" name="B09" id="B09" value="" class="st_input i_w95" /> 원 | 자기자본의 부담액 : <input type="text" name="B09" id="B09" value="" class="st_input i_w95" /> 원</td>
    </tr>
    
    <tr>
      <th>보조사업비 소요경비 <b class="imp_st">*</b></th>
      <td colspan="3">은행명 : <input type="text" name="B09" id="B09" value="" class="st_input" /> | 계좌번호 : <input type="text" name="B09" id="B09" value="" class="st_input" /> | 예금주 : <input type="text" name="B09" id="B09" value="" class="st_input" /></td>
    </tr>

  </tbody>
</table>






<h4 class="tit">제출 서류</h4>
<table class="table_style table_t_left thd_v_m">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>교육보조금<br/>지급신청서  <b class="imp_st">*</b></th>
      <td>
          <p class="br"><a class="btn_st btn_c_bk" href="#">파일다운로드</a> <span class="txt_c_bl"> [교육지원 보조금 지급신청서] 파일을 다운로드하여 이용해주세요.</span></p>
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
          <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
        </td>
    </tr>
    
    <tr>
      <th>교육보조금<br/>지급신청서  <b class="imp_st">*</b></th>
      <td>
          <p class="br"><a class="btn_st btn_c_bk" href="#">파일다운로드</a> <span class="txt_c_bl"> [교육지원 보조금 지급신청서] 파일을 다운로드하여 이용해주세요.</span></p>
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
          <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
        </td>
    </tr>
    <tr>
      <th>기타 증빙서류
        <a class="btn_st btn_ico_pl" href="#">파일추가</a></th>
      <td>
        <p class="txt_c_bl br">기타 학교별 증빙서류를 자유롭게 등록해 주세요. (첨부파일은 최대 10개까지 등록 가능합니다.)</p>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>
  </tbody>
</table>





<div class="box_w_agree">
  <p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제8조의2제4항에 따라 위와 같이 교육지원 보조금의 지급을 신청합니다.
  </p>
  
  <p class="date">2022년 07월 28일</p>
  <div class="agree_sign">
    <div class="name">신청인 
      <input type="text" name="sWord222" id="sWord222" value="AA"  class="st_input i_w95 st_i_dis AlignRight" disabled="disabled" /><span class="MAR20">대학교 총(학)장</span>
    </div>
  </div>
  
  <p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
</div>




<div class="btn_g_btm">
  <a class="btn_st btn_c_wt btn_s_big" href="#">임시저장</a>
  <a class="btn_st btn_c_gr btn_s_big" href="#">신청하기</a>
  <a class="btn_st btn_s_big" href="#">취소</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
