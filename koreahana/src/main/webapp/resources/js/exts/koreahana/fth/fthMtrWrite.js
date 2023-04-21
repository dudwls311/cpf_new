$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {
		beforeSerializeFunction:function(form, options){
			$('#rrno').val($('#rrno1').val() + '-' + $('#rrno2').val());
			$('#mbphno').val($('#mbphnoSplit0').val() + '-' + $('#mbphnoSplit1').val() + '-' + $('#mbphnoSplit2').val());
		}
	});
	ajform.init();
	
	$('#ctpvCd').on('change',fnChangeCtpvCd);
	fnChangeCtpvCd();
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#fthpbbMtryCncltnSn').val() != ''){
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

//시도코드 변경
function fnChangeCtpvCd(){
	ComFns.makeCodeSelectTagByUprCd($('#ctpvCd').val(), '#sggCd', $('#or_sggCd').val(), '선택', $('#enum_sggCd').val());
}