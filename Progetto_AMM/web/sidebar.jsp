<%-- 
    Document   : sidebar
    Created on : 29-apr-2017, 16.37.11
    Author     : Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Andreea Turtoiu">
        <meta name="keywords" content="cerca">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

    </head>
    
    <body>
        <div id="sideBar">
  
             <div id="cerca">
                <input id="searchFriends" type="text" placeholder="Cerca.." value="">
            </div>
            
            <div id="user">   
                <h3>Amici</h3>
                <ul>
                    <c:forEach var="user" items="${amici}">
                        <li>
                            <div class ="userData">
                                <img alt ="Foto Profilo" src="${user.urlFotoProfilo}"/> 
                                <a href="bacheca.html?user=${user.id}">${user.nome} ${user.cognome}</a> 
                            </div>
                        </li>        
                    </c:forEach>    
                </ul>     
            </div>

            <div id="group">
                <h3>Gruppi</h3>
                <ul>
                    <c:forEach var="group" items="${gruppi}">
                        <li>
                            <img alt ="Foto" src="${group.urlImmagine}"/> 
                            <a href="bacheca.html?group=${group.id}">${group.nome}</a>                            
                        </li>                                 
                    </c:forEach>  
                </ul>
            </div>   
            
        </div>
    </body>
 
</html>
