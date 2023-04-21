<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mdl/mdlView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${param.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${param.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${param.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kmMode" value="write" />
	<input type="hidden" id="mdlcrSprtSn" name="mdlcrSprtSn" value="<c:out value="${result.mdlcrSprtSn }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${param.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${param.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${param.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kmMode" value="view" />
	<input type="hidden" name="mdlcrSprtSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${param.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${param.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${param.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


					<h4 class="tit">지원대상자 기본 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row">성명</th>
							<td>
								<c:out value="${result.flnm}" />
								<c:out value="${jtag:getCdNm(genderCdList,result.genderCd)}" />
							</td>
							<th scope="row">입국연월</th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.entcnyYm,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row">생년월일</th>
							<td colspan="3">
								<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row">주소</th>
							<td colspan="3">
								<c:out value="${result.addr}" />
							</td>
						</tr>
						<tr>
							<th scope="row">전화번호</th>
							<td colspan="3">
								<c:out value="${result.telno}" />
							</td>
						</tr>
					</table>
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row">질환구분</th>
							<td colspan="3">
								<c:out value="${jtag:getCdNm(dssSeCdList,result.dssSeCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row">치료기간</th>
							<td colspan="3">
								<c:out value="${result.curePeriod}" />
							</td>
						</tr>
						<tr>
							<th scope="row">병원</th>
							<td colspan="3">
								<c:out value="${result.hsptlNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row">질병명</th>
							<td colspan="3">
								<c:out value="${result.dssNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row">지원금</th>
							<td>
								<fmt:formatNumber value="${result.sprtAmt}" /> 원
							</td>
							<th scope="row">지원일자</th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.sprtYmd,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row">질병명</th>
							<td colspan="3">
								<c:out value="${jtag:getCdNm(sprtSeCdList,result.sprtSeCd)}" />
							</td>
						</tr>
					</table>
					
					<h4 class="tit">의료비 지원이력</h4>
					<p class="p_info">이름, 성별, 생년월일, 입국연월 정보가 일치하는 지원대상자의 지원이력정보가 출력됩니다.</p>
					<table class="table_style thd_v_m">
						<thead>
							<tr>
								<th scope="col">질환구분</th>
								<th scope="col">치료기간</th>
								<th scope="col">질병명</th>
								<th scope="col">지원금</th>
								<th scope="col">지원일자</th>
								<th scope="col">상세보기</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="sprtAmtTotal" value="0" />
						<c:forEach var="his" items="${hisList}" varStatus="status">
						<c:set var="sprtAmtTotal" value="${sprtAmtTotal + his.sprtAmt }" />
							<tr>
								<td><c:out value="${jtag:getCdNm(dssSeCdList,his.dssSeCd)}" /></td>
								<td><c:out value="${his.curePeriod}" /></td>
								<td><c:out value="${his.dssNm}" /></td>
								<td><fmt:formatNumber value="${his.sprtAmt}" /></td>
								<td><c:out value="${jtag:convertDateSplitString(his.sprtYmd,'-')}" /></td>
								<td><a href="#" class="btn_st btn_c_gy" onclick="javascript:fnView('<c:out value="${his.mdlcrSprtSn}" />');return false;">상세보기</a></td>
							</tr>
						</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="3">총합</td>
								<td><fmt:formatNumber value="${sprtAmtTotal }" /></td>
								<td colspan="2"></td>
						</tfoot>
					</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
