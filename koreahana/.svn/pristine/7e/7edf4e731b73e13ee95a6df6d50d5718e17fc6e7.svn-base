<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spf/spfPrcList.js"></script>

<c:set var="sprtType" value="adt" />
<c:set var="modeName" value="kspMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<c:set var="showTestRsltCd" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th>구분</th>
							<th>지원대상</th>
							<th>생년월일</th>
							<th>신청일</th>
							<th>이전과정 수료일</th>
							<th>응시번호</th>
							<th>시험결과</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd) }" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
							<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd, '-') }" /></td>
							<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.eduFnshYmd, '-') }" /></td>
							<td><c:out value="${result.exslno }" /></td>
							<td><c:out value="${jtag:getCdNm(testRsltCdList,result.testRsltCd) }" /></td>
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
