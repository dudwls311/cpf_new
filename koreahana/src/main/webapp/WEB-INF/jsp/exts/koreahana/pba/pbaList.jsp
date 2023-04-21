<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>

<script type="text/javascript" src="/resources/js/exts/koreahana/pba/pbaList.js"></script>

<c:choose>
	<c:when test="${enumFrsEml == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/eml/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/adt/index.do" />
		<c:set var="modeName" value="kaMode" />
	</c:when>
	<c:when test="${enumFrsSho == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/sho/index.do" />
		<c:set var="modeName" value="ksMode" />
	</c:when>
	<c:when test="${enumFrsEdu == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/edu/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsVdo == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/vdo/index.do" />
		<c:set var="modeName" value="kvMode" />
	</c:when>
	<c:when test="${enumFrsLnb == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/lnb/index.do" />
		<c:set var="modeName" value="klMode" />
	</c:when>
	<c:when test="${enumFrsSpf == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/spf/index.do" />
		<c:set var="modeName" value="ksMode" />
	</c:when>
	<c:when test="${enumFrsEmv == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/emv/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsEmp == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="actAdmUrl" value="/exts/koreahana/emp/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
</c:choose>

<form id="sprtWritePageForm" action="<c:url value="${actAdmUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="write" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="" />
</form>
<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="rlsYn" value="<c:out value="${searchVO.rlsYn }" />" />
	<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${searchVO.pbancrcSttsCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kpMode" name="kpMode" value="" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<form action="?">
	<div class="box_w_gray ig_wrap ">
		<div class="ig_s">
			<c:if test="${ isCenterStaff == false }">
				<label for="rlsYn" class="MAL0">공개여부</label>
				<select name="rlsYn" id="rlsYn" class="st_select">
					<option value="">전체</option> 
					<option value="Y" ${searchVO.rlsYn == 'Y' ? 'selected' : '' } >공개</option> 
					<option value="N" ${searchVO.rlsYn == 'N' ? 'selected' : '' }>비공개</option> 
				</select>
			</c:if>
			
			<c:if test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd || enumFrsSpf == searchVO.pbancrcCtgryFrstCd || enumFrsEmp == searchVO.pbancrcCtgryFrstCd }">
				<label for="bizSeCd" class="MAL20">사업</label>
				<select id="bizSeCd" name="bizSeCd" class="st_select">
					<option value="">전체</option>
					<c:forEach var="code" items="${bizSeCdList }" varStatus="codeStatus">searchVO
						<option value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == searchVO.bizSeCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
					</c:forEach>
				</select>
			</c:if>
			
			<label for="pbancrcSttsCd" class="MAL20">모집상태</label>
			<select name="pbancrcSttsCd" id="pbancrcSttsCd" class="st_select">
				<option value="">전체</option>
				<c:forEach var="code" items="${pbancrcSttsCdList }" varStatus="pbancrcSttsCodeStatus">
					<c:if test="${code.indivCd != enumPbaUnsCd }">
						<option value="<c:out value="${code.indivCd }" />" <c:out value="${searchVO.pbancrcSttsCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		
		<div class="ig_l">
			<label for="searchKeyword" class="comment">검색어 입력</label>
			<input type="text" id="searchKeyword" name="searchKeyword" class="st_input input_long" value="<c:out value="${searchVO.searchKeyword }" />" placeholder="제목 또는 내용으로 검색" />
			<input type="hidden" name="searchCondition" value="0" />
		</div>
		
		<div class="ig_s">
			<button type="submit" class="btn-input-search">조회</button>
		</div>
	</div>
</form>

<div class="con_b_tp">
	<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
	<%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %>
</div>

<c:set var="isBizSeCdShow" value="${searchVO.pbancrcCtgryFrstCd == enumFrsAdt || searchVO.pbancrcCtgryFrstCd == enumFrsSpf || searchVO.pbancrcCtgryFrstCd == enumFrsEmp }" />

<table class="table_style thd_v_m">
	<colgroup>
		<col width="5%" />
		<col width="7%" />
		<c:if test="${isBizSeCdShow == true }">
			<col width="12%" />
		</c:if>
		<col width="*" />
		<col width="13%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>No.</th>
			<th>공개<br/>여부</th>
			<c:if test="${isBizSeCdShow == true }">
				<th>사업구분</th>
			</c:if>
			<th>제목</th>
			<th>모집기간</th>
			<th>모집상태</th>
			<th>신청건수</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<fmt:formatDate var="regDt" value="${result.regDt}" pattern="${dateFormat }" />
			<fmt:formatDate var="pbancrcBgngDt" value="${result.pbancrcBgngDt}" pattern="${dateFormat }" />
			<fmt:formatDate var="pbancrcEndDt" value="${result.pbancrcEndDt}" pattern="${dateFormat }" />
			
			<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
			<tr>
				<td><fmt:formatNumber value="${no}" /></td>
				<td><c:out value="${result.rlsYn == 'Y' ? '공개' : result.rlsYn == 'N' ? '비공개' : ''}" /></td>
					<c:if test="${isBizSeCdShow == true }">
						<td><c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd)}" /></td>
					</c:if>
				<td class="AlignLeft"><a href="#" onclick="javascript:fnView('<c:out value="${result.pbancrcSn}" />');return false;"><c:out value="${result.pbancrcNm}" /></a></td>
				<td>
					<c:choose>
						<c:when test="${result.pbancrcSttsCd == enumPbaUnsCd}">접수전</c:when>
						<c:when test="${result.pbancrcSttsCd == enumPbaAlwCd}">상시모집</c:when>
						<c:otherwise><c:out value="${pbancrcBgngDt}" /><br /> ~ <c:out value="${pbancrcEndDt}" /></c:otherwise>
					</c:choose>
				</td>
				<td class="td_bg">
					<c:if test="${enumPbaReqCd != result.pbancrcSttsCd && enumPbaAlwCd != result.pbancrcSttsCd }">
						<c:out value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd) }" />
					</c:if>
					<c:if test="${enumPbaReqCd == result.pbancrcSttsCd || enumPbaAlwCd == result.pbancrcSttsCd }">
						<a class="btn_st btn_c_gr" href="#" onclick="fnSprtWrite('<c:out value="${result.pbancrcSn }" />');return false;" >신청하기</a>
					</c:if>
				</td>
				<td>
					<c:set var="sprtCnt" value="0" />
					<c:forEach var="sprt" items="${sprtCntList }">
						<c:if test="${result.pbancrcSn == sprt.pbancrcSn }"><c:set var="sprtCnt" value="${sprt.sprtCnt }" /></c:if>
					</c:forEach>
					<fmt:formatNumber value="${sprtCnt}" />
				</td>
				<td><c:out value="${regDt }" /></td>
			</tr>
		</c:forEach>
		<c:if test="${resultCnt < 1 }">
			<tr>
				<td colspan="8">데이터가 존재하지 않습니다.</td>
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

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
