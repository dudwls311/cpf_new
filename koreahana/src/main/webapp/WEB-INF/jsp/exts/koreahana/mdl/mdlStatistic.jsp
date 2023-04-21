<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>

<form action="?">
	<div class="box_w_gray">
		<div class="search_wrap">
			<div class="search_left">
				<label for="sprtYear">지급년도</label>
				<select id="sprtYear" name="sprtYear" class="st_select">
					<c:forEach var="y" items="${yearList }" >
						<option value="${y }" ${y == searchVO.sprtYear ? 'selected':'' }>${y }</option>
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
	<h4 class="tit">전체 지원현황 <p class="p_info FloatRight">(단위 : 원)</p></h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="50px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th colspan="2">구분</th>
		<c:forEach var="m" begin="1" end="12">
			<th>${m }월</th>
		</c:forEach>
			<th>총계</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${dssSeCdList }" var="cd">
		<tr>
			<th rowspan="2"><c:out value="${cd.indivCdNm }" /></th>
			<th>금액</th>
		<c:set var="amtTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="amt" value="0" />
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'dssSeCd' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="amt" value="${result.amt }" /><c:set var="amtTot" value="${amtTot + result.amt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${amt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${amtTot }" /></b></td>
		</tr>
		<tr>
			<th>인원</th>
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'dssSeCd' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th rowspan="2">총계</th>
			<th>금액</th>
		<c:set var="amtTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="amt" value="0" />			
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'total' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="amt" value="${result.amt }" /><c:set var="amtTot" value="${amtTot + result.amt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${amt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${amtTot }" /></b></td>
		</tr>
		<tr>
			<th>인원</th>
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />			
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'total' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</tfoot>
</table>

<div class="con_b_tp">
	<h4 class="tit">공공의료 체계지원 현황 </h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
		<c:forEach var="m" begin="1" end="12">
			<th>${m }월</th>
		</c:forEach>
			<th>총계</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${sprtSeCdList }" var="cd">
		<tr>
			<th><c:out value="${cd.indivCdNm }" /></th>
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'sprtSeCd' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>총계</th>
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />			
			<c:forEach items="${resultList }" var="result"><c:if test="${result.gb == 'total' && result.cd == cd.indivCd && result.mt == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</tfoot>
</table>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
