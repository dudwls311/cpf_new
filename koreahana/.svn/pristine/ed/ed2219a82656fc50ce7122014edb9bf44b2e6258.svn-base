$(document).ready(function(){
	$('#listBtn').on('click',fnList);
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//첨부파일 다운로드
function fnDownload(atchFileSn, pbancrcSn){
	$("#downloadForm [name=atchFileSn]").val(atchFileSn);
	$("#downloadForm [name=pbancrcSn]").val(pbancrcSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}

//신청하기
function fnWrite(pbancrcSn){
	$("#writePageForm [name$=Mode]").val('write');
	$("#writePageForm #pbancrcSn").val(pbancrcSn);
	$("#writePageForm").submit();
}