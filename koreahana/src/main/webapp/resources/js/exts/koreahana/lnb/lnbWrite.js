$(document).ready(function(){
	
	if($("#sprtSn").val() == '') fnFavoSgnLoad('prtcr');		//최초 등록시 즐겨찾기 서명 가져오기
	
	ComFns.sgnLoad('sgntFileSn');
	ComFns.sgnLoad('prtcrSgntFileSn');
	
	fnToggleShow($('[name=rcoblYn]:checked').val(), '#rcoblSgntFile');
	$("[name=rcoblYn]").on('change', function(){
		fnToggleShow($('[name=rcoblYn]:checked').val(), '#rcoblSgntFile');
	});
	
	$("[id^=lnbPrcBrplcCd]:checked").each(function(fnIdx, fnObj){
		fnToggleBrplcCdShow(fnObj);
	});
	
	$("[id^=lnbPrcBrplcCd]").on('change', function(){
		fnToggleBrplcCdShow(this);
	});
	
	if($("#userType").val() == 'ntk' && $("#sprtSn").val() == ''){
		fnLnbSprtInfoFormAdd();
	}
	
	fnFileEvent('#rcoblSgntFileSn');
	if($("#userType").val() == 'nor' || $("#sprtSn").val() != '') fnFileEvent('#lnbSprtInfoTbody', 'init');		//일반사용자일경우
	
});

function fnFileEvent(id, init){
	if(init == undefined || init == null || init == '' ) id = id+'FileForm';
	
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

function fnToggleShow(chkValue, fileId){
	if(chkValue == undefined || chkValue == null) return false;
	
	if(chkValue == 'Y'){
		$(fileId+'Tr').show();
	}else{
		$(fileId+'Tr').hide();
		$(fileId+'SnFileDelete').trigger('click');
	}
}

//학습지 지원대상자 기본 정보폼 추가
function fnLnbSprtInfoFormAdd(){
	var maxSort = 4;
	var trLastObj = $("#lnbSprtInfoTbody").find("tr[id^=lnbSprtInfoTr][id$=_1]").last();
	var lastSort = trLastObj.data('sort');
	if(lastSort == undefined) lastSort = 0;
	if(lastSort >= maxSort){
		alert('최대 '+maxSort+'개 까지 추가 가능합니다.');
	}else{
		var nextSort = Number(lastSort)+1;
		var html = $("#lnbSprtInfoAppend").html().replace('<tbody>', '').replace('</tbody>', '').replace(/@nextSort@/g, nextSort);
		if(nextSort == 1){
			$("#lnbSprtInfoTbody").append(html);
		}else{
			$("#lnbSprtInfoTbody").find("tr").last().after(html);
		}
		fnFileEvent('#ntkrdfAcrtfctFileSn'+nextSort);
		
		$('#lnbSprtInfoTr'+nextSort+'_4').find("[id^=lnbPrcBrplcCd]").bind('change', function(){
			fnToggleBrplcCdShow(this);
		});
		
		ComFns.initDatePicker('#lnbPrcBrdtYmd'+nextSort);//날짜입력박스
		$('#lnbPrcBrdtYmd'+nextSort).mask('0000-00-00');
		ComFns.numberOnly('#lnbPrcHanawonTh'+nextSort);//숫자처리(콤마제거)
		ComFns.numberOnly('#lnbPrcEntcnyYr'+nextSort);//숫자처리(콤마제거)
	}
}

//학습지 지원대상자 기본 정보폼 제거
function fnLnbSprtInfoFormDel(){
	var trLastObj = $("#lnbSprtInfoTbody").find("tr[id^=lnbSprtInfoTr][id$=_1]").last();
	var lastSort = trLastObj.data('sort');
	if(lastSort == undefined) return false;
	
	var lnbkSprtBscInfoSn = $("[id^=lnbSprtInfoTr"+lastSort+"]").find("input[type=hidden][name^=lnbkSprtBscInfoSn]").val();
	if(lnbkSprtBscInfoSn != undefined && lnbkSprtBscInfoSn != 'undefined' && lnbkSprtBscInfoSn != null && lnbkSprtBscInfoSn != ''){
		var html = '<input type="hidden" name="deleteLnbkSprtBscInfoSn" value="'+lnbkSprtBscInfoSn+'" />';
		$("#deleteLnbkSprtBscInfoSn").after(html);
	}
	
	$("#lnbSprtInfoTbody").find("tr[id^=lnbSprtInfoTr"+lastSort+"]").remove();
}


//국민기초생활수급확인서
function fnToggleShow(chkValue, fileId){
	if(chkValue == undefined || chkValue == null) return false;
	
	if(chkValue == 'Y'){
		$(fileId+'Tr').show();
	}else{
		$(fileId+'Tr').hide();
		$(fileId+'SnFileDelete').trigger('click');
	}
}


//출생지
function fnToggleBrplcCdShow(chkObj){
	if(chkObj == undefined || chkObj == null) return false;
	
	var userType = $("#userType").val();
	
	chkObj = $(chkObj);
	var chkValue = chkObj.val();
	var sort = Number(chkObj.data('sort'));
	
	if(chkValue == '3001'){
		$('#ntkSpan'+sort).show();
		
		if(userType == 'ntk'){
			$('#lnbSprtInfoTr'+sort+'_1').find('th').attr('rowspan', 6);
			$('#lnbSprtInfoTr'+sort+'_5').show();
		}else{
			$('#ntkInfoTr'+sort).hide();
			$('[name=ntkrdfOprtSe'+sort+']').prop('checked', false);
			$('#ntkrdfOprtFlnm'+sort).val('');
			$('#ntkrdfHanawonTh'+sort).val('');
			$('#ntkrdfEntcnyYr'+sort).val('');
		}
	}else{
		$('#ntkSpan'+sort).hide();
		$('#lnbPrcHanawonTh'+sort).val('');
		$('#lnbPrcEntcnyYr'+sort).val('');
		
		if(userType == 'ntk'){
			$('#lnbSprtInfoTr'+sort+'_1').find('th').attr('rowspan', 5);
			$('#lnbSprtInfoTr'+sort+'_5').hide();
		}else{
			
			$('#ntkInfoTr'+sort).show();
			$('#ntkrdfAcrtfctFileSn'+sort+'FileDelete').trigger('click');
		}
	}
}

//기초생활수급자인증서파일 다운로드
function fnRcoblSgntFileDownload(){
	var sprtSn = $("#sprtSn").val();
	$("#rcoblSgntFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#rcoblSgntFileDownloadForm").attr('target', 'downloadFrame');
	$("#rcoblSgntFileDownloadForm").submit();
}

//북한이탈주민인증서파일 다운로드
function fnNtkrdfAcrtfctFileDownload(ntkrdfAcrtfctFileSn){
	var sprtSn = $("#sprtSn").val();
	$("#ntkrdfAcrtfctFileDownloadForm [name=sprtSn]").val(sprtSn);
	$("#ntkrdfAcrtfctFileDownloadForm [name=ntkrdfAcrtfctFileSn]").val(ntkrdfAcrtfctFileSn);
	$("#ntkrdfAcrtfctFileDownloadForm").attr('target', 'downloadFrame');
	$("#ntkrdfAcrtfctFileDownloadForm").submit();
}