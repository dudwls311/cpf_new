<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/eml/emlPrcWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kepMode" value="view" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kepMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />

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
				회수 : <input type="text" class="st_input i_w95 number_nocomma_style" id="sprtNmtm" name="sprtNmtm" value="<c:out value="${result.sprtNmtm}" />" />
				지원금액 : <input type="text" class="st_input i_w95 number_nocomma_style" id="sprtAmt" name="sprtAmt" value="<c:out value="${result.sprtAmt}" />" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">지자체<br />긴급지원수급여부</th>
			<td>
				<input type="radio" name="emrgSprtSpdmYn" value="Y" id="emrgSprtSpdmYnY"${'Y' == result.emrgSprtSpdmYn?' checked="checked"':'' } class="st_radio">
				<label for="emrgSprtSpdmYnY">유</label>
				/ 사유 : <input type="text" class="st_input" id="emrgSprtSpdmRsn" name="emrgSprtSpdmRsn" value="<c:out value="${result.emrgSprtSpdmRsn}" />" />
				<br />
				<input type="radio" name="emrgSprtSpdmYn" value="N" id="emrgSprtSpdmYnN"${'N' == result.emrgSprtSpdmYn?' checked="checked"':'' } class="st_radio">
				<label for="emrgSprtSpdmYnN">무</label>
				/ 사유 : <input type="text" class="st_input" id="emrgSprtSpdmNRsn" name="emrgSprtSpdmNRsn" value="<c:out value="${result.emrgSprtSpdmNRsn}" />" />
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
				<input type="text" class="st_input i_w95 number_nocomma_style" id="cycl" name="cycl" value="<c:out value="${result.cycl}" />" /> 차
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
				<input type="text" class="st_input i_w95 number_nocomma_style" id="aplyAmt" name="aplyAmt" value="<c:out value="${result.aplyAmt}" />" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">신청주요내용</th>
			<td>
				<input type="text" class="st_input input_long" id="aplyMainCn" name="aplyMainCn" value="<c:out value="${result.aplyMainCn}" />" />
			</td>
		</tr>
		<tr>
			<th scope="row">주요위기사유</th>
			<td>
				<input type="text" class="st_input input_long" id="mainCrssRsn" name="mainCrssRsn" value="<c:out value="${result.mainCrssRsn}" />" />
			</td>
		</tr>
		<tr>
			<th scope="row">장애여부</th>
			<td>
				<input type="radio" name="dsbltyYn" value="Y" id="dsbltyYnY"${'Y' == result.dsbltyYn?' checked="checked"':'' } class="st_radio">
				<label for="dsbltyYnY">유</label>
				<input type="radio" name="dsbltyYn" value="N" id="dsbltyYnN"${'N' == result.dsbltyYn?' checked="checked"':'' } class="st_radio">
				<label for="dsbltyYnN">무</label>
			</td>
		</tr>
		<tr>
			<th scope="row">소득</th>
			<td>
			<c:forEach var="cd" items="${earnCdList }" varStatus="status">
				<input type="radio" name="earnCd" value="<c:out value="${cd.indivCd }" />" id="earnCd${status.index }"${cd.indivCd == result.earnCd?' checked="checked"':'' } class="st_radio">
				<label for="earnCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">가구원수</th>
			<td>
			<c:forEach var="cd" items="${mbohhCntCdList }" varStatus="status">
				<input type="radio" name="mbohhCntCd" value="<c:out value="${cd.indivCd }" />" id="mbohhCntCd${status.index }"${cd.indivCd == result.mbohhCntCd?' checked="checked"':'' } class="st_radio">
				<label for="mbohhCntCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">주거형태</th>
			<td>
			<c:forEach var="cd" items="${dwngShapeCdList }" varStatus="status">
				<input type="radio" name="dwngShapeCd" value="<c:out value="${cd.indivCd }" />" id="dwngShapeCd${status.index }"${cd.indivCd == result.dwngShapeCd?' checked="checked"':'' } class="st_radio">
				<label for="dwngShapeCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">공과금체납</th>
			<td>
			<c:forEach var="cd" items="${utblNpmntCdList }" varStatus="status">
				<input type="radio" name="utblNpmntCd" value="<c:out value="${cd.indivCd }" />" id="utblNpmntCd${status.index }"${cd.indivCd == result.utblNpmntCd?' checked="checked"':'' } class="st_radio">
				<label for="utblNpmntCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">위기</th>
			<td>
			<div style="display: none;">
			<c:forEach var="cd" items="${crssCdList }" varStatus="status">
				<input type="radio" name="crssCd" value="<c:out value="${cd.indivCd }" />" id="crssCd${status.index }"${cd.indivCd == result.crssCd?' checked="checked"':'' } class="st_radio">
				<label for="crssCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</div>
			총 점수 : <input type="text" class="st_input i_w95 number_nocomma_style" id="totScr" name="totScr" value="<c:out value="${result.totScr}" />" maxlength="3" />
			<span id="totScrSpan" class="txt_c_bl br"></span>
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
				<input type="text" class="st_input i_w95 date_style" id="giveYmd" name="giveYmd" value="<c:out value="${jtag:convertDateSplitString(result.giveYmd,'-')}" />" />
			</td>
		</tr>
		<tr>
			<th scope="row">지급금액</th>
			<td>
				<input type="text" class="st_input i_w95 number_nocomma_style" id="giveAmt" name="giveAmt" value="<c:out value="${result.giveAmt}" />" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">비고</th>
			<td>
				<textarea class="st_textarea" name="rmrk" id="rmrk"><c:out value="${result.rmrk}" /></textarea>
			</td>
		</tr>
	</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
