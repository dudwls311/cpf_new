<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NTK.getCode()" var="enumNtk" /> <%//북한이탈주민 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumLnbType).NOR.getCode()" var="enumNor" /> <%//일반인 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/lnb/lnbWrite.js"></script>

<c:set var="rcoblYnY" value="기초생활수급권자" />
<c:set var="rcoblYnN" value="해당없음" /> 

<c:set var="ntkrdfOprtSeF" value="부" />
<c:set var="ntkrdfOprtSeM" value="모" />

<c:set var="modeName" value="klMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
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

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeActionJson" />
	<input type="hidden" name="aplcntType" value="<c:out value="${empty result ? searchVO.aplcntType : result.aplcntType }" />" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${empty result.sprtSn ? sprVO.sprtSn : result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />
	<input type="hidden" id="bizSeCd" value="<c:out value="${pbaVO.bizSeCd }" />" />
	
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<input type="hidden" id="deleteLnbkSprtBscInfoSn" />
	
	<c:choose>
		<c:when test="${enumNtk == searchVO.aplcntType || enumNtk == result.aplcntType }">
			<h4 class="tit">신청자(보호자) 정보</h4>
			<c:if test="${adminPageYn != 'Y' }"><p class="p_info">보호자 기본정보는 회원 정보로 자동 입력됩니다. 보호자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p></c:if>
		</c:when>
		<c:when test="${enumNor == searchVO.aplcntType || enumNor == result.aplcntType }">
			<h4 class="tit">신청자 (보호자, 보호시설장) 정보</h4>
			<c:if test="${adminPageYn != 'Y' }"><p class="p_info">보호자 기본정보는 회원 정보로 자동 입력됩니다. 보호자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p></c:if>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
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
					<c:if test="${adminPageYn == 'Y' }">
						<c:set var="flnm" value="${result.flnm }" />
						<c:set var="genderCd" value="${result.genderCd }" />
						
						<input type="text" class="st_input" id="flnm" name="flnm" value="<c:out value="${flnm }" />" />
						&nbsp;/&nbsp;
						<select id="genderCd" name="genderCd" class="st_select">
							<option value="">선택</option>
							<c:forEach var="code" items="${genderCdList }">
								<option value="<c:out value="${code.indivCd }" />" <c:out value="${genderCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${adminPageYn != 'Y' }">
						<c:set var="flnm" value="${empty result ? loginVO.mbrNm : result.flnm }" />
						<c:set var="genderCd" value="${empty result ? loginAdtVO.genderCd : result.genderCd }" />
						<input type="hidden" name="flnm" value="<c:out value="${flnm }" />" />
						<input type="hidden" name="genderCd" value="<c:out value="${genderCd }" />" />
						
						<c:out value="${flnm }" />
						&nbsp;/&nbsp;
						<c:out value="${jtag:getCdNm(genderCdList, genderCd) }" />
					</c:if>
				</td>
				<th>생년월일</th>
				<td>
					<c:if test="${adminPageYn == 'Y' }">
						<c:set var="brdtYmd" value="${result.brdtYmd }" />
						<input type="text" class="date_style st_input" id="brdtYmd" name="brdtYmd" value="<c:out value="${brdtYmd }" />" />
					</c:if>
					<c:if test="${adminPageYn != 'Y' }">
						<c:set var="brdtYmd" value="${empty result ? loginAdtVO.brdtYmd : result.brdtYmd }" />
						<input type="hidden" name="brdtYmd" value="<c:out value="${brdtYmd }" />" />
						<c:out value="${jtag:convertDateSplitString(brdtYmd, '-') }" />
					</c:if>
				</td>
			</tr>
			<tr>
				<c:if test="${enumNtk == searchVO.aplcntType || enumNtk == result.aplcntType }">
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
				<td <c:if test="${enumNtk != searchVO.aplcntType && enumNtk != result.aplcntType }">colspan="3"</c:if> >
					<c:if test="${adminPageYn == 'Y' }">
						<c:set var="mbphno" value="${result.mbphno }" />
						<c:set var="mbphnoSplit" value="${fn:split(mbphno,'-')}" />
						<input type="hidden" name="mbphno" id="mbphno" value="" >
						<select id="mbphnoSplit0" name="mbphnoSplit0" class="st_select">
							<c:forEach var="cd" items="${frontOfPhone }" varStatus="status">
								<option value="<c:out value="${cd}" />" ${cd == mbphnoSplit[0]?' selected':'' } ><c:out value="${cd }" /></option>
							</c:forEach>
						</select>
						-
						<input type="text" name="mbphnoSplit1" id="mbphnoSplit1" value="<c:out value="${mbphnoSplit[1]}" />" class="st_input i_w95 number_nocomma_style" maxlength="4">
						-
						<input type="text" name="mbphnoSplit2" id="mbphnoSplit2" value="<c:out value="${mbphnoSplit[2]}" />" class="st_input i_w95 number_nocomma_style" maxlength="4">
					</c:if>
					<c:if test="${adminPageYn != 'Y' }">
						<c:set var="mbphno" value="${empty result ? loginAdtVO.mbphno : result.mbphno }" />
						<input type="hidden" name="mbphno" value="<c:out value="${mbphno }" />" />
						<c:out value="${mbphno }" />
					</c:if>
				</td>
			</tr>
			<tr>
				<th>주소 <span class="imp_st">*</span></th>
				<td colspan="3">
					<c:if test="${adminPageYn == 'Y' }">
						<c:set var="zip" value="${result.zip }" />
						<c:set var="addr" value="${result.addr }" />
						<c:set var="daddr" value="${result.daddr }" />
					</c:if>
					<c:if test="${adminPageYn != 'Y' }">
						<c:set var="zip" value="${empty result ? loginAdtVO.zip : result.zip }" />
						<c:set var="addr" value="${empty result ? loginAdtVO.addr : result.addr }" />
						<c:set var="daddr" value="${empty result ? loginAdtVO.daddr : result.daddr }" />
					</c:if>
					
					<p class="txt_c_bl br">실제 서비스 받을 주소기재 (기본주소는 회원정보와 동일하게 입력됩니다. 수정이 필요한 경우 수정해주세요.)</p>
					<input type="text" name="zip" id="zip" value="<c:out value="${zip}" />" class="st_input " placeholder="">
					<a class="btn_st btn_c_bk" href="#" onclick="fnAddr();return false;">주소 검색</a>
					<input type="text" name="addr" id="addr" value="<c:out value="${addr}" />" class="st_input input_long  MAB5  MAT5">
					<input type="text" name="daddr" id="daddr" value="<c:out value="${daddr}" />" class="st_input input_long ">
				</td>
			</tr>
			<c:if test="${enumNtk == searchVO.aplcntType || enumNtk == result.aplcntType }">
				<tr>
					<th>교육지원 대상자와의 관계 <span class="imp_st">*</span></th>
					<td colspan="3">
						<c:forEach var="code" items="${eduSprtTrprRelCdList }" varStatus="codeStatus">
							<input type="radio" name="eduSprtTrprRelCd" id="<c:out value="eduSprtTrprRelCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.eduSprtTrprRelCd ? 'checked' : '' }" /> class="st_radio"/>
							<label for="<c:out value="eduSprtTrprRelCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
						</c:forEach>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${enumNtk != searchVO.aplcntType && enumNtk != result.aplcntType }">
				<tr>
					<th>교육지원 대상자와의 관계 <span class="imp_st">*</span></th>
					<td colspan="3">
						<input type="text" class="st_input input_long" id="eduSprtTrprRelDtl" name="eduSprtTrprRelDtl" value="<c:out value="${result.eduSprtTrprRelDtl }" />" />
					</td>
				</tr>
			</c:if>
			
			<tr>
				<th>세대주명 <span class="imp_st">*</span></th>
				<td colspan="3">
					<input type="text" class="st_input" id="hshldrFlnm" name="hshldrFlnm" value="<c:out value="${result.hshldrFlnm }" />" />
				</td>
			</tr>
			<tr>
				<th>기초생활수급자 <span class="imp_st">*</span></th>
				<td colspan="3">
					<input type="radio" name="rcoblYn" id="rcoblYnY" class="st_radio" value="Y" <c:out value="${result.rcoblYn == 'Y' ? 'checked' : '' }" /> /><label for="rcoblYnY"><c:out value="${rcoblYnY }" /></label>
					<input type="radio" name="rcoblYn" id="rcoblYnN" class="st_radio" value="N" <c:out value="${result.rcoblYn == 'N' ? 'checked' : '' }" /> /><label for="rcoblYnN"><c:out value="${rcoblYnN }" /></label>
				</td>
			</tr>
			<tr id="rcoblSgntFileTr">
				<th>국민기초생활수급확인서 <b class="imp_st">*</b></th>
				<td colspan="3">
					<c:set var="fileVar" value="rcoblSgntFileSn" />
			      	<c:set var="fileItem" value="${rcoblSgntFile }" />
			      	<c:set var="downloadFnName" value="fnRcoblSgntFileDownload" />
			      	<c:set var="downloadFnValue" value="" />
			      	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
				</td>
			</tr>
		</tbody>
	</table>
	
	<c:choose>
		<c:when test="${enumNtk == searchVO.aplcntType || enumNtk == result.aplcntType }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/lnb/include/lnbNtkForm.jsp" %>
		</c:when>
		<c:when test="${enumNor == searchVO.aplcntType || enumNor == result.aplcntType }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/lnb/include/lnbNorForm.jsp" %>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<c:set var="agreeType" value="lnb" />
	<c:set var="sgnType" value="lnb" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%//개인정보동의폼 %> 
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
			
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_write_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<%//개인정보동의폼 %> 
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeUserForm.jsp" %>
			
			<%//서명폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_write_bottom.jsp" %>		
		</c:otherwise>
	</c:choose>
