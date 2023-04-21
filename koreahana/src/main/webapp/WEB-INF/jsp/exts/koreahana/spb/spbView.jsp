<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spb/spbView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="ksMode" value="write" />
	<input type="hidden" id="sprtBizStngSnsprtBizStngSn" name="sprtBizStngSnsprtBizStngSn" value="<c:out value="${result.sprtBizStngSnsprtBizStngSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


					<h4 class="tit">상세 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row">지원사업설정일련번호지원사업설정일련번호</th>
							<td>
								<c:out value="${result.sprtBizStngSnsprtBizStngSn}" />
							</td>
							<th scope="row">최초범주코드</th>
							<td>
								<c:out value="${result.ctgryFrstCd}" />
							</td>
							<th scope="row">설정코드</th>
							<td>
								<c:out value="${result.stngCd}" />
							</td>

						</tr>
					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
