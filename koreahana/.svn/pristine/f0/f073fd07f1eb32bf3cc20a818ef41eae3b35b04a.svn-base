<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).values()" var="enumFrsList" /> <%//최초범주리스트 %>

<c:set var="bizSeCdName" value="${jtag:getCdNm(bizSeCdList, (empty result ? pbaVO.bizSeCd : result.bizSeCd) )}" />
<c:forEach var="enumFrs" items="${enumFrsList }">
	<c:if test="${enumFrs.getCode() == (empty result ? pbaVO.pbancrcCtgryFrstCd : result.pbancrcCtgryFrstCd ) }">
		<c:set var="ctgryName" value="${enumFrs.getName() }" />
	</c:if>
</c:forEach>
<c:set var="sprtTitle" value="${bizSeCdName } ${ctgryName } 신청" />
<p class="tit_b_title box_w_gray"><c:out value="${sprtTitle }" /></p>
<c:if test="${hideRequire != 'Y' }">
	<p class="AlignRight"><span class="imp_st">* 표시는 필수입력</span></p>
</c:if>