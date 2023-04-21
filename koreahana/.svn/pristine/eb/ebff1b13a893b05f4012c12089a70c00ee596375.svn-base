<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).SEL.getCode()" var="enumSprSelCd" />
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).TMP.getCode()" var="enumSprTmpCd" />

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprListSub.js"></script>


			<form action="?" id="searchForm">
		<%@include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListPbaSearchForm.jsp" %>
			</form>

<c:set var="ntkrdfYnList" value="${fn:split('Y,N',',') }"/>
<c:set var="sholSlctnTypeList" value="${fn:split('1,2,2_1,2_2,2_3,2_4,3,4,4_1,4_2,5',',') }"/><%//2,4은 중간합계용(대학생+중고등학생[하위가 존재하는 항목]) %>
			
<div class="con_b_tp">
	<h4 class="tit">장학금 지급현황</h4>
</div>
<table class="table_style th_v_m">
	<colgroup>
		<col width="100px">
		<col width="">
	</colgroup>
	<thead>
		<tr>
			<th>지원자 유형</th>
			<th>장학금 유형</th>
			<th>신청인원</th>
			<th>선정인원</th>
			<th>경쟁률</th>
			<th>지급금액(원)</th>
		</tr>
	</thead>
	<tbody>
<c:set var="sprtCnt_ntkrdfTotal" value="0" />
<c:set var="sprtCnt_thirdcntyTotal" value="0" />
<c:set var="dcsnCnt_ntkrdfTotal" value="0" />
<c:set var="dcsnCnt_thirdcntyTotal" value="0" />
<c:set var="sholGiveAmt_ntkrdfTotal" value="0" />
<c:set var="sholGiveAmt_thirdcntyTotal" value="0" />
<c:forEach items="${ntkrdfYnList }" var="ntkrdfYn">
	<c:forEach items="${sholSlctnTypeList }" var="sholSlctnType" varStatus="status">
		<c:set var="va_sholSlctnType" value="${ntkrdfYn == 'Y'?'ntkrdf':'thirdcnty' }${sholSlctnType }" /><%//변수용처리용 %>
		<c:set var="sprtCnt" value="0" />
		<c:set var="dcsnCnt" value="0" />
		<c:set var="sholGiveAmt" value="0" />
		<c:forEach items="${resultList }" var="result"><c:if test="${result.ntkrdfYn == ntkrdfYn && fn:indexOf(result.sholSlctnType,va_sholSlctnType) >= 0 }">
			<c:choose>
				<c:when test="${result.sprtSttsCd == enumSprSelCd }">
					<c:set var="dcsnCnt" value="${dcsnCnt + result.cnt }" />
					<c:set var="sprtCnt" value="${sprtCnt + result.cnt }" />
					<c:set var="sholGiveAmt" value="${sholGiveAmt + result.sholGiveAmt }" />
				</c:when>
				<c:when test="${result.sprtSttsCd != enumSprSelCd }">
					<c:set var="sprtCnt" value="${sprtCnt + result.cnt }" />
				</c:when>
			</c:choose>
		</c:if></c:forEach>
		<c:if test="${ntkrdfYn == 'Y' && sholSlctnType != '2' && sholSlctnType != '4' }"><%//중간합계제외(대학생+중고등학생[하위가 존재하는 항목]) %>
			<c:set var="sprtCnt_ntkrdfTotal" value="${sprtCnt_ntkrdfTotal + sprtCnt }" />
			<c:set var="dcsnCnt_ntkrdfTotal" value="${dcsnCnt_ntkrdfTotal + dcsnCnt }" />
			<c:set var="sholGiveAmt_ntkrdfTotal" value="${sholGiveAmt_ntkrdfTotal + sholGiveAmt }" />
		</c:if>
		<c:if test="${ntkrdfYn == 'N' && sholSlctnType != '2' && sholSlctnType != '4' }"><%//중간합계제외(대학생+중고등학생[하위가 존재하는 항목]) %>
			<c:set var="sprtCnt_thirdcntyTotal" value="${sprtCnt_thirdcntyTotal + sprtCnt }" />
			<c:set var="dcsnCnt_thirdcntyTotal" value="${dcsnCnt_thirdcntyTotal + dcsnCnt }" />
			<c:set var="sholGiveAmt_thirdcntyTotal" value="${sholGiveAmt_thirdcntyTotal + sholGiveAmt }" />
		</c:if>
		<tr>
		<c:if test="${status.first }"> 
			<th rowspan="${fn:length(sholSlctnTypeList) }">${ntkrdfYn == 'Y'?'북한이탈주민':'제3국 출생'}</th>
		</c:if>
			<td ${fn:length(sholSlctnType) == 1?' class="td_bg"':'' }>
			<c:choose>
				<c:when test="${sholSlctnType == '1' }">대학원생</c:when>
				<c:when test="${sholSlctnType == '2' }">대학생</c:when>
				<c:when test="${sholSlctnType == '2_1' }">&nbsp;&nbsp;&nbsp;일반(연속지원)</c:when>
				<c:when test="${sholSlctnType == '2_2' }">&nbsp;&nbsp;&nbsp;일반(1회지원)</c:when>
				<c:when test="${sholSlctnType == '2_3' }">&nbsp;&nbsp;&nbsp;전문대</c:when>
				<c:when test="${sholSlctnType == '2_4' }">&nbsp;&nbsp;&nbsp;사이버대</c:when>
				<c:when test="${sholSlctnType == '3' }">계절학기</c:when>
				<c:when test="${sholSlctnType == '4' }">중고등학생</c:when>
				<c:when test="${sholSlctnType == '4_1' }">&nbsp;&nbsp;&nbsp;중학생</c:when>
				<c:when test="${sholSlctnType == '4_2' }">&nbsp;&nbsp;&nbsp;고등학생</c:when>
				<c:when test="${sholSlctnType == '5' }">검정고시 합격생</c:when>
			</c:choose>
			</td>
			<td ${fn:length(sholSlctnType) == 1?' class="td_bg"':'' }><fmt:formatNumber value="${sprtCnt }" /></td>
			<td ${fn:length(sholSlctnType) == 1?' class="td_bg"':'' }><fmt:formatNumber value="${dcsnCnt }" /></td>
			<td ${fn:length(sholSlctnType) == 1?' class="td_bg"':'' }><c:out value="${jtag:percent(sprtCnt, dcsnCnt, '') }" />%</td>
			<td class="td_bg"><fmt:formatNumber value="${sholGiveAmt }" /></td>
		</tr>
	</c:forEach>
