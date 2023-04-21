<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<html>
	<head>
		<title>남북하나재단</title>
		<%@include file="/WEB-INF/jsp/exts/koreahana/com/header_inc.jsp" %>
		<script type="text/javascript">
			var isStreAuth = ${!empty isStreAuth?isStreAuth:'false'};
		    var isRedngAuth = ${!empty isRedngAuth?isRedngAuth:'false'};
		    var isDelAuth = ${!empty isDelAuth?isDelAuth:'false'};
		    var isPrntgAuth = ${!empty isPrntgAuth?isPrntgAuth:'false'};
		    
		    var actionUrl = '${actionUrl}';
		    
		    
		    function fnShowInfo(){
		    	var obj = $("#login_tab");
		    	var isVisible = obj.is(':visible');
		    	if(isVisible) obj.hide();
		    	else obj.show();
		    }
		    
		    function fnHelpPopup(curMmenuSn){
		    	var domain = 'https://online.nkrf.or.kr';
		    	var popupLink = '';
		    	var popupOption = 'width=1500,height=700,resizeable=yes,scrollbars=yes,status=no';
		    	
		    	//사업신청공고
		    	if(curMmenuSn == 'main') popupLink = '/guide/etc/0001/';					//메인
		    	else if(curMmenuSn == '1010000') popupLink = '/guide/etc/0002/0011/0001/';	//긴급생계비
		    	else if(curMmenuSn == '1020000') popupLink = '/guide/etc/0002/0012/0001/';	//가산금
		    	else if(curMmenuSn == '1030000') popupLink = '/guide/etc/0002/0013/0001/';  //장학금
		    	else if(curMmenuSn == '1040000') popupLink = '/guide/etc/0002/0014/0001/';  //교육지원금
		    	else if(curMmenuSn == '1050000') popupLink = '/guide/etc/0002/0015/0001/';  //화상영어
		    	else if(curMmenuSn == '1060000') popupLink = '/guide/etc/0002/0016/0001/';  //학습지
		    	else if(curMmenuSn == '1070000') popupLink = '/guide/etc/0002/0017/0001/';  //정착지원 전문관리사
		    	else if(curMmenuSn == '1080000') popupLink = '/guide/etc/0002/0018/0001/';  //취업바우처카드
		    	else if(curMmenuSn == '1090000') popupLink = '/guide/etc/0002/0019/0001/';  //취업연계 직업훈련
		    	
		    	//지원대상 관리
		    	else if(curMmenuSn == '2010100') popupLink = '/guide/etc/0003/0001/0001/';		//의료비(지원금 지급정보)
		    	else if(curMmenuSn == '2010200') popupLink = '/guide/etc/0003/0001/0002/';		//의료비(통계)
		    	else if(curMmenuSn == '2020100') popupLink = '/guide/etc/0003/0002/0001/';		//긴급생계비(신청서 접수현황)
		    	else if(curMmenuSn == '2020200') popupLink = '/guide/etc/0003/0002/0002/';		//긴급생계비(지원금 지급정보)
		    	else if(curMmenuSn == '2030100') popupLink = '/guide/etc/0003/0003/0001/';		//가산금(신청서 접수현황)
		    	else if(curMmenuSn == '2030200') popupLink = '/guide/etc/0003/0003/0002/';		//가산금(지원금 지급정보)
		    	else if(curMmenuSn == '2030300') popupLink = '/guide/etc/0003/0003/0003/';		//가산금(통계)
		    	else if(curMmenuSn == '2040100') popupLink = '/guide/etc/0003/0004/0001/';		//장학금(신청서 접수현황)
		    	else if(curMmenuSn == '2040200') popupLink = '/guide/etc/0003/0004/0002/';		//장학금(장학금 지급정보)
		    	else if(curMmenuSn == '2040300') popupLink = '/guide/etc/0003/0004/0003/';		//장학금(통계)
		    	else if(curMmenuSn == '2050100') popupLink = '/guide/etc/0003/0005/0001/';		//교육지원금(신청서 접수현황)
		    	else if(curMmenuSn == '2050200') popupLink = '/guide/etc/0003/0005/0002/';		//교육지원금(지원금 지급정보)
		    	else if(curMmenuSn == '2060100') popupLink = '/guide/etc/0003/0006/0001/';		//화상영어(신청서 접수현황)
		    	else if(curMmenuSn == '2060200') popupLink = '/guide/etc/0003/0006/0002/';		//화상영어(화상영어 지원정보)
		    	else if(curMmenuSn == '2070100') popupLink = '/guide/etc/0003/0007/0001/';		//학습지(신청서 접수현황)
		    	else if(curMmenuSn == '2070200') popupLink = '/guide/etc/0003/0007/0002/';		//학습지(학습지 지원정보)
		    	else if(curMmenuSn == '2080100') popupLink = '/guide/etc/0003/0008/0001/';		//전문관리사(신청서 접수현황)
		    	else if(curMmenuSn == '2080200') popupLink = '/guide/etc/0003/0008/0002/';		//전문관리사(교육 지원정보)
		    	else if(curMmenuSn == '2090100') popupLink = '/guide/etc/0003/0009/0001/';		//취업바우처카드(신청서 접수현황)
		    	else if(curMmenuSn == '2090200') popupLink = '/guide/etc/0003/0009/0002/';		//취업바우처카드(지원금 지급정보)
		    	else if(curMmenuSn == '2090300') popupLink = '/guide/etc/0003/0009/0003/';		//취업바우처카드(카드사용 정보)
		    	else if(curMmenuSn == '2100100') popupLink = '/guide/etc/0003/0010/0001/';		//미래행복통장(신규신청)
		    	else if(curMmenuSn == '2100200') popupLink = '/guide/etc/0003/0010/0002/';		//미래행복통장(만기해지)
		    	else if(curMmenuSn == '2100300') popupLink = '/guide/etc/0003/0010/0003/';		//미래행복통장(중도해지)
		    	else if(curMmenuSn == '2100400') popupLink = '/guide/etc/0003/0010/0004/';		//미래행복통장(통계)
		    	else if(curMmenuSn == '2110100') popupLink = '/guide/etc/0003/0011/0001/';		//취업연계 직업훈련(신청서 접수현황)
		    	else if(curMmenuSn == '2110200') popupLink = '/guide/etc/0003/0011/0002/';		//취업연계 직업훈련(교육 지원정보)
		    	else if(curMmenuSn == '2110300') popupLink = '/guide/etc/0003/0011/0003/';		//취업연계 직업훈련(통계)
		    	else if(curMmenuSn == '2120100') popupLink = '/guide/etc/0003/0012/0001/';		//경영개선자금(지원금 지급정보)
		    	else if(curMmenuSn == '2120200') popupLink = '/guide/etc/0003/0012/0002/';		//경영개선자금(통계)
		    	else if(curMmenuSn == '2130100') popupLink = '/guide/etc/0003/0013/0001/';		//영농정착(지원금 지급정보)
		    	else if(curMmenuSn == '2130200') popupLink = '/guide/etc/0003/0013/0002/';		//영농정착(통계)
		    	//지원이력조회
		    	else if(curMmenuSn == '3010000') popupLink = '/guide/etc/0004/0001/';
		    	//설정
		    	else if(curMmenuSn == '4010000') popupLink = '/guide/etc/0005/0001/';			//지원사업설정
		    	else if(curMmenuSn == '4020000') popupLink = '/guide/etc/0005/0002/';			//사용자관리
		    	else if(curMmenuSn == '4030000') popupLink = '/guide/etc/0005/0003/';			//그룹별 메뉴권한 관리
		    	else if(curMmenuSn == '4040000') popupLink = '/guide/etc/0005/0004/';			//개인별 메뉴권한 관리
		    	
		    	window.open(domain+popupLink, "도움말", popupOption);
		    }
		    
		    function fnMyPage(){
		    	var url = '/support/mypage/myinfo/info_edit/';
		    	var name = '마이페이지';
		    	
		    	var width = 1200;
		    	var heigth = 800;
		    	var popupX = (document.body.offsetWidth / 2) - (width / 2);
		    	var popupY = (window.screen.height / 2) - (heigth / 2);
		    	var options = 'status=no,scrollbars=no,menubar=no,toolbar=no,location=no,height='+heigth+',width='+width+',left='+popupX+',top='+popupY;
		    	window.open(url, name, options);
		    }
		    
		    
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
						location.href='/exts/com/mbr/login.do';
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
			
			//var loginSecond = 14400;
			var loginSecond = 7200;
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
	</head>
	<body>
		<div class="wrap">
			<!-- header -->
			<div id="header">
				<ul id="skip">
					<li><a href="#content">본문 바로가기</a></li>
				</ul>
				<div class="container">
					<h1 class="h1_logo"><a href="/exts/koreahana/com/main.do"><img src="/support/img/common/logo_h1.png" alt="남북하나재단" /></a></h1>
					<div class="gnv">
						<ul>
						<c:forEach items="${lmenuList }" var="lmenu" varStatus="lstatus">
							<c:set var="mmenuCount" value="0" />
							<c:forEach items="${mmenuList }" var="mmenu" varStatus="mstatus"><c:if test="${mmenu.uprMenuSn == lmenu.menuSn }"><c:set var="mmenuCount" value="${mmenuCount+1 }" /></c:if></c:forEach>
							<li${curLmenuSn == lmenu.menuSn ?' class="on"':'' }>
								<a href="<c:url value="${lmenu.menuUrl }" />"><c:out value="${lmenu.menuNm }" /></a>
							<c:if test="${mmenuCount > 0 }">
								<div class="sub_menu">
									<ul>
									<c:forEach items="${mmenuList }" var="mmenu" varStatus="mstatus"><c:if test="${mmenu.uprMenuSn == lmenu.menuSn }">
										<li${curMmenuSn == mmenu.menuSn ?' class="on"':'' }><a href="<c:url value="${mmenu.menuUrl }" />"><c:out value="${mmenu.menuNm }" /></a></li>
									</c:if></c:forEach>
									</ul>
								</div>
							</c:if>
							</li>
						</c:forEach>
						</ul>
					</div>
					
					<div class="util_menu">
						<div class="login_wrap">
							<c:if test="${not empty loginVO }">
								<span class="login_type lgt_0${isCenterStaff?'2':(isFoundStaff?'1':'0') }"><c:out value="${loginVO.typeVO.typeNm }" /></span>								
								<button type="button" class="member_name" onclick="fnShowInfo();"><c:out value="${loginVO.mbrNm }" /><span id="loginInvalidTimeSpan"> (0:00)</span></button>
								<!-- lgt_00 or x 일반인 lgt_01 북한이탈주민 lgt_02 ~~하나센터-->
								<div id="login_tab" class="login_tab" style="display: none;">
									<ul>
										<li><a href="#" onclick="fnMyPage();return false;">마이페이지</a></li>
 										<li><a href="/exts/com/mbr/changePassword.do">비밀번호 변경</a></li>
										<li><a href="<c:url value="/uat/uia/actionLogout.do" />">로그아웃</a></li>
									</ul>
								</div>
							</c:if>
							<c:if test="${empty loginVO }">
								<a href="<c:url value="/exts/com/mbr/login.do" />">로그인</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			<!-- End of header -->
		<c:if test="${!empty curMenuCode && curMenuCode != 'MAIN' }">
			<div class="sub_visual">
				<div class="container">
					<div class="tit_area"><h2><c:out value="${curMmenuNm }" /></h2></div>
					<span id="pageLinkNav">
						<a href="/exts/koreahana/com/main.do" class="menu-home"><span>Home</span></a> 
						<span class="gt"> &gt; </span> 
						<a href="<c:url value="${curLmenuUrl }" />"><span><c:out value="${curLmenuNm }" /></span></a> 
						<span class="gt"> &gt; </span> 
						<span class="menu-active"><c:out value="${curMmenuNm }" /></span>
					</span>
					<a href="#none" target="_blank" title="새 창으로 열림" class="site_help_btn" onclick="fnHelpPopup('<c:out value="${empty curSmenuSn ? curMmenuSn : curSmenuSn }" />');return false;" >화면도우미</a>
				</div>
			</div>
		</c:if>
			<!-- middle -->
			<div id="middle">
			<!-- 
				<div id="leftMenu">
					<h2>상담사 <span></span></h2>
					<ul class="leftMenuList">
						<li id="left01" class="">
							<a href="/support/sd/0007" title="스타일가이드">스타일가이드</a>
						</li>
						<li id="left02" class="">
							<a href="/support/sd/0001" title="7_로그인">7_로그인</a>
						</li>
						<li id="left03" class="">
							<a href="/support/sd/0002" title="8_모집중인 공고">8_모집중인 공고</a>
						</li>
						<li id="left04" class="on">
							<a href="/support/sd/0003" title="9_사업공고 리스트">9_사업공고 리스트</a>
						</li>
						<li id="left05" class="">
							<a href="/support/sd/0004" title="10_모집공고 등록">10_모집공고 등록</a>
						</li>
						<li id="left06" class="">
							<a href="/support/sd/0005" title="12_신청서 미리보기">12_신청서 미리보기</a>
						</li>
						<li id="left07" class="">
							<a href="/support/sd/0006" title="13_모집_뷰">13_모집_뷰</a>
						</li>
	                </ul>
				</div>
			 -->
				<div class="content">
					<div class="sub_cont">
						<div class="container">
						<c:if test="${!empty curSmenuSn }">
							<ul class="tab_st01 MAB30">
							<c:forEach items="${smenuList }" var="smenu" varStatus="sstatus"><c:if test="${smenu.uprMenuSn == curMmenuSn }">
								<li${curSmenuSn == smenu.menuSn?' class="on"':'' }><a href="<c:url value="${smenu.menuUrl }" />"><c:out value="${smenu.menuNm }" /></a></li>
							</c:if></c:forEach>
							</ul>
						</c:if>