<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><c:set var="Jnit_sitePath" value="support" /><% String result = "";if(request.getParameter("result") != null){ if("Y".equals(request.getParameter("localYn"))){result = new String( request.getParameter("result").getBytes("8859_1"),"UTF-8"); }else{ result = request.getParameter("result");} }%><c:set var="result" value="<%= result%>" /><%@ include file='/support/_tpls/B/TPL_000018_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><jsp:include page="/user/exts/koreahana/mbr/findPasswdAction.do"/><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000018_E.jsp' %>