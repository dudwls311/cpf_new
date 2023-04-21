<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:if test="${empty param.sprtType }">
	<%//sprtType은 지원이력조회에서 넘어오는 파라미터로 지원이력 조회에서는 수정 밑 삭제가 불가능 %>
	
	<%//actUrl : view.jsp > sprViewForm.jsp include된 파일에서 sprVariable.jsp 참조 %>
	<form action="<c:out value="${actUrl }" />" id="writeSprtSttsForm" method="post">
		<input type="hidden" name="<c:out value="${modeName }" />" value="writeSprtSttsActionJson" />
		<input type="hidden" name="sprtSnArr" value="<c:out value="${result.sprtSn }" />" />
		<input type="hidden" id="sprtSttsCdTmp" value="<c:out value="${result.sprtSttsCd }" />" />
		
		<div class="sup_sel_result">
			<div class="sup_sel_tit">선정결과</div>
			<div class="sup_sel_radio">
				<c:forEach var="code" items="${sprtSttsCdList }" varStatus="codeStatus">
					<c:if test="${code.indivCd != '16006' }">
						<input type="radio" name="sprtSttsCd" value="<c:out value="${code.indivCd }" />" 
								id="<c:out value="sprtSttsCd${codeStatus.count }" />" <c:out value="${result.sprtSttsCd == code.indivCd ? 'checked' : '' }" />
								onclick="fnSprtSttsChg('<c:out value="${code.indivCd }" />');"
								class="st_radio"  />
						<label for="<c:out value="sprtSttsCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
						<c:if test="${code.indivCd == '16005' }"><textarea class="st_textarea" id="rsn" name="rsn" placeholder="서류미비 사유를 입력해주세요." ><c:out value="${result.rsn}" escapeXml="false" /></textarea></c:if>
					</c:if>
				</c:forEach>
			</div>
			<a href="#" id="sprtSttsSaveBtn" class="btn_st btn_c_gr sup_sel_save">저장</a>
		</div>
	</form>
</c:if>