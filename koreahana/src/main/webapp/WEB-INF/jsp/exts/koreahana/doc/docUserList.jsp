<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/exts/koreahana/com/header_inc.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/doc/docList.js"></script>
<c:set var="dateFormat" value="yyyy-MM-dd" />
<c:set var="dateTimeFormat" value="yyyy-MM-dd HH:mm" />

<input type="hidden" id="actionUrl" value="<c:url value="/user/exts/koreahana/doc/index.do" />" />
<form id="docWritePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kdMode" name="kdMode" value="" />
	<input type="hidden" id="docBoxSn" name="docBoxSn" value="" />
</form>
<form id="downloadForm" action="<c:url value="${actionUrl }" />">
	<input type="hidden" name="kdMode" value="fileDownload" />
	<input type="hidden" name="docBoxSn" value="" />
</form>
<h4 class="tit">문서관리</h4>
<p class="p_info">지원서 신청시 첨부하는 다양한 서류를 저장하여 신청서 작성시 이용할 수 있습니다.</p>

<div class="con_b_tp">
	<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
	<%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %>
</div>
<table class="table_style thd_v_m">
	<colgroup>
		<col width="5%" />
		<col width="*" />
		<col width="35%" />
		<col width="11%" />
		<col width="11%" />
	</colgroup>

	<thead>
		<tr>
			<th>No.</th>
			<th>문서명</th>
			<th>파일명</th>
			<th>등록일</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList }" varStatus="status">
			<tr>
				<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
				<td><fmt:formatNumber value="${no }" /> </td>
				<td class="AlignLeft"><c:out value="${result.docBoxNm}" /></td>
				<td class="AlignLeft"><a class="txt_ico_f" href="#none" onclick="fnDownload('<c:out value="${result.docBoxSn }" />');return false;"><c:out value="${result.orgnlAtchFileNm}" /></a></td>
				<td><fmt:formatDate value="${result.regDt}" pattern="${dateFormat }" /></td>
				<td><a href="#" class="btn_st btn_c_or" onclick="fnWrite('<c:out value="${result.docBoxSn }" />');return false;">수정</a> <a href="#" class="btn_st btn_c_gy" onclick="fnDelete('<c:out value="${result.docBoxSn }" />');return false;">삭제</a></td>
			</tr>
		</c:forEach>
		<c:if test="${fn:length(resultList) < 1 }">
			<tr>
				<td colspan="5">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>

<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>