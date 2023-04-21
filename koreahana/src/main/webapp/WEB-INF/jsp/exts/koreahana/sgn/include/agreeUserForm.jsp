<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<div class="box_w_geain">
	<h4 class="box_w_gray AlignCenter box_s_add">개인정보 수집·이용 동의서</h4>
	<c:if test="${agreeType == 'vdo' }">
		<p class="box_w_wht">우리 재단은「개인정보보호법」에 의거하여, <b>화상영어교육 지원 사업</b> 관련 신청서 접수, 대상자 선정 및 관리와 관련하여 귀하의 개인정보를 아래와 같이 수집․이용․제공을 하고자 합니다. 귀하께서는 아래 내용을 자세히  읽어보시고 모든 내용을 이해하신 후에 동의여부를 결정하여 주시기 바랍니다.</p>
	</c:if>
	<c:if test="${agreeType == 'lnb' }">
		<p class="box_w_wht">북한이탈주민지원재단은 「개인정보 보호법」에 의거하여, <b>학습지원 사업</b> 관련 신청서 접수, 대상자 선정 및 관리와 관련하여 귀하의 개인정보를 아래와 같이 수집‧이용‧제공을 하고자 합니다. 귀하께서는 아래 내용을 자세히 읽어보시고 모든 내용을 이해하신 후에 동의여부를 결정하여 주시기 바랍니다.</p>
	</c:if>
	<c:if test="${agreeType == 'emp' }">
		<p class="box_w_wht">북한이탈주민지원재단은 <b>「취업연계 직업훈련 운영과정」</b> 사업 지원에 필요한 개인정보의 수집‧이용을 위하여 개인정보보호법에 따라 귀하의 동의를 받고자합니다.
		<br />개인정보에 대한 열람, 정정‧삭제, 처리정지, 이의제기 하고자 할 때에는 개인정보보호책임자를 통해 요구 및 개인정보침해 시 개인정보처리방침 권익침해 구제방법을 통해 구제 받을 수 있습니다.</p>
	</c:if>
</div>

<h5 class="tit">개인정보의 수집 및 이용 동의서</h5>

<c:if test="${agreeType == 'vdo' }">
	<div class="box_w_wht box_s_add">
		<p class="p_h5">이용자가 제공한 모든 정보는 다음의 목적을 위해 활용하여, 하기 목적 이외의 용도로는 사용되지 않습니다.</p>
		<h6 class="tit">1. 수집·이용 목적</h6>
		<ul class="ul_st">
			<li>신청자 자격확인 및 대상자 선정</li>
			<li>대상자 연락 및 관리</li>
			<li>기타 화상영어교육 지원 사업 운영에 필요한 업무</li>
			<li>설문조사 및 고객만족도 조사를 통한 재단 하나센터 상담 · 유관기관 자원 연계</li>
			<li>북한이탈주민 취업관리 시스템 회원가입 및 취업지원 서비스 (자립지원부)</li>
		</ul>
		<h6 class="tit">2. 수집·이용할 항목 (필수항목)</h6>
		<ul class="ul_st">
			<li>성명, 생년월일, 하나원 기수(해당자), 출생지, 주소, 연락처, 소속(해당자)</li>
			<li>보호자명, 보호자 하나원 기수, 보호자 연락처, 대상자와의 관계</li>
			<li>대상자 선정 및 관리와 관련 가족관계 확인이 필요한 서류 <br />&nbsp;&nbsp;&nbsp;:주민등록등본, 북한이탈주민등록확인서, 국민기초생활수급자증명서(해당시), 한부모가정확인서</li>
		</ul>
		<p class="p_h6">※ 주민등록번호는 「북한이탈주민의 보호 및 정착지원에 관한법률 시행령」 제49조의2(고유식별정보의 처리)에 따라 별도 수집합니다.</p>
	
		<h6 class="tit">3. 보유·이용 기간 : <b class="txt_c_bl">5</b>년</h6>
		<p class="p_h6"><b>※ 귀하께서는 본 안내에 따른 개인정보 수집․이용에 대하여 동의를 거부하실 권리가 있습니다. 다만, 귀하가 개인정보의 수집․이용에 동의를 거부하시는 경우에 대상자 선정에 있어 불이익이 발생할 수 있음을 알려드립니다.</b></p>
	</div>
