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
		<div class="box_w_agree">
			<p class="bea_txt">「북한이탈주민의 보호 및 정착지원에 관한 법률 시행령」 제39조제5항 및 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제6조제3항에 따라 가산금 지급을 신청합니다.
		</p>
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'sho' }">
		<div class="box_w_agree">
			<p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 장학금을 신청합니다.</p>
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'edu' }">
		<div class="box_w_agree">
			<p class="bea_txt">위 작성(등록)한 내용은 모두 사실임을 확인하며 「북한이탈주민의 보호 및 정착지원에 관한 법률 시행규칙」 제8조의2제4항에 따라 위와 같이 교육지원 보조금의 지급을 신청합니다.</p>
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>대학교 총(학)장
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'vdo' }">
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
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			
			<c:if test="${result.aplcntType == enumNtkPrt || result.aplcntType == enumNorPrt }">
				<div class="agree_sign">
					<div class="name">법정대리인
						<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.prtcrSgntrFlnm }" /></span>
						<p>인
							<c:if test="${not empty prtcrSgnResult }">
								<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(prtcrSgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
							</c:if>
						</p>
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
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">신청인 
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<div class="agree_sign">
				<div class="name">법정대리인
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.prtcrSgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty prtcrSgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(prtcrSgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
		
		<p class="box_w_wht">※정보주체가 만14세 미만의 아동인 경우, 개인정보보호법 제22조에 의거 법정대리인의 동의를 받습니다.</p>
	</c:when>
	
	<c:when test="${sgnType == 'spf' }">
		<div class="box_w_agree">
			<p class="bea_txt">「정착지원전문관리사」 자격시험에 응시하고자 응시원서를 제출합니다.</p>
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:when test="${sgnType == 'emp' }">
		<div class="box_w_agree">
			<p class="bea_txt">상기 본인은 공고문에 제시된 ‘<c:out value="${bizSeCdName }" />양성과정’ 모집내용을 정확히 인지하였으며, 위 기재사실 및 제출서류에 허위가 있는 경우 선정이 취소될 수 있으며, 제출한 서류는 일체 반환하지 않습니다.</p>
			<p class="date"><fmt:formatDate value="${result.regDt }" pattern="yyyy년 MM월 dd일"/></p>
			<div class="agree_sign">
				<div class="name">
					<span class="MAR20">신청인</span><span class="MAR20"><c:out value="${result.sgntrFlnm }" /></span>
					<p>인
						<c:if test="${not empty sgnResult }">
							<img src="<c:url value="${sgnViewUrl }${jtag:sprtFileViewEncode(sgnResult.atchFileSn, result.sprtSn)}" />" alt="서명파일 이미지" />
						</c:if>
					</p>
				</div>
			</div>
			<p class="bea_txt02">북한이탈주민지원재단 이사장 귀하</p>
		</div>
	</c:when>
	
	<c:otherwise></c:otherwise>
</c:choose>
