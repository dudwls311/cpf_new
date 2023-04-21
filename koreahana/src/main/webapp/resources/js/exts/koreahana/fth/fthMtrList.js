$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(fthpbbMtryCncltnSn){
	$("#kfmMode").val('view');
	$("#fthpbbMtryCncltnSn").val(fthpbbMtryCncltnSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(fthpbbMtryCncltnSn){
	$("#kfmMode").val('write');
	$("#fthpbbMtryCncltnSn").val(fthpbbMtryCncltnSn);
	$("#writePageForm").submit();
}


//일괄업로드
function fnWriteBundle(){
	$('#kfmMode').val('excelUpload');
	$('#fthpbbMtryCncltnSn').val('');
	$('#writePageForm').submit();
}