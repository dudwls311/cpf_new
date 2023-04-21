<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
		<script type="text/javascript">
		$(document).ready(function(){
//	     	$('#mbrId').focus();
	        
	    	var ajform = new ComAjaxForm('loginForm','listForm', 
	    		{
	    		beforeSerializeFunction : function(){
	    			$('#msgDiv').hide();
	    			$('#mbrLoginMsg').hide();
	    			$('#passwdMsg').hide();
	    		},
	    		successFunction : function(resultData, statusText, xhr, $form){
	    			if(resultData.isSuccess == true){
	    				if(resultData.msg == 'smsAuth'){
	    					setInterval(fnSetIntervalSmsInvlid, 1000);
	    					alert('SMS가 전송되었습니다.');
	    					$("#loginSpan").hide();
	    					$("#openpassDiv").hide();
	    					ComFns.hideLoading();
	    					$("#smsAuthNumberReqYn").val('N');
	    					$("#smsAuthNumberSpan").slideDown();
	    				}else{
	    					location.href = resultData.msg;
	    				}	    				
	    			}else{
	    				ComFns.hideLoading();
	    				if(resultData.msg){
	    					//alert(resultData.msg);
	    					$('#msgDiv > p').html(resultData.msg);
	    					$('#msgDiv').show();	    					
	    					return;
	    				}
	    				if(resultData.errorList){
	    					for(var i = 0; i < resultData.errorList.length; i++){
	    						var e = resultData.errorList[i];
	    						//alert(e.errorMessage);
	    						$('#'+e.errorField + 'Msg').show();
	    						return;
	    					}	
	    				}
	    			}
	    		}
	    	});
	    	ajform.init();
	    	
	    	function fnSetIntervalSmsInvlid(){
	    		var invalidTimeText = ' (유효시간  '+fnSecondToMinute()+')';
	    		$("#invalidSecondSpan").text(invalidTimeText);
			}
			
			var second = $("#smsAuthInvalidTime").val();
			function fnSecondToMinute() {
				second--;
				var min = parseInt((second%3600)/60);
				var sec = second%60;
				//if(min < 10) min = '0'+min;
				if(sec < 10) sec = '0'+sec;
				
				if(sec >= 0){
					return min+":"+sec;
				}else{
					return '만료';
				}
			}
	    });
		</script>


    <div class="login_box logbox_nofloat">
      <div class="login_box_02">
<form name="loginForm" id="loginForm" class="form-vertical" action ="<c:url value='/user/exts/koreahana/mbr/loginAction.do'/>" method="post">
	<input type="hidden" id="smsAuthNumberReqYn" name="smsAuthNumberReqYn" value="<c:out value="${smsAuthNumberReqYn }" />" />
	<input type="hidden" id="smsAuthInvalidTime" value="<c:out value="${smsAuthInvalidTime }" />" />
	
		<span id="loginSpan">
	        <h3>로그인</h3>
	        <label for="mbrLogin">아이디</label>
	        <input type="text" name="mbrLogin" id="mbrLogin" placeholder="아이디" />
	        <p id="mbrLoginMsg" class="txt_c_re" style="display: none;">아이디를 입력해 주세요.</p>
	
	        <label for="passwd">비밀번호</label>
	        <input type="password" name="passwd" id="passwd" placeholder="비밀번호" />
	        <p id="passwdMsg" class="txt_c_re" style="display: none;">비밀번호를 입력해 주세요. / 아이디 또는 비밀번호가 일치하지 않습니다.</p>
	   </span>
	   
	   <span id="smsAuthNumberSpan" style="display: none;">
			<label for="smsAuthNumber">인증번호<span id="invalidSecondSpan"></span></label>
			<input type="text" name="smsAuthNumber" id="smsAuthNumber" placeholder="인증번호">
			<p id="smsAuthNumberMsg" class="txt_c_re" style="display: none;">인증번호를 입력해 주세요.</p>
		</span>

        <button type="submit" class="login_btn">로그인</button>

  </form>
        <div id="openpassDiv" class="login_or_d AlignCenter">
          <p class="or_d_tit MAB10">다양한 정부사이트를 하나의 아이디로 간편하게</p>
         <%-- <c:import url="/user/exts/onepass/login.do"/> --%>
          <a class="btn_st btn_s_dopass ">디지털원패스로 로그인</a>  
        </div>
        <div class="box_w_wht MAB0" id="msgDiv" style="display:none">
          <p class="txt_c_or"></p>
        </div>
      </div>
    </div>

<p class="AlignCenter">
  <a href="mbr/sign.jsp" class="btn_a">회원가입</a>
  <span class="MAL10 MAR10">|</span>
  <a href="mbr/noSetpIdFind.jsp" class="btn_a">아이디 찾기</a>
  <span class="MAL10 MAR10">|</span>
  <a href="mbr/noSetpPwFind.jsp" class="btn_a">비밀번호 찾기</a>
</p>
</div>