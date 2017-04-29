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
        <div id ="nuovoPost1">
            <form action="bacheca.html">
                <div id="nuovoPost">
                    <div id="postContent">
                        <div>
                            <label for="textPost">Nuovo post</label>
                            <textarea name="textPost" id="textPost" ></textarea>
                        </div>
                        <div>
                            <label for="profileImg">Allegato</label>
                            <input type="url" id="profileImg"/>
                        </div>
                    </div>
                    <div id="postType">
                        <div>
                            <label for="immaginePost">Immagine</label>
                            <input type="radio" name="immagine" value="immaginePost" id="immaginePost">
                        </div>
                        <div>
                            <label for="LinkType">Link</label>
                            <input type="radio" name="link" value="LinkType" id="LinkType">
                        </div>
                    </div>

                    <button type="submit">Invia</button>
                </div>            
            </form>
        </div>



        <div id="bacheca">
            <h1>Post utente</h1>
            <div class="userName">
                <img alt="Utente1" src="img/bunny.jpg">
                <h2><b>Bugs Bunny</b></h2>
            </div>
            <div class="contenuto">
                <p>
                    Un sondaggio inglese rivela: la frase più ricordata tra gli amanti dei cartoon è quella del celebre coniglio: «Che succede amico?»Bugs Bunny
                    Per gli americani dev'essere una sorta di riflesso condizionato: davanti alle orecchie di un coniglio viene automatico pensare «what's up doc?». E si capisce. E' la frase «tormentone» del coniglio più famoso d'America: Bugs Bunny. La faccia soddisfatta del dentone carota-dipendente la dice a ripetizione anche da noi, al di qua delle Alpi: «Che succede amico?». E non è un caso che sia proprio quella la frase la più famosa legata a un personaggio dei cartoon. Lo rivela un recente studio-sondaggio voluto dalla sede inglese del gruppo di distribuzione cinematografica Uci Cinemas per lanciare l'ultimo film della Warner Bros, Back in Action. A 500 cinefili inglesi appassionati di cartoni animati è stato chiesto quale detto, frase o parola amano e ricordano di più in relazione a un cartoon. Bene: su tutti ha prevalso quel «what's up doc?», seguito da «Doh!», espressione fra lo sgomento e lo stupito di un personaggio ben più giovane di Bugs, Homer Simpson il confuso ispettore nucleare della famiglia più strampalata dei cartoon.
                </p>  

            </div>

            <div class="userName">
                <img alt="Utente2" src="img/images.jpg">
                <h2><b>Deadpool</b></h2>                    
            </div>
            <div class="contenuto">
                <p>
                    - Che c'è, non hai mai sentito parlare di Google? Dovresti cercarlo su Google.<br/>
                    - A volte, non sempre ovviamente, ma a volte, io... vedo come delle cose. Ho delle visioni. Immagini distorte della realtà. [...] Oh, non è una cosa fissa. Ma il piccolo uomo pallido dietro la tenda, cioè il mio editor-- dice non più di due per episodio.<br/>
                    - Ehi, tamarro. Senti, io sono uno dei buoni--- be', almeno in questo numero...<br/>
                    -Fare l'eroe è la professione più breve del mondo. Fa tutto ridere, finchè capita a qualcun altro.<br/>
                    - Sono stato creato specificamente dagli umani... per uccidere gli umani. Il che la dice lunga sulla razza umana in generale, non credete?!<br/>
                    - Una volta uno mi ha detto che alla fine di tutto rimpiangiamo non quello che abbiamo fatto, ma quello che non abbiamo fatto.<br/>
                </p>    
                <img alt="Utente2" src="img/pool.jpg">                        
            </div>


            <div class="userName">                  
                <img alt="Utente3" src="img/images1.jpg">   
                <h2><b>Jerry</b></h2>
            </div>
            <div class="contenuto">
                <p>
                    La Ofcom ha spiegato che Tom & Jerry è un cartone animato vintage realizzato 
                    in un periodo in cui il rischio legato al fumo non era ancora stato attentamente 
                    studiato e che questa era un'ottima ragione per chiedere alla Turner di prendere 
                    provvedimenti. Tom & Jerry però sono stati censurati altre volte. Molte scene di 
                    altri episodi contenevano dei blackface, cioè quando esplodeva qualcosa o il viso 
                    di Tom, Jerry o altri personaggi si coprivano di fango, essi diventavano come delle 
                    persone africane e ciò poteva risultare offensivo per le persone di origine africana.
                    Un altro episodio censurato è Il suo topo Venerdì (His Mouse Friday, 1951) a causa 
                    degli stereotipi razziali in esso contenuti.
                </p>  
                <a href="https://i.makeagif.com/media/6-06-2015/nc_GSl.gif">https://i.makeagif.com/media/6-06-2015/nc_GSl.gif</a>   
            </div>
        </div>
    </body>
</html>
