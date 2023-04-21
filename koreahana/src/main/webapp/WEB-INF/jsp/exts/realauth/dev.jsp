<%@ page contentType="text/html;charset=utf-8"%><%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
실명인증값 임시생성<br />
<form action="dev.do" method="post">
	<input type="hidden" name="remove" value="N" />
	실명인증타입 : <select name="type"><option value="M">휴대폰</option><option value="">IPIN</option></select><br />
	중복확인코드: <input type="text" name="dupinfo" value="test1234567890123456789001234567890012345678900123456789001234567890" /><br />
	ci: <input type="text" name="ci" value="test1234567890123456789001234567890012345678900123456789001234567890" /><br />
	실명: <input type="text" name="realname" value="테스트" /><br />
	생년월일: <input type="text" name="birth" value="19800101" /><br />
	성별: <select name="sex"><option value="1">남</option><option value="0">여</option></select><br />
	휴대폰번호: <input type="text" name="mobile" value="01000000000" /><br />
	휴대폰사: <input type="text" name="mobileCo" value="SK" /><br />
	<input type="submit" value="생성" />
</form>

<br />

<c:if test="${!empty realAuthVO }">
	<br />실명인증 생성값 : ${realAuthVO.dupinfo }
	<script type="text/javascript">
	if(opener.fnAuthCallback != undefined){
		opener.fnAuthCallback();
	}else{
		opener.location.reload();	
	}
	window.close();
	</script>
</c:if>

<br />
<br />
<br />
<br />
<br />
<a href="?remove=Y">실명인증값 삭제</a>
