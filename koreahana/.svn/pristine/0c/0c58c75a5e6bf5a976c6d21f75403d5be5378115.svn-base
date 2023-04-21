<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%	/*   
	hideModify = Y(수정버튼 숨김)
	hideDelete = Y(삭제버튼 숨김)
	hideList = Y(목록버튼 숨김)
	hideDocView = Y(목록버튼 숨김)
	*/ %>
<div class="btn_g_btm">
	<c:if test="${isAdmin == true || isFoundStaff == true}">
		<c:if test="${hideModify != 'Y' }">						
		<button class="btn_st btn_c_big btn_c_or" type="button" id="modifyBtn"><spring:message code="com.btn.modify" /></button>
		</c:if>
	</c:if>
	
	<c:if test="${isCenterStaff == true}">
		<c:if test="${enumFrsEml == result.pbancrcCtgryFrstCd || enumFrsEmv == result.pbancrcCtgryFrstCd }">						
			<button class="btn_st btn_c_big btn_c_or" type="button" id="requestBtn">신청하기</button>
		</c:if>
	</c:if>
	
	<c:if test="${hideList != 'Y' }">
		<button class="btn_st btn_c_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
	</c:if>
	<c:if test="${isAdmin == true || isDelAuth == true}">
		<c:if test="${hideDelete != 'Y' }">
			<button class="btn_st btn_c_re" type="button" id="deleteBtn"><spring:message code="com.btn.delete" /></button>
		</c:if>
	</c:if>
</div>