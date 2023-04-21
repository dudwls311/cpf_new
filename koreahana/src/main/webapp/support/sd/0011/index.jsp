<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><p class="FloatRight"><span class="imp_st">* 표시는 필수입력</span></p>
<h4 class="tit">지원사업 모집공고</h4>
<table class="table_style table_t_left th_v_m">
  <colgroup>
    <col width="20%" />
    <col width="*" />
  </colgroup>
  <tbody>
    <tr>
      <th>
        <label for="AAA11111">공개여부</label><span class="imp_st">*</span></th>
      <td>
          <input type="radio" name="AAAAA1" value="공개" id="AAA11111" checked="checked" class="st_radio"/><label for="AAA11111">공개</label>
          <input type="radio" name="AAAAA1" value="비공개" id="AAA111112" class="st_radio"/><label for="AAA111112">비공개</label>
      </td>
    </tr>

    <tr>
      <th>
        <label for="AAA22222">제목</label><span class="imp_st">*</span></th>
      <td>
          <input type="text" name="AAA22222" id="AAA22222" value="" class="st_input input_long"/>
      </td>
    </tr>

    <tr>
      <th>
        모집기간<span class="imp_st">*</span></th>
      <td>
          <label for="AAA3333" class="MAL0">모집 시작일 : </label><input type="text" name="AAA3333" id="AAA3333" class="st_input i_w95" value="" /> &nbsp; - &nbsp;  
          <label for="AAA3333" class="MAL0">모집 종료일 : </label><input type="text" name="AAA3333" id="AAA3333" class="st_input i_w95" value="" />
        

          <input type="checkbox" id="chk_check1" name="xxx" value="yyy" class="st_check"/><label for="chk_check1">상시모집</label>
          <input type="checkbox" id="chk_check2" name="xxx" value="yyy" class="st_check"/><label for="chk_check2">모집기간 미정</label>


      </td>
    </tr>

    <tr>
      <th>
        내용<span class="imp_st">*</span></th>
      <td>
        <div>
          <textarea class="st_textarea" style="height:200px">에디터 자리에 자리잡은 임시 에리어</textarea>
        </div>
      </td>
    </tr>

    <tr>
      <th>
        첨부파일 <a class="btn_st btn_ico_pl" href="#" titlt="첨부파일추가"><span class="comment">첨부파일추가</span></a></th>
      <td>
        <p class="file_uplode">
          <a class="btn_st" href="#">파일찾기</a>
          <span class="file_name">파일링크 이름
            <a class="file_del" href="#"><span class="comment">파일제거</span></a>
          </span>
        </p>
        <br/>
        <input type="file" size="30" id="file" />
      </td>
    </tr>

  </tbody>
</table>







<h4 class="tit">장학금 선발유형</h4>
<table class="table_style thd_v_m">
  <colgroup>
    <col width="*"/>
    <col width="17%"/>
    <col width="17%"/>
    <col width="17%"/>
    <col width="17%"/>
    <col width="17%"/>
  </colgroup>
  <thead>
    <tr>
      <th>선발유형</th>
      <th>대학원생</th>
      <th>대학생<br/>(일반/전문/사이버)</th>
      <th>계절학기<br/>(일반)</th>
      <th>중고등학생</th>
      <th>검정고시합격자</th>
    </tr>
  </thead>
  <tbody>


    <tr>
      <th>북한이탈주민</th>
      <td><input type="checkbox" id="aaa111" name="xxx" value="" class="st_check02" /><label for="aaa111"></label></td>
      <td><input type="checkbox" id="aaa112" name="xxx" value="" class="st_check02" /><label for="aaa112"></label></td>
      <td><input type="checkbox" id="aaa113" name="xxx" value="" class="st_check02" /><label for="aaa113"></label></td>
      <td><input type="checkbox" id="aaa114" name="xxx" value="" class="st_check02" /><label for="aaa114"></label></td>
      <td><input type="checkbox" id="aaa115" name="xxx" value="" class="st_check02" /><label for="aaa115"></label></td>
    </tr>
    <tr>
      <th>제3국 출생</th>
      <td><input type="checkbox" id="aaa121" name="xxx" value="" class="st_check02" /><label for="aaa121"></label></td>
      <td><input type="checkbox" id="aaa122" name="xxx" value="" class="st_check02" /><label for="aaa122"></label></td>
      <td><input type="checkbox" id="aaa123" name="xxx" value="" class="st_check02" /><label for="aaa123"></label></td>
      <td><input type="checkbox" id="aaa124" name="xxx" value="" class="st_check02" /><label for="aaa124"></label></td>
      <td><input type="checkbox" id="aaa125" name="xxx" value="" class="st_check02" /><label for="aaa125"></label></td>
    </tr>
    
    
  </tbody>
