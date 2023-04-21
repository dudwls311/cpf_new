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
	
	<table class="table_style thd_v_m" summary="<c:out value="${boardinfoVO.boardTitle}" /> <%= JnitboardController.isLanguage("의 게시글 목록으로",lang) %><c:forEach var="k" items="${sIdx}" varStatus="status"><c:out value="${lbl[k]}" /><c:out value="${status.last ? '' : ','}" /></c:forEach> <%= JnitboardController.isLanguage("로 구성되어 있습니다.",lang) %>">
		<caption><c:out value="${boardinfoVO.boardTitle}" /></caption>
		<colgroup>
			<col width="5%" />
			<col width="*" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<c:forEach var="k" items="${sIdx}" varStatus="status">
				<th scope="col" class="${k}<c:out value="${k == 'no' ? ' hidden-phone' : k == 'created' ? ' hidden-phone' : k == 'hit' ? ' hidden-phone' : ''}" /><c:out value="${status.first ? ' start' : status.last ? ' end' : ''}" />"><c:out value="${lbl[k]}" /></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${noticeList}" varStatus="status">
				<tr>
					<c:forEach var="k" items="${sIdx}" varStatus="s">
						<td class="notice ${k}<c:out value="${k == 'no' ? ' hidden-phone' : k == 'created' ? ' hidden-phone' : k == 'hit' ? ' hidden-phone' : ''}" /><c:out value="${s.first ? ' start' : s.last ? ' end' : ''}" />" style="${k == 'title' ? 'text-align: left;' : ''}">
						<c:choose>
						<%--hit--%>
						<c:when test="${k == 'no'}">
							<c:if test="${result.isNotice == 1}"><b class="txt_c_re"><%= JnitboardController.isLanguage("공지",lang) %></b></c:if><c:if test="${result.isNotice == 0}"><c:out value="${startNum-status.index}" /></c:if>
						</c:when>
						<%--title--%>
						<c:when test="${k == 'title'}">
							<c:if test="${not empty result.idx && result.idx != ''}"><span class="replyArtile depth<c:out value="${fn:length(result.idx)}" />"><img src="/resources/img/replace_icon.gif" alt="<%= JnitboardController.isLanguage("답변 게시물",lang) %>" /></span></c:if>
							<c:if test="${isAdmin == true && result.isdel == 1}"><span class="delArticle">(<%= JnitboardController.isLanguage("삭제글",lang) %>)</span></c:if>
							<c:choose>						
								<c:when test="${result.isdel == 2}">
								(<%= JnitboardController.isLanguage("이동된 글",lang) %>)<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}" ><c:out value="${result.title}" /></a>
								</c:when>						
								<c:when test="${result.isSecret == 1}"><!-- 비밀글 -->
									<span class="secretArticle"><img src="<c:url value="/resources/img/lock_icon.gif"/>" alt="<%= JnitboardController.isLanguage("비밀 게시물",lang) %>" /></span>
									<c:if test="${result.mbrId == null || loginVO.mbrId == null}"><!-- 비회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
									<c:if test="${result.mbrId != null &&  loginVO.mbrId != null}"><!-- 회원글 -->
										<c:if test="${result.mbrId == loginVO.mbrId || isAdmin == true}">
											<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
												<c:out value="${result.title}" />
											</a>
										</c:if>
										<c:if test="${result.mbrId != loginVO.mbrId && isAdmin == false}">
												<c:out value="${result.title}" />
										</c:if>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${result.mbrId == null || result.mbrId == ''}"><!-- 비회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
									<c:if test="${result.mbrId != null && result.mbrId != ''}"><!-- 회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
								</c:otherwise>
							</c:choose>
							${jtag:makeIconImg(boardinfoVO, result)}				
						</c:when>					
						<c:when test="${k == 'file'}">
							<c:choose>
							<c:when test="${!empty boardFileMap[result.id]}">						
								<c:forEach var="resultfile" items="${boardFileMap[result.id]}" varStatus="status2">																															
									<span class="list_file">
										<a href="javascript:Jnit_boardDownload('<c:url value="${resultfile.fileUrl}"/>','<c:url value="/board/ajax/file/downloadCount.do?fileId=${resultfile.fileId }"/>','${status.count }');" target="_self">
											<img src="<c:url value="/board/_common/img/icon_${fn:toLowerCase(boardFileType[resultfile.fileId] == 'jpeg' ? 'jpg' :  boardFileType[resultfile.fileId])}.png" />" alt="<c:out value="${resultfile.fileOnm}"/> <%= JnitboardController.isLanguage("파일 다운로드",lang) %>" />
										</a>
									</span>
								</c:forEach>
							</c:when>
							</c:choose>
						</c:when>
						<%--writer--%>
						<c:when test="${k == 'writer'}">
							<c:choose>
							<c:when test="${result.isSecret == 1 && (result.mbrId != loginVO.mbrId && not isAdmin )}">
								<c:out value="${fn:substring(result.writer,0,fn:length(result.writer)-1)}" />*
							</c:when>
							<c:otherwise>
								<c:out value="${result.writer}" />
							</c:otherwise>
							</c:choose>
						</c:when>
						<%--created--%>
						<c:when test="${k == 'created'}">
							<fmt:parseDate var="dateFmt" value="${result.created}" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${dateFmt }" pattern="yyyy-MM-dd" />
							<%-- <c:out value="${dateFmt }" /> --%>
						</c:when>
						<%--기본--%>
						<c:otherwise>
							<c:out value="${result[k]}" />
						</c:otherwise>
						</c:choose>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<c:forEach var="k" items="${sIdx}" varStatus="s">
						<td class="${k}<c:out value="${k == 'no' ? ' hidden-phone' : k == 'created' ? ' hidden-phone' : k == 'hit' ? ' hidden-phone' : ''}" /><c:out value="${s.first ? ' start' : s.last ? ' end' : ''}" />" style="${k == 'title' ? 'text-align: left;' : ''}">
						<c:choose>
						<%--hit--%>
						<c:when test="${k == 'no'}">
							<c:if test="${result.isNotice == 1}"><b class="txt_c_re"><%= JnitboardController.isLanguage("공지",lang) %></b></c:if><c:if test="${result.isNotice == 0}"><c:out value="${startNum-status.index}" /></c:if>
						</c:when>
						<%--title--%>
						<c:when test="${k == 'title'}">
							<c:if test="${not empty result.idx && result.idx != ''}"><span class="replyArtile depth<c:out value="${fn:length(result.idx)}" />"><img src="/resources/img/replace_icon.gif" alt="<%= JnitboardController.isLanguage("답변 게시물",lang) %>" /></span></c:if>
							<c:if test="${isAdmin == true && result.isdel == 1}"><span class="delArticle">(<%= JnitboardController.isLanguage("삭제글",lang) %>)</span></c:if>
							<c:if test="${result.tmp3 == '1'}"><%--최근게시물 체크된 글<img src="<c:url value="/board/_common/img/new_icon.gif" />" alt="" /> --%></c:if>
							<c:choose>						
								<c:when test="${result.isdel == 2}">
								(<%= JnitboardController.isLanguage("이동된 글",lang) %>)<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}" ><c:out value="${result.title}" /></a>
								</c:when>						
								<c:when test="${result.isSecret == 1}"><!-- 비밀글 -->
									<span class="secretArticle"><img src="<c:url value="/resources/img/lock_icon.gif"/>" alt="<%= JnitboardController.isLanguage("비밀 게시물",lang) %>" /></span>
									<c:if test="${result.mbrId == null || loginVO.mbrId == null}"><!-- 비회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
									<c:if test="${result.mbrId != null &&  loginVO.mbrId != null}"><!-- 회원글 -->
										<c:if test="${result.mbrId == loginVO.mbrId || isAdmin == true}">
											<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
												<c:out value="${result.title}" />
											</a>
										</c:if>
										<c:if test="${result.mbrId != loginVO.mbrId && isAdmin == false}">
												<c:out value="${result.title}" />
										</c:if>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${result.mbrId == null || result.mbrId == ''}"><!-- 비회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
									<c:if test="${result.mbrId != null && result.mbrId != ''}"><!-- 회원글 -->
										<a href="?boardId=${boardinfoVO.boardId}&amp;mode=view&amp;cntId=${result.id}&amp;category=${jtag:encodeUrl(result.category)}&amp;pageIdx=<c:out value="${param.pageIdx}" />" >
											<c:out value="${result.title}" />
										</a>
									</c:if>
								</c:otherwise>
							</c:choose>
							
							${jtag:makeIconImg(boardinfoVO, result)}
						</c:when>
						<c:when test="${k == 'file'}">
							<c:choose>						
							<c:when test="${!empty boardFileMap[result.id]}">						
								<c:forEach var="resultfile" items="${boardFileMap[result.id]}" varStatus="status2">																															
									<span class="list_file">
										<a href="javascript:Jnit_boardDownload('<c:url value="${resultfile.fileUrl}"/>','<c:url value="/board/ajax/file/downloadCount.do?fileId=${resultfile.fileId }"/>','${status.count }');" target="_self">
											<img src="<c:url value="/board/_common/img/icon_${boardFileType[resultfile.fileId] == 'jpeg' ? 'jpg' :  boardFileType[resultfile.fileId] }.png" />" alt="<c:out value="${resultfile.fileOnm}"/> <%= JnitboardController.isLanguage("파일 다운로드",lang) %>" />
										</a>
									</span>
								</c:forEach>
							</c:when>
							</c:choose>
						</c:when>
						<%--writer--%>
						<c:when test="${k == 'writer'}">
							<c:choose>
							<c:when test="${result.isSecret == 1 && (result.mbrId != loginVO.mbrId && not isAdmin )}">
								<c:out value="${fn:substring(result.writer,0,fn:length(result.writer)-1)}" />*
							</c:when>
							<c:otherwise>
								<c:out value="${result.writer}" />
							</c:otherwise>
							</c:choose>
						</c:when>
						<%--created--%>
						<c:when test="${k == 'created'}">
							<fmt:parseDate var="dateFmt" value="${result.created}" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${dateFmt }" pattern="yyyy-MM-dd" />
							<%-- <c:out value="${dateFmt }" /> --%>
						</c:when>
						<%--기본--%>
						<c:otherwise>
							<c:out value="${result[k]}" />
						</c:otherwise>
						</c:choose>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>		
			<c:if test="${empty resultList && empty noticeList}">
				<tr>
					<td colspan="<c:out value="${fn:length(sIdx)}" />" class="nodata">					
						<%= JnitboardController.isLanguage("조회된 게시물이 없습니다.",lang) %>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<div class="con_b_bt AlignCenter on">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="jnitBoardPage"   />
			</ul>
		</div>
	</div>
</form:form>