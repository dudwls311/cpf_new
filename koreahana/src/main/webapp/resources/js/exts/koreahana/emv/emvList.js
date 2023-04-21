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

//사유보기
function fnEmvRsnShow(pbancrcSn, pbancrcCtgryFrstCd, sprtSn){
	$("#emvPageForm [name=pbancrcSn]").val(pbancrcSn);
	$("#emvPageForm [name=pbancrcCtgryFrstCd]").val(pbancrcCtgryFrstCd);
	$("#emvPageForm [name=sprtSn]").val(sprtSn);
	ComFns.popup.init({title:'서류미비 사유'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/spr/index.do', {ksMode:'showRsnAjax', sprtSn:sprtSn} );
	ComFns.popup.setConfirmBtnClickMethod(fnEmvWirtePageMove);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//사유 팝업창에서 수정페이지로 이동
function fnEmvWirtePageMove(){
	$("#emvPageForm").submit();
	return false;
}