</form>

<%//학습지 지원대상자폼 %>
<table id="lnbSprtInfoAppend" style="display: none;">
	<tr id="lnbSprtInfoTr@nextSort@_1" data-sort="@nextSort@">
		<th rowspan="6">@nextSort@순위</th>
	</tr>
	<tr id="lnbSprtInfoTr@nextSort@_2">
		<th>성명</th>
		<td>
			<input type="hidden" name="prefix" value="@nextSort@" />
			<input type="hidden" name="rnkg@nextSort@" value="@nextSort@" />
			<input type="text" class="st_input" id="lnbPrcFlnm@nextSort@" name="lnbPrcFlnm@nextSort@" />
		</td>
	</tr>
	<tr id="lnbSprtInfoTr@nextSort@_3">
		<th>생년월일</th>
		<td><input type="text" class="st_input" id="lnbPrcBrdtYmd@nextSort@" name="lnbPrcBrdtYmd@nextSort@" /></td>
	</tr>
	<tr id="lnbSprtInfoTr@nextSort@_4">
		<th>출생지</th>
		<td>
		
			<c:forEach var="code" items="${brplcCdList }" varStatus="codeStatus">
				<input type="radio" name="lnbPrcBrplcCd@nextSort@" id="<c:out value="lnbPrcBrplcCd${codeStatus.count }@nextSort@" />" value="<c:out value="${code.indivCd }" />" class="st_radio" data-sort="@nextSort@" />
				<label for="<c:out value="lnbPrcBrplcCd${codeStatus.count }@nextSort@" />"><c:out value="${code.indivCdNm }" /></label>
				<c:if test="${codeStatus.first }">
					<span id="ntkSpan@nextSort@">
					(하나원기수:<input type="text" class="st_input i_w95" maxlength="10" id="lnbPrcHanawonTh@nextSort@" name="lnbPrcHanawonTh@nextSort@" />
					&nbsp;&nbsp;입국년도:<input type="text" class="st_input i_w95" maxlength="4" id="lnbPrcEntcnyYr@nextSort@" name="lnbPrcEntcnyYr@nextSort@" />)
					</span>
				</c:if>
			</c:forEach>
		</td>
	</tr>
	<tr id="lnbSprtInfoTr@nextSort@_5">
		<th>북한이탈주민등록확인서</th>
		<td>
			<c:set var="fileVar" value="ntkrdfAcrtfctFileSn@nextSort@" />
			<c:set var="fileItem" value="${ntkrdfSgntFile }" />
			<c:set var="downloadFnName" value="fnNtkrdfAcrtfctFileDownload" />
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprFileForm.jsp" %>
		</td>
	</tr>
	<tr id="lnbSprtInfoTr@nextSort@_6">
		<th>기존수혜여부</th>
		<td>
			<c:forEach var="code" items="${existBnfCdList }" varStatus="codeStatus">
				<input type="radio" name="lnbPrcExistBnfCd@nextSort@" id="<c:out value="lnbPrcExistBnfCd${codeStatus.count }@nextSort@" />" value="<c:out value="${code.indivCd }" />" class="st_radio"/>
				<label for="<c:out value="lnbPrcExistBnfCd${codeStatus.count }@nextSort@" />"><c:out value="${code.indivCdNm }" /></label>
			</c:forEach>
		</td>
	</tr>
</table>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>