$(document).ready(function(){
});

//추가/수정
function fnWrite(ctgryFrstCd){
	$("#ksMode").val('write');
	$("#ctgryFrstCd").val(ctgryFrstCd);
	$("#writePageForm").submit();
}
