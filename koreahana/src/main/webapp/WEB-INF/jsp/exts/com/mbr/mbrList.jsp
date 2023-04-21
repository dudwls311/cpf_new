<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/com/mbr/mbrList.js"></script>
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).values()" var="enumMbrTypes" /> 
<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="commMode" name="commMode" value="" />
	<input type="hidden" id="mbrId" name="mbrId" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="selectCondition" name="selectCondition" value="<c:out value="${searchVO.selectCondition }" />" />
	<input type="hidden" id="typeId" name="typeId" value="<c:out value="${searchVO.typeId }" />" />
	<input type="hidden" id="orgId" name="orgId" value="<c:out value="${searchVO.orgId }" />" />
</form>
			<form action="?">
			
		<div class="box_w_gray">
			<div class="search_wrap">
				<div class="search_left">
					<label for="selectCondition">상태</label>
					<select id="selectCondition" name="selectCondition" class="st_select">
						<option value="0">전체</option>
						<option value="1"${param.selectCondition == '1'?' selected="selected"':'' }>활성화</option>
						<option value="2"${param.selectCondition == '2'?' selected="selected"':'' }>비활성화</option>
						<option value="3"${param.selectCondition == '3'?' selected="selected"':'' }>로그인차단</option>
					</select>
					<label for="typeId">권한구분</label>
					<select id="typeId" name="typeId" class="st_select">
						<option value="">전체</option>
					<c:forEach items="${enumMbrTypes }" var="mbrType"><c:if test="${isAdmin || loginVO.typeId == mbrType.code }">
						<option value="${mbrType.code }"${param.typeId == mbrType.code?' selected':'' }><c:out value="${mbrType.name}" /></option>
					</c:if></c:forEach>
					</select>
					<label for="orgId">소속</label>
					<select id="orgId" name="orgId" class="st_select">
						<option value="">전체</option>
					<c:forEach items="${orgList }" var="org"><c:if test="${isAdmin || loginVO.orgId == org.orgId }">
						<option value="${org.orgId }"${param.orgId == org.orgId?' selected':'' }><c:out value="${org.orgNm}" /></option>
					</c:if></c:forEach>
					</select>
				</div>
				<div class="search_right">
					<label for="searchKeyword" class="comment">검색어 입력</label>
					<input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="st_input" placeholder="사용자 이름,ID로 검색"/>
					<input type="hidden" name="searchCondition" value="0" />
					<button type="submit" class="btn-input-search">조회</button>
				</div>
			</div>
		</div>
			</form>
			<div class="con_b_tp">
				<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
				<%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %>
			</div>

				<!-- 필요시 exceltemplate 추가 후 주석 제거 -->
				<!-- <div class="btn_right_hd">
					<button class="btn_bdgreen_25" type="button" onclick="ComFns.excelDownload()">엑셀저장</button>
				</div> -->
				
				<table class="table_style thd_v_m">
					<thead>
						<tr>
							<th scope="col">등록일</th>
							<th scope="col">권한구분</th>
							<th scope="col">소속</th>
							<th scope="col">이름</th>
							<th scope="col">아이디</th>
							<th scope="col">상태</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="now" value="<%=new java.util.Date() %>" />
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<fmt:formatDate var="regDt" value="${result.created}" pattern="yyyy-MM-dd" />
						<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
						<tr>
							<td><c:out value="${regDt}" /></td>
							<td><c:forEach items="${enumMbrTypes }" var="mbrType"><c:if test="${result.typeId == mbrType.code }"><c:out value="${mbrType.name}" /></c:if></c:forEach></td>
							<td><c:forEach items="${orgList }" var="org"><c:if test="${result.orgId == org.orgId }"><c:out value="${org.orgNm}" /></c:if></c:forEach></td>
							<td><a href="#" onclick="javascript:fnView('<c:out value="${result.mbrId}" />');return false;"><c:out value="${result.mbrNm}" /></a></td>
							<td><c:out value="${result.mbrLogin}" /></td>
							<td>
							<c:choose>
								<c:when test="${result.pwMiscnt > searchVO.ex01 }">
									로그인차단
								</c:when>
								<c:when test="${!empty result.expireDate && now > result.expireDate }">
									비활성화
								</c:when>
								<c:otherwise>
									활성화
								</c:otherwise>
							</c:choose>
							</td>
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
