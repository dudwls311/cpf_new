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
	<h4 class="tit">취업연계 직업훈련 교육 수료율, 자격증 취득률, 취업률</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>교육명</th>
			<th>교육 대상자수</th>
			<th>교육 수료자수</th>
			<th>교육 수료율</th>
			<th>자격증 취득자수</th>
			<th>자격증 취득률</th>
			<th>취업자수</th>
			<th>취업률</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${resultList }" var="result"><c:if test="${!empty result.bizSeCd }">
		<tr>
			<th><c:out value="${jtag:getCdNm(bizSeCdList, result.bizSeCd) }" /></th>
			<td>${result.tcnt }</td>
			<td>${result.eduFnshCnt }</td>
			<td>${result.fnshPcnt }%</td>
			<td>${result.crtfctAcqsCnt }</td>
			<td>${result.crtPcnt }%</td>
			<td>${result.empmCnt }</td>
			<td>${result.empPcnt }%</td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
	<c:forEach items="${resultList }" var="result"><c:if test="${empty result.bizSeCd }">
		<tr>
			<th>총계</th>
			<td>${result.tcnt }</td>
			<td>${result.eduFnshCnt }</td>
			<td>${result.fnshPcnt }%</td>
			<td>${result.crtfctAcqsCnt }</td>
			<td>${result.crtPcnt }%</td>
			<td>${result.empmCnt }</td>
			<td>${result.empPcnt }%</td>
		</tr>
	</c:if></c:forEach>
	</tfoot>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
