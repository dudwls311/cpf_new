<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% /*   hideWrite = Y(추가버튼 숨김)*/ %>
<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
	<div class=" FloatRight"><a class="btn_st btn_c_bk" href="#" onclick="fnWrite('');return false;"><spring:message code="com.btn.write" /></a></div>
</c:if>