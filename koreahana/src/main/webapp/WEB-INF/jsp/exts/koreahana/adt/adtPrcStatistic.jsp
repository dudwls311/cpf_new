<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>


			<form action="?">
		<div class="box_w_gray">
			<div class="search_wrap">
				<div class="search_left">
					<label for="searchYear">지급년도</label>
					<select id="searchYear" name="searchYear" class="st_select">
					<c:forEach var="y" items="${yearList }" >
						<option value="${y }" ${y == searchVO.searchYear?' selected':'' }>${y }</option>
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
	<h4 class="tit"><c:out value="${searchVO.searchYear}" />년 월별 가산금 지급현황</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th colspan="2">구분</th>
		<c:forEach var="m" begin="1" end="12">
			<th>${m }월</th>
		</c:forEach>
			<th>합계</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="allCnt" value="0" />
	<c:forEach items="${bizSeCdList }" var="cd">
		<tr>
			<th rowspan="2"><c:out value="${cd.indivCdNm }" /></th>
			<th>지급액</th>
		<c:set var="valTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="val" value="0" />
			<c:forEach items="${stmonthList }" var="result"><c:if test="${cd.indivCd == result.bizSeCd && result.giveYm == mt }">
				<c:set var="val" value="${result.giveAmt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg">
				<b><fmt:formatNumber value="${valTot }" /></b>
			</td>
		</tr>
		<tr>
			<th>지급건</th>
		<c:set var="valTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="val" value="0" />
			<c:forEach items="${stmonthList }" var="result"><c:if test="${cd.indivCd == result.bizSeCd && result.giveYm == mt }">
				<c:set var="val" value="${result.giveCnt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg">
				<b><fmt:formatNumber value="${valTot }" /></b>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th rowspan="2">합계</th>
			<th>지급액</th>
		<c:set var="valTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="val" value="0" />
			<c:forEach items="${stmonthList }" var="result"><c:if test="${empty result.bizSeCd && result.giveYm == mt }">
				<c:set var="val" value="${result.giveAmt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg">
				<b><fmt:formatNumber value="${valTot }" /></b>
			</td>
		</tr>
		<tr>
			<th>지급건</th>
		<c:set var="valTot" value="0" />
		<c:forEach var="m" begin="1" end="12">
			<c:set var="mt" value="${m < 10?'0':'' }${m }" />
			<c:set var="val" value="0" />
			<c:forEach items="${stmonthList }" var="result"><c:if test="${empty result.bizSeCd && result.giveYm == mt }">
				<c:set var="val" value="${result.giveCnt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg">
				<b><fmt:formatNumber value="${valTot }" /></b>
			</td>
		</tr>
	</tfoot>
</table>



<div class="con_b_tp">
	<h4 class="tit">연도별 가산금 지급현황</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th rowspan="2">구분</th>
		<c:forEach items="${bizSeCdList }" var="cd">
			<th colspan="2"><c:out value="${cd.indivCdNm }" /></th>
		</c:forEach>
			<th colspan="2">합계</th>
		</tr>
		<tr>
		<c:forEach items="${bizSeCdList }" var="cd">
			<th>지급액</th>
			<th>지급건</th>
		</c:forEach>
			<th>지급액</th>
			<th>지급건</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${styearList }" var="styear"><c:if test="${!empty styear.giveYm && !empty styear.bizSeCd}">
		<tr>
			<th><c:out value="${styear.giveYm }" /></th>
		<c:set var="valTot" value="0" />
		<c:set var="cntTot" value="0" />
		<c:forEach items="${bizSeCdList }" var="cd">
			<c:set var="val" value="0" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${styearList }" var="result"><c:if test="${cd.indivCd == result.bizSeCd && styear.giveYm == result.giveYm}">
				<c:set var="val" value="${result.giveAmt }" /><c:set var="valTot" value="${valTot + val }" />
				<c:set var="cnt" value="${result.giveCnt }" /><c:set var="cntTot" value="${cntTot + cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
			<td class="td_bg"><fmt:formatNumber value="${cntTot }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>합계</th>
		<c:set var="valTot" value="0" />
		<c:set var="cntTot" value="0" />
		<c:forEach items="${bizSeCdList }" var="cd">
			<c:set var="val" value="0" />
			<c:set var="cnt" value="0" />
			<c:forEach items="${styearList }" var="result"><c:if test="${cd.indivCd == result.bizSeCd && empty result.giveYm}">
				<c:set var="val" value="${result.giveAmt }" /><c:set var="valTot" value="${valTot + val }" />
				<c:set var="cnt" value="${result.giveCnt }" /><c:set var="cntTot" value="${cntTot + cnt }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${cnt }" /></td>
		</c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
			<td class="td_bg"><fmt:formatNumber value="${cntTot }" /></td>
		</tr>
	</tfoot>
</table>


<div class="con_b_tp">
	<h4 class="tit">연도별 장애 가산금 지급결정 현황 (장애정도)</h4>
