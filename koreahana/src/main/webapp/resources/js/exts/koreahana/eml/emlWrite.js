$(document).ready(function(){
	$('.st_select2').select2();
	fnExcvMthdCdChg();
});

function fnAddr(){
	//공통 주소찾기 호출
	fnComAddressFind(function(data){
		$('#zip').val(data.zip);
		$('#addr').val(data.address);
		$('#daddr').val(data.addressDetail);
		
	});
	return false;
}

function fnExcvMthdCdChg(){
	var excvMthdCd = $("[name=excvMthdCd]:checked").val();
	if(excvMthdCd == '42006') {
		$("#excvMthdEtc").prop('disabled', false);
	}else{
		$("#excvMthdEtc").val('');
		$("#excvMthdEtc").prop('disabled', true);
	}
}