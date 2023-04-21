<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/vdo/vdoPrcView.js"></script>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_IDT.getCode()" var="enumNtkIdt" /> <%//북한이탈주민(본인) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NTK_PRT.getCode()" var="enumNtkPrt" /> <%//북한이탈주민(보호자) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_IDT.getCode()" var="enumNorIdt" /> <%//본인(북한이탈주민 자녀) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumVdoType).NOR_PRT.getCode()" var="enumNorPrt" /> <%//보호자 %>

<c:set var="rcoblYnY" value="기초생활수급권자" />
<c:set var="rcoblYnN" value="해당없음" />

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kvpMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>

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
				<th>성명 / 성별</th>
				<td>
					<c:set var="flnm" value="${result.flnm }" />
					<c:set var="genderCd" value="${result.genderCd }" />
					
					<c:out value="${flnm }" />
					&nbsp;/&nbsp;
					<c:out value="${jtag:getCdNm(genderCdList, genderCd) }" />
				</td>
				<th>생년월일</th>
				<td>
					<c:set var="brdtYmd" value="${result.brdtYmd }" />
					<c:out value="${jtag:convertDateSplitString(brdtYmd, '-') }" />
				</td>
			</tr>
			<tr>
				<c:if test="${not empty result.ntkrdfUnqNo }">
					<th>북한이탈주민 정보</th>
					<td>
						 북한이탈주민 번호 : <c:out value="${loginAdtVO.ntkrdfUnqNo }" /><br>
					        입국일 : <c:out value="${jtag:convertDateSplitString(loginAdtVO.entcnyYmd, '-') }" /><br>
					        보호결정일 : <c:out value="${jtag:convertDateSplitString(loginAdtVO.prtdcsYmd, '-') }" /><br>
					        하나원 수료일 : <c:out value="${jtag:convertDateSplitString(loginAdtVO.hanawonFnshYmd, '-') }" /><br>
					        하나원기수 : <c:out value="${loginAdtVO.hanawonTh }" />
					</td>
				</c:if>
				<th>휴대폰 번호</th>
				<td colspan="<c:out value="${not empty result.ntkrdfUnqNo ? '1' : '3' }" />">
					<c:set var="mbphno" value="${result.mbphno }" />
					<c:out value="${mbphno }" />
				</td>
			</tr>
			<tr>
				<th>출생지</th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(brplcCdList, result.brplcCd) }" />
				</td>
			</tr>
			<tr>
				<th>기존 수혜여부</th>
				<td colspan="3">
					<c:out value="${jtag:getCdNm(existBnfCdList, result.existBnfCd) }" />
				</td>
			</tr>
			<tr>
				<th>기초생활수급자</th>
				<td colspan="3">
					<c:out value="${result.rcoblYn == 'Y' ? rcoblYnY : rcoblYnN }" />
				</td>
			</tr>
			<tr>
				<th>소속</th>
				<td colspan="3">
					<c:out value="${result.aplcntOgdp }" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">
			        <c:set var="zip" value="${result.zip }" />
					<c:set var="addr" value="${result.addr }" />
					<c:set var="daddr" value="${result.daddr }" />
					<c:set var="addrAll" value="(${zip }) ${addr } ${daddr }" />
					<c:out value="${addrAll }" />
				</td>
			</tr>
			<tr>
				<th scope="row">학습지중복대상여부</th>
				<td colspan="3">
				<c:if test="${!empty result.lnbkDpcnTrgtYn }">${'Y' == result.lnbkDpcnTrgtYn?'O':'X'}</c:if>
				</td>
			</tr>
			<tr>
				<th scope="row">중도퇴가</th>
				<td colspan="3">
					퇴가일 : <c:out value="${jtag:convertDateSplitString(result.mdwGbkhmYmd,'-')}" />
				</td>
			</tr>
			<tr>
				<th scope="row">퇴가사유</th>
				<td colspan="3">
					<c:out value="${result.gbkhmRsn}" />
				</td>
			</tr>
		</tbody>
	</table>

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
					<th>교육지원 대상자와의 관계 </th>
					<td colspan="3">
						<c:if test="${enumNtkPrt == result.aplcntType || enumNorIdt == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${jtag:getCdNm(eduSprtTrprRelCdList, result.eduSprtTrprRelCd) }" /></c:if>
						<c:if test="${enumNorPrt == result.aplcntType }"><c:set var="eduSprtTrprRel" value="${result.eduSprtTrprRelDtl }" /></c:if>
						<c:out value="${eduSprtTrprRel }" />
					</td>
				</tr>
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
				<tr>
					<c:if test="${not empty result.ntkrdfUnqNo }">
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
					<td colspan="<c:out value="${not empty result.ntkrdfUnqNo ? '1' : '3' }" />">
						<c:set var="prtcrMbphno" value="${result.prtcrMbphno }" />
						<c:out value="${prtcrMbphno }" />
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="3">
						<c:set var="prtcrZip" value="${result.prtcrZip }" />
						<c:set var="prtcrAddr" value="${result.prtcrAddr }" />
						<c:set var="prtcrDaddr" value="${result.prtcrDaddr }" />
						<c:set var="prtcrAddrAll" value="(${prtcrZip }) ${prtcrAddr } ${prtcrDaddr }" />
						
						<c:out value="${prtcrAddrAll }" />
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>

					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
