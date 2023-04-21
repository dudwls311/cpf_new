$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {
		beforeSerializeFunction:function(form, options){
			$('#mbphno').val($('#mbphnoSplit0').val() + '-' + $('#mbphnoSplit1').val() + '-' + $('#mbphnoSplit2').val());
		}
	});
	ajform.init();
	
	$('input[name="rcmtFldCd"]').on('click',fnChangeRcmtFldCd);
	fnChangeRcmtFldCd();
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#mgmipvAmtSprtSn').val() != ''){
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

//이력 상세보기
function fnView(sn){
	$('#viewPageForm [name="mgmipvAmtSprtSn"]').val(sn);
	$('#viewPageForm').submit();
	return false;
}

//모집분야변경시
function fnChangeRcmtFldCd(){
	$('#viH4').hide();
	$('#viTable').hide();
	if($('input[name="rcmtFldCd"]:checked').val() == $('#RCMT_FLD_CD_VEHICLE').val()){//운수업일때
		$('#viH4').show();
		$('#viTable').show();
	}
}