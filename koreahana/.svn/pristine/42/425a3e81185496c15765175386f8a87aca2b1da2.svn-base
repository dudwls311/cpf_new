<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spf/spfPrcView.js"></script>

<form id="writePageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" name="testRsltCd" value="<c:out value="${searchVO.testRsltCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kspMode" value="write" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
</form>
<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" name="testRsltCd" value="<c:out value="${searchVO.testRsltCd }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>


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
						<c:when test="${empty photoFile }">
							<c:url var="photoFileUrl" value="/support/img/content/p_default.jpg" />
						</c:when>
						<c:otherwise>
							<c:if test="${adminPageYn == 'Y' }">
								<c:url var="photoFileUrl" value="${actionUrl }?${modeName }=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, result.sprtSn) }" />
							</c:if>
							<c:if test="${adminPageYn != 'Y' }">
								<c:url var="photoFileUrl" value="/user/exts/koreahana/spr/index.do?ksMode=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, '') }" />
							</c:if>
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
					<div class=" FloatRight"><a class="btn_st" href="#" onclick="fnTestIdPrint();return false;">수험표 인쇄</a></div>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">응시번호</th>
								<td>
									<c:out value="${result.exslno}" />
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
								<c:if test="${!empty qlfResult.sccdPrsntnYmd }">
									<fmt:parseDate pattern="yyyyMMdd" value="${qlfResult.sccdPrsntnYmd }" var="sccdPrsntnYmd"/>
									(<fmt:formatDate pattern="E" value="${sccdPrsntnYmd }" />)
								</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">시험결과</th>
								<td>
								<c:out value="${jtag:getCdNm(testRsltCdList, result.testRsltCd) }" />
								<c:if test="${code.indivCd == '33002' }">
										/ 합격일 : <c:out value="${jtag:convertDateSplitString(result.passYmd,'-') }" />
									</c:if>
								</td>
							</tr>
					</table>
</c:if>

					<c:set var="hideDelete" value="Y" />
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/view_bottom.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
