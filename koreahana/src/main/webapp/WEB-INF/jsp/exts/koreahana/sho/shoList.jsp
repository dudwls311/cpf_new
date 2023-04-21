<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprListSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoList.js"></script>

<c:set var="sprtType" value="sho" />
<c:set var="modeName" value="ksMode" />
<c:set var="showExcelUpload" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>

<form action="<c:url value="${actionUrl }" />" id="listForm">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeSprtSttsActionJson" />
	<input type="hidden" id="sprtSttsCd2" name="sprtSttsCd" value="" />
	
	<table class="table_style thd_v_m">
		<thead>
			<tr>
				<th><input type="checkbox" class="st_check" id="chkAll" onclick="fnAllChkToggle();" /><label for="chkAll"><span class="comment">전체선택</span></label></th>
				<th>지원자유형</th>
				<th>장학금유형</th>
				<th>지원대상</th>
				<th>생년월일</th>
				<th>신청일</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList }" varStatus="status">
				<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
				<tr>
					<td>
						<input type="checkbox" class="st_check" id="<c:out value="listChk${status.count }" />" name="sprtSnArr" value="<c:out value="${result.sprtSn}" />" />
						<label for="<c:out value="listChk${status.count }" />"><span class="comment">전체선택</span></label>
					</td>
					<td><c:out value="${empty result.ntkrdfUnqNo ? '제3국출생' : '북한이탈주민' }" /></td>
					<td>
						<c:choose>
							<c:when test="${result.sholSlctnType == 'ntkrdf1' || result.sholSlctnType == 'thirdcnty1'}"><c:set var="sholSlctnName" value="대학원생" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf2_1' || result.sholSlctnType == 'thirdcnty2_1'}"><c:set var="sholSlctnName" value="대학생(연속지원)" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf2_2' || result.sholSlctnType == 'thirdcnty2_2'}"><c:set var="sholSlctnName" value="대학생(1회지원)" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf2_3' || result.sholSlctnType == 'thirdcnty2_3'}"><c:set var="sholSlctnName" value="대학생(전문대)" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf2_4' || result.sholSlctnType == 'thirdcnty2_4'}"><c:set var="sholSlctnName" value="대학생(사이버/방송/통신대)" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf3' || result.sholSlctnType == 'thirdcnty3'}"><c:set var="sholSlctnName" value="계절학기 수강생" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf4_1' || result.sholSlctnType == 'thirdcnty4_1'}"><c:set var="sholSlctnName" value="중학생" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf4_2' || result.sholSlctnType == 'thirdcnty4_2'}"><c:set var="sholSlctnName" value="고등학생" /></c:when>
							<c:when test="${result.sholSlctnType == 'ntkrdf5' || result.sholSlctnType == 'thirdcnty5'}"><c:set var="sholSlctnName" value="검정고시 합격생" /></c:when>
							<c:otherwise><c:set var="sholSlctnName" value="-" /></c:otherwise>
						</c:choose>
						<c:out value="${sholSlctnName }" />
					</td>
					<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
					<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-') }" /></td>
					<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
					<td class="td_bg">
						<c:out value="${jtag:getCdNm(sprtSttsCdList,result.sprtSttsCd) }" />
						<c:if test="${result.sprtSttsCd == enumSprUndCd }">
							&nbsp;&nbsp;<a href="#" class="btn_st btn_c_re" onclick="fnRsnChg('<c:out value="${result.sprtSn}" />');return false;" >사유등록</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${fn:length(resultList) < 1 }">
				<tr>
					<td colspan="8">해당 데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</form>
<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>
<%-- <%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %> --%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
