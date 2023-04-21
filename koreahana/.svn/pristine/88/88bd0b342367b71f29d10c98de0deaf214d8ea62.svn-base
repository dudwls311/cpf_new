<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><form id="writeForm" action="?" method="post" enctype="multipart/form-data">
	<input type="hidden" name="kmMode" value="writeActionJson">
	<input type="hidden" id="mbrId" name="mbrId" value="">

					<h4 class="tit">정보</h4>
					<table class="table_style table_t_left th_v_m">
						<colgroup>
							<col style="width:140px;">
							<col>
						</colgroup>
							<tbody><tr>
								<th scope="row"><label class="MAL0" for="typeId">권한구분</label> <span class="imp_st">*</span></th>
								<td>
								
									<input type="radio" name="typeId" value="30020" id="typeId0" class="st_radio">
									<label for="typeId0">최고관리자</label>
								
									<input type="radio" name="typeId" value="30033" id="typeId1" class="st_radio">
									<label for="typeId1">재단직원</label>
								
									<input type="radio" name="typeId" value="30034" id="typeId2" class="st_radio">
									<label for="typeId2">센터상담사</label>
								
									<input type="radio" name="typeId" value="30035" id="typeId3" class="st_radio">
									<label for="typeId3">북한이탈주민</label>
								
									<input type="radio" name="typeId" value="30036" id="typeId4" class="st_radio">
									<label for="typeId4">일반사용자</label>
								
								</td>
							</tr>
							<tr id="orgIdTr" style="display:none">
								<th scope="row"><label class="MAL0" for="mbrNm">소속</label> <span class="imp_st">*</span></th>
								<td>
									<select id="orgId" name="orgId" class="st_select">
									
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrNm">이름</label> <span class="imp_st">*</span></th>
								<td>
									<input type="text" name="mbrNm" id="mbrNm" value="" class="st_input input_long" placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="mbrLogin">아이디</label> <span class="imp_st">*</span></th>
								<td>
								
									
									
										<input type="hidden" id="chkId" value="">    
										<div class="clear_box">                          
											<input type="text" name="mbrLogin" id="mbrLogin" value="" class="st_input " placeholder="">
											<a class="btn_st" onclick="fnIdCheck();return false;">아이디 중복확인</a>
										</div>
									
								
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="passwd">비밀번호</label> <span class="imp_st">*</span></th>
								<td>
									<input type="text" name="passwd" id="passwd" value="" class="st_input " placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="tel">연락처</label> </th>
								<td>
									<input type="text" name="tel" id="tel" value="" class="st_input" placeholder="">
								</td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="zip">주소</label> </th>
								<td>
								<div class="">
									<input type="text" name="zip" id="zip" value="" class="st_input " placeholder="">
									<a class="btn_st btn_c_bk " href="#" onclick="fnAddr();return false;">주소 검색</a>
									<input type="text" name="aa11" id="aa11" value="서울특별시 마포구 새창로 7" class="st_input input_long  MAB5  MAT5">
									<input type="text" name="aa11" id="aa11" value="5011호" class="st_input input_long ">
								</div>
                                      </td>
							</tr>
							<tr>
								<th scope="row"><label class="MAL0" for="expireDate">만료일자</label> </th>
								<td>
									<input type="text" name="expireDate" id="expireDate" value="" class="st_input i_w95 date_style hasDatepicker" placeholder="" maxlength="10">
									<p class="txt_c_bl br">만료일자를 설정할 경우 만료일자 이후로는 계정이 비활성화됩니다.<br>초기화 할 경우 만료일이 제한없이 계정이 활성화 됩니다.</p>
								</td>
							</tr>

					</tbody></table>

					
					<div class="btn_g_btm">
					
						<a href="/support/hn_set/user/list/" class="btn_st btn_c_gr btn_s_big" type="button" id="saveBtn">저장</a>
					
					<a href="/support/hn_set/user/list/" class="btn_st btn_s_big" type="button" id="cancelBtn">취소</a>
					</div>
</form><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>