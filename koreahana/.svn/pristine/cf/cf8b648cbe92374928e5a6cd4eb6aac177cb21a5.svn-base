<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/emp/empWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="empmSttsYnY" value="재직 중" />
<c:set var="empmSttsYnN" value="구직 중" />

<c:set var="hgvlcYnY" value="있음" />
<c:set var="hgvlcYnN" value="없음" />

<c:set var="busDrvngCrtfctYnY" value="있음" />
<c:set var="busDrvngCrtfctYnN" value="없음" />


<c:set var="modeName" value="keMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<input type="hidden" id="empQlfListJson" value="<c:out value="${empQlfListJson }" />" />
<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />

	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
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
				<th>최종학력 <b class="imp_st">*</b></th>
				<td colspan="3">
					<label for="lastAcbgSchlNm">학교명 :</label><input type="text" name="lastAcbgSchlNm" id="lastAcbgSchlNm" value="<c:out value="${result.lastAcbgSchlNm}" />" class="st_input MAR10" />
					<c:forEach var="code" items="${empmSttsCdList }" varStatus="codeStatus">
						<input type="radio" name="lastAcbgSchlGrdtnCd" id="<c:out value="lastAcbgSchlGrdtnCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.lastAcbgSchlGrdtnCd ? 'checked' : '' }" /> class="st_radio"/>
						<label for="<c:out value="lastAcbgSchlGrdtnCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
					</c:forEach>
					<br />
					<label for="lastAcbgMjrNm">전공명 :</label><input type="text" name="lastAcbgMjrNm" id="lastAcbgMjrNm" value="<c:out value="${result.lastAcbgMjrNm}" />" class="st_input MAT5" />
				</td>
			</tr>
			<tr>
				<th>취업상태 <b class="imp_st">*</b></th>
				<td colspan="3">
					<input type="radio" name="empmSttsYn" id="<c:out value="empmSttsYnY" />" value="Y" <c:out value="${'Y' == result.empmSttsYn ? 'checked' : '' }" /> class="st_radio"/>
					<label for="<c:out value="empmSttsYnY" />"><c:out value="${empmSttsYnY }" /></label>
					
					<span id="empmWrcNmSpan">
						<label for="empmWrcNm">/&nbsp;직장명 :</label><input type="text" name="empmWrcNm" id="empmWrcNm" value="<c:out value="${result.empmWrcNm}" />" class="st_input MAR10" />
					</span>
					
					<input type="radio" name="empmSttsYn" id="<c:out value="empmSttsYnN" />" value="N" <c:out value="${'N' == result.empmSttsYn ? 'checked' : '' }" /> class="st_radio"/>
					<label for="<c:out value="empmSttsYnN" />"><c:out value="${empmSttsYnN }" /></label>
				</td>
			</tr>
			<c:if test="${enumBizBus == pbaVO.bizSeCd || enumBizBus == result.bizSeCd }">
				<tr>
					<th>1종 대형면허 <b class="imp_st">*</b></th>
					<td>
						<input type="radio" name="hgvlcYn" id="<c:out value="hgvlcYnY" />" value="Y" <c:out value="${'Y' == result.hgvlcYn ? 'checked' : '' }" /> class="st_radio"/>
						<label for="<c:out value="hgvlcYnY" />"><c:out value="${hgvlcYnY }" /></label>
						
						<input type="radio" name="hgvlcYn" id="<c:out value="hgvlcYnN" />" value="N" <c:out value="${'N' == result.hgvlcYn ? 'checked' : '' }" /> class="st_radio"/>
						<label for="<c:out value="hgvlcYnN" />"><c:out value="${hgvlcYnN }" /></label>	
					</td>
					<th>버스운전자격증 <b class="imp_st">*</b></th>
					<td>
						<input type="radio" name="busDrvngCrtfctYn" id="<c:out value="busDrvngCrtfctYnY" />" value="Y" <c:out value="${'Y' == result.busDrvngCrtfctYn ? 'checked' : '' }" /> class="st_radio"/>
						<label for="<c:out value="busDrvngCrtfctYnY" />"><c:out value="${busDrvngCrtfctYnY }" /></label>
						
						<input type="radio" name="busDrvngCrtfctYn" id="<c:out value="busDrvngCrtfctYnN" />" value="N" <c:out value="${'N' == result.busDrvngCrtfctYn ? 'checked' : '' }" /> class="st_radio"/>
						<label for="<c:out value="busDrvngCrtfctYnN" />"><c:out value="${busDrvngCrtfctYnN }" /></label>
					</td>
				</tr>
				<tr>
					<th>희망 운수업체 <b class="imp_st">*</b></th>
					<td colspan="3">
						<input type="text" name="hopeTrpttBzenty" id="hopeTrpttBzenty" value="<c:out value="${result.hopeTrpttBzenty}" />" class="st_input input_long" />
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">자격사항</h4>
	<p class="AlignRight  MAB10">
		<a href="#" class="btn_st btn_ico_pl MAR10" onclick="fnEmpQlfFormAdd();return false;">추가</a>
		<a href="#" class="btn_st btn_ico_mn" onclick="fnEmpQlfFormDel();return false;">삭제</a>
	</p>
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
		<tbody id="empQlfTbody">
		
		</tbody>
	</table>
	
	<h4 class="tit">지원동기</h4>
    <div class="box_w_gray PAL15 PAR15">
        <textarea class="st_textarea" id="rsnaplc" name="rsnaplc"><c:out value="${result.rsnaplc }" /></textarea>
    </div>
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<c:set var="agreeType" value="emp" />
	<c:set var="sgnType" value="emp" />
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

<%//자격사항폼 %>
<table id="empQlfForm" style="display: none">
	<tr data-sort="@nextSort@">
		<td>
			<input type="hidden" name="empQlfPrefix" value="@nextSort@" />
			<input type="text" name="crtfctNm@nextSort@" id="crtfctNm@nextSort@" value="@crtfctNm@" class="st_input input_long" />
		</td>
		<td><input type="text" name="acqsYmd@nextSort@" id="acqsYmd@nextSort@" value="@acqsYmd@" class="st_input st_input i_w95" /></td>
		<td><input type="text" name="acqsPlc@nextSort@" id="acqsPlc@nextSort@" value="@acqsPlc@" class="st_input input_long" /></td>
	</tr>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>