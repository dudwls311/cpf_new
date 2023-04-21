<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/edu/eduWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="modeName" value="keMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="keMode" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${empty result.sprtSn ? sprVO.sprtSn : result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />
	<input type="hidden" id="bizSeCd" value="<c:out value="${pbaVO.bizSeCd }" />" />
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<h4 class="tit">신청자 기본 정보</h4>
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
				<th>학교명 <b class="imp_st">*</b></th>
				<td colspan="3">
					<input type="text" class="st_input" style="width: 40%;" id="shclNm" name="shclNm" value="<c:out value="${result.shclNm }" />" />
					&nbsp;&nbsp;<span class="txt_c_bl">캠퍼스명 기입 필수</span>
				</td>
			</tr>
			<tr>
				<th>소재지 <b class="imp_st">*</b></th>
				<td colspan="3">
					<c:set var="schlZip" value="${result.schlZip }" />
					<c:set var="schlAddr" value="${result.schlAddr }" />
					<c:set var="schlDaddr" value="${result.schlDaddr }" />
				
					<input type="text" name="schlZip" id="schlZip" value="<c:out value="${schlZip}" />" class="st_input " placeholder="">
					<a class="btn_st btn_c_bk" href="#" onclick="fnSchlAddr();return false;">주소 검색</a>
					<input type="text" name="schlAddr" id="schlAddr" value="<c:out value="${schlAddr}" />" class="st_input input_long  MAB5  MAT5">
					<input type="text" name="schlDaddr" id="schlDaddr" value="<c:out value="${schlDaddr}" />" class="st_input input_long ">
				</td>
			</tr>
			<tr>
				<th>대표자 성명 <b class="imp_st">*</b></th>
				<td><input type="text" class="st_input" id="rprsvFlnm" name="rprsvFlnm" value="<c:out value="${result.rprsvFlnm }" />" /></td>
				<th>취학자</th>
				<td><input type="text" class="st_input number_style" id="schlacCnt" name="schlacCnt" value="<c:out value="${result.schlacCnt }" />" />명</td>
			</tr>
			<tr>
				<th>보조사업비 소요경비 <b class="imp_st">*</b></th>
				<td colspan="3">
					<label for="asstBizTotAmt">소요경비 총액:</label><input type="text" class="st_input number_style" style="width:130px;" id="asstBizTotAmt" name="asstBizTotAmt" value="<c:out value="${result.asstBizTotAmt }" />" />원
					| <label for="asstBizAsstAmt">지급받으려는 보조액:</label><input type="text" class="st_input number_style" style="width:130px;" id="asstBizAsstAmt" name="asstBizAsstAmt" value="<c:out value="${result.asstBizAsstAmt }" />" />원
					| <label for="asstBizBrdmAmt">자기자본의 부담액:</label><input type="text" class="st_input number_style" style="width:130px;" id="asstBizBrdmAmt" name="asstBizBrdmAmt" value="<c:out value="${result.asstBizBrdmAmt }" />" />원
				</td>
			</tr>
			<tr>
				<th>보조금 입금계좌 <b class="imp_st">*</b></th>
				<td colspan="3">
					<label for="bacntBankCd">은행명:</label>
					<select id="bacntBankCd" name="bacntBankCd" class="st_select">
						<option value="">선택</option>
						<c:forEach var="code" items="${bankCdList }">
							<option value="<c:out value="${code.indivCd }" />" <c:out value="${result.bacntBankCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
						</c:forEach>
					</select>
					| <label for="actno">계좌번호:</label><input type="text" class="st_input" id="actno" name="actno" value="<c:out value="${result.actno }" />" />
					| <label for="dpstr">예금주:</label><input type="text" class="st_input" id="dpstr" name="dpstr" value="<c:out value="${result.dpstr }" />" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<%//개인정보동의폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
	
	<c:set var="sgnType" value="edu" />
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

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>