<%
/**
 *@version 3.2.0.1
 **/
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/jnit/board/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>" />
<script src="/resources/js/jquery.plugins/jquery.ui.latest.custom.min.js"></script>
<script src="/resources/js/jquery.plugins/jquery.ui.datepicker-ko.js"></script>
<script src="/resources/js/jquery.plugins/jquery.ui.timepicker.addon.js"></script>
<script>
$(document).ready(function(){
	var ext01Value = $("#ext01Value").val();
	var ext02Value = $("#ext02Value").val();
	
	$("#searchext01").val(ext01Value);
	fnExt01Change(ext02Value);
	
	$("#searchext01").on('change', function(){
		fnExt01Change();
	});
	
	initDatePicker('.date_style');//날짜입력박스
	
	betweenDatepickerOption('#createdStartDate', '#createdEndDate');
});

function fnExt01Change(val){
	var ext01 = $("#searchext01").val();
	
	$("#searchext02").find('option').remove();
	
	var ext02Arr = [];
	var ext01Type = '';
	if(ext01 == '지원사업신청'){
		ext01Type = '1';
		ext02Arr.push('가산금지원');
		ext02Arr.push('장학금');
		ext02Arr.push('교육지원금');
		ext02Arr.push('화상영어');
		ext02Arr.push('학습지');
		ext02Arr.push('정착지원 전문관리사');
		//ext02Arr.push('취업연계 직업훈련');
		
		<c:if test="${loginVO.typeId != '30035' && loginVO.typeId != '30036' }">
		ext02Arr.push('의료비');
		ext02Arr.push('긴급생계비');
		ext02Arr.push('취업바우처카드');
		ext02Arr.push('미래행복통장');
		ext02Arr.push('경영개선자금');
		ext02Arr.push('영농정착');
		</c:if>
		
	}else if(ext01 == '시스템사용'){
		ext01Type = '2';
		ext02Arr.push('고도화');
		ext02Arr.push('시스템오류');
		ext02Arr.push('시스템개선요청');
	}else{
		ext01Type = '3';
	}
	
	if(ext01Type != ''){
		var opt = '<option value="">전체</option>';
		var isSelected = '';
		$(ext02Arr).each(function(fnIdx, fnObj){
			isSelected = (fnObj == val ? 'selected' : '');
			opt += '<option value="'+fnObj+'" '+isSelected+'>'+fnObj+'</option>';
		});
		$("#searchext02").append(opt);
	}
}

initDatePicker = function (element, options){
	var currentYear = new Date().getFullYear()+2;
	var pastYear = (currentYear - 100);
	var calendarDefault = {};
	var monthNames = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
	var monthNamesShort = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
	var dayNamesMin = ['일','월','화','수','목','금','토'];
	var dateFormat = 'yy-mm-dd';
//	var minDate = '';
//	var maxDate = '';
	var buttonImage = '/resources/common/images/common/ico-cal.png';
	var yearRange = pastYear+':'+currentYear;
	calendarDefault = {
			monthNames: monthNames,
			monthNamesShort: monthNamesShort,
			dayNamesMin: dayNamesMin,
			weekHeader: 'Wk',
			dateFormat: dateFormat,
		    yearSuffix: '년',
			autoSize: false,
			changeMonth: true,
			changeYear: true,
			showMonthAfterYear: true,
//			buttonImageOnly: true,
//			buttonText: '달력선택',
//			buttonImage: buttonImage,
//			showOn: "both",
//			showOn: "button",
//		    minDate: minDate,
//		    maxDate: maxDate,
			yearRange: yearRange
		};
	for(var k in options){
		calendarDefault[k] = options[k];
	}
	if(options != undefined && options != null && options.reaonly != undefined && options.reaonly != '')$(element).prop("readonly",options.reaonly);
	$(element).datepicker(calendarDefault);
	$(element).prop('maxlength','10');
}


betweenDatepickerOption = function(startDateEle, endDateEle){
	$(startDateEle).datepicker('option','onSelect',function(selected){
		$(endDateEle).datepicker("option","minDate", selected);
	});
	$(endDateEle).datepicker('option','onSelect',function(selected){
		$(startDateEle).datepicker("option","maxDate", selected);
	});
}

function pageInit(){
	$("#pageIdx").val('1');
}
</script>