</div>
	<p class="p_info FloatLeft">19년 7월부터 6급(장애의 정도가 경한 경우)에 대하여도 장애가산금 지급</p>
	<div class=" FloatRight">(지급 결정일 기준 / 단위 : 명)</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
			<th>장애의 정도가 심한 장애인</th>
			<th>장애의 정도가 심하지 아니한 장애인</th>
			<th>합계</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${styearDegrList }" var="styear"><c:if test="${!empty styear.giveDcsnYear && empty styear.dsbltyDegr}">
		<tr>
			<th><c:out value="${styear.giveDcsnYear }" /></th>
			<c:set var="valTot" value="0" />
			<c:set var="val" value="0" />
			<c:set var="val2" value="0" />
			<c:forEach items="${styearDegrList }" var="result"><c:if test="${styear.giveDcsnYear == result.giveDcsnYear}">
				<c:if test="${result.dsbltyDegr == '경증' }"><c:set var="val" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" /></c:if>
				<c:if test="${result.dsbltyDegr == '중증' }"><c:set var="val2" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val2 }" /></c:if>
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${val2 }" /></td>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>합계</th>
		<c:set var="valTot" value="0" />
		<c:set var="val" value="0" />
		<c:set var="val2" value="0" />
			<c:forEach items="${styearDegrList }" var="result"><c:if test="${!empty result.giveDcsnYear && !empty result.dsbltyDegr}">
				<c:if test="${result.dsbltyDegr == '경증' }"><c:set var="val" value="${val + result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" /></c:if>
				<c:if test="${result.dsbltyDegr == '중증' }"><c:set var="val2" value="${val2 + result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val2 }" /></c:if>
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${val2 }" /></td>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</tfoot>
</table>


<div class="con_b_tp">
	<h4 class="tit">연도별 장기치료 가산금 지급결정 현황 (입원기간)
		<p class="p_info FloatRight">(지급 결정일 기준 / 단위 : 명)</p>
	</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
		<c:forEach begin="1" end="12" var="i">
			<th>${i }개월</th>
		</c:forEach>
			<th>합계</th>
		</tr>
		<tr>
	</thead>
	<tbody>
	<c:forEach items="${styearPeriodList }" var="styear"><c:if test="${!empty styear.giveDcsnYear && empty styear.hsptzPeriod}">
		<tr>
			<th><c:out value="${styear.giveDcsnYear }" /></th>
		<c:set var="valTot" value="0" />
		<c:forEach begin="1" end="12" var="i">
			<c:set var="val" value="0" />
			<c:forEach items="${styearPeriodList }" var="result"><c:if test="${i == result.hsptzPeriod && styear.giveDcsnYear == result.giveDcsnYear}">
				<c:set var="val" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>합계</th>
		<c:set var="valTot" value="0" />
		<c:forEach begin="1" end="12" var="i">
			<c:set var="val" value="0" />
			<c:forEach items="${styearPeriodList }" var="result"><c:if test="${i == result.hsptzPeriod && !empty result.giveDcsnYear}">
				<c:set var="val" value="${val + result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" />
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
		</c:forEach>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</tfoot>
</table>



<div class="con_b_tp">
	<h4 class="tit">연도별 제3국 출생자녀양육 가산금 지급결정 현황 (자녀연령/만나이)
		<p class="p_info FloatRight">(지급 결정일 기준 / 단위 : 명)</p>
	</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
		<col width="">
		<col width="">
<!-- 		<col width=""> -->
	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
			<th>0~4세</th>
			<th>5~9세</th>
			<th>10~15세</th>
<!-- 			<th>16세이상</th> -->
			<th>합계</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${styearAgeList }" var="styear"><c:if test="${!empty styear.giveDcsnYear && empty styear.ageType}">
		<tr>
			<th><c:out value="${styear.giveDcsnYear }" /></th>
			<c:set var="valTot" value="0" />
			<c:set var="val" value="0" />
			<c:set var="val2" value="0" />
			<c:set var="val3" value="0" />
			<c:set var="val4" value="0" />
			<c:forEach items="${styearAgeList }" var="result"><c:if test="${styear.giveDcsnYear == result.giveDcsnYear}">
				<c:if test="${result.ageType == '1' }"><c:set var="val" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" /></c:if>
				<c:if test="${result.ageType == '2' }"><c:set var="val2" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val2 }" /></c:if>
				<c:if test="${result.ageType == '3' }"><c:set var="val3" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val3 }" /></c:if>
				<c:if test="${result.ageType == '4' }"><c:set var="val4" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val4 }" /></c:if>
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${val2 }" /></td>
			<td><fmt:formatNumber value="${val3 }" /></td>
<%-- 			<td><fmt:formatNumber value="${val4 }" /></td> --%>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</c:if></c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>합계</th>
			<c:set var="valTot" value="0" />
			<c:set var="val" value="0" />
			<c:set var="val2" value="0" />
			<c:set var="val3" value="0" />
			<c:set var="val4" value="0" />
			<c:forEach items="${styearAgeList }" var="result"><c:if test="${!empty result.giveDcsnYear && !empty result.ageType}">
				<c:if test="${result.ageType == '1' }"><c:set var="val" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val }" /></c:if>
				<c:if test="${result.ageType == '2' }"><c:set var="val2" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val2 }" /></c:if>
				<c:if test="${result.ageType == '3' }"><c:set var="val3" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val3 }" /></c:if>
				<c:if test="${result.ageType == '4' }"><c:set var="val4" value="${result.giveDcsnCnt }" /><c:set var="valTot" value="${valTot + val4 }" /></c:if>
			</c:if></c:forEach>
			<td><fmt:formatNumber value="${val }" /></td>
			<td><fmt:formatNumber value="${val2 }" /></td>
			<td><fmt:formatNumber value="${val3 }" /></td>
<%-- 			<td><fmt:formatNumber value="${val4 }" /></td> --%>
			<td class="td_bg"><fmt:formatNumber value="${valTot }" /></td>
		</tr>
	</tfoot>
</table>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
