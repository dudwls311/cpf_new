<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>" />
<link rel="stylesheet" href="/resources/js/exts/com/jquery.loading.css" />
<link rel="stylesheet" href="/resources/css/select2.css" />


<script src="/resources/js/jquery.plugins/jquery.ui.latest.custom.min.js"></script>
<script src="/resources/js/jquery.plugins/jquery.ui.datepicker-ko.js"></script>
<script src="/resources/js/jquery.plugins/jquery.ui.timepicker.addon.js"></script>
<script src="/resources/js/exts/com/ComFns.js"></script>
<script src="/resources/js/exts/com/jquery.form.js"></script>
<script src="/resources/js/exts/com/ComAjaxForm.js"></script>
<script src="/resources/js/exts/com/jquery.mask.min.js"></script>
<script src="/resources/js/exts/com/jquery.number.min.js"></script>
<script src="/resources/js/exts/com/jquery.loading.js"></script>
<script src="/resources/js/select2.min.js" ></script>

<script type="text/javascript">
ComFns.contextUrl = '<c:url value="/" />';

var Msg = Msg || {};
Msg.com = {
		confirmDelete:'<spring:message code="com.msg.confirmDelete" />',
		confirmFileDelete:'<spring:message code="com.msg.confirmFileDelete" />',
		confirmSave:'<spring:message code="com.msg.confirmSave" />',
}
</script>
<c:set var="dateFormat" value="yyyy-MM-dd" />
<c:set var="dateTimeFormat" value="yyyy-MM-dd HH:mm" />

<c:url var="mypageUrl" value="/support/mypage/sup_history/0001/" />		<%//마이페이지 지원사업신청이력 URL %>
<c:url var="adtUrl" value="/support/su_sub/supadd/list/" />				<%//가산금 URL %>