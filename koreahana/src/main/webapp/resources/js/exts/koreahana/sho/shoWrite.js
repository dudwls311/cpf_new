$(document).ready(function(){
	fnSholSlctnType($("#sholSlctnTypeTmp").val());
	
	//북한이탈주민 인증서 이벤트 바인드
	fnFileEvent('#ntkrdfAcrtfctFileSn');
	
	if($("#sprtSn").val() == '') fnFavoSgnLoad();		//최초 등록시 즐겨찾기 서명 가져오기
	ComFns.sgnLoad('sgntFileSn');
});

//선택한 제출서류만 보여주기
function fnSholSlctnType(smbsnDocTypeVl){
	if(smbsnDocTypeVl == undefined || smbsnDocTypeVl == null ) smbsnDocTypeVl = '';
	if(smbsnDocTypeVl.indexOf('_') != -1) smbsnDocTypeVl = smbsnDocTypeVl.substr(0, smbsnDocTypeVl.indexOf('_'));
	
	var divObj = $('#SMB_'+smbsnDocTypeVl);
	var smbAllDiv = $('div[id^=SMB_ntkrdf],div[id^=SMB_thirdcnty]');
	$("#sholSlctnTypeValue").val(smbsnDocTypeVl);
	smbAllDiv.hide();
	divObj.show();
}

function fnFileEvent(id){
	id = id+'FileForm';
	//첨부파일 클릭 트리거
	$(id).find("a[id$=Trg]").on('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$(id).find("input[type=file]").on('change', function(){
		var fileId = $(this).attr('id');
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$(id).find("a[id$=Delete]").on('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileFsnId = $(this).attr('id').replace('FileDelete', '')+'Fsn';
		var fileNmId = fileId+'FileNm';
		var fileTrg = fileId+'Trg';
		
		$('#'+fileId).val('');
		$('#'+fileFsnId).val('');
	    $("#"+fileNmId).empty();
	    $("#"+fileTrg).show();
	    return false;
	});
}

function fnAddr(){
	//공통 주소찾기 호출
	fnComAddressFind(function(data){
		$('#zip').val(data.zip);
		$('#addr').val(data.address);
		$('#daddr').val(data.addressDetail);
		
	});
	return false;
}

//북한이탈주민인증서파일 다운로드
function fnNtkrdfAcrtfctFileDownload(){
	var sprtSn = $("#sprtSn").val();
	$("#ntkrdfAcrtfctFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#ntkrdfAcrtfctFileDownloadForm").attr('target', 'downloadFrame');
	$("#ntkrdfAcrtfctFileDownloadForm").submit();
}