<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<input type="hidden" id="smbListJson" value="<c:out value="${smbListJson }" />" />
<input type="hidden" id="smbDocFormListJson" value="<c:out value="${smbDocFormListJson }" />" />
<input type="hidden" id="smbMpnListJson" value="<c:out value="${smbMpnListJson }" />" />

<input type="hidden" id="deleteFileSn"/>
<c:forEach var="smbTyp" items="${smbTypList }">

	<c:choose>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'ntkrdf1'}"><c:set var="smbNmPrefix" value="대학원생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'ntkrdf2'}"><c:set var="smbNmPrefix" value="대학생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'ntkrdf3'}"><c:set var="smbNmPrefix" value="계절학기 수강생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'ntkrdf4'}"><c:set var="smbNmPrefix" value="중고등학생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'ntkrdf5'}"><c:set var="smbNmPrefix" value="검정고시 합격생 " /></c:when>
		
		<c:when test="${smbTyp.smbsnDocTypeVl == 'thirdcnty1'}"><c:set var="smbNmPrefix" value="대학원생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'thirdcnty2'}"><c:set var="smbNmPrefix" value="대학생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'thirdcnty3'}"><c:set var="smbNmPrefix" value="계절학기 수강생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'thirdcnty4'}"><c:set var="smbNmPrefix" value="중고등학생 " /></c:when>
		<c:when test="${smbTyp.smbsnDocTypeVl == 'thirdcnty5'}"><c:set var="smbNmPrefix" value="검정고시 합격생 " /></c:when>
	</c:choose>
	
	<div id="<c:out value="SMB_${smbTyp.smbsnDocTypeVl }" />">
		<h4 class="tit"><c:out value="${smbNmPrefix }제출 서류" />
			<div class="tooltip_txt FloatRight">
				<span><b>?</b>파일첨부방법</span>
				<div class="tooltip_pop ">
					<b>파일찾기</b>
					<p>내 PC에 저장되어 있는 파일을 첨부할 수 있습니다.</p>
					<b>나의 문서함</b>
					<p>자주 사용하는 문서를 등록해두고 선택하여 첨부할 수 있습니다. 나의 문서는 마이페이지에서 관리할 수 있습니다.</p>
				</div>
			</div>
		</h4>
		<c:if test="${smbType == 'sho' }"><p style='font-size: 15px;'>모든 서류는 모집공고일 기준 <span style='font-color: red;color: red;font-weight: bold;'>3개월 이내 발급분</span>만 인정합니다.</p></c:if>
		
		<table class="table_style table_t_left th_v_m">
			<colgroup>
				<col width="15%" />
				<col width="*" />
			</colgroup>
			<tbody id="smbsnDocTbody">
				
			</tbody>
		</table>
	</div>
</c:forEach>
