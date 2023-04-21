<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript">
var _vldTime = new Date('<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${result.vldDt }" />');
var _interval;
var _intervalData;
$(document).ready(function(){
	popup_fnChk();
	_interval = setInterval(popup_fnChk,1000);
	_intervalData = setInterval(popup_fnChkData,2000);
});
//유효시간변경
function popup_fnChk(){
	//팝업이 닫혀있을때 취소처리
	if($("#modalDiv").css('display') === 'none'){
		popup_fnCancel();
		return;
	}
	
	var _now = new Date();
	var _diffTime = parseInt((_vldTime.getTime() - _now.getTime()) / (1000));

	var _timeText = '';
	if(_diffTime <= 0){
		popup_fnShowReloadDiv();
		return;
	}else if(_diffTime < 60){
		_timeText = _diffTime + '초';
	}else{
		_timeText = parseInt(_diffTime / 60) + '분 ' + (_diffTime % 60 < 10?'0':'') + (_diffTime % 60) + '초';
	}
	$('#popup_timer').text(_timeText);
	
}
//업로드데이터체크
function popup_fnChkData(){
	$.ajax({
		url:'/exts/koreahana/mbl/getDataAjax.do',
		data:{mblUldSn:'${result.mblUldSn}'},
		success:function(data){
			if(data != null){
				if(data.valid && data.atchFileSn != undefined && data.atchFileSn != ''){
					var _funcNm = $('#showQrPopup_callback').val();	
					
					if(typeof(window[_funcNm]) == "function"){
					 	var execFunc = (new Function("return " + _funcNm))();
						execFunc(data.atchFile);
					}else{
						alert('콜백함수 없음.');
					}	
					popup_fnClose();
				}	
			}else{
				popup_fnShowReloadDiv();
			}
			
		},
		error:function(){
			console.log('error');
			popup_fnClose();
		}
	});	
}
function popup_fnClose(){
	popup_fnClearInterval();
	ComFns.popup.hide();	
}
function popup_fnClearInterval(){
	clearInterval(_interval);
	clearInterval(_intervalData);
}
function popup_fnCancel(){
	popup_fnClearInterval();
	$.ajax({
		url:'/exts/koreahana/mbl/cancelAjax.do',
		data:{mblUldSn:'${result.mblUldSn}'},
		success:function(data){
			
		}
	});	
	popup_fnClose();
}

//리로드화면
function popup_fnShowReloadDiv(){
	popup_fnClearInterval();
	ComFns.popup.changeContentHtml($('#popup_reloadDiv').html());	
}
function popup_fnReload(){
	ComFns.openMblPopup($('#showQrPopup_callback').val());
}
</script>
<div class="box_w_gray AlignCenter" id="popup_qrDiv"><br />
        핸드폰으로 아래 QR코드를 스캔하려면<br />
        모바일기기에 저장된 파일을 첨부할 수 있습니다.<br />
        <div class="qr_code">
			<input type="hidden" id="showQrPopup_callback" value="<c:out value="${param.callback }" />" />
			<img src="<c:url value="/exts/koreahana/mbl/qr.do?w=167&h=167&qrContent=${param.host }/exts/koreahana/mbl/mobileUpload.do?c=${c }" />" alt="" />
        </div>
        QR코드 유효 시간 <span class="txt_c_re"><b id="popup_timer">2분 20초</b></span>
        <br /><br />
</div>
      
<div  id="popup_reloadDiv" style="display:none">
	<div class="box_w_gray AlignCenter"><br />
	  <b>QR코드 유효 시간이 만료되었습니다.</b><br />
	  QR코드 스캔을 다시 시도하시려면 [재시도]를 눌러주세요.<br />
	  <div class="btn_reload">
	    <a href="#" onclick="popup_fnReload();return false;"><img src="/support/img/content/reload.png" alt="reload"/><br />
	      <span class="txt_c_bl"><b>재시도</b></span></a>
	  </div>
	  <br /><br />
	</div>
</div>