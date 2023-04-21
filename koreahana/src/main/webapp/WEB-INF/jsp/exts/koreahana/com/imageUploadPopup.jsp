<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript">

$(document).ready(function(){

	$('#writeFileForm').ajaxForm({
		success : function(data){
			console.log(data);
			if(data.isSuccess){
				tinymce.activeEditor.execCommand("mceInsertContent",'false','<img src="/user/exts/koreahana/com/imageView.do?enc=' + data.msg + '" alt="이미지" />');
				ComFns.popup.hide();
			}else{
				alert(data.msg);
			}
		},
		error: function(error){
			console.log(error);
		}
	});
	
	$("#imgFile").on('change', function(){
		$("#writeFileForm").submit();
	});
	
	$("#imgFileTrg").on('click', function(){
	    $("#imgFile").trigger('click');
	    return false;
	});
});
</script>
<form id="writeFileForm" action="<c:url value="/exts/koreahana/com/imageUploadPopupAction.do" />" method="post" enctype="multipart/form-data">
	<input type="file" id="imgFile" name="imgFile" style="display: none;" accept="image/gif, image/jpeg, image/jpg, image/png, image/bmp">
</form>

<form id="writeForm" action="<c:url value="/exts/koreahana/com/imageUploadPopupAction.do" />" method="post" enctype="multipart/form-data">
	<button type="button" class="sign_draw_btn" id="imgFileTrg" onclick="return false;">
		이미지 파일을 클릭해서 업로드하세요.<br />
		(5MB이하, 이미지파일만 업로드 가능합니다.)
	</button>
</form>