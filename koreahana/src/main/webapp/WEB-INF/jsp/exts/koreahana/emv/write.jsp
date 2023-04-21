<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="modeName" value="keMode" />
<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />

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
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoForm.jsp" %>
			<tr>
				<th>북한이탈주민정보 <span class="imp_st">*</span></th>
				<td colspan="3">
					<label for="hanawonFnshYr">하나원 : </label>
					<input type="text" name="hanawonFnshYr" id="hanawonFnshYr" value="<c:out value="${result.hanawonFnshYr }" />" class="st_input i_w95 number_nocomma_style" maxlength="4" /> 년 수료 ( 
					<input type="text" name="hnwTh" id="hnwTh" value="<c:out value="${result.hnwTh }" />" class="st_input i_w95 number_nocomma_style" maxlength="10" /> 기 )
				</td>
			</tr>
			<tr>
				<th>하나센터 상담정보 <span class="imp_st">*</span></th>
				<td colspan="3">
					<label class="MAL0" for="dscsnYmd">상담일 : </label>
					<input type="text" name="dscsnYmd" id="dscsnYmd" value="<c:out value="${result.dscsnYmd }" />" class="st_input i_w95 date_style" />
					<label class="MAL20" for="cnslFlnm">상담사 : </label>
					<input type="text" name="cnslFlnm" id="cnslFlnm" value="<c:out value="${result.cnslFlnm }" />" class="st_input i_w95"/>
					
					<c:if test="${isFoundStaff || isAdmin }">
						<label class="MAL20" for="hanactCd">하나센터</label>
						<select id="hanactCd" name="hanactCd" class="st_select st_select2">
							<option value="">선택</option>
							<c:forEach var="hanact" items="${hanactList }">
								<option value="<c:out value="${hanact.orgId }" />" <c:out value="${result.hanactCd == hanact.orgId ? 'selected' : '' }" /> ><c:out value="${hanact.orgNm }" /></option>
							</c:forEach>
						</select>
					</c:if>
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="emv">이메일</label> <span class="imp_st">*</span></th>
				<td colspan="3"><input type="text" name="eml" id="eml" value="<c:out value="${result.eml }" />" class="st_input input_long"/></td>
			</tr>
		</tbody>
	</table>
	
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<%//개인정보동의폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
			
	<%//버튼폼 %>
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_write_bottom.jsp" %>
</form>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>