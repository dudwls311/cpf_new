<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_IDT.getCode()" var="enumNtkIdt" /> <%//북한이탈주민(본인) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_PRT.getCode()" var="enumNtkPrt" /> <%//북한이탈주민(보호자) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_IDT.getCode()" var="enumNorIdt" /> <%//본인(북한이탈주민 자녀) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_PRT.getCode()" var="enumNorPrt" /> <%//보호자 %>

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
	<input type="hidden" name="kvMode" value="write" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${param.pbancrcSn }" />" />
	<input type="hidden" name="aplcntType" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>

<c:choose>
	<c:when test="${isNtkrdf }">
		<div class="box_w_suc">
			<h3 class="suc_tit">신청자 선택</h3>
			<p class="AlignCenter MAB30">본 지원사업을 신청하는 자가 누구인지 확인해주세요.</p>
			<a class="btn_st btn_c_sc btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNtkIdt }" />');return false;">
				<p class="br Fs20"><b>북한이탈주민(본인)</b></p>
				<span class="MAT20">지원사업을 신청하고 지원받고자 하는 사람이<br />
				북한이탈주민이며 본인입니다.</span>
			</a>
			<a class="btn_st btn_c_sc03 btn_s_long btn_s_bbig" href="#" onclick="fnWrite('<c:out value="${enumNtkPrt }" />');return false;">
				<p class="br Fs20"><b>북한이탈주민(보호자)</b></p>
				<span class="MAT20">북한이탈주민의 자녀(제3국 출생)을 대신하여 보호자로서<br /> 대리접수를 하고자합니다.</span>
			</a>
		</div>
	</c:when>
	<c:when test="${isNormal }">
		<div class="box_w_suc">
			<h3 class="suc_tit">신청자 선택</h3>
			<p class="AlignCenter MAB30">본 지원사업을 신청하는 자가 누구인지 확인해주세요.</p>
			<a class="btn_st btn_c_sc btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNorIdt }" />');return false;">
				<p class="br Fs20"><b>본인(북한이탈주민 자녀)</b></p>
				<span class="MAT20">지원사업을 신청하고 지원받고자 하는 사람이<br />북한이탈주민의 자녀(제3국 출생)이며 본인입니다.</span>
			</a>
			<a class="btn_st btn_c_sc03 btn_s_long btn_s_bbig" href="#" onclick="fnWrite('<c:out value="${enumNorPrt }" />');return false;">
				<p class="br Fs20"><b>보호자</b></p>
				<span class="MAT20">북한이탈주민의 자녀(제3국 출생)을 대신하여 보호자로서<br /> 대리접수를 하고자합니다.</span>
			</a>
		</div>
	</c:when>
	<c:when test="${isAdmin || isFoundStaff }">
		<div class="box_w_suc">
			<h3 class="suc_tit">신청자 선택</h3>
			<p class="AlignCenter MAB30">본 지원사업을 신청하는 자가 누구인지 확인해주세요.</p>
			<a class="btn_st btn_c_sc btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNtkIdt }" />');return false;">
				<p class="br Fs20"><b>북한이탈주민(본인)</b></p>
				<span class="MAT20">지원사업을 신청하고 지원받고자 하는 사람이<br />
				북한이탈주민이며 본인입니다.</span>
			</a>
			<a class="btn_st btn_c_sc03 btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNtkPrt }" />');return false;">
				<p class="br Fs20"><b>북한이탈주민(보호자)</b></p>
				<span class="MAT20">북한이탈주민의 자녀(제3국 출생)을 대신하여 보호자로서<br /> 대리접수를 하고자합니다.</span>
			</a>
			<a class="btn_st btn_c_sc btn_s_long btn_s_bbig MAB20" href="#" onclick="fnWrite('<c:out value="${enumNorIdt }" />');return false;">
				<p class="br Fs20"><b>본인(북한이탈주민 자녀)</b></p>
				<span class="MAT20">지원사업을 신청하고 지원받고자 하는 사람이<br />북한이탈주민의 자녀(제3국 출생)이며 본인입니다.</span>
			</a>
			<a class="btn_st btn_c_sc03 btn_s_long btn_s_bbig" href="#" onclick="fnWrite('<c:out value="${enumNorPrt }" />');return false;">
				<p class="br Fs20"><b>보호자</b></p>
				<span class="MAT20">북한이탈주민의 자녀(제3국 출생)을 대신하여 보호자로서<br /> 대리접수를 하고자합니다.</span>
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

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>
