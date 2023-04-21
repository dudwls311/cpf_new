<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/edu/eduView.js"></script>

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
	
	<h4 class="tit">신청자 기본 정보</h4>
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
	
	<h4 class="tit">교육지원금 신청 내용</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th>신청일</th>
				<td colspan="3"><fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<th>학교명</th>
				<td colspan="3"><c:out value="${result.shclNm }" /></td>
			</tr>
			<tr>
				<th>소재지</th>
				<td colspan="3"><c:out value="(${result.schlZip }) ${result.schlAddr } ${result.schlDaddr }" />
				</td>
			</tr>
			<tr>
				<th>대표자 성명</th>
				<td><c:out value="${result.rprsvFlnm }" /></td>
				<th>취학자</th>
				<td><fmt:formatNumber value="${result.schlacCnt }" />명</td>
			</tr>
			<tr>
				<th>보조사업비 소요경비</th>
				<td colspan="3">
					소요경비 총액:<fmt:formatNumber value="${result.asstBizTotAmt }" />원
					| 지급받으려는 보조액:<fmt:formatNumber value="${result.asstBizAsstAmt }" />원
					| 자기자본의 부담액:<fmt:formatNumber value="${result.asstBizBrdmAmt }" />원
				</td>
			</tr>
			<tr>
				<th>보조금 입금계좌</th>
				<td colspan="3">
					은행명&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${jtag:getCdNm(bankCdList, result.bacntBankCd)}" />
					|&nbsp;&nbsp;계좌번호&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.actno }" />
					|&nbsp;&nbsp;예금주&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.dpstr }" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<c:set var="sgnType" value="edu" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewAllDownForm.jsp" %>
			
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			
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