<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<h4 class="tit">화상영어교육 지원대상자 기본 정보</h4>
<p class="p_info">화상영어교육을 지원 받고자 하는 대상자의 정보를 입력해주세요.</p>
<table class="table_style table_t_left thd_v_m">
	<colgroup>
		<col width="20%" />
		<col width="35%" />
		<col width="10%" />
		<col width="35%" />
	</colgroup>
	<tbody>
		<tr>
			<th>성명 / 성별 <span class="imp_st">*</span></th>
			<td>
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
			</td>
			<th>생년월일 <span class="imp_st">*</span></th>
			<td>
				<c:set var="brdtYmd" value="${result.brdtYmd }" />
				<input type="text" class="date_style st_input" id="brdtYmd" name="brdtYmd" value="<c:out value="${brdtYmd }" />" />
			</td>
		</tr>
		<tr>
			<th>휴대폰 번호 <span class="imp_st">*</span></th>
			<td colspan="3">
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
				
			</td>
		</tr>
		<tr>
			<th>출생지 <span class="imp_st">*</span></th>
			<td colspan="3">
				<c:forEach var="code" items="${brplcCdList }" varStatus="codeStatus">
					<input type="radio" name="brplcCd" id="<c:out value="brplcCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.brplcCd ? 'checked' : '' }" /> class="st_radio"/>
					<label for="<c:out value="brplcCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>기존 수혜여부 <span class="imp_st">*</span></th>
			<td colspan="3">
				<c:forEach var="code" items="${existBnfCdList }" varStatus="codeStatus">
					<input type="radio" name="existBnfCd" id="<c:out value="existBnfCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.existBnfCd ? 'checked' : '' }" /> class="st_radio"/>
					<label for="<c:out value="existBnfCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
				</c:forEach>
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
		<tr>
			<th>소속</th>
			<td colspan="3">
				<p class="txt_c_bl br">해당자만 학교명 등 기입</p>
				<input type="text" name="aplcntOgdp" id="aplcntOgdp" value="<c:out value="${result.aplcntOgdp }" />" class="st_input input_long"/>
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
					<p class="txt_c_bl br">실제 비품 및 교재를 받을 수 있는 주소 기재 (기본주소는 회원정보와 동일하게 입력됩니다. 수정이 필요한 경우 수정해주세요.)</p>
					<c:set var="zip" value="${empty result ? loginAdtVO.zip : result.zip }" />
					<c:set var="addr" value="${empty result ? loginAdtVO.addr : result.addr }" />
					<c:set var="daddr" value="${empty result ? loginAdtVO.daddr : result.daddr }" />
				</c:if>
				
				<input type="text" name="zip" id="zip" value="<c:out value="${zip}" />" class="st_input " placeholder="">
				<a class="btn_st btn_c_bk" href="#" onclick="fnAddr();return false;">주소 검색</a>
				<input type="text" name="addr" id="addr" value="<c:out value="${addr}" />" class="st_input input_long  MAB5  MAT5">
				<input type="text" name="daddr" id="daddr" value="<c:out value="${daddr}" />" class="st_input input_long ">
			</td>
		</tr>
	</tbody>
</table>

