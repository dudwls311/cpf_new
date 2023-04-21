<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/frm/frmView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
	<input type="hidden" name="kfMode" value="write" />
	<input type="hidden" id="frmSpfstSn" name="frmSpfstSn" value="<c:out value="${result.frmSpfstSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>

<form id="viewPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kfMode" value="view" />
	<input type="hidden" name="frmSpfstSn" value="<c:out value="${result.frmSpfstSn }" />" />
</form>

					<h4 class="tit">지원대상자 기본 정보</h4>
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
								<c:out value="${jtag:getCdNm(genderCdList,result.genderCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="mbphno">휴대폰번호</label> </th>
							<td colspan="3">
								<c:out value="${result.mbphno}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prtdcsYmd">북한이탈정보</label> </th>
							<td colspan="3">
								<label class="MAL0" for="prtdcsYmd">보호결정일 : </label>
								<c:out value="${jtag:convertDateSplitString(result.prtdcsYmd,'-')}" />
								
								<label class="MAL0" for="entcnyYmdd">입국연월 : </label>
								<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />
							</td>
						<tr>
							<th scope="row"><label class="MAL0" for="addr">주소(거주지)</label> </th>
							<td colspan="3">
								<c:out value="${result.addr}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="frscpkEdu">영성패 교육여부</label> </th>
							<td colspan="3">
								<c:out value="${result.frscpkEdu}" />
							</td>
						</tr>
					</table>
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row"><label class="MAL0" for="newYnN">구분</label> </th>
							<td>
								${'N' == result.newYn?'기존':'신규'}
							</td>
							<th scope="row"><label class="MAL0" for="sprtYr">지원연도/차수</label> </th>
							<td>
								<c:out value="${result.sprtYr}" />
								년
								<c:out value="${result.sprtCycl}" />
								차
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="sprtDcsnAmt">지원결정액</label> </th>
							<td colspan="3">
								<fmt:formatNumber value="${result.sprtDcsnAmt}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="sprtAmt">실집행액</label> </th>
							<td colspan="3">
								<fmt:formatNumber value="${result.sprtAmt}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="noExeAmtSpan">미집행액</label></th>
							<td colspan="3">
								<span id="noExeAmtSpan"><fmt:formatNumber value="${result.sprtDcsnAmt - result.sprtAmt}" /></span>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prchsBzenty">구매업체</label> </th>
							<td colspan="3">
								<c:out value="${result.prchsBzenty}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prchsItem">구매품목</label> </th>
							<td colspan="3">
								<c:out value="${result.prchsItem}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rmrk">비고</label> </th>
							<td colspan="3">
								<c:out value="${result.rmrk}" />
							</td>
						</tr>
					</table>


					<h4 class="tit">영농정착지원 지원이력</h4>
					<p class="p_info">이름, 성별, 생년월일, 보호결정일, 입국일 정보가 일치하는 지원대상자의 지원이력정보가 출력됩니다.</p>
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">지원연도</th>
							<th scope="col">차수</th>
							<th scope="col">구매물품</th>
							<th scope="col">지원결정액</th>
							<th scope="col">실집행액</th>
							<th scope="col">미집행액</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="sprtDcsnAmtTotal" value="0" />
						<c:set var="sprtAmtTotal" value="0" />
						<c:forEach var="his" items="${hisList}" varStatus="status">
						<c:set var="sprtDcsnAmtTotal" value="${sprtDcsnAmtTotal + his.sprtDcsnAmt}" />
						<c:set var="sprtAmtTotal" value="${sprtAmtTotal + his.sprtAmt }" />
							<tr>
								<td><c:out value="${his.sprtYr}" /></td>
								<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${his.frmSpfstSn}" />');return false;"><c:out value="${his.sprtCycl}" />차</a></td>
								<td><c:out value="${his.prchsItem}" /></td>
								<td><fmt:formatNumber value="${his.sprtDcsnAmt}" /></td>
								<td><fmt:formatNumber value="${his.sprtAmt}" /></td>
								<td><fmt:formatNumber value="${his.sprtDcsnAmt - his.sprtAmt}" /></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">총지급액</td>
							<td><fmt:formatNumber value="${sprtDcsnAmtTotal }" /></td>
							<td><fmt:formatNumber value="${sprtAmtTotal }" /></td>
							<td><fmt:formatNumber value="${sprtDcsnAmtTotal - sprtAmtTotal }" /></td>
						</tr>
					</tfoot>
				</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
