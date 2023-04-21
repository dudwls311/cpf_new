<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthMtrList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kfmMode" name="kfmMode" value="" />
	<input type="hidden" id="fthpbbMtryCncltnSn" name="fthpbbMtryCncltnSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>
<form action="?">
	<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
				<label for="rcptYear">지원연도</label>
				<select id="rcptYear" name="rcptYear" class="st_select">
				<c:forEach var="y" items="${yearList }" >
					<option value="${y }" ${y == searchVO.rcptYear?' selected':'' }>${y }</option>
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
				<div class=" FloatRight MAB10">
					<a class="btn_st btn_c_gr" href="#" onclick="ComFns.excelDownload();return false;">엑셀다운로드</a>
				<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
					<a class="btn_st btn_c_bk" href="#" onclick="fnWrite('');return false;">만기해지정보 개별등록</a>
					<a class="btn_st btn_c_bk" href="#" onclick="fnWriteBundle();return false;">만기해지정보 일괄등록</a>
				</c:if>
			</div>

				<!-- 필요시 exceltemplate 추가 후 주석 제거 -->
				<!-- <div class="btn_right_hd">
					<button class="btn_bdgreen_25" type="button" onclick="ComFns.excelDownload()">엑셀저장</button>
				</div> -->
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">접수일자</th>
							<th scope="col">해지일자</th>
							<th scope="col">성명</th>
							<th scope="col">관할 하나센터</th>
							<th scope="col">통장가입일</th>
							<th scope="col">사용 용도</th>
							<th scope="col">본인적립금<br />(총액기준/원)</th>
							<th scope="col">재단적립금<br />(지급액기준/원)</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${no}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.rcptYmd,'-')}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.cncltnYmd,'-')}" /></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.fthpbbMtryCncltnSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
							<td><c:out value="${result.jrdcHanactNm}" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.bbJoinYmd,'-')}" /></td>
							<td><c:out value="${jtag:getCdNm(usdusgCdList,result.usdusgCd)}" /></td>
							<td><fmt:formatNumber value="${result.idtprsSavingAmt}" /></td>
							<td><fmt:formatNumber value="${result.fndtSavingAmt}" /></td>
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
