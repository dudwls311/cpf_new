<%
/**
 *@version 3.2.0.1
 **/
%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/jnit/board/header.jsp" %>
<%@ page import="jnit.board.BoardSession" %>
<%
	BoardSession.initBoardSession();		//게시판 세션 초기화
	BoardSession.setBoardSession();			//게시판 세션 생성 ( info : boardId, useSkeleton, fixedCategory, customSkin, customCss jsp:param 데이터를 담는다.)
%>

<script>
$(document).ready(function(){
	var ext01Value = $("#ext01Value").val();
	var ext02Value = $("#ext02Value").val();
	
	$("#ext01").val(ext01Value);
	fnExt01Change(ext02Value);
	
	$("#ext01").on('change', function(){
		fnExt01Change();
	});
});

function fnExt01Change(val){
	var ext01 = $("#ext01").val();
	
	$("#ext02").find('option').remove();
	
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
		
	}
	
	if(ext01Type != ''){
		var opt = '';
		var isSelected = '';
		$(ext02Arr).each(function(fnIdx, fnObj){
			isSelected = (fnObj == val ? 'selected' : '');
			opt += '<option value="'+fnObj+'" '+isSelected+'>'+ext01Type+'.'+(fnIdx+1)+' '+fnObj+'</option>';
		});
		$("#ext02").show();
		$("#ext02").append(opt);
	}else{
		$("#ext02").hide();
	}
}

function fnUserInfoPop(mbrId){
	var url = '/exts/com/mbr/index.do?searchCondition=&searchKeyword=&pageIndex=1&qnaView=Y&commMode=view&mbrId='+mbrId;
	var name = '사용자 정보 확인';
	
	var width = 1000;
	var heigth = 600;
	var popupX = (document.body.offsetWidth / 2) - (width / 2);
	var popupY = (window.screen.height / 2) - (heigth / 2);
	var options = 'status=no,scrollbars=no,menubar=no,toolbar=no,location=no,height='+heigth+',width='+width+',left='+popupX+',top='+popupY;
	window.open(url, name, options);
}
</script>

<%--
<%//write.jsp 참고%>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="?">
--%>
<c:url value="/board/board.do" var="actionUrl"/>
<form:form commandName="jnitboarddbVO" name="bbsForm" id="bbsForm" method="post" enctype="multipart/form-data" action="${actionUrl }">
<input type="hidden" id="retUrl" name="retUrl" value="${retUrl }" />

