$(document).ready(function(){
	if($("#sprtSn").val() == '') fnFavoSgnLoad();		//최초 등록시 즐겨찾기 서명 가져오기
	ComFns.sgnLoad('sgntFileSn');
	
	fnEmpmSttsYnToggle($("[name=empmSttsYn]:checked").val(), '#empmWrcNm', '#empmWrcNmSpan');
	$("[name=empmSttsYn]").on('change', function(){
		fnEmpmSttsYnToggle($("[name=empmSttsYn]:checked").val(), '#empmWrcNm', '#empmWrcNmSpan');
	});
	
	var empQlfListJson = $.parseJSON($("#empQlfListJson").val());
	if(empQlfListJson != null){
		$(empQlfListJson).each(function(fnIdx, fnObj){
			fnEmpQlfFormAdd(fnObj.crtfctNm, fnObj.acqsYmd, fnObj.acqsPlc);
		});
	}else{
		fnEmpQlfFormAdd();
	}
});

function fnEmpQlfFormAdd(crtfctNm, acqsYmd, acqsPlc){
	if(crtfctNm == undefined || crtfctNm == null) crtfctNm = '';
	if(acqsYmd == undefined || acqsYmd == null) acqsYmd = '';
	if(acqsPlc == undefined || acqsPlc == null) acqsPlc = '';
	
	var tbodyObj = $("#empQlfTbody");
	var trLength = tbodyObj.find('tr').length;
	var nextSort = 1;
	if(trLength > 0){
		var maxSort = tbodyObj.find('tr').last().data('sort');
		nextSort = Number(maxSort)+1;
	}
	
	var html = $("#empQlfForm").html().replace('<tbody>', '').replace('</tbody>', '');
	html = html.replace(/@crtfctNm@/g, crtfctNm).replace(/@acqsYmd@/g, acqsYmd).replace(/@acqsPlc@/g, acqsPlc).replace(/@nextSort@/g, nextSort);
	
	if(trLength < 1){
		tbodyObj.append(html);
	}else{
		tbodyObj.find('tr').last().after(html);
	}
	
	ComFns.initDatePicker('#acqsYmd'+nextSort);//날짜입력박스
	$('#acqsYmd'+nextSort).mask('0000-00-00');
}

function fnEmpQlfFormDel(){
	var tbodyObj = $("#empQlfTbody");
	var trLength = tbodyObj.find('tr').length;
	if(trLength > 0) tbodyObj.find('tr').last().remove();
}

function fnEmpmSttsYnToggle(empmSttsYn, empmWrcNmId, spanId){
	if(empmSttsYn == undefined || empmSttsYn == null || empmSttsYn == '') return false;
	if(empmWrcNmId == undefined || empmWrcNmId == null || empmWrcNmId == '') return false;
	if(spanId == undefined || spanId == null || spanId == '') return false;
	
	if(empmSttsYn == 'Y'){
		$(spanId).show();
	}else{
		$(spanId).hide();
		$(empmWrcNmId).val('');
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