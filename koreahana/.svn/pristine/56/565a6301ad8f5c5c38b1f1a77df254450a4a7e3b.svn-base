<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprListSub.js"></script>

<form id="writePageForm" action="?">
<c:if test="${sprtType == 'sho' }">
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
</c:if>
<c:if test="${sprtType == 'eml' && isFoundStaff == true }">
	<input type="hidden" name="hanactCd" value="<c:out value="${searchVO.hanactCd }" />" />
</c:if>
<c:if test="${hideSprtSttsCd != 'Y' }">
	<input type="hidden" name="sprtSttsCd" value="<c:out value="${searchVO.sprtSttsCd }" />" />
</c:if>
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	<input type="hidden" id="<c:out value="${modeName }" />" name="<c:out value="${modeName }" />" value="" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="" />
</form>
<form id="listPageForm" action="?">
<c:if test="${sprtType == 'sho' }">
	<input type="hidden" name="searchNtkYn" value="<c:out value="${searchVO.searchNtkYn }" />" />
	<input type="hidden" name="searchSholSlctnType" value="<c:out value="${searchVO.searchSholSlctnType }" />" />
</c:if>
<c:if test="${hideSprtSttsCd != 'Y' }">
	<input type="hidden" name="sprtSttsCd" value="<c:out value="${searchVO.sprtSttsCd }" />" />
</c:if>
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="bizSeCd" value="<c:out value="${searchVO.bizSeCd }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>

<form action="?" id="searchForm">
	<%@include file="/WEB-INF/jsp/exts/koreahana/spr/include/SprListPbaSearchForm.jsp" %>

	<div class="box_w_gray ">
		<div class="ig_wrap">
			<div class="ig_s">
				<label for="regDtYr">신청연도</label>
				<select name="regDtYr" id="regDtYr"  class="st_select">
					<option value="">전체</option>
					<c:forEach var="regDtYr" items="${regDtYrList }">
						<option value="<c:out value="${regDtYr.regDtYr }" />" <c:out value="${regDtYr.regDtYr == searchVO.regDtYr ? 'selected' : ''}" />  ><c:out value="${regDtYr.regDtYr }" /></option>
					</c:forEach>
				</select> 
		
				<c:if test="${ ( isFoundStaff == true || isAdmin == true ) && ( sprtType == 'eml' || sprtType == 'emv' ) }">
					<label for="searchNtkYn">하나센터</label>
					<select name="hanactCd" id="hanactCd"  class="st_select">
						<option value="">전체</option>
						<c:forEach var="hanact" items="${hanactList }">
							<option value="<c:out value="${hanact.orgId }" />" ${hanact.orgId == searchVO.hanactCd?'selected':'' }><c:out value="${hanact.orgNm }" /></option>
						</c:forEach>
					</select> 
				</c:if>
		
				<c:if test="${showTestRsltCd == 'Y'}">
					<label for="testRsltCd">시험결과</label>
					<select name="testRsltCd" id="testRsltCd"  class="st_select">
						<option value="">전체</option>
					<c:forEach var="code" items="${testRsltCdList }" varStatus="codeStatus">
						<option value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == searchVO.testRsltCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
					</c:forEach>
					</select> 
				</c:if>
				<c:if test="${sprtType == 'sho' }">
					<label for="searchNtkYn">지원자유형</label>
					<select name="searchNtkYn" id="searchNtkYn"  class="st_select">
						<option value="">전체</option>
						<option value="Y"${searchVO.searchNtkYn == 'Y'?' selected':'' }>북한이탈주민</option>
						<option value="N"${searchVO.searchNtkYn == 'N'?' selected':'' }>제3국출생</option>
					</select> 
					<label for="searchSholSlctnType">장학금유형</label>
					<select name="searchSholSlctnType" id="searchSholSlctnType"  class="st_select">
						<option value="">전체</option>
						<option value="1"${searchVO.searchSholSlctnType == '1'?' selected':'' }>대학원생</option>
						<option value="2"${searchVO.searchSholSlctnType == '2'?' selected':'' }>대학생</option>
						<option value="3"${searchVO.searchSholSlctnType == '3'?' selected':'' }>계절학기 수강생</option>
						<option value="4"${searchVO.searchSholSlctnType == '4'?' selected':'' }>중고등학생</option>
						<option value="5"${searchVO.searchSholSlctnType == '5'?' selected':'' }>검정고시합격자</option>
					</select>
				</c:if>
			<c:if test="${hideSprtSttsCd != 'Y' }">
				<label for="sprtSttsCd" class="MAL20">상태</label>
				<select id="sprtSttsCd" name="sprtSttsCd" class="st_select">
					<option value="">전체</option>
					<c:forEach var="code" items="${sprtSttsCdList }" varStatus="codeStatus">
						<option value="<c:out value="${code.indivCd }" />" <c:out value="${code.indivCd == searchVO.sprtSttsCd ? 'selected' : '' }" /> ><c:out value="${code.indivCdNm }" /></option>
					</c:forEach>
				</select>
			</c:if>
			</div>
	
			<div class="ig_l">
				<input type="hidden" name="searchCondition" value="0" />
				<label for="searchKeyword" class="comment">검색어 입력</label>
				<input type="text" name="searchKeyword" id="searchKeyword" class="st_input input_long" value="<c:out value="${searchVO.searchKeyword }" />" placeholder="지원대상 이름으로 검색"/>
			</div>
			
			<div class="ig_s">
				<button type="submit" class="btn-input-search">조회</button>
			</div>
			
		</div>
	</div>
