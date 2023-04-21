<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<div>
	<input type="hidden" id="maxSort" value="0"/>
	<input type="hidden" id="smbsnDocTypeVl" />
	<input type="hidden" id="deleteSmbsnDocSn"/>
	<input type="hidden" id="deleteSmbsnDocTypeSn"/>
	<input type="hidden" id="deleteSmbsnDocFormSn"/>
	<input type="hidden" id="deleteSmbsnDocTypeVl" />
	
	<input type="hidden" id="smbTypJSON" value="<c:out value="${jtag:convertObjectToJson(smbTypList) }" />" />	
	<input type="hidden" id="smbJSON" value="<c:out value="${jtag:convertObjectToJson(smbList) }" />" />
	<input type="hidden" id="smbFileJSON" value="<c:out value="${jtag:convertObjectToJson(smbFileList) }" />" />
	
	<c:choose>
		<c:when test="${searchVO.pbancrcCtgryFrstCd == enumFrsSho }">
			<%//장학금 %>
			<c:set var="smbDocNmVar" value="대학원생제출서류,대학생(일반/전문/사이버),계절학기(일반),중고등학생,검정고시합격자" />
			<c:set var="smbDocNmVar1" value="ntkrdf" />
			<c:set var="smbDocNmVar2" value="thirdcnty" />
		
			<h4 class="tit">장학금 선발유형</h4>
			<c:if test="${not empty searchVO.pbancrcSn }">해당 공고문에 이미 제출된 신청서가 있을 경우 제출서류 내용을 수정/삭제/추가하시면 사후 관리에 문제가 될 수 있으니 주의해주세요.</c:if>
			<table class="table_style thd_v_m">
				<colgroup>
					<col width="*">
					<col width="17%">
					<col width="17%">
					<col width="17%">
					<col width="17%">
					<col width="17%">
				</colgroup>
				<thead>
					<tr>
						<th>선발유형</th>
						<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
							<th><c:out value="${smbDocNm }" /></th>
						</c:forTokens>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>북한이탈주민</th>
						<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
							<c:set var="smbDocVal" value="${smbDocNmVar1 }${smbDocNmStatus.count }" />
							<td><input type="checkbox" class="st_check02" id="<c:out value="${smbDocVal }Chk" />" value="<c:out value="${smbDocVal }" />" onclick="fnSmbDocToggle(<c:out value="'${smbDocVal }', 'Y'" />);"><label for="<c:out value="${smbDocVal }" />">&nbsp;</label></td>
						</c:forTokens>
					</tr>
					<tr>
						<th>제3국 출생</th>
						<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
							<c:set var="smbDocVal" value="${smbDocNmVar2 }${smbDocNmStatus.count }" />
							<td><input type="checkbox" class="st_check02" id="<c:out value="${smbDocVal }Chk" />" value="<c:out value="${smbDocVal }" />" onclick="fnSmbDocToggle(<c:out value="'${smbDocVal }', 'Y'" />);"><label for="<c:out value="${smbDocVal }" />">&nbsp;</label></td>
						</c:forTokens>
					</tr>
				</tbody>
			</table>
			
			<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
				<c:set var="smbDocVal" value="${smbDocNmVar1 }${smbDocNmStatus.count }" />
				<div id="<c:out value="${smbDocVal }Div" />" style="display: none;">
					<h4 class="tit"><c:out value="[북한이탈주민]${smbDocNm }" /></h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col width="7%">
							<col width="10%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody id="<c:out value="${smbDocVal }Tbody" />"></tbody>
					</table>
					<div class="MAT-20"><a href="#" class="btn_st btn_c_sc02 btn_s_long" onclick="fnSmbDocFormAdd(<c:out value="'${smbDocVal }'" />);return false;"><img src="/support/img/common/btn_r_plus.png" alt=""> 제출서류 항목 추가</a></div>
				</div>
			</c:forTokens>
			<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
				<c:set var="smbDocVal" value="${smbDocNmVar2 }${smbDocNmStatus.count }" />
				<div id="<c:out value="${smbDocVal }Div" />" style="display: none;">
					<h4 class="tit"><c:out value="[제3국 출생]${smbDocNm }" /></h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col width="7%">
							<col width="10%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody id="<c:out value="${smbDocVal }Tbody" />"></tbody>
					</table>
					<div class="MAT-20"><a href="#" class="btn_st btn_c_sc02 btn_s_long" onclick="fnSmbDocFormAdd(<c:out value="'${smbDocVal }'" />);return false;"><img src="/support/img/common/btn_r_plus.png" alt=""> 제출서류 항목 추가</a></div>
				</div>
			</c:forTokens>
		</c:when>
		<c:otherwise>
			<!-- <button class="btn_st btn_c_sc02" onclick="fnSmbTemplateCall('type2');return false;">템플릿 유형1</button> -->
			<c:set var="smbDocNmVar" value="미사용" />
			<c:set var="smbDocNmVar1" value="none" />
			
			<c:forTokens var="smbDocNm" items="${smbDocNmVar }" delims="," varStatus="smbDocNmStatus">
				<c:set var="smbDocVal" value="${smbDocNmVar1 }${smbDocNmStatus.count }" />
				<input type="hidden" name="smbsnDocTypeVl" value="<c:out value="${smbDocVal }" />">
				<input type="checkbox" id="<c:out value="${smbDocVal }Chk" />" value="<c:out value="${smbDocVal }" />" onclick="fnSmbDocToggle(<c:out value="'${smbDocVal }'" />);" checked="checked" style="display: none;" />
				<div id="<c:out value="${smbDocVal }Div" />">
					<h4 class="tit">제출서류</h4>
					<c:if test="${not empty searchVO.pbancrcSn }">해당 공고문에 이미 제출된 신청서가 있을 경우 제출서류 내용을 수정/삭제/추가하시면 사후 관리에 문제가 될 수 있으니 주의해주세요.</c:if>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col width="7%">
							<col width="10%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody id="<c:out value="${smbDocVal }Tbody" />"></tbody>
					</table>
					<div class="MAT-20"><a href="#" class="btn_st btn_c_sc02 btn_s_long" onclick="fnSmbDocFormAdd(<c:out value="'${smbDocVal }'" />);return false;"><img src="/support/img/common/btn_r_plus.png" alt=""> 제출서류 항목 추가</a></div>
				</div>
			</c:forTokens>
		</c:otherwise>
	</c:choose>
</div>