$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(docBoxSn){
	$("#kdMode").val('view');
	$("#docBoxSn").val(docBoxSn);
	$("#docWritePageForm").submit();
}


//추가/수정
function fnWrite(docBoxSn){
	ComFns.popup.init({title:'문서 선택'});
	ComFns.popup.loadContent($("#actionUrl").val(), {kdMode:'write',docBoxSn:docBoxSn} );
	ComFns.popup.setConfirmBtnClickMethod(fnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm').submit();
		return false;
	}
}

//삭제
function fnDelete(docBoxSn){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax($("#actionUrl").val(), {kdMode:'deleteActionJson',docBoxSn:docBoxSn}, fnSuccessReload);
	}
}

function fnSuccessReload(){
	location.reload();
}

//첨부파일 다운로드
function fnDownload(docBoxSn){
	$("#downloadForm [name=docBoxSn]").val(docBoxSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}