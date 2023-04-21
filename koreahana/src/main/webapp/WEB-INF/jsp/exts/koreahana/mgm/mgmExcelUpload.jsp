<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/mgm/mgmExcelUpload.js"></script>
<form id="writeForm" action="${actionUrl }" method="post">
	<input type="hidden" name="kmMode" value="excelUploadActionJson" />
</form>
<form id="validationForm" action="${actionUrl }" method="post">
	<input type="hidden" name="kmMode" value="excelValidationActionJson" />
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

<h4 class="tit">경영개선자금 지급정보 일괄등록</h4>
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
		<a href="#" class="btn_st btn_c_gr" onclick="ComFns.sampleDownload('mgm.xlsx','경영개선자금지원정보샘플.xlsx');return false;">업로드샘플파일 다운로드</a>
	</span>
</div>


<div class="fixed_table" id="uploadTableDiv">
	<table class="table_style">
		<thead>
			<tr>
				<th scope="col">성명</th>
				<th scope="col">생년월일</th>
				<th scope="col">주민등록번호뒷자리</th>
				<th scope="col">하나원기수</th>
				<th scope="col">휴대폰번호</th>
				<th scope="col">상호명</th>
				<th scope="col">업태</th>
				<th scope="col">업태그외</th>
				<th scope="col">업종</th>
				<th scope="col">사업자번호</th>
				<th scope="col">사업개시일</th>
				<th scope="col">주소(사업장)</th>
				<th scope="col">차량</th>
				<th scope="col">주행거리(km)</th>
				<th scope="col">차량연식</th>
				<th scope="col">모집분야</th>
				<th scope="col">지원연도</th>
				<th scope="col">결정금액</th>
				<th scope="col">구매내역</th>
				<th scope="col">구매금액</th>
				<th scope="col">지급금액</th>
				<th scope="col">지급차수</th>
				<th scope="col">비고</th>
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
