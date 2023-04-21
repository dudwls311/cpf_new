<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>" />
<link rel="stylesheet" href="/resources/js/exts/com/jquery.loading.css" />
<link rel="stylesheet" href="/resources/css/select2.css" />

<link type="text/css" href="/support/common/css/font-awesome.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_base.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_print.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_common.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_main.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_content.css" media='all' rel='stylesheet' />
<link type="text/css" href="/support/common/css/Jnit_sub.css" media='all' rel='stylesheet' />

<script src="/resources/js/jquery.min.js"></script>
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
<c:set var="adminListDateFormat" value="yyyy-MM-dd HH:mm:ss" />
<c:set var="dateTimeFormat" value="yyyy-MM-dd HH:mm" />