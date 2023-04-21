<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<script type="text/javascript" src="/resources/js/exts/koreahana/fth/fthMdwWrite.js"></script>

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
	<input type="hidden" name="kfmMode" value="view" />
	<input type="hidden" name="fthpbbMdwCncltnSn" value="<c:out value="${result.fthpbbMdwCncltnSn }" />" />
</form>

<form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kfmMode" value="writeActionJson" />
	<input type="hidden" id="fthpbbMdwCncltnSn" name="fthpbbMdwCncltnSn" value="<c:out value="${result.fthpbbMdwCncltnSn }" />" />

					<h4 class="tit">신청자(지원대상자) 기본 정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;" />
							<col />
							<col style="width:140px;" />
							<col />
						</colgroup>
						<tr>
							<th><label class="MAL0" for="flnm">성명</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="flnm" id="flnm" value="<c:out value="${result.flnm}" />" class="st_input" placeholder="성명">
								<%-- 
								<label for="genderCd0" class="comment">성별</label>
							<c:forEach var="cd" items="${genderCdList }" varStatus="status">
								<input type="radio" name="genderCd" value="<c:out value="${cd.indivCd}" />" id="genderCd${status.index }"${cd.indivCd == result.genderCd?' checked="checked"':'' } class="st_radio">
								<label for="genderCd${status.index }"><c:out value="${cd.indivCdNm}" /></label>
							</c:forEach>
							 --%>
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
							<th scope="row"><label class="MAL0" for="mbphno">연락처</label> <span class="imp_st">*</span></th>
							<td colspan="3">
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
					</table>

					<h4 class="tit">미래행복통장 중도해지 정보</h4>
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
							<th scope="row"><label class="MAL0" for="rcptYmd">해지일자</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="cncltnYmd" id="cncltnYmd" value="<c:out value="${jtag:convertDateSplitString(result.cncltnYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="jrdcHanactNm">관할 하나센터</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="jrdcHanactNm" id="jrdcHanactNm" value="<c:out value="${result.jrdcHanactNm}" />" class="st_input " placeholder="">
							</td>
							<th scope="row"><label class="MAL0" for="hanactPic">하나센터 담당자</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="hanactPic" id="hanactPic" value="<c:out value="${result.hanactPic}" />" class="st_input " placeholder="">
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="bbJoinYmd">통장가입일</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="bbJoinYmd" id="bbJoinYmd" value="<c:out value="${jtag:convertDateSplitString(result.bbJoinYmd,'-')}" />" class="st_input i_w95 date_style" placeholder="">						
							</td>
							<th scope="row"><label class="MAL0" for="joinPeriodMmCnt">가입기간</label></th>
							<td>
								<input type="text" name="joinPeriodMmCnt" id="joinPeriodMmCnt" value="<c:out value="${result.joinPeriodMmCnt}" />" class="st_input i_w95 number_nocomma_style" placeholder="">
								개월						
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="dcsnSprtAmt">해지사유</label> <span class="imp_st">*</span></th>
							<td colspan="3">
								<select id="cncltnRsnCd" name="cncltnRsnCd" class="st_select">
									<option value="">선택</option>
								<c:forEach var="cd" items="${cncltnRsnCdList }" varStatus="status">
									<option value="<c:out value="${cd.indivCd }" />" ${cd.indivCd == result.cncltnRsnCd?' selected':'' } ><c:out value="${cd.indivCdNm }" /></option>
								</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label class="MAL0" for="idtprsSavingAmt">본인적립금(총액기준)</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="idtprsSavingAmt" id="idtprsSavingAmt" value="<c:out value="${result.idtprsSavingAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder="">	원					
							</td>
							<th scope="row"><label class="MAL0" for="fndtSavingAmt">재단적립금(지급액기준)</label> <span class="imp_st">*</span></th>
							<td>
								<input type="text" name="fndtSavingAmt" id="fndtSavingAmt" value="<c:out value="${result.fndtSavingAmt}" />" class="st_input i_w95 number_nocomma_style" placeholder="">	원					
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
