<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/eml/emlPrcView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kepMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
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
			<tr>
				<th>북한이탈주민정보</th>
				<td colspan="3">
					입국연월일 : <c:out value="${jtag:convertDateSplitString(result.entcnyYmd, '-') }" /> 
					&nbsp;&nbsp;하나원 : <c:out value="${result.hanawonFnshYr }" />년 수료 (<c:out value="${result.hnwTh }" />기 )
				</td>
			</tr>
			<tr>
				<th>하나센터 상담정보</th>
				<td colspan="3">
					<c:forEach var="hanact" items="${hanactList }">
						<c:if test="${result.hanactCd == hanact.orgId }"><c:set var="hanactNm" value="${hanact.orgNm }" /></c:if>
					</c:forEach>
					상담일 : <c:out value="${jtag:convertDateSplitString(result.dscsnYmd, '-') }" />
					&nbsp;&nbsp;상담사 : <c:out value="${hanactNm } ${result.cnslFlnm }" />
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="eml">이메일</label></th>
				<td colspan="3"><c:out value="${result.eml }" /></td>
			</tr>
			<tr>
				<th><label class="MAL0" for="A12">계좌번호</label></th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(bankCdList, result.bacntBankCd) }" />
					&nbsp;&nbsp;계좌번호 : <c:out value="${result.actno }" />
					&nbsp;&nbsp;예금주 : <c:out value="${result.dpstr }" />
					<br />기타 : <c:out value="${result.actnoRmrk }" />
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="eml">발굴방법</label></th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(excvMthdCdList, result.excvMthdCd) }" />&nbsp;<c:if test="${not empty result.excvMthdEtc }"><c:out value="(${result.excvMthdEtc })" /></c:if>
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="frstCnslYmd">최초 상담일</label></th>
				<td colspan="3">
					<fmt:parseDate var="frstCnslYmdPrase" value="${result.frstCnslYmd }" pattern="yyyyMMdd" />
					<fmt:formatDate value="${frstCnslYmdPrase }" pattern="yyyy년 MM월 dd일" />
					<%-- <c:out value="${jtag:convertDateSplitString(result.frstCnslYmd, '-') }" /> --%>
				</td>
			</tr>
		</tbody>
	</table>
	
	<h4 class="tit">기지원 정보</h4>
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col style="width:140px;" />
			<col />
		</colgroup>
		<tr>
			<th scope="row">재단 지원 현황</th>
			<td>
				회수 : <fmt:formatNumber value="${result.sprtNmtm}" />
				지원금액 : <fmt:formatNumber value="${result.sprtAmt}" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">지자체<br />긴급지원수급여부</th>
			<td>
				${empty result.emrgSprtSpdmYn?'':('Y' == result.emrgSprtSpdmYn?'유':'무') }
				<c:if test="${'Y' == result.emrgSprtSpdmYn }">
					/ 사유 : <c:out value="${result.emrgSprtSpdmRsn}" />
				</c:if>
				<c:if test="${'N' == result.emrgSprtSpdmYn }">
					/ 사유 : <c:out value="${result.emrgSprtSpdmNRsn}" />
				</c:if>
			</td>
		</tr>
	</table>
	
	<h4 class="tit">신청 정보</h4>
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col style="width:140px;" />
			<col />
		</colgroup>
		<tr>
			<th scope="row">재단 지원 현황</th>
			<td>
				<c:out value="${result.cycl}" /> 차
			</td>
		</tr>
		<tr>
			<th scope="row">신청일</th>
			<td>
				<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
		</tr>
		<tr>
			<th scope="row">신청금액</th>
			<td>
				<fmt:formatNumber value="${result.aplyAmt}" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">신청주요내용</th>
			<td>
				<c:out value="${result.aplyMainCn}" />
			</td>
		</tr>
		<tr>
			<th scope="row">주요위기사유</th>
			<td>
				<c:out value="${result.mainCrssRsn}" />
			</td>
		</tr>
		<tr>
			<th scope="row">장애여부</th>
			<td>
				${empty result.dsbltyYn?'':('Y' == result.dsbltyYn?'유':'무')}
			</td>
		</tr>
		<tr>
			<th scope="row">소득</th>
			<td>
				<c:out value="${jtag:getCdNm(earnCdList, result.earnCd) }" />
			</td>
		</tr>
		<tr>
			<th scope="row">가구원수</th>
			<td>
				<c:out value="${jtag:getCdNm(mbohhCntCdList, result.mbohhCntCd) }" />
			</td>
		</tr>
		<tr>
			<th scope="row">주거형태</th>
			<td>
				<c:out value="${jtag:getCdNm(dwngShapeCdList, result.dwngShapeCd) }" />
			</td>
		</tr>
		<tr>
			<th scope="row">공과금체납</th>
			<td>
				<c:out value="${jtag:getCdNm(utblNpmntCdList, result.utblNpmntCd) }" />
			</td>
		</tr>
		<tr>
			<th scope="row">위기</th>
			<td>
				<c:out value="${jtag:getCdNm(crssCdList, result.crssCd) }" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;총 점수 : <c:out value="${result.totScr}" />
			</td>
		</tr>
	</table>
	
	
	<h4 class="tit">지원 정보</h4>
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col style="width:140px;" />
			<col />
		</colgroup>
		<tr>
			<th scope="row">지급일</th>
			<td>
				<c:out value="${jtag:convertDateSplitString(result.giveYmd,'-')}" />
			</td>
		</tr>
		<tr>
			<th scope="row">지급금액</th>
			<td>
				<fmt:formatNumber value="${result.giveAmt}" />
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
