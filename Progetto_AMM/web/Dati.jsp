<%-- 
    Document   : Dati
    Created on : 29-apr-2017, 18.20.43
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
        <h2>Nome</h2>
        <p>${param.firstname}</p>
        <h2>Cognome</h2>
        <p>${param.lastname}</p>
        <h2>Password</h2>
        <p>${param.psw}</p>
        <h2>Conferma Password</h2>
        <p>${param.psw1}</p>
         <h2>Immagine profilo</h2>
        <p>${param.profilePic}</p>
        <h2>Frase descrizione</h2>
        <p>${param.textPost}</p>
        <h2>Data</h2>
        <p>${param.bDay}</p>     
    </body>
</html>
