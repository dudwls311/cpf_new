<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/vdo/vdoPrcList.js"></script>

<c:set var="modeName" value="kvpMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th>보호자</th>
							<th>지원대상</th>
							<th>신청일</th>
							<th>기존수해여부</th>
							<th>학습지중복대상</th>
							<th>중도퇴가</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${not empty result.prtcrFlnm ? result.prtcrFlnm : '-' }" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
							<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
							<td><c:out value="${jtag:getCdNm(existBnfCdList, result.existBnfCd)}" /></td>
							<td><c:if test="${!empty result.lnbkDpcnTrgtYn }"><c:out value="${result.lnbkDpcnTrgtYn == 'Y'?'O':'X'}" /></c:if></td>
							<td><c:out value="${jtag:convertDateSplitString(result.mdwGbkhmYmd,'-')}" /></td>							
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
