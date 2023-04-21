<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthNewView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kfnMode" value="write" />
	<input type="hidden" id="fthpbbNewAplySn" name="fthpbbNewAplySn" value="<c:out value="${result.fthpbbNewAplySn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>

					<h4 class="tit">신청자(지원대상자) 기본 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="flnm">성명/성별</label> </th>
							<td>
								<c:out value="${result.flnm}" />
								&nbsp;/&nbsp;<c:out value="${jtag:getCdNm(genderCdList,result.genderCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="flnm">주민번호</label> </th>
							<td>
								<c:out value="${fn:substring(result.rrno,0,6)}-${fn:substring(result.rrno,6,13)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ageCd">연령대</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(ageCdList,result.ageCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> </th>
							<td>
								<c:set var="mbphnoSplit" value="${fn:split(result.mbphno,'-')}" />
								<c:out value="${mbphnoSplit[0]}-${mbphnoSplit[1]}-${mbphnoSplit[2]}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ctpvCd">시도</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(ctpvCdList,result.ctpvCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="sggCd">군구</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(sggCdList,result.sggCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ecnmatCd">경제활동</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(ecnmatCdList,result.ecnmatCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="crCd">직업군</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(crCdList,result.crCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="coNm">회사명</label> </th>
							<td>
								<c:out value="${result.coNm}" />						
							</td>
							<th scope="row"><label class="MAL0" for="emplisJoinYmd">고용보험가입일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.emplisJoinYmd,'-')}" />						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="salaryAmt">월급여액</label> </th>
							<td>
								<fmt:formatNumber value="${result.salaryAmt}" /> 원					
							</td>
							<th scope="row"><label class="MAL0" for="entcnyYmd">입국일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="entiscYmd">사회진출일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.entiscYmd,'-')}" />						
							</td>
							<th scope="row"><label class="MAL0" for="trinsExpryYmd">보호기간만료일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.trinsExpryYmd,'-')}" />						
							</td>
						</tr>
					</table>

					<h4 class="tit">미래행복통장 신규신청 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row"><label class="MAL0" for="rcptYmd">접수일자</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.rcptYmd,'-')}" />						
							</td>
							<th scope="row"><label class="MAL0" for="jrdcHanactNm">관할 하나센터</label> </th>
							<td>
								<c:out value="${result.jrdcHanactNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="dcsnSprtAmt">결정지원액</label> </th>
							<td colspan="3">
								<fmt:formatNumber value="${result.dcsnSprtAmt}" /> 원
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bbJoinYmd">통장가입일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.bbJoinYmd,'-')}" />	
							</td>
							<th scope="row"><label class="MAL0" for="savingDdlnYmd">적립마감일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.savingDdlnYmd,'-')}" />	
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prtprdExtsnCd">보호기간연장(2년)</label> </th>
							<td colspan="3">
								<c:out value="${jtag:getCdNm(prtprdExtsnCdList,result.prtprdExtsnCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="idtprsSavingAmtActno">본인적립금 계좌번호</label> </th>
							<td>
								<c:out value="${result.idtprsSavingAmtActno}" />
							</td>
							<th scope="row"><label class="MAL0" for="stmchkActno">정부지원금 계좌번호</label> </th>
							<td>
								<c:out value="${result.stmchkActno}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rmrk">비고</label> </th>
							<td colspan="3">
								<c:out value="${result.rmrk}" />
							</td>
						</tr>
					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
