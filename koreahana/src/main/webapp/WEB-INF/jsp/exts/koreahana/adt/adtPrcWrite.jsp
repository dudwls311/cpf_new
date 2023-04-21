<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<%//기존 회차데이터 %>
<script type="text/javascript">
var arrRndData = new Array();
var arrRndYmData = new Array();
<c:forEach items="${result.rndList}" var="rnd">
	arrRndData[${rnd.rnd}] = ${rnd.giveAmt};
	arrRndYmData[${rnd.rnd}] = '${rnd.giveYm}';
</c:forEach>
</script>
<script type="text/javascript" src="/resources/js/exts/koreahana/adt/adtPrcWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="pbancrcSn" value="<c:out value="${searchVO.pbancrcSn }" />" />
	<input type="hidden" name="regDtYr" value="<c:out value="${searchVO.regDtYr }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kapMode" value="view" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kapMode" value="writeActionJson" />
	<input type="hidden" id="sprtSn" name="sprtSn" value="<c:out value="${result.sprtSn }" />" />
	<input type="hidden" id="adtnAmtSprtPrcnMngSn" name="adtnAmtSprtPrcnMngSn" value="<c:out value="${result.adtnAmtSprtPrcnMngSn }" />" />

	<input type="hidden" id="rndConcat" name="rndConcat" value="" />
	
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
	
	<c:if test="${enumBizThr == result.bizSeCd }">
		<h4 class="tit">가족관계</h4>
		<table class="table_style">
			<colgroup>
				<col width="50%" />
				<col width="50%" />
			</colgroup>
			<thead>
				<tr>
					<th>신청자와의 관계</th>
					<th>가족 성명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fam" items="${famList }">
					<tr>
						<td><c:out value="${jtag:getCdNm(aplcntRelCdList,fam.aplcntRelCd) }" /></td>
						<td><c:out value="${fam.famFlnm }" /></td>
					</tr>
				</c:forEach>
				<c:if test="${fn:length(famList) < 1 }">
					<tr>
						<td colspan="2">데이터가 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</c:if>
	
				<h4 class="tit">신청정보</h4>
				<table class="table_style table_t_left th_v_m">
					<colgroup>
						<col style="width:140px;" />
						<col />
					</colgroup>
						<tr>
							<th scope="row">신청일</th>
							<td>
								<fmt:formatDate value="${result.regDt}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th scope="row">장애구분</th>
							<td>
								<c:out value="${jtag:getCdNm(bizSeCdList,result.bizSeCd) }" />
							</td>
						</tr>
						<tr>
							<th scope="row">지급사유</th>
							<td>
								<c:out value="${result.rsn}" />
							</td>
						</tr>
				</table>
					
				<c:if test="${enumBizDis == result.bizSeCd }">
					<h4 class="tit">장애 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">장애정도</th>
								<td>
									<input type="radio" name="dsbltyDegr" value="중증" id="dsbltyDegr1"${'중증' == result.dsbltyDegr?' checked="checked"':'' } class="st_radio">
									<label for="dsbltyDegr1">중증</label>
									
									<input type="radio" name="dsbltyDegr" value="경증" id="dsbltyDegr2"${'경증' == result.dsbltyDegr?' checked="checked"':'' } class="st_radio">
									<label for="dsbltyDegr2">경증</label>
								</td>
							</tr>
							<tr>
								<th scope="row">장애구분</th>
								<td>
									<input type="text" name="dsbltySe" id="dsbltySe" value="<c:out value="${result.dsbltySe}" />" class="st_input input_long" placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									<textarea class="st_textarea" name="dsbltyRmrk" id="dsbltyRmrk"><c:out value="${result.dsbltyRmrk}" /></textarea>
								</td>
							</tr>
					</table>
				</c:if>
					
				<c:if test="${enumBizLon == result.bizSeCd }">
					<h4 class="tit">장기치료 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">질병명</th>
								<td>
									<input type="text" name="dssNm" id="dssNm" value="<c:out value="${result.dssNm}" />" class="st_input input_long" placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row">입원기간</th>
								<td>
								<select id="hsptzPeriod" name="hsptzPeriod" class="st_select">
									<option value="">선택</option>
								<c:forEach begin="1" end="12" var="m">
									<option value="${m }"${m == result.hsptzPeriod?' selected':'' }>${m }개월</option>
								</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<th scope="row">입원정보</th>
								<td>
									<textarea class="st_textarea" name="hsptzInfo" id="hsptzInfo"><c:out value="${result.hsptzInfo}" /></textarea>
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									<textarea class="st_textarea" name="lperiodCureRmrk" id="lperiodCureRmrk"><c:out value="${result.lperiodCureRmrk}" /></textarea>
								</td>
							</tr>
					</table>
				</c:if>
				
				<c:if test="${enumBizThr == result.bizSeCd }">
					<h4 class="tit">제3국출생 자녀양육 가산금 추가정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">자녀1</th>
								<td>
									<label class="MAL0" for="frstChdrFlnm">이름 : </label>
									<input type="text" name="frstChdrFlnm" id="frstChdrFlnm" value="<c:out value="${result.frstChdrFlnm}" />" class="st_input i_w95" placeholder="">
									<label class="MAL20" for="frstChdrBrdtYmd">생년월일 : </label>
									<input type="text" name="frstChdrBrdtYmd" id="frstChdrBrdtYmd" value="<c:out value="${jtag:convertDateSplitString(result.frstChdrBrdtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">
									<span id="frstChdrSpan"></span>
									<label class="MAL20" for="frstChdrBrthNtnNm">출생국가 : </label>
									<input type="text" name="frstChdrBrthNtnNm" id="frstChdrBrthNtnNm" value="<c:out value="${result.frstChdrBrthNtnNm}" />" class="st_input i_w95" placeholder="">									
								</td>
							</tr>
							<tr>
								<th scope="row">자녀2</th>
								<td>
									<label class="MAL0" for="scndryChdrFlnm">이름 : </label>
									<input type="text" name="scndryChdrFlnm" id="scndryChdrFlnm" value="<c:out value="${result.scndryChdrFlnm}" />" class="st_input i_w95" placeholder="">
									<label class="MAL20" for="scndryChdrBrdtYmd">생년월일 : </label>
									<input type="text" name="scndryChdrBrdtYmd" id="scndryChdrBrdtYmd" value="<c:out value="${jtag:convertDateSplitString(result.scndryChdrBrdtYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">
									<span id="scndryChdrSpan"></span>
									<label class="MAL20" for="scndryChdrBrthNtnNm">출생국가 : </label>
									<input type="text" name="scndryChdrBrthNtnNm" id="scndryChdrBrthNtnNm" value="<c:out value="${result.scndryChdrBrthNtnNm}" />" class="st_input i_w95" placeholder="">									
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td>
									<textarea class="st_textarea" name="chdrNtreRmrk" id="chdrNtreRmrk"><c:out value="${result.chdrNtreRmrk}" /></textarea>
								</td>
							</tr>
						</table>
					</c:if>
						
					<h4 class="tit">지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">지급 결정일</th>
								<td>
									<input type="text" name="giveDcsnYmd" id="giveDcsnYmd" value="<c:out value="${jtag:convertDateSplitString(result.giveDcsnYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">									
								</td>
							</tr>
							<tr>
								<th scope="row">최초결정액</th>
								<td>
									<input type="text" onkeyup="fnCalRndAmt()" name="frstDcsnAmt" id="frstDcsnAmt" value="<c:out value="${result.frstDcsnAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder="">
									원									
								</td>
							</tr>
							<tr>
								<th scope="row">지급시작 종료 연월</th>
								<td>
									<input type="text" name="giveBgngYm" id="giveBgngYm" value="<c:out value="${jtag:convertDateSplitString(result.giveBgngYm,'-')}" />" class="st_input i_w95 ym_style" placeholder="yyyy-mm">
									~
									<input type="text" name="giveEndYm" id="giveEndYm" value="<c:out value="${jtag:convertDateSplitString(result.giveEndYm,'-')}" />" class="st_input i_w95 ym_style" placeholder="yyyy-mm">
									
									<label class="MAL20" for="totGiveNmtm">총지급횟수 : </label>
									<select id="totGiveNmtm" name="totGiveNmtm" class="st_select">
									<c:forEach begin="1" end="16" var="i">
										<option value="${i }"${i == result.totGiveNmtm?' selected':'' }>${i }</option>
									</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">계좌정보</th>
								<td>
									<select name="bacntBankCd" id="bacntBankCd" class="st_select">
										<option value="">은행선택</option> 
									<c:forEach var="cd" items="${bankCdList }" varStatus="status">
										<option value="<c:out value="${cd.indivCd}" />" ${cd.indivCd == result.bacntBankCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
									</c:forEach>
									</select>
									<label class="MAL20" for="actno">계좌번호 : </label>
									<input type="text" name="actno" id="actno" value="<c:out value="${result.actno}" />" class="st_input ">
									<label class="MAL20" for="dpstr">예금주 : </label>
									<input type="text" name="dpstr" id="dpstr" value="<c:out value="${result.dpstr}" />" class="st_input ">
								</td>
							</tr>
						</table>
						
						
					<h4 class="tit">회차별 지원정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:80px;" />
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tbody id="rndTbody">
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5" style="text-align:center"><b>총 지급액:<span id="giveTotalAmt"></span>원 <span class="txt_c_bl">(잔액: <span id="remainTotalAmt"></span>원)</span></b></td>
							</tr>
						</tfoot>
					</table>
					
					
					<h4 class="tit">종결정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
						</colgroup>
							<tr>
								<th scope="row">지급 종료일</th>
								<td>
									<input type="text" name="giveTrmnYmd" id="giveTrmnYmd" value="<c:out value="${jtag:convertDateSplitString(result.giveTrmnYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">									
								</td>
							</tr>
							<tr>
								<th scope="row">종결사유</th>
								<td>
									<textarea class="st_textarea" name="trmnRsn" id="trmnRsn"><c:out value="${result.trmnRsn}" /></textarea>
								</td>
							</tr>
					</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>

<table style="display:none">
	<tbody id="rndDiv">
	<tr>
		<th scope="row">@cnt@회</th>
		<th>지급 연월</th>
		<td>
			<input type="text" name="rndYm@cnt@" id="rndYm@cnt@" value="" class="st_input i_w95 ym_style" placeholder="yyyy-mm">
		</td>
		<th>지급액</th>
		<td>
			<input type="text" name="rndAmt@cnt@" id="rndAmt@cnt@" value="" onkeyup="fnChangeRndAmt(this)" class="st_input i_w95 number_nocomma_style" placeholder="">
			원
		</td>
	</tr>
	</tbody>
</table>
</div>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