<form:form commandName="searchVO" name="bbsForm" id="bbsForm" method="get">
<input type="hidden" name="mode" value="<c:out value="${mode}" />" />
<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />

<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
				<input type="hidden" id="ext01Value" value="<c:out value="${param.searchext01 }" />" />
	    		<input type="hidden" id="ext02Value" value="<c:out value="${param.searchext02 }" />" />
	    		
				<label for="searchext01">구&nbsp;&nbsp;&nbsp;&nbsp;분</label>
				<select name="searchext01" id="searchext01" class="st_select">
					<option value="">전체</option>
					<option value="지원사업신청" ${param.searchext01 == '지원사업신청' ? 'selected' : '' } >지원사업신청</option>
					<option value="시스템사용" ${param.searchext01 == '시스템사용' ? 'selected' : '' }>시스템사용</option>
				</select> 
				<label for="searchext02" class="MAL20">유형</label>
				<select id="searchext02" name="searchext02" class="st_select" style="width: 200px;">
					<option value="">전체</option>
				</select>
				
				<label for="searchext18" class="MAL20">등록일</label>
				<input type="text" name="createdStartDate" id="createdStartDate" class="st_input date_style" value="<c:out value="${param.createdStartDate }" />" placeholder="시작일" style="width: 90px;">
				~
				<input type="text" name="createdEndDate" id="createdEndDate" class="st_input date_style" value="<c:out value="${param.createdEndDate }" />" placeholder="종료일" style="width: 90px;">
				
				<br />
				
				<label for="searchext03">담당자</label>
				<select name="searchext03" id="searchext03" class="st_select">
					<option value="">전체</option>
					<option value="시스템" ${param.searchext03 == '시스템' ? 'selected' : '' } >시스템</option>
					<option value="남북하나재단" ${param.searchext03 == '남북하나재단' ? 'selected' : '' }>남북하나재단</option>
				</select>
				
				<label for="searchext19" class="MAL20">제목</label>
				<input type="text" name="searchext19" id="searchext19" class="st_input" value="<c:out value="${param.searchext19 }" />" placeholder="제목+내용 검색" style="width: 202px;">
				
				<label for="searchext18" class="MAL20">작성자</label>
				<input type="text" name="searchext18" id="searchext18" class="st_input" value="<c:out value="${param.searchext18 }" />" placeholder="작성자 검색" style="width: 195px;">
				
				<label for="searchext04" class="MAL20">상태</label>
				<select name="searchext04" id="searchext04" class="st_select">
					<option value="">전체</option>
					<option value="신청" ${param.searchext04 == '신청' ? 'selected' : '' } >신청</option>
					<option value="접수" ${param.searchext04 == '접수' ? 'selected' : '' }>접수</option>
					<option value="답변완료" ${param.searchext04 == '답변완료' ? 'selected' : '' }>답변완료</option>
					<option value="처리불가" ${param.searchext04 == '처리불가' ? 'selected' : '' }>처리불가</option>
				</select>
			</div>
	
			<div class="ig_l">
				
			</div>
			
			<br />
			<div class="ig_s">
				<input type="hidden" name="searchCondition" value="koreahanaAll">
				<input type="hidden" name="searchKeyword" value="koreahanaAll">
				<button type="submit" class="btn-input-search" onclick="pageInit();">조회</button>
			</div>
		</div>
	</div>

<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>${totCnt}</span>건</p>
  <div class="FloatRight"><a class="btn_st btn_c_bk" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=write&category=${category}" />" >등록</a></div>
  <c:if test="${isAdmin == true }">
  	<div class="FloatRight MAR10"><a class="btn_st btn_c_sc" target="_blank" href="<c:out value="/cms/sub2/0101.do?retTypeId=lock" />" >사용자잠금해제</a></div>
  	<div class="FloatRight MAR10"><a class="btn_st btn_c_sc02" target="_blank" href="<c:out value="/exts/koreahana/com/main.do" />" >관리자페이지</a></div>
  	<%-- <div class="FloatRight MAR10"><a class="btn_st btn_c_sc03" target="_blank" href="<c:out value="/guide/etc/0007/0001/" />" >주소검색 매뉴얼</a></div> --%>
  	<div class="FloatRight MAR10"><a class="btn_st btn_c_bl" target="_blank" href="<c:out value="/login/logList.do" />" >접속기록</a></div>
  </c:if>
</div>

