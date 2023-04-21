<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="text/javascript">
//리스트
function popup_fnStaffSearchList(p){
	$('#staffSearchPopupForm [name="pageindex"]').val(p);
	ComFns.popup.loadContent(ComFns.getContextUrl() + 'exts/koreahana/com/staffSearchPopupAjax.do', $('#staffSearchPopupForm').serialize() );
	return false;
}
//선택
function popup_fnStaffSearchSelect(mbrId){
	var _funcNm = $('#staffSearchPopupForm [name="callback"]').val();	
	
	if(typeof(window[_funcNm]) == "function"){
	 	var execFunc = (new Function("return " + _funcNm))();
		var _obj = $('#popup_' + mbrId);
		var _ret = {'nm':_obj.data('nm'),'mbrId':mbrId};
	 	execFunc(_ret);
	 }else{
		 alert('콜백함수 없음.');
	 }
}
</script>
<form id="staffSearchPopupForm" action="?" onsubmit="return popup_fnStaffSearchList('1');">
	<div class="search_field align_right">
		<div class="option_box">
			<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
			<input type="hidden" name="callback" value="<c:out value="${param.callback }" />" />
			<select name="searchCondition">
				<option value="9"${searchVO.searchCondition == '9'?' selected':'' }>아이디</option>
				<option value="10"${searchVO.searchCondition == '10'?' selected':'' }>이름</option>
				<option value="12"${searchVO.searchCondition == '12'?' selected':'' }>부서</option>
			</select>
			<input type="text" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="text" placeholder="검색어를 입력하세요" style="width:274px;" />
			<button class="btn_bggreen_29" type="submit">검색</button>
		</div>
	</div>
</form>
<table class="board_list mgt5">
	<thead>
		<tr>
			<th scope="col">부서</th>
			<th scope="col">아이디</th>
			<th scope="col">이름</th>
			<th scope="col">선택</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr id="popup_<c:out value="${result.mbrId}" />"
			data-nm="<c:out value="${result.mbrNm}" />"
		>
			<td><c:out value="${result.orgNm}" /></td>
			<td><c:out value="${result.mbrLogin}" /></td>
			<td><c:out value="${result.mbrNm}" /></td>
			<td><button onclick="popup_fnStaffSearchSelect('${result.mbrId}');return false;">선택</button> </td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<div class="paging">
	<ui:pagination paginationInfo="${paginationInfo}"   type="image"   jsFunction="fnOpenMyDocBox"   />
</div>
