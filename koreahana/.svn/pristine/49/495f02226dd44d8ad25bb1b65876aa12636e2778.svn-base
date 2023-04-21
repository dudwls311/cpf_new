<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mdl/mdlWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${param.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${param.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${param.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${param.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${param.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${param.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kmMode" value="view" />
	<input type="hidden" name="mdlcrSprtSn" value="<c:out value="${result.mdlcrSprtSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kmMode" value="writeActionJson" />
	<input type="hidden" id="mdlcrSprtSn" name="mdlcrSprtSn" value="<c:out value="${result.mdlcrSprtSn }" />" />

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
							<th scope="row"><label class="MAL0" for="entcnyYm">입국연월</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="entcnyYm" id="entcnyYm" value="<c:out value="${jtag:convertDateSplitString(result.entcnyYm,'-')}" />" class="st_input i_w95 ym_style" placeholder="yyyy-mm">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="brdtYmd" id="brdtYmd" value="<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="brdtYmd">주소</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="addr" id="addr" value="<c:out value="${result.addr}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="brdtYmd">전화번호</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="telno" id="telno" value="<c:out value="${result.telno}" />" class="st_input" maxlength="14"><span class="txt_c_bl"> 하이픈(-) 포함하여 입력해주세요. </span>
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
							<th scope="row"><label class="MAL0" for="dssSeCd0">질환구분</label> <span class="imp_st">*</span></th>
							<td colspan="3">
							<c:forEach var="cd" items="${dssSeCdList }" varStatus="status">
								<input type="radio" name="dssSeCd" value="<c:out value="${cd.indivCd}" />" id="dssSeCd${status.index }"${cd.indivCd == result.dssSeCd?' checked="checked"':'' } class="st_radio">
								<label for="dssSeCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="curePeriod">치료기간</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="curePeriod" id="curePeriod" value="<c:out value="${result.curePeriod}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="hsptlNm">병원</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="hsptlNm" id="hsptlNm" value="<c:out value="${result.hsptlNm}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="dssNm">질병명</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="dssNm" id="dssNm" value="<c:out value="${result.dssNm}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="sprtAmt">지원금</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="sprtAmt" id="sprtAmt" value="<c:out value="${result.sprtAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
							<th scope="row"><label class="MAL0" for="sprtYmd">지원일자</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="sprtYmd" id="sprtYmd" value="<c:out value="${jtag:convertDateSplitString(result.sprtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">								
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="sprtSeCd0">지원방식</label> <span class="imp_st">*</span></th>
							<td colspan="3">
							<c:forEach var="cd" items="${sprtSeCdList }" varStatus="status">
								<input type="radio" name="sprtSeCd" value="<c:out value="${cd.indivCd}" />" id="sprtSeCd${status.index }"${cd.indivCd == result.sprtSeCd?' checked="checked"':'' } class="st_radio">
								<label for="sprtSeCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
						</tr>
					</table>
<c:if test="${!empty result }">
					<h4 class="tit">의료비 지원이력</h4>
					<p class="p_info">이름, 성별, 생년월일, 입국연월 정보가 일치하는 지원대상자의 지원이력정보가 출력됩니다.</p>
					<table class="table_style thd_v_m">
						<thead>
							<tr>
								<th scope="col">질환구분</th>
								<th scope="col">치료기간</th>
								<th scope="col">질병명</th>
								<th scope="col">지원금</th>
								<th scope="col">지원일자</th>
								<th scope="col">상세보기</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="his" items="${hisList}" varStatus="status">
							<tr>
								<td><c:out value="${jtag:getCdNm(dssSeCdList,his.dssSeCd)}" /></td>
								<td><c:out value="${his.curePeriod}" /></td>
								<td><c:out value="${his.dssNm}" /></td>
								<td><fmt:formatNumber value="${his.sprtAmt}" /></td>
								<td><c:out value="${jtag:convertDateSplitString(his.sprtYmd,'-')}" /></td>
								<td><a href="#" class="btn_st btn_c_gy" onclick="javascript:fnView('<c:out value="${his.mdlcrSprtSn}" />');return false;">상세보기</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
</c:if>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
