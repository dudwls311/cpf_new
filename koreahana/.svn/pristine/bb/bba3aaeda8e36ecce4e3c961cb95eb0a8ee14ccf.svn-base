<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${isTrustedNetowrk }"><%//내부망으로 접속했을때 juso.go.kr로 주소찾기처리 %>
<script type="text/javascript">
var _jusoCallback;
function fnComAddressFind(callback){
	_jusoCallback = callback;
	var pop = window.open("<c:url value="/user/exts/com/jusoPopup.do" />","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail, roadAddrPart2,engAddr
		, jibunAddr,zipNo, admCd, rnMgtSn, bdMgtSn, detBdNmList
		, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn
		, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	_jusoCallback({'zip':zipNo,'address':roadAddrPart1,'addressDetail':addrDetail});
}
</script>
	</c:when>
	<c:otherwise><%//외부망으로 접속했을때 %>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function fnComAddressFind(callback){
	new daum.Postcode({
        oncomplete: function(data) { //선택시 입력값 세팅
            console.log(data);
    		callback({'zip':data.zonecode,'address':data.roadAddress,'addressDetail':''});
        }
    }).open();
}
</script>
	</c:otherwise>
</c:choose>
