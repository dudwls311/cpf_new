<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).values()" var="enumFrsList" /> <%//최초범주리스트 %>
<script type="text/javascript" src="/resources/js/exts/koreahana/spr/sprHistoryList.js"></script>

<c:forEach var="enumFrs" items="${enumFrsList }">
	<c:if test="${enumFrsMdl == enumFrs.getCode() }"><c:set var="mdlLink" value="/exts/koreahana/mdl/index.do?kmMode=view" /></c:if>
	<c:if test="${enumFrsEml == enumFrs.getCode() }"><c:set var="emlLink" value="/exts/koreahana/eml/index.do?keMode=view" /></c:if>
	<c:if test="${enumFrsAdt == enumFrs.getCode() }"><c:set var="adtLink" value="/exts/koreahana/adt/index.do?kaMode=view" /></c:if>
	<c:if test="${enumFrsSho == enumFrs.getCode() }"><c:set var="shoLink" value="/exts/koreahana/sho/index.do?ksMode=view" /></c:if>
	<c:if test="${enumFrsEdu == enumFrs.getCode() }"><c:set var="eduLink" value="/exts/koreahana/edu/index.do?keMode=view" /></c:if>
	<c:if test="${enumFrsVdo == enumFrs.getCode() }"><c:set var="vdoLink" value="/exts/koreahana/vdo/index.do?kvMode=view" /></c:if>
	<c:if test="${enumFrsLnb == enumFrs.getCode() }"><c:set var="lnbLink" value="/exts/koreahana/lnb/index.do?klMode=view" /></c:if>
	<c:if test="${enumFrsSpf == enumFrs.getCode() }"><c:set var="spfLink" value="/exts/koreahana/spf/index.do?ksMode=view" /></c:if>
	<c:if test="${enumFrsEmv == enumFrs.getCode() }"><c:set var="emvLink" value="/exts/koreahana/emv/index.do?keMode=view" /></c:if>
	<c:if test="${enumFrsFthNew == enumFrs.getCode() }"><c:set var="fthNewLink" value="/exts/koreahana/fthNew/index.do?kfnMode=view" /></c:if>
	<c:if test="${enumFrsFthMtr == enumFrs.getCode() }"><c:set var="fthMtrLink" value="/exts/koreahana/fthMtr/index.do?kfmMode=view" /></c:if>
	<c:if test="${enumFrsFthMdw == enumFrs.getCode() }"><c:set var="fthMdwLink" value="/exts/koreahana/fthMdw/index.do?kfmMode=view" /></c:if>
	<c:if test="${enumFrsEmp == enumFrs.getCode() }"><c:set var="empLink" value="/exts/koreahana/emp/index.do?keMode=view" /></c:if>
	<c:if test="${enumFrsMgm == enumFrs.getCode() }"><c:set var="mgmLink" value="/exts/koreahana/mgm/index.do?kmMode=view" /></c:if>
	<c:if test="${enumFrsFrm == enumFrs.getCode() }"><c:set var="frmLink" value="/exts/koreahana/frm/index.do?kfMode=view" /></c:if>
</c:forEach>

	
<script type="text/javascript">
var mdlLink = '${mdlLink}';
var emlLink = '${emlLink}';
var adtLink = '${adtLink}';
var shoLink = '${shoLink}';
var eduLink = '${eduLink}';
var vdoLink = '${vdoLink}';
var lnbLink = '${lnbLink}';
var spfLink = '${spfLink}';
var emvLink = '${emvLink}';
var fthNewLink = '${fthNewLink}';
var fthMtrLink = '${fthMtrLink}';
var fthMdwLink = '${fthMdwLink}';
var empLink = '${empLink}';
var mgmLink = '${mgmLink}';
var frmLink = '${frmLink}';

