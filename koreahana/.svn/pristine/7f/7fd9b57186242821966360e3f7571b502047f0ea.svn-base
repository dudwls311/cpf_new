<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthMdwView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kfmMode" value="write" />
	<input type="hidden" id="fthpbbMdwCncltnSn" name="fthpbbMdwCncltnSn" value="<c:out value="${result.fthpbbMdwCncltnSn }" />" />
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
								<%-- 
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							 --%>
							</td>
							<th scope="row"><label class="MAL0" for="flnm">주민번호</label> </th>
							<td>
								<c:out value="${fn:substring(result.rrno,0,6)}-${fn:substring(result.rrno,6,13)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> </th>
							<td colspan="3">
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
					</table>

					<h4 class="tit">미래행복통장 중도해지 정보</h4>
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
							<th scope="row"><label class="MAL0" for="rcptYmd">해지일자</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.cncltnYmd,'-')}" />						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="jrdcHanactNm">관할 하나센터</label> </th>
							<td>
								<c:out value="${result.jrdcHanactNm}" />
							</td>
							<th scope="row"><label class="MAL0" for="hanactPic">하나센터 담당자</label> </th>
							<td>
								<c:out value="${result.hanactPic}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bbJoinYmd">통장가입일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.bbJoinYmd,'-')}" />						
							</td>
							<th scope="row"><label class="MAL0" for="joinPeriodMmCnt">가입기간</label> </th>
							<td>
								<c:out value="${result.joinPeriodMmCnt}" />
								개월						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="dcsnSprtAmt">해지사유</label> </th>
							<td colspan="3">
								<c:out value="${jtag:getCdNm(cncltnRsnCdList,result.cncltnRsnCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="idtprsSavingAmt">본인적립금(총액기준)</label> </th>
							<td>
								<c:out value="${result.idtprsSavingAmt}" />					
							</td>
							<th scope="row"><label class="MAL0" for="fndtSavingAmt">재단적립금(지급액기준)</label> </th>
							<td>
								<c:out value="${result.fndtSavingAmt}" />					
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
