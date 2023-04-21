<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mdl/mdlList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${searchVO.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${searchVO.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${searchVO.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kmMode" name="kmMode" value="" />
	<input type="hidden" id="mdlcrSprtSn" name="mdlcrSprtSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYear" value="<c:out value="${searchVO.sprtYear }" />" />
	<input type="hidden" name="dssSeCd" value="<c:out value="${searchVO.dssSeCd }" />" />
	<input type="hidden" name="sprtSeCd" value="<c:out value="${searchVO.sprtSeCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<form action="?">
	<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
					<label for="sprtYear">지원연도</label>
					<select id="sprtYear" name="sprtYear" class="st_select">
					<c:forEach var="y" items="${yearList }" >
						<option value="${y }" ${y == searchVO.sprtYear?' selected':'' }>${y }</option>
					</c:forEach>
					</select>
					<label for="dssSeCd">질환구분</label>
					<select id="dssSeCd" name="dssSeCd" class="st_select">
						<option value="">전체</option>
					<c:forEach var="cd" items="${dssSeCdList }" varStatus="status">
						<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.dssSeCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
					</c:forEach>
					</select>
					<label for="sprtSeCd">지원방식</label>
					<select id="sprtSeCd" name="sprtSeCd" class="st_select">
						<option value="">전체</option>
					<c:forEach var="cd" items="${sprtSeCdList }" varStatus="status">
						<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.sprtSeCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
					</c:forEach>
					</select>
			</div>
			<div class="ig_l">
				<input type="hidden" name="searchCondition" value="0" />
				<label for="searchKeyword" class="comment">검색어 입력</label>
				<input type="text" name="searchKeyword" id="searchKeyword" class="st_input input_long" value="<c:out value="${searchVO.searchKeyword }" />" placeholder="지원대상 이름으로 검색"/>
			</div>
			<div class="ig_s">
				<button type="submit" class="btn-input-search">조회</button>
			</div>
		</div>
	</div>
			</form>
			<div class="con_b_tp">
				<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
				<div class=" FloatRight">
					<a class="btn_st btn_c_gr" href="#" onclick="ComFns.excelDownload();return false;">엑셀다운로드</a>
				<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
					<a class="btn_st btn_c_bk" href="#" onclick="fnWrite('');return false;">지급정보 개별등록</a>
					<a class="btn_st btn_c_bk" href="#" onclick="fnWriteBundle();return false;">지급정보 일괄등록</a>
				</c:if>
				</div>
			</div>

				<!-- 필요시 exceltemplate 추가 후 주석 제거 -->
				<!-- <div class="btn_right_hd">
					<button class="btn_bdgreen_25" type="button" onclick="ComFns.excelDownload()">엑셀저장</button>
				</div> -->
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">성명</th>
							<th scope="col">입국연월</th>
							<th scope="col">생년월일</th>
							<th scope="col">질환구분</th>
							<th scope="col">치료기간</th>
							<th scope="col">질병명</th>
							<th scope="col">지원금</th>
							<th scope="col">지원일자</th>
							<th scope="col">지원방식</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${no}" /></td>
							<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${result.mdlcrSprtSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
							<td><c:out value="${jtag:convertDateSplitString(result.entcnyYm,'-')}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" /></td>
							<td><c:out value="${jtag:getCdNm(dssSeCdList,result.dssSeCd)}" /></td>
							<td><c:out value="${result.curePeriod}" /></td>
							<td><c:out value="${result.dssNm}" /></td>
							<td><fmt:formatNumber value="${result.sprtAmt}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.sprtYmd,'-')}" /></td>
							<td><c:out value="${jtag:getCdNm(sprtSeCdList,result.sprtSeCd)}" /></td>						
						</tr>
					</c:forEach>
					</tbody>
				</table>
<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
