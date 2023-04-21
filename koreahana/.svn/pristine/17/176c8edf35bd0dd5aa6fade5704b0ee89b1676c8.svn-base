$(document).ready(function(){
	$('.st_select2').select2();
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