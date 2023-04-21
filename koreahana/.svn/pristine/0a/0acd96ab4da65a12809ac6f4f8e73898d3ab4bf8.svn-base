<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mgm/mgmList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kmMode" name="kmMode" value="" />
	<input type="hidden" id="mgmipvAmtSprtSn" name="mgmipvAmtSprtSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="rcmtFldCd" value="<c:out value="${searchVO.rcmtFldCd }" />" />
	<input type="hidden" name="bzstatCd" value="<c:out value="${searchVO.bzstatCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>
<form action="?">
	<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
				<label for="sprtYr">지원연도</label>
				<select id="sprtYr" name="sprtYr" class="st_select">
				<c:forEach var="y" items="${yearList }" >
					<option value="${y }" ${y == searchVO.sprtYr?' selected':'' }>${y }</option>
				</c:forEach>
				</select>
				<label for="rcmtFldCd">모집분야</label>
				<select id="rcmtFldCd" name="rcmtFldCd" class="st_select">
					<option value="">전체</option>
				<c:forEach var="cd" items="${rcmtFldCdList }" varStatus="status">
					<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.rcmtFldCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
				</c:forEach>
				</select>
				<label for="bzstatCd">업태</label>
				<select id="bzstatCd" name="bzstatCd" class="st_select">
					<option value="">전체</option>
				<c:forEach var="cd" items="${bzstatCdList }" varStatus="status">
					<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.bzstatCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
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
							<th scope="col">지원연도</th>
							<th scope="col">모집분야</th>
							<th scope="col">업태</th>
							<th scope="col">지원대상</th>
							<th scope="col">결정금액</th>
							<th scope="col">구매내역</th>
							<th scope="col">구매금액</th>
							<th scope="col">지급금액</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
							<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
							<tr>
								<td><c:out value="${no}" /></td>
								<td><c:out value="${result.sprtYr}" /></td>
								<td><c:out value="${jtag:getCdNm(rcmtFldCdList,result.rcmtFldCd)}" /></td>
								<td><c:out value="${jtag:getCdNm(bzstatCdList,result.bzstatCd)}" /></td>
								<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${result.mgmipvAmtSprtSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
								<td><fmt:formatNumber value="${result.dcsnAmt}" /></td>
								<td><c:out value="${result.prchsDsctn}" /></td>
								<td><fmt:formatNumber value="${result.prchsAmt}" /></td>
								<td><fmt:formatNumber value="${result.giveAmt}" /></td>
							</tr>
						</c:forEach>
						<c:if test="${fn:length(resultList) < 1 }">
							<tr>
								<td colspan="9">데이터가 존재하지 않습니다.</td>
							</tr>
						</c:if>
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
