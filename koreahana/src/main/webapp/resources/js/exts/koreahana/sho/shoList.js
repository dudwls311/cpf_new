//상세
function fnView(sprtSn){
	$("#ksMode").val('view');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(sprtSn){
	$("#ksMode").val('write');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#ksMode').val('excelUpload');
	$('#sprtSn').val('');
	$('#writePageForm').submit();
}


function fnRsnChg(sprtSn){
	ComFns.popup.init({title:'서류미비 사유'});
	ComFns.popup.loadContent(actionUrl, {ksMode:'writeRsnJson', sprtSn:sprtSn} );
	ComFns.popup.setConfirmBtnClickMethod(fnRsnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

function fnRsnSave(){
	$("#rsnAjaxForm").submit();
}