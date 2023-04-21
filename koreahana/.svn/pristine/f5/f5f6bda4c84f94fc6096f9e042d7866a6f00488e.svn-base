<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emp/empPrcList.js"></script>

<c:set var="modeName" value="kepMode" />
<c:set var="hideSprtSttsCd" value="Y" />
<c:set var="hideWrite" value="Y" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>
<div id="percentDiv" style="display:none"><%//공통 검색폼 아래에 들어갈 내용 %>
<c:set var="fnshPcnt" value="0" /> 
<c:set var="crtPcnt" value="0" /> 
<c:set var="empPcnt" value="0" /> 
<c:forEach items="${sttList }" var="stt"><c:if test="${!empty stt.bizSeCd }">
	<c:set var="fnshPcnt" value="${stt.fnshPcnt }" />
	<c:set var="crtPcnt" value="${stt.crtPcnt }" />
	<c:set var="empPcnt" value="${stt.empPcnt }" />
</c:if></c:forEach>
	<div class="box_w_blue board_l_stat_i MAT-20">
		<b>교육 수료율</b><span class="bg_c_bl"><fmt:formatNumber value="${fnshPcnt }" />% </span>
		<span class="bar"></span>
		<b>자격증 취득률</b><span class="bg_c_bl"><fmt:formatNumber value="${crtPcnt }" />% </span>
		<span class="bar"></span>
		<b>취업률</b><span class="bg_c_bl"><fmt:formatNumber value="${empPcnt }" />% </span>
	</div>
</div>
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th>구분</th>
							<th>지원대상</th>
							<th>생년월일</th>
							<th>신청일</th>
							<th>교육기간</th>
							<th>수료여부</th>
							<th>자격증</th>
							<th>취업</th>
							<th>취업처</th>
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
							<td><c:out value="${jtag:convertDateSplitString(result.eduBgngYmd, '-')} ~ ${jtag:convertDateSplitString(result.eduEndYmd, '-')}" /></td>
							<td><c:out value="${empty result.eduFnshCmptnYn ?'': (result.eduFnshCmptnYn == 'Y'?'O':'x')}" /></td>
							<td><c:out value="${empty result.crtfctAcqsYn ?'': (result.crtfctAcqsYn == 'Y'?'O':'x')}" /></td>
							<td><c:out value="${empty result.empmYn ?'': (result.empmYn == 'Y'?'O':'x')}" /></td>
							<td><c:out value="${result.empmCoNm}" /></td>
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
