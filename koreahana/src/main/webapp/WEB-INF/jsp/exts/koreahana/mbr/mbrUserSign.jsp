<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<div class="box_w_suc">
<h3 class="suc_tit">회원${param.o == 'Y'?'연동':'가입' }</h3>
<p class="AlignCenter MAB30">북한이탈주민지원재단 온라인신청시스템 <br>
  회원가입을 위해 사용자 유형을 선택해 주세요.

</p>
<a class="btn_st btn_c_bl btn_s_long btn_s_bbig MAB20" href="signup.jsp?t=n&amp;o=${param.o == 'Y'?'Y':'' }">
  <p class="br Fs20"><b>북한이탈주민</b></p>
  <span class="MAT20">북한이탈주민을 대상으로 하는 다양한 지원사업을 신청할 수 있습니다. <br>(북한이탈주민 인증 필수)</span>
</a>
<a class="btn_st btn_c_bl btn_s_long btn_s_bbig MAB20" href="signup.jsp?t=u&amp;o=${param.o == 'Y'?'Y':'' }">
  <p class="br Fs20"><b>일반사용자</b></p>
  <span class="MAT20">북한이탈주민의 자녀(제3국 출생) 또는 일반사용자를 대상으로 하는 지원사업을 신청할 수 있습니다.</span>
</a>

</div>