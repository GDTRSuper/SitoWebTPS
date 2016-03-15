<%-- 
    Document   : aggiungiCommento
    Created on : 15-mar-2016, 8.28.35
    Author     : FSEVERI\trovo2987
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${evento.creatore.nickname}
    <c:forEach items="${evento.commentiCollection}" var="commento">
        Commenti: ${commento.utente.nickname}
        ${commento.voto}
        ${commento.testo}
    </c:forEach>
    </body>
</html>