function fnViewPba(ctgry,sn){
	var _link = '';
	if(ctgry ==  '${enumFrsMdl}'){
		_link = mdlLink;
		location.href = _link + '&mdlcrSprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsEml}'){
		_link = emlLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsAdt}'){
		_link = adtLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsSho}'){
		_link = shoLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsEdu}'){
		_link = eduLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsVdo}'){
		_link = vdoLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsLnb}'){
		_link = lnbLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsSpf}'){
		_link = spfLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsEmv}'){
		_link = emvLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsFthNew}'){
		_link = fthNewLink;
		location.href = _link + '&fthpbbNewAplySn=' + sn;
	}else if(ctgry ==  '${enumFrsFthMtr}'){
		_link = fthMtrLink;
		location.href = _link + '&fthpbbMtryCncltnSn=' + sn;
	}else if(ctgry ==  '${enumFrsFthMdw}'){
		_link = fthMdwLink;
		location.href = _link + '&fthpbbMdwCncltnSn=' + sn;
	}else if(ctgry ==  '${enumFrsEmp}'){
		_link = empLink;
		location.href = _link + '&sprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsMgm}'){
		_link = mgmLink;
		location.href = _link + '&mgmipvAmtSprtSn=' + sn;
	}else if(ctgry ==  '${enumFrsFrm}'){
		_link = frmLink;
		location.href = _link + '&frmSpfstSn=' + sn;
	}
}
</script>
<form action="?" id="listPageForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="<c:out value="${searchVO.pageIndex }" />" />
	
	<div class="box_w_gray ig_wrap ">
		<div class="ig_s">
			<label for="pbancrcCtgryFrstCd" class="MAL0">지원사업</label>
			<select name="pbancrcCtgryFrstCd" id="pbancrcCtgryFrstCd" class="st_select">
				<option value="">전체</option> 
				<c:forEach var="enumFrs" items="${enumFrsList }">
					<c:if test="${enumFrs.getCode() != '20002' }">
						<option value="<c:out value="${enumFrs.getCode() }" />" <c:out value="${enumFrs.getCode() == searchVO.pbancrcCtgryFrstCd ? 'selected' : '' }" /> ><c:out value="${enumFrs.getName() }" /></option>
					</c:if>
				</c:forEach>
			</select>
			
			<label for="flnm" class="MAL30">이름</label>
			<input type="text" style="width: 90px;" id="flnm" name="flnm" class="st_input" value="<c:out value="${searchVO.flnm }" />" />
		
			<label for="brdtYmd" class="MAL30">생년월일</label>
			<input type="text" style="width: 90px;" id="brdtYmd" name="brdtYmd" class="st_input date_style" value="<c:out value="${searchVO.brdtYmd }" />" />
		
			<label for="ntkrdfUnqNo" class="MAL30">북한이탈주민번호</label>
			<input type="text" style="width: 90px;" id="ntkrdfUnqNo" name="ntkrdfUnqNo" class="st_input" value="<c:out value="${searchVO.ntkrdfUnqNo }" />" />
			<br />
			
			<label for="entcnyYmd">입국일&nbsp;&nbsp;&nbsp;</label>
			<input type="text" style="width: 90px;" id="entcnyYmd" name="entcnyYmd" class="st_input date_style" value="<c:out value="${searchVO.entcnyYmd }" />" />
			
			<label for="prtdcsYmd" style="margin-left: 75px;">보호결정일</label>
			<input type="text" style="width: 90px;" id="prtdcsYmd" name="prtdcsYmd" class="st_input date_style" value="<c:out value="${searchVO.prtdcsYmd }" />" />
		
			<label for="hanawonTh" style="margin-left: 17px;">하나원기수</label>
			<input type="text" style="width: 90px;" id="hanawonTh" name="hanawonTh" class="st_input" value="<c:out value="${searchVO.hanawonTh }" />" />
		
			<label for="hanawonFnshYmd" style="margin-left: 53px;">하나원 수료일</label>
			<input type="text" style="width: 90px;" id="hanawonFnshYmd" name="hanawonFnshYmd" class="st_input date_style" value="<c:out value="${searchVO.hanawonFnshYmd }" />" />
		
			<button type="submit"style="margin-left: 30px;" class="btn-input-search">조회</button>
		</div>
	</div>
</form>

<div class="page_tip">
	최종 선정된 지원대상자의 사업별 지원 이력정보가 조회됩니다.<br />
	이름, 생년월일, 입국일, 북한이탈주민번호, 보호결정일, 하나원기수, 하나원수요일 정보 중 하나 이상 입력 후 검색해주세요.
</div>

<div class="con_b_tp">
	<p class="b_total FloatLeft">총<span><fmt:formatNumber value="${resultCnt}" /></span>건</p>
	<div class=" FloatRight">
		<a class="btn_st btn_c_gr" href="#" onclick="ComFns.excelDownload();return false;">엑셀 다운로드</a>
	</div>
</div>

<table class="table_style thd_v_m">
	<colgroup>
		<col width="5%" />
		<col width="11%" />
		<col width="11%" />
		<col width="11%" />
		<col width="5%" />
		<col width="11%" />
		<col width="7%" />
		<col width="17%" />
		<col width="11%" />
		<col width="11%" />
	</colgroup>
	<thead>
		<tr>
			<th>No.</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>입국일</th>
			<th>하나원기수</th>
			<th>하나원 수료일</th>
			<th>북한이탈주민번호</th>
			<th>지원사업명</th>
			<th>신청일</th>
			<th>지원 또는 지급(결정)일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList }" varStatus="status">
			<fmt:formatDate var="regDt" value="${result.regDt}" pattern="${dateFormat }" />
			<c:set var="no" value="${resultCnt - (((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage) + status.index)}" />
			<c:forEach var="enumFrs" items="${enumFrsList }">
				<c:if test="${enumFrs.getCode() == result.pbancrcCtgryFrstCd }"><c:set var="sprtName" value="${enumFrs.getName() }" /></c:if>
			</c:forEach>
			
			<tr>
				<td><c:out value="${no }" /></td>
				<td><a href="#" onclick="javascript:fnViewPba(<c:out value="'${result.pbancrcCtgryFrstCd}','${result.sprtSn}'" />);return false;"><c:out value="${result.flnm }" /></a></td>
				<td><c:out value="${jtag:convertDateSplitString(result.brdtYmd, '-') }" /></td>
				<td><c:out value="${jtag:convertDateSplitString(result.entcnyYmd, '-') }" /></td>
				<td><c:out value="${result.hanawonTh }" /></td>
				<td><c:out value="${jtag:convertDateSplitString(result.hanawonFnshYmd, '-') }" /></td>
				<td><c:out value="${result.ntkrdfUnqNo }" /></td>
				<td><c:out value="${sprtName }" /></td>
				<td><c:out value="${regDt }" /></td>
				<td><c:out value="${jtag:convertDateSplitString(result.giveYmd, '-') }" /></td>
			</tr>
		</c:forEach>
		<c:if test="${fn:length(resultList) < 1 }">
			<tr>
				<td colspan="11">해당 데이터가 존재하지 않습니다.</td>
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
<%-- <%@ include file="/WEB-INF/jsp/exts/koreahana/com/list_bottom.jsp" %> --%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
