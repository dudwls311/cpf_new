<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="/resources/js/jquery.min.js"></script>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<c:choose>
	<c:when test="${onepassLogin }">
<script type="text/javascript">
location.href = '/';
</script>
	</c:when>
	<c:otherwise>
<script type="text/javascript">
alert('회원정보가 없습니다. 회원연동 페이지로 이동합니다.');
location.href = '/support/mbr/sign.jsp?o=Y';
</script>
	</c:otherwise>
</c:choose>