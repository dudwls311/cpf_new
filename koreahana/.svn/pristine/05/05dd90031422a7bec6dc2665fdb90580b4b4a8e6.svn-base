<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<ul class="tab_st01 MAB10">
	<li class="on"><a href="#" onclick="ComFns.openMySgn();return false;">서명 선택</a></li>
	<li><a href="#" onclick="fnSgnWrite();return false;">서명 직접 그리기</a></li>
</ul>

<div class="list_type_3 sign_c_list">
	<c:if test="${fn:length(sgnList) < 1 }">
		<div class="box_w_gray AlignCenter">
			등록된 서명이 없습니다. <br /><br />
			자주 사용하는 문서를 문서함에 저장하여 이용하세요.<br />
			마이페이지 &gt; 나의 문서관리 &gt; <a class="txt_st_unb" href="<c:url value="/support/mypage/my_document/sign/" />" target="_blank" >서명관리</a> 메뉴에서 <br />
			문서를 등록할 수 있습니다.
		</div>
	</c:if>
	<c:if test="${fn:length(sgnList) > 0 }">
		<ul>
			<c:forEach var="sgn" items="${sgnList }" varStatus="sgnStatus">
				<li>
					<input type="radio" name="sgnRadio" id="<c:out value="sgnRadio${sgnStatus.count }" />" class="comment"
							data-url="<c:url value="/user/exts/koreahana/sgn/index.do?ksMode=sgnView&enc=" />"
							data-param="<c:out value="${jtag:sprtFileViewEncode(sgn.atchFileSn, '')}" />"
							data-fsn="<c:out value="${sgn.atchFileSn }" />"
							data-sgntnm="<c:out value="${sgn.sgntNm }" />"
							data-sgnid="<c:out value="${sgnId}" />" />
							
					<label class="sign_c_btn"  onclick="$('#<c:out value="sgnRadio${sgnStatus.count }" />').trigger('click');" >
						<p class="sign"><img src="<c:url value="/user/exts/koreahana/sgn/index.do?ksMode=sgnView&enc=${jtag:sprtFileViewEncode(sgn.atchFileSn, '')}" />" alt="<c:out value="${sgn.sgntNm } 이미지" />" /></p>
						<p class="name"><c:out value="${sgn.sgntNm }" /></p>
					</label>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</div>