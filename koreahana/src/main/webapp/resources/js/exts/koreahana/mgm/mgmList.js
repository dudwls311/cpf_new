$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(mgmipvAmtSprtSn){
	$("#kmMode").val('view');
	$("#mgmipvAmtSprtSn").val(mgmipvAmtSprtSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(mgmipvAmtSprtSn){
	$("#kmMode").val('write');
	$("#mgmipvAmtSprtSn").val(mgmipvAmtSprtSn);
	$("#writePageForm").submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#kmMode').val('excelUpload');
	$('#mgmipvAmtSprtSn').val('');
	$('#writePageForm').submit();
}
