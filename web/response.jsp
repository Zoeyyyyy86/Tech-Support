<%-- 
    Document   : response
    Created on : 1 déc. 2021, 11:38:38
    Author     : rykuz
--%>

<jsp:useBean id="techSupportBean" scope="application" class="bean.TechSupportBean" />
<%@ page errorPage="/error.jsp" %>
<html>
    <head><title>Customer service</title></head>
    <body>
        <h1>Customer service</h1>
        <p>Thank you for your request, which has been registered.</p>
        <hr color="#1C9DD9">
        Common user:
        <%= techSupportBean.getPrenom() %>
        <%= techSupportBean.getNom() %>
        <hr color="#1C9DD9">
        <div style="position: fixed; bottom: 0;right: 0;">By Ningman XU and Peter THAY</div>
        <br>
    </body>
</html>