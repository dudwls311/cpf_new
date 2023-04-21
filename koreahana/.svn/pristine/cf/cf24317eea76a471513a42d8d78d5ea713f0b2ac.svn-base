<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserVariable.jsp" %>
<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
	<input type="hidden" name="<c:out value="${modeName }" />" value="write" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>
<form id="deletePageForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="deleteActionJson" />
	<input type="hidden" name="sprtSn" value="" />
</form>
<form id="myFileDownloadForm" action="<c:url value="/user/exts/koreahana/spr/index.do" />">
	<input type="hidden" name="ksMode" value="myFileDownload" />
	<input type="hidden" name="pbancrcSn" value="" />
	<input type="hidden" name="sprtSn" value="" />
	<input type="hidden" name="atchFileSn" value="" />
</form>
<form id="docDownloadForm" action="<c:url value="/user/exts/koreahana/smb/index.do" />">
	<input type="hidden" name="ksMode" value="fileDownload" />
	<input type="hidden" name="smbsnDocFormSn" value="" />
</form>