<input type="hidden" name="mode" value="proc" />
<input type="hidden" name="proc" value="edit" />
<input type="hidden" name="boardId" value="<c:out value="${boardinfoVO.boardId}"/>" />
<input type="hidden" name="cntId" value="<c:out value="${result.id}"/>" />
<input type="hidden" name="ext20" value="<c:out value="${result.ext20}"/>" />
<input type="hidden" name="pid" value="<c:out value="${param.pid}"/>" />
<c:if test="${boardinfoVO.useCategory == '1' && not empty fixedCategory}">
<input type="hidden" name="category" value="${fixedCategory}" />
</c:if>
<c:if test="${param.pid == null || param.pid == ''}">
<div id="writeFrom" style="display:<c:out value="${param.writeMode eq 'success' ? 'none' : ''}"/>;"> 
	<div class="box_w_suc box_s_add">
	  <h3 class="suc_tit">1:1문의 작성하기</h3>
	  <p class="AlignCenter MAB30">북한이탈주민 지원사업에 관련하여 궁금한 점이 있으시면 문의해 주세요</p>
	  <div class="AlignLeft">
	
	    <div class="MAB20">
	      <label for="B09">문의 제목</label>
	      <input type="text" name="title" id="title" value="<c:out value="${result.title }"/>" class="st_input input_long" />
	    </div>
	    
	    <input type="hidden" id="ext01Value" value="<c:out value="${result.ext01 }" />" />
	    <input type="hidden" id="ext02Value" value="<c:out value="${result.ext02 }" />" />
	    <div class="MAB20">
	      <label for="ext01">문의 유형</label><br />
			<select id="ext01" name="ext01" class="st_select" required="required">
				<option value="">선택</option>
			    <option value="지원사업신청">1. 지원사업신청</option>
			    <option value="시스템사용">2. 시스템사용</option>
			</select>
			<select id="ext02" name="ext02" class="st_select" required="required" style="display: none;">
			</select>
	    </div>
	    
	    <div class="MAB20">
	      <label for="ext03">담당자</label><br />
			<select id="ext03" name="ext03" class="st_select">
				<option value="">선택</option>
			    <option value="시스템" ${result.ext03 == '시스템' ? 'selected' : '' }>시스템</option>
			    <option value="남북하나재단" ${result.ext03 == '남북하나재단' ? 'selected' : '' }>남북하나재단</option>
			</select>
	    </div>
	    
	    <div class="MAB20">
	      <label for="ext04">상태</label><br />
			<select id="ext04" name="ext04" class="st_select">
				<option value="">선택</option>
			    <option value="신청" ${result.ext04 == '신청' ? 'selected' : '' }>신청</option>
			    <option value="접수" ${result.ext04 == '접수' ? 'selected' : '' }>접수</option>
			    <option value="답변완료" ${result.ext04 == '답변완료' ? 'selected' : '' }>답변완료</option>
			    <option value="처리불가" ${result.ext04 == '처리불가' ? 'selected' : '' }>처리불가</option>
			</select>
	    </div>
	    
	    <c:if test="${not empty result.mbrId }">
		    <div class="MAB20">
		      <label for="writer">작성자</label><br />
		      	<c:choose>
		      		<c:when test="${isAdmin == true }"><span onclick="fnUserInfoPop('<c:out value="${result.mbrId }" />');return false;"><c:out value="${result.writer}" /></span></c:when>
		      		<c:otherwise><span><c:out value="${result.writer}" /></span></c:otherwise>
		      	</c:choose>
		    </div>
	    </c:if>
	    
	    <div class="MAB20">
	      <label for="B09">문의 내용</label> 
	      <textarea class="st_textarea" name="content" id="content" rows="10"><c:out value="${result.content }" /></textarea>
	    </div>
	    
	    <div class="MAB20">
	      <label for="searchext05">답변</label> 
	      <textarea class="st_textarea" name="ext05" id="ext05" rows="10"><c:out value="${result.ext05 }" /></textarea>
	    </div>
	    
	    <p class="AlignCenter ">문의에 대한 답변은 마이페이지 &gt; <span class="txt_st_unb">1:1문의 이력</span> 메뉴에서 확인 할 수 있습니다.</p>
	
	  </div>
	</div>
	<div class="box_w_suc PADDING20 AlignLeft" style="background:#fff;">
	  <ul class="ul_st02">
	    <li><b>고객센터</b> 평일 09:00~18:00 (점심시간 : 12:00~13:00)</li>
    	<li><b>전화번호</b> <a href="https://www.koreahana.or.kr/home/kor/foundationIntro/organization/department/index.do?ptSignature=QnrvtOekxiPklgsn74dfsf2nw91hIc5NDmxXTxJshCU%3D&menuPos=74" target="_blank">사업별 담당자 찾기(링크)</a></li>
    	<li><b>안내데스크</b> 02-3215-0000</li>
	  </ul>
	
	</div>
	<div class="btn_g_btm">
	  <button id="inquiry_write_submt" class="btn_st btn_c_bk btn_s_big btn_s_long" href="#none;">문의내용 등록하기</button>
	</div>
</div>
</c:if>

<c:if test="${param.pid != null && param.pid != ''}"> 
<div id="replyWriteFrom"> 
	<div class="box_w_suc box_s_add">
	  <h3 class="suc_tit">1:1문의 답변작성하기</h3>
	  <div class="AlignLeft">
	    	<input type="hidden" name="title" value="문의 답변"/>
	    <div class="MAB20">
	      <label for="B09">답변 내용</label> 
	      <textarea class="st_textarea" name="content" id="content"><c:out value="${result.content }" escapeXml="false" /></textarea>
	    </div>
	  </div>
	</div>
	<div class="btn_g_btm">
	  <button class="btn_st btn_c_bk btn_s_big btn_s_long">문의답변 등록하기</button>
	</div>
</div>
</c:if>
<c:if test="${boardinfoVO.useFile == 2}">
<jsp:include page="/board/fileupload/list.do" flush="false">
	<jsp:param name="boardId"					value="${boardinfoVO.boardId}" />
	<jsp:param name="multiple"					value="true" />
	<jsp:param name="dragDrop"					value="true" />
	<jsp:param name="blacklist"					value="${boardinfoVO.fileBlacklist}" />
	<jsp:param name="maxFileCount"				value="${boardinfoVO.fileLimitCount}" />
	<jsp:param name="maxFileSize"				value="${boardinfoVO.fileLimitSize}MB" />
</jsp:include>
</c:if>

<input type="hidden" name="searchCondition" value="<c:out value='${param.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${param.searchKeyword}'/>"/>
<input type="hidden" name="pageIdx" id="pageIdx"  value="<c:out value="${param.pageIdx}"/>" />
<input type="hidden" name="fileuploadList" id="fileuploadList" value=""/>
</form:form>
