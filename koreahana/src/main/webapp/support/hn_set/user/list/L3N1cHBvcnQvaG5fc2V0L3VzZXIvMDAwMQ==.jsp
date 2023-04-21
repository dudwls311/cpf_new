<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><%@ include file='/support/_tpls/B/TPL_000019_S.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div class="box_w_gray">
  <div class="br">

    <label for="s2">상태</label>
    <select name="s2" id="s2"  class="st_select MAR20">
      <option>전체</option> 
      <option>활성화</option> 
      <option>비활성화</option> 
      <option>로그인차단</option>
    </select> 

    <label for="s3">권한구분</label>
    <select name="s3" id="s3"  class="st_select MAR20">
      <option>전체</option> 
      <option>최고관리자</option> 
      <option>재단담당자</option> 
      <option>하나센터</option>
    </select> 

    <label for="s4">소속부서</label>
    <select name="s4" id="s4"  class="st_select MAR20">
      <option>전체</option> 
      <option>생활안정</option> 
      <option>교육지원</option> 
      <option>자립지원</option>
    </select> 

    <label for="s5">소속센터</label>
    <select name="s5" id="s5"  class="st_select">
      <option>전체</option> 
      <option>경기</option> 
      <option>경남</option> 
      <option>서울</option> 
      <option>강원남부</option>
    </select> 


  </div>
  <div class="ig_wrap">
    <div class="ig_l">
      <label for="iWWWW" class="comment">검색어 입력</label>
      <input type="text" name="iWWWW" id="iWWWW" class="st_input input_long" value="" placeholder="사용자 이름, ID로 검색" />

    </div>

    <div class="ig_s">
      <button type="button" class="btn-input-search">조회</button>
    </div>

  </div>
</div>
<!-- // search box -->



<div class="con_b_tp">
  <p class="b_total FloatLeft">총<span>102</span>건</p>
  <div class=" FloatRight"><a class="btn_st btn_c_bk" href="#">사용자 등록</a></div>
</div>



<table class="table_style thd_v_m">
  <colgroup>
    <col width="5%" />
    <col width="10%"/>
    <col width="15%"/>
    <col width="15%"/>
    <col width="*"/>
    <col width="10%"/>
    <col width="10%"/>
    <col width="10%"/>
    <col width="8%"/>
  </colgroup>

  <thead>
    <tr>
      <th>No.</th>
      <th>등록일</th>
      <th>권한구분</th>
      <th>소속부서</th>
      <th>소속센터</th>
      <th>이름</th>
      <th>아이디</th>
      <th>상태</th>
      <th>정보수정</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>5</td>
      <td>yyyy-mm-dd</td>
      <td>최고관리자</td>
      <td>&nbsp;</td>
      <td>강원북부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td>활성화</td>
      <td><a href="/support/hn_set/user/edit/" class="btn_st">수정</a></td>
    </tr>
    <tr>
      <td>4</td>
      <td>yyyy-mm-dd</td>
      <td>최고관리자</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td>활성화</td>
      <td><a href="/support/hn_set/user/edit/" class="btn_st">수정</a></td>
    </tr>
    <tr>
      <td>3</td>
      <td>yyyy-mm-dd</td>
      <td>하나센터</td>
      <td>&nbsp;</td>
      <td>강원남부</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td>비활성화</td>
      <td><a href="/support/hn_set/user/edit/" class="btn_st">수정</a></td>
    </tr>
    <tr>
      <td>2</td>
      <td>yyyy-mm-dd</td>
      <td>재단담당자</td>
      <td>자립지원</td>
      <td>&nbsp;</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td>로그인차단</td>
      <td><a href="/support/hn_set/user/edit/" class="btn_st">수정</a></td>
    </tr>
    <tr>
      <td>1</td>
      <td>yyyy-mm-dd</td>
      <td>최고관리자</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>홍길동</td>
      <td>id1234</td>
      <td>활성화</td>
      <td><a href="/support/hn_set/user/edit/" class="btn_st">수정</a></td>
    </tr>

  </tbody>
</table>




<div class="con_b_bt AlignCenter">
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
</div><% /*<!-- /[-CONTENT-] -->*/ %><%@ include file='/support/_tpls/B/TPL_000019_E.jsp' %>