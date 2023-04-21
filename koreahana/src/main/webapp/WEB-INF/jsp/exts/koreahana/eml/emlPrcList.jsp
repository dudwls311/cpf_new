<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/eml/emlPrcList.js"></script>

<c:set var="sprtType" value="eml" />
<c:set var="modeName" value="kepMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th>차수</th>
							<th>지원대상</th>
							<th>하나센터(상담사)</th>
							<th>신청일</th>
							<th>신청금액</th>
							<th>지급금액</th>
							<th>지급일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${result.cycl }" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
							<td><c:out value="${result.hanactNm }(${result.cnslFlnm })" /></td>
							<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
							<td><fmt:formatNumber value="${result.aplyAmt }" /></td>
							<td><fmt:formatNumber value="${result.giveAmt }" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.giveYmd, '-') }" /></td>
							
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
