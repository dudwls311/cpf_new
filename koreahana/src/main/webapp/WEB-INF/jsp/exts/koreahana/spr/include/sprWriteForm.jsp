<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprVariable.jsp" %>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${param.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${param.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${param.bizSeCd }" />" />
	<input type="hidden" name="sprtSttsCd" value="<c:out value="${param.sprtSttsCd }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>
<form id="completePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${param.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${param.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${param.bizSeCd }" />" />
	<input type="hidden" name="sprtSttsCd" value="<c:out value="${param.sprtSttsCd }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="<c:out value="${modeName }" />" value="view" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="myFileDownloadForm" action="<c:url value="${actionUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="myFileDownload" />
	<input type="hidden" name="pbancrcSn" value="" />
	<input type="hidden" name="sprtSn" value="" />
	<input type="hidden" name="atchFileSn" value="" />
</form>
<form id="docDownloadForm" action="<c:url value="/user/exts/koreahana/smb/index.do" />">
	<input type="hidden" name="ksMode" value="fileDownload" />
	<input type="hidden" name="smbsnDocFormSn" value="" />
</form>