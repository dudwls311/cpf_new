<%@ page contentType="text/html; charset=utf-8" %><%@ include file='/_common/_header.jsp' %><%@ page import="jnit.cms.handler.*" %><%@ page import="jnit.com.util.CclUtil" %><%@ page import="jnit.cms.menu.JnitcmsmenuController" %><c:set var="handingType" value="TPL_000020" />
              <!-- Sample E 이하 --> 
              <div class="updateButton"><!-- 컨텐츠 수정 -->
                <jsp:include page="/cms/import/support_updateButton.jsp"></jsp:include>   
              </div>
            </div>
          </div>

        </div>
      </div>
      <!-- End of middle -->
      <!-- footer -->
      <jsp:include page="/support/include/footer/index.jsp" flush="false" ></jsp:include>
      <!-- End of footer -->
    </div>
  </body>
</html>