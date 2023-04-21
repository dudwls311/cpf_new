
//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#kaMode").val('write');
	$("#writePageForm").submit();
	return false;
}