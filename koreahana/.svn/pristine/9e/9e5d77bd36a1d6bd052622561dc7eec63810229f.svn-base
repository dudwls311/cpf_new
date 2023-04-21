<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<c:import url="/user/exts/com/addressFind.do" /><%//공통 주소찾기 함수 %>

<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprWriteSub.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/spf/spfWrite.js"></script>
<script type="text/javascript" src="/resources/js/exts/koreahana/smb/smbWrite.js"></script>

<c:set var="sprtType" value="spf" />
<c:set var="modeName" value="ksMode" />
<c:choose>
	<c:when test="${adminPageYn == 'Y' }">
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprWriteForm.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprUserWriteForm.jsp" %>
	</c:otherwise>
</c:choose>

<form id="writeFileForm" action="<c:url value="/user/exts/koreahana/spf/index.do" />" method="post" enctype="multipart/form-data" style="display: none;">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeFileActionJson" />
	<input type="file" id="photoFile" name="photoFile" />
</form>

<form id="writeForm" action="<c:url value="${actionUrl }" />" method="post" enctype="multipart/form-data">
	<input type="hidden" name="<c:out value="${modeName }" />" value="writeActionJson" />
	<input type="hidden" id="tmpSaveYn" name="tmpSaveYn" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="<c:out value="${pbaVO.pbancrcSn }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${pbaVO.bizSeCd }" />" />

	<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/sprTitleForm.jsp" %>
	
	<h4 class="tit">신청자(지원 대상자) 기본 정보</h4>
	<c:if test="${adminPageYn != 'Y' }"><p class="p_info">신청자 기본정보는 회원 정보로 자동 입력됩니다. 신청자 기본정보는 마이페이지 > 개인정보수정 메뉴에서 수정할 수 있습니다.</p></c:if>
	<table class="table_style table_t_left">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<c:choose>
				<c:when test="${adminPageYn == 'Y' }">
					<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoForm.jsp" %>
				</c:when>
				<c:otherwise>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/mbrInfoUserForm.jsp" %>
				</c:otherwise>
			</c:choose>
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
				<th>사진 <b class="imp_st">*</b></th>
				<td>
					<c:if test="${adminPageYn == 'Y' }">
						<input type="hidden" id="photoUrl" value="<c:out value="${actionUrl }?${modeName }=imgView&enc=@encParam@" />" />
					</c:if>
					<c:if test="${adminPageYn != 'Y' }">
						<input type="hidden" id="photoUrl" value="/user/exts/koreahana/spr/index.do?ksMode=imgView&enc=@encParam@" />
					</c:if>
					
					<c:choose>
						<c:when test="${empty photoFile }">
							<c:url var="photoFileUrl" value="/support/img/content/p_default.jpg" />
						</c:when>
						<c:otherwise>
							<c:set var="photoFileStyle" value="style='display: none';" />
							<c:if test="${adminPageYn == 'Y' }">
								<c:url var="photoFileUrl" value="${actionUrl }?${modeName }=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, result.sprtSn) }" />
							</c:if>
							<c:if test="${adminPageYn != 'Y' }">
								<c:url var="photoFileUrl" value="/user/exts/koreahana/spr/index.do?ksMode=imgView&enc=${jtag:sprtFileViewEncode(photoFile.atchFileSn, result.sprtSn) }" />
							</c:if>
						</c:otherwise>
					</c:choose>
					<input type="hidden" id="photoFileSn" name="photoFileSn" value="<c:out value="${result.photoFileSn }" />" />
					<img src="<c:out value="${photoFileUrl }" />" alt="기본 이미지" class="img_profil" id="imgArea" />
					<ul class="profil_r_txt txt_c_bl">
						<li>✓ 최근 3월 이내에 촬영한 반명함판 사진을 등록해주세요.</li>
						<li>✓ 사진의 규격은 3cm X 4cm 증명사진 비율이 적합합니다.</li>
					</ul>
					<p>
						<a class="btn_st" href="#" id="photoFileTrg" ${photoFileStyle } >파일찾기</a>
						<a class="btn_st FloatRight" href="#" onclick="fnSetImg();return false;">다시등록</a>
					</p>
				</td>
			</tr>
			<c:if test="${enumBizQlf == pbaVO.bizSeCd }">
				<tr>
					<th>자격증 수령지 <b class="imp_st">*</b></th>
					<td>
						<c:set var="crtfctRcvZip" value="${empty result ? loginAdtVO.zip : result.crtfctRcvZip }" />
						<c:set var="crtfctRcvAddr" value="${empty result ? loginAdtVO.addr : result.crtfctRcvAddr }" />
						<c:set var="crtfctRcvDaddr" value="${empty result ? loginAdtVO.daddr : result.crtfctRcvDaddr }" />
					
						<input type="text" name="crtfctRcvZip" id="crtfctRcvZip" value="<c:out value="${crtfctRcvZip}" />" class="st_input " placeholder="">
						<a class="btn_st btn_c_bk" href="#" onclick="fnCrtfctRcvAddr();return false;">주소 검색</a>
						<input type="text" name="crtfctRcvAddr" id="crtfctRcvAddr" value="<c:out value="${crtfctRcvAddr}" />" class="st_input input_long  MAB5  MAT5">
						<input type="text" name="crtfctRcvDaddr" id="crtfctRcvDaddr" value="<c:out value="${crtfctRcvDaddr}" />" class="st_input input_long ">
					</td>
				</tr>
			</c:if>
			<tr>
				<th>소속 <b class="imp_st">*</b></th>
				<td><input type="text" name="ordpNm" id="ordpNm" value="<c:out value="${result.ordpNm }" />" class="st_input input_long" /></td>
			</tr>
			<tr>
				<th>이메일 <b class="imp_st">*</b></th>
				<td><input type="text" name="eml" id="eml" value="<c:out value="${result.eml }" />" class="st_input input_long" /></td>
			</tr>
			<tr>
				<th>최종학력 <b class="imp_st">*</b></th>
				<td>
					<c:forEach var="code" items="${aplcntLastAcbgCdList }" varStatus="codeStatus" >
						<c:if test="${!codeStatus.last }">
							<input type="radio" name="lastAcbgCd" id="<c:out value="lastAcbgCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${result.lastAcbgCd == code.indivCd ? 'checked' : '' }" /> class="st_radio"/><label for="<c:out value="lastAcbgCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
						</c:if>
						<c:if test="${codeStatus.last }">
							<div class="ig_s">
								<input type="radio" name="lastAcbgCd" id="<c:out value="lastAcbgCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${result.lastAcbgCd == code.indivCd ? 'checked' : '' }" /> class="st_radio"/><label for="<c:out value="lastAcbgCd${codeStatus.count }" />"><c:out value="${code.indivCdNm } :" /></label>
							</div>
							<div class="ig_l">
								<input type="text" name="lastAcbgEtc" id="lastAcbgEtc" value="<c:out value="${result.lastAcbgEtc }" />" class="st_input input_long" />
							</div>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>종사기관 유형 <b class="imp_st">*</b></th>
				<td>
					<c:forEach var="code" items="${ocptInstTypeCdList }" varStatus="codeStatus" >
						<c:if test="${!codeStatus.last }">
							<input type="radio" name="ocptInstTypeCd" id="<c:out value="ocptInstTypeCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${result.ocptInstTypeCd == code.indivCd ? 'checked' : '' }" /> class="st_radio"/><label for="<c:out value="ocptInstTypeCd${codeStatus.count }" />"><c:out value="${code.indivCdNm }" /></label>
						</c:if>
						<c:if test="${codeStatus.last }">
							<div class="ig_s">
								<input type="radio" name="ocptInstTypeCd" id="<c:out value="ocptInstTypeCd${codeStatus.count }" />" value="<c:out value="${code.indivCd }" />" <c:out value="${result.ocptInstTypeCd == code.indivCd ? 'checked' : '' }" /> class="st_radio"/><label for="<c:out value="ocptInstTypeCd${codeStatus.count }" />"><c:out value="${code.indivCdNm } :" /></label>
							</div>
							<div class="ig_l">
								<input type="text" name="ocptInstTypeEtc" id="ocptInstTypeEtc" value="<c:out value="${result.ocptInstTypeEtc }" />" class="st_input input_long" />
							</div>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<c:if test="${enumBizQlf != pbaVO.bizSeCd }">
				<tr>
					<th>북한이탈주민 정착 지원 실무 경력</th>
					<td><textarea class="st_textarea" id="ptexp" name="ptexp"><c:out value="${result.ptexp }" /></textarea></td>
				</tr>
				<tr>
					<th>신청 동기 및  기대 효과 <b class="imp_st">*</b></th>
					<td>
						<p class="MAB10">
							<span class="txt_c_bl">반드시 300자 이상 작성해주세요.</span>
							<span class="FloatRight">공백포함 : 총 <b class="txt_c_re" id="aplyMtvSpan">0</b> 자</span>
						</p>
						<textarea class="st_textarea" id="aplyMtv" name="aplyMtv"><c:out value="${result.aplyMtv }" /></textarea>
					</td>
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
					<th><c:out value="${eduFnshName }" /> <b class="imp_st">*</b></th>
					<td><input type="text" name="eduFnshYmd" id="eduFnshYmd" value="<c:out value="${jtag:convertDateSplitString(result.eduFnshYmd, '-') }" />" class="st_input i_w95 date_style" /></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	
	<%//제출서류폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbWriteForm.jsp" %>
	
	<%//개인정보동의폼 %> 
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/agreeForm.jsp" %>
	
	<c:set var="sgnType" value="spf" />
	<%//서명폼 %>
	<%@ include file="/WEB-INF/jsp/exts/koreahana/sgn/include/signForm.jsp" %>
			
	<c:choose>
		<c:when test="${adminPageYn == 'Y' }">
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_write_bottom.jsp" %>
		</c:when> 
		<c:otherwise>
			<%//버튼폼 %>
			<%@ include file="/WEB-INF/jsp/exts/koreahana/spr/include/spr_user_write_bottom.jsp" %>		
		</c:otherwise>
	</c:choose>
</form>

<%@ include file="/WEB-INF/jsp/exts/koreahana/doc/include/docTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/smb/include/smbTemplateForm.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaConfirmTemplate.jsp" %>