<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/lnb/lnbPrcWrite.js"></script>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NTK.getCode()" var="enumNtk" /> <%//북한이탈주민 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NOR.getCode()" var="enumNor" /> <%//일반인 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).NOR.getCode()" var="enumBrpNor" /> <%//북한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).SOU.getCode()" var="enumBrpSou" /> <%//남한 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBrplcCd).THR.getCode()" var="enumBrpThr" /> <%//제3국 %>

<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="klpMode" value="view" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="klpMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<p class="tit_b_title box_w_gray"><c:out value="${result.pbancrcNm }" /></p>
	

	
	<h4 class="tit">보호자 정보</h4>
	<table class="table_style table_t_left thd_v_m fileEvent">
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
				<th>휴대폰 번호</th>
				<td colspan="3">
					<c:set var="mbphno" value="${result.mbphno }" />
					<c:out value="${mbphno }" />
				</td>
			</tr>
			<tr>
				<th>주소 </th>
				<td colspan="3">
			        <c:set var="zip" value="${result.zip }" />
					<c:set var="addr" value="${result.addr }" />
					<c:set var="daddr" value="${result.daddr }" />
					
					<c:out value="(${zip }) ${addr } ${daddr }" />
				</td>
			</tr>
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
						<input type="text" name="rnkg${prcSn }" id="rnkg${prcSn }" value="<c:out value="${lnbSprtInfo.rnkg}" />" class="st_input i_w95 number_nocomma_style" placeholder="">순위
					</td>
					<th>지원대상여부 </th>
					<td>
						<input type="radio" name="sprtTrgtYn${prcSn }" value="Y" id="sprtTrgtYnY${prcSn }"${'Y' == lnbSprtInfo.sprtTrgtYn?' checked="checked"':'' } class="st_radio">
						<label for="sprtTrgtYnY${prcSn }">대상</label>
						<input type="radio" name="sprtTrgtYn${prcSn }" value="N" id="sprtTrgtYnN${prcSn }"${'N' == lnbSprtInfo.sprtTrgtYn?' checked="checked"':'' } class="st_radio">
						<label for="sprtTrgtYnN${prcSn }">비대상</label>
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
						<input type="radio" name="vdoengDpcnTrgtYn${prcSn }" value="Y" id="vdoengDpcnTrgtYnY${prcSn }"${'Y' == lnbSprtInfo.vdoengDpcnTrgtYn?' checked="checked"':'' } class="st_radio">
						<label for="vdoengDpcnTrgtYnY${prcSn }">여</label>
						<input type="radio" name="vdoengDpcnTrgtYn${prcSn }" value="N" id="vdoengDpcnTrgtYnN${prcSn }"${'N' == lnbSprtInfo.vdoengDpcnTrgtYn?' checked="checked"':'' } class="st_radio">
						<label for="vdoengDpcnTrgtYnN${prcSn }">부</label>
					</td>
				</tr>
				<tr>
					<th>중도퇴가</th>
					<td>
						퇴가일:<input type="text" name="mdwGbkhmYmd${prcSn }" id="mdwGbkhmYmd${prcSn }" value="<c:out value="${jtag:convertDateSplitString(lnbSprtInfo.mdwGbkhmYmd,'-')}" />" class="st_input w95 date_style" placeholder="">
					</td>
					<th>퇴가사유 </th>
					<td>
						<input type="text" name="gbkhmRsn${prcSn }" id="gbkhmRsn${prcSn }" value="<c:out value="${lnbSprtInfo.gbkhmRsn}" />" class="st_input " placeholder="">
					</td>
				</tr>
		</tbody>
	</table>
			</c:forEach>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