</c:if>
<c:if test="${agreeType == 'lnb' }">
	<div class="box_w_wht box_s_add">
		<h6 class="tit">1. 수집·이용 목적</h6>
		<ul class="ul_st">
			<li>신청자 자격확인, 대상자 선정 및 대상자 지원내역 조회</li>
			<li>대상자 연락 및 관리</li>
			<li>기타 학습지원 사업 운영에 필요한 업무</li>
			<li>설문조사 및 고객만족도 조사를 통한 재단 하나센터 상담 · 유관기관 자원 연계</li>
		</ul>
		<h6 class="tit">2. 수집·이용할 항목 (필수항목)</h6>
		<ul class="ul_st">
			<li>(보호자) 성명, 생년월일, 연락처(전화, 휴대폰), 하나원 기수, 대상자와의 관계, 주소, 세대주명</li>
			<li>(학습대상자) 성명, 생년월일, 출생지</li>
			<li>대상자 선정 및 관리와 관련 가족관계 확인이 필요한 서류 <br />&nbsp;&nbsp;&nbsp;: 주민등록등본, 북한이탈주민등록확인서, 국민기초생활수급자증명서(해당시), 한부모가정확인서</li>
		</ul>
		<p class="p_h6">※ 주민등록번호는 「북한이탈주민의 보호 및 정착지원에 관한법률 시행령」 제49조의2(고유식별정보의 처리)에 따라 별도 수집합니다.</p>
	
		<h6 class="tit">3. 보유·이용 기간 : <b class="txt_c_bl">5</b>년</h6>
		<p class="p_h6"><b>※ 귀하께서는 본 안내에 따른 개인정보 수집․이용에 대하여 동의를 거부하실 권리가 있습니다. 다만, 귀하가 개인정보의 수집․이용에 동의를 거부하시는 경우에 대상자 선정에 있어 불이익이 발생할 수 있음을 알려드립니다.</b></p>
	</div>
