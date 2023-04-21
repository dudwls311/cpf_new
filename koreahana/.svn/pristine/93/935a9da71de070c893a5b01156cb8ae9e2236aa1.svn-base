
//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#ksMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//북한이탈주민인증서파일 다운로드
function fnNtkrdfAcrtfctFileDownload(){
	var sprtSn = $("#sprtSn").val();
	$("#ntkrdfAcrtfctFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#ntkrdfAcrtfctFileDownloadForm").attr('target', 'downloadFrame');
	$("#ntkrdfAcrtfctFileDownloadForm").submit();
}