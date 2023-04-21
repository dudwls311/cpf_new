<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/emp/empView.js"></script>

<c:set var="empmSttsYnY" value="재직 중" />
<c:set var="empmSttsYnN" value="구직 중" />

<c:set var="hgvlcYnY" value="있음" />
<c:set var="hgvlcYnN" value="없음" />

<c:set var="busDrvngCrtfctYnY" value="있음" />
<c:set var="busDrvngCrtfctYnN" value="없음" />

<c:set var="modeName" value="keMode" />

<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserViewForm.jsp" %>
	</c:otherwise>
</c:choose>

<input type="hidden" id="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<c:set var="hideRequire" value="Y" />
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
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
	
	<h4 class="tit">신청자 인적사항</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th>최종학력 </th>
				<td colspan="3">
					학교명 : <c:out value="${result.lastAcbgSchlNm}" />&nbsp;&nbsp;&nbsp;<c:out value="${jtag:getCdNm(empmSttsCdList, result.lastAcbgSchlGrdtnCd) }" />
					<br />
					전공명 : <c:out value="${result.lastAcbgMjrNm}" />
				</td>
			</tr>
			<tr>
				<th>취업상태 </th>
				<td colspan="3">
					<c:out value="${result.empmSttsYn == 'Y' ? empmSttsYnY : empmSttsYnN }" />
					<c:if test="${result.empmSttsYn == 'Y' }">/&nbsp;직장명 :<c:out value="${result.empmWrcNm}" /></c:if>
				</td>
			</tr>
			<c:if test="${enumBizBus == pbaVO.bizSeCd || enumBizBus == result.bizSeCd }">
				<tr>
					<th>1종 대형면허 </th>
					<td><c:out value="${result.hgvlcYn == 'Y' ? hgvlcYnY : hgvlcYnN }" /></td>
					<th>버스운전자격증 </th>
					<td>
						<c:out value="${result.busDrvngCrtfctYn == 'Y' ? busDrvngCrtfctYnY : busDrvngCrtfctYnN }" />
					</td>
				</tr>
				<tr>
					<th>희망 운수업체 </th>
					<td colspan="3"><c:out value="${result.hopeTrpttBzenty}" /></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">자격사항</h4>
	<table class="table_style">
		<colgroup>
			<col width="40%" />
			<col width="20%" />
			<col width="40%" />
		</colgroup>
		<thead>
			<tr>
				<th>자격증명</th>
				<th>취득일</th>
				<th>취득처</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="empQlf" items="${empQlfList }">
				<tr>
					<td><c:out value="${empQlf.crtfctNm }" /></td>
					<td><c:out value="${jtag:convertDateSplitString(empQlf.acqsYmd, '-') }" /></td>
					<td><c:out value="${empQlf.acqsPlc }" /></td>
				</tr>
			</c:forEach>
			<c:if test="${fn:length(empQlfList) < 1 }">
				<tr>
					<td colspan="3">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">지원동기</h4>
    <div class="box_w_gray PAL15 PAR15">
    	<c:out value="${fn:replace(result.rsnaplc, lf, '<br />')}" escapeXml="false" />
    </div>
	
	<c:set var="agreeType" value="emp" />
	<c:set var="sgnType" value="emp" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewAllDownForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeUserForm.jsp" %>		<%//개인정보동의폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprSttsForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_view_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<h4 class="tit">제출 서류</h4>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_view_bottom.jsp" %>
		</c:otherwise>
	</c:choose>
