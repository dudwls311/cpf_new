<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvPrcWrite.js"></script>

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
			<c:set var="sprtType" value="emv" />
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoViewForm.jsp" %>
			<tr>
				<th>북한이탈주민정보</th>
				<td colspan="3">
					하나원 : <c:out value="${result.hanawonFnshYr }" />년 수료 (<c:out value="${result.hnwTh }" />기 )
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
				<th><label class="MAL0" for="emv">이메일</label></th>
				<td colspan="3"><c:out value="${result.eml }" /></td>
			</tr>
			<tr>
				<th scope="row">최종학력</th>
				<td colspan="3">
					학교명 : <input type="text" class="st_input" id="schlNm" name="schlNm" value="<c:out value="${result.schlNm}" />" />
					전공명 : <input type="text" class="st_input" id="mjrNm" name="mjrNm" value="<c:out value="${result.mjrNm}" />" />
					학년 : <input type="text" class="st_input" id="schlyr" name="schlyr" value="<c:out value="${result.schlyr}" />" />
				</td>
			</tr>
			<tr>
				<th scope="row">소속</th>
				<td colspan="3">
					<input type="text" class="st_input input_long" id="ogdp" name="ogdp" value="<c:out value="${result.ogdp}" />" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<h4 class="tit">신청 정보</h4>
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col style="width:140px;" />
			<col />
			<col style="width:140px;" />
			<col />
		</colgroup>
		<tr>
			<th scope="row">신청일</th>
			<td>
				<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
			<th scope="row">신청자격</th>
			<td>
			<c:forEach var="cd" items="${aplcntQlfcCdList }" varStatus="status">
				<input type="radio" name="aplcntQlfcCd" value="<c:out value="${cd.indivCd }" />" id="aplcntQlfcCd${status.index }"${cd.indivCd == result.aplcntQlfcCd?' checked="checked"':'' } class="st_radio">
				<label for="aplcntQlfcCd${status.index }"><c:out value="${cd.indivCdNm }" /></label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th scope="row">우리카드 기존 사용여부</th>
			<td colspan="3">
				<input type="radio" name="existCdUseYn" value="Y" id="existCdUseYnY"${'Y' == result.existCdUseYn?' checked="checked"':'' } class="st_radio">
				<label for="existCdUseYnY">사용함</label>
				<input type="radio" name="existCdUseYn" value="N" id="existCdUseYnN"${'N' == result.existCdUseYn?' checked="checked"':'' } class="st_radio">
				<label for="existCdUseYnN">사용하지 않음</label>
			</td>
		</tr>
		<tr>
			<th scope="row">카드번호 </th>
			<td colspan="3">
				<p class="p_info">카드를 재발급 한 경우 재발급한 카드 정보를 추가로 입력해주세요</p>
				<input type="text" class="st_input" id="frstCardNo" name="frstCardNo" value="<c:out value="${result.frstCardNo}" />" />
				<input type="text" class="st_input" id="scndryCardNo" name="scndryCardNo" value="<c:out value="${result.scndryCardNo}" />" />
				<input type="text" class="st_input" id="thirdCardNo" name="thirdCardNo" value="<c:out value="${result.thirdCardNo}" />" />
			</td>
		</tr>
		<tr>
			<th scope="row">사전승인</th>
			<td colspan="3">
				<input type="text" class="st_input i_w95 date_style" id="bfrhdAprvYmd" name="bfrhdAprvYmd" value="<c:out value="${jtag:convertDateSplitString(result.bfrhdAprvYmd,'-')}" />" />
			</td>
		</tr>
		<tr>
			<th scope="row">신청금액</th>
			<td colspan="3">
				<input type="text" class="st_input i_w95 number_nocomma_style" id="aplyAmt" name="aplyAmt" value="<c:out value="${result.aplyAmt}" />" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">패널티</th>
			<td colspan="3">
				<input type="checkbox" id=pntyYn name="pntyYn" value="Y" class="st_check"${result.pntyYn == 'Y'?' checked':'' }>
				<label for="pntyYn">패널티</label>
			</td>
		</tr>
		<tr>
			<th scope="row">비고</th>
			<td colspan="3">
				<textarea class="st_textarea" name="rmrk" id="rmrk"><c:out value="${result.rmrk}" /></textarea>
			</td>
		</tr>
		<tr>
			<th scope="row">하나센터메모</th>
			<td colspan="3">
				<textarea class="st_textarea" name="hanactMemo" id="hanactMemo"><c:out value="${result.hanactMemo}" /></textarea>
			</td>
		</tr>
	</table>
	
	<h4 class="tit">수강 정보</h4>
	<!-- <p class="AlignRight  MAB10">
		<a href="#" class="btn_st btn_ico_pl MAR10" onclick="fnEmvPrcTkcAdd();return false;">추가</a>
		<a href="#" class="btn_st btn_ico_pl" onclick="fnEmvPrcTkcDel();return false;">제거</a>
	</p> -->
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col style="width:33%;" />
			<col style="width:33%;" />
			<col style="width:*" />
		</colgroup>
		<thead>
			<tr>
				<th>신청과목</th>
				<th>교육기관</th>
				<th>수강기간</th>
			</tr>
		</thead>
		<tbody id="emvPrcTkcBody">
			<%-- <c:forEach var="emvPrcTkc" items="${emvPrcTkcList }" varStatus="emvPrcTkcStatus"> --%>
			<c:forEach begin="1" end="3" step="1" var="emvPrcTkcCount">
				<c:set var="emvPrcTkc" value="${emvPrcTkcList[-1] }" />
				<c:forEach var="emvPrcTkcResult" items="${emvPrcTkcList }" varStatus="emvPrcTkcStatus">
					<c:if test="${emvPrcTkcStatus.count == emvPrcTkcCount }"><c:set var="emvPrcTkc" value="${emvPrcTkcList[emvPrcTkcCount-1] }" /></c:if>
				</c:forEach>
				<tr data-sort="<c:out value="${emvPrcTkcCount }" />">
					<td>
						<input type="hidden" name="emvPrcTkcPrefix" value="<c:out value="${emvPrcTkcCount }" />" />
						<select id="<c:out value="sbjctCd${emvPrcTkcCount }" />" name="<c:out value="sbjctCd${emvPrcTkcCount }" />" class="st_select">
							<option value="">선택</option>
							<c:forEach var="code" items="${sbjctCdList }">
								<option value="<c:out value="${code.indivCd }" />" <c:out value="${emvPrcTkc.sbjctCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
							</c:forEach>
						</select>
						<input type="text" class="st_input" id="<c:out value="sbjctNm${emvPrcTkcCount }" />" name="<c:out value="sbjctNm${emvPrcTkcCount }" />" value="<c:out value="${emvPrcTkc.sbjctNm }" />" />
					</td>
					<td>
						<select id="<c:out value="ednstCd${emvPrcTkcCount }" />" name="<c:out value="ednstCd${emvPrcTkcCount }" />" class="st_select">
							<option value="">선택</option>
							<c:forEach var="code" items="${ednstCdList }">
								<option value="<c:out value="${code.indivCd }" />" <c:out value="${emvPrcTkc.ednstCd == code.indivCd ? 'selected' : '' }" />><c:out value="${code.indivCdNm }" /></option>
							</c:forEach>
						</select>
						<input type="text" class="st_input" id="<c:out value="ednstNm${emvPrcTkcCount }" />" name="<c:out value="ednstNm${emvPrcTkcCount }" />" value="<c:out value="${emvPrcTkc.ednstNm }" />" />
					</td>
					<td>
						<input type="text" class="st_input input_long" id="<c:out value="tkclsPeriod${emvPrcTkcCount }" />" name="<c:out value="tkclsPeriod${emvPrcTkcCount }" />" value="<c:out value="${emvPrcTkc.tkclsPeriod }" />" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>

