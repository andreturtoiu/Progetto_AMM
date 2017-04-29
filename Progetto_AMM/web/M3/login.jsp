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

        <div class="formL" id="loginForm">           
            <form action="profilo.html" method="post">
                <label for="uName">Username</label>
                <input type="text" name="username" id="uName"/>

                <label for="pswd">Password</label>
                <input type="password" name="pswd” " id="pswd"/>

                <button type="submit">Accedi</button>
            </form>             
        </div>                
    </body>
</html>
