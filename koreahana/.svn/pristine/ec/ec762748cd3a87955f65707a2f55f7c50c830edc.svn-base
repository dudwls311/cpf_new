<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%	/*   
	hideModify = Y(수정버튼 숨김)
	hideDelete = Y(삭제버튼 숨김)
	hideList = Y(목록버튼 숨김)
	param.sprtType = sprtType은 지원이력조회에서 넘어오는 파라미터로 지원이력 조회에서는 수정 밑 삭제가 불가능
	*/ %>
<div class="btn_g_btm">
	<c:if test="${isStreAuth == true}">
		<c:if test="${hideModify != 'Y' }">
			<c:if test="${isCenterStaff == false || (isCenterStaff == true && enumSprUndCd == result.sprtSttsCd) }">						
				<button class="btn_st btn_c_big btn_c_or" type="button" id="modifyBtn"><spring:message code="com.btn.modify" /></button>
			</c:if>
		</c:if>
	</c:if>
	<c:if test="${hideList != 'Y' }">
		<button class="btn_st btn_c_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
	</c:if>
	<c:if test="${isDelAuth == true}">
		<c:if test="${hideDelete != 'Y' }">
			<c:if test="${isCenterStaff == false || (isCenterStaff == true && enumSprUndCd == result.sprtSttsCd) }">
				<button class="btn_st btn_c_re" type="button" id="deleteBtn"><spring:message code="com.btn.delete" /></button>
			</c:if>
		</c:if>
	</c:if>
</div>