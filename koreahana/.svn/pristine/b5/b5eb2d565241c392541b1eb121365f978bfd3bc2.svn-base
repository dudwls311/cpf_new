//상세
function fnView(sprtSn){
	$("#keMode").val('view');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(sprtSn){
	$("#keMode").val('write');
	$("#sprtSn").val(sprtSn);
	$("#writePageForm").submit();
}


function fnRsnChg(sprtSn){
	ComFns.popup.init({title:'서류미비 사유'});
	ComFns.popup.loadContent(actionUrl, {keMode:'writeRsnJson', sprtSn:sprtSn} );
	ComFns.popup.setConfirmBtnClickMethod(fnRsnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

function fnRsnSave(){
	$("#rsnAjaxForm").submit();
}