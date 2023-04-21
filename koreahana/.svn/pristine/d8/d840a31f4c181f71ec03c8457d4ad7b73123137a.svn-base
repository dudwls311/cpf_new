<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/ap/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/pba/pbaWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="rlsYn" value="<c:out value="${param.rlsYn }" />" />
	<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${param.pbancrcSttsCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="rlsYn" value="<c:out value="${param.rlsYn }" />" />
	<input type="hidden" name="pbancrcSttsCd" value="<c:out value="${param.pbancrcSttsCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kpMode" value="view" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
</form>
<form id="downloadForm" action="?">
	<input type="hidden" name="kpMode" value="fileDownload" />
	<input type="hidden" name="atchFileSn" value="" />
	<input type="hidden" name="pbancrcSn" value="" />
</form>
<form id="docDownloadForm" action="">
	<input type="hidden" name="ksMode" value="fileDownload" />
	<input type="hidden" name="smbsnDocFormSn" value="" />
</form>
<input type="hidden" id="pbancrcCtgryFrstCd" value="<c:out value="${searchVO.pbancrcCtgryFrstCd }" />" />
<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kpMode" value="writeActionJson" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${result.pbancrcSn }" />" />
	<input type="hidden" id="pbaFileLength" value="<c:out value="${fn:length(pbaFileList) }" />" />
	
	<input type="hidden" id="deleteFileSn"/>

	<p class="FloatRight"><span class="imp_st">* 표시는 필수입력</span></p>
	<h4 class="tit">지원사업 모집공고</h4>
	<table class="table_style table_t_left th_v_m">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<c:if test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd || enumFrsSpf == searchVO.pbancrcCtgryFrstCd || enumFrsEmp == searchVO.pbancrcCtgryFrstCd }">
			<tr>
				<th scope="row">사업구분</th>
				<td>
					<c:if test="${empty result }">
						<div class="search_left">
							<select id="bizSeCd" name="bizSeCd" class="st_select">
								<option value="">사업 선택</option>
								<c:forEach var="code" items="${bizSeCdList }" varStatus="codeStatus">
									<option value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.bizSeCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
								</c:forEach>
							</select>
						</div>
					</c:if>
					<c:if test="${not empty result }">
						<c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd) }" />
						<input type="hidden" id="bizSeCd" name="bizSeCd" value="<c:out value="${result.bizSeCd }" />" />
					</c:if>
				</td>
			</tr>
		</c:if>
		<tr>
			<th scope="row"><label for="rlsYnY">공개여부</label><span class="imp_st">*</span></th>
			<td>
				<input type="radio" id="rlsYnY" name="rlsYn" class="st_radio" value="Y" <c:out value="${result.rlsYn == 'Y' ? 'checked' : empty result ? 'checked' : '' }" /> ><label for="rlsYnY">공개</label>
				<input type="radio" id="rlsYnN" name="rlsYn" class="st_radio" value="N" <c:out value="${result.rlsYn == 'N' ? 'checked' : '' }" />><label for="rlsYnN">비공개</label>
				
				<input type="checkbox" id="topSearchYn" name="topSearchYn" class="st_check" value="Y" <c:out value="${result.topSearchYn == 'Y' ? 'checked' : '' }" />><label for="topSearchYn" class="MAL20">상위표시</label>
			</td>
		</tr>
		<tr>
			<th scope="row"><label for="pbancrcNm">제목</label><span class="imp_st">*</span></th>
			<td>
				<input type="text" class="st_input input_long" id="pbancrcNm" name="pbancrcNm" value="<c:out value="${result.pbancrcNm}" />" />
			</td>
		</tr>
		<tr id="pbancrcBgngStrTr">
			<th scope="row">모집기간</th>
			<td>
				<fmt:formatDate var="pbancrcBgngDt" value="${result.pbancrcBgngDt}" pattern="${dateFormat }" />
				<fmt:formatDate var="pbancrcEndDt" value="${result.pbancrcEndDt}" pattern="${dateFormat }" />
				<span id="pbancrcDtSpan">
					<label for="pbancrcBgngStr" class="MAL0">모집 시작일 : </label><input type="text" name="pbancrcBgngStr" id="pbancrcBgngStr" class="st_input i_w95 date_style" value="<c:out value="${pbancrcBgngDt == '1980-01-01' ? '' : pbancrcBgngDt}" />" onchange="fnPbancrcDateChk(this);" /> &nbsp; - &nbsp;  
					<label for="pbancrcEndStr" class="MAL0">모집 종료일 : </label><input type="text" name="pbancrcEndStr" id="pbancrcEndStr" class="st_input i_w95 date_style" value="<c:out value="${pbancrcEndDt == '9999-01-01' ? '' : pbancrcEndDt}" />"  onchange="fnPbancrcDateChk(this);" />
				</span>
				
				<input type="checkbox" id="pbancrcAlways" name="pbancrcAlways" value="Y" class="st_check" onclick="fnPbancrcTypeChk(this);" <c:out value="${result.pbancrcSttsCd == enumPbaAlwCd ? 'checked' : '' }" /> /><label for="pbancrcAlways">상시모집</label>
				<input type="checkbox" id="pbancrcUnset" value="Y" class="st_check"  onclick="fnPbancrcTypeChk(this);" <c:out value="${result.pbancrcSttsCd == enumPbaUnsCd ? 'checked' : '' }" /> /><label for="pbancrcUnset">모집기간 미정</label>
			</td>
		</tr>
		<tr>
			<th scope="row">내용</th>
			<td>
				<textarea name="pbancrcCn" id="pbancrcCn" class="st_textarea" style="height:200px"><c:out value="${result.pbancrcCn}" escapeXml="false" /></textarea>
			</td>
		</tr>
		<tr>
			<th scope="row">
				첨부파일<a class="btn_st btn_ico_pl" href="#" title="첨부파일추가" onclick="fnFileFormAdd('pbaFile');return false;"><span class="comment">첨부파일추가</span></a>
			</th>
			<td id="<c:out value="pbaFileTd"/>">
				<c:set var="fileCount" value="1" />
				<c:if  test="${fn:length(pbaFileList) > 0 }">
					<c:forEach var="pbaFileResult" items="${pbaFileList }" varStatus="pbaFileStatus">
						<div class="file_multi ig_wrap" id="<c:out value="pbaFile${fileCount }Form"/>" <c:out value="data-pbaFilesort=${fileCount }" /> >
							<div class="ig_s"></div>
							<div class="ig_l PAL5 PAR5">
								<span class="file_uplode">
									<span class="file_name">
										<a href="#" onclick="fnDownload(<c:out value="'${pbaFileResult.atchFileSn }','${result.pbancrcSn }'" />);return false;"><c:out value="${pbaFileResult.orgnlAtchFileNm }" /></a>
									</span>
								</span>
							</div>
							<div class="ig_s">
								<button class="btn_st btn_ico_mn FloatRight" onclick="fnFileFormDel(<c:out value="'pbaFile${fileCount }','${pbaFileResult.pbancrcAtchFileMpngSn }'" />);return false;">제거</button>
							</div>
						</div>
						<c:set var="fileCount" value="${fileCount + 1 }" />
					</c:forEach>
				</c:if>
			</td>
		</tr>
	</table>
	
	<%//자격시험 정보 %>
	<c:if test="${enumFrsSpf == searchVO.pbancrcCtgryFrstCd }">
		<div id="spfQlfDiv">
			<h4 class="tit">자격시험 정보</h4>
			<p class="p_info">수험표에 표시될 정보입니다.</p>
			<table class="table_style table_t_left th_v_m">
				 <colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>시험장소<span class="imp_st">*</span></th>
					<td><input type="text" class="st_input input_long" id="testPlc" name="testPlc" value="<c:out value="${spfQlfVO.testPlc }" />" /></td>
				</tr>
				<tr>
					<th>시험일자<span class="imp_st">*</span></th>
					<td><input type="text" class="st_input date_style" id="testYmd" name="testYmd" value="<c:out value="${spfQlfVO.testYmd }" />" /></td>
				</tr>
				<tr>
					<th>시험시간<span class="imp_st">*</span></th>
					<td><input type="text" class="st_input input_long" id="testHrInfo" name="testHrInfo" value="<c:out value="${spfQlfVO.testHrInfo }" />" /></td>
				</tr>
				<tr>
					<th>합격자발표<span class="imp_st">*</span></th>
					<td><input type="text" class="st_input date_style" id="sccdPrsntnYmd" name="sccdPrsntnYmd" value="<c:out value="${spfQlfVO.sccdPrsntnYmd }" />" /></td>
				</tr>
			</table>
		</div>
	</c:if>
	
	<div id="smbDocContent"></div>
	<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>

<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
