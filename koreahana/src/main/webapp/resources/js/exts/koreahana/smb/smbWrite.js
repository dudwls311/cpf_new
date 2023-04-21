//제출서류 다운로드(제출자가 제출한 첨부파일)
function fnMyFileDownload(atchFileSn){
	var pbancrcSn = $("#pbancrcSn").val();
	var sprtSn = $("#sprtSn").val();
	$("#myFileDownloadForm [name=pbancrcSn]").val(pbancrcSn);
	$("#myFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#myFileDownloadForm [name=atchFileSn]").val(atchFileSn);
	
	$("#myFileDownloadForm").attr('target', 'downloadFrame');
	$("#myFileDownloadForm").submit();
}

//제출서류양식 다운로드
function fnDocFormDownload(smbsnDocFormSn){
	$("#docDownloadForm [name=smbsnDocFormSn]").val(smbsnDocFormSn);
	$("#docDownloadForm").attr('target', 'downloadFrame');
	$("#docDownloadForm").submit();
}

//제출서류 첨부파일
function fnSetSmbFile(){
	var smbListJson = $.parseJSON($("#smbListJson").val());
	var smbDocFormListJson = $.parseJSON($("#smbDocFormListJson").val());
	var smbMpnListJson = $.parseJSON($("#smbMpnListJson").val());
	
	//제출서류 변수
	var pbancrcSn = $("#writeForm #pbancrcSn").val();
	var smbsnDocFormSn = '';
	var docBoxYn = '';
	var smbsnDocMtlYn = '';
	var smbsnDocNm = '';
	var smbsnDocRqrYn = '';
	var smbsnDocSn = '';
	var smbsnDocTypeSn = '';
	var smbsnDocTypeVl = '';
	var smbsnRsn = '';
	
	//제출서류 샘플파일 변수
	var orgnlAtchFileNm = '';

	var nextSort = 1;
	var prefix = '';
	var subPrefix = '';
	
	$(smbListJson).each(function(fnIdx1, fnObj1){
		if(smbsnDocFormSn != fnObj1.smbsnDocFormSn) nextSort = 1;
		smbsnDocFormSn = fnObj1.smbsnDocFormSn;
		docBoxYn = fnObj1.docBoxYn;
		smbsnDocMtlYn = fnObj1.smbsnDocMtlYn;
		smbsnDocNm = fnObj1.smbsnDocNm;
		smbsnDocRqrYn = fnObj1.smbsnDocRqrYn;
		smbsnDocSn = fnObj1.smbsnDocSn;
		smbsnDocTypeSn = fnObj1.smbsnDocTypeSn;
		smbsnDocTypeVl = 'SMB_'+fnObj1.smbsnDocTypeVl;
		smbsnRsn = fnObj1.smbsnRsn;
		prefix = smbsnDocSn+'_';
		subPrefix = prefix+nextSort+'_';
		
		//제출서류 샘플파일
		orgnlAtchFileNm = '';
		$(smbDocFormListJson).each(function(fnIdx2, fnObj2){
			if(smbsnDocFormSn == fnObj2.atchFileSn){
				orgnlAtchFileNm = fnObj2.orgnlAtchFileNm;
			}
		});
		
		//제출서류 첨부파일
		var smbMpnList = new Array();
		$(smbMpnListJson).each(function(fnIdx3, fnObj3){
			if(smbsnDocSn == fnObj3.smbsnDocSn){
				smbMpnList.push(fnObj3);
			}
		});
		
		fnSmbFileTrFormSet(smbsnDocTypeVl, prefix, smbsnDocTypeSn, pbancrcSn, smbsnDocSn, smbsnDocNm, smbsnDocFormSn, smbsnRsn, smbsnDocRqrYn, smbsnDocMtlYn, docBoxYn, orgnlAtchFileNm, smbMpnList);
		nextSort++;
	});
}

