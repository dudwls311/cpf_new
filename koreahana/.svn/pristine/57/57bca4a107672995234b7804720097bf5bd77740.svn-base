$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();
	
	$('#frstCardNo').mask('0000-0000-0000-0000');
	$('#scndryCardNo').mask('0000-0000-0000-0000');
	$('#thirdCardNo').mask('0000-0000-0000-0000');
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#sprtSn').val() != ''){
		$("#viewPageForm").submit();	
	}else{
		fnList();
	}
	return false;
}


//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm').submit();
		return false;
	}
}

//수강정보 추가
function fnEmvPrcTkcAdd(){
	var tbodyObj = $("#emvPrcTkcBody");
	var lastTr = tbodyObj.find('tr').last();
	var nextSort = 1;
	if(lastTr.data('sort') != undefined) nextSort = Number(lastTr.data('sort'))+1;
	
	var html = $("#emvPrcTkcForm").html().replace('<tbody>', '').replace('</tbody>', '').replace(/@nextSort@/g, nextSort).replace(/@.+@/g, '');
	if(lastTr != undefined){
		tbodyObj.append(html);
	}else{
		lastTr.after(html);
	}
}

//수강정보 제거
function fnEmvPrcTkcDel(){
	var tbodyObj = $("#emvPrcTkcBody");
	var lastTr = tbodyObj.find('tr').last();
	if(lastTr != undefined) lastTr.remove();
}