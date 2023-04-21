<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoView.js"></script>

<c:set var="modeName" value="ksMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserViewForm.jsp" %>
	</c:otherwise>
</c:choose>

<%//북한이탈주민인증서파일 다운로드폼 %>
<form id="ntkrdfAcrtfctFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="ntkrdfAcrtfctFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
</form>

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
			<c:if test="${empty result.ntkrdfUnqNo }">
				<tr>
			      <th>북한이탈주민 정보 <span class="imp_st">*</span></th>
			      <td colspan="3">
			      	<input type="radio" id="ntkrdfOptrCd1" name="ntkrdfOptrCd" value="부" class="st_radio" <c:out value="${result.ntkrdfOptrCd == '부' ? 'checked' : '' }" /> disabled="disabled" /> <label for="ntkrdfOptrCd1">부</label>
			      	<input type="radio" id="ntkrdfOptrCd2" name="ntkrdfOptrCd" value="모" class="st_radio" <c:out value="${result.ntkrdfOptrCd == '모' ? 'checked' : '' }" /> disabled="disabled" /> <label for="ntkrdfOptrCd2">모</label>
			      	
			      	(하나원기수 : <c:out value="${result.ntkrdfHanawonTh }" />
			      	입국년도 : <c:out value="${result.ntkrdfOptrEntryYr }" />)
			      </td>
			    </tr>
			    <tr>
			      <th>북한이탈주민등록확인서 <span class="imp_st">*</span></th>
			      <td colspan="3">
			      	<c:set var="fileVar" value="ntkrdfAcrtfctFileSn" />
			      	<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
			      	<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
			      	<c:set var="downloadFnValue" value="" />
			      	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileViewForm.jsp" %>
				 </td>
			    </tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">장학금 선발 유형(대상)</h4>
	<table class="table_style table_t_left">
	  <colgroup>
	    <col width="15%" />
	    <col width="*" />
	  </colgroup>
	  <tbody>
	    <tr>
	      <th>신청일</th>
	      <td>
	      	<fmt:formatDate value="${result.regDt}" pattern="${dateFormat }" />
	      </td>
	    </tr>
	    <tr>
	      <th>유형</th>
	      <td>
	      	<c:choose>
				<c:when test="${result.sholSlctnType == 'ntkrdf1' || result.sholSlctnType == 'thirdcnty1'}"><c:set var="sholSlctnName" value="대학원생 " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf2_1' || result.sholSlctnType == 'thirdcnty2_1'}"><c:set var="sholSlctnName" value="대학생(연속지원) " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf2_2' || result.sholSlctnType == 'thirdcnty2_2'}"><c:set var="sholSlctnName" value="대학생(1회지원) " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf2_3' || result.sholSlctnType == 'thirdcnty2_3'}"><c:set var="sholSlctnName" value="대학생(전문대) " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf2_4' || result.sholSlctnType == 'thirdcnty2_4'}"><c:set var="sholSlctnName" value="대학생(사이버/방송/통신대) " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf3' || result.sholSlctnType == 'thirdcnty3'}"><c:set var="sholSlctnName" value="계절학기 수강생 " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf4_1' || result.sholSlctnType == 'thirdcnty4_1'}"><c:set var="sholSlctnName" value="중학생 " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf4_2' || result.sholSlctnType == 'thirdcnty4_2'}"><c:set var="sholSlctnName" value="고등학생 " /></c:when>
				<c:when test="${result.sholSlctnType == 'ntkrdf5' || result.sholSlctnType == 'thirdcnty5'}"><c:set var="sholSlctnName" value="검정고시 합격생 " /></c:when>
			</c:choose>
			<c:out value="${sholSlctnName }" />
	      </td>
	    </tr>
	  </tbody>
	</table>
	
	<c:set var="sgnType" value="sho" />
	<c:set var="smbsnDocTypeVl" value="${result.sholSlctnType }" />
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