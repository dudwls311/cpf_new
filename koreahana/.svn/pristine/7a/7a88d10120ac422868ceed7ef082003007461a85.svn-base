$(document).ready(function(){
	if($("#sprtSn").val() == '') fnFavoSgnLoad();		//최초 등록시 즐겨찾기 서명 가져오기
	ComFns.sgnLoad('sgntFileSn');
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

function fnSchlAddr(){
	//공통 주소찾기 호출
	fnComAddressFind(function(data){
		$('#schlZip').val(data.zip);
		$('#schlAddr').val(data.address);
		$('#schlDaddr').val(data.addressDetail);
		
	});
	return false;
}