<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="tit_b_title box_w_gray">정착지원 전문관리사 중급 교육 신청</p>



<h4 class="tit">신청자(지원대상자) 기본 정보</h4>
<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 &gt; 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
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
      <td colspan="3">(041680) 서울 마포구새창로  7 SNU장학빌딩 4-5-14층</td>
    </tr>
  </tbody>
</table>


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


<h4 class="tit">신청자 인적사항</h4>
<table class="table_style table_t_left thd_v_m">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>사진</th>
      <td><img src="/support/img/content/p_default.jpg" alt="" class="img_profil"/>
        <ul class="profil_r_txt txt_c_bl">
          <li>✓ 최근 3월 이내에 촬영한 반명함판 사진을 등록해주세요.</li>
          <li>✓ 사진의 규격은 3cm X 4cm 증명사진 비율이 적합합니다.</li>
        </ul>
        <p>
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc03 " href="#">핸드폰에서 파일찾기</a>
          <a class="btn_st btn_c_sc02 " href="#">나의 문서함</a>
          <a class="btn_st FloatRight" href="#">다시등록</a>
        </p>
      </td>
    </tr>
    <tr>
      <th>소속 <b class="imp_st">*</b></th>
      <td><input type="text" name="A001" id="A001" value="" class="st_input input_long" /></td>
    </tr>
    <tr>
      <th>이메일 <b class="imp_st">*</b></th>
      <td><input type="text" name="A002" id="A002" value="" class="st_input input_long" /></td>
    </tr>

    <tr>
      <th>최종학력 <b class="imp_st">*</b></th>
      <td>
        <input type="radio" name="A02222" id="A01" class="st_radio"/><label for="A01">대학원이상</label>
        <input type="radio" name="A02222" id="A02" class="st_radio"/><label for="A02">4년제 대학</label>
        <input type="radio" name="A02222" id="A03" class="st_radio"/><label for="A03">2년제 대학</label>
        <input type="radio" name="A02222" id="A04" class="st_radio"/><label for="A04">고졸</label>
        <div class="ig_wrap MAT10">
          <div class="ig_s">
            <input type="radio" name="A02222" id="A05" class="st_radio"/><label for="A05">기타 :</label>
          </div>
          <div class="ig_l">
            <input type="text" name="A06" id="A06" value="" class="st_input input_long" />
          </div>
        </div>
      </td>
    </tr>


    <tr>
      <th>종사기관 유형 <b class="imp_st">*</b></th>
      <td>
        <input type="radio" name="B02222" id="B01" class="st_radio"/><label for="B01">공공기관</label>
        <input type="radio" name="B02222" id="B02" class="st_radio"/><label for="B02">공무원</label>
        <input type="radio" name="B02222" id="B03" class="st_radio"/><label for="B03">하나센터</label>
        <input type="radio" name="B02222" id="B04" class="st_radio"/><label for="B04">교육시설</label>
        <input type="radio" name="B02222" id="B05" class="st_radio"/><label for="B05">생활시설</label>
        <input type="radio" name="B02222" id="B06" class="st_radio"/><label for="B06">민간단체</label>
        <input type="radio" name="B02222" id="B07" class="st_radio"/><label for="B07">일반인</label>

        <div class="ig_wrap MAT10">
          <div class="ig_s">
            <input type="radio" name="B02222" id="B08" class="st_radio"/><label for="B08">기타 :</label>
          </div>
          <div class="ig_l">
            <input type="text" name="B09" id="B09" value="" class="st_input input_long" />
          </div>
        </div>
      </td>
    </tr>


    <tr>
      <th>북한이탈주민 정착 지원 실무 경력</th>
      <td>
        <textarea class="st_textarea"></textarea>
      </td>
    </tr>
    <tr>
      <th>신청 동기 및  기대 효과 <b class="imp_st">*</b></th>
      <td>
        <p class="MAB10">
          <span class="txt_c_bl">반드시 300자 이상 작성해주세요.</span>
          <span class="FloatRight">공백포함 : 총 <b class="txt_c_re">0</b> 자</span>
        </p>
        <textarea class="st_textarea"></textarea>
      </td>
    </tr>

    <tr>
      <th>초급교육 수료일 <b class="imp_st">*</b></th>
      <td><input type="text" name="A001" id="A001" value="" class="st_input i_w95" placeholder="yyyy-mm-dd" /></td>
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
      <th>초급교육이수 수료증 <b class="imp_st">*</b></th>
      <td>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>
    <tr>
      <th>개인정보 수집·이용 및 제3자 제공 동의서 <b class="imp_st">*</b></th>
      <td>
        <a class="btn_st btn_c_bk" href="#">파일다운로드</a> <span class="txt_c_bl"> [개인정보 수집·이용 및 제3자 제공 동의서] 파일을 다운로드하여 이용해주세요.</span>
        <div class="br"></div>
        <a class="btn_st" href="#">파일찾기</a>
        <a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>
        <a class="btn_st btn_c_sc02" href="#">나의 문서함</a>
      </td>
    </tr>
  </tbody>
</table>




<p class="AlignRight MAB10"><a href="#" class="btn_st btn_ico_pl">서명 파일 선택</a></p>

<div class="box_w_agree">
  <p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 정착지원 전문관리사 교육을 신청합니다.   </p>

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