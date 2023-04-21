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
							brdtYmd:[],
							rrnoBknb:[],
							hnwCycl:[],
							mbphno:[],
							conm:[],
							bzstatCd:[],
							bzstatOsd:[],
							tpbizNm:[],
							brno:[],
							bizStartYmd:[],
							addr:[],
							carmdlCd:[],
							mlg:[],
							vhclMdyr:[],
							rcmtFldCd:[],
							sprtYr:[],
							dcsnAmt:[],
							prchsDsctn:[],
							prchsAmt:[],
							giveAmt:[],
							giveCycl:[],
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
			_errHtml += '			<td>' + ComFns.convertText(_data.vo.brdtYmd) + '</td>';
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
	_conHtml += '			<th scope="col">생년월일</th>';
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
						brdtYmd:[],
						rrnoBknb:[],
						hnwCycl:[],
						mbphno:[],
						conm:[],
						bzstatCd:[],
						bzstatOsd:[],
						tpbizNm:[],
						brno:[],
						bizStartYmd:[],
						addr:[],
						carmdlCd:[],
						mlg:[],
						vhclMdyr:[],
						rcmtFldCd:[],
						sprtYr:[],
						dcsnAmt:[],
						prchsDsctn:[],
						prchsAmt:[],
						giveAmt:[],
						giveCycl:[],
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
				html += '	<td' + (_err.flnm.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.flnm);
				html += 		(_err.flnm.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.flnm) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.brdtYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.brdtYmd);
				html += 		(_err.brdtYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.brdtYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.rrnoBknb.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rrnoBknb);
				html += 		(_err.rrnoBknb.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rrnoBknb) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.hnwCycl.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.hnwCycl);
				html += 		(_err.hnwCycl.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.hnwCycl) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.mbphno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.mbphno);
				html += 		(_err.mbphno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.mbphno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.conm.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.conm);
				html += 		(_err.conm.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.conm) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.bzstatCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.bzstatCd);
				html += 		(_err.bzstatCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.bzstatCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.bzstatOsd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.bzstatOsd);
				html += 		(_err.bzstatOsd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.bzstatOsd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.tpbizNm.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.tpbizNm);
				html += 		(_err.tpbizNm.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.tpbizNm) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.brno.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.brno);
				html += 		(_err.brno.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.brno) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.bizStartYmd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.bizStartYmd);
				html += 		(_err.bizStartYmd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.bizStartYmd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.addr.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.addr);
				html += 		(_err.addr.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.addr) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.carmdlCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.carmdlCd);
				html += 		(_err.carmdlCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.carmdlCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.mlg.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.mlg);
				html += 		(_err.mlg.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.mlg) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.vhclMdyr.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.vhclMdyr);
				html += 		(_err.vhclMdyr.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.vhclMdyr) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.rcmtFldCd.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.rcmtFldCd);
				html += 		(_err.rcmtFldCd.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.rcmtFldCd) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.sprtYr.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.sprtYr);
				html += 		(_err.sprtYr.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.sprtYr) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.dcsnAmt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.dcsnAmt);
				html += 		(_err.dcsnAmt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.dcsnAmt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.prchsDsctn.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.prchsDsctn);
				html += 		(_err.prchsDsctn.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.prchsDsctn) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.prchsAmt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.prchsAmt);
				html += 		(_err.prchsAmt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.prchsAmt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.giveAmt.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.giveAmt);
				html += 		(_err.giveAmt.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.giveAmt) + '</span>':'') ;
				html += '	</td>';
				html += '	<td' + (_err.giveCycl.length > 0?' class="error"':'') + '>' ;
				html += 		ComFns.convertText(_data.vo.giveCycl);
				html += 		(_err.giveCycl.length > 0?'<span class="tooltip">' + ComFns.printErrorArrayMessage(_err.giveCycl) + '</span>':'') ;
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


