<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/sms/smsLogView.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


					<h4 class="tit">상세 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:30%" />
							<col style="width:*" />
						</colgroup>
						<tr>
							<th scope="row">발신고유번호</th>
							<td>
								<c:out value="${result.clidx}" />
							</td>
						</tr>
						<tr>
							<th scope="row">발신대상번호(미사용)</th>
							<td>
								<c:out value="${result.cltno}" />
							</td>
						</tr>
						<tr>
							<th scope="row">발신구분(M:일반문자/K:알림톡)</th>
							<td>
								<c:out value="${result.gb}" />
							</td>
						</tr>
						<tr>
							<th scope="row">전송구분(S:SMS/L:LMS)</th>
							<td>
								<c:out value="${result.msggb}" />
							</td>
						</tr>
						<tr>
							<th scope="row">발신번호</th>
							<td>
								<c:out value="${result.sendnum}" />
							</td>
						</tr>
						<tr>
							<th scope="row">수신번호</th>
							<td>
								<c:out value="${result.recvnum}" />
							</td>
						</tr>
						<tr>
							<th scope="row">발신요청일시</th>
							<td>
								<c:out value="${result.schddt}" />
							</td>
						</tr>
						<tr>
							<th scope="row">결과코드(903:성공/905:실패)</th>
							<td>
								<c:out value="${result.result}" />
							</td>
						</tr>
						<tr>
							<th scope="row">상태코드(333:완료/334:취소/335:오류)</th>
							<td>
								<c:out value="${result.status}" />
							</td>
						</tr>
						<tr>
							<th scope="row">오류코드(0:성공/이외실패)</th>
							<td>
								<c:out value="${result.errcode}" />
							</td>
						</tr>
						<tr>
							<th scope="row">처리시작일시</th>
							<td>
								<c:out value="${result.sdt}" />
							</td>
						</tr>
						<tr>
							<th scope="row">처리종료일시</th>
							<td>
								<c:out value="${result.edt}" />
							</td>
						</tr>
						<tr>
							<th scope="row">시스템계정</th>
							<td>
								<c:out value="${result.userid}" />
							</td>
						</tr>
						<tr>
							<th scope="row">시스템하위코드</th>
							<td>
								<c:out value="${result.subcode}" />
							</td>
						</tr>
					</table>
					
				<div class="btn_g_btm">
					<button class="btn_st btn_c_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
				</div>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
