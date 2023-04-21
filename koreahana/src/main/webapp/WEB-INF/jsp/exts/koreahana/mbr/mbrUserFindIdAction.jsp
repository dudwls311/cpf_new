<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<c:choose>
	<c:when test="${!empty result }">
		<c:choose>
			<c:when test="${!empty result.sn  }">
		<script type="text/javascript">
			alert("디지털원패스 회원입니다. 디지털 원패스로 로그인하시기 바랍니다.");
			history.back();
		</script>	
			</c:when>
			<c:otherwise>
		<div class="box_w_suc">
		  <h3 class="suc_tit">아이디 안내</h3>
		  <p class="AlignCenter MAB30">개인정보 도용에 대한 피해방지를 위하여 <br>아이디 끝 두자리는 **처리합니다.</p>
		
		  <div class="box_w_wht">
		    회원님의 아이디는 <b class="txt_c_or"><c:out value="${fn:substring(result.mbrLogin, 0, fn:length(result.mbrLogin) - 2) }" />**</b> (으)로 등록되어 있습니다.<br>
		    가입일자는 <b class="txt_c_or"><fmt:formatDate value="${result.created }" pattern="yyyy-MM-dd" /></b> 입니다.
		
		  </div>
		
		  <a class="btn_st btn_c_gr btn_s_long btn_s_big MAB20" href="../login.jsp">
		    <p class="br Fs20"><b>로그인</b></p>
		  </a>
		
		
		</div>			
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("회원가입정보가 존재하지 않습니다.");
			history.back();
		</script>	
	</c:otherwise>
</c:choose>
