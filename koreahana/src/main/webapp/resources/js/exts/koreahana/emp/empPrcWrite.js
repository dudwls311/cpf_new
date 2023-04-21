$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();
	
	$('#crtfctAcqsYn').on('click',fnChangeCrtf);
	$('#empmYn').on('click',fnChangeEmpm);
	fnChangeCrtf();
	fnChangeEmpm();
	
	ComFns.betweenDatepickerOption('#eduBgngYmd','#eduEndYmd');
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#empcnnVoctrnPcrnMngSn').val() != ''){
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


function fnChangeCrtf(){
	$('#crtfctInfo').prop('disabled',$('#crtfctAcqsYn:checked').length == 0);
}


function fnChangeEmpm(){
	$('#empmCoNm').prop('disabled',$('#empmYn:checked').length == 0);
}