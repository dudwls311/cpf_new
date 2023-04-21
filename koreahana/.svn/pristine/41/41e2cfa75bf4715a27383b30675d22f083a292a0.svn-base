$(document).ready(function(){
	$('#listBtn').on('click',fnList);
	$('#modifyBtn').on('click',fnModify);
	$('#deleteBtn').on('click',fnDelete);
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//수정
function fnModify(){
	$("#kepMode").val('write');
	$("#writePageForm").submit();
	return false;
}

//삭제
function fnDelete(){
	if(confirm(Msg.com.confirmDelete)){
		ComFns.ajax(actionUrl, {kepMode:'deleteActionJson',sprtSn:$('#sprtSn').val()}, fnList);
	}
}


//카드정보보기
function fnViewCard(cardListType){
	if(cardListType == undefined || cardListType == null || cardListType == '') cardListType = 'reqInfo';		//카드번호를 보여줄 유형(reqInfo:신청정보, cardUseList:카드사용정보);
	
	ComFns.popup.init({
		title:'비밀번호입력',
		confirmBtn:true,
		confirmBtnClickMethod:function(){
			if($('#cardPasswd').val() == ''){
				alert('비밀번호를 입력해 주세요');
				return false;
			}
			ComFns.ajax(
				actionUrl,
				{kepMode:'viewCardInfo',sprtSn:$('#sprtSn').val(),cardPasswd:$('#cardPasswd').val(),cardListType:cardListType}, 
				function(result){
					var data = result.data;
					ComFns.hideLoading();
					
					if(cardListType == 'reqInfo'){
						if(data.frstCardNo != null) $('#frstCardNoSpan').text(data.frstCardNo);
						if(data.scndryCardNo != null) $('#scndryCardNoSpan').text(' | '+data.scndryCardNo);
						if(data.thirdCardNo != null) $('#thirdCardNoSpan').text(' | '+data.thirdCardNo);
						$('#cardBtn').hide();
					}else{
						$(data.cardList).each(function(fnIdx, fnObj){
							$("#cardNo"+(fnIdx+1)).text(fnObj);
						});
						$('#cardUseBtn').hide();
					}
					ComFns.popup.hide();
				},
				{},
				true
			);
		}
	});
	ComFns.popup.changeContentHtml($('#popup_cardInfoDiv').html().replace('@','') );
	ComFns.popup.show();
}