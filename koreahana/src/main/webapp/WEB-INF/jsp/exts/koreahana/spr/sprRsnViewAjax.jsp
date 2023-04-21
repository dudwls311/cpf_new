<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>
<form id="sprPageForm" action="?">
	<input type="hidden" name="ksMode" value="write" />
	<input type="hidden" name="pbancrcCtgryFrstCd" value="<c:out value="${result.pbancrcCtgryFrstCd }" />" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<div class="box_w_gray">
	<c:out value="${fn:replace(result.rsn, lf, '<br />')}" escapeXml="false" />
</div>