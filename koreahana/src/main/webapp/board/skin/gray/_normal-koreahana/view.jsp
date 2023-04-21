<%
/**
 *@version 3.2.0.1
 **/
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/jnit/board/header.jsp" %>
<%@ page import="jnit.board.BoardSession" %>
<%
	BoardSession.initBoardSession();		//게시판 세션 초기화
	BoardSession.setBoardSession();			//게시판 세션 생성 ( info : boardId, useSkeleton, fixedCategory, customSkin, customCss jsp:param 데이터를 담는다.)
%>
<%--
<%//write.jsp 참고%>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="?">
--%>
<c:url value="/board/board.do" var="actionUrl"/>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="${actionUrl }">
	<input type="hidden" id="retUrl" name="retUrl" value="${retUrl }" />
	<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />
	<input type="hidden" name="mode" value="<c:out value="${param.mode}"/>" />
	<input type="hidden" name="cntId" value="<c:out value="${param.cntId}"/>" />
	
	<div class="board_view">
		<div class="board_v_t">
			<p class="title">
				<c:if test="${isAdmin == true && result.isdel == 1}">(<%= JnitboardController.isLanguage("삭제글",lang) %>)</c:if>
				<c:out value="${result.title}" /></p>
			<p class="board_v_s_info">
				<b>등록일</b><span><fmt:formatDate value="${result.created}" pattern="yyyy-MM-dd" /></span>
				<span class="bar"></span>
				<b>조회수</b><span><fmt:formatNumber value="${result.hit}" /></span>
			</p>
		</div>
		<div class="board_v_con">
			<div class="contents">
				<%-- <c:out value="${fn:replace(result.content, lf, '<br />')}" escapeXml="false" /> --%>
				
				<c:if test="${result.isHtml == 1}">				
					<c:out value="${result.content}" escapeXml="false" />			
				</c:if>
				<c:if test="${result.isHtml == 0}">
					<c:out value="${fn:replace(result.content,lf,'<br />')}" escapeXml="false" />				
				</c:if>
			</div>
		</div>
		<c:if test="${not empty fileList && boardinfoVO.useFile != 0 || !empty mainFileVO }" >
			<div class="board_v_file">
				<c:forEach var="bbsfile" items="${fileList}" varStatus="status">
					<c:if test="${fn:contains(bbsfile.fileUrl, '.')}">
						<c:set var="fileUrl" value="${fn:split(bbsfile.fileUrl,'.')}" />
					</c:if>
					<c:if test="${!status.first }"><br /></c:if>
					<p class="file">
						<a href="javascript:Jnit_boardDownload('<c:url value="${fileUrl[0]}"/>','<c:url value="/board/ajax/file/downloadCount.do?fileId=${bbsfile.fileId }"/>','${status.count }');" target="_self">
							<c:out value="${bbsfile.fileOnm}"/>
						</a>
					</p>
				</c:forEach>
			</div>
		</c:if>
	</div>
	
	<c:if test="${boardinfoVO.useCmt == 1}" >
		<input type="hidden" id="boarcmtUrl" value="<c:url value='/board/ajax/cmt.do'/>"/>
		<div id="Jnit_boardCmt"></div>
		<c:if test ="${permCmt}" >	
			<table class="bbsCmt table table-bordered" summary="<c:out value="${boardinfoVO.boardTitle}" /><%= JnitboardController.isLanguage("의 덧글입력 테이블입니다.",lang) %>">	
				<caption><c:out value="${boardinfoVO.boardTitle}" /> <%= JnitboardController.isLanguage("덧글 입력",lang) %></caption>
				<tbody>
					<tr>
						<td class="cmt_text"><textarea id="cmtsubmit_text" name="cmtsubmit_text" class="content content input-xxlarge" rows="2" required onKeyUp="javascript:fnByte(this,'2000','cmt')"></textarea><span id="byteInfo_cmt">0</span>/2000Byte</td>
						<td class="cmt_btn"><a href="javascript:Jnit_boardCmtAdd('<c:url value='/board/ajax/cmt.do'/>');" ><%= JnitboardController.isLanguage("등록",lang) %></a></td>
					</tr>
				</tbody>
			</table>
		</c:if>
	</c:if>
	
	<!-- 검색조건 유지 -->
	<input type="hidden" name="searchCondition" value="<c:out value='${param.searchCondition}'/>"/>
	<input type="hidden" name="searchKeyword" value="<c:out value='${param.searchKeyword}'/>"/>
	<input type="hidden" name="pageIdx" id="pageIdx"  value="<c:out value="${param.pageIdx}"/>" />
</form:form>

<div class="btn_g_btm">
	<c:if test="${isAdmin == true || isMine == true}">
	<a id="linkEdit" class="btn_st btn_c_big btn_c_or" href="?boardId=${boardinfoVO.boardId}&amp;mode=edit&amp;cntId=${result.id}&amp;pageIdx=<c:out value="${param.pageIdx}" />"><%= JnitboardController.isLanguage("수정",lang) %></a>
	
	<c:if test="${result.isdel == 0 || result.isdel == 2}">
	    <c:choose>
	    	<c:when test="${isAdmin == true}">
			    <a id="linkDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("삭제",lang) %></a>
	    	</c:when>
	    	<c:when test="${isAdmin != true && loginVO.mbrId != null}">
	    		<c:if test="${result.mbrId != null}">
	    			<a id="linkDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("삭제",lang) %></a>
	    		</c:if>
			    <c:if test="${result.mbrId == null}">
			    	<a id="deletebtn" class="btn_st btn_c_re" href="#none;" onclick="return false;"><%= JnitboardController.isLanguage("삭제",lang) %></a>
				    <span id="yourInput" style="display: none;">
				    	<input type="password" id="yourinput" name="yourinput"/>
				    	<a id="linkDelete" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;retUrl=${retUrl}" class="btn_st btn_c_re"><%= JnitboardController.isLanguage("확인",lang) %></a>
				    	<a id="deleteCancle" href="#none;" class="btn_st btn_c_big" onclick="return false;"><%= JnitboardController.isLanguage("취소",lang) %></a>
				    </span>
			    </c:if>
	    	</c:when>
	    	<c:when test="${isAdmin != true && loginVO.mbrId == null}">
				<a id="deletebtn" class="btn_st btn_c_re" href="#none;" onclick="return false;"><%= JnitboardController.isLanguage("삭제",lang) %></a>
			    <span id="yourInput" style="display: none;">
			    	<input type="password" id="yourinput" name="yourinput"/>
			    	<a id="linkDelete" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;retUrl=${retUrl}" class="btn_st btn_c_re"><%= JnitboardController.isLanguage("확인",lang) %></a>
			    	<a id="deleteCancle" href="#none;" class="btn_st btn_c_re" onclick="return false;"><%= JnitboardController.isLanguage("취소",lang) %></a>
			    </span>
	    	</c:when>
	    </c:choose>
    </c:if>
    
    <%--
    <c:if test="${isAdmin }">
		<a id="linkAllDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=allDelete&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("영구삭제",lang) %></a>
    </c:if>
    --%>
        
	</c:if>
    <c:if test="${isAdmin == true}">
	    <c:if test="${result.isdel == 1}">
	    <a id="linkRecovery" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=recovery&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("복구",lang) %></a>
	    </c:if>
	</c:if>   
	<a class="btn_st btn_c_big" href="?boardId=${boardinfoVO.boardId}&amp;mode=list&amp;category=${category}&amp;pageIdx=<c:out value="${param.pageIdx}" />"><%= JnitboardController.isLanguage("목록",lang) %></a> 
</div>