<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><script>
  $(function () { 
            $('.SAMPLE_ADAD').toggle(function () { 
            $('.gnv.SAMPLE_HEAD').removeClass("on_1");
            $('.gnv.SAMPLE_HEAD').removeClass("on_3");
            $('.gnv.SAMPLE_HEAD').removeClass("on_4");
            $('.gnv.SAMPLE_HEAD').addClass("on_2"); //재단2

            $('.SAMPLE_SANGDAM_NO_BTN').hide();
            $('.SAMPLE_SANGDAM_VIEW_BTN').show();

            fnChangeLink(2);

      },function(){
            $('.gnv.SAMPLE_HEAD').removeClass("on_1");
            $('.gnv.SAMPLE_HEAD').removeClass("on_2");
            $('.gnv.SAMPLE_HEAD').removeClass("on_3");
            $('.gnv.SAMPLE_HEAD').addClass("on_4"); //시스템4
            $('.SAMPLE_SANGDAM_NO_BTN').show();
            $('.SAMPLE_SANGDAM_VIEW_BTN').hide();
            fnChangeLink(4);
      },function(){
            $('.gnv.SAMPLE_HEAD').removeClass("on_3");
            $('.gnv.SAMPLE_HEAD').removeClass("on_2");
            $('.gnv.SAMPLE_HEAD').removeClass("on_4");
            $('.gnv.SAMPLE_HEAD').addClass("on_1"); //최고 1
            $('.SAMPLE_SANGDAM_NO_BTN').show();
            $('.SAMPLE_SANGDAM_VIEW_BTN').hide();
            fnChangeLink(1);
      });

      var isVisible = $('.SAMPLE_ADAD').is(":visible"); 
      localStorage.setItem('visible', isVisible);

            var _p = getCookie('p');
            if(_p != null){

            $('.gnv.SAMPLE_HEAD').removeClass("on_1");
            $('.gnv.SAMPLE_HEAD').removeClass("on_2");
            $('.gnv.SAMPLE_HEAD').removeClass("on_3");
            $('.gnv.SAMPLE_HEAD').removeClass("on_4");
            $('.gnv.SAMPLE_HEAD').addClass("on_" + _p);
      }
  });

  // stored in localStorage as string, `toggle` needs boolean
  var isVisible = localStorage.getItem('visible') === 'false' ? false : true;
  $('.SAMPLE_ADAD').toggle(isVisible);

  function fnChangeLink(p){
  setCookie('p',p,100);
  }

  function setCookie(name, value, exp) {
  var date = new Date();
  date.setTime(date.getTime() + exp*24*60*60*1000);
  document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
  }

  function getCookie(name) {
  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
  return value? value[2] : null;
  }
</script>
<style>

  .SAMPLE_01 {display:none;}
  .SAMPLE_02 {display:none;}
  .SAMPLE_03 {display:none;}
  .SAMPLE_04 {display:none;}

  .gnv.SAMPLE_HEAD.on_1 + .util_menu .SAMPLE_01 {display: inline;}
  .gnv.SAMPLE_HEAD.on_2 + .util_menu .SAMPLE_02 {display:inline;}
  .gnv.SAMPLE_HEAD.on_3 + .util_menu .SAMPLE_03 {display:inline;}
  .gnv.SAMPLE_HEAD.on_4 + .util_menu .SAMPLE_04 {display:inline;}


  .gnv.on_1 li.Inb01 {}
  .gnv.on_1 li.Inb02 {}
  .gnv.on_1 li.Inb52 {}
  .gnv.on_1 li.Inb60 {}

  .gnv.on_2 li.Inb01 {}
  .gnv.on_2 li.Inb01 li {display:none;}
  .gnv.on_2 li.Inb01 .sub1_1 , 
  .gnv.on_2 li.Inb01 .sub1_8 {display:list-item;}
  .gnv.on_2 li.Inb01 .Inbsub01 ul {width: 530px;}
  .gnv.on_2 li.Inb02 {}
  .gnv.on_2 li.Inb02 li {display:none;}
  .gnv.on_2 li.Inb02 .sub2_2 , 
  .gnv.on_2 li.Inb02 .sub2_9 {display:list-item;}
  .gnv.on_2 li.Inb02 .Inbsub02 ul {width: 530px;}
  .gnv.on_2 li.Inb52 {display:none;}
  .gnv.on_2 li.Inb60 {display:none;}

  .gnv.on_3 li.Inb01 {display:none;}
  .gnv.on_3 li.Inb02 {display:none;}
  .gnv.on_3 li.Inb52 {display:none;}
  .gnv.on_3 li.Inb60 {}
