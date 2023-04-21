<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) { response.setHeader("Cache-Control", "no-cache"); } %><%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/header.jsp' %><% /*<!-- [-CONTENT-] -->*/ %><div id="footer">
        <div class="f_top">
            <div class="container">
                <ul class="f_nav">
                    <li><a href="/support/kor/perInf/priv210606/"><b>개인정보처리방침</b></a></li>
                    <li><a href="/support/kor/service/servi171201/">이용약관</a></li>
                    <li><a href="/support/commu/qna/">1:1문의</a></li>
                </ul>
                <div class="f_nav_r">
                    북한이탈주민 종한상담 콜센터 <b>1577-6635</b>
                    <div class="baro_box">
                      <select class="site_link" onchange="window.open(value,'_blank');">
                        <option>국내 유관기관</option>
                        <option value="https://www.unikorea.go.kr/unikorea/">통일부</option>
                        <option value="https://www.koreahana.or.kr/">남북하나재단</option>
                      </select>
                    </div>
                    <a href="#wrap" class="top_btn" title="상단으로 이동"></a>
                </div>
            </div>
        </div>
        <div class="container">
            <p class="f_logo"><img src="/support/img/common/logo_h1.png" alt="북한이탈주민지원재단 온라인 신청 시스템" /></p>
            <p class="f_info">04168 서울특별시 마포구 세창로 7, 4-5층 (도화동 565, SUN장학빌딩) &nbsp;&nbsp;&nbsp;&nbsp; TEL : 1577-6635 &nbsp;&nbsp;&nbsp;&nbsp;  FAX : 02-3215-5779</p>
            <p class="f_copy">Copyrightⓒ 북한이탈주민지원재단. All right reserved.</p>
          <!-- <p class=""><img src="/support/img/common/logo_f.png" alt="남북하나재단" /></p>-->
        </div>
    </div><% /*<!-- /[-CONTENT-] -->*/ %>
