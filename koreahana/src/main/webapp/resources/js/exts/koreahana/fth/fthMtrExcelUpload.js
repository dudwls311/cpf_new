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
							flnm:[],
							rrno:[],
							mbphno:[],
							ctpvCd:[],
							sggCd:[],
							rcptYmd:[],
							cncltnYmd:[],
							jrdcHanactNm:[],
							bbJoinYmd:[],
							usdusgCd:[],
							idtprsSavingAmt:[],
							fndtSavingAmt:[],
							mtryMmCnt:[],
							fncEduTkclsYmd:[],
							idtprsSavingAmtActno:[],
							stmchkActno:[],
							rmrk:[],
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
			_errHtml += '			<td>' + ComFns.convertText(_data.vo.flnm) + '</td>';
			_errHtml += '			<td>' + ComFns.convertText(_data.vo.rrno) + '</td>';
			_errHtml += '			<td>' + ComFns.printErrorArrayMessage(_errMsg) + '</td>';
			_errHtml += '		</tr>';
		}
	}
	var _conHtml = '';
	_conHtml += '<p class="p_h5">실패건수 : ' + _errCnt + '건</p>';
	_conHtml += '<table class="table_style">';
	_conHtml += '	<thead>';
	_conHtml += '		<tr>';
	_conHtml += '			<th scope="col">성명</th>';
	_conHtml += '			<th scope="col">주민번호</th>';
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
						flnm:[],
						rrno:[],
						mbphno:[],
						ctpvCd:[],
						sggCd:[],
						rcptYmd:[],
						cncltnYmd:[],
						jrdcHanactNm:[],
						bbJoinYmd:[],
						usdusgCd:[],
						idtprsSavingAmt:[],
						fndtSavingAmt:[],
						mtryMmCnt:[],
						fncEduTkclsYmd:[],
						idtprsSavingAmtActno:[],
						stmchkActno:[],
						rmrk:[],
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
				html += '	<td' + (_err.rcptYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rcptYmd);
				html += 		(_err.rcptYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rcptYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.cncltnYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.cncltnYmd);
				html += 		(_err.cncltnYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.cncltnYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.flnm.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.flnm);
				html += 		(_err.flnm.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.flnm) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.rrno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rrno);
				html += 		(_err.rrno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rrno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.mbphno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.mbphno);
				html += 		(_err.mbphno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.mbphno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.ctpvCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.ctpvCd);
				html += 		(_err.ctpvCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.ctpvCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.sggCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.sggCd);
				html += 		(_err.sggCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.sggCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.jrdcHanactNm.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.jrdcHanactNm);
				html += 		(_err.jrdcHanactNm.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.jrdcHanactNm) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.bbJoinYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.bbJoinYmd);
				html += 		(_err.bbJoinYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.bbJoinYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.usdusgCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.usdusgCd);
				html += 		(_err.usdusgCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.usdusgCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.idtprsSavingAmt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.idtprsSavingAmt);
				html += 		(_err.idtprsSavingAmt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.idtprsSavingAmt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.fndtSavingAmt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.fndtSavingAmt);
				html += 		(_err.fndtSavingAmt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.fndtSavingAmt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.mtryMmCnt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.mtryMmCnt);
				html += 		(_err.mtryMmCnt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.mtryMmCnt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.fncEduTkclsYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.fncEduTkclsYmd);
				html += 		(_err.fncEduTkclsYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.fncEduTkclsYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.idtprsSavingAmtActno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.idtprsSavingAmtActno);
				html += 		(_err.idtprsSavingAmtActno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.idtprsSavingAmtActno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.stmchkActno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.stmchkActno);
				html += 		(_err.stmchkActno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.stmchkActno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.rmrk.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rmrk);
				html += 		(_err.rmrk.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rmrk) + '</span>':'') ;
				html += '	</td>';
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


