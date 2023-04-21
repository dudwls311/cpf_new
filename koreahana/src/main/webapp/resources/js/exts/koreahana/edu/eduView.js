//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#keMode").val('write');
	$("#writePageForm").submit();
	return false;
}