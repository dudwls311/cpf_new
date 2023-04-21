<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/lnb/lnbPrcView.js"></script>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NTK.getCode()" var="enumNtk" /> <%//북한이탈주민 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NOR.getCode()" var="enumNor" /> <%//일반인 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).NOR.getCode()" var="enumBrpNor" /> <%//북한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).SOU.getCode()" var="enumBrpSou" /> <%//남한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).THR.getCode()" var="enumBrpThr" /> <%//제3국 %>

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="klpMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


	<h4 class="tit">보호자 정보</h4>
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
					<c:out value="${result.rcoblYn == 'Y' ? '기초생활수급권자' : '해당없음' }" />
				</td>
			</tr>
			<tr>
				<th scope="row">신청일</th>
				<td colspan="3">
					<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</tbody>
	</table>
	
	<c:set var="count" value="1" />
	<c:set var="lnbSprtInfo" value="${lnbSprtInfoList[0] }" />
	
	<h4 class="tit">지원대상자 정보</h4>
			<c:forEach var="lnbSprtInfo" items="${lnbSprtInfoList }" varStatus="lnbSprtInfoStatus">
			<c:set var="prcSn" value="${lnbSprtInfo.lnbkSprtBscInfoSn }" />
			<input type="hidden" name="prcSns" value="${prcSn }" />
	<table class="table_style table_t_left thd_v_m fileEvent">
		<colgroup>
			<col width="20%">
			<col width="35%">
			<col width="10%">
			<col width="35%">
		</colgroup>
		<tbody id="lnbSprtInfoTbody">
				<tr>
					<th>순위</th>
					<td>
						<c:out value="${lnbSprtInfo.rnkg}" />
					</td>
					<th>지원대상여부 </th>
					<td>
					<c:if test="${!empty lnbSprtInfo.sprtTrgtYn }">
						${'Y' == lnbSprtInfo.sprtTrgtYn?'대상':'비대상' }
					</c:if>
					</td>
				</tr>
				<tr>
					<th>성명 </th>
					<td>
						<c:out value="${lnbSprtInfo.flnm }" />
					</td>
					<th>생년월일 </th>
					<td><c:out value="${jtag:convertDateSplitString(lnbSprtInfo.brdtYmd ,'-')}" /></td>
				</tr>
				<tr>
					<th>출생지 </th>
					<td>
						<c:out value="${jtag:getCdNm(brplcCdList, lnbSprtInfo.brplcCd) }" />
						
						<c:if test="${lnbSprtInfo.brplcCd == enumBrpNor }">
							(&nbsp;&nbsp;하나원기수 :<c:out value="${lnbSprtInfo.hanawonTh }" />
							입국년도 :<c:out value="${lnbSprtInfo.entcnyYr }" />&nbsp;&nbsp;)
						</c:if>
					</td>
					<th>기존수혜여부 </th>
					<td>
						<c:out value="${jtag:getCdNm(existBnfCdList, lnbSprtInfo.existBnfCd) }" />
					</td>
				</tr>
				<tr>
					<th>화상영어중복대상 </th>
					<td colspan="3">
					<c:if test="${!empty lnbSprtInfo.vdoengDpcnTrgtYn }">
						${'Y' == lnbSprtInfo.vdoengDpcnTrgtYn?'여':'부' }
					</c:if>
					</td>
				</tr>
				<tr>
					<th>중도퇴가</th>
					<td>
						퇴가일:<c:out value="${jtag:convertDateSplitString(lnbSprtInfo.mdwGbkhmYmd,'-')}" />
					</td>
					<th>퇴가사유 </th>
					<td>
						<c:out value="${lnbSprtInfo.gbkhmRsn}" />
					</td>
				</tr>
		</tbody>
	</table>
			</c:forEach>
					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
