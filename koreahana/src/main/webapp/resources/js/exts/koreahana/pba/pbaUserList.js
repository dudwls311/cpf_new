$(document).ready(function(){
	if($("#pbancrcCtgryFrstCd").val() == '10005' || $("#pbancrcCtgryFrstCd").val() == '10007'){
		fnShowInfoVdo();
		/*
	}else if($("#pbancrcCtgryFrstCd").val() == '10002'){
		var sprtName = '가산금지원';
		var dtStr = '2023년 2월';
		fnShowInfo(sprtName, dtStr);
		*/
		/*
	}else if($("#pbancrcCtgryFrstCd").val() == '10004'){
		var sprtName = '교육지원금';
		var dtStr = '2023년 3월';
		fnShowInfo(sprtName, dtStr);
		*/
	}
});

//페이징
function fnPage(p){
	$("#pageIndex").val(p);
	$("#listPageForm").submit();
}

//상세
function fnView(pbancrcSn){
	$("#writePageForm [name$=Mode]").val('pbaView');
	$("#writePageForm #pbancrcSn").val(pbancrcSn);
	$("#writePageForm").submit();
}

//신청하기
function fnWirte(pbancrcSn){
	//if($("#pbancrcCtgryFrstCd").val() == '10004'){
	  //var msg = '지원 권한이 없습니다.';
	  //alert(msg);
	  //return false;
	//}

	$("#writePageForm [name$=Mode]").val('write');
	$("#writePageForm #pbancrcSn").val(pbancrcSn);
	$("#writePageForm").submit();
}

function fnShowInfoVdo(){
	if($("#searchKeyword").val() != '') return false;
	var pbancrcCtgryFrstCd = $("#pbancrcCtgryFrstCd").val();
	//if(pbancrcCtgryFrstCd == '10006'){
	var sprtName = (pbancrcCtgryFrstCd == '10007' ? '정착지원 전문관리사' : '화상영어'); 
	//(pbancrcCtgryFrstCd == '10005' ? '화상영어' : '학습지');
	var sprtDiffName = (pbancrcCtgryFrstCd == '10007' ? '화상영어' : '정착지원 전문관리사');
	//(pbancrcCtgryFrstCd == '10005' ? '학습지' : '화상영어');
	var vdoInfoHtml = $("#vdoInfoForm").html().replace(/@sprtName@/g, sprtName).replace(/@sprtDiffName@/g, sprtDiffName);
	ComFns.popup.init({title:'안내사항'});
	ComFns.popup.changeContentHtml(vdoInfoHtml);
	ComFns.popup.show();
	//}else{
	//}
}

function fnShowInfo(sprtName, date){
	if($("#searchKeyword").val() != '') return false;
	var sprtInfoHtml = $("#sprtInfoForm").html().replace(/@sprtName@/g, sprtName).replace(/@date@/g, date);
	ComFns.popup.init({title:'안내사항'});
	ComFns.popup.changeContentHtml(sprtInfoHtml);
	ComFns.popup.show();
}