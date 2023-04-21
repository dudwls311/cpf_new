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
<script type="text/javascript">
$(document).ready(function(){

	var ajform = new ComAjaxForm('fPw','listPageForm', {
		beforeSerializeFunction : function(){
			$('#fPw input').removeClass('input_rere');
			$('#passwdMsg').hide();
			$('#passwd1Msg').hide();
			if($('#passwd').val() != $('#passwd1').val()){
				$('#passwd1').addClass('input_rere');
				$('#passwd1Msg').show();
				$('#passwd1').focus();
				return false;
			}
		},
		successFunction : function(resultData, statusText, xhr, $form){
			if(resultData.isSuccess == true){
				alert('비밀번호가 변경되었습니다.');
				location.href = '../login.jsp';				
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
						$('#'+e.errorField).addClass('input_rere')
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
<form id="fPw" action="<c:url value="/user/exts/koreahana/mbr/changePasswordActionJson.do" />" method="post">
		<div class="box_w_suc MAT50">
		  <h3 class="suc_tit">비밀번호 변경</h3>
		
		  <div class="AlignLeft">
		
		    <div class="MAB20">
		      <label for="passwd">변경할 비밀번호</label>
		      <input type="password" name="passwd" id="passwd" placeholder="비밀번호" class="st_input input_long ">
        	  <p id="passwdMsg" class="txt_c_re" style="display: none;">비밀번호를 입력해 주세요.</p>
		      <!-- 
		      <p class="p_info">
		        <span class="MAR10" id="pwLen">✓ 8~20자리</span>
		        <span class="MAR10" id="pwNum">✓ 숫자</span> 
		        <span class="MAR10" id="pwEng">✓ 영어</span> 
		        <span class="MAR10" id="pwSpc">✓ 특수문자</span>
		      </p>
		       -->
		    </div>
		
		    <div class="">
		      <label for="passwd1">변경할 비밀번호 확인</label>
		      <input type="password" name="passwd1" id="passwd1" placeholder="비밀번호" class="st_input input_long">
        	  <p id="passwd1Msg" class="txt_c_re" style="display: none;">새비밀번호와 비밀번호확인 값이 일치하지 않습니다.</p>
		    </div>
		  </div>
		</div>
		<div class="btn_g_btm">
		  <a class="btn_st btn_c_bk btn_s_long btn_s_big" href="#" onclick="$('#fPw').submit();return false;">비밀번호 변경</a>
		</div>
</form>
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
