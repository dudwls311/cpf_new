<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>

<c:if test="${searchVO.tmpSaveYn == 'Y' }">
	<div class="box_w_suc">
		<p class="suc_tit">신청서를 임시저장 하였습니다.</p><br />
		<b class="txt_c_bl">입력하신 신청서는 미제출된 상태입니다. </b><br />
		현재까지 작성하신 내용은 임시 저장되어 있으며<br />
		마이페이지 &gt; <span class="txt_st_unb">지원사업 신청이력</span> 메뉴에서 작성중인 신청서를 확인 하실 수 있습니다. <br />
		신청서를 제출하고 난 이후에는 수정이 불가능 하므로 바르게 <br />
		작성되었는지 다시 한번 확인 하시기 바랍니다.<br /><br />
	</div>
</c:if>
<c:if test="${searchVO.tmpSaveYn != 'Y' }">
	<div class="box_w_suc">
	  <p class="suc_tit">신청서가 제출 완료되었습니다. </p><br />
	  신청결과는 신청자 핸드폰 번호로 안내될 예정이며,<br />
	  마이페이지 &gt; <span class="txt_st_unb">지원사업 신청이력</span> 메뉴에서도 확인하실 수 있습니다.<br /><br />
	</div>
</c:if>

<div class="btn_g_btm AlignCenter">
  <a class="btn_st btn_s_big btn_c_bk btn_s_long" href="<c:out value="${mypageUrl }" />">신청이력(결과) 조회</a>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>