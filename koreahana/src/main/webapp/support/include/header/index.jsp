<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div id="header">

<c:if test="${not empty loginVO }">
<script>

	var timeInterval = null; 
	$(document).ready(function(){
		
		//로그인 유효시간
		timeInterval = setInterval(fnSetIntervalLoginInvaildTime, 1000);
	});

	function fnLogout(){
		$.ajax({
			type:'post'
			,url:'/uat/uia/actionLogout.do'
			,success:function(data){
				clearInterval(timeInterval);
				alert('장시간 미사용으로 인해 로그아웃 됩니다.');
				location.href='/support/login.jsp';
			}
			,error:function(error){
				//console.log(error);
			}
		});
	}
	
	function fnSetIntervalLoginInvaildTime(){
		var invalidTimeText = ' ('+fnSecondToMinute()+')';
		$("#loginInvalidTimeSpan").text(invalidTimeText);
	}
	
	var loginSecond = 60;
	<c:choose>
		<c:when test="${loginVO.typeId == '30035' || loginVO.typeId == '30036' }">
			loginSecond = 1800;
		</c:when>
		<c:otherwise>
			//loginSecond = 14400;
			loginSecond = 7200;
		</c:otherwise>
	</c:choose>
	
	function fnSecondToMinute() {
		loginSecond--;
		
		var hour = Math.floor( (loginSecond / 60) / 60 );
		var min = Math.floor( (loginSecond / 60) % 60 );
		var sec = Math.floor( (loginSecond % 60) );
		
		if(hour > 0 && min < 10) min = '0'+min;
		if(sec < 10) sec = '0'+sec;
		
		if(hour == 0 && min == 0 && sec == 0){
			fnLogout();
			return '로그인 만료';
		}else{
			return (hour > 0 ? hour+':' : '')+min+":"+sec;
		}
	}
</script>
</c:if>

  <ul id="skip">
    <li><a href="#fast_cont">본문 바로가기</a></li>
  </ul>
  <div class="container">
    <h1 class="h1_logo"><a href="/support/"><img src="/support/img/common/logo_h1.png" alt="남북하나재단" /></a></h1>
    <div class="gnv">
      <ul>
        
		<!-- 탑메뉴 코드 시작 -->
			<c:import url="/menu/getTopMenu.do">
				<c:param name="target" value="sup_top" />
				<c:param name="menuNm" value="지원사업 소개" />
				<c:param name="depth" value="2" />
				<c:param name="order" value="52" />
			</c:import>
		<!-- 탑메뉴 코드 끝 -->	
		<!-- 탑메뉴 코드 시작 -->
			<c:import url="/menu/getTopMenu.do">
				<c:param name="target" value="sup_top" />
				<c:param name="menuNm" value="지원사업 신청" />
				<c:param name="depth" value="2" />
				<c:param name="order" value="2" />
			</c:import>
		<!-- 탑메뉴 코드 끝 -->	
		<!-- 탑메뉴 코드 시작 -->
			<c:import url="/menu/getTopMenu.do">
				<c:param name="target" value="sup_top" />
				<c:param name="menuNm" value="커뮤니티" />
				<c:param name="depth" value="2" />
				<c:param name="order" value="54" />
			</c:import>
		<!-- 탑메뉴 코드 끝 -->	
      </ul>
    </div>

	<div class="util_menu">
		<div class="login_wrap">
			<c:if test="${not empty loginVO }">
				<span class="login_type lgt_0${isCenterStaff?'2':(isFoundStaff?'1':'0') }"><c:out value="${loginVO.typeVO.typeNm }" /></span>								
				<button type="button" class="member_name"><c:out value="${loginVO.mbrNm }" /><span id="loginInvalidTimeSpan"> (0:00)</span></button>
				<div id="login_tab" class="login_tab" style="display: none;">
					<ul>
						<li><a href="<c:url value="/support/mypage/myinfo/info_edit/" />">마이페이지</a></li>
						<li><a href="<c:url value="/support/mypage/sup_history/" />">신청이력</a></li>
                      	<li><a href="<c:url value="/support/mypage/qna_history/" />">1:1문의</a></li>
                      	<li><a href="<c:url value="/support/mypage/my_document/sign/" />">서명관리</a></li>
						<li><a href="<c:url value="/support/mypage/my_document/docu/" />">문서관리</a></li>
						<li><a href="<c:url value="/uat/uia/actionLogout.do" />">로그아웃</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${empty loginVO }">
				<a href="<c:url value="/support/login.jsp" />">로그인</a>
			</c:if>
		</div>
		<div class="h_search_inner">
			<div class="h_search_btn"><a href="/support/"><img src="/support/img/common/icon_search_02.png" /></a></div>
		</div>
    </div>
    
  </div>
</div><% /*<!-- /[-CONTENT-] -->*/ %>
