<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spb/spbList.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" id="ksMode" name="ksMode" value="" />
	<input type="hidden" id="ctgryFrstCd" name="ctgryFrstCd" value="" />
</form>
<table class="table_style">
  <colgroup>
    <col width="14%">
    <col width="7%">
    <col width="20%">
    <col width="*">
    <col width="10%">
    <col width="10%">
    <col width="7%">
  </colgroup>
  <thead>
    <tr>
      <th>지원사업명</th>
      <th>지원구분<br>(부서)</th>
    <c:forEach items="${spbStngCdList }" var="spbStngCd">
      <th><c:out value="${spbStngCd.indivCdNm }" /></th>
    </c:forEach>
      <th>수정</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${spbCdList }" var="spbCd">
    <tr>
      <td class="td_bg02"><b><c:out value="${spbCd.indivCdNm }" /></b></td>
      <td><c:out value="${spbCd.indivCdVlFrst }" /></td>
    <c:forEach items="${spbStngCdList }" var="spbStngCd">
      <td>
      	<c:set var="str" value="" />
      <c:forEach items="${spbDtlCdList }" var="spbDtlCd"><c:if test="${spbDtlCd.upIndivCd == spbStngCd.indivCd }">
      	<c:forEach items="${resultList }" var="result"><c:if test="${result.ctgryFrstCd == spbCd.indivCd && spbDtlCd.indivCd == result.stngCd }">
      		<c:set var="str" value="${str}${!empty str?',':'' }${spbDtlCd.indivCdNm }" />
      	</c:if></c:forEach>
      </c:if></c:forEach>
      	<c:out value="${str }" />
      </td>
    </c:forEach>
      <td><a class="btn_st" href="#" onclick="javascript:fnWrite('<c:out value="${spbCd.indivCd}" />');return false;">수정</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
