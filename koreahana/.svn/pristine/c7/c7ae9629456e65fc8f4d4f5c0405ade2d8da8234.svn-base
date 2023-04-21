<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spf/spfPrcWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" name="testRsltCd" value="<c:out value="${searchVO.testRsltCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" name="testRsltCd" value="<c:out value="${searchVO.testRsltCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kspMode" value="view" />
	<input type="hidden" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kspMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoViewForm.jsp" %>
		</tbody>
	</table>
	
	<h4 class="tit">신청자 인적사항</h4>
	<table class="table_style table_t_left thd_v_m">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>사진</th>
				<td>
					<c:choose>
						<c:when test="${empty photoFileEnc }">
							<c:url var="photoFileUrl" value="/support/img/content/p_default.jpg" />
						</c:when>
						<c:otherwise>
							<c:url var="photoFileUrl" value="/exts/koreahana/spr/imgView.do?enc=${photoFileEnc }" />
						</c:otherwise>
					</c:choose>
					<img src="<c:out value="${photoFileUrl }" />" alt="기본 이미지" class="img_profil" id="imgArea" />
				</td>
			</tr>
			<c:if test="${enumBizQlf == pbaVO.bizSeCd }">
				<tr>
					<th>자격증 수령지</th>
					<td><c:out value="(${result.crtfctRcvZip}) ${result.crtfctRcvAddr} ${result.crtfctRcvDaddr}" /></td>
				</tr>
			</c:if>
			<tr>
				<th>소속</th>
				<td><c:out value="${result.ordpNm }" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><c:out value="${result.eml }" /></td>
			</tr>
			<tr>
				<th>최종학력</th>
				<td><c:out value="${jtag:getCdNm(aplcntLastAcbgCdList, result.lastAcbgCd) }" /><c:out value="${result.lastAcbgEtc }" /></td>
			</tr>
			<tr>
				<th>종사기관 유형</th>
				<td><c:out value="${jtag:getCdNm(ocptInstTypeCdList, result.ocptInstTypeCd) }" /><c:out value="${result.ocptInstTypeEtc }" /></td>
			</tr>
			<c:if test="${enumBizQlf != result.bizSeCd }">
				<tr>
					<th>북한이탈주민 정착 지원 실무 경력</th>
					<td><c:out value="${fn:replace(result.ptexp, lf, '<br />')}" escapeXml="false" /></td>
				</tr>
				<tr>
					<th>신청 동기 및  기대 효과</th>
					<td><c:out value="${fn:replace(result.aplyMtv, lf, '<br />')}" escapeXml="false" /></td>
				</tr>
			</c:if>
			<c:if test="${enumBizInt == pbaVO.bizSeCd || enumBizHig == pbaVO.bizSeCd || enumBizPra == pbaVO.bizSeCd || enumBizQlf == pbaVO.bizSeCd }">
				<c:choose>
					<c:when test="${enumBizInt == pbaVO.bizSeCd }"><c:set var="eduFnshName" value="초급교육 수료일" /></c:when>
					<c:when test="${enumBizHig == pbaVO.bizSeCd }"><c:set var="eduFnshName" value="중급교육 수료일" /></c:when>
					<c:when test="${enumBizPra == pbaVO.bizSeCd }"><c:set var="eduFnshName" value="이론교육이수 수료일" /></c:when>
					<c:when test="${enumBizQlf == pbaVO.bizSeCd }"><c:set var="eduFnshName" value="고급교육 또는 이론교육 수료일" /></c:when>
					<c:otherwise><c:set var="eduFnshName" value="" /></c:otherwise>
				</c:choose>
				<tr>
					<th><c:out value="${eduFnshName }" /></th>
					<td><c:out value="${jtag:convertDateSplitString(result.eduFnshYmd, '-') }" /></td>
				</tr>
			</c:if>
		</tbody>
	</table>
<c:if test="${result.bizSeCd == enumBizQlf }">
					<h4 class="tit">자격시험 정보</h4>
					<p class="p_info FloatLeft">수험표에 표시될 정보입니다.</p>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">응시번호</th>
								<td>
									<input type="text" name="exslno" id="exslno" value="<c:out value="${result.exslno}" />" class="st_input input_long" placeholder="">
								</td>
							</tr>
							<tr>
								<th>시험장소</th>
								<td><c:out value="${qlfResult.testPlc }" /></td>
							</tr>
							<tr>
								<th>시험일자</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(qlfResult.testYmd,'-') }" />
								<c:if test="${!empty qlfResult.testYmd }">
									<fmt:parseDate pattern="yyyyMMdd" value="${qlfResult.testYmd }" var="testYmd"/>
									(<fmt:formatDate pattern="E" value="${testYmd }" />)
								</c:if>
								
								</td>
							</tr>
							<tr>
								<th>시험시간</th>
								<td><c:out value="${qlfResult.testHrInfo }" /></td>
							</tr>
							<tr>
								<th>합격자발표</th>
								<td>
									<c:out value="${jtag:convertDateSplitString(qlfResult.sccdPrsntnYmd,'-') }" />
								<c:if test="${!empty qlfResult.testYmd }">
									<fmt:parseDate pattern="yyyyMMdd" value="${qlfResult.sccdPrsntnYmd }" var="sccdPrsntnYmd"/>
									(<fmt:formatDate pattern="E" value="${sccdPrsntnYmd }" />)
								</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">시험결과</th>
								<td>
								<c:forEach var="code" items="${testRsltCdList }" varStatus="codeStatus">
									<input type="radio" name="testRsltCd" value="${code.indivCd}" id="testRsltCd${codeStatus.index }"${code.indivCd  == result.testRsltCd?' checked="checked"':'' } class="st_radio" onclick="fnCheckPass();">
									<label for="testRsltCd${codeStatus.index }"><c:out value="${code.indivCdNm }" /></label>
									<c:if test="${code.indivCd == '33002' }">
										/ 합격일 : <input type="text" name="passYmd" id="passYmd" value="<c:out value="${jtag:convertDateSplitString(result.passYmd,'-') }" />" class="st_input i_w95 date_style" placeholder="">
									</c:if>
								</c:forEach>
								</td>
							</tr>
					</table>
</c:if>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
