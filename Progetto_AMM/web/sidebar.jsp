<%-- 
    Document   : sidebar
    Created on : 29-apr-2017, 16.37.11
    Author     : Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div id="sideBar">
            <div id="user">                
                <h3>Amici</h3>
                <ul>
                    <c:forEach var="user" items="${amici}">
                        <li>
                            <img alt ="Foto" src="${user.urlFotoProfilo}"/> 
                            <a href="Bacheca?user=${user.id}">${user.nome} ${user.cognome}</a> 
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
                            <a href="Bacheca?group=${group.id}">${group.nome}</a>                            
                        </li>                                 
                    </c:forEach>  
                </ul>

            </div>       
</div>
