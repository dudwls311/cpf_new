<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<input type="hidden" id="userType" value="nor" />

<c:set var="count" value="1" />
<c:set var="lnbSprtInfo" value="${lnbSprtInfoList[0] }" />

<h4 class="tit">학습지 지원대상자 기본 정보<span class="imp_st">*</span></h4>
<p class="p_info">보호자가 부모가 아닐 경우(무연고탈북아동 등)에는 아동 1명당 신청서 1부 작성</p>
<table class="table_style table_t_left thd_v_m fileEvent">
	<colgroup>
		<col width="20%" />
		<col width="*%" />
	</colgroup>
	<tbody id="lnbSprtInfoTbody">
		<tr id="<c:out value="lnbSprtInfoTr${count }_2" />">
			<th>성명 <span class="imp_st">*</span></th>
			<td>
				<input type="hidden" name="prefix" value="<c:out value="${count }" />" />
				<input type="hidden" name="<c:out value="rnkg${count }" />" value="<c:out value="${count }" />" />
				<input type="hidden" name="<c:out value="lnbkSprtBscInfoSn${count }" />" value="<c:out value="${lnbSprtInfo.lnbkSprtBscInfoSn }" />" />
				<input type="text" class="st_input" id="<c:out value="lnbPrcFlnm${count }" />" name="lnbPrcFlnm<c:out value="${count }" />" value="<c:out value="${lnbSprtInfo.flnm }" />" />
			</td>
		</tr>
		<tr id="<c:out value="lnbSprtInfoTr${count }_3" />">
			<th>생년월일 <span class="imp_st">*</span></th>
			<td><input type="text" class="date_style st_input" id="<c:out value="lnbPrcBrdtYmd${count }" />" name="lnbPrcBrdtYmd<c:out value="${count }" />" value="<c:out value="${lnbSprtInfo.brdtYmd }" />"  /></td>
		</tr>
		<tr id="<c:out value="lnbSprtInfoTr${count }_4" />">
			<th>출생지 <span class="imp_st">*</span></th>
			<td>
				<c:forEach var="code" items="${brplcCdList }" varStatus="codeStatus">
					<input type="radio" class="st_radio" name="<c:out value="lnbPrcBrplcCd${count }" />" id="<c:out value="lnbPrcBrplcCd${codeStatus.count }${count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == lnbSprtInfo.brplcCd ? 'checked' : '' }" /> data-sort="<c:out value="${count }" />"  />
					<label for="<c:out value="lnbPrcBrplcCd${codeStatus.count }${count }" />"><c:out value="${code.indivCdNm }" /></label>
					<c:if test="${codeStatus.first }">
						<span id="<c:out value="ntkSpan${count }" />">
						<label for="<c:out value="lnbPrcHanawonTh${count }" />">(&nbsp;&nbsp;하나원기수 :</label>
						<input type="text" class="st_input i_w95 number_nocomma_style" maxlength="10" id="<c:out value="lnbPrcHanawonTh${count }" />" name="<c:out value="lnbPrcHanawonTh${count }" />" value="<c:out value="${lnbSprtInfo.hanawonTh }" />" />
						<label for="<c:out value="lnbPrcEntcnyYr${count }" />">입국년도 :</label>
						<input type="text" class="st_input i_w95 number_nocomma_style" maxlength="4" id="<c:out value="lnbPrcEntcnyYr${count }" />" name="<c:out value="lnbPrcEntcnyYr${count }" />"  value="<c:out value="${lnbSprtInfo.entcnyYr }" />" />&nbsp;&nbsp;)
						</span>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr id="<c:out value="ntkInfoTr${count }" />">
			<th>북한이탈주민 정보 <span class="imp_st">*</span></th>
			<td colspan="3">
				<p class="txt_c_bl br">학습지 지원대상자 부 또는 모의 북한이탈주민 정보를 입력해주세요.</p>
				<input type="radio" name="<c:out value="ntkrdfOprtSe${count }" />" id="<c:out value="ntkrdfOprtSe${count }1" />" class="st_radio" value="F" <c:out value="${lnbSprtInfo.ntkrdfOprtSe == 'F' ? 'checked' : '' }" /> /><label for="<c:out value="ntkrdfOprtSe${count }1" />"><c:out value="${ntkrdfOprtSeF }" /></label>
				<input type="radio" name="<c:out value="ntkrdfOprtSe${count }" />" id="<c:out value="ntkrdfOprtSe${count }2" />" class="st_radio" value="M" <c:out value="${lnbSprtInfo.ntkrdfOprtSe == 'M' ? 'checked' : '' }" /> /><label for="<c:out value="ntkrdfOprtSe${count }2" />"><c:out value="${ntkrdfOprtSeM }" /></label>
				<input type="text" name="<c:out value="ntkrdfOprtFlnm${count }" />" id="<c:out value="ntkrdfOprtFlnm${count }" />" value="<c:out value="${lnbSprtInfo.ntkrdfOprtFlnm}" />" class="st_input i_w95" placeholder="성명" />
			
				<label for="<c:out value="ntkrdfOprtHanawonTh${count }" />">(&nbsp;&nbsp;하나원기수 :</label>
				<input type="text" name="<c:out value="ntkrdfOprtHanawonTh${count }" />" id="<c:out value="ntkrdfOprtHanawonTh${count }" />" value="<c:out value="${lnbSprtInfo.ntkrdfOprtHanawonTh}" />" class="st_input i_w95 number_nocomma_style" maxlength="10">
				<label for="<c:out value="ntkrdfOprtEnctnyYr${count }" />">입국년도 :</label>
				<input type="text" name="<c:out value="ntkrdfOprtEnctnyYr${count }" />" id="<c:out value="ntkrdfOprtEnctnyYr${count }" />" value="<c:out value="${lnbSprtInfo.ntkrdfOprtEnctnyYr}" />" class="st_input i_w95 number_nocomma_style" maxlength="4">&nbsp;&nbsp;)
			</td>
		</tr>
		<tr id="<c:out value="lnbSprtInfoTr${count }_5" />">
			<th>북한이탈주민등록확인서 <span class="imp_st">*</span></th>
			<td>
				<p class="txt_c_bl br">학습지 지원대상자 또는 대상자 부모의 북한이탈주민등록확인서를 제출해주세요.</p>
				<c:forEach var="ntkrdfAcrtfctFile" items="${ntkrdfAcrtfctFileList }">
					<c:if test="${lnbSprtInfo.ntkrdfAcrtfctFileSn == ntkrdfAcrtfctFile.atchFileSn }">
						<c:set var="fileVar" value="ntkrdfAcrtfctFileSn${count }" />
						<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
						<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
						<c:set var="downloadFnValue" value="${lnbSprtInfo.ntkrdfAcrtfctFileSn }" />
						<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
					</c:if>
				</c:forEach>
				<c:if test="${empty ntkrdfAcrtfctFileList }">
					<c:set var="fileVar" value="ntkrdfAcrtfctFileSn${count }" />
					<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
					<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
					<c:set var="downloadFnValue" value="${lnbSprtInfo.ntkrdfAcrtfctFileSn }" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
				</c:if>
			</td>
		</tr>
		<tr id="<c:out value="lnbSprtInfoTr${count }_6" />">
			<th>기존수혜여부 <span class="imp_st">*</span></th>
			<td>
				<c:forEach var="code" items="${existBnfCdList }" varStatus="codeStatus">
					<input type="radio" class="st_radio" name="<c:out value="lnbPrcExistBnfCd${count }" />" id="<c:out value="lnbPrcExistBnfCd${codeStatus.count }${count }" />" value="<c:out value="${code.indivCd }" />"  <c:out value="${code.indivCd == lnbSprtInfo.existBnfCd ? 'checked' : '' }" /> />
					<label for="<c:out value="lnbPrcExistBnfCd${codeStatus.count }${count }" />"><c:out value="${code.indivCdNm }" /></label>
				</c:forEach>
			</td>
		</tr>
	</tbody>
</table>