<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emp/empPrcWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kepMode" value="view" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>

<c:set var="empmSttsYnY" value="재직 중" />
<c:set var="empmSttsYnN" value="구직 중" />

<c:set var="hgvlcYnY" value="있음" />
<c:set var="hgvlcYnN" value="없음" />

<c:set var="busDrvngCrtfctYnY" value="있음" />
<c:set var="busDrvngCrtfctYnN" value="없음" />
<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kepMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	
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
				<th>최종학력 <b class="imp_st">*</b></th>
				<td colspan="3">
					학교명 : <c:out value="${result.lastAcbgSchlNm}" />&nbsp;&nbsp;&nbsp;<c:out value="${jtag:getCdNm(empmSttsCdList, result.lastAcbgSchlGrdtnCd) }" />
					<br />
					전공명 : <c:out value="${result.lastAcbgMjrNm}" />
				</td>
			</tr>
			<tr>
				<th>취업상태 <b class="imp_st">*</b></th>
				<td colspan="3">
					<c:out value="${result.empmSttsYn == 'Y' ? empmSttsYnY : empmSttsYnN }" />
					<c:if test="${result.empmSttsYn == 'Y' }">/&nbsp;직장명 :<c:out value="${result.empmWrcNm}" /></c:if>
				</td>
			</tr>
			<c:if test="${enumBizBus == pbaVO.bizSeCd || enumBizBus == result.bizSeCd }">
				<tr>
					<th>1종 대형면허 <b class="imp_st">*</b></th>
					<td><c:out value="${result.hgvlcYn == 'Y' ? hgvlcYnY : hgvlcYnN }" /></td>
					<th>버스운전자격증 <b class="imp_st">*</b></th>
					<td>
						<c:out value="${result.busDrvngCrtfctYn == 'Y' ? busDrvngCrtfctYnY : busDrvngCrtfctYnN }" />
					</td>
				</tr>
				<tr>
					<th>희망 운수업체 <b class="imp_st">*</b></th>
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
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">교육기간</th>
								<td>
									<input type="text" id="eduBgngYmd" name="eduBgngYmd" value="<c:out value="${jtag:convertDateSplitString(result.eduBgngYmd,'-')}" />"  class="st_input i_w95 date_style"/>
									~
									<input type="text" id="eduEndYmd" name="eduEndYmd" value="<c:out value="${jtag:convertDateSplitString(result.eduEndYmd,'-')}" />"  class="st_input i_w95 date_style"/>
								</td>
							</tr>
							<tr>
								<th scope="row">교육수료여부</th>
								<td>
									<input type="checkbox" id="eduFnshCmptnYn" name="eduFnshCmptnYn" value="Y" class="st_check"${result.eduFnshCmptnYn == 'Y'?' checked':'' }>
									<label for="eduFnshCmptnYn">교육 수료 완료</label>
								</td>
							</tr>
							<tr>
								<th scope="row">중도포기여부</th>
								<td>
									<input type="checkbox" id=mdwGvupYn name="mdwGvupYn" value="Y" class="st_check"${result.mdwGvupYn == 'Y'?' checked':'' }>
									<label for="mdwGvupYn">중도포기</label>
								</td>
							</tr>
							<tr>
								<th scope="row">자격증취득여부</th>
								<td>
									<input type="checkbox" id=crtfctAcqsYn name="crtfctAcqsYn" value="Y" class="st_check"${result.crtfctAcqsYn == 'Y'?' checked':'' }>
									<label for="crtfctAcqsYn">자격증 취득</label>
									<input type="text" id="crtfctInfo" name="crtfctInfo" value="<c:out value="${result.crtfctInfo}" />" class="st_input"/>
								</td>
							</tr>
							<tr>
								<th scope="row">취업여부</th>
								<td>
									<input type="checkbox" id=empmYn name="empmYn" value="Y" class="st_check"${result.empmYn == 'Y'?' checked':'' }>
									<label for="empmYn">취업</label>
									/ 취업처
									<input type="text" id="empmCoNm" name="empmCoNm" value="<c:out value="${result.empmCoNm}" />" class="st_input"/>
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									<textarea class="st_textarea" name="rmrk" id="rmrk"><c:out value="${result.rmrk}" /></textarea>
								</td>
							</tr>

					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
