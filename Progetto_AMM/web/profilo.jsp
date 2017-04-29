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
        <c:set var="pagina" value="profilo" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidebar.jsp"/>

        <div class="formDati">
            <form action="Dati.jsp" method="post">
                <label for="firstname">Nome:</label>
                <input type="text" name="firstname" id ="firstname" value ="${loggedUser.nome}">

                <label for="lastname">Cognome:</label>
                <input type="text" name="lastname" id = "lastname" value ="${loggedUser.cognome}">

                <label for="profileImg">Immagine profilo</label>
                <input type="url" id="profileImg" name="profilePic" value ="${loggedUser.urlFotoProfilo}"/>

                <label for="psw"> Password:</label>
                <input type="password" name="psw" id="psw" value ="${loggedUser.password}">

                <label for="confirmpsw">Conferma password:</label>
                <input type="password" name="psw1" id="confirmpsw">

                <label for="textPost">Frase di descrizione:</label>
                <textarea name="textPost" id="textPost" >${loggedUser.fraseDescrizione}</textarea>

                <label for="bDay">Birthday:</label>
                <input type="date" name="bDay" id ="bDay">
                <br/>
                <button type="submit">Invia</button>                                                     
            </form>                    
        </div>  

    </body>
</html>
