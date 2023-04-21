<%
/**
 *@version 3.2.0.1
 **/
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/jnit/board/header.jsp" %>
<form:form commandName="searchVO" name="bbsForm" id="bbsForm" method="get">
	<input type="hidden" name="mode" value="<c:out value="${mode}" />" />
	<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />
	<input type="hidden" name="pageIdx" id="pageIdx"  value="<c:out value="${param.pageIdx}"/>" />
	
	<div class="con_b_tp">
		<p class="b_total FloatLeft">총<span> <fmt:formatNumber value="${totCnt}" /> </span>건</p>
		
		<c:if test="${boardinfoVO.hideWrite != 0 || permWrite}">
			<div class="FloatRight"><a class="btn_st btn_c_bk" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=write&category=${category}" />" >등록</a></div>
		</c:if>
		
		<div class="FloatRight MAR10">
			<input type="hidden" name="searchCondition" value="all" />
			<input type="text" name="searchKeyword" id="searchKeyword" class="st_input MAL10 PAR25" value="<c:out value="${searchVO.searchKeyword }" />" placeholder="제목 또는 내용으로 검색"/>
			<button type="submit" class="ico_search"><span class="comment">검색</span></button>
		</div>
	</div>
	
	<div class="faq_board">
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<div class="faq_box">
				<input type="checkbox" id="<c:out value="faq_${status.count }" />" name="faq" value=""/>
				<label for="<c:out value="faq_${status.count }" />">
					<span class="b_type">Q.</span>
					<p class="title">
						<c:if test="${isAdmin == true && result.isdel == 1}"><span class="delArticle" style="font-weight: bold;">(<%= JnitboardController.isLanguage("삭제글",lang) %>)</span></c:if>
						<c:out value="${result.title }" />
						<c:if test="${isAdmin == true || isMine == true}">
							<a class="btn_st btn_c_big btn_c_or FloatRight" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=view&cntId=${result.id}&category=${jtag:encodeUrl(result.category)}&pageIdx=${param.pageIdx}" />" >관리</a>
						</c:if>
					</p>
				</label>
				<div class="faq_b_anw">
					<span class="b_type">A.</span>
					<p class="coment">
						<c:if test="${result.isHtml == 1}">				
							<c:out value="${contentMap.get(result.id)}" escapeXml="false" />			
						</c:if>
						<c:if test="${result.isHtml == 0}">
							<c:out value="${fn:replace(contentMap.get(result.id),lf,'<br />')}" escapeXml="false" />				
						</c:if>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="con_b_bt AlignCenter on">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="jnitBoardPage"   />
			</ul>
		</div>
	</div>
</form:form>