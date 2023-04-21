<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><% /* cset_s */ %><% String servletPath = request.getServletPath(); %><% String[] Jnit_ServletPath = servletPath.split("/"); String Jnit_sitePath = Jnit_ServletPath[1]; %><c:set var="Jnit_sitePath" value="<%= Jnit_sitePath %>" scope="request"/><%@ page import="egovframework.com.utl.fcc.service.StringUtil"%><% String localYn = ""; if(StringUtil.isExistString(request.getRequestURL().toString(),"local")) localYn="Y"; %><c:set var="localYn" value="<%= localYn %>" scope="request" /><% /* cset_e */ %><% /*<!-- [-CONTENT-] -->*/ %><%
   /**
   *@version 3.2.0.1
   **/
   %>
  <%@ include file="/_common/stateCount.jsp" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
      <title>북한이탈주민지원재단 | 온라인 신청 시스템</title>
      <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <%@ include file="/support/common/config/handing/cssHanding.jsp" %>

      <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
      <%@ include file="/support/common/config/handing/jsHanding.jsp" %>
    </head>

    <body>

      <div id="wrap" class="main">
        <!-- header -->
        <jsp:include page="/support/include/header/index.jsp" flush="false" ></jsp:include>
        <!-- End of header -->
        <!-- middle -->
        <div id="contents">
          <div class="visual">
            <div class="container">

              <form id="fMainSearch" method="post">
              <p class="tit_visual">손쉽게 찾아가는 내가 원하는 지원 사업 
          <a href="#none" target="_blank" title="새 창으로 열림" class="site_help_btn" style="margin: 0 60px 0 -100px;" onclick="fnHelpPopup('main');return false;">화면도우미</a> </p>
              <ul>
                <li class="v_step01">
                  <p class="v_tit">1차분류</p>
                  <div style="display: inline-block;width: 200px;">
                    <input type="checkbox" id="ca01" name="cd1Vals" value="생활안정" class="st_t_check02"/><label for="ca01" class="MAB10" style="width: 100%;">생활안정</label>
                    <input type="checkbox" id="ca02" name="cd1Vals" value="교육지원" class="st_t_check02"/><label for="ca02" class="MAB10" style="width: 100%;">교육지원</label>
                    <input type="checkbox" id="ca03" name="cd1Vals" value="자립지원" class="st_t_check02"/><label for="ca03"  style="width: 100%;">자립지원</label>
                  </div>

                </li>
                <li class="v_step02">
                  <div style="width: 300px;">
                    <label for="vi000" class="cate_tit" >지원신청 자격</label>
                    <input type="checkbox" id="vi001" name="stngCds" value="29011" class="st_t_check"/><label class="vs_select" for="vi001"><img src="/support/img/main/icon_qb_101.png" alt="" />북한이탈주민</label>
                    <input type="checkbox" id="vi002" name="stngCds" value="29012" class="st_t_check"/><label class="vs_select" for="vi002"><img src="/support/img/main/icon_qb_102.png" alt="" />제3국 출생 자녀</label>
                    <input type="checkbox" id="vi003" name="stngCds" value="29013" class="st_t_check"/><label class="vs_select" for="vi003"><img src="/support/img/main/icon_qb_103.png" alt="" />대국민</label>
                  </div>
                  <div>
                    <label for="vi030" class="cate_tit">기타  조건</label>
                    <input type="checkbox" id="vi031" name="stngCds" value="29041" class="st_t_check"/><label class="vs_select" for="vi031"><img src="/support/img/main/icon_qb_201.png" alt="" />재직중</label>
                    <input type="checkbox" id="vi032" name="stngCds" value="29042" class="st_t_check"/><label class="vs_select" for="vi032"><img src="/support/img/main/icon_qb_202.png" alt="" />사업자(기창업자)</label>
                  </div>
                  <div style="width: 300px;">
                    <label for="vi010" class="cate_tit">연령</label>
                    <input type="checkbox" id="vi011" name="stngCds" value="29021" class="st_t_check"/><label class="vs_select" for="vi011"><img src="/support/img/main/icon_qb_301.png" alt="" />미취학아동</label>
                    <input type="checkbox" id="vi012" name="stngCds" value="29022" class="st_t_check"/><label class="vs_select" for="vi012"><img src="/support/img/main/icon_qb_302.png" alt="" />초등학생</label>
                    <input type="checkbox" id="vi013" name="stngCds" value="29023" class="st_t_check"/><label class="vs_select" for="vi013"><img src="/support/img/main/icon_qb_303.png" alt="" />중학생</label>
                    <input type="checkbox" id="vi014" name="stngCds" value="29024" class="st_t_check"/><label class="vs_select" for="vi014"><img src="/support/img/main/icon_qb_304.png" alt="" />고등학생</label>
                    <input type="checkbox" id="vi015" name="stngCds" value="29025" class="st_t_check"/><label class="vs_select" for="vi015"><img src="/support/img/main/icon_qb_305.png" alt="" />검정고시생</label>
                    <input type="checkbox" id="vi016" name="stngCds" value="29026" class="st_t_check"/><label class="vs_select" for="vi016"><img src="/support/img/main/icon_qb_306.png" alt="" />대학생</label>
                    <input type="checkbox" id="vi017" name="stngCds" value="29027" class="st_t_check"/><label class="vs_select" for="vi017"><img src="/support/img/main/icon_qb_307.png" alt="" />대학원생</label>
                    <input type="checkbox" id="vi018" name="stngCds" value="29028" class="st_t_check"/><label class="vs_select" for="vi018"><img src="/support/img/main/icon_qb_308.png" alt="" />연령제한 없음</label>

                  </div>

                  <div style="width: 220px;">
                    <label for="vi020" class="cate_tit">업종</label>
                    <input type="checkbox" id="vi021" name="stngCds" value="29031" class="st_t_check"/><label class="vs_select" for="vi021"><img src="/support/img/main/icon_qb_401.png" alt="" />운수업</label>
                    <input type="checkbox" id="vi022" name="stngCds" value="29032" class="st_t_check"/><label class="vs_select" for="vi022"><img src="/support/img/main/icon_qb_402.png" alt="" />농업</label>
                    <input type="checkbox" id="vi023" name="stngCds" value="29033" class="st_t_check"/><label class="vs_select" for="vi023"><img src="/support/img/main/icon_qb_403.png" alt="" />어업</label>
                    <input type="checkbox" id="vi024" name="stngCds" value="29034" class="st_t_check"/><label class="vs_select" for="vi024"><img src="/support/img/main/icon_qb_404.png" alt="" />임업</label>
                    <input type="checkbox" id="vi025" name="stngCds" value="29035" class="st_t_check"/><label class="vs_select" for="vi025"><img src="/support/img/main/icon_qb_405.png" alt="" />업종무관</label>
                  </div>




                </li>

              </ul>
              </form>
              <p class="AlignCenter"><a class="SPB_POP_BTN" href="#none" style="position: relative;z-index: 2;"><img src="/support/img/main/btn_main_search.png" alt="검색" /></a></p>
              <script>
              $(document).ready(function(){
                  // 검색팝업
                  $('.SPB_POP_BTN').click(function() {
                	  if($('#fMainSearch input[name="cd1Vals"]:checked').length == 0){
                		  alert('1차분류를 한가지 이상 선택해 주세요');
                		  return false;
                	  }
                	  
                	  if($('#fMainSearch input[name="stngCds"]:checked').length == 0){
                		  alert('조건을 한가지 이상 선택해 주세요');
                		  return false;
                	  }

                      $('.SPB_POP li').hide();
                	  $.ajax({
                		 url:'/user/exts/koreahana/com/spbSearchActionJson.do',
                		 data:$('#fMainSearch').serialize(),
                		 method:'post',
                		 success:function(data){
                           $('.SPB_POP').toggleClass('SAMPLE_POP_ON');
                           $('.SPB_POP').toggleClass('SAMPLE_POP_OFF');
                           $(data).each(function(){
                        	  $('#spb' + this + 'Li').show();
                           });
                		 }
                	  });
                  	return false;
                  });

                  // 팝업닫기
                  $('.SAMPLE_POP_CLOSE').click(function() {
                  $('.SPB_POP').toggleClass('SAMPLE_POP_ON');
                  $('.SPB_POP').toggleClass('SAMPLE_POP_OFF');
                  });
              });

            </script>

				<div class="main_src_pop  SPB_POP SAMPLE_POP_OFF" >                  
                  	<div class="main_src_box">
                      <h3 class="suc_tit">지원사업 검색 결과</h3>
                      <p class="FloatRight"><a href="#none" class="Fs20 SAMPLE_POP_CLOSE"> X <span class="comment">닫기</span></a></p>
                      	<ul>
                          <li id="spb27001Li">
                            <span class="st_01">생활안정지원사업</span><br />
                            <p class="ma_tit">의료비지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?menuPos=5" >자세히알기</a>
                            </p>
                          </li>
                          <li id="spb27002Li">
                            <span class="st_01">생활안정지원사업</span><br />
                            <p class="ma_tit">공공의료 협약병원지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?menuPos=6" >자세히알기</a>
                            </p>
                          </li>
                          <li id="spb27003Li">
                            <span class="st_01">생활안정지원사업</span><br />
                            <p class="ma_tit">치과(틀니)지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?menuPos=7" >자세히알기</a>
                            </p>
                          </li>
                          <li id="spb27004Li">
                            <span class="st_01">생활안정지원사업</span><br />
                            <p class="ma_tit">긴급생계비지원</p>
                            <p class="ma_btn">
                            </p>
                          </li>
                          <li id="spb27005Li">
                            <span class="st_01">생활안정지원사업</span><br />
                            <p class="ma_tit">가산금지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsTKqql12Umls2aVd%2FkDZog0%3D&amp;menuPos=42" >자세히알기</a>
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/supadd/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27006Li">
                            <span class="st_02">교육지원사업</span><br />
                            <p class="ma_tit">장학금지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsYPdw8OsB4AILnN9sdjIMFE%3D&menuPos=29"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/scholarship/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27007Li">
                            <span class="st_02">교육지원사업</span><br />
                            <p class="ma_tit">교육지원금지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_bk" href="/support/su_sub/suppay/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27008Li">
                            <span class="st_02">교육지원사업</span><br />
                            <p class="ma_tit">화상영어지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&amp;menuPos=31"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/scholarship/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27009Li">
                            <span class="st_02">교육지원사업</span><br />
                            <p class="ma_tit">학습지지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsYPdw8OsB4AILnN9sdjIMFE%3D&menuPos=29"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/worksheet/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27010Li">
                            <span class="st_02">교육지원사업</span><br />
                            <p class="ma_tit">정착지원전문관리사 양성</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh"  href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsVXGV6WVTcKT6U2Bx5fOBDg%3D&amp;menuPos=31"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/manager/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27011Li">
                            <span class="st_03">자립지원사업</span><br />
                            <p class="ma_tit">취업바우처카드</p>
                          </li>

                          <li id="spb27012Li">
                            <span class="st_03">자립지원사업</span><br />
                            <p class="ma_tit">미래행복통장</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh" href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsTKqql12Umls2aVd%2FkDZog0%3D&menuPos=44"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                            </p>
                          </li>
                          
                          <li id="spb27013Li">
                            <span class="st_03">교육지원사업</span><br />
                            <p class="ma_tit">취업연계 직업훈련</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_bk"  href="/support/su_sub/jobt/list/">모집공고</a>
                            </p>
                          </li>

                          <li id="spb27014Li">
                            <span class="st_03">자립지원사업</span><br />
                            <p class="ma_tit">경영개선 자금지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh" href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsXv2KdT7Rc7Qz0my5sWdgK4%3D&amp;menuPos=19"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                            </p>
                          </li>

                          <li id="spb27015Li">
                            <span class="st_03">자립지원사업</span><br />
                            <p class="ma_tit">영농정착지원</p>
                            <p class="ma_btn">
                              <a class="btn_st btn_c_wh" href="https://www.koreahana.or.kr/home/kor/contents.do?ptSignature=QnrvtOekxiPklgsn74dfsf3lWPJ0boQW6NIyd%2FtHiNE%3D&amp;menuPos=17"  target="_blank" title="새 창으로 열립니다." >자세히알기</a>
                            </p>
                          </li>
                          
                      </ul>
                      
                  	</div>                  
              	</div>
              
            </div>

          </div>
          <div class="container">

            <div class="hana_baro_btn">
              <p class="q_tit">남북하나재단 지원사업 바로가기</p>
              <ul>
                <li><a href="/support/su_sub/supadd/"><img src="/support/img/main/img_q_01.png" alt="" />가산금<br />지원</a></li>
                <li><a href="/support/su_sub/scholarship/"><img src="/support/img/main/img_q_02.png" alt="" />장학금<br />지원</a></li>
                <li><a href="/support/su_sub/suppay/"><img src="/support/img/main/img_q_03.png" alt="" />교육지원금<br />지원</a></li>
                <li><a href="/support/su_sub/video/"><img src="/support/img/main/img_q_04.png" alt="" />화상영어<br />지원</a></li>
                <li><a href="/support/su_sub/worksheet/"><img src="/support/img/main/img_q_05.png" alt="" />학습지<br />지원</a></li>
                <li><a href="/support/su_sub/manager/"><img src="/support/img/main/img_q_06.png" alt="" />정착지원<br />전문관리사</a></li>
                <li><a href="/support/su_sub/jobt/"><img src="/support/img/main/img_q_07.png" alt="" />취업연계<br />직업훈련</a></li>

              </ul>
            </div>
			
            <%--
				*** 미니게시판 삽입 code 설명 ***
				base_path : 해당 게시판 실제 삽입된 페이지 경로(게시물클릭시 이동기본 참조URL,다중 게시판 데이터 사용시 ,로 구분하여 입력)
			--%>
			<c:catch var ='catchException'>
			<jsp:include page='/WEB-INF/jsp/jnit/board/latest/skin/SITE_00001/공지사항.jsp'>
				<jsp:param name='base_path' value='/support/commu/notice/'></jsp:param>
			</jsp:include>
			</c:catch>
              
			<%--
            <div class="notice_menu_and">
              <div class="tab_board">
                <p class="tit_notice"><a href="/support/commu/notice/">공지사항</a></p>
                <div class="board_list">
                  <a href="/support/commu/notice/" class="btn_more"><img src="/support/img/common/icon_plus.png" alt="게시글 더 보기" /></a>
                  <ul>
                    <li><a href="/support/commu/notice/">[공지] 공지사항 문구 안내 및 날짜 안내 해드립니다. 자세한 내용은 잘려버리는</a><span class="date">2002-09-05</span></li>
                    <li><a href="/support/commu/notice/">[공지] 공지사항 문구 안내 및 날짜 안내 해드립니다. 자세한 내용은 잘려버리는</a><span class="date">2002-09-05</span></li>
                    <li><a href="/support/commu/notice/">[공지] 공지사항 문구 안내 및 날짜 안내 해드립니다. 자세한 내용은 잘려버리는</a><span class="date">2002-09-05</span></li>
                    <li><a href="/support/commu/notice/">[공지] 공지사항 문구 안내 및 날짜 안내 해드립니다. 자세한 내용은 잘려버리는</a><span class="date">2002-09-05</span></li>
                    <li><a href="/support/commu/notice/">[공지] 공지사항 문구 안내 및 날짜 안내 해드립니다. 자세한 내용은 잘려버리는</a><span class="date">2002-09-05</span></li>
                  </ul>
                </div>

              </div>


              <div class="quick_btn">
                <ul>
                  <li><a href="/support/commu/faq/"><img src="/support/img/main/img_qbtn_img01.png" alt="" />자주 묻는 질문</a></li>
                  <li><a href="/support/commu/qna/"><img src="/support/img/main/img_qbtn_img02.png" alt="" />1:1 문의</a></li>
                </ul>
              </div>
            </div>
          </div>
			--%>
        
        
        </div>   
        <!-- End of middle -->
        <!-- footer -->
        <jsp:include page="/support/include/footer/index.jsp" flush="false" ></jsp:include>
        <!-- End of footer -->
      </div>

    </body>
  </html><% /*<!-- /[-CONTENT-] -->*/ %>