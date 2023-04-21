<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spb/spbWrite.js"></script>

<form id="listPageForm" action="?">
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ksMode" value="writeActionJson" />
	<input type="hidden" id="ctgryFrstCd" name="ctgryFrstCd" value="<c:out value="${param.ctgryFrstCd }" />" />

<c:forEach items="${spbCdList }" var="spbCd"><c:if test="${spbCd.indivCd == param.ctgryFrstCd }">
	<c:set var="spbNm" value="${spbCd.indivCdNm }" />
	<c:set var="spbTypeNm" value="${spbCd.indivCdVlFrst}" />
</c:if></c:forEach>
<h5 class="tit"><c:out value="${spbNm }" /></h5>
<table class="table_style table_t_left">
<colgroup>
  <col width="20%">
</colgroup>
<tbody>
  <tr>
    <th>지원구분</th>
    <td><c:out value="${spbTypeNm }" /></td>
    </tr><tr>
    </tr>
  <c:forEach items="${spbStngCdList }" var="spbStngCd" varStatus="stngStatus">
    <tr><th><c:out value="${spbStngCd.indivCdNm }" /></th>
	    <td>
	    <c:forEach items="${spbDtlCdList }" var="spbDtlCd" varStatus="dtlStatus"><c:if test="${spbDtlCd.upIndivCd == spbStngCd.indivCd }">
	    	<c:set var="checked" value="" />
	    	<c:forEach items="${resultList }" var="result"><c:if test="${result.stngCd == spbDtlCd.indivCd }"><c:set var="checked" value=" checked" /></c:if></c:forEach>
	    
	      <input type="checkbox" id="stngCds${stngStatus.index }${dtlStatus.index}" name="stngCds" value="${spbDtlCd.indivCd }" class="st_check"${checked }>
	      <label for="stngCds${stngStatus.index }${dtlStatus.index}"><c:out value="${spbDtlCd.indivCdNm }" /></label>
		</c:if></c:forEach>
	    </td>
    </tr>
  </c:forEach>
</tbody>
</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
