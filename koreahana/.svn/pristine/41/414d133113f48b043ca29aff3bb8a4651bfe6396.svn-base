$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {
		beforeSerializeFunction:function(form, options){
			$('#mbphno').val($('#mbphnoSplit0').val() + '-' + $('#mbphnoSplit1').val() + '-' + $('#mbphnoSplit2').val());
		}
	});
	ajform.init();

	$('#sprtDcsnAmt').on('keyup',fnCalNoExeAmt);
	$('#sprtAmt').on('keyup',fnCalNoExeAmt);
	fnCalNoExeAmt();
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#frmSpfstSn').val() != ''){
		$("#viewPageForm").submit();	
	}else{
		fnList();
	}
	return false;
}


//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm').submit();
		return false;
	}
}

//미지급액 계산
function fnCalNoExeAmt(){
	var _sprtDcsnAmt = $('#sprtDcsnAmt').val();
	var _sprtAmt = $('#sprtAmt').val();
	var _t = '';
	if(!isNaN(_sprtDcsnAmt) && !isNaN(_sprtAmt))_t = _sprtDcsnAmt - _sprtAmt;
	$('#noExeAmtSpan').text(_t);
}