<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>
<c:set var="sessionName" value="<%=exts.realauth.service.RealAuthService.SESSION_REALAUTH%>" />
<c:set var="realAuth" value="${sessionScope[sessionName] }" />
<c:if test="${empty realAuth }">
	<script type="text/javascript">
		alert('본인확인 정보가 없습니다. 다시 시도해 주세요');
		history.back();
	</script>
</c:if>
<script type="text/javascript">
$(document).ready(function(){
	ComFns.mobileMask('#mbphno');
	$('#mbrLogin').on('keydown',function(){$('#chkId').val('');});
	
	var ajform = new ComAjaxForm('fJoin','listPageForm', {
		beforeSerializeFunction : function(){
			$('.txt_c_re').hide();
			$('#fJoin input').removeClass('input_rere');
		<c:if test="${param.t == 'n' }">
			if($('#cert').val() != 'Y'){
				$('input[name*="rrno"').addClass('input_rere');
				$('input[name*="rrno"]')[0].focus();
				$('#rrnoMsg').text('북한이탈주민 인증을 해주세요');
				$('#rrnoMsg').show();
				return false;
			}
		</c:if>
		<c:if test="${param.o != 'Y' }">
			if($('#chkId').val() != 'Y'){
				$('input[name*="mbrLogin"').addClass('input_rere')
				$('input[name*="mbrLogin"]')[0].focus();
				$('#mbrLoginMsg').text('아이디 중복확인을 해주세요');
				$('#mbrLoginMsg').show();
				return false;
			}
			if($('#passwd').val() != $('#passwd1').val()){
				$('#passwd1').addClass('input_rere');
				$('#passwd1Msg').text('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
				$('#passwd1Msg').show();
				$('#passwd1').focus();
				return false;
			}
		</c:if>
		
		if($("[name=pinfoAgreeYn]").length > 0 && ( $("[name=pinfoAgreeYn]").is(":checked") == false || $("[name=pinfoAgreeYn]:checked").val() == "N" )){
			alert('온라인신청 시스템 개인정보 수집‧이용 및 제공 동의가 필요합니다.');
			return false;
		}
	
		if($("[name=agreeYn]").length > 0 && ( $("[name=agreeYn]").is(":checked") == false || $("[name=agreeYn]:checked").val() == "N" )){
			alert('개인정보 제공 및 행정정보 공동이용 서비스 활용 동의가 필요합니다.');
			return false;
		}
		
		},
		successFunction : function(resultData, statusText, xhr, $form){
			if(resultData.isSuccess == true){
				location.href = '/support/mbr/signupSuccess.jsp?o=${param.o == 'Y'?'Y':''}';				
			}else{
				ComFns.hideLoading();
				if(resultData.msg){
					alert(resultData.msg);
					return;
				}
				if(resultData.errorList){
					for(var i = 0; i < resultData.errorList.length; i++){
						var e = resultData.errorList[i];
						alert(e.errorMessage);
						/*
						$('input[name*="'+e.errorField+'"]').addClass('input_rere');
						if($('input[name*="'+e.errorField+'"]').length > 0)$('input[name*="'+e.errorField+'"]')[0].focus();
						$('#'+e.errorField + 'Msg').text(e.errorMessage);
						$('#'+e.errorField + 'Msg').show();
						*/
						return;
					}	
				}
			}
		}
	});
	ajform.init();
});
//북한이탈주민인증
function fnCertification(){
	if($('#cert').val() == 'Y'){
		alert('이미 인증하셨습니다.');
		return;
	}
	
	if($('#rrno1').val() == '' || $('#rrno2').val() == '' || $('#rrno1').val().length != 6 || $('#rrno2').val().length != 7  ){
		$('#rrno1').focus();
		alert('주민번호를 정확히 입력해 주세요');
		return;
	}
	ComFns.showLoading();
	
	$.ajax({
		url:'/user/exts/koreahana/mbr/certificationActionJson.do',
		data:{rrno:$('#rrno1').val() + '' + $('#rrno2').val()},
		success:function (resultData){
			ComFns.hideLoading();
			if(!resultData.isSuccess){
				alert(resultData.msg);
				return;
			}
			var _data = resultData.data;
			var _html = '';
			if(_data.dpkdfryn == 'Y'){
				_html += '<li><b>북한이탈주민 인증완료</b> <span></span></li>';
				_html += '<li><b>✓</b> 북한이탈주민 번호 : ' + _data.prtcnno + '</li>';
				_html += '<li><b>✓</b> 입국일 : ' + _data.entrcdate + '</li>';
				_html += '<li><b>✓</b> 보호결정일 : ' + _data.prtcndecsndate + '</li>';
				_html += '<li><b>✓</b> 하나원 수료일 : ' + _data.hanascomptdate + '</li>';
				_html += '<li><b>✓</b> 하나원 기수 : ' + _data.hanasordno + '</li>';
				$('#rrno1').prop('readonly',true);
				$('#rrno2').prop('readonly',true);
				$('#cert').val('Y');
				$('#certDiv').show();
				$('input[name*="rrno"').removeClass('input_rere');
				$('#rrnoMsg').hide();
			}else{
				alert('이름과 주민등록번호가 일치하는 북한이탈주민정보를 찾지 못했습니다. 다시 확인해 주세요.');
				$('#rrno1').prop('readonly',false);
				$('#rrno2').prop('readonly',false);
				$('#rrno1').val('');
				$('#rrno2').val('');
				$('#cert').val('N');
				$('#certDiv').hide();
			}
			$('#certDiv div ul').html(_html);
		}
	});
}

//주소찾기
function fnAddr(){
	fnComAddressFind(function(data){
		$('#zip').val(data.zip);
		$('#addr').val(data.address);
		$('#daddr').val(data.addressDetail);
	});
	return false;
}

//아이디 중복체크
function fnIdCheck(){
	var _id = $('#mbrLogin').val();
	if(_id == ''){
		alert('아이디를 입력해 주세요');
		$('#mbrLogin').focus();
		return false;
	}
	$.ajax({
		url:ComFns.getContextUrl()+'user/exts/koreahana/mbr/duplicateIdActionJson.do',
		data:{mbrLogin:_id},
		success:function(resultData){
			if(resultData.isSuccess){
				$('#chkId').val('Y');
				alert('사용하실 수 있는 아이디입니다.');
				$('input[name*="mbrLogin"').removeClass('input_rere');
				$('#mbrLoginMsg').hide();
			}else{
				if(resultData.msg != ''){
					alert(resultData.msg);	
				}else{
					alert('사용할 수 없는 아이디입니다. 다른 아이디을 입력해 주세요.');
				}
			}
		}
	});	
}

</script>
<form id="listPageForm" action="signupSuccess.jsp"></form>
<form id="fJoin" name="fJoin" action="/user/exts/koreahana/mbr/joinActionJson.do" method="post">
<input type="hidden" name="t" value="<c:out value="${param.t }" />" />
<input type="hidden" name="o" value="<c:out value="${param.o }" />" />
<div class="box_w_suc">
  <h3 class="suc_tit">회원 정보 입력</h3>
  <div class="AlignLeft">
<c:if test="${param.t == 'n' }">
    <div class="MAB20">
      <label for="aaa2">북한이탈주민 인증  </label><span class="p_info">주민번호를 입력해주세요.</span><br>
      <input type="text" name="rrno1" id="rrno1" value="" class="st_input number_nocomma_style" placeholder="" maxlength="6"> -
      <input type="password" name="rrno2" id="rrno2" value="" class="st_input number_nocomma_style" placeholder="" maxlength="7">
      <input type="hidden" id="cert" value="" />
      <a id="btnCert" class="btn_st btn_c_bk btn_s_big" href="#" onclick="fnCertification();return false;">인증하기</a>
      <p id="rrnoMsg" class="txt_c_re" style="display: none;"></p>
    </div>
	<div class="MAB20" style="display:none" id="certDiv">
      <label for="aaa3">북한이탈주민 인증</label>
      <div class="box_w_gray">
        <ul>
          
        </ul>
      </div>
    </div>
</c:if>
    <div class="MAB20">
      <label for="aaa3">이름  </label><!-- span class="p_info">이름을 입력해주세요</span -->
      <input type="text" name="mbrNm" id="mbrNm" value="<c:out value="${realAuth.realname }" />" class="st_input input_long  " readonly>
    </div>
    
<c:if test="${param.t == 'u' }">
    <div class="MAB20">
      <label>성별</label>
      <div class="btn_tab">
        <input type="radio" id="genderCd0" name="genderCd" value="1001" class="st_radio_tab"${realAuth.sex == '1'?' checked':'' } disabled>
        <label for="genderCd0">남</label>
        <input type="radio" id="genderCd1" name="genderCd" value="1002" class="st_radio_tab"${realAuth.sex == '0'?' checked':'' } disabled>
        <label for="genderCd1">여</label>

      </div>
    </div>


    <div class="MAB20">
      <label for="aaa4">생년월일    </label>
      <input type="text" name="brdtYmd" id="brdtYmd" value="<c:out value="${jtag:convertDateSplitString(realAuth.birth,'-') }" />" class="st_input input_long  " readonly>
    </div>
</c:if>
    <div class="MAB20">
      <label for="mbphno">휴대폰번호    </label><span class="p_info">숫자만 입력해주세요</span>
      <input type="text" name="mbphno" id="mbphno" value="<c:out value="${realAuth.mobile }" />" class="st_input input_long  " placeholder="010-1234-4567">
      <p id="mbphnoMsg" class="txt_c_re" style="display: none;"></p>
    </div>


    <div class="MAB20">
      <p><label for="zip">주소</label></p>
      <input type="text" name="zip" id="zip" value="<c:out value="${result.zip}" />" class="st_input " placeholder="우편번호" readonly>
      <a class="btn_st btn_c_bk btn_s_big" href="#" onclick="fnAddr();return false;">주소 검색</a>
      <input type="text" name="addr" id="addr" value="<c:out value="${result.addr}" />" class="st_input input_long  MAB5  MAT5" placeholder="기본주소"  readonly>
      <input type="text" name="daddr" id="daddr" value="<c:out value="${result.daddr}" />" class="st_input input_long " placeholder="상세주소">
      <p id="zipMsg" class="txt_c_re" style="display: none;"></p>
      <p id="daddrMsg" class="txt_c_re" style="display: none;"></p>
    </div>
<c:if test="${param.o != 'Y' }">
    <div class="MAB20">
      <label for="mbrLogin">아이디</label><br>
      <input type="hidden" id="chkId" value="" />  
      <input type="text" name="mbrLogin" id="mbrLogin" value="" class="st_input   ">
      <a class="btn_st btn_c_bk btn_s_big" href="#" onclick="fnIdCheck();return false;">중복 확인</a>
       <p id="mbrLoginMsg" class="txt_c_re" style="display: none;"></p>
    </div>

    <div class="MAB20">
      <label for="passwd">비밀번호</label>
      <input type="password" name="passwd" id="passwd" placeholder="비밀번호" class="st_input input_long">
      <p id="passwdMsg" class="txt_c_re" style="display: none;">비밀번호를 입력해 주세요.</p>
      <!-- 
      <p class="p_info"><span class="txt_c_re MAR10">X 8~15자리</span> 
        <span class="MAR10">✓ 숫자</span> 
        <span class="MAR10">✓ 영어</span> 
        <span class="MAR10">✓ 특수문자</span>
      </p>
       -->
    </div>

    <div class="MAB20">
      <label for="passwd1">비밀번호확인</label>
      <input type="password" name="passwd1" id="passwd1" placeholder="비밀번호" class="st_input input_long ">
       <p id="passwd1Msg" class="txt_c_re" style="display: none;">새비밀번호와 비밀번호확인 값이 일치하지 않습니다.</p>
    </div>

	<div class="AlignLeft">
        <c:choose>
			<c:when test="${param.t == 'n' }">
				<h3>(북한이탈주민) 온라인신청 시스템 개인정보 수집‧이용 및 제공 동의서</h3>
			</c:when>
			<c:otherwise>
				<h3>(일반사용자) 온라인신청 시스템 개인정보 수집‧이용 및 제공 동의서</h3>
			</c:otherwise>
		</c:choose>
        
        <div class="box_w_gray box_s_add MAT20" style="font-size: 13px;">
          북한이탈주민지원재단은 온라인신청 시스템 회원가입에 필요한 개인정보의 수집‧이용을 위하여 개인정보 보호법 제15조(개인정보의 수집‧이용), 제17조(개인정보의 제공), 제22조(동의를 받는 방법)에 따라 귀하의 동의를 받고자 합니다.
          귀하의 개인정보는 수집 목적 외 다른 목적으로는 이용하지 않으며, 정보주체가 개인정보에 대한 열람, 정정‧삭제, 처리정지, 이의제기 하고자 할 때에는 개인정보보호책임자를 통해 요구할 수 있으며, 개인정보침해 시 개인정보처리방침 권익침해 구제방법을 통해 구제받을 수 있습니다. 
        </div>
        <div class="box_w_wht box_s_add">
          <h4 class="tit MAT10">1. 개인정보의 수집‧이용</h4>
          <h6 class="tit MAT10">개인정보의 수집‧이용목적</h6>
          <ul class="ul_st">
            <li>온라인신청 시스템 회원가입</li>
            <li>북한이탈주민지원재단 지원사업 서비스 및 행정정보공동이용</li>
            <li>북한이탈주민지원재단 설문 및 만족도 조사</li>
          </ul>

          <h6 class="tit">수집하려는 개인정보의 항목</h6>
          <table class="table_style thd_v_m MAB10">
            <tbody>
              <tr>
                <th>필수항목</th>
                
                <c:choose>
                	<c:when test="${param.t == 'n' }">
                		<td>이름, 휴대폰번호, 주소</td>
                	</c:when>
                	<c:otherwise>
                		<td>이름, 성별, 생년월일, 휴대폰번호, 주소</td>
                	</c:otherwise>
                </c:choose>
              </tr>
            </tbody>
          </table>
          <c:if test="${param.t == 'n' }">
          	<p class="">※ 주민등록번호는 [북한이탈주민의 보호 및 정착지원에 관한 법률] 제30조(북한이탈주민지원재단) 및 [북한이탈주민의 보호 및 정착지원에 관한 법률 시행령] 제49조의2(고유식별정보의 처리) 제2항에 따라 수집합니다.</p>
          </c:if>
          <h6 class="tit">개인정보의 보유 및 이용 기간 <span style="font-size: 16px;padding: 2px 0;margin-left: 20px;color: #0064cd;border-bottom: 1px solid #0064cd;"> 온라인신청 시스템 회원 탈퇴 시까지</span></h6> 
          <h6 class="tit">상기 개인정보 수집‧이용에 대하여 동의를 거부할 수 있습니다. 동의 거부 시에는 온라인신청 시스템 서비스가 제한될 수 있습니다.</h6> 
        </div>

        <div class="box_w_gray AlignCenter">
          위 내용에 동의합니다. 
          <input type="radio" name="pinfoAgreeYn"  id="pinfoAgreeYnY" class="st_radio" value="Y" />
          <label for="pinfoAgreeYnY">동의함</label>
          <input type="radio" name="pinfoAgreeYn"  id="pinfoAgreeYnN" class="st_radio" value="N" />
          <label for="pinfoAgreeYnN">동의하지 않음</label>
        </div>
      </div>

    <c:if test="${param.t == 'n' }">
	    <br />
	    <h3>행정정보 공동이용 사전동의서</h3>
	    <div class="box_w_wht box_s_add">
			<h6 class="tit"><b>1.이용기관 명칭 : </b>북한이탈주민지원재단 (남북하나재단)</h6>
			<h6 class="tit"><b>2.이용사무(이용목적) : </b>북한이탈주민법 제30조④항에 따른 정착지원 업무를 수행하기 위한 탈북민 등록 여부 확인</h6>
			<h6 class="tit"><b>3.공동이용 행정정보(구비서류)</b></h6>
			<table class="table_style thd_v_m">
				<thead>
					<tr>
						<th>연번</th>
						<th>행정정보명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>북한이탈주민등록확인서</td>
					</tr>
				</tbody>
			</table>
			<ul class="ul_st">
				<li>※ 이용기관은 본인이 동의한 위 공동이용 행정정보를 확인하기 위해「개인정보 보호법」시행령 제19조에 및 북한이탈주민법 시행령 제49조의2(민감정보 및 고유식별정보의 처리) ③ 항 따라 주민등록번호, 여권번호가 포함된 행정정보를 처리할 수 있습니다.</li>
			</ul>
			<h6 class="tit"><b>4. 정보주체(본인) 동의사항</b></h6>
			<ul class="ul_st">
				<li>본인은 위 사무의 처리를 위하여 「전자정부법」제36조에 따른 행정정보 공동이용을 통해 이용기관의 업무처리담당자가 전자적으로 본인의 구비서류(공동이용 행정정보)를 확인하는 것에 동의합니다. </li>
			</ul>
			<h6 class="tit">※ 만일, 본인이 위 행정정보 이용에 대해 동의를 하지 아니할 경우에도 지원결정에 불이익은 없습니다. 다만, 동의하지 아니한 경우에는 본인이 해당 신청서 및 구비서류를 우편 또는 방문 접수하셔야 합니다.</h6>
		</div>
		
		<div class="box_w_gray AlignCenter">
          위 내용에 동의합니다. 
          <input type="radio" name="agreeYn"  id="agreeYnY" class="st_radio" value="Y" />
          <label for="agreeYnY">동의함</label>
          <input type="radio" name="agreeYn"  id="agreeYnN" class="st_radio" value="N" />
          <label for="agreeYnN">동의하지 않음</label>
        </div>
	</c:if>

</c:if>    
  </div>
</div>

<div class="btn_g_btm">
  <button class="btn_st btn_c_bk btn_s_long btn_s_big SAMPLE_NEXT_02_BTN" type="submit">회원${param.o == 'Y'?'연동':'가입' }</button>
</div>
</form>