<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript" src="/resources/js/signature_pad.umd.min.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/sgn/sgnWrite.js?v=202302140001"></script>

<form id="sgnWriteForm" action="<c:url value="/user/exts/koreahana/sgn/index.do" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ksMode" value="writeActionJson" />
	<input type="hidden" id="atchFileSn" name="atchFileSn" value="" />
	<input type="hidden" id="signDataUrl" name="signDataUrl" value="" />
		
	<ul class="tab_st01 MAB10">
		
		<c:if test="${param.sprtSgnWirteYn == 'Y' }">
			<li><a href="#" onclick="ComFns.openMySgn();return false;">서명 선택</a></li>
			<li class="on"><a href="#" onclick="fnSgnWrite();return false;">서명 직접 그리기</a></li>
		</c:if>
		<c:if test="${param.sprtSgnWirteYn != 'Y' }">
			<li class="on"><a href="#" onclick="fnWrite();return false;">서명 직접 그리기</a></li>
			<li><a href="#" onclick="fnWriteFile();return false;">서명파일 업로드</a></li>
		</c:if>
	</ul>

	<div id="signature-pad" class="sign_place m-signature-pad">
		<div class="sign_draw m-signature-pad--body">
			<canvas id="sgnCanvas"></canvas>
			<span id="sgnInfoSpan">여기에 서명을 그려주세요.</span>
		</div>
		<a class="btn_st btn_s_sml btn_reset" href="#" onclick="fnSignClear();return false;">초기화</a>
	</div>
      
	<ul class="ul_st02">
		<li class="MAB10"><b>서명 이름</b> <input type="text" class="st_input input_long" style="width:180px;" id="sgntNm" name="sgntNm" value="" /></li>
		<li class="MAB10"><b>기본 서명</b> 
			<input type="checkbox" id="sgntFavoYn" name="sgntFavoYn" value="Y" class="st_check" />
			<label for="sgntFavoYn">기본 서명으로 설정</label>
		</li>
	</ul>
</form>
