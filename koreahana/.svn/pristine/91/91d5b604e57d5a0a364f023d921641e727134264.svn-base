<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emp/empPrcView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kepMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


<c:set var="empmSttsYnY" value="재직 중" />
<c:set var="empmSttsYnN" value="구직 중" />

<c:set var="hgvlcYnY" value="있음" />
<c:set var="hgvlcYnN" value="없음" />

<c:set var="busDrvngCrtfctYnY" value="있음" />
<c:set var="busDrvngCrtfctYnN" value="없음" />
	
	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
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
	
	<h4 class="tit">신청자 인적사항</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th>최종학력 </th>
				<td colspan="3">
					학교명 : <c:out value="${result.lastAcbgSchlNm}" />&nbsp;&nbsp;&nbsp;<c:out value="${jtag:getCdNm(empmSttsCdList, result.lastAcbgSchlGrdtnCd) }" />
					<br />
					전공명 : <c:out value="${result.lastAcbgMjrNm}" />
				</td>
			</tr>
			<tr>
				<th>취업상태 </th>
				<td colspan="3">
					<c:out value="${result.empmSttsYn == 'Y' ? empmSttsYnY : empmSttsYnN }" />
					<c:if test="${result.empmSttsYn == 'Y' }">/&nbsp;직장명 :<c:out value="${result.empmWrcNm}" /></c:if>
				</td>
			</tr>
			<c:if test="${enumBizBus == pbaVO.bizSeCd || enumBizBus == result.bizSeCd }">
				<tr>
					<th>1종 대형면허 </th>
					<td><c:out value="${result.hgvlcYn == 'Y' ? hgvlcYnY : hgvlcYnN }" /></td>
					<th>버스운전자격증 </th>
					<td>
						<c:out value="${result.busDrvngCrtfctYn == 'Y' ? busDrvngCrtfctYnY : busDrvngCrtfctYnN }" />
					</td>
				</tr>
				<tr>
					<th>희망 운수업체 </th>
					<td colspan="3"><c:out value="${result.hopeTrpttBzenty}" /></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">자격사항</h4>
	<table class="table_style">
		<colgroup>
			<col width="40%" />
			<col width="20%" />
			<col width="40%" />
		</colgroup>
		<thead>
			<tr>
				<th>자격증명</th>
				<th>취득일</th>
				<th>취득처</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="empQlf" items="${empQlfList }">
				<tr>
					<td><c:out value="${empQlf.crtfctNm }" /></td>
					<td><c:out value="${jtag:convertDateSplitString(empQlf.acqsYmd, '-') }" /></td>
					<td><c:out value="${empQlf.acqsPlc }" /></td>
				</tr>
			</c:forEach>
			<c:if test="${fn:length(empQlfList) < 1 }">
				<tr>
					<td colspan="3">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<h4 class="tit">지원동기</h4>
    <div class="box_w_gray PAL15 PAR15">
    	${jtag:dbToHtml(result.rsnaplc)}
    </div>
    
					<h4 class="tit">교육 수료정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">교육기간</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.eduBgngYmd,'-')}" />
									 ~ <c:out value="${jtag:convertDateSplitString(result.eduEndYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row">교육수료여부</th>
								<td><c:out value="${empty result.eduFnshCmptnYn ?'': (result.eduFnshCmptnYn == 'Y'?'O':'x')}" /></td>
							</tr>
							<tr>
								<th scope="row">중도포기여부</th>
								<td><c:out value="${empty result.mdwGvupYn ?'': (result.mdwGvupYn == 'Y'?'O':'x')}" /></td>
							</tr>
							<tr>
								<th scope="row">자격증취득여부</th>
								<td>
									<c:out value="${empty result.crtfctAcqsYn ?'': (result.crtfctAcqsYn == 'Y'?'O':'x')}" />
									<c:out value="${result.crtfctInfo}" />
								</td>
							</tr>
							<tr>
								<th scope="row">취업여부</th>
								<td>
									<c:out value="${empty result.empmYn ?'': (result.empmYn == 'Y'?'O':'x')}" />
									<c:if test="${result.empmYn == 'Y' && !empty result.empmCoNm}"> / 취업처 : <c:out value="${result.empmCoNm}" /></c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									${jtag:dbToHtml(result.rmrk)}
								</td>
							</tr>

					</table>

					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
