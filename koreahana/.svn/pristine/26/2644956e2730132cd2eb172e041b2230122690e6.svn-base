<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/adt/adtView.js"></script>

<c:set var="modeName" value="kaMode" />
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
	
	<c:if test="${enumBizThr == result.bizSeCd }"><%//제3국출생양육 %>
		<h4 class="tit">가족관계</h4>
		<table class="table_style">
			<colgroup>
				<col width="50%" />
				<col width="50%" />
			</colgroup>
			<thead>
				<tr>
					<th>신청자와의 관계</th>
					<th>가족 성명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fam" items="${famList }">
					<tr>
						<td><c:out value="${jtag:getCdNm(aplcntRelCdList,fam.aplcntRelCd) }" /></td>
						<td><c:out value="${fam.famFlnm }" /></td>
					</tr>
				</c:forEach>
				<c:if test="${fn:length(famList) < 1 }">
					<tr>
						<td colspan="2">데이터가 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</c:if>
	
	<h4 class="tit">가산금 선택 및 지급 사유</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>가산금  종류</th>
				<td><c:out value="${jtag:getCdNm(bizSeCdList, result.bizSeCd)}" /></td>
			</tr>
			<tr>
				<th>지급사유</th>
				<td>
					<c:out value="${fn:replace(result.adtnAmtGiveRsn, lf, '<br />')}" escapeXml="false" />
				</td>
			</tr>
		</tbody>
	</table>
	
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
