$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	ComFns.betweenDatepickerOption('#pbancrcBgngStr', '#pbancrcEndStr');
	
	var ajform = new ComAjaxForm('writeForm','listPageForm', {});
	ajform.init();
	
	fnQlfToggle($("#bizSeCd").val());
	$("#bizSeCd").on('change', function(){
		fnSmbTypListAjax($("#pbancrcSn").val(), $("#bizSeCd").val());
		fnQlfToggle($("#bizSeCd").val());
	});
	
	//첨부파일 클릭 트리거
	$("a[id$=Trg]").on('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$("input[type=file]").on('change', function(){
		var fileId = $(this).attr('id');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$("a[id$=Delete]").on('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		
		$('#'+fileId).val('');
	    $("#"+fileNmId).empty();
	    return false;
	});
	
	//모집기간 기간설정 입력란 초기화
	if($("#pbancrcAlways").prop('checked')){
		fnPbancrcTypeChk($("#pbancrcAlways"));
	}
	if($("#pbancrcUnset").prop('checked')){
		fnPbancrcTypeChk($("#pbancrcUnset"));
	}
	
	fnSmbTypListAjax($("#pbancrcSn").val(), $("#bizSeCd").val());
	fnFileFormAdd('pbaFile');
	tinymce_init('pbancrcCn');
	
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#pbancrcSn').val() != ''){
		$("#viewPageForm").submit();
	}else{
		fnList();
	}
	return false;
}

//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$("#pbancrcCn").val(tinymce.get(0).getContent());		//에디터 내용 적용
		$('#writeForm').submit();
		return false;
	}
}

//상시여부
function fnPbancrcTypeChk(obj){
	var curObj = $(obj);
	var curId = curObj.attr('id');
	var isCurChecked = curObj.prop('checked');
	
	var pbancrcAlwaysId = 'pbancrcAlways';
	var pbancrcAlwaysObj = $("#"+pbancrcAlwaysId);
	var isAlwaysChecked = pbancrcAlwaysObj.prop('checked');
	
	var pbancrcUnsetId = 'pbancrcUnset';
	var pbancrcUnsetObj = $("#"+pbancrcUnsetId);
	var isUnsetChecked = pbancrcUnsetObj.prop('checked');
	
	if(isCurChecked){
		$("#pbancrcBgngStr").val('');
		$("#pbancrcEndStr").val('');
		$("#pbancrcDtSpan").hide();
		if(curId == pbancrcAlwaysId){
			pbancrcUnsetObj.prop('checked', false);
		}else if(curId == pbancrcUnsetId){
			pbancrcAlwaysObj.prop('checked', false);
		}
	}else{
		$("#pbancrcDtSpan").show();
	}
	
}

//모집일자 설정
function fnPbancrcDateChk(obj){
	var pbancrcAlwaysObj = $("#pbancrcAlways");
	var pbancrcUnsetObj = $("#pbancrcUnset");
	var isAlwaysChecked = pbancrcAlwaysObj.prop('checked');
	var isUnsetChecked = pbancrcUnsetObj.prop('checked');
	
	var modeStr = '';
	if(isAlwaysChecked) modeStr = '상시모집';
	else if(isUnsetChecked) modeStr = '모집기간 미정';
	
	if(isAlwaysChecked || isUnsetChecked){
		alert(modeStr+'의 경우 날짜 설정이 불가능 합니다');
		$(obj).val('');
	}
}

//자격시험정보 입력란 표시여부
function fnQlfToggle(bizSeCd){
	var pbancrcCtgryFrstCd = $("#pbancrcCtgryFrstCd").val();
	//10007(정착지원 전문관리사) + 11009(자격시험)
	
	if(pbancrcCtgryFrstCd == '10007'){
		if(bizSeCd == '11009'){
			$("#spfQlfDiv").show();
		}else{
			$("#spfQlfDiv").hide();
			$("#spfQlfDiv #testPlc").val('');
			$("#spfQlfDiv #testYmd").val('');
			$("#spfQlfDiv #testHrInfo").val('');
			$("#spfQlfDiv #sccdPrsntnYmd").val('');
		}
	}
}

//첨부파일 다운로드
function fnDownload(atchFileSn, pbancrcSn){
	$("#downloadForm [name=atchFileSn]").val(atchFileSn);
	$("#downloadForm [name=pbancrcSn]").val(pbancrcSn);
	$("#downloadForm").attr('target', 'downloadFrame');
	$("#downloadForm").submit();
}

//제출서류양식 다운로드
function fnDocFormDownload(smbsnDocSn, pbancrcSn, smbsnDocFormSn){
	$("#docDownloadForm [name=smbsnDocFormSn]").val(smbsnDocFormSn);
	$("#docDownloadForm").attr('action', ComFns.getContextUrl() + 'user/exts/koreahana/smb/index.do');
	$("#docDownloadForm").attr('target', 'downloadFrame');
	$("#docDownloadForm").submit();
}

