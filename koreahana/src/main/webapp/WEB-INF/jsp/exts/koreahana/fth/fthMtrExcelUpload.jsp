<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthMtrExcelUpload.js"></script>
<form id="writeForm" action="${actionUrl }" method="post">
	<input type="hidden" name="kfmMode" value="excelUploadActionJson" />
</form>
<form id="validationForm" action="${actionUrl }" method="post">
	<input type="hidden" name="kfmMode" value="excelValidationActionJson" />
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

<h4 class="tit">미래행복통장 만기해지 일괄등록</h4>
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
		<a href="#" class="btn_st btn_c_gr" onclick="ComFns.sampleDownload('fthMtr.xlsx','미래행복통장만기해지샘플.xlsx');return false;">업로드샘플파일 다운로드</a>
	</span>
</div>


<div class="fixed_table" id="uploadTableDiv">
	<table class="table_style">
		<thead>
			<tr>
				<th scope="col">접수일자</th>
				<th scope="col">해지일자</th>
				<th scope="col">성명</th>
				<th scope="col">주민번호</th>
				<th scope="col">연락처</th>
				<th scope="col">시도</th>
				<th scope="col">군구</th>
				<th scope="col">관할하나센터</th>
				<th scope="col">통장 가입일</th>
				<th scope="col">사용처</th>
				<th scope="col">본인적립금(총액기준, 원)</th>
				<th scope="col">재단적립금(지금액기준, 원)</th>
				<th scope="col">만기(개월)</th>
				<th scope="col">금융교육 수강일</th>
				<th scope="col">본인적립금 계좌번호</th>
				<th scope="col">정부지원금 계좌번호</th>
				<th scope="col">비고</th>
			</tr>
		</thead>
		<tbody id="excelUploadTbody">
		</tbody>
	</table>
</div>
<div id="uploadResultDiv" style="display:none">
	<h4 class="tit">미래행복통장 만기해지 일괄등록 결과</h4>
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
