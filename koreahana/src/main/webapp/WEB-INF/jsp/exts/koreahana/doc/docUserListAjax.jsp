<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:set var="dateFormat" value="yyyy-MM-dd" />
<c:set var="dateTimeFormat" value="yyyy-MM-dd HH:mm" />
<script>
/**
 * 나의문서함
 */
function popup_fnOpenMyDocBox(p){
	if(p == undefined || p == null || p == '') p = 1;
	$("#popupPageIndex").val(p);
	ComFns.popup.init({title:'나의 문서함'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/doc/index.do', $("#docBoxListPageForm").serialize() );
	ComFns.popup.show();
}

//첨부파일 다운로드
function fnDownload(docBoxSn){
	$("#downloadForm [name=docBoxSn]").val(docBoxSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}
</script>
<form id="downloadForm" action="<c:url value="/user/exts/koreahana/doc/index.do" />">
	<input type="hidden" name="kdMode" value="fileDownload" />
	<input type="hidden" name="docBoxSn" value="" />
</form>
<form id="docBoxListPageForm" action="?" onsubmit="popup_fnOpenMyDocBox();">
	<div class="search_field align_right MAB10">
		<div class="option_box">
			<input type="hidden" id="popupPageIndex" name="pageIndex" value="1" />
			<input type="hidden" name="kdMode" value="listAjax" />
			<input type="hidden" name="smbsnDocPrefix" value="<c:out value="${smbsnDocPrefix }" />" />
			<input type="hidden" name="smbsnDocMtlYn" value="<c:out value="${smbsnDocMtlYn }" />" />
			<input type="hidden" name="searchCondition" value="1" />
			<input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="st_input PAR25" placeholder="검색어를 입력하세요" style="width:365px;" />
			<button class="btn-input-search" type="submit">검색</button>
		</div>
	</div>
</form>


<table class="table_style thd_v_m" style="table-layout: fixed" >
	<colgroup>
		<col width="*%" />
		<col width="*" />
		<col width="35%" />
		<col width="20%" />
	</colgroup>

	<thead>
		<tr>
			<th>No.</th>
			<th>문서명</th>
			<th>파일명</th>
			<th>선택</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList }" varStatus="status">
			<tr>
				<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
				<td><fmt:formatNumber value="${no }" /> </td>
				<td class="AlignLeft" style='text-overflow:ellipsis; -o-text-overflow:ellipsis; overflow:hidden; white-space;nowrap;'><c:out value="${result.docBoxNm}" /></td>
				<td class="AlignLeft" style='text-overflow:ellipsis; -o-text-overflow:ellipsis; overflow:hidden; white-space;nowrap;'><a class="txt_ico_f" href="#none" onclick="fnDownload('<c:out value="${result.docBoxSn }" />');return false;"><c:out value="${result.orgnlAtchFileNm}" /></a></td>
				<td>
					<button id="<c:out value="doc${status.count }" />" onclick="<c:out value="${docBoxSelectType }" />(<c:out value="'doc${status.count }'" />);return false;" class="btn_st btn_c_or"
						data-smbsndocprefix="<c:out value="${smbsnDocPrefix }" />" 
						data-smbsndocmtlyn="<c:out value="${smbsnDocMtlYn }" />"
						data-smbdocmpngsn="<c:out value="${smbDocMpngSn }" />" 
						data-docboxsn="<c:out value="${result.docBoxSn }" />" 
						data-atchfilesn="<c:out value="${result.atchFileSn }" />" 
						data-orgnlatchfilenm="<c:out value="${result.orgnlAtchFileNm }" />" >
						선택
					</button>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${fn:length(resultList) < 1 }">
			<tr>
				<td colspan="5">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>

<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>