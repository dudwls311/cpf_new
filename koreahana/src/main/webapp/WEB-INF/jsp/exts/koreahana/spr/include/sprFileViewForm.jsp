<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:if test="${not empty fileItem }">
	<a href="#" class="txt_ico_f" onclick="<c:out value="${downloadFnName }" />('<c:out value="${downloadFnValue }" />');return false;"><c:out value="${fileItem.orgnlAtchFileNm }" /></a>
</c:if>