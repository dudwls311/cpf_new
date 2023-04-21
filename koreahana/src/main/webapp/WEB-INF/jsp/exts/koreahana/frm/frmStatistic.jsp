<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>


			<form action="?">
		<div class="box_w_gray">
			<div class="search_wrap">
				<div class="search_left">
					<label for="sprtYr">지원연도</label>
					<select id="sprtYr" name="sprtYr" class="st_select">
					<c:forEach var="y" items="${yearList }" >
						<option value="${y }" ${y == searchVO.sprtYr?' selected':'' }>${y }</option>
					</c:forEach>
					</select>
				</div>
				<div class="search_right">
					<button type="submit" class="btn-input-search">조회</button>
				</div>
			</div>
		</div>
			</form>
			
<div class="con_b_tp">
	<h4 class="tit"><c:out value="${searchVO.sprtYr}" />년 영농정착지원 현황</h4>
</div>
<table class="table_style th_v_m">
	<thead>
		<tr>
			<th>차수</th>
			<th>총 지원자수</th>
			<th>신규</th>
			<th>기존</th>
			<th>실집행액 총액</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${resultList }" var="result"><c:if test="${!empty result.sprtCycl }">
		<tr>
			<td><c:out value="${result.sprtCycl }" />차</td>
			<td><fmt:formatNumber value="${result.cnt }" /></td>
			<td><fmt:formatNumber value="${result.newYesCnt }" /></td>
			<td><fmt:formatNumber value="${result.newNoCnt }" /></td>
			<td><fmt:formatNumber value="${result.sprtAmt }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<c:forEach items="${resultList }" var="result"><c:if test="${empty result.sprtCycl }">
	<tfoot>
		<tr>
			<td>총합</td>
			<td><fmt:formatNumber value="${result.cnt }" /></td>
			<td><fmt:formatNumber value="${result.newYesCnt }" /></td>
			<td><fmt:formatNumber value="${result.newNoCnt }" /></td>
			<td><fmt:formatNumber value="${result.sprtAmt }" /></td>
		</tr>
	</tfoot>
	</c:if></c:forEach>
</table>

<div class="con_b_tp">
	<h4 class="tit">영농정착지원 연도별 지원 추이</h4>
</div>
<table class="table_style th_v_m">
	<thead>
		<tr>
			<th rowspan="2">구분</th>
			<th colspan="2">인원</th>
			<th rowspan="2">인원합계</th>
			<th colspan="2">지원금액</th>
			<th rowspan="2">실집행액합계</th>
		</tr>
		<tr>
			<th>기존</th>
			<th>신규</th>
			<th>기존</th>
			<th>신규</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${resultSprtYrList }" var="result"><c:if test="${!empty result.sprtYr }">
		<tr>
			<td><c:out value="${result.sprtYr }" /></td>
			<td><fmt:formatNumber value="${result.newYesCnt }" /></td>
			<td><fmt:formatNumber value="${result.newNoCnt }" /></td>
			<td><fmt:formatNumber value="${result.cnt }" /></td>
			<td><fmt:formatNumber value="${result.newYesAmt }" /></td>
			<td><fmt:formatNumber value="${result.newNoAmt }" /></td>
			<td><fmt:formatNumber value="${result.sprtAmt }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<c:forEach items="${resultSprtYrList }" var="result"><c:if test="${empty result.sprtYr }">
	<tfoot>
		<tr>
			<td>총합</td>
			<td><fmt:formatNumber value="${result.newYesCnt }" /></td>
			<td><fmt:formatNumber value="${result.newNoCnt }" /></td>
			<td><fmt:formatNumber value="${result.cnt }" /></td>
			<td><fmt:formatNumber value="${result.newYesAmt }" /></td>
			<td><fmt:formatNumber value="${result.newNoAmt }" /></td>
			<td><fmt:formatNumber value="${result.sprtAmt }" /></td>
		</tr>
	</tfoot>
	</c:if></c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>