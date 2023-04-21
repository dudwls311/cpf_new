//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#kvMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//기초생활수급자인증서파일 다운로드
function fnRcoblSgntFileDownload(){
	var sprtSn = $("#sprtSn").val();
	$("#rcoblSgntFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#rcoblSgntFileDownloadForm").attr('target', 'downloadFrame');
	$("#rcoblSgntFileDownloadForm").submit();
}

//북한이탈주민인증서파일 다운로드
function fnNtkrdfAcrtfctFileDownload(){
	var sprtSn = $("#sprtSn").val();
	$("#ntkrdfAcrtfctFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#ntkrdfAcrtfctFileDownloadForm").attr('target', 'downloadFrame');
	$("#ntkrdfAcrtfctFileDownloadForm").submit();
}