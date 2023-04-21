<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="modeName" value="ksMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<c:set var="smbTypeName" value="${(not empty result && not empty result.ntkrdfUnqNo) ? 'ntkrdf' : 'thirdcnty' }" />
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<c:set var="smbTypeName" value="${isNtkrdf ? 'ntkrdf' : 'thirdcnty' }" />
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<%//북한이탈주민인증서파일 다운로드폼 %>
<form id="ntkrdfAcrtfctFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="ntkrdfAcrtfctFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
</form>

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ksMode" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${empty result.sprtSn ? sprVO.sprtSn : result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />
	<input type="hidden" id="bizSeCd" value="<c:out value="${pbaVO.bizSeCd }" />" />
	<input type="hidden" id="sholSlctnTypeTmp" value="<c:out value="${result.sholSlctnType }" />" />
	
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
			<c:if test="${isNormal || (isAdmin || isFoundStaff) && empty result.ntkrdfUnqNo }">
				<tr>
			      <th>북한이탈주민 정보 <span class="imp_st">*</span></th>
			      <td colspan="3">
			      	<input type="radio" id="ntkrdfOptrCd1" name="ntkrdfOptrCd" value="부" class="st_radio" <c:out value="${result.ntkrdfOptrCd == '부' ? 'checked' : '' }" /> /> <label for="ntkrdfOptrCd1">부</label>
			      	<input type="radio" id="ntkrdfOptrCd2" name="ntkrdfOptrCd" value="모" class="st_radio" <c:out value="${result.ntkrdfOptrCd == '모' ? 'checked' : '' }" /> /> <label for="ntkrdfOptrCd2">모</label>
			      	
			        <label class="MAL20" for="ntkrdfHanawonTh">(하나원기수 : </label><input type="text" name="ntkrdfHanawonTh" id="ntkrdfHanawonTh" class="st_input i_w95 number_nocomma_style" maxlength="10" value="<c:out value="${result.ntkrdfHanawonTh }" />" />
			        <label class="MAL0" for="ntkrdfOptrEntryYr">입국년도 : </label><input type="text" name="ntkrdfOptrEntryYr" id="ntkrdfOptrEntryYr" class="st_input i_w95 number_nocomma_style" maxlength="4" value="<c:out value="${result.ntkrdfOptrEntryYr }" />" />)
			      </td>
			    </tr>
			    <tr>
			      <th>북한이탈주민등록확인서 <span class="imp_st">*</span></th>
			      <td colspan="3">
			      	<p class="txt_c_bl br">부 또는 모의 북한이탈주민등록확인서를 등록해주세요.</p>
			      	<c:set var="fileVar" value="ntkrdfAcrtfctFileSn" />
			      	<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
			      	<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
			      	<c:set var="downloadFnValue" value="" />
			      	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
				 </td>
			    </tr>
			</c:if>
		</tbody>
	</table>

	<input type="hidden" id="sholSlctnTypeValue" name="sholSlctnTypeValue" value="" />
	<h4 class="tit">장학금 선발 유형(대상) 선택</h4>
	<p class="p_info">본인이 해당하는 장학금 유형을 선택해주세요. 대상별 신청자격에 대한 상세 정보는 공고문을 확인해주세요.</p>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<thead>
			<tr>
				<th>유형</th>
				<th>선택  <b class="imp_st">*</b></th>
			</tr>
		</thead>
		<tbody>
			<c:set var="smbTypeValue1" value="${smbTypeName }1" />		<%//대학원생 %>
		  	<c:forEach var="smbType" items="${smbTypList }">
		  		<c:if test="${smbType.smbsnDocTypeVl == smbTypeValue1 }">
		  			<tr>
						<td>대학원생</td>
						<td>
							<c:set var="smbTypeChecked1" value="${result.sholSlctnType == smbTypeValue1 ? 'checked' : '' }" />
							<input type="radio" id="sholSlctnType1_1" name="sholSlctnType" value="<c:out value="${smbTypeValue1 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue1 }" />')" <c:out value="${smbTypeChecked1 }" />  /> <label for="sholSlctnType1_1">대학원생</label>
						</td>
					</tr>
		  		</c:if>
		  	</c:forEach>
		  	
		  	<c:set var="smbTypeValue2" value="${smbTypeName }2" />
		  	<c:forEach var="smbType" items="${smbTypList }">
		  		<c:if test="${smbType.smbsnDocTypeVl == smbTypeValue2 }">
		  			<tr>
						<td>대학생</td>
						<td>
							<c:set var="smbTypeValue2_1" value="${smbTypeValue2 }_1" />
							<c:set var="smbTypeValue2_2" value="${smbTypeValue2 }_2" />
							<c:set var="smbTypeValue2_3" value="${smbTypeValue2 }_3" />
							<c:set var="smbTypeValue2_4" value="${smbTypeValue2 }_4" />
				      	
							<c:set var="smbTypeChecked2_1" value="${result.sholSlctnType == smbTypeValue2_1 ? 'checked' : '' }" />
							<c:set var="smbTypeChecked2_2" value="${result.sholSlctnType == smbTypeValue2_2 ? 'checked' : '' }" />
							<c:set var="smbTypeChecked2_3" value="${result.sholSlctnType == smbTypeValue2_3 ? 'checked' : '' }" />
							<c:set var="smbTypeChecked2_4" value="${result.sholSlctnType == smbTypeValue2_4 ? 'checked' : '' }" />
				      	
							<input type="radio" id="sholSlctnType2_1" name="sholSlctnType" value="<c:out value="${smbTypeValue2_1 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue2_1 }" />')" <c:out value="${smbTypeChecked2_1 }" /> /> <label for="sholSlctnType2_1">일반대(연속지원)</label>
							<input type="radio" id="sholSlctnType2_2" name="sholSlctnType" value="<c:out value="${smbTypeValue2_2 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue2_2 }" />')" <c:out value="${smbTypeChecked2_2 }" /> /> <label for="sholSlctnType2_2">일반대(1회지원)</label>
							<input type="radio" id="sholSlctnType2_3" name="sholSlctnType" value="<c:out value="${smbTypeValue2_3 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue2_3 }" />')" <c:out value="${smbTypeChecked2_3 }" /> /> <label for="sholSlctnType2_3">전문대</label>
							<input type="radio" id="sholSlctnType2_4" name="sholSlctnType" value="<c:out value="${smbTypeValue2_4 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue2_4 }" />')" <c:out value="${smbTypeChecked2_4 }" /> /> <label for="sholSlctnType2_4">사이버/방송/통신대</label>
				      </td>
				    </tr>
		  		</c:if>
		  	</c:forEach>
		  	
		  	<c:set var="smbTypeValue3" value="${smbTypeName }3" />
		  	<c:forEach var="smbType" items="${smbTypList }">
		  		<c:if test="${smbType.smbsnDocTypeVl == smbTypeValue3 }">
		  			<tr>
		  				<td>계절학기 수강생</td>
		  				<td>
		  					<c:set var="smbTypeChecked3" value="${result.sholSlctnType == smbTypeValue3 ? 'checked' : '' }" />
		  					<input type="radio" id="sholSlctnType3_1" name="sholSlctnType" value="<c:out value="${smbTypeValue3 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue3 }" />')" <c:out value="${smbTypeChecked3 }" /> /> <label for="sholSlctnType3_1">일반대</label>
		  				</td>
		  			</tr>
		  		</c:if>
		  	</c:forEach>
		  	
		  	<c:set var="smbTypeValue4" value="${smbTypeName }4" />
		  	<c:forEach var="smbType" items="${smbTypList }">
		  		<c:if test="${smbType.smbsnDocTypeVl == smbTypeValue4 }">
		  			<tr>
						<td>중고등학생</td>
						<td>
							<c:set var="smbTypeValue4_1" value="${smbTypeValue4 }_1" />
							<c:set var="smbTypeValue4_2" value="${smbTypeValue4 }_2" />
				      	
							<c:set var="smbTypeChecked4_1" value="${result.sholSlctnType == smbTypeValue4_1 ? 'checked' : '' }" />
							<c:set var="smbTypeChecked4_2" value="${result.sholSlctnType == smbTypeValue4_2 ? 'checked' : '' }" />
				      	
							<input type="radio" id="sholSlctnType4_1" name="sholSlctnType" value="<c:out value="${smbTypeValue4_1 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue4_1 }" />')" <c:out value="${smbTypeChecked4_1 }" /> /> <label for="sholSlctnType4_1">중학생</label>
							<input type="radio" id="sholSlctnType4_2" name="sholSlctnType" value="<c:out value="${smbTypeValue4_2 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue4_2 }" />')" <c:out value="${smbTypeChecked4_2 }" /> /> <label for="sholSlctnType4_2">고등학생</label>
						</td>
					</tr>
		  		</c:if>
		  	</c:forEach>
		  	
		  	<c:set var="smbTypeValue5" value="${smbTypeName }5" />
		  	<c:forEach var="smbType" items="${smbTypList }">
		  		<c:if test="${smbType.smbsnDocTypeVl == smbTypeValue5 }">
					<tr>
						<td>검정고시합격자</td>
						<td>
							<c:set var="smbTypeChecked5" value="${result.sholSlctnType == smbTypeValue5 ? 'checked' : '' }" />
							<input type="radio" id="sholSlctnType5_1" name="sholSlctnType" value="<c:out value="${smbTypeValue5 }" />" class="st_radio" onclick="fnSholSlctnType('<c:out value="${smbTypeValue5 }" />')" <c:out value="${smbTypeChecked5 }" /> /> <label for="sholSlctnType5_1">검정고시합격자</label>
						</td>
					</tr>
		  		</c:if>
		  	</c:forEach>
		</tbody>
	</table>
	
	<%//제출서류폼 %>
	<c:set var="smbType" value="sho" /> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<%//개인정보동의폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
	
	<c:set var="sgnType" value="sho" />
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