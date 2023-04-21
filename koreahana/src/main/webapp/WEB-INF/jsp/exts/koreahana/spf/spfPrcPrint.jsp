<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/ozreport/ozheader.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<c:choose>
	<c:when test="${empty photoFile }">
		<c:url var="photoFileUrl" value="/support/img/content/p_default.jpg" />
	</c:when>
	<c:otherwise>
		<c:url var="photoFileUrl" value="/user/exts/koreahana/spr/index.do?ksMode=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, '') }" />
	</c:otherwise>
</c:choose>
<c:if test="${!empty qlfResult.testYmd }">
	<fmt:parseDate pattern="yyyyMMdd" value="${qlfResult.testYmd }" var="testYmd"/>
	
</c:if>
<c:if test="${!empty qlfResult.sccdPrsntnYmd }">
	<fmt:parseDate pattern="yyyyMMdd" value="${qlfResult.sccdPrsntnYmd }" var="sccdPrsntnYmd"/>
	
</c:if>
<c:set var="now" value="<%=new java.util.Date() %>" />
<input type="hidden" id="ozp_APPLYNO" value="<c:out value="${result.exslno }" />" />
<input type="hidden" id="ozp_NM" value="<c:out value="${result.flnm }" />" />
<input type="hidden" id="ozp_BIRTHDAY" value="<c:out value="${jtag:convertDateSplitString(result.brdtYmd, '-') }" />" />
<input type="hidden" id="ozp_GENDER" value="<c:out value="${result.genderCd }" />" />
<input type="hidden" id="ozp_EXAMPLACE" value="<c:out value="${qlfResult.testPlc }" />" />
<input type="hidden" id="ozp_EXAMDATE" value="<c:out value="${jtag:convertDateSplitString(qlfResult.testYmd,'-') }" /><c:if test="${!empty testYmd }">(<fmt:formatDate pattern="E" value="${testYmd }" />)</c:if>" />
<input type="hidden" id="ozp_EXAMTIME" value="<c:out value="${qlfResult.testHrInfo }" />" />
<input type="hidden" id="ozp_ANNOUNCEDATE" value="<c:out value="${jtag:convertDateSplitString(qlfResult.sccdPrsntnYmd,'-') }" /><c:if test="${!empty sccdPrsntnYmd }">(<fmt:formatDate pattern="E" value="${sccdPrsntnYmd }" />)</c:if>" />
<input type="hidden" id="ozp_YEAR" value="<fmt:formatDate value="${now }" pattern="yyyy" />" />
<input type="hidden" id="ozp_MONTH" value="<fmt:formatDate value="${now }" pattern="MM" />" />
<input type="hidden" id="ozp_DAY" value="<fmt:formatDate value="${now }" pattern="dd" />" />
<input type="hidden" id="ozp_IMG_URL" value="<%=egovframework.com.utl.fcc.service.UrlUtil.currentContextUrl(request)%><c:url value="${photoFileUrl }" />" />
<input type="hidden" id="ozp_PAGE_USR_IP" value="<%=request.getRemoteAddr()%>" />
<script type="text/javascript">
$(document).ready(function(){
	ComOz.report.init('OZViewer','/testId.ozr',{formParamPrefixId:'ozp_'});
	ComOz.report.start();
});
</script>
<div id="OZViewer" style="width:98%;height:98%"></div>
<%@ include file="/WEB-INF/jsp/exts/com/ozreport/ozfooter.jsp" %>