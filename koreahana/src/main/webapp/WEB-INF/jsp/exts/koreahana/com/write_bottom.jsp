<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<div class="btn_g_btm">
					<c:if test="${isStreAuth == true}">
						<button class="btn_st btn_c_gr btn_s_big" type="button" id="saveBtn"><spring:message code="com.btn.save" /></button>
					</c:if>
					<button class="btn_st btn_s_big" type="button" id="cancelBtn"><spring:message code="com.btn.cancleList" /></button>
					</div>