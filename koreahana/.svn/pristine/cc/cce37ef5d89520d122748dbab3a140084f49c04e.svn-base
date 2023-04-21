<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
	<div class="gonggo_s_wrap">
		<div class="box_w_gray">
			<label for="ggst">공고선택</label>
			<select name="pbancrcSn" id="pbancrcSn" class="st_select2" style="width:90%">
				<c:forEach var="pbaResult" items="${pbaList }">
					<option value="<c:out value="${pbaResult.pbancrcSn }" />" <c:out value="${searchVO.pbancrcSn == pbaResult.pbancrcSn ? 'selected' : '' }" />>
						<c:choose>
							<c:when test="${enumPbaBefCd == pbaResult.pbancrcSttsCd || enumPbaUnsCd == pbaResult.pbancrcSttsCd }">접수전</c:when>
							<c:when test="${enumPbaReqCd == pbaResult.pbancrcSttsCd || enumPbaAlwCd == pbaResult.pbancrcSttsCd }">모집중</c:when>
							<c:otherwise><b><c:out value="${jtag:getCdNm(pbancrcSttsCdList,pbaResult.pbancrcSttsCd)}" /></b></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pbaResult.pbancrcSttsCd == enumPbaUnsCd}">(접수전)</c:when>
							<c:when test="${pbaResult.pbancrcSttsCd == enumPbaAlwCd}">(상시모집)</c:when>
							<c:otherwise>(<fmt:formatDate value="${pbaResult.pbancrcBgngDt}" pattern="${dateFormat }" /><br /> ~ <fmt:formatDate value="${pbaResult.pbancrcEndDt}" pattern="${dateFormat }" />)</c:otherwise>
						</c:choose>
						<c:out value="${pbaResult.pbancrcNm }" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
