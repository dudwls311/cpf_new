<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvPrcView.js"></script>

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
					학교명 : <c:out value="${result.schlNm}" />
					전공명 : <c:out value="${result.mjrNm}" />
					학년 : <c:out value="${result.schlyr}" />
				</td>
			</tr>
			<tr>
				<th scope="row">소속</th>
				<td colspan="3">
					<c:out value="${result.ogdp}" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<h4 class="tit">신청 정보
		<span class="FloatRight">
			<a href="#" onclick="fnViewCard();return false;" class="btn_st" id="cardBtn" style="">카드정보 보기</a>
		</span>
	</h4>
	
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
			<th scope="row">재단 지원 현황</th>
			<td>
				<c:out value="${jtag:getCdNm(aplcntQlfcCdList, result.aplcntQlfcCd) }" />
			</td>
		</tr>
		<tr>
			<th scope="row">우리카드 기존 사용여부</th>
			<td colspan="3">
				${empty result.existCdUseYn?'':('Y' == result.existCdUseYn?'사용함':'사용하지 않음') }
			</td>
		</tr>
		<tr>
			<th scope="row">카드번호 </th>
			<td colspan="3">
			<c:if test="${!empty result.frstCardNo }">
				<span id="frstCardNoSpan"><c:out value="${fn:substring(result.frstCardNo,0,4)}-****-****-${fn:substring(result.frstCardNo,15,19)}" /></span>
			</c:if>
			<c:if test="${!empty result.scndryCardNo }">
				<span id="scndryCardNoSpan">&nbsp;|&nbsp;<c:out value="${fn:substring(result.scndryCardNo,0,4)}-****-****-${fn:substring(result.scndryCardNo,15,19)}" /></span>
			</c:if>
			<c:if test="${!empty result.thirdCardNo }">
				<span id="thirdCardNoSpan">&nbsp;|&nbsp;<c:out value="${fn:substring(result.thirdCardNo,0,4)}-****-****-${fn:substring(result.thirdCardNo,15,19)}" /></span>
			</c:if>
			</td>
		</tr>
		<tr>
			<th scope="row">사전승인</th>
			<td colspan="3">
				<c:out value="${jtag:convertDateSplitString(result.bfrhdAprvYmd,'-')}" />
			</td>
		</tr>
		<tr>
			<th scope="row">신청금액</th>
			<td colspan="3">
				<fmt:formatNumber value="${result.aplyAmt}" /> 원
			</td>
		</tr>
		<tr>
			<th scope="row">패널티</th>
			<td colspan="3">
				${result.pntyYn == 'Y'?'패널티':'' }
			</td>
		</tr>
		<tr>
			<th scope="row">비고</th>
			<td colspan="3">
				${jtag:dbToHtml(result.rmrk)}
			</td>
		</tr>
		<tr>
			<th scope="row">하나센터메모</th>
			<td colspan="3">
				${jtag:dbToHtml(result.hanactMemo)}
			</td>
		</tr>
	</table>
	
	<h4 class="tit">수강 정보</h4>
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
			<c:forEach var="emvPrcTkc" items="${emvPrcTkcList }" varStatus="emvPrcTkcStatus">
				<tr data-sort="<c:out value="${emvPrcTkcStatus.count }" />">
					<td>
						<c:out value="${jtag:getCdNm(sbjctCdList,emvPrcTkc.sbjctCd) }" />&nbsp;&nbsp;<c:out value="${emvPrcTkc.sbjctNm }" />
					</td>
					<td>
						<c:out value="${jtag:getCdNm(ednstCdList,emvPrcTkc.ednstCd) }" />&nbsp;&nbsp;<c:out value="${emvPrcTkc.ednstNm }" />
					</td>
					<td>
						<c:out value="${emvPrcTkc.tkclsPeriod }" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h4 class="tit">지원금 현황</h4>
	<table class="table_style thd_v_m">
		<thead>
			<tr>
				<th>신청금액</th>
				<th>사용금액</th>
				<th>잔액</th>
				<th>사용율</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><fmt:formatNumber value="${result.aplyAmt }" /></td>
				<td><fmt:formatNumber value="${result.useAmt }" /></td>
				<td><fmt:formatNumber value="${result.aplyAmt - result.useAmt}" /></td>
				<td><c:out value="${jtag:percent(result.aplyAmt, result.useAmt, '')}" />%</td>
			</tr>
		</tbody>
	</table>
	
	
	<h4 class="tit">카드 사용 정보
		<span class="FloatRight">
			<a href="#" onclick="fnViewCard('cardUseList');return false;" class="btn_st" id="cardUseBtn" style="">카드정보 보기</a>
		</span>
	</h4>
	<table class="table_style thd_v_m">
		<thead>
			<tr>
				<th scope="col">카드번호</th>
				<th scope="col">승인연월일</th>
				<th scope="col">승인번호</th>
				<th scope="col">가맹점명</th>
				<th scope="col">승인금액</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="aprvAmtTotal" value="0" />
		<c:forEach var="cardUse" items="${cardUseList}" varStatus="status">
		<c:set var="aprvAmtTotal" value="${aprvAmtTotal + cardUse.aprvAmt }" />
			<fmt:formatDate var="regDt" value="${cardUse.regDt}" pattern="yyyy-MM-dd" />
			<tr>
				<td id="<c:out value="cardNo${status.count }" />"><c:out value="${fn:substring(cardUse.cardNo,0,4)}-****-****-${fn:substring(cardUse.cardNo,15,19)}" /></td>
				<td><c:out value="${jtag:convertDateSplitString(cardUse.aprvYmd,'-')}" /></td>
				<td><c:out value="${cardUse.aprvNo}" /></td>
				<td><c:out value="${cardUse.frcsNm}" /></td>
				<td><fmt:formatNumber value="${cardUse.aprvAmt}" /></td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="4">총 승인금액</th>
				<td><fmt:formatNumber value="${aprvAmtTotal}" /></td>
			</tr>
		</tfoot>
	</table>
	
<div id="popup_cardInfoDiv" style="display:none">
	<div class="box_w_gray AlignCenter"><br />
	  숨겨진 카드정보를 조회하기 위해서<br /> 
로그인한 계정의 비밀번호를 입력해주세요.<br />
	  <div class="btn_reload">
	    <input type="password" id="@cardPasswd"/>
	  </div>
	  <br /><br />
	</div>
</div>
					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
