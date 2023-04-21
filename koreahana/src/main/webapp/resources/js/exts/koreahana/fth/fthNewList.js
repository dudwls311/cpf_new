$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(fthpbbNewAplySn){
	$("#kfnMode").val('view');
	$("#fthpbbNewAplySn").val(fthpbbNewAplySn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(fthpbbNewAplySn){
	$("#kfnMode").val('write');
	$("#fthpbbNewAplySn").val(fthpbbNewAplySn);
	$("#writePageForm").submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#kfnMode').val('excelUpload');
	$('#fthpbbNewAplySn').val('');
	$('#writePageForm').submit();
}