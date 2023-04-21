<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<div class="btn_g_btm">
	<c:if test="${isAllowSprtStts == true && ( empty result || enumSprTmpCd == result.sprtSttsCd ) && !isFoundStaff }">
		<button class="btn_st btn_c_wt btn_s_big" type="button" id="tmpSaveBtn" >임시저장</button>
	</c:if>
	<c:if test="${isAllowSprtStts == true}">
		<button class="btn_st btn_c_gr btn_s_big" type="button" id="saveBtn">신청하기</button>
	</c:if>
	<c:if test="${enumSprTmpCd == result.sprtSttsCd }">
		<button class="btn_st btn_c_re btn_s_big" type="button" id="deleteBtn"><spring:message code="com.btn.delete" /></button>
	</c:if>
	<button class="btn_st btn_s_big" type="button" id="cancelBtn"><spring:message code="com.btn.cancleList" /></button>
</div>