<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><%-- 
	게시판 code 사용법
	* boardid : 게시판 아이디
	* useSkeleton : true로 입력하면 게시판의 html 뼈대 없이 가져옵니다.
	* customSkin : 게시판 설정을 무시하고 스킨 설정
--%>
<jsp:include page="/${ctxRoot}/board/board.do">
	<jsp:param name="boardId" value="bbs_0000000000000003"/>
	<jsp:param name="fixedCategory" value=""/>
	<jsp:param name="useSkeleton" value="true"/>
	<jsp:param name="customSkin" value=""/>
	<jsp:param name="isMobile" value="false"/>
</jsp:include>



<%--
<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class="FloatRight">
    <input type="text" name="isWord2" id="isWord2" class="st_input MAL10 PAR25" value="" placeholder="제목 또는 내용으로 검색
"/>
    <button type="button" class="ico_search"><span class="comment">검색</span></button>
  </div>
</div>


<table class="table_style thd_v_m">
  <colgroup>
    <col width="7%" />
    <col width="*" />
    <col width="15%" />
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>제목</th>
      <th>등록일</th>
    </tr>
  </thead>
  <tbody>
    <tr class="tr_bg_re">
      <td><b class="txt_c_re">공지</b></td>
      <td class="AlignLeft"><a href="#" class="btn_a">( 2021 ) 북한이탈주민 사회통합조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>9</td>
      <td class="AlignLeft"><a href="#" class="btn_a">( 2021 ) 북한이탈주민 정착실태조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>

    <tr>
      <td>8</td>
      <td class="AlignLeft"><a href="#" class="btn_a">( 2020 ) 탈북청소년 실태조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>7</td>
      <td class="AlignLeft"><a href="#" class="btn_a">( 2020 ) 북한이탈주민 사회통합조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>6</td>
      <td class="AlignLeft"><a href="#" class="btn_a">( 2020 ) 북한이탈주민 정착실태조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>5</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2021년 통일부 업무보고
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>4</td>
      <td class="AlignLeft"><a href="#" class="btn_a">북한이탈주민을 통해 본 남북한 질병언어 소통 사례집 발간
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>3</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2020 북한이탈주민 정착지원 실무편람
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>2</td>
      <td class="AlignLeft"><a href="#" class="btn_a">탈북민 정보 처리자를 위한 개인정보 보호 안내 리플렛
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>
    <tr>
      <td>1</td>
      <td class="AlignLeft"><a href="#" class="btn_a">2019년 북한이탈주민 사회통합조사
      </a></td>
      <td>yyyy-mm-dd</td>
    </tr>

  </tbody>
</table>




<div class="con_b_bt AlignCenter MAB30">
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

--%><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>