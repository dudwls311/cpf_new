<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>
<script type="text/javascript" src="/resources/js/exts/koreahana/pba/pbaView.js"></script>

<c:choose>
	<c:when test="${enumFrsEml == result.pbancrcCtgryFrstCd }">
		<c:set var="actUrl" value="/exts/koreahana/eml/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:when test="${enumFrsEmv == result.pbancrcCtgryFrstCd }">
		<c:set var="actUrl" value="/exts/koreahana/emv/index.do" />
		<c:set var="modeName" value="keMode" />
	</c:when>
	<c:otherwise>
		<c:set var="actUrl" value="" />
		<c:set var="modeName" value="" />
	</c:otherwise>
</c:choose>

<c:if test="${enumFrsEml == result.pbancrcCtgryFrstCd || enumFrsEmv == result.pbancrcCtgryFrstCd }">
	<form id="requestForm" action="<c:url value="${actUrl }" />">
		<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
		<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
		<input type="hidden" name="rlsYn" value="<c:out value="${param.rlsYn }" />" />
		<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${param.pbancrcSttsCd }" />" />
		<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
		<input type="hidden" name="<c:out value="${modeName }" />" value="write" />
		<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
	</form>
</c:if>

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="rlsYn" value="<c:out value="${param.rlsYn }" />" />
	<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${param.pbancrcSttsCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
	<input type="hidden" name="kpMode" value="write" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="rlsYn" value="<c:out value="${param.rlsYn }" />" />
	<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${param.pbancrcSttsCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>
<form id="sprtWritePageForm" action="?">
	<input type="hidden" id="mode" name="" value="" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<form id="downloadForm" action="?">
	<input type="hidden" name="kpMode" value="fileDownload" />
	<input type="hidden" name="atchFileSn" value="" />
	<input type="hidden" name="pbancrcSn" value="" />
</form>

<div class="board_view">
	<div class="board_v_t">
		<p class="title">
			<c:if test="${enumFrsAdt == result.pbancrcCtgryFrstCd || enumFrsEmp == result.pbancrcCtgryFrstCd || enumFrsSpf == result.pbancrcCtgryFrstCd || enumFrsEmp == result.pbancrcCtgryFrstCd }">
				<span class="categori"><c:out value="${jtag:getCdNm(bizSeCdList, result.bizSeCd) }" /></span>
			</c:if>
			<c:out value="${result.pbancrcNm}" />
		</p>
		<p class="board_v_s_info">
			<b>모집기간</b>
			<span>
				<fmt:formatDate var="pbancrcBgngDt" value="${result.pbancrcBgngDt}" pattern="${dateFormat }" />
				<fmt:formatDate var="pbancrcEndDt" value="${result.pbancrcEndDt}" pattern="${dateFormat }" />
				<c:choose>
					<c:when test="${result.pbancrcSttsCd == enumPbaUnsCd}">접수전</c:when>
					<c:when test="${result.pbancrcSttsCd == enumPbaAlwCd}">상시모집</c:when>
					<c:otherwise><c:out value="${pbancrcBgngDt}" /> ~ <c:out value="${pbancrcEndDt}" /></c:otherwise>
				</c:choose>	
			</span>
			<span class="bar"></span>
			<fmt:formatDate var="regDt" value="${result.regDt}" pattern="${dateFormat }" />
			<b>등록일</b><span><c:out value="${regDt }" /></span>
			<span class="bar"></span>
			<b>조회수</b><span><fmt:formatNumber value="${result.inqCnt}" /></span>
		</p>
		<div class="board_v_rcsitu">
			<c:choose>
				<c:when test="${enumPbaUnsCd == result.pbancrcSttsCd }">
					<c:set var="pbaStatusClass" value="b_situ_01" />
					<c:set var="pbaStatusName" value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd)}" />
				</c:when>
				<c:when test="${enumPbaBefCd == result.pbancrcSttsCd }">
					<c:set var="pbaStatusClass" value="b_situ_02" />
					<c:set var="pbaStatusName" value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd)}" />
				</c:when>
				<c:when test="${enumPbaComCd == result.pbancrcSttsCd }">
					<c:set var="pbaStatusClass" value="b_situ_03" />
					<c:set var="pbaStatusName" value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd)}" />
				</c:when>
				<c:when test="${enumPbaReqCd == result.pbancrcSttsCd || enumPbaAlwCd == result.pbancrcSttsCd }">
					<c:set var="pbaStatusClass" value="b_situ_04" />
					<c:set var="pbaStatusName" value="모집중" />
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			
			<div class="<c:out value="${pbaStatusClass }" />"><c:out value="${pbaStatusName }" /></div>
		</div>
	</div>
	<div class="board_v_con">
		<div class="contents"><c:out value="${result.pbancrcCn}" escapeXml="false" /></div>
	</div>
	<c:if test="${fn:length(pbaFileList) > 0 }">
		<div class="board_v_file">
			<c:forEach var="pbaFileResult" items="${pbaFileList }" varStatus="fileStatus">
				<p class="file"><a href="#" onclick="fnDownload(<c:out value="'${pbaFileResult.atchFileSn }','${result.pbancrcSn }'" />)"><c:out value="${pbaFileResult.orgnlAtchFileNm }" /></a></p>
			</c:forEach>
		</div>
	</c:if>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>