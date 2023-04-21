$(document).ready(function(){
	$('.st_select2').select2();

	$("#pbancrcSn").on('change', function(){
		$("#searchForm").submit();
	});
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(sprtSn){
	$("#kspMode").val('view');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(sprtSn){
	$("#kspMode").val('write');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#kspMode').val('excelUpload');
	$('#sprtSn').val('');
	$('#writePageForm').submit();
}