<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NTK.getCode()" var="enumNtk" /> <%//북한이탈주민 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NOR.getCode()" var="enumNor" /> <%//일반인 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).NOR.getCode()" var="enumBrpNor" /> <%//북한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).SOU.getCode()" var="enumBrpSou" /> <%//남한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).THR.getCode()" var="enumBrpThr" /> <%//제3국 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/lnb/lnbView.js"></script>

<c:set var="modeName" value="klMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserViewForm.jsp" %>
	</c:otherwise>
</c:choose>

<%//기초생활수급자인증서파일 다운로드폼 %>
<form id="rcoblSgntFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="rcoblSgntFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
</form>

<%//북한이탈주민인증서파일 다운로드폼 %>
<form id="ntkrdfAcrtfctFileDownloadForm" action="<c:out value="${actUrl }" />">
	<input type="hidden" name="<c:out value="${modeName }" />" value="ntkrdfAcrtfctFileDownload" />
	<input type="hidden" name="sprtSn" value="" />
	<input type="hidden" name="ntkrdfAcrtfctFileSn" value="" />
</form>

<c:set var="rcoblYnY" value="기초생활수급권자" />
<c:set var="rcoblYnN" value="해당없음" /> 

<c:set var="ntkrdfOprtSeF" value="부" />
<c:set var="ntkrdfOprtSeM" value="모" /> 

<input type="hidden" id="userType" value="${result.aplcntType == enumNtk ? 'ntk' : 'nor' }" />

