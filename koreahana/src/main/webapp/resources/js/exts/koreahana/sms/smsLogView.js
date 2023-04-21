$(document).ready(function(){
	$('#listBtn').on('click',fnList);
});

//리스트
function fnList(){
	$("#listPageForm").submit();
	return false;
}