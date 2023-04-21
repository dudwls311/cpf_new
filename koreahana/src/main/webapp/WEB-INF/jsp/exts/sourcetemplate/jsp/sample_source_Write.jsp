<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/[first_package]/[second_package]/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/[file_path]/[sample_source]Write.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="[mode_name]Mode" value="view" />
	<input type="hidden" name="[firstVo]" value="<c:out value="${result.[firstVo] }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="[mode_name]Mode" value="writeActionJson" />
	<input type="hidden" id="[firstVo]" name="[firstVo]" value="<c:out value="${result.[firstVo] }" />" />

					<h4 class="tit">정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
[JSP_WRITE_TR]
					</table>

					<%@ include file="/WEB-INF/jsp/[first_package]/[second_package]/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/[first_package]/[second_package]/com/footer.jsp" %>