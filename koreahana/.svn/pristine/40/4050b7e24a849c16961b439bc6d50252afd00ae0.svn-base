$(document).ready(function(){
	$('#cancelBtn').on('click',fnCancel);
	$('#saveBtn').on('click',fnSave);

	var ajform = new ComAjaxForm('writeForm','listPageForm', {
		beforeSerializeFunction:function(form, options){
			//회차별 지원정보 문자열연결
			var _cc = '';
			var _cnt = $('#totGiveNmtm').val();
			for(var i = 1; i <= _cnt; i++){
				var _ym = $('#rndYm' + i).val();
				var _amt = $('#rndAmt' + i).val();
				if(isNaN(_amt) || _amt == '')_amt = 0;
				if(_cc != '')_cc += ',';
				_cc += i + '^' + _ym + '^' +  _amt;
				//날짜 validate체크
				if(_ym != '' && !isValidDate(_ym + '-01')){					
					alert('올바른 연월을 입력해 주세요');
					$('#rndYm' + i).focus();
					return false;
				}
			}
			$('#rndConcat').val(_cc);
		}
	});
	ajform.init();
	
	$('#totGiveNmtm').on('change',fnChangeRnd);
	fnChangeRnd();
	fnCalRndAmt();
	
	$('#frstChdrBrdtYmd').on('keyup',fnChangeFrstBrdt);
	$('#frstChdrBrdtYmd').on('change',fnChangeFrstBrdt);
	fnChangeFrstBrdt();

	$('#scndryChdrBrdtYmd').on('keyup',fnChangeScndryBrdt);
	$('#scndryChdrBrdtYmd').on('change',fnChangeScndryBrdt);
	fnChangeScndryBrdt();
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}

//취소
function fnCancel(){
	if($('#adtnAmtSprtPrcnMngSn').val() != ''){
		$("#viewPageForm").submit();	
	}else{
		fnList();
	}
	return false;
}


//저장
function fnSave(){
	if(confirm(Msg.com.confirmSave)){
		$('#writeForm').submit();
		return false;
	}
}


//회차별지원정보 만들기
function fnChangeRnd(){
	var _cnt = $('#totGiveNmtm').val();
	var _html = '';
	for(var i = 1; i <= _cnt; i++){
		_html += $('#rndDiv').html().replace(/@cnt@/g,i);
	}
	$('#rndTbody').html(_html)
	
	//숫자만 입력가능 및 기존 데이터 입력
	for(var i = 1; i <= _cnt; i++){
		ComFns.numberOnly('#rndAmt' + i);
		if(arrRndData[i] != null){
			$('#rndAmt' + i).val(arrRndData[i]);
			$('#rndYm' + i).val(arrRndYmData[i]);
		}
	}
	
}

//회차별 금액 변경시.
function fnChangeRndAmt(obj){
	var _rnd = $(obj).attr('id').replace('rndAmt','');
	arrRndData[_rnd] = obj.value;
	fnCalRndAmt();
}

//회차별지원금액 계산
function fnCalRndAmt(){
	var _dcsnAmt = $('#frstDcsnAmt').val();
	if(isNaN(_dcsnAmt))_dcsnAmt = 0;
	var _tot = 0;
	var _remain = 0;
	var _cnt = $('#totGiveNmtm').val();
	for(var i = 1; i <= _cnt; i++){
		var _amt = $('#rndAmt' + i).val();
		if(isNaN(_amt) || _amt == '')_amt = 0;
		_tot = _tot*1 + _amt*1;
	}
	_remain = _dcsnAmt - _tot;
	
	$('#giveTotalAmt').text($.number(_tot));
	$('#remainTotalAmt').text($.number(_remain));
}


//자녀1 만나이 처리
function fnChangeFrstBrdt(){
	var _b = $('#frstChdrBrdtYmd').val();
	var _age = xCalManAge(_b);
	$('#frstChdrSpan').removeClass('txt_c_bl').removeClass('txt_c_re');
	if(_b == ''){
		$('#frstChdrSpan').text('');
	}else if(_age > 15){
		$('#frstChdrSpan').text('만 15세 이하 지원가능');
		$('#frstChdrSpan').addClass('txt_c_re');
	}else{
		$('#frstChdrSpan').text('만 ' + _age + '세');
		$('#frstChdrSpan').addClass('txt_c_bl');
	}
}

//자녀2 만나이 처리
function fnChangeScndryBrdt(){
	var _b = $('#scndryChdrBrdtYmd').val();
	var _age = xCalManAge(_b);
	$('#scndryChdrSpan').removeClass('txt_c_bl').removeClass('txt_c_re');
	if(_b == ''){
		$('#scndryChdrSpan').text('');
	}else if(_age > 15){
		$('#scndryChdrSpan').text('만 15세 이하 지원가능');
		$('#scndryChdrSpan').addClass('txt_c_re');
	}else{
		$('#scndryChdrSpan').text('만 ' + _age + '세');
		$('#scndryChdrSpan').addClass('txt_c_bl');
	}
}


//만 나이계산
function xCalManAge(_birth) {
	let _rtnAge=0;
    try {
		let _todayDateTime = new Date();
		
		// 월은 0~11 로 넣기 때문에 -1한다.
		let _birthDateTime = new Date(_birth.substr(0, 4), Number(_birth.substr(5, 2))-1, Number(_birth.substr(8, 2))); //  

		// 일반나이 = 현재년도 - 출생년도
		_rtnAge = _todayDateTime.getFullYear() - _birthDateTime.getFullYear();

		// 생일이 안 지났으면 -1 한다.
		let _monthgap = _todayDateTime.getMonth() - _birthDateTime.getMonth();
		// 출생월이 작거나, 같은경우 일이 작은 경우는 생일이 안 지난 것이다.
		if ( _monthgap < 0 || (_monthgap === 0 && _todayDateTime.getDate() < _birthDateTime.getDate())) {
			_rtnAge--;
		}
    } catch (e) {
		_rtnAge=0;
    }
	return _rtnAge;
}


function isValidDate(s) {
    var pt = /^\d{4}-\d{2}-\d{2}$/;
    if (!pt.test(s)) return false;
    var y = parseInt(s.substr(0,4), 10);
    var m = parseInt(s.substr(5,2), 10) - 1;
    var d = parseInt(s.substr(8,2), 10);
    var dt = new Date(y, m, d);
    if (dt.getYear()+1900 == y&&dt.getMonth() == m&&dt.getDate() == d) {
        return true;
    }
    else {
        return false;
    }
}