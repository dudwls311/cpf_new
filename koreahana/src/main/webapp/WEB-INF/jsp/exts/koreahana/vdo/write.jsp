<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_IDT.getCode()" var="enumNtkIdt" /> <%//북한이탈주민(본인) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_PRT.getCode()" var="enumNtkPrt" /> <%//북한이탈주민(보호자) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_IDT.getCode()" var="enumNorIdt" /> <%//본인(북한이탈주민 자녀) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_PRT.getCode()" var="enumNorPrt" /> <%//보호자 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/vdo/vdoWrite.js"></script>

<c:set var="rcoblYnY" value="기초생활수급권자" />
<c:set var="rcoblYnN" value="해당없음" />

<c:set var="modeName" value="kvMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<%//기초생활수급자인증서파일 다운로드폼 %>
<form id="rcoblSgntFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="rcoblSgntFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
</form>

<%//북한이탈주민인증서파일 다운로드폼 %>
<form id="ntkrdfAcrtfctFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="ntkrdfAcrtfctFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
</form>

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kvMode" value="writeActionJson" />
	<input type="hidden" name="aplcntType" value="<c:out value="${empty result ? param.aplcntType : result.aplcntType }" />" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${empty result.sprtSn ? sprVO.sprtSn : result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />
	<input type="hidden" id="bizSeCd" value="<c:out value="${pbaVO.bizSeCd }" />" />
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<c:choose>
		<c:when test="${result.aplcntType == enumNtkIdt || param.aplcntType == enumNtkIdt }">
			<input type="hidden" id="vdoType" value="${enumNtkIdt }" />
			<%//북한이탈주민(본인) %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/vdo/include/vdoNtkIdtForm.jsp" %>
		</c:when>
		<c:when test="${result.aplcntType == enumNtkPrt || param.aplcntType == enumNtkPrt }">
			<input type="hidden" id="vdoType" value="${enumNtkPrt }" />
			<%//북한이탈주민(보호자) %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/vdo/include/vdoNtkPrtForm.jsp" %>
		</c:when>
		<c:when test="${result.aplcntType == enumNorIdt || param.aplcntType == enumNorIdt }">
			<input type="hidden" id="vdoType" value="${enumNorIdt }" />
			<%//본인(북한이탈주민 자녀) %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/vdo/include/vdoNorIdtForm.jsp" %>
		</c:when>
		<c:when test="${result.aplcntType == enumNorPrt || param.aplcntType == enumNorPrt }">
			<input type="hidden" id="vdoType" value="${enumNorPrt }" />
			<%//보호자 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/vdo/include/vdoNorPrtForm.jsp" %>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<c:set var="agreeType" value="vdo" />
	<c:set var="sgnType" value="vdo" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%//개인정보동의폼 %> 
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
			
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_write_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<%//개인정보동의폼 %> 
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeUserForm.jsp" %>
			
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_write_bottom.jsp" %>		
		</c:otherwise>
	</c:choose>
</form>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>