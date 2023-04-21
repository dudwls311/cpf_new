<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprVariable.jsp" %>

<c:choose>
	<c:when test="${enumFrsEml == searchVO.pbancrcCtgryFrstCd || enumFrsEml == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd || enumFrsAdt == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="kaMode" />
	</c:when>
	<c:when test="${enumFrsSho == searchVO.pbancrcCtgryFrstCd || enumFrsSho == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="ksMode" />
	</c:when>
	<c:when test="${enumFrsEdu == searchVO.pbancrcCtgryFrstCd || enumFrsEdu == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsVdo == searchVO.pbancrcCtgryFrstCd || enumFrsVdo == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="kvMode" />
	</c:when>
	<c:when test="${enumFrsLnb == searchVO.pbancrcCtgryFrstCd || enumFrsLnb == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="klMode" />
	</c:when>
	<c:when test="${enumFrsSpf == searchVO.pbancrcCtgryFrstCd || enumFrsSpf == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="ksMode" />
	</c:when>
	<c:when test="${enumFrsEmp == searchVO.pbancrcCtgryFrstCd || enumFrsEmp == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsEmv == searchVO.pbancrcCtgryFrstCd || enumFrsEmv == result.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>

<script>
	var ajRsnform = new ComAjaxForm('rsnAjaxForm','', {reload:'Y'});
	ajRsnform.init();
</script>
<form id="rsnAjaxForm" action="<c:url value="${actionUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeSprtSttsActionJson" />
	<input type="hidden" name="sprtSnArr" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" name="sprtSttsCd" value="<c:out value="${result.sprtSttsCd }" />" />
	<textarea name="rsn" class="st_textarea"><c:out value="${result.rsn }" /></textarea>
</form>