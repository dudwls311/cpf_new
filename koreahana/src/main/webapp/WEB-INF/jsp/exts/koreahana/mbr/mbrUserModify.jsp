<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NTK.getCode()" var="enumMbrTypeCdNTK" />
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumGenderCd).FEMALE.getCode()" var="enumGenderCdFEMALE" />
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>
<c:set var="sessionName" value="<%=exts.com.service.ComMbrService.SESSION_ADT_VO%>" />
<c:set var="result" value="${sessionScope[sessionName] }" />

<c:if test="${empty result }">
	<script type="text/javascript">
		alert('로그인 정보가 없습니다.');
		history.back();
	</script>
</c:if>
<script type="text/javascript">
$(document).ready(function(){
	if($("#digitalOnepassUserYn").val() == 'Y'){
		fnDigitalOnepass();
	}
});

function fnChkPasswd(){
	$('#chkPasswd').removeClass('input_rere');
	$('#chkPasswdMsg').hide();
	if($('#chkPasswd').val() == ''){
		$('#chkPasswd').addClass('input_rere');	
		$('#chkPasswdMsg').text('현재 비밀번호를 입력해 주세요.').show();
		return false;
	}
	$.ajax({
		url:'/user/exts/koreahana/mbr/chkPasswdActionJson.do',
		data:{passwd:$('#chkPasswd').val()},
		success:function(data){
			if(data.isSuccess){
				$('#modifyFormDiv').load('/user/exts/koreahana/mbr/modifyView.do').show();
				$('#chkPasswdDiv').hide();
			}else{
				$('#chkPasswd').addClass('input_rere');	
				$('#chkPasswdMsg').text('현재 비밀번호가 일치하지 않습니다.').show();
				return false;
			}
		}
	});
	
}

function fnDigitalOnepass(){
	$.ajax({
		url:'/user/exts/koreahana/mbr/chkDigitalOnepassJson.do',
		success:function(data){
			if(data.isSuccess){
				$('#modifyFormDiv').load('/user/exts/koreahana/mbr/modifyView.do').show();
				$('#chkPasswdDiv').hide();
			}else{
				$('#chkPasswd').addClass('input_rere');	
				$('#chkPasswdMsg').text('디지털원패스 회원이 아닙니다.').show();
				return false;
			}
		}
	});
}
</script>

<div id="chkPasswdDiv"${!empty sessionScope.loginVO.sn?' style="display:none"':'' }>
  <div class="box_w_suc MAT50">
    <h3 class="suc_tit">비밀번호 입력</h3>
    <p class="MAB30">개인정보 수정을 위해서 비밀번호를 입력해주세요.</p>

    <div class="AlignLeft">
      <label for="password" class="comment">현재 비밀번호</label>
      <input type="password" id="chkPasswd" placeholder="비밀번호" class="st_input input_long ">
      <p class="AlignLeft txt_c_re" id="chkPasswdMsg"></p>

    </div>
  </div>
  
  <div class="btn_g_btm">
    <a class="btn_st btn_c_bk btn_s_big btn_s_long" href="#" onclick="fnChkPasswd();return false;">개인정보 수정</a>
  </div>
  
  <input type="hidden" id="digitalOnepassUserYn" value="${!empty sessionScope.loginVO.sn?'Y':'N'}" />
</div>

<div class="box_w_suc" id="modifyFormDiv" style="display:none">
</div>
