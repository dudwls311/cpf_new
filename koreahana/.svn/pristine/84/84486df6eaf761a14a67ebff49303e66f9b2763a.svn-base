<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sms/smsLogList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kslMode" name="kslMode" value="" />
	<input type="hidden" id="clidx" name="clidx" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>
			<form action="?">
			
		<div class="box_w_gray">
			<div class="search_wrap">
				<div class="search_left">
					<label for="searchCondition">검색종류</label>
					<select id="searchCondition" name="searchCondition" class="st_select">
						<option value="0">전체</option>
						<option value="1"${param.searchCondition == '1'?' selected="selected"':'' }>제목</option>
						<option value="2"${param.searchCondition == '2'?' selected="selected"':'' }>내용</option>
					</select>
				</div>
				<div class="search_right">
					<label for="searchKeyword" class="comment">검색어 입력</label>
					<input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="st_input" placeholder="검색어를 입력하세요"/>
					<button type="submit" class="btn-input-search">조회</button>
				</div>
			</div>
		</div>
			</form>
			<div class="con_b_tp">
				<p class="b_total FloatLeft">
					총<span><fmt:formatNumber value="${resultCnt}" /></span>건
					&nbsp;&nbsp;&nbsp;&nbsp;전송상태 : (0:성공 / -1:계정없음 / 9:발신,수신번호자릿수(12자)초과)
				</p>
			</div>

				<!-- 필요시 exceltemplate 추가 후 주석 제거 -->
				<!-- <div class="btn_right_hd">
					<button class="btn_bdgreen_25" type="button" onclick="ComFns.excelDownload()">엑셀저장</button>
				</div> -->
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">발신고유번호</th>
							<th scope="col">전송상태</th>
							<th scope="col">등록일시</th>
							<th scope="col">등록자아이디</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.clidx}" />');return false;"><c:out value="${result.clidx}" /></a></td>
							<td><c:out value="${result.stat}" /></td>
							<td><c:out value="${regDt}" /></td>
							<td><c:out value="${result.rgtrId}" /></td>
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
