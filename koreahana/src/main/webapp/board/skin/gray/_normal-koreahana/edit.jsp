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
	
	<input type="hidden" name="mode" value="proc" />
	<input type="hidden" name="proc" value="edit" />
	<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />
	<input type="hidden" name="cntId" value="<c:out value="${result.id}"/>" />
	<c:if test="${boardinfoVO.useCategory == '1' && not empty fixedCategory}">
	<input type="hidden" name="category" value="${fixedCategory}" />
	</c:if>
	<table class="table_style" summary="<c:out value="${boardinfoVO.boardTitle}" /><%= JnitboardController.isLanguage("에 글을 수정하기 위한 입력폼으로",lang) %> <c:if test="${boardinfoVO.useCategory == '1' && empty fixedCategory}"><c:out value="${lbl.category}" />, </c:if><c:if test="${boardinfoVO.useSecret == '1'}"><%= JnitboardController.isLanguage("비밀글 여부",lang) %>, </c:if><c:forEach var="k" items="${sIdx}" varStatus="s"><c:choose><c:when test="${k == 'writer' || k == 'hit'}"><c:if test="${isAdmin == true}"><c:out value="${f[k].lbl}" /></c:if></c:when><c:otherwise><c:out value="${f[k].lbl}" /></c:otherwise></c:choose><c:out value="${s.last ? '' : ','}" /></c:forEach><c:if test="${boardinfoVO.useFile == 1}">, <%= JnitboardController.isLanguage("첨부",lang) %></c:if> <%= JnitboardController.isLanguage("으로 구성되어 있습니다.",lang) %>">
		<caption><c:out value="${boardinfoVO.boardTitle}" /> <%= JnitboardController.isLanguage("수정폼",lang) %></caption>
		<tbody>
		
			<c:if test="${boardinfoVO.useCategory == '1' && empty fixedCategory}">
				<tr>
					<th><label for="category"><c:out value="${lbl.category}" /></label></th>
					<td><select name="category" class="category" title="<c:out value="${lbl['category']}" /> <%= JnitboardController.isLanguage("선택",lang) %>">
							<option value=""><%= JnitboardController.isLanguage("전체",lang) %></option>
							<c:forEach var="category" items="${categoryList}" varStatus="status">
							<option value="<c:out value="${category}"/>" <c:out value="${result.category == category ? 'selected' : ''}"/>><c:out value="${category}"/></option>
							</c:forEach>
					</select></td>
				</tr>
			</c:if>
			
			<c:if test="${isAdmin == true && boardinfoVO.useLatestlist == '1' }">
				<tr>
					<th scope="row" style="width: 18%;"><label for="tmp3"></label><%= JnitboardController.isLanguage("최근게시물 표시",lang) %></th>
					<td><input type="checkbox" class="st_check" name="tmp3" id="tmp3" value="1" <c:out value="${result.tmp3 == '1' ? 'checked' : '' }"/>></td>
				</tr>
			</c:if>
			<c:if test="${isAdmin == true && boardinfoVO.useNotice == '1'}">
				<tr>
					<th style="width: 18%;"><%= JnitboardController.isLanguage("공지글",lang) %></th>
					<td style="text-align: left;"><input type="checkbox" class="st_check" name="isNotice" id="isNotice" value="1" <c:out value="${result.isNotice == '1' ? 'checked' : ''}"/>/><label for="isNotice"></label></td>
				</tr>
			</c:if>
			<c:if test="${boardinfoVO.useSecret == '1' && loginVO.mbrId != null}">
				<tr>
					<th style="width: 18%;"><label for="isSecret"><%= JnitboardController.isLanguage("비밀글",lang) %></label></th>
					<td><input type="checkbox" class="st_check" name="isSecret" id="isSecret" value="1" <c:out value="${result.isSecret == '1' ? 'checked' : ''}"/>/></td>
				</tr>
			</c:if>
			
			<c:forEach var="k" items="${sIdx}" varStatus="s">
				<c:choose>
				<%--no--%>
				<c:when test="${k == 'no'}">
				</c:when>
				<%--adminField--%>
				<c:when test="${k == 'writer' || k == 'hit'}">
				<c:if test="${isAdmin == true}">
				<tr>
					<th><label for="${k}"><c:out value="${f[k].lbl}" /></label></th>
					<td><input name="${k}" value="<c:out value="${result[k]}" />" id="${k}" class="st_input input_long ${k}" type="text" /></td>
				</tr>
				</c:if>
				</c:when>
				<%--created--%>
				<c:when test="${k == 'created'}">
				<c:if test="${isAdmin == true}">
				<tr>
					<th><label for="${k}"><c:out value="${f[k].lbl}" /></label></th>
					<td><input name="${k}" value="<fmt:formatDate value="${result[k]}" pattern="yyyy-MM-dd HH:mm:ss" />" id="${k}" class="st_input input_long ${k} datetime" type="text" data-datetype="yyyy-MM-dd hh:mm:ss" required/></td>
				</tr>
				</c:if>
				</c:when>
				<%--title--%>
				<c:when test="${k == 'title'}">
				<tr>
					<th style="width: 18%;"><label for="${k}"><c:out value="${f[k].lbl}" /></label></th>
					<td><input name="${k}" value="<c:out value="${result[k]}" />" id="${k}" class="st_input input_long ${k}" type="text" required/></td>
				</tr>
				<%--비회원작성자 --%>
				<c:if test="${boardinfoVO.anonPermWrite == '1' && isAdmin != true && isMine != true}">
				<tr>
					<th><label for="writer"><%= JnitboardController.isLanguage("작성자",lang) %></label></th>
					<td><input name="writer" value="<c:out value="${result.writer}" />" id="writer" class="input-xxlarge st_input input_long ${k}" required type="text" /></td>
				</tr>
				<tr>
					<th><label for="<%= JnitboardController.isLanguage("비밀번호",lang) %>"><%= JnitboardController.isLanguage("비밀번호",lang) %></label></th>
					<td><input name="password" value="" id="password" class="input-xxlarge st_input input_long ${k}" required type="password" /></td>
				</tr>
				</c:if>
				</c:when>
				<%--content--%>
				<c:when test="${k == 'content'}">
				<tr>
					<%-- <th><label for="${k}"><c:out value="${f[k].lbl}" /></label></th> --%>
					<td colspan="2" class="board_td_content">
						<c:if test="${boardinfoVO.useWyswyg != 1}">
							<textarea id="${k}" class="${k} content" rows="10" name="${k}" required><c:out value="${result[k]}" /></textarea>
						</c:if>
						<c:if test="${boardinfoVO.useWyswyg == 1}">
							<c:if test="${boardinfoVO.useImage == 1 && boardinfoVO.useWyswygType == 'tinymce'}">
								<div class="editTinymceImages"><a class="btn_st btn_c_gr" style="width: 100%;" href="javascript:Jnit_img_upload('<c:url value='/broad/pupup.do?boardId=${boardinfoVO.boardId }'/>');"><%= JnitboardController.isLanguage("사진업로드",lang) %></a></div>
							</c:if>
							<textarea id="Jnit_edit" name="content"><c:out value="${result.content }" escapeXml="false" /></textarea>
						</c:if>
					</td>
				</tr>
				</c:when>
				<%--기본--%>
				<c:otherwise>
				<tr>
					<th><label for="${k}"><c:out value="${f[k].lbl}" /></label></th>
					<td>
					<c:choose>
					<%--input--%>
					<c:when test="${f[k].type == 'input'}">
					<input name="${k}" id="${k}" value="<c:out value="${result[k]}" />" class="st_input input_long ${k}" type="text" <c:out value="${f[k].required?' required':''}"/>>
					</c:when>
					<c:when test="${f[k].type == 'email'}">
					<input name="${k}" id="${k}" value="<c:out value="${result[k]}" />" class="input-xxlarge st_input input_long boardEmail ${k} " type="text" <c:out value="${f[k].required?' required':''}"/>>
					</c:when>
					<%--textarea--%>
					<c:when test="${f[k].type == 'textarea'}">
					<textarea id="${k}" rows="10" name="${k}" class="${k}" <c:out value="${f[k].required?' required':''}"/>><c:out value="${result[k]}" /></textarea>
					</c:when>
					<%--address--%>
					<c:when test="${f[k].type == 'address'}">
					<input name="${k}" id="${k}" value="<c:out value="${result[k]}" />" class="address ${k}" type="text" <c:out value="${f[k].required?' required':''}"/>>
					<input name="tmpAddrDetail" id="tmpAddrDetail" value="" type="hidden">
					</c:when>
					<%--date--%>
					<c:when test="${f[k].type == 'date'}">
					<input name="${k}" id="${k}" value="<fmt:formatDate value="${result[k]}" pattern="yyyy-MM-dd" />" class="date ${k}" type="text" data-datetype="yyyy-MM-dd" <c:out value="${f[k].required?' required':''}"/>>
					</c:when>
					<%--datetime--%>
					<c:when test="${f[k].type == 'datetime'}">
					<input name="${k}" id="${k}" value="<fmt:formatDate value="${result[k]}" pattern="yyyy-MM-dd HH:mm:ss" />" class="datetime ${k}" type="text" data-datetype="yyyy-MM-dd HH:mm:ss" <c:out value="${f[k].required?' required':''}"/>>
					</c:when>
					<%--select--%>
					<c:when test="${f[k].type == 'select'}">
					<select name="${k}" id="${k}" class="${k}" >
							<c:forEach var="itm" items="${f[k].item}" varStatus="status">
							<option value="<c:out value="${itm}"/>" <c:out value="${result[k] == itm ? 'selected' : ''}"/>><c:out value="${itm}"/></option>
							</c:forEach>
					</select>
					</c:when>
					<c:when test="${f[k].type == 'check'}">
							<c:forEach var="itm" items="${f[k].item}" varStatus="status">
							<input type="checkbox" class="st_check" name="${k}" id="${k}" value="${itm}" <c:out value="${f[k].required?' required':''}"/> ><label for="${k}">${itm}</label>
							</c:forEach>
					</c:when>
					<c:otherwise>
					<input name="${k}" id="${k}" value="<c:out value="${result[k]}" />" class="st_input input_long ${k}" type="text" <c:out value="${f[k].required?' required':''}"/>>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${boardinfoVO.useFile == 1}">
			<tr>
				<th>
					<label><%= JnitboardController.isLanguage("첨부",lang) %></label>
					<span id="upfileAdd" class="btn_st btn_ico_pl"><a href="#none"></a></span>
					<span id="upfileDel" class="btn_st btn_ico_mn"><a href="#none"></a></span>
				</th>
				<td>
					<c:if test="${not empty fileList}" >
						<div id="files_list">
						<c:forEach var="bbsfile" items="${fileList}" varStatus="status">
							<span class="file">
								<label for="delFile" class="blind">
									<a href="<c:url value="${bbsfile.fileUrl }"/>" target="_blank"><c:out value="${bbsfile.fileOnm}"/></a>
								</label>
								<input type="checkbox" id="delFile" name="delFile" value="<c:out value="${bbsfile.fileId}"/>" />
								<%= JnitboardController.isLanguage("삭제",lang) %> (<img src="<c:url value="/board/_common/img/icoFile2.gif" />" alt="<%= JnitboardController.isLanguage("파일삭제",lang) %>" /><c:out value="${bbsfile.fileOnm}"/>)
							</span>
							<br />
						</c:forEach>
						</div>
					</c:if>
					<div class="upfileWrap">
						<div class="upfileElem">
							<label for="upfile1" class="blind"><%= JnitboardController.isLanguage("파일",lang) %></label>
							<input type="file" id="upfile1" name="upfile1">
						</div>
					</div>
				</td>
			</tr>
			</c:if>
		</tbody>
	</table>
	
	<c:if test="${boardinfoVO.useFile == 2}">
		<jsp:include page="/board/fileupload/list.do" flush="false">
			<jsp:param name="boardId"					value="${boardinfoVO.boardId}" />
			<jsp:param name="multiple"					value="true" />
			<jsp:param name="dragDrop"					value="true" />
			<jsp:param name="blacklist"					value="${boardinfoVO.fileBlacklist}" />
			<jsp:param name="maxFileCount"				value="${boardinfoVO.fileLimitCount}" />
			<jsp:param name="maxFileSize"				value="${boardinfoVO.fileLimitSize}MB" />
		</jsp:include>
	</c:if>
	
	<div class="btn_g_btm">
		<input type="submit" id="btnSubmit" class="btn_st btn_c_gr btn_s_big" value="<%= JnitboardController.isLanguage("등록",lang) %>" />
		<a id="btnCancel" class="btn_st btn_s_big" href="?boardId=${boardinfoVO.boardId}&amp;mode=list&amp;category=${category}"><%= JnitboardController.isLanguage("취소",lang) %></a>
	</div>
	
	<input type="hidden" name="searchCondition" value="<c:out value='${param.searchCondition}'/>"/>
	<input type="hidden" name="searchKeyword" value="<c:out value='${param.searchKeyword}'/>"/>
	<input type="hidden" name="pageIdx" id="pageIdx"  value="<c:out value="${param.pageIdx}"/>" />
	<input type="hidden" name="fileuploadList" id="fileuploadList" value=""/>
</form:form>