</c:if>
<c:if test="${agreeType == 'emp' }">
	<div class="box_w_wht box_s_add">
		<h6 class="tit">1. 개인정보의 수집·이용 목적</h6>
		<ul class="ul_st">
			<li>교육서비스 제공, 본인확인, 구직시스템 등록, 자격 검토, 사후관리</li>
		</ul>
		<h6 class="tit">2. 수집·이용할 항목 (필수항목)</h6>
		<ul class="ul_st">
			<li>필수항목 : 성명, 생년월일, 성별, 주소, 하나원 수료연도 및 수료기수, 최종학력, 연락처, 직장경험, 자격사항, 지원동기, 취업포부, 북한이탈주민등록확인서, 취업확인서(재직증명서 포함), 해당과정 요구하는 자격증 사본, 신분증사본, 통장사본
			<br />&nbsp;&nbsp;&nbsp;※ 주민등록번호는 「북한이탈주민의 보호 및 정착지원에 관한법률」제30조(북한이탈주민지원재단) 및 「북한이탈주민의 보호 및 정착지원에 관한법률 시행령」 제49조의2(고유식별정보의 처리 제2항에 따라 처리하기 위하여 수집합니다.</li>
		</ul>
		<h6 class="tit">3. 보유·이용 기간 : <b class="txt_c_bl">3</b>년</h6>
		<h6 class="tit">4. 동의를 거부할 권리 및 동의를 거부할 경우 불이익에 관한 사항</h6>
		<ul class="ul_st">
			<li>귀하는 개인정보의 수집‧이용에 대한 동의를 거부할 수 있으며, 동의 후에도 언제든지 철회 가능합니다. 단, 동의 거부 시 수집‧이용 목적과 관련된 직업훈련 지원이 제한됩니다.</li>
		</ul>
	</div>
</c:if>

<input type="checkbox" id="collectAgreeYn" name="collectAgreeYn" value="Y" class="st_t_check02" />
<label for="collectAgreeYn" class="MAB30" style="width: 100%;">✓ 동의함</label>

<h5 class="tit">개인정보의 제3자 제공 동의</h5>
<c:if test="${agreeType == 'vdo' }">
	<div class="box_w_wht box_s_add">
		<ul class="ul_st">
			<li>제공받는 자 : <b class="txt_c_bl">통일부, 지역적응센터, 풀브라이트(한미위원단)</b></li>
			<li>제공목적 : <b class="txt_c_bl">화상영어 대상자 지원내역 조회,상담 및 서비스 연계 · 지원</b></li>
			<li>제공항목 : 성명, 생년월일, 주소, 연락처, 하나원기수</li>
			<li>보유 기간 : <b class="txt_c_bl">5년</b></li>
		</ul>
		<p class="p_h6">
			<b>※ 주민등록번호는 「북한이탈주민의 보호 및 정착지원에 관한법률 시행령」 제49조의2(고유식별정보의 처리)에 따라 별도 수집합니다.<br />
			   ※ 귀하께서는 본 안내에 따른 개인정보 제공‧조회에 대하여 동의를 거부하실 권리가 있습니다. 다만, 개인정보의 제공에 동의를 거부하시는 경우에 대상자 선정 과정에 있어 불이익이 발생할 수 있음을 알려드립니다.</b>
		</p>
	</div>
</c:if>
<c:if test="${ agreeType == 'lnb' }">
	<div class="box_w_wht box_s_add">
		<ul class="ul_st">
			<li>제공받는 자 : <b class="txt_c_bl">통일부, 지역적응센터</b></li>
			<li>제공목적 : <b class="txt_c_bl">학습지 대상자 지원내역 조회, 상담 및 서비스 연계 · 지원</b></li>
			<li>제공항목 : 성명, 생년월일, 주소, 연락처, 하나원기수</li>
			<li>보유 기간 : <b class="txt_c_bl">5년</b></li>
		</ul>
		<p class="p_h6">
			<b>※ 주민등록번호는 「북한이탈주민의 보호 및 정착지원에 관한법률 시행령」 제49조의2(고유식별정보의 처리)에 따라 별도 수집합니다.<br />
			   ※ 귀하께서는 본 안내에 따른 개인정보 제공‧조회에 대하여 동의를 거부하실 권리가 있습니다. 다만, 개인정보의 제공에 동의를 거부하시는 경우에 대상자 선정 과정에 있어 불이익이 발생할 수 있음을 알려드립니다.
			</b>
		</p>
	</div>
</c:if>
<c:if test="${ agreeType == 'emp' }">
	<div class="box_w_wht box_s_add">
		<ul class="ul_st">
			<li>제공받는 자 : <b class="txt_c_bl">해당 과정 운영 기관</b></li>
			<li>개인정보 제공 항목<br />&nbsp;&nbsp;&nbsp;성명, 생년월일, 성별, 주소, 하나원 수료연도 및 수료기수, 최종학력, 연락처, 직장경험, 자격사항, 지원동기, 취업포부,해당과정 요구하는 자격증 사본</li>
			<li>제공받는자의 보유 이용목적 : <b class="txt_c_bl">교육서비스 제공 및 취업연계</b></li>
			<li>보유 기간 : <b class="txt_c_bl">3년  ※ 버스운전기사양성과정의 경우 영구</b></li>
			<li>동의를 거부할 권리 및 거부 시 불이익에 관한 사항<br />귀하는 개인정보 제3자 제공대한 동의를 거부할 수 있으며, 동의 후에도 언제든지 철회 가능합니다. 동의 거부 시 직업훈련 지원이 제한될 수 있습니다.</li>
		</ul>
	</div>
</c:if>
<input type="checkbox" id="thirdPartyAgreeYn" name="thirdPartyAgreeYn" value="Y" class="st_t_check02" />
<label for="thirdPartyAgreeYn" class="MAB30" style="width: 100%;">✓ 동의함</label>