<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="Text/javascript">
	if(opener.fnAuthCallback != undefined){
		opener.fnAuthCallback();
	}else{
		opener.location.reload();	
	}
	window.close();
</script>