<input type="hidden" id="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<c:set var="hideRequire" value="Y" />
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<input type="hidden" id="userType" value="nor" />

	<c:choose>
		<c:when test="${enumNtk == result.aplcntType }">
			<h4 class="tit">신청자(보호자) 정보</h4>
		</c:when>
		<c:when test="${enumNor == result.aplcntType }">
			<h4 class="tit">신청자 (보호자, 보호시설장) 정보</h4>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	
	<table class="table_style table_t_left thd_v_m fileEvent">
		<colgroup>
			<col width="20%" />
			<col width="35%" />
			<col width="10%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoViewForm.jsp" %>
			<tr>
				<th>교육지원 대상자와의 관계</th>
				<td colspan="3">
					<c:out value="${result.eduSprtTrprRelDtl }" />
					<c:if test="${enumNtk == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${jtag:getCdNm(eduSprtTrprRelCdList, result.eduSprtTrprRelCd) }" /></c:if>
					<c:if test="${enumNor == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${result.eduSprtTrprRelDtl }" /></c:if>
					<c:out value="${eduSprtTrprRel }" />
				</td>
			</tr>
			<tr>
				<th>세대주명 </th>
				<td colspan="3">
					<c:out value="${result.hshldrFlnm }" />
				</td>
			</tr>
			<tr>
				<th>기초생활수급자 </th>
				<td colspan="3">
					<c:out value="${result.rcoblYn == 'Y' ? rcoblYnY : rcoblYnN }" />
				</td>
			</tr>
			<c:if test="${result.rcoblYn == 'Y'}">
				<tr id="rcoblSgntFileTr">
					<th>국민기초생활수급확인서</th>
					<td colspan="3">
						<c:set var="fileVar" value="rcoblSgntFileSn" />
					    <c:set var="fileItem" value="${rcoblSgntFile }" />
					    <c:set var="downloadFnName" value="fnRcoblSgntFileDownload" />
					    <c:set var="downloadFnValue" value="" />
					    <%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileViewForm.jsp" %>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<c:set var="count" value="1" />
	<c:set var="lnbSprtInfo" value="${lnbSprtInfoList[0] }" />
	
	<c:choose>
		<c:when test="${enumNtk == result.aplcntType }">
			<h4 class="tit">학습지 지원대상자 기본 정보 </h4>
		</c:when>
		<c:when test="${enumNor == result.aplcntType }">
			<h4 class="tit">학습지 지원대상자 기본 정보</h4>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<table class="table_style table_t_left thd_v_m fileEvent">
		<colgroup>
			<col width="20%" />
			<col width="*%" />
		</colgroup>
		<tbody id="lnbSprtInfoTbody">
			<c:forEach var="lnbSprtInfo" items="${lnbSprtInfoList }" varStatus="lnbSprtInfoStatus">
				<c:if test="${enumNtk == result.aplcntType }">
					<tr id="<c:out value="lnbSprtInfoTr${lnbSprtInfoStatus.count }_1" />" data-sort="<c:out value="${lnbSprtInfoStatus.count }" />">
						<th rowspan="${lnbSprtInfo.brplcCd == enumBrpNor ? '6' : '5' }"><c:out value="${lnbSprtInfoStatus.count }" />순위</th>
					</tr>
				</c:if>
				<tr id="<c:out value="lnbSprtInfoTr${count }_2" />">
					<th>성명 </th>
					<td>
						<c:out value="${lnbSprtInfo.flnm }" />
					</td>
				</tr>
				<tr id="<c:out value="lnbSprtInfoTr${count }_3" />">
					<th>생년월일 </th>
					<td><c:out value="${lnbSprtInfo.brdtYmd }" /></td>
				</tr>
				<tr id="<c:out value="lnbSprtInfoTr${count }_4" />">
					<th>출생지 </th>
					<td>
						<c:out value="${jtag:getCdNm(brplcCdList, lnbSprtInfo.brplcCd) }" />
						
						<c:if test="${lnbSprtInfo.brplcCd == enumBrpNor }">
							(&nbsp;&nbsp;하나원기수 :<c:out value="${lnbSprtInfo.hanawonTh }" />
							입국년도 :<c:out value="${lnbSprtInfo.entcnyYr }" />&nbsp;&nbsp;)
						</c:if>
					</td>
				</tr>
				<c:if test="${enumNor == result.aplcntType && lnbSprtInfo.brplcCd != enumBrpNor }">
					<tr id="<c:out value="ntkInfoTr${count }" />">
						<th>북한이탈주민 정보 </th>
						<td colspan="3">
							<c:out value="${lnbSprtInfo.ntkrdfOprtSe == 'F' ? ntkrdfOprtSeF : ntkrdfOprtSeM }" />&nbsp;&nbsp;/&nbsp;&nbsp;<c:out value="${lnbSprtInfo.ntkrdfOprtFlnm}" />
						
							(&nbsp;&nbsp;하나원기수&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${lnbSprtInfo.ntkrdfOprtHanawonTh}" />
							&nbsp;&nbsp;입국년도&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${lnbSprtInfo.ntkrdfOprtEnctnyYr}" />&nbsp;&nbsp;)
						</td>
					</tr>
				</c:if>
				<c:if test="${enumNor == result.aplcntType || lnbSprtInfo.brplcCd == enumBrpNor }">
					<tr id="<c:out value="lnbSprtInfoTr${count }_5" />">
						<th>북한이탈주민등록확인서 </th>
						<td>
							<c:forEach var="ntkrdfAcrtfctFile" items="${ntkrdfAcrtfctFileList }">
								<c:if test="${lnbSprtInfo.ntkrdfAcrtfctFileSn == ntkrdfAcrtfctFile.atchFileSn }">
									<c:set var="fileVar" value="ntkrdfAcrtfctFileSn${count }" />
									<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
									<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
									<c:set var="downloadFnValue" value="${lnbSprtInfo.ntkrdfAcrtfctFileSn }" />
									<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileViewForm.jsp" %>
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:if>
				<tr id="<c:out value="lnbSprtInfoTr${count }_6" />">
					<th>기존수혜여부</th>
					<td><c:out value="${jtag:getCdNm(existBnfCdList, lnbSprtInfo.existBnfCd) }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:set var="agreeType" value="lnb" />
	<c:set var="sgnType" value="lnb" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewAllDownForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeUserForm.jsp" %>		<%//개인정보동의폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprSttsForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_view_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<h4 class="tit">제출 서류</h4>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_view_bottom.jsp" %>
		</c:otherwise>
	</c:choose>
