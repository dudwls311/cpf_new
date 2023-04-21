<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/vdo/vdoView.js"></script>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_IDT.getCode()" var="enumNtkIdt" /> <%//북한이탈주민(본인) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_PRT.getCode()" var="enumNtkPrt" /> <%//북한이탈주민(보호자) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_IDT.getCode()" var="enumNorIdt" /> <%//본인(북한이탈주민 자녀) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_PRT.getCode()" var="enumNorPrt" /> <%//보호자 %>

<c:set var="rcoblYnY" value="기초생활수급권자" />
<c:set var="rcoblYnN" value="해당없음" />


<c:set var="modeName" value="kvMode" />
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
</form>

<input type="hidden" id="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<c:set var="hideRequire" value="Y" />
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<input type="hidden" id="enumNorPrt" value="<c:out value="${enumNorPrt }" />" />

	<c:if test="${result.aplcntType == enumNtkIdt }">
		<%//북한이탈주민(보호자) %>
		<h4 class="tit">신청자(화상영어교육 지원대상자) 기본 정보</h4>
	</c:if>
	<c:if test="${result.aplcntType == enumNtkPrt }">
		<%//북한이탈주민(보호자) %>
		<h4 class="tit">화상영어교육 지원대상자 기본 정보</h4>
	</c:if>
	<c:if test="${result.aplcntType == enumNorIdt }">
		<%//본인(북한이탈주민 자녀) %>
		<h4 class="tit">신청자(화상영어교육 지원대상자) 기본 정보</h4>
	</c:if>
	<c:if test="${result.aplcntType == enumNorPrt }">
		<%//보호자 %>
		<h4 class="tit">화상영어교육 지원대상자 기본 정보</h4>
	</c:if>
	
	<table class="table_style table_t_left thd_v_m">
		<colgroup>
			<col width="20%" />
			<col width="35%" />
			<col width="10%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th>성명 / 성별 </th>
				<td>
					<c:set var="flnm" value="${result.flnm }" />
					<c:set var="genderCd" value="${result.genderCd }" />
					
					<c:out value="${flnm }" />
					&nbsp;/&nbsp;
					<c:out value="${jtag:getCdNm(genderCdList, genderCd) }" />
				</td>
				<th>생년월일 </th>
				<td>
					<c:set var="brdtYmd" value="${result.brdtYmd }" />
					<c:out value="${jtag:convertDateSplitString(brdtYmd, '-') }" />
				</td>
			</tr>
			<tr>
				<c:if test="${not empty result.ntkrdfUnqNo && result.aplcntType == enumNtkIdt }">
					<th>북한이탈주민 정보</th>
					<td>
						북한이탈주민 번호 : <c:out value="${result.ntkrdfUnqNo }" /><br>
						입국일 : <c:out value="${jtag:convertDateSplitString(result.entcnyYmd, '-') }" /><br>
						보호결정일 : <c:out value="${jtag:convertDateSplitString(result.prtdcsYmd, '-') }" /><br>
						하나원 수료일 : <c:out value="${jtag:convertDateSplitString(result.hanawonFnshYmd, '-') }" /><br>
						하나원기수 : <c:out value="${result.hanawonTh }" />
					</td>
				</c:if>
				<th>휴대폰 번호</th>
				<td colspan="<c:out value="${not empty result.ntkrdfUnqNo && result.aplcntType != enumNtkPrt ? '1' : '3' }" />">
					<c:set var="mbphno" value="${result.mbphno }" />
					<c:out value="${mbphno }" />
				</td>
			</tr>
			<tr>
				<th>출생지 </th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(brplcCdList, result.brplcCd) }" />
				</td>
			</tr>
			<tr>
				<th>기존 수혜여부 </th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(existBnfCdList, result.existBnfCd) }" />
				</td>
			</tr>
			<tr>
				<th>기초생활수급자 </th>
				<td colspan="3">
					<c:out value="${result.rcoblYn == 'Y' ? rcoblYnY : rcoblYnN }" />
				</td>
			</tr>
			<c:if test="${result.rcoblYn == 'Y'}">
				<tr>
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
			<tr>
				<th>소속</th>
				<td colspan="3">
					<c:out value="${result.aplcntOgdp }" />
				</td>
			</tr>
			<tr>
				<th>주소 </th>
				<td colspan="3">
			        <c:set var="zip" value="${result.zip }" />
					<c:set var="addr" value="${result.addr }" />
					<c:set var="daddr" value="${result.daddr }" />
					<c:set var="addrAll" value="(${zip }) ${addr } ${daddr }" />
					<c:out value="${addrAll }" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<c:if test="${result.aplcntType == enumNorPrt }">
		<%//보호자 %>
		<h4 class="tit">북한이탈주민 확인 정보</h4>
		<table class="table_style table_t_left thd_v_m">
			<colgroup>
				<col width="20%" />
				<col width="35%" />
				<col width="10%" />
				<col width="35%" />
			</colgroup>
			<tbody>
				<tr>
					<th>북한이탈주민 구분 </th>
					<td colspan="3">
						<c:out value="${result.ntkrdfSe }" />&nbsp;&nbsp;&nbsp;<c:out value="${not empty result.ntkrdfFlnm ? '성명 : ' : ''}" /><c:out value="${result.ntkrdfFlnm}" />
					</td>
				</tr>
				<tr>
					<th>북한이탈주민 정보</th>
					<td colspan="3">
						하나원 기수&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.ntkrdfHanawonTh}" />
						&nbsp;&nbsp;&nbsp;&nbsp;입국년도&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.ntkrdfEntcnyYr}" />
					</td>
				</tr>
				<tr>
					<th>북한이탈주민등록확인서</th>
					<td colspan="3">
						<c:set var="fileVar" value="ntkrdfAcrtfctFileSn" />
				      	<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
				      	<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
		      			<c:set var="downloadFnValue" value="" />
				      	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileViewForm.jsp" %>
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	
	<c:if test="${result.aplcntType == enumNtkPrt }">
		<%//북한이탈주민(보호자) %>
		<h4 class="tit">신청자(보호자) 기본 정보</h4>
	</c:if>
	<c:if test="${result.aplcntType == enumNorIdt }">
		<%//본인(북한이탈주민 자녀) %>
		<h4 class="tit">보호자 정보</h4>
	</c:if>
	<c:if test="${result.aplcntType == enumNorPrt }">
		<%//보호자 %>
		<h4 class="tit">신청자(보호자, 보호시설장) 정보</h4>
	</c:if>
	
	<c:if test="${result.aplcntType == enumNtkPrt || result.aplcntType == enumNorIdt || result.aplcntType == enumNorPrt }">
		<table class="table_style table_t_left thd_v_m">
			<colgroup>
				<col width="20%" />
				<col width="35%" />
				<col width="10%" />
				<col width="35%" />
			</colgroup>
			<tbody>
				<tr>
					<th>교육지원 대상자와의 관계  </th>
					<td colspan="3">
						<c:if test="${enumNtkPrt == result.aplcntType || enumNorIdt == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${jtag:getCdNm(eduSprtTrprRelCdList, result.eduSprtTrprRelCd) }" /></c:if>
						<c:if test="${enumNorPrt == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${result.eduSprtTrprRelDtl }" /></c:if>
						<c:out value="${eduSprtTrprRel }" />
					</td>
				</tr>
				
				<c:if test="${result.aplcntType != enumNorIdt }">
					<tr>
						<th>성명 / 성별</th>
						<td>
							<c:set var="prtcrFlnm" value="${result.prtcrFlnm }" />
							<c:set var="prtcrGenderCd" value="${result.prtcrGenderCd }" />
							
							<c:out value="${prtcrFlnm }" />
							&nbsp;/&nbsp;
							<c:out value="${jtag:getCdNm(genderCdList, prtcrGenderCd) }" />
						</td>
						<th>생년월일</th>
						<td>
							<c:set var="prtcrBrdtYmd" value="${result.prtcrBrdtYmd }" />
							<c:out value="${jtag:convertDateSplitString(prtcrBrdtYmd, '-') }" />
						</td>
					</tr>
				</c:if>
				
				<c:if test="${result.aplcntType == enumNorIdt }">
					<tr>
						<th>성명</th>
						<td>
							<c:set var="prtcrFlnm" value="${result.prtcrFlnm }" />
							<c:out value="${prtcrFlnm }" />
						</td>
						<th>휴대폰 번호</th>
						<td>
							<c:set var="prtcrMbphno" value="${result.prtcrMbphno }" />
							<c:out value="${prtcrMbphno }" />
						</td>
					</tr>
				</c:if>
				
				<tr>
					<c:if test="${result.aplcntType != enumNorIdt }">
						<c:if test="${not empty result.ntkrdfUnqNo }">
							<th>북한이탈주민 정보</th>
							<td>
								<c:set var="ntkrdfUnqNo" value="${empty result ? loginAdtVO.ntkrdfUnqNo : result.ntkrdfUnqNo }" />
								<c:set var="entcnyYmd" value="${empty result ? loginAdtVO.entcnyYmd : result.entcnyYmd }" />
								<c:set var="prtdcsYmd" value="${empty result ? loginAdtVO.prtdcsYmd : result.prtdcsYmd }" />
								<c:set var="hanawonFnshYmd" value="${empty result ? loginAdtVO.hanawonFnshYmd : result.hanawonFnshYmd }" />
								<c:set var="hanawonTh" value="${empty result ? loginAdtVO.hanawonTh : result.hanawonTh }" />
								
								북한이탈주민 번호 : <c:out value="${ntkrdfUnqNo }" /><br>
								입국일 : <c:out value="${jtag:convertDateSplitString(entcnyYmd, '-') }" /><br>
								보호결정일 : <c:out value="${jtag:convertDateSplitString(prtdcsYmd, '-') }" /><br>
								하나원 수료일 : <c:out value="${jtag:convertDateSplitString(hanawonFnshYmd, '-') }" /><br>
								하나원기수 : <c:out value="${hanawonTh }" />
							</td>
						</c:if>
						<th>휴대폰 번호</th>
						<td colspan="<c:out value="${not empty result.ntkrdfUnqNo ? '1' : '3' }" />">
							<c:set var="prtcrMbphno" value="${result.prtcrMbphno }" />
							<c:out value="${prtcrMbphno }" />
						</td>
					</c:if>
					<c:if test="${result.aplcntType == enumNorIdt }">
						<th>북한이탈주민 정보</th>
						<td colspan="3">
							부 또는 모 하나원기수 :<c:out value="${result.ntkrdfHanawonTh}" />
							&nbsp;&nbsp;입국년도 :<c:out value="${result.ntkrdfEntcnyYr}" />
						</td>
					</c:if>
				</tr>
				<tr>
					<c:if test="${result.aplcntType != enumNorIdt }">
						<th>주소</th>
						<td colspan="3">
							<c:set var="prtcrZip" value="${result.prtcrZip }" />
							<c:set var="prtcrAddr" value="${result.prtcrAddr }" />
							<c:set var="prtcrDaddr" value="${result.prtcrDaddr }" />
							<c:set var="prtcrAddrAll" value="(${prtcrZip }) ${prtcrAddr } ${prtcrDaddr }" />
							
							<c:out value="${prtcrAddrAll }" />
						</td>
					</c:if>
					<c:if test="${result.aplcntType == enumNorIdt }">
						<th>북한이탈주민등록확인서</th>
						<td colspan="3">
							<c:set var="fileVar" value="ntkrdfAcrtfctFileSn" />
					      	<c:set var="fileItem" value="${ntkrdfAcrtfctFile }" />
					      	<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
		      				<c:set var="downloadFnValue" value="" />
					      	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileViewForm.jsp" %>
						</td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</c:if>
	
	<c:set var="agreeType" value="vdo" />
	<c:set var="sgnType" value="vdo" />
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