//제출서류 첨부파일폼 추가
function fnSmbFileTrFormSet(smbsnDocTypeVl, prefix, smbsnDocTypeSn, pbancrcSn, smbsnDocSn, smbsnDocNm, smbsnDocFormSn, smbsnRsn, smbsnDocRqrYn, smbsnDocMtlYn, docBoxYn, orgnlAtchFileNm, smbMpnList){
	var html = fnSmbFileTrForm(prefix, pbancrcSn, smbsnDocSn, smbsnDocNm, smbsnDocFormSn, smbsnRsn, smbsnDocRqrYn, smbsnDocMtlYn, docBoxYn, orgnlAtchFileNm, smbMpnList);
	$("#"+smbsnDocTypeVl+" #smbsnDocTbody").append(html);
	
	$("#"+prefix+" > [id$=Form]").find("a[id$=Trg]").unbind('click');
	$("#"+prefix+" > [id$=Form]").find("input[type=file]").unbind('change');
	$("#"+prefix+" > [id$=Form]").find("a[id$=Delete]").unbind('click');
	
	
	//첨부파일 클릭 트리거
	$("#"+prefix+" > [id$=Form]").find("a[id$=Trg]").bind('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$("#"+prefix+" > [id$=Form]").find("input[type=file]").bind('change', function(){
		var fileId = $(this).attr('id');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
		$('[name='+fileId+'fsn]').val('');
		$('[name='+fileId+'mpngSn]').val('');
		$("#"+fileDivId).show();
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$("#"+prefix+" > [id$=Form]").find("a[id$=Delete]").bind('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileDivId = fileId+'Div';
		var fileFsnId = fileId+'fsn';
		var fileMpngSnId = fileId+'mpngSn';
		var fileNmId = fileId+'FileNm';
		
		$('#'+fileFsnId).val('');
		$('#'+fileMpngSnId).val('');
		$('#'+fileId).val('');
		$("#"+fileDivId).hide();
	    $("#"+fileNmId).empty();
	    return false;
	});
	
}

//첨부파일Tr폼
function fnSmbFileTrForm(prefix, pbancrcSn, smbsnDocSn, smbsnDocNm, smbsnDocFormSn, smbsnRsn, smbsnDocRqrYn, smbsnDocMtlYn, docBoxYn, orgnlAtchFileNm, smbMpnList){
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(pbancrcSn == undefined || pbancrcSn == null || pbancrcSn == '') return '';
	if(smbsnDocSn == undefined || smbsnDocSn == null || smbsnDocSn == '') smbsnDocSn = '';
	if(smbsnDocNm == undefined || smbsnDocNm == null) smbsnDocNm = '';
	if(smbsnDocFormSn == undefined || smbsnDocFormSn == null) smbsnDocFormSn = '';
	if(smbsnRsn == undefined || smbsnRsn == null) smbsnRsn = '';
	if(orgnlAtchFileNm == undefined || orgnlAtchFileNm == null) orgnlAtchFileNm = '';
	if(smbMpnList == undefined || smbMpnList == '') smbMpnList = null;
	
	var nextSort = 1;
	var subPrefix = prefix+nextSort+'_';
	
	var smbFileTrForm = $("#smbFileTrForm").html().replace('<tbody>', '').replace('</tbody>', '');
	var smbsnDocRqrYnForm = fnSmbsnDocRqrYnForm();
	var smbsnDocMtlYnForm = fnSmbsnDocMtlYnForm(prefix, subPrefix, docBoxYn, smbsnDocMtlYn);
	var smbsnDocFileForm = fnSmbsnDocFileForm(smbsnDocSn, pbancrcSn, smbsnDocFormSn, orgnlAtchFileNm);
	var smbsnRsnForm = fnSmbsnRsnForm(smbsnRsn);
	
	var smbFileTdForm = '';
	$(smbMpnList).each(function(fnIdx, fnObj){
		var atchFileSn = fnObj.atchFileSn;
		var smbDocMpngSn = fnObj.smbDocMpngSn;
		var orgnlAtchFileNm = fnObj.orgnlAtchFileNm;
		var nextSort = (fnIdx+1);
		subPrefix = prefix+nextSort+'_';
		
		smbFileTdForm += fnSmbFileTdForm(nextSort, prefix, subPrefix, smbsnRsn, docBoxYn, smbsnDocMtlYn, atchFileSn, smbDocMpngSn, orgnlAtchFileNm);
		nextSort++;
	});
	if(smbMpnList == null) smbFileTdForm = fnSmbFileTdForm(nextSort, prefix, subPrefix, smbsnRsn, docBoxYn, smbsnDocMtlYn);
	
	smbFileTrForm = smbFileTrForm.replace(/@prefix@/g, prefix);
	smbFileTrForm = smbFileTrForm.replace(/@smbsnDocNm@/g, smbsnDocNm);
	if(smbsnDocRqrYn == 'Y') smbFileTrForm = smbFileTrForm.replace(/@@smbsnDocRqrYnForm@@/g, smbsnDocRqrYnForm);
	if(smbsnDocMtlYn == 'Y') smbFileTrForm = smbFileTrForm.replace(/@@smbsnDocMtlYnForm@@/g, smbsnDocMtlYnForm);
	smbFileTrForm = smbFileTrForm.replace(/@@smbsnDocFileForm@@/g, smbsnDocFileForm);
	smbFileTrForm = smbFileTrForm.replace(/@@smbsnRsnForm@@/g, smbsnRsnForm);
	smbFileTrForm = smbFileTrForm.replace(/@@smbFileTdForm@@/g, smbFileTdForm);
	return fnSmbsnFileReplace(smbFileTrForm);
}

