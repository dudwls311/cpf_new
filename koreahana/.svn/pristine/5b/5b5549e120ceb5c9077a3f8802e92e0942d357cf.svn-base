$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();

	fnCheckPass();	
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#sprtSn').val() != ''){
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

//합격일 체크
function fnCheckPass(){
	$('#passYmd').prop('disabled','33002' != $('#writeForm input[name="testRsltCd"]:checked').val());
}