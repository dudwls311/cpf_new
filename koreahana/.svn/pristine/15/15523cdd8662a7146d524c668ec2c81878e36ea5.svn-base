<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprList.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<form id="pageForm" action="?">
	<input type="hidden" name="ksMode" value="" />
	<input type="hidden" name="pbancrcCtgryFrstCd" value="" />
	<input type="hidden" name="sprtSn" value="" />
	<input type="hidden" name="pbancrcSn" value="" />
</form>

<h4 class="tit">지원사업 신청이력</h4>

<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
</div>

<table class="table_style thd_v_m">
  <colgroup>
    <col width="5%" />
    <col width="*" />
    <col width="17%" />
    <col width="15%" />
    <col width="8%" />
  </colgroup>
  <thead>
    <tr>
      <th>No.</th>
      <th>제목</th>
      <th>마지막 저장시간</th>
      <th>상태</th>
      <th>수정/조회</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="result" items="${resultList}" varStatus="status">
		<fmt:formatDate var="mdfcnDt" value="${result.mdfcnDt}" pattern="yyyy-MM-dd HH:mm:ss" />
		<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
		
		<c:set var="modeName" value="" />
		<c:set var="pageUrl" value="" />
		<c:choose>
			<c:when test="${enumFrsAdt == result.pbancrcCtgryFrstCd }">
				<c:set var="pageUrl" value="${adtUrl }" />
				<c:set var="modeName" value="kaMode" />
			</c:when>
		</c:choose>
		
		<c:set var="spanClass" value="" />
		<c:choose>
			<c:when test="${enumSprSelCd == result.sprtSttsCd }"><c:set var="spanClass" value="txt_c_bl" /></c:when>
			<c:when test="${enumSprUndCd == result.sprtSttsCd }"><c:set var="spanClass" value="txt_c_re" /></c:when>
		</c:choose>
		
		<tr>
			<td><c:out value="${no }" /></td>
			<td class="AlignLeft"><c:out value="${result.pbancrcNm }" /></td>
			<td><c:out value="${mdfcnDt}" /></td>
			<td class="td_bg">
			
				<c:choose>
					<c:when test="${( result.pbancrcSttsCd != enumPbaAlwCd && result.pbancrcSttsCd != enumPbaReqCd ) && result.sprtSttsCd == enumSprTmpCd }">
						모집완료(신청불가)
					</c:when>
					<c:otherwise>
						<span class="<c:out value="${spanClass }" />"><b><c:out value="${jtag:getCdNm(sprtSttsCdList,result.sprtSttsCd) }" /></b></span>
						<c:choose>
							<c:when test="${enumFrsSpf == result.pbancrcCtgryFrstCd && enumSprSelCd == result.sprtSttsCd && enumBizQlf == result.bizSeCd}">
								<a href="#none" class="btn_st btn_c_bl" onclick="fnTstIdtfPrint(<c:out value="'${result.sprtSn }'" />);return false;">수험표인쇄</a>
							</c:when>
							<c:when test="${enumSprUndCd == result.sprtSttsCd }"><a href="#none" class="btn_st btn_c_re" onclick="fnRsnShow(<c:out value="'${result.sprtSn }'" />);return false;">사유확인</a></c:when>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${result.sprtSttsCd == enumSprUndCd || ( result.pbancrcSttsCd == enumPbaAlwCd || result.pbancrcSttsCd == enumPbaReqCd ) && result.sprtSttsCd == enumSprTmpCd }">
						<a href="#" class="btn_st btn_c_wh" onclick="fnWrite(<c:out value="'${result.pbancrcCtgryFrstCd }','${result.pbancrcSn }','${result.sprtSn }'" />);return false;">수정</a>
					</c:when>
					<c:otherwise>
						<a href="#" class="btn_st btn_c_wh" onclick="fnView(<c:out value="'${result.pbancrcCtgryFrstCd }','${result.pbancrcSn }','${result.sprtSn }'" />);return false;">조회</a>
					</c:otherwise>
				</c:choose>
			</td>
	    </tr>
	</c:forEach>
	<c:if test="${fn:length(resultList) < 1}">
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

<div id="rsnShowForm" style="display: none;">
	<div class="box_w_gray">@rsn@</div>
</div>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>