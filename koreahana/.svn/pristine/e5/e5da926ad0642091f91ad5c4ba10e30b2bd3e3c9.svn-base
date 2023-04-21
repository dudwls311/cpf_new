$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(sgntSn){
	$("#ksMode").val('view');
	$("#sgntSn").val(sgntSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(){
	ComFns.popup.init({title:'서명 선택'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do', {ksMode:'write'} );
	ComFns.popup.setConfirmBtnClickMethod(fnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//추가/수정
function fnWriteFile(){
	ComFns.popup.init({title:'서명 선택'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do', {ksMode:'writeFile'} );
	ComFns.popup.setConfirmBtnClickMethod(fnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		if(sign != ''){
			//서명파일(그리기)
			if(sign.isEmpty()){
				alert('서명파일을 그려주세요.');
				return false;
			}else{
				$("#signDataUrl").val(sign.toDataURL());
			}
		}
		$('#sgnWriteForm').submit();
	}
}

//삭제
function fnDelete(sgntSn){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do', {ksMode:'deleteActionJson',sgntSn:sgntSn}, fnSuccessReload);
	}
}

//메인변경
function fnMainChange(sgntSn){
	if(sgntSn == undefined || sgntSn == null || sgntSn == '') return false;
	ComFns.ajax(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do', {ksMode:'favoChgActionJson',sgntSn:sgntSn}, fnSuccessReload);
}

function fnSuccessReload(){
	location.reload();
}