$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(emvucdUseInfoSn){
	$("#keuMode").val('view');
	$("#emvucdUseInfoSn").val(emvucdUseInfoSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(emvucdUseInfoSn){
	$("#keuMode").val('write');
	$("#emvucdUseInfoSn").val(emvucdUseInfoSn);
	$("#writePageForm").submit();
}

//삭제
function fnDelete(emvucdUseInfoSn){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {keuMode:'deleteActionJson',emvucdUseInfoSn:emvucdUseInfoSn}, function(){location.reload();});
	}
}

//일괄업로드
function fnWriteBundle(){
	$('#keuMode').val('excelUpload');
	$('#emvucdUseInfoSn').val('');
	$('#writePageForm').submit();
}