<table class="table_style thd_v_m" summary="<c:out value="${boardinfoVO.boardTitle}" /> <%= JnitboardController.isLanguage("의 게시글 목록으로",lang) %><c:forEach var="k" items="${sIdx}" varStatus="status"><c:out value="${lbl[k]}" /><c:out value="${status.last ? '' : ','}" /></c:forEach> <%= JnitboardController.isLanguage("로 구성되어 있습니다.",lang) %>">
	<caption><c:out value="${boardinfoVO.boardTitle}" /></caption>
	<colgroup>
    <col width="5%" />
    <col width="12%" />
    <col width="10%" />
    <col width="*" />
    <col width="10%" />
    <col width="15%" />
    <c:if test="${isAdmin == true}"><col width="10%" /></c:if>
    <col width="10%" />
  </colgroup>
  	 
	<thead>
	    <tr>
	      <th>No.</th>
	      <th>문의 구분</th>
	      <th>문의 유형</th>
	      <th>문의 제목</th>
	      <th>작성자</th>
	      <th>등록일</th>
	      <c:if test="${isAdmin == true}"><th>담당자</th></c:if>
	      <th>상태</th>
	    </tr>
	  </thead>
	<tbody>
	<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr>
			<td><c:out value="${startNum-status.index}" /></td>
			<td><c:out value="${result.ext01}" /></td>
			<td><c:out value="${result.ext02}" /></td>
			<td class="AlignLeft">
				<c:if test="${result.mbrId == null || result.mbrId == ''}"><!-- 비회원글 -->
					<a class="btn_a" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=view&cntId=${result.id}&category=${jtag:encodeUrl(result.category)}&pageIdx=${param.pageIdx}&searchext01=${param.searchext01 }&searchext02=${param.searchext02 }&searchext03=${param.searchext03 }&searchext04=${param.searchext04 }&searchext18=${param.searchext18 }&searchext19=${param.searchext19 }&createdStartDate=${param.createdStartDate }&createdEndDate=${param.createdEndDate }&pageIdx=${param.pageIdx}" />">
						<c:if test="${result.isdel == 1 }">(삭제글) </c:if><c:out value="${result.title}" />
					</a>
				</c:if>
				<c:if test="${result.mbrId != null && result.mbrId != ''}"><!-- 회원글 -->
					<a class="btn_a" href="<c:out value="?boardId=${boardinfoVO.boardId}&mode=view&cntId=${result.id}&category=${jtag:encodeUrl(result.category)}&pageIdx=${param.pageIdx}&searchext01=${param.searchext01 }&searchext02=${param.searchext02 }&searchext03=${param.searchext03 }&searchext04=${param.searchext04 }&searchext18=${param.searchext18 }&searchext19=${param.searchext19 }&createdStartDate=${param.createdStartDate }&createdEndDate=${param.createdEndDate }&pageIdx=${param.pageIdx}" />">
						<c:if test="${result.isdel == 1 }">(삭제글) </c:if><c:out value="${result.title}" />
					</a>
				</c:if>
			</td>
			<td><c:out value="${result.writer}" /></td>
			<td>
				<fmt:parseDate var="dateFmt" value="${result.created}" pattern="yyyy-MM-dd HH:mm:ss" />
				<fmt:formatDate value="${dateFmt }" pattern="yyyy-MM-dd HH:mm" />
			</td>
			<c:if test="${isAdmin == true}"><td><c:out value="${result.ext03}" /></td></c:if>
			<td class="td_bg">
				<span class="${result.ext04 == '신청' ? 'txt_c_bk' : 'txt_c_bl'}"><b><c:out value="${result.ext04 }" /></b></span>
			</td>
		</tr>
	</c:forEach>		
	<c:if test="${empty resultList}">
		<tr>
			<td colspan="8" class="nodata">					
				<%= JnitboardController.isLanguage("조회된 게시물이 없습니다.",lang) %>
			</td>
		</tr>
	</c:if>
	</tbody>
</table>

<div class="con_b_bt AlignCenter">
    <div class="paging">
	<ui:pagination paginationInfo = "${paginationInfo}"   type="jnitDefault"   jsFunction="jnitBoardPage"   />
	 <input type="hidden" name="pageIdx" id="pageIdx"  value="<c:out value="${param.pageIdx}"/>" />
	</div>
</div>

</form:form>