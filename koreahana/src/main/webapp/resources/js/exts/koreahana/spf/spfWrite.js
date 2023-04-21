$(document).ready(function(){

	if($("#sprtSn").val() == '') fnFavoSgnLoad();		//최초 등록시 즐겨찾기 서명 가져오기
	ComFns.sgnLoad('sgntFileSn');
	
	$("#aplyMtv").on('change keydown keyup', function(){
		fnStrLengt('#aplyMtv', '#aplyMtvSpan', 300);
	});
	
	fnEtcToggle('lastAcbgCd', '#lastAcbgEtc', '5005');
	$("input[type='radio'][name=lastAcbgCd]").on('change', function(){
		fnEtcToggle('lastAcbgCd', '#lastAcbgEtc', '5005');
	});
	
	fnEtcToggle('ocptInstTypeCd', '#ocptInstTypeEtc', '6008');
	$("input[type='radio'][name=ocptInstTypeCd]").on('change', function(){
		fnEtcToggle('ocptInstTypeCd', '#ocptInstTypeEtc', '6008');
	});
	
	$("#photoFileTrg").on('click', function(){
		$("#photoFile").trigger('click');
		return false;
	});
	
	$('#writeFileForm').ajaxForm({
		success : function(data){
			if(data.isSuccess){
				fnSetImg(data.msg, data.data.atchFileSn);
			}else{
				alert(data.msg);
			}
		},
		error: function(error){
			console.log(error);
		}
	});
	$("#photoFile").on('change', function(){
		$('#writeFileForm').submit();
	});
});

function fnStrLengt(id, textId, maxLength){
	if(id == undefined || id == null || id == '') return false;
	if(textId == undefined || textId == null || textId == '') return false;
	if(maxLength == undefined || maxLength == null || maxLength == '') maxLength = 300;
	maxLength = Number(maxLength);
	
	var curLength = Number($(id).val().length);
	$(textId).text(curLength);
}

function fnEtcToggle(nm, etcId, disableValue){
	var chkObjValue = $('[name='+nm+']:checked').val();
	
	if(chkObjValue == disableValue){
		$(etcId).prop('disabled', false);
	}else{
		$(etcId).val('');
		$(etcId).prop('disabled', true);
	}
}

function fnSetImg(encParam, atchFileSn){
	if(atchFileSn == undefined || atchFileSn == null ) atchFileSn = '';
	
	var imgUrl = '';
	if(encParam == undefined || encParam == null || encParam == '' ){
		imgUrl = '/support/img/content/p_default.jpg';
	}else{
		imgUrl = $("#photoUrl").val().replace(/@encParam@/g, encParam);
	}
	$("#imgArea").attr('src', imgUrl);
	$("#photoFileSn").val(atchFileSn);
	
	if(atchFileSn == ''){
		$("#photoFileTrg").show();
	}else{
		$("#photoFileTrg").hide();
	}
}

function fnCrtfctRcvAddr(){
	//공통 주소찾기 호출
	fnComAddressFind(function(data){
		$('#crtfctRcvZip').val(data.zip);
		$('#crtfctRcvAddr').val(data.address);
		$('#crtfctRcvDaddr').val(data.addressDetail);
		
	});
	return false;
}