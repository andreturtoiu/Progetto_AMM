<%-- 
    Document   : NewPost
    Created on : 29-apr-2017, 21.30.39
    Author     : Andreea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>DATI:</h1>
        <h2>Utente che ha inserito</h2>
        <p>${utenteLoggato.nome}</p>
            <c:if test="${utenteLoggato.cognome} != null">
                          <p>{utenteLoggato.cognome}</p>
            </c:if>
        <h2>Proprietario Bacheca</h2>
        <p>${param.nomeDest}</p>
        <h2>Post</h2>
        <p>${param.textPost}</p>
        <h2>Allegato</h2>
        <p>${param.urlAllegato}</p>
        <h2>Tipo post</h2>
        <c:choose>
            <c:when test="${postType == 'textPost'}">
                <h3>Testo</h3>
            </c:when>
            <c:when test="${postType == 'immaginePost'}">
                <h3>Immagine</h3>
            </c:when>
            <c:when test="${postType == 'LinkType'}">
                <h3>Link</h3>
            </c:when>      
        </c:choose>
        
        <form action="NewPost" method="POST">
            <input type="hidden" name="tipoBacheca" value="${param.tipoBacheca}"/>
            <input type="hidden" name="dest" value="${param.dest}"/>
            <input type="hidden" name="urlAllegato" value="${param.urlAllegato}"/>
            <input type="hidden" name="postType" value="${param.postType}"/>
            <input type="hidden" name="textPost" value="${param.textPost}"/>
            <label>Conferma?</label>
            <button name="thereIsPost" type="submit">Invia</button>
        </form>
    </body>
</html>
