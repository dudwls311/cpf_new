<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/edu/eduPrcWrite.js"></script>

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

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kepMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<h4 class="tit">신청자 기본 정보</h4>
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

	<h4 class="tit">교육지원금 신청 내용</h4>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th>학교명</th>
				<td colspan="3"><c:out value="${result.shclNm }" /></td>
			</tr>
			<tr>
				<th>소재지</th>
				<td colspan="3"><c:out value="(${result.schlZip }) ${result.schlAddr } ${result.schlDaddr }" />
				</td>
			</tr>
			<tr>
				<th>대표자 성명</th>
				<td><c:out value="${result.rprsvFlnm }" /></td>
				<th>취학자</th>
				<td><fmt:formatNumber value="${result.schlacCnt }" />명</td>
			</tr>
			<tr>
				<th>보조사업비 소요경비</th>
				<td colspan="3">
					소요경비 총액:<fmt:formatNumber value="${result.asstBizTotAmt }" />원
					| 지급받으려는 보조액:<fmt:formatNumber value="${result.asstBizAsstAmt }" />원
					| 자기자본의 부담액:<fmt:formatNumber value="${result.asstBizBrdmAmt }" />원
				</td>
			</tr>
			<tr>
				<th>보조금 입금계좌</th>
				<td colspan="3">
					은행명&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${jtag:getCdNm(bankCdList, result.bacntBankCd)}" />
					|&nbsp;&nbsp;계좌번호&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.actno }" />
					|&nbsp;&nbsp;예금주&nbsp;&nbsp;:&nbsp;&nbsp;<c:out value="${result.dpstr }" />
				</td>
			</tr>
		</tbody>
	</table>
	
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">지급일</th>
								<td>
									<input type="text" name="giveYmd" id="giveYmd" value="<c:out value="${jtag:convertDateSplitString(result.giveYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row">보조금 지급금액</th>
								<td>
									<input type="text" name="asstAmtGiveAmt" id="asstAmtGiveAmt" value="<c:out value="${result.asstAmtGiveAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
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
