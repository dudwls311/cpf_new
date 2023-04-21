<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_wht">장애 가산금지원 신청</p>
<p class="AlignRight"><span class="imp_st">* 표시는 필수입력</span></p>



<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
<table class="table_style table_t_left">
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




<h4 class="tit">가족관계
  <p class="FloatRight"><button type="button" class="btn_st btn_ico_pl">추가</button>
    <button type="button" class="btn_st btn_ico_mn">삭제</button></p>
</h4>
<table class="table_style">
  <colgroup>
    <col width="50%" />
    <col width="50%" />
  </colgroup>
  <thead>
    <tr>
      <th>신청자와의 관계 <b class="imp_st">*</b></th>
      <th>가족 성명 <b class="imp_st">*</b></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
          <select name="s2" id="s2" class="st_select">
            <option value="">선택</option> 
            <option value="0">부</option>
            <option value="0">모</option>
            <option value="0">배우자</option>
            <option value="0">자녀</option>
            <option value="0">형제/자매</option>
            <option value="0">조부</option>
            <option value="0">조모</option>
          </select>
      </td>
      <td>
          <input type="text" name="sWord" id="sWord2" value="" placeholder="성명"  class="st_input" />
      </td>
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
      <th>지급사유 <b class="imp_st">*</b></th>
      <td><textarea class="st_textarea" placeholder="구체적 사유를 입력해주세요."></textarea></td>
    </tr>
  </tbody>
</table>






<h4 class="tit">제출 서류

  <div class="tooltip_txt FloatRight">
    <span><b>?</b>파일첨부방법</span>
    <div class="tooltip_pop ">
      <b>파일찾기</b>
      <p>내 PC에 저장되어 있는 파일을 첨부할 수 있습니다.</p>
      <b>핸드폰에서 파일찾기</b>
      <p>QR코드를 이용하여 모바일 디바이스에 있는 파일을 첨부할 수 있습니다.</p>
      <b>나의 문서함</b>
      <p>자주 사용하는 문서를 등록해두고 선택하여 첨부할 수 있습니다. 나의 문서는 마이페이지에서 관리할 수 있습니다.</p>
    </div>
  </div>
  
</h4>
<table class="table_style table_t_left th_v_m">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>신분증사본 <b class="imp_st">*</b></th>
      <td>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>

    <tr>
      <th>통장사본 (본인명의) <b class="imp_st">*</b></th>
      <td>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
        
        <div class="MAT10">
          <span class="file_uplode">
            <span class="file_name">파일링크 이름.pdf
              <a class="file_del" href="#"><span class="comment">파일제거</span></a>
            </span>
          </span>
        </div>
        
      </td>
    </tr>

    <tr>
      <th>장애 증빙서류  <span class="imp_st">*</span><br />
        <button type="button" class="btn_st btn_ico_pl" >파일추가</button></th>
      <td>
        <p class="txt_c_bl br">장애인증명서, 장애진단서, 복지카드 사본 등 통일부장관이 인정하는 장애에 해당하는 것을 증명할 수 있는 서류 (복수등록가능)</p>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>




    <tr>
      <th>장기치료 증빙서류 <span class="imp_st">*</span></th>
      <td>
        <p class="txt_c_bl br">진단서, 입원 확인서 등 3개월 이상 치료가 필요하다는 것을 증명할 수 있는 서류</p>
        
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>


    <tr>
      <th>제3국 출생 자녀 양육 증빙서류  <span class="imp_st">*</span></th>
      <td>
        <p class="txt_c_bl br">기본증명서, 가족관계증명서, 주민등록표등본 등 제3국에서 출생한 자녀를 양육하는 것을 증명할 수 있는 서류 (복수등록가능)</p>
        
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>




  </tbody>
</table>





<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl">서명 파일 선택</a></p>


<div class="box_w_agree">
  <p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.
</p>
  
  <p class="date">2022년 07월 28일</p>
  <div class="agree_sign">
    <div class="name">신청인 
      <input type="text" name="sWord222" id="sWord222" value="" placeholder="이름"  class="st_input i_w95 MAR20" /> 
      <p>인<img src="/support/img/main/icon_woman.png" alt="" class="sign_img"/></p>
    </div>
  </div>
  
  <p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
</div>




<div class="btn_g_btm">
  <a class="btn_st btn_c_wt btn_s_big" href="#">임시저장</a>
  <a class="btn_st btn_c_gr btn_s_big" href="#">신청하기</a>
  <a class="btn_st btn_s_big" href="#">취소</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>