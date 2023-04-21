<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:if test="${param.authType == 'nice' }">
	<form name="form_chk" method="post" action="https://nice.checkplus.co.kr/CheckPlusSafeModel/checkplus.cb">
		<input type="hidden" name="m" value="checkplusSerivce">						<!-- 필수 데이타로, 누락하시면 안됩니다. -->
		<input type="hidden" name="EncodeData" value="${sEncData  }">		<!-- 위에서 업체정보를 암호화 한 데이타입니다. -->
	</form>
</c:if>
<c:if test="${param.authType == 'niceipin' }">
	<form name="form_chk" method="post" action="https://cert.vno.co.kr/ipin.cb">
		<input type="hidden" name="m" value="pubmain">						<!-- 필수 데이타로, 누락하시면 안됩니다. -->
		<input type="hidden" name="enc_data" value="${sEncData  }">		<!-- 위에서 업체정보를 암호화 한 데이타입니다. -->
	</form>
</c:if>
<script type="Text/javascript">
	document.form_chk.submit();
</script>