<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<c:if test="${adminPageYn == 'Y' }">
	<c:set var="sgnViewUrl" value="${actionUrl }?${modeName }=sgnView&enc=" />
</c:if>
<c:if test="${adminPageYn != 'Y' }">
	<c:set var="sgnViewUrl" value="/user/exts/koreahana/sgn/index.do?ksMode=sgnView&enc=" />
</c:if>

<c:choose>
	<c:when test="${empty sgnType }">
	
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a></p>
		<div class="box_w_agree">
			<p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.</p>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${empty result ? loginVO.mbrNm : result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>인<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'sho' }">
	
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a></p>
		<div class="box_w_agree">
			<p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 장학금을 신청합니다.</p>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${empty result ? loginVO.mbrNm : result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>인<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'edu' }">
	
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a></p>
		<div class="box_w_agree">
			<p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제8조의2제4항에 따라 위와 같이 교육지원 보조금의 지급을 신청합니다.</p>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>대학교 총(학)장<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'vdo' }">
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<c:if test="${not empty prtcrSgnResult }">
			<input type="hidden" id="prtcrSgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(prtcrSgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${prtcrSgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10">
			<a href="#" class="btn_st btn_ico_pl MAR10" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a>
			<c:if test="${(result.aplcntType == enumNtkPrt || param.aplcntType == enumNtkPrt) || (result.aplcntType == enumNorPrt || param.aplcntType == enumNorPrt) }">
				<a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn('prtcrSgntFileSn');return false;">법정대리인 서명파일 선택</a>
			</c:if>
		</p>
		<div class="box_w_agree">
			<p class="bea_txt">본인은 신청자(보호자)로서 화상영어교육 지원 서비스를 희망하기에 신청서류를 구비하여 제출하며, 대상자로 선발된 이후 수업에 성실히 참여하고 과제를 수행하도록 협조할 것을 약속합니다. 또한 아래의 사항에 해당되는 행위를 하였을 경우, 지원 대상자에서 제외됨을 인지하고 재단 측에 일체의 민‧형사상의 책임을 묻지 않을 것을 서약합니다. 또한 본 동의서에 관하여 충분히 설명을 듣고 이해하였으며, 개인정보 수집‧이용‧제공 하는 것에 동의합니다</p>
			<div class="box_w_wht MAT20 MAB10 AlignLeft">
				<ul>
					<li>① 증빙서류 위조 및 허위신청</li>
					<li>② 강사에 부당한 언행 및 행위 사용</li>
					<li>③ 학습지원 서비스 1개월 내 2회 이상 수업불참</li>
					<li>④ 기타 재단이 서비스 제한이 필요하다 생각되는 경우</li>
					<li>⑤ 개인정보 수집ㆍ이용 동의서 숙지 및 확인</li>
				</ul>
			</div>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인
					<c:choose>
						<c:when test="${(result.aplcntType == enumNtkPrt || param.aplcntType == enumNtkPrt) || (result.aplcntType == enumNorPrt || param.aplcntType == enumNorPrt) }">
							<c:set var="sgntrFlnm" value="" />
						</c:when>
						<c:otherwise>
							<c:set var="sgntrFlnm" value="${empty result ? loginVO.mbrNm : result.sgntrFlnm }" />
						</c:otherwise>
					</c:choose>
					 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>인<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<c:if test="${(result.aplcntType == enumNtkPrt || param.aplcntType == enumNtkPrt) || (result.aplcntType == enumNorPrt || param.aplcntType == enumNorPrt) }">
				<div class="agree_sign">
					<div class="name">법정대리인
						<input type="text" name="prtcrSgntrFlnm" id="prtcrSgntrFlnm" value="<c:out value="${empty result ? loginVO.mbrNm : result.prtcrSgntrFlnm }" />" placeholder="이름" class="st_input i_w95 MAR20">
						<p>인<span id="prtcrSgntFileSnSpan"></span></p>
					</div>
				</div>
			</c:if>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
		
		<c:if test="${(result.aplcntType == enumNtkPrt || param.aplcntType == enumNtkPrt) || (result.aplcntType == enumNorPrt || param.aplcntType == enumNorPrt) }">
			<p class="box_w_wht">※정보주체가 만14세 미만의 아동인 경우, 개인정보보호법 제22조에 의거 법정대리인의 동의를 받습니다.</p>
		</c:if>
	</c:when>
	
	<c:when test="${sgnType == 'lnb' }">
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<c:if test="${not empty prtcrSgnResult }">
			<input type="hidden" id="prtcrSgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(prtcrSgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${prtcrSgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10">
			<a href="#" class="btn_st btn_ico_pl MAR10" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a>
			<a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn('prtcrSgntFileSn');return false;">법정대리인 서명파일 선택</a>
		</p>
		<div class="box_w_agree">
			<p class="bea_txt">본인은 신청자(보호자)로서 학습지원 서비스를 희망하기에 신청서류를 구비하여 제출하며, 대상자로 선발된 이후 수업에 성실히 참여하고 과제를 수행하도록 협조할 것을 약속합니다. 또한 아래의 사항에 해당되는 행위를 하였을 경우, 지원 대상자에서 제외됨을 인지하고 재단 측에 일체의 민‧형사상의 책임을 묻지 않을 것을 서약합니다. 또한 본 동의서에 관하여 충분히 설명을 듣고 이해하였으며, 개인정보 수집‧이용‧제공 하는 것에 동의합니다.</p>
			<div class="box_w_wht MAT20 MAB10 AlignLeft">
				<ul>
					<li>① 증빙서류 위조 및 허위신청</li>
					<li>② 강사에 부당한 언행 및 행위 사용</li>
					<li>③ 학습지원 서비스 1개월 내 2회 이상 수업불참</li>
					<li>④ 기타 재단이 서비스 제한이 필요하다 생각되는 경우</li>
					<li>⑤ 개인정보 수집ㆍ이용 동의서 숙지 및 확인</li>
				</ul>
			</div>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인(자녀)
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>(서명)<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<div class="agree_sign">
				<div class="name">법정대리인(부모)
					<input type="text" name="prtcrSgntrFlnm" id="prtcrSgntrFlnm" value="<c:out value="${empty result ? loginVO.mbrNm : result.prtcrSgntrFlnm }" />" placeholder="이름" class="st_input i_w95 MAR20">
					<p>(서명)<span id="prtcrSgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
		
		<p class="box_w_wht">※정보주체가 만14세 미만의 아동인 경우, 개인정보보호법 제22조에 의거 법정대리인의 동의를 받습니다.</p>
	</c:when>
	
	<c:when test="${sgnType == 'spf' }">
	
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a></p>
		<div class="box_w_agree">
			<p class="bea_txt">「정착지원전문관리사」 자격시험에 응시하고자 응시원서를 제출합니다.</p>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${empty result ? loginVO.mbrNm : result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>인<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'emp' }">
	
		<c:if test="${not empty sgnResult }">
			<input type="hidden" id="sgntFileSnHidden"
								 data-url="<c:url value="${sgnViewUrl }" />" 
								 data-param="<c:out value="${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" 
								 data-fsn="<c:out value="${sgnResult.atchFileSn }" />" 
								 data-sgntnm="서명" />
		</c:if>
		
		<p class="AlignRight  MAB10"><a href="#" class="btn_st btn_ico_pl" onclick="ComFns.openMySgn();return false;">서명 파일 선택</a></p>
		<div class="box_w_agree">
			<p class="bea_txt">상기 본인은 공고문에 제시된 ‘<c:out value="${bizSeCdName }" />양성과정’ 모집내용을 정확히 인지하였으며, 위 기재사실 및 제출서류에 허위가 있는 경우 선정이 취소될 수 있으며, 제출한 서류는 일체 반환하지 않습니다.</p>
			<p class="date"><fmt:formatDate value="${empty result ? today : result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<input type="text" id="sgntrFlnm" name="sgntrFlnm" value="<c:out value="${result.sgntrFlnm }" />" placeholder="이름"  class="st_input i_w95 MAR20" required="required" />
					<p>인<span id="sgntFileSnSpan"></span></p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:otherwise></c:otherwise>
</c:choose>

<%//즐겨찾기 서명호출용 %>
<c:if test="${empty sgnResult }">
	<input type="hidden" id="sgntFileSnHidden" data-url="<c:url value="${sgnViewUrl }" />" data-param="" data-fsn="" data-sgntnm="서명" />
	<input type="hidden" id="prtcrSgntFileSnHidden" data-url="<c:url value="${sgnViewUrl }" />" data-param="" data-fsn="" data-sgntnm="서명" />
</c:if>

<%//서명 파일폼 %>
<div id="sgnFileAppend" style="display: none;">
	<input type="hidden" name="@sgnId@" value="@fsn@" />
	<img src="@url@@param@" alt="@sgntNm@ 이미지" />
</div>