//첨부파일Td폼
function fnSmbFileTdForm(nextSort, prefix, subPrefix, smbsnRsn, docBoxYn, smbsnDocMtlYn, atchFileSn, smbDocMpngSn, orgnlAtchFileNm){
	if(nextSort == undefined || nextSort == null || nextSort == '') return '';
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	if(docBoxYn == undefined || docBoxYn == null) docBoxYn = '';
	if(smbsnDocMtlYn == undefined || smbsnDocMtlYn == null) smbsnDocMtlYn = '';
	if(atchFileSn == undefined || atchFileSn == null) atchFileSn = '';
	if(smbDocMpngSn == undefined || smbDocMpngSn == null) smbDocMpngSn = '';
	if(orgnlAtchFileNm == undefined || orgnlAtchFileNm == null) orgnlAtchFileNm = '';
	
	var smbFileTdForm = $("#smbFileTdForm").html();
	var myDocBoxForm = '';
	var smbsnFileTrgForm = '';
	var smbsnFileForm = '';
	
	var display = 'display: none;';
	if(atchFileSn != ''){
		smbsnFileForm = fnSmbsnFileForm(prefix, subPrefix, atchFileSn, smbDocMpngSn, orgnlAtchFileNm);
		display = '';
	}else{
		smbsnFileForm = fnSmbsnFileNewForm(prefix, subPrefix, docBoxYn, smbsnDocMtlYn);
		myDocBoxForm = fnMyDocBoxForm(nextSort, prefix, subPrefix, docBoxYn, smbsnDocMtlYn);
		smbsnFileTrgForm = fbSmbsnFileTrgForm(subPrefix);
	}
	
	smbFileTdForm = smbFileTdForm.replace(/@nextSort@/g, nextSort);
	smbFileTdForm = smbFileTdForm.replace(/@prefix@/g, prefix);
	smbFileTdForm = smbFileTdForm.replace(/@subPrefix@/g, subPrefix);
	smbFileTdForm = smbFileTdForm.replace(/@docBoxYn@/g, docBoxYn);
	smbFileTdForm = smbFileTdForm.replace(/@display@/g, display);
	smbFileTdForm = smbFileTdForm.replace(/@smbsnDocMtlYn@/g, smbsnDocMtlYn);
	smbFileTdForm = smbFileTdForm.replace(/@smbDocMpngSn@/g, smbDocMpngSn);
	smbFileTdForm = smbFileTdForm.replace(/@@smbsnFileTrgForm@@/g, smbsnFileTrgForm);
	smbFileTdForm = smbFileTdForm.replace(/@@myDocBoxForm@@/g, myDocBoxForm);
	smbFileTdForm = smbFileTdForm.replace(/@@smbsnFileForm@@/g, smbsnFileForm);
	return fnSmbsnFileReplace(smbFileTdForm);
}

//필수값 표시폼
function fnSmbsnDocRqrYnForm(){
	var smbsnDocRqrYnForm = $("#smbsnDocRqrYnForm").html();
	return smbsnDocRqrYnForm;
}

//멀티등록 버튼폼
function fnSmbsnDocMtlYnForm(prefix, subPrefix, docBoxYn, smbsnDocMtlYn){
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	if(docBoxYn == undefined || docBoxYn == null) docBoxYn = '';
	if(smbsnDocMtlYn == undefined || smbsnDocMtlYn == null) smbsnDocMtlYn = '';
	
	
	var smbsnDocMtlYnForm = $("#smbsnDocMtlYnForm").html();
	smbsnDocMtlYnForm = smbsnDocMtlYnForm.replace(/@prefix@/g, prefix);
	smbsnDocMtlYnForm = smbsnDocMtlYnForm.replace(/@subPrefix@/g, subPrefix);
	smbsnDocMtlYnForm = smbsnDocMtlYnForm.replace(/@docBoxYn@/g, docBoxYn);
	smbsnDocMtlYnForm = smbsnDocMtlYnForm.replace(/@smbsnDocMtlYn@/g, smbsnDocMtlYn);
	return fnSmbsnFileReplace(smbsnDocMtlYnForm);
}

//제출서류샘플파일폼
function fnSmbsnDocFileForm(smbsnDocSn, pbancrcSn, smbsnDocFormSn, orgnlAtchFileNm){
	if(smbsnDocSn == undefined || smbsnDocSn == null || smbsnDocSn == '') return '';
	if(pbancrcSn == undefined || pbancrcSn == null || pbancrcSn == '') return '';
	if(smbsnDocFormSn == undefined || smbsnDocFormSn == null || smbsnDocFormSn == '') return '';
	if(orgnlAtchFileNm == undefined || orgnlAtchFileNm == null || orgnlAtchFileNm == '') return '';
	
	var smbsnDocFileForm = $("#smbsnDocFileForm").html();
	smbsnDocFileForm = smbsnDocFileForm.replace(/@smbsnDocSn@/g, smbsnDocSn);
	smbsnDocFileForm = smbsnDocFileForm.replace(/@pbancrcSn@/g, pbancrcSn);
	smbsnDocFileForm = smbsnDocFileForm.replace(/@smbsnDocFormSn@/g, smbsnDocFormSn);
	smbsnDocFileForm = smbsnDocFileForm.replace(/@orgnlAtchFileNm@/g, orgnlAtchFileNm);
	return fnSmbsnFileReplace(smbsnDocFileForm);
}

