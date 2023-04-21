$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();

	$('input[name="emrgSprtSpdmYn"]').on('click',fnChangeEmrgSprtSpdmYn);
	fnChangeEmrgSprtSpdmYn();
	
	$("[name=emrgSprtSpdmYn]").on('change', function(){
		console.log($("[name=emrgSprtSpdmYn]:checked").val());
		fnEmrgSprtSpdmYnToggle($("[name=emrgSprtSpdmYn]:checked").val());
	});
	fnEmrgSprtSpdmYnToggle($("[name=emrgSprtSpdmYn]:checked").val());
	
	$("#totScr").on('keyup keydown change', function(){
		fnTotScrToCrssCd($("#totScr").val());
	});
	fnTotScrToCrssCd($("#totScr").val());
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


//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm').submit();
		return false;
	}
}

//지자체 긴급지원 변경시
function fnChangeEmrgSprtSpdmYn(){
	$('#emrgSprtSpdmRsn').prop('disabled',$('#emrgSprtSpdmYnY:checked').length == 0);
}

function fnEmrgSprtSpdmYnToggle(emrgSprtSpdmYnY){
	if(emrgSprtSpdmYnY == 'Y'){
		$("#emrgSprtSpdmRsn").prop('disabled', false);
		$("#emrgSprtSpdmNRsn").prop('disabled', true);
		$("#emrgSprtSpdmNRsn").val('');
	}else if(emrgSprtSpdmYnY == 'N'){
		$("#emrgSprtSpdmNRsn").prop('disabled', false);
		$("#emrgSprtSpdmRsn").prop('disabled', true);
		$("#emrgSprtSpdmRsn").val('');
	}
}

//위기점수에 맞는 상/중/하 설정
function fnTotScrToCrssCd(){
	var totScr = Number($("#totScr").val());
	if(isNaN(totScr)){
		alert('숫자만 입력해주세요.');
	}else{
		if(totScr > 0 && totScr < 50){
			$("[name=crssCd][value=38003]").prop('checked', true);
			$("#totScrSpan").text('하(30~50점 미만)');
		}else if(totScr >= 50 && totScr < 70){
			$("[name=crssCd][value=38002]").prop('checked', true);
			$("#totScrSpan").text('중(50~70점 미만)');
		}else if(totScr >= 70){
			$("[name=crssCd][value=38001]").prop('checked', true);
			$("#totScrSpan").text('상(70~100점)');
		}else{
			$("[name=crssCd]:checked").prop('checked', false)
		}
	}
}