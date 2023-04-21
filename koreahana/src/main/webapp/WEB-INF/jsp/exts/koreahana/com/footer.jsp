<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%//팝업레이어 %>
<div class="popup_wrap" id="modalDiv" style="display:none">
	<div class="popup_bg" onclick="ComFns.popup.hide()"></div>
	<div class="popup_box">
		<div class="popup_tit">
			<div class="p_title" id="modalDiv_title"></div>
		</div>
		<div class="popup_con" id="modalDiv_content">
		</div>
	    <div class="pop_b_btn AlignCenter">
	      <a class="btn_st btn_c_gr btn_s_big" href="#" id="modalDiv_confirmBtn">확인</a>
	      <a class="btn_st btn_s_big" href="#" onclick="ComFns.popup.hide();return false;">닫기</a>
	    </div>
	</div>
</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

<%//엑셀 파싱용 폼 %>
<form id="excelUploadForm" method="post" enctype="multipart/form-data" action="<c:url value="/exts/com/parseExcelJson.do" />">
	<input type="file" style="display:none" id="excelFileForParse" name="excelFileForParse" accept=".xls,.xlsx">
</form>
</html>