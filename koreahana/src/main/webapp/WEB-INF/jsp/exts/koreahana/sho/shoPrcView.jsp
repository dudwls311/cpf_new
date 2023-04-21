<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoPrcView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
	<input type="hidden" name="slctnMthdCd" value="<c:out value="${searchVO.slctnMthdCd }" />" />
	<input type="hidden" name="slctnMmtCd" value="<c:out value="${searchVO.slctnMmtCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kspMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
	<input type="hidden" name="slctnMthdCd" value="<c:out value="${searchVO.slctnMthdCd }" />" />
	<input type="hidden" name="slctnMmtCd" value="<c:out value="${searchVO.slctnMmtCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>

	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoViewForm.jsp" %>
		</tbody>
	</table>
					
					<h4 class="tit">장학금 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">신청일</th>
								<td>
									<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
							<tr>
								<th scope="row">유형</th>
								<td>
								<c:choose>
									<c:when test="${result.sholSlctnType == 'ntkrdf1' || result.sholSlctnType == 'thirdcnty1'}"><c:set var="sholSlctnName" value="대학원생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_1' || result.sholSlctnType == 'thirdcnty2_1'}"><c:set var="sholSlctnName" value="대학생(연속지원)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_2' || result.sholSlctnType == 'thirdcnty2_2'}"><c:set var="sholSlctnName" value="대학생(1회지원)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_3' || result.sholSlctnType == 'thirdcnty2_3'}"><c:set var="sholSlctnName" value="대학생(전문대	)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_4' || result.sholSlctnType == 'thirdcnty2_4'}"><c:set var="sholSlctnName" value="대학생(사이버/방송/통신대)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf3' || result.sholSlctnType == 'thirdcnty3'}"><c:set var="sholSlctnName" value="계절학기 수강생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf4_1' || result.sholSlctnType == 'thirdcnty4_1'}"><c:set var="sholSlctnName" value="중학생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf4_2' || result.sholSlctnType == 'thirdcnty4_2'}"><c:set var="sholSlctnName" value="고등학생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf5' || result.sholSlctnType == 'thirdcnty5'}"><c:set var="sholSlctnName" value="검정고시 합격생" /></c:when>
								</c:choose>
								<c:out value="${sholSlctnName }" />
								</td>
							</tr>
							<tr>
								<th scope="row">선발방법</th>
								<td>
									<c:out value="${jtag:getCdNm(slctnMthdCdList,result.slctnMthdCd)}" />
								</td>
							</tr>
							<tr>
								<th scope="row">선발시기</th>
								<td>
									<c:out value="${jtag:getCdNm(slctnMmtCdList,result.slctnMmtCd)}" />
								</td>
							</tr>
					</table>
					
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">재원</th>
								<td>
									<c:out value="${jtag:getCdNm(fncrscCdList,result.fncrscCd)}" />
								</td>
							</tr>
							<tr>
								<th scope="row">지급일</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.giveYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row">장학금 지급금액</th>
								<td>
									<fmt:formatNumber value="${result.sholGiveAmt}" /> 원
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									${jtag:dbToHtml(result.rmrk)}
								</td>
							</tr>
					</table>
					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
