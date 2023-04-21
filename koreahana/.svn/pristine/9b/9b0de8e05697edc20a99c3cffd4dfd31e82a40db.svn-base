$(document).ready(function(){
	$('#listBtn').on('click',fnList);
	$('#modifyBtn').on('click',fnModify);
	$('#deleteBtn').on('click',fnDelete);
	$('#requestBtn').on('click',fnRequest);
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#kpMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//수정
function fnRequest(){
	$("#requestForm").submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {kpMode:'deleteActionJson',pbancrcSn:$('#pbancrcSn').val()}, fnList);
	}
}

//첨부파일 다운로드
function fnDownload(atchFileSn, pbancrcSn){
	$("#downloadForm [name=atchFileSn]").val(atchFileSn);
	$("#downloadForm [name=pbancrcSn]").val(pbancrcSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}
