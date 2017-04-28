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
        <header> 
            <nav>
                <ol>
                    <li><a href="descrizione.html" id="nerdbook_style">NerdBook</a></li>
                    <li><a href="login.html">Login</a></li>
                </ol>

            </nav>
        </header>

        <div id="divBody">
            <div id="sommario">
                <h2>Sommario</h2>
                <ul>
                    <li><a href="#descrizione">-Descrizione</a></li>
                    <li><a href="#utenti">-Utenti</a></li>
                    <li><a href="#iscrizione">-Iscrizione</a></li>
                </ul>
            </div>
            <div>
                <h1>Info generali</h1>
                <h2>Descrizione</h2>
                <p id="descrizione">Nerbook è un social network che permette agli utenti di stringere amicizie e di creare e gestire dei gruppi.               </p>

                <h2>Utenti</h2>
                <h3>1.Utenti registrati</h3>
                <h3>2.Utente amministratore</h3>

                <p id="utenti">   Si avranno due tipologie di utent.<br/>
                    Un utente registrato può inserire dei post nella sua bacheca o in quella dei suoi amici. Nel caso un utente visiti la bacheca di un altro utente che non è nella lista dei suoi amici, l’applicazione gli permetterà di stringere amicizia. Non è prevista una conferma dell’amicizia. 
                    Una volta stretta l’amicizia, l’utente potrà inserire dei post in bacheca. I gruppi permettono di raccogliere degli utenti, che non siano necessariamente amici fra loro, per condividere informazioni e materiali legati da un comune interesse (un linguaggio di programmazione, una squadra di calcio, un gruppo musicale ecc.). Anche i gruppi hanno la loro bacheca. Ogni volta che un post viene pubblicato sulla bacheca di un gruppo, questo viene replicato anche nella bacheca di tutti gli appartenenti al gruppo.
                    Un utente si iscrive spontaneamente visitando la bacheca del gruppo e richiedendo l’iscrizione. Non è prevista la conferma dell’iscrizione dagli altri appartenenti al gruppo. 
                    Il gruppo viene fondato da un utente, che è l’unico, oltre all’amministratore, che può cancellarlo. Una volta cancellato, anche tutti i post del gruppo sono eliminati. <br/>
                    L’amministratore è un utente speciale che può cancellare i contenuti ritenuti non appropriati. Per questo può cancellare post di qualsiasi utente e qualsiasi gruppo. 
                </p>

                <h3>Modalità di iscrizione</h3>
                <p id="iscrizione">L'iscrizione al social non prevede nessun tipo di pagamento in denaro. L'utente si iscrive e disincrive gratuitamente. </p>     
            </div>

        </div>
    </body>
</html>
