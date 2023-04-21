<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><script>
  $(document).ready(function(){
  //가족추가제거
  $('.SAMPLE_FAM_OFF').click(function() {
  $('.SAMPLE_TR_ONOFF').css( 'display', 'none' );
  });
  $('.SAMPLE_FAM_ON').click(function() {
  $('.SAMPLE_TR_ONOFF').css( 'display', 'table-row' );
  });

  // 서명관리팝업
  $('.SAMPLE_POP_BTN').click(function() {
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  // 서명관리 (서명 선택 화면)
  $('.SAMPLE_TOGGLE_BTN').click(function() {
  $('.SAMPLE_TOGGLE_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_TOGGLE_HERE').toggleClass('SAMPLE_POP_OFF');
  });


  // 문서관리팝업
  $('.SAMPLE_POP_02_BTN').click(function() {
  $('.SAMPLE_POP_02_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_02_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  // 문서관리 (문서 선택 화면)
  $('.SAMPLE_TOGGLE_02_BTN').click(function() {
  $('.SAMPLE_TOGGLE_02_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_TOGGLE_02_HERE').toggleClass('SAMPLE_POP_OFF');
  });

  // 신청서삭제팝업
  $('.SAMPLE_POP_03_BTN').click(function() {
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_OFF');
  });

  // 첨부파일목록추가
  $('.SAMPLE_FILE_ADD_BTN').click(function() {
  $('.SAMPLE_FILE_ADD_HERE').toggleClass('SAMPLE_FILE_ADD_ON');
  $('.SAMPLE_FILE_ADD_HERE').toggleClass('SAMPLE_FILE_ADD_OFF');
  });

  // 팝업닫기
  $('.SAMPLE_POP_CLOSE').click(function() {
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  // 팝업닫기
  $('.SAMPLE_POP_02_CLOSE').click(function() {
  $('.SAMPLE_POP_02_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_02_HERE').toggleClass('SAMPLE_POP_OFF');
  });
  // 팝업닫기
  $('.SAMPLE_POP_03_CLOSE').click(function() {
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_ON');
  $('.SAMPLE_POP_03_HERE').toggleClass('SAMPLE_POP_OFF');
  });





  });
</script>

<p class="tit_b_title box_w_gray">가산금지원 신청 (장애, 장기치료, 제3국 출생 자녀 양육)</p>
<p class="AlignRight MAT-20"><span class="imp_st">* 표시는 필수입력</span></p>



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
  <p class="FloatRight"><button type="button" class="btn_st btn_ico_pl SAMPLE_FAM_ON" >추가</button>
    <button type="button" class="btn_st btn_ico_mn SAMPLE_FAM_OFF" >삭제</button></p>
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
          <option value="0" selected="selected">자녀</option>
          <option value="0">형제/자매</option>
          <option value="0">조부</option>
          <option value="0">조모</option>
        </select>
      </td>
      <td>
        <input type="text" name="sWord" id="sWord2" value="홍민영" placeholder="성명"  class="st_input" />
      </td>
    </tr>




    <tr class="SAMPLE_TR_ONOFF" style="display:none;">
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
      <td>
        <input type="checkbox" id="chkk21" name="ccccc" value="yyy" class="st_check" checked="checked"/>
        <label for="chkk21">장애</label>

        <input type="checkbox" id="chkk31" name="ccccc" value="yyy" class="st_check" />
        <label for="chkk31">장기치료</label>

        <input type="checkbox" id="chkk41" name="ccccc" value="yyy" class="st_check"  checked="checked"/>
        <label for="chkk41">제3국 출생 자녀 양육</label>

      </td>
    </tr>
    <tr>
      <th>지급사유 <b class="imp_st">*</b></th>
      <td><textarea class="st_textarea" placeholder="구체적 사유를 입력해주세요.">장애가 있는 자녀를 위해 제3국 출생 자녀 양육을 위해 지원금이 필요합니다.</textarea></td>
    </tr>
  </tbody>
</table>






<h4 class="tit">제출 서류</h4>
<table class="table_style table_t_left th_v_m">
  <colgroup>
    <col width="15%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>신분증사본 <b class="imp_st">*</b></th>
      <td>
        <!-- 첨부파일 -->
        <div class="file_multi">
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
          <div class="MAT5">
            <span class="file_uplode">
              <span class="file_name"><a href="#" class="file">홍길동_신분증사본.pdf</a>
                <a class="file_del" href="#"><span class="comment">파일제거</span></a>
              </span>
            </span>
          </div>
        </div>
        <!-- 첨부파일 끝 -->
      </td>
    </tr>

    <tr>
      <th>통장사본 (본인명의) <b class="imp_st">*</b></th>
      <td>
        <!-- 첨부파일 -->
        <div class="file_multi">
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
          <div class="MAT5">
            <span class="file_uplode">
              <span class="file_name"><a href="#" class="file">홍길동_우리은행_통장사본.pdf</a>
                <a class="file_del" href="#"><span class="comment">파일제거</span></a>
              </span>
            </span>
          </div>
        </div>
        <!-- 첨부파일 끝 -->
      </td>
    </tr>

    <tr>
      <th>장애 증빙서류  <span class="imp_st">*</span><br />
        <button type="button" class="btn_st btn_ico_pl SAMPLE_FILE_ADD_BTN" >파일추가</button></th>
      <td>
        <p class="txt_c_bl br">장애인증명서, 장애진단서, 복지카드 사본 등 통일부장관이 인정하는 장애에 해당하는 것을 증명할 수 있는 서류 (복수등록가능)</p>

        <!-- 첨부파일 -->
        <div class="file_multi">
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
          <div class="MAT5">
            <span class="file_uplode">
              <span class="file_name"><a href="#" class="file">장애인증명서.pdf</a>
                <a class="file_del" href="#"><span class="comment">파일제거</span></a>
              </span>
            </span>
          </div>
        </div>
        <!-- 첨부파일 끝 -->

        <!-- 첨부파일 -->
        <div class="file_multi SAMPLE_FILE_ADD_HERE SAMPLE_FILE_ADD_OFF">
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
          <button type="button" class="btn_st btn_ico_mn FloatRight SAMPLE_FILE_ADD_BTN SAMPLE_FILE_ADD_HERE SAMPLE_FILE_ADD_OFF" >제거</button>
          <div class="MAT5">
            <span class="file_uplode">
              <span class="file_name"><a href="#" class="file">장애인_복지카드.jpg</a>
                <a class="file_del" href="#"><span class="comment">파일제거</span></a>
              </span>
            </span>
          </div>
        </div>
        <!-- 첨부파일 끝 -->

      </td>
    </tr>




    <tr>
      <th>장기치료 증빙서류 <span class="imp_st">*</span></th>
      <td>
        <p class="txt_c_bl br">진단서, 입원 확인서 등 3개월 이상 치료가 필요하다는 것을 증명할 수 있는 서류</p>

        <!-- 첨부파일 -->
        <div class="file_multi">
          <a class="btn_st" href="#">파일찾기</a>
          <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
          <div class="MAT5">
            <span class="file_uplode">
              <span class="file_name"><a href="#" class="file">가족관계증명서.pdf</a>
                <a class="file_del" href="#"><span class="comment">파일제거</span></a>
              </span>
            </span>
          </div>
        </div>
        <!-- 첨부파일 끝 -->

      </td>
    </tr>


    <tr>
      <th>제3국 출생 자녀 양육 증빙서류  <span class="imp_st">*</span></th>
      <td>
        <p class="txt_c_bl br">기본증명서, 가족관계증명서, 주민등록표등본 등 제3국에서 출생한 자녀를 양육하는 것을 증명할 수 있는 서류 (복수등록가능)</p>

        <a class="btn_st" href="#">파일찾기</a>
        <!--<a class="btn_st btn_c_sc03" href="#">핸드폰에서 파일찾기</a>-->
        <a class="btn_st btn_c_sc02 SAMPLE_POP_02_BTN" href="#none">나의 문서함</a>
      </td>
    </tr>




  </tbody>
</table>





<p class="AlignRight  MAB10"><a href="#none" class="btn_st btn_ico_pl SAMPLE_POP_BTN">서명 파일 선택</a></p>


<div class="box_w_agree">
  <p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.
  </p>

  <p class="date">2022년 07월 28일</p>
  <div class="agree_sign">
    <div class="name">신청인 
      <input type="text" name="sWord222" id="sWord222" value="홍길동" placeholder="이름"  class="st_input i_w95 MAR20" /> 
      <p>인<img src="/support/img/content/s_sign01.png" alt="" class="sign_img"/></p>
    </div>
  </div>

  <p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
</div>




<div class="btn_g_btm">
  <a class="btn_st btn_c_wt btn_s_big" href="/support/su_sub/sb_g/temp/">임시저장</a>
  <a class="btn_st btn_c_gr btn_s_big" href="/support/su_sub/sb_g/write_02/">신청하기</a>
  <a class="btn_st btn_c_gy btn_s_big SAMPLE_POP_03_BTN" href="#none">삭제</a>
  <a class="btn_st btn_s_big" href="javascript:history.back();">취소</a>
</div>













<!-- popup -->
<div class="popup_wrap SAMPLE_POP_HERE SAMPLE_POP_OFF" >
  <div class="popup_bg SAMPLE_POP_CLOSE"></div>

  <!-- 팝업내용 -->
  <div class="popup_box SAMPLE_TOGGLE_HERE SAMPLE_POP_ON" style="width: 540px;">
    <div class="popup_tit">
      <div class="p_title">서명 선택</div>
    </div>
    <div class="popup_con pop_b_none">
      <div class="box_w_gray AlignCenter">
        등록된 서명이 없습니다. <br /><br />

        마이페이지 &gt; 나의 문서관리 &gt; <span class="txt_st_unb SAMPLE_TOGGLE_BTN">서명관리</span> 메뉴에서 <br />
        문서를 등록할 수 있습니다.
      </div>

      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big" href="/support/mypage/my_document/sign/">서명관리</a>
        <a class="btn_st btn_s_big SAMPLE_POP_CLOSE" href="#none">취소</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->



  <!-- 팝업내용 -->
  <div class="popup_box SAMPLE_TOGGLE_HERE SAMPLE_POP_OFF" style="width: 540px;">
    <div class="popup_tit">
      <div class="p_title">서명 선택</div>
    </div>
    <div class="popup_con pop_b_none">
      <div class="list_type_3 sign_c_list">
        <ul>
          <li>
            <input type="radio" id="sign_check11" name="sign_check" class="comment" checked="checked"/>
            <label class="sign_c_btn" for="sign_check11" >
              <p class="sign"><img src="/support/img/content/s_sign01.png" alt="" /></p>
              <p class="name">홍길동</p>
            </label>
          </li>
          <li>
            <input type="radio" id="sign_check22" name="sign_check" class="comment"/>
            <label class="sign_c_btn" for="sign_check22" >
              <p class="sign"><img src="/support/img/content/s_sign02.gif" alt="" /></p>
              <p class="name">홍민영</p>
            </label>
          </li>
          <li>
            <input type="radio" id="sign_check33" name="sign_check" class="comment" />
            <label class="sign_c_btn" for="sign_check33" >
              <p class="sign"><img src="/support/img/content/s_sign03.gif" alt="" /></p>
              <p class="name">이하나</p>
            </label>
          </li>
        </ul>
      </div>

      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big SAMPLE_POP_CLOSE" href="#none">서명선택</a>
        <a class="btn_st btn_s_big SAMPLE_TOGGLE_BTN" href="#none">취소</a>
      </div>

    </div>
    <!-- 팝업내용종료 -->


  </div>
</div>
<!-- //popup -->

















<!-- popup -->
<div class="popup_wrap SAMPLE_POP_02_HERE SAMPLE_POP_OFF" >
  <div class="popup_bg SAMPLE_POP_02_CLOSE"></div>

  <!-- 팝업내용 -->
  <div class="popup_box SAMPLE_TOGGLE_02_HERE SAMPLE_POP_ON" style="width: 540px;">
    <div class="popup_tit">
      <div class="p_title">나의 문서함</div>
    </div>
    <div class="popup_con pop_b_none">



      <div class="box_w_gray AlignCenter">
        등록된 문서가 없습니다. <br />
        자주 사용하는 문서를 문서함에 저장하여 이용하세요.<br /><br />

        마이페이지 &gt; 나의 문서관리 &gt; <span class="txt_st_unb SAMPLE_TOGGLE_02_BTN">문서관리</span> 메뉴에서 <br />
        문서를 등록할 수 있습니다.<br /><br />
      </div>


      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big" href="/support/mypage/my_document/docu/">문서관리</a>
        <a class="btn_st btn_s_big SAMPLE_POP_02_CLOSE" href="#none">닫기</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->



  <!-- 팝업내용 -->
  <div class="popup_box SAMPLE_TOGGLE_02_HERE SAMPLE_POP_OFF" style="width: 540px;">
    <div class="popup_tit">
      <div class="p_title">나의 문서함</div>
    </div>
    <div class="popup_con pop_b_none">



      <p class="p_h5"><b>문서를 선택하여 이용하세요.</b></p>

      <table class="table_style">
        <colgroup>
          <col width="65%" />
          <col width="20%" />
          <col width="15%" />
        </colgroup>

        <thead>
          <tr>
            <th>문서명</th>
            <th>등록일</th>
            <th>선택</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="AlignLeft">신분증 사본(홍길동)</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
          <tr>
            <td class="AlignLeft">통장사본(우리은행)</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
          <tr>
            <td class="AlignLeft">복지카드(홍길동)</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
          <tr>
            <td class="AlignLeft">장애인증명서(홍길동)-220607발급</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
          <tr>
            <td class="AlignLeft">장애인진단서(홍길동)-220607발급</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
          <tr>
            <td class="AlignLeft">북한이탈주민인증서(아빠 홍성훈)</td>
            <td>yyyy-mm-dd</td>
            <td><a class="btn_st btn_c_or btn_s_sml SAMPLE_POP_02_CLOSE" href="#none">선택</a></td>
          </tr>
        </tbody>
      </table>




      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_s_big SAMPLE_POP_02_CLOSE" href="#none">닫기</a>
        <a class="btn_st btn_s_big SAMPLE_TOGGLE_02_BTN" href="#none">(임시 이전 팝업)</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->


</div>
<!-- //popup -->


















<!-- popup -->
<div class="popup_wrap SAMPLE_POP_03_HERE SAMPLE_POP_OFF" >
  <div class="popup_bg SAMPLE_POP_03_CLOSE"></div>

  <!-- 팝업내용 -->
  <div class="popup_box">
    <div class="popup_tit">
      <div class="p_title">신청서 삭제</div>
    </div>
    <div class="popup_con pop_b_none">

      <div class="box_w_gray AlignCenter">
        신청서 삭제 시 작성한 내용이 모두 삭제됩니다. <br /><br />
        삭제 하시겠습니까?

      </div>

      <div class="btn_g_btm AlignCenter MAT0 MAB0">
        <a class="btn_st btn_c_gr btn_s_big" href="/support/mypage/sup_history/0001">삭제</a>
        <a class="btn_st btn_s_big SAMPLE_POP_03_CLOSE" href="#none">취소</a>
      </div>

    </div>
  </div>
  <!-- 팝업내용종료 -->
</div>
<!-- //popup --><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>