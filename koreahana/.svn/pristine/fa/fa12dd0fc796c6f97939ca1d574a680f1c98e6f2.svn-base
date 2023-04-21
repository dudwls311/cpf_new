<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/header.jsp" %>
<%@ include file="/WEB-INF/jsp/exts/koreahana/pba/include/pbaEnums.jsp" %>
<%//공고,지원대상 링크처리 %>
<c:set var="pbaLink" value="" />
<c:set var="sprtLink" value="" />
<c:forEach items="${lmenuList }" var="lmenu" varStatus="lstatus">
	<c:if test="${lmenu.menuSn == 1000000}"><c:set var="pbaLink" value="${lmenu.menuUrl }" /></c:if>
	<c:if test="${lmenu.menuSn == 2000000}"><c:set var="sprtLink" value="${lmenu.menuUrl }" /></c:if>
</c:forEach>


<c:set var="emlLink" value="" />
<c:set var="adtLink" value="" />
<c:set var="shoLink" value="" />
<c:set var="eduLink" value="" />
<c:set var="vdoLink" value="" />
<c:set var="lnbLink" value="" />
<c:set var="spfLink" value="" />
<c:set var="emvLink" value="" />
<c:set var="empLink" value="" />
<c:forEach items="${mmenuList }" var="mmenu" varStatus="mstatus"><c:if test="${mmenu.uprMenuSn == 1000000 }">
	<c:if test="${mmenu.menuSn == 1010000 }"><c:set var="emlLink" value="/exts/koreahana/pba/emeIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1020000 }"><c:set var="adtLink" value="/exts/koreahana/pba/adtIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1030000 }"><c:set var="shoLink" value="/exts/koreahana/pba/shoIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1040000 }"><c:set var="eduLink" value="/exts/koreahana/pba/eduIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1050000 }"><c:set var="vdoLink" value="/exts/koreahana/pba/vdoIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1060000 }"><c:set var="lnbLink" value="/exts/koreahana/pba/lnbIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1070000 }"><c:set var="spfLink" value="/exts/koreahana/pba/spfIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1080000 }"><c:set var="emvLink" value="/exts/koreahana/pba/emvIndex.do" /></c:if>
	<c:if test="${mmenu.menuSn == 1090000 }"><c:set var="empLink" value="/exts/koreahana/pba/empIndex.do" /></c:if>
</c:if></c:forEach>
<script type="text/javascript">
var emlLink = '${emlLink}';
var adtLink = '${adtLink}';
var shoLink = '${shoLink}';
var eduLink = '${eduLink}';
var vdoLink = '${vdoLink}';
var lnbLink = '${lnbLink}';
var spfLink = '${spfLink}';
var emvLink = '${emvLink}';
var empLink = '${empLink}';
function fnViewPba(ctgry,sn){
	var _link = '';
	if(ctgry ==  '${enumFrsEml}'){
		_link = emlLink;
	}else if(ctgry ==  '${enumFrsAdt}'){
		_link = adtLink;
	}else if(ctgry ==  '${enumFrsSho}'){
		_link = shoLink;
	}else if(ctgry ==  '${enumFrsEdu}'){
		_link = eduLink;
	}else if(ctgry ==  '${enumFrsVdo}'){
		_link = vdoLink;
	}else if(ctgry ==  '${enumFrsLnb}'){
		_link = lnbLink;
	}else if(ctgry ==  '${enumFrsSpf}'){
		_link = spfLink;
	}else if(ctgry ==  '${enumFrsEmv}'){
		_link = emvLink;
	}else if(ctgry ==  '${enumFrsEmp}'){
		_link = empLink;
	}
	if(_link == ''){
		alert('해당 메뉴에 대한 권한이 없습니다.');
		return false;
	}
	
	location.href = _link + '?kpMode=view&pbancrcSn=' + sn;
}
function fnPage(p){
	location.href = '?pageIndex=' + p;
}
</script>

<div class="container" id="fast_cont" style="display: block;">
              
<div class="admain_warp">
	<a href="#none" target="_blank" title="새 창으로 열림" class="site_help_btn" onclick="fnHelpPopup('main');return false;">화면도우미</a>
  <h4 class="tit">주요 메뉴 바로가기</h4>
  <div class="list_type_3 list_st_quick_menu">
    <ul>
      <c:if test="${pbaMenuAuth == true }"><li><a class="btn_st btn_c_sc03 " href="${pbaLink }">정착지원사업 공고 관리</a></li></c:if>
      <c:if test="${sprMenuAuth == true }"><li><a class="btn_st btn_c_sc02 " href="${sprtLink }">정착지원사업 지원대상 관리</a></li></c:if>
      <c:if test="${sphMenuAuth == true }"><li><a class="btn_st btn_c_sc " href="/exts/koreahana/spr/index.do">지원이력 조회</a></li></c:if>
    </ul>
  </div>  



  <h4 class="tit">모집중인 공고</h4>
  <div class="list_type_3 list_st_gongo_menu" style="background: #efefef;padding: 20px;border-radius: 10px;">
    <ul>
	<c:forEach items="${pbaList }" var="pba">
	<fmt:formatDate var="pbancrcBgngDt" value="${pba.pbancrcBgngDt}" pattern="${dateFormat }" />
	<fmt:formatDate var="pbancrcEndDt" value="${pba.pbancrcEndDt}" pattern="${dateFormat }" />
	<c:set var="pbancrcCn" value="${jtag:removeHtmlTag(pba.pbancrcCn)}" />
	
      <li>
        <div class="box_st_hv">
          <p class="p_info"><c:out value="${fn:substring(pba.pbancrcNm, 0, 15)}${fn:length(pba.pbancrcNm) > 14 ? '...' : '' }" /></p>
          <a href="#" onclick="javascript:fnViewPba('<c:out value="${pba.pbancrcCtgryFrstCd}" />','<c:out value="${pba.pbancrcSn}" />');return false;"><c:out value="${fn:substring(pbancrcCn, 0, 80) }${fn:length(pbancrcCn) > 79 ? '...' : '' }" /></a>
          <p class="AlignRight">
          	<span class="txt_c_bl">
          		<c:choose>
					<c:when test="${pba.pbancrcSttsCd == enumPbaUnsCd}">모집전</c:when>
					<c:when test="${pba.pbancrcSttsCd == enumPbaAlwCd}">상시모집</c:when>
					<c:otherwise><c:out value="${pbancrcBgngDt}" /> ~ <c:out value="${pbancrcEndDt}" /></c:otherwise>
				</c:choose>
			</span>
		  </p>
        </div>
      </li>
	</c:forEach>
    </ul>
  </div>


  <div class="con_b_bt AlignCenter on">
    <div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}"   type="koreahana"   jsFunction="fnPage"   />
		</ul>
	</div>
  </div>


</div>


            </div>
<%--
<script type="text/javascript">
//모바일 업로드 완료시 callback
function fnMblCallback1(data){
	console.log(data);
}
</script>
<button type="button" onclick="ComFns.openMblPopup('fnMblCallback1')">모바일로 파일 업로드하기</button>
 --%>
<%@ include file="/WEB-INF/jsp/exts/koreahana/com/footer.jsp" %>