<table id="emvPrcTkcForm" style="display: none;">
	<tr data-sort="@nextSort@">
		<td>
			<input type="hidden" name="emvPrcTkcPrefix" value="@nextSort@" />
			<select id="sbjctCd@nextSort@" name="sbjctCd@nextSort@" class="st_select">
				<option value="">선택</option>
				<c:forEach var="code" items="${sbjctCdList }">
					<option value="<c:out value="${code.indivCd }" />"><c:out value="${code.indivCdNm }" /></option>
				</c:forEach>
			</select>
			<input type="text" class="st_input" id="sbjctNm@nextSort@" name="sbjctNm@nextSort@" value="" />
		</td>
		<td>
			<select id="ednstCd@nextSort@" name="ednstCd@nextSort@" class="st_select">
				<option value="">선택</option>
				<c:forEach var="code" items="${ednstCdList }">
					<option value="<c:out value="${code.indivCd }" />"><c:out value="${code.indivCdNm }" /></option>
				</c:forEach>
			</select>
			<input type="text" class="st_input" id="ednstNm@nextSort@" name="ednstNm@nextSort@" value="" />
		</td>
		<td>
			<input type="text" class="st_input input_long" id="tkclsPeriod@nextSort@" name="tkclsPeriod@nextSort@" value="" />
		</td>
	</tr>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
