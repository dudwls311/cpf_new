<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000021_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><%-- 
	게시판 code 사용법
	* boardid : 게시판 아이디
	* useSkeleton : true로 입력하면 게시판의 html 뼈대 없이 가져옵니다.
	* customSkin : 게시판 설정을 무시하고 스킨 설정
--%>
<jsp:include page="/${ctxRoot}/board/board.do">
	<jsp:param name="boardId" value="bbs_0000000000000002"/>
	<jsp:param name="fixedCategory" value=""/>
	<jsp:param name="useSkeleton" value="true"/>
	<jsp:param name="customSkin" value=""/>
	<jsp:param name="isMobile" value="false"/>
</jsp:include>

  
<%--

<div class="box_w_suc box_s_add">
  <h3 class="suc_tit">1:1문의 작성하기</h3>
  <p class="AlignCenter MAB30">북한이탈주민 지원사업에 관련하여 궁금한 점이 있으시면 문의해 주세요</p>
  <div class="AlignLeft">

    <div class="MAB20">
      <label for="B09">문의 제목</label>
      <input type="text" name="B09" id="B09" value="" class="st_input input_long" />
    </div>

    <div class="MAB20">
      <label for="B09">문의 내용</label> 
      <textarea class="st_textarea"></textarea>
    </div>
    <p class="AlignCenter ">문의에 대한 답변은 마이페이지 &gt; <span class="txt_st_unb">1:1문의 이력</span> 메뉴에서 확인 할 수 있습니다.</p>

  </div>
</div>
<div class="box_w_suc PADDING20 AlignLeft" style="background:#fff;">
  <ul class="ul_st02">
    <li><b>고객센터</b> 평일 9:00~18:00 (점심시간 : 12:00~13:00)</li>
    <li><b>전화번호</b> 02-0000-0000</li>
    <li><b>이메일</b> email@emai.com</li>
  </ul>

</div>
<div class="btn_g_btm">
  <a class="btn_st btn_c_bk btn_s_big btn_s_long" href="/support/commu/0005/">문의내용 등록하기</a>
</div>

--%><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000021_E.jsp' %>