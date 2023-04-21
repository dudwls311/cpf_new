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
	$("#kspMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {kspMode:'deleteActionJson',sprtSn:$('#sprtSn').val()}, fnList);
	}
}


//수험표출력
function fnTestIdPrint(){
	var _url = actionUrl;
	_url += '?kspMode=print&sprtSn=' + $('#sprtSn').val();
	window.open(_url, 'winPrint','width=870,height=800,scroll=No');
}