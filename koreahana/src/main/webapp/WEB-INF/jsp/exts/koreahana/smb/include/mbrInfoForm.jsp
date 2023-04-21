<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
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
	<th>휴대폰 번호 <span class="imp_st">*</span></th>
	<td colspan="<c:out value="${not empty loginAdtVO.ntkrdfUnqNo ? '1' : '3' }" />">
		<c:set var="mbphno" value="${empty result ? loginAdtVO.mbphno : result.mbphno }" />
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
	<th><c:choose><c:when test="${sprtType == 'emv' }">주소(실거주지)</c:when><c:otherwise>주소</c:otherwise></c:choose> <span class="imp_st">*</span></th>
	<td colspan="3">
		<c:set var="zip" value="${result.zip }" />
		<c:set var="addr" value="${result.addr }" />
		<c:set var="daddr" value="${result.daddr }" />
		
		<input type="text" name="zip" id="zip" value="<c:out value="${zip}" />" class="st_input " placeholder="">
		<a class="btn_st btn_c_bk" href="#" onclick="fnAddr();return false;">주소 검색</a>
		<input type="text" name="addr" id="addr" value="<c:out value="${addr}" />" class="st_input input_long  MAB5  MAT5">
		<input type="text" name="daddr" id="daddr" value="<c:out value="${daddr}" />" class="st_input input_long ">
	</td>
</tr>