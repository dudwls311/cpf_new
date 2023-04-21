<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>


			<form action="?">
		<div class="box_w_gray">
			<div class="search_wrap">
				<div class="search_left">
					<label for="sprtYr">신청연도</label>
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
	<h4 class="tit">${searchVO.sprtYr }년 월별 긴급생계비 지원현황</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
		<c:forEach begin="1" end="12" var="m">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<th>${mt }월</th>
		</c:forEach>
			<th>합계</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>지급액</th>
		<c:set var="giveAmtTotal" value="0" />		
		<c:forEach begin="1" end="12" var="m">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<td>
				<c:set var="giveAmt" value="0" />
				<c:forEach items="${resultList }" var="result"><c:if test="${result.giveMonth == mt}">
					<c:set var="giveAmt" value="${result.giveAmt }" />
					<c:set var="giveAmtTotal" value="${giveAmtTotal + result.giveAmt }"/>
				</c:if></c:forEach>
				<fmt:formatNumber value="${giveAmt }" />
			</td>
		</c:forEach>
			<td><fmt:formatNumber value="${giveAmtTotal }" /></td>
		</tr>
		<tr>
			<th>지급건</th>
		<c:set var="cntTotal" value="0" />		
		<c:forEach begin="1" end="12" var="m">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<td>
				<c:set var="cnt" value="0" />
				<c:forEach items="${resultList }" var="result"><c:if test="${result.giveMonth == mt}">
					<c:set var="cnt" value="${result.cnt }" />
					<c:set var="cntTotal" value="${cntTotal +  result.cnt }"/>
				</c:if></c:forEach>
				<fmt:formatNumber value="${cnt }" />
			</td>
		</c:forEach>
			<td><fmt:formatNumber value="${cntTotal }" /></td>
		</tr>
	</tbody>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
