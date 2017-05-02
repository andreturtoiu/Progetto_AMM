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
        
        <c:set var="pagina" value="bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidebar.jsp"/>
        
        <div id ="nuovoPost1">
            <form action="NewPost.jsp">
                <input type="hidden" name="userB" value="${user.nome}"/>
                <div id="nuovoPost">
                    <div id="postContent">
                        <div>
                            <label for="textPost">Nuovo post</label>
                            <textarea name="textPost" id="textPost" value ="${newPost}" ></textarea>
                        </div>
                        <div>
                            <label for="link">Allegato</label>
                            <input type="url" name="urlAllegato" id="link" value ="${newUrl}"/>
                                  
                        </div>
                    </div>
                    <div id="postType">
                        <div>
                            <label for="immaginePost">Immagine</label>
                            <input type="radio" name="postType" value="immaginePost" id="immaginePost">
                        </div>
                        <div>
                            <label for="LinkType">Link</label>
                            <input type="radio" name="postType" value="LinkType" id="LinkType">
                        </div>
                    </div>

                    <button type="submit">Invia</button>
                </div>            
            </form>
        </div>
             
        <c:if test="${user.fraseDescrizione != null}">
            <div id="fraseDescrizione">
                <p> ${user.nome} ${user.cognome } :</p>
                <p>${user.fraseDescrizione}</p>
            </div>
        </c:if>  
       

        <div id="bacheca">
            <c:forEach var="post" items="${posts}">
                <div class="post">
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