</form>

<c:if test="${hideSprtSttsCd != 'Y' }">
<!-- // search box -->
<div class="box_w_blue board_l_stat_i MAT-20">

	<c:forEach var="code" items="${sprtSttsCdList }" varStatus="codeSprStatus">
		<c:if test="${code.indivCd != enumSprTmpCd }">
			<c:set var="sprtSttsCnt" value="0" />
			<c:set var="spanClass" value="" />
			
			<c:forEach var="sprtSttsResult" items="${sprtSttsList }" varStatus="sprtSttsStatus">
				<c:if test="${code.indivCd == sprtSttsResult.sprtSttsCd }">
					<c:set var="sprtSttsCnt" value="${sprtSttsResult.sprtSttsCnt }" />
				</c:if>
			</c:forEach>
			
			<c:choose>
				<c:when test="${enumSprComCd == code.indivCd }"><c:set var="spanClass" value="bg_c_bl" /></c:when>
				<c:when test="${enumSprSelCd == code.indivCd }"><c:set var="spanClass" value="bg_c_gr" /></c:when>
				<c:when test="${enumSprUnsCd == code.indivCd }"><c:set var="spanClass" value="bg_c_gy" /></c:when>
				<c:when test="${enumSprWaiCd == code.indivCd }"><c:set var="spanClass" value="bg_c_ye" /></c:when>
				<c:when test="${enumSprUndCd == code.indivCd }"><c:set var="spanClass" value="bg_c_re" /></c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			
			<b><c:out value="${code.indivCdNm }" /></b><span class="<c:out value="${spanClass }" />"><fmt:formatNumber value="${sprtSttsCnt }" /> </span>
			<c:if test="${!codeSprStatus.last }"><span class="bar"></span></c:if>
		</c:if>
	</c:forEach>
	
</div>
</c:if>
<div id="statDiv"></div>
<div class="con_b_tp">
	<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
	<div class=" FloatRight">
		<a class="btn_st btn_c_gr" href="#" onclick="ComFns.excelDownload();return false;">엑셀 다운로드</a>
		
	<c:if test="${hideWrite != 'Y' && isStreAuth == true}">
		<a class="btn_st btn_c_bk" href="#" onclick="fnWrite('');return false;">추가</a>
		<c:if test="${showExcelUpload == 'Y' }">
			<a class="btn_st btn_c_bk" href="#" onclick="fnWriteBundle();return false;">선정결과 일괄등록</a>
		</c:if>
	</c:if>
	</div>
</div>

<c:if test="${hideSprtSttsCd != 'Y' && isCenterStaff == false }">
<div class="box_w_wht MAB5">
	<label for="sprtSttsCdChg" class="comment">신청서 상태변경</label>
	<select id="sprtSttsCdChg" class="st_select" onchange="fnSprtSttsCdChg();">
   		<option value="">신청서 상태변경</option>
   		<c:forEach var="code" items="${sprtSttsCdList }" varStatus="codeStatus">
   			<c:if test="${code.indivCd != enumSprTmpCd }">
   				<option value="<c:out value="${code.indivCd }" />" data-nm="<c:out value="${code.indivCdNm }" />" ><c:out value="${code.indivCdNm }" /></option>
   			</c:if>
		</c:forEach>
	</select>
</div>
</c:if>