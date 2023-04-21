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
	$("#kdMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {kdMode:'deleteActionJson',docBoxSn:$('#docBoxSn').val()}, fnList);
	}
}

//첨부파일 다운로드
function fnDownload(docNo, atchFileSno){
	$("#downloadForm [name=docNo]").val(docNo);
	$("#downloadForm [name=atchFileSno]").val(atchFileSno);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}
