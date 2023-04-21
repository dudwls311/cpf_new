<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_header_inc.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/pba/pbaUserList.js?v=20230303"></script>

<c:choose>
	<c:when test="${enumFrsAdt == searchVO.pbancrcCtgryFrstCd }">
		<c:set var="modeName" value="kaMode" />
		<div class="page_tip">북한이탈주민의 초기정착을 돕고자 마련된 정착금의 일종으로 남북하나재단에서는 장애, 장기치료, 제3국 출생 자녀양육가산금을 지원하고 있습니다.
			<a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsTKqql12Umls2aVd%2FkDZog0%3D&menuPos=42">자세히 알기</a>
		</div>
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
	<c:when test="${enumFrsSho == searchVO.pbancrcCtgryFrstCd }">
		<div class="page_tip">탈북 학생들(대학생, 대학원생, 중고등학생, 검정고시합격자)이 안정적인 환경에서 공부할 수 있도록 생활비 보조형의 장학금을 지원하고 있습니다.
  			<a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsYPdw8OsB4AILnN9sdjIMFE%3D&amp;menuPos=29">자세히 알기</a>
		</div>
		<c:set var="modeName" value="ksMode" />
	</c:when>
	<c:when test="${enumFrsEdu == searchVO.pbancrcCtgryFrstCd }">
		<div class="page_tip">탈북 대학생의 교육지원(등록금 면제 또는 등록금 50% 보조)지원의 일환으로 등록금을 지원하고 있습니다. 교육지원금의 경우 각 대학별 모집을 통해 신청 할 수 있습니다.</div>
		<c:set var="modeName" value="keMode" />
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
	<c:when test="${enumFrsVdo == searchVO.pbancrcCtgryFrstCd }">
		<div class="page_tip">만9세 ~ 만24세 탈북 청소년 및 북한이탈주민 자녀를 대상으로 원어민 교사와의 1:1 수준별 화상영어 수업을 지원하고 있습니다.
  			<a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&amp;menuPos=31">자세히 알기</a>
		</div>
		<c:set var="modeName" value="kvMode" />
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
	<c:when test="${enumFrsLnb == searchVO.pbancrcCtgryFrstCd }">
		<div class="page_tip">만3세 ~ 초등학생 탈북 청소년 및 북한이탈주민 자녀를 대상으로 학습지 교사의 가정 방문을 통한 주1회 1과목 지도 수업을 지원하고 있습니다.
  			<a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&menuPos=31">자세히 알기</a>
		</div>
		<c:set var="modeName" value="klMode" />
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
	<c:when test="${enumFrsSpf == searchVO.pbancrcCtgryFrstCd }">
	
		<div class="page_tip"><strong>[탈북민 정착지원전문관리사]</strong> Uni-Korea Case Manager (민간자격등록번호 제 2014-4435호) 정착지원 분야 실무 인력 및 사회통합 및 정착분야 지원을 희망하는 예비 종사자(일반인)을 하여 [탈북민 정착지원전문관리사] 교육을 진행하고 있습니다. 
  			<a class="btn_st btn_ico_r FloatRight" target="_blank" title="새 창으로 열립니다." href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&menuPos=31">자세히 알기</a>
		</div>
		<c:set var="modeName" value="ksMode" />
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
	<c:when test="${enumFrsEmp == searchVO.pbancrcCtgryFrstCd }">
		<div class="page_tip">북한이탈주민들의 원활한 남한정착 및 자립, 생계유지를 위한다양한 취업연계 직업훈련 교육과정을 진행하고 있습니다.</div>
		<c:set var="modeName" value="keMode" />
		<input type="hidden" id="pbancrcCtgryFrstCd" value="${searchVO.pbancrcCtgryFrstCd }" />
	</c:when>
</c:choose>

