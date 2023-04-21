<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvUseWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="keuMode" value="view" />
	<input type="hidden" name="emvucdUseInfoSn" value="<c:out value="${result.emvucdUseInfoSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="keuMode" value="writeActionJson" />
	<input type="hidden" id="emvucdUseInfoSn" name="emvucdUseInfoSn" value="<c:out value="${result.emvucdUseInfoSn }" />" />

					<h4 class="tit">정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">취업바우처카드지원현황관리일련번호</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="emvucdSprtPrcnMngSn" name="emvucdSprtPrcnMngSn" value="<c:out value="${result.emvucdSprtPrcnMngSn}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">카드번호</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="cardNo" name="cardNo" value="<c:out value="${result.cardNo}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">발급자</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="issuistFlnm" name="issuistFlnm" value="<c:out value="${result.issuistFlnm}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">승인연월일</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="aprvYmd" name="aprvYmd" value="<c:out value="${result.aprvYmd}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">승인번호</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="aprvNo" name="aprvNo" value="<c:out value="${result.aprvNo}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">가맹점명</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="frcsNm" name="frcsNm" value="<c:out value="${result.frcsNm}" />" />
								</td>
							</tr>
							<tr>
								<th scope="row">승인금액</th>
								<td>
									<input type="text" class="text" style="width:180px;" id="aprvAmt" name="aprvAmt" value="<c:out value="${result.aprvAmt}" />" />
								</td>
							</tr>

					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
