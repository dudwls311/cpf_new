<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div class="cell_wrap">

  <div class="cell_box left_group">
    <form name="searchForm" id="searchForm" action="?">
      <div class="search_box MAB15">
        <input type="text" name="searchKeyword" id="searchKeyword" value=""  class="st_input"/>
        <button class="btn_st btn_c_gr" type="button" id="searchBtn">검색</button>
      </div>
    </form>						
    <div class="search_glist">
      <ul class="">

        <li data-authgrpid="30036" data-grpnm="일반사용자" class="active">
          <a href="#none">일반사용자</a>
        </li>

        <li data-authgrpid="30035" data-grpnm="북한이탈주민">
          <a href="#none">북한이탈주민</a>
        </li>

        <li data-authgrpid="30034" data-grpnm="센터상담사">
          <a href="#none">센터상담사</a>
        </li>

        <li data-authgrpid="30033" data-grpnm="재단직원">
          <a href="#none">재단직원</a>
        </li>

        <li data-authgrpid="30024" data-grpnm="유지보수팀">
          <a href="#none">유지보수팀</a>
        </li>

        <li data-authgrpid="30020" data-grpnm="최고관리자">
          <a href="#none">최고관리자</a>
        </li>

        <li data-authgrpid="30016" data-grpnm="탈퇴회원">
          <a href="#none">탈퇴회원</a>
        </li>

      </ul>
    </div>
  </div>

  <form id="writeForm" action="?" method="post">
    <input type="hidden" id="authGrpId" name="authGrpId" value="" />
    <input type="hidden" name="cmgmaMode" value="writeActionJson" />
    <div class="box_w_wht  PAT15">
      <table class="thd_v_m MAB15 PADDING10" style="width: 100%;background: #f2f2f2;padding: 10px;border-radius: 3px;">
        <colgroup>
          <col style="width:10%;" />
          <col style="width:10%;" />
          <col style="*" />
        </colgroup>
        <tbody>
          <tr>
            <th scope="row">그룹명</th>
            <td id="grpNmTd"></td>
            <td><button class="btn_st FloatRight" type="button" id="saveBtn" >저장</button></td>
          </tr>
        </tbody>
      </table>
      <table class="table_style MAB0">
        <colgroup>
          <col style="width:24%;"/>
          <col style="width:24%;"/>
          <col style="width:24%;"/>
        <col style="*"/>
        </colgroup>
        <thead>
          <tr>
            <th scope="col">1뎁스</th>
            <th scope="col">2뎁스</th>
            <th scope="col">3뎁스</th>
            <th scope="col">권한</th>
          </tr>
        </thead>
        <tbody>

          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1000000_redngAuthYn" name="1000000_redngAuthYn" value="Y" data-id="1000000" data-parent="0" data-lmenu="1000000" data-mmenu="" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1000000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1000000_streAuthYn" name="1000000_streAuthYn" value="Y" data-id="1000000" data-parent="0" data-lmenu="1000000" data-mmenu="" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1000000_streAuthYn">저장</label>
              <input type="checkbox" id="1000000_delAuthYn" name="1000000_delAuthYn" value="Y" data-id="1000000" data-parent="0" data-lmenu="1000000" data-mmenu="" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1000000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>긴급생계비</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1010000_redngAuthYn" name="1010000_redngAuthYn" value="Y" data-id="1010000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1010000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1010000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1010000_streAuthYn" name="1010000_streAuthYn" value="Y" data-id="1010000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1010000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1010000_streAuthYn">저장</label>
              <input type="checkbox" id="1010000_delAuthYn" name="1010000_delAuthYn" value="Y" data-id="1010000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1010000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1010000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>가산금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1020000_redngAuthYn" name="1020000_redngAuthYn" value="Y" data-id="1020000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1020000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1020000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1020000_streAuthYn" name="1020000_streAuthYn" value="Y" data-id="1020000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1020000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1020000_streAuthYn">저장</label>
              <input type="checkbox" id="1020000_delAuthYn" name="1020000_delAuthYn" value="Y" data-id="1020000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1020000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1020000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>장학금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1030000_redngAuthYn" name="1030000_redngAuthYn" value="Y" data-id="1030000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1030000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1030000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1030000_streAuthYn" name="1030000_streAuthYn" value="Y" data-id="1030000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1030000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1030000_streAuthYn">저장</label>
              <input type="checkbox" id="1030000_delAuthYn" name="1030000_delAuthYn" value="Y" data-id="1030000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1030000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1030000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>교육지원금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1040000_redngAuthYn" name="1040000_redngAuthYn" value="Y" data-id="1040000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1040000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1040000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1040000_streAuthYn" name="1040000_streAuthYn" value="Y" data-id="1040000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1040000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1040000_streAuthYn">저장</label>
              <input type="checkbox" id="1040000_delAuthYn" name="1040000_delAuthYn" value="Y" data-id="1040000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1040000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1040000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>화상영어</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1050000_redngAuthYn" name="1050000_redngAuthYn" value="Y" data-id="1050000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1050000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1050000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1050000_streAuthYn" name="1050000_streAuthYn" value="Y" data-id="1050000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1050000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1050000_streAuthYn">저장</label>
              <input type="checkbox" id="1050000_delAuthYn" name="1050000_delAuthYn" value="Y" data-id="1050000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1050000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1050000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>학습지</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1060000_redngAuthYn" name="1060000_redngAuthYn" value="Y" data-id="1060000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1060000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1060000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1060000_streAuthYn" name="1060000_streAuthYn" value="Y" data-id="1060000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1060000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1060000_streAuthYn">저장</label>
              <input type="checkbox" id="1060000_delAuthYn" name="1060000_delAuthYn" value="Y" data-id="1060000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1060000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1060000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>정착지원 전문관리사</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1070000_redngAuthYn" name="1070000_redngAuthYn" value="Y" data-id="1070000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1070000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1070000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1070000_streAuthYn" name="1070000_streAuthYn" value="Y" data-id="1070000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1070000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1070000_streAuthYn">저장</label>
              <input type="checkbox" id="1070000_delAuthYn" name="1070000_delAuthYn" value="Y" data-id="1070000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1070000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1070000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>취업바우처카드</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1080000_redngAuthYn" name="1080000_redngAuthYn" value="Y" data-id="1080000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1080000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1080000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1080000_streAuthYn" name="1080000_streAuthYn" value="Y" data-id="1080000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1080000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1080000_streAuthYn">저장</label>
              <input type="checkbox" id="1080000_delAuthYn" name="1080000_delAuthYn" value="Y" data-id="1080000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1080000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1080000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>사업공고(신청서) 관리</td>
            <td>취업연계 직업훈련</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="1090000_redngAuthYn" name="1090000_redngAuthYn" value="Y" data-id="1090000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1090000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="1090000_redngAuthYn">읽기</label>
              <input type="checkbox" id="1090000_streAuthYn" name="1090000_streAuthYn" value="Y" data-id="1090000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1090000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="1090000_streAuthYn">저장</label>
              <input type="checkbox" id="1090000_delAuthYn" name="1090000_delAuthYn" value="Y" data-id="1090000" data-parent="1000000" data-lmenu="1000000" data-mmenu="1090000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="1090000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2000000_redngAuthYn" name="2000000_redngAuthYn" value="Y" data-id="2000000" data-parent="0" data-lmenu="2000000" data-mmenu="" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2000000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2000000_streAuthYn" name="2000000_streAuthYn" value="Y" data-id="2000000" data-parent="0" data-lmenu="2000000" data-mmenu="" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2000000_streAuthYn">저장</label>
              <input type="checkbox" id="2000000_delAuthYn" name="2000000_delAuthYn" value="Y" data-id="2000000" data-parent="0" data-lmenu="2000000" data-mmenu="" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2000000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>의료비</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2010000_redngAuthYn" name="2010000_redngAuthYn" value="Y" data-id="2010000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2010000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2010000_streAuthYn" name="2010000_streAuthYn" value="Y" data-id="2010000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2010000_streAuthYn">저장</label>
              <input type="checkbox" id="2010000_delAuthYn" name="2010000_delAuthYn" value="Y" data-id="2010000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2010000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>의료비</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2010100_redngAuthYn" name="2010100_redngAuthYn" value="Y" data-id="2010100" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010100" data-auth="redngAuthYn" class="st_check" /><label for="2010100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2010100_streAuthYn" name="2010100_streAuthYn" value="Y" data-id="2010100" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010100" data-auth="streAuthYn" class="st_check" /><label for="2010100_streAuthYn">저장</label>
              <input type="checkbox" id="2010100_delAuthYn" name="2010100_delAuthYn" value="Y" data-id="2010100" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010100" data-auth="delAuthYn" class="st_check" /><label for="2010100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>의료비</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2010200_redngAuthYn" name="2010200_redngAuthYn" value="Y" data-id="2010200" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010200" data-auth="redngAuthYn" class="st_check" /><label for="2010200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2010200_streAuthYn" name="2010200_streAuthYn" value="Y" data-id="2010200" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010200" data-auth="streAuthYn" class="st_check" /><label for="2010200_streAuthYn">저장</label>
              <input type="checkbox" id="2010200_delAuthYn" name="2010200_delAuthYn" value="Y" data-id="2010200" data-parent="2010000" data-lmenu="2000000" data-mmenu="2010000" data-smenu="2010200" data-auth="delAuthYn" class="st_check" /><label for="2010200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>긴급생계비</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2020000_redngAuthYn" name="2020000_redngAuthYn" value="Y" data-id="2020000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2020000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2020000_streAuthYn" name="2020000_streAuthYn" value="Y" data-id="2020000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2020000_streAuthYn">저장</label>
              <input type="checkbox" id="2020000_delAuthYn" name="2020000_delAuthYn" value="Y" data-id="2020000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2020000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>긴급생계비</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2020100_redngAuthYn" name="2020100_redngAuthYn" value="Y" data-id="2020100" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020100" data-auth="redngAuthYn" class="st_check" /><label for="2020100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2020100_streAuthYn" name="2020100_streAuthYn" value="Y" data-id="2020100" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020100" data-auth="streAuthYn" class="st_check" /><label for="2020100_streAuthYn">저장</label>
              <input type="checkbox" id="2020100_delAuthYn" name="2020100_delAuthYn" value="Y" data-id="2020100" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020100" data-auth="delAuthYn" class="st_check" /><label for="2020100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>긴급생계비</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2020200_redngAuthYn" name="2020200_redngAuthYn" value="Y" data-id="2020200" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020200" data-auth="redngAuthYn" class="st_check" /><label for="2020200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2020200_streAuthYn" name="2020200_streAuthYn" value="Y" data-id="2020200" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020200" data-auth="streAuthYn" class="st_check" /><label for="2020200_streAuthYn">저장</label>
              <input type="checkbox" id="2020200_delAuthYn" name="2020200_delAuthYn" value="Y" data-id="2020200" data-parent="2020000" data-lmenu="2000000" data-mmenu="2020000" data-smenu="2020200" data-auth="delAuthYn" class="st_check" /><label for="2020200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>가산금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2030000_redngAuthYn" name="2030000_redngAuthYn" value="Y" data-id="2030000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2030000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2030000_streAuthYn" name="2030000_streAuthYn" value="Y" data-id="2030000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2030000_streAuthYn">저장</label>
              <input type="checkbox" id="2030000_delAuthYn" name="2030000_delAuthYn" value="Y" data-id="2030000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2030000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>가산금</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2030100_redngAuthYn" name="2030100_redngAuthYn" value="Y" data-id="2030100" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030100" data-auth="redngAuthYn" class="st_check" /><label for="2030100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2030100_streAuthYn" name="2030100_streAuthYn" value="Y" data-id="2030100" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030100" data-auth="streAuthYn" class="st_check" /><label for="2030100_streAuthYn">저장</label>
              <input type="checkbox" id="2030100_delAuthYn" name="2030100_delAuthYn" value="Y" data-id="2030100" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030100" data-auth="delAuthYn" class="st_check" /><label for="2030100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>가산금</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2030200_redngAuthYn" name="2030200_redngAuthYn" value="Y" data-id="2030200" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030200" data-auth="redngAuthYn" class="st_check" /><label for="2030200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2030200_streAuthYn" name="2030200_streAuthYn" value="Y" data-id="2030200" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030200" data-auth="streAuthYn" class="st_check" /><label for="2030200_streAuthYn">저장</label>
              <input type="checkbox" id="2030200_delAuthYn" name="2030200_delAuthYn" value="Y" data-id="2030200" data-parent="2030000" data-lmenu="2000000" data-mmenu="2030000" data-smenu="2030200" data-auth="delAuthYn" class="st_check" /><label for="2030200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>장학금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2040000_redngAuthYn" name="2040000_redngAuthYn" value="Y" data-id="2040000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2040000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2040000_streAuthYn" name="2040000_streAuthYn" value="Y" data-id="2040000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2040000_streAuthYn">저장</label>
              <input type="checkbox" id="2040000_delAuthYn" name="2040000_delAuthYn" value="Y" data-id="2040000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2040000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>장학금</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2040100_redngAuthYn" name="2040100_redngAuthYn" value="Y" data-id="2040100" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040100" data-auth="redngAuthYn" class="st_check" /><label for="2040100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2040100_streAuthYn" name="2040100_streAuthYn" value="Y" data-id="2040100" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040100" data-auth="streAuthYn" class="st_check" /><label for="2040100_streAuthYn">저장</label>
              <input type="checkbox" id="2040100_delAuthYn" name="2040100_delAuthYn" value="Y" data-id="2040100" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040100" data-auth="delAuthYn" class="st_check" /><label for="2040100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>장학금</td>
            <td>장학금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2040200_redngAuthYn" name="2040200_redngAuthYn" value="Y" data-id="2040200" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040200" data-auth="redngAuthYn" class="st_check" /><label for="2040200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2040200_streAuthYn" name="2040200_streAuthYn" value="Y" data-id="2040200" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040200" data-auth="streAuthYn" class="st_check" /><label for="2040200_streAuthYn">저장</label>
              <input type="checkbox" id="2040200_delAuthYn" name="2040200_delAuthYn" value="Y" data-id="2040200" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040200" data-auth="delAuthYn" class="st_check" /><label for="2040200_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>장학금</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2040300_redngAuthYn" name="2040300_redngAuthYn" value="Y" data-id="2040300" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040300" data-auth="redngAuthYn" class="st_check" /><label for="2040300_redngAuthYn">읽기</label>
              <input type="checkbox" id="2040300_streAuthYn" name="2040300_streAuthYn" value="Y" data-id="2040300" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040300" data-auth="streAuthYn" class="st_check" /><label for="2040300_streAuthYn">저장</label>
              <input type="checkbox" id="2040300_delAuthYn" name="2040300_delAuthYn" value="Y" data-id="2040300" data-parent="2040000" data-lmenu="2000000" data-mmenu="2040000" data-smenu="2040300" data-auth="delAuthYn" class="st_check" /><label for="2040300_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>교육지원금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2050000_redngAuthYn" name="2050000_redngAuthYn" value="Y" data-id="2050000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2050000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2050000_streAuthYn" name="2050000_streAuthYn" value="Y" data-id="2050000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2050000_streAuthYn">저장</label>
              <input type="checkbox" id="2050000_delAuthYn" name="2050000_delAuthYn" value="Y" data-id="2050000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2050000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>교육지원금</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2050100_redngAuthYn" name="2050100_redngAuthYn" value="Y" data-id="2050100" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050100" data-auth="redngAuthYn" class="st_check" /><label for="2050100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2050100_streAuthYn" name="2050100_streAuthYn" value="Y" data-id="2050100" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050100" data-auth="streAuthYn" class="st_check" /><label for="2050100_streAuthYn">저장</label>
              <input type="checkbox" id="2050100_delAuthYn" name="2050100_delAuthYn" value="Y" data-id="2050100" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050100" data-auth="delAuthYn" class="st_check" /><label for="2050100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>교육지원금</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2050200_redngAuthYn" name="2050200_redngAuthYn" value="Y" data-id="2050200" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050200" data-auth="redngAuthYn" class="st_check" /><label for="2050200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2050200_streAuthYn" name="2050200_streAuthYn" value="Y" data-id="2050200" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050200" data-auth="streAuthYn" class="st_check" /><label for="2050200_streAuthYn">저장</label>
              <input type="checkbox" id="2050200_delAuthYn" name="2050200_delAuthYn" value="Y" data-id="2050200" data-parent="2050000" data-lmenu="2000000" data-mmenu="2050000" data-smenu="2050200" data-auth="delAuthYn" class="st_check" /><label for="2050200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>화상영어</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2060000_redngAuthYn" name="2060000_redngAuthYn" value="Y" data-id="2060000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2060000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2060000_streAuthYn" name="2060000_streAuthYn" value="Y" data-id="2060000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2060000_streAuthYn">저장</label>
              <input type="checkbox" id="2060000_delAuthYn" name="2060000_delAuthYn" value="Y" data-id="2060000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2060000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>화상영어</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2060100_redngAuthYn" name="2060100_redngAuthYn" value="Y" data-id="2060100" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060100" data-auth="redngAuthYn" class="st_check" /><label for="2060100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2060100_streAuthYn" name="2060100_streAuthYn" value="Y" data-id="2060100" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060100" data-auth="streAuthYn" class="st_check" /><label for="2060100_streAuthYn">저장</label>
              <input type="checkbox" id="2060100_delAuthYn" name="2060100_delAuthYn" value="Y" data-id="2060100" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060100" data-auth="delAuthYn" class="st_check" /><label for="2060100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>화상영어</td>
            <td>화상영어 지원정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2060200_redngAuthYn" name="2060200_redngAuthYn" value="Y" data-id="2060200" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060200" data-auth="redngAuthYn" class="st_check" /><label for="2060200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2060200_streAuthYn" name="2060200_streAuthYn" value="Y" data-id="2060200" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060200" data-auth="streAuthYn" class="st_check" /><label for="2060200_streAuthYn">저장</label>
              <input type="checkbox" id="2060200_delAuthYn" name="2060200_delAuthYn" value="Y" data-id="2060200" data-parent="2060000" data-lmenu="2000000" data-mmenu="2060000" data-smenu="2060200" data-auth="delAuthYn" class="st_check" /><label for="2060200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>학습지</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2070000_redngAuthYn" name="2070000_redngAuthYn" value="Y" data-id="2070000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2070000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2070000_streAuthYn" name="2070000_streAuthYn" value="Y" data-id="2070000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2070000_streAuthYn">저장</label>
              <input type="checkbox" id="2070000_delAuthYn" name="2070000_delAuthYn" value="Y" data-id="2070000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2070000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>학습지</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2070100_redngAuthYn" name="2070100_redngAuthYn" value="Y" data-id="2070100" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070100" data-auth="redngAuthYn" class="st_check" /><label for="2070100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2070100_streAuthYn" name="2070100_streAuthYn" value="Y" data-id="2070100" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070100" data-auth="streAuthYn" class="st_check" /><label for="2070100_streAuthYn">저장</label>
              <input type="checkbox" id="2070100_delAuthYn" name="2070100_delAuthYn" value="Y" data-id="2070100" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070100" data-auth="delAuthYn" class="st_check" /><label for="2070100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>학습지</td>
            <td>학습지 지원정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2070200_redngAuthYn" name="2070200_redngAuthYn" value="Y" data-id="2070200" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070200" data-auth="redngAuthYn" class="st_check" /><label for="2070200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2070200_streAuthYn" name="2070200_streAuthYn" value="Y" data-id="2070200" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070200" data-auth="streAuthYn" class="st_check" /><label for="2070200_streAuthYn">저장</label>
              <input type="checkbox" id="2070200_delAuthYn" name="2070200_delAuthYn" value="Y" data-id="2070200" data-parent="2070000" data-lmenu="2000000" data-mmenu="2070000" data-smenu="2070200" data-auth="delAuthYn" class="st_check" /><label for="2070200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>정착지원 전문관리사</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2080000_redngAuthYn" name="2080000_redngAuthYn" value="Y" data-id="2080000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2080000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2080000_streAuthYn" name="2080000_streAuthYn" value="Y" data-id="2080000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2080000_streAuthYn">저장</label>
              <input type="checkbox" id="2080000_delAuthYn" name="2080000_delAuthYn" value="Y" data-id="2080000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2080000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>정착지원 전문관리사</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2080100_redngAuthYn" name="2080100_redngAuthYn" value="Y" data-id="2080100" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080100" data-auth="redngAuthYn" class="st_check" /><label for="2080100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2080100_streAuthYn" name="2080100_streAuthYn" value="Y" data-id="2080100" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080100" data-auth="streAuthYn" class="st_check" /><label for="2080100_streAuthYn">저장</label>
              <input type="checkbox" id="2080100_delAuthYn" name="2080100_delAuthYn" value="Y" data-id="2080100" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080100" data-auth="delAuthYn" class="st_check" /><label for="2080100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>정착지원 전문관리사</td>
            <td>교육 지원정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2080200_redngAuthYn" name="2080200_redngAuthYn" value="Y" data-id="2080200" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080200" data-auth="redngAuthYn" class="st_check" /><label for="2080200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2080200_streAuthYn" name="2080200_streAuthYn" value="Y" data-id="2080200" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080200" data-auth="streAuthYn" class="st_check" /><label for="2080200_streAuthYn">저장</label>
              <input type="checkbox" id="2080200_delAuthYn" name="2080200_delAuthYn" value="Y" data-id="2080200" data-parent="2080000" data-lmenu="2000000" data-mmenu="2080000" data-smenu="2080200" data-auth="delAuthYn" class="st_check" /><label for="2080200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>취업바우처카드</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2090000_redngAuthYn" name="2090000_redngAuthYn" value="Y" data-id="2090000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2090000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2090000_streAuthYn" name="2090000_streAuthYn" value="Y" data-id="2090000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2090000_streAuthYn">저장</label>
              <input type="checkbox" id="2090000_delAuthYn" name="2090000_delAuthYn" value="Y" data-id="2090000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2090000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>취업바우처카드</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2090100_redngAuthYn" name="2090100_redngAuthYn" value="Y" data-id="2090100" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090100" data-auth="redngAuthYn" class="st_check" /><label for="2090100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2090100_streAuthYn" name="2090100_streAuthYn" value="Y" data-id="2090100" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090100" data-auth="streAuthYn" class="st_check" /><label for="2090100_streAuthYn">저장</label>
              <input type="checkbox" id="2090100_delAuthYn" name="2090100_delAuthYn" value="Y" data-id="2090100" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090100" data-auth="delAuthYn" class="st_check" /><label for="2090100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>취업바우처카드</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2090200_redngAuthYn" name="2090200_redngAuthYn" value="Y" data-id="2090200" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090200" data-auth="redngAuthYn" class="st_check" /><label for="2090200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2090200_streAuthYn" name="2090200_streAuthYn" value="Y" data-id="2090200" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090200" data-auth="streAuthYn" class="st_check" /><label for="2090200_streAuthYn">저장</label>
              <input type="checkbox" id="2090200_delAuthYn" name="2090200_delAuthYn" value="Y" data-id="2090200" data-parent="2090000" data-lmenu="2000000" data-mmenu="2090000" data-smenu="2090200" data-auth="delAuthYn" class="st_check" /><label for="2090200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>미래행복통장</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2100000_redngAuthYn" name="2100000_redngAuthYn" value="Y" data-id="2100000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2100000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2100000_streAuthYn" name="2100000_streAuthYn" value="Y" data-id="2100000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2100000_streAuthYn">저장</label>
              <input type="checkbox" id="2100000_delAuthYn" name="2100000_delAuthYn" value="Y" data-id="2100000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2100000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>미래행복통장</td>
            <td>신규신청</td>
            <td class="td_bg">
              <input type="checkbox" id="2100100_redngAuthYn" name="2100100_redngAuthYn" value="Y" data-id="2100100" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100100" data-auth="redngAuthYn" class="st_check" /><label for="2100100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2100100_streAuthYn" name="2100100_streAuthYn" value="Y" data-id="2100100" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100100" data-auth="streAuthYn" class="st_check" /><label for="2100100_streAuthYn">저장</label>
              <input type="checkbox" id="2100100_delAuthYn" name="2100100_delAuthYn" value="Y" data-id="2100100" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100100" data-auth="delAuthYn" class="st_check" /><label for="2100100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>미래행복통장</td>
            <td>만기해지</td>
            <td class="td_bg">
              <input type="checkbox" id="2100200_redngAuthYn" name="2100200_redngAuthYn" value="Y" data-id="2100200" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100200" data-auth="redngAuthYn" class="st_check" /><label for="2100200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2100200_streAuthYn" name="2100200_streAuthYn" value="Y" data-id="2100200" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100200" data-auth="streAuthYn" class="st_check" /><label for="2100200_streAuthYn">저장</label>
              <input type="checkbox" id="2100200_delAuthYn" name="2100200_delAuthYn" value="Y" data-id="2100200" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100200" data-auth="delAuthYn" class="st_check" /><label for="2100200_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>미래행복통장</td>
            <td>중도해지</td>
            <td class="td_bg">
              <input type="checkbox" id="2100300_redngAuthYn" name="2100300_redngAuthYn" value="Y" data-id="2100300" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100300" data-auth="redngAuthYn" class="st_check" /><label for="2100300_redngAuthYn">읽기</label>
              <input type="checkbox" id="2100300_streAuthYn" name="2100300_streAuthYn" value="Y" data-id="2100300" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100300" data-auth="streAuthYn" class="st_check" /><label for="2100300_streAuthYn">저장</label>
              <input type="checkbox" id="2100300_delAuthYn" name="2100300_delAuthYn" value="Y" data-id="2100300" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100300" data-auth="delAuthYn" class="st_check" /><label for="2100300_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>미래행복통장</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2100400_redngAuthYn" name="2100400_redngAuthYn" value="Y" data-id="2100400" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100400" data-auth="redngAuthYn" class="st_check" /><label for="2100400_redngAuthYn">읽기</label>
              <input type="checkbox" id="2100400_streAuthYn" name="2100400_streAuthYn" value="Y" data-id="2100400" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100400" data-auth="streAuthYn" class="st_check" /><label for="2100400_streAuthYn">저장</label>
              <input type="checkbox" id="2100400_delAuthYn" name="2100400_delAuthYn" value="Y" data-id="2100400" data-parent="2100000" data-lmenu="2000000" data-mmenu="2100000" data-smenu="2100400" data-auth="delAuthYn" class="st_check" /><label for="2100400_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>취업연계 직업훈련</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2110000_redngAuthYn" name="2110000_redngAuthYn" value="Y" data-id="2110000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2110000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2110000_streAuthYn" name="2110000_streAuthYn" value="Y" data-id="2110000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2110000_streAuthYn">저장</label>
              <input type="checkbox" id="2110000_delAuthYn" name="2110000_delAuthYn" value="Y" data-id="2110000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2110000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>취업연계 직업훈련</td>
            <td>신청서 접수현황</td>
            <td class="td_bg">
              <input type="checkbox" id="2110100_redngAuthYn" name="2110100_redngAuthYn" value="Y" data-id="2110100" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110100" data-auth="redngAuthYn" class="st_check" /><label for="2110100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2110100_streAuthYn" name="2110100_streAuthYn" value="Y" data-id="2110100" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110100" data-auth="streAuthYn" class="st_check" /><label for="2110100_streAuthYn">저장</label>
              <input type="checkbox" id="2110100_delAuthYn" name="2110100_delAuthYn" value="Y" data-id="2110100" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110100" data-auth="delAuthYn" class="st_check" /><label for="2110100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>취업연계 직업훈련</td>
            <td>교육 지원정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2110200_redngAuthYn" name="2110200_redngAuthYn" value="Y" data-id="2110200" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110200" data-auth="redngAuthYn" class="st_check" /><label for="2110200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2110200_streAuthYn" name="2110200_streAuthYn" value="Y" data-id="2110200" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110200" data-auth="streAuthYn" class="st_check" /><label for="2110200_streAuthYn">저장</label>
              <input type="checkbox" id="2110200_delAuthYn" name="2110200_delAuthYn" value="Y" data-id="2110200" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110200" data-auth="delAuthYn" class="st_check" /><label for="2110200_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>취업연계 직업훈련</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2110300_redngAuthYn" name="2110300_redngAuthYn" value="Y" data-id="2110300" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110300" data-auth="redngAuthYn" class="st_check" /><label for="2110300_redngAuthYn">읽기</label>
              <input type="checkbox" id="2110300_streAuthYn" name="2110300_streAuthYn" value="Y" data-id="2110300" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110300" data-auth="streAuthYn" class="st_check" /><label for="2110300_streAuthYn">저장</label>
              <input type="checkbox" id="2110300_delAuthYn" name="2110300_delAuthYn" value="Y" data-id="2110300" data-parent="2110000" data-lmenu="2000000" data-mmenu="2110000" data-smenu="2110300" data-auth="delAuthYn" class="st_check" /><label for="2110300_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>경영개선자금</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2120000_redngAuthYn" name="2120000_redngAuthYn" value="Y" data-id="2120000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2120000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2120000_streAuthYn" name="2120000_streAuthYn" value="Y" data-id="2120000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2120000_streAuthYn">저장</label>
              <input type="checkbox" id="2120000_delAuthYn" name="2120000_delAuthYn" value="Y" data-id="2120000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2120000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>경영개선자금</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2120100_redngAuthYn" name="2120100_redngAuthYn" value="Y" data-id="2120100" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120100" data-auth="redngAuthYn" class="st_check" /><label for="2120100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2120100_streAuthYn" name="2120100_streAuthYn" value="Y" data-id="2120100" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120100" data-auth="streAuthYn" class="st_check" /><label for="2120100_streAuthYn">저장</label>
              <input type="checkbox" id="2120100_delAuthYn" name="2120100_delAuthYn" value="Y" data-id="2120100" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120100" data-auth="delAuthYn" class="st_check" /><label for="2120100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>경영개선자금</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2120200_redngAuthYn" name="2120200_redngAuthYn" value="Y" data-id="2120200" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120200" data-auth="redngAuthYn" class="st_check" /><label for="2120200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2120200_streAuthYn" name="2120200_streAuthYn" value="Y" data-id="2120200" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120200" data-auth="streAuthYn" class="st_check" /><label for="2120200_streAuthYn">저장</label>
              <input type="checkbox" id="2120200_delAuthYn" name="2120200_delAuthYn" value="Y" data-id="2120200" data-parent="2120000" data-lmenu="2000000" data-mmenu="2120000" data-smenu="2120200" data-auth="delAuthYn" class="st_check" /><label for="2120200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원대상 관리</td>
            <td>영농정착</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="2130000_redngAuthYn" name="2130000_redngAuthYn" value="Y" data-id="2130000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="2130000_redngAuthYn">읽기</label>
              <input type="checkbox" id="2130000_streAuthYn" name="2130000_streAuthYn" value="Y" data-id="2130000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="2130000_streAuthYn">저장</label>
              <input type="checkbox" id="2130000_delAuthYn" name="2130000_delAuthYn" value="Y" data-id="2130000" data-parent="2000000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="2130000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원대상 관리</td>
            <td>영농정착</td>
            <td>지원금 지급정보</td>
            <td class="td_bg">
              <input type="checkbox" id="2130100_redngAuthYn" name="2130100_redngAuthYn" value="Y" data-id="2130100" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130100" data-auth="redngAuthYn" class="st_check" /><label for="2130100_redngAuthYn">읽기</label>
              <input type="checkbox" id="2130100_streAuthYn" name="2130100_streAuthYn" value="Y" data-id="2130100" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130100" data-auth="streAuthYn" class="st_check" /><label for="2130100_streAuthYn">저장</label>
              <input type="checkbox" id="2130100_delAuthYn" name="2130100_delAuthYn" value="Y" data-id="2130100" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130100" data-auth="delAuthYn" class="st_check" /><label for="2130100_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>지원대상 관리</td>
            <td>영농정착</td>
            <td>통계</td>
            <td class="td_bg">
              <input type="checkbox" id="2130200_redngAuthYn" name="2130200_redngAuthYn" value="Y" data-id="2130200" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130200" data-auth="redngAuthYn" class="st_check" /><label for="2130200_redngAuthYn">읽기</label>
              <input type="checkbox" id="2130200_streAuthYn" name="2130200_streAuthYn" value="Y" data-id="2130200" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130200" data-auth="streAuthYn" class="st_check" /><label for="2130200_streAuthYn">저장</label>
              <input type="checkbox" id="2130200_delAuthYn" name="2130200_delAuthYn" value="Y" data-id="2130200" data-parent="2130000" data-lmenu="2000000" data-mmenu="2130000" data-smenu="2130200" data-auth="delAuthYn" class="st_check" /><label for="2130200_delAuthYn">삭제</label>
            </td>
          </tr>






          <tr>
            <td>지원이력 조회</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="3000000_redngAuthYn" name="3000000_redngAuthYn" value="Y" data-id="3000000" data-parent="0" data-lmenu="3000000" data-mmenu="" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="3000000_redngAuthYn">읽기</label>
              <input type="checkbox" id="3000000_streAuthYn" name="3000000_streAuthYn" value="Y" data-id="3000000" data-parent="0" data-lmenu="3000000" data-mmenu="" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="3000000_streAuthYn">저장</label>
              <input type="checkbox" id="3000000_delAuthYn" name="3000000_delAuthYn" value="Y" data-id="3000000" data-parent="0" data-lmenu="3000000" data-mmenu="" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="3000000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>지원이력 조회</td>
            <td>지원이력조회</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="3010000_redngAuthYn" name="3010000_redngAuthYn" value="Y" data-id="3010000" data-parent="3000000" data-lmenu="3000000" data-mmenu="3010000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="3010000_redngAuthYn">읽기</label>
              <input type="checkbox" id="3010000_streAuthYn" name="3010000_streAuthYn" value="Y" data-id="3010000" data-parent="3000000" data-lmenu="3000000" data-mmenu="3010000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="3010000_streAuthYn">저장</label>
              <input type="checkbox" id="3010000_delAuthYn" name="3010000_delAuthYn" value="Y" data-id="3010000" data-parent="3000000" data-lmenu="3000000" data-mmenu="3010000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="3010000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>설정</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="4000000_redngAuthYn" name="4000000_redngAuthYn" value="Y" data-id="4000000" data-parent="0" data-lmenu="4000000" data-mmenu="" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="4000000_redngAuthYn">읽기</label>
              <input type="checkbox" id="4000000_streAuthYn" name="4000000_streAuthYn" value="Y" data-id="4000000" data-parent="0" data-lmenu="4000000" data-mmenu="" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="4000000_streAuthYn">저장</label>
              <input type="checkbox" id="4000000_delAuthYn" name="4000000_delAuthYn" value="Y" data-id="4000000" data-parent="0" data-lmenu="4000000" data-mmenu="" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="4000000_delAuthYn">삭제</label>
            </td>
          </tr>




          <tr>
            <td>설정</td>
            <td>지원사업설정</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="4010000_redngAuthYn" name="4010000_redngAuthYn" value="Y" data-id="4010000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4010000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="4010000_redngAuthYn">읽기</label>
              <input type="checkbox" id="4010000_streAuthYn" name="4010000_streAuthYn" value="Y" data-id="4010000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4010000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="4010000_streAuthYn">저장</label>
              <input type="checkbox" id="4010000_delAuthYn" name="4010000_delAuthYn" value="Y" data-id="4010000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4010000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="4010000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>설정</td>
            <td>사용자관리</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="4020000_redngAuthYn" name="4020000_redngAuthYn" value="Y" data-id="4020000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4020000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="4020000_redngAuthYn">읽기</label>
              <input type="checkbox" id="4020000_streAuthYn" name="4020000_streAuthYn" value="Y" data-id="4020000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4020000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="4020000_streAuthYn">저장</label>
              <input type="checkbox" id="4020000_delAuthYn" name="4020000_delAuthYn" value="Y" data-id="4020000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4020000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="4020000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>설정</td>
            <td>그룹별 메뉴권한 관리</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="4030000_redngAuthYn" name="4030000_redngAuthYn" value="Y" data-id="4030000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4030000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="4030000_redngAuthYn">읽기</label>
              <input type="checkbox" id="4030000_streAuthYn" name="4030000_streAuthYn" value="Y" data-id="4030000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4030000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="4030000_streAuthYn">저장</label>
              <input type="checkbox" id="4030000_delAuthYn" name="4030000_delAuthYn" value="Y" data-id="4030000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4030000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="4030000_delAuthYn">삭제</label>
            </td>
          </tr>





          <tr>
            <td>설정</td>
            <td>개인별 메뉴권한 관리</td>
            <td>&nbsp;</td>
            <td class="td_bg">
              <input type="checkbox" id="4040000_redngAuthYn" name="4040000_redngAuthYn" value="Y" data-id="4040000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4040000" data-smenu="" data-auth="redngAuthYn" class="st_check" /><label for="4040000_redngAuthYn">읽기</label>
              <input type="checkbox" id="4040000_streAuthYn" name="4040000_streAuthYn" value="Y" data-id="4040000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4040000" data-smenu="" data-auth="streAuthYn" class="st_check" /><label for="4040000_streAuthYn">저장</label>
              <input type="checkbox" id="4040000_delAuthYn" name="4040000_delAuthYn" value="Y" data-id="4040000" data-parent="4000000" data-lmenu="4000000" data-mmenu="4040000" data-smenu="" data-auth="delAuthYn" class="st_check" /><label for="4040000_delAuthYn">삭제</label>
            </td>
          </tr>



        </tbody>
      </table>
    </div>
  </form>
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>
