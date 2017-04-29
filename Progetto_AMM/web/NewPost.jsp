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
        <p>${user.nome} {user.cognome}</p>
        <h2>Propietario Bacheca</h2>
        <p>${user.firstname} {user.lastname}</p>
        <h2>Post</h2>
        <p>${param.newPost}</p>
        <h2>Allegato</h2>
        <p>${param.newUrl}</p>
        
        
    </body>
</html>
