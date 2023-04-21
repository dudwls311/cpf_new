$(document).ready(function(){
	//국민기초생활수급확인서 이벤트 바인드
	fnFileEvent('#rcoblSgntFileSn');
	fnFileEvent('#ntkrdfAcrtfctFileSn');
	
	if($("#sprtSn").val() == '' ){
		var vdoType = $("#vdoType").val();
		if(vdoType == 'NTK_PRT' || vdoType == 'NOR_PRT'){
			fnFavoSgnLoad('prtcr');		//최초 등록시 즐겨찾기 서명 가져오기
		}else{
			fnFavoSgnLoad();
		}
	}
	
	ComFns.sgnLoad('sgntFileSn');
	ComFns.sgnLoad('prtcrSgntFileSn');
	
	fnToggleShow($('[name=rcoblYn]:checked').val(), '#rcoblSgntFile');
	$("[name=rcoblYn]").on('change', function(){
		fnToggleShow($('[name=rcoblYn]:checked').val(), '#rcoblSgntFile');
	});
	
	var vdoType = $("#vdoType").val();
	if(vdoType == 'NOR_PRT'){
		fnBrplcCdToggleShow($('[name=brplcCd]:checked').val(), '#ntkrdfSe');
		$("[name=brplcCd]").on('change', function(){
			fnBrplcCdToggleShow($('[name=brplcCd]:checked').val(), '#ntkrdfSe');
		});
	}
	
});

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
		var fileDoc = fileId+'Doc';
		
		$('#'+fileId).val('');
		$('#'+fileFsnId).val('');
	    $("#"+fileNmId).empty();
	    $("#"+fileTrg).show();
	    $("#"+fileDoc).show();
	    return false;
	});
}

function fnToggleShow(chkValue, fileId){
	if(chkValue == undefined || chkValue == null) return false;
	
	if(chkValue == 'Y'){
		$(fileId+'Tr').show();
	}else{
		$(fileId+'Tr').hide();
		$(fileId+'SnFileDelete').trigger('click');
	}
}

function fnBrplcCdToggleShow(chkValue, fileId){
	if(chkValue == undefined || chkValue == null) return false;
	
	if(chkValue == '3001'){
		//출생지 북한 선택시
		$(fileId+'Span1').show();
		$(fileId+'Span2').hide();
		$("[name=ntkrdfSe][value=본인]").prop('checked', true);
		$("#ntkrdfFlnm").val('');
	}else{
		$(fileId+'Span1').hide();
		$(fileId+'Span2').show();
		$("[name=ntkrdfSe][value=본인]").prop('checked', false);
	}
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

function fnPrtcrAddr(){
	//공통 주소찾기 호출
	fnComAddressFind(function(data){
		$('#prtcrZip').val(data.zip);
		$('#prtcrAddr').val(data.address);
		$('#prtcrDaddr').val(data.addressDetail);
		
	});
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