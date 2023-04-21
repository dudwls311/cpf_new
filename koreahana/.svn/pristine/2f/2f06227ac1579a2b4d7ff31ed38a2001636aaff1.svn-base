<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<% pageContext.setAttribute("lf", "\n"); %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprViewSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/spf/spfView.js"></script>

<c:set var="modeName" value="ksMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserViewForm.jsp" %>
	</c:otherwise>
</c:choose>

<input type="hidden" id="sprtSn" value="<c:out value="${result.sprtSn }" />" />

	<c:set var="hideRequire" value="Y" />
	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
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
								<c:url var="photoFileUrl" value="/user/exts/koreahana/spr/index.do?ksMode=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, result.sprtSn) }" />
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
	
	<c:set var="sgnType" value="spf" />
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprViewAllDownForm.jsp" %>
			
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprSttsForm.jsp" %>
			
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_view_bottom.jsp" %>
		</c:when>
		<c:otherwise>
			<h4 class="tit">제출 서류</h4>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signViewForm.jsp" %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_view_bottom.jsp" %>
		</c:otherwise>
	</c:choose>