</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="2">북한이탈주민 총합</th>
			<td ><fmt:formatNumber value="${sprtCnt_ntkrdfTotal }" /></td>
			<td ><fmt:formatNumber value="${dcsnCnt_ntkrdfTotal }" /></td>
			<td ><c:out value="${jtag:percent(sprtCnt_ntkrdfTotal, dcsnCnt_ntkrdfTotal, '') }" />%</td>
			<td ><fmt:formatNumber value="${sholGiveAmt_ntkrdfTotal }" /></td>
		</tr>
		<tr>
			<th colspan="2">제3국 출생 총합</th>
			<td ><fmt:formatNumber value="${sprtCnt_thirdcntyTotal }" /></td>
			<td ><fmt:formatNumber value="${dcsnCnt_thirdcntyTotal }" /></td>
			<td ><c:out value="${jtag:percent(sprtCnt_thirdcntyTotal, dcsnCnt_thirdcntyTotal, '') }" />%</td>
			<td ><fmt:formatNumber value="${sholGiveAmt_thirdcntyTotal }" /></td>
		</tr>
		<tr>
			<th class="td_bg" colspan="2">총합</th>
			<td class="td_bg" ><fmt:formatNumber value="${sprtCnt_ntkrdfTotal + sprtCnt_thirdcntyTotal }" /></td>
			<td class="td_bg" ><fmt:formatNumber value="${dcsnCnt_ntkrdfTotal + dcsnCnt_thirdcntyTotal }" /></td>
			<td class="td_bg" ><c:out value="${jtag:percent(sprtCnt_ntkrdfTotal + sprtCnt_thirdcntyTotal, dcsnCnt_ntkrdfTotal + dcsnCnt_thirdcntyTotal, '') }" />%</td>
			<td class="td_bg" ><fmt:formatNumber value="${sholGiveAmt_ntkrdfTotal + sholGiveAmt_thirdcntyTotal }" /></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