<h4 class="tit">신청자(보호자) 기본 정보</h4>
<c:if test="${adminPageYn != 'Y' }"><p class="p_info">보호자 기본정보는 회원 정보로 자동 입력됩니다. 보호자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p></c:if>
<table class="table_style table_t_left thd_v_m">
	<colgroup>
		<col width="20%" />
		<col width="35%" />
		<col width="10%" />
		<col width="35%" />
	</colgroup>
	<tbody>
		<tr>
			<th>교육지원 대상자와의 관계  <span class="imp_st">*</span></th>
			<td colspan="3">
				<c:forEach var="code" items="${eduSprtTrprRelCdList }" varStatus="codeStatus">
					<input type="radio" name="eduSprtTrprRelCd" id="<c:out value="eduSprtTrprRelCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == result.eduSprtTrprRelCd ? 'checked' : '' }" /> class="st_radio"/>
					<label for="<c:out value="eduSprtTrprRelCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>성명 / 성별</th>
			<td>
				<c:if test="${adminPageYn == 'Y' }">
					<c:set var="prtcrFlnm" value="${result.prtcrFlnm }" />
					<c:set var="prtcrGenderCd" value="${result.prtcrGenderCd }" />
					
					<input type="text" class="st_input" id="prtcrFlnm" name="prtcrFlnm" value="<c:out value="${prtcrFlnm }" />" />
					&nbsp;/&nbsp;
					<select id="prtcrGenderCd" name="prtcrGenderCd" class="st_select">
						<option value="">선택</option>
						<c:forEach var="code" items="${genderCdList }">
							<option value="<c:out value="${code.indivCd }" />" <c:out value="${prtcrGenderCd == code.indivCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${adminPageYn != 'Y' }">
					<c:set var="prtcrFlnm" value="${empty result ? loginVO.mbrNm : result.prtcrFlnm }" />
					<c:set var="prtcrGenderCd" value="${empty result ? loginAdtVO.genderCd : result.prtcrGenderCd }" />
					<input type="hidden" name="prtcrFlnm" value="<c:out value="${prtcrFlnm }" />" />
					<input type="hidden" name="prtcrGenderCd" value="<c:out value="${prtcrGenderCd }" />" />
					
					<c:out value="${prtcrFlnm }" />
					&nbsp;/&nbsp;
					<c:out value="${jtag:getCdNm(genderCdList, prtcrGenderCd) }" />
				</c:if>
			</td>
			<th>생년월일</th>
			<td>
				<c:if test="${adminPageYn == 'Y' }">
					<c:set var="prtcrBrdtYmd" value="${result.prtcrBrdtYmd }" />
					<input type="text" class="date_style st_input" id="prtcrBrdtYmd" name="prtcrBrdtYmd" value="<c:out value="${prtcrBrdtYmd }" />" />
				</c:if>
				<c:if test="${adminPageYn != 'Y' }">
					<c:set var="prtcrBrdtYmd" value="${empty result ? loginAdtVO.brdtYmd : result.prtcrBrdtYmd }" />
					<input type="hidden" name="prtcrBrdtYmd" value="<c:out value="${prtcrBrdtYmd }" />" />
					<c:out value="${jtag:convertDateSplitString(prtcrBrdtYmd, '-') }" />
				</c:if>
			</td>
		</tr>
		<tr>
			<c:if test="${not empty loginAdtVO.ntkrdfUnqNo || not empty result.ntkrdfUnqNo }">
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
			<td colspan="<c:out value="${not empty loginAdtVO.ntkrdfUnqNo ? '1' : '3' }" />">
				<c:if test="${adminPageYn == 'Y' }">
					<c:set var="prtcrMbphno" value="${result.prtcrMbphno }" />
					<c:set var="prtcrMbphnoSplit" value="${fn:split(prtcrMbphno,'-')}" />
					<input type="hidden" name="prtcrMbphno" id="prtcrMbphno" value="" >
					<select id="prtcrMbphnoSplit0" name="prtcrMbphnoSplit0" class="st_select">
						<c:forEach var="cd" items="${frontOfPhone }" varStatus="status">
							<option value="<c:out value="${cd}" />" ${cd == prtcrMbphnoSplit[0]?' selected':'' } ><c:out value="${cd }" /></option>
						</c:forEach>
					</select>
					-
					<input type="text" name="prtcrMbphnoSplit1" id="prtcrMbphnoSplit1" value="<c:out value="${prtcrMbphnoSplit[1]}" />" class="st_input i_w95 number_nocomma_style" maxlength="4">
					-
					<input type="text" name="prtcrMbphnoSplit2" id="prtcrMbphnoSplit2" value="<c:out value="${prtcrMbphnoSplit[2]}" />" class="st_input i_w95 number_nocomma_style" maxlength="4">
				</c:if>
				<c:if test="${adminPageYn != 'Y' }">
					<c:set var="prtcrMbphno" value="${empty result ? loginAdtVO.mbphno : result.prtcrMbphno }" />
					<input type="hidden" name="prtcrMbphno" value="<c:out value="${prtcrMbphno }" />" />
					<c:out value="${prtcrMbphno }" />
				</c:if>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3">
				<c:if test="${adminPageYn == 'Y' }">
					<c:set var="prtcrZip" value="${result.prtcrZip }" />
					<c:set var="prtcrAddr" value="${result.prtcrAddr }" />
					<c:set var="prtcrDaddr" value="${result.prtcrDaddr }" />
					
					<input type="text" name="prtcrZip" id="prtcrZip" value="<c:out value="${prtcrZip}" />" class="st_input " placeholder="">
					<a class="btn_st btn_c_bk" href="#" onclick="fnPrtcrAddr();return false;">주소 검색</a>
					<input type="text" name="prtcrAddr" id="prtcrAddr" value="<c:out value="${prtcrAddr}" />" class="st_input input_long  MAB5  MAT5">
					<input type="text" name="prtcrDaddr" id="prtcrDaddr" value="<c:out value="${prtcrDaddr}" />" class="st_input input_long ">
				</c:if>
				<c:if test="${adminPageYn != 'Y' }">
					<c:set var="prtcrZip" value="${empty result ? loginAdtVO.zip : result.prtcrZip }" />
					<c:set var="prtcrAddr" value="${empty result ? loginAdtVO.addr : result.prtcrAddr }" />
					<c:set var="prtcrDaddr" value="${empty result ? loginAdtVO.daddr : result.prtcrDaddr }" />
					
					<c:set var="prtcrAddrAll" value="(${prtcrZip }) ${prtcrAddr } ${prtcrDaddr }" />
					<input type="hidden" name="prtcrZip" value="<c:out value="${prtcrZip }" />" />
					<input type="hidden" name="prtcrAddr" value="<c:out value="${prtcrAddr }" />" />
					<input type="hidden" name="prtcrDaddr" value="<c:out value="${prtcrDaddr }" />" />
					
					<c:out value="${prtcrAddrAll }" />
				</c:if>
			</td>
		</tr>
	</tbody>
</table>