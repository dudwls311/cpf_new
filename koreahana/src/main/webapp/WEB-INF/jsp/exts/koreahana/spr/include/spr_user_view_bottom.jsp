<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%	/*   
	hideModify = Y(수정버튼 숨김)
	hideDelete = Y(삭제버튼 숨김)
	hideList = Y(목록버튼 숨김)
	*/ %>
<div class="btn_g_btm">
	<c:if test="${hideList != 'Y' }">
		<button class="btn_st btn_c_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
	</c:if>
</div>