//첨부파일폼 추가
function fnFileFormAdd(type){
	var fileFormObj = $('[id^='+type+'][id$=Form]');
	var lastFileFormObj = fileFormObj.last();
	var maxSort = Number(lastFileFormObj.data(type.toLowerCase()+'sort'));
	if(isNaN(maxSort)) maxSort = 0;
	var nextSort = maxSort+1;
	
	var html = fnFileFormHtml(type, nextSort);
	if(fileFormObj.length < 1){
		$("#"+type+'Td').append(html);
	}else{
		lastFileFormObj.after(html);
	}
	
	var pbAppendaFileFormId = type+nextSort+'Form';		//서식파일 영역
	//첨부파일 클릭 트리거
	$('#'+pbAppendaFileFormId).find("a[id$=Trg]").bind('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$('#'+pbAppendaFileFormId).find("input[type=file]").bind('change', function(){
		var fileId = $(this).attr('id');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$('#'+pbAppendaFileFormId).find("a[id$=Delete]").bind('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		
		$('#'+fileId).val('');
	    $("#"+fileNmId).empty();
	    return false;
	});
	
}

//첨부파일폼 제거
function fnFileFormDel(id, mpnSn){
	if(id == undefined || id == null || id == '') return false;
	if(mpnSn == undefined || mpnSn == null) mpnSn = '';
	
	$('#'+id+'Form').remove();
	if(mpnSn != ''){
		var html = '<input type="hidden" name="deleteFileSn" value="'+mpnSn+'" />';
		$('#deleteFileSn').after(html);
	}
}

//첨부파일폼 html
function fnFileFormHtml(type, nextSort){
	var fileId = type+nextSort;
	
	var html = $("#pbaFileAppend").html().replace(/@type@/g, type).replace(/@nextSort@/g, nextSort).replace(/@fileId@/g, fileId);
	return html.replace(/@@.+@@/g, '').replace(/@.+@/g, '');
}

//제출서류파일 삭제
function fnSmbFileDelAct(type, id, fsn){
	var html = '<input type="hidden" name="deleteSmbsnDocFormSn" value="'+fsn+'" />';
	$('#deleteSmbsnDocFormSn').after(html);
	$('#smbDoc'+id+'Form').remove();
	
	var fileFormObj = $('[id^='+type+'][id$=Form]');
	if(fileFormObj.length < 1){
		fnFileFormAdd(type);
	}
}

//제출서류 템플릿 호출
function fnSmbTypListAjax(pbancrcSn, bizSeCd){
	if(pbancrcSn == undefined) pbancrcSn = '';
	if(bizSeCd == undefined) bizSeCd = '';
	
	$.ajax({
		type:'post',
		url:actionUrl,
		data:{
			kpMode:'smbTypListAjax',
			pbancrcSn:pbancrcSn
		},
		beforeSend:function(){
			ComFns.showLoading();
		},
		complete:function(){
			ComFns.hideLoading();
		},
		success:function(data){
			fnTemplateHtml(data);
			if(pbancrcSn == ''){
				fnSmbTemplateCall($("#pbancrcCtgryFrstCd").val(), bizSeCd, '');
			}else{
				fnSmbDocCall($.parseJSON($("#smbTypJSON").val()), $.parseJSON($("#smbJSON").val()), $.parseJSON($("#smbFileJSON").val()), false);
			}
		},
		error:function(error){
			alert('제출서류를 정상적으로 호출하지 못했습니다.');
		}
	});
}

//제출서류 템플릿 호출
function fnSmbTemplateCall(pbancrcCtgryFrstCd, bizSeCd, smbDocVal){
	if(pbancrcCtgryFrstCd == undefined || pbancrcCtgryFrstCd == null || pbancrcCtgryFrstCd == '') return;
	if(bizSeCd == undefined || bizSeCd == null || bizSeCd == '') bizSeCd = '';
	
	var smbTemplate = fnGetSmbTemplateData(pbancrcCtgryFrstCd, bizSeCd, smbDocVal);
	var smbTypArr = smbTemplate.smbTypArr;
	var smbArr = smbTemplate.smbArr;
	fnSmbDocCall(smbTypArr, smbArr, null, true);
}

//제출서류 html append
function fnTemplateHtml(data){
	$("#smbDocContent").empty().append(data);
}

