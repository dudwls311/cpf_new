<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<input type="hidden" id="userType" value="ntk" />

<h4 class="tit">학습지 지원대상자 기본 정보<span class="imp_st">*</span></h4>
<p class="p_info">제3국, 남한출생의 경우 1가구 당 1순위인 학습대상자를 우선적으로 선발(한 가구 당 최대 2명까지 가능)하며, 신청 가구수가 선정대상보다 적을 경우 ①기초생활수급자 ②신규자 ③전년출석우수자 순으로 선발되어 1가구 1자녀 지원이 되지 않을 수도 있습니다.</p>
<p class="AlignRight  MAB10">
	<a href="#" class="btn_st btn_ico_pl MAR10" onclick="fnLnbSprtInfoFormAdd();return false;">추가</a>
	<a href="#" class="btn_st btn_ico_mn" onclick="fnLnbSprtInfoFormDel();return false;">삭제</a>
</p>
<table class="table_style table_t_left thd_v_m">
	<colgroup>
		<col width="7%" />
		<col width="15%" />
		<col width="*" />
	</colgroup>
	<tbody id="lnbSprtInfoTbody">
		<c:forEach var="lnbSprtInfo" items="${lnbSprtInfoList }" varStatus="lnbSprtInfoStatus">
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_1" />" data-sort="<c:out value="${lnbSprtInfoStatus.count }" />">
				<th rowspan="6"><c:out value="${lnbSprtInfoStatus.count }" />순위</th>
			</tr>
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_2" />">
				<th>성명</th>
				<td>
					<input type="hidden" name="prefix" value="<c:out value="${lnbSprtInfoStatus.count }" />" />
					<input type="hidden" name="<c:out value="rnkg${lnbSprtInfoStatus.count }" />" value="<c:out value="${lnbSprtInfoStatus.count }" />" />
					<input type="hidden" name="<c:out value="lnbkSprtBscInfoSn${lnbSprtInfoStatus.count }" />" value="<c:out value="${lnbSprtInfo.lnbkSprtBscInfoSn }" />" />
					<input type="text" class="st_input" id="<c:out value="lnbPrcFlnm${lnbSprtInfoStatus.count }" />" name="lnbPrcFlnm<c:out value="${lnbSprtInfoStatus.count }" />" value="<c:out value="${lnbSprtInfo.flnm }" />" />
				</td>
			</tr>
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_3" />">
				<th>생년월일</th>
				<td><input type="text" class="date_style st_input" id="<c:out value="lnbPrcBrdtYmd${lnbSprtInfoStatus.count }" />" name="lnbPrcBrdtYmd<c:out value="${lnbSprtInfoStatus.count }" />" value="<c:out value="${lnbSprtInfo.brdtYmd }" />"  /></td>
			</tr>
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_4" />">
				<th>출생지</th>
				<td>
				
					<c:forEach var="code" items="${brplcCdList }" varStatus="codeStatus">
						<input type="radio" class="st_radio" name="<c:out value="lnbPrcBrplcCd${lnbSprtInfoStatus.count }" />" id="<c:out value="lnbPrcBrplcCd${codeStatus.count }${lnbSprtInfoStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == lnbSprtInfo.brplcCd ? 'checked' : '' }" /> data-sort="<c:out value="${lnbSprtInfoStatus.count }" />"  />
						<label for="<c:out value="lnbPrcBrplcCd${codeStatus.count }${lnbSprtInfoStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
						<c:if test="${codeStatus.first }">
							<span id="<c:out value="ntkSpan${lnbSprtInfoStatus.count }" />">
							(하나원기수:<input type="text" class="st_input i_w95 number_nocomma_style" maxlength="10" id="<c:out value="lnbPrcHanawonTh${lnbSprtInfoStatus.count }" />" name="<c:out value="lnbPrcHanawonTh${lnbSprtInfoStatus.count }" />" value="<c:out value="${lnbSprtInfo.hanawonTh }" />" />
							&nbsp;&nbsp;입국년도:<input type="text" class="st_input i_w95 number_nocomma_style" maxlength="4" id="<c:out value="lnbPrcEntcnyYr${lnbSprtInfoStatus.count }" />" name="<c:out value="lnbPrcEntcnyYr${lnbSprtInfoStatus.count }" />"  value="<c:out value="${lnbSprtInfo.entcnyYr }" />" />)
							</span>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_5" />">
				<th>북한이탈주민등록확인서</th>
				<td>
					<c:set var="isExist" value="N" />
					<c:forEach var="ntkrdfAcrtfctFile" items="${ntkrdfAcrtfctFileList }">
						<c:if test="${lnbSprtInfo.ntkrdfAcrtfctFileSn == ntkrdfAcrtfctFile.atchFileSn }"><c:set var="isExist" value="Y" /></c:if>
					</c:forEach>
					
					<c:forEach var="ntkrdfAcrtfctFile" items="${ntkrdfAcrtfctFileList }">
						<c:if test="${lnbSprtInfo.ntkrdfAcrtfctFileSn == ntkrdfAcrtfctFile.atchFileSn }">
							<c:set var="fileVar" value="ntkrdfAcrtfctFileSn${lnbSprtInfoStatus.count }" />
							<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
							<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
							<c:set var="downloadFnValue" value="${lnbSprtInfo.ntkrdfAcrtfctFileSn }" />
							<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
						</c:if>
					</c:forEach>
					<c:if test="${empty ntkrdfAcrtfctFileList || isExist == 'N' }">
						<c:set var="fileVar" value="ntkrdfAcrtfctFileSn${lnbSprtInfoStatus.count }" />
						<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
						<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
						<c:set var="downloadFnValue" value="${lnbSprtInfo.ntkrdfAcrtfctFileSn }" />
						<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
					</c:if>
				</td>
			</tr>
			<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_6" />">
				<th>기존수혜여부</th>
				<td>
					<c:forEach var="code" items="${existBnfCdList }" varStatus="codeStatus">
						<input type="radio" class="st_radio" name="<c:out value="lnbPrcExistBnfCd${lnbSprtInfoStatus.count }" />" id="<c:out value="lnbPrcExistBnfCd${codeStatus.count }${lnbSprtInfoStatus.count }" />" value="<c:out value="${code.indivCd }" />"  <c:out value="${code.indivCd == lnbSprtInfo.existBnfCd ? 'checked' : '' }" /> />
						<label for="<c:out value="lnbPrcExistBnfCd${codeStatus.count }${lnbSprtInfoStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>