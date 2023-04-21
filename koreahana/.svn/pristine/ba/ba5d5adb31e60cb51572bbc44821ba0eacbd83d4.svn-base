<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/adt/adtWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="modeName" value="kaMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<input type="hidden" id="famListJson" value="<c:out value="${famListJson }" />" />
<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kaMode" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />

	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<c:if test="${adminPageYn != 'Y' }"><p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p></c:if>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<c:choose>
				<c:when test="${adminPageYn == 'Y' }">
					<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoForm.jsp" %>
				</c:when>
				<c:otherwise>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoUserForm.jsp" %>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	<c:if test="${enumBizThr == pbaVO.bizSeCd }"><%//제3국출생양육 %>
		<h4 class="tit">가족관계
			<p class="FloatRight"><button type="button" class="btn_st btn_ico_pl" onclick="fnFamFormAdd();return false;">추가</button>
			<button type="button" class="btn_st btn_ico_mn" onclick="fnFamFormDel();return false;">삭제</button></p>
		</h4>
		<table class="table_style">
			<colgroup>
				<col width="50%" />
				<col width="50%" />
			</colgroup>
			<thead>
				<tr>
					<th>신청자와의 관계 <b class="imp_st">*</b></th>
					<th>가족 성명 <b class="imp_st">*</b></th>
				</tr>
			</thead>
			<tbody id="famFirstTbody"></tbody>
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
				<td><c:out value="${jtag:getCdNm(bizSeCdList, pbaVO.bizSeCd)}" /></td>
			</tr>
			<tr>
				<th>지급사유 <b class="imp_st">*</b></th>
				<td>
					<textarea class="st_textarea" id="adtnAmtGiveRsn" name="adtnAmtGiveRsn" placeholder="구체적 사유를 입력해주세요."><c:out value="${result.adtnAmtGiveRsn}" escapeXml="false" /></textarea>
				</td>
			</tr>
		</tbody>
	</table>
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<%//개인정보동의폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_write_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_write_bottom.jsp" %>		
		</c:otherwise>
	</c:choose>
</form>

<%//가족관계폼 %>
<table id="adtnAmtFamAppend" style="display: none;">
	<tr id="@famPrefix@" data-sort="@famNextSort@">
		<td>
			<input type="hidden" name="adtnAmtFamId" value="@famPrefix@" />
			<select name="@famPrefix@aplcntRelCd" class="st_select">
				<option value="">선택</option>
				<c:forEach var="famCode" items="${aplcntRelCdList }" varStatus="famStatus">
					<option value="<c:out value="${famCode.indivCd }" />" <c:out value="@${famCode.indivCd }@" /> ><c:out value="${famCode.indivCdNm }" /></option>
				</c:forEach>
			</select>
		</td>
		<td><input type="text" name="@famPrefix@famFlnm" value="@famFlnm@" /></td>
	</tr>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>