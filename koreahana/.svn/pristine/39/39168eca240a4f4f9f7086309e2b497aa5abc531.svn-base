var uploadableCnt = 0;//업로드 가능 데이터 갯수
var uploadResultDataList;//업로드 완료 후 데이터저장공간

$(document).ready(function(){

	//엑셀 파일 파싱초기화
	ComFns.excelParseInit('#selFileText','#selFileLabel','#checkBtn',function(data){
		fnChangeStep(3);
		ComFns.makeExcelData('#writeForm', data);
		ComFns.makeExcelData('#validationForm', data);
		fnValidate();
	},
	function(){
		fnChangeStep(2);
	});
	

	var ajform = new ComAjaxForm('writeForm','listPageForm', {
		successFunction: function(resultData, statusText, xhr, $form){
			ComFns.hideLoading();
			if(resultData.isSuccess == true){
				uploadResultDataList = resultData.data;
				var _errCnt = 0;
				for(var i=0; i<resultData.data.length; i++){
					var _data = resultData.data[i];
					var _err = {
						sprtSn:[],
						sprtSttsCd:[],
						rsn:[],
					};
					if(_data.errorList != undefined && _data.errorList.length > 0){
						for(var e = 0; e < _data.errorList.length; e++){
							var _curError = _data.errorList[e];
							_err[_curError.errorField].push(_curError);
						}	
						_errCnt++;
					}	
				}
				fnChangeStep(4);
				$('#uploadResultSuccessEm').text((resultData.data.length - _errCnt) + '건');
				$('#uploadResultFailEm').text(_errCnt + '건');
			}else{
				alert(resultData.msg);
			}
		}
	});
	ajform.init();
	
	//초기화버튼
	$('#initBtn').on('click',function(){
		fnChangeStep(1);
		return false;
	});
	//업로드버튼
	$('#uploadBtn').on('click',function(){
		if(uploadableCnt == 0){
			alert('업로드할 데이터가 없습니다.');
			return false;
		}
		if(confirm(Msg.com.confirmSave)){
			$('#writeForm').submit();
			return false;
		}
	});
	
	
});
//업로드 결과 보기
function fnShowResult(){
	if(uploadResultDataList == undefined|| uploadResultDataList == null){
		alert('업로드결과가 존재하지 않습니다.');
		return false;
	}
	var _errHtml = '';
	var _errCnt = 0;
	for(var i=0; i<uploadResultDataList.length; i++){
		var _data = uploadResultDataList[i];
		var _errMsg = []
		if(_data.errorList != undefined && _data.errorList.length > 0){
			for(var e = 0; e < _data.errorList.length; e++){
				var _curError = _data.errorList[e];
				_errMsg.push(_curError);
				
			}	
			_errCnt++;
			_errHtml += '		<tr>';
			_errHtml += '			<td>' + ComFns.convertText(_data.vo.sprtSn) + '</td>';
			_errHtml += '			<td>' + ComFns.convertText(_data.vo.flnm) + '</td>';
			_errHtml += '			<td>' + ComFns.printErrorArrayMessage(_errMsg) + '</td>';
			_errHtml += '		</tr>';
		}
	}
	var _conHtml = '';
	_conHtml += '<p class="p_h5">실패건수 : ' + _errCnt + '건</p>';
	_conHtml += '<table class="table_style">';
	_conHtml += '	<thead>';
	_conHtml += '		<tr>';
	_conHtml += '			<th scope="col">신청번호</th>';
	_conHtml += '			<th scope="col">지원대상</th>';
	_conHtml += '			<th scope="col">오류</th>';
	_conHtml += '		</tr>';
	_conHtml += '	</thead>';
	_conHtml += '	<tbody>';
	_conHtml += _errHtml;
	_conHtml += '	</tbody>';
	_conHtml += '</table>';
	
	ComFns.popup.init({title:'업로드 실패 상세'});
	ComFns.popup.changeContentHtml(_conHtml);
	ComFns.popup.show();
}

//validation
function fnValidate(){
	ComFns.showLoading();
	uploadableCnt = 0;
	$.ajax({
		url:actionUrl,
		type:'POST',
		enctype: 'multipart/form-data',
		data:new FormData($('#validationForm')[0]),
        processData: false,
        contentType: false,
        cache: false,
		success:function(resultData){
			$("#excelUploadTbody").empty();				

			var html = '';
			var value = '';
			var _errCnt = 0;
			for(var i=0; i<resultData.length; i++){
				
				var _data = resultData[i];
				var _err = {
						sprtSn:[],
						regDtStr:[],
						sprtSttsCd:[],
						rsn:[],
				};
				if(_data.errorList != undefined && _data.errorList.length > 0){
					for(var e = 0; e < _data.errorList.length; e++){
						var _curError = _data.errorList[e];
						_err[_curError.errorField].push(_curError);
					}	
					_errCnt++;
				}else{
					uploadableCnt++;
				}
				
				html += '<tr>';
				html += '	<td' + (_err.sprtSn.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(i);
				html += 		(_err.sprtSn.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.sprtSn) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.sprtSn.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.sprtSn);
				html += 		(_err.sprtSn.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.sprtSn) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.regDtStr.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.regDtStr);
				html += 		(_err.regDtStr.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.regDtStr) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.sprtSttsCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.sprtSttsCd);
				html += 		(_err.sprtSttsCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.sprtSttsCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.rsn.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rsn);
				html += 		(_err.rsn.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rsn) + '</span>':'') ;
				html += '	</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.flnm) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.genderCd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.brdtYmd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.ntkrdfUnqNo) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.entcnyYmd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.prtdcsYmd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.hanawonFnshYmd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.hanawonTh) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.mbphno) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.zip) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.lastAcbgSchlNm) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.lastAcbgSchlGrdtnCd) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.lastAcbgMjrNm) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.empmSttsYn) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.empmWrcNm) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.rsnaplc) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.hgvlcYn) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.busDrvngCrtfctYn) + '</td>';
				html += '	<td>' + ComFns.convertText(_data.vo.hopeTrpttBzenty) + '</td>';
				html += '</tr>';
			}
			$("#excelUploadTbody").append(html);
			$('#msgSpan').text('오류 : ' + _errCnt + '건');

			ComFns.hideLoading();
		}
	});
}

//스텝변경
function fnChangeStep(step){
	$('#msgSpan').text('');
	$('#step1Li').removeClass('on').removeClass('check');
	$('#step2Li').removeClass('on').removeClass('check');
	$('#step3Li').removeClass('on').removeClass('check');
	$('#step4Li').removeClass('on').removeClass('check');
	for(var i = 1; i < step; i++){
		$('#step' + i + 'Li').addClass('on').addClass('check');
	}
	$('#step' + step + 'Li').addClass('on');
	$('#uploadResultDiv').hide();
	$('#initBtn').hide();
	$('#uploadBtn').hide();
	$('#uploadTableDiv').show();
	$('#checkBtn').hide();
	
	//각 스텝별 처리
	if(step == 1){
		$('#excelFileForParse').val('');
		$('#selFileText').text('');
		$('#excelUploadTbody').empty();
	}else if(step == 2){
		$('#excelUploadTbody').empty();
		$('#checkBtn').show();
	}else if(step == 3){
		$('#initBtn').show();
		$('#uploadBtn').show();
	}else if(step == 4){
		$('#excelFileForParse').val('');
		$('#selFileText').text('');
		$('#excelUploadTbody').empty();
		$('#initBtn').hide();
		$('#uploadBtn').hide();
		$('#uploadResultDiv').show();
		$('#uploadTableDiv').hide();
	}
}


