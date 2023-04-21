<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/emv/emvUseList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="aprvYear" value="<c:out value="${searchVO.aprvYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="keuMode" name="keuMode" value="" />
	<input type="hidden" id="emvucdUseInfoSn" name="emvucdUseInfoSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="aprvYear" value="<c:out value="${searchVO.aprvYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>
<form action="?">
	<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
					<label for="aprvYear">승인연도</label>
					<select id="aprvYear" name="aprvYear" class="st_select">
						<option value="">전체</option>
					<c:forEach var="y" items="${yearList }" >
						<option value="${y }" ${y == searchVO.aprvYear?' selected':'' }>${y }</option>
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
				<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
<!-- 					<a class="btn_st btn_c_bk" href="#" onclick="fnWrite('');return false;">지급정보 개별등록</a> -->
					<a class="btn_st btn_c_bk" href="#" onclick="fnWriteBundle();return false;">카드사용정보 일괄등록</a>
				</c:if>
				</div>
			</div>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">카드번호</th>
							<th scope="col">발급자</th>
							<th scope="col">승인연월일</th>
							<th scope="col">승인번호</th>
							<th scope="col">가맹점명</th>
							<th scope="col">승인금액</th>
							<th scope="col">삭제</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${no}" /></td>
							<td><c:out value="${result.cardNo}" /></td>
							<td><c:out value="${result.issuistFlnm}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.aprvYmd,'-')}" /></td>
							<td><c:out value="${result.aprvNo}" /></td>
							<td><c:out value="${result.frcsNm}" /></td>
							<td><fmt:formatNumber value="${result.aprvAmt}" /></td>
							<td><a href="#" class="btn_st" onclick="javascript:fnDelete('<c:out value="${result.emvucdUseInfoSn}" />');return false;">삭제</a></td>
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
