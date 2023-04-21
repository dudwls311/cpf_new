<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%	/*   
	hideModify = Y(수정버튼 숨김)
	hideDelete = Y(삭제버튼 숨김)
	hideList = Y(목록버튼 숨김)
	hideDocView = Y(목록버튼 숨김)
	*/ %>
<div class="btn_g_btm">
	<c:if test="${isStreAuth == true}">
		<c:if test="${hideModify != 'Y' }">						
		<button class="btn_st btn_c_gr btn_s_big" type="button" id="modifyBtn">신청서 수정</button>
		</c:if>
	</c:if>
	<c:if test="${hideList != 'Y' }">
		<button class="btn_st btn_s_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
	</c:if>
</div>