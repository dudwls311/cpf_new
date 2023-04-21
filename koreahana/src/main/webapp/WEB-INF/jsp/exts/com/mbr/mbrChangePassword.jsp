<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
<c:if test="${empty sessionScope.loginVO }">
	alert('로그인 정보가 없습니다.');
	history.back();
</c:if>
	var ajform = new ComAjaxForm('fPass','listPageForm', {
		beforeSerializeFunction : function(){
			$('.txt_c_re').hide();
			$('#fPass input').removeClass('input_rere');

			if($('#orPasswd').val() == ''){
				$('#orPasswd').addClass('input_rere');
				$('#orPasswdMsg').text('현재 비밀번호를 입력해 주세요.').show();
				$('#orPasswd').focus();
				return false;
			}
			
			if($('#passwd').val() != $('#passwd1').val()){
				$('#passwd1').addClass('input_rere');
				$('#passwd1Msg').text('새비밀번호와 비밀번호확인 값이 일치하지 않습니다.').show();
				$('#passwd1').focus();
				return false;
			}
			
		},
		successFunction : function(resultData, statusText, xhr, $form){
			if(resultData.isSuccess == true){
				alert('변경되었습니다.');
				location.reload();
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



<form id="fPass" action="/exts/com/mbr/changePasswordActionJson.do" method="post">
<br /><br />
  <div class="box_w_suc MAT50">
    <h3 class="suc_tit">비밀번호 변경</h3>

    <div class="AlignLeft">
      <div class="MAB20">
        <label for="password">현재 비밀번호</label>
        <input type="password" name="orPasswd" id="orPasswd" placeholder="비밀번호" class="st_input input_long " />
        <p class="txt_c_re" id="orPasswdMsg"></p>
      </div>

      <div class="MAB20">
        <label for="passwd">변경할 비밀번호</label>
        <input type="password" name="passwd" id="passwd" placeholder="비밀번호" class="st_input input_long "/>
        <p class="txt_c_re" id="passwdMsg"></p>
        <!-- p class="p_info"><span class="txt_c_re MAR10">X 8~15자리</span> 
          <span class="MAR10">✓ 숫자</span> 
          <span class="MAR10">✓ 영어</span> 
          <span class="MAR10">✓ 특수문자</span>
        </p -->
      </div>

      <div class="MAB0">
        <label for="passwd1">변경할 비밀번호 확인</label>
        <input type="password" name="passwd1" id="passwd1" placeholder="비밀번호" class="st_input input_long"/>
        <p class="txt_c_re" id="passwd1Msg"></p>
      </div>

    </div>
  </div>
  <div class="btn_g_btm">
    <button class="btn_st btn_c_bk btn_s_long btn_s_big" type="submit">비밀번호 변경</button>
  </div>



</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
