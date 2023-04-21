$(document).ready(function(){
	$('#listBtn').on('click',fnList);
	$('#modifyBtn').on('click',fnModify);
	$('#deleteBtn').on('click',fnDelete);
	$('#sprtSttsSaveBtn').on('click', fnSprtSttsCdSave);
	
	var ajSttsform = new ComAjaxForm('writeSprtSttsForm','', {reload:'Y'});
	ajSttsform.init();
	
	fnSprtSttsChg($("#sprtSttsCdTmp").val());
	
	//정보동의
	$('#collectAgreeYn').prop('checked',true);
	$('#thirdPartyAgreeYn').prop('checked',true);
});

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		var ajDeleteform = new ComAjaxForm('deletePageForm','listPageForm', {});
		ajDeleteform.init();
	
		$("#deletePageForm [name=sprtSn]").val($('#sprtSn').val());
		$("#deletePageForm").submit();
		return false;
	}
}

//제출서류 다운로드(제출자가 제출한 첨부파일)
function fnMyFileDownload(atchFileSn){
	var sprtSn = $("#sprtSn").val();
	$("#myFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#myFileDownloadForm [name=atchFileSn]").val(atchFileSn);
	$("#myFileDownloadForm").attr('target', 'downloadFrame');
	$("#myFileDownloadForm").submit();
}

//제출서류전체 다운로드
function fnSprtFileAllDonwload(){
	$("#allDownloadForm [name=sprtSn]").val($("#sprtSn").val());
	$("#allDownloadForm").attr('target', 'downloadFrame');
	$("#allDownloadForm").submit();
}

//제출서류양식 다운로드
function fnDocFormDownload(smbsnDocFormSn){
	$("#docDownloadForm [name=smbsnDocFormSn]").val(smbsnDocFormSn);
	$("#docDownloadForm").attr('target', 'downloadFrame');
	$("#docDownloadForm").submit();
}

function fnSprtSttsCdSave(){
	if(confirm('선정결과를 저장하시겠습니까?')){
		$("#writeSprtSttsForm").submit();
	}
}

//선정결과값 변경
function fnSprtSttsChg(sprtSttsCd){
	if(sprtSttsCd == undefined || sprtSttsCd == null || sprtSttsCd == '') return false;
	if(sprtSttsCd == '16005'){		//서류미비
		$("#rsn").show();
	}else{
		$("#rsn").hide();
	}
}