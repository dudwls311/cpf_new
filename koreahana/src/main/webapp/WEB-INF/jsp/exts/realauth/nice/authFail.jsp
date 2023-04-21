<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="Text/javascript">
<c:if test="${errorCode == '0001'}">
alert('본인인증에 실패하였습니다. 정보를 정확히 입력해 주세요.');
</c:if>
<c:if test="${errorCode == '0001'}">
alert('본인인증에 실패하였습니다. 실패코드(${errorCode})');
</c:if>
window.close();
</script>