//제출서류 Form Add
function fnSmbDocFormAdd(smbDocId, smbsnDocTypeVl, smbsnDocNm, smbsnRsn, smbsnDocMtlYn, smbsnDocRqrYn, docBoxYn, smbsnDocFormSn, smbsnDocSn, pbancrcSn, orgnlAtchFileNm){
	
	if(smbsnDocTypeVl == undefined) smbsnDocTypeVl = '';
	if(smbsnDocNm == undefined) smbsnDocNm = '';
	if(smbsnRsn == undefined) smbsnRsn = '';
	if(smbsnDocMtlYn == undefined) smbsnDocMtlYn = '';
	if(smbsnDocRqrYn == undefined) smbsnDocRqrYn = '';
	if(docBoxYn == undefined) docBoxYn = '';
	if(smbsnDocFormSn == undefined) smbsnDocFormSn = '';
	if(smbsnDocSn == undefined) smbsnDocSn = '';
	if(pbancrcSn == undefined) pbancrcSn = '';
	if(orgnlAtchFileNm == undefined) orgnlAtchFileNm = '';

	if(smbsnDocMtlYn == 'Y'){
		smbsnDocMtlYn = 'checked';
	}else{
		smbsnDocMtlYn = '';
	}
	
	if(smbsnDocRqrYn == 'Y'){
		smbsnDocRqrYn = 'checked';
	}else{
		smbsnDocRqrYn = '';
	}
	
	if(docBoxYn == 'Y'){
		docBoxYn = 'checked';
	}else{
		docBoxYn = '';
	}
	

	var lastSort = Number($("#maxSort").val());
	var nextSort = lastSort+1;
	$("#maxSort").val(nextSort);
	
	var html = $("#smbDocAppend").html().replace(/@nextSort@/g, nextSort).replace(/@smbsnDocFormSn@/g, smbsnDocFormSn)
										.replace(/@smbsnDocTypeVl@/g, smbsnDocTypeVl).replace(/@smbsnDocNm@/g, smbsnDocNm)
										.replace(/@smbsnRsn@/g, smbsnRsn).replace(/@smbsndocmtlyn@/g, smbsnDocMtlYn)
										.replace(/@smbsndocrqryn@/g, smbsnDocRqrYn).replace(/@docboxyn@/g, docBoxYn)
										.replace(/@smbsnDocFormSn@/g, smbsnDocFormSn).replace(/@smbsnDocSn@/g, smbsnDocSn)
										.replace(/@pbancrcSn@/g, pbancrcSn).replace(/@orgnlAtchFileNm@/g, orgnlAtchFileNm)
										.replace(/@smbDocId@/g, smbDocId).replace('<tbody>', '').replace('</tbody>', '');
	
	var displayFile = '';
	if(smbsnDocFormSn != ''){
		var displayFile = 'style="display: none;';
		var sbmFileHtml = $("#smbDocFileAppendExist").html().replace(/@nextSort@/g, nextSort).replace(/@smbsnDocFormSn@/g, smbsnDocFormSn)
													   .replace(/@pbancrcSn@/g, pbancrcSn).replace(/@orgnlAtchFileNm@/g, orgnlAtchFileNm)
													   .replace(/@smbsnDocSn@/g, smbsnDocSn).replace(/@displayFile@/g, displayFile);
	}else{
		var sbmFileHtml = $("#smbDocFileAppendNew").html().replace(/@nextSort@/g, nextSort).replace(/@smbsnDocFormSn@/g, smbsnDocFormSn);
	}
	html = html.replace(/@@smbDocFile@@/g, sbmFileHtml).replace(/@@.+@@/g, '').replace(/@.+@/g, '');
	
	var trLength = $("#"+smbDocId+"Tbody").find("tr").length;
	if(trLength == 0){
		$("#"+smbDocId+"Tbody").append(html);
	}else{
		$("#"+smbDocId+"Tbody").find("tr").last().after(html);
	}
	
	
	var pbAppendaFileFormId = 'smbDoc'+nextSort+'Form';		//서식파일 영역
	//첨부파일 클릭 트리거
	$('#'+pbAppendaFileFormId).find("a[id$=Trg]").bind('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
	
	//첨부파일명 설정
	$('#'+pbAppendaFileFormId).find("input[type=file]").bind('change', function(){
		var fileId = $(this).attr('id');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		var fileNm = $(this).val();
		fileNm = fileNm.substr(fileNm.lastIndexOf('\\')+1);
		
		$("#"+fileDivId).show();
	    $("#"+fileNmId).empty().append(fileNm);
	});
	
	//첨부파일초기화
	$('#'+pbAppendaFileFormId).find("a[id$=Delete]").bind('click', function(){
		var fileId = $(this).attr('id').replace('Delete', '');
		var fileDivId = fileId+'Div';
		var fileNmId = fileId+'FileNm';
		
		$('#'+fileId).val('');
	    $("#"+fileNmId).empty();
	    return false;
	});
}

//제출서류 Form Del
function fnSmbDocFormDel(trId, smbsnDocSn){
	$("#"+trId).remove();
	$("#"+trId+'_1').remove();
	$("#"+trId+'_2').remove();
	$("#"+trId+'_3').remove();
	
	if(smbsnDocSn != undefined && smbsnDocSn != null && smbsnDocSn != ''){
		var html = '<input type="hidden" name="deleteSmbsnDocSn" value="'+smbsnDocSn+'" />';
		$('#deleteSmbsnDocSn').after(html);
	}
}

//제출서류양식 삭제
function fnDocFormDelAct(type, fsn){
	//$("#smbDoc"+type+"Form").remove();
	var html = '<input type="hidden" name="deleteSmbsnDocFormSn" value="'+fsn+'" />';
	$('#deleteSmbsnDocFormSn').after(html);
}

//제출서류 호출
function fnSmbDocCall(smbTypJSON, smbJSON, smbFileJSON, isTemplate){
	if(smbTypJSON == undefined || smbTypJSON == null || smbTypJSON == '') return;
	if(smbJSON == undefined || smbJSON == null || smbJSON == '') return;
	if(smbFileJSON == undefined || smbFileJSON == null || smbFileJSON == '') smbFileJSON == null;
	if(isTemplate == undefined || isTemplate == null) isTemplate == false;
	
	
	var smbDocId = '';
	var smbsnDocSn = '';
	var pbancrcSn = '';
	var smbsnDocTypeVl = '';
	var smbsnDocNm = '';
	var smbsnRsn = '';
	var smbsnDocMtlYn = '';
	var smbsnDocRqrYn = '';
	var docBoxYn = '';
	var smbsnDocFormSn = '';
	var atchFileSn = '';
	var atchFileNm = '';
	var atchFilePathNm = '';
	var orgnlAtchFileNm = '';
	var smbsnDocTypeSn = '';
	
	if(isTemplate){
		//기존에 체크되어 있던 제출서류유형 제거
		$("[name=smbsnDocTypeVl]").each(function(fnIdx, fnObj){
			var smbsnDocTypeVl = $(fnObj).val();
			$("#"+smbsnDocTypeVl+"Chk").prop('checked', false);
			fnSmbDocToggle(smbsnDocTypeVl);
		});
	}
	
	//제출서류유형
	$(smbTypJSON).each(function(fnIdx1, fnObj1){
		smbDocId = fnObj1.smbsnDocTypeVl;
		smbsnDocTypeVl = fnObj1.smbsnDocTypeVl;
		pbancrcSn = fnObj1.pbancrcSn;
		smbsnDocTypeSn = fnObj1.smbsnDocTypeSn;
		
		//제출서류
		$(smbJSON).each(function(fnIdx2, fnObj2){
			if(isTemplate){
				//템플릿 호출시
				if(smbsnDocTypeVl == fnObj2.smbsnDocTypeVl){
					smbsnDocNm = fnObj2.smbsnDocNm;
					smbsnRsn = fnObj2.smbsnRsn;
					smbsnDocMtlYn = fnObj2.smbsnDocMtlYn;
					smbsnDocRqrYn = fnObj2.smbsnDocRqrYn;
					docBoxYn = fnObj2.docBoxYn;
					fnSmbDocFormAdd(smbDocId, smbsnDocTypeVl, smbsnDocNm, smbsnRsn, smbsnDocMtlYn, smbsnDocRqrYn, docBoxYn);		//제출서류 추가
				}
			}else{
				//저장된 데이터 호출시
				if(smbsnDocTypeSn == fnObj2.smbsnDocTypeSn){
					smbsnDocSn = fnObj2.smbsnDocSn;
					smbsnDocNm = fnObj2.smbsnDocNm;
					smbsnRsn = fnObj2.smbsnRsn;
					smbsnDocMtlYn = fnObj2.smbsnDocMtlYn;
					smbsnDocRqrYn = fnObj2.smbsnDocRqrYn;
					docBoxYn = fnObj2.docBoxYn;
					smbsnDocFormSn = fnObj2.smbsnDocFormSn;
					
					//제출서류양식
					$(smbFileJSON).each(function(fnIdx3, fnObj3){
						if(smbsnDocFormSn == fnObj3.atchFileSn){
							atchFileSn = fnObj3.atchFileSn;
							atchFileNm = fnObj3.atchFileNm;
							atchFilePathNm = fnObj3.atchFilePathNm;
							orgnlAtchFileNm = fnObj3.orgnlAtchFileNm;
						}
					});
					fnSmbDocFormAdd(smbDocId, smbsnDocTypeVl, smbsnDocNm, smbsnRsn, smbsnDocMtlYn, smbsnDocRqrYn, docBoxYn, smbsnDocFormSn, smbsnDocSn, pbancrcSn, orgnlAtchFileNm);		//제출서류 추가
				}
			}
		});
		
		if(smbsnDocTypeSn != '') $("#"+smbDocId+"Chk").attr('data-smbsndoctypesn', smbsnDocTypeSn);
		$("#"+smbDocId+"Chk").prop('checked', true);
		fnSmbDocToggle(smbDocId);
	});
}

//제출서류유형 체크
function fnSmbDocToggle(smbDocVal, shoYn){
	if(shoYn == undefined || shoYn == null || shoYn == '') shoYn = 'N';		//장학금에서만 사용
	
	var obj = $('#'+smbDocVal+'Chk');
	var isChecked = obj.prop('checked');
	if(isChecked){
		var smbsndoctypesn = obj.data('smbsndoctypesn');
		var deleteSmbsnDocTypeSnObj = $("[name=deleteSmbsnDocTypeSn][value="+smbsndoctypesn+"]");
		if(deleteSmbsnDocTypeSnObj.length > 0) deleteSmbsnDocTypeSnObj.remove();
	
		var html = '<input type="hidden" name="smbsnDocTypeVl" value="'+smbDocVal+'" />';
		$("#smbsnDocTypeVl").after(html);
		
		if(shoYn == 'Y'){
			var smbTemplate = fnGetSmbTemplateData($("#pbancrcCtgryFrstCd").val(), '', smbDocVal);
			var smbTypArr = smbTemplate.smbTypArr;
			var smbArr = smbTemplate.smbArr;
			fnSmbDocCall(smbTypArr, smbArr, null, false);
		}
		
		$('#'+smbDocVal+'Div').show();
	}else{
		$("[name=smbsnDocTypeVl][value="+smbDocVal+"]").remove();
		$("#"+smbDocVal+"Tbody").find("[name$=_smbsnDocSn]").each(function(fnIdx, fnObj){
			//관련제출서류 삭제
			var curVal = $(fnObj).val();
			if(curVal != ''){
				var html = '<input type="hidden" name="deleteSmbsnDocSn" value="'+curVal+'" />';
				$("#deleteSmbsnDocSn").after(html);
			}
			
		});
		
		//관련제출서류파일
		$("#"+smbDocVal+"Tbody").find("[name$=_fsn]").each(function(fnIdx, fnObj){
			var fsn = $(fnObj).val();
			fnSmbFileDelAct('', '', fsn);
		});
		
		//관련제출서류유형
		var smbsnDocTypeSn = obj.data('smbsndoctypesn');
		var deleteSmbsnDocTypeSnLength = $("[name=deleteSmbsnDocTypeSn][value="+smbsnDocTypeSn+"]").length;
		if(smbsnDocTypeSn != undefined && deleteSmbsnDocTypeSnLength == 0){
			var html = '<input type="hidden" name="deleteSmbsnDocTypeSn" value="'+smbsnDocTypeSn+'" />';
			$("#deleteSmbsnDocTypeSn").after(html);
		}
		
		//관련제출서류 파일 삭제
		
		
		$('#'+smbDocVal+'Tbody').empty();
		$('#'+smbDocVal+'Div').hide();
	}
}

//tiny 에디터
function tinymce_init(selector){
	tinymce.init({
	language:'ko_KR', //언어설정
	selector: "#"+selector, //id
	plugins: [
		  "advlist anchor autolink", // autosave autoresize
		  "charmap code contextmenu", //도구 소스코드
		  "directionality",
		  "hr",
		  "image  insertdatetime",//importcss
		  "layer link lists", //legacyoutput
		  "nonbreaking noneditable",
		  "pagebreak paste preview print",
		  "tabfocus table template textcolor",
		  "visualblocks visualchars"
	  ],
	  target_list: [
		{title: '_blank', value: '_blank'},
		{title: '_self', value: '_self'}     
	  ],
	  image_advtab : true, // 사용자 지정 스타일
	  height : 300, //아래는 고정
	  relative_urls : false,//이미지 상대경로 치환부분 막기
	  toolbar1: "code | undo | redo | cut | copy | paste | searchreplace | charmap | emoticons | custom_image | table | visualblocks",
	  toolbar2: "fontselect | fontsizeselect | forecolor | backcolor | bold | italic | underline | strikethrough | alignleft | aligncenter | alignright | alignjustify | bullist | numlist | outdent | indent | hr | removeformat | subscript | superscript | link | unlink | anchory",
	  setup: function(editor) {
            editor.addButton('custom_image', {
                title: '이미지삽입',
                icon: 'image',
                onclick: function() {
            		ComFns.popup.init({title:'이미지삽입'});
            		ComFns.popup.loadContent('/exts/koreahana/com/imageUploadPopup.do');
            		ComFns.popup.show();
     			}
	      	});
	  }      
	});
}

//제출서류 템플릿 데이터 가져오기
function fnGetSmbTemplateData(pbancrcCtgryFrstCd, bizSeCd, smbDocVal){
	if(pbancrcCtgryFrstCd == undefined || pbancrcCtgryFrstCd == null || pbancrcCtgryFrstCd == '') return '';
	if(pbancrcCtgryFrstCd == undefined || pbancrcCtgryFrstCd == null || pbancrcCtgryFrstCd == '') return '';
	if(smbDocVal == undefined || smbDocVal == null || smbDocVal == '') smbDocVal = 'all';		//현재는 장학금에서만 사용
	
	var retObj = {};
	var smbTypArr = new Array();
	var smbArr = new Array();
	var smbObj = {};
	var smbTypObj = {};
	
	if(pbancrcCtgryFrstCd == '10003'){
		//장학금
		
		var ntkrdf = 'ntkrdf';
		var thirdcnty = 'thirdcnty';
		for(var i=1; i<=5; i++){
			smbTypObj = {};
			smbTypObj.smbsnDocTypeVl = ntkrdf+i;		//북한이탈주민 (1:대학원생|2:대학생|3:대학생계절학기|4:중고등학생|5:검정고시합격자)
			if(smbDocVal == 'all' || smbDocVal == smbTypObj.smbsnDocTypeVl) smbTypArr.push(smbTypObj);
		
			smbTypObj = {};
			smbTypObj.smbsnDocTypeVl = thirdcnty+i;	//제3국출생 (1:대학원생|2:대학생|3:대학생계절학기|4:중고등학생|5:검정고시합격자)
			if(smbDocVal == 'all' || smbDocVal == smbTypObj.smbsnDocTypeVl) smbTypArr.push(smbTypObj);
		}
		
		var ntkrdfDocArr = new Array();
		var thirdcntyDocArr = new Array();
												/* 표시여부 */							/* 필수여부 */									/* 복수여부 */							/* 문서함여부 */
		ntkrdfDocArr.push(new Array(1, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '진로·진학검사지', '커리어넷, 워크넷에서 진로/진학 검사 후 결과 제출'));
		ntkrdfDocArr.push(new Array(2, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '장학금신청서', '[장학금신청서, 학업계획서, 서약서, 개인정보동의서] 파일을 다운로드하여 이용해주세요.'));
		ntkrdfDocArr.push(new Array(3, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학업계획서', ''));
		ntkrdfDocArr.push(new Array(4, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '서약서', ''));
		ntkrdfDocArr.push(new Array(5, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '개인정보동의서', ''));
		ntkrdfDocArr.push(new Array(6, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '북한이탈주민등록확인서', ''));
		ntkrdfDocArr.push(new Array(7, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '주민등록등본', ''));
		ntkrdfDocArr.push(new Array(8, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '가족관계증명서(상세)', '기혼 : 본인기준 / 미혼 : 부모기준'));
		ntkrdfDocArr.push(new Array(9, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '통장사본', '신청자본인 명의 통장사본 / 적금통장 불가'));
		ntkrdfDocArr.push(new Array(10, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '국민기초생활수급자증명서', '대상자만 제출'));
		ntkrdfDocArr.push(new Array(11, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '차상위계층 증빙서류', '대상자만 제출 (차상위계층확인서, 한부모가족증명서, 자활근로자확인서, 장애(아동)수당 대상자확인서, 차상위본인부담 경감대상자 증명서 중 택1)'));
		ntkrdfDocArr.push(new Array(12, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학자금 지원 구간 통지서', '발급가능한 자에 한함'));
		ntkrdfDocArr.push(new Array(13, new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '기본증명서(상세)', ''));
		ntkrdfDocArr.push(new Array(14, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '재학증명서', '22.8.1. 이후 발급분 인정'));
		ntkrdfDocArr.push(new Array(15, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '수강등록증빙', '22년 2학기 / 22.8.1. 이후 발급분 인정'));
		ntkrdfDocArr.push(new Array(16, new Array('N', 'N', 'Y', 'N', 'N'), new Array('N', 'N', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '교육비 납입증명서', '22년 여름학기, 2학기 / 22.8.1. 이후 발급분 인정'));
		ntkrdfDocArr.push(new Array(17, new Array('N', 'N', 'N', 'Y', 'N'), new Array('N', 'N', 'N', 'Y', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학교생활기록부', '성적명시 / 22.8.1. 이후 발급분 인정'));
		ntkrdfDocArr.push(new Array(18, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '성적증명서', '22.8.1. 이후 발급분 인정'));
		ntkrdfDocArr.push(new Array(19, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '취업관리시스템 가입신청서', '[취업관리시스템 가입신청서] 파일을 다운로드하여 이용해주세요. '));
		ntkrdfDocArr.push(new Array(20, new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '검정고시 합격증서 사본', '22.1.1 이후 합격자 인정'));
		ntkrdfDocArr.push(new Array(21, new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '검정고시 학원비 등 자기부담 영수증', '22.1.1 이후 합격자 인정'));
		ntkrdfDocArr.push(new Array(22, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '장애인증명서', '소득세법상 「장애인 증명서」 인정'));
		
		thirdcntyDocArr.push(new Array(1, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '진로·진학검사지', '커리어넷, 워크넷에서 진로/진학 검사 후 결과 제출'));
		thirdcntyDocArr.push(new Array(2, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '장학금신청서', '[장학금신청서, 학업계획서, 서약서, 개인정보동의서] 파일을 다운로드하여 이용해주세요.'));
		thirdcntyDocArr.push(new Array(3, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학업계획서', ''));
		thirdcntyDocArr.push(new Array(4, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '서약서', ''));
		thirdcntyDocArr.push(new Array(5, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '개인정보동의서', ''));
//		thirdcntyDocArr.push(new Array(6, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '북한이탈주민등록확인서', ''));
		thirdcntyDocArr.push(new Array(7, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '주민등록등본', ''));
		thirdcntyDocArr.push(new Array(8, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '가족관계증명서(상세)', '기혼 : 본인기준 / 미혼 : 부모기준'));
		thirdcntyDocArr.push(new Array(9, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '통장사본', '신청자본인 명의 통장사본 / 적금통장 불가'));
		thirdcntyDocArr.push(new Array(10, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '국민기초생활수급자증명서', '대상자만 제출'));
		thirdcntyDocArr.push(new Array(11, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '차상위계층 증빙서류', '대상자만 제출 (차상위계층확인서, 한부모가족증명서, 자활근로자확인서, 장애(아동)수당 대상자확인서, 차상위본인부담 경감대상자 증명서 중 택1)'));
		thirdcntyDocArr.push(new Array(12, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학자금 지원 구간 통지서', '발급가능한 자에 한함'));
		thirdcntyDocArr.push(new Array(13, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '기본증명서(상세)', ''));
		thirdcntyDocArr.push(new Array(14, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '재학증명서', '22.8.1. 이후 발급분 인정'));
		thirdcntyDocArr.push(new Array(15, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '수강등록증빙', '22년 2학기 / 22.8.1. 이후 발급분 인정'));
		thirdcntyDocArr.push(new Array(16, new Array('N', 'N', 'Y', 'N', 'N'), new Array('N', 'N', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '교육비 납입증명서', '22년 여름학기, 2학기 / 22.8.1. 이후 발급분 인정'));
		thirdcntyDocArr.push(new Array(17, new Array('N', 'N', 'N', 'Y', 'N'), new Array('N', 'N', 'N', 'Y', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '학교생활기록부', '성적명시 / 22.8.1. 이후 발급분 인정'));
		thirdcntyDocArr.push(new Array(18, new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('Y', 'Y', 'Y', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '성적증명서', '22.8.1. 이후 발급분 인정'));
		thirdcntyDocArr.push(new Array(19, new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '취업관리시스템 가입신청서', '[취업관리시스템 가입신청서] 파일을 다운로드하여 이용해주세요. '));
		thirdcntyDocArr.push(new Array(20, new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '검정고시 합격증서 사본', '22.1.1 이후 합격자 인정'));
		thirdcntyDocArr.push(new Array(21, new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '검정고시 학원비 등 자기부담 영수증', '22.1.1 이후 합격자 인정'));
		thirdcntyDocArr.push(new Array(22, new Array('Y', 'Y', 'Y', 'Y', 'Y'), new Array('N', 'N', 'N', 'N', 'N'), new Array('N', 'N', 'N', 'N', 'N'), new Array('Y', 'Y', 'Y', 'Y', 'Y'), '장애인증명서', '소득세법상 「장애인 증명서」 인정'));
		
		var showYn = '';
		var smbsnDocNm = '';
		var smbsnRsn = '';
		var smbsnDocRqrYn = '';
		var smbsnDocMtlYn = '';
		var docBoxYn = '';
		
		$(ntkrdfDocArr).each(function(fnIdx, fnObj){
			smbsnType = fnObj[0];		//서류구분
			showYn = fnObj[1];			//표시여부
			smbsnDocRqrYn = fnObj[2];	//필수여부
			smbsnDocMtlYn = fnObj[3];	//복수등록여부
			docBoxYn = fnObj[4];		//문서함사용여부
			smbsnDocNm = fnObj[5];		//서류명
			smbsnRsn = fnObj[6];		//서류설명
			
			for(var i=1; i<=5; i++){	//(1:대학원생|2:대학생|3:대학생계절학기|4:중고등학생|5:검정고시합격자)
				if(showYn[i-1] == 'Y'){
					smbObj = {};
					smbObj.smbsnDocTypeVl = ntkrdf+i;
					smbObj.smbsnDocNm = smbsnDocNm;
					smbObj.smbsnRsn = smbsnRsn;
					smbObj.smbsnDocRqrYn = smbsnDocRqrYn[i-1];
					smbObj.smbsnDocMtlYn = smbsnDocMtlYn[i-1];
					smbObj.docBoxYn = docBoxYn[i-1];
					if(smbDocVal == 'all' || smbDocVal == smbObj.smbsnDocTypeVl) smbArr.push(smbObj);
				}
			}
		});
		
		$(thirdcntyDocArr).each(function(fnIdx, fnObj){
			smbsnType = fnObj[0];		//서류구분
			showYn = fnObj[1];			//표시여부
			smbsnDocRqrYn = fnObj[2];	//필수여부
			smbsnDocMtlYn = fnObj[3];	//복수등록여부
			docBoxYn = fnObj[4];		//문서함사용여부
			smbsnDocNm = fnObj[5];		//서류명
			smbsnRsn = fnObj[6];		//서류설명
			
			for(var i=1; i<=5; i++){	//(1:대학원생|2:대학생|3:대학생계절학기|4:중고등학생|5:검정고시합격자)
				if(showYn[i-1] == 'Y'){
					smbObj = {};
					smbObj.smbsnDocTypeVl = thirdcnty+i;
					smbObj.smbsnDocNm = smbsnDocNm;
					smbObj.smbsnRsn = smbsnRsn;
					smbObj.smbsnDocRqrYn = smbsnDocRqrYn[i-1];
					smbObj.smbsnDocMtlYn = smbsnDocMtlYn[i-1];
					smbObj.docBoxYn = docBoxYn[i-1];
					if(smbDocVal == 'all' || smbDocVal == smbObj.smbsnDocTypeVl) smbArr.push(smbObj);
				}
			}
		});
		
	}else if(pbancrcCtgryFrstCd == '10002' && bizSeCd == '11001'){
		//가산금(장애)
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		docArr.push(new Array(1, 'Y', 'N', 'Y', '신분증사본', ''));
		docArr.push(new Array(2, 'Y', 'N', 'Y', '통장사본 (본인명의)', ''));
		docArr.push(new Array(3, 'Y', 'Y', 'Y', '장애 증빙서류', '장애인증명서, 장애진단서, 복지카드 사본 등 통일부장관이 인정하는 장애에 해당하는 것을 증명할 수 있는 서류'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10002' && bizSeCd == '11002'){
		//가산금(장기치료)
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		docArr.push(new Array(1, 'Y', 'N', 'Y', '신분증사본', ''));
		docArr.push(new Array(2, 'Y', 'N', 'Y', '통장사본 (본인명의)', ''));
		docArr.push(new Array(3, 'Y', 'N', 'Y', '장기치료 증빙서류', '진단서, 입원 확인서 등 3개월 이상 치료가 필요하다는 것을 증명할 수 있는 서류'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10002' && bizSeCd == '11003'){
		//가산금(제3국)
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		docArr.push(new Array(1, 'Y', 'N', 'Y', '신분증사본', ''));
		docArr.push(new Array(2, 'Y', 'N', 'Y', '통장사본 (본인명의)', ''));
		docArr.push(new Array(3, 'Y', 'N', 'Y', '제3국 출생 자녀 양육 증빙서류', '기본증명서, 가족관계증명서, 주민등록표등본 등 제3국에서 출생한 자녀를 양육하는 것을 증명할 수 있는 서류'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10007'){
		//정착지원 전문관리사
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		if(bizSeCd == '11005'){			//중급
			docArr.push(new Array(1, 'Y', 'N', 'Y', '초급교육이수 수료증', ''));
		}else if(bizSeCd == '11006'){	//고급
			docArr.push(new Array(1, 'Y', 'N', 'Y', '중급교육이수 수료증', ''));
		}else if(bizSeCd == '11008'){	//실기
			docArr.push(new Array(1, 'Y', 'N', 'Y', '이론교육이수 수료증', ''));
		}else if(bizSeCd == '11009'){	//자격시험
			docArr.push(new Array(1, 'Y', 'N', 'Y', '고급교육 또는 이론교육 수료증', ''));
		}
		
		docArr.push(new Array(2, 'Y', 'N', 'Y', '개인정보 수집·이용 및 제3자 제공 동의서', ''));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10009' && bizSeCd == '11010'){
		//취업연계 + 버스기사
		
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		docArr.push(new Array(1, 'Y', 'N', 'Y', '운전 경력증명서', ''));
		docArr.push(new Array(2, 'N', 'N', 'Y', '버스운전자격증사본', ''));
		docArr.push(new Array(3, 'N', 'N', 'Y', '1종대형운전면허증사본', ''));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10001'){
		//긴급생계비
		
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		docArr.push(new Array(1, 'Y', 'N', 'Y', '공문', ''));
		docArr.push(new Array(2, 'Y', 'N', 'Y', '긴급생계비 지원 신청서', '[긴급생계비 지원 신청서 ] 파일을 다운로드하여 이용해주세요.'));
		docArr.push(new Array(3, 'Y', 'N', 'Y', '북한이탈주민 확인서', ''));
		docArr.push(new Array(4, 'Y', 'N', 'Y', '통장사본', ''));
		docArr.push(new Array(5, 'Y', 'N', 'Y', '주민등록등본', ''));
		docArr.push(new Array(6, 'Y', 'N', 'Y', '가족관계증명서', ''));
		docArr.push(new Array(7, 'Y', 'Y', 'Y', '위기상황에 대한 증빙서류', '1개 이상 필수 첨부'));
		docArr.push(new Array(8, 'N', 'N', 'Y', '기초생활수급 증명서', '해당하는 경우 제출'));
		docArr.push(new Array(9, 'N', 'N', 'Y', '차상위계층 증명서', '해당하는 경우 제출'));
		docArr.push(new Array(10, 'N', 'N', 'Y', '건강보험자격확인서 (건강보험증 사본)', '중위소득 75%이하에 해당하는 경우 소득활동 중인 가구원 모두 제출'));
		docArr.push(new Array(11, 'N', 'N', 'Y', '건강보험료 납부 확인서', '중위소득 75%이하에 해당하는 경우 소득활동 중인 가구원 모두 제출 (6개월 납부내역)'));
		docArr.push(new Array(12, 'N', 'N', 'Y', '한부모가족증명서', ''));
		docArr.push(new Array(13, 'N', 'Y', 'Y', '공과금 등 체납 증빙서류', '해당하는 경우 제출'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10008'){
		//취업바우처카드
		
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		docArr.push(new Array(1,  'Y', 'N', 'Y', '바우처카드 신청서류', '[바우처카드 신청서, 개인정보 수집·이용·제3자 제공 동의서, 우리카드 발급신청서] 파일을 다운로드하여 이용해주세요.'));
		docArr.push(new Array(2,  'Y', 'N', 'Y', '신분증 사본', '대형운전면허 및 중장비과정은 운전면허증 사본을 제출해주세요.'));
		docArr.push(new Array(3,  'Y', 'N', 'Y', '북한이탈주민등록확인서', '바우처카드 ‘17년 이전 신청자, 올해 첫 신청자는 북한이탈주민등록확인서를 제출해주세요.'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10004'){
		//교육지원금
		
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		docArr.push(new Array(1,  'Y', 'N', 'Y', '교육보조금 지급신청서', '[교육지원 보조금 지급신청서] 파일을 다운로드하여 이용해주세요.'));
		docArr.push(new Array(2,  'Y', 'N', 'Y', '성적통지서 / 학적현황', '[교육지원대상 성적통지서, 학적현황] 파일을 다운로드하여 이용해주세요.'));
		docArr.push(new Array(3,  'N', 'Y', 'Y', '기타 증빙서류', '기타 학교별 증빙서류를 자유롭게 등록해 주세요. (첨부파일은 최대 10개까지 등록 가능합니다.)'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}else if(pbancrcCtgryFrstCd == '10005' || pbancrcCtgryFrstCd == '10006'){
		//화상영어 or 학습지
		
		var smbsnDocTypeVl = 'none1';
		smbTypObj = {};
		smbTypObj.smbsnDocTypeVl = smbsnDocTypeVl;
		smbTypArr.push(smbTypObj);
			
		var docArr = new Array();
		
		docArr.push(new Array(1,  'Y', 'N', 'Y', '주민등록표등본', '주민등록표등본 제출 시 반드시 세대원이 포함되어 나올 수 있도록 발급해주세요.'));
		
		var smbArr = new Array();
		var smbObj = {};
		$(docArr).each(function(fnIdx, fnObj){
			smbObj = {};
			smbObj.smbsnDocTypeVl = smbsnDocTypeVl;
			smbObj.smbsnType = fnObj[0];		//서류구분
			smbObj.smbsnDocRqrYn = fnObj[1];	//필수여부
			smbObj.smbsnDocMtlYn = fnObj[2];	//복수등록여부
			smbObj.docBoxYn = fnObj[3];		//문서함사용여부
			smbObj.smbsnDocNm = fnObj[4];		//서류명
			smbObj.smbsnRsn = fnObj[5];		//서류설명
			smbArr.push(smbObj);
		});
	}
	retObj.smbTypArr = smbTypArr;
	retObj.smbArr = smbArr;
	return retObj;
}