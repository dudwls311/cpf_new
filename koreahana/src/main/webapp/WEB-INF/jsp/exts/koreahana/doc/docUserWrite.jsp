<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/doc/docWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
</form>
<form id="downloadForm" action="<c:url value="/user/exts/koreahana/doc/index.do" />">
	<input type="hidden" name="kdMode" value="fileDownload" />
	<input type="hidden" name="docBoxSn" value="" />
</form>
<form id="writeForm" action="<c:url value="/user/exts/koreahana/doc/index.do" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kdMode" value="writeActionJson" />
	<input type="hidden" id="docBoxSn" name="docBoxSn" value="<c:out value="${result.docBoxSn }" />" />

	<ul class="ul_st02">
		<li class="MAB10"><b>문서 명</b> <input type="text" name="docBoxNm" id="docBoxNm" value="<c:out value="${result.docBoxNm }" />" class="st_input input_long" /></li>
		<li class="MAB20"><b>파일등록</b>
			<p class="file_uplode">
				<c:if test="${empty result }">
					<input type="file" id="docFile" name="docFile" style="display: none;" />
					<a class="btn_st" href="#" id="docFileTrg">파일열기</a>
				</c:if>
				<span class="file_name">
					<c:if test="${empty result }">
						<span id="docFileFileNm"><c:out value="${result.orgnlAtchFileNm }" /></span>
					</c:if>
					<c:if test="${not empty result }">
						<a class="txt_ico_f" href="#none" onclick="fnDownload('<c:out value="${result.docBoxSn }" />');return false;"><c:out value="${result.orgnlAtchFileNm}" /></a>
					</c:if>
					<c:if test="${empty result }">
						<a class="file_del" id="docFileDelete" href="#"><span class="comment">파일제거</span></a>
					</c:if>
				</span>
			</p>
		</li>
	</ul>
</form>
