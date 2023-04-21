$(document).ready(function(){
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(frmSpfstSn){
	$("#kfMode").val('view');
	$("#frmSpfstSn").val(frmSpfstSn);
	$("#writePageForm").submit();
}


//추가/수정
function fnWrite(frmSpfstSn){
	$("#kfMode").val('write');
	$("#frmSpfstSn").val(frmSpfstSn);
	$("#writePageForm").submit();
}

//일괄업로드
function fnWriteBundle(){
	$('#kfMode').val('excelUpload');
	$('#frmSpfstSn').val('');
	$('#writePageForm').submit();
}

//전체선택
function fnChkAll(){
	var isAllChecked = $("#chkAll").is(':checked');
	if(isAllChecked == true){
		$("[id*=frmChk_]").prop('checked', true);
	}else{
		$("[id*=frmChk_]").prop('checked', false);
	}
}

//선택삭제
function fnDeleteAll(){
	var chkCnt = $("[id*=frmChk_]:checked").length;
	
	if(chkCnt < 1){
		alert('삭제할 항목을 선택해주세요.');
		return false;
	}else{
	
		if(confirm(Msg.com.confirmDelete)){
			var frmSpfstSnArr = '';
			$($("[id*=frmChk_]:checked")).each(function(fnIdx, fnObj){
				if(fnIdx == 0){
					frmSpfstSnArr = fnObj.value;
				}else{
					frmSpfstSnArr += ','+fnObj.value;
				}
			});
			
			ComFns.ajax(ComFns.getContextUrl()+'exts/koreahana/frm/index.do', {kfMode:'deleteAllActionJson',frmSpfstSnArr:frmSpfstSnArr}, fnDeleteAllSuccess);
		}
	}
}

function fnDeleteAllSuccess(){
	alert('처리 되었습니다.');
	location.reload();
}