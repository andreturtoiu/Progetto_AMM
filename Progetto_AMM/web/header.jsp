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
        <nav>
            <ol>
                <li><a href="descrizione.jsp" id="nerdbook_style">NerdBook</a></li>
                <li><a href="Bacheca">Bacheca</a></li> 
                <li><a href="Profilo">Profilo</a></li>
                <li><a class="inOut" href="Login?logout=true">Logout</a></li>
            </ol>
        </nav>  
    </c:if>


    <c:if test="${pagina == 'login'}">
        <a href="descrizione.jsp" id="nerdbook_style">NerdBook</a>
    </c:if>       

    <c:if test="${pagina == 'descrizione'}">
        <nav>
           <ol>
               <li><a href="descrizione.jsp" id="nerdbook_style">NerdBook</a></li>
               <li><a class="inOut" href="Login">Login</a></li>
           </ol>
        </nav>
    </c:if> 
        
</header>
