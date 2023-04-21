<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/lnb/lnbPrcList.js"></script>

<c:set var="modeName" value="klpMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">보호자</th>
							<th scope="col">지원대상(1순위)</th>
							<th scope="col">지원대상(2순위)</th>
							<th scope="col">신청일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList }" varStatus="status">
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${no}" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
							<td>
								<c:if test="${not empty result.lnbPrc1 }">
									<c:out value="${result.lnbPrc1.flnm }(${jtag:convertDateSplitString(result.lnbPrc1.brdtYmd, '-') })" />
								</c:if>
							</td>
							<td>
								<c:if test="${not empty result.lnbPrc2 }">
									<c:out value="${result.lnbPrc2.flnm }(${jtag:convertDateSplitString(result.lnbPrc2.brdtYmd, '-') })" />
								</c:if>
							</td>
							<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
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
