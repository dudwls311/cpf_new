<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/exts/com/init.jsp" %>

<%//모집공고상태코드 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd).UNS.getCode()" var="enumPbaUnsCd" /> <%//미정(접수전) %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd).ALW.getCode()" var="enumPbaAlwCd" /> <%//상시 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd).BEF.getCode()" var="enumPbaBefCd" /> <%//모집전 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd).COM.getCode()" var="enumPbaComCd" /> <%//모집완료 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumPbancrcSttsCd).REQ.getCode()" var="enumPbaReqCd" /> <%//신청하기 %>

<%//지원상태코드 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).COM.getCode()" var="enumSprComCd" /> <%//신청완료 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).SEL.getCode()" var="enumSprSelCd" /> <%//선정 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).UNS.getCode()" var="enumSprUnsCd" /> <%//미선정 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).WAI.getCode()" var="enumSprWaiCd" /> <%//선정대기 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).UND.getCode()" var="enumSprUndCd" /> <%//서류미비 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumSprtSttsCd).TMP.getCode()" var="enumSprTmpCd" /> <%//임시저장 %>

<%//일차적범주코드 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).MDL.getCode()" var="enumFrsMdl" /> <%//의료비 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).EML.getCode()" var="enumFrsEml" /> <%//긴급생계비 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).ADT.getCode()" var="enumFrsAdt" /> <%//가산금 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).SHO.getCode()" var="enumFrsSho" /> <%//장학금 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).EDU.getCode()" var="enumFrsEdu" /> <%//교육지원금 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).VDO.getCode()" var="enumFrsVdo" /> <%//화상영어 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).LNB.getCode()" var="enumFrsLnb" /> <%//학습지 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).SPF.getCode()" var="enumFrsSpf" /> <%//정착지원 전문관리사 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).EMV.getCode()" var="enumFrsEmv" /> <%//취업바우처카드 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).FTH.getCode()" var="enumFrsFth" /> <%//미래행복통장 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).FTH_NEW.getCode()" var="enumFrsFthNew" /> <%//미래행복통장 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).FTH_MTR.getCode()" var="enumFrsFthMtr" /> <%//미래행복통장 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).FTH_MDW.getCode()" var="enumFrsFthMdw" /> <%//미래행복통장 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).EMP.getCode()" var="enumFrsEmp" /> <%//취업연계 직업훈련 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).MGM.getCode()" var="enumFrsMgm" /> <%//경영개선자금 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumCtgryFrstCd).FRM.getCode()" var="enumFrsFrm" /> <%//영농정착 %>

<%//사업구분코드 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).DIS.getCode()" var="enumBizDis" /> <%//장애 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).LON.getCode()" var="enumBizLon" /> <%//장기치료 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).THR.getCode()" var="enumBizThr" /> <%//제3국출생양육 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).ELE.getCode()" var="enumBizEle" /> <%//초급 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).INT.getCode()" var="enumBizInt" /> <%//중급 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).HIG.getCode()" var="enumBizHig" /> <%//고급 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).THE.getCode()" var="enumBizThe" /> <%//이론 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).PRA.getCode()" var="enumBizPra" /> <%//실기 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).QLF.getCode()" var="enumBizQlf" /> <%//자격시험 %>

<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).BUS.getCode()" var="enumBizBus" /> <%//버스운전기사 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).ACC.getCode()" var="enumBizAcc" /> <%//회계실무자 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).CRA.getCode()" var="enumBizCra" /> <%//전기기능사 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).SWT.getCode()" var="enumBizSwt" /> <%//SW테스터 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).SON.getCode()" var="enumBizSon" /> <%//송도에스이 미화전문가 %>
<spring:eval expression="T(exts.koreahana.com.enums.KoreahanaEnumBizSeCd).SAM.getCode()" var="enumBizSam" /> <%//삼성중공업 직업기술생 %>