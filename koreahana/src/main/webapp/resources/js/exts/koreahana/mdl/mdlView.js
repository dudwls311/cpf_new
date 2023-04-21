$(document).ready(function(){
	$('#listBtn').on('click',fnList);
	$('#modifyBtn').on('click',fnModify);
	$('#deleteBtn').on('click',fnDelete);
	
});

//리스트
function fnList(){
	$('#listPageForm').submit();
	return false;
}

//수정
function fnModify(){
	$('#kmMode').val('write');
	$('#writePageForm').submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {kmMode:'deleteActionJson',mdlcrSprtSn:$('#mdlcrSprtSn').val()}, fnList);
	}
}

//이력 상세보기
function fnView(sn){
	$('#viewPageForm [name="mdlcrSprtSn"]').val(sn);
	$('#viewPageForm').submit();
	return false;
}
