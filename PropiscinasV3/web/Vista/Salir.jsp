<%-- 
    Document   : Salir
    Created on : 28/11/2019, 08:14:57 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.invalidate();
response.sendRedirect("/PropiscinasSAS/Vista/MenuPrincipal.jsp");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salir</title>
    </head>
    <body>
        
    </body>
</html>
