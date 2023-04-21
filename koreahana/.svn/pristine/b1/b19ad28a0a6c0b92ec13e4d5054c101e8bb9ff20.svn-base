<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/eml/emlWrite.js"></script>
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
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoForm.jsp" %>
			<tr>
				<th>북한이탈주민정보 <span class="imp_st">*</span></th>
				<td colspan="3">
					<label class="MAL0" for="entcnyYmd">입국연월일 : </label>
					<input type="text" name="entcnyYmd" id="entcnyYmd" value="<c:out value="${result.entcnyYmd }" />" class="st_input i_w95 date_style" /> 년 수료 ( 
					<label class="MAL20" for="hanawonFnshYr">하나원 : </label>
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
				<th><label class="MAL0" for="eml">이메일</label> <span class="imp_st">*</span></th>
				<td colspan="3"><input type="text" name="eml" id="eml" value="<c:out value="${result.eml }" />" class="st_input input_long"/></td>
			</tr>
			<tr>
				<th><label class="MAL0" for="A12">계좌번호</label> <span class="imp_st">*</span></th>
				<td colspan="3">
					<select id="bacntBankCd" name="bacntBankCd" class="st_select">
						<option value="">선택</option>
						<c:forEach var="code" items="${bankCdList }">
							<option value="<c:out value="${code.indivCd }" />" <c:out value="${result.bacntBankCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
						</c:forEach>
					</select>
					
					<label class="MAL20" for="actno">계좌번호 : </label>
					<input type="text" name="actno" id="actno" value="<c:out value="${result.actno }" />" class="st_input " />
					<label class="MAL20" for="dpstr">예금주 : </label>
					<input type="text" name="dpstr" id="dpstr" value="<c:out value="${result.dpstr }" />" class="st_input "/>
					<br />
					<label class="MAL0" for="actnoRmrk">비고 : </label>
					<input type="text" name="actnoRmrk" id="actnoRmrk" value="<c:out value="${result.actnoRmrk }" />" class="st_input MAT5" style="width: 76%;" />
					
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="eml">발굴방법</label> <span class="imp_st">*</span></th>
				<td colspan="3">
					<c:forEach var="code" items="${excvMthdCdList }" varStatus="codeStatus">
						<c:if test="${codeStatus.last }"><br /></c:if>
						<input type="radio" class="st_radio" id="<c:out value="excvMthdCd${codeStatus.count }" />" name="excvMthdCd" value="<c:out value="${code.indivCd }" />" onchange="fnExcvMthdCdChg();" <c:out value="${result.excvMthdCd == code.indivCd ? 'checked' : '' }" /> />
						<label for="<c:out value="excvMthdCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
					</c:forEach>
					<input type="text" name="excvMthdEtc" id="excvMthdEtc" value="<c:out value="${result.excvMthdEtc }" />" class="st_input MAT10" style="width: 83%;" />
				</td>
			</tr>
			<tr>
				<th><label class="MAL0" for="frstCnslYmd">최초 상담일</label> <span class="imp_st">*</span></th>
				<td colspan="3"><input type="text" name="frstCnslYmd" id="frstCnslYmd" value="<c:out value="${result.frstCnslYmd }" />" class="st_input i_w95 date_style" maxlength="10"/></td>
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