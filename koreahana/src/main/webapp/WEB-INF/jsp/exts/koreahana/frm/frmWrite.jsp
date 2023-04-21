<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/frm/frmWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
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

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kfMode" value="writeActionJson" />
	<input type="hidden" id="frmSpfstSn" name="frmSpfstSn" value="<c:out value="${result.frmSpfstSn }" />" />

					<h4 class="tit">지원대상자 기본 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="flnm">성명/성별</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="flnm" id="flnm" value="<c:out value="${result.flnm}" />" class="st_input" placeholder="성명">
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
							<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="brdtYmd" id="brdtYmd" value="<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="mbphno">휴대폰번호</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<c:set var="mbphnoSplit" value="${fn:split(result.mbphno,'-')}" />
								<input type="hidden" name="mbphno" id="mbphno" value="" >
								<select id="mbphnoSplit0" name="mbphnoSplit0" class="st_select">
								<c:forEach var="cd" items="${frontOfPhone }" varStatus="status">
									<option value="<c:out value="${cd}" />" ${cd == mbphnoSplit[0]?' selected':'' } ><c:out value="${cd }" /></option>
								</c:forEach>
								<c:forEach var="cd" items="${frontOfTel }" varStatus="status">
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
							<th scope="row"><label class="MAL0" for="prtdcsYmd">북한이탈정보</label> </th>
							<td colspan="3">
								<label class="MAL0" for="prtdcsYmd">보호결정일</label>
								<input type="text" name="prtdcsYmd" id="prtdcsYmd" value="<c:out value="${jtag:convertDateSplitString(result.prtdcsYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">
								
								<label class="MAL0" for="entcnyYmd">입국일</label>
								<span class="imp_st">*</span>
								<input type="text" name="entcnyYmd" id="entcnyYmd" value="<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">
							</td>
						<tr>
							<th scope="row"><label class="MAL0" for="addr">주소(거주지)</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="addr" id="addr" value="<c:out value="${result.addr}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="frscpkEdu">영성패 교육여부</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="frscpkEdu" id="frscpkEdu" value="<c:out value="${result.frscpkEdu}" />" class="st_input input_long" placeholder="">
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
							<th scope="row"><label class="MAL0" for="newYnN">구분</label> <span class="imp_st">*</span></th>
							<td>
								<input type="radio" name="newYn" value="N" id="newYnN"${'N' == result.newYn?' checked="checked"':'' } class="st_radio">
								<label for="newYnN">기존</label>
								<input type="radio" name="newYn" value="Y" id="newYnY"${'Y' == result.newYn?' checked="checked"':'' } class="st_radio">
								<label for="newYnY">신규</label>
							</td>
							<th scope="row"><label class="MAL0" for="sprtYr">지원연도/차수</label> <span class="imp_st">*</span></th>
							<td>
								<select id=sprtYr name="sprtYr" class="st_select">
									<option value="">선택</option>
								<c:forEach var="y" items="${yearList }" varStatus="status">
									<option value="<c:out value="${y }" />" ${y == result.sprtYr?' selected':'' } ><c:out value="${y }" /></option>
								</c:forEach>
								</select>
								년
								
								<select name="sprtCycl" id="sprtCycl" class="st_select">
									<option value="">선택</option>
									<c:forEach var="sprtCyclCnt" begin="1" end="5" step="1">
										<option value="<c:out value="${sprtCyclCnt }" />" <c:out value="${sprtCyclCnt == result.sprtCycl ? 'selected' : '' }" /> ><c:out value="${sprtCyclCnt }" /></option>
									</c:forEach>
								</select>
								차
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="sprtDcsnAmt">지원결정액</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="sprtDcsnAmt" id="sprtDcsnAmt" value="<c:out value="${result.sprtDcsnAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="sprtAmt">실집행액</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="sprtAmt" id="sprtAmt" value="<c:out value="${result.sprtAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="noExeAmtSpan">미집행액</label></th>
							<td colspan="3">
								<span id="noExeAmtSpan"></span>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prchsBzenty">구매업체</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="prchsBzenty" id="prchsBzenty" value="<c:out value="${result.prchsBzenty}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prchsItem">구매품목</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="prchsItem" id="prchsItem" value="<c:out value="${result.prchsItem}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rmrk">비고</label> </th>
							<td colspan="3">
								<input type="text" name="rmrk" id="rmrk" value="<c:out value="${result.rmrk}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
					</table>

					
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
