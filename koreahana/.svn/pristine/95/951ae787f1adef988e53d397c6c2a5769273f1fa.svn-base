<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvUseView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="keuMode" value="write" />
	<input type="hidden" id="emvucdUseInfoSn" name="emvucdUseInfoSn" value="<c:out value="${result.emvucdUseInfoSn }" />" />
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
							<th scope="row">취업바우처카드사용정보일련번호</th>
							<td>
								<c:out value="${result.emvucdUseInfoSn}" />
							</td>
							<th scope="row">카드번호</th>
							<td>
								<c:out value="${result.cardNo}" />
							</td>
							<th scope="row">발급자</th>
							<td>
								<c:out value="${result.issuistFlnm}" />
							</td>
							<th scope="row">승인연월일</th>
							<td>
								<c:out value="${result.aprvYmd}" />
							</td>
							<th scope="row">승인번호</th>
							<td>
								<c:out value="${result.aprvNo}" />
							</td>
							<th scope="row">가맹점명</th>
							<td>
								<c:out value="${result.frcsNm}" />
							</td>
							<th scope="row">승인금액</th>
							<td>
								<c:out value="${result.aprvAmt}" />
							</td>

						</tr>
					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
