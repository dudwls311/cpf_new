$(document).ready(function(){
});

//페이징
function fnPage(p){
	$('#pageIndex').val(p);
	$('#listPageForm').submit();
}

//상세
function fnView(mdlcrSprtSn){
	$('#kmMode').val('view');
	$('#mdlcrSprtSn').val(mdlcrSprtSn);
	$('#writePageForm').submit();
}


//추가/수정
function fnWrite(mdlcrSprtSn){
	$('#kmMode').val('write');
	$('#mdlcrSprtSn').val(mdlcrSprtSn);
	$('#writePageForm').submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#kmMode').val('excelUpload');
	$('#mdlcrSprtSn').val('');
	$('#writePageForm').submit();
}