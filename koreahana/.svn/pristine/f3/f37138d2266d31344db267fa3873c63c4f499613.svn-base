var canvas = '';
var sign = '';

$(document).ready(function(){

	var ajform = new ComAjaxForm('sgnWriteForm','listPageForm', {});
	ajform.init();

	var writeType = $("#writeType").val();
	if(writeType == 'file'){
		fnSetFileForm();
		
		$('#writeFileForm').ajaxForm({
			success : function(data){
				if(data.isSuccess){
					$("#atchFileSn").val(data.data.atchFileSn);
					fnSetImgForm(ComFns.getContextUrl() + 'user/exts/koreahana/sgn/index.do?ksMode=sgnView&enc='+data.msg, '서명 파일');
				}
			},
			error: function(error){
				console.log(error);
			}
		});
		
	}else{
		canvas = $('#signature-pad canvas')[0];
		if(canvas != undefined){
			sign = new SignaturePad(canvas, {});
			resizeCanvas(canvas);
		}
	}
});

function resizeCanvas(canvas){
	var ratio =  Math.max(window.devicePixelRatio || 1, 1);
	canvas.width = 450;
	canvas.height = 240;
	canvas.getContext('2d').scale(ratio, ratio);
}

function fnSignClear(){
	sign.clear();
};

function fnSetFileForm(){
	$("#atchFileSn").val('');
	
	var signFileForm = $("#signFileForm").html();
	$("#signFileDiv").empty().append(signFileForm);
	
	//첨부파일 
	$("#sgnFile").on('change', function(){
		$("#writeFileForm").submit();
	});
	
	//첨부파일 클릭 트리거
	$("button[id$=Trg]").on('click', function(){
	    var fileId = $(this).attr('id').replace('Trg', '');
	    $("#"+fileId).trigger('click');
	    return false;
	});
}

function fnSetImgForm(imgSrc, imgAlt){
	var signImgForm = $("#signImgForm").html();
	signImgForm = signImgForm.replace(/@imgSrc@/g, imgSrc).replace(/@imgAlt@/g, imgAlt);
	signImgForm = signImgForm.replace(/@.+@/g, '');
	$("#signFileDiv").empty().append(signImgForm);
}