//제출서류설명폼
function fnSmbsnRsnForm(smbsnRsn){
	if(smbsnRsn == undefined || smbsnRsn == null || smbsnRsn == '') return '';
	
	var smbsnRsnForm = $("#smbsnRsnForm").html();
	smbsnRsnForm = smbsnRsnForm.replace(/@smbsnRsn@/g, smbsnRsn);
	return fnSmbsnFileReplace(smbsnRsnForm);
}

//문서함폼
function fnMyDocBoxForm(nextSort, prefix, subPrefix, docBoxYn, smbsnDocMtlYn, smbDocMpngSn){
	if(nextSort == undefined || nextSort == null || nextSort == '') return '';
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	if(docBoxYn == undefined || docBoxYn == null || docBoxYn == '') return '';
	if(smbsnDocMtlYn == undefined || smbsnDocMtlYn == null) smbsnDocMtlYn = '';
	if(smbDocMpngSn == undefined || smbDocMpngSn == null) smbDocMpngSn = '';
	
	if(docBoxYn != 'Y') return '';
	
	var myDocBoxForm = $("#myDocBoxForm").html();
	myDocBoxForm = myDocBoxForm.replace(/@nextSort@/g, nextSort);
	myDocBoxForm = myDocBoxForm.replace(/@prefix@/g, prefix);
	myDocBoxForm = myDocBoxForm.replace(/@subPrefix@/g, subPrefix);
	myDocBoxForm = myDocBoxForm.replace(/@smbsnDocMtlYn@/g, smbsnDocMtlYn);
	if(smbDocMpngSn != undefined){
		myDocBoxForm = myDocBoxForm.replace(/@smbDocMpngSn@/g, smbDocMpngSn);
	}
	return fnSmbsnFileReplace(myDocBoxForm);
}

//파일찾기폼
function fbSmbsnFileTrgForm(subPrefix){
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	var smbsnFileTrgForm = $("#smbsnFileTrgForm").html();
	smbsnFileTrgForm = smbsnFileTrgForm.replace(/@subPrefix@/g, subPrefix);
	return fnSmbsnFileReplace(smbsnFileTrgForm);
}

//제출서류첨부파일폼
function fnSmbsnFileForm(prefix, subPrefix, atchFileSn, smbDocMpngSn, orgnlAtchFileNm){
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	if(atchFileSn == undefined || atchFileSn == null || atchFileSn == '') atchFileSn = '';
	if(smbDocMpngSn == undefined || smbDocMpngSn == null || smbDocMpngSn == '') smbDocMpngSn = '';
	if(orgnlAtchFileNm == undefined || orgnlAtchFileNm == null || orgnlAtchFileNm == '') orgnlAtchFileNm = '';
	
	var smbsnFileForm = $("#smbsnFileForm").html();
	smbsnFileForm = smbsnFileForm.replace(/@prefix@/g, prefix);
	smbsnFileForm = smbsnFileForm.replace(/@subPrefix@/g, subPrefix);
	smbsnFileForm = smbsnFileForm.replace(/@atchFileSn@/g, atchFileSn);
	smbsnFileForm = smbsnFileForm.replace(/@smbDocMpngSn@/g, smbDocMpngSn);
	smbsnFileForm = smbsnFileForm.replace(/@orgnlAtchFileNm@/g, orgnlAtchFileNm);
	return fnSmbsnFileReplace(smbsnFileForm);
}

//신규제출서류첨부파일폼
function fnSmbsnFileNewForm(prefix, subPrefix){
	if(prefix == undefined || prefix == null || prefix == '') return '';
	if(subPrefix == undefined || subPrefix == null || subPrefix == '') return '';
	
	var smbsnFileNewForm = $("#smbsnFileNewForm").html();
	smbsnFileNewForm = smbsnFileNewForm.replace(/@prefix@/g, prefix);
	smbsnFileNewForm = smbsnFileNewForm.replace(/@subPrefix@/g, subPrefix);
	
	return fnSmbsnFileReplace(smbsnFileNewForm);
}

//치환문자열 제거
function fnSmbsnFileReplace(str){
	return str.replace(/@@.+@@/g, '').replace(/@.+@/g, '');
}