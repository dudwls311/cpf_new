<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NTK.getCode()" var="enumMbrTypeCdNTK" />
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumGenderCd).FEMALE.getCode()" var="enumGenderCdFEMALE" />
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>
<c:set var="sessionName" value="<%=exts.com.service.ComMbrService.SESSION_ADT_VO%>" />
<c:set var="result" value="${sessionScope[sessionName] }" />

<script type="text/javascript">
$(document).ready(function(){
	ComFns.mobileMask('#mbphno');
	
	var ajform = new ComAjaxForm('fModify','listPageForm', {
		beforeSerializeFunction : function(){
			$('.txt_c_re').hide();
			$('#fModify input').removeClass('input_rere');
		},
		successFunction : function(resultData, statusText, xhr, $form){
			if(resultData.isSuccess == true){
				alert('정상처리되었습니다.');
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
//주소찾기
function fnAddr(){
	fnComAddressFind(function(data){
		$('#zip').val(data.zip);
		$('#addr').val(data.address);
		$('#daddr').val(data.addressDetail);
	});
	return false;
}

function fnOnepassOut(){
	if(confirm('정말로 연동해지하시겠습니까?')){
		ComFns.showLoading();
		$.ajax({
			url:'/user/exts/koreahana/mbr/onepassOutActionJson.do',
			success:function(data){
				ComFns.hideLoading();
				if(data.isSuccess){
					alert('정상처리되었습니다.');
					location.href = '/';
				}else{
					alert(data.msg);
					return false;
				}
			}
		});
	}
}
</script>


 

<form id="fModify" name="fModify" action="/user/exts/koreahana/mbr/modifyActionJson.do" method="post">
  <h3 class="suc_tit">개인 정보 수정</h3>
  <div class="AlignLeft">
<c:if test="${result.typeId == enumMbrTypeCdNTK }">
	<div class="MAB20" style="" id="certDiv">
      <label for="aaa3">북한이탈주민 인증</label>
      <div class="box_w_gray">
        <ul>
			<li><b>북한이탈주민 인증완료</b> <span></span></li>
			<li><b>✓</b> 북한이탈주민 번호 : <c:out value="${result.ntkrdfUnqNo }" /></li>
			<li><b>✓</b> 입국일 : <c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-') }" /></li>
			<li><b>✓</b> 보호결정일 : <c:out value="${jtag:convertDateSplitString(result.prtdcsYmd,'-') }" /></li>
			<li><b>✓</b> 하나원 수료일 : <c:out value="${jtag:convertDateSplitString(result.hanawonFnshYmd,'-') }" /></li>
			<li><b>✓</b> 하나원 기수 : <c:out value="${result.hanawonTh }" /></li>
        </ul>
      </div>
    </div>
</c:if>
    <div class="MAB20">
      <label for="aaa3">이름  </label><!-- span class="p_info">이름을 입력해주세요</span -->
      <input type="text" name="mbrNm" id="mbrNm" value="<c:out value="${result.mbrNm }" />" class="st_input input_long input_stop " readonly>
    </div>
    
    <div class="MAB20">
      <label>성별</label>
      <input type="text" name="genderCd" id="genderCd" value="${result.genderCd == enumGenderCdFEMALE?'여':'남'}" class="st_input input_long input_stop " readonly>
    </div>

    <div class="MAB20">
      <label for="mbphno">휴대폰번호    </label><span class="p_info">숫자만 입력해주세요</span>
      <input type="text" name="mbphno" id="mbphno" value="<c:out value="${result.mbphno }" />" class="st_input input_long  " placeholder="010-1234-4567" maxlength="13">
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

    <div class="MAB20">
      <label for="mbrLogin">아이디</label><br>
      <c:choose>
			<c:when test="${!empty result.sn  }">
		디지털원패스 사용자입니다.
		<a class="btn_st btn_c_bk btn_s_big" href="#" onclick="fnOnepassOut();return false;">디지털원패스 연동해지</a>
		<br />연동 해지 시 연동 정보가 완전히 삭제 됩니다. 
			</c:when>
			<c:otherwise>
      <input type="text" name="mbrLogin" id="mbrLogin" value="<c:out value="${result.mbrLogin }" />" class="st_input input_long input_stop " readonly>
			</c:otherwise>
		</c:choose>
    </div>

  </div>
	<div class="btn_g_btm">
	  <button class="btn_st btn_c_bk btn_s_long btn_s_big " type="submit">수정내용 저장</button>
	</div>
</form>
