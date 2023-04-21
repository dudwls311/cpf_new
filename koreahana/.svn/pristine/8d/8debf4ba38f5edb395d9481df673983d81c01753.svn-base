$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(pbancrcCtgryFrstCd, pbancrcSn, sprtSn){
	$("#pageForm [name=ksMode]").val('view');
	$("#pageForm [name=pbancrcCtgryFrstCd]").val(pbancrcCtgryFrstCd);
	$("#pageForm [name=pbancrcSn]").val(pbancrcSn);
	$("#pageForm [name=sprtSn]").val(sprtSn);
	$("#pageForm").submit();
}


//추가/수정
function fnWrite(pbancrcCtgryFrstCd, pbancrcSn, sprtSn){
	$("#pageForm [name=ksMode]").val('write');
	$("#pageForm [name=pbancrcCtgryFrstCd]").val(pbancrcCtgryFrstCd);
	$("#pageForm [name=pbancrcSn]").val(pbancrcSn);
	$("#pageForm [name=sprtSn]").val(sprtSn);
	$("#pageForm").submit();
}

//사유보기
function fnRsnShow(sprtSn){
	ComFns.popup.init({title:'서류미비 사유'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/spr/index.do', {ksMode:'showRsnAjax', sprtSn:sprtSn} );
	ComFns.popup.setConfirmBtnClickMethod(fnWirtePageMove);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//사유 팝업창에서 수정페이지로 이동
function fnWirtePageMove(){
	$("#sprPageForm").submit();
	return false;
}


//수험표인쇄
function fnTstIdtfPrint(sprtSn){
	var _url = '/user/exts/koreahana/spf/index.do';
	_url += '?ksMode=print&sprtSn=' + sprtSn;
	window.open(_url, 'winPrint','width=870,height=800,scroll=No');
}