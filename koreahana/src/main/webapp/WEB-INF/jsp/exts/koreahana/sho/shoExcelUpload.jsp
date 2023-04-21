<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sho/shoExcelUpload.js"></script>
<form id="writeForm" action="${actionUrl }" method="post">
	<input type="hidden" name="ksMode" value="excelUploadActionJson" />
</form>
<form id="validationForm" action="${actionUrl }" method="post">
	<input type="hidden" name="ksMode" value="excelValidationActionJson" />
</form>
<!-- step: 활성화class on, 체크완료class check -->
<ul class="step_box">
	<li id="step1Li" class="on">
		<div class="num">1</div>
		<span class="txt">업로드 파일선택</span>
	</li>
	<li id="step2Li">
		<div class="num">2</div>
		<span class="txt">파일가져오기</span>
	</li>
	<li id="step3Li">
		<div class="num">3</div>
		<span class="txt">정합성 검사</span>
	</li>
	<li id="step4Li">
		<div class="num">4</div>
		<span class="txt">업로드 완료</span>
	</li>
</ul>

<h4 class="tit">선정결과 일괄등록</h4>
<div class="box_w_wht">
	<label for="iWWWW">파일 업로드</label>
	<span class="file_uplode" style="display: inline-block;width: 81%;">
		<a class="btn_st" href="#" id="selFileLabel">파일찾기</a>
		<span class="file_name" id="selFileText"></span>
	</span>
	<a href="#" class="btn_st btn_c_gr" id="checkBtn">정합성 검사</a>
</div>



<div class="MAB10">
	<span class="txt_c_re"><b id="msgSpan"></b></span>
	<span class="FloatRight MAB5">
		<a href="#" class="btn_st btn_c_bk" id="initBtn" style="display:none">초기화</a>
		<a href="#" class="btn_st btn_c_bl" id="uploadBtn" style="display:none">업로드</a>
		<a href="#" class="btn_st btn_c_gr" onclick="alert('목록페이지에서 다운받은 파일을 사용해 주세요.');return false;">업로드샘플파일 다운로드</a>
	</span>
</div>


<div class="fixed_table" id="uploadTableDiv">
	<table class="table_style">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">신청번호</th>
				<th scope="col">신청일</th>
				<th scope="col">선정결과</th>
				<th scope="col">서류미비사유</th>
				<th scope="col">지원자유형</th>
				<th scope="col">장학금유형</th>
				<th scope="col">지원대상</th>
				<th scope="col">성별</th>
				<th scope="col">생년월일</th>
				<th scope="col">북한이탈주민 번호</th>
				<th scope="col">입국일</th>
				<th scope="col">보호결정일</th>
				<th scope="col">하나원 수료일</th>
				<th scope="col">하나원기수</th>
				<th scope="col">휴대폰번호</th>
				<th scope="col">주소</th>
			</tr>
		</thead>
		<tbody id="excelUploadTbody">
		</tbody>
	</table>
</div>
<div id="uploadResultDiv" style="display:none">
	<h4 class="tit">경영개선자금 지급정보 일괄등록 결과</h4>
	<table class="table_style table_t_left">
		<tbody>
			<tr>
				<th>성공</th>
				<td><em class="txt_c_bl" id="uploadResultSuccessEm">건</em></td>
			</tr>
			<tr>
				<th>실패</th>
				<td><em class="txt_c_re" id="uploadResultFailEm">건</em>
					<a href="#" onclick="fnShowResult();return false;" class="btn_st btn_c_gy MAL20">업로드 실패사유</a></td>
			</tr>
		</tbody>
	</table>
</div>


<div class="btn_b_g AlignCenter">
    <a href="#" onclick="location.href = actionUrl;return false;" class="btn_st btn_s_big" style="">목록으로</a>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
