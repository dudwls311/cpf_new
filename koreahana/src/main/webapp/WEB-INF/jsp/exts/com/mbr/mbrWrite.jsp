<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/com/mbr/mbrWrite.js"></script>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).SUP.getCode()" var="enumMbrTypeSUP" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).FOU.getCode()" var="enumMbrTypeFOU" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).CEN.getCode()" var="enumMbrTypeCEN" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NTK.getCode()" var="enumMbrTypeNTK" /> 
<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).NOR.getCode()" var="enumMbrTypeNOR" /> 

<spring:eval expression="T(exts.com.enums.EnumMbrTypeCd).values()" var="enumMbrTypes" /> 
<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="commMode" value="view" />
	<input type="hidden" name="mbrId" value="<c:out value="${result.mbrId }" />" />
</form>

<input type="hidden" id="enumMbrTypeFOU" value="${enumMbrTypeFOU }" />
<input type="hidden" id="enumMbrTypeCEN" value="${enumMbrTypeCEN }" />

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="commMode" value="writeActionJson" />
	<input type="hidden" id="mbrId" name="mbrId" value="<c:out value="${result.mbrId }" />" />

					<h4 class="tit">정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row"><label class="MAL0" for="typeId">권한구분</label> <span class="imp_st">*</span></th>
								<td>
								<%-- <c:choose>
									<c:when test="${!empty result.mbrLogin }">
										<c:forEach items="${enumMbrTypes }" var="mbrType"><c:if test="${result.typeId == mbrType.code }"><c:out value="${mbrType.name}" /></c:if></c:forEach>
										<input type="hidden" id="typeId" name="typeId" value="<c:out value="${result.typeId }" />" />
									</c:when>
									<c:otherwise> --%>
								<c:forEach items="${enumMbrTypes }" var="mbrType" varStatus="status"><c:if test="${enumMbrTypeSUP == mbrType.code||enumMbrTypeFOU == mbrType.code||enumMbrTypeCEN == mbrType.code }">
									<c:if test="${isAdmin || loginVO.typeId == mbrType.code }">
										<input type="radio" name="typeId" value="${mbrType.code }" id="typeId${status.index }"${result.typeId == mbrType.code?' checked="checked"':'' } class="st_radio">
										<label for="typeId${status.index }"><c:out value="${mbrType.name}" /></label>
									</c:if>
								</c:if></c:forEach>
									<%-- </c:otherwise>
								</c:choose> --%>
									
								</td>
							</tr>
							<tr id="orgIdTr"${result.typeId != enumMbrTypeFOU && result.typeId != enumMbrTypeCEN?' style="display:none"':'' }>
								<th scope="row"><label class="MAL0" for="orgId">소속</label> <span class="imp_st">*</span></th>
								<td>
									<select id="orgId" name="orgId" class="st_select">
											<option value="">선택</option>
									<c:forEach items="${orgList }" var="org">
										<c:if test="${isAdmin || loginVO.orgId == org.orgId }">
											<option value="${org.orgId }" ${result.orgId == org.orgId ? 'selected':'' }><c:out value="${org.orgNm}" /></option>
										</c:if>
									</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrNm">이름</label> <span class="imp_st">*</span></th>
								<td>
									<input type="text" name="mbrNm" id="mbrNm" value="<c:out value="${result.mbrNm}" />" class="st_input " placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrLogin">아이디</label> <span class="imp_st">*</span></th>
								<td>
								<c:choose>
									<c:when test="${!empty result.mbrLogin }">
										<input type="hidden" id="mbrLogin" name="mbrLogin" value="<c:out value="${result.mbrLogin }" />" />
										<c:out value="${result.mbrLogin }" />
									</c:when>
									<c:otherwise>
										<input type="hidden" id="chkId" value="" />    
										<div class="clear_box">                          
											<input type="text" name="mbrLogin" id="mbrLogin" value="<c:out value="${result.mbrLogin}" />" class="st_input " placeholder="">
											<a class="btn_st" onclick="fnIdCheck();return false;" >아이디 중복확인</a>
										</div>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="passwd">비밀번호</label> <c:if test="${empty result }"><span class="imp_st">*</span></c:if></th>
								<td>
									<input type="text" name="passwd" id="passwd" value="" class="st_input " placeholder="">
								</td>
							</tr>
					<c:if test="${result.typeId == enumMbrTypeNTK || result.typeId == enumMbrTypeNOR}">
							<tr>
								<th scope="row"><label class="MAL0" for="genderCd">성별</label> </th>
								<td>
									<c:out value="${jtag:getCdNm(genderCdList,result.genderCd)}" />
									<input type="hidden" name="genderCd" id="genderCd" value="<c:out value="${result.genderCd}" />">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="brdtYmd">생년월일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.brdtYmd,'-')}" />
									<input type="hidden" name="brdtYmd" id="brdtYmd" value="<c:out value="${result.brdtYmd}" />">
								</td>
							</tr>
						<c:if test="${result.typeId == enumMbrTypeNTK}">
							<tr>
								<th scope="row"><label class="MAL0" for="ntkrdfUnqNo">북한이탈주민번호</label> </th>
								<td>
									<c:out value="${result.ntkrdfUnqNo}" />
									<input type="hidden" name="ntkrdfUnqNo" id="ntkrdfUnqNo" value="<c:out value="${result.ntkrdfUnqNo}" />">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="entcnyYmd">입국일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />
									<input type="hidden" name="entcnyYmd" id="entcnyYmd" value="<c:out value="${result.entcnyYmd}" />">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="prtdcsYmd">보호결정일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.prtdcsYmd,'-')}" />
									<input type="hidden" name="prtdcsYmd" id="prtdcsYmd" value="<c:out value="${result.prtdcsYmd}" />">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="flnm">하나원 수료일</label> </th>
								<td>
									<c:out value="${jtag:convertDateSplitString(result.hanawonFnshYmd,'-')}" />
									<input type="hidden" name="hanawonFnshYmd" id="hanawonFnshYmd" value="<c:out value="${result.hanawonFnshYmd}" />">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="hanawonTh">하나원기수</label> </th>
								<td>
									<input type="text" name="hanawonTh" id="hanawonTh" value="<c:out value="${result.hanawonTh}" />" class="st_input w95 number_nocomma_style" placeholder=""> 기
								</td>
							</tr>
						</c:if>
							<tr>
								<th scope="row"><label class="MAL0" for="zip">주소</label> </th>
								<td>
									<input type="text" name="zip" id="zip" value="<c:out value="${result.zip}" />" class="st_input " placeholder="">
									<a class="btn_st btn_c_bk" href="#" onclick="fnAddr();return false;">주소 검색</a>
									<input type="text" name="addr" id="addr" value="<c:out value="${result.addr}" />" class="st_input input_long  MAB5  MAT5">
									<input type="text" name="daddr" id="daddr" value="<c:out value="${result.daddr}" />" class="st_input input_long ">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="expireDate">만료일자</label> </th>
								<td>
									<fmt:formatDate var="expireDate" value="${result.expireDate }" pattern="yyyy-MM-dd"/>
									<input type="text" name="expireDate" id="expireDate" value="<c:out value="${jtag:convertDateSplitString(expireDate,'-')}" />" class="st_input i_w95 date_style" placeholder="" >
									<span class="txt_c_bl br">만료일자를 설정할 경우 만료일자 이후로는 계정이 비활성화됩니다.</span>
								</td>
							</tr>
					</c:if>
							<tr>
								<th scope="row"><label class="MAL0" for="mbphno">휴대폰번호</label> </th>
								<td>
									<input type="text" name="mbphno" id="mbphno" value="<c:out value="${result.mbphno}" />" class="st_input" placeholder="" maxlength="13">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="telno">전화번호</label> </th>
								<td>
									<input type="text" name="telno" id="telno" value="<c:out value="${result.telno}" />" class="st_input" placeholder="" maxlength="13">
								</td>
							</tr>
					</table>

					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>

<select id="orgIdFOU" style="display:none">
	<option value="">선택</option>
<c:forEach items="${orgList }" var="org"><c:if test="${(isAdmin || loginVO.orgId == org.orgId) && org.orgRankOdr == 0 }">
	<option value="${org.orgId }" ${result.orgId == org.orgId ? 'selected':'' }><c:out value="${org.orgNm}" /></option>
</c:if></c:forEach>
</select>

<select id="orgIdCEN" style="display:none">
	<option value="">선택</option>
<c:forEach items="${orgList }" var="org"><c:if test="${(isAdmin || loginVO.orgId == org.orgId) && org.orgRankOdr != 0 }">
	<option value="${org.orgId }" ${result.orgId == org.orgId ? 'selected':'' }><c:out value="${org.orgNm}" /></option>
</c:if></c:forEach>
</select>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