</table>

    
    



<h4 class="tit">제출서류</h4>
<p class="p_info">해당 공고문에 이미 제출된 신청서가 있을 경우 제출서류 내용을 수정/삭제/추가하시면 사후 관리에 문제가 될 수 있으니 주의해주세요.</p>
<table class="table_style table_t_left th_v_m">
  <colgroup>
    <col width="7%"/>
    <col width="10%"/>
    <col width="*"/>
    <col width="10%"/>
  </colgroup>
  <tbody>


    <tr>
      <th class="AlignCenter" rowspan="4"><button type="button" class="grab_menu"><span class="comment">파일 위치 이동</span></button></th>
      <th><label for="a0001">서류 명</label> <span class="imp_st">*</span></th>
      <td><input type="text" name="a0001" id="a0001" value="" class="st_input input_long" placeholder="공문" /></td>
      <th class="AlignCenter" rowspan="4"><a class="btn_st btn_ico_mn" href="#">삭제</a></th>
    </tr>
    <tr>
      <th><label for="a0002">설명</label></th>
      <td><input type="text" name="a0002" id="a0002" value="" class="st_input input_long" /></td>
    </tr>
    <tr>
      <th>유형</th>
      <td>
        <div class="st_check">
          <input type="checkbox" id="chk_check12" name="xxx" value="yyy" /><label for="chk_check12">필수 제출서류</label>
          <input type="checkbox" id="chk_check22" name="xxx" value="yyy" /><label for="chk_check22">복수등록가능</label>
        </div>
      </td>
    </tr>
    <tr>
      <th><label for="a0001">서식파일</label></th>
      <td>
        <p class="file_uplode">
          <a class="btn_st" href="#">파일찾기</a>
          <span class="file_name">파일링크 이름
            <a class="file_del" href="#"><span class="comment">파일제거</span></a>
          </span>
        </p>
      </td>
    </tr>
    
    
    
    <tr>
      <th class="AlignCenter" rowspan="4"><button type="button" class="grab_menu"><span class="comment">파일 위치 이동</span></button></th>
      <th><label for="a0001">서류 명</label> <span class="imp_st">*</span></th>
      <td><input type="text" name="a0001" id="a0001" value="" class="st_input input_long" placeholder="공문" /></td>
      <th class="AlignCenter" rowspan="4"><a class="btn_st btn_ico_mn" href="#">삭제</a></th>
    </tr>
    <tr>
      <th><label for="a0002">설명</label></th>
      <td><input type="text" name="a0002" id="a0002" value="" class="st_input input_long" /></td>
    </tr>
    <tr>
      <th>유형</th>
      <td>
        <div class="st_check">
          <input type="checkbox" id="chk_check13" name="xxx" value="yyy" /><label for="chk_check13">필수 제출서류</label>
          <input type="checkbox" id="chk_check23" name="xxx" value="yyy" /><label for="chk_check23">복수등록가능</label>
        </div>
      </td>
    </tr>
    <tr>
      <th><label for="a0001">서식파일</label></th>
      <td>
        <p class="file_uplode">
          <a class="btn_st" href="#">파일찾기</a>
          <span class="file_name">파일링크 이름
            <a class="file_del" href="#"><span class="comment">파일제거</span></a>
          </span>
        </p>
      </td>
    </tr>
    
    
  </tbody>
</table>

<div class="MAT-20"><a href="#" class="btn_st btn_c_sc02 btn_s_long"><img src="/support/img/common/btn_r_plus.png" alt="" /> 제출서류 항목 추가</a></div>




<div class="btn_g_btm">
  <a class="btn_st btn_c_gr btn_s_big" href="#">등록</a>
  <a class="btn_st btn_s_big" href="#">신청서 미리보기</a>
  <a class="btn_st btn_s_big" href="#">취소</a>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>
