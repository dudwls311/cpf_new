<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/exts/koreahana/com/header_inc.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sgn/sgnList.js"></script>

<input type="hidden" id="actionUrl" value="<c:url value="/user/exts/koreahana/sgn/index.do" />" />
<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="ksMode" name="ksMode" value="" />
	<input type="hidden" id="sgntSn" name="sgntSn" value="" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<h4 class="tit">서명관리<%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %></h4>
	<div class="board_list">
	<div class="list_type_3 sign_c_list">
		<ul>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<li>
					<a class="sign_c_btn">
						<p class="sign"><img src="<c:url value="/user/exts/koreahana/sgn/index.do?ksMode=sgnView&enc=${jtag:sprtFileViewEncode(result.atchFileSn, '')}" />" alt="<c:out value="${result.sgntNm } 이미지" />" /></p>
						<p class="name AlignCenter">
						<button type="button" onclick="fnMainChange('<c:out value="${result.sgntSn }" />');return false;" class="btn_star <c:out value="${result.sgntFavoYn == 'Y' ? 'on' : '' }" />"><i></i><span class="comment">기본서명</span></button>
						<c:out value="${result.sgntNm }" />
						<button type="button" class="btn_st btn_c_wh btn_s_sml FloatRight" onclick="fnDelete('<c:out value="${result.sgntSn }" />');return false;">삭제</button>
						</p>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>