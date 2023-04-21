$(document).ready(function(){
	fnSetFamForm();
	
	if($("#sprtSn").val() == '') fnFavoSgnLoad();		//최초 등록시 즐겨찾기 서명 가져오기
	ComFns.sgnLoad('sgntFileSn');
});


//가족관계폼
function fnSetFamForm(){
	var famListJson = $.parseJSON($("#famListJson").val());
	$(famListJson).each(function(fnIdx, fnObj){
		var aplcntRelCd = fnObj.aplcntRelCd;
		var famFlnm = fnObj.famFlnm;
		
		fnFamFormAdd(aplcntRelCd, famFlnm);
	});
	
	if(famListJson == null || famListJson.length < 1) fnFamFormAdd();
}

//가족관계 폼추가
function fnFamFormAdd(aplcntRelCd, famFlnm){
	if(aplcntRelCd == undefined) aplcntRelCd == '';
	if(famFlnm == undefined) famFlnm = '';
	
	var famObj = $("tr[id^=fam_]");
	var famMaxSort = famObj.last().data('sort');
	if(isNaN(famMaxSort)) famMaxSort = 0;
	var famNextSort = (famMaxSort + 1);
	
	var famPrefix = 'fam_'+famNextSort+'_';
	
	var html = $("#adtnAmtFamAppend").html().replace('<tbody>', '').replace('</tbody>', '')
											.replace(/@famNextSort@/g, famNextSort).replace(/@famPrefix@/g, famPrefix)
											.replace('@'+aplcntRelCd+'@', 'selected').replace(/@famFlnm@/g, famFlnm)
											.replace(/ @.+@=""/g, '');
	
	if(famObj.length > 0){
		famObj.last().after(html);
	}else{
		$("#famFirstTbody").append(html);
	}
}

//가족관계 폼제거
function fnFamFormDel(){
	var famObj = $("tr[id^=fam_]");
	var lastFamObj = famObj.last();
	
	if(lastFamObj.length > 0) lastFamObj.remove();
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