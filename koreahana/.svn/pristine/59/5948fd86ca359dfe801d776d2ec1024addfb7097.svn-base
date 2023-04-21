<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NTK.getCode()" var="enumNtk" /> <%//북한이탈주민 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NOR.getCode()" var="enumNor" /> <%//일반인 %>

<script>
function fnWrite(aplcntType){
	if(aplcntType == undefined || aplcntType == null || aplcntType == ''){
		alert('신청자를 선택해주세요.');
	}else{
		$("#writePageForm [name=aplcntType]").val(aplcntType);
		$("#writePageForm").submit();
	}
}
</script>

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
	<input type="hidden" name="klMode" value="write" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${param.pbancrcSn }" />" />
	<input type="hidden" name="aplcntType" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>

<c:choose>
	<c:when test="${isAdmin || isFoundStaff }">
		<div class="box_w_suc">
			<h3 class="suc_tit">신청자 선택</h3>
			<p class="AlignCenter MAB30">본 지원사업을 신청하는 자가 누구인지 확인해주세요.</p>
			<a class="btn_st btn_c_sc btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNtk }" />');return false;">
				<p class="br Fs20"><b>북한이탈주민</b></p>
			</a>
			<a class="btn_st btn_c_sc03 btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNor }" />');return false;">
				<p class="br Fs20"><b>일반사용자</b></p>
			</a>
		</div>
	</c:when>
	<c:otherwise>
		<div class="box_w_suc">
			<h3 class="suc_tit">신청자 선택</h3>
			<p class="AlignCenter MAB30">신청이 불가능한 회원입니다.</p>
		</div>
	</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>