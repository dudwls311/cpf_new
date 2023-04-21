<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<script type="text/javascript">
<c:if test="${empty sessionScope.loginVO }">
	alert('로그인 정보가 없습니다.');
	history.back();
</c:if>
<c:if test="${!empty sessionScope.loginVO.sn }">
alert('디지털원패스 회원은 개인정보 수정페이지에서 연동해지할 수 있습니다.');
history.back();
</c:if>
$(document).ready(function(){
	var ajform = new ComAjaxForm('fOut','listPageForm', {
		beforeSerializeFunction : function(){
			$('.txt_c_re').hide();
			$('#fOut input').removeClass('input_rere');

			if($('#passwd').val() == ''){
				$('#passwd').addClass('input_rere');
				$('#passwdMsg').text('현재 비밀번호를 입력해 주세요.').show();
				$('#passwd').focus();
				return false;
			}
			if(!confirm('정말로 탈퇴하시겠습니까?')){
				return false;
			}
		},
		successFunction : function(resultData, statusText, xhr, $form){
			if(resultData.isSuccess == true){
				alert('정상처리되었습니다.');
				location.href = '/';
			}else{
				ComFns.hideLoading();
				if(resultData.msg){
					alert(resultData.msg);
					return;
				}
				if(resultData.errorList){
					for(var i = 0; i < resultData.errorList.length; i++){
						var e = resultData.errorList[i];
						//alert(e.errorMessage);
						$('input[name*="'+e.errorField+'"]').addClass('input_rere');
						if($('input[name*="'+e.errorField+'"]').length > 0)$('input[name*="'+e.errorField+'"]')[0].focus();
						$('#'+e.errorField + 'Msg').text(e.errorMessage);
						$('#'+e.errorField + 'Msg').show();
						return;
					}	
				}
			}
		}
	});
	ajform.init();
});
</script>

<form id="fOut" action="/user/exts/koreahana/mbr/outActionJson.do" method="post">
<div class="box_w_suc MAT50">
  <h3 class="suc_tit">회원탈퇴</h3>
  <p class="">북한이탈주민지원재단 온라인신청시스템 회원탈퇴를 하시면<br />
    회원정보, 지원사업 신청정보, 1:1문의 내역이 초기화되며 복구하실 수 없습니다. <br /><br />
    정말로 회원탈퇴를 원하신다면<br />
    아래에 비밀번호를 입력하시고 탈퇴하기 버튼을 눌러주세요.
  </p>
  <div class="MAT20">
    <label for="passwd" class="comment">비밀번호 확인</label>
    <input type="password" name="passwd" id="passwd" placeholder="비밀번호" class="st_input input_long"/>
    <p class="txt_c_re" id="passwdMsg"></p>
  </div>
</div>
<div class="btn_g_btm">
  <button class="btn_st btn_c_gy btn_s_long btn_s_big " type="submit">탈퇴하기</button>
</div>
</form>
