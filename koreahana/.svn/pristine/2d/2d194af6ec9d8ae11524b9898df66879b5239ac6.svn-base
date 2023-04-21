<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/com/mbr/mbrView.js"></script>

<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).SUP.getCode()" var="enumMbrTypeSUP" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).FOU.getCode()" var="enumMbrTypeFOU" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).CEN.getCode()" var="enumMbrTypeCEN" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NTK.getCode()" var="enumMbrTypeNTK" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NOR.getCode()" var="enumMbrTypeNOR" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).values()" var="enumMbrTypes" /> 

<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="commMode" value="write" />
	<input type="hidden" id="mbrId" name="mbrId" value="<c:out value="${result.mbrId }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


					<h4 class="tit">상세 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row"><label class="MAL0" for="">상태</label> </th>
								<td>
								<c:set var="now" value="<%=new java.util.Date() %>" />
								<c:choose>
									<c:when test="${!empty result.lockDate}">
										로그인 차단 <a class="btn_st" onclick="fnUnLock();return false;" >로그인 차단 해제</a>
									</c:when>
								<c:when test="${!empty result.expireDate && now > result.expireDate }">
									비활성화
								</c:when>
									<c:otherwise>
										활성화
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="typeId">권한구분</label> </th>
								<td>
									<c:forEach items="${enumMbrTypes }" var="mbrType"><c:if test="${result.typeId == mbrType.code }"><c:out value="${mbrType.name}" /></c:if></c:forEach>
								</td>
							</tr>
						<c:if test="${result.typeId == enumMbrTypeFOU || result.typeId == enumMbrTypeCEN }">
							<tr>
								<th scope="row"><label class="MAL0" for="mbrNm">소속</label> </th>
								<td>
									<c:forEach items="${orgList }" var="org"><c:if test="${result.orgId == org.orgId }"><c:out value="${org.orgNm}" /></c:if></c:forEach>
								</td>
							</tr>
						</c:if>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrNm">이름</label> </th>
								<td>
									<c:out value="${result.mbrNm}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrLogin">아이디</label> </th>
								<td>
									<c:out value="${result.mbrLogin }" />
								</td>
							</tr>
					<c:if test="${result.typeId == enumMbrTypeNTK || result.typeId == enumMbrTypeNOR}">
							<tr>
								<th scope="row"><label class="MAL0" for="genderCd">성별</label> </th>
								<td>
									<c:out value="${jtag:getCdNm(genderCdList,result.genderCd)}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />
								</td>
							</tr>
						<c:if test="${result.typeId == enumMbrTypeNTK}">
							<tr>
								<th scope="row"><label class="MAL0" for="flnm">북한이탈주민번호</label> </th>
								<td>
									<c:out value="${result.ntkrdfUnqNo}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="flnm">입국일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="flnm">보호결정일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.prtdcsYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="flnm">하나원 수료일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.hanawonFnshYmd,'-')}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="hanawonTh">하나원기수</label> </th>
								<td>
									<c:out value="${result.hanawonTh}" /> 기
								</td>
							</tr>
						</c:if>
							<tr>
								<th scope="row"><label class="MAL0" for="zip">주소</label> </th>
								<td>
									<c:out value="(${result.zip}) ${result.addr} ${result.daddr}" />
								</td>
							</tr>
					</c:if>
							<tr>
								<th scope="row"><label class="MAL0" for="mbphno">휴대폰번호</label> </th>
								<td>
									<c:out value="${result.mbphno}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="telno">전화번호</label> </th>
								<td>
									<c:out value="${result.telno}" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="expireDate">만료일자</label> </th>
								<td>
									<fmt:formatDate var="expireDate" value="${result.expireDate }" pattern="yyyy-MM-dd"/>
									<c:out value="${!empty expireDate?jtag:convertDateSplitString(expireDate,'-'):'만료일 없음'}" />
								</td>
							</tr>
					</table>

<div class="btn_g_btm">
		<button class="btn_st btn_c_big btn_c_or" type="button" id="modifyBtn"><spring:message code="com.btn.modify" /></button>
		<button class="btn_st btn_c_big" type="button" id="listBtn"><spring:message code="com.btn.list" /></button>
		<c:if test="${isAdmin == true }"><button class="btn_st btn_c_re" type="button" id="deleteBtn"><spring:message code="com.btn.delete" /></button></c:if>
</div>		
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
