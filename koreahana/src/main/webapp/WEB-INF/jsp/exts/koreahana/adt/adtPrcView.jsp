<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/adt/adtPrcView.js"></script>
<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kapMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoViewForm.jsp" %>
		</tbody>
	</table>
	
	<c:if test="${enumBizThr == result.bizSeCd }">
		<h4 class="tit">가족관계</h4>
		<table class="table_style">
			<colgroup>
				<col width="50%" />
				<col width="50%" />
			</colgroup>
			<thead>
				<tr>
					<th>신청자와의 관계</th>
					<th>가족 성명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fam" items="${famList }">
					<tr>
						<td><c:out value="${jtag:getCdNm(aplcntRelCdList,fam.aplcntRelCd) }" /></td>
						<td><c:out value="${fam.famFlnm }" /></td>
					</tr>
				</c:forEach>
				<c:if test="${fn:length(famList) < 1 }">
					<tr>
						<td colspan="2">데이터가 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</c:if>
	
					<h4 class="tit">신청정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">신청일</th>
								<td>
									<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
							<tr>
								<th scope="row">가산금구분</th>
								<td>
									<c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd) }" />
								</td>
							</tr>
							<tr>
								<th scope="row">지급사유</th>
								<td>
									<c:out value="${result.adtnAmtGiveRsn}" />
								</td>
							</tr>
					</table>
				<c:if test="${enumBizDis == result.bizSeCd }">
					<h4 class="tit">장애 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">장애정도</th>
								<td>
									<c:out value="${result.dsbltyDegr}" />
								</td>
							</tr>
							<tr>
								<th scope="row">장애구분</th>
								<td>
									<c:out value="${result.dsbltySe}" />
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									${jtag:dbToHtml(result.dsbltyRmrk)}
								</td>
							</tr>
					</table>
				</c:if>
				<c:if test="${enumBizLon == result.bizSeCd }">
					<h4 class="tit">장기치료 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">질병명</th>
								<td>
									<c:out value="${result.dssNm}" />
								</td>
							</tr>
							<tr>
								<th scope="row">입원기간</th>
								<td>
									<c:out value="${result.hsptzPeriod}" />
								</td>
							</tr>
							<tr>
								<th scope="row">입원정보</th>
								<td>
									${jtag:dbToHtml(result.hsptzInfo)}
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									${jtag:dbToHtml(result.lperiodCureRmrk)}
								</td>
							</tr>
					</table>
				</c:if>
				<c:if test="${enumBizThr == result.bizSeCd }">
					<h4 class="tit">제3국출생 자녀양육 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">자녀1</th>
								<td>
									<label class="MAL0" for="frstChdrFlnm">이름 : </label>
									<c:out value="${result.frstChdrFlnm}" />
									<label class="MAL20" for="frstChdrBrdtYmd">생년월일 : </label>
									<c:out value="${jtag:convertDateSplitString(result.frstChdrBrdtYmd,'-')}" />
									<span id="frstChdrSpan"></span>
									<label class="MAL20" for="frstChdrBrthNtnNm">출생국가 : </label>
									<c:out value="${result.frstChdrBrthNtnNm}" />
								</td>
							</tr>
							<tr>
								<th scope="row">자녀2</th>
								<td>
									<label class="MAL0" for="scndryChdrFlnm">이름 : </label>
									<c:out value="${result.scndryChdrFlnm}" />
									<label class="MAL20" for="scndryChdrBrdtYmd">생년월일 : </label>
									<c:out value="${jtag:convertDateSplitString(result.scndryChdrBrdtYmd,'-')}" />
									<span id="scndryChdrSpan"></span>
									<label class="MAL20" for="scndryChdrBrthNtnNm">출생국가 : </label>
									<c:out value="${result.scndryChdrBrthNtnNm}" />
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									${jtag:dbToHtml(result.chdrNtreRmrk)}
								</td>
							</tr>
						</table>
				</c:if>
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">지급 결정일</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.giveDcsnYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row">최초결정액</th>
								<td>
									<fmt:formatNumber value="${result.frstDcsnAmt}" />
									원									
								</td>
							</tr>
							<tr>
								<th scope="row">지급시작 종료 연월</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.giveBgngYm,'-')}" />
									~
									<c:out value="${jtag:convertDateSplitString(result.giveEndYm,'-')}" />
									
									<label class="MAL20" for="totGiveNmtm">총지급횟수 : </label>
									<c:out value="${result.totGiveNmtm}" />
								</td>
							</tr>
							<tr>
								<th scope="row">계좌정보</th>
								<td>
									<c:out value="${jtag:getCdNm(bankCdList,result.bacntBankCd)}" />
									<label class="MAL20" for="actno">계좌번호 : </label>
									<c:out value="${result.actno}" />
									<label class="MAL20" for="dpstr">예금주 : </label>
									<c:out value="${result.dpstr}" />
								</td>
							</tr>
						</table>
						
						
					<h4 class="tit">회차별 지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:80px;" />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tbody id="rndTbody">
						<c:set var="totalAmt" value="0" />
						<c:forEach items="${result.rndList}" var="rnd">
							<tr>
								<th scope="row">${rnd.rnd}회</th>
								<th scope="row">지급일</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(rnd.giveYm,'-')}" />
								</td>
								<th scope="row">지급액</th>
								<td>
									<c:set var="totalAmt" value="${totalAmt + rnd.giveAmt }" />
									<fmt:formatNumber value="${rnd.giveAmt}" />
									원
								</td>
							</tr>
						</c:forEach>

						</tbody>
						<tfoot>
							<tr>
								<td colspan="5" style="text-align:center"><b>총 지급액:<span id="giveTotalAmt"><fmt:formatNumber value="${totalAmt}" /></span>원 <span class="txt_c_bl">(잔액: <span id="remainTotalAmt"><fmt:formatNumber value="${result.frstDcsnAmt - totalAmt}" /></span>원)</span></b></td>
							</tr>
						</tfoot>
					</table>
					
					
					<h4 class="tit">종결정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">지급 종료일</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.giveTrmnYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row">종결사유</th>
								<td>
									${jtag:dbToHtml(result.trmnRsn)}
								</td>
							</tr>
					</table>
					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
