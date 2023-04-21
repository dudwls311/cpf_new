<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<table class="table_style table_t_left th_v_m">
	<colgroup>
		<col width="15%" />
		<col width="*" />
	</colgroup>
	<tbody>
		<c:forEach var="smb" items="${smbList }">
			<c:if test="${fn:contains(smbsnDocTypeVl, smb.smbsnDocTypeVl) || empty smbsnDocTypeVl }">
				<tr>
					<th>
						<c:out value="${smb.smbsnDocNm }" />
						<%-- <c:forEach var="smbDocForm" items="${smbDocFormList }">
							<c:if test="${smb.smbsnDocFormSn == smbDocForm.atchFileSn }">
								<br /><a class="btn_st btn_c_gy" href="#" style="width: 123px; text-align: center;" onclick="fnDocFormDownload('<c:out value="${smb.smbsnDocFormSn }" />');return false;">양식 다운로드</a>
							</c:if>
						</c:forEach> --%>
					</th>
					<td>
						<%-- <c:if test="${smb.smbsnRsn != '' && not empty smb.smbsnRsn }">
							<p class="txt_c_bl br"><c:out value="${smb.smbsnRsn }" /></p>
						</c:if> --%>
						
						<c:set var="smbMpnCount" value="1" />
						<c:forEach var="smbMpn" items="${result.smbMpnList }">
							<c:if test="${smb.smbsnDocSn == smbMpn.smbsnDocSn }">
								<a href="#" class="txt_ico_f" onclick="fnMyFileDownload('<c:out value="${smbMpn.atchFileSn }" />');return false;"><c:out value="${smbMpn.orgnlAtchFileNm }" /></a>
								<c:if test="${smbMpnCount > 0 }"><br /></c:if>
								<c:set var="smbMpnCount" value="${smbMpnCount + 1 }" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>