<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>

<div class="con_b_tp">
	<h4 class="tit">연도별·월별 가입현황 </h4>
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
			<th>월평균</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="allCnt" value="0" />
	<c:forEach items="${fthNewJoinYmList }" var="y"><c:if test="${!empty y.bbJoinYear && empty y.bbJoinMonth }">
		<tr>
			<th><c:out value="${y.bbJoinYear }" /></th>
		<c:set var="cntCnt" value="0" />
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthNewJoinYmList }" var="result"><c:if test="${y.bbJoinYear == result.bbJoinYear && result.bbJoinMonth == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntCnt" value="${cntCnt+1 }" /><c:set var="cntTot" value="${cntTot + result.cnt }" /><c:set var="allCnt" value="${allCnt + 1 }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
			<td class="td_bg"><b><fmt:formatNumber value="${jtag:average(cntTot,cntCnt,'') }" /></b></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="13">총계</th>
			<td class="td_bg">
				<c:set var="cntAllTot" value="0" />
				<c:forEach items="${fthNewJoinYmList }" var="allTotal"><c:if test="${empty y.bbJointYear && empty y.bbJoinMonth }"><c:set var="cntAllTot" value="${allTotal.cnt }" /></c:if></c:forEach>
				<b><fmt:formatNumber value="${cntAllTot }" /></b>
			</td>
			<td class="td_bg"><b><fmt:formatNumber value="${jtag:average(cntAllTot,allCnt,'') }" /></b></td>
		</tr>
	</tfoot>
</table>

<c:set var="dcsnSprtAmtList" value="${fn:split('50000,100000,150000,200000,250000,300000,350000,400000,450000,500000',',') }" />
<div class="con_b_tp">
	<h4 class="tit">적립금액별 가입현황 </h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
		<c:forEach var="dcsnSprtAmt" items="${dcsnSprtAmtList }">
			<th><fmt:formatNumber value="${dcsnSprtAmt/10000 }" pattern="#"/>만원</th>
		</c:forEach>
			<th>총계</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>구분</th>
		<c:set var="cntTot" value="0" />
		<c:forEach var="dcsnSprtAmt" items="${dcsnSprtAmtList }">
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthNewSprtAmtList }" var="result"><c:if test="${dcsnSprtAmt == result.dcsnSprtAmt}">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntTot" value="${cntTot + result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" pattern="#"/></td>
		</c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${cntTot }" pattern="#" /></td>
		</tr>
		<tr>
			<th>비율(%)</th>
		<c:forEach var="dcsnSprtAmt" items="${dcsnSprtAmtList }">
			<c:set var="amtPercent" value="0" />
			<c:forEach items="${fthNewSprtAmtList }" var="result"><c:if test="${dcsnSprtAmt == result.dcsnSprtAmt}">
				<c:set var="amtPercent" value="${result.amtPercent }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${amtPercent }" /></td>
		</c:forEach>
			<td class="td_bg">100</td>
		</tr>
	</tbody>
</table>


<div class="con_b_tp">
	<h4 class="tit">성별·연령별 가입현황(가입당시 만 나이 기준) </h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>연도</th>
			<th>성별</th>
			<th>총계</th>
		<c:forEach var="ageCd" items="${ageCdList }">
			<th>${ageCd.indivCdNm }</th>
		</c:forEach>
		</tr>
	</thead>
	<tbody>
	<c:set var="allCnt" value="0" />
	<c:forEach items="${fthNewGenderAgeList }" var="y"><c:if test="${!empty y.bbJoinYear && empty y.ageCd && empty y.genderCd }">
		<c:forEach var="genderCd" items="${genderCdList }" varStatus="genderStatus">
		<tr>
		<c:if test="${genderStatus.first }">
			<th rowspan="2"><c:out value="${y.bbJoinYear }" />년</th>
		</c:if>
			<th>${genderCd.indivCdNm }</th>
			<td>
			<c:set var="genderTot" value="0" />
			<c:forEach items="${fthNewGenderAgeList }" var="result"><c:if test="${y.bbJoinYear == result.bbJoinYear && result.genderCd == genderCd.indivCd && empty result.ageCd }">
				<c:set var="genderTot" value="${result.cnt }" />
			</c:if></c:forEach>
				<fmt:formatNumber value="${genderTot }" />
			</td>
		<c:forEach var="ageCd" items="${ageCdList }">
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthNewGenderAgeList }" var="result"><c:if test="${y.bbJoinYear == result.bbJoinYear && result.genderCd == genderCd.indivCd && result.ageCd == ageCd.indivCd}">
				<c:set var="cnt" value="${result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
		</tr>
		</c:forEach>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="2">총계</th>		
			<td class="td_bg">
			<c:set var="allTot" value="0" />
			<c:forEach items="${fthNewGenderAgeList }" var="result"><c:if test="${empty result.bbJoinYear && empty result.genderCd && empty result.ageCd }">
				<c:set var="allTot" value="${result.cnt }" />
			</c:if></c:forEach>
				<fmt:formatNumber value="${allTot }" />
			</td>
		<c:forEach var="ageCd" items="${ageCdList }">
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthNewGenderAgeList }" var="result"><c:if test="${empty result.genderCd && result.ageCd == ageCd.indivCd}">
				<c:set var="cnt" value="${cnt + result.cnt }" />
			</c:if></c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
		</tr>
	</tfoot>
