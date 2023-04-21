$(document).ready(function(){
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();

	//첨부파일 클릭 트리거
	$("a[id$=Trg]").on('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$("input[type=file]").on('change', function(){
		var fileId = $(this).attr('id');
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$("a[id$=Delete]").on('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileNmId = fileId+'FileNm';
		
		$('#'+fileId).val('');
	    $("#"+fileNmId).empty();
	    return false;
	});
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#docBoxSn').val() != ''){
		$("#viewPageForm").submit();	
	}else{
		fnList();
	}
	return false;
}

//첨부파일 다운로드
function fnDownload(docBoxSn){
	$("#downloadForm [name=docBoxSn]").val(docBoxSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}