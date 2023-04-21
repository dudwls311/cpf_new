<%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/_header.jsp' %><%@ page import="jnit.cms.handler.*" %><%@ page import="jnit.com.util.CclUtil" %><%@ page import="jnit.cms.menu.JnitcmsmenuController" %><c:set var="handingType" value="TPL_000021" /><% /* cset_s */ %><% String servletPath = request.getServletPath(); %><% String[] Jnit_ServletPath = servletPath.split("/"); String Jnit_sitePath = Jnit_ServletPath[1]; %><c:set var="Jnit_sitePath" value="<%= Jnit_sitePath %>" scope="request"/><%@ page import="egovframework.com.utl.fcc.service.StringUtil"%><% String localYn = ""; if(StringUtil.isExistString(request.getRequestURL().toString(),"local")) localYn="Y"; %><c:set var="localYn" value="<%= localYn %>" scope="request" /><% /* cset_e */ %><%
/**
 *@version 3.2.0.1
 **/
%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><%= JnitcmsmenuController.getMenuJSON("pageNavTitle") %></title>
    <%@ include file="/support/common/config/handing/metaHanding.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@ include file="/support/common/config/handing/cssHanding.jsp" %>

    <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.ui/js/jquery-ui-1.9.0.custom.min.js'/>"></script>
    <!-- script -->
    <%@ include file="/support/common/config/handing/jsHanding.jsp" %>
  </head>

  <body>
    <div id="wrap">
      <!-- header -->
      <jsp:include page="/support/include/header/index.jsp" flush="false" ></jsp:include>
      <!-- End of header -->


      <div class="sub_visual">
        <div class="container">
          <div class="tit_area"><h2><%= CmsServletPathProperty.getProp(servletPath,"pageTitle") %></h2></div>
          <%= JnitcmsmenuController.getMenuJSON("pageLinkNav") %>
          <a href="#none" target="_blank" title="새 창으로 열림" class="site_help_btn" onclick="fnHelpPopup('<c:out value="${pageContext.request.requestURI}" />');return false;">화면도우미</a><!-- 탭이 아니라 창이 떠야하려나요-->
        </div>
      </div>

      <!-- middle -->
      <div id="middle">    		

        <div class="content">
          <div class="sub_cont">
            
            <div class="sub_left_container" id="fast_cont">        
              <!-- Sample S 이상 -->
              
