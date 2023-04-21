<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>
<script type="Text/javascript">
$(document).ready(function(){
	$('#btnPhone').on('click',function (){
		window.open('/user/exts/realauth/authPopup.do?authType=nice&sAuthType=M', 'popupChk', 'width=500, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
		return false;		
	});
	$('#btnIpin').on('click',function (){
		window.open('/user/exts/realauth/authPopup.do?authType=niceipin', 'popupChk', 'width=500, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
		return false;
	});
});
</script>
				<div class="ct_recruit confirm">

					<div class="bx_top_info">
						<h2 class="tit">본인인증</h2>
						<p class="txt">휴대전화 또는 아이핀으로 인증 할 수 있습니다.</p>
					</div>
					<!-- end of bx_top_info -->

					<div class="bx_confirm">

						<div class="table">
							<div class="row">
								<div class="cell item">
									<i class="icon_phone ico"></i>
									<dl class="txt">
										<dt>휴대전화 인증</dt>
										<dd>본인 명의의 휴대전화를 통한 인증입니다.</dd>
									</dl>
									<a id="btnPhone" href="#;" class="btn_df w180">휴대전화 인증하기</a>
								</div>
								<div class="cell item">
									<div class="item">
										<i class="icon_ipin ico"></i>
										<dl class="txt">
											<dt>아이핀 인증</dt>
											<dd>본인 명의의 아이핀을 통한 인증입니다.</dd>
										</dl>
										<a id="btnIpin" href="#;" class="btn_df w180">아이핀 인증하기</a>
									</div>
									<!-- end of item -->
								</div>
							</div>
						</div>


					</div>
					<!-- end of bx_confirm -->

				</div>
				<!-- end of ct_recruit -->