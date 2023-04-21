<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<div class="box_w_suc">
  <h3 class="suc_tit">비밀번호 재설정</h3>
  <p class="AlignCenter MAB30">북한이탈주민지원재단 온라인신청시스템 비밀번호를 재설정하기 위해 실명확인이 필요합니다
  </p>
  <a class="btn_st btn_c_bl btn_s_long btn_s_bbig MAB20" href="#" onclick="ComFns.openRealAuth();return false;">
    <p class="br Fs20"><b>휴대폰 본인인증</b></p>
    <span class="MAT20">본인 명의로 가입된 휴대폰을 이용하여 실명인증 후 비밀번호를 재설정합니다.</span>
  </a>

</div>
<script type="text/javascript">
function fnAuthCallback(){
	location.href = '/support/mbr/noSetpPwResult.jsp';
}
</script>