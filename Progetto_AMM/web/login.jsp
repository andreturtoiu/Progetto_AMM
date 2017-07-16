<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Nerdbook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author"
              content="Andreea Turtoiu">   
        <meta name="keywords"
              content="nerdbook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>


    <body>
        <c:set var="pagina" value="login" scope="request"/>
        <jsp:include page="header.jsp"/>
        <div class="formL" id="loginForm">  
            
            <c:if test="${invalidData == true}">
                <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
                
            <form action="login.html" method="get">
                <label for="uName">Username</label>
                <input type="text" name="username" id="uName" value ="Harry"/>

                <label for="pswd">Password</label>
                <input type="password" name="pswd" id="pswd" value = "123"/>

                <button type="submit">Accedi</button>
            </form>             
        </div>                
    </body>
</html>
