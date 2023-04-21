<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000003_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><%-- 
	게시판 code 사용법
	* boardid : 게시판 아이디
	* useSkeleton : true로 입력하면 게시판의 html 뼈대 없이 가져옵니다.
	* customSkin : 게시판 설정을 무시하고 스킨 설정
--%>
<jsp:include page="/${ctxRoot}/board/board.do">
	<jsp:param name="boardId" value="bbs_0000000000000004"/>
	<jsp:param name="fixedCategory" value=""/>
	<jsp:param name="useSkeleton" value="true"/>
	<jsp:param name="customSkin" value=""/>
	<jsp:param name="isMobile" value="false"/>
</jsp:include>



<%--
<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class="FloatRight">
    <input type="text" name="isWord2" id="isWord2" class="st_input MAL10 PAR25" value="" placeholder="제목 또는 내용으로 검색
                                                                                                      "/>
    <button type="button" class="ico_search"><span class="comment">검색</span></button>
  </div>
</div>


<div class="faq_board">

  <div class="faq_box">
    <input type="checkbox" id="faq_01" name="faq" value=""/>
    <label for="faq_01">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. </p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_02" name="faq" value=""/>
    <label for="faq_02">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_03" name="faq" value=""/>
    <label for="faq_03">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_04" name="faq" value=""/>
    <label for="faq_04">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_05" name="faq" value=""/>
    <label for="faq_05">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_06" name="faq" value=""/>
    <label for="faq_06">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_07" name="faq" value=""/>
    <label for="faq_07">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_08" name="faq" value=""/>
    <label for="faq_08">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>

  <div class="faq_box">
    <input type="checkbox" id="faq_09" name="faq" value=""/>
    <label for="faq_09">
      <span class="b_type">Q.</span>
      <p class="title">자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다. 자주 묻는 질문 제목이 보여집니다. 생략 없이 보여집니다.</p>
    </label>
    <div class="faq_b_anw">
      <span class="b_type">A.</span>
      <p class="coment">자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 자주 묻는 질문에 대한 답변 내용이 보여집니다. 생략 없이 모두 보여집니다. 
      </p>
    </div>
  </div>
  
  
</div>




<div class="con_b_bt AlignCenter MAB30">
  <div class="paging">
    <ul>
      <li class="first_page_btn"><a href="#none"><span>첫 페이지</span></a></li>
      <li class="prev_page_btn"><a href="#none"><span>이전 페이지</span></a></li>
      <li class="on"><a href="#none">1</a></li>                        
      <li><a href="#none">2</a></li>                        
      <li><a href="#none">3</a></li>                        
      <li><a href="#none">4</a></li>                        
      <li><a href="#none">5</a></li>                        
      <li><a href="#none">6</a></li>                        
      <li><a href="#none">7</a></li>                        
      <li><a href="#none">8</a></li>                        
      <li><a href="#none">9</a></li>                        
      <li><a href="#none">10</a></li>
      <li class="next_page_btn"><a href="#none"><span>다음 페이지</span></a></li>
      <li class="last_page_btn"><a href="#none"><span>마지막 페이지</span></a></li>
    </ul>
  </div>
</div>

--%><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000003_E.jsp' %>