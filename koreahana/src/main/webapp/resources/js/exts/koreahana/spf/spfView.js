//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#ksMode").val('write');
	$("#writePageForm").submit();
	return false;
}