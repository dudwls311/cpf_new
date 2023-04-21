$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(pbancrcSn){
	$("#writePageForm #kpMode").val('view');
	$("#writePageForm #pbancrcSn").val(pbancrcSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(pbancrcSn){
	$("#writePageForm #kpMode").val('write');
	$("#writePageForm #pbancrcSn").val(pbancrcSn);
	$("#writePageForm").submit();
}

//추가/수정
function fnSprtWrite(pbancrcSn){
	$("#sprtWritePageForm #pbancrcSn").val(pbancrcSn);
	$("#sprtWritePageForm").submit();
}
