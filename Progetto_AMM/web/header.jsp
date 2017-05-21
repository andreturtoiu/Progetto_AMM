<%-- 
    Document   : header
    Created on : 29-apr-2017, 16.14.21
    Author     : Andreea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<header>
    <!-- profilo e bacheca-->
    
    <c:if test ="${pagina =='bacheca' || pagina == 'profilo'}">
        <div>
            <nav>
                <ol>
                    <li><a href="descrizione.jsp" id="nerdbook_style">NerdBook</a></li>
                    <li><a href="Bacheca">Bacheca</a></li> 
                    <li><a href="Profilo">Profilo</a></li>
                </ol>
            </nav>
        </div>  
        <div class="inOut">
            <img alt ="Foto" src="${utenteLoggato.urlFotoProfilo}"/>
            <a href="Login?logout=true">Logout</a>
        </div>
        
    </c:if>


    <c:if test="${pagina == 'login'}">
        <a href="descrizione.jsp" id="nerdbook_style">NerdBook</a>
    </c:if>       

    <c:if test="${pagina == 'descrizione'}">
        <div>
            <nav>
                <ol>
                    <li><a href="descrizione.jsp" id="nerdbook_style">NerdBook</a></li>
                </ol>
             </nav>
        </div>
         <div class="inOut">
            <a href="Login">Login</a>
        </div>
    </c:if> 
        
</header>
