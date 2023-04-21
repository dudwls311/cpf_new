<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvList.js"></script>

<c:set var="sprtType" value="emv" />
<c:set var="modeName" value="keMode" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListSearchForm.jsp" %>

<form id="emvPageForm" action="?">
	<input type="hidden" name="keMode" value="write" />
	<input type="hidden" name="pbancrcSn" value="" />
	<input type="hidden" name="pbancrcCtgryFrstCd" value="" />
	<input type="hidden" name="sprtSn" value="" />
</form>

<form action="<c:url value="${actionUrl }" />" id="listForm">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeSprtSttsActionJson" />
	<input type="hidden" id="sprtSttsCd2" name="sprtSttsCd" value="" />
	
	<table class="table_style thd_v_m">
		<thead>
			<tr>
				<c:if test="${isCenterStaff == false }">
					<th><input type="checkbox" class="st_check" id="chkAll" onclick="fnAllChkToggle();" /><label for="chkAll"><span class="comment">전체선택</span></label></th>
				</c:if>
				<th>지원대상</th>
				<th>생년월일</th>
				<th>신청일</th>
				<th>하나센터(상담사)</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList }" varStatus="status">
				<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
				<tr>
					<c:if test="${isCenterStaff == false }">
						<td>
							<input type="checkbox" class="st_check" id="<c:out value="listChk${status.count }" />" name="sprtSnArr" value="<c:out value="${result.sprtSn}" />" />
							<label for="<c:out value="listChk${status.count }" />"><span class="comment">전체선택</span></label>
						</td>
					</c:if>
					<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm }" /></a></td>
					<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd, '-') }" /></td>
					<td><fmt:formatDate value="${result.regDt}" pattern="${adminListDateFormat }" /></td>
					<td><c:out value="${result.hanactNm }(${result.cnslFlnm })" /></td>
					<td class="td_bg">
						<c:out value="${jtag:getCdNm(sprtSttsCdList,result.sprtSttsCd) }" />
						<c:choose>
							<c:when test="${isAdmin == true || isFoundStaff == true }">
								<c:if test="${result.sprtSttsCd == enumSprUndCd }">
									&nbsp;&nbsp;<a href="#" class="btn_st btn_c_re" onclick="fnRsnChg('<c:out value="${result.sprtSn}" />');return false;" >사유등록</a>
								</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${result.sprtSttsCd == enumSprUndCd }">
									&nbsp;&nbsp;<a href="#" class="btn_st btn_c_re" onclick="fnEmvRsnShow(<c:out value="'${result.pbancrcSn}','${result.pbancrcCtgryFrstCd}','${result.sprtSn}'" />);return false;" >사유확인</a>
								</c:if>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${fn:length(resultList) < 1 }">
				<tr>
					<td colspan="7">해당 데이터가 존재하지 않습니다.</td>
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
