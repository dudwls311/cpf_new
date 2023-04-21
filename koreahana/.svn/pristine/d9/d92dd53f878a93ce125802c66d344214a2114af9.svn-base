<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>모바일 업로드&lt; include&lt; 온라인신청시스템</title>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header_inc.jsp" %>


</head>

<body>
  
<c:choose>
	<c:when test="${!empty result }">
<script type="text/javascript">
$(document).ready(function(){
	ComFns.hideLoading();
});

function fnSubmit(){
	ComFns.showLoading();
}
</script>
<div class="m_file_uploae">
<form id="writeForm" name="writeForm" action="<c:url value="/exts/koreahana/mbl/uploadAction.do" />" method="post" enctype="multipart/form-data" onsubmit="return fnSubmit()">
  <div class="mfu_w">
    <p class="file"><input type="file" size="30" id="m_file" name="upfile"/><label for="m_file" class="btn_st btn_c_bk btn_s_long btn_s_big Fs20">파일선택</label></p>
    <div class="btn_g_btm AlignCenter MAT50">
      <a href="javascript://" onclick="$('#writeForm').submit();return false;" class="btn_st btn_c_gr btn_s_big btn_s_long MAB10 Fs20">파일 업로드</a>
      <a href="javascript:window.close();" class="btn_st btn_s_big btn_s_long Fs20">취소</a>
    </div>
  </div>
<input type="hidden" name="c" value="<c:out value="${param.c }" />"/>
</form>
  
  
</div>



	</c:when>
	<c:otherwise>
<script type="text/javascript">
alert('<spring:message code="exts.error.koreahana.mbl.none" />');
window.close();
</script>
	</c:otherwise>
</c:choose>

          
</body>
</html>