</style>

<div id="header">
  <ul id="skip">
    <li><a href="#fast_cont">본문 바로가기</a></li>
  </ul>
  <div class="container">
    <h1 class="h1_logo"><a href="/support/sds/adlogin/"><img src="/support/img/common/logo_h1.png" alt="남북하나재단" /></a></h1>
    <div class="gnv SAMPLE_HEAD on_1">
      <ul>

        <!-- 탑메뉴 코드 시작 -->
        <c:import url="/menu/getTopMenu.do">
          <c:param name="target" value="sup_top" />
          <c:param name="menuNm" value="사업공고(신청서) 관리" />
          <c:param name="depth" value="2" />
          <c:param name="order" value="1" />
        </c:import>
        <!-- 탑메뉴 코드 끝 -->	
        <!-- 탑메뉴 코드 시작 -->
        <c:import url="/menu/getTopMenu.do">
          <c:param name="target" value="sup_top" />
          <c:param name="menuNm" value="지원대상 관리" />
          <c:param name="depth" value="2" />
          <c:param name="order" value="2" />
        </c:import>
        <!-- 탑메뉴 코드 끝 -->	
        <!-- 탑메뉴 코드 시작 -->
        <c:import url="/menu/getTopMenu.do">
          <c:param name="target" value="sup_top" />
          <c:param name="menuNm" value="지원이력 조회" />
          <c:param name="depth" value="2" />
          <c:param name="order" value="52" />
        </c:import>
        <!-- 탑메뉴 코드 끝 -->	
        <!-- 탑메뉴 코드 시작 -->
        <c:import url="/menu/getTopMenu.do">
          <c:param name="target" value="sup_top" />
          <c:param name="menuNm" value="설정" />
          <c:param name="depth" value="2" />
          <c:param name="order" value="60" />
        </c:import>
        <!-- 탑메뉴 코드 끝 -->	
      </ul>
    </div>



    <div class="util_menu">
      <div class="login_wrap MAR0">
        <c:if test="${loginVO.mbrId == null }">
          <a href="${pageContext.request.contextPath }/${Jnit_sitePath}/login.jsp">로그인</a>            
        </c:if>
        <c:if test="${loginVO.mbrId != null }">


          <span class="login_type lgt_03 SAMPLE_ADAD SAMPLE_01">생활안정부</span>
          <span class="login_type lgt_02 SAMPLE_ADAD SAMPLE_02">강원남부하나센터</span>
          <span class="login_type lgt_04 SAMPLE_ADAD SAMPLE_03">시스템담당자</span>
          <span class="login_type lgt_05 SAMPLE_ADAD SAMPLE_04">최고관리자</span>
          <button type="button" class="member_name">홍길동</button>
          <!-- lgt_00 or x 일반인 lgt_01 북한이탈주민 lgt_02 ~~하나센터 03 재단담당자 04시스템 05 최고-->
          <div class="login_tab" style="display:none;">
            <ul>
              <li class="SAMPLE_SANGDAM_VIEW_BTN"><a href="/support/hanacenter/">하나센터</a></li>
              <li><a href="/support/sd/0023/">개인정보 수정</a></li>
              <li><a href="/support/sd/0022/">비밀번호 수정</a></li>
              <li><a href="${pageContext.request.contextPath }/uat/uia/actionLogout.do">로그아웃</a></li>
            </ul>
          </div>
        </c:if>
      </div>


    </div>
  </div>
</div><% /*<!-- /[-CONTENT-] -->*/ %>
