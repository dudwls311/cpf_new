<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthNewWrite.js"></script>

<form id="listPageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
</form>
<form id="viewPageForm" action="?">
	<input type="hidden" name="rcptYear" value="<c:out value="${searchVO.rcptYear }" />" />
	<input type="hidden" name="searchCondition" value="<c:out value="${param.searchCondition }" />" />
	<input type="hidden" name="searchKeyword" value="<c:out value="${param.searchKeyword }" />" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex }" />" />
	<input type="hidden" name="kfnMode" value="view" />
	<input type="hidden" name="fthpbbNewAplySn" value="<c:out value="${result.fthpbbNewAplySn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kfnMode" value="writeActionJson" />
	<input type="hidden" id="fthpbbNewAplySn" name="fthpbbNewAplySn" value="<c:out value="${result.fthpbbNewAplySn }" />" />

					<h4 class="tit">신청자(지원대상자) 기본 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="flnm">성명/성별</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="flnm" id="flnm" value="<c:out value="${result.flnm}" />" class="st_input" placeholder="성명">
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							</td>
							<th scope="row"><label class="MAL0" for="flnm">주민번호</label> <span class="imp_st">*</span></th>
							<td>
								<input type="hidden" name="rrno" id="rrno" value="" >
								<input type="text" name="rrno1" id="rrno1" value="<c:out value="${fn:substring(result.rrno,0,6)}" />" class="st_input i_w95 number_nocomma_style" placeholder="" maxlength="6">
								-
								<input type="text" name="rrno2" id="rrno2" value="<c:out value="${fn:substring(result.rrno,6,13)}" />" class="st_input i_w95 number_nocomma_style" placeholder="" maxlength="7">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ageCd">연령대</label> <span class="imp_st">*</span></th>
							<td>
								<select id="ageCd" name="ageCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${ageCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.ageCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> <span class="imp_st">*</span></th>
							<td>
								<c:set var="mbphnoSplit" value="${fn:split(result.mbphno,'-')}" />
								<input type="hidden" name="mbphno" id="mbphno" value="" >
								<select id="mbphnoSplit0" name="mbphnoSplit0" class="st_select">
								<c:forEach var="cd" items="${frontOfPhone }" varStatus="status">
									<option value="<c:out value="${cd}" />" ${cd == mbphnoSplit[0]?' selected':'' } ><c:out value="${cd }" /></option>
								</c:forEach>
								<c:forEach var="cd" items="${frontOfTel }" varStatus="status">
									<option value="<c:out value="${cd}" />" ${cd == mbphnoSplit[0]?' selected':'' } ><c:out value="${cd }" /></option>
								</c:forEach>
								</select>
								-
								<input type="text" name="mbphnoSplit1" id="mbphnoSplit1" value="<c:out value="${mbphnoSplit[1]}" />" class="st_input i_w95" maxlength="4">
								-
								<input type="text" name="mbphnoSplit2" id="mbphnoSplit2" value="<c:out value="${mbphnoSplit[2]}" />" class="st_input i_w95" maxlength="4">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ctpvCd">시도</label> <span class="imp_st">*</span></th>
							<td>
								<select id="ctpvCd" name="ctpvCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${ctpvCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.ctpvCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>					
							</td>
							<th scope="row"><label class="MAL0" for="sggCd">군구</label> <span class="imp_st">*</span></th>
							<td>
								<select id="sggCd" name="sggCd" class="st_select">
								</select>
								<spring:eval expression="T(exts.com.enums.EnumGrpCd).SGG_CD.getCode()" var="enum_sggCd" />
								<input type="hidden" id="enum_sggCd" value="<c:out value="${enum_sggCd}" />">
								<input type="hidden" id="or_sggCd" value="<c:out value="${result.sggCd}" />">						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="ecnmatCd">경제활동</label> <span class="imp_st">*</span></th>
							<td>
								<select id="ecnmatCd" name="ecnmatCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${ecnmatCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.ecnmatCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
							<th scope="row"><label class="MAL0" for="crCd">직업군</label></th>
							<td>
								<select id="crCd" name="crCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${crCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.crCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="coNm">회사명</label></th>
							<td>
								<input type="text" name="coNm" id="coNm" value="<c:out value="${result.coNm}" />" class="st_input " placeholder="">						
							</td>
							<th scope="row"><label class="MAL0" for="emplisJoinYmd">고용보험가입일</label></th>
							<td>
								<input type="text" name="emplisJoinYmd" id="emplisJoinYmd" value="<c:out value="${jtag:convertDateSplitString(result.emplisJoinYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="salaryAmt">월급여액</label></th>
							<td>
								<input type="text" name="salaryAmt" id="salaryAmt" value="<c:out value="${result.salaryAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder="">	원					
							</td>
							<th scope="row"><label class="MAL0" for="entcnyYmd">입국일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="entcnyYmd" id="entcnyYmd" value="<c:out value="${jtag:convertDateSplitString(result.entcnyYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="entiscYmd">사회진출일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="entiscYmd" id="entiscYmd" value="<c:out value="${jtag:convertDateSplitString(result.entiscYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
							<th scope="row"><label class="MAL0" for="trinsExpryYmd">보호기간만료일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="trinsExpryYmd" id="trinsExpryYmd" value="<c:out value="${jtag:convertDateSplitString(result.trinsExpryYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
						</tr>
					</table>

					<h4 class="tit">미래행복통장 신규신청 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th scope="row"><label class="MAL0" for="rcptYmd">접수일자</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="rcptYmd" id="rcptYmd" value="<c:out value="${jtag:convertDateSplitString(result.rcptYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
							<th scope="row"><label class="MAL0" for="jrdcHanactNm">관할 하나센터</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="jrdcHanactNm" id="jrdcHanactNm" value="<c:out value="${result.jrdcHanactNm}" />" class="st_input " placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="dcsnSprtAmt">결정지원액</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<c:set var="dcsnSprtAmtList" value="${fn:split('500000,450000,400000,350000,300000,250000,200000,150000,100000,50000',',') }" />
								<select id="dcsnSprtAmt" name="dcsnSprtAmt" class="st_select">
								<c:forEach var="cd" items="${dcsnSprtAmtList }" varStatus="status">
									<option value="<c:out value="${cd}" />" ${cd == result.dcsnSprtAmt?' selected':'' } ><fmt:formatNumber value="${cd }" /></option>
								</c:forEach>
								</select>
								 원
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bbJoinYmd">통장가입일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="bbJoinYmd" id="bbJoinYmd" value="<c:out value="${jtag:convertDateSplitString(result.bbJoinYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">	
							</td>
							<th scope="row"><label class="MAL0" for="savingDdlnYmd">적립마감일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="savingDdlnYmd" id="savingDdlnYmd" value="<c:out value="${jtag:convertDateSplitString(result.savingDdlnYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">	
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="prtprdExtsnCd">보호기간연장(2년)</label> </th>
							<td colspan="3">
								<select id="prtprdExtsnCd" name="prtprdExtsnCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${prtprdExtsnCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.prtprdExtsnCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="idtprsSavingAmtActno">본인적립금 계좌번호</label></th>
							<td>
								<input type="text" name="idtprsSavingAmtActno" id="idtprsSavingAmtActno" value="<c:out value="${result.idtprsSavingAmtActno}" />" class="st_input " placeholder="">
							</td>
							<th scope="row"><label class="MAL0" for="stmchkActno">정부지원금 계좌번호</label></th>
							<td>
								<input type="text" name="stmchkActno" id="stmchkActno" value="<c:out value="${result.stmchkActno}" />" class="st_input " placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="rmrk">비고</label> </th>
							<td colspan="3">
								<input type="text" name="rmrk" id="rmrk" value="<c:out value="${result.rmrk}" />" class="st_input input_long" placeholder="">
							</td>
						</tr>
					</table>
					<%@ include file="/WEB-INF/jsp/exts/koreahana/com/write_bottom.jsp" %>
</form>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
