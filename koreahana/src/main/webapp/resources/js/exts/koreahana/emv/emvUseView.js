$(document).ready(function(){
	$('#listBtn').on('click',fnList);
	$('#modifyBtn').on('click',fnModify);
	$('#deleteBtn').on('click',fnDelete);
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#keuMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {keuMode:'deleteActionJson',emvucdUseInfoSn:$('#emvucdUseInfoSn').val()}, fnList);
	}
}
