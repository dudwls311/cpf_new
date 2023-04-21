<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mgm/mgmView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
	<input type="hidden" name="kmMode" value="write" />
	<input type="hidden" id="mgmipvAmtSprtSn" name="mgmipvAmtSprtSn" value="<c:out value="${result.mgmipvAmtSprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${empty param.pageIndex ? '1' : param.pageIndex }" />" />
</form>


<form id="viewPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kmMode" value="view" />
	<input type="hidden" name="mgmipvAmtSprtSn" value="<c:out value="${result.mgmipvAmtSprtSn }" />" />
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
								<%--
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							 --%>
							<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rrnoBknb">주민등록번호 뒷번호</label> </th>
							<td>
								<c:out value="${result.rrnoBknb}" />						
							</td>
							<th scope="row"><label class="MAL0" for="hnwCycl">하나원기수</label> </th>
							<td>
								<c:out value="${result.hnwCycl}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> </th>
							<td colspan="3">
								<c:set var="mbphnoSplit" value="${fn:split(result.mbphno,'-')}" />
								<c:out value="${mbphnoSplit[0]}-${mbphnoSplit[1]}-${mbphnoSplit[2]}" />
							</td>
						</tr>
					</table>
					<h4 class="tit">업체정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row"><label class="MAL0" for="conm">상호명</label> </th>
							<td colspan="3">
								<c:out value="${result.conm}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bzstatCd0">업태</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(bzstatCdList,result.bzstatCd)}" />
							</td>
							<th scope="row"><label class="MAL0" for="bzstatOsd">업태 그외</label> </th>
							<td>
								<c:out value="${result.bzstatOsd}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="tpbizNm">업종</label> </th>
							<td colspan="3">
								<c:out value="${result.tpbizNm}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="brno">사업자번호</label> </th>
							<td>
								<c:out value="${jtag:convertBiznumberSplitString(result.brno,'-')}" />
							</td>
							<th scope="row"><label class="MAL0" for="bizStartYmd">사업개시일</label> </th>
							<td>
								<c:out value="${jtag:convertDateSplitString(result.bizStartYmd,'-')}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="addr">주소</label> </th>
							<td colspan="3">
								<c:out value="${result.addr}" />
							</td>
						</tr>
					</table>

					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="rcmtFldCd0">모집분야</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(rcmtFldCdList,result.rcmtFldCd)}" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="sprtYr">지원연도</label> </th>
							<td>
								<c:out value="${result.sprtYr}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="dcsnAmt">결정금액</label> </th>
							<td>
								<fmt:formatNumber value="${result.dcsnAmt}" /> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="prchsDsctn">구매내역</label> </th>
							<td>
								<c:out value="${result.prchsDsctn}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="prchsAmt">구매금액</label> </th>
							<td>
								<fmt:formatNumber value="${result.prchsAmt}" /> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="giveAmt">지급금액</label> </th>
							<td>
								<fmt:formatNumber value="${result.giveAmt}" /> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="giveCycl">지급차수</label> </th>
							<td>
								<c:out value="${result.giveCycl}" /> 차
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="rmrk">비고</label> </th>
							<td>
								<c:out value="${result.rmrk}" />
							</td>
						</tr>
					</table>
				<c:if test="${result.rcmtFldCd == RCMT_FLD_CD_VEHICLE  }">
					<h4 class="tit">차량정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="carmdlCd0">차종</label> </th>
							<td>
								<c:out value="${jtag:getCdNm(carmdlCdList,result.carmdlCd)}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="mlg">주행거리</label> </th>
							<td>
								<c:out value="${result.mlg}" />
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="vhclMdyr">차량연식</label> </th>
							<td>
								<c:out value="${result.vhclMdyr}" />
							</td>
						</tr>
					</table>
				</c:if>


					<h4 class="tit">경영개선자금지원이력</h4>
					<p class="p_info">이름, 생년월일 정보가 일치하는 지원대상자의 지원이력정보가 출력됩니다.</p>
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">지원연도</th>
							<th scope="col">모집분야</th>
							<th scope="col">업태</th>
							<th scope="col">구매내역</th>
							<th scope="col">결정금액</th>
							<th scope="col">구매금액</th>
							<th scope="col">지급금액</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="dcsnAmtTotal" value="0" />
					<c:set var="prchsAmtTotal" value="0" />
					<c:forEach var="his" items="${hisList}" varStatus="status">
					<c:set var="dcsnAmtTotal" value="${dcsnAmtTotal + his.dcsnAmt}" />
					<c:set var="prchsAmtTotal" value="${prchsAmtTotal + his.prchsAmt }" />
						<fmt:formatDate var="regDt" value="${his.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${hisCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${his.sprtYr}" /></td>
							<td><c:out value="${jtag:getCdNm(rcmtFldCdList,his.rcmtFldCd)}" /></td>
							<td><c:out value="${jtag:getCdNm(bzstatCdList,his.bzstatCd)}" /></td>
							<td><c:out value="${his.prchsDsctn}" /></td>
							<td><fmt:formatNumber value="${his.dcsnAmt}" /></td>
							<td><fmt:formatNumber value="${his.prchsAmt}" /></td>
							<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${his.mgmipvAmtSprtSn}" />');return false;"><fmt:formatNumber value="${his.giveAmt}" /></a></td>
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4">총지급액</td>
							<td><fmt:formatNumber value="${dcsnAmtTotal }" /></td>
							<td><fmt:formatNumber value="${prchsAmtTotal }" /></td>
							<td></td>
						</tr>
					</tfoot>
				</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
