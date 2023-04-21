<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/adt/adtPrcList.js"></script>


<c:set var="sprtType" value="adt" />
<c:set var="modeName" value="kapMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th>No.</th>
							<th>구분</th>
							<th>지원대상</th>
							<th>신청일</th>
							<th>최초결정액</th>
							<th>지급액</th>
							<th>잔액</th>
							<th>총지급횟수</th>
							<th>지급결정일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<c:set var="giveTotalAmt" value="0" />
						<c:forEach items="${result.rndList }" var="rnd"><c:set var="giveTotalAmt" value="${giveTotalAmt + rnd.giveAmt }" /></c:forEach>
						<tr>
							<td><c:out value="${no}" /></td>
							<td><c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd) }" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
							<td>${regDt }</td>
							<td><fmt:formatNumber value="${result.frstDcsnAmt}" /></td>
							<td><fmt:formatNumber value="${empty result.frstDcsnAmt?'':giveTotalAmt}" /></td>
							<td><fmt:formatNumber value="${empty result.frstDcsnAmt?'':result.frstDcsnAmt - giveTotalAmt}" /></td>
							<td><fmt:formatNumber value="${empty result.rndList?'':fn:length(result.rndList)}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.giveDcsnYmd,'-')}" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
