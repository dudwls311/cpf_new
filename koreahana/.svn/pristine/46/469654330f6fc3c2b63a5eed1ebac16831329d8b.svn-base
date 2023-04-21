$(document).ready(function(){
	$('#cancelBtn').on('click',fnList);
	$('#saveBtn').on('click',fnSaveConfirm);
	$('#tmpSaveBtn').on('click',fnTmpSave);
	$('#deleteBtn').on('click',fnDelete);

	var ajform = new ComAjaxForm('writeForm','completePageForm', {
		beforeSerializeFunction:function(form, options){
			$('#mbphno').val($('#mbphnoSplit0').val() + '-' + $('#mbphnoSplit1').val() + '-' + $('#mbphnoSplit2').val());
			$('#prtcrMbphno').val($('#prtcrMbphnoSplit0').val() + '-' + $('#prtcrMbphnoSplit1').val() + '-' + $('#prtcrMbphnoSplit2').val());
		}
	});
	
	ajform.init();
	
	fnSetSmbFile();
	
	//성명|서명 입력값 동기화
	$("#flnm").on('keyup', function(){
		$("#sgntrFlnm").val($(this).val());
	});
	
	//성명|서명 입력값 동기화
	$("#prtcrFlnm").on('keyup', function(){
		$("#prtcrSgntrFlnm").val($(this).val());
	});
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#sprtSn').val() != ''){
		$("#viewPageForm").submit();	
	}else{
		fnList();
	}
	return false;
}

function fnSaveConfirm(){
	var pbaConfirmHtml = $("#pbaConfirmAppend").html();
	ComFns.popup.init({title:'신청서 제출'});
	ComFns.popup.changeContentHtml(pbaConfirmHtml);
	ComFns.popup.setConfirmBtnClickMethod(fnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

//저장
function fnSave(){
	ComFns.popup.hide();
	$('#writeForm #tmpSaveYn').val('');
	$('#writeForm').submit();
	return false;
}

//임시저장
function fnTmpSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm #tmpSaveYn').val('Y');
		$("#completePageForm #tmpSaveYnComplete").val('Y');
		$('#writeForm').submit();
		return false;
	}
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		var ajDeleteform = new ComAjaxForm('deletePageForm','listPageForm', {});
		ajDeleteform.init();
	
		$("#deletePageForm [name=ksMode]").val('deleteActionJson');
		$("#deletePageForm [name=sprtSn]").val($('#sprtSn').val());
		$("#deletePageForm").submit();
		return false;
	}
}

//즐겨찾기 서명 가져오기
function fnFavoSgnLoad(signType){
	if(signType == 'prtcr') {
		ComFns.ajax(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do?ksMode=getFavoSgnJson', null, fnFavoSgnPrtcrSuccess, null, true);
	}else{
		ComFns.ajax(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do?ksMode=getFavoSgnJson', null, fnFavoSgnSuccess, null, true);
	}
}

//신청인 서명
function fnFavoSgnSuccess(data){
	ComFns.hideLoading();
	var sgnId = 'sgntFileSn';
	var sgnObj = $("#"+sgnId+"Hidden");
	
	var url = sgnObj.data('url');
	var param = data.data.encParam;
	var fsn = data.data.fsn;
	var sgntNm = sgnObj.data('sgntnm');
	if(param == '' || fsn == '') return false;
	
	//ComFns.sgnLoad의 경우 sgntFileSnHidden의 최초 호출된 값만 호출하다보니 값을 설정해도 인식하지 못하여 이부분만 별도로 가져와서 설정
	var html = $("#sgnFileAppend").html().replace(/@url@/g, url).replace(/@param@/g, param).replace(/@fsn@/g, fsn).replace(/@sgntNm@/g, sgntNm).replace(/@sgnId@/g, sgnId);
	$("#"+sgnId+"Span").empty().append(html);
}

//보호자 서명
function fnFavoSgnPrtcrSuccess(data){
	ComFns.hideLoading();
	var sgnId = 'sgntFileSn';
	var sgnObj = $("#"+sgnId+"Hidden");
	
	var url = sgnObj.data('url');
	var param = data.data.encParam;
	var fsn = data.data.fsn;
	var sgntNm = sgnObj.data('sgntnm');
	if(param == '' || fsn == '') return false;
	
	//ComFns.sgnLoad의 경우 sgntFileSnHidden의 최초 호출된 값만 호출하다보니 값을 설정해도 인식하지 못하여 이부분만 별도로 가져와서 설정
	var html = $("#sgnFileAppend").html().replace(/@url@/g, url).replace(/@param@/g, param).replace(/@fsn@/g, fsn).replace(/@sgntNm@/g, sgntNm).replace(/@sgnId@/g, 'prtcrSgntFileSn');
	$("#prtcrSgntFileSnSpan").empty().append(html);
}

//서명 등록
function fnSgnWrite(){
	ComFns.popup.init({title:'서명 선택'});
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do', {ksMode:'write',sprtSgnWirteYn:'Y'} );
	ComFns.popup.setConfirmBtnClickMethod(fnSgnSave);
	ComFns.popup.showConfirmBtn();
	ComFns.popup.show();
}

function fnSgnSave(){
	if(confirm(Msg.com.confirmSave)){
		if(sign.isEmpty()){
			alert('서명파일을 그려주세요.');
			return false;
		}else{
			$("#signDataUrl").val(sign.toDataURL());
			$('#sgnWriteForm').ajaxSubmit({
				success:function(data){
					if(data.isSuccess){
						ComFns.openMySgn();
					}else{
						if(data.msg){
							alert(data.msg);	
							return;
						}
						if(data.errorList){
							for(var i = 0; i < data.errorList.length; i++){
								var e = data.errorList[i];
								alert(e.errorMessage);
								$('#'+e.errorField).focus();
								return;
							}	
						}
					}
				},
				error:function(error){
					console.log(error);
				}
			});
		}
	}
}