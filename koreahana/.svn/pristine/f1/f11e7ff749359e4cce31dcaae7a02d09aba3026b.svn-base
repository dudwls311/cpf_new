<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoPrcList.js"></script>

<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NTK.getCode()" var="enumMbrTypeCdNTK" />
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NOR.getCode()" var="enumMbrTypeCdNOR" />

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
	<input type="hidden" name="slctnMthdCd" value="<c:out value="${searchVO.slctnMthdCd }" />" />
	<input type="hidden" name="slctnMmtCd" value="<c:out value="${searchVO.slctnMmtCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="kspMode" name="kspMode" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
	<input type="hidden" name="slctnMthdCd" value="<c:out value="${searchVO.slctnMthdCd }" />" />
	<input type="hidden" name="slctnMmtCd" value="<c:out value="${searchVO.slctnMmtCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<form action="?" id="searchForm">
		<%@include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListPbaSearchForm.jsp" %>
		<div class="box_w_gray">
			<div class="br">
				<label for="sprtYr">신청연도</label>
				<select name="regDtYr" id="regDtYr"  class="st_select">
					<option value="">전체</option>
					<c:forEach var="regDtYr" items="${regDtYrList }">
						<option value="<c:out value="${regDtYr.regDtYr }" />" <c:out value="${regDtYr.regDtYr == searchVO.regDtYr ? 'selected' : ''}" />  ><c:out value="${regDtYr.regDtYr }" /></option>
					</c:forEach>
				</select> 
				<label for="searchNtkYn">지원자유형</label>
				<select name="searchNtkYn" id="searchNtkYn"  class="st_select">
					<option value="">전체</option>
					<option value="Y"${searchVO.searchNtkYn == 'Y'?' selected':'' }>북한이탈주민</option>
					<option value="N"${searchVO.searchNtkYn == 'N'?' selected':'' }>제3국출생</option>
				</select> 
				<label for="searchSholSlctnType">장학금유형</label>
				<select name="searchSholSlctnType" id="searchSholSlctnType"  class="st_select">
					<option value="">전체</option>
					<option value="1"${searchVO.searchSholSlctnType == '1'?' selected':'' }>대학원생</option>
					<option value="2"${searchVO.searchSholSlctnType == '2'?' selected':'' }>대학생</option>
					<option value="3"${searchVO.searchSholSlctnType == '3'?' selected':'' }>계절학기 수강생</option>
					<option value="4"${searchVO.searchSholSlctnType == '4'?' selected':'' }>중고등학생</option>
					<option value="5"${searchVO.searchSholSlctnType == '5'?' selected':'' }>검정고시합격자</option>
				</select> 
				<label for="slctnMthdCd">선발방법</label>
				<select name="slctnMthdCd" id="slctnMthdCd"  class="st_select">
					<option value="">전체</option>
					<c:forEach var="cd" items="${slctnMthdCdList }" varStatus="status">
						<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.slctnMthdCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
					</c:forEach>
				</select> 
				<label for="slctnMmtCd">선발시기</label>
				<select name="slctnMmtCd" id="slctnMmtCd"  class="st_select">
					<option value="">전체</option>
					<c:forEach var="cd" items="${slctnMmtCdList }" varStatus="status">
						<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == searchVO.slctnMmtCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
					</c:forEach>
				</select> 
			</div>
			<div class="ig_l">
				<label for="searchKeyword" class="comment">검색어 입력</label>
				<input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="st_input input_long" placeholder="지원대상 이름으로 검색"  />
			</div>
			<div class="ig_s">
				<input type="hidden" name="searchCondition" value="0" />
				<button type="submit" class="btn-input-search">조회</button>
			</div>
		</div>
			</form>
			<div class="con_b_tp">
				<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
				<%//@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %>
				<div class=" FloatRight">
					<a class="btn_st btn_c_gr" href="#" onclick="ComFns.excelDownload();return false;">엑셀다운로드</a>
					<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
						<a class="btn_st btn_c_bk" href="#" onclick="fnWriteBundle();return false;">지급정보 일괄등록</a>
					</c:if>
				</div>
			</div>
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">지원자유형</th>
							<th scope="col">장학금유형</th>
							<th scope="col">지원대상</th>
							<th scope="col">신청일</th>
							<th scope="col">선발방법</th>
							<th scope="col">선발시기</th>
							<th scope="col">재원</th>
							<th scope="col">지급일</th>
							<th scope="col">지급금액</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.regDt}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${no}" /></td>
							<td><c:out value="${empty result.ntkrdfUnqNo ? '제3국출생' : '북한이탈주민' }" /></td>
							<td>
								<c:choose>
									<c:when test="${result.sholSlctnType == 'ntkrdf1' || result.sholSlctnType == 'thirdcnty1'}"><c:set var="sholSlctnName" value="대학원생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_1' || result.sholSlctnType == 'thirdcnty2_1'}"><c:set var="sholSlctnName" value="대학생(연속지원)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_2' || result.sholSlctnType == 'thirdcnty2_2'}"><c:set var="sholSlctnName" value="대학생(1회지원)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_3' || result.sholSlctnType == 'thirdcnty2_3'}"><c:set var="sholSlctnName" value="대학생(전문대)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf2_4' || result.sholSlctnType == 'thirdcnty2_4'}"><c:set var="sholSlctnName" value="대학생(사이버/방송/통신대)" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf3' || result.sholSlctnType == 'thirdcnty3'}"><c:set var="sholSlctnName" value="계절학기 수강생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf4_1' || result.sholSlctnType == 'thirdcnty4_1'}"><c:set var="sholSlctnName" value="중학생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf4_2' || result.sholSlctnType == 'thirdcnty4_2'}"><c:set var="sholSlctnName" value="고등학생" /></c:when>
									<c:when test="${result.sholSlctnType == 'ntkrdf5' || result.sholSlctnType == 'thirdcnty5'}"><c:set var="sholSlctnName" value="검정고시 합격생" /></c:when>
								</c:choose>
								<c:out value="${sholSlctnName }" />
							</td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.sprtSn}" />');return false;"><c:out value="${result.flnm}" /></a></td>
							<td><fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td><c:out value="${jtag:getCdNm(slctnMthdCdList,result.slctnMthdCd) }" /></td>
							<td><c:out value="${jtag:getCdNm(slctnMmtCdList,result.slctnMmtCd) }" /></td>
							<td><c:out value="${jtag:getCdNm(fncrscCdList,result.fncrscCd) }" /></td>
							<td><c:out value="${jtag:convertDateSplitString(result.giveYmd,'-')}" /></td>
							<td><fmt:formatNumber value="${result.sholGiveAmt}" /></td>
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