</table>


<div class="con_b_tp">
	<h4 class="tit">연도별·월별 중도해지 현황 </h4>
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
	<c:set var="allCnt" value="0" />
	<c:forEach items="${fthMdwJoinYmList }" var="y"><c:if test="${!empty y.bbJoinYear && empty y.bbJoinMonth }">
		<tr>
			<th><c:out value="${y.bbJoinYear }" /></th>
		<c:set var="cntCnt" value="0" />
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthMdwJoinYmList }" var="result"><c:if test="${y.bbJoinYear == result.bbJoinYear && result.bbJoinMonth == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntCnt" value="${cntCnt+1 }" /><c:set var="cntTot" value="${cntTot + result.cnt }" /><c:set var="allCnt" value="${allCnt + 1 }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="13">총계</th>
			<td class="td_bg">
				<c:set var="cntAllTot" value="0" />
				<c:forEach items="${fthMdwJoinYmList }" var="allTotal"><c:if test="${empty y.bbJointYear && empty y.bbJoinMonth }"><c:set var="cntAllTot" value="${allTotal.cnt }" /></c:if></c:forEach>
				<b><fmt:formatNumber value="${cntAllTot }" /></b>
			</td>
		</tr>
	</tfoot>
</table>


<div class="con_b_tp">
	<h4 class="tit">중도해지사유 </h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>사유</th>
		<c:forEach var="cncltnRsnCd" items="${cncltnRsnCdList }">
			<th>${cncltnRsnCd.indivCdNm }</th>
		</c:forEach>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>인원수</th>
		<c:forEach var="cncltnRsnCd" items="${cncltnRsnCdList }">
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthMdwCncltnRsnCdList }" var="result"><c:if test="${result.cncltnRsnCd == cncltnRsnCd.indivCd}">
				<c:set var="cnt" value="${result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
		</tr>
	</tbody>
</table>



<div class="con_b_tp">
	<h4 class="tit">연도별·월별 만기해지 현황 </h4>
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
	<c:set var="allCnt" value="0" />
	<c:forEach items="${fthMtrJoinYmList }" var="y"><c:if test="${!empty y.bbJoinYear && empty y.bbJoinMonth }">
		<tr>
			<th><c:out value="${y.bbJoinYear }" /></th>
		<c:set var="cntCnt" value="0" />
		<c:set var="cntTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthMtrJoinYmList }" var="result"><c:if test="${y.bbJoinYear == result.bbJoinYear && result.bbJoinMonth == mt }">
				<c:set var="cnt" value="${result.cnt }" /><c:set var="cntCnt" value="${cntCnt+1 }" /><c:set var="cntTot" value="${cntTot + result.cnt }" /><c:set var="allCnt" value="${allCnt + 1 }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><b><fmt:formatNumber value="${cntTot }" /></b></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="13">총계</th>
			<td class="td_bg">
				<c:set var="cntAllTot" value="0" />
				<c:forEach items="${fthMtrJoinYmList }" var="allTotal"><c:if test="${empty y.bbJointYear && empty y.bbJoinMonth }"><c:set var="cntAllTot" value="${allTotal.cnt }" /></c:if></c:forEach>
				<b><fmt:formatNumber value="${cntAllTot }" /></b>
			</td>
		</tr>
	</tfoot>
</table>


<div class="con_b_tp">
	<h4 class="tit">만기해지사유 </h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>사유</th>
		<c:forEach var="usdusgCd" items="${usdusgCdList }">
			<th>${usdusgCd.indivCdNm }</th>
		</c:forEach>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>인원수</th>
		<c:forEach var="usdusgCd" items="${usdusgCdList }">
			<c:set var="cnt" value="0" />
			<c:forEach items="${fthMtrUsdusgCdList }" var="result"><c:if test="${result.usdusgCd == usdusgCd.indivCd}">
				<c:set var="cnt" value="${result.cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
		</tr>
	</tbody>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
