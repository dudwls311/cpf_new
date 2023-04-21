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
	<h4 class="tit"><c:out value="${searchVO.sprtYr}" />년 경영개선자금 지원 현황</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="34%">
		<col width="33%">
		<col width="33%">
	</colgroup>
	<thead>
		<tr>
			<th>모집분야</th>
			<th>총 지원자수</th>
			<th>총 지원금액</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="amtTot" value="0" />
	<c:set var="cntTot" value="0" />
	<c:forEach items="${rcmtFldCdList }" var="cd">
		<c:set var="amt" value="0" />
		<c:set var="cnt" value="0" />
		<c:forEach items="${resultRcmtFldCdList }" var="result"><c:if test="${result.rcmtFldCd == cd.indivCd }">
			<c:set var="amt" value="${result.amt }" /><c:set var="amtTot" value="${amtTot + result.amt }" />
			<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
		</c:if></c:forEach>
		<tr>
			<td><c:out value="${cd.indivCdNm }" /></th>
			<td><fmt:formatNumber value="${cnt }" /></td>
			<td><fmt:formatNumber value="${amt }" />원</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td>총합</td>
			<td><fmt:formatNumber value="${cntTot }" /></td>
			<td><fmt:formatNumber value="${amtTot }" />원</td>
		</tr>
	</tfoot>
</table>

<div class="con_b_tp">
	<h4 class="tit">경영개선자금 연도별 지원 추이</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
		<c:forEach items="${resultSprtYrList }" var="result">
			<th>${empty result.sprtYr?'총계':result.sprtYr }</th>
		</c:forEach>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>인원</th>
		<c:forEach items="${resultSprtYrList }" var="result">
			<td${empty result.sprtYr?' class="td_bg"':'' }><fmt:formatNumber value="${result.cnt }" /></td>
		</c:forEach>
		</tr>
		<tr>
			<th>지원금액</th>
		<c:forEach items="${resultSprtYrList }" var="result">
			<td${empty result.sprtYr?' class="td_bg"':'' }><fmt:formatNumber value="${result.amt }" /></td>
		</c:forEach>
		</tr>
	</tbody>
</table>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
