$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(fthpbbMdwCncltnSn){
	$("#kfmMode").val('view');
	$("#fthpbbMdwCncltnSn").val(fthpbbMdwCncltnSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(fthpbbMdwCncltnSn){
	$("#kfmMode").val('write');
	$("#fthpbbMdwCncltnSn").val(fthpbbMdwCncltnSn);
	$("#writePageForm").submit();
}


//일괄업로드
function fnWriteBundle(){
	$('#kfmMode').val('excelUpload');
	$('#fthpbbMdwCncltnSn').val('');
	$('#writePageForm').submit();
}