<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>

<c:choose>
	<c:when test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/adt/index.do"><c:param name="kaMode" value="write" /></c:import>
	</c:when>
	<c:when test="${enumFrsSho == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/sho/index.do"><%-- <c:param name="ksMode" value="write" /> 파라미터로 넘어오는 mode 변수가 동일해서 주석처리 --%></c:import>
	</c:when>
	<c:when test="${enumFrsEdu == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/edu/index.do"><c:param name="keMode" value="write" /></c:import>
	</c:when>
	<c:when test="${enumFrsVdo == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/vdo/index.do"><c:param name="kvMode" value="write" /></c:import>
	</c:when>
	<c:when test="${enumFrsLnb == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/lnb/index.do"><c:param name="klMode" value="write" /></c:import>
	</c:when>
	<c:when test="${enumFrsSpf == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/spf/index.do"><%-- <c:param name="ksMode" value="write" /> 파라미터로 넘어오는 mode 변수가 동일해서 주석처리 --%></c:import>
	</c:when>
	<c:when test="${enumFrsEmp == searchVO.pbancrcCtgryFrstCd }">
		<c:import url="/user/exts/koreahana/emp/index.do"><c:param name="keMode" value="write" /></c:import>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>