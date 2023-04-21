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
	
	pageContext.setAttribute("lf", "\r");
%>
<%--
<%//write.jsp 참고%>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="?">
--%>
<script>
function fnUserInfoPop(mbrId){
	var url = '/exts/com/mbr/index.do?searchCondition=&searchKeyword=&pageIndex=1&commMode=view&mbrId='+mbrId;
	var name = '사용자 정보 확인';
	
	var width = 1000;
	var heigth = 600;
	var popupX = (document.body.offsetWidth / 2) - (width / 2);
	var popupY = (window.screen.height / 2) - (heigth / 2);
	var options = 'status=no,scrollbars=no,menubar=no,toolbar=no,location=no,height='+heigth+',width='+width+',left='+popupX+',top='+popupY;
	window.open(url, name, options);
}
</script>
<c:url value="/board/board.do" var="actionUrl"/>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="${actionUrl }">
<input type="hidden" id="retUrl" name="retUrl" value="${retUrl }" />
<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />
<input type="hidden" name="mode" value="<c:out value="${param.mode}"/>" />
<input type="hidden" name="cntId" value="<c:out value="${param.cntId}"/>" />

<div class="board_view">
  <div class="board_v_t">
    <p class="title"><c:if test="${result.isdel == 1 }">(삭제글) </c:if><c:out value="${result.title}" /></p>
    <p class="board_v_s_info">
    	<b>문의 구분</b><span><c:out value="${result.ext01}" /></span>
    	<b>문의 유형</b><span><c:out value="${result.ext02}" /></span>
    	<c:if test="${isAdmin == true && not empty result.ext03}">
    		<b>담당자</b><span><c:out value="${result.ext03}" /></span>
    	</c:if>
   		<b>작성자</b>
   		<c:choose>
      		<c:when test="${isAdmin == true }"><span onclick="fnUserInfoPop('<c:out value="${result.mbrId }" />');return false;"><c:out value="${result.writer}" /></span></c:when>
      		<c:otherwise><span><c:out value="${result.writer}" /></span></c:otherwise>
      	</c:choose>
    	
      <b>문의 등록일</b><span><fmt:formatDate value="${result.created}" pattern="yyyy-MM-dd" /></span>
    </p>
    <div class="board_v_rcsitu">
    <div class="${result.ext04 != '신청' ? 'b_situ_01' : 'b_situ_04' }"><c:out value="${result.ext04 }" /></div>
      <!--<div class="b_situ_02">모집중</div>-->
      <!--<div class="b_situ_03">모집완료</div>-->
      <!--<div class="b_situ_04">답변완료</div>-->
    </div>
  </div>
  <div class="board_v_con">
    <div class="contents">
    	<strong>[문의]</strong><br />
		<c:if test="${result.isHtml == 1}">
			<c:out value="${result.content}" escapeXml="false" />			
		</c:if>
		<c:if test="${result.isHtml == 0}">
			<c:out value="${fn:replace(result.content,lf,'<br />')}" escapeXml="false" />				
		</c:if>
    </div>
  </div>
  
  <c:if test="${not empty result.ext05 }">
	  <div class="board_v_con">
	  	<div class="contents">
	  		<strong>[답변]</strong><br />
			<c:out value="${fn:replace(result.ext05,lf,'<br />')}" escapeXml="false" />				
	    </div>
	  </div>
  </c:if>
  
  <%-- <c:if test="${fn:length(inquiryList) > 0 }">
  	<div class="board_comment">
	  <c:forEach var="result" items="${inquiryList}" varStatus="status">
	  	<div class="comment_g">
	  	  <p class="b_tit">답변내용
	        <span class="date">
	          <b>답변 등록일</b>
	          	<span>
	          		<fmt:parseDate var="dateFmt" value="${result.created}" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${dateFmt }" pattern="yyyy-MM-dd" />
				</span>
	        </span>
	      </p>
	      <div class="comment_g_con">
				<c:out value="${fn:replace(result.searchext05,lf,'<br />')}" escapeXml="false" />				
	      </div>
	      <div class="btn_g_btm AlignCenter">
				<c:if test="${result.mbrId == loginVO.mbrId || isAdmin == true}">
					<a id="linkEdit" class="btn_st btn_c_bl" href="?boardId=${boardinfoVO.boardId}&amp;mode=edit&amp;cntId=${result.id}&amp;pid=<c:out value="${param.cntId}" />&amp;pageIdx=<c:out value="${param.pageIdx}" />"><%= JnitboardController.isLanguage("수정",lang) %></a>
					<c:if test="${result.isdel == 0 || result.isdel == 2}">
				    	<a id="linkDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;pid=<c:out value="${param.cntId}" />&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("삭제",lang) %></a>
				    </c:if>
				    <c:if test="${isAdmin }">
				    	<a id="linkAllDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=allDelete&amp;cntId=${result.id}&amp;pid=<c:out value="${param.cntId}" />&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("삭제",lang) %></a>
				    </c:if>	    
				</c:if>
			    <c:if test="${isAdmin == true}">
				    <c:if test="${result.isdel == 1}">
				    <a id="linkRecovery" class="btn_st" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=recovery&amp;cntId=${result.id}&amp;pid=<c:out value="${param.cntId}" />&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("복구",lang) %></a>
				    </c:if>
				</c:if>   
			</div>
	    </div>
		</c:forEach>
		</div>
	</c:if> --%>
</div>
<div class="btn_g_btm AlignCenter">
	<c:if test="${isAdmin == true}"><%--답변이 관리자 전용 --%>
		<a id="linkEdit" class="btn_st btn_c_bl" href="?boardId=${boardinfoVO.boardId}&amp;mode=edit&amp;cntId=${result.id}&amp;pageIdx=<c:out value="${param.pageIdx}" />"><%= JnitboardController.isLanguage("수정",lang) %></a>
		
		<%-- <c:if test="${result.isNotice == '0'}">
			<c:if test="${permReply == true || isAdmin == true }">
				<c:if test="${boardinfoVO.useReply == '1' }">
					<a id="linkReply" class="btn_st btn_c_gr" href="?boardId=${boardinfoVO.boardId}&amp;mode=write&amp;cntId=${result.id}"><%= JnitboardController.isLanguage("답변",lang) %></a>
				</c:if>
			</c:if>
		</c:if> --%>
		
		<c:if test="${result.isdel == 0 }">
			<a id="linkDelete" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=delete&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("삭제",lang) %></a>
		</c:if>
		<c:if test="${result.isdel == 1 }">
			<a id="linkRecovery" class="btn_st btn_c_re" href="?boardId=${boardinfoVO.boardId}&amp;mode=proc&amp;proc=recovery&amp;cntId=${result.id}&amp;retUrl=${retUrl}"><%= JnitboardController.isLanguage("복구",lang) %></a>
		</c:if>
	</c:if>
	<a class="btn_st" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=list&category=${jtag:encodeUrl(result.category)}&pageIdx=${param.pageIdx}&searchext01=${param.searchext01 }&searchext02=${param.searchext02 }&searchext03=${param.searchext03 }&searchext04=${param.searchext04 }&searchext18=${param.searchext18 }&searchext19=${param.searchext19 }&createdStartDate=${param.createdStartDate }&createdEndDate=${param.createdEndDate }&pageIdx=${param.pageIdx}&searchCondition=koreahanaAll&searchKeyword=koreahanaAll" />">목록으로</a>
</div>
</form:form>

