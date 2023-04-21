<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/frm/frmList.js?v=20230110"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kfMode" name="kfMode" value="" />
	<input type="hidden" id="frmSpfstSn" name="frmSpfstSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="sprtYr" value="<c:out value="${searchVO.sprtYr }" />" />
	<input type="hidden" name="sprtCycl" value="<c:out value="${searchVO.sprtCycl }" />" />
	<input type="hidden" name="newYn" value="<c:out value="${searchVO.newYn }" />" />
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
				<label for="sprtCycl">차수</label>
				<select id="sprtCycl" name="sprtCycl" class="st_select">
					<option value="">전체</option>
				<c:forEach var="c" begin="1" end="5">
					<option value="${c }" ${c == searchVO.sprtCycl?' selected':'' } >${c }차</option>
				</c:forEach>
				</select>
				<label for="newYn">구분</label>
				<select id="newYn" name="newYn" class="st_select">
					<option value="">전체</option>
					<option value="Y"${'Y' == searchVO.newYn?' selected':'' }>신규</option>
					<option value="N"${'N' == searchVO.newYn?' selected':'' }>기존</option>
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
				<c:if test="${isDelAuth == true}">
					<a class="btn_st btn_c_re MAL10" href="#" onclick="fnDeleteAll();return false;">삭제</a>
				</c:if>
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
							<c:if test="${isDelAuth == true}">
								<th scope="col"><input type="checkbox" class="st_check" id="chkAll" onclick="fnChkAll();" /><label for="chkAll"><span class="comment">전체선택</span></label></th>
							</c:if>
							<th scope="col">No.</th>
							<th scope="col">구분</th>
							<th scope="col">지원연도</th>
							<th scope="col">차수</th>
							<th scope="col">지원대상</th>
							<th scope="col">생년월일</th>
							<th scope="col">구매물품</th>
							<th scope="col">지원결정액</th>
							<th scope="col">실집행액</th>
							<th scope="col">미집행액</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
							<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
							<tr>
								<c:if test="${isDelAuth == true}">
									<td><input type="checkbox" class="st_check" id="<c:out value="frmChk_${status.count }" />" value="<c:out value="${result.frmSpfstSn }" />" /><label for="<c:out value="frmChk_${status.count }" />"><span class="comment">선택</span></label></td>
								</c:if>
								<td><c:out value="${no}" /></td>
								<td><c:out value="${result.newYn == 'Y'?'신규':'기존'}" /></td>
								<td><c:out value="${result.sprtYr}" /></td>
								<td><c:out value="${result.sprtCycl}" />차</td>
								<td><a href="#" class="btn_a" onclick="javascript:fnView('<c:out value="${result.frmSpfstSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
								<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" /></td>
								<td><c:out value="${result.prchsItem}" /></td>
								<td><fmt:formatNumber value="${result.sprtDcsnAmt}" /></td>
								<td><fmt:formatNumber value="${result.sprtAmt}" /></td>
								<td><fmt:formatNumber value="${result.sprtDcsnAmt - result.sprtAmt}" /></td>
							</tr>
						</c:forEach>
						<c:if test="${fn:length(resultList) < 1 }">
							<tr>
								<td colspan="11">데이터가 존재하지 않습니다.</td>
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
