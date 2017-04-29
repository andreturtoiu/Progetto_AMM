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
       <div id="sideBar">
            <div id="user">
                <h3>Utenti</h3>
                <ul>
                    <li><img alt="Foto" src="img/bunny.jpg">Bugs Bunny</li>
                    <li><img alt="Foto" src="img/images.jpg">Deadpool</li>
                    <li><img alt="Foto" src="img/images1.jpg">Jerry</li>
                </ul>      
            </div>

            <div id="group">
                <h3>Gruppi</h3>
                <ul>
                    <li><img alt="Foto" src="img/cn.png">CartoonNetwork</li>
                    <li><img alt="Foto" src="img/marvel.jpg">Marvel</li>
                </ul>
            </div>       
        </div>

        <div class="formDati">
            <form action="bacheca.html" method="post">
                <label for="firstname">Nome:</label>
                <input type="text" name="firstname" id ="firstname">

                <label for="lastname">Cognome:</label>
                <input type="text" name="lastname" id = "lastname">

                <label for="profileImg">Immagine profilo</label>
                <input type="url" id="profileImg"/>

                <label for="psw"> Password:</label>
                <input type="password" name="psw" id="psw">

                <label for="confirmpsw">Conferma password:</label>
                <input type="password" name="psw" id="confirmpsw">

                <label for="textPost">Frase di descrizione:</label>
                <textarea name="textPost" id="textPost" ></textarea>

                <label for="bDay">Birthday:</label>
                <input type="date" name="bDay" id ="bDay">
                <br/>
                <button type="submit">Aggiorna</button>                                                     
            </form>                    
        </div>  

    </body>
</html>
