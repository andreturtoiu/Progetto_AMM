<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/javascript.js"></script>   

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
        
        <c:set var="pagina" value="bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidebar.jsp"/>
        
        <div id ="nuovoPost1">
            <form action="NewPost.jsp">
                <c:choose>
                    <c:when test="${tipoBacheca == 'bachecaUtente'}">
                        <input type="hidden" name="dest" value="${user.id}"/>                        
                    </c:when>

                    <c:when test="${tipoBacheca == 'bachecaGruppo'}">
                        <input type="hidden" name="dest" value="${gruppo.id}"/>                        
                    </c:when>
                </c:choose>
                <input type="hidden" name="nomeDest" value="${nomeDest}"/>
                <div id="nuovoPost">
                    <div id="postContent">
                        <div>
                            <label for="textPost">Nuovo post</label>
                            <textarea name="textPost" id="textPost" value ="textPost" ></textarea>
                        </div>
                        <div>
                            <label for="link">Allegato</label>
                            <input type="url" name="urlAllegato" id="link"/>
                                  
                        </div>
                    </div>
                    <div id="postType">
                        <div>
                          <label for="immaginePost">Immagine</label>  
                          <label for="LinkType">Link</label>  
                        </div>
                        
                        <div>
                            <input type="radio" name="postType" value="immaginePost" id="immaginePost">  
                            <input type="radio" name="postType" value="LinkType" id="LinkType">
                        </div>

                        

                    </div>

                            <button type="submit" name ="thereIsPost" value="needConfirm">Invia</button>
                </div>            
            </form>
        </div>
        
        <c:if test="${tipoBacheca == 'bachecaUtente'}">
            <div id="fraseDescrizione">
                <img alt ="Foto" src="${user.urlFotoProfilo}"/> 
                <p> ${user.nome} ${user.cognome } </p>
                <p>Data di nascita: ${user.dataNascita } </p>
                <p>E-mail: ${user.email }</p>
                <c:if test="${user.fraseDescrizione != null}">
                        <p>Frase descrizione: ${user.fraseDescrizione}</p>  
                </c:if>  
            </div>         
        </c:if>
        
       

        <div id="bacheca">
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <div class="autore">                      
                        <img alt ="Foto" src="${post.user.urlFotoProfilo}"/> 
                        <p>${post.user.nome} ${post.user.cognome}</p> 
                    </div>
                    
                        <c:choose>
                            <c:when test="${post.postType == 'TEXT'}">
                                <p>${post.content}</p>
                            </c:when>
                            <c:when test="${post.postType == 'IMAGE'}">
                                <p>${post.content}</p>
                                <img alt="Foto" src="${post.allegato}">                     
                            </c:when>
                            <c:when test="${post.postType == 'LINK'}">
                                <p>${post.content}</p>
                                <a href="${post.allegato}">${post.allegato}</a> 
                            </c:when>
                        </c:choose>  

                </div> 
            </c:forEach>
      </div>
    </body>
</html>
