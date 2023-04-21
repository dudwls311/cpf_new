<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvView.js"></script>

<c:set var="modeName" value="keMode" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewForm.jsp" %>

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
				<th><label class="MAL0" for="emv">신청일</label></th>
				<td colspan="3"><fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</tbody>
	</table>
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewAllDownForm.jsp" %>
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
	
	<c:if test="${isCenterStaff == false }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprSttsForm.jsp" %>
	</c:if>
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_view_bottom.jsp" %>
