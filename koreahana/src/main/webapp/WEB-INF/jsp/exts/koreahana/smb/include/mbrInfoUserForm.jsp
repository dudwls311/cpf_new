<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
		<tr>
			<th>성명 / 성별</th>
			<td>
				<c:set var="flnm" value="${empty result ? loginVO.mbrNm : result.flnm }" />
				<c:set var="genderCd" value="${empty result ? loginAdtVO.genderCd : result.genderCd }" />
				<input type="hidden" name="flnm" value="<c:out value="${flnm }" />" />
				<input type="hidden" name="genderCd" value="<c:out value="${genderCd }" />" />
				
				<c:out value="${flnm }" />
				&nbsp;/&nbsp;
				<c:out value="${jtag:getCdNm(genderCdList, genderCd) }" />
			</td>
			<th>생년월일</th>
			<td>
				<c:set var="brdtYmd" value="${empty result ? loginAdtVO.brdtYmd : result.brdtYmd }" />
				<input type="hidden" name="brdtYmd" value="<c:out value="${brdtYmd }" />" />
				<c:out value="${jtag:convertDateSplitString(brdtYmd, '-') }" />
			</td>
		</tr>
		<tr>
			<c:if test="${ (not empty loginAdtVO.ntkrdfUnqNo || not empty result.ntkrdfUnqNo) && sprtType != 'spf' }">
				<th>북한이탈주민 정보${sprtType }</th>
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
			<td colspan="<c:out value="${not empty loginAdtVO.ntkrdfUnqNo && sprtType != 'spf' ? '1' : '3' }" />">
				<c:set var="mbphno" value="${empty result ? loginAdtVO.mbphno : result.mbphno }" />
				<input type="hidden" name="mbphno" value="<c:out value="${mbphno }" />" />
				<c:out value="${mbphno }" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3">
				<c:set var="zip" value="${empty result ? loginAdtVO.zip : result.zip }" />
				<c:set var="addr" value="${empty result ? loginAdtVO.addr : result.addr }" />
				<c:set var="daddr" value="${empty result ? loginAdtVO.daddr : result.daddr }" />
				
				<c:set var="addrAll" value="(${zip }) ${addr } ${daddr }" />
				<input type="hidden" name="zip" value="<c:out value="${zip }" />" />
				<input type="hidden" name="addr" value="<c:out value="${addr }" />" />
				<input type="hidden" name="daddr" value="<c:out value="${daddr }" />" />
				
				<c:out value="${addrAll }" />
			</td>
		</tr>