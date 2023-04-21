<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div id="header">
  <ul id="skip">
    <li><a href="#content">본문 바로가기</a></li>
  </ul>
  <div class="container">
    <h1 class="h1_logo"><a href="#none"><img src="/support/img/common/logo_h1.png" alt="남북하나재단" /></a></h1>
    <div class="gnv">
      <ul>
        
			<c:import url="/menu/getTopMenu.do">
				<c:param name="target" value="sup_top" />
				<c:param name="menuNm" value="지원사업 소개" />
				<c:param name="depth" value="2" />
				<c:param name="order" value="1" />
			</c:import>
		<!-- 탑메뉴 코드 끝 -->	
      </ul>
    </div>



    <div class="util_menu">
      <div class="login_wrap">
        <c:if test="${loginVO.mbrId == null }">
          <a href="${pageContext.request.contextPath }/${Jnit_sitePath}/login.jsp">로그인</a>            
        </c:if>
        <c:if test="${loginVO.mbrId != null }">

          <span class="login_type lgt_01">북한이탈주민</span>
          <button type="button" class="member_name">홍길동</button>
          <!-- lgt_00 or x 일반인 lgt_01 북한이탈주민 lgt_02 ~~하나센터-->
          <div class="login_tab" style="display:none;">
            <ul>
              <li><a href="/support/mypage/">마이페이지</a></li>
              <!--<li><a href="${pageContext.request.contextPath }/${Jnit_sitePath}/mbr/myPage.jsp">마이페이지</a></li> -->
              <li><a href="${pageContext.request.contextPath }/uat/uia/actionLogout.do">로그아웃</a></li>
            </ul>
          </div>
        </c:if>
      </div>

      <div class="h_search_inner">
        <input type="text" name="h_search_box" id="h_search_box" value="" class="h_search_txt" placeholder="검색어를 입력하세요." />
        <div class="h_search_btn"><a href="#none"><img src="/support/img/common/icon_search_02.png" /></a></div>
      </div>

    </div>
  </div>
</div><% /*<!-- /[-CONTENT-] -->*/ %>
