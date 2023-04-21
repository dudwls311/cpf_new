<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mgm/mgmWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
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

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kmMode" value="writeActionJson" />
	<input type="hidden" id="mgmipvAmtSprtSn" name="mgmipvAmtSprtSn" value="<c:out value="${result.mgmipvAmtSprtSn }" />" />

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
								<%--
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							 --%>
							<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="brdtYmd" id="brdtYmd" value="<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rrnoBknb">주민등록번호 뒷번호</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="rrnoBknb" id="rrnoBknb" value="<c:out value="${result.rrnoBknb}" />" class="st_input i_w95 number_nocomma_style" placeholder="" maxlength="7">						
							</td>
							<th scope="row"><label class="MAL0" for="hnwCycl">하나원기수</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="hnwCycl" id="hnwCycl" value="<c:out value="${result.hnwCycl}" />" class="st_input i_w95 number_nocomma_style" placeholder="" maxlength="4"> 기
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> <span class="imp_st">*</span></th>
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
							<th scope="row"><label class="MAL0" for="conm">상호명</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="conm" id="conm" value="<c:out value="${result.conm}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bzstatCd0">업태</label> <span class="imp_st">*</span></th>
							<td>
								<select id=bzstatCd name="bzstatCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${bzstatCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.bzstatCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
							<th scope="row"><label class="MAL0" for="bzstatOsd">업태 그외</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="bzstatOsd" id="bzstatOsd" value="<c:out value="${result.bzstatOsd}" />" class="st_input" placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="tpbizNm">업종</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="tpbizNm" id="tpbizNm" value="<c:out value="${result.tpbizNm}" />" class="st_input " placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="brno">사업자번호</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="brno" id="brno" value="<c:out value="${jtag:convertBiznumberSplitString(result.brno,'-')}" />" class="st_input " placeholder="">
							</td>
							<th scope="row"><label class="MAL0" for="bizStartYmd">사업개시일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="bizStartYmd" id="bizStartYmd" value="<c:out value="${jtag:convertDateSplitString(result.bizStartYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="yyyy-mm-dd">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="addr">주소</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<input type="text" name="addr" id="addr" value="<c:out value="${result.addr}" />" class="st_input input_long" placeholder="">
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
							<th><label class="MAL0" for="rcmtFldCd0">모집분야</label> <span class="imp_st">*</span></th>
							<td>
							<c:forEach var="cd" items="${rcmtFldCdList }" varStatus="status">
								<input type="radio" name="rcmtFldCd" value="<c:out value="${cd.indivCd}" />" id="rcmtFldCd${status.index }"${cd.indivCd == result.rcmtFldCd?' checked="checked"':'' } class="st_radio">
								<label for="rcmtFldCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="sprtYr">지원연도</label> <span class="imp_st">*</span></th>
							<td>
								<select id=sprtYr name="sprtYr" class="st_select">
									<option value="">선택</option>
								<c:forEach var="y" items="${yearList }" varStatus="status">
									<option value="<c:out value="${y }" />" ${y == result.sprtYr?' selected':'' } ><c:out value="${y }" /></option>
								</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="dcsnAmt">결정금액</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="dcsnAmt" id="dcsnAmt" value="<c:out value="${result.dcsnAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="prchsDsctn">구매내역</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="prchsDsctn" id="prchsDsctn" value="<c:out value="${result.prchsDsctn}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="prchsAmt">구매금액</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="prchsAmt" id="prchsAmt" value="<c:out value="${result.prchsAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="giveAmt">지급금액</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="giveAmt" id="giveAmt" value="<c:out value="${result.giveAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> 원
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="giveCycl">지급차수</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="giveCycl" id="giveCycl" value="<c:out value="${result.giveCycl}" />" class="st_input i_w95 number_nocomma_style" placeholder="" maxlength="4"> 차
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="rmrk">비고</label> </th>
							<td>
								<input type="text" name="rmrk" id="rmrk" value="<c:out value="${result.rmrk}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
					</table>
<input type="hidden" id="RCMT_FLD_CD_VEHICLE" value="${RCMT_FLD_CD_VEHICLE }" />
					<h4 class="tit" id="viH4">차량정보</h4>
					<table class="table_style table_t_left th_v_m" id="viTable">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="carmdlCd0">차종</label> <span class="imp_st">*</span></th>
							<td>
							<c:forEach var="cd" items="${carmdlCdList }" varStatus="status">
								<input type="radio" name="carmdlCd" value="<c:out value="${cd.indivCd}" />" id="carmdlCd${status.index }"${cd.indivCd == result.carmdlCd?' checked="checked"':'' } class="st_radio">
								<label for="carmdlCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="mlg">주행거리</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="mlg" id="mlg" value="<c:out value="${result.mlg}" />" class="st_input i_w95 number_nocomma_style" placeholder=""> km (계기판과 동일하게)
							</td>
						</tr>
						<tr>
							<th><label class="MAL0" for="vhclMdyr">차량연식</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="vhclMdyr" id="vhclMdyr" value="<c:out value="${result.vhclMdyr}" />" class="st_input i_w95" placeholder="">
							</td>
						</tr>
					</table>
					
<c:if test="${!empty result }">

					<h4 class="tit">경영개선자금지원이력</h4>
					<p class="p_info">이름, 생년월일, 하나원기수 정보가 일치하는 지원대상자의 지원이력정보가 출력됩니다.</p>
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">지원연도</th>
							<th scope="col">모집분야</th>
							<th scope="col">업태</th>
							<th scope="col">구매물품</th>
							<th scope="col">결정금액</th>
							<th scope="col">구매내역</th>
							<th scope="col">구매금액</th>
							<th scope="col">지급금액</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="his" items="${hisList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${his.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${hisCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${his.sprtYr}" /></td>
							<td><c:out value="${jtag:getCdNm(rcmtFldCdList,his.rcmtFldCd)}" /></td>
							<td><c:out value="${jtag:getCdNm(bzstatCdList,his.bzstatCd)}" /></td>
							<td><c:out value="${his.prchsDsctn}" /></td>
							<td><fmt:formatNumber value="${his.dcsnAmt}" /></td>
							<td><c:out value="${his.prchsDsctn}" /></td>
							<td><fmt:formatNumber value="${his.prchsAmt}" /></td>
							<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${his.mgmipvAmtSprtSn}" />');return false;"><fmt:formatNumber value="${his.giveAmt}" /></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
</c:if>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
