<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<c:set var="fileVarName" value="${fileVar }File" />
<div class="file_multi ig_wrap" id="<c:out value="${fileVarName }Form"/>" >
	<div class="ig_s">
		<a class="btn_st" href="#" id="<c:out value="${fileVarName }Trg"/>" style="display: ${not empty fileItem ? 'none' : ''}" >파일찾기</a>
		<c:if test="${hideDocBtn != 'Y' }">
			<a class="btn_st" href="#" id="<c:out value="${fileVarName }Doc"/>" onclick="ComFns.openMyDocBox2('${fileVar }');return false;" style="display: ${not empty fileItem ? 'none' : ''}" >문서찾기</a>
		</c:if>
	</div>
	<div class="ig_l PAL5 PAR5">
		<input type="hidden" id="<c:out value="${fileVar }Fsn"/>" name="<c:out value="${fileVar }"/>" value="<c:out value="${fileItem.atchFileSn }"/>" />
		<input type="file" id="<c:out value="${fileVarName }"/>" name="<c:out value="${fileVarName }"/>" style="display: none;">
		<span class="file_uplode">
			<span class="file_name">
				<span id="<c:out value="${fileVarName }FileNm"/>">
					<c:if test="${not empty fileItem }">
						<a href="#" class="txt_ico_f" onclick="<c:out value="${downloadFnName }" />('<c:out value="${downloadFnValue }" />');return false;"><c:out value="${fileItem.orgnlAtchFileNm }" /></a>
					</c:if>
				</span>
				<a class="file_del" href="#" id="<c:out value="${fileVarName }Delete"/>"><span class="comment">파일제거</span></a>
			</span>
		</span>
	</div>
	<div class="ig_s"></div>
</div>