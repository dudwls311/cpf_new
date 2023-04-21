<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript" src="<c:url value="/resources/js/signature_pad.umd.min.js" />"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/sgn/sgnWrite.js"></script>

<form id="sgnWriteForm" action="<c:url value="/user/exts/koreahana/sgn/index.do" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ksMode" value="writeActionJson" />
	<input type="hidden" id="signDataUrl" name="signDataUrl" value="" />
	<input type="hidden" id="atchFileSn" name="atchFileSn" value="" />
	<input type="hidden" id="writeType" value="file" />
	
	<ul class="tab_st01 MAB10">
		<li><a href="#" onclick="fnWrite();return false;">서명 직접 그리기</a></li>
		<li class="on"><a href="#" onclick="fnWriteFile();return false;">서명파일 업로드</a></li>
	</ul>

	<div id="signFileDiv" class="sign_place"></div>
	
	<ul class="ul_st02">
		<li class="MAB10"><b>서명 이름</b> <input type="text" class="st_input input_long" style="width:180px;" id="sgntNm" name="sgntNm" value="" /></li>
		<li class="MAB10"><b>기본 서명</b> 
			<input type="checkbox" id="sgntFavoYn" name="sgntFavoYn" value="Y" class="st_check" />
			<label for="sgntFavoYn">기본 서명으로 설정</label>
		</li>
	</ul>
</form>

<form id="writeFileForm" action="<c:url value="/user/exts/koreahana/sgn/index.do" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ksMode" value="writeFileActionJson" />
	<input type="file" id="sgnFile" name="sgnFile" style="display: none;" accept=".png">
</form>

<form id="signFileForm" style="display: none;">
	<button type="button" class="sign_draw_btn" id="sgnFileTrg" onclick="return false;">
		서명 이미지 파일을 클릭해서 업로드하세요.<br />
		(5MB이하, PNG, GIF파일만 업로드 가능합니다.)
	</button>
</form>
<form id="signImgForm" style="display: none;">
	<div class="sign_place">
		<p class="sign_draw_img">
			<img src="@imgSrc@" alt="@imgAlt@">
		</p>
		<a class="btn_st btn_s_sml btn_reset" href="#" onclick="fnSetFileForm();return false;">초기화</a>
	</div>
</form>