<form id="listPageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
</form>
<form id="writePageForm" action="?">
	<input type="hidden" name="searchCondition" value="<c:out value="${searchVO.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	
	<input type="hidden" name="<c:out value="${modeName }" />" value="" />
	<input type="hidden" id="pbancrcSn" name="pbancrcSn" value="" />
</form>

<form action="?">
	<div class="con_b_tp">
		<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
		<div class="FloatRight">
			<input type="hidden" name="searchCondition" value="0" />
			<input type="text" id="searchKeyword" name="searchKeyword" value="<c:out value="${searchVO.searchKeyword }" />" class="st_input MAL10 PAR25" />
			<button type="submit" class="ico_search"><span class="comment">검색</span></button>
		</div>
	</div>
</form>

<c:set var="isBizSeCdShow" value="${searchVO.pbancrcCtgryFrstCd == enumFrsAdt || searchVO.pbancrcCtgryFrstCd == enumFrsSpf || searchVO.pbancrcCtgryFrstCd == enumFrsEmp }" />

<table class="table_style thd_v_m">
	<colgroup>
		<col width="5%" />
		<c:if test="${isBizSeCdShow == true }">
			<col width="15%" />
		</c:if>
		<col width="*" />
		<col width="20%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>No.</th>
			<c:if test="${isBizSeCdShow == true }">
				<th>구분</th>
			</c:if>
			<th>제목</th>
			<th>모집기간</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<fmt:formatDate var="pbancrcBgngDt" value="${result.pbancrcBgngDt}" pattern="${dateFormat }" />
			<fmt:formatDate var="pbancrcEndDt" value="${result.pbancrcEndDt}" pattern="${dateFormat }" />
			
			<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
			<tr>
				<td><c:out value="${no}" /></td>
				<c:if test="${isBizSeCdShow == true }">
					<td><c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd)}" /></td>
				</c:if>
				<td class="AlignLeft"><a href="#" onclick="javascript:fnView('<c:out value="${result.pbancrcSn}" />');return false;"><c:out value="${result.pbancrcNm}" /></a></td>
				<td>
					<c:choose>
						<c:when test="${result.pbancrcSttsCd == enumPbaUnsCd}">-</c:when>
						<c:when test="${result.pbancrcSttsCd == enumPbaAlwCd}">상시모집</c:when>
						<c:otherwise><c:out value="${pbancrcBgngDt}" /> ~ <c:out value="${pbancrcEndDt}" /></c:otherwise>
					</c:choose>
				</td>
				<td class="td_bg">
					<c:set var="pbancrcSttsClass" value="" />
					<c:choose>
						<c:when test="${enumPbaUnsCd == result.pbancrcSttsCd }"><span class="txt_c_bk"><b>접수전</b></span></c:when>
						<c:when test="${enumPbaBefCd == result.pbancrcSttsCd }"><span class="txt_c_bk"><b><c:out value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd)}" /></b></span></c:when>
						<c:when test="${enumPbaComCd == result.pbancrcSttsCd }"><span class="txt_c_bl"><b><c:out value="${jtag:getCdNm(pbancrcSttsCdList,result.pbancrcSttsCd)}" /></b></span></c:when>
						<c:when test="${enumPbaReqCd == result.pbancrcSttsCd || enumPbaAlwCd == result.pbancrcSttsCd }"><span class="btn_st btn_c_gr" onclick="fnWirte('<c:out value="${result.pbancrcSn}" />');return false;" ><b>신청하기</b></span></c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${resultCnt < 1 }">
			<tr>
				<td colspan="8">"온라인 신청 기간이 아닙니다."</td>
			</tr>
		</c:if>
	</tbody>
</table>

<div class="con_b_bt AlignCenter on">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
</div>


<div id="vdoInfoForm" style="display: none;">
	<div class="box_w_gray AlignCenter"> 
		<img src="/support/img/content/notice.png" alt="" style="width:60px; "><br>
		<span style="font-size: 16px;line-height: 30px;">
			<b class="txt_c_bl">@sprtName@ 지원 사업</b>은 <b class="txt_c_re">@sprtDiffName@ 지원 사업</b>과 <br>
			<span style="background: #777777;color: #fff;padding: 2px 3px;">중복 수혜 불가능</span> 하오니 유의하여 신청해 주세요.
		</span>
		<p class="p_info">(@sprtName@ 또는 @sprtDiffName@ 중 하나의 사업만 신청 가능)</p>
		<c:if test="${searchVO.pbancrcCtgryFrstCd eq '100005'}">
			<p class="p_info" style="color: red; font-weight: bold;">@sprtName@ 지원 신청 전 공고문 내용을 상세히 확인해주세요.</p>
			
		</c:if>
		
	</div>
</div>

<div id="sprtInfoForm" style="display: none;">
	<div class="box_w_gray AlignCenter"> 
		<img src="/support/img/content/notice.png" alt="" style="width:60px; "><br>
		<span style="font-size: 16px;line-height: 30px;">
			<b class="txt_c_bl">@sprtName@</b>의 <b class="txt_c_re">온라인신청</b>은 <br>
			<span style="background: #777777;color: #fff;padding: 2px 3px;">@date@부터</span> 가능 하오니 <br />이점 양지해주시길 바랍니다.
		</span>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/exts/koreahana/com/user_footer_inc.jsp" %>