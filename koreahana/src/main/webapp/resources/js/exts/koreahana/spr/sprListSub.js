$(document).ready(function(){

	$('.st_select2').select2();
	
	$("#pbancrcSn").on('change', function(){
		$("regDtYr").val('');
		$("searchKeyword").val('');
		$("#searchForm").submit();
	});
	
	
	var ajform = new ComAjaxForm('listForm','listPageForm', {});
	ajform.init();
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

function fnAllChkToggle(){
	var isAllChecked = $("#chkAll").is(':checked');
	$("input[type=checkbox][id^=listChk]").prop('checked', isAllChecked);
}

function fnSprtSttsCdChg(){
	var sprtSttsCdChg = $("#sprtSttsCdChg").val();
	var sprtSttsCdChgNm = $("#sprtSttsCdChg>option:selected").data('nm');
	
	if($("input[type=checkbox][id^=listChk]:checked").length < 1 ){
		alert('지원상태를 변경할 자료를 체크해주세요.');
		$("#sprtSttsCdChg").val('');
	}else{
		if(sprtSttsCdChg != undefined && sprtSttsCdChg != null && sprtSttsCdChg != ''){
			if(confirm('지원상태값을 ['+sprtSttsCdChgNm+']로 일괄 변경하시겠습니까?')){
				$("#sprtSttsCd2").val(sprtSttsCdChg);
				$("#listForm").submit();
			